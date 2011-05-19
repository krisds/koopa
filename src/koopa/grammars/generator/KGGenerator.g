tree grammar KGGenerator;

options {
  tokenVocab = KG;
  language = Java;
  output = template;
  ASTLabelType=CommonTree;
}

@header {
  package koopa.grammars.generator;
  
  import java.util.List;
  import java.util.LinkedList;
  import java.util.Date;
  import java.util.Set;
  import java.util.HashSet;

  import koopa.util.Tuple;
}

@members {
}

koopa [String name, String pack, String pack, String imports, String supportCode]
  : ^(GRAMMAR
      (r+=rule)*
    )
    
    -> koopa(
      name = {name},
      date = {new Date()},
      package = {pack},
      imports = {imports},
      rule = {$r},
      support_code = {supportCode}
    )
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
  
    { boolean isLowerCase = Character.isLowerCase(((CommonTree) i).getText().charAt(0)); }
  
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
  ;
