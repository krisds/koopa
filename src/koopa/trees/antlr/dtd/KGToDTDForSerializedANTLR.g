tree grammar KGToDTDForSerializedANTLR;

options {
  tokenVocab = KG;
  language = Java;
  output = template;
  ASTLabelType=CommonTree;
}

@header {
  package koopa.trees.antlr.dtd;
  
  import koopa.trees.antlr.ANTLRNaming;
  import koopa.trees.antlr.TokenTypes;
  
  import java.util.Set;
  import java.util.HashSet;
  import java.util.Map;
  import java.util.HashMap;
  import java.util.List;
  import java.util.LinkedList;
}

@members {
  private Set<String> tokens = new HashSet<String>();
  private TokenTypes numbers = new TokenTypes();
  private int count = 13;

  public void node(String text) {
    if (!tokens.contains(text)) {
      // System.out.println("node " + text + "=" + count);
      tokens.add(text);
      numbers.put(ANTLRNaming.forNode(text), count++, false);
    }
  }

  public void token(String text) {
    if (!tokens.contains(text)) {
      // System.out.println("token " + text + "=" + count);
      tokens.add(text);
      numbers.put(ANTLRNaming.forLiteral(text), count++, true);
    }
  }
  
  public TokenTypes getTokenTypes() {
    if (!numbers.contains("TOKEN")) {
      numbers.put("TOKEN", 11, false);
    }
    
    if (!numbers.contains("WATER")) {
      numbers.put("WATER", 12, false);
    }
    
    return numbers;
  }
}

koopa
  : ^(GRAMMAR
      (r+=rule)*
    )
  
    -> treegrammar(
      rule={$r}
    )
  ;

rule
  : ^(RULE n=IDENTIFIER 
      locals?
      returning?
      b=body
    )
    
    -> {$body.len > 1}? rule(
      name={$n},
      body={b}
    )
    
    -> {$body.len == 1}? rule1(
      name={$n},
      body={b}
    )
    
    -> rule(
      name={$n}
    )
  ;

returning
  : ^(RETURNS IDENTIFIER)
  ;
  
locals
  : ^(LOCALS
      declaration+
    )
  ;

declaration
  : ^(DECLARATION IDENTIFIER IDENTIFIER)
  ;

body returns [ int len, boolean optional ]
  @init {
    $body.len = 0;
    $body.optional = false;
  }
  : { List<StringTemplate> steps = new LinkedList<StringTemplate>(); }
  
    ^(SEQUENCE 
      (x=inner_body
        { if ($x.len > 0) {
            steps.add($x.st);
            $body.len += $x.len;
          }
        }
      )+
    )
    
    -> {$body.len == 1}? {steps.get(0)}
    -> {$body.len > 1}? sequence(
         step={steps}
       )
    -> {%{"::seq::"}}
  
  | ^(ACT NATIVE_CODE)
  
    { $body.len = 0; }

    -> {%{"::act::"}}
    
  | i=IDENTIFIER
  
    { $body.len = 1; }
    
    { String text = ((CommonTree) $i).getText();
      boolean isLiteral = Character.isUpperCase(text.charAt(0));
    }
    
    -> {isLiteral}? literal()
    -> {%{text}}
    
  | l=LITERAL

    { $body.len = 1; }
    
    { String text = ((CommonTree) $l).getText();
      text = text.substring(1, text.length() - 1);
    }

    -> literal()
    
  | n=NUMBER
  
    { $body.len = 1; }
    
    { String text = ((CommonTree) $n).getText(); }

    -> literal()
    
  | DOT
  
    { $body.len = 1; }
    
    -> literal()
    
  | ^(ASSIGN IDENTIFIER (i=IDENTIFIER | n=NUMBER | d=DOT))
  
    { $body.len = 1; }
    
    { String text = null;
      boolean isLiteral = false;
      if ($i != null) {
        text = ((CommonTree) $i).getText();
        isLiteral = Character.isUpperCase(text.charAt(0));
        
      } else if ($n != null) {
        text = ((CommonTree) $n).getText();
      }
    }
    
    -> {i != null && isLiteral}? literal()
    -> {i != null}? {%{text}}
    -> literal()
    
  | ^(STAR b=inner_body)
  
    { $body.len = 1;
      $body.optional = true;
    }
  
    -> star(
         body={b}
       )
    
  | ^(PLUS b=inner_body)
  
    { $body.len = 1; }
  
    -> plus(
         body={b}
       )
    
  | { List<StringTemplate> steps = new LinkedList<StringTemplate>(); }
    ^(CHOICE
      { $body.optional = true; }
      (x=inner_body
        { if ($x.len > 0) {
            steps.add(x.st);
            $body.len += $x.len;
            $body.optional = $body.optional && $x.optional;
          }
        }
      )+
    )
    
    -> {$body.len > 0}? choice(
         step={steps}
       )
    -> {%{"::choice::"}}
    
  | ^(OPTIONAL
      b=inner_body
    )
  
    { $body.len = $b.len;
      $body.optional = true;
    }
  
    -> {$body.len > 0 && !$b.optional}? opt(
         body={b}
       )
    -> {$body.len > 0 && $b.optional}? {$b.st}
    -> {%{"::optional::"}}
       
    
  | ^(SKIP_TO
      body
    )
  
    { $body.len = 1;
      $body.optional = true;
    }
  
    -> water()
    
  | ^(NOT body)

    { $body.len = 0;
      $body.optional = true;
    }

    -> {%{""}}

  | { List<StringTemplate> steps = new LinkedList<StringTemplate>(); }
    ^(PERMUTED 
      (x=inner_body
        { if ($x.len > 0) {
            steps.add(x.st);
            $body.len += $x.len;
          }
        }
      )+
    )

    { StringTemplate y = %choice(
        step={steps}
      );
      
      $body.optional = true;
    }
    
    -> {$body.len > 0}? star(
         body={y}
       )
    -> {%{"::permuted::"}}
  ;

inner_body returns [ int len, boolean optional ]
  : body
    { $inner_body.len = $body.len;
      $inner_body.optional = $body.optional;
    }
    -> {$body.st}
  ;