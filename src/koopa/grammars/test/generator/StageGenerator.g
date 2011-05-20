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
  
  import koopa.tokenizers.cobol.TestTokenizer;
}

@members {
  private int count = 0;
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
      data = data.substring(1, data.length() - 1).trim();
      data = data.replaceAll("\u2022", " " + TestTokenizer.MARKER_TEXT + " ");
      data = data.replaceAll("\n", "\\\\n");
      data = data.replaceAll("\"", "\\\\\"");
    }
    
    -> {accept}? accept(
      name = {name},
      number = {++count},
      target = {target},
      token = {data}
    )
    
    -> reject(
      name = {name},
      number = {++count},
      target = {target},
      token = {data}
    )
  ;
