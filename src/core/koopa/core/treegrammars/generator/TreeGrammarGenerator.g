tree grammar TreeGrammarGenerator;

options {
  tokenVocab = KG;
  language = Java;
  output = template;
  ASTLabelType=CommonTree;
}

@header {
  package koopa.core.treegrammars.generator;
  
  import java.util.Collections;
  import java.util.Date;
  import java.util.List;
  import java.util.LinkedList;
  import java.util.Set;
  import java.util.HashSet;
  import java.util.Properties;

  import koopa.core.util.Tuple;
}

@members {
}

koopa [Properties p, String imports]
  : ^(GRAMMAR
      meta[p]
      (r+=rule)*
    )
  
    -> treegrammar(
      name = {p.getProperty("named")},
      extending = {p.getProperty("extending")},
      date = {new Date()},
      package = {p.getProperty("package")},
      imports={imports},
      rule={$r}
    )
  ;


meta [ Properties meta ]
  : ^(META TREE n=named (e=extending)?)
    
    { meta.setProperty("named", $n.name);
    
      if (e != null) meta.setProperty("extending", $e.name);
      else meta.setProperty("extending", "Tree");
    }
  ;

named returns [String name = null]
  : ^(NAMED (i=IDENTIFIER | i=TOKEN))
  
    { $named.name = ((CommonTree) $i).getText(); }
  ;

extending returns [String name = null]
  : ^(EXTENDING (i=IDENTIFIER | i=TOKEN))
  
    { $extending.name = ((CommonTree) $i).getText(); }
  ;


rule
  : { List<String> bindings = null;
      List<String> unbindings = null;
      StringTemplate bod = null;
    }
    ^(RULE 
      (PUBLIC | PRIVATE)
      n=IDENTIFIER
      
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
          steps.add($b.st);
          steps.add($r.st);
          bod = %sequence(
            step={steps}
          );
          
        } else {
          bod = $b.st;
        }
      }
    )
    
    -> rule(
      name={$n},
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
  : ^(DECLARATION (a=IDENTIFIER|a=TOKEN) (b=IDENTIFIER|b=TOKEN))
    { $declaration.tuple = new Tuple<String, String>(((CommonTree) $a).getText(), ((CommonTree) $b).getText()); }
  ;

body [ List<String> bindings, List<String> unbindings ]
  : { List<StringTemplate> steps = new LinkedList<StringTemplate>(); }
    ^(SEQUENCE 
      (b=body[bindings, unbindings]
        { steps.add($b.st); }
      )+
    )
    
    -> sequence(
      step = {steps}
    )
  
  | ^(ACT n=NATIVE_CODE)
  
    -> apply(
      bind = {bindings},
      unbind = {unbindings},
      native_code = {n}
    )
    
  | ANY

    -> any()

  | TAG

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
  
  | l=LITERAL

  | n=NUMBER
  
  | d=DOT
    
    -> token(
      text = {d}
    )
    
  | ^(ASSIGN l=IDENTIFIER (i=IDENTIFIER | n=NUMBER | d=DOT | a=ANY))
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
      
      } else if (d != null) {
        body = %token(
          text={"."}
        );
      
      } else {
        body = %any();
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
        { steps.add($b.st); }
      )+
    )
    
    -> choice(
      step = {steps}
    )
  
  | ^(OPTIONAL
      b=body[bindings, unbindings]
    )
    
    -> opt(
      body = {b}
    )
    
  | ^(SKIP_TO
      body[bindings, unbindings]
    )
  
  | ^(NOT body[bindings, unbindings])

  | ^(NOSKIP 
      (body[bindings, unbindings]
      )+
    )
    
  | ^(PERMUTED 
      (body[bindings, unbindings]
      )+
    )
    
  | ^(LIMIT b_t=body[bindings, unbindings] b_l=body[bindings, unbindings])
  
    -> limit(
      target = {b_t},
      limiter = {b_l}
    )

  | ^(AS IDENTIFIER b=body[bindings, unbindings])
  ;
