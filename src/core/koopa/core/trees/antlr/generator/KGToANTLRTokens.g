tree grammar KGToANTLRTokens;

options {
  tokenVocab = KG;
  language = Java;
  output = none;
  ASTLabelType=CommonTree;
}

@header {
  package koopa.core.trees.antlr.generator;
  
  import koopa.core.trees.antlr.ANTLRNaming;
  import koopa.core.trees.antlr.ANTLRTokensLoader;
  import koopa.core.trees.antlr.ANTLRTokens;
  
  import java.util.Set;
  import java.util.HashSet;
  import java.util.Map;
  import java.util.HashMap;
  
  import java.io.File;
  import java.io.IOException;
}

@members {
  private ANTLRTokens numbers = new ANTLRTokens();
  private int count = 14;
  private File path = null;

  public void node(String text) {
    text = ANTLRNaming.forNode(text);
    if (!numbers.contains(text))
      numbers.put(text, count++, false);
  }

  public void token(String text) {
    text = ANTLRNaming.forLiteral(text);
    if (!numbers.contains(text))
      numbers.put(text, count++, true);
  }
  
  public ANTLRTokens getTokenTypes() {
    if (!numbers.contains("TOKEN"))
      numbers.put("TOKEN", 11, false);
    
    if (!numbers.contains("WATER"))
      numbers.put("WATER", 12, false);
    
    if (!numbers.contains("COMMENT"))
      numbers.put("COMMENT", 13, false);
    
    return numbers;
  }
  
  public void setPath(File path) {
  	this.path = path;
  }
  
  private void loadTokensForBaseGrammar(String name) {
    try {
      File tokensFile = new File(path, name + ".tokens");
      if (!tokensFile.exists()) {
        System.out.println("Found no tokens for base grammar!");
        return;
      }
      
	  System.out.println("Loading tokens for base grammar: " + name);
      ANTLRTokensLoader.loadFile(new File(path, name + ".tokens"), numbers);
	  count = numbers.getMaxValue() + 1;
	  
	} catch (IOException e) {
	  e.printStackTrace();
	}
  }
}

koopa
  : ^(GRAMMAR meta rule*)
  ;

meta
  : ^(META named extending?)
  ;

named
  : ^(NAMED IDENTIFIER)
  ;

extending
  : ^(EXTENDING i=IDENTIFIER)
  
    { loadTokensForBaseGrammar( ((CommonTree) $i).getText() ); }
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
    
  | TAG

  | ANY

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
  
  | ^(ASSIGN IDENTIFIER (i=IDENTIFIER | n=NUMBER | d=DOT | a=ANY))
    { if (i != null) {
        String text = ((CommonTree) $i).getText();
        if (Character.isUpperCase(text.charAt(0))) {
          token(text);
        }
      
      } else if (n != null) {
        token(((CommonTree) $n).getText());

      } else if (d != null) {
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
  
  | ^(NOSKIP body)
  ;
