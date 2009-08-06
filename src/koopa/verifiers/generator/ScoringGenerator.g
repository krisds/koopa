tree grammar ScoringGenerator;

options {
  tokenVocab = Scoring;
  language = Java;
  output = template;
  ASTLabelType=CommonTree;
}

@header{
  package koopa.verifiers.generator;
  
  import java.util.List;
  import java.util.LinkedList;
}

@members{
  private String buildTest(List<Boolean> present) {
    StringBuilder builder = new StringBuilder();
    
    int yes = -1;
    for(int i = 0; i < present.size(); i++) {
      if (i > 0) {
        builder.append(" && ");
      }

      if (present.get(i)) {
        builder.append("p" + (yes+1) + " < p" + (i+1));
        yes = i;

      } else {
        int j = i;
        while (j < present.size() && !present.get(j)) {
          j++;
        }
        
        if (j < present.size()) {
          builder.append("(p" + (i+1) + " < p" + (yes+1) + " || p" + (i+1) + " > p" + (j+1) + ")");
        } else {
          builder.append("p" + (i+1) + " < p" + (yes+1));
        }
      }
    }
    
    return builder.toString();
  }
}

scoring [String name, String pack]
  : ^(SCORING v+=verification*)
  
  -> scoring(
    name = {name},
    pack = {pack},
    verification = {$v}
  )
  ;

verification
  : ^(VERIFICATION IDENTIFIER a+=assertion*)
  
  -> verification (
    target = {$IDENTIFIER},
    assertion = {$a}
  )
  ;

assertion
  : ^(ACCEPT sequence response)
  
  -> accept(
    items = {$sequence.steps},
    test = {buildTest($sequence.presentOrNot)},
    response = {$response.st}
  )

  | ^(REJECT sequence response)
  
  -> reject(
    items = {$sequence.steps},
    test = {buildTest($sequence.presentOrNot)},
    response = {$response.st}
  )
  ;

sequence returns [ List<String> steps, List<Boolean> presentOrNot ]
  : ^(SEQUENCE
       { $sequence.steps = new LinkedList<String>();
         $sequence.presentOrNot = new LinkedList<Boolean>();
       }
  
       ( i0=IDENTIFIER
         { $sequence.steps.add(((Tree) $i0).getText());
           $sequence.presentOrNot.add(true);
         }

       | ^(BANG i1=IDENTIFIER
           { $sequence.steps.add(((Tree) $i1).getText());
             $sequence.presentOrNot.add(false);
           }
         )
       )+
    )
  ;

response
  : ^(WARN STRING_LITERAL)
  
  -> warn(
    msg = {$STRING_LITERAL}
  )

  | ^(ERROR STRING_LITERAL)

  -> error(
    msg = {$STRING_LITERAL}
  )
  ;
