tree grammar KGToANTLRTokens;

options {
  tokenVocab = KG;
  language = Java;
  output = none;
  ASTLabelType=CommonTree;
}

@header {
  package koopa.trees.antlr.generator;
  
  import koopa.trees.antlr.ANTLRNaming;
  import koopa.trees.antlr.TokenTypes;
  
  import java.util.Set;
  import java.util.HashSet;
  import java.util.Map;
  import java.util.HashMap;
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
  : ^(GRAMMAR rule*)
  ;

rule
  : ^(RULE i=IDENTIFIER  { node(((CommonTree) $i).getText()); } 
      locals?
      returning?
      body
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

body
  : ^(SEQUENCE 
      body+
    )
  
  | ^(ACT NATIVE_CODE)
    
  | i=IDENTIFIER
    { String text = ((CommonTree) $i).getText();
      if (Character.isUpperCase(text.charAt(0))) {
        token(text);
      }
    }
  
  | l=LITERAL
    { String text = ((CommonTree) $l).getText();
      text = text.substring(1, text.length() - 1);
      token(text);
    }
  
  | n=NUMBER
    { token(((CommonTree) $n).getText()); }
  
  | DOT
    { token("."); }
  
  | ^(ASSIGN IDENTIFIER (i=IDENTIFIER | n=NUMBER | d=DOT))
    { if (i != null) {
        String text = ((CommonTree) $i).getText();
        if (Character.isUpperCase(text.charAt(0))) {
          token(text);
        }
      
      } else if (n != null) {
        token(((CommonTree) $n).getText());

      } else {
        token(".");
      }
    }
  
  | ^(STAR body)
  
  | ^(PLUS body)
  
  | ^(CHOICE
      body+
    )
    
  | ^(OPTIONAL
      body
    )
  
  | ^(SKIP_TO
      body
    )
  
  | ^(PERMUTED 
      body+
    )
  
  | ^(NOT body)
  ;
