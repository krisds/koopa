tree grammar KGGenerator;

options {
  tokenVocab = KG;
  language = Java;
  output = template;
  ASTLabelType=CommonTree;
}

@header {
  package koopa.core.grammars.generator;
  
  import java.util.List;
  import java.util.LinkedList;
  import java.util.Date;
  import java.util.Set;
  import java.util.HashSet;
  import java.util.Properties;

  import koopa.core.util.Tuple;
}

@members {
}

koopa [Properties p, String imports, String supportCode]
  : ^(GRAMMAR
      meta[p]
      (r+=rule)*
    )
    
    -> koopa(
      name = {p.getProperty("named")},
      extending = {p.getProperty("extending")},
      date = {new Date()},
      package = {p.getProperty("package")},
      imports = {imports},
      rule = {$r},
      support_code = {supportCode}
    )
  ;

meta [ Properties meta ]
  : ^(META n=named (e=extending)?)
    
    { meta.setProperty("named", $n.name);
    
      if (e != null) meta.setProperty("extending", $e.name);
      else meta.setProperty("extending", "Koopa");
    }
  ;

named returns [String name = null]
  : ^(NAMED i=IDENTIFIER)
  
    { $named.name = ((CommonTree) $i).getText(); }
  ;

extending returns [String name = null]
  : ^(EXTENDING i=IDENTIFIER)
  
    { $extending.name = ((CommonTree) $i).getText(); }
  ;

rule
  : { List<String> bindings = null;
      List<String> unbindings = null;
      StringTemplate bod = null;
    }
    ^(RULE n=IDENTIFIER 
      (l=locals
        { bindings = new LinkedList<String>();
          unbindings = new LinkedList<String>();
          
          for(Tuple<String, String> tuple : $l.tuples) {
            String type = tuple.getFirst();
            String name = tuple.getSecond();

            bindings.add(%bind(
              name={name},
              type={type}
            ).toString());
            
            unbindings.add(%unbind(
              name={name}
            ).toString());
          }
        }
      )?

      (r=returning)?

      b=body[bindings, unbindings]
      { if (r != null) {
          List<StringTemplate> steps = new LinkedList<StringTemplate>();
          steps.add(b.st);
          steps.add(r.st);
          bod = %sequence(
            step={steps}
          );
          
        } else {
          bod = b.st;
        }
      }
    )
    
    -> rule(
         name = {n},
         body = {bod}
       )
  ;

returning
  : ^(RETURNS i=IDENTIFIER)
  
    -> returning(
      name={((CommonTree) $i).getText()}
    )
  ;
  
locals returns [List<Tuple<String, String>> tuples = new LinkedList<Tuple<String, String>>()]
  : ^(LOCALS
      (d=declaration
        { $locals.tuples.add($d.tuple); }
      )+
    )
  ;

declaration returns [Tuple<String, String> tuple = null]
  : ^(DECLARATION a=IDENTIFIER b=IDENTIFIER)
    { $declaration.tuple = new Tuple<String, String>(((CommonTree) $a).getText(), ((CommonTree) $b).getText()); }
  ;

body [ List<String> bindings, List<String> unbindings ]
  : { List<StringTemplate> steps = new LinkedList<StringTemplate>(); }
    ^(SEQUENCE
      (b=body[bindings, unbindings]
        { steps.add(b.st); }
      )+
    )
    
    -> sequence(
      step = {steps}
    )
  
  | ^(ACT n=NATIVE_CODE)
  
    -> apply(
      bind = {bindings},
      native_code = {n},
      unbind = {unbindings}
    )
    
  | t=TAG

	{ String name = ((CommonTree) $t).getText();
      name = name.substring(1, name.length()); 
	}

    -> tag(
      text = {name}
    )

  | ANY

    -> any()
  
  | l=LITERAL
  
    { String unquoted = ((CommonTree) $l).getText();
      unquoted = unquoted.substring(1, unquoted.length() - 1); 
    }
  
    -> token(
      text = {unquoted}
    )
  
  | n=NUMBER

    -> token(
      text = {n}
    )
  
  | i=IDENTIFIER
  
    { String text = ((CommonTree) i).getText();
 	  boolean isLowerCase = Character.isLowerCase(text.charAt(0));
    }

    -> {isLowerCase}? call(
      name = {i}
    )
    
    -> token(
      text = {i}
    )
  
  | d=DOT
  
    -> token(
      text = {d}
    )
  
  | ^(ASSIGN l=IDENTIFIER (i=IDENTIFIER | n=NUMBER | d=DOT))
    { StringTemplate body = null;
      if (i != null) {
        String text = ((CommonTree) i).getText();
        if (Character.isLowerCase(text.charAt(0))) {
          body = %call(
            name={i}
          );
        } else {
          body = %token(
            text={i}
          );
        }
      
      } else if (n != null) {
        body = %token(
          text={n}
        );
      
      } else {
        body = %token(
          text={"."}
        );
      }
    }
  
    -> assign(
      name = {l},
      value = {body}
    )
  
  | ^(STAR b=body[bindings, unbindings])
  
    -> star(
      body = {b}
    )
  
  | ^(PLUS b=body[bindings, unbindings])
  
    -> plus(
      body = {b}
    )
  
  | { List<StringTemplate> steps = new LinkedList<StringTemplate>(); }
    ^(CHOICE
      (b=body[bindings, unbindings]
        { steps.add(b.st); }
      )+
    )
    
    -> choice(
      step = {steps}
    )
  
  | ^(OPTIONAL b=body[bindings, unbindings])
  
    -> optional(
      body = {b}
    )
  
  | ^(SKIP_TO b=body[bindings, unbindings])

    -> skipto(
      body = {b}
    )
  
  | { List<StringTemplate> choices = new LinkedList<StringTemplate>(); }
    ^(PERMUTED
      (b=body[bindings, unbindings]
        { choices.add(b.st); }
      )+
    )

    -> permuted(
      choice = {choices}
    )

  | ^(NOT b=body[bindings, unbindings])
  
    -> not(
      body = {b}
    )

  | ^(NOSKIP b=body[bindings, unbindings])
  
	{ String option = "NOSKIP"; }
    -> opt(
      option = {option},
      body = {b}
    )
  
  | ^(LIMIT b_t=body[bindings, unbindings] b_l=body[bindings, unbindings])
  
    -> limit(
      target = {b_t},
      limiter = {b_l}
    )
  ;
