tree grammar KGToANTLRTreeGrammar;

options {
  tokenVocab = KG;
  language = Java;
  output = template;
  ASTLabelType=CommonTree;
}

@header {
  package koopa.trees.antlr.generator;
  
  import java.util.Collections;
  import java.util.Date;
  import java.util.List;
  import java.util.LinkedList;
  import java.util.Set;
  import java.util.HashSet;

  import koopa.trees.antlr.ANTLRNaming;
}

@members {
  private Set<String> literals = new HashSet<String>();
  
  private void literal(String literal) {
    literals.add(literal);
  }
  
  private List<String> antlrifiedLiterals() {
    List<String> list = new LinkedList<String>();

    for (String lit : literals) {
      list.add(ANTLRNaming.forLiteral(lit));
    }
    
    Collections.sort(list);
    
    return list;
  }
}

koopa [String name, String pack, String usercode]
  : ^(GRAMMAR
      (r+=rule)*
    )
  
    -> treegrammar(
      name={name},
      date={new Date()},
      pack={pack},
      rule={$r},
      literal={antlrifiedLiterals()},
      usercode={usercode}
    )
  ;

rule
  : ^(RULE n=IDENTIFIER 
      locals?
      returning?
      b=body
    )
    
    -> {$body.len > 0}? rule(
      name={$n},
      tag={ANTLRNaming.forNode($n.toString())},
      body={b}
    )
    
    -> rule(
      name={$n},
      tag={ANTLRNaming.forNode($n.toString())}
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
      if (isLiteral) {
        literal(text);
      }
    }
    
    -> {isLiteral}? {%{ANTLRNaming.forLiteral(text)}}
    -> {%{text}}
    
  | l=LITERAL

    { $body.len = 1; }
    
    { String text = ((CommonTree) $l).getText();
      text = text.substring(1, text.length() - 1);
      literal(text);
    }

    -> {%{ANTLRNaming.forLiteral(text)}}
    
  | n=NUMBER
  
    { $body.len = 1; }
    
    { String text = ((CommonTree) $n).getText();
      literal(text);
    }

    -> {%{ANTLRNaming.forLiteral(text)}}
    
  | DOT
  
    { $body.len = 1; }
    
    { literal("."); }
    
    -> {%{"'.'"}}
    
  | ^(ASSIGN IDENTIFIER (i=IDENTIFIER | n=NUMBER | d=DOT))
  
    { $body.len = 1; }
    
    { String text = null;
      boolean isLiteral = false;
      if ($i != null) {
        text = ((CommonTree) $i).getText();
        isLiteral = Character.isUpperCase(text.charAt(0));
        if (isLiteral) {
          literal(text);
        }
        
      } else if ($n != null) {
        text = ((CommonTree) $n).getText();
        literal(text);
        
      } else {
        literal(".");
      }
    }
    
    -> {i != null && isLiteral}? {%{ANTLRNaming.forLiteral(text)}}
    -> {i != null}? {%{text}}
    -> {%{ANTLRNaming.forLiteral(text)}}
    
  | ^(STAR b=inner_body)
  
    { $body.len = $b.len;
      $body.optional = true;
    }
  
    -> {$body.len > 0}? star(
         body={b}
       )
    -> {%{"::star::"}}
    
  | ^(PLUS b=inner_body)
  
    { $body.len = $b.len; }
  
    -> {$body.len > 0}? plus(
         body={b}
       )
    -> {%{"::plus::"}}
    
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