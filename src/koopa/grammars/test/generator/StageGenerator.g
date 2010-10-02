tree grammar StageGenerator;

options {
  tokenVocab = Stage;
  language = Java;
  output = template;
  ASTLabelType=CommonTree;
}

@header{
  package koopa.grammars.test.generator;
  
  import java.util.Date;
  import java.util.List;
  import java.util.LinkedList;
}

@members {
  private int count = 0;
  private int mark = -1;
  
  private List<String> tokenize(String data) {
    List<String> tokens = new LinkedList<String>();
    
    int position = 0;
    mark = -1;
    while (position < data.length()) {
      char c = data.charAt(position);

      if (c == '\u2022') {
        mark = tokens.size();
      
      } else if (c == '\"') {
        int start = position;
        do {
          position++;
        } while (position < data.length() && data.charAt(position) != '\"');
        
        tokens.add("\"\\\"" + data.substring(start + 1, position) + "\\\"\"");
        // start = position + 1;
      
      } else if (c == '=' && position + 1 < data.length() && data.charAt(position + 1) == '=') {
        int start = position;
        position += 2;
        while (position + 1 < data.length()
               && (data.charAt(position) != '=' || data.charAt(position + 1) != '=')) {
          position += 1;
        }

        position += 2;
        tokens.add("\"" + data.substring(start, position) + "\"");
        // start = position + 1;
      
      } else if (!Character.isWhitespace(c)) {
        int start = position;
        
        do {
          position++;
        } while (position < data.length() && !Character.isWhitespace(data.charAt(position)));

        tokens.add("\"" + data.substring(start, position) + "\"");
        // start = position + 1;
      } 
    
      position++;
    }

    if (mark == -1) {
      mark = tokens.size();
    }
    
    return tokens;
  }
}


stage [String name]
  : { List<StringTemplate> tests = new LinkedList<StringTemplate>(); }
  
    ^(STAGE p=pack g=grammah 
      (t=testsForGrammarRule
        {tests.addAll($t.tests);}
      )*
    )
  
    -> stage(
      name = {name},
      date = {new Date()},
      package = {p},
      grammah = {g},
      test = {tests}
    )
  ;
  
pack
  : ^(PACKAGE IDENTIFIER)
  
    -> {%{((CommonTree) $IDENTIFIER).getText()}}
  ;

grammah
  : ^(GRAMMAR IDENTIFIER)
  
    -> {%{((CommonTree) $IDENTIFIER).getText()}}
  ;

testsForGrammarRule returns [List<StringTemplate> tests = new LinkedList<StringTemplate>()]
  : ^(TARGET i=IDENTIFIER
       ( t=test[((CommonTree) $i).getText()]
         { $testsForGrammarRule.tests.add($t.st); }
       )*
    )
  ;
  
test [String target]
  : ^(TEST
      { boolean accept = true; }
      ( ACCEPT
      | REJECT { accept = false; }
      )
      CDATA
    )
    
    { String name = target.substring(1);
      name = Character.toUpperCase(target.charAt(0)) + name;
    }
    
    { String data = ((CommonTree) $CDATA).getText();
      data = data.substring(1, data.length() - 1);
      List<String> tokens = tokenize(data);
    }
    
    -> {accept}? accept(
      name = {name},
      number = {++count},
      target = {target},
      token = {tokens},
      processedCount = {mark}
    )
    
    -> reject(
      name = {name},
      number = {++count},
      target = {target},
      token = {tokens}
    )
  ;
