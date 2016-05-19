package koopa.cobol.grammar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import koopa.core.data.Token;
import koopa.core.data.markers.Start;
import koopa.core.parsers.combinators.Block;
import koopa.core.grammars.KoopaGrammar;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.FutureParser;
import koopa.core.parsers.Stream;

import static koopa.core.grammars.combinators.Opt.NOSKIP;
import static koopa.core.grammars.combinators.Scoped.Visibility.PUBLIC;
import static koopa.core.grammars.combinators.Scoped.Visibility.PRIVATE;
import static koopa.core.grammars.combinators.Scoped.Visibility.HIDING;

import static koopa.cobol.data.tags.SyntacticTag.UNSIGNED;
import koopa.cobol.data.tags.SyntacticTag;
import static koopa.cobol.data.tags.SyntacticTag.INTEGER_LITERAL;
import koopa.cobol.grammar.preprocessing.CobolPreprocessingGrammar;
import koopa.core.data.tags.AreaTag;

public class CobolGrammar extends CobolBaseGrammar {
    public CobolGrammar() {
    }
    
    // ========================================================
    // compilationGroup
    // ........................................................
    
    private ParserCombinator compilationGroupParser = null;
    
    public final Start compilationGroup = Start.on(getNamespace(), "compilationGroup");
    
    public ParserCombinator compilationGroup() {
      if (compilationGroupParser == null) {
        FutureParser future = scoped("compilationGroup", PUBLIC, true);
        compilationGroupParser = future;
        future.setParser(
          sequence(
            star(
              choice(
                compilerDirective(),
                sourceUnit()
              )
            ),
            optional(
              eof()
            )
          )
        );
      }
    
      return compilationGroupParser;
    }
    
    // ========================================================
    // copybook
    // ........................................................
    
    private ParserCombinator copybookParser = null;
    
    public final Start copybook = Start.on(getNamespace(), "copybook");
    
    public ParserCombinator copybook() {
      if (copybookParser == null) {
        FutureParser future = scoped("copybook", PUBLIC, false);
        copybookParser = future;
        future.setParser(
          sequence(
            choice(
              plus(
                sourceUnit()
              ),
              copybookHoldingData(),
              copybookHoldingBehaviour()
            ),
            optional(
              eof()
            )
          )
        );
      }
    
      return copybookParser;
    }
    
    // ========================================================
    // copybookHoldingData
    // ........................................................
    
    private ParserCombinator copybookHoldingDataParser = null;
    
    public final Start copybookHoldingData = Start.on(getNamespace(), "copybookHoldingData");
    
    public ParserCombinator copybookHoldingData() {
      if (copybookHoldingDataParser == null) {
        FutureParser future = scoped("copybookHoldingData", PUBLIC, true);
        copybookHoldingDataParser = future;
        future.setParser(
          plus(
            choice(
              constantEntry(),
              dataDescriptionEntry(),
              specialNameStatement(),
              sequence(
                fileDescriptionEntry(),
                star(
                  recordDescriptionEntry()
                )
              ),
              sequence(
                selectStatement(),
                optional(
                  literal(".")
                )
              ),
              copyStatement(),
              replaceStatement(),
              sequence(
                execStatement(),
                optional(
                  literal(".")
                )
              )
            )
          )
        );
      }
    
      return copybookHoldingDataParser;
    }
    
    // ========================================================
    // copybookHoldingBehaviour
    // ........................................................
    
    private ParserCombinator copybookHoldingBehaviourParser = null;
    
    public final Start copybookHoldingBehaviour = Start.on(getNamespace(), "copybookHoldingBehaviour");
    
    public ParserCombinator copybookHoldingBehaviour() {
      if (copybookHoldingBehaviourParser == null) {
        FutureParser future = scoped("copybookHoldingBehaviour", PUBLIC, true);
        copybookHoldingBehaviourParser = future;
        future.setParser(
          sequence(
            star(
              sentence()
            ),
            star(
              paragraph()
            ),
            star(
              section()
            ),
            star(
              statement()
            )
          )
        );
      }
    
      return copybookHoldingBehaviourParser;
    }
    
    // ========================================================
    // sourceUnit
    // ........................................................
    
    private ParserCombinator sourceUnitParser = null;
    
    public final Start sourceUnit = Start.on(getNamespace(), "sourceUnit");
    
    public ParserCombinator sourceUnit() {
      if (sourceUnitParser == null) {
        FutureParser future = scoped("sourceUnit", PUBLIC, false);
        sourceUnitParser = future;
        future.setParser(
          choice(
            programPrototype(),
            functionPrototype(),
            programDefinition(),
            functionDefinition(),
            classDefinition(),
            interfaceDefinition(),
            methodDefinition(),
            callPrototypeDefinition(),
            delegateDefinition(),
            enumDefinition(),
            iteratorDefinition(),
            enumDefinition(),
            operatorDefinition(),
            valueTypeDefinition()
          )
        );
      }
    
      return sourceUnitParser;
    }
    
    // ========================================================
    // programPrototype
    // ........................................................
    
    private ParserCombinator programPrototypeParser = null;
    
    public final Start programPrototype = Start.on(getNamespace(), "programPrototype");
    
    public ParserCombinator programPrototype() {
      if (programPrototypeParser == null) {
        FutureParser future = scoped("programPrototype", PUBLIC, true);
        programPrototypeParser = future;
        future.setParser(
          sequence(
            as("identificationDivision",
              sequence(
                optional(
                  sequence(
                    choice(
                      token("ID"),
                      token("IDENTIFICATION")
                    ),
                    token("DIVISION"),
                    literal(".")
                  )
                ),
                programPrototypeIdParagraph(),
                optional(
                  optionsParagraph()
                )
              )
            ),
            optional(
              environmentDivision()
            ),
            optional(
              dataDivision()
            ),
            optional(
              procedureDivision()
            ),
            token("END"),
            token("PROGRAM"),
            name(),
            literal(".")
          )
        );
      }
    
      return programPrototypeParser;
    }
    
    // ========================================================
    // programPrototypeIdParagraph
    // ........................................................
    
    private ParserCombinator programPrototypeIdParagraphParser = null;
    
    public final Start programPrototypeIdParagraph = Start.on(getNamespace(), "programPrototypeIdParagraph");
    
    public ParserCombinator programPrototypeIdParagraph() {
      if (programPrototypeIdParagraphParser == null) {
        FutureParser future = scoped("programPrototypeIdParagraph", PUBLIC, true);
        programPrototypeIdParagraphParser = future;
        future.setParser(
          sequence(
            token("PROGRAM-ID"),
            optional(
              literal(".")
            ),
            name(),
            optional(
              sequence(
                token("AS"),
                literal()
              )
            ),
            optional(
              token("IS")
            ),
            token("PROTOTYPE"),
            optional(
              literal(".")
            )
          )
        );
      }
    
      return programPrototypeIdParagraphParser;
    }
    
    // ========================================================
    // functionPrototype
    // ........................................................
    
    private ParserCombinator functionPrototypeParser = null;
    
    public final Start functionPrototype = Start.on(getNamespace(), "functionPrototype");
    
    public ParserCombinator functionPrototype() {
      if (functionPrototypeParser == null) {
        FutureParser future = scoped("functionPrototype", PUBLIC, true);
        functionPrototypeParser = future;
        future.setParser(
          sequence(
            as("identificationDivision",
              sequence(
                optional(
                  sequence(
                    choice(
                      token("ID"),
                      token("IDENTIFICATION")
                    ),
                    token("DIVISION"),
                    literal(".")
                  )
                ),
                functionPrototypeIdParagraph(),
                optional(
                  optionsParagraph()
                )
              )
            ),
            optional(
              environmentDivision()
            ),
            optional(
              dataDivision()
            ),
            optional(
              procedureDivision()
            ),
            token("END"),
            token("FUNCTION"),
            name(),
            literal(".")
          )
        );
      }
    
      return functionPrototypeParser;
    }
    
    // ========================================================
    // functionPrototypeIdParagraph
    // ........................................................
    
    private ParserCombinator functionPrototypeIdParagraphParser = null;
    
    public final Start functionPrototypeIdParagraph = Start.on(getNamespace(), "functionPrototypeIdParagraph");
    
    public ParserCombinator functionPrototypeIdParagraph() {
      if (functionPrototypeIdParagraphParser == null) {
        FutureParser future = scoped("functionPrototypeIdParagraph", PUBLIC, true);
        functionPrototypeIdParagraphParser = future;
        future.setParser(
          sequence(
            token("FUNCTION-ID"),
            optional(
              literal(".")
            ),
            name(),
            optional(
              sequence(
                token("AS"),
                literal()
              )
            ),
            optional(
              token("IS")
            ),
            token("PROTOTYPE"),
            optional(
              literal(".")
            )
          )
        );
      }
    
      return functionPrototypeIdParagraphParser;
    }
    
    // ========================================================
    // programDefinition
    // ........................................................
    
    private ParserCombinator programDefinitionParser = null;
    
    public final Start programDefinition = Start.on(getNamespace(), "programDefinition");
    
    public ParserCombinator programDefinition() {
      if (programDefinitionParser == null) {
        FutureParser future = scoped("programDefinition", PUBLIC, true);
        programDefinitionParser = future;
        future.setParser(
          sequence(
            as("identificationDivision",
              sequence(
                optional(
                  sequence(
                    choice(
                      token("ID"),
                      token("IDENTIFICATION")
                    ),
                    token("DIVISION"),
                    literal(".")
                  )
                ),
                programIdParagraph(),
                optional(
                  replaceStatement()
                ),
                optional(
                  optionsParagraph()
                ),
                optional(
                  metadata()
                )
              )
            ),
            optional(
              environmentDivision()
            ),
            optional(
              dataDivision()
            ),
            optional(
              sequence(
                procedureDivision(),
                star(
                  as("sourceUnit",
                    programDefinition()
                  )
                )
              )
            ),
            optional(
              sequence(
                token("END"),
                token("PROGRAM"),
                programName(),
                literal(".")
              )
            )
          )
        );
      }
    
      return programDefinitionParser;
    }
    
    // ========================================================
    // programIdParagraph
    // ........................................................
    
    private ParserCombinator programIdParagraphParser = null;
    
    public final Start programIdParagraph = Start.on(getNamespace(), "programIdParagraph");
    
    public ParserCombinator programIdParagraph() {
      if (programIdParagraphParser == null) {
        FutureParser future = scoped("programIdParagraph", PUBLIC, true);
        programIdParagraphParser = future;
        future.setParser(
          sequence(
            token("PROGRAM-ID"),
            optional(
              literal(".")
            ),
            programName(),
            optional(
              sequence(
                token("AS"),
                literal()
              )
            ),
            optional(
              sequence(
                optional(
                  token("IS")
                ),
                permuted(
                  token("COMMON"),
                  choice(
                    token("INITIAL"),
                    token("RECURSIVE")
                  )
                ),
                optional(
                  token("PROGRAM")
                )
              )
            ),
            optional(
              literal(".")
            )
          )
        );
      }
    
      return programIdParagraphParser;
    }
    
    // ========================================================
    // functionDefinition
    // ........................................................
    
    private ParserCombinator functionDefinitionParser = null;
    
    public final Start functionDefinition = Start.on(getNamespace(), "functionDefinition");
    
    public ParserCombinator functionDefinition() {
      if (functionDefinitionParser == null) {
        FutureParser future = scoped("functionDefinition", PUBLIC, true);
        functionDefinitionParser = future;
        future.setParser(
          sequence(
            as("identificationDivision",
              sequence(
                optional(
                  sequence(
                    choice(
                      token("ID"),
                      token("IDENTIFICATION")
                    ),
                    token("DIVISION"),
                    literal(".")
                  )
                ),
                functionIdParagraph(),
                optional(
                  optionsParagraph()
                )
              )
            ),
            optional(
              environmentDivision()
            ),
            optional(
              dataDivision()
            ),
            optional(
              procedureDivision()
            ),
            token("END"),
            token("FUNCTION"),
            name(),
            literal(".")
          )
        );
      }
    
      return functionDefinitionParser;
    }
    
    // ========================================================
    // functionIdParagraph
    // ........................................................
    
    private ParserCombinator functionIdParagraphParser = null;
    
    public final Start functionIdParagraph = Start.on(getNamespace(), "functionIdParagraph");
    
    public ParserCombinator functionIdParagraph() {
      if (functionIdParagraphParser == null) {
        FutureParser future = scoped("functionIdParagraph", PUBLIC, true);
        functionIdParagraphParser = future;
        future.setParser(
          sequence(
            token("FUNCTION-ID"),
            optional(
              literal(".")
            ),
            name(),
            optional(
              sequence(
                token("AS"),
                literal()
              )
            ),
            optional(
              literal(".")
            )
          )
        );
      }
    
      return functionIdParagraphParser;
    }
    
    // ========================================================
    // classDefinition
    // ........................................................
    
    private ParserCombinator classDefinitionParser = null;
    
    public final Start classDefinition = Start.on(getNamespace(), "classDefinition");
    
    public ParserCombinator classDefinition() {
      if (classDefinitionParser == null) {
        FutureParser future = scoped("classDefinition", PUBLIC, true);
        classDefinitionParser = future;
        future.setParser(
          sequence(
            as("identificationDivision",
              sequence(
                optional(
                  sequence(
                    choice(
                      token("ID"),
                      token("IDENTIFICATION")
                    ),
                    token("DIVISION"),
                    literal(".")
                  )
                ),
                classIdParagraph(),
                optional(
                  optionsParagraph()
                )
              )
            ),
            optional(
              environmentDivision()
            ),
            optional(
              factoryDefinition()
            ),
            optional(
              instanceDefinition()
            ),
            token("END"),
            token("CLASS"),
            name(),
            literal(".")
          )
        );
      }
    
      return classDefinitionParser;
    }
    
    // ========================================================
    // classIdParagraph
    // ........................................................
    
    private ParserCombinator classIdParagraphParser = null;
    
    public final Start classIdParagraph = Start.on(getNamespace(), "classIdParagraph");
    
    public ParserCombinator classIdParagraph() {
      if (classIdParagraphParser == null) {
        FutureParser future = scoped("classIdParagraph", PUBLIC, true);
        classIdParagraphParser = future;
        future.setParser(
          sequence(
            token("CLASS-ID"),
            optional(
              literal(".")
            ),
            name(),
            optional(
              sequence(
                token("AS"),
                literal()
              )
            ),
            optional(
              sequence(
                token("INHERITS"),
                optional(
                  token("FROM")
                ),
                plus(
                  typeSpecifier()
                )
              )
            ),
            optional(
              sequence(
                optional(
                  token("IS")
                ),
                token("STATIC")
              )
            ),
            optional(
              sequence(
                optional(
                  token("IS")
                ),
                plus(
                  choice(
                    token("PARTIAL"),
                    token("FINAL"),
                    token("ABSTRACT")
                  )
                )
              )
            ),
            optional(
              sequence(
                optional(
                  token("IS")
                ),
                choice(
                  token("PUBLIC"),
                  token("INTERNAL")
                )
              )
            ),
            optional(
              attributeClause()
            ),
            optional(
              sequence(
                token("IMPLEMENTS"),
                plus(
                  typeSpecifier()
                )
              )
            ),
            optional(
              sequence(
                token("USING"),
                plus(
                  parameterName()
                )
              )
            ),
            optional(
              literal(".")
            )
          )
        );
      }
    
      return classIdParagraphParser;
    }
    
    // ========================================================
    // factoryDefinition
    // ........................................................
    
    private ParserCombinator factoryDefinitionParser = null;
    
    public final Start factoryDefinition = Start.on(getNamespace(), "factoryDefinition");
    
    public ParserCombinator factoryDefinition() {
      if (factoryDefinitionParser == null) {
        FutureParser future = scoped("factoryDefinition", PUBLIC, true);
        factoryDefinitionParser = future;
        future.setParser(
          sequence(
            as("identificationDivision",
              sequence(
                optional(
                  sequence(
                    choice(
                      token("ID"),
                      token("IDENTIFICATION")
                    ),
                    token("DIVISION"),
                    literal(".")
                  )
                ),
                factoryParagraph(),
                optional(
                  optionsParagraph()
                )
              )
            ),
            optional(
              environmentDivision()
            ),
            optional(
              dataDivision()
            ),
            optional(
              procedureDivision()
            ),
            token("END"),
            token("FACTORY"),
            literal(".")
          )
        );
      }
    
      return factoryDefinitionParser;
    }
    
    // ========================================================
    // factoryParagraph
    // ........................................................
    
    private ParserCombinator factoryParagraphParser = null;
    
    public final Start factoryParagraph = Start.on(getNamespace(), "factoryParagraph");
    
    public ParserCombinator factoryParagraph() {
      if (factoryParagraphParser == null) {
        FutureParser future = scoped("factoryParagraph", PUBLIC, true);
        factoryParagraphParser = future;
        future.setParser(
          sequence(
            token("FACTORY"),
            optional(
              literal(".")
            ),
            optional(
              sequence(
                token("IMPLEMENTS"),
                plus(
                  name()
                ),
                literal(".")
              )
            )
          )
        );
      }
    
      return factoryParagraphParser;
    }
    
    // ========================================================
    // instanceDefinition
    // ........................................................
    
    private ParserCombinator instanceDefinitionParser = null;
    
    public final Start instanceDefinition = Start.on(getNamespace(), "instanceDefinition");
    
    public ParserCombinator instanceDefinition() {
      if (instanceDefinitionParser == null) {
        FutureParser future = scoped("instanceDefinition", PUBLIC, true);
        instanceDefinitionParser = future;
        future.setParser(
          sequence(
            as("identificationDivision",
              sequence(
                optional(
                  sequence(
                    choice(
                      token("ID"),
                      token("IDENTIFICATION")
                    ),
                    token("DIVISION"),
                    literal(".")
                  )
                ),
                objectParagraph(),
                optional(
                  optionsParagraph()
                )
              )
            ),
            optional(
              environmentDivision()
            ),
            optional(
              dataDivision()
            ),
            optional(
              procedureDivision()
            ),
            token("END"),
            token("OBJECT"),
            literal(".")
          )
        );
      }
    
      return instanceDefinitionParser;
    }
    
    // ========================================================
    // objectParagraph
    // ........................................................
    
    private ParserCombinator objectParagraphParser = null;
    
    public final Start objectParagraph = Start.on(getNamespace(), "objectParagraph");
    
    public ParserCombinator objectParagraph() {
      if (objectParagraphParser == null) {
        FutureParser future = scoped("objectParagraph", PUBLIC, true);
        objectParagraphParser = future;
        future.setParser(
          sequence(
            token("OBJECT"),
            optional(
              literal(".")
            ),
            optional(
              sequence(
                token("IMPLEMENTS"),
                plus(
                  name()
                ),
                optional(
                  literal(".")
                )
              )
            )
          )
        );
      }
    
      return objectParagraphParser;
    }
    
    // ========================================================
    // interfaceDefinition
    // ........................................................
    
    private ParserCombinator interfaceDefinitionParser = null;
    
    public final Start interfaceDefinition = Start.on(getNamespace(), "interfaceDefinition");
    
    public ParserCombinator interfaceDefinition() {
      if (interfaceDefinitionParser == null) {
        FutureParser future = scoped("interfaceDefinition", PUBLIC, true);
        interfaceDefinitionParser = future;
        future.setParser(
          sequence(
            as("identificationDivision",
              sequence(
                optional(
                  sequence(
                    choice(
                      token("ID"),
                      token("IDENTIFICATION")
                    ),
                    token("DIVISION"),
                    literal(".")
                  )
                ),
                interfaceIdParagraph(),
                optional(
                  optionsParagraph()
                )
              )
            ),
            optional(
              environmentDivision()
            ),
            optional(
              procedureDivision()
            ),
            token("END"),
            token("INTERFACE"),
            name(),
            literal(".")
          )
        );
      }
    
      return interfaceDefinitionParser;
    }
    
    // ========================================================
    // interfaceIdParagraph
    // ........................................................
    
    private ParserCombinator interfaceIdParagraphParser = null;
    
    public final Start interfaceIdParagraph = Start.on(getNamespace(), "interfaceIdParagraph");
    
    public ParserCombinator interfaceIdParagraph() {
      if (interfaceIdParagraphParser == null) {
        FutureParser future = scoped("interfaceIdParagraph", PUBLIC, true);
        interfaceIdParagraphParser = future;
        future.setParser(
          sequence(
            token("INTERFACE-ID"),
            optional(
              literal(".")
            ),
            name(),
            optional(
              sequence(
                token("AS"),
                literal()
              )
            ),
            optional(
              sequence(
                token("INHERITS"),
                optional(
                  token("FROM")
                ),
                plus(
                  name()
                )
              )
            ),
            optional(
              sequence(
                token("USING"),
                optional(
                  token("FROM")
                ),
                plus(
                  name()
                )
              )
            ),
            optional(
              literal(".")
            )
          )
        );
      }
    
      return interfaceIdParagraphParser;
    }
    
    // ========================================================
    // methodDefinition
    // ........................................................
    
    private ParserCombinator methodDefinitionParser = null;
    
    public final Start methodDefinition = Start.on(getNamespace(), "methodDefinition");
    
    public ParserCombinator methodDefinition() {
      if (methodDefinitionParser == null) {
        FutureParser future = scoped("methodDefinition", PUBLIC, true);
        methodDefinitionParser = future;
        future.setParser(
          sequence(
            as("identificationDivision",
              sequence(
                optional(
                  sequence(
                    choice(
                      token("ID"),
                      token("IDENTIFICATION")
                    ),
                    token("DIVISION"),
                    literal(".")
                  )
                ),
                methodIdParagraph(),
                optional(
                  optionsParagraph()
                )
              )
            ),
            optional(
              environmentDivision()
            ),
            optional(
              dataDivision()
            ),
            optional(
              procedureDivision()
            ),
            token("END"),
            token("METHOD"),
            optional(
              name()
            ),
            literal(".")
          )
        );
      }
    
      return methodDefinitionParser;
    }
    
    // ========================================================
    // methodIdParagraph
    // ........................................................
    
    private ParserCombinator methodIdParagraphParser = null;
    
    public final Start methodIdParagraph = Start.on(getNamespace(), "methodIdParagraph");
    
    public ParserCombinator methodIdParagraph() {
      if (methodIdParagraphParser == null) {
        FutureParser future = scoped("methodIdParagraph", PUBLIC, true);
        methodIdParagraphParser = future;
        future.setParser(
          sequence(
            token("METHOD-ID"),
            optional(
              literal(".")
            ),
            choice(
              sequence(
                choice(
                  token("GET"),
                  token("SET")
                ),
                token("PROPERTY"),
                name()
              ),
              sequence(
                name(),
                optional(
                  sequence(
                    token("AS"),
                    literal()
                  )
                )
              )
            ),
            optional(
              token("OVERRIDE")
            ),
            optional(
              sequence(
                optional(
                  token("IS")
                ),
                token("FINAL")
              )
            ),
            optional(
              literal(".")
            )
          )
        );
      }
    
      return methodIdParagraphParser;
    }
    
    // ========================================================
    // callPrototypeDefinition
    // ........................................................
    
    private ParserCombinator callPrototypeDefinitionParser = null;
    
    public final Start callPrototypeDefinition = Start.on(getNamespace(), "callPrototypeDefinition");
    
    public ParserCombinator callPrototypeDefinition() {
      if (callPrototypeDefinitionParser == null) {
        FutureParser future = scoped("callPrototypeDefinition", PUBLIC, true);
        callPrototypeDefinitionParser = future;
        future.setParser(
          sequence(
            as("identificationDivision",
              sequence(
                optional(
                  sequence(
                    choice(
                      token("ID"),
                      token("IDENTIFICATION")
                    ),
                    token("DIVISION"),
                    literal(".")
                  )
                ),
                callPrototypeIdParagraph(),
                optional(
                  optionsParagraph()
                )
              )
            ),
            optional(
              environmentDivision()
            ),
            optional(
              dataDivision()
            ),
            optional(
              procedureDivision()
            ),
            optional(
              sequence(
                token("END"),
                token("PROGRAM"),
                programName(),
                literal(".")
              )
            )
          )
        );
      }
    
      return callPrototypeDefinitionParser;
    }
    
    // ========================================================
    // callPrototypeIdParagraph
    // ........................................................
    
    private ParserCombinator callPrototypeIdParagraphParser = null;
    
    public final Start callPrototypeIdParagraph = Start.on(getNamespace(), "callPrototypeIdParagraph");
    
    public ParserCombinator callPrototypeIdParagraph() {
      if (callPrototypeIdParagraphParser == null) {
        FutureParser future = scoped("callPrototypeIdParagraph", PUBLIC, true);
        callPrototypeIdParagraphParser = future;
        future.setParser(
          sequence(
            token("PROGRAM-ID"),
            optional(
              literal(".")
            ),
            programName(),
            optional(
              token("IS")
            ),
            token("EXTERNAL"),
            optional(
              token("PROGRAM")
            ),
            optional(
              literal(".")
            )
          )
        );
      }
    
      return callPrototypeIdParagraphParser;
    }
    
    // ========================================================
    // delegateDefinition
    // ........................................................
    
    private ParserCombinator delegateDefinitionParser = null;
    
    public final Start delegateDefinition = Start.on(getNamespace(), "delegateDefinition");
    
    public ParserCombinator delegateDefinition() {
      if (delegateDefinitionParser == null) {
        FutureParser future = scoped("delegateDefinition", PUBLIC, true);
        delegateDefinitionParser = future;
        future.setParser(
          sequence(
            as("identificationDivision",
              sequence(
                optional(
                  sequence(
                    choice(
                      token("ID"),
                      token("IDENTIFICATION")
                    ),
                    token("DIVISION"),
                    literal(".")
                  )
                ),
                delegateIdParagraph()
              )
            ),
            as("procedureDivisionHeader",
              procedureDivision$header()
            ),
            token("END"),
            token("DELEGATE"),
            literal(".")
          )
        );
      }
    
      return delegateDefinitionParser;
    }
    
    // ========================================================
    // delegateIdParagraph
    // ........................................................
    
    private ParserCombinator delegateIdParagraphParser = null;
    
    public final Start delegateIdParagraph = Start.on(getNamespace(), "delegateIdParagraph");
    
    public ParserCombinator delegateIdParagraph() {
      if (delegateIdParagraphParser == null) {
        FutureParser future = scoped("delegateIdParagraph", PUBLIC, true);
        delegateIdParagraphParser = future;
        future.setParser(
          sequence(
            token("DELEGATE-ID"),
            optional(
              literal(".")
            ),
            delegateName(),
            optional(
              sequence(
                token("AS"),
                literal()
              )
            ),
            optional(
              sequence(
                optional(
                  token("IS")
                ),
                plus(
                  choice(
                    token("PUBLIC"),
                    token("PRIVATE"),
                    token("PROTECTED"),
                    token("INTERNAL")
                  )
                )
              )
            ),
            optional(
              attributeClause()
            ),
            optional(
              literal(".")
            )
          )
        );
      }
    
      return delegateIdParagraphParser;
    }
    
    // ========================================================
    // enumDefinition
    // ........................................................
    
    private ParserCombinator enumDefinitionParser = null;
    
    public final Start enumDefinition = Start.on(getNamespace(), "enumDefinition");
    
    public ParserCombinator enumDefinition() {
      if (enumDefinitionParser == null) {
        FutureParser future = scoped("enumDefinition", PUBLIC, true);
        enumDefinitionParser = future;
        future.setParser(
          sequence(
            as("identificationDivision",
              sequence(
                optional(
                  sequence(
                    choice(
                      token("ID"),
                      token("IDENTIFICATION")
                    ),
                    token("DIVISION"),
                    literal(".")
                  )
                ),
                enumIdParagraph()
              )
            ),
            optional(
              skipto(
                sequence(
                  token("END"),
                  token("ENUM"),
                  literal(".")
                )
              )
            ),
            token("END"),
            token("ENUM"),
            literal(".")
          )
        );
      }
    
      return enumDefinitionParser;
    }
    
    // ========================================================
    // enumIdParagraph
    // ........................................................
    
    private ParserCombinator enumIdParagraphParser = null;
    
    public final Start enumIdParagraph = Start.on(getNamespace(), "enumIdParagraph");
    
    public ParserCombinator enumIdParagraph() {
      if (enumIdParagraphParser == null) {
        FutureParser future = scoped("enumIdParagraph", PUBLIC, true);
        enumIdParagraphParser = future;
        future.setParser(
          sequence(
            token("ENUM-ID"),
            optional(
              literal(".")
            ),
            enumName(),
            optional(
              sequence(
                token("AS"),
                literal()
              )
            ),
            optional(
              sequence(
                optional(
                  token("IS")
                ),
                plus(
                  choice(
                    token("PUBLIC"),
                    token("PRIVATE"),
                    token("PROTECTED"),
                    token("INTERNAL")
                  )
                )
              )
            ),
            optional(
              attributeClause()
            ),
            optional(
              literal(".")
            )
          )
        );
      }
    
      return enumIdParagraphParser;
    }
    
    // ========================================================
    // iteratorDefinition
    // ........................................................
    
    private ParserCombinator iteratorDefinitionParser = null;
    
    public final Start iteratorDefinition = Start.on(getNamespace(), "iteratorDefinition");
    
    public ParserCombinator iteratorDefinition() {
      if (iteratorDefinitionParser == null) {
        FutureParser future = scoped("iteratorDefinition", PUBLIC, true);
        iteratorDefinitionParser = future;
        future.setParser(
          sequence(
            as("identificationDivision",
              sequence(
                optional(
                  sequence(
                    choice(
                      token("ID"),
                      token("IDENTIFICATION")
                    ),
                    token("DIVISION"),
                    literal(".")
                  )
                ),
                iteratorIdParagraph()
              )
            ),
            optional(
              skipto(
                sequence(
                  token("END"),
                  token("ITERATOR"),
                  literal(".")
                )
              )
            ),
            token("END"),
            token("ITERATOR"),
            literal(".")
          )
        );
      }
    
      return iteratorDefinitionParser;
    }
    
    // ========================================================
    // iteratorIdParagraph
    // ........................................................
    
    private ParserCombinator iteratorIdParagraphParser = null;
    
    public final Start iteratorIdParagraph = Start.on(getNamespace(), "iteratorIdParagraph");
    
    public ParserCombinator iteratorIdParagraph() {
      if (iteratorIdParagraphParser == null) {
        FutureParser future = scoped("iteratorIdParagraph", PUBLIC, true);
        iteratorIdParagraphParser = future;
        future.setParser(
          sequence(
            token("ITERATOR-ID"),
            optional(
              literal(".")
            ),
            iteratorName(),
            optional(
              sequence(
                token("AS"),
                literal()
              )
            ),
            optional(
              sequence(
                optional(
                  token("IS")
                ),
                plus(
                  choice(
                    token("PUBLIC"),
                    token("PRIVATE"),
                    token("PROTECTED"),
                    token("INTERNAL")
                  )
                )
              )
            ),
            optional(
              attributeClause()
            ),
            optional(
              literal(".")
            )
          )
        );
      }
    
      return iteratorIdParagraphParser;
    }
    
    // ========================================================
    // operatorDefinition
    // ........................................................
    
    private ParserCombinator operatorDefinitionParser = null;
    
    public final Start operatorDefinition = Start.on(getNamespace(), "operatorDefinition");
    
    public ParserCombinator operatorDefinition() {
      if (operatorDefinitionParser == null) {
        FutureParser future = scoped("operatorDefinition", PUBLIC, true);
        operatorDefinitionParser = future;
        future.setParser(
          sequence(
            as("identificationDivision",
              sequence(
                optional(
                  sequence(
                    choice(
                      token("ID"),
                      token("IDENTIFICATION")
                    ),
                    token("DIVISION"),
                    literal(".")
                  )
                ),
                operatorIdParagraph()
              )
            ),
            optional(
              skipto(
                sequence(
                  token("END"),
                  token("ENUM"),
                  literal(".")
                )
              )
            ),
            token("END"),
            token("OPERATOR"),
            literal(".")
          )
        );
      }
    
      return operatorDefinitionParser;
    }
    
    // ========================================================
    // operatorIdParagraph
    // ........................................................
    
    private ParserCombinator operatorIdParagraphParser = null;
    
    public final Start operatorIdParagraph = Start.on(getNamespace(), "operatorIdParagraph");
    
    public ParserCombinator operatorIdParagraph() {
      if (operatorIdParagraphParser == null) {
        FutureParser future = scoped("operatorIdParagraph", PUBLIC, true);
        operatorIdParagraphParser = future;
        future.setParser(
          sequence(
            token("OPERATOR-ID"),
            optional(
              literal(".")
            ),
            choice(
              sequence(
                literal("="),
                optional(
                  token("EXTENSION")
                )
              ),
              literal("<>"),
              literal(">="),
              literal(">"),
              literal("<="),
              literal("<"),
              literal("+"),
              literal("-"),
              literal("*"),
              literal("/"),
              token("B-AND"),
              token("B-OR"),
              token("B-XOR"),
              token("B-NOT"),
              token("B-LEFT"),
              token("B-RIGHT"),
              token("IMPLICIT"),
              token("EXPLICIT")
            ),
            optional(
              literal(".")
            )
          )
        );
      }
    
      return operatorIdParagraphParser;
    }
    
    // ========================================================
    // valueTypeDefinition
    // ........................................................
    
    private ParserCombinator valueTypeDefinitionParser = null;
    
    public final Start valueTypeDefinition = Start.on(getNamespace(), "valueTypeDefinition");
    
    public ParserCombinator valueTypeDefinition() {
      if (valueTypeDefinitionParser == null) {
        FutureParser future = scoped("valueTypeDefinition", PUBLIC, true);
        valueTypeDefinitionParser = future;
        future.setParser(
          sequence(
            as("identificationDivision",
              sequence(
                optional(
                  sequence(
                    choice(
                      token("ID"),
                      token("IDENTIFICATION")
                    ),
                    token("DIVISION"),
                    literal(".")
                  )
                ),
                valueTypeIdParagraph()
              )
            ),
            optional(
              skipto(
                sequence(
                  token("END"),
                  token("ENUM"),
                  literal(".")
                )
              )
            ),
            token("END"),
            token("VALUETYPE"),
            literal(".")
          )
        );
      }
    
      return valueTypeDefinitionParser;
    }
    
    // ========================================================
    // valueTypeIdParagraph
    // ........................................................
    
    private ParserCombinator valueTypeIdParagraphParser = null;
    
    public final Start valueTypeIdParagraph = Start.on(getNamespace(), "valueTypeIdParagraph");
    
    public ParserCombinator valueTypeIdParagraph() {
      if (valueTypeIdParagraphParser == null) {
        FutureParser future = scoped("valueTypeIdParagraph", PUBLIC, true);
        valueTypeIdParagraphParser = future;
        future.setParser(
          sequence(
            token("VALUETYPE-ID"),
            optional(
              literal(".")
            ),
            valuetypeName(),
            optional(
              sequence(
                token("AS"),
                literal()
              )
            ),
            optional(
              sequence(
                optional(
                  token("IS")
                ),
                choice(
                  token("FINAL"),
                  token("PARTIAL"),
                  token("ABSTRACT")
                )
              )
            ),
            optional(
              sequence(
                optional(
                  token("IS")
                ),
                choice(
                  token("PUBLIC"),
                  token("INTERNAL")
                )
              )
            ),
            optional(
              attributeClause()
            ),
            optional(
              sequence(
                token("IMPLEMENTS"),
                plus(
                  interfaceName()
                )
              )
            ),
            optional(
              literal(".")
            )
          )
        );
      }
    
      return valueTypeIdParagraphParser;
    }
    
    // ========================================================
    // endMarker
    // ........................................................
    
    private ParserCombinator endMarkerParser = null;
    
    public final Start endMarker = Start.on(getNamespace(), "endMarker");
    
    public ParserCombinator endMarker() {
      if (endMarkerParser == null) {
        FutureParser future = scoped("endMarker", PUBLIC, true);
        endMarkerParser = future;
        future.setParser(
          sequence(
            token("END"),
            choice(
              sequence(
                token("CLASS"),
                name()
              ),
              token("FACTORY"),
              sequence(
                token("FUNCTION"),
                name()
              ),
              sequence(
                token("INTERFACE"),
                name()
              ),
              sequence(
                token("METHOD"),
                optional(
                  name()
                )
              ),
              token("OBJECT"),
              sequence(
                token("PROGRAM"),
                programName()
              ),
              sequence(
                token("DELEGATE"),
                name()
              ),
              sequence(
                token("ENUM"),
                name()
              ),
              sequence(
                token("OPERATOR"),
                optional(
                  name()
                )
              ),
              token("STATIC"),
              sequence(
                token("VALUETYPE"),
                name()
              )
            ),
            literal(".")
          )
        );
      }
    
      return endMarkerParser;
    }
    
    // ========================================================
    // optionsParagraph
    // ........................................................
    
    private ParserCombinator optionsParagraphParser = null;
    
    public final Start optionsParagraph = Start.on(getNamespace(), "optionsParagraph");
    
    public ParserCombinator optionsParagraph() {
      if (optionsParagraphParser == null) {
        FutureParser future = scoped("optionsParagraph", PUBLIC, true);
        optionsParagraphParser = future;
        future.setParser(
          sequence(
            token("OPTIONS"),
            literal("."),
            optional(
              arithmeticClause()
            ),
            optional(
              defaultRoundedClause()
            ),
            optional(
              entryConventionClause()
            ),
            optional(
              intermediateRoundingClause()
            ),
            literal(".")
          )
        );
      }
    
      return optionsParagraphParser;
    }
    
    // ========================================================
    // arithmeticClause
    // ........................................................
    
    private ParserCombinator arithmeticClauseParser = null;
    
    public final Start arithmeticClause = Start.on(getNamespace(), "arithmeticClause");
    
    public ParserCombinator arithmeticClause() {
      if (arithmeticClauseParser == null) {
        FutureParser future = scoped("arithmeticClause", PUBLIC, true);
        arithmeticClauseParser = future;
        future.setParser(
          sequence(
            token("ARITHMETIC"),
            optional(
              token("IS")
            ),
            choice(
              token("NATIVE"),
              token("STANDARD"),
              token("STANDARD-BINARY"),
              token("STANDARD-DECIMAL")
            )
          )
        );
      }
    
      return arithmeticClauseParser;
    }
    
    // ========================================================
    // defaultRoundedClause
    // ........................................................
    
    private ParserCombinator defaultRoundedClauseParser = null;
    
    public final Start defaultRoundedClause = Start.on(getNamespace(), "defaultRoundedClause");
    
    public ParserCombinator defaultRoundedClause() {
      if (defaultRoundedClauseParser == null) {
        FutureParser future = scoped("defaultRoundedClause", PUBLIC, true);
        defaultRoundedClauseParser = future;
        future.setParser(
          sequence(
            token("DEFAULT"),
            token("ROUNDED"),
            optional(
              token("MODE")
            ),
            optional(
              token("IS")
            ),
            choice(
              token("AWAY-FROM-ZERO"),
              token("NEAREST-AWAY-FROM-ZERO"),
              token("NEAREST-EVEN"),
              token("NEAREST-TOWARD-ZERO"),
              token("PROHIBITED"),
              token("TOWARD-GREATER"),
              token("TOWARD-LESSER"),
              token("TRUNCATION")
            )
          )
        );
      }
    
      return defaultRoundedClauseParser;
    }
    
    // ========================================================
    // entryConventionClause
    // ........................................................
    
    private ParserCombinator entryConventionClauseParser = null;
    
    public final Start entryConventionClause = Start.on(getNamespace(), "entryConventionClause");
    
    public ParserCombinator entryConventionClause() {
      if (entryConventionClauseParser == null) {
        FutureParser future = scoped("entryConventionClause", PUBLIC, true);
        entryConventionClauseParser = future;
        future.setParser(
          sequence(
            token("ENTRY-CONVENTION"),
            optional(
              token("IS")
            ),
            choice(
              token("COBOL"),
              name()
            )
          )
        );
      }
    
      return entryConventionClauseParser;
    }
    
    // ========================================================
    // intermediateRoundingClause
    // ........................................................
    
    private ParserCombinator intermediateRoundingClauseParser = null;
    
    public final Start intermediateRoundingClause = Start.on(getNamespace(), "intermediateRoundingClause");
    
    public ParserCombinator intermediateRoundingClause() {
      if (intermediateRoundingClauseParser == null) {
        FutureParser future = scoped("intermediateRoundingClause", PUBLIC, true);
        intermediateRoundingClauseParser = future;
        future.setParser(
          sequence(
            token("INTERMEDIATE"),
            token("ROUNDING"),
            optional(
              token("IS")
            ),
            choice(
              token("NEAREST-AWAY-FROM-ZERO"),
              token("NEAREST-EVEN"),
              token("PROHIBITED"),
              token("TRUNCATION")
            )
          )
        );
      }
    
      return intermediateRoundingClauseParser;
    }
    
    // ========================================================
    // metadata
    // ........................................................
    
    private ParserCombinator metadataParser = null;
    
    public final Start metadata = Start.on(getNamespace(), "metadata");
    
    public ParserCombinator metadata() {
      if (metadataParser == null) {
        FutureParser future = scoped("metadata", PUBLIC, true);
        metadataParser = future;
        future.setParser(
          sequence(
            plus(
              choice(
                sequence(
                  token("AUTHOR"),
                  optional(
                    literal(".")
                  ),
                  optional(
                    commentEntry()
                  )
                ),
                sequence(
                  token("INSTALLATION"),
                  optional(
                    literal(".")
                  ),
                  optional(
                    commentEntry()
                  )
                ),
                sequence(
                  token("DATE-WRITTEN"),
                  optional(
                    literal(".")
                  ),
                  optional(
                    commentEntry()
                  )
                ),
                sequence(
                  token("DATE-COMPILED"),
                  optional(
                    literal(".")
                  ),
                  optional(
                    commentEntry()
                  )
                ),
                sequence(
                  token("SECURITY"),
                  optional(
                    literal(".")
                  ),
                  optional(
                    commentEntry()
                  )
                ),
                sequence(
                  token("REMARKS"),
                  optional(
                    literal(".")
                  ),
                  optional(
                    commentEntry()
                  )
                )
              )
            ),
            optional(
              skipto(
                choice(
                  paragraphStart(),
                  sectionStart(),
                  divisionStart()
                )
              )
            )
          )
        );
      }
    
      return metadataParser;
    }
    
    // ========================================================
    // environmentDivision
    // ........................................................
    
    private ParserCombinator environmentDivisionParser = null;
    
    public final Start environmentDivision = Start.on(getNamespace(), "environmentDivision");
    
    public ParserCombinator environmentDivision() {
      if (environmentDivisionParser == null) {
        FutureParser future = scoped("environmentDivision", PUBLIC, true);
        environmentDivisionParser = future;
        future.setParser(
          choice(
            sequence(
              token("ENVIRONMENT"),
              token("DIVISION"),
              literal("."),
              optional(
                environmentDivisionBody()
              )
            ),
            environmentDivisionBody(),
            sequence(
              configurationSectionBody(),
              optional(
                ioSection()
              ),
              optional(
                skipto(
                  choice(
                    paragraphStart(),
                    sectionStart(),
                    divisionStart()
                  )
                )
              )
            ),
            sequence(
              ioSectionBody(),
              optional(
                configurationSection()
              ),
              optional(
                skipto(
                  choice(
                    paragraphStart(),
                    sectionStart(),
                    divisionStart()
                  )
                )
              )
            )
          )
        );
      }
    
      return environmentDivisionParser;
    }
    
    // ========================================================
    // environmentDivisionBody
    // ........................................................
    
    private ParserCombinator environmentDivisionBodyParser = null;
    
    public final Start environmentDivisionBody = Start.on(getNamespace(), "environmentDivisionBody");
    
    public ParserCombinator environmentDivisionBody() {
      if (environmentDivisionBodyParser == null) {
        FutureParser future = scoped("environmentDivisionBody", PUBLIC, true);
        environmentDivisionBodyParser = future;
        future.setParser(
          sequence(
            plus(
              choice(
                configurationSection(),
                ioSection(),
                objectSection()
              )
            ),
            optional(
              skipto(
                choice(
                  paragraphStart(),
                  sectionStart(),
                  divisionStart()
                )
              )
            )
          )
        );
      }
    
      return environmentDivisionBodyParser;
    }
    
    // ========================================================
    // configurationSection
    // ........................................................
    
    private ParserCombinator configurationSectionParser = null;
    
    public final Start configurationSection = Start.on(getNamespace(), "configurationSection");
    
    public ParserCombinator configurationSection() {
      if (configurationSectionParser == null) {
        FutureParser future = scoped("configurationSection", PUBLIC, true);
        configurationSectionParser = future;
        future.setParser(
          choice(
            sequence(
              token("CONFIGURATION"),
              token("SECTION"),
              literal("."),
              optional(
                configurationSectionBody()
              )
            ),
            configurationSectionBody()
          )
        );
      }
    
      return configurationSectionParser;
    }
    
    // ========================================================
    // configurationSectionBody
    // ........................................................
    
    private ParserCombinator configurationSectionBodyParser = null;
    
    protected final Start configurationSectionBody = Start.on(getNamespace(), "configurationSectionBody");
    
    protected ParserCombinator configurationSectionBody() {
      if (configurationSectionBodyParser == null) {
        FutureParser future = scoped("configurationSectionBody", PRIVATE, true);
        configurationSectionBodyParser = future;
        future.setParser(
          sequence(
            plus(
              choice(
                sourceComputerParagraph(),
                objectComputerParagraph(),
                specialNamesParagraph(),
                repositoryParagraph(),
                constraintsParagraph(),
                classAttributesParagraph(),
                assemblyAttributesParagraph()
              )
            ),
            optional(
              skipto(
                choice(
                  paragraphStart(),
                  sectionStart(),
                  divisionStart()
                )
              )
            )
          )
        );
      }
    
      return configurationSectionBodyParser;
    }
    
    // ========================================================
    // sourceComputerParagraph
    // ........................................................
    
    private ParserCombinator sourceComputerParagraphParser = null;
    
    public final Start sourceComputerParagraph = Start.on(getNamespace(), "sourceComputerParagraph");
    
    public ParserCombinator sourceComputerParagraph() {
      if (sourceComputerParagraphParser == null) {
        FutureParser future = scoped("sourceComputerParagraph", PUBLIC, true);
        sourceComputerParagraphParser = future;
        future.setParser(
          sequence(
            token("SOURCE-COMPUTER"),
            literal("."),
            optional(
              sequence(
                computerName(),
                optional(
                  withDebuggingMode()
                ),
                literal(".")
              )
            ),
            optional(
              skipto(
                choice(
                  paragraphStart(),
                  sectionStart(),
                  divisionStart()
                )
              )
            )
          )
        );
      }
    
      return sourceComputerParagraphParser;
    }
    
    // ========================================================
    // withDebuggingMode
    // ........................................................
    
    private ParserCombinator withDebuggingModeParser = null;
    
    public final Start withDebuggingMode = Start.on(getNamespace(), "withDebuggingMode");
    
    public ParserCombinator withDebuggingMode() {
      if (withDebuggingModeParser == null) {
        FutureParser future = scoped("withDebuggingMode", PUBLIC, true);
        withDebuggingModeParser = future;
        future.setParser(
          sequence(
            optional(
              token("WITH")
            ),
            token("DEBUGGING"),
            token("MODE")
          )
        );
      }
    
      return withDebuggingModeParser;
    }
    
    // ========================================================
    // objectComputerParagraph
    // ........................................................
    
    private ParserCombinator objectComputerParagraphParser = null;
    
    public final Start objectComputerParagraph = Start.on(getNamespace(), "objectComputerParagraph");
    
    public ParserCombinator objectComputerParagraph() {
      if (objectComputerParagraphParser == null) {
        FutureParser future = scoped("objectComputerParagraph", PUBLIC, true);
        objectComputerParagraphParser = future;
        future.setParser(
          sequence(
            token("OBJECT-COMPUTER"),
            literal("."),
            optional(
              sequence(
                computerName(),
                optional(
                  skipto(
                    literal(".")
                  )
                ),
                literal(".")
              )
            ),
            optional(
              skipto(
                choice(
                  paragraphStart(),
                  sectionStart(),
                  divisionStart()
                )
              )
            )
          )
        );
      }
    
      return objectComputerParagraphParser;
    }
    
    // ========================================================
    // constraintsParagraph
    // ........................................................
    
    private ParserCombinator constraintsParagraphParser = null;
    
    public final Start constraintsParagraph = Start.on(getNamespace(), "constraintsParagraph");
    
    public ParserCombinator constraintsParagraph() {
      if (constraintsParagraphParser == null) {
        FutureParser future = scoped("constraintsParagraph", PUBLIC, true);
        constraintsParagraphParser = future;
        future.setParser(
          sequence(
            token("CONSTRAINTS"),
            literal("."),
            optional(
              skipto(
                choice(
                  paragraphStart(),
                  sectionStart(),
                  divisionStart()
                )
              )
            )
          )
        );
      }
    
      return constraintsParagraphParser;
    }
    
    // ========================================================
    // classAttributesParagraph
    // ........................................................
    
    private ParserCombinator classAttributesParagraphParser = null;
    
    public final Start classAttributesParagraph = Start.on(getNamespace(), "classAttributesParagraph");
    
    public ParserCombinator classAttributesParagraph() {
      if (classAttributesParagraphParser == null) {
        FutureParser future = scoped("classAttributesParagraph", PUBLIC, true);
        classAttributesParagraphParser = future;
        future.setParser(
          sequence(
            token("CLASS-ATTRIBUTES"),
            literal("."),
            optional(
              skipto(
                choice(
                  paragraphStart(),
                  sectionStart(),
                  divisionStart()
                )
              )
            )
          )
        );
      }
    
      return classAttributesParagraphParser;
    }
    
    // ========================================================
    // assemblyAttributesParagraph
    // ........................................................
    
    private ParserCombinator assemblyAttributesParagraphParser = null;
    
    public final Start assemblyAttributesParagraph = Start.on(getNamespace(), "assemblyAttributesParagraph");
    
    public ParserCombinator assemblyAttributesParagraph() {
      if (assemblyAttributesParagraphParser == null) {
        FutureParser future = scoped("assemblyAttributesParagraph", PUBLIC, true);
        assemblyAttributesParagraphParser = future;
        future.setParser(
          sequence(
            token("ASSEMBLY-ATTRIBUTES"),
            literal("."),
            optional(
              skipto(
                choice(
                  paragraphStart(),
                  sectionStart(),
                  divisionStart()
                )
              )
            )
          )
        );
      }
    
      return assemblyAttributesParagraphParser;
    }
    
    // ========================================================
    // genericStringDef
    // ........................................................
    
    private ParserCombinator genericStringDefParser = null;
    
    public final Start genericStringDef = Start.on(getNamespace(), "genericStringDef");
    
    public ParserCombinator genericStringDef() {
      if (genericStringDefParser == null) {
        FutureParser future = scoped("genericStringDef", PUBLIC, true);
        genericStringDefParser = future;
        future.setParser(
          sequence(
            star(
              alphanumeric()
            ),
            optional(
              sequence(
                token("WITH"),
                token("DEBUGGING")
              )
            ),
            optional(
              literal(".")
            )
          )
        );
      }
    
      return genericStringDefParser;
    }
    
    // ========================================================
    // specialNamesParagraph
    // ........................................................
    
    private ParserCombinator specialNamesParagraphParser = null;
    
    public final Start specialNamesParagraph = Start.on(getNamespace(), "specialNamesParagraph");
    
    public ParserCombinator specialNamesParagraph() {
      if (specialNamesParagraphParser == null) {
        FutureParser future = scoped("specialNamesParagraph", PUBLIC, true);
        specialNamesParagraphParser = future;
        future.setParser(
          sequence(
            token("SPECIAL-NAMES"),
            literal("."),
            star(
              choice(
                specialNameStatement(),
                copyStatement()
              )
            ),
            optional(
              literal(".")
            ),
            optional(
              skipto(
                choice(
                  paragraphStart(),
                  sectionStart(),
                  divisionStart()
                )
              )
            )
          )
        );
      }
    
      return specialNamesParagraphParser;
    }
    
    // ========================================================
    // specialNameStatement
    // ........................................................
    
    private ParserCombinator specialNameStatementParser = null;
    
    public final Start specialNameStatement = Start.on(getNamespace(), "specialNameStatement");
    
    public ParserCombinator specialNameStatement() {
      if (specialNameStatementParser == null) {
        FutureParser future = scoped("specialNameStatement", PUBLIC, true);
        specialNameStatementParser = future;
        future.setParser(
          choice(
            consoleIsCRT(),
            alphabetIs(),
            symbolicChars(),
            classIs(),
            localeIs(),
            currencySignIs(),
            decimalIsComma(),
            numericSignIs(),
            callConvention(),
            cursorIs(),
            crtStatusIs(),
            xmlSchemaIs(),
            screenControlIs(),
            eventStatusIs(),
            sequence(
              cobolSwitch(),
              token("IS"),
              mnemonicName(),
              star(
                sequence(
                  choice(
                    token("ON"),
                    token("OFF")
                  ),
                  optional(
                    token("STATUS")
                  ),
                  optional(
                    token("IS")
                  ),
                  conditionName()
                )
              )
            ),
            sequence(
              cobolDevice(),
              token("IS"),
              mnemonicName()
            )
          )
        );
      }
    
      return specialNameStatementParser;
    }
    
    // ========================================================
    // consoleIsCRT
    // ........................................................
    
    private ParserCombinator consoleIsCRTParser = null;
    
    public final Start consoleIsCRT = Start.on(getNamespace(), "consoleIsCRT");
    
    public ParserCombinator consoleIsCRT() {
      if (consoleIsCRTParser == null) {
        FutureParser future = scoped("consoleIsCRT", PUBLIC, true);
        consoleIsCRTParser = future;
        future.setParser(
          sequence(
            token("CONSOLE"),
            optional(
              token("IS")
            ),
            token("CRT")
          )
        );
      }
    
      return consoleIsCRTParser;
    }
    
    // ========================================================
    // cobolDevice
    // ........................................................
    
    private ParserCombinator cobolDeviceParser = null;
    
    public final Start cobolDevice = Start.on(getNamespace(), "cobolDevice");
    
    public ParserCombinator cobolDevice() {
      if (cobolDeviceParser == null) {
        FutureParser future = scoped("cobolDevice", PUBLIC, true);
        cobolDeviceParser = future;
        future.setParser(
          choice(
            token("SYSIN"),
            token("SYSIPT"),
            token("SYSOUT"),
            token("SYSLIST"),
            token("SYSLST"),
            token("SYSPCH"),
            token("SYSPUNCH"),
            token("CONSOLE"),
            token("TAB"),
            token("PRINTER"),
            token("FORMFEED"),
            token("COMMAND-LINE"),
            token("ARGUMENT-NUMBER"),
            token("ENVIRONMENT-NAME"),
            token("ENVIRONMENT-VALUE"),
            token("SYSERR"),
            token("C01"),
            token("C02"),
            token("C03"),
            token("C04"),
            token("C05"),
            token("C06"),
            token("C07"),
            token("C08"),
            token("C09"),
            token("C10"),
            token("C11"),
            token("C12"),
            token("S01"),
            token("S02"),
            token("S03"),
            token("S04"),
            token("S05"),
            token("CSP"),
            alphanumericLiteral(),
            cobolWord()
          )
        );
      }
    
      return cobolDeviceParser;
    }
    
    // ========================================================
    // cobolSwitch
    // ........................................................
    
    private ParserCombinator cobolSwitchParser = null;
    
    public final Start cobolSwitch = Start.on(getNamespace(), "cobolSwitch");
    
    public ParserCombinator cobolSwitch() {
      if (cobolSwitchParser == null) {
        FutureParser future = scoped("cobolSwitch", PUBLIC, true);
        cobolSwitchParser = future;
        future.setParser(
          choice(
            token("SWITCH-0"),
            token("SWITCH-1"),
            token("SWITCH-2"),
            token("SWITCH-3"),
            token("SWITCH-4"),
            token("SWITCH-5"),
            token("SWITCH-6"),
            token("SWITCH-7"),
            token("SWITCH-8")
          )
        );
      }
    
      return cobolSwitchParser;
    }
    
    // ========================================================
    // alphabetIs
    // ........................................................
    
    private ParserCombinator alphabetIsParser = null;
    
    public final Start alphabetIs = Start.on(getNamespace(), "alphabetIs");
    
    public ParserCombinator alphabetIs() {
      if (alphabetIsParser == null) {
        FutureParser future = scoped("alphabetIs", PUBLIC, true);
        alphabetIsParser = future;
        future.setParser(
          sequence(
            token("ALPHABET"),
            identifier(),
            optional(
              token("IS")
            ),
            alphabetType()
          )
        );
      }
    
      return alphabetIsParser;
    }
    
    // ========================================================
    // alphabetType
    // ........................................................
    
    private ParserCombinator alphabetTypeParser = null;
    
    public final Start alphabetType = Start.on(getNamespace(), "alphabetType");
    
    public ParserCombinator alphabetType() {
      if (alphabetTypeParser == null) {
        FutureParser future = scoped("alphabetType", PUBLIC, true);
        alphabetTypeParser = future;
        future.setParser(
          choice(
            standard1AlphabetType(),
            standard2AlphabetType(),
            nativeAlphabetType(),
            asciiAlphabetType(),
            ebcdicAlphabetType(),
            explicitAlphabetType(),
            codeNameAlphabetType()
          )
        );
      }
    
      return alphabetTypeParser;
    }
    
    // ========================================================
    // standard1AlphabetType
    // ........................................................
    
    private ParserCombinator standard1AlphabetTypeParser = null;
    
    public final Start standard1AlphabetType = Start.on(getNamespace(), "standard1AlphabetType");
    
    public ParserCombinator standard1AlphabetType() {
      if (standard1AlphabetTypeParser == null) {
        FutureParser future = scoped("standard1AlphabetType", PUBLIC, true);
        standard1AlphabetTypeParser = future;
        future.setParser(
          token("STANDARD-1")
        );
      }
    
      return standard1AlphabetTypeParser;
    }
    
    // ========================================================
    // standard2AlphabetType
    // ........................................................
    
    private ParserCombinator standard2AlphabetTypeParser = null;
    
    public final Start standard2AlphabetType = Start.on(getNamespace(), "standard2AlphabetType");
    
    public ParserCombinator standard2AlphabetType() {
      if (standard2AlphabetTypeParser == null) {
        FutureParser future = scoped("standard2AlphabetType", PUBLIC, true);
        standard2AlphabetTypeParser = future;
        future.setParser(
          token("STANDARD-2")
        );
      }
    
      return standard2AlphabetTypeParser;
    }
    
    // ========================================================
    // nativeAlphabetType
    // ........................................................
    
    private ParserCombinator nativeAlphabetTypeParser = null;
    
    public final Start nativeAlphabetType = Start.on(getNamespace(), "nativeAlphabetType");
    
    public ParserCombinator nativeAlphabetType() {
      if (nativeAlphabetTypeParser == null) {
        FutureParser future = scoped("nativeAlphabetType", PUBLIC, true);
        nativeAlphabetTypeParser = future;
        future.setParser(
          token("NATIVE")
        );
      }
    
      return nativeAlphabetTypeParser;
    }
    
    // ========================================================
    // asciiAlphabetType
    // ........................................................
    
    private ParserCombinator asciiAlphabetTypeParser = null;
    
    public final Start asciiAlphabetType = Start.on(getNamespace(), "asciiAlphabetType");
    
    public ParserCombinator asciiAlphabetType() {
      if (asciiAlphabetTypeParser == null) {
        FutureParser future = scoped("asciiAlphabetType", PUBLIC, true);
        asciiAlphabetTypeParser = future;
        future.setParser(
          token("ASCII")
        );
      }
    
      return asciiAlphabetTypeParser;
    }
    
    // ========================================================
    // ebcdicAlphabetType
    // ........................................................
    
    private ParserCombinator ebcdicAlphabetTypeParser = null;
    
    public final Start ebcdicAlphabetType = Start.on(getNamespace(), "ebcdicAlphabetType");
    
    public ParserCombinator ebcdicAlphabetType() {
      if (ebcdicAlphabetTypeParser == null) {
        FutureParser future = scoped("ebcdicAlphabetType", PUBLIC, true);
        ebcdicAlphabetTypeParser = future;
        future.setParser(
          token("EBCDIC")
        );
      }
    
      return ebcdicAlphabetTypeParser;
    }
    
    // ========================================================
    // explicitAlphabetType
    // ........................................................
    
    private ParserCombinator explicitAlphabetTypeParser = null;
    
    public final Start explicitAlphabetType = Start.on(getNamespace(), "explicitAlphabetType");
    
    public ParserCombinator explicitAlphabetType() {
      if (explicitAlphabetTypeParser == null) {
        FutureParser future = scoped("explicitAlphabetType", PUBLIC, true);
        explicitAlphabetTypeParser = future;
        future.setParser(
          sequence(
            choice(
              literalRange(),
              literal()
            ),
            star(
              sequence(
                token("ALSO"),
                choice(
                  literalRange(),
                  literal()
                )
              )
            )
          )
        );
      }
    
      return explicitAlphabetTypeParser;
    }
    
    // ========================================================
    // codeNameAlphabetType
    // ........................................................
    
    private ParserCombinator codeNameAlphabetTypeParser = null;
    
    public final Start codeNameAlphabetType = Start.on(getNamespace(), "codeNameAlphabetType");
    
    public ParserCombinator codeNameAlphabetType() {
      if (codeNameAlphabetTypeParser == null) {
        FutureParser future = scoped("codeNameAlphabetType", PUBLIC, true);
        codeNameAlphabetTypeParser = future;
        future.setParser(
          cobolWord()
        );
      }
    
      return codeNameAlphabetTypeParser;
    }
    
    // ========================================================
    // literalRange
    // ........................................................
    
    private ParserCombinator literalRangeParser = null;
    
    public final Start literalRange = Start.on(getNamespace(), "literalRange");
    
    public ParserCombinator literalRange() {
      if (literalRangeParser == null) {
        FutureParser future = scoped("literalRange", PUBLIC, true);
        literalRangeParser = future;
        future.setParser(
          sequence(
            literal(),
            choice(
              token("THROUGH"),
              token("THRU")
            ),
            literal()
          )
        );
      }
    
      return literalRangeParser;
    }
    
    // ========================================================
    // symbolicChars
    // ........................................................
    
    private ParserCombinator symbolicCharsParser = null;
    
    public final Start symbolicChars = Start.on(getNamespace(), "symbolicChars");
    
    public ParserCombinator symbolicChars() {
      if (symbolicCharsParser == null) {
        FutureParser future = scoped("symbolicChars", PUBLIC, true);
        symbolicCharsParser = future;
        future.setParser(
          sequence(
            token("SYMBOLIC"),
            optional(
              choice(
                token("CHARACTER"),
                token("CHARACTERS")
              )
            ),
            plus(
              sequence(
                plus(
                  literal()
                ),
                optional(
                  choice(
                    token("IS"),
                    token("ARE")
                  )
                ),
                plus(
                  integer()
                )
              )
            ),
            optional(
              sequence(
                token("IN"),
                identifier()
              )
            )
          )
        );
      }
    
      return symbolicCharsParser;
    }
    
    // ========================================================
    // classIs
    // ........................................................
    
    private ParserCombinator classIsParser = null;
    
    public final Start classIs = Start.on(getNamespace(), "classIs");
    
    public ParserCombinator classIs() {
      if (classIsParser == null) {
        FutureParser future = scoped("classIs", PUBLIC, true);
        classIsParser = future;
        future.setParser(
          sequence(
            token("CLASS"),
            identifier(),
            optional(
              token("IS")
            ),
            plus(
              choice(
                literalRange(),
                literal()
              )
            )
          )
        );
      }
    
      return classIsParser;
    }
    
    // ========================================================
    // localeIs
    // ........................................................
    
    private ParserCombinator localeIsParser = null;
    
    public final Start localeIs = Start.on(getNamespace(), "localeIs");
    
    public ParserCombinator localeIs() {
      if (localeIsParser == null) {
        FutureParser future = scoped("localeIs", PUBLIC, true);
        localeIsParser = future;
        future.setParser(
          sequence(
            token("LOCALE"),
            identifier(),
            optional(
              token("IS")
            ),
            identifier()
          )
        );
      }
    
      return localeIsParser;
    }
    
    // ========================================================
    // currencySignIs
    // ........................................................
    
    private ParserCombinator currencySignIsParser = null;
    
    public final Start currencySignIs = Start.on(getNamespace(), "currencySignIs");
    
    public ParserCombinator currencySignIs() {
      if (currencySignIsParser == null) {
        FutureParser future = scoped("currencySignIs", PUBLIC, true);
        currencySignIsParser = future;
        future.setParser(
          sequence(
            currencySignIs$sign(),
            optional(
              currencySignIs$symbol()
            )
          )
        );
      }
    
      return currencySignIsParser;
    }
    
    // ========================================================
    // sign
    // ........................................................
    
    private ParserCombinator currencySignIs$signParser = null;
    
    public final Start currencySignIs$sign = Start.on(getNamespace(), "sign");
    
    public ParserCombinator currencySignIs$sign() {
      if (currencySignIs$signParser == null) {
        FutureParser future = scoped("sign", PUBLIC, true);
        currencySignIs$signParser = future;
        future.setParser(
          sequence(
            token("CURRENCY"),
            optional(
              token("SIGN")
            ),
            optional(
              token("IS")
            ),
            literal()
          )
        );
      }
    
      return currencySignIs$signParser;
    }
    
    // ========================================================
    // symbol
    // ........................................................
    
    private ParserCombinator currencySignIs$symbolParser = null;
    
    public final Start currencySignIs$symbol = Start.on(getNamespace(), "symbol");
    
    public ParserCombinator currencySignIs$symbol() {
      if (currencySignIs$symbolParser == null) {
        FutureParser future = scoped("symbol", PUBLIC, true);
        currencySignIs$symbolParser = future;
        future.setParser(
          sequence(
            optional(
              token("WITH")
            ),
            token("PICTURE"),
            token("SYMBOL"),
            literal()
          )
        );
      }
    
      return currencySignIs$symbolParser;
    }
    
    // ========================================================
    // decimalIsComma
    // ........................................................
    
    private ParserCombinator decimalIsCommaParser = null;
    
    public final Start decimalIsComma = Start.on(getNamespace(), "decimalIsComma");
    
    public ParserCombinator decimalIsComma() {
      if (decimalIsCommaParser == null) {
        FutureParser future = scoped("decimalIsComma", PUBLIC, true);
        decimalIsCommaParser = future;
        future.setParser(
          sequence(
            token("DECIMAL-POINT"),
            optional(
              token("IS")
            ),
            token("COMMA")
          )
        );
      }
    
      return decimalIsCommaParser;
    }
    
    // ========================================================
    // numericSignIs
    // ........................................................
    
    private ParserCombinator numericSignIsParser = null;
    
    public final Start numericSignIs = Start.on(getNamespace(), "numericSignIs");
    
    public ParserCombinator numericSignIs() {
      if (numericSignIsParser == null) {
        FutureParser future = scoped("numericSignIs", PUBLIC, true);
        numericSignIsParser = future;
        future.setParser(
          sequence(
            token("NUMERIC"),
            token("SIGN"),
            optional(
              token("IS")
            ),
            choice(
              token("LEADING"),
              token("TRAILING")
            ),
            optional(
              sequence(
                token("SEPARATE"),
                optional(
                  token("CHARACTER")
                )
              )
            )
          )
        );
      }
    
      return numericSignIsParser;
    }
    
    // ========================================================
    // callConvention
    // ........................................................
    
    private ParserCombinator callConventionParser = null;
    
    public final Start callConvention = Start.on(getNamespace(), "callConvention");
    
    public ParserCombinator callConvention() {
      if (callConventionParser == null) {
        FutureParser future = scoped("callConvention", PUBLIC, true);
        callConventionParser = future;
        future.setParser(
          sequence(
            token("CALL-CONVENTION"),
            integer(),
            optional(
              token("IS")
            ),
            mnemonicName()
          )
        );
      }
    
      return callConventionParser;
    }
    
    // ========================================================
    // cursorIs
    // ........................................................
    
    private ParserCombinator cursorIsParser = null;
    
    public final Start cursorIs = Start.on(getNamespace(), "cursorIs");
    
    public ParserCombinator cursorIs() {
      if (cursorIsParser == null) {
        FutureParser future = scoped("cursorIs", PUBLIC, true);
        cursorIsParser = future;
        future.setParser(
          sequence(
            token("CURSOR"),
            optional(
              token("IS")
            ),
            dataName()
          )
        );
      }
    
      return cursorIsParser;
    }
    
    // ========================================================
    // crtStatusIs
    // ........................................................
    
    private ParserCombinator crtStatusIsParser = null;
    
    public final Start crtStatusIs = Start.on(getNamespace(), "crtStatusIs");
    
    public ParserCombinator crtStatusIs() {
      if (crtStatusIsParser == null) {
        FutureParser future = scoped("crtStatusIs", PUBLIC, true);
        crtStatusIsParser = future;
        future.setParser(
          sequence(
            token("CRT"),
            token("STATUS"),
            optional(
              token("IS")
            ),
            dataName()
          )
        );
      }
    
      return crtStatusIsParser;
    }
    
    // ========================================================
    // xmlSchemaIs
    // ........................................................
    
    private ParserCombinator xmlSchemaIsParser = null;
    
    public final Start xmlSchemaIs = Start.on(getNamespace(), "xmlSchemaIs");
    
    public ParserCombinator xmlSchemaIs() {
      if (xmlSchemaIsParser == null) {
        FutureParser future = scoped("xmlSchemaIs", PUBLIC, true);
        xmlSchemaIsParser = future;
        future.setParser(
          sequence(
            token("XML-SCHEMA"),
            identifier(),
            optional(
              token("IS")
            ),
            choice(
              dataName(),
              literal()
            )
          )
        );
      }
    
      return xmlSchemaIsParser;
    }
    
    // ========================================================
    // screenControlIs
    // ........................................................
    
    private ParserCombinator screenControlIsParser = null;
    
    public final Start screenControlIs = Start.on(getNamespace(), "screenControlIs");
    
    public ParserCombinator screenControlIs() {
      if (screenControlIsParser == null) {
        FutureParser future = scoped("screenControlIs", PUBLIC, true);
        screenControlIsParser = future;
        future.setParser(
          sequence(
            token("SCREEN"),
            token("CONTROL"),
            optional(
              token("IS")
            ),
            identifier()
          )
        );
      }
    
      return screenControlIsParser;
    }
    
    // ========================================================
    // eventStatusIs
    // ........................................................
    
    private ParserCombinator eventStatusIsParser = null;
    
    public final Start eventStatusIs = Start.on(getNamespace(), "eventStatusIs");
    
    public ParserCombinator eventStatusIs() {
      if (eventStatusIsParser == null) {
        FutureParser future = scoped("eventStatusIs", PUBLIC, true);
        eventStatusIsParser = future;
        future.setParser(
          sequence(
            token("EVENT"),
            token("STATUS"),
            optional(
              token("IS")
            ),
            identifier()
          )
        );
      }
    
      return eventStatusIsParser;
    }
    
    // ========================================================
    // repositoryParagraph
    // ........................................................
    
    private ParserCombinator repositoryParagraphParser = null;
    
    public final Start repositoryParagraph = Start.on(getNamespace(), "repositoryParagraph");
    
    public ParserCombinator repositoryParagraph() {
      if (repositoryParagraphParser == null) {
        FutureParser future = scoped("repositoryParagraph", PUBLIC, true);
        repositoryParagraphParser = future;
        future.setParser(
          sequence(
            token("REPOSITORY"),
            literal("."),
            optional(
              sequence(
                plus(
                  choice(
                    classSpecifier(),
                    interfaceSpecifier(),
                    programSpecifier(),
                    propertySpecifier(),
                    functionSpecifier(),
                    delegateSpecifier(),
                    enumSpecifier()
                  )
                ),
                literal(".")
              )
            )
          )
        );
      }
    
      return repositoryParagraphParser;
    }
    
    // ========================================================
    // classSpecifier
    // ........................................................
    
    private ParserCombinator classSpecifierParser = null;
    
    public final Start classSpecifier = Start.on(getNamespace(), "classSpecifier");
    
    public ParserCombinator classSpecifier() {
      if (classSpecifierParser == null) {
        FutureParser future = scoped("classSpecifier", PUBLIC, true);
        classSpecifierParser = future;
        future.setParser(
          sequence(
            token("CLASS"),
            className(),
            optional(
              sequence(
                token("AS"),
                literal()
              )
            ),
            optional(
              sequence(
                token("EXPANDS"),
                className(),
                token("USING"),
                choice(
                  className(),
                  interfaceName()
                )
              )
            )
          )
        );
      }
    
      return classSpecifierParser;
    }
    
    // ========================================================
    // interfaceSpecifier
    // ........................................................
    
    private ParserCombinator interfaceSpecifierParser = null;
    
    public final Start interfaceSpecifier = Start.on(getNamespace(), "interfaceSpecifier");
    
    public ParserCombinator interfaceSpecifier() {
      if (interfaceSpecifierParser == null) {
        FutureParser future = scoped("interfaceSpecifier", PUBLIC, true);
        interfaceSpecifierParser = future;
        future.setParser(
          sequence(
            token("INTERFACE"),
            interfaceName(),
            optional(
              sequence(
                token("AS"),
                literal()
              )
            ),
            optional(
              sequence(
                token("EXPANDS"),
                interfaceName(),
                token("USING"),
                choice(
                  className(),
                  interfaceName()
                )
              )
            )
          )
        );
      }
    
      return interfaceSpecifierParser;
    }
    
    // ========================================================
    // programSpecifier
    // ........................................................
    
    private ParserCombinator programSpecifierParser = null;
    
    public final Start programSpecifier = Start.on(getNamespace(), "programSpecifier");
    
    public ParserCombinator programSpecifier() {
      if (programSpecifierParser == null) {
        FutureParser future = scoped("programSpecifier", PUBLIC, true);
        programSpecifierParser = future;
        future.setParser(
          sequence(
            token("PROGRAM"),
            programName(),
            optional(
              sequence(
                token("AS"),
                literal()
              )
            )
          )
        );
      }
    
      return programSpecifierParser;
    }
    
    // ========================================================
    // propertySpecifier
    // ........................................................
    
    private ParserCombinator propertySpecifierParser = null;
    
    public final Start propertySpecifier = Start.on(getNamespace(), "propertySpecifier");
    
    public ParserCombinator propertySpecifier() {
      if (propertySpecifierParser == null) {
        FutureParser future = scoped("propertySpecifier", PUBLIC, true);
        propertySpecifierParser = future;
        future.setParser(
          sequence(
            token("PROPERTY"),
            propertyName(),
            optional(
              sequence(
                token("AS"),
                literal()
              )
            )
          )
        );
      }
    
      return propertySpecifierParser;
    }
    
    // ========================================================
    // functionSpecifier
    // ........................................................
    
    private ParserCombinator functionSpecifierParser = null;
    
    public final Start functionSpecifier = Start.on(getNamespace(), "functionSpecifier");
    
    public ParserCombinator functionSpecifier() {
      if (functionSpecifierParser == null) {
        FutureParser future = scoped("functionSpecifier", PUBLIC, true);
        functionSpecifierParser = future;
        future.setParser(
          sequence(
            token("FUNCTION"),
            choice(
              sequence(
                choice(
                  token("ALL"),
                  functionName()
                ),
                token("INTRINSIC")
              ),
              sequence(
                functionName(),
                optional(
                  sequence(
                    token("AS"),
                    literal()
                  )
                )
              )
            )
          )
        );
      }
    
      return functionSpecifierParser;
    }
    
    // ========================================================
    // delegateSpecifier
    // ........................................................
    
    private ParserCombinator delegateSpecifierParser = null;
    
    public final Start delegateSpecifier = Start.on(getNamespace(), "delegateSpecifier");
    
    public ParserCombinator delegateSpecifier() {
      if (delegateSpecifierParser == null) {
        FutureParser future = scoped("delegateSpecifier", PUBLIC, true);
        delegateSpecifierParser = future;
        future.setParser(
          sequence(
            token("DELEGATE"),
            delegateName(),
            optional(
              sequence(
                token("AS"),
                literal()
              )
            )
          )
        );
      }
    
      return delegateSpecifierParser;
    }
    
    // ========================================================
    // enumSpecifier
    // ........................................................
    
    private ParserCombinator enumSpecifierParser = null;
    
    public final Start enumSpecifier = Start.on(getNamespace(), "enumSpecifier");
    
    public ParserCombinator enumSpecifier() {
      if (enumSpecifierParser == null) {
        FutureParser future = scoped("enumSpecifier", PUBLIC, true);
        enumSpecifierParser = future;
        future.setParser(
          sequence(
            token("ENUM"),
            enumName(),
            optional(
              sequence(
                token("AS"),
                literal()
              )
            )
          )
        );
      }
    
      return enumSpecifierParser;
    }
    
    // ========================================================
    // ioSection
    // ........................................................
    
    private ParserCombinator ioSectionParser = null;
    
    public final Start ioSection = Start.on(getNamespace(), "ioSection");
    
    public ParserCombinator ioSection() {
      if (ioSectionParser == null) {
        FutureParser future = scoped("ioSection", PUBLIC, true);
        ioSectionParser = future;
        future.setParser(
          choice(
            sequence(
              token("INPUT-OUTPUT"),
              token("SECTION"),
              literal("."),
              optional(
                ioSectionBody()
              )
            ),
            ioSectionBody()
          )
        );
      }
    
      return ioSectionParser;
    }
    
    // ========================================================
    // ioSectionBody
    // ........................................................
    
    private ParserCombinator ioSectionBodyParser = null;
    
    protected final Start ioSectionBody = Start.on(getNamespace(), "ioSectionBody");
    
    protected ParserCombinator ioSectionBody() {
      if (ioSectionBodyParser == null) {
        FutureParser future = scoped("ioSectionBody", PRIVATE, true);
        ioSectionBodyParser = future;
        future.setParser(
          sequence(
            plus(
              choice(
                fileControlParagraph(),
                ioControlParagraph()
              )
            ),
            optional(
              skipto(
                choice(
                  paragraphStart(),
                  sectionStart(),
                  divisionStart()
                )
              )
            )
          )
        );
      }
    
      return ioSectionBodyParser;
    }
    
    // ========================================================
    // fileControlParagraph
    // ........................................................
    
    private ParserCombinator fileControlParagraphParser = null;
    
    public final Start fileControlParagraph = Start.on(getNamespace(), "fileControlParagraph");
    
    public ParserCombinator fileControlParagraph() {
      if (fileControlParagraphParser == null) {
        FutureParser future = scoped("fileControlParagraph", PUBLIC, true);
        fileControlParagraphParser = future;
        future.setParser(
          choice(
            sequence(
              token("FILE-CONTROL"),
              literal("."),
              optional(
                fileControlEntry()
              )
            ),
            fileControlEntry()
          )
        );
      }
    
      return fileControlParagraphParser;
    }
    
    // ========================================================
    // fileControlEntry
    // ........................................................
    
    private ParserCombinator fileControlEntryParser = null;
    
    public final Start fileControlEntry = Start.on(getNamespace(), "fileControlEntry");
    
    public ParserCombinator fileControlEntry() {
      if (fileControlEntryParser == null) {
        FutureParser future = scoped("fileControlEntry", PUBLIC, true);
        fileControlEntryParser = future;
        future.setParser(
          plus(
            choice(
              selectStatement(),
              copyStatement()
            )
          )
        );
      }
    
      return fileControlEntryParser;
    }
    
    // ========================================================
    // selectStatement
    // ........................................................
    
    private ParserCombinator selectStatementParser = null;
    
    public final Start selectStatement = Start.on(getNamespace(), "selectStatement");
    
    public ParserCombinator selectStatement() {
      if (selectStatementParser == null) {
        FutureParser future = scoped("selectStatement", PUBLIC, true);
        selectStatementParser = future;
        future.setParser(
          sequence(
            selectClause(),
            optional(
              permuted(
                assignClause(),
                organizationClause(),
                collationClause(),
                recordDelimiterClause(),
                reserveClause(),
                accessModeClause(),
                lockModeClause(),
                relativeKeyClause(),
                recordKeyClause(),
                plus(
                  alternateRecordKeyClause()
                ),
                fileStatusClause(),
                sortStatusClause(),
                sharingClause(),
                paddingClause()
              )
            ),
            literal(".")
          )
        );
      }
    
      return selectStatementParser;
    }
    
    // ========================================================
    // selectClause
    // ........................................................
    
    private ParserCombinator selectClauseParser = null;
    
    public final Start selectClause = Start.on(getNamespace(), "selectClause");
    
    public ParserCombinator selectClause() {
      if (selectClauseParser == null) {
        FutureParser future = scoped("selectClause", PUBLIC, true);
        selectClauseParser = future;
        future.setParser(
          sequence(
            token("SELECT"),
            optional(
              choice(
                token("OPTIONAL"),
                sequence(
                  token("NOT"),
                  token("OPTIONAL")
                )
              )
            ),
            fileName()
          )
        );
      }
    
      return selectClauseParser;
    }
    
    // ========================================================
    // assignClause
    // ........................................................
    
    private ParserCombinator assignClauseParser = null;
    
    public final Start assignClause = Start.on(getNamespace(), "assignClause");
    
    public ParserCombinator assignClause() {
      if (assignClauseParser == null) {
        FutureParser future = scoped("assignClause", PUBLIC, true);
        assignClauseParser = future;
        future.setParser(
          sequence(
            token("ASSIGN"),
            choice(
              assignUsingClause(),
              assignToClause()
            )
          )
        );
      }
    
      return assignClauseParser;
    }
    
    // ========================================================
    // assignUsingClause
    // ........................................................
    
    private ParserCombinator assignUsingClauseParser = null;
    
    public final Start assignUsingClause = Start.on(getNamespace(), "assignUsingClause");
    
    public ParserCombinator assignUsingClause() {
      if (assignUsingClauseParser == null) {
        FutureParser future = scoped("assignUsingClause", PUBLIC, true);
        assignUsingClauseParser = future;
        future.setParser(
          sequence(
            token("USING"),
            dataName()
          )
        );
      }
    
      return assignUsingClauseParser;
    }
    
    // ========================================================
    // assignToClause
    // ........................................................
    
    private ParserCombinator assignToClauseParser = null;
    
    public final Start assignToClause = Start.on(getNamespace(), "assignToClause");
    
    public ParserCombinator assignToClause() {
      if (assignToClauseParser == null) {
        FutureParser future = scoped("assignToClause", PUBLIC, true);
        assignToClauseParser = future;
        future.setParser(
          sequence(
            optional(
              token("TO")
            ),
            optional(
              choice(
                token("EXTERNAL"),
                token("DYNAMIC")
              )
            ),
            choice(
              diskClause(),
              literal(),
              name()
            )
          )
        );
      }
    
      return assignToClauseParser;
    }
    
    // ========================================================
    // diskClause
    // ........................................................
    
    private ParserCombinator diskClauseParser = null;
    
    public final Start diskClause = Start.on(getNamespace(), "diskClause");
    
    public ParserCombinator diskClause() {
      if (diskClauseParser == null) {
        FutureParser future = scoped("diskClause", PUBLIC, true);
        diskClauseParser = future;
        future.setParser(
          choice(
            sequence(
              token("DISK"),
              token("FROM"),
              dataName()
            ),
            sequence(
              token("LINE"),
              token("ADVANCING"),
              optional(
                token("FILE")
              ),
              plus(
                choice(
                  dataName(),
                  literal()
                )
              )
            ),
            sequence(
              optional(
                token("MULTIPLE")
              ),
              choice(
                token("REEL"),
                token("UNIT")
              ),
              optional(
                token("FILE")
              ),
              plus(
                choice(
                  dataName(),
                  literal()
                )
              )
            ),
            sequence(
              optional(
                token("DISK")
              ),
              token("FILE"),
              plus(
                choice(
                  dataName(),
                  literal()
                )
              )
            ),
            sequence(
              choice(
                token("DISK"),
                token("PRINTER")
              ),
              token("DISPLAY")
            ),
            sequence(
              choice(
                token("DISK"),
                token("KEYBOARD"),
                token("DISPLAY"),
                token("PRINTER"),
                token("PRINTER-1")
              ),
              star(
                choice(
                  dataName(),
                  literal()
                )
              )
            )
          )
        );
      }
    
      return diskClauseParser;
    }
    
    // ========================================================
    // collationClause
    // ........................................................
    
    private ParserCombinator collationClauseParser = null;
    
    public final Start collationClause = Start.on(getNamespace(), "collationClause");
    
    public ParserCombinator collationClause() {
      if (collationClauseParser == null) {
        FutureParser future = scoped("collationClause", PUBLIC, true);
        collationClauseParser = future;
        future.setParser(
          sequence(
            token("COLLATING"),
            optional(
              token("SEQUENCE")
            ),
            optional(
              token("IS")
            ),
            alphabetName()
          )
        );
      }
    
      return collationClauseParser;
    }
    
    // ========================================================
    // recordDelimiterClause
    // ........................................................
    
    private ParserCombinator recordDelimiterClauseParser = null;
    
    public final Start recordDelimiterClause = Start.on(getNamespace(), "recordDelimiterClause");
    
    public ParserCombinator recordDelimiterClause() {
      if (recordDelimiterClauseParser == null) {
        FutureParser future = scoped("recordDelimiterClause", PUBLIC, true);
        recordDelimiterClauseParser = future;
        future.setParser(
          sequence(
            token("RECORD"),
            token("DELIMITER"),
            optional(
              token("IS")
            ),
            choice(
              token("STANDARD-1"),
              literal(),
              name()
            )
          )
        );
      }
    
      return recordDelimiterClauseParser;
    }
    
    // ========================================================
    // reserveClause
    // ........................................................
    
    private ParserCombinator reserveClauseParser = null;
    
    public final Start reserveClause = Start.on(getNamespace(), "reserveClause");
    
    public ParserCombinator reserveClause() {
      if (reserveClauseParser == null) {
        FutureParser future = scoped("reserveClause", PUBLIC, true);
        reserveClauseParser = future;
        future.setParser(
          sequence(
            token("RESERVE"),
            choice(
              integer(),
              token("NO")
            ),
            optional(
              token("ALTERNATE")
            ),
            optional(
              choice(
                token("AREA"),
                token("AREAS")
              )
            )
          )
        );
      }
    
      return reserveClauseParser;
    }
    
    // ========================================================
    // organizationClause
    // ........................................................
    
    private ParserCombinator organizationClauseParser = null;
    
    public final Start organizationClause = Start.on(getNamespace(), "organizationClause");
    
    public ParserCombinator organizationClause() {
      if (organizationClauseParser == null) {
        FutureParser future = scoped("organizationClause", PUBLIC, true);
        organizationClauseParser = future;
        future.setParser(
          sequence(
            optional(
              sequence(
                token("ORGANIZATION"),
                optional(
                  token("IS")
                )
              )
            ),
            optional(
              choice(
                token("LINE"),
                sequence(
                  token("RECORD"),
                  token("BINARY")
                ),
                token("RECORD"),
                token("BINARY")
              )
            ),
            choice(
              token("SEQUENTIAL"),
              token("RELATIVE"),
              token("INDEXED")
            )
          )
        );
      }
    
      return organizationClauseParser;
    }
    
    // ========================================================
    // accessModeClause
    // ........................................................
    
    private ParserCombinator accessModeClauseParser = null;
    
    public final Start accessModeClause = Start.on(getNamespace(), "accessModeClause");
    
    public ParserCombinator accessModeClause() {
      if (accessModeClauseParser == null) {
        FutureParser future = scoped("accessModeClause", PUBLIC, true);
        accessModeClauseParser = future;
        future.setParser(
          sequence(
            token("ACCESS"),
            optional(
              token("MODE")
            ),
            optional(
              token("IS")
            ),
            choice(
              token("SEQUENTIAL"),
              token("RANDOM"),
              token("DYNAMIC"),
              token("EXCLUSIVE"),
              sequence(
                token("MANUAL"),
                optional(
                  lockModeWithClause()
                )
              ),
              sequence(
                token("AUTOMATIC"),
                optional(
                  lockModeWithClause()
                )
              )
            )
          )
        );
      }
    
      return accessModeClauseParser;
    }
    
    // ========================================================
    // lockModeClause
    // ........................................................
    
    private ParserCombinator lockModeClauseParser = null;
    
    public final Start lockModeClause = Start.on(getNamespace(), "lockModeClause");
    
    public ParserCombinator lockModeClause() {
      if (lockModeClauseParser == null) {
        FutureParser future = scoped("lockModeClause", PUBLIC, true);
        lockModeClauseParser = future;
        future.setParser(
          sequence(
            token("LOCK"),
            optional(
              token("MODE")
            ),
            optional(
              token("IS")
            ),
            choice(
              token("EXCLUSIVE"),
              sequence(
                token("MANUAL"),
                optional(
                  lockModeWithClause()
                )
              ),
              sequence(
                token("AUTOMATIC"),
                optional(
                  lockModeWithClause()
                )
              )
            )
          )
        );
      }
    
      return lockModeClauseParser;
    }
    
    // ========================================================
    // lockModeWithClause
    // ........................................................
    
    private ParserCombinator lockModeWithClauseParser = null;
    
    public final Start lockModeWithClause = Start.on(getNamespace(), "lockModeWithClause");
    
    public ParserCombinator lockModeWithClause() {
      if (lockModeWithClauseParser == null) {
        FutureParser future = scoped("lockModeWithClause", PUBLIC, true);
        lockModeWithClauseParser = future;
        future.setParser(
          sequence(
            optional(
              token("WITH")
            ),
            choice(
              token("ROLLBACK"),
              sequence(
                token("LOCK"),
                token("ON"),
                optional(
                  token("MULTIPLE")
                ),
                choice(
                  token("RECORD"),
                  token("RECORDS")
                )
              )
            )
          )
        );
      }
    
      return lockModeWithClauseParser;
    }
    
    // ========================================================
    // relativeKeyClause
    // ........................................................
    
    private ParserCombinator relativeKeyClauseParser = null;
    
    public final Start relativeKeyClause = Start.on(getNamespace(), "relativeKeyClause");
    
    public ParserCombinator relativeKeyClause() {
      if (relativeKeyClauseParser == null) {
        FutureParser future = scoped("relativeKeyClause", PUBLIC, true);
        relativeKeyClauseParser = future;
        future.setParser(
          sequence(
            token("RELATIVE"),
            optional(
              token("KEY")
            ),
            optional(
              token("IS")
            ),
            recordKeyDefinition()
          )
        );
      }
    
      return relativeKeyClauseParser;
    }
    
    // ========================================================
    // recordKeyClause
    // ........................................................
    
    private ParserCombinator recordKeyClauseParser = null;
    
    public final Start recordKeyClause = Start.on(getNamespace(), "recordKeyClause");
    
    public ParserCombinator recordKeyClause() {
      if (recordKeyClauseParser == null) {
        FutureParser future = scoped("recordKeyClause", PUBLIC, true);
        recordKeyClauseParser = future;
        future.setParser(
          sequence(
            token("RECORD"),
            optional(
              token("KEY")
            ),
            optional(
              token("IS")
            ),
            recordKeyDefinition(),
            optional(
              passwordClause()
            )
          )
        );
      }
    
      return recordKeyClauseParser;
    }
    
    // ========================================================
    // alternateRecordKeyClause
    // ........................................................
    
    private ParserCombinator alternateRecordKeyClauseParser = null;
    
    public final Start alternateRecordKeyClause = Start.on(getNamespace(), "alternateRecordKeyClause");
    
    public ParserCombinator alternateRecordKeyClause() {
      if (alternateRecordKeyClauseParser == null) {
        FutureParser future = scoped("alternateRecordKeyClause", PUBLIC, true);
        alternateRecordKeyClauseParser = future;
        future.setParser(
          sequence(
            token("ALTERNATE"),
            optional(
              token("RECORD")
            ),
            optional(
              token("KEY")
            ),
            optional(
              token("IS")
            ),
            recordKeyDefinition(),
            optional(
              permuted(
                passwordClause(),
                suppressClause(),
                sequence(
                  optional(
                    token("WITH")
                  ),
                  token("DUPLICATES")
                )
              )
            )
          )
        );
      }
    
      return alternateRecordKeyClauseParser;
    }
    
    // ========================================================
    // recordKeyDefinition
    // ........................................................
    
    private ParserCombinator recordKeyDefinitionParser = null;
    
    public final Start recordKeyDefinition = Start.on(getNamespace(), "recordKeyDefinition");
    
    public ParserCombinator recordKeyDefinition() {
      if (recordKeyDefinitionParser == null) {
        FutureParser future = scoped("recordKeyDefinition", PUBLIC, true);
        recordKeyDefinitionParser = future;
        future.setParser(
          choice(
            sequence(
              choice(
                literal(),
                identifier()
              ),
              choice(
                literal("="),
                sequence(
                  token("SOURCE"),
                  optional(
                    token("IS")
                  )
                )
              ),
              plus(
                dataName()
              )
            ),
            dataName()
          )
        );
      }
    
      return recordKeyDefinitionParser;
    }
    
    // ========================================================
    // fileStatusClause
    // ........................................................
    
    private ParserCombinator fileStatusClauseParser = null;
    
    public final Start fileStatusClause = Start.on(getNamespace(), "fileStatusClause");
    
    public ParserCombinator fileStatusClause() {
      if (fileStatusClauseParser == null) {
        FutureParser future = scoped("fileStatusClause", PUBLIC, true);
        fileStatusClauseParser = future;
        future.setParser(
          sequence(
            optional(
              token("FILE")
            ),
            token("STATUS"),
            optional(
              token("IS")
            ),
            qualifiedDataName()
          )
        );
      }
    
      return fileStatusClauseParser;
    }
    
    // ========================================================
    // sortStatusClause
    // ........................................................
    
    private ParserCombinator sortStatusClauseParser = null;
    
    public final Start sortStatusClause = Start.on(getNamespace(), "sortStatusClause");
    
    public ParserCombinator sortStatusClause() {
      if (sortStatusClauseParser == null) {
        FutureParser future = scoped("sortStatusClause", PUBLIC, true);
        sortStatusClauseParser = future;
        future.setParser(
          sequence(
            token("SORT"),
            token("STATUS"),
            optional(
              token("IS")
            ),
            qualifiedDataName()
          )
        );
      }
    
      return sortStatusClauseParser;
    }
    
    // ========================================================
    // passwordClause
    // ........................................................
    
    private ParserCombinator passwordClauseParser = null;
    
    public final Start passwordClause = Start.on(getNamespace(), "passwordClause");
    
    public ParserCombinator passwordClause() {
      if (passwordClauseParser == null) {
        FutureParser future = scoped("passwordClause", PUBLIC, true);
        passwordClauseParser = future;
        future.setParser(
          sequence(
            token("PASSWORD"),
            optional(
              token("IS")
            ),
            dataName()
          )
        );
      }
    
      return passwordClauseParser;
    }
    
    // ========================================================
    // suppressClause
    // ........................................................
    
    private ParserCombinator suppressClauseParser = null;
    
    public final Start suppressClause = Start.on(getNamespace(), "suppressClause");
    
    public ParserCombinator suppressClause() {
      if (suppressClauseParser == null) {
        FutureParser future = scoped("suppressClause", PUBLIC, true);
        suppressClauseParser = future;
        future.setParser(
          sequence(
            token("SUPPRESS"),
            optional(
              token("WHEN")
            ),
            choice(
              zero(),
              space(),
              sequence(
                optional(
                  token("ALL")
                ),
                literal()
              )
            )
          )
        );
      }
    
      return suppressClauseParser;
    }
    
    // ========================================================
    // sharingClause
    // ........................................................
    
    private ParserCombinator sharingClauseParser = null;
    
    public final Start sharingClause = Start.on(getNamespace(), "sharingClause");
    
    public ParserCombinator sharingClause() {
      if (sharingClauseParser == null) {
        FutureParser future = scoped("sharingClause", PUBLIC, true);
        sharingClauseParser = future;
        future.setParser(
          sequence(
            token("SHARING"),
            optional(
              token("WITH")
            ),
            choice(
              sequence(
                token("READ"),
                token("ONLY")
              ),
              sequence(
                choice(
                  token("ALL"),
                  token("NO")
                ),
                optional(
                  token("OTHER")
                )
              )
            )
          )
        );
      }
    
      return sharingClauseParser;
    }
    
    // ========================================================
    // paddingClause
    // ........................................................
    
    private ParserCombinator paddingClauseParser = null;
    
    public final Start paddingClause = Start.on(getNamespace(), "paddingClause");
    
    public ParserCombinator paddingClause() {
      if (paddingClauseParser == null) {
        FutureParser future = scoped("paddingClause", PUBLIC, true);
        paddingClauseParser = future;
        future.setParser(
          sequence(
            token("PADDING"),
            optional(
              token("CHARACTER")
            ),
            optional(
              token("IS")
            ),
            choice(
              literal(),
              identifier()
            )
          )
        );
      }
    
      return paddingClauseParser;
    }
    
    // ========================================================
    // ioControlParagraph
    // ........................................................
    
    private ParserCombinator ioControlParagraphParser = null;
    
    public final Start ioControlParagraph = Start.on(getNamespace(), "ioControlParagraph");
    
    public ParserCombinator ioControlParagraph() {
      if (ioControlParagraphParser == null) {
        FutureParser future = scoped("ioControlParagraph", PUBLIC, true);
        ioControlParagraphParser = future;
        future.setParser(
          sequence(
            token("I-O-CONTROL"),
            literal("."),
            optional(
              skipto(
                choice(
                  paragraphStart(),
                  sectionStart(),
                  divisionStart()
                )
              )
            )
          )
        );
      }
    
      return ioControlParagraphParser;
    }
    
    // ========================================================
    // objectSection
    // ........................................................
    
    private ParserCombinator objectSectionParser = null;
    
    public final Start objectSection = Start.on(getNamespace(), "objectSection");
    
    public ParserCombinator objectSection() {
      if (objectSectionParser == null) {
        FutureParser future = scoped("objectSection", PUBLIC, true);
        objectSectionParser = future;
        future.setParser(
          choice(
            sequence(
              token("OBJECT"),
              token("SECTION"),
              literal("."),
              optional(
                objectSectionBody()
              )
            ),
            objectSectionBody()
          )
        );
      }
    
      return objectSectionParser;
    }
    
    // ========================================================
    // objectSectionBody
    // ........................................................
    
    private ParserCombinator objectSectionBodyParser = null;
    
    public final Start objectSectionBody = Start.on(getNamespace(), "objectSectionBody");
    
    public ParserCombinator objectSectionBody() {
      if (objectSectionBodyParser == null) {
        FutureParser future = scoped("objectSectionBody", PUBLIC, true);
        objectSectionBodyParser = future;
        future.setParser(
          plus(
            choice(
              classControlParagraph(),
              copyStatement()
            )
          )
        );
      }
    
      return objectSectionBodyParser;
    }
    
    // ========================================================
    // classControlParagraph
    // ........................................................
    
    private ParserCombinator classControlParagraphParser = null;
    
    public final Start classControlParagraph = Start.on(getNamespace(), "classControlParagraph");
    
    public ParserCombinator classControlParagraph() {
      if (classControlParagraphParser == null) {
        FutureParser future = scoped("classControlParagraph", PUBLIC, true);
        classControlParagraphParser = future;
        future.setParser(
          sequence(
            token("CLASS-CONTROL"),
            literal("."),
            plus(
              choice(
                sequence(
                  className(),
                  token("IS"),
                  token("CLASS"),
                  literal()
                ),
                copyStatement()
              )
            ),
            optional(
              literal(".")
            )
          )
        );
      }
    
      return classControlParagraphParser;
    }
    
    // ========================================================
    // dataDivision
    // ........................................................
    
    private ParserCombinator dataDivisionParser = null;
    
    public final Start dataDivision = Start.on(getNamespace(), "dataDivision");
    
    public ParserCombinator dataDivision() {
      if (dataDivisionParser == null) {
        FutureParser future = scoped("dataDivision", PUBLIC, true);
        dataDivisionParser = future;
        future.setParser(
          choice(
            sequence(
              token("DATA"),
              token("DIVISION"),
              literal("."),
              optional(
                dataDivisionBody()
              )
            ),
            dataDivisionBody()
          )
        );
      }
    
      return dataDivisionParser;
    }
    
    // ========================================================
    // dataDivisionBody
    // ........................................................
    
    private ParserCombinator dataDivisionBodyParser = null;
    
    public final Start dataDivisionBody = Start.on(getNamespace(), "dataDivisionBody");
    
    public ParserCombinator dataDivisionBody() {
      if (dataDivisionBodyParser == null) {
        FutureParser future = scoped("dataDivisionBody", PUBLIC, true);
        dataDivisionBodyParser = future;
        future.setParser(
          plus(
            choice(
              fileSection(),
              workingStorageSection(),
              threadLocalStorageSection(),
              objectStorageSection(),
              localStorageSection(),
              linkageSection(),
              communicationSection(),
              reportSection(),
              screenSection(),
              copyStatement()
            )
          )
        );
      }
    
      return dataDivisionBodyParser;
    }
    
    // ========================================================
    // fileSection
    // ........................................................
    
    private ParserCombinator fileSectionParser = null;
    
    public final Start fileSection = Start.on(getNamespace(), "fileSection");
    
    public ParserCombinator fileSection() {
      if (fileSectionParser == null) {
        FutureParser future = scoped("fileSection", PUBLIC, true);
        fileSectionParser = future;
        future.setParser(
          sequence(
            choice(
              sequence(
                token("FILE"),
                token("SECTION"),
                literal("."),
                optional(
                  fileSectionContents()
                )
              ),
              fileSectionContents()
            ),
            optional(
              skipto(
                choice(
                  paragraphStart(),
                  sectionStart(),
                  divisionStart()
                )
              )
            )
          )
        );
      }
    
      return fileSectionParser;
    }
    
    // ========================================================
    // fileSectionContents
    // ........................................................
    
    private ParserCombinator fileSectionContentsParser = null;
    
    protected final Start fileSectionContents = Start.on(getNamespace(), "fileSectionContents");
    
    protected ParserCombinator fileSectionContents() {
      if (fileSectionContentsParser == null) {
        FutureParser future = scoped("fileSectionContents", PRIVATE, true);
        fileSectionContentsParser = future;
        future.setParser(
          plus(
            choice(
              copyStatement(),
              sequence(
                fileDescriptionEntry(),
                star(
                  recordDescriptionEntry()
                )
              )
            )
          )
        );
      }
    
      return fileSectionContentsParser;
    }
    
    // ========================================================
    // fileDescriptionEntry
    // ........................................................
    
    private ParserCombinator fileDescriptionEntryParser = null;
    
    public final Start fileDescriptionEntry = Start.on(getNamespace(), "fileDescriptionEntry");
    
    public ParserCombinator fileDescriptionEntry() {
      if (fileDescriptionEntryParser == null) {
        FutureParser future = scoped("fileDescriptionEntry", PUBLIC, true);
        fileDescriptionEntryParser = future;
        future.setParser(
          choice(
            fdFileDescriptionEntry(),
            sdFileDescriptionEntry()
          )
        );
      }
    
      return fileDescriptionEntryParser;
    }
    
    // ========================================================
    // fdFileDescriptionEntry
    // ........................................................
    
    private ParserCombinator fdFileDescriptionEntryParser = null;
    
    public final Start fdFileDescriptionEntry = Start.on(getNamespace(), "fdFileDescriptionEntry");
    
    public ParserCombinator fdFileDescriptionEntry() {
      if (fdFileDescriptionEntryParser == null) {
        FutureParser future = scoped("fdFileDescriptionEntry", PUBLIC, true);
        fdFileDescriptionEntryParser = future;
        future.setParser(
          sequence(
            token("FD"),
            fileName(),
            optional(
              permuted(
                externalClause(),
                globalClause(),
                formatClause(),
                blockContainsClause(),
                recordClause(),
                linageClause(),
                codeSetClause(),
                reportClause(),
                dataRecords(),
                labelRecords(),
                recordingMode(),
                threadLocalClause(),
                valueOfFileId(),
                valueOf()
              )
            ),
            skipto(
              literal(".")
            ),
            literal(".")
          )
        );
      }
    
      return fdFileDescriptionEntryParser;
    }
    
    // ========================================================
    // sdFileDescriptionEntry
    // ........................................................
    
    private ParserCombinator sdFileDescriptionEntryParser = null;
    
    public final Start sdFileDescriptionEntry = Start.on(getNamespace(), "sdFileDescriptionEntry");
    
    public ParserCombinator sdFileDescriptionEntry() {
      if (sdFileDescriptionEntryParser == null) {
        FutureParser future = scoped("sdFileDescriptionEntry", PUBLIC, true);
        sdFileDescriptionEntryParser = future;
        future.setParser(
          sequence(
            token("SD"),
            fileName(),
            optional(
              permuted(
                recordClause(),
                blockContainsClause(),
                dataRecords(),
                labelRecords(),
                recordingMode(),
                valueOfFileId()
              )
            ),
            skipto(
              literal(".")
            ),
            literal(".")
          )
        );
      }
    
      return sdFileDescriptionEntryParser;
    }
    
    // ========================================================
    // workingStorageSection
    // ........................................................
    
    private ParserCombinator workingStorageSectionParser = null;
    
    public final Start workingStorageSection = Start.on(getNamespace(), "workingStorageSection");
    
    public ParserCombinator workingStorageSection() {
      if (workingStorageSectionParser == null) {
        FutureParser future = scoped("workingStorageSection", PUBLIC, true);
        workingStorageSectionParser = future;
        future.setParser(
          sequence(
            token("WORKING-STORAGE"),
            token("SECTION"),
            literal("."),
            star(
              choice(
                recordDescriptionEntry(),
                replaceStatement(),
                sequence(
                  execStatement(),
                  optional(
                    literal(".")
                  )
                )
              )
            )
          )
        );
      }
    
      return workingStorageSectionParser;
    }
    
    // ========================================================
    // threadLocalStorageSection
    // ........................................................
    
    private ParserCombinator threadLocalStorageSectionParser = null;
    
    public final Start threadLocalStorageSection = Start.on(getNamespace(), "threadLocalStorageSection");
    
    public ParserCombinator threadLocalStorageSection() {
      if (threadLocalStorageSectionParser == null) {
        FutureParser future = scoped("threadLocalStorageSection", PUBLIC, true);
        threadLocalStorageSectionParser = future;
        future.setParser(
          sequence(
            token("THREAD-LOCAL-STORAGE"),
            token("SECTION"),
            literal("."),
            star(
              choice(
                recordDescriptionEntry(),
                replaceStatement(),
                sequence(
                  execStatement(),
                  optional(
                    literal(".")
                  )
                )
              )
            )
          )
        );
      }
    
      return threadLocalStorageSectionParser;
    }
    
    // ========================================================
    // objectStorageSection
    // ........................................................
    
    private ParserCombinator objectStorageSectionParser = null;
    
    public final Start objectStorageSection = Start.on(getNamespace(), "objectStorageSection");
    
    public ParserCombinator objectStorageSection() {
      if (objectStorageSectionParser == null) {
        FutureParser future = scoped("objectStorageSection", PUBLIC, true);
        objectStorageSectionParser = future;
        future.setParser(
          sequence(
            token("OBJECT-STORAGE"),
            token("SECTION"),
            literal("."),
            star(
              choice(
                recordDescriptionEntry(),
                replaceStatement(),
                sequence(
                  execStatement(),
                  optional(
                    literal(".")
                  )
                )
              )
            )
          )
        );
      }
    
      return objectStorageSectionParser;
    }
    
    // ========================================================
    // localStorageSection
    // ........................................................
    
    private ParserCombinator localStorageSectionParser = null;
    
    public final Start localStorageSection = Start.on(getNamespace(), "localStorageSection");
    
    public ParserCombinator localStorageSection() {
      if (localStorageSectionParser == null) {
        FutureParser future = scoped("localStorageSection", PUBLIC, true);
        localStorageSectionParser = future;
        future.setParser(
          sequence(
            token("LOCAL-STORAGE"),
            token("SECTION"),
            literal("."),
            star(
              choice(
                recordDescriptionEntry(),
                replaceStatement(),
                sequence(
                  execStatement(),
                  optional(
                    literal(".")
                  )
                )
              )
            )
          )
        );
      }
    
      return localStorageSectionParser;
    }
    
    // ========================================================
    // linkageSection
    // ........................................................
    
    private ParserCombinator linkageSectionParser = null;
    
    public final Start linkageSection = Start.on(getNamespace(), "linkageSection");
    
    public ParserCombinator linkageSection() {
      if (linkageSectionParser == null) {
        FutureParser future = scoped("linkageSection", PUBLIC, true);
        linkageSectionParser = future;
        future.setParser(
          sequence(
            token("LINKAGE"),
            token("SECTION"),
            literal("."),
            star(
              choice(
                recordDescriptionEntry(),
                replaceStatement(),
                sequence(
                  execStatement(),
                  optional(
                    literal(".")
                  )
                )
              )
            )
          )
        );
      }
    
      return linkageSectionParser;
    }
    
    // ========================================================
    // communicationSection
    // ........................................................
    
    private ParserCombinator communicationSectionParser = null;
    
    public final Start communicationSection = Start.on(getNamespace(), "communicationSection");
    
    public ParserCombinator communicationSection() {
      if (communicationSectionParser == null) {
        FutureParser future = scoped("communicationSection", PUBLIC, true);
        communicationSectionParser = future;
        future.setParser(
          sequence(
            token("COMMUNICATION"),
            token("SECTION"),
            literal("."),
            star(
              choice(
                communicationDescriptionEntry(),
                recordDescriptionEntry()
              )
            )
          )
        );
      }
    
      return communicationSectionParser;
    }
    
    // ========================================================
    // communicationDescriptionEntry
    // ........................................................
    
    private ParserCombinator communicationDescriptionEntryParser = null;
    
    public final Start communicationDescriptionEntry = Start.on(getNamespace(), "communicationDescriptionEntry");
    
    public ParserCombinator communicationDescriptionEntry() {
      if (communicationDescriptionEntryParser == null) {
        FutureParser future = scoped("communicationDescriptionEntry", PUBLIC, true);
        communicationDescriptionEntryParser = future;
        future.setParser(
          choice(
            communicationDescriptionEntry_format1(),
            communicationDescriptionEntry_format2(),
            communicationDescriptionEntry_format3()
          )
        );
      }
    
      return communicationDescriptionEntryParser;
    }
    
    // ========================================================
    // communicationDescriptionEntry_format1
    // ........................................................
    
    private ParserCombinator communicationDescriptionEntry_format1Parser = null;
    
    public final Start communicationDescriptionEntry_format1 = Start.on(getNamespace(), "communicationDescriptionEntry_format1");
    
    public ParserCombinator communicationDescriptionEntry_format1() {
      if (communicationDescriptionEntry_format1Parser == null) {
        FutureParser future = scoped("communicationDescriptionEntry_format1", PUBLIC, true);
        communicationDescriptionEntry_format1Parser = future;
        future.setParser(
          sequence(
            token("CD"),
            cdName(),
            optional(
              token("FOR")
            ),
            optional(
              token("INITIAL")
            ),
            token("INPUT"),
            optional(
              choice(
                permuted(
                  sequence(
                    optional(
                      token("SYMBOLIC")
                    ),
                    token("QUEUE"),
                    optional(
                      token("IS")
                    ),
                    dataName()
                  ),
                  sequence(
                    optional(
                      token("SYMBOLIC")
                    ),
                    token("SUB-QUEUE-1"),
                    optional(
                      token("IS")
                    ),
                    dataName()
                  ),
                  sequence(
                    optional(
                      token("SYMBOLIC")
                    ),
                    token("SUB-QUEUE-2"),
                    optional(
                      token("IS")
                    ),
                    dataName()
                  ),
                  sequence(
                    optional(
                      token("SYMBOLIC")
                    ),
                    token("SUB-QUEUE-3"),
                    optional(
                      token("IS")
                    ),
                    dataName()
                  ),
                  sequence(
                    token("MESSAGE"),
                    token("DATE"),
                    optional(
                      token("IS")
                    ),
                    dataName()
                  ),
                  sequence(
                    token("MESSAGE"),
                    token("TIME"),
                    optional(
                      token("IS")
                    ),
                    dataName()
                  ),
                  sequence(
                    optional(
                      token("SYMBOLIC")
                    ),
                    token("SOURCE"),
                    optional(
                      token("IS")
                    ),
                    dataName()
                  ),
                  sequence(
                    token("TEXT"),
                    token("LENGTH"),
                    optional(
                      token("IS")
                    ),
                    dataName()
                  ),
                  sequence(
                    token("END"),
                    token("KEY"),
                    optional(
                      token("IS")
                    ),
                    dataName()
                  ),
                  sequence(
                    token("STATUS"),
                    token("KEY"),
                    optional(
                      token("IS")
                    ),
                    dataName()
                  ),
                  sequence(
                    optional(
                      token("MESSAGE")
                    ),
                    token("COUNT"),
                    optional(
                      token("IS")
                    ),
                    dataName()
                  )
                ),
                plus(
                  choice(
                    token("FILLER"),
                    dataName()
                  )
                )
              )
            ),
            literal(".")
          )
        );
      }
    
      return communicationDescriptionEntry_format1Parser;
    }
    
    // ========================================================
    // communicationDescriptionEntry_format2
    // ........................................................
    
    private ParserCombinator communicationDescriptionEntry_format2Parser = null;
    
    public final Start communicationDescriptionEntry_format2 = Start.on(getNamespace(), "communicationDescriptionEntry_format2");
    
    public ParserCombinator communicationDescriptionEntry_format2() {
      if (communicationDescriptionEntry_format2Parser == null) {
        FutureParser future = scoped("communicationDescriptionEntry_format2", PUBLIC, true);
        communicationDescriptionEntry_format2Parser = future;
        future.setParser(
          sequence(
            token("CD"),
            cdName(),
            optional(
              token("FOR")
            ),
            token("OUTPUT"),
            optional(
              sequence(
                token("DESTINATION"),
                token("COUNT"),
                optional(
                  token("IS")
                ),
                dataName()
              )
            ),
            optional(
              sequence(
                token("TEXT"),
                token("LENGTH"),
                optional(
                  token("IS")
                ),
                dataName()
              )
            ),
            optional(
              sequence(
                token("STATUS"),
                token("KEY"),
                optional(
                  token("IS")
                ),
                dataName()
              )
            ),
            optional(
              sequence(
                token("DESTINATION"),
                token("TABLE"),
                token("OCCURS"),
                integer(),
                optional(
                  token("TIMES")
                ),
                optional(
                  sequence(
                    token("INDEXED"),
                    optional(
                      token("BY")
                    ),
                    plus(
                      indexName()
                    )
                  )
                )
              )
            ),
            optional(
              sequence(
                token("ERROR"),
                token("KEY"),
                optional(
                  token("IS")
                ),
                dataName()
              )
            ),
            optional(
              sequence(
                optional(
                  token("SYMBOLIC")
                ),
                token("DESTINATION"),
                optional(
                  token("IS")
                ),
                dataName()
              )
            ),
            literal(".")
          )
        );
      }
    
      return communicationDescriptionEntry_format2Parser;
    }
    
    // ========================================================
    // communicationDescriptionEntry_format3
    // ........................................................
    
    private ParserCombinator communicationDescriptionEntry_format3Parser = null;
    
    public final Start communicationDescriptionEntry_format3 = Start.on(getNamespace(), "communicationDescriptionEntry_format3");
    
    public ParserCombinator communicationDescriptionEntry_format3() {
      if (communicationDescriptionEntry_format3Parser == null) {
        FutureParser future = scoped("communicationDescriptionEntry_format3", PUBLIC, true);
        communicationDescriptionEntry_format3Parser = future;
        future.setParser(
          sequence(
            token("CD"),
            cdName(),
            optional(
              token("FOR")
            ),
            optional(
              token("INITIAL")
            ),
            token("I-O"),
            choice(
              plus(
                choice(
                  token("FILLER"),
                  dataName()
                )
              ),
              optional(
                permuted(
                  sequence(
                    token("MESSAGE"),
                    token("DATE"),
                    optional(
                      token("IS")
                    ),
                    dataName()
                  ),
                  sequence(
                    token("MESSAGE"),
                    token("TIME"),
                    optional(
                      token("IS")
                    ),
                    dataName()
                  ),
                  sequence(
                    optional(
                      token("SYMBOLIC")
                    ),
                    token("TERMINAL"),
                    optional(
                      token("IS")
                    ),
                    dataName()
                  ),
                  sequence(
                    token("TEXT"),
                    token("LENGTH"),
                    optional(
                      token("IS")
                    ),
                    dataName()
                  ),
                  sequence(
                    token("END"),
                    token("KEY"),
                    optional(
                      token("IS")
                    ),
                    dataName()
                  ),
                  sequence(
                    token("STATUS"),
                    token("KEY"),
                    optional(
                      token("IS")
                    ),
                    dataName()
                  )
                )
              )
            ),
            literal(".")
          )
        );
      }
    
      return communicationDescriptionEntry_format3Parser;
    }
    
    // ========================================================
    // reportSection
    // ........................................................
    
    private ParserCombinator reportSectionParser = null;
    
    public final Start reportSection = Start.on(getNamespace(), "reportSection");
    
    public ParserCombinator reportSection() {
      if (reportSectionParser == null) {
        FutureParser future = scoped("reportSection", PUBLIC, true);
        reportSectionParser = future;
        future.setParser(
          sequence(
            token("REPORT"),
            token("SECTION"),
            literal("."),
            star(
              sequence(
                reportDescriptionEntry(),
                plus(
                  reportGroupDescriptionEntry()
                )
              )
            )
          )
        );
      }
    
      return reportSectionParser;
    }
    
    // ========================================================
    // reportDescriptionEntry
    // ........................................................
    
    private ParserCombinator reportDescriptionEntryParser = null;
    
    public final Start reportDescriptionEntry = Start.on(getNamespace(), "reportDescriptionEntry");
    
    public ParserCombinator reportDescriptionEntry() {
      if (reportDescriptionEntryParser == null) {
        FutureParser future = scoped("reportDescriptionEntry", PUBLIC, true);
        reportDescriptionEntryParser = future;
        future.setParser(
          sequence(
            token("RD"),
            reportName(),
            optional(
              permuted(
                globalClause(),
                codeClause(),
                controlClause(),
                pageClause()
              )
            ),
            literal(".")
          )
        );
      }
    
      return reportDescriptionEntryParser;
    }
    
    // ========================================================
    // reportGroupDescriptionEntry
    // ........................................................
    
    private ParserCombinator reportGroupDescriptionEntryParser = null;
    
    public final Start reportGroupDescriptionEntry = Start.on(getNamespace(), "reportGroupDescriptionEntry");
    
    public ParserCombinator reportGroupDescriptionEntry() {
      if (reportGroupDescriptionEntryParser == null) {
        FutureParser future = scoped("reportGroupDescriptionEntry", PUBLIC, true);
        reportGroupDescriptionEntryParser = future;
        future.setParser(
          sequence(
            levelNumber(),
            optional(
              dataName()
            ),
            optional(
              permuted(
                lineClause(),
                nextGroupClause(),
                reportGroupTypeClause(),
                reportGroupUsageClause(),
                pictureClause(),
                signClause(),
                justifiedClause(),
                blankWhenZeroClause(),
                columnClause(),
                sourceClause(),
                reportSectionValueClause(),
                sumClause(),
                presentWhenClause(),
                groupIndicateClause(),
                occursClause(),
                varyingClause()
              )
            ),
            literal(".")
          )
        );
      }
    
      return reportGroupDescriptionEntryParser;
    }
    
    // ========================================================
    // screenSection
    // ........................................................
    
    private ParserCombinator screenSectionParser = null;
    
    public final Start screenSection = Start.on(getNamespace(), "screenSection");
    
    public ParserCombinator screenSection() {
      if (screenSectionParser == null) {
        FutureParser future = scoped("screenSection", PUBLIC, true);
        screenSectionParser = future;
        future.setParser(
          sequence(
            token("SCREEN"),
            token("SECTION"),
            literal("."),
            star(
              screenDescriptionEntry()
            ),
            optional(
              skipto(
                choice(
                  paragraphStart(),
                  sectionStart(),
                  divisionStart()
                )
              )
            )
          )
        );
      }
    
      return screenSectionParser;
    }
    
    // ========================================================
    // screenDescriptionEntry
    // ........................................................
    
    private ParserCombinator screenDescriptionEntryParser = null;
    
    public final Start screenDescriptionEntry = Start.on(getNamespace(), "screenDescriptionEntry");
    
    public ParserCombinator screenDescriptionEntry() {
      if (screenDescriptionEntryParser == null) {
        FutureParser future = scoped("screenDescriptionEntry", PUBLIC, true);
        screenDescriptionEntryParser = future;
        future.setParser(
          sequence(
            levelNumber(),
            optional(
              choice(
                token("FILLER"),
                screenName()
              )
            ),
            optional(
              permuted(
                globalClause(),
                lineClause(),
                columnClause(),
                blankClause(),
                bellClause(),
                blinkClause(),
                highlightClause(),
                reverseVideoClause(),
                underlineClause(),
                foregroundColorClause(),
                backgroundColorClause(),
                signClause(),
                fullClause(),
                autoClause(),
                secureClause(),
                requiredClause(),
                occursClause(),
                usageClause(),
                eraseClause(),
                pictureClause(),
                screenFromClause(),
                screenToClause(),
                screenUsingClause(),
                screenValueClause(),
                blankWhenZeroClause(),
                justifiedClause(),
                controlClause(),
                screenEntryPhrase()
              )
            ),
            literal(".")
          )
        );
      }
    
      return screenDescriptionEntryParser;
    }
    
    // ========================================================
    // recordDescriptionEntry
    // ........................................................
    
    private ParserCombinator recordDescriptionEntryParser = null;
    
    public final Start recordDescriptionEntry = Start.on(getNamespace(), "recordDescriptionEntry");
    
    public ParserCombinator recordDescriptionEntry() {
      if (recordDescriptionEntryParser == null) {
        FutureParser future = scoped("recordDescriptionEntry", PUBLIC, true);
        recordDescriptionEntryParser = future;
        future.setParser(
          choice(
            constantEntry(),
            dataDescriptionEntry(),
            copyStatement()
          )
        );
      }
    
      return recordDescriptionEntryParser;
    }
    
    // ========================================================
    // dataDescriptionEntry
    // ........................................................
    
    private ParserCombinator dataDescriptionEntryParser = null;
    
    public final Start dataDescriptionEntry = Start.on(getNamespace(), "dataDescriptionEntry");
    
    public ParserCombinator dataDescriptionEntry() {
      if (dataDescriptionEntryParser == null) {
        FutureParser future = scoped("dataDescriptionEntry", PUBLIC, true);
        dataDescriptionEntryParser = future;
        future.setParser(
          choice(
            dataDescriptionEntry_format3_and_4(),
            dataDescriptionEntry_format2(),
            dataDescriptionEntry_format1()
          )
        );
      }
    
      return dataDescriptionEntryParser;
    }
    
    // ========================================================
    // constantEntry
    // ........................................................
    
    private ParserCombinator constantEntryParser = null;
    
    public final Start constantEntry = Start.on(getNamespace(), "constantEntry");
    
    public ParserCombinator constantEntry() {
      if (constantEntryParser == null) {
        FutureParser future = scoped("constantEntry", PUBLIC, true);
        constantEntryParser = future;
        future.setParser(
          choice(
            constantEntry_level01(),
            constantEntry_level78()
          )
        );
      }
    
      return constantEntryParser;
    }
    
    // ========================================================
    // constantEntry_level01
    // ........................................................
    
    private ParserCombinator constantEntry_level01Parser = null;
    
    protected final Start constantEntry_level01 = Start.on(getNamespace(), "constantEntry_level01");
    
    protected ParserCombinator constantEntry_level01() {
      if (constantEntry_level01Parser == null) {
        FutureParser future = scoped("constantEntry_level01", PRIVATE, true);
        constantEntry_level01Parser = future;
        future.setParser(
          sequence(
            as("levelNumber",
              choice(
                token("1"),
                token("01")
              )
            ),
            as("entryName",
              choice(
                token("FILLER"),
                cobolWord()
              )
            ),
            token("CONSTANT"),
            optional(
              globalClause()
            ),
            choice(
              sequence(
                optional(
                  token("AS")
                ),
                identifier()
              ),
              sequence(
                token("FROM"),
                cobolWord()
              )
            ),
            literal(".")
          )
        );
      }
    
      return constantEntry_level01Parser;
    }
    
    // ========================================================
    // constantEntry_level78
    // ........................................................
    
    private ParserCombinator constantEntry_level78Parser = null;
    
    protected final Start constantEntry_level78 = Start.on(getNamespace(), "constantEntry_level78");
    
    protected ParserCombinator constantEntry_level78() {
      if (constantEntry_level78Parser == null) {
        FutureParser future = scoped("constantEntry_level78", PRIVATE, true);
        constantEntry_level78Parser = future;
        future.setParser(
          sequence(
            as("levelNumber",
              token("78")
            ),
            as("entryName",
              cobolWord()
            ),
            constantValueClause(),
            literal(".")
          )
        );
      }
    
      return constantEntry_level78Parser;
    }
    
    // ========================================================
    // dataDescriptionEntry_format1
    // ........................................................
    
    private ParserCombinator dataDescriptionEntry_format1Parser = null;
    
    protected final Start dataDescriptionEntry_format1 = Start.on(getNamespace(), "dataDescriptionEntry_format1");
    
    protected ParserCombinator dataDescriptionEntry_format1() {
      if (dataDescriptionEntry_format1Parser == null) {
        FutureParser future = scoped("dataDescriptionEntry_format1", PRIVATE, true);
        dataDescriptionEntry_format1Parser = future;
        future.setParser(
          sequence(
            levelNumber(),
            optional(
              as("entryName",
                choice(
                  token("FILLER"),
                  token("CURSOR"),
                  dataName()
                )
              )
            ),
            optional(
              permuted(
                redefinesClause(),
                typedefClause(),
                alignedClause(),
                anyLengthClause(),
                basedClause(),
                blankWhenZeroClause(),
                constantRecordClause(),
                externalClause(),
                globalClause(),
                groupUsageClause(),
                justifiedClause(),
                occursClause(),
                pictureClause(),
                propertyClause(),
                sameAsClause(),
                selectWhenClause(),
                signClause(),
                synchronizedClause(),
                typeNameTypeClause(),
                classClause(),
                defaultClause(),
                destinationClause(),
                plus(
                  invalidClause()
                ),
                presentWhenClause(),
                varyingClause(),
                validateStatusClause(),
                valueClause(),
                threadLocalClause(),
                dtLinePos(),
                columnClause(),
                autoClause(),
                backgroundColorClause(),
                bellClause(),
                blinkClause(),
                controlPhrase(),
                eraseClause(),
                fillPhrase(),
                foregroundColorClause(),
                fullClause(),
                gridPhrase(),
                highPhrase(),
                lowPhrase(),
                linePhrase(),
                promptPhrase(),
                requiredPhrase(),
                reversePhrase(),
                securePhrase(),
                sizePhrase(),
                sequence(
                  token("USING"),
                  identifier()
                ),
                sequence(
                  token("FROM"),
                  choice(
                    identifier(),
                    literal()
                  ),
                  optional(
                    sequence(
                      token("TO"),
                      identifier()
                    )
                  )
                ),
                token("PUBLIC"),
                token("PRIVATE"),
                token("PROTECTED"),
                token("INTERNAL"),
                attributeClause(),
                usageClause(),
                literal()
              )
            ),
            as("unknown",
              skipto(
                literal(".")
              )
            ),
            literal(".")
          )
        );
      }
    
      return dataDescriptionEntry_format1Parser;
    }
    
    // ========================================================
    // dataDescriptionEntry_format2
    // ........................................................
    
    private ParserCombinator dataDescriptionEntry_format2Parser = null;
    
    protected final Start dataDescriptionEntry_format2 = Start.on(getNamespace(), "dataDescriptionEntry_format2");
    
    protected ParserCombinator dataDescriptionEntry_format2() {
      if (dataDescriptionEntry_format2Parser == null) {
        FutureParser future = scoped("dataDescriptionEntry_format2", PRIVATE, true);
        dataDescriptionEntry_format2Parser = future;
        future.setParser(
          sequence(
            as("levelNumber",
              token("66")
            ),
            as("entryName",
              dataName()
            ),
            renamesClause(),
            literal(".")
          )
        );
      }
    
      return dataDescriptionEntry_format2Parser;
    }
    
    // ========================================================
    // dataDescriptionEntry_format3_and_4
    // ........................................................
    
    private ParserCombinator dataDescriptionEntry_format3_and_4Parser = null;
    
    protected final Start dataDescriptionEntry_format3_and_4 = Start.on(getNamespace(), "dataDescriptionEntry_format3_and_4");
    
    protected ParserCombinator dataDescriptionEntry_format3_and_4() {
      if (dataDescriptionEntry_format3_and_4Parser == null) {
        FutureParser future = scoped("dataDescriptionEntry_format3_and_4", PRIVATE, true);
        dataDescriptionEntry_format3_and_4Parser = future;
        future.setParser(
          sequence(
            as("levelNumber",
              token("88")
            ),
            choice(
              sequence(
                optional(
                  as("entryName",
                    sequence(
                      not(
                        choice(
                          token("VALUE"),
                          token("VALUES")
                        )
                      ),
                      conditionName()
                    )
                  )
                ),
                valueClause()
              ),
              as("unknown",
                skipto(
                  literal(".")
                )
              )
            ),
            literal(".")
          )
        );
      }
    
      return dataDescriptionEntry_format3_and_4Parser;
    }
    
    // ========================================================
    // dataRecords
    // ........................................................
    
    private ParserCombinator dataRecordsParser = null;
    
    public final Start dataRecords = Start.on(getNamespace(), "dataRecords");
    
    public ParserCombinator dataRecords() {
      if (dataRecordsParser == null) {
        FutureParser future = scoped("dataRecords", PUBLIC, true);
        dataRecordsParser = future;
        future.setParser(
          sequence(
            optional(
              token("DATA")
            ),
            choice(
              sequence(
                token("RECORD"),
                optional(
                  token("IS")
                )
              ),
              sequence(
                token("RECORDS"),
                optional(
                  token("ARE")
                )
              )
            ),
            plus(
              dataName()
            )
          )
        );
      }
    
      return dataRecordsParser;
    }
    
    // ========================================================
    // labelRecords
    // ........................................................
    
    private ParserCombinator labelRecordsParser = null;
    
    public final Start labelRecords = Start.on(getNamespace(), "labelRecords");
    
    public ParserCombinator labelRecords() {
      if (labelRecordsParser == null) {
        FutureParser future = scoped("labelRecords", PUBLIC, true);
        labelRecordsParser = future;
        future.setParser(
          sequence(
            token("LABEL"),
            choice(
              sequence(
                token("RECORD"),
                optional(
                  token("IS")
                )
              ),
              sequence(
                token("RECORDS"),
                optional(
                  token("ARE")
                )
              )
            ),
            choice(
              token("OMITTED"),
              token("STANDARD"),
              plus(
                dataName()
              )
            )
          )
        );
      }
    
      return labelRecordsParser;
    }
    
    // ========================================================
    // recordingMode
    // ........................................................
    
    private ParserCombinator recordingModeParser = null;
    
    public final Start recordingMode = Start.on(getNamespace(), "recordingMode");
    
    public ParserCombinator recordingMode() {
      if (recordingModeParser == null) {
        FutureParser future = scoped("recordingMode", PUBLIC, true);
        recordingModeParser = future;
        future.setParser(
          sequence(
            token("RECORDING"),
            optional(
              token("MODE")
            ),
            optional(
              token("IS")
            ),
            choice(
              token("F"),
              token("V"),
              token("U"),
              token("S"),
              token("FIXED"),
              token("VARIABLE")
            )
          )
        );
      }
    
      return recordingModeParser;
    }
    
    // ========================================================
    // valueOfFileId
    // ........................................................
    
    private ParserCombinator valueOfFileIdParser = null;
    
    public final Start valueOfFileId = Start.on(getNamespace(), "valueOfFileId");
    
    public ParserCombinator valueOfFileId() {
      if (valueOfFileIdParser == null) {
        FutureParser future = scoped("valueOfFileId", PUBLIC, true);
        valueOfFileIdParser = future;
        future.setParser(
          sequence(
            token("VALUE"),
            token("OF"),
            token("FILE-ID"),
            optional(
              token("IS")
            ),
            choice(
              dataName(),
              literal()
            )
          )
        );
      }
    
      return valueOfFileIdParser;
    }
    
    // ========================================================
    // valueOf
    // ........................................................
    
    private ParserCombinator valueOfParser = null;
    
    public final Start valueOf = Start.on(getNamespace(), "valueOf");
    
    public ParserCombinator valueOf() {
      if (valueOfParser == null) {
        FutureParser future = scoped("valueOf", PUBLIC, true);
        valueOfParser = future;
        future.setParser(
          sequence(
            token("VALUE"),
            token("OF"),
            plus(
              sequence(
                choice(
                  token("IDENTIFICATION"),
                  token("ID"),
                  cobolWord()
                ),
                optional(
                  token("IS")
                ),
                choice(
                  dataName(),
                  literal()
                )
              )
            )
          )
        );
      }
    
      return valueOfParser;
    }
    
    // ========================================================
    // cicsValue
    // ........................................................
    
    private ParserCombinator cicsValueParser = null;
    
    public final Start cicsValue = Start.on(getNamespace(), "cicsValue");
    
    public ParserCombinator cicsValue() {
      if (cicsValueParser == null) {
        FutureParser future = scoped("cicsValue", PUBLIC, true);
        cicsValueParser = future;
        future.setParser(
          sequence(
            choice(
              token("DFHVALUE"),
              token("DFHRESP")
            ),
            literal("("),
            cobolWord(),
            literal(")")
          )
        );
      }
    
      return cicsValueParser;
    }
    
    // ========================================================
    // whenSetToFalseClause
    // ........................................................
    
    private ParserCombinator whenSetToFalseClauseParser = null;
    
    public final Start whenSetToFalseClause = Start.on(getNamespace(), "whenSetToFalseClause");
    
    public ParserCombinator whenSetToFalseClause() {
      if (whenSetToFalseClauseParser == null) {
        FutureParser future = scoped("whenSetToFalseClause", PUBLIC, true);
        whenSetToFalseClauseParser = future;
        future.setParser(
          sequence(
            optional(
              token("WHEN")
            ),
            optional(
              token("SET")
            ),
            optional(
              token("TO")
            ),
            token("FALSE"),
            optional(
              token("IS")
            ),
            literal()
          )
        );
      }
    
      return whenSetToFalseClauseParser;
    }
    
    // ========================================================
    // blankWhenZero
    // ........................................................
    
    private ParserCombinator blankWhenZeroParser = null;
    
    public final Start blankWhenZero = Start.on(getNamespace(), "blankWhenZero");
    
    public ParserCombinator blankWhenZero() {
      if (blankWhenZeroParser == null) {
        FutureParser future = scoped("blankWhenZero", PUBLIC, true);
        blankWhenZeroParser = future;
        future.setParser(
          sequence(
            token("BLANK"),
            optional(
              token("WHEN")
            ),
            zero()
          )
        );
      }
    
      return blankWhenZeroParser;
    }
    
    // ========================================================
    // threadLocalClause
    // ........................................................
    
    private ParserCombinator threadLocalClauseParser = null;
    
    public final Start threadLocalClause = Start.on(getNamespace(), "threadLocalClause");
    
    public ParserCombinator threadLocalClause() {
      if (threadLocalClauseParser == null) {
        FutureParser future = scoped("threadLocalClause", PUBLIC, true);
        threadLocalClauseParser = future;
        future.setParser(
          sequence(
            optional(
              token("IS")
            ),
            token("THREAD-LOCAL")
          )
        );
      }
    
      return threadLocalClauseParser;
    }
    
    // ========================================================
    // zero
    // ........................................................
    
    private ParserCombinator zeroParser = null;
    
    public final Start zero = Start.on(getNamespace(), "zero");
    
    public ParserCombinator zero() {
      if (zeroParser == null) {
        FutureParser future = scoped("zero", PUBLIC, true);
        zeroParser = future;
        future.setParser(
          choice(
            token("ZERO"),
            token("ZEROS"),
            token("ZEROES")
          )
        );
      }
    
      return zeroParser;
    }
    
    // ========================================================
    // space
    // ........................................................
    
    private ParserCombinator spaceParser = null;
    
    public final Start space = Start.on(getNamespace(), "space");
    
    public ParserCombinator space() {
      if (spaceParser == null) {
        FutureParser future = scoped("space", PUBLIC, true);
        spaceParser = future;
        future.setParser(
          choice(
            token("SPACE"),
            token("SPACES")
          )
        );
      }
    
      return spaceParser;
    }
    
    // ========================================================
    // justified
    // ........................................................
    
    private ParserCombinator justifiedParser = null;
    
    public final Start justified = Start.on(getNamespace(), "justified");
    
    public ParserCombinator justified() {
      if (justifiedParser == null) {
        FutureParser future = scoped("justified", PUBLIC, true);
        justifiedParser = future;
        future.setParser(
          sequence(
            optional(
              token("OUTPUT")
            ),
            choice(
              token("JUSTIFIED"),
              token("JUST")
            ),
            optional(
              choice(
                token("LEFT"),
                token("RIGHT"),
                token("CENTERED")
              )
            )
          )
        );
      }
    
      return justifiedParser;
    }
    
    // ========================================================
    // valueClause
    // ........................................................
    
    private ParserCombinator valueClauseParser = null;
    
    public final Start valueClause = Start.on(getNamespace(), "valueClause");
    
    public ParserCombinator valueClause() {
      if (valueClauseParser == null) {
        FutureParser future = scoped("valueClause", PUBLIC, true);
        valueClauseParser = future;
        future.setParser(
          sequence(
            choice(
              sequence(
                token("VALUE"),
                optional(
                  token("IS")
                )
              ),
              sequence(
                token("VALUES"),
                optional(
                  token("ARE")
                )
              )
            ),
            choice(
              plus(
                sequence(
                  plus(
                    sequence(
                      not(
                        choice(
                          token("THROUGH"),
                          token("THRU")
                        )
                      ),
                      literal()
                    )
                  ),
                  token("FROM"),
                  literal("("),
                  plus(
                    subscript()
                  ),
                  literal(")"),
                  optional(
                    sequence(
                      token("TO"),
                      literal("("),
                      plus(
                        subscript()
                      ),
                      literal(")")
                    )
                  )
                )
              ),
              sequence(
                plus(
                  sequence(
                    choice(
                      cicsValue(),
                      sequence(
                        not(
                          token("FALSE")
                        ),
                        literal()
                      )
                    ),
                    optional(
                      sequence(
                        choice(
                          token("THROUGH"),
                          token("THRU")
                        ),
                        literal()
                      )
                    )
                  )
                ),
                optional(
                  sequence(
                    optional(
                      token("IN")
                    ),
                    not(
                      token("FALSE")
                    ),
                    alphabetName()
                  )
                ),
                optional(
                  sequence(
                    optional(
                      token("WHEN")
                    ),
                    optional(
                      token("SET")
                    ),
                    optional(
                      token("TO")
                    ),
                    token("FALSE"),
                    optional(
                      token("IS")
                    ),
                    literal()
                  )
                ),
                optional(
                  sequence(
                    optional(
                      choice(
                        token("IS"),
                        token("ARE")
                      )
                    ),
                    choice(
                      token("INVALID"),
                      token("VALID")
                    )
                  )
                ),
                optional(
                  sequence(
                    token("WHEN"),
                    condition()
                  )
                )
              ),
              constant()
            )
          )
        );
      }
    
      return valueClauseParser;
    }
    
    // ========================================================
    // alignedClause
    // ........................................................
    
    private ParserCombinator alignedClauseParser = null;
    
    public final Start alignedClause = Start.on(getNamespace(), "alignedClause");
    
    public ParserCombinator alignedClause() {
      if (alignedClauseParser == null) {
        FutureParser future = scoped("alignedClause", PUBLIC, true);
        alignedClauseParser = future;
        future.setParser(
          token("ALIGNED")
        );
      }
    
      return alignedClauseParser;
    }
    
    // ========================================================
    // anyLengthClause
    // ........................................................
    
    private ParserCombinator anyLengthClauseParser = null;
    
    public final Start anyLengthClause = Start.on(getNamespace(), "anyLengthClause");
    
    public ParserCombinator anyLengthClause() {
      if (anyLengthClauseParser == null) {
        FutureParser future = scoped("anyLengthClause", PUBLIC, true);
        anyLengthClauseParser = future;
        future.setParser(
          sequence(
            token("ANY"),
            token("LENGTH")
          )
        );
      }
    
      return anyLengthClauseParser;
    }
    
    // ========================================================
    // autoClause
    // ........................................................
    
    private ParserCombinator autoClauseParser = null;
    
    public final Start autoClause = Start.on(getNamespace(), "autoClause");
    
    public ParserCombinator autoClause() {
      if (autoClauseParser == null) {
        FutureParser future = scoped("autoClause", PUBLIC, true);
        autoClauseParser = future;
        future.setParser(
          choice(
            token("AUTO"),
            token("AUTO-SKIP")
          )
        );
      }
    
      return autoClauseParser;
    }
    
    // ========================================================
    // backgroundColorClause
    // ........................................................
    
    private ParserCombinator backgroundColorClauseParser = null;
    
    public final Start backgroundColorClause = Start.on(getNamespace(), "backgroundColorClause");
    
    public ParserCombinator backgroundColorClause() {
      if (backgroundColorClauseParser == null) {
        FutureParser future = scoped("backgroundColorClause", PUBLIC, true);
        backgroundColorClauseParser = future;
        future.setParser(
          sequence(
            choice(
              token("BACKGROUND-COLOR"),
              token("BACKGROUND-COLOUR")
            ),
            optional(
              token("IS")
            ),
            integer()
          )
        );
      }
    
      return backgroundColorClauseParser;
    }
    
    // ========================================================
    // basedClause
    // ........................................................
    
    private ParserCombinator basedClauseParser = null;
    
    public final Start basedClause = Start.on(getNamespace(), "basedClause");
    
    public ParserCombinator basedClause() {
      if (basedClauseParser == null) {
        FutureParser future = scoped("basedClause", PUBLIC, true);
        basedClauseParser = future;
        future.setParser(
          token("BASED")
        );
      }
    
      return basedClauseParser;
    }
    
    // ========================================================
    // bellClause
    // ........................................................
    
    private ParserCombinator bellClauseParser = null;
    
    public final Start bellClause = Start.on(getNamespace(), "bellClause");
    
    public ParserCombinator bellClause() {
      if (bellClauseParser == null) {
        FutureParser future = scoped("bellClause", PUBLIC, true);
        bellClauseParser = future;
        future.setParser(
          token("BELL")
        );
      }
    
      return bellClauseParser;
    }
    
    // ========================================================
    // blankClause
    // ........................................................
    
    private ParserCombinator blankClauseParser = null;
    
    public final Start blankClause = Start.on(getNamespace(), "blankClause");
    
    public ParserCombinator blankClause() {
      if (blankClauseParser == null) {
        FutureParser future = scoped("blankClause", PUBLIC, true);
        blankClauseParser = future;
        future.setParser(
          sequence(
            token("BLANK"),
            choice(
              token("SCREEN"),
              token("LINE")
            )
          )
        );
      }
    
      return blankClauseParser;
    }
    
    // ========================================================
    // blankWhenZeroClause
    // ........................................................
    
    private ParserCombinator blankWhenZeroClauseParser = null;
    
    public final Start blankWhenZeroClause = Start.on(getNamespace(), "blankWhenZeroClause");
    
    public ParserCombinator blankWhenZeroClause() {
      if (blankWhenZeroClauseParser == null) {
        FutureParser future = scoped("blankWhenZeroClause", PUBLIC, true);
        blankWhenZeroClauseParser = future;
        future.setParser(
          sequence(
            token("BLANK"),
            optional(
              token("WHEN")
            ),
            zero()
          )
        );
      }
    
      return blankWhenZeroClauseParser;
    }
    
    // ========================================================
    // blinkClause
    // ........................................................
    
    private ParserCombinator blinkClauseParser = null;
    
    public final Start blinkClause = Start.on(getNamespace(), "blinkClause");
    
    public ParserCombinator blinkClause() {
      if (blinkClauseParser == null) {
        FutureParser future = scoped("blinkClause", PUBLIC, true);
        blinkClauseParser = future;
        future.setParser(
          token("BLINK")
        );
      }
    
      return blinkClauseParser;
    }
    
    // ========================================================
    // blockContainsClause
    // ........................................................
    
    private ParserCombinator blockContainsClauseParser = null;
    
    public final Start blockContainsClause = Start.on(getNamespace(), "blockContainsClause");
    
    public ParserCombinator blockContainsClause() {
      if (blockContainsClauseParser == null) {
        FutureParser future = scoped("blockContainsClause", PUBLIC, true);
        blockContainsClauseParser = future;
        future.setParser(
          sequence(
            token("BLOCK"),
            optional(
              token("CONTAINS")
            ),
            integer(),
            optional(
              sequence(
                token("TO"),
                integer()
              )
            ),
            optional(
              choice(
                token("CHARACTERS"),
                token("RECORDS")
              )
            )
          )
        );
      }
    
      return blockContainsClauseParser;
    }
    
    // ========================================================
    // classClause
    // ........................................................
    
    private ParserCombinator classClauseParser = null;
    
    public final Start classClause = Start.on(getNamespace(), "classClause");
    
    public ParserCombinator classClause() {
      if (classClauseParser == null) {
        FutureParser future = scoped("classClause", PUBLIC, true);
        classClauseParser = future;
        future.setParser(
          sequence(
            token("CLASS"),
            optional(
              token("IS")
            ),
            choice(
              token("NUMERIC"),
              token("ALPHABETIC"),
              token("ALPHABETIC-LOWER"),
              token("ALPHABETIC-UPPER"),
              token("BOOLEAN"),
              name()
            )
          )
        );
      }
    
      return classClauseParser;
    }
    
    // ========================================================
    // codeClause
    // ........................................................
    
    private ParserCombinator codeClauseParser = null;
    
    public final Start codeClause = Start.on(getNamespace(), "codeClause");
    
    public ParserCombinator codeClause() {
      if (codeClauseParser == null) {
        FutureParser future = scoped("codeClause", PUBLIC, true);
        codeClauseParser = future;
        future.setParser(
          sequence(
            optional(
              token("WITH")
            ),
            token("CODE"),
            choice(
              literal(),
              identifier()
            )
          )
        );
      }
    
      return codeClauseParser;
    }
    
    // ========================================================
    // codeSetClause
    // ........................................................
    
    private ParserCombinator codeSetClauseParser = null;
    
    public final Start codeSetClause = Start.on(getNamespace(), "codeSetClause");
    
    public ParserCombinator codeSetClause() {
      if (codeSetClauseParser == null) {
        FutureParser future = scoped("codeSetClause", PUBLIC, true);
        codeSetClauseParser = future;
        future.setParser(
          sequence(
            token("CODE-SET"),
            optional(
              token("IS")
            ),
            alphabetName(),
            optional(
              sequence(
                token("FOR"),
                plus(
                  identifier()
                )
              )
            )
          )
        );
      }
    
      return codeSetClauseParser;
    }
    
    // ========================================================
    // columnClause
    // ........................................................
    
    private ParserCombinator columnClauseParser = null;
    
    public final Start columnClause = Start.on(getNamespace(), "columnClause");
    
    public ParserCombinator columnClause() {
      if (columnClauseParser == null) {
        FutureParser future = scoped("columnClause", PUBLIC, true);
        columnClauseParser = future;
        future.setParser(
          sequence(
            choice(
              sequence(
                choice(
                  token("COL"),
                  token("COLUMN")
                ),
                optional(
                  choice(
                    token("NUMBER"),
                    token("NUMBERS")
                  )
                )
              ),
              token("COLUMNS"),
              token("COLS")
            ),
            optional(
              choice(
                token("LEFT"),
                token("CENTER"),
                token("RIGHT")
              )
            ),
            optional(
              choice(
                token("IS"),
                token("ARE")
              )
            ),
            optional(
              choice(
                token("PLUS"),
                literal("+"),
                token("MINUS"),
                literal("-")
              )
            ),
            choice(
              integer(),
              identifier(),
              literal()
            )
          )
        );
      }
    
      return columnClauseParser;
    }
    
    // ========================================================
    // constantRecordClause
    // ........................................................
    
    private ParserCombinator constantRecordClauseParser = null;
    
    public final Start constantRecordClause = Start.on(getNamespace(), "constantRecordClause");
    
    public ParserCombinator constantRecordClause() {
      if (constantRecordClauseParser == null) {
        FutureParser future = scoped("constantRecordClause", PUBLIC, true);
        constantRecordClauseParser = future;
        future.setParser(
          sequence(
            token("CONSTANT"),
            token("RECORD")
          )
        );
      }
    
      return constantRecordClauseParser;
    }
    
    // ========================================================
    // constantValueClause
    // ........................................................
    
    private ParserCombinator constantValueClauseParser = null;
    
    public final Start constantValueClause = Start.on(getNamespace(), "constantValueClause");
    
    public ParserCombinator constantValueClause() {
      if (constantValueClauseParser == null) {
        FutureParser future = scoped("constantValueClause", PUBLIC, true);
        constantValueClauseParser = future;
        future.setParser(
          sequence(
            token("VALUE"),
            optional(
              token("IS")
            ),
            choice(
              token("NEXT"),
              sequence(
                token("START"),
                optional(
                  token("OF")
                ),
                dataName()
              ),
              sequence(
                token("LENGTH"),
                optional(
                  token("OF")
                ),
                dataName()
              ),
              literal()
            ),
            optional(
              sequence(
                choice(
                  token("AND"),
                  token("OR"),
                  literal("&"),
                  literal("+"),
                  literal("-"),
                  literal("*"),
                  literal("/")
                ),
                choice(
                  token("NEXT"),
                  sequence(
                    token("START"),
                    optional(
                      token("OF")
                    ),
                    dataName()
                  ),
                  sequence(
                    token("LENGTH"),
                    optional(
                      token("OF")
                    ),
                    dataName()
                  ),
                  integer()
                )
              )
            )
          )
        );
      }
    
      return constantValueClauseParser;
    }
    
    // ========================================================
    // controlClause
    // ........................................................
    
    private ParserCombinator controlClauseParser = null;
    
    public final Start controlClause = Start.on(getNamespace(), "controlClause");
    
    public ParserCombinator controlClause() {
      if (controlClauseParser == null) {
        FutureParser future = scoped("controlClause", PUBLIC, true);
        controlClauseParser = future;
        future.setParser(
          sequence(
            choice(
              sequence(
                token("CONTROL"),
                optional(
                  token("IS")
                )
              ),
              sequence(
                token("CONTROLS"),
                optional(
                  token("ARE")
                )
              )
            ),
            choice(
              sequence(
                token("FINAL"),
                star(
                  dataName()
                )
              ),
              plus(
                dataName()
              )
            )
          )
        );
      }
    
      return controlClauseParser;
    }
    
    // ========================================================
    // defaultClause
    // ........................................................
    
    private ParserCombinator defaultClauseParser = null;
    
    public final Start defaultClause = Start.on(getNamespace(), "defaultClause");
    
    public ParserCombinator defaultClause() {
      if (defaultClauseParser == null) {
        FutureParser future = scoped("defaultClause", PUBLIC, true);
        defaultClauseParser = future;
        future.setParser(
          sequence(
            token("DEFAULT"),
            optional(
              token("IS")
            ),
            choice(
              token("NONE"),
              literal(),
              identifier()
            )
          )
        );
      }
    
      return defaultClauseParser;
    }
    
    // ========================================================
    // destinationClause
    // ........................................................
    
    private ParserCombinator destinationClauseParser = null;
    
    public final Start destinationClause = Start.on(getNamespace(), "destinationClause");
    
    public ParserCombinator destinationClause() {
      if (destinationClauseParser == null) {
        FutureParser future = scoped("destinationClause", PUBLIC, true);
        destinationClauseParser = future;
        future.setParser(
          sequence(
            token("DESTINATION"),
            optional(
              token("IS")
            ),
            plus(
              identifier()
            )
          )
        );
      }
    
      return destinationClauseParser;
    }
    
    // ========================================================
    // eraseClause
    // ........................................................
    
    private ParserCombinator eraseClauseParser = null;
    
    public final Start eraseClause = Start.on(getNamespace(), "eraseClause");
    
    public ParserCombinator eraseClause() {
      if (eraseClauseParser == null) {
        FutureParser future = scoped("eraseClause", PUBLIC, true);
        eraseClauseParser = future;
        future.setParser(
          sequence(
            token("ERASE"),
            optional(
              choice(
                token("EOL"),
                token("EOS"),
                sequence(
                  optional(
                    sequence(
                      token("END"),
                      token("OF")
                    )
                  ),
                  token("LINE")
                ),
                sequence(
                  optional(
                    sequence(
                      token("END"),
                      token("OF")
                    )
                  ),
                  token("SCREEN")
                )
              )
            )
          )
        );
      }
    
      return eraseClauseParser;
    }
    
    // ========================================================
    // externalClause
    // ........................................................
    
    private ParserCombinator externalClauseParser = null;
    
    public final Start externalClause = Start.on(getNamespace(), "externalClause");
    
    public ParserCombinator externalClause() {
      if (externalClauseParser == null) {
        FutureParser future = scoped("externalClause", PUBLIC, true);
        externalClauseParser = future;
        future.setParser(
          sequence(
            optional(
              token("IS")
            ),
            token("EXTERNAL"),
            optional(
              sequence(
                choice(
                  token("AS"),
                  token("BY")
                ),
                literal()
              )
            )
          )
        );
      }
    
      return externalClauseParser;
    }
    
    // ========================================================
    // foregroundColorClause
    // ........................................................
    
    private ParserCombinator foregroundColorClauseParser = null;
    
    public final Start foregroundColorClause = Start.on(getNamespace(), "foregroundColorClause");
    
    public ParserCombinator foregroundColorClause() {
      if (foregroundColorClauseParser == null) {
        FutureParser future = scoped("foregroundColorClause", PUBLIC, true);
        foregroundColorClauseParser = future;
        future.setParser(
          sequence(
            choice(
              token("FOREGROUND-COLOR"),
              token("FOREGROUND-COLOUR")
            ),
            optional(
              token("IS")
            ),
            choice(
              integer(),
              identifier()
            )
          )
        );
      }
    
      return foregroundColorClauseParser;
    }
    
    // ========================================================
    // formatClause
    // ........................................................
    
    private ParserCombinator formatClauseParser = null;
    
    public final Start formatClause = Start.on(getNamespace(), "formatClause");
    
    public ParserCombinator formatClause() {
      if (formatClauseParser == null) {
        FutureParser future = scoped("formatClause", PUBLIC, true);
        formatClauseParser = future;
        future.setParser(
          sequence(
            token("FORMAT"),
            permuted(
              token("BIT"),
              token("CHARACTER"),
              token("NUMERIC")
            ),
            token("DATA")
          )
        );
      }
    
      return formatClauseParser;
    }
    
    // ========================================================
    // fullClause
    // ........................................................
    
    private ParserCombinator fullClauseParser = null;
    
    public final Start fullClause = Start.on(getNamespace(), "fullClause");
    
    public ParserCombinator fullClause() {
      if (fullClauseParser == null) {
        FutureParser future = scoped("fullClause", PUBLIC, true);
        fullClauseParser = future;
        future.setParser(
          token("FULL")
        );
      }
    
      return fullClauseParser;
    }
    
    // ========================================================
    // globalClause
    // ........................................................
    
    private ParserCombinator globalClauseParser = null;
    
    public final Start globalClause = Start.on(getNamespace(), "globalClause");
    
    public ParserCombinator globalClause() {
      if (globalClauseParser == null) {
        FutureParser future = scoped("globalClause", PUBLIC, true);
        globalClauseParser = future;
        future.setParser(
          sequence(
            optional(
              token("IS")
            ),
            token("GLOBAL")
          )
        );
      }
    
      return globalClauseParser;
    }
    
    // ========================================================
    // groupIndicateClause
    // ........................................................
    
    private ParserCombinator groupIndicateClauseParser = null;
    
    public final Start groupIndicateClause = Start.on(getNamespace(), "groupIndicateClause");
    
    public ParserCombinator groupIndicateClause() {
      if (groupIndicateClauseParser == null) {
        FutureParser future = scoped("groupIndicateClause", PUBLIC, true);
        groupIndicateClauseParser = future;
        future.setParser(
          sequence(
            token("GROUP"),
            optional(
              token("INDICATE")
            )
          )
        );
      }
    
      return groupIndicateClauseParser;
    }
    
    // ========================================================
    // groupUsageClause
    // ........................................................
    
    private ParserCombinator groupUsageClauseParser = null;
    
    public final Start groupUsageClause = Start.on(getNamespace(), "groupUsageClause");
    
    public ParserCombinator groupUsageClause() {
      if (groupUsageClauseParser == null) {
        FutureParser future = scoped("groupUsageClause", PUBLIC, true);
        groupUsageClauseParser = future;
        future.setParser(
          sequence(
            token("GROUP-USAGE"),
            optional(
              token("IS")
            ),
            choice(
              token("BIT"),
              token("NATIONAL")
            )
          )
        );
      }
    
      return groupUsageClauseParser;
    }
    
    // ========================================================
    // highlightClause
    // ........................................................
    
    private ParserCombinator highlightClauseParser = null;
    
    public final Start highlightClause = Start.on(getNamespace(), "highlightClause");
    
    public ParserCombinator highlightClause() {
      if (highlightClauseParser == null) {
        FutureParser future = scoped("highlightClause", PUBLIC, true);
        highlightClauseParser = future;
        future.setParser(
          choice(
            token("HIGHLIGHT"),
            token("LOWLIGHT")
          )
        );
      }
    
      return highlightClauseParser;
    }
    
    // ========================================================
    // invalidClause
    // ........................................................
    
    private ParserCombinator invalidClauseParser = null;
    
    public final Start invalidClause = Start.on(getNamespace(), "invalidClause");
    
    public ParserCombinator invalidClause() {
      if (invalidClauseParser == null) {
        FutureParser future = scoped("invalidClause", PUBLIC, true);
        invalidClauseParser = future;
        future.setParser(
          sequence(
            token("INVALID"),
            token("WHEN"),
            condition()
          )
        );
      }
    
      return invalidClauseParser;
    }
    
    // ========================================================
    // justifiedClause
    // ........................................................
    
    private ParserCombinator justifiedClauseParser = null;
    
    public final Start justifiedClause = Start.on(getNamespace(), "justifiedClause");
    
    public ParserCombinator justifiedClause() {
      if (justifiedClauseParser == null) {
        FutureParser future = scoped("justifiedClause", PUBLIC, true);
        justifiedClauseParser = future;
        future.setParser(
          sequence(
            choice(
              token("JUSTIFIED"),
              token("JUST")
            ),
            optional(
              token("RIGHT")
            )
          )
        );
      }
    
      return justifiedClauseParser;
    }
    
    // ========================================================
    // linageClause
    // ........................................................
    
    private ParserCombinator linageClauseParser = null;
    
    public final Start linageClause = Start.on(getNamespace(), "linageClause");
    
    public ParserCombinator linageClause() {
      if (linageClauseParser == null) {
        FutureParser future = scoped("linageClause", PUBLIC, true);
        linageClauseParser = future;
        future.setParser(
          sequence(
            token("LINAGE"),
            optional(
              token("IS")
            ),
            choice(
              dataName(),
              integer()
            ),
            optional(
              token("LINES")
            ),
            optional(
              footingClause()
            ),
            optional(
              linesAtTopClause()
            ),
            optional(
              linesAtBottomClause()
            )
          )
        );
      }
    
      return linageClauseParser;
    }
    
    // ========================================================
    // footingClause
    // ........................................................
    
    private ParserCombinator footingClauseParser = null;
    
    public final Start footingClause = Start.on(getNamespace(), "footingClause");
    
    public ParserCombinator footingClause() {
      if (footingClauseParser == null) {
        FutureParser future = scoped("footingClause", PUBLIC, true);
        footingClauseParser = future;
        future.setParser(
          sequence(
            optional(
              token("WITH")
            ),
            token("FOOTING"),
            optional(
              token("AT")
            ),
            choice(
              dataName(),
              integer()
            )
          )
        );
      }
    
      return footingClauseParser;
    }
    
    // ========================================================
    // linesAtTopClause
    // ........................................................
    
    private ParserCombinator linesAtTopClauseParser = null;
    
    public final Start linesAtTopClause = Start.on(getNamespace(), "linesAtTopClause");
    
    public ParserCombinator linesAtTopClause() {
      if (linesAtTopClauseParser == null) {
        FutureParser future = scoped("linesAtTopClause", PUBLIC, true);
        linesAtTopClauseParser = future;
        future.setParser(
          sequence(
            optional(
              token("LINES")
            ),
            optional(
              token("AT")
            ),
            token("TOP"),
            choice(
              dataName(),
              integer()
            )
          )
        );
      }
    
      return linesAtTopClauseParser;
    }
    
    // ========================================================
    // linesAtBottomClause
    // ........................................................
    
    private ParserCombinator linesAtBottomClauseParser = null;
    
    public final Start linesAtBottomClause = Start.on(getNamespace(), "linesAtBottomClause");
    
    public ParserCombinator linesAtBottomClause() {
      if (linesAtBottomClauseParser == null) {
        FutureParser future = scoped("linesAtBottomClause", PUBLIC, true);
        linesAtBottomClauseParser = future;
        future.setParser(
          sequence(
            optional(
              token("LINES")
            ),
            optional(
              token("AT")
            ),
            token("BOTTOM"),
            choice(
              dataName(),
              integer()
            )
          )
        );
      }
    
      return linesAtBottomClauseParser;
    }
    
    // ========================================================
    // lineClause
    // ........................................................
    
    private ParserCombinator lineClauseParser = null;
    
    public final Start lineClause = Start.on(getNamespace(), "lineClause");
    
    public ParserCombinator lineClause() {
      if (lineClauseParser == null) {
        FutureParser future = scoped("lineClause", PUBLIC, true);
        lineClauseParser = future;
        future.setParser(
          sequence(
            choice(
              sequence(
                token("LINE"),
                optional(
                  choice(
                    token("NUMBER"),
                    token("NUMBERS")
                  )
                ),
                optional(
                  choice(
                    token("IS"),
                    token("ARE")
                  )
                )
              ),
              sequence(
                token("LINES"),
                optional(
                  token("ARE")
                )
              )
            ),
            choice(
              plus(
                choice(
                  sequence(
                    integer(),
                    optional(
                      sequence(
                        optional(
                          token("ON")
                        ),
                        token("NEXT"),
                        token("PAGE")
                      )
                    )
                  ),
                  sequence(
                    choice(
                      token("PLUS"),
                      literal("+")
                    ),
                    choice(
                      integer(),
                      identifier()
                    )
                  ),
                  sequence(
                    optional(
                      token("ON")
                    ),
                    token("NEXT"),
                    token("PAGE")
                  )
                )
              ),
              sequence(
                choice(
                  token("PLUS"),
                  literal("+"),
                  token("MINUS"),
                  literal("-")
                ),
                choice(
                  integer(),
                  identifier()
                )
              )
            )
          )
        );
      }
    
      return lineClauseParser;
    }
    
    // ========================================================
    // nextGroupClause
    // ........................................................
    
    private ParserCombinator nextGroupClauseParser = null;
    
    public final Start nextGroupClause = Start.on(getNamespace(), "nextGroupClause");
    
    public ParserCombinator nextGroupClause() {
      if (nextGroupClauseParser == null) {
        FutureParser future = scoped("nextGroupClause", PUBLIC, true);
        nextGroupClauseParser = future;
        future.setParser(
          sequence(
            token("NEXT"),
            token("GROUP"),
            optional(
              token("IS")
            ),
            choice(
              integer(),
              sequence(
                token("PLUS"),
                integer()
              ),
              sequence(
                token("NEXT"),
                token("PAGE"),
                optional(
                  sequence(
                    optional(
                      token("WITH")
                    ),
                    token("RESET")
                  )
                )
              )
            )
          )
        );
      }
    
      return nextGroupClauseParser;
    }
    
    // ========================================================
    // occursClause
    // ........................................................
    
    private ParserCombinator occursClauseParser = null;
    
    public final Start occursClause = Start.on(getNamespace(), "occursClause");
    
    public ParserCombinator occursClause() {
      if (occursClauseParser == null) {
        FutureParser future = scoped("occursClause", PUBLIC, true);
        occursClauseParser = future;
        future.setParser(
          sequence(
            token("OCCURS"),
            choice(
              sequence(
                choice(
                  as("dynamic",
                    sequence(
                      token("DYNAMIC"),
                      optional(
                        sequence(
                          token("CAPACITY"),
                          optional(
                            token("IN")
                          ),
                          dataName()
                        )
                      ),
                      optional(
                        sequence(
                          token("FROM"),
                          integer()
                        )
                      ),
                      optional(
                        sequence(
                          token("TO"),
                          integer()
                        )
                      ),
                      optional(
                        token("INITIALIZED")
                      )
                    )
                  ),
                  as("fixed",
                    sequence(
                      optional(
                        sequence(
                          integer(),
                          token("TO")
                        )
                      ),
                      integer(),
                      optional(
                        token("TIMES")
                      )
                    )
                  )
                ),
                optional(
                  as("dependingOn",
                    sequence(
                      token("DEPENDING"),
                      optional(
                        token("ON")
                      ),
                      qualifiedDataName()
                    )
                  )
                ),
                optional(
                  as("step",
                    sequence(
                      token("STEP"),
                      integer()
                    )
                  )
                ),
                star(
                  as("keyIs",
                    sequence(
                      choice(
                        as("ascending",
                          token("ASCENDING")
                        ),
                        as("descending",
                          token("DESCENDING")
                        )
                      ),
                      optional(
                        token("KEY")
                      ),
                      optional(
                        token("IS")
                      ),
                      plus(
                        qualifiedDataName()
                      )
                    )
                  )
                ),
                star(
                  as("indexedBy",
                    sequence(
                      token("INDEXED"),
                      optional(
                        token("BY")
                      ),
                      plus(
                        indexName()
                      )
                    )
                  )
                )
              ),
              as("any",
                token("ANY")
              )
            )
          )
        );
      }
    
      return occursClauseParser;
    }
    
    // ========================================================
    // pageClause
    // ........................................................
    
    private ParserCombinator pageClauseParser = null;
    
    public final Start pageClause = Start.on(getNamespace(), "pageClause");
    
    public ParserCombinator pageClause() {
      if (pageClauseParser == null) {
        FutureParser future = scoped("pageClause", PUBLIC, true);
        pageClauseParser = future;
        future.setParser(
          sequence(
            token("PAGE"),
            optional(
              choice(
                token("LIMIT"),
                token("LIMITS")
              )
            ),
            optional(
              choice(
                token("IS"),
                token("ARE")
              )
            ),
            integer(),
            optional(
              choice(
                token("LINE"),
                token("LINES")
              )
            ),
            optional(
              sequence(
                token("HEADING"),
                integer()
              )
            ),
            optional(
              sequence(
                token("FIRST"),
                token("DETAIL"),
                integer()
              )
            ),
            optional(
              sequence(
                token("LAST"),
                token("DETAIL"),
                integer()
              )
            ),
            optional(
              sequence(
                token("FOOTING"),
                integer()
              )
            )
          )
        );
      }
    
      return pageClauseParser;
    }
    
    // ========================================================
    // pictureClause
    // ........................................................
    
    private ParserCombinator pictureClauseParser = null;
    
    public final Start pictureClause = Start.on(getNamespace(), "pictureClause");
    
    public ParserCombinator pictureClause() {
      if (pictureClauseParser == null) {
        FutureParser future = scoped("pictureClause", PUBLIC, true);
        pictureClauseParser = future;
        future.setParser(
          sequence(
            choice(
              token("PIC"),
              token("PICTURE")
            ),
            optional(
              token("IS")
            ),
            pictureString(),
            optional(
              pictureLocaleClause()
            )
          )
        );
      }
    
      return pictureClauseParser;
    }
    
    // ========================================================
    // pictureLocaleClause
    // ........................................................
    
    private ParserCombinator pictureLocaleClauseParser = null;
    
    public final Start pictureLocaleClause = Start.on(getNamespace(), "pictureLocaleClause");
    
    public ParserCombinator pictureLocaleClause() {
      if (pictureLocaleClauseParser == null) {
        FutureParser future = scoped("pictureLocaleClause", PUBLIC, true);
        pictureLocaleClauseParser = future;
        future.setParser(
          sequence(
            token("LOCALE"),
            optional(
              sequence(
                optional(
                  token("IS")
                ),
                cobolWord()
              )
            ),
            token("SIZE"),
            optional(
              token("IS")
            ),
            integer()
          )
        );
      }
    
      return pictureLocaleClauseParser;
    }
    
    // ========================================================
    // presentWhenClause
    // ........................................................
    
    private ParserCombinator presentWhenClauseParser = null;
    
    public final Start presentWhenClause = Start.on(getNamespace(), "presentWhenClause");
    
    public ParserCombinator presentWhenClause() {
      if (presentWhenClauseParser == null) {
        FutureParser future = scoped("presentWhenClause", PUBLIC, true);
        presentWhenClauseParser = future;
        future.setParser(
          sequence(
            token("PRESENT"),
            token("WHEN"),
            condition()
          )
        );
      }
    
      return presentWhenClauseParser;
    }
    
    // ========================================================
    // propertyClause
    // ........................................................
    
    private ParserCombinator propertyClauseParser = null;
    
    public final Start propertyClause = Start.on(getNamespace(), "propertyClause");
    
    public ParserCombinator propertyClause() {
      if (propertyClauseParser == null) {
        FutureParser future = scoped("propertyClause", PUBLIC, true);
        propertyClauseParser = future;
        future.setParser(
          sequence(
            token("PROPERTY"),
            optional(
              sequence(
                optional(
                  token("WITH")
                ),
                token("NO"),
                choice(
                  token("GET"),
                  token("SET")
                )
              )
            ),
            optional(
              sequence(
                optional(
                  token("IS")
                ),
                token("FINAL")
              )
            )
          )
        );
      }
    
      return propertyClauseParser;
    }
    
    // ========================================================
    // recordClause
    // ........................................................
    
    private ParserCombinator recordClauseParser = null;
    
    public final Start recordClause = Start.on(getNamespace(), "recordClause");
    
    public ParserCombinator recordClause() {
      if (recordClauseParser == null) {
        FutureParser future = scoped("recordClause", PUBLIC, true);
        recordClauseParser = future;
        future.setParser(
          sequence(
            token("RECORD"),
            choice(
              recordContainsClause(),
              recordIsVaryingClause()
            )
          )
        );
      }
    
      return recordClauseParser;
    }
    
    // ========================================================
    // recordContainsClause
    // ........................................................
    
    private ParserCombinator recordContainsClauseParser = null;
    
    public final Start recordContainsClause = Start.on(getNamespace(), "recordContainsClause");
    
    public ParserCombinator recordContainsClause() {
      if (recordContainsClauseParser == null) {
        FutureParser future = scoped("recordContainsClause", PUBLIC, true);
        recordContainsClauseParser = future;
        future.setParser(
          sequence(
            optional(
              token("CONTAINS")
            ),
            integer(),
            optional(
              sequence(
                token("TO"),
                integer()
              )
            ),
            optional(
              token("CHARACTERS")
            )
          )
        );
      }
    
      return recordContainsClauseParser;
    }
    
    // ========================================================
    // recordIsVaryingClause
    // ........................................................
    
    private ParserCombinator recordIsVaryingClauseParser = null;
    
    public final Start recordIsVaryingClause = Start.on(getNamespace(), "recordIsVaryingClause");
    
    public ParserCombinator recordIsVaryingClause() {
      if (recordIsVaryingClauseParser == null) {
        FutureParser future = scoped("recordIsVaryingClause", PUBLIC, true);
        recordIsVaryingClauseParser = future;
        future.setParser(
          sequence(
            optional(
              token("IS")
            ),
            token("VARYING"),
            optional(
              token("IN")
            ),
            optional(
              token("SIZE")
            ),
            optional(
              sequence(
                optional(
                  token("FROM")
                ),
                integer(),
                optional(
                  sequence(
                    token("TO"),
                    integer()
                  )
                ),
                optional(
                  token("CHARACTERS")
                )
              )
            ),
            optional(
              sequence(
                token("DEPENDING"),
                optional(
                  token("ON")
                ),
                fileName()
              )
            )
          )
        );
      }
    
      return recordIsVaryingClauseParser;
    }
    
    // ========================================================
    // redefinesClause
    // ........................................................
    
    private ParserCombinator redefinesClauseParser = null;
    
    public final Start redefinesClause = Start.on(getNamespace(), "redefinesClause");
    
    public ParserCombinator redefinesClause() {
      if (redefinesClauseParser == null) {
        FutureParser future = scoped("redefinesClause", PUBLIC, true);
        redefinesClauseParser = future;
        future.setParser(
          sequence(
            token("REDEFINES"),
            dataName()
          )
        );
      }
    
      return redefinesClauseParser;
    }
    
    // ========================================================
    // renamesClause
    // ........................................................
    
    private ParserCombinator renamesClauseParser = null;
    
    public final Start renamesClause = Start.on(getNamespace(), "renamesClause");
    
    public ParserCombinator renamesClause() {
      if (renamesClauseParser == null) {
        FutureParser future = scoped("renamesClause", PUBLIC, true);
        renamesClauseParser = future;
        future.setParser(
          sequence(
            token("RENAMES"),
            qualifiedDataName(),
            optional(
              sequence(
                choice(
                  token("THROUGH"),
                  token("THRU")
                ),
                qualifiedDataName()
              )
            )
          )
        );
      }
    
      return renamesClauseParser;
    }
    
    // ========================================================
    // reportClause
    // ........................................................
    
    private ParserCombinator reportClauseParser = null;
    
    public final Start reportClause = Start.on(getNamespace(), "reportClause");
    
    public ParserCombinator reportClause() {
      if (reportClauseParser == null) {
        FutureParser future = scoped("reportClause", PUBLIC, true);
        reportClauseParser = future;
        future.setParser(
          sequence(
            choice(
              sequence(
                token("REPORT"),
                optional(
                  token("IS")
                )
              ),
              sequence(
                token("REPORTS"),
                optional(
                  token("ARE")
                )
              )
            ),
            plus(
              reportName()
            )
          )
        );
      }
    
      return reportClauseParser;
    }
    
    // ========================================================
    // reportGroupTypeClause
    // ........................................................
    
    private ParserCombinator reportGroupTypeClauseParser = null;
    
    public final Start reportGroupTypeClause = Start.on(getNamespace(), "reportGroupTypeClause");
    
    public ParserCombinator reportGroupTypeClause() {
      if (reportGroupTypeClauseParser == null) {
        FutureParser future = scoped("reportGroupTypeClause", PUBLIC, true);
        reportGroupTypeClauseParser = future;
        future.setParser(
          sequence(
            token("TYPE"),
            optional(
              token("IS")
            ),
            choice(
              choice(
                token("RH"),
                sequence(
                  token("REPORT"),
                  token("HEADING")
                )
              ),
              choice(
                token("PH"),
                sequence(
                  token("PAGE"),
                  token("HEADING")
                )
              ),
              sequence(
                choice(
                  token("CH"),
                  sequence(
                    token("CONTROL"),
                    token("HEADING")
                  )
                ),
                optional(
                  choice(
                    token("ON"),
                    token("FOR")
                  )
                ),
                choice(
                  token("FINAL"),
                  dataName()
                )
              ),
              choice(
                token("DE"),
                token("DETAIL")
              ),
              sequence(
                choice(
                  token("CF"),
                  sequence(
                    token("CONTROL"),
                    token("FOOTING")
                  )
                ),
                optional(
                  choice(
                    token("ON"),
                    token("FOR")
                  )
                ),
                choice(
                  token("FINAL"),
                  dataName()
                )
              ),
              choice(
                token("PF"),
                sequence(
                  token("PAGE"),
                  token("FOOTING")
                )
              ),
              choice(
                token("RF"),
                sequence(
                  token("REPORT"),
                  token("FOOTING")
                )
              )
            )
          )
        );
      }
    
      return reportGroupTypeClauseParser;
    }
    
    // ========================================================
    // reportGroupUsageClause
    // ........................................................
    
    private ParserCombinator reportGroupUsageClauseParser = null;
    
    public final Start reportGroupUsageClause = Start.on(getNamespace(), "reportGroupUsageClause");
    
    public ParserCombinator reportGroupUsageClause() {
      if (reportGroupUsageClauseParser == null) {
        FutureParser future = scoped("reportGroupUsageClause", PUBLIC, true);
        reportGroupUsageClauseParser = future;
        future.setParser(
          sequence(
            token("USAGE"),
            optional(
              token("IS")
            ),
            choice(
              token("DISPLAY"),
              token("DISPLAY-1")
            )
          )
        );
      }
    
      return reportGroupUsageClauseParser;
    }
    
    // ========================================================
    // reportSectionValueClause
    // ........................................................
    
    private ParserCombinator reportSectionValueClauseParser = null;
    
    public final Start reportSectionValueClause = Start.on(getNamespace(), "reportSectionValueClause");
    
    public ParserCombinator reportSectionValueClause() {
      if (reportSectionValueClauseParser == null) {
        FutureParser future = scoped("reportSectionValueClause", PUBLIC, true);
        reportSectionValueClauseParser = future;
        future.setParser(
          sequence(
            choice(
              sequence(
                token("VALUE"),
                optional(
                  token("IS")
                )
              ),
              sequence(
                token("VALUES"),
                optional(
                  token("ARE")
                )
              )
            ),
            plus(
              choice(
                literal(),
                figurativeConstant()
              )
            )
          )
        );
      }
    
      return reportSectionValueClauseParser;
    }
    
    // ========================================================
    // reverseVideoClause
    // ........................................................
    
    private ParserCombinator reverseVideoClauseParser = null;
    
    public final Start reverseVideoClause = Start.on(getNamespace(), "reverseVideoClause");
    
    public ParserCombinator reverseVideoClause() {
      if (reverseVideoClauseParser == null) {
        FutureParser future = scoped("reverseVideoClause", PUBLIC, true);
        reverseVideoClauseParser = future;
        future.setParser(
          token("REVERSE-VIDEO")
        );
      }
    
      return reverseVideoClauseParser;
    }
    
    // ========================================================
    // requiredClause
    // ........................................................
    
    private ParserCombinator requiredClauseParser = null;
    
    public final Start requiredClause = Start.on(getNamespace(), "requiredClause");
    
    public ParserCombinator requiredClause() {
      if (requiredClauseParser == null) {
        FutureParser future = scoped("requiredClause", PUBLIC, true);
        requiredClauseParser = future;
        future.setParser(
          token("REQUIRED")
        );
      }
    
      return requiredClauseParser;
    }
    
    // ========================================================
    // sameAsClause
    // ........................................................
    
    private ParserCombinator sameAsClauseParser = null;
    
    public final Start sameAsClause = Start.on(getNamespace(), "sameAsClause");
    
    public ParserCombinator sameAsClause() {
      if (sameAsClauseParser == null) {
        FutureParser future = scoped("sameAsClause", PUBLIC, true);
        sameAsClauseParser = future;
        future.setParser(
          sequence(
            token("SAME"),
            token("AS"),
            dataName()
          )
        );
      }
    
      return sameAsClauseParser;
    }
    
    // ========================================================
    // screenFromClause
    // ........................................................
    
    private ParserCombinator screenFromClauseParser = null;
    
    public final Start screenFromClause = Start.on(getNamespace(), "screenFromClause");
    
    public ParserCombinator screenFromClause() {
      if (screenFromClauseParser == null) {
        FutureParser future = scoped("screenFromClause", PUBLIC, true);
        screenFromClauseParser = future;
        future.setParser(
          sequence(
            token("FROM"),
            choice(
              literal(),
              identifier()
            )
          )
        );
      }
    
      return screenFromClauseParser;
    }
    
    // ========================================================
    // screenToClause
    // ........................................................
    
    private ParserCombinator screenToClauseParser = null;
    
    public final Start screenToClause = Start.on(getNamespace(), "screenToClause");
    
    public ParserCombinator screenToClause() {
      if (screenToClauseParser == null) {
        FutureParser future = scoped("screenToClause", PUBLIC, true);
        screenToClauseParser = future;
        future.setParser(
          sequence(
            token("TO"),
            identifier()
          )
        );
      }
    
      return screenToClauseParser;
    }
    
    // ========================================================
    // screenUsingClause
    // ........................................................
    
    private ParserCombinator screenUsingClauseParser = null;
    
    public final Start screenUsingClause = Start.on(getNamespace(), "screenUsingClause");
    
    public ParserCombinator screenUsingClause() {
      if (screenUsingClauseParser == null) {
        FutureParser future = scoped("screenUsingClause", PUBLIC, true);
        screenUsingClauseParser = future;
        future.setParser(
          sequence(
            token("USING"),
            identifier()
          )
        );
      }
    
      return screenUsingClauseParser;
    }
    
    // ========================================================
    // screenValueClause
    // ........................................................
    
    private ParserCombinator screenValueClauseParser = null;
    
    public final Start screenValueClause = Start.on(getNamespace(), "screenValueClause");
    
    public ParserCombinator screenValueClause() {
      if (screenValueClauseParser == null) {
        FutureParser future = scoped("screenValueClause", PUBLIC, true);
        screenValueClauseParser = future;
        future.setParser(
          sequence(
            token("VALUE"),
            optional(
              token("IS")
            ),
            literal()
          )
        );
      }
    
      return screenValueClauseParser;
    }
    
    // ========================================================
    // secureClause
    // ........................................................
    
    private ParserCombinator secureClauseParser = null;
    
    public final Start secureClause = Start.on(getNamespace(), "secureClause");
    
    public ParserCombinator secureClause() {
      if (secureClauseParser == null) {
        FutureParser future = scoped("secureClause", PUBLIC, true);
        secureClauseParser = future;
        future.setParser(
          token("SECURE")
        );
      }
    
      return secureClauseParser;
    }
    
    // ========================================================
    // selectWhenClause
    // ........................................................
    
    private ParserCombinator selectWhenClauseParser = null;
    
    public final Start selectWhenClause = Start.on(getNamespace(), "selectWhenClause");
    
    public ParserCombinator selectWhenClause() {
      if (selectWhenClauseParser == null) {
        FutureParser future = scoped("selectWhenClause", PUBLIC, true);
        selectWhenClauseParser = future;
        future.setParser(
          sequence(
            token("SELECT"),
            token("WHEN"),
            choice(
              token("OTHER"),
              conditionName()
            )
          )
        );
      }
    
      return selectWhenClauseParser;
    }
    
    // ========================================================
    // signClause
    // ........................................................
    
    private ParserCombinator signClauseParser = null;
    
    public final Start signClause = Start.on(getNamespace(), "signClause");
    
    public ParserCombinator signClause() {
      if (signClauseParser == null) {
        FutureParser future = scoped("signClause", PUBLIC, true);
        signClauseParser = future;
        future.setParser(
          sequence(
            optional(
              sequence(
                token("SIGN"),
                optional(
                  token("IS")
                )
              )
            ),
            choice(
              token("LEADING"),
              token("TRAILING")
            ),
            optional(
              sequence(
                token("SEPARATE"),
                optional(
                  token("CHARACTER")
                )
              )
            )
          )
        );
      }
    
      return signClauseParser;
    }
    
    // ========================================================
    // sourceClause
    // ........................................................
    
    private ParserCombinator sourceClauseParser = null;
    
    public final Start sourceClause = Start.on(getNamespace(), "sourceClause");
    
    public ParserCombinator sourceClause() {
      if (sourceClauseParser == null) {
        FutureParser future = scoped("sourceClause", PUBLIC, true);
        sourceClauseParser = future;
        future.setParser(
          sequence(
            choice(
              sequence(
                token("SOURCE"),
                optional(
                  token("IS")
                )
              ),
              sequence(
                token("SOURCES"),
                optional(
                  token("ARE")
                )
              )
            ),
            plus(
              choice(
                sequence(
                  identifier(),
                  not(
                    moreArithmeticOp()
                  )
                ),
                arithmeticExpression()
              )
            ),
            optional(
              roundedPhrase()
            )
          )
        );
      }
    
      return sourceClauseParser;
    }
    
    // ========================================================
    // sumClause
    // ........................................................
    
    private ParserCombinator sumClauseParser = null;
    
    public final Start sumClause = Start.on(getNamespace(), "sumClause");
    
    public ParserCombinator sumClause() {
      if (sumClauseParser == null) {
        FutureParser future = scoped("sumClause", PUBLIC, true);
        sumClauseParser = future;
        future.setParser(
          sequence(
            plus(
              sequence(
                token("SUM"),
                optional(
                  token("OF")
                ),
                plus(
                  sequence(
                    not(
                      token("UPON")
                    ),
                    identifier()
                  )
                ),
                optional(
                  sequence(
                    token("UPON"),
                    plus(
                      dataName()
                    )
                  )
                )
              )
            ),
            optional(
              sequence(
                token("RESET"),
                optional(
                  token("ON")
                ),
                choice(
                  token("FINAL"),
                  dataName()
                )
              )
            )
          )
        );
      }
    
      return sumClauseParser;
    }
    
    // ========================================================
    // synchronizedClause
    // ........................................................
    
    private ParserCombinator synchronizedClauseParser = null;
    
    public final Start synchronizedClause = Start.on(getNamespace(), "synchronizedClause");
    
    public ParserCombinator synchronizedClause() {
      if (synchronizedClauseParser == null) {
        FutureParser future = scoped("synchronizedClause", PUBLIC, true);
        synchronizedClauseParser = future;
        future.setParser(
          sequence(
            choice(
              token("SYNCHRONIZED"),
              token("SYNC")
            ),
            optional(
              choice(
                token("LEFT"),
                token("RIGHT")
              )
            )
          )
        );
      }
    
      return synchronizedClauseParser;
    }
    
    // ========================================================
    // typedefClause
    // ........................................................
    
    private ParserCombinator typedefClauseParser = null;
    
    public final Start typedefClause = Start.on(getNamespace(), "typedefClause");
    
    public ParserCombinator typedefClause() {
      if (typedefClauseParser == null) {
        FutureParser future = scoped("typedefClause", PUBLIC, true);
        typedefClauseParser = future;
        future.setParser(
          sequence(
            optional(
              token("IS")
            ),
            token("TYPEDEF"),
            optional(
              token("STRONG")
            )
          )
        );
      }
    
      return typedefClauseParser;
    }
    
    // ========================================================
    // typeNameTypeClause
    // ........................................................
    
    private ParserCombinator typeNameTypeClauseParser = null;
    
    public final Start typeNameTypeClause = Start.on(getNamespace(), "typeNameTypeClause");
    
    public ParserCombinator typeNameTypeClause() {
      if (typeNameTypeClauseParser == null) {
        FutureParser future = scoped("typeNameTypeClause", PUBLIC, true);
        typeNameTypeClauseParser = future;
        future.setParser(
          sequence(
            token("TYPE"),
            optional(
              token("TO")
            ),
            typeName()
          )
        );
      }
    
      return typeNameTypeClauseParser;
    }
    
    // ========================================================
    // underlineClause
    // ........................................................
    
    private ParserCombinator underlineClauseParser = null;
    
    public final Start underlineClause = Start.on(getNamespace(), "underlineClause");
    
    public ParserCombinator underlineClause() {
      if (underlineClauseParser == null) {
        FutureParser future = scoped("underlineClause", PUBLIC, true);
        underlineClauseParser = future;
        future.setParser(
          token("UNDERLINE")
        );
      }
    
      return underlineClauseParser;
    }
    
    // ========================================================
    // usageClause
    // ........................................................
    
    private ParserCombinator usageClauseParser = null;
    
    public final Start usageClause = Start.on(getNamespace(), "usageClause");
    
    public ParserCombinator usageClause() {
      if (usageClauseParser == null) {
        FutureParser future = scoped("usageClause", PUBLIC, true);
        usageClauseParser = future;
        future.setParser(
          sequence(
            optional(
              sequence(
                token("USAGE"),
                optional(
                  token("IS")
                )
              )
            ),
            usageOperand()
          )
        );
      }
    
      return usageClauseParser;
    }
    
    // ========================================================
    // usageOperand
    // ........................................................
    
    private ParserCombinator usageOperandParser = null;
    
    public final Start usageOperand = Start.on(getNamespace(), "usageOperand");
    
    public ParserCombinator usageOperand() {
      if (usageOperandParser == null) {
        FutureParser future = scoped("usageOperand", PUBLIC, true);
        usageOperandParser = future;
        future.setParser(
          choice(
            token("BINARY"),
            token("BINARY-C-LONG"),
            sequence(
              token("BINARY-CHAR"),
              optional(
                choice(
                  token("SIGNED"),
                  token("UNSIGNED")
                )
              )
            ),
            sequence(
              token("BINARY-DOUBLE"),
              optional(
                choice(
                  token("SIGNED"),
                  token("UNSIGNED")
                )
              )
            ),
            sequence(
              token("BINARY-LONG"),
              optional(
                choice(
                  token("SIGNED"),
                  token("UNSIGNED")
                )
              )
            ),
            sequence(
              token("BINARY-SHORT"),
              optional(
                choice(
                  token("SIGNED"),
                  token("UNSIGNED")
                )
              )
            ),
            token("BIT"),
            token("CHARACTER"),
            token("COMPUTATIONAL"),
            token("COMP"),
            token("COMPUTATIONAL-1"),
            token("COMP-1"),
            token("COMPUTATIONAL-2"),
            token("COMP-2"),
            token("COMPUTATIONAL-3"),
            token("COMP-3"),
            token("COMPUTATIONAL-4"),
            token("COMP-4"),
            token("COMPUTATIONAL-5"),
            token("COMP-5"),
            token("COMPUTATIONAL-6"),
            token("COMP-6"),
            token("COMPUTATIONAL-X"),
            token("COMP-X"),
            token("COMPUTATIONAL-N"),
            token("COMP-N"),
            token("CONDITION-VALUE"),
            token("DECIMAL"),
            token("DISPLAY"),
            token("DISPLAY-1"),
            token("DOUBLE"),
            token("INDEX"),
            token("FLOAT"),
            token("FLOAT-EXTENDED"),
            token("FLOAT-LONG"),
            token("FLOAT-SHORT"),
            sequence(
              token("HANDLE"),
              optional(
                sequence(
                  optional(
                    token("OF")
                  ),
                  choice(
                    token("WINDOW"),
                    token("SUBWINDOW"),
                    sequence(
                      token("FONT"),
                      optional(
                        cobolWord()
                      )
                    ),
                    token("THREAD"),
                    token("MENU"),
                    token("VARIANT"),
                    sequence(
                      token("LAYOUT-MANAGER"),
                      optional(
                        cobolWord()
                      )
                    )
                  )
                )
              )
            ),
            token("MONITOR-POINTER"),
            token("MUTEX-POINTER"),
            token("NATIONAL"),
            sequence(
              token("OBJECT"),
              token("REFERENCE"),
              optional(
                choice(
                  sequence(
                    optional(
                      sequence(
                        token("FACTORY"),
                        token("OF")
                      )
                    ),
                    token("ACTIVE-CLASS")
                  ),
                  sequence(
                    optional(
                      sequence(
                        token("FACTORY"),
                        token("OF")
                      )
                    ),
                    className(),
                    optional(
                      choice(
                        token("ONLY"),
                        token("EVENT")
                      )
                    )
                  )
                )
              )
            ),
            token("OBJECT"),
            token("PACKED-DECIMAL"),
            token("POINTER"),
            token("PROCEDURE-POINTER"),
            sequence(
              token("PROGRAM-POINTER"),
              optional(
                sequence(
                  optional(
                    token("TO")
                  ),
                  programName()
                )
              )
            ),
            token("SEMAPHORE-POINTER"),
            token("SIGNED-INT"),
            token("SIGNED-LONG"),
            token("SIGNED-SHORT"),
            token("THREAD-POINTER"),
            token("UNSIGNED-INT"),
            token("UNSIGNED-LONG"),
            token("UNSIGNED-SHORT"),
            token("STRING"),
            typedefName(),
            className()
          )
        );
      }
    
      return usageOperandParser;
    }
    
    // ========================================================
    // validateStatusClause
    // ........................................................
    
    private ParserCombinator validateStatusClauseParser = null;
    
    public final Start validateStatusClause = Start.on(getNamespace(), "validateStatusClause");
    
    public ParserCombinator validateStatusClause() {
      if (validateStatusClauseParser == null) {
        FutureParser future = scoped("validateStatusClause", PUBLIC, true);
        validateStatusClauseParser = future;
        future.setParser(
          sequence(
            choice(
              token("VALIDATE-STATUS"),
              token("VAL-STATUS")
            ),
            optional(
              token("IS")
            ),
            choice(
              literal(),
              identifier()
            ),
            optional(
              token("WHEN")
            ),
            optional(
              token("NO")
            ),
            token("ERROR"),
            optional(
              sequence(
                token("ON"),
                permuted(
                  token("FORMAT"),
                  token("CONTENT"),
                  token("RELATION")
                )
              )
            ),
            token("FOR"),
            plus(
              identifier()
            )
          )
        );
      }
    
      return validateStatusClauseParser;
    }
    
    // ========================================================
    // varyingClause
    // ........................................................
    
    private ParserCombinator varyingClauseParser = null;
    
    public final Start varyingClause = Start.on(getNamespace(), "varyingClause");
    
    public ParserCombinator varyingClause() {
      if (varyingClauseParser == null) {
        FutureParser future = scoped("varyingClause", PUBLIC, true);
        varyingClauseParser = future;
        future.setParser(
          sequence(
            token("VARYING"),
            plus(
              sequence(
                dataName(),
                optional(
                  sequence(
                    token("FROM"),
                    arithmeticExpression()
                  )
                ),
                optional(
                  sequence(
                    token("BY"),
                    arithmeticExpression()
                  )
                )
              )
            )
          )
        );
      }
    
      return varyingClauseParser;
    }
    
    // ========================================================
    // procedureDivision
    // ........................................................
    
    private ParserCombinator procedureDivisionParser = null;
    
    public final Start procedureDivision = Start.on(getNamespace(), "procedureDivision");
    
    public ParserCombinator procedureDivision() {
      if (procedureDivisionParser == null) {
        FutureParser future = scoped("procedureDivision", PUBLIC, true);
        procedureDivisionParser = future;
        future.setParser(
          sequence(
            procedureDivision$header(),
            optional(
              declaratives()
            ),
            star(
              sentence()
            ),
            star(
              paragraph()
            ),
            star(
              section()
            )
          )
        );
      }
    
      return procedureDivisionParser;
    }
    
    // ========================================================
    // header
    // ........................................................
    
    private ParserCombinator procedureDivision$headerParser = null;
    
    public final Start procedureDivision$header = Start.on(getNamespace(), "header");
    
    public ParserCombinator procedureDivision$header() {
      if (procedureDivision$headerParser == null) {
        FutureParser future = scoped("header", PUBLIC, true);
        procedureDivision$headerParser = future;
        future.setParser(
          sequence(
            token("PROCEDURE"),
            token("DIVISION"),
            optional(
              mnemonicName()
            ),
            optional(
              procedureDivision$header$using()
            ),
            optional(
              procedureDivision$header$returning()
            ),
            literal(".")
          )
        );
      }
    
      return procedureDivision$headerParser;
    }
    
    // ========================================================
    // using
    // ........................................................
    
    private ParserCombinator procedureDivision$header$usingParser = null;
    
    public final Start procedureDivision$header$using = Start.on(getNamespace(), "using");
    
    public ParserCombinator procedureDivision$header$using() {
      if (procedureDivision$header$usingParser == null) {
        FutureParser future = scoped("using", PUBLIC, true);
        procedureDivision$header$usingParser = future;
        future.setParser(
          sequence(
            choice(
              token("USING"),
              token("CHAINING"),
              token("GIVING")
            ),
            plus(
              choice(
                procedureDivision$header$using$byReference(),
                procedureDivision$header$using$byValue(),
                procedureDivision$header$using$byOutput()
              )
            ),
            optional(
              procedureDivision$header$using$repeated()
            )
          )
        );
      }
    
      return procedureDivision$header$usingParser;
    }
    
    // ========================================================
    // byReference
    // ........................................................
    
    private ParserCombinator procedureDivision$header$using$byReferenceParser = null;
    
    public final Start procedureDivision$header$using$byReference = Start.on(getNamespace(), "byReference");
    
    public ParserCombinator procedureDivision$header$using$byReference() {
      if (procedureDivision$header$using$byReferenceParser == null) {
        FutureParser future = scoped("byReference", PUBLIC, true);
        procedureDivision$header$using$byReferenceParser = future;
        future.setParser(
          sequence(
            optional(
              sequence(
                optional(
                  token("BY")
                ),
                token("REFERENCE")
              )
            ),
            plus(
              sequence(
                procedureDivision$header$using$arg(),
                optional(
                  procedureDivision$header$using$asTypeName()
                )
              )
            )
          )
        );
      }
    
      return procedureDivision$header$using$byReferenceParser;
    }
    
    // ========================================================
    // byValue
    // ........................................................
    
    private ParserCombinator procedureDivision$header$using$byValueParser = null;
    
    public final Start procedureDivision$header$using$byValue = Start.on(getNamespace(), "byValue");
    
    public ParserCombinator procedureDivision$header$using$byValue() {
      if (procedureDivision$header$using$byValueParser == null) {
        FutureParser future = scoped("byValue", PUBLIC, true);
        procedureDivision$header$using$byValueParser = future;
        future.setParser(
          sequence(
            optional(
              token("BY")
            ),
            token("VALUE"),
            plus(
              sequence(
                procedureDivision$header$using$arg(),
                optional(
                  procedureDivision$header$using$asTypeName()
                )
              )
            )
          )
        );
      }
    
      return procedureDivision$header$using$byValueParser;
    }
    
    // ========================================================
    // byOutput
    // ........................................................
    
    private ParserCombinator procedureDivision$header$using$byOutputParser = null;
    
    public final Start procedureDivision$header$using$byOutput = Start.on(getNamespace(), "byOutput");
    
    public ParserCombinator procedureDivision$header$using$byOutput() {
      if (procedureDivision$header$using$byOutputParser == null) {
        FutureParser future = scoped("byOutput", PUBLIC, true);
        procedureDivision$header$using$byOutputParser = future;
        future.setParser(
          sequence(
            optional(
              token("BY")
            ),
            token("OUTPUT"),
            star(
              sequence(
                procedureDivision$header$using$arg(),
                procedureDivision$header$using$asTypeName()
              )
            )
          )
        );
      }
    
      return procedureDivision$header$using$byOutputParser;
    }
    
    // ========================================================
    // arg
    // ........................................................
    
    private ParserCombinator procedureDivision$header$using$argParser = null;
    
    public final Start procedureDivision$header$using$arg = Start.on(getNamespace(), "arg");
    
    public ParserCombinator procedureDivision$header$using$arg() {
      if (procedureDivision$header$using$argParser == null) {
        FutureParser future = scoped("arg", PUBLIC, true);
        procedureDivision$header$using$argParser = future;
        future.setParser(
          sequence(
            optional(
              token("UNSIGNED")
            ),
            optional(
              procedureDivision$header$using$arg$sizeIs()
            ),
            optional(
              as("optional",
                token("OPTIONAL")
              )
            ),
            procedureDivision$header$using$arg$value(),
            optional(
              sequence(
                token("DELIMITED"),
                optional(
                  sequence(
                    token("BY"),
                    token("SIZE")
                  )
                )
              )
            )
          )
        );
      }
    
      return procedureDivision$header$using$argParser;
    }
    
    // ========================================================
    // value
    // ........................................................
    
    private ParserCombinator procedureDivision$header$using$arg$valueParser = null;
    
    public final Start procedureDivision$header$using$arg$value = Start.on(getNamespace(), "value");
    
    public ParserCombinator procedureDivision$header$using$arg$value() {
      if (procedureDivision$header$using$arg$valueParser == null) {
        FutureParser future = scoped("value", PUBLIC, true);
        procedureDivision$header$using$arg$valueParser = future;
        future.setParser(
          choice(
            dataName(),
            as("any",
              token("ANY")
            )
          )
        );
      }
    
      return procedureDivision$header$using$arg$valueParser;
    }
    
    // ========================================================
    // sizeIs
    // ........................................................
    
    private ParserCombinator procedureDivision$header$using$arg$sizeIsParser = null;
    
    public final Start procedureDivision$header$using$arg$sizeIs = Start.on(getNamespace(), "sizeIs");
    
    public ParserCombinator procedureDivision$header$using$arg$sizeIs() {
      if (procedureDivision$header$using$arg$sizeIsParser == null) {
        FutureParser future = scoped("sizeIs", PUBLIC, true);
        procedureDivision$header$using$arg$sizeIsParser = future;
        future.setParser(
          sequence(
            token("SIZE"),
            optional(
              token("IS")
            ),
            choice(
              token("AUTO"),
              token("DEFAULT"),
              integer()
            )
          )
        );
      }
    
      return procedureDivision$header$using$arg$sizeIsParser;
    }
    
    // ========================================================
    // repeated
    // ........................................................
    
    private ParserCombinator procedureDivision$header$using$repeatedParser = null;
    
    public final Start procedureDivision$header$using$repeated = Start.on(getNamespace(), "repeated");
    
    public ParserCombinator procedureDivision$header$using$repeated() {
      if (procedureDivision$header$using$repeatedParser == null) {
        FutureParser future = scoped("repeated", PUBLIC, true);
        procedureDivision$header$using$repeatedParser = future;
        future.setParser(
          sequence(
            token("REPEATED"),
            optional(
              sequence(
                integer(),
                token("TO"),
                integer()
              )
            )
          )
        );
      }
    
      return procedureDivision$header$using$repeatedParser;
    }
    
    // ========================================================
    // asTypeName
    // ........................................................
    
    private ParserCombinator procedureDivision$header$using$asTypeNameParser = null;
    
    public final Start procedureDivision$header$using$asTypeName = Start.on(getNamespace(), "asTypeName");
    
    public ParserCombinator procedureDivision$header$using$asTypeName() {
      if (procedureDivision$header$using$asTypeNameParser == null) {
        FutureParser future = scoped("asTypeName", PUBLIC, true);
        procedureDivision$header$using$asTypeNameParser = future;
        future.setParser(
          sequence(
            token("AS"),
            typeName(),
            optional(
              attributeClause()
            )
          )
        );
      }
    
      return procedureDivision$header$using$asTypeNameParser;
    }
    
    // ========================================================
    // returning
    // ........................................................
    
    private ParserCombinator procedureDivision$header$returningParser = null;
    
    public final Start procedureDivision$header$returning = Start.on(getNamespace(), "returning");
    
    public ParserCombinator procedureDivision$header$returning() {
      if (procedureDivision$header$returningParser == null) {
        FutureParser future = scoped("returning", PUBLIC, true);
        procedureDivision$header$returningParser = future;
        future.setParser(
          sequence(
            choice(
              token("RETURNING"),
              token("YIELDING"),
              token("GIVING")
            ),
            dataName(),
            optional(
              sequence(
                token("AS"),
                typeName(),
                optional(
                  attributeClause()
                )
              )
            )
          )
        );
      }
    
      return procedureDivision$header$returningParser;
    }
    
    // ========================================================
    // roundedPhrase
    // ........................................................
    
    private ParserCombinator roundedPhraseParser = null;
    
    public final Start roundedPhrase = Start.on(getNamespace(), "roundedPhrase");
    
    public ParserCombinator roundedPhrase() {
      if (roundedPhraseParser == null) {
        FutureParser future = scoped("roundedPhrase", PUBLIC, true);
        roundedPhraseParser = future;
        future.setParser(
          sequence(
            token("ROUNDED"),
            optional(
              sequence(
                token("MODE"),
                optional(
                  token("IS")
                ),
                choice(
                  token("AWAY-FROM-ZERO"),
                  token("NEAREST-AWAY-FROM-ZERO"),
                  token("NEAREST-EVEN"),
                  token("NEAREST-TOWARD-ZERO"),
                  token("PROHIBITED"),
                  token("TOWARD-GREATER"),
                  token("TOWARD-LESSER"),
                  token("TRUNCATION")
                )
              )
            )
          )
        );
      }
    
      return roundedPhraseParser;
    }
    
    // ========================================================
    // declaratives
    // ........................................................
    
    private ParserCombinator declarativesParser = null;
    
    public final Start declaratives = Start.on(getNamespace(), "declaratives");
    
    public ParserCombinator declaratives() {
      if (declarativesParser == null) {
        FutureParser future = scoped("declaratives", PUBLIC, true);
        declarativesParser = future;
        future.setParser(
          sequence(
            token("DECLARATIVES"),
            literal("."),
            star(
              declarativeSection()
            ),
            token("END"),
            token("DECLARATIVES"),
            literal(".")
          )
        );
      }
    
      return declarativesParser;
    }
    
    // ========================================================
    // declarativeSection
    // ........................................................
    
    private ParserCombinator declarativeSectionParser = null;
    
    public final Start declarativeSection = Start.on(getNamespace(), "declarativeSection");
    
    public ParserCombinator declarativeSection() {
      if (declarativeSectionParser == null) {
        FutureParser future = scoped("declarativeSection", PUBLIC, true);
        declarativeSectionParser = future;
        future.setParser(
          sequence(
            sectionName(),
            token("SECTION"),
            literal("."),
            as("sentence",
              sequence(
                as("statement",
                  useStatement()
                ),
                literal(".")
              )
            ),
            star(
              sentence()
            ),
            star(
              paragraph()
            )
          )
        );
      }
    
      return declarativeSectionParser;
    }
    
    // ========================================================
    // section
    // ........................................................
    
    private ParserCombinator sectionParser = null;
    
    public final Start section = Start.on(getNamespace(), "section");
    
    public ParserCombinator section() {
      if (sectionParser == null) {
        FutureParser future = scoped("section", PUBLIC, true);
        sectionParser = future;
        future.setParser(
          sequence(
            sectionName(),
            token("SECTION"),
            optional(
              segmentNumber()
            ),
            literal("."),
            star(
              sentence()
            ),
            star(
              paragraph()
            )
          )
        );
      }
    
      return sectionParser;
    }
    
    // ========================================================
    // paragraph
    // ........................................................
    
    private ParserCombinator paragraphParser = null;
    
    public final Start paragraph = Start.on(getNamespace(), "paragraph");
    
    public ParserCombinator paragraph() {
      if (paragraphParser == null) {
        FutureParser future = scoped("paragraph", PUBLIC, true);
        paragraphParser = future;
        future.setParser(
          sequence(
            paragraphName(),
            literal("."),
            star(
              sentence()
            )
          )
        );
      }
    
      return paragraphParser;
    }
    
    // ========================================================
    // sentence
    // ........................................................
    
    private ParserCombinator sentenceParser = null;
    
    public final Start sentence = Start.on(getNamespace(), "sentence");
    
    public ParserCombinator sentence() {
      if (sentenceParser == null) {
        FutureParser future = scoped("sentence", PUBLIC, true);
        sentenceParser = future;
        future.setParser(
          choice(
            literal("."),
            compilerStatement(),
            sequence(
              statement(),
              star(
                choice(
                  statement(),
                  compilerStatement(),
                  continuationOfStatement()
                )
              ),
              literal(".")
            )
          )
        );
      }
    
      return sentenceParser;
    }
    
    // ========================================================
    // nestedCopyStatement
    // ........................................................
    
    private ParserCombinator nestedCopyStatementParser = null;
    
    protected final Start nestedCopyStatement = Start.on(getNamespace(), "nestedCopyStatement");
    
    protected ParserCombinator nestedCopyStatement() {
      if (nestedCopyStatementParser == null) {
        FutureParser future = scoped("nestedCopyStatement", PRIVATE, true);
        nestedCopyStatementParser = future;
        future.setParser(
          as("copyStatement",
            sequence(
              copyStatementBody(),
              optional(
                sequence(
                  literal("."),
                  at(
                    choice(
                      literal("."),
                      verb(),
                      endOfStatementMarker(),
                      somethingFollowingAStatement()
                    )
                  )
                )
              )
            )
          )
        );
      }
    
      return nestedCopyStatementParser;
    }
    
    // ========================================================
    // statement
    // ........................................................
    
    private ParserCombinator statementParser = null;
    
    public final Start statement = Start.on(getNamespace(), "statement");
    
    public ParserCombinator statement() {
      if (statementParser == null) {
        FutureParser future = scoped("statement", PUBLIC, true);
        statementParser = future;
        future.setParser(
          choice(
            dispatched(
              new String[]{
                "ACCEPT",
                "ADD",
                "ALTER",
                "CALL",
                "CHAIN",
                "CANCEL",
                "CLOSE",
                "COMMIT",
                "COMPUTE",
                "CONTINUE",
                "DELETE",
                "DISABLE",
                "DISPLAY",
                "DIVIDE",
                "ENABLE",
                "ENTRY",
                "EVALUATE",
                "EXAMINE",
                "EXEC",
                "EXHIBIT",
                "EXIT",
                "GENERATE",
                "GOBACK",
                "GO",
                "IDENTIFIED",
                "IF",
                "INITIATE",
                "INVOKE",
                "MERGE",
                "MOVE",
                "MULTIPLY",
                "NEXT",
                "ON",
                "OPEN",
                "PERFORM",
                "RAISE",
                "READ",
                "READY",
                "RECEIVE",
                "RELEASE",
                "RESET",
                "RETURN",
                "REWRITE",
                "ROLLBACK",
                "PURGE",
                "SEARCH",
                "SEND",
                "SERVICE",
                "SORT",
                "START",
                "STOP",
                "STRING",
                "SUBTRACT",
                "SUPPRESS",
                "TERMINATE",
                "TRANSFORM",
                "UNLOCK",
                "UNSTRING",
                "WAIT",
                "WRITE",
                "XML",
                "SET",
                "INITIALIZE",
                "INSPECT",
                "ALLOCATE",
                "FREE",
                "COPY"
              },
              new ParserCombinator[]{
                acceptStatement(),
                addStatement(),
                alterStatement(),
                callStatement(),
                chainStatement(),
                cancelStatement(),
                closeStatement(),
                commitStatement(),
                computeStatement(),
                continueStatement(),
                choice(
                  deleteFileStatement(),
                  deleteStatement()
                ),
                disableStatement(),
                displayStatement(),
                divideStatement(),
                enableStatement(),
                entryStatement(),
                evaluateStatement(),
                examineStatement(),
                execStatement(),
                exhibitStatement(),
                exitStatement(),
                generateStatement(),
                gobackStatement(),
                goToStatement(),
                identifiedByStatement(),
                ifStatement(),
                initiateStatement(),
                invokeStatement(),
                mergeStatement(),
                moveStatement(),
                multiplyStatement(),
                nextSentenceStatement(),
                onStatement(),
                openStatement(),
                performStatement(),
                raiseStatement(),
                readStatement(),
                readyTraceStatement(),
                receiveStatement(),
                releaseStatement(),
                resetTraceStatement(),
                returnStatement(),
                rewriteStatement(),
                rollbackStatement(),
                purgeStatement(),
                searchStatement(),
                sendStatement(),
                serviceStatement(),
                sortStatement(),
                startStatement(),
                stopStatement(),
                stringStatement(),
                subtractStatement(),
                suppressStatement(),
                terminateStatement(),
                transformStatement(),
                unlockStatement(),
                unstringStatement(),
                waitStatement(),
                writeStatement(),
                choice(
                  xmlGenerateStatement(),
                  xmlParseStatement()
                ),
                setStatement(),
                initializeStatement(),
                inspectStatement(),
                allocateStatement(),
                freeStatement(),
                nestedCopyStatement()
              }
            ),
            sequence(
              verb(),
              optional(
                skipto(
                  choice(
                    endOfStatementMarker(),
                    somethingFollowingAStatement()
                  )
                )
              )
            )
          )
        );
      }
    
      return statementParser;
    }
    
    // ========================================================
    // continuationOfStatement
    // ........................................................
    
    private ParserCombinator continuationOfStatementParser = null;
    
    public final Start continuationOfStatement = Start.on(getNamespace(), "continuationOfStatement");
    
    public ParserCombinator continuationOfStatement() {
      if (continuationOfStatementParser == null) {
        FutureParser future = scoped("continuationOfStatement", PUBLIC, true);
        continuationOfStatementParser = future;
        future.setParser(
          choice(
            sequence(
              assign("t",
                eventPhrase()
              ),
              apply(new Block() {
                public void apply(Parse parse) {
                  Token t = (Token) parse.getStack().getScope().getValue("t");
                  { parse.warn(t, "Nested statement found out of line."); }
                  parse.getStack().getScope().setValue("t", t);
                }
              }),
              statement()
            ),
            sequence(
              assign("t",
                endOfStatementMarker()
              ),
              apply(new Block() {
                public void apply(Parse parse) {
                  Token t = (Token) parse.getStack().getScope().getValue("t");
                  { parse.warn(t, "Loose end of statement."); }
                  parse.getStack().getScope().setValue("t", t);
                }
              })
            )
          )
        );
      }
    
      return continuationOfStatementParser;
    }
    
    // ========================================================
    // nestedStatements
    // ........................................................
    
    private ParserCombinator nestedStatementsParser = null;
    
    public final Start nestedStatements = Start.on(getNamespace(), "nestedStatements");
    
    public ParserCombinator nestedStatements() {
      if (nestedStatementsParser == null) {
        FutureParser future = scoped("nestedStatements", PUBLIC, true);
        nestedStatementsParser = future;
        future.setParser(
          plus(
            statement()
          )
        );
      }
    
      return nestedStatementsParser;
    }
    
    // ========================================================
    // eventPhrase
    // ........................................................
    
    private ParserCombinator eventPhraseParser = null;
    
    protected final Start eventPhrase = Start.on(getNamespace(), "eventPhrase");
    
    protected ParserCombinator eventPhrase() {
      if (eventPhraseParser == null) {
        FutureParser future = scoped("eventPhrase", PRIVATE, true);
        eventPhraseParser = future;
        future.setParser(
          sequence(
            optional(
              token("NOT")
            ),
            optional(
              choice(
                token("ON"),
                token("AT")
              )
            ),
            assign("t",
              eventType()
            ),
            returning("t")
          )
        );
      }
    
      return eventPhraseParser;
    }
    
    // ========================================================
    // eventType
    // ........................................................
    
    private ParserCombinator eventTypeParser = null;
    
    protected final Start eventType = Start.on(getNamespace(), "eventType");
    
    protected ParserCombinator eventType() {
      if (eventTypeParser == null) {
        FutureParser future = scoped("eventType", PRIVATE, true);
        eventTypeParser = future;
        future.setParser(
          sequence(
            choice(
              assign("t",
                token("EXCEPTION")
              ),
              sequence(
                assign("t",
                  token("SIZE")
                ),
                token("ERROR")
              ),
              assign("t",
                token("OVERFLOW")
              ),
              sequence(
                assign("t",
                  token("INVALID")
                ),
                optional(
                  token("KEY")
                )
              ),
              assign("t",
                token("END")
              ),
              assign("t",
                token("END-OF-PAGE")
              ),
              assign("t",
                token("EOP")
              )
            ),
            returning("t")
          )
        );
      }
    
      return eventTypeParser;
    }
    
    // ========================================================
    // retryPhrase
    // ........................................................
    
    private ParserCombinator retryPhraseParser = null;
    
    public final Start retryPhrase = Start.on(getNamespace(), "retryPhrase");
    
    public ParserCombinator retryPhrase() {
      if (retryPhraseParser == null) {
        FutureParser future = scoped("retryPhrase", PUBLIC, true);
        retryPhraseParser = future;
        future.setParser(
          sequence(
            token("RETRY"),
            choice(
              sequence(
                choice(
                  identifier(),
                  integer()
                ),
                token("TIMES")
              ),
              sequence(
                token("FOR"),
                choice(
                  identifier(),
                  integer()
                ),
                token("SECONDS")
              ),
              token("FOREVER")
            )
          )
        );
      }
    
      return retryPhraseParser;
    }
    
    // ========================================================
    // endOfStatementMarker
    // ........................................................
    
    private ParserCombinator endOfStatementMarkerParser = null;
    
    protected final Start endOfStatementMarker = Start.on(getNamespace(), "endOfStatementMarker");
    
    protected ParserCombinator endOfStatementMarker() {
      if (endOfStatementMarkerParser == null) {
        FutureParser future = scoped("endOfStatementMarker", PRIVATE, true);
        endOfStatementMarkerParser = future;
        future.setParser(
          sequence(
            choice(
              assign("t",
                token("END-ACCEPT")
              ),
              assign("t",
                token("END-ADD")
              ),
              assign("t",
                token("END-CALL")
              ),
              assign("t",
                token("END-CHAIN")
              ),
              assign("t",
                token("END-COMPUTE")
              ),
              assign("t",
                token("END-DELETE")
              ),
              assign("t",
                token("END-DIVIDE")
              ),
              assign("t",
                token("END-EVALUATE")
              ),
              assign("t",
                token("END-EXEC")
              ),
              assign("t",
                token("END-IF")
              ),
              assign("t",
                token("END-MULTIPLY")
              ),
              assign("t",
                token("END-PERFORM")
              ),
              assign("t",
                token("END-READ")
              ),
              assign("t",
                token("END-RETURN")
              ),
              assign("t",
                token("END-REWRITE")
              ),
              assign("t",
                token("END-SEARCH")
              ),
              assign("t",
                token("END-START")
              ),
              assign("t",
                token("END-STRING")
              ),
              assign("t",
                token("END-SUBTRACT")
              ),
              assign("t",
                token("END-UNSTRING")
              ),
              assign("t",
                token("END-WAIT")
              ),
              assign("t",
                token("END-WRITE")
              )
            ),
            returning("t")
          )
        );
      }
    
      return endOfStatementMarkerParser;
    }
    
    // ========================================================
    // somethingFollowingAStatement
    // ........................................................
    
    private ParserCombinator somethingFollowingAStatementParser = null;
    
    protected final Start somethingFollowingAStatement = Start.on(getNamespace(), "somethingFollowingAStatement");
    
    protected ParserCombinator somethingFollowingAStatement() {
      if (somethingFollowingAStatementParser == null) {
        FutureParser future = scoped("somethingFollowingAStatement", PRIVATE, true);
        somethingFollowingAStatementParser = future;
        future.setParser(
          choice(
            literal("."),
            verb(),
            token("COPY"),
            token("ELSE"),
            token("WHEN"),
            token("END-ACCEPT"),
            token("END-ADD"),
            token("END-CALL"),
            token("END-CHAIN"),
            token("END-COMPUTE"),
            token("END-DELETE"),
            token("END-DISPLAY"),
            token("END-DIVIDE"),
            token("END-EVALUATE"),
            token("END-EXEC"),
            token("END-IF"),
            token("END-MULTIPLY"),
            token("END-PERFORM"),
            token("END-READ"),
            token("END-RECEIVE"),
            token("END-RETURN"),
            token("END-REWRITE"),
            token("END-SEARCH"),
            token("END-START"),
            token("END-STRING"),
            token("END-SUBTRACT"),
            token("END-UNSTRING"),
            token("END-WAIT"),
            token("END-WRITE"),
            token("END-XML"),
            sequence(
              optional(
                token("NOT")
              ),
              token("INVALID")
            ),
            sequence(
              optional(
                token("NOT")
              ),
              optional(
                token("ON")
              ),
              token("SIZE")
            ),
            sequence(
              optional(
                token("NOT")
              ),
              optional(
                token("ON")
              ),
              token("OVERFLOW")
            ),
            sequence(
              optional(
                token("NOT")
              ),
              optional(
                token("ON")
              ),
              token("EXCEPTION")
            ),
            sequence(
              optional(
                token("NOT")
              ),
              optional(
                token("AT")
              ),
              token("END")
            ),
            sequence(
              optional(
                token("NOT")
              ),
              optional(
                token("AT")
              ),
              token("END-OF-PAGE")
            ),
            sequence(
              optional(
                token("NOT")
              ),
              optional(
                token("AT")
              ),
              token("EOP")
            )
          )
        );
      }
    
      return somethingFollowingAStatementParser;
    }
    
    // ========================================================
    // verb
    // ........................................................
    
    private ParserCombinator verbParser = null;
    
    public final Start verb = Start.on(getNamespace(), "verb");
    
    public ParserCombinator verb() {
      if (verbParser == null) {
        FutureParser future = scoped("verb", PUBLIC, true);
        verbParser = future;
        future.setParser(
          choice(
            token("ADD"),
            token("ALTER"),
            token("CALL"),
            token("CANCEL"),
            token("CHAIN"),
            token("CLOSE"),
            token("COMMIT"),
            token("CONTINUE"),
            token("DELETE"),
            token("DIVIDE"),
            token("EJECT"),
            token("ENTRY"),
            token("EVALUATE"),
            token("EXEC"),
            token("EXIT"),
            token("GENERATE"),
            token("GOBACK"),
            token("GO"),
            token("IDENTIFIED"),
            token("IF"),
            token("INITIATE"),
            token("INVOKE"),
            token("MERGE"),
            token("MOVE"),
            token("MULTIPLY"),
            sequence(
              token("NEXT"),
              token("SENTENCE")
            ),
            token("OPEN"),
            token("PERFORM"),
            token("RAISE"),
            token("READ"),
            sequence(
              token("READY"),
              token("TRACE")
            ),
            token("RELEASE"),
            token("REPLACE"),
            sequence(
              token("RESET"),
              token("TRACE")
            ),
            token("RETURN"),
            token("REWRITE"),
            token("ROLLBACK"),
            token("SEARCH"),
            token("SERVICE"),
            token("SET"),
            token("SKIP1"),
            token("SKIP2"),
            token("SKIP3"),
            token("SORT"),
            token("STOP"),
            token("STRING"),
            token("SUBTRACT"),
            token("SUPPRESS"),
            token("TERMINATE"),
            token("TITLE"),
            token("UNSTRING"),
            token("WAIT"),
            token("WRITE"),
            sequence(
              token("XML"),
              token("GENERATE")
            ),
            sequence(
              token("XML"),
              token("PARSE")
            ),
            token("SET"),
            token("INITIALIZE"),
            token("DISPLAY"),
            token("COMPUTE"),
            token("INSPECT"),
            token("ACCEPT"),
            token("ALLOCATE"),
            token("FREE"),
            token("XML"),
            token("ENABLE"),
            token("DISABLE"),
            token("SEND"),
            token("RECEIVE"),
            token("PURGE"),
            token("START"),
            token("USE")
          )
        );
      }
    
      return verbParser;
    }
    
    // ========================================================
    // acceptStatement
    // ........................................................
    
    private ParserCombinator acceptStatementParser = null;
    
    public final Start acceptStatement = Start.on(getNamespace(), "acceptStatement");
    
    public ParserCombinator acceptStatement() {
      if (acceptStatementParser == null) {
        FutureParser future = scoped("acceptStatement", PUBLIC, true);
        acceptStatementParser = future;
        future.setParser(
          sequence(
            token("ACCEPT"),
            choice(
              acceptFromDate(),
              acceptScreenSizeData(),
              acceptFromCommandLine(),
              acceptFromOther(),
              acceptFromMnemonic(),
              acceptMessageCount(),
              acceptScreenFormat(),
              as("unknown",
                skipto(
                  somethingFollowingAStatement()
                )
              )
            ),
            optional(
              token("END-ACCEPT")
            )
          )
        );
      }
    
      return acceptStatementParser;
    }
    
    // ========================================================
    // acceptFromMnemonic
    // ........................................................
    
    private ParserCombinator acceptFromMnemonicParser = null;
    
    public final Start acceptFromMnemonic = Start.on(getNamespace(), "acceptFromMnemonic");
    
    public ParserCombinator acceptFromMnemonic() {
      if (acceptFromMnemonicParser == null) {
        FutureParser future = scoped("acceptFromMnemonic", PUBLIC, true);
        acceptFromMnemonicParser = future;
        future.setParser(
          sequence(
            identifier_format2(),
            token("FROM"),
            mnemonicName(),
            optional(
              choice(
                onException(),
                onEscape()
              )
            ),
            optional(
              choice(
                notOnException(),
                notOnEscape()
              )
            )
          )
        );
      }
    
      return acceptFromMnemonicParser;
    }
    
    // ========================================================
    // acceptFromOther
    // ........................................................
    
    private ParserCombinator acceptFromOtherParser = null;
    
    public final Start acceptFromOther = Start.on(getNamespace(), "acceptFromOther");
    
    public ParserCombinator acceptFromOther() {
      if (acceptFromOtherParser == null) {
        FutureParser future = scoped("acceptFromOther", PUBLIC, true);
        acceptFromOtherParser = future;
        future.setParser(
          sequence(
            identifier_format2(),
            token("FROM"),
            choice(
              token("TERMINAL-INFO"),
              token("SYSTEM-INFO"),
              sequence(
                token("INPUT"),
                token("STATUS")
              ),
              sequence(
                token("ESCAPE"),
                token("KEY")
              ),
              sequence(
                token("EXCEPTION"),
                token("STATUS")
              ),
              sequence(
                token("LINE"),
                token("NUMBER")
              ),
              sequence(
                token("USER"),
                token("NAME")
              ),
              token("COMMAND-LINE"),
              sequence(
                token("STANDARD"),
                token("OBJECT"),
                identifier()
              ),
              sequence(
                token("THREAD"),
                token("HANDLE")
              ),
              sequence(
                token("WINDOW"),
                token("HANDLE")
              ),
              sequence(
                token("ENVIRONMENT"),
                choice(
                  name(),
                  alphanumericLiteral()
                )
              )
            )
          )
        );
      }
    
      return acceptFromOtherParser;
    }
    
    // ========================================================
    // acceptScreenFormat
    // ........................................................
    
    private ParserCombinator acceptScreenFormatParser = null;
    
    public final Start acceptScreenFormat = Start.on(getNamespace(), "acceptScreenFormat");
    
    public ParserCombinator acceptScreenFormat() {
      if (acceptScreenFormatParser == null) {
        FutureParser future = scoped("acceptScreenFormat", PUBLIC, true);
        acceptScreenFormatParser = future;
        future.setParser(
          sequence(
            choice(
              token("OMITTED"),
              identifier()
            ),
            optional(
              unitPhrase()
            ),
            optional(
              choice(
                dtLineColPositioning(),
                dtAtPositioning()
              )
            ),
            optional(
              sequence(
                token("FROM"),
                token("CRT")
              )
            ),
            optional(
              modeIsBlockPhrase()
            ),
            optional(
              sequence(
                token("WITH"),
                plus(
                  screenEntryPhrase()
                )
              )
            ),
            optional(
              choice(
                onException(),
                onEscape()
              )
            ),
            optional(
              choice(
                notOnException(),
                notOnEscape()
              )
            )
          )
        );
      }
    
      return acceptScreenFormatParser;
    }
    
    // ========================================================
    // acceptFromDate
    // ........................................................
    
    private ParserCombinator acceptFromDateParser = null;
    
    public final Start acceptFromDate = Start.on(getNamespace(), "acceptFromDate");
    
    public ParserCombinator acceptFromDate() {
      if (acceptFromDateParser == null) {
        FutureParser future = scoped("acceptFromDate", PUBLIC, true);
        acceptFromDateParser = future;
        future.setParser(
          sequence(
            identifier_format2(),
            token("FROM"),
            choice(
              sequence(
                token("DATE"),
                optional(
                  choice(
                    token("YYYYMMDD"),
                    token("CENTURY-DATE")
                  )
                )
              ),
              sequence(
                token("DAY"),
                optional(
                  choice(
                    token("YYYYDDD"),
                    token("CENTURY-DAY")
                  )
                )
              ),
              token("DAY-OF-WEEK"),
              token("TIME"),
              token("YEAR"),
              token("YYYYMMDD"),
              token("CENTURY-DATE"),
              token("YYYYDDD"),
              token("CENTURY-DAY")
            )
          )
        );
      }
    
      return acceptFromDateParser;
    }
    
    // ========================================================
    // acceptMessageCount
    // ........................................................
    
    private ParserCombinator acceptMessageCountParser = null;
    
    public final Start acceptMessageCount = Start.on(getNamespace(), "acceptMessageCount");
    
    public ParserCombinator acceptMessageCount() {
      if (acceptMessageCountParser == null) {
        FutureParser future = scoped("acceptMessageCount", PUBLIC, true);
        acceptMessageCountParser = future;
        future.setParser(
          sequence(
            identifier(),
            optional(
              token("MESSAGE")
            ),
            token("COUNT")
          )
        );
      }
    
      return acceptMessageCountParser;
    }
    
    // ========================================================
    // unitPhrase
    // ........................................................
    
    private ParserCombinator unitPhraseParser = null;
    
    public final Start unitPhrase = Start.on(getNamespace(), "unitPhrase");
    
    public ParserCombinator unitPhrase() {
      if (unitPhraseParser == null) {
        FutureParser future = scoped("unitPhrase", PUBLIC, true);
        unitPhraseParser = future;
        future.setParser(
          sequence(
            token("UNIT"),
            choice(
              identifier(),
              literal()
            )
          )
        );
      }
    
      return unitPhraseParser;
    }
    
    // ========================================================
    // modeIsBlockPhrase
    // ........................................................
    
    private ParserCombinator modeIsBlockPhraseParser = null;
    
    public final Start modeIsBlockPhrase = Start.on(getNamespace(), "modeIsBlockPhrase");
    
    public ParserCombinator modeIsBlockPhrase() {
      if (modeIsBlockPhraseParser == null) {
        FutureParser future = scoped("modeIsBlockPhrase", PUBLIC, true);
        modeIsBlockPhraseParser = future;
        future.setParser(
          sequence(
            token("MODE"),
            optional(
              token("IS")
            ),
            token("BLOCK")
          )
        );
      }
    
      return modeIsBlockPhraseParser;
    }
    
    // ========================================================
    // acceptScreenSizeData
    // ........................................................
    
    private ParserCombinator acceptScreenSizeDataParser = null;
    
    public final Start acceptScreenSizeData = Start.on(getNamespace(), "acceptScreenSizeData");
    
    public ParserCombinator acceptScreenSizeData() {
      if (acceptScreenSizeDataParser == null) {
        FutureParser future = scoped("acceptScreenSizeData", PUBLIC, true);
        acceptScreenSizeDataParser = future;
        future.setParser(
          sequence(
            identifier(),
            token("FROM"),
            choice(
              token("LINES"),
              token("COLUMNS")
            )
          )
        );
      }
    
      return acceptScreenSizeDataParser;
    }
    
    // ========================================================
    // acceptFromCommandLine
    // ........................................................
    
    private ParserCombinator acceptFromCommandLineParser = null;
    
    public final Start acceptFromCommandLine = Start.on(getNamespace(), "acceptFromCommandLine");
    
    public ParserCombinator acceptFromCommandLine() {
      if (acceptFromCommandLineParser == null) {
        FutureParser future = scoped("acceptFromCommandLine", PUBLIC, true);
        acceptFromCommandLineParser = future;
        future.setParser(
          sequence(
            identifier(),
            token("FROM"),
            choice(
              token("COMMAND-LINE"),
              token("ARGUMENT-NUMBER"),
              token("ARGUMENT-VALUE")
            )
          )
        );
      }
    
      return acceptFromCommandLineParser;
    }
    
    // ========================================================
    // addStatement
    // ........................................................
    
    private ParserCombinator addStatementParser = null;
    
    public final Start addStatement = Start.on(getNamespace(), "addStatement");
    
    public ParserCombinator addStatement() {
      if (addStatementParser == null) {
        FutureParser future = scoped("addStatement", PUBLIC, true);
        addStatementParser = future;
        future.setParser(
          sequence(
            token("ADD"),
            choice(
              addStatement$format1(),
              addStatement$format2(),
              addStatement$format3()
            ),
            optional(
              onSizeError()
            ),
            optional(
              notOnSizeError()
            ),
            optional(
              token("END-ADD")
            )
          )
        );
      }
    
      return addStatementParser;
    }
    
    // ========================================================
    // format1
    // ........................................................
    
    private ParserCombinator addStatement$format1Parser = null;
    
    protected final Start addStatement$format1 = Start.on(getNamespace(), "format1");
    
    protected ParserCombinator addStatement$format1() {
      if (addStatement$format1Parser == null) {
        FutureParser future = scoped("format1", PRIVATE, true);
        addStatement$format1Parser = future;
        future.setParser(
          sequence(
            as("corresponding",
              sequence(
                choice(
                  token("CORRESPONDING"),
                  token("CORR")
                ),
                as("identifier",
                  qualifiedDataName()
                )
              )
            ),
            as("to",
              sequence(
                token("TO"),
                qualifiedDataName(),
                optional(
                  token("ROUNDED")
                )
              )
            )
          )
        );
      }
    
      return addStatement$format1Parser;
    }
    
    // ========================================================
    // format2
    // ........................................................
    
    private ParserCombinator addStatement$format2Parser = null;
    
    protected final Start addStatement$format2 = Start.on(getNamespace(), "format2");
    
    protected ParserCombinator addStatement$format2() {
      if (addStatement$format2Parser == null) {
        FutureParser future = scoped("format2", PRIVATE, true);
        addStatement$format2Parser = future;
        future.setParser(
          sequence(
            not(
              choice(
                token("CORRESPONDING"),
                token("CORR")
              )
            ),
            plus(
              choice(
                identifier(),
                literal()
              )
            ),
            optional(
              as("to",
                sequence(
                  token("TO"),
                  choice(
                    identifier(),
                    literal()
                  )
                )
              )
            ),
            as("giving",
              sequence(
                token("GIVING"),
                plus(
                  sequence(
                    identifier(),
                    optional(
                      token("ROUNDED")
                    )
                  )
                )
              )
            )
          )
        );
      }
    
      return addStatement$format2Parser;
    }
    
    // ========================================================
    // format3
    // ........................................................
    
    private ParserCombinator addStatement$format3Parser = null;
    
    protected final Start addStatement$format3 = Start.on(getNamespace(), "format3");
    
    protected ParserCombinator addStatement$format3() {
      if (addStatement$format3Parser == null) {
        FutureParser future = scoped("format3", PRIVATE, true);
        addStatement$format3Parser = future;
        future.setParser(
          sequence(
            not(
              choice(
                token("CORRESPONDING"),
                token("CORR")
              )
            ),
            plus(
              choice(
                identifier(),
                literal()
              )
            ),
            as("to",
              sequence(
                token("TO"),
                plus(
                  sequence(
                    identifier(),
                    optional(
                      token("ROUNDED")
                    )
                  )
                )
              )
            )
          )
        );
      }
    
      return addStatement$format3Parser;
    }
    
    // ========================================================
    // allocateStatement
    // ........................................................
    
    private ParserCombinator allocateStatementParser = null;
    
    public final Start allocateStatement = Start.on(getNamespace(), "allocateStatement");
    
    public ParserCombinator allocateStatement() {
      if (allocateStatementParser == null) {
        FutureParser future = scoped("allocateStatement", PUBLIC, true);
        allocateStatementParser = future;
        future.setParser(
          sequence(
            token("ALLOCATE"),
            choice(
              sequence(
                arithmeticExpression(),
                token("CHARACTERS")
              ),
              qualifiedDataName()
            ),
            optional(
              token("INITIALIZED")
            ),
            optional(
              sequence(
                token("RETURNING"),
                qualifiedDataName()
              )
            )
          )
        );
      }
    
      return allocateStatementParser;
    }
    
    // ========================================================
    // alterStatement
    // ........................................................
    
    private ParserCombinator alterStatementParser = null;
    
    public final Start alterStatement = Start.on(getNamespace(), "alterStatement");
    
    public ParserCombinator alterStatement() {
      if (alterStatementParser == null) {
        FutureParser future = scoped("alterStatement", PUBLIC, true);
        alterStatementParser = future;
        future.setParser(
          sequence(
            token("ALTER"),
            plus(
              alterationClause()
            )
          )
        );
      }
    
      return alterStatementParser;
    }
    
    // ========================================================
    // alterationClause
    // ........................................................
    
    private ParserCombinator alterationClauseParser = null;
    
    public final Start alterationClause = Start.on(getNamespace(), "alterationClause");
    
    public ParserCombinator alterationClause() {
      if (alterationClauseParser == null) {
        FutureParser future = scoped("alterationClause", PUBLIC, true);
        alterationClauseParser = future;
        future.setParser(
          sequence(
            procedureName(),
            token("TO"),
            optional(
              sequence(
                token("PROCEED"),
                token("TO")
              )
            ),
            procedureName()
          )
        );
      }
    
      return alterationClauseParser;
    }
    
    // ========================================================
    // callStatement
    // ........................................................
    
    private ParserCombinator callStatementParser = null;
    
    public final Start callStatement = Start.on(getNamespace(), "callStatement");
    
    public ParserCombinator callStatement() {
      if (callStatementParser == null) {
        FutureParser future = scoped("callStatement", PUBLIC, true);
        callStatementParser = future;
        future.setParser(
          sequence(
            token("CALL"),
            choice(
              sequence(
                optional(
                  sequence(
                    callStatement$programName(),
                    token("AS")
                  )
                ),
                token("NESTED")
              ),
              sequence(
                callStatement$programName(),
                token("AS"),
                callStatement$programPrototypeName()
              ),
              sequence(
                as("mnemonicName",
                  identifier()
                ),
                callStatement$programName()
              ),
              callStatement$programName()
            ),
            optional(
              callStatement$using()
            ),
            optional(
              callStatement$giving()
            ),
            optional(
              as("unknown",
                skipto(
                  somethingFollowingAStatement()
                )
              )
            ),
            optional(
              choice(
                onOverflow(),
                permuted(
                  onException(),
                  notOnException()
                )
              )
            ),
            optional(
              token("END-CALL")
            )
          )
        );
      }
    
      return callStatementParser;
    }
    
    // ========================================================
    // programName
    // ........................................................
    
    private ParserCombinator callStatement$programNameParser = null;
    
    public final Start callStatement$programName = Start.on(getNamespace(), "programName");
    
    public ParserCombinator callStatement$programName() {
      if (callStatement$programNameParser == null) {
        FutureParser future = scoped("programName", PUBLIC, true);
        callStatement$programNameParser = future;
        future.setParser(
          choice(
            identifier(),
            alphanumericLiteral()
          )
        );
      }
    
      return callStatement$programNameParser;
    }
    
    // ========================================================
    // programPrototypeName
    // ........................................................
    
    private ParserCombinator callStatement$programPrototypeNameParser = null;
    
    public final Start callStatement$programPrototypeName = Start.on(getNamespace(), "programPrototypeName");
    
    public ParserCombinator callStatement$programPrototypeName() {
      if (callStatement$programPrototypeNameParser == null) {
        FutureParser future = scoped("programPrototypeName", PUBLIC, true);
        callStatement$programPrototypeNameParser = future;
        future.setParser(
          cobolWord()
        );
      }
    
      return callStatement$programPrototypeNameParser;
    }
    
    // ========================================================
    // using
    // ........................................................
    
    private ParserCombinator callStatement$usingParser = null;
    
    public final Start callStatement$using = Start.on(getNamespace(), "using");
    
    public ParserCombinator callStatement$using() {
      if (callStatement$usingParser == null) {
        FutureParser future = scoped("using", PUBLIC, true);
        callStatement$usingParser = future;
        future.setParser(
          sequence(
            token("USING"),
            plus(
              choice(
                callStatement$using$byReference(),
                callStatement$using$byContent(),
                callStatement$using$byValue(),
                copyStatement()
              )
            )
          )
        );
      }
    
      return callStatement$usingParser;
    }
    
    // ========================================================
    // byReference
    // ........................................................
    
    private ParserCombinator callStatement$using$byReferenceParser = null;
    
    public final Start callStatement$using$byReference = Start.on(getNamespace(), "byReference");
    
    public ParserCombinator callStatement$using$byReference() {
      if (callStatement$using$byReferenceParser == null) {
        FutureParser future = scoped("byReference", PUBLIC, true);
        callStatement$using$byReferenceParser = future;
        future.setParser(
          sequence(
            optional(
              sequence(
                optional(
                  token("BY")
                ),
                token("REFERENCE")
              )
            ),
            plus(
              callStatement$using$arg()
            )
          )
        );
      }
    
      return callStatement$using$byReferenceParser;
    }
    
    // ========================================================
    // byContent
    // ........................................................
    
    private ParserCombinator callStatement$using$byContentParser = null;
    
    public final Start callStatement$using$byContent = Start.on(getNamespace(), "byContent");
    
    public ParserCombinator callStatement$using$byContent() {
      if (callStatement$using$byContentParser == null) {
        FutureParser future = scoped("byContent", PUBLIC, true);
        callStatement$using$byContentParser = future;
        future.setParser(
          sequence(
            optional(
              token("BY")
            ),
            token("CONTENT"),
            plus(
              callStatement$using$arg()
            )
          )
        );
      }
    
      return callStatement$using$byContentParser;
    }
    
    // ========================================================
    // byValue
    // ........................................................
    
    private ParserCombinator callStatement$using$byValueParser = null;
    
    public final Start callStatement$using$byValue = Start.on(getNamespace(), "byValue");
    
    public ParserCombinator callStatement$using$byValue() {
      if (callStatement$using$byValueParser == null) {
        FutureParser future = scoped("byValue", PUBLIC, true);
        callStatement$using$byValueParser = future;
        future.setParser(
          sequence(
            optional(
              token("BY")
            ),
            token("VALUE"),
            plus(
              callStatement$using$arg()
            )
          )
        );
      }
    
      return callStatement$using$byValueParser;
    }
    
    // ========================================================
    // arg
    // ........................................................
    
    private ParserCombinator callStatement$using$argParser = null;
    
    public final Start callStatement$using$arg = Start.on(getNamespace(), "arg");
    
    public ParserCombinator callStatement$using$arg() {
      if (callStatement$using$argParser == null) {
        FutureParser future = scoped("arg", PUBLIC, true);
        callStatement$using$argParser = future;
        future.setParser(
          sequence(
            optional(
              token("UNSIGNED")
            ),
            optional(
              callStatement$using$arg$sizeIs()
            ),
            callStatement$using$arg$value()
          )
        );
      }
    
      return callStatement$using$argParser;
    }
    
    // ========================================================
    // value
    // ........................................................
    
    private ParserCombinator callStatement$using$arg$valueParser = null;
    
    public final Start callStatement$using$arg$value = Start.on(getNamespace(), "value");
    
    public ParserCombinator callStatement$using$arg$value() {
      if (callStatement$using$arg$valueParser == null) {
        FutureParser future = scoped("value", PUBLIC, true);
        callStatement$using$arg$valueParser = future;
        future.setParser(
          choice(
            addressOf(),
            lengthOf(),
            as("omitted",
              token("OMITTED")
            ),
            sequence(
              identifier(),
              not(
                moreArithmeticOp()
              )
            ),
            sequence(
              literal(),
              not(
                moreArithmeticOp()
              )
            ),
            arithmeticExpression()
          )
        );
      }
    
      return callStatement$using$arg$valueParser;
    }
    
    // ========================================================
    // sizeIs
    // ........................................................
    
    private ParserCombinator callStatement$using$arg$sizeIsParser = null;
    
    public final Start callStatement$using$arg$sizeIs = Start.on(getNamespace(), "sizeIs");
    
    public ParserCombinator callStatement$using$arg$sizeIs() {
      if (callStatement$using$arg$sizeIsParser == null) {
        FutureParser future = scoped("sizeIs", PUBLIC, true);
        callStatement$using$arg$sizeIsParser = future;
        future.setParser(
          sequence(
            token("SIZE"),
            optional(
              token("IS")
            ),
            choice(
              token("AUTO"),
              token("DEFAULT"),
              integer()
            )
          )
        );
      }
    
      return callStatement$using$arg$sizeIsParser;
    }
    
    // ========================================================
    // giving
    // ........................................................
    
    private ParserCombinator callStatement$givingParser = null;
    
    public final Start callStatement$giving = Start.on(getNamespace(), "giving");
    
    public ParserCombinator callStatement$giving() {
      if (callStatement$givingParser == null) {
        FutureParser future = scoped("giving", PUBLIC, true);
        callStatement$givingParser = future;
        future.setParser(
          sequence(
            choice(
              token("GIVING"),
              token("RETURNING")
            ),
            choice(
              addressOf(),
              sequence(
                optional(
                  token("INTO")
                ),
                identifier()
              )
            )
          )
        );
      }
    
      return callStatement$givingParser;
    }
    
    // ========================================================
    // cancelStatement
    // ........................................................
    
    private ParserCombinator cancelStatementParser = null;
    
    public final Start cancelStatement = Start.on(getNamespace(), "cancelStatement");
    
    public ParserCombinator cancelStatement() {
      if (cancelStatementParser == null) {
        FutureParser future = scoped("cancelStatement", PUBLIC, true);
        cancelStatementParser = future;
        future.setParser(
          sequence(
            token("CANCEL"),
            plus(
              choice(
                identifier(),
                alphanumeric()
              )
            )
          )
        );
      }
    
      return cancelStatementParser;
    }
    
    // ========================================================
    // chainStatement
    // ........................................................
    
    private ParserCombinator chainStatementParser = null;
    
    public final Start chainStatement = Start.on(getNamespace(), "chainStatement");
    
    public ParserCombinator chainStatement() {
      if (chainStatementParser == null) {
        FutureParser future = scoped("chainStatement", PUBLIC, true);
        chainStatementParser = future;
        future.setParser(
          sequence(
            token("CHAIN"),
            choice(
              identifier(),
              literal()
            ),
            optional(
              chainUsing()
            ),
            optional(
              token("END-CHAIN")
            )
          )
        );
      }
    
      return chainStatementParser;
    }
    
    // ========================================================
    // chainUsing
    // ........................................................
    
    private ParserCombinator chainUsingParser = null;
    
    public final Start chainUsing = Start.on(getNamespace(), "chainUsing");
    
    public ParserCombinator chainUsing() {
      if (chainUsingParser == null) {
        FutureParser future = scoped("chainUsing", PUBLIC, true);
        chainUsingParser = future;
        future.setParser(
          sequence(
            token("USING"),
            star(
              choice(
                literal(),
                identifier()
              )
            ),
            star(
              choice(
                sequence(
                  optional(
                    token("BY")
                  ),
                  token("REFERENCE"),
                  plus(
                    choice(
                      addressOf(),
                      identifier(),
                      token("OMITTED"),
                      literal()
                    )
                  )
                ),
                sequence(
                  optional(
                    token("BY")
                  ),
                  token("CONTENT"),
                  plus(
                    choice(
                      literal(),
                      identifier()
                    )
                  )
                ),
                sequence(
                  optional(
                    token("BY")
                  ),
                  token("VALUE"),
                  plus(
                    choice(
                      identifier(),
                      sequence(
                        integer(),
                        optional(
                          sequence(
                            token("SIZE"),
                            optional(
                              token("IS")
                            ),
                            integer()
                          )
                        )
                      ),
                      literal()
                    )
                  )
                )
              )
            )
          )
        );
      }
    
      return chainUsingParser;
    }
    
    // ========================================================
    // closeStatement
    // ........................................................
    
    private ParserCombinator closeStatementParser = null;
    
    public final Start closeStatement = Start.on(getNamespace(), "closeStatement");
    
    public ParserCombinator closeStatement() {
      if (closeStatementParser == null) {
        FutureParser future = scoped("closeStatement", PUBLIC, true);
        closeStatementParser = future;
        future.setParser(
          sequence(
            token("CLOSE"),
            plus(
              sequence(
                fileName(),
                optional(
                  choice(
                    sequence(
                      optional(
                        token("WITH")
                      ),
                      choice(
                        sequence(
                          token("NO"),
                          token("REWIND")
                        ),
                        token("LOCK")
                      )
                    ),
                    sequence(
                      choice(
                        token("REEL"),
                        token("UNIT")
                      ),
                      optional(
                        sequence(
                          optional(
                            token("FOR")
                          ),
                          token("REMOVAL")
                        )
                      )
                    ),
                    sequence(
                      optional(
                        token("FOR")
                      ),
                      token("REMOVAL")
                    )
                  )
                )
              )
            )
          )
        );
      }
    
      return closeStatementParser;
    }
    
    // ========================================================
    // commitStatement
    // ........................................................
    
    private ParserCombinator commitStatementParser = null;
    
    public final Start commitStatement = Start.on(getNamespace(), "commitStatement");
    
    public ParserCombinator commitStatement() {
      if (commitStatementParser == null) {
        FutureParser future = scoped("commitStatement", PUBLIC, true);
        commitStatementParser = future;
        future.setParser(
          sequence(
            token("COMMIT"),
            optional(
              token("TRANSACTION")
            )
          )
        );
      }
    
      return commitStatementParser;
    }
    
    // ========================================================
    // computeStatement
    // ........................................................
    
    private ParserCombinator computeStatementParser = null;
    
    public final Start computeStatement = Start.on(getNamespace(), "computeStatement");
    
    public ParserCombinator computeStatement() {
      if (computeStatementParser == null) {
        FutureParser future = scoped("computeStatement", PUBLIC, true);
        computeStatementParser = future;
        future.setParser(
          sequence(
            token("COMPUTE"),
            plus(
              sequence(
                qualifiedDataName(),
                optional(
                  token("ROUNDED")
                )
              )
            ),
            choice(
              literal("="),
              token("EQUAL")
            ),
            arithmeticExpression(),
            optional(
              onSizeError()
            ),
            optional(
              notOnSizeError()
            ),
            optional(
              token("END-COMPUTE")
            )
          )
        );
      }
    
      return computeStatementParser;
    }
    
    // ========================================================
    // continueStatement
    // ........................................................
    
    private ParserCombinator continueStatementParser = null;
    
    public final Start continueStatement = Start.on(getNamespace(), "continueStatement");
    
    public ParserCombinator continueStatement() {
      if (continueStatementParser == null) {
        FutureParser future = scoped("continueStatement", PUBLIC, true);
        continueStatementParser = future;
        future.setParser(
          token("CONTINUE")
        );
      }
    
      return continueStatementParser;
    }
    
    // ========================================================
    // deleteStatement
    // ........................................................
    
    private ParserCombinator deleteStatementParser = null;
    
    public final Start deleteStatement = Start.on(getNamespace(), "deleteStatement");
    
    public ParserCombinator deleteStatement() {
      if (deleteStatementParser == null) {
        FutureParser future = scoped("deleteStatement", PUBLIC, true);
        deleteStatementParser = future;
        future.setParser(
          sequence(
            token("DELETE"),
            fileName(),
            optional(
              token("RECORD")
            ),
            optional(
              invalidKey()
            ),
            optional(
              notInvalidKey()
            ),
            optional(
              token("END-DELETE")
            )
          )
        );
      }
    
      return deleteStatementParser;
    }
    
    // ========================================================
    // invalidKey
    // ........................................................
    
    private ParserCombinator invalidKeyParser = null;
    
    public final Start invalidKey = Start.on(getNamespace(), "invalidKey");
    
    public ParserCombinator invalidKey() {
      if (invalidKeyParser == null) {
        FutureParser future = scoped("invalidKey", PUBLIC, true);
        invalidKeyParser = future;
        future.setParser(
          sequence(
            token("INVALID"),
            optional(
              token("KEY")
            ),
            nestedStatements()
          )
        );
      }
    
      return invalidKeyParser;
    }
    
    // ========================================================
    // notInvalidKey
    // ........................................................
    
    private ParserCombinator notInvalidKeyParser = null;
    
    public final Start notInvalidKey = Start.on(getNamespace(), "notInvalidKey");
    
    public ParserCombinator notInvalidKey() {
      if (notInvalidKeyParser == null) {
        FutureParser future = scoped("notInvalidKey", PUBLIC, true);
        notInvalidKeyParser = future;
        future.setParser(
          sequence(
            token("NOT"),
            token("INVALID"),
            optional(
              token("KEY")
            ),
            nestedStatements()
          )
        );
      }
    
      return notInvalidKeyParser;
    }
    
    // ========================================================
    // deleteFileStatement
    // ........................................................
    
    private ParserCombinator deleteFileStatementParser = null;
    
    public final Start deleteFileStatement = Start.on(getNamespace(), "deleteFileStatement");
    
    public ParserCombinator deleteFileStatement() {
      if (deleteFileStatementParser == null) {
        FutureParser future = scoped("deleteFileStatement", PUBLIC, true);
        deleteFileStatementParser = future;
        future.setParser(
          sequence(
            token("DELETE"),
            token("FILE"),
            plus(
              fileName()
            )
          )
        );
      }
    
      return deleteFileStatementParser;
    }
    
    // ========================================================
    // disableStatement
    // ........................................................
    
    private ParserCombinator disableStatementParser = null;
    
    public final Start disableStatement = Start.on(getNamespace(), "disableStatement");
    
    public ParserCombinator disableStatement() {
      if (disableStatementParser == null) {
        FutureParser future = scoped("disableStatement", PUBLIC, true);
        disableStatementParser = future;
        future.setParser(
          sequence(
            token("DISABLE"),
            choice(
              sequence(
                token("INPUT"),
                optional(
                  token("TERMINAL")
                )
              ),
              sequence(
                token("I-O"),
                token("TERMINAL")
              ),
              token("OUTPUT")
            ),
            cdName(),
            optional(
              token("WITH")
            ),
            token("KEY"),
            choice(
              literal(),
              identifier()
            )
          )
        );
      }
    
      return disableStatementParser;
    }
    
    // ========================================================
    // displayStatement
    // ........................................................
    
    private ParserCombinator displayStatementParser = null;
    
    public final Start displayStatement = Start.on(getNamespace(), "displayStatement");
    
    public ParserCombinator displayStatement() {
      if (displayStatementParser == null) {
        FutureParser future = scoped("displayStatement", PUBLIC, true);
        displayStatementParser = future;
        future.setParser(
          sequence(
            token("DISPLAY"),
            plus(
              choice(
                token("OMITTED"),
                identifier(),
                literal()
              )
            ),
            star(
              choice(
                uponClause(),
                withNoAdvancing(),
                sequence(
                  token("UNIT"),
                  choice(
                    identifier(),
                    literal()
                  )
                ),
                dtAtPositioning(),
                dtLineColPositioning(),
                uponClause(),
                modeIsBlockPhrase(),
                sequence(
                  optional(
                    token("WITH")
                  ),
                  plus(
                    screenEntryPhrase()
                  )
                )
              )
            ),
            optional(
              onException()
            ),
            optional(
              notOnException()
            ),
            optional(
              token("END-DISPLAY")
            )
          )
        );
      }
    
      return displayStatementParser;
    }
    
    // ========================================================
    // displayStatement__
    // ........................................................
    
    private ParserCombinator displayStatement__Parser = null;
    
    public final Start displayStatement__ = Start.on(getNamespace(), "displayStatement__");
    
    public ParserCombinator displayStatement__() {
      if (displayStatement__Parser == null) {
        FutureParser future = scoped("displayStatement__", PUBLIC, true);
        displayStatement__Parser = future;
        future.setParser(
          sequence(
            token("DISPLAY"),
            choice(
              displayTerminalFormat(),
              displayDeviceFormat(),
              as("unknown",
                skipto(
                  somethingFollowingAStatement()
                )
              )
            ),
            optional(
              token("END-DISPLAY")
            )
          )
        );
      }
    
      return displayStatement__Parser;
    }
    
    // ========================================================
    // displayDeviceFormat
    // ........................................................
    
    private ParserCombinator displayDeviceFormatParser = null;
    
    public final Start displayDeviceFormat = Start.on(getNamespace(), "displayDeviceFormat");
    
    public ParserCombinator displayDeviceFormat() {
      if (displayDeviceFormatParser == null) {
        FutureParser future = scoped("displayDeviceFormat", PUBLIC, true);
        displayDeviceFormatParser = future;
        future.setParser(
          sequence(
            plus(
              choice(
                identifier(),
                literal()
              )
            ),
            optional(
              uponClause()
            ),
            optional(
              withNoAdvancing()
            ),
            optional(
              onException()
            ),
            optional(
              notOnException()
            )
          )
        );
      }
    
      return displayDeviceFormatParser;
    }
    
    // ========================================================
    // uponClause
    // ........................................................
    
    private ParserCombinator uponClauseParser = null;
    
    public final Start uponClause = Start.on(getNamespace(), "uponClause");
    
    public ParserCombinator uponClause() {
      if (uponClauseParser == null) {
        FutureParser future = scoped("uponClause", PUBLIC, true);
        uponClauseParser = future;
        future.setParser(
          sequence(
            token("UPON"),
            choice(
              token("ARGUMENT-NUMBER"),
              token("COMMAND-LINE"),
              token("ENVIRONMENT-VALUE"),
              token("ENVIRONMENT-NAME"),
              environmentName(),
              mnemonicName()
            )
          )
        );
      }
    
      return uponClauseParser;
    }
    
    // ========================================================
    // withNoAdvancing
    // ........................................................
    
    private ParserCombinator withNoAdvancingParser = null;
    
    public final Start withNoAdvancing = Start.on(getNamespace(), "withNoAdvancing");
    
    public ParserCombinator withNoAdvancing() {
      if (withNoAdvancingParser == null) {
        FutureParser future = scoped("withNoAdvancing", PUBLIC, true);
        withNoAdvancingParser = future;
        future.setParser(
          sequence(
            optional(
              token("WITH")
            ),
            token("NO"),
            token("ADVANCING")
          )
        );
      }
    
      return withNoAdvancingParser;
    }
    
    // ========================================================
    // displayTerminalFormat
    // ........................................................
    
    private ParserCombinator displayTerminalFormatParser = null;
    
    public final Start displayTerminalFormat = Start.on(getNamespace(), "displayTerminalFormat");
    
    public ParserCombinator displayTerminalFormat() {
      if (displayTerminalFormatParser == null) {
        FutureParser future = scoped("displayTerminalFormat", PUBLIC, true);
        displayTerminalFormatParser = future;
        future.setParser(
          plus(
            sequence(
              choice(
                token("OMITTED"),
                identifier(),
                literal()
              ),
              optional(
                sequence(
                  token("UNIT"),
                  choice(
                    identifier(),
                    literal()
                  )
                )
              ),
              choice(
                dtAtPositioning(),
                dtLineColPositioning()
              ),
              optional(
                uponClause()
              ),
              optional(
                modeIsBlockPhrase()
              ),
              optional(
                sequence(
                  optional(
                    token("WITH")
                  ),
                  plus(
                    screenEntryPhrase()
                  )
                )
              )
            )
          )
        );
      }
    
      return displayTerminalFormatParser;
    }
    
    // ========================================================
    // dtAtPositioning
    // ........................................................
    
    private ParserCombinator dtAtPositioningParser = null;
    
    public final Start dtAtPositioning = Start.on(getNamespace(), "dtAtPositioning");
    
    public ParserCombinator dtAtPositioning() {
      if (dtAtPositioningParser == null) {
        FutureParser future = scoped("dtAtPositioning", PUBLIC, true);
        dtAtPositioningParser = future;
        future.setParser(
          sequence(
            token("AT"),
            choice(
              identifier(),
              literal()
            )
          )
        );
      }
    
      return dtAtPositioningParser;
    }
    
    // ========================================================
    // dtLineColPositioning
    // ........................................................
    
    private ParserCombinator dtLineColPositioningParser = null;
    
    public final Start dtLineColPositioning = Start.on(getNamespace(), "dtLineColPositioning");
    
    public ParserCombinator dtLineColPositioning() {
      if (dtLineColPositioningParser == null) {
        FutureParser future = scoped("dtLineColPositioning", PUBLIC, true);
        dtLineColPositioningParser = future;
        future.setParser(
          sequence(
            optional(
              choice(
                token("AT"),
                token("FROM")
              )
            ),
            choice(
              sequence(
                dtLinePos(),
                optional(
                  dtColPos()
                )
              ),
              sequence(
                dtColPos(),
                optional(
                  dtLinePos()
                )
              )
            )
          )
        );
      }
    
      return dtLineColPositioningParser;
    }
    
    // ========================================================
    // dtLinePos
    // ........................................................
    
    private ParserCombinator dtLinePosParser = null;
    
    public final Start dtLinePos = Start.on(getNamespace(), "dtLinePos");
    
    public ParserCombinator dtLinePos() {
      if (dtLinePosParser == null) {
        FutureParser future = scoped("dtLinePos", PUBLIC, true);
        dtLinePosParser = future;
        future.setParser(
          sequence(
            token("LINE"),
            optional(
              token("NUMBER")
            ),
            optional(
              token("IS")
            ),
            optional(
              choice(
                token("PLUS"),
                literal("+"),
                literal("-")
              )
            ),
            choice(
              identifier(),
              literal()
            )
          )
        );
      }
    
      return dtLinePosParser;
    }
    
    // ========================================================
    // dtColPos
    // ........................................................
    
    private ParserCombinator dtColPosParser = null;
    
    public final Start dtColPos = Start.on(getNamespace(), "dtColPos");
    
    public ParserCombinator dtColPos() {
      if (dtColPosParser == null) {
        FutureParser future = scoped("dtColPos", PUBLIC, true);
        dtColPosParser = future;
        future.setParser(
          sequence(
            choice(
              token("COL"),
              token("COLUMN"),
              token("POSITION"),
              token("POS")
            ),
            optional(
              token("NUMBER")
            ),
            optional(
              token("IS")
            ),
            optional(
              choice(
                token("PLUS"),
                literal("+"),
                literal("-")
              )
            ),
            choice(
              identifier(),
              literal()
            )
          )
        );
      }
    
      return dtColPosParser;
    }
    
    // ========================================================
    // screenEntryPhrase
    // ........................................................
    
    private ParserCombinator screenEntryPhraseParser = null;
    
    public final Start screenEntryPhrase = Start.on(getNamespace(), "screenEntryPhrase");
    
    public ParserCombinator screenEntryPhrase() {
      if (screenEntryPhraseParser == null) {
        FutureParser future = scoped("screenEntryPhrase", PUBLIC, true);
        screenEntryPhraseParser = future;
        future.setParser(
          choice(
            autoPhrase(),
            beepPhrase(),
            blankPhrase(),
            blankWhenZero(),
            blinkPhrase(),
            boldPhrase(),
            capitalizationPhrase(),
            controlPhrase(),
            convertPhrase(),
            cursorPhrase(),
            echoPhrase(),
            erasePhrase(),
            fillPhrase(),
            fullPhrase(),
            gridPhrase(),
            justificationPhrase(),
            justified(),
            highPhrase(),
            lowPhrase(),
            linePhrase(),
            offPhrase(),
            pictureClause(),
            promptPhrase(),
            requiredPhrase(),
            reversePhrase(),
            scrollPhrase(),
            securePhrase(),
            sizePhrase(),
            standardPhrase(),
            foregroundPhrase(),
            backgroundPhrase(),
            timeoutPhrase(),
            trailingSignPhrase(),
            tabPhrase(),
            timePhrase(),
            updatePhrase()
          )
        );
      }
    
      return screenEntryPhraseParser;
    }
    
    // ========================================================
    // autoPhrase
    // ........................................................
    
    private ParserCombinator autoPhraseParser = null;
    
    public final Start autoPhrase = Start.on(getNamespace(), "autoPhrase");
    
    public ParserCombinator autoPhrase() {
      if (autoPhraseParser == null) {
        FutureParser future = scoped("autoPhrase", PUBLIC, true);
        autoPhraseParser = future;
        future.setParser(
          choice(
            token("AUTO"),
            token("AUTO-SKIP")
          )
        );
      }
    
      return autoPhraseParser;
    }
    
    // ========================================================
    // backgroundPhrase
    // ........................................................
    
    private ParserCombinator backgroundPhraseParser = null;
    
    public final Start backgroundPhrase = Start.on(getNamespace(), "backgroundPhrase");
    
    public ParserCombinator backgroundPhrase() {
      if (backgroundPhraseParser == null) {
        FutureParser future = scoped("backgroundPhrase", PUBLIC, true);
        backgroundPhraseParser = future;
        future.setParser(
          sequence(
            choice(
              token("BACKGROUND-COLOR"),
              token("BACKGROUND-COLOUR")
            ),
            optional(
              token("IS")
            ),
            integer()
          )
        );
      }
    
      return backgroundPhraseParser;
    }
    
    // ========================================================
    // beepPhrase
    // ........................................................
    
    private ParserCombinator beepPhraseParser = null;
    
    public final Start beepPhrase = Start.on(getNamespace(), "beepPhrase");
    
    public ParserCombinator beepPhrase() {
      if (beepPhraseParser == null) {
        FutureParser future = scoped("beepPhrase", PUBLIC, true);
        beepPhraseParser = future;
        future.setParser(
          sequence(
            optional(
              token("NO")
            ),
            choice(
              token("BEEP"),
              token("BELL")
            )
          )
        );
      }
    
      return beepPhraseParser;
    }
    
    // ========================================================
    // blankPhrase
    // ........................................................
    
    private ParserCombinator blankPhraseParser = null;
    
    public final Start blankPhrase = Start.on(getNamespace(), "blankPhrase");
    
    public ParserCombinator blankPhrase() {
      if (blankPhraseParser == null) {
        FutureParser future = scoped("blankPhrase", PUBLIC, true);
        blankPhraseParser = future;
        future.setParser(
          sequence(
            token("BLANK"),
            choice(
              token("SCREEN"),
              token("LINE")
            )
          )
        );
      }
    
      return blankPhraseParser;
    }
    
    // ========================================================
    // blinkPhrase
    // ........................................................
    
    private ParserCombinator blinkPhraseParser = null;
    
    public final Start blinkPhrase = Start.on(getNamespace(), "blinkPhrase");
    
    public ParserCombinator blinkPhrase() {
      if (blinkPhraseParser == null) {
        FutureParser future = scoped("blinkPhrase", PUBLIC, true);
        blinkPhraseParser = future;
        future.setParser(
          choice(
            token("BLINKING"),
            token("BLINK")
          )
        );
      }
    
      return blinkPhraseParser;
    }
    
    // ========================================================
    // boldPhrase
    // ........................................................
    
    private ParserCombinator boldPhraseParser = null;
    
    public final Start boldPhrase = Start.on(getNamespace(), "boldPhrase");
    
    public ParserCombinator boldPhrase() {
      if (boldPhraseParser == null) {
        FutureParser future = scoped("boldPhrase", PUBLIC, true);
        boldPhraseParser = future;
        future.setParser(
          token("BOLD")
        );
      }
    
      return boldPhraseParser;
    }
    
    // ========================================================
    // capitalizationPhrase
    // ........................................................
    
    private ParserCombinator capitalizationPhraseParser = null;
    
    public final Start capitalizationPhrase = Start.on(getNamespace(), "capitalizationPhrase");
    
    public ParserCombinator capitalizationPhrase() {
      if (capitalizationPhraseParser == null) {
        FutureParser future = scoped("capitalizationPhrase", PUBLIC, true);
        capitalizationPhraseParser = future;
        future.setParser(
          choice(
            token("UPPER"),
            token("LOWER")
          )
        );
      }
    
      return capitalizationPhraseParser;
    }
    
    // ========================================================
    // controlPhrase
    // ........................................................
    
    private ParserCombinator controlPhraseParser = null;
    
    public final Start controlPhrase = Start.on(getNamespace(), "controlPhrase");
    
    public ParserCombinator controlPhrase() {
      if (controlPhraseParser == null) {
        FutureParser future = scoped("controlPhrase", PUBLIC, true);
        controlPhraseParser = future;
        future.setParser(
          sequence(
            token("CONTROL"),
            optional(
              token("IS")
            ),
            choice(
              identifier_format2(),
              literal()
            )
          )
        );
      }
    
      return controlPhraseParser;
    }
    
    // ========================================================
    // convertPhrase
    // ........................................................
    
    private ParserCombinator convertPhraseParser = null;
    
    public final Start convertPhrase = Start.on(getNamespace(), "convertPhrase");
    
    public ParserCombinator convertPhrase() {
      if (convertPhraseParser == null) {
        FutureParser future = scoped("convertPhrase", PUBLIC, true);
        convertPhraseParser = future;
        future.setParser(
          choice(
            token("CONVERT"),
            token("CONVERSION")
          )
        );
      }
    
      return convertPhraseParser;
    }
    
    // ========================================================
    // cursorPhrase
    // ........................................................
    
    private ParserCombinator cursorPhraseParser = null;
    
    public final Start cursorPhrase = Start.on(getNamespace(), "cursorPhrase");
    
    public ParserCombinator cursorPhrase() {
      if (cursorPhraseParser == null) {
        FutureParser future = scoped("cursorPhrase", PUBLIC, true);
        cursorPhraseParser = future;
        future.setParser(
          sequence(
            token("CURSOR"),
            choice(
              identifier(),
              literal()
            )
          )
        );
      }
    
      return cursorPhraseParser;
    }
    
    // ========================================================
    // echoPhrase
    // ........................................................
    
    private ParserCombinator echoPhraseParser = null;
    
    public final Start echoPhrase = Start.on(getNamespace(), "echoPhrase");
    
    public ParserCombinator echoPhrase() {
      if (echoPhraseParser == null) {
        FutureParser future = scoped("echoPhrase", PUBLIC, true);
        echoPhraseParser = future;
        future.setParser(
          token("ECHO")
        );
      }
    
      return echoPhraseParser;
    }
    
    // ========================================================
    // erasePhrase
    // ........................................................
    
    private ParserCombinator erasePhraseParser = null;
    
    public final Start erasePhrase = Start.on(getNamespace(), "erasePhrase");
    
    public ParserCombinator erasePhrase() {
      if (erasePhraseParser == null) {
        FutureParser future = scoped("erasePhrase", PUBLIC, true);
        erasePhraseParser = future;
        future.setParser(
          sequence(
            token("ERASE"),
            optional(
              choice(
                token("EOL"),
                token("EOS")
              )
            )
          )
        );
      }
    
      return erasePhraseParser;
    }
    
    // ========================================================
    // foregroundPhrase
    // ........................................................
    
    private ParserCombinator foregroundPhraseParser = null;
    
    public final Start foregroundPhrase = Start.on(getNamespace(), "foregroundPhrase");
    
    public ParserCombinator foregroundPhrase() {
      if (foregroundPhraseParser == null) {
        FutureParser future = scoped("foregroundPhrase", PUBLIC, true);
        foregroundPhraseParser = future;
        future.setParser(
          sequence(
            choice(
              token("FOREGROUND-COLOR"),
              token("FOREGROUND-COLOUR")
            ),
            optional(
              token("IS")
            ),
            integer()
          )
        );
      }
    
      return foregroundPhraseParser;
    }
    
    // ========================================================
    // fullPhrase
    // ........................................................
    
    private ParserCombinator fullPhraseParser = null;
    
    public final Start fullPhrase = Start.on(getNamespace(), "fullPhrase");
    
    public ParserCombinator fullPhrase() {
      if (fullPhraseParser == null) {
        FutureParser future = scoped("fullPhrase", PUBLIC, true);
        fullPhraseParser = future;
        future.setParser(
          choice(
            token("FULL"),
            token("LENGTH-CHECK")
          )
        );
      }
    
      return fullPhraseParser;
    }
    
    // ========================================================
    // gridPhrase
    // ........................................................
    
    private ParserCombinator gridPhraseParser = null;
    
    public final Start gridPhrase = Start.on(getNamespace(), "gridPhrase");
    
    public ParserCombinator gridPhrase() {
      if (gridPhraseParser == null) {
        FutureParser future = scoped("gridPhrase", PUBLIC, true);
        gridPhraseParser = future;
        future.setParser(
          token("GRID")
        );
      }
    
      return gridPhraseParser;
    }
    
    // ========================================================
    // highPhrase
    // ........................................................
    
    private ParserCombinator highPhraseParser = null;
    
    public final Start highPhrase = Start.on(getNamespace(), "highPhrase");
    
    public ParserCombinator highPhrase() {
      if (highPhraseParser == null) {
        FutureParser future = scoped("highPhrase", PUBLIC, true);
        highPhraseParser = future;
        future.setParser(
          choice(
            token("HIGH"),
            token("HIGHLIGHT")
          )
        );
      }
    
      return highPhraseParser;
    }
    
    // ========================================================
    // linePhrase
    // ........................................................
    
    private ParserCombinator linePhraseParser = null;
    
    public final Start linePhrase = Start.on(getNamespace(), "linePhrase");
    
    public ParserCombinator linePhrase() {
      if (linePhraseParser == null) {
        FutureParser future = scoped("linePhrase", PUBLIC, true);
        linePhraseParser = future;
        future.setParser(
          choice(
            token("LEFTLINE"),
            token("OVERLINE"),
            token("UNDERLINE")
          )
        );
      }
    
      return linePhraseParser;
    }
    
    // ========================================================
    // lowPhrase
    // ........................................................
    
    private ParserCombinator lowPhraseParser = null;
    
    public final Start lowPhrase = Start.on(getNamespace(), "lowPhrase");
    
    public ParserCombinator lowPhrase() {
      if (lowPhraseParser == null) {
        FutureParser future = scoped("lowPhrase", PUBLIC, true);
        lowPhraseParser = future;
        future.setParser(
          choice(
            token("LOW"),
            token("LOWLIGHT")
          )
        );
      }
    
      return lowPhraseParser;
    }
    
    // ========================================================
    // offPhrase
    // ........................................................
    
    private ParserCombinator offPhraseParser = null;
    
    public final Start offPhrase = Start.on(getNamespace(), "offPhrase");
    
    public ParserCombinator offPhrase() {
      if (offPhraseParser == null) {
        FutureParser future = scoped("offPhrase", PUBLIC, true);
        offPhraseParser = future;
        future.setParser(
          token("OFF")
        );
      }
    
      return offPhraseParser;
    }
    
    // ========================================================
    // promptPhrase
    // ........................................................
    
    private ParserCombinator promptPhraseParser = null;
    
    public final Start promptPhrase = Start.on(getNamespace(), "promptPhrase");
    
    public ParserCombinator promptPhrase() {
      if (promptPhraseParser == null) {
        FutureParser future = scoped("promptPhrase", PUBLIC, true);
        promptPhraseParser = future;
        future.setParser(
          sequence(
            token("PROMPT"),
            optional(
              choice(
                sequence(
                  token("CHARACTER"),
                  optional(
                    token("IS")
                  ),
                  identifier()
                ),
                sequence(
                  optional(
                    token("CHARACTER")
                  ),
                  optional(
                    token("IS")
                  ),
                  literal()
                )
              )
            )
          )
        );
      }
    
      return promptPhraseParser;
    }
    
    // ========================================================
    // requiredPhrase
    // ........................................................
    
    private ParserCombinator requiredPhraseParser = null;
    
    public final Start requiredPhrase = Start.on(getNamespace(), "requiredPhrase");
    
    public ParserCombinator requiredPhrase() {
      if (requiredPhraseParser == null) {
        FutureParser future = scoped("requiredPhrase", PUBLIC, true);
        requiredPhraseParser = future;
        future.setParser(
          choice(
            token("REQUIRED"),
            token("EMPTY-CHECK")
          )
        );
      }
    
      return requiredPhraseParser;
    }
    
    // ========================================================
    // reversePhrase
    // ........................................................
    
    private ParserCombinator reversePhraseParser = null;
    
    public final Start reversePhrase = Start.on(getNamespace(), "reversePhrase");
    
    public ParserCombinator reversePhrase() {
      if (reversePhraseParser == null) {
        FutureParser future = scoped("reversePhrase", PUBLIC, true);
        reversePhraseParser = future;
        future.setParser(
          choice(
            token("REVERSE"),
            token("REVERSED"),
            token("REVERSE-VIDEO")
          )
        );
      }
    
      return reversePhraseParser;
    }
    
    // ========================================================
    // scrollPhrase
    // ........................................................
    
    private ParserCombinator scrollPhraseParser = null;
    
    public final Start scrollPhrase = Start.on(getNamespace(), "scrollPhrase");
    
    public ParserCombinator scrollPhrase() {
      if (scrollPhraseParser == null) {
        FutureParser future = scoped("scrollPhrase", PUBLIC, true);
        scrollPhraseParser = future;
        future.setParser(
          sequence(
            token("SCROLL"),
            choice(
              token("UP"),
              token("DOWN")
            ),
            optional(
              sequence(
                optional(
                  token("BY")
                ),
                choice(
                  integer(),
                  identifier()
                ),
                choice(
                  token("LINE"),
                  token("LINES")
                )
              )
            )
          )
        );
      }
    
      return scrollPhraseParser;
    }
    
    // ========================================================
    // securePhrase
    // ........................................................
    
    private ParserCombinator securePhraseParser = null;
    
    public final Start securePhrase = Start.on(getNamespace(), "securePhrase");
    
    public ParserCombinator securePhrase() {
      if (securePhraseParser == null) {
        FutureParser future = scoped("securePhrase", PUBLIC, true);
        securePhraseParser = future;
        future.setParser(
          choice(
            token("SECURE"),
            token("NO-ECHO")
          )
        );
      }
    
      return securePhraseParser;
    }
    
    // ========================================================
    // sizePhrase
    // ........................................................
    
    private ParserCombinator sizePhraseParser = null;
    
    public final Start sizePhrase = Start.on(getNamespace(), "sizePhrase");
    
    public ParserCombinator sizePhrase() {
      if (sizePhraseParser == null) {
        FutureParser future = scoped("sizePhrase", PUBLIC, true);
        sizePhraseParser = future;
        future.setParser(
          sequence(
            token("SIZE"),
            optional(
              token("IS")
            ),
            choice(
              identifier(),
              literal()
            )
          )
        );
      }
    
      return sizePhraseParser;
    }
    
    // ========================================================
    // standardPhrase
    // ........................................................
    
    private ParserCombinator standardPhraseParser = null;
    
    public final Start standardPhrase = Start.on(getNamespace(), "standardPhrase");
    
    public ParserCombinator standardPhrase() {
      if (standardPhraseParser == null) {
        FutureParser future = scoped("standardPhrase", PUBLIC, true);
        standardPhraseParser = future;
        future.setParser(
          token("STANDARD")
        );
      }
    
      return standardPhraseParser;
    }
    
    // ========================================================
    // tabPhrase
    // ........................................................
    
    private ParserCombinator tabPhraseParser = null;
    
    public final Start tabPhrase = Start.on(getNamespace(), "tabPhrase");
    
    public ParserCombinator tabPhrase() {
      if (tabPhraseParser == null) {
        FutureParser future = scoped("tabPhrase", PUBLIC, true);
        tabPhraseParser = future;
        future.setParser(
          token("TAB")
        );
      }
    
      return tabPhraseParser;
    }
    
    // ========================================================
    // timePhrase
    // ........................................................
    
    private ParserCombinator timePhraseParser = null;
    
    public final Start timePhrase = Start.on(getNamespace(), "timePhrase");
    
    public ParserCombinator timePhrase() {
      if (timePhraseParser == null) {
        FutureParser future = scoped("timePhrase", PUBLIC, true);
        timePhraseParser = future;
        future.setParser(
          sequence(
            optional(
              token("BEFORE")
            ),
            token("TIME"),
            choice(
              identifier(),
              literal()
            )
          )
        );
      }
    
      return timePhraseParser;
    }
    
    // ========================================================
    // timeoutPhrase
    // ........................................................
    
    private ParserCombinator timeoutPhraseParser = null;
    
    public final Start timeoutPhrase = Start.on(getNamespace(), "timeoutPhrase");
    
    public ParserCombinator timeoutPhrase() {
      if (timeoutPhraseParser == null) {
        FutureParser future = scoped("timeoutPhrase", PUBLIC, true);
        timeoutPhraseParser = future;
        future.setParser(
          sequence(
            choice(
              token("TIME-OUT"),
              token("TIMEOUT")
            ),
            token("AFTER"),
            choice(
              identifier(),
              integer()
            )
          )
        );
      }
    
      return timeoutPhraseParser;
    }
    
    // ========================================================
    // justificationPhrase
    // ........................................................
    
    private ParserCombinator justificationPhraseParser = null;
    
    public final Start justificationPhrase = Start.on(getNamespace(), "justificationPhrase");
    
    public ParserCombinator justificationPhrase() {
      if (justificationPhraseParser == null) {
        FutureParser future = scoped("justificationPhrase", PUBLIC, true);
        justificationPhraseParser = future;
        future.setParser(
          choice(
            token("LEFT-JUSTIFY"),
            token("RIGHT-JUSTIFY")
          )
        );
      }
    
      return justificationPhraseParser;
    }
    
    // ========================================================
    // fillPhrase
    // ........................................................
    
    private ParserCombinator fillPhraseParser = null;
    
    public final Start fillPhrase = Start.on(getNamespace(), "fillPhrase");
    
    public ParserCombinator fillPhrase() {
      if (fillPhraseParser == null) {
        FutureParser future = scoped("fillPhrase", PUBLIC, true);
        fillPhraseParser = future;
        future.setParser(
          choice(
            token("SPACE-FILL"),
            token("ZERO-FILL")
          )
        );
      }
    
      return fillPhraseParser;
    }
    
    // ========================================================
    // trailingSignPhrase
    // ........................................................
    
    private ParserCombinator trailingSignPhraseParser = null;
    
    public final Start trailingSignPhrase = Start.on(getNamespace(), "trailingSignPhrase");
    
    public ParserCombinator trailingSignPhrase() {
      if (trailingSignPhraseParser == null) {
        FutureParser future = scoped("trailingSignPhrase", PUBLIC, true);
        trailingSignPhraseParser = future;
        future.setParser(
          token("TRAILING-SIGN")
        );
      }
    
      return trailingSignPhraseParser;
    }
    
    // ========================================================
    // updatePhrase
    // ........................................................
    
    private ParserCombinator updatePhraseParser = null;
    
    public final Start updatePhrase = Start.on(getNamespace(), "updatePhrase");
    
    public ParserCombinator updatePhrase() {
      if (updatePhraseParser == null) {
        FutureParser future = scoped("updatePhrase", PUBLIC, true);
        updatePhraseParser = future;
        future.setParser(
          token("UPDATE")
        );
      }
    
      return updatePhraseParser;
    }
    
    // ========================================================
    // divideStatement
    // ........................................................
    
    private ParserCombinator divideStatementParser = null;
    
    public final Start divideStatement = Start.on(getNamespace(), "divideStatement");
    
    public ParserCombinator divideStatement() {
      if (divideStatementParser == null) {
        FutureParser future = scoped("divideStatement", PUBLIC, true);
        divideStatementParser = future;
        future.setParser(
          sequence(
            token("DIVIDE"),
            choice(
              divideStatement$format1(),
              divideStatement$format2(),
              divideStatement$format3()
            ),
            optional(
              onSizeError()
            ),
            optional(
              notOnSizeError()
            ),
            optional(
              token("END-DIVIDE")
            )
          )
        );
      }
    
      return divideStatementParser;
    }
    
    // ========================================================
    // format1
    // ........................................................
    
    private ParserCombinator divideStatement$format1Parser = null;
    
    protected final Start divideStatement$format1 = Start.on(getNamespace(), "format1");
    
    protected ParserCombinator divideStatement$format1() {
      if (divideStatement$format1Parser == null) {
        FutureParser future = scoped("format1", PRIVATE, true);
        divideStatement$format1Parser = future;
        future.setParser(
          sequence(
            choice(
              identifier(),
              literal()
            ),
            as("into",
              sequence(
                choice(
                  token("INTO"),
                  token("BY")
                ),
                choice(
                  identifier(),
                  literal()
                )
              )
            ),
            as("giving",
              sequence(
                token("GIVING"),
                assign("identifier",
                  qualifiedDataName()
                ),
                optional(
                  token("ROUNDED")
                )
              )
            ),
            as("remainder",
              sequence(
                token("REMAINDER"),
                qualifiedDataName()
              )
            )
          )
        );
      }
    
      return divideStatement$format1Parser;
    }
    
    // ========================================================
    // format2
    // ........................................................
    
    private ParserCombinator divideStatement$format2Parser = null;
    
    protected final Start divideStatement$format2 = Start.on(getNamespace(), "format2");
    
    protected ParserCombinator divideStatement$format2() {
      if (divideStatement$format2Parser == null) {
        FutureParser future = scoped("format2", PRIVATE, true);
        divideStatement$format2Parser = future;
        future.setParser(
          sequence(
            choice(
              identifier(),
              literal()
            ),
            as("into",
              sequence(
                choice(
                  token("INTO"),
                  token("BY")
                ),
                choice(
                  identifier(),
                  literal()
                )
              )
            ),
            as("giving",
              sequence(
                token("GIVING"),
                plus(
                  sequence(
                    as("identifier",
                      qualifiedDataName()
                    ),
                    optional(
                      token("ROUNDED")
                    )
                  )
                )
              )
            )
          )
        );
      }
    
      return divideStatement$format2Parser;
    }
    
    // ========================================================
    // format3
    // ........................................................
    
    private ParserCombinator divideStatement$format3Parser = null;
    
    protected final Start divideStatement$format3 = Start.on(getNamespace(), "format3");
    
    protected ParserCombinator divideStatement$format3() {
      if (divideStatement$format3Parser == null) {
        FutureParser future = scoped("format3", PRIVATE, true);
        divideStatement$format3Parser = future;
        future.setParser(
          sequence(
            choice(
              identifier(),
              literal()
            ),
            as("into",
              sequence(
                token("INTO"),
                plus(
                  sequence(
                    qualifiedDataName(),
                    optional(
                      token("ROUNDED")
                    )
                  )
                )
              )
            )
          )
        );
      }
    
      return divideStatement$format3Parser;
    }
    
    // ========================================================
    // enableStatement
    // ........................................................
    
    private ParserCombinator enableStatementParser = null;
    
    public final Start enableStatement = Start.on(getNamespace(), "enableStatement");
    
    public ParserCombinator enableStatement() {
      if (enableStatementParser == null) {
        FutureParser future = scoped("enableStatement", PUBLIC, true);
        enableStatementParser = future;
        future.setParser(
          sequence(
            token("ENABLE"),
            choice(
              sequence(
                token("INPUT"),
                optional(
                  token("TERMINAL")
                )
              ),
              sequence(
                token("I-O"),
                token("TERMINAL")
              ),
              token("OUTPUT")
            ),
            cdName(),
            optional(
              token("WITH")
            ),
            token("KEY"),
            choice(
              literal(),
              identifier()
            )
          )
        );
      }
    
      return enableStatementParser;
    }
    
    // ========================================================
    // entryStatement
    // ........................................................
    
    private ParserCombinator entryStatementParser = null;
    
    public final Start entryStatement = Start.on(getNamespace(), "entryStatement");
    
    public ParserCombinator entryStatement() {
      if (entryStatementParser == null) {
        FutureParser future = scoped("entryStatement", PUBLIC, true);
        entryStatementParser = future;
        future.setParser(
          sequence(
            token("ENTRY"),
            literal(),
            optional(
              mnemonicName()
            ),
            optional(
              sequence(
                token("USING"),
                plus(
                  sequence(
                    optional(
                      sequence(
                        optional(
                          token("BY")
                        ),
                        choice(
                          token("REFERENCE"),
                          token("VALUE")
                        )
                      )
                    ),
                    choice(
                      token("ANY"),
                      sequence(
                        dataName(),
                        optional(
                          sequence(
                            token("DELIMITED"),
                            optional(
                              sequence(
                                token("BY"),
                                token("SIZE")
                              )
                            )
                          )
                        )
                      )
                    )
                  )
                ),
                optional(
                  sequence(
                    token("REPEATED"),
                    optional(
                      sequence(
                        integer(),
                        token("TO"),
                        integer()
                      )
                    )
                  )
                )
              )
            ),
            optional(
              sequence(
                choice(
                  token("GIVING"),
                  token("RETURNING")
                ),
                dataName()
              )
            )
          )
        );
      }
    
      return entryStatementParser;
    }
    
    // ========================================================
    // evaluateStatement
    // ........................................................
    
    private ParserCombinator evaluateStatementParser = null;
    
    public final Start evaluateStatement = Start.on(getNamespace(), "evaluateStatement");
    
    public ParserCombinator evaluateStatement() {
      if (evaluateStatementParser == null) {
        FutureParser future = scoped("evaluateStatement", PUBLIC, true);
        evaluateStatementParser = future;
        future.setParser(
          sequence(
            token("EVALUATE"),
            subject(),
            star(
              sequence(
                token("ALSO"),
                subject()
              )
            ),
            plus(
              when()
            ),
            optional(
              whenOther()
            ),
            optional(
              token("END-EVALUATE")
            )
          )
        );
      }
    
      return evaluateStatementParser;
    }
    
    // ========================================================
    // subject
    // ........................................................
    
    private ParserCombinator subjectParser = null;
    
    public final Start subject = Start.on(getNamespace(), "subject");
    
    public ParserCombinator subject() {
      if (subjectParser == null) {
        FutureParser future = scoped("subject", PUBLIC, true);
        subjectParser = future;
        future.setParser(
          sequence(
            choice(
              condition(),
              sequence(
                literal(),
                not(
                  moreArithmeticOp()
                )
              ),
              sequence(
                identifier(),
                not(
                  moreArithmeticOp()
                )
              ),
              arithmeticExpression()
            ),
            skipto(
              choice(
                token("ALSO"),
                token("WHEN")
              )
            )
          )
        );
      }
    
      return subjectParser;
    }
    
    // ========================================================
    // when
    // ........................................................
    
    private ParserCombinator whenParser = null;
    
    public final Start when = Start.on(getNamespace(), "when");
    
    public ParserCombinator when() {
      if (whenParser == null) {
        FutureParser future = scoped("when", PUBLIC, true);
        whenParser = future;
        future.setParser(
          sequence(
            plus(
              sequence(
                token("WHEN"),
                not(
                  token("OTHER")
                ),
                object(),
                star(
                  sequence(
                    token("ALSO"),
                    object()
                  )
                )
              )
            ),
            nestedStatements()
          )
        );
      }
    
      return whenParser;
    }
    
    // ========================================================
    // whenOther
    // ........................................................
    
    private ParserCombinator whenOtherParser = null;
    
    public final Start whenOther = Start.on(getNamespace(), "whenOther");
    
    public ParserCombinator whenOther() {
      if (whenOtherParser == null) {
        FutureParser future = scoped("whenOther", PUBLIC, true);
        whenOtherParser = future;
        future.setParser(
          sequence(
            token("WHEN"),
            token("OTHER"),
            nestedStatements()
          )
        );
      }
    
      return whenOtherParser;
    }
    
    // ========================================================
    // object
    // ........................................................
    
    private ParserCombinator objectParser = null;
    
    public final Start object = Start.on(getNamespace(), "object");
    
    public ParserCombinator object() {
      if (objectParser == null) {
        FutureParser future = scoped("object", PUBLIC, true);
        objectParser = future;
        future.setParser(
          choice(
            token("ANY"),
            rangeExpression(),
            token("TRUE"),
            token("FALSE"),
            condition(),
            sequence(
              optional(
                token("NOT")
              ),
              choice(
                sequence(
                  identifier(),
                  not(
                    moreArithmeticOp()
                  )
                ),
                sequence(
                  literal(),
                  not(
                    moreArithmeticOp()
                  )
                ),
                arithmeticExpression()
              )
            ),
            sequence(
              literal("("),
              object(),
              literal(")")
            )
          )
        );
      }
    
      return objectParser;
    }
    
    // ========================================================
    // rangeExpression
    // ........................................................
    
    private ParserCombinator rangeExpressionParser = null;
    
    public final Start rangeExpression = Start.on(getNamespace(), "rangeExpression");
    
    public ParserCombinator rangeExpression() {
      if (rangeExpressionParser == null) {
        FutureParser future = scoped("rangeExpression", PUBLIC, true);
        rangeExpressionParser = future;
        future.setParser(
          sequence(
            optional(
              token("NOT")
            ),
            choice(
              sequence(
                literal(),
                not(
                  moreArithmeticOp()
                )
              ),
              sequence(
                identifier(),
                not(
                  moreArithmeticOp()
                )
              ),
              arithmeticExpression()
            ),
            choice(
              token("THROUGH"),
              token("THRU")
            ),
            choice(
              sequence(
                literal(),
                not(
                  moreArithmeticOp()
                )
              ),
              sequence(
                identifier(),
                not(
                  moreArithmeticOp()
                )
              ),
              arithmeticExpression()
            )
          )
        );
      }
    
      return rangeExpressionParser;
    }
    
    // ========================================================
    // examineStatement
    // ........................................................
    
    private ParserCombinator examineStatementParser = null;
    
    public final Start examineStatement = Start.on(getNamespace(), "examineStatement");
    
    public ParserCombinator examineStatement() {
      if (examineStatementParser == null) {
        FutureParser future = scoped("examineStatement", PUBLIC, true);
        examineStatementParser = future;
        future.setParser(
          sequence(
            token("EXAMINE"),
            identifier(),
            choice(
              sequence(
                token("TALLYING"),
                choice(
                  sequence(
                    token("UNTIL"),
                    token("FIRST")
                  ),
                  token("ALL"),
                  token("LEADING")
                ),
                literal(),
                optional(
                  sequence(
                    token("REPLACING"),
                    token("BY"),
                    literal()
                  )
                )
              ),
              sequence(
                token("REPLACING"),
                choice(
                  token("ALL"),
                  token("LEADING"),
                  token("FIRST"),
                  sequence(
                    token("UNTIL"),
                    token("FIRST")
                  )
                ),
                literal(),
                token("BY"),
                literal()
              )
            )
          )
        );
      }
    
      return examineStatementParser;
    }
    
    // ========================================================
    // execStatement
    // ........................................................
    
    private ParserCombinator execStatementParser = null;
    
    protected final Start execStatement = Start.on(getNamespace(), "execStatement");
    
    protected ParserCombinator execStatement() {
      if (execStatementParser == null) {
        FutureParser future = scoped("execStatement", PRIVATE, true);
        execStatementParser = future;
        future.setParser(
          choice(
            execSQLStatement(),
            execCICSStatement(),
            execDLIStatement(),
            execHTMLStatement(),
            execTextDataStatement()
          )
        );
      }
    
      return execStatementParser;
    }
    
    // ========================================================
    // execSQLStatement
    // ........................................................
    
    private ParserCombinator execSQLStatementParser = null;
    
    public final Start execSQLStatement = Start.on(getNamespace(), "execSQLStatement");
    
    public ParserCombinator execSQLStatement() {
      if (execSQLStatementParser == null) {
        FutureParser future = scoped("execSQLStatement", PUBLIC, true);
        execSQLStatementParser = future;
        future.setParser(
          sequence(
            choice(
              token("EXEC"),
              token("EXECUTE")
            ),
            token("SQL"),
            limited(
              optional(
                sqlStatement()
              ),
              token("END-EXEC")
            ),
            optional(
              as("unknown",
                skipto(
                  token("END-EXEC")
                )
              )
            ),
            token("END-EXEC")
          )
        );
      }
    
      return execSQLStatementParser;
    }
    
    // ========================================================
    // execCICSStatement
    // ........................................................
    
    private ParserCombinator execCICSStatementParser = null;
    
    public final Start execCICSStatement = Start.on(getNamespace(), "execCICSStatement");
    
    public ParserCombinator execCICSStatement() {
      if (execCICSStatementParser == null) {
        FutureParser future = scoped("execCICSStatement", PUBLIC, true);
        execCICSStatementParser = future;
        future.setParser(
          sequence(
            choice(
              token("EXEC"),
              token("EXECUTE")
            ),
            token("CICS"),
            limited(
              optional(
                cicsStatement()
              ),
              token("END-EXEC")
            ),
            optional(
              as("unknown",
                skipto(
                  token("END-EXEC")
                )
              )
            ),
            token("END-EXEC")
          )
        );
      }
    
      return execCICSStatementParser;
    }
    
    // ========================================================
    // execDLIStatement
    // ........................................................
    
    private ParserCombinator execDLIStatementParser = null;
    
    public final Start execDLIStatement = Start.on(getNamespace(), "execDLIStatement");
    
    public ParserCombinator execDLIStatement() {
      if (execDLIStatementParser == null) {
        FutureParser future = scoped("execDLIStatement", PUBLIC, true);
        execDLIStatementParser = future;
        future.setParser(
          sequence(
            choice(
              token("EXEC"),
              token("EXECUTE")
            ),
            token("DLI"),
            optional(
              as("unknown",
                skipto(
                  token("END-EXEC")
                )
              )
            ),
            token("END-EXEC")
          )
        );
      }
    
      return execDLIStatementParser;
    }
    
    // ========================================================
    // execHTMLStatement
    // ........................................................
    
    private ParserCombinator execHTMLStatementParser = null;
    
    public final Start execHTMLStatement = Start.on(getNamespace(), "execHTMLStatement");
    
    public ParserCombinator execHTMLStatement() {
      if (execHTMLStatementParser == null) {
        FutureParser future = scoped("execHTMLStatement", PUBLIC, true);
        execHTMLStatementParser = future;
        future.setParser(
          sequence(
            choice(
              token("EXEC"),
              token("EXECUTE")
            ),
            token("HTML"),
            optional(
              as("unknown",
                skipto(
                  token("END-EXEC")
                )
              )
            ),
            token("END-EXEC")
          )
        );
      }
    
      return execHTMLStatementParser;
    }
    
    // ========================================================
    // execTextDataStatement
    // ........................................................
    
    private ParserCombinator execTextDataStatementParser = null;
    
    public final Start execTextDataStatement = Start.on(getNamespace(), "execTextDataStatement");
    
    public ParserCombinator execTextDataStatement() {
      if (execTextDataStatementParser == null) {
        FutureParser future = scoped("execTextDataStatement", PUBLIC, true);
        execTextDataStatementParser = future;
        future.setParser(
          sequence(
            choice(
              token("EXEC"),
              token("EXECUTE")
            ),
            textName(),
            optional(
              as("unknown",
                skipto(
                  token("END-EXEC")
                )
              )
            ),
            token("END-EXEC")
          )
        );
      }
    
      return execTextDataStatementParser;
    }
    
    // ========================================================
    // exitStatement
    // ........................................................
    
    private ParserCombinator exitStatementParser = null;
    
    public final Start exitStatement = Start.on(getNamespace(), "exitStatement");
    
    public ParserCombinator exitStatement() {
      if (exitStatementParser == null) {
        FutureParser future = scoped("exitStatement", PUBLIC, true);
        exitStatementParser = future;
        future.setParser(
          sequence(
            token("EXIT"),
            optional(
              as("endpoint",
                choice(
                  token("PROGRAM"),
                  token("PARAGRAPH"),
                  token("SECTION"),
                  sequence(
                    token("PERFORM"),
                    optional(
                      token("CYCLE")
                    )
                  ),
                  token("METHOD"),
                  token("FUNCTION"),
                  token("ITERATOR")
                )
              )
            ),
            optional(
              returningPhrase()
            )
          )
        );
      }
    
      return exitStatementParser;
    }
    
    // ========================================================
    // returningPhrase
    // ........................................................
    
    private ParserCombinator returningPhraseParser = null;
    
    public final Start returningPhrase = Start.on(getNamespace(), "returningPhrase");
    
    public ParserCombinator returningPhrase() {
      if (returningPhraseParser == null) {
        FutureParser future = scoped("returningPhrase", PUBLIC, true);
        returningPhraseParser = future;
        future.setParser(
          sequence(
            choice(
              token("GIVING"),
              token("RETURNING")
            ),
            choice(
              integer(),
              addressOf()
            )
          )
        );
      }
    
      return returningPhraseParser;
    }
    
    // ========================================================
    // generateStatement
    // ........................................................
    
    private ParserCombinator generateStatementParser = null;
    
    public final Start generateStatement = Start.on(getNamespace(), "generateStatement");
    
    public ParserCombinator generateStatement() {
      if (generateStatementParser == null) {
        FutureParser future = scoped("generateStatement", PUBLIC, true);
        generateStatementParser = future;
        future.setParser(
          sequence(
            token("GENERATE"),
            choice(
              dataName(),
              reportName()
            )
          )
        );
      }
    
      return generateStatementParser;
    }
    
    // ========================================================
    // freeStatement
    // ........................................................
    
    private ParserCombinator freeStatementParser = null;
    
    public final Start freeStatement = Start.on(getNamespace(), "freeStatement");
    
    public ParserCombinator freeStatement() {
      if (freeStatementParser == null) {
        FutureParser future = scoped("freeStatement", PUBLIC, true);
        freeStatementParser = future;
        future.setParser(
          sequence(
            token("FREE"),
            plus(
              sequence(
                optional(
                  sequence(
                    token("ADDRESS"),
                    optional(
                      token("OF")
                    )
                  )
                ),
                qualifiedDataName()
              )
            )
          )
        );
      }
    
      return freeStatementParser;
    }
    
    // ========================================================
    // gobackStatement
    // ........................................................
    
    private ParserCombinator gobackStatementParser = null;
    
    public final Start gobackStatement = Start.on(getNamespace(), "gobackStatement");
    
    public ParserCombinator gobackStatement() {
      if (gobackStatementParser == null) {
        FutureParser future = scoped("gobackStatement", PUBLIC, true);
        gobackStatementParser = future;
        future.setParser(
          sequence(
            token("GOBACK"),
            optional(
              sequence(
                choice(
                  token("GIVING"),
                  token("RETURNING")
                ),
                choice(
                  addressOf(),
                  identifier(),
                  integer()
                )
              )
            )
          )
        );
      }
    
      return gobackStatementParser;
    }
    
    // ========================================================
    // goToStatement
    // ........................................................
    
    private ParserCombinator goToStatementParser = null;
    
    public final Start goToStatement = Start.on(getNamespace(), "goToStatement");
    
    public ParserCombinator goToStatement() {
      if (goToStatementParser == null) {
        FutureParser future = scoped("goToStatement", PUBLIC, true);
        goToStatementParser = future;
        future.setParser(
          sequence(
            token("GO"),
            optional(
              token("TO")
            ),
            star(
              procedureName()
            ),
            optional(
              dependingOn()
            )
          )
        );
      }
    
      return goToStatementParser;
    }
    
    // ========================================================
    // dependingOn
    // ........................................................
    
    private ParserCombinator dependingOnParser = null;
    
    public final Start dependingOn = Start.on(getNamespace(), "dependingOn");
    
    public ParserCombinator dependingOn() {
      if (dependingOnParser == null) {
        FutureParser future = scoped("dependingOn", PUBLIC, true);
        dependingOnParser = future;
        future.setParser(
          sequence(
            token("DEPENDING"),
            optional(
              token("ON")
            ),
            identifier()
          )
        );
      }
    
      return dependingOnParser;
    }
    
    // ========================================================
    // ifStatement
    // ........................................................
    
    private ParserCombinator ifStatementParser = null;
    
    public final Start ifStatement = Start.on(getNamespace(), "ifStatement");
    
    public ParserCombinator ifStatement() {
      if (ifStatementParser == null) {
        FutureParser future = scoped("ifStatement", PUBLIC, true);
        ifStatementParser = future;
        future.setParser(
          sequence(
            token("IF"),
            condition(),
            thenBranch(),
            optional(
              elseBranch()
            ),
            optional(
              token("END-IF")
            )
          )
        );
      }
    
      return ifStatementParser;
    }
    
    // ========================================================
    // thenBranch
    // ........................................................
    
    private ParserCombinator thenBranchParser = null;
    
    public final Start thenBranch = Start.on(getNamespace(), "thenBranch");
    
    public ParserCombinator thenBranch() {
      if (thenBranchParser == null) {
        FutureParser future = scoped("thenBranch", PUBLIC, true);
        thenBranchParser = future;
        future.setParser(
          sequence(
            optional(
              token("THEN")
            ),
            choice(
              nestedStatements(),
              as("nestedStatements",
                as("statement",
                  nextSentenceStatement()
                )
              )
            )
          )
        );
      }
    
      return thenBranchParser;
    }
    
    // ========================================================
    // elseBranch
    // ........................................................
    
    private ParserCombinator elseBranchParser = null;
    
    public final Start elseBranch = Start.on(getNamespace(), "elseBranch");
    
    public ParserCombinator elseBranch() {
      if (elseBranchParser == null) {
        FutureParser future = scoped("elseBranch", PUBLIC, true);
        elseBranchParser = future;
        future.setParser(
          sequence(
            token("ELSE"),
            choice(
              nestedStatements(),
              as("nestedStatements",
                as("statement",
                  nextSentenceStatement()
                )
              )
            )
          )
        );
      }
    
      return elseBranchParser;
    }
    
    // ========================================================
    // initiateStatement
    // ........................................................
    
    private ParserCombinator initiateStatementParser = null;
    
    public final Start initiateStatement = Start.on(getNamespace(), "initiateStatement");
    
    public ParserCombinator initiateStatement() {
      if (initiateStatementParser == null) {
        FutureParser future = scoped("initiateStatement", PUBLIC, true);
        initiateStatementParser = future;
        future.setParser(
          sequence(
            token("INITIATE"),
            plus(
              reportName()
            )
          )
        );
      }
    
      return initiateStatementParser;
    }
    
    // ========================================================
    // invokeStatement
    // ........................................................
    
    private ParserCombinator invokeStatementParser = null;
    
    public final Start invokeStatement = Start.on(getNamespace(), "invokeStatement");
    
    public ParserCombinator invokeStatement() {
      if (invokeStatementParser == null) {
        FutureParser future = scoped("invokeStatement", PUBLIC, true);
        invokeStatementParser = future;
        future.setParser(
          sequence(
            token("INVOKE"),
            identifier(),
            optional(
              sequence(
                token("AS"),
                choice(
                  token("OBJECT"),
                  identifier()
                )
              )
            ),
            choice(
              literal(),
              identifier()
            ),
            optional(
              sequence(
                token("USING"),
                plus(
                  choice(
                    sequence(
                      optional(
                        sequence(
                          optional(
                            token("BY")
                          ),
                          token("REFERENCE")
                        )
                      ),
                      choice(
                        addressOf(),
                        token("OMITTED"),
                        literal(),
                        identifier()
                      )
                    ),
                    sequence(
                      optional(
                        token("BY")
                      ),
                      token("CONTENT"),
                      choice(
                        sequence(
                          token("LENGTH"),
                          token("OF"),
                          identifier()
                        ),
                        sequence(
                          literal(),
                          not(
                            moreArithmeticOp()
                          )
                        ),
                        sequence(
                          identifier(),
                          not(
                            moreArithmeticOp()
                          )
                        ),
                        arithmeticExpression()
                      )
                    ),
                    sequence(
                      optional(
                        token("BY")
                      ),
                      token("VALUE"),
                      choice(
                        sequence(
                          token("LENGTH"),
                          token("OF"),
                          identifier()
                        ),
                        sequence(
                          integer(),
                          token("SIZE"),
                          optional(
                            token("IS")
                          ),
                          integer()
                        ),
                        sequence(
                          integer(),
                          not(
                            moreArithmeticOp()
                          )
                        ),
                        sequence(
                          identifier(),
                          not(
                            moreArithmeticOp()
                          )
                        ),
                        arithmeticExpression()
                      )
                    )
                  )
                )
              )
            ),
            optional(
              sequence(
                choice(
                  token("GIVING"),
                  token("RETURNING")
                ),
                choice(
                  addressOf(),
                  sequence(
                    optional(
                      token("INTO")
                    ),
                    identifier()
                  )
                )
              )
            )
          )
        );
      }
    
      return invokeStatementParser;
    }
    
    // ========================================================
    // exhibitStatement
    // ........................................................
    
    private ParserCombinator exhibitStatementParser = null;
    
    public final Start exhibitStatement = Start.on(getNamespace(), "exhibitStatement");
    
    public ParserCombinator exhibitStatement() {
      if (exhibitStatementParser == null) {
        FutureParser future = scoped("exhibitStatement", PUBLIC, true);
        exhibitStatementParser = future;
        future.setParser(
          sequence(
            token("EXHIBIT"),
            choice(
              token("NAMED"),
              sequence(
                token("CHANGED"),
                token("NAMED")
              ),
              token("CHANGED")
            ),
            choice(
              identifier(),
              literal()
            )
          )
        );
      }
    
      return exhibitStatementParser;
    }
    
    // ========================================================
    // identifiedByStatement
    // ........................................................
    
    private ParserCombinator identifiedByStatementParser = null;
    
    public final Start identifiedByStatement = Start.on(getNamespace(), "identifiedByStatement");
    
    public ParserCombinator identifiedByStatement() {
      if (identifiedByStatementParser == null) {
        FutureParser future = scoped("identifiedByStatement", PUBLIC, true);
        identifiedByStatementParser = future;
        future.setParser(
          sequence(
            token("IDENTIFIED"),
            optional(
              token("BY")
            ),
            choice(
              dataName(),
              literal()
            ),
            optional(
              sequence(
                optional(
                  token("IS")
                ),
                token("ATTRIBUTE")
              )
            )
          )
        );
      }
    
      return identifiedByStatementParser;
    }
    
    // ========================================================
    // initializeStatement
    // ........................................................
    
    private ParserCombinator initializeStatementParser = null;
    
    public final Start initializeStatement = Start.on(getNamespace(), "initializeStatement");
    
    public ParserCombinator initializeStatement() {
      if (initializeStatementParser == null) {
        FutureParser future = scoped("initializeStatement", PUBLIC, true);
        initializeStatementParser = future;
        future.setParser(
          sequence(
            token("INITIALIZE"),
            plus(
              identifier()
            ),
            optional(
              replacingInitClause()
            ),
            optional(
              as("unknown",
                skipto(
                  somethingFollowingAStatement()
                )
              )
            )
          )
        );
      }
    
      return initializeStatementParser;
    }
    
    // ========================================================
    // replacingInitClause
    // ........................................................
    
    private ParserCombinator replacingInitClauseParser = null;
    
    public final Start replacingInitClause = Start.on(getNamespace(), "replacingInitClause");
    
    public ParserCombinator replacingInitClause() {
      if (replacingInitClauseParser == null) {
        FutureParser future = scoped("replacingInitClause", PUBLIC, true);
        replacingInitClauseParser = future;
        future.setParser(
          sequence(
            token("REPLACING"),
            replacementTarget(),
            optional(
              token("DATA")
            ),
            token("BY"),
            choice(
              identifier(),
              literal()
            )
          )
        );
      }
    
      return replacingInitClauseParser;
    }
    
    // ========================================================
    // replacementTarget
    // ........................................................
    
    private ParserCombinator replacementTargetParser = null;
    
    public final Start replacementTarget = Start.on(getNamespace(), "replacementTarget");
    
    public ParserCombinator replacementTarget() {
      if (replacementTargetParser == null) {
        FutureParser future = scoped("replacementTarget", PUBLIC, true);
        replacementTargetParser = future;
        future.setParser(
          choice(
            token("ALPHABETIC"),
            token("ALPHANUMERIC"),
            token("ALPHANUMERIC-EDITED"),
            token("NATIONAL"),
            token("NATIONAL-EDITED"),
            token("NUMERIC"),
            token("NUMERIC-EDITED"),
            token("DBCS"),
            token("EGCS")
          )
        );
      }
    
      return replacementTargetParser;
    }
    
    // ========================================================
    // inspectStatement
    // ........................................................
    
    private ParserCombinator inspectStatementParser = null;
    
    public final Start inspectStatement = Start.on(getNamespace(), "inspectStatement");
    
    public ParserCombinator inspectStatement() {
      if (inspectStatementParser == null) {
        FutureParser future = scoped("inspectStatement", PUBLIC, true);
        inspectStatementParser = future;
        future.setParser(
          sequence(
            token("INSPECT"),
            identifier(),
            choice(
              convertingPhrase(),
              sequence(
                tallyingPhrase(),
                optional(
                  replacingPhrase()
                )
              ),
              replacingPhrase()
            )
          )
        );
      }
    
      return inspectStatementParser;
    }
    
    // ========================================================
    // convertingPhrase
    // ........................................................
    
    private ParserCombinator convertingPhraseParser = null;
    
    public final Start convertingPhrase = Start.on(getNamespace(), "convertingPhrase");
    
    public ParserCombinator convertingPhrase() {
      if (convertingPhraseParser == null) {
        FutureParser future = scoped("convertingPhrase", PUBLIC, true);
        convertingPhraseParser = future;
        future.setParser(
          sequence(
            token("CONVERTING"),
            choice(
              identifier(),
              literal()
            ),
            token("TO"),
            choice(
              identifier(),
              literal()
            ),
            star(
              locationPhrase()
            )
          )
        );
      }
    
      return convertingPhraseParser;
    }
    
    // ========================================================
    // tallyingPhrase
    // ........................................................
    
    private ParserCombinator tallyingPhraseParser = null;
    
    public final Start tallyingPhrase = Start.on(getNamespace(), "tallyingPhrase");
    
    public ParserCombinator tallyingPhrase() {
      if (tallyingPhraseParser == null) {
        FutureParser future = scoped("tallyingPhrase", PUBLIC, true);
        tallyingPhraseParser = future;
        future.setParser(
          sequence(
            token("TALLYING"),
            star(
              sequence(
                qualifiedDataName(),
                token("FOR"),
                star(
                  choice(
                    tallyingCharactersPhrase(),
                    tallyingAllLeadingOrTrailingPhrase()
                  )
                )
              )
            )
          )
        );
      }
    
      return tallyingPhraseParser;
    }
    
    // ========================================================
    // tallyingCharactersPhrase
    // ........................................................
    
    private ParserCombinator tallyingCharactersPhraseParser = null;
    
    public final Start tallyingCharactersPhrase = Start.on(getNamespace(), "tallyingCharactersPhrase");
    
    public ParserCombinator tallyingCharactersPhrase() {
      if (tallyingCharactersPhraseParser == null) {
        FutureParser future = scoped("tallyingCharactersPhrase", PUBLIC, true);
        tallyingCharactersPhraseParser = future;
        future.setParser(
          sequence(
            token("CHARACTERS"),
            star(
              locationPhrase()
            )
          )
        );
      }
    
      return tallyingCharactersPhraseParser;
    }
    
    // ========================================================
    // tallyingAllLeadingOrTrailingPhrase
    // ........................................................
    
    private ParserCombinator tallyingAllLeadingOrTrailingPhraseParser = null;
    
    public final Start tallyingAllLeadingOrTrailingPhrase = Start.on(getNamespace(), "tallyingAllLeadingOrTrailingPhrase");
    
    public ParserCombinator tallyingAllLeadingOrTrailingPhrase() {
      if (tallyingAllLeadingOrTrailingPhraseParser == null) {
        FutureParser future = scoped("tallyingAllLeadingOrTrailingPhrase", PUBLIC, true);
        tallyingAllLeadingOrTrailingPhraseParser = future;
        future.setParser(
          sequence(
            choice(
              token("ALL"),
              token("LEADING"),
              token("TRAILING")
            ),
            star(
              sequence(
                choice(
                  sequence(
                    identifier(),
                    not(
                      token("FOR")
                    )
                  ),
                  literal()
                ),
                star(
                  locationPhrase()
                )
              )
            )
          )
        );
      }
    
      return tallyingAllLeadingOrTrailingPhraseParser;
    }
    
    // ========================================================
    // replacingPhrase
    // ........................................................
    
    private ParserCombinator replacingPhraseParser = null;
    
    public final Start replacingPhrase = Start.on(getNamespace(), "replacingPhrase");
    
    public ParserCombinator replacingPhrase() {
      if (replacingPhraseParser == null) {
        FutureParser future = scoped("replacingPhrase", PUBLIC, true);
        replacingPhraseParser = future;
        future.setParser(
          sequence(
            token("REPLACING"),
            star(
              choice(
                replacingCharactersPhrase(),
                replacingAllLeadingFirstOrTrailingPhrase()
              )
            )
          )
        );
      }
    
      return replacingPhraseParser;
    }
    
    // ========================================================
    // replacingCharactersPhrase
    // ........................................................
    
    private ParserCombinator replacingCharactersPhraseParser = null;
    
    public final Start replacingCharactersPhrase = Start.on(getNamespace(), "replacingCharactersPhrase");
    
    public ParserCombinator replacingCharactersPhrase() {
      if (replacingCharactersPhraseParser == null) {
        FutureParser future = scoped("replacingCharactersPhrase", PUBLIC, true);
        replacingCharactersPhraseParser = future;
        future.setParser(
          sequence(
            token("CHARACTERS"),
            token("BY"),
            choice(
              identifier(),
              literal()
            ),
            star(
              locationPhrase()
            )
          )
        );
      }
    
      return replacingCharactersPhraseParser;
    }
    
    // ========================================================
    // replacingAllLeadingFirstOrTrailingPhrase
    // ........................................................
    
    private ParserCombinator replacingAllLeadingFirstOrTrailingPhraseParser = null;
    
    public final Start replacingAllLeadingFirstOrTrailingPhrase = Start.on(getNamespace(), "replacingAllLeadingFirstOrTrailingPhrase");
    
    public ParserCombinator replacingAllLeadingFirstOrTrailingPhrase() {
      if (replacingAllLeadingFirstOrTrailingPhraseParser == null) {
        FutureParser future = scoped("replacingAllLeadingFirstOrTrailingPhrase", PUBLIC, true);
        replacingAllLeadingFirstOrTrailingPhraseParser = future;
        future.setParser(
          sequence(
            choice(
              token("ALL"),
              token("LEADING"),
              token("FIRST"),
              token("TRAILING")
            ),
            star(
              sequence(
                choice(
                  identifier(),
                  literal()
                ),
                token("BY"),
                choice(
                  identifier(),
                  literal()
                ),
                star(
                  locationPhrase()
                )
              )
            )
          )
        );
      }
    
      return replacingAllLeadingFirstOrTrailingPhraseParser;
    }
    
    // ========================================================
    // locationPhrase
    // ........................................................
    
    private ParserCombinator locationPhraseParser = null;
    
    public final Start locationPhrase = Start.on(getNamespace(), "locationPhrase");
    
    public ParserCombinator locationPhrase() {
      if (locationPhraseParser == null) {
        FutureParser future = scoped("locationPhrase", PUBLIC, true);
        locationPhraseParser = future;
        future.setParser(
          sequence(
            choice(
              token("BEFORE"),
              token("AFTER")
            ),
            optional(
              token("INITIAL")
            ),
            choice(
              identifier(),
              literal()
            )
          )
        );
      }
    
      return locationPhraseParser;
    }
    
    // ========================================================
    // mergeStatement
    // ........................................................
    
    private ParserCombinator mergeStatementParser = null;
    
    public final Start mergeStatement = Start.on(getNamespace(), "mergeStatement");
    
    public ParserCombinator mergeStatement() {
      if (mergeStatementParser == null) {
        FutureParser future = scoped("mergeStatement", PUBLIC, true);
        mergeStatementParser = future;
        future.setParser(
          sequence(
            token("MERGE"),
            fileName(),
            plus(
              as("key",
                sequence(
                  optional(
                    token("ON")
                  ),
                  choice(
                    as("asc",
                      token("ASCENDING")
                    ),
                    as("desc",
                      token("DESCENDING")
                    )
                  ),
                  optional(
                    token("KEY")
                  ),
                  optional(
                    token("IS")
                  ),
                  plus(
                    qualifiedDataName()
                  )
                )
              )
            ),
            optional(
              as("sequence",
                sequence(
                  optional(
                    as("collating",
                      token("COLLATING")
                    )
                  ),
                  token("SEQUENCE"),
                  optional(
                    token("IS")
                  ),
                  alphabetName()
                )
              )
            ),
            as("using",
              sequence(
                token("USING"),
                fileName(),
                plus(
                  fileName()
                )
              )
            ),
            choice(
              as("output",
                sequence(
                  token("OUTPUT"),
                  token("PROCEDURE"),
                  optional(
                    token("IS")
                  ),
                  procedureName(),
                  optional(
                    sequence(
                      choice(
                        token("THROUGH"),
                        token("THRU")
                      ),
                      procedureName()
                    )
                  )
                )
              ),
              as("giving",
                sequence(
                  token("GIVING"),
                  plus(
                    fileName()
                  )
                )
              )
            )
          )
        );
      }
    
      return mergeStatementParser;
    }
    
    // ========================================================
    // moveStatement
    // ........................................................
    
    private ParserCombinator moveStatementParser = null;
    
    public final Start moveStatement = Start.on(getNamespace(), "moveStatement");
    
    public ParserCombinator moveStatement() {
      if (moveStatementParser == null) {
        FutureParser future = scoped("moveStatement", PUBLIC, true);
        moveStatementParser = future;
        future.setParser(
          sequence(
            token("MOVE"),
            choice(
              as("corresponding",
                sequence(
                  choice(
                    token("CORRESPONDING"),
                    token("CORR")
                  ),
                  identifier()
                )
              ),
              as("sending",
                identifier()
              ),
              literal()
            ),
            token("TO"),
            plus(
              identifier()
            ),
            optional(
              as("unknown",
                skipto(
                  somethingFollowingAStatement()
                )
              )
            )
          )
        );
      }
    
      return moveStatementParser;
    }
    
    // ========================================================
    // multiplyStatement
    // ........................................................
    
    private ParserCombinator multiplyStatementParser = null;
    
    public final Start multiplyStatement = Start.on(getNamespace(), "multiplyStatement");
    
    public ParserCombinator multiplyStatement() {
      if (multiplyStatementParser == null) {
        FutureParser future = scoped("multiplyStatement", PUBLIC, true);
        multiplyStatementParser = future;
        future.setParser(
          sequence(
            token("MULTIPLY"),
            choice(
              multiplyStatement$format1(),
              multiplyStatement$format2()
            ),
            optional(
              onSizeError()
            ),
            optional(
              notOnSizeError()
            ),
            optional(
              token("END-MULTIPLY")
            )
          )
        );
      }
    
      return multiplyStatementParser;
    }
    
    // ========================================================
    // format1
    // ........................................................
    
    private ParserCombinator multiplyStatement$format1Parser = null;
    
    protected final Start multiplyStatement$format1 = Start.on(getNamespace(), "format1");
    
    protected ParserCombinator multiplyStatement$format1() {
      if (multiplyStatement$format1Parser == null) {
        FutureParser future = scoped("format1", PRIVATE, true);
        multiplyStatement$format1Parser = future;
        future.setParser(
          sequence(
            choice(
              identifier(),
              literal()
            ),
            as("by",
              sequence(
                token("BY"),
                choice(
                  identifier(),
                  literal()
                )
              )
            ),
            as("giving",
              sequence(
                token("GIVING"),
                plus(
                  sequence(
                    as("identifier",
                      qualifiedDataName()
                    ),
                    optional(
                      token("ROUNDED")
                    )
                  )
                )
              )
            )
          )
        );
      }
    
      return multiplyStatement$format1Parser;
    }
    
    // ========================================================
    // format2
    // ........................................................
    
    private ParserCombinator multiplyStatement$format2Parser = null;
    
    protected final Start multiplyStatement$format2 = Start.on(getNamespace(), "format2");
    
    protected ParserCombinator multiplyStatement$format2() {
      if (multiplyStatement$format2Parser == null) {
        FutureParser future = scoped("format2", PRIVATE, true);
        multiplyStatement$format2Parser = future;
        future.setParser(
          sequence(
            choice(
              identifier(),
              literal()
            ),
            as("by",
              sequence(
                token("BY"),
                plus(
                  sequence(
                    qualifiedDataName(),
                    optional(
                      token("ROUNDED")
                    )
                  )
                )
              )
            )
          )
        );
      }
    
      return multiplyStatement$format2Parser;
    }
    
    // ========================================================
    // nextSentenceStatement
    // ........................................................
    
    private ParserCombinator nextSentenceStatementParser = null;
    
    public final Start nextSentenceStatement = Start.on(getNamespace(), "nextSentenceStatement");
    
    public ParserCombinator nextSentenceStatement() {
      if (nextSentenceStatementParser == null) {
        FutureParser future = scoped("nextSentenceStatement", PUBLIC, true);
        nextSentenceStatementParser = future;
        future.setParser(
          sequence(
            token("NEXT"),
            token("SENTENCE")
          )
        );
      }
    
      return nextSentenceStatementParser;
    }
    
    // ========================================================
    // onStatement
    // ........................................................
    
    private ParserCombinator onStatementParser = null;
    
    public final Start onStatement = Start.on(getNamespace(), "onStatement");
    
    public ParserCombinator onStatement() {
      if (onStatementParser == null) {
        FutureParser future = scoped("onStatement", PUBLIC, true);
        onStatementParser = future;
        future.setParser(
          sequence(
            token("ON"),
            not(
              eventType()
            ),
            choice(
              literal(),
              identifier()
            ),
            optional(
              sequence(
                token("AND"),
                token("EVERY"),
                choice(
                  literal(),
                  identifier()
                )
              )
            ),
            optional(
              sequence(
                token("UNTIL"),
                choice(
                  literal(),
                  identifier()
                )
              )
            ),
            choice(
              nestedStatements(),
              sequence(
                token("NEXT"),
                token("SENTENCE")
              )
            ),
            optional(
              sequence(
                choice(
                  token("ELSE"),
                  token("OTHERWISE")
                ),
                choice(
                  nestedStatements(),
                  sequence(
                    token("NEXT"),
                    token("SENTENCE")
                  )
                )
              )
            )
          )
        );
      }
    
      return onStatementParser;
    }
    
    // ========================================================
    // openStatement
    // ........................................................
    
    private ParserCombinator openStatementParser = null;
    
    public final Start openStatement = Start.on(getNamespace(), "openStatement");
    
    public ParserCombinator openStatement() {
      if (openStatementParser == null) {
        FutureParser future = scoped("openStatement", PUBLIC, true);
        openStatementParser = future;
        future.setParser(
          sequence(
            token("OPEN"),
            plus(
              choice(
                sequence(
                  token("INPUT"),
                  plus(
                    sequence(
                      fileName(),
                      optional(
                        choice(
                          token("REVERSED"),
                          sequence(
                            optional(
                              token("WITH")
                            ),
                            token("NO"),
                            token("REWIND")
                          )
                        )
                      )
                    )
                  )
                ),
                sequence(
                  token("OUTPUT"),
                  plus(
                    sequence(
                      fileName(),
                      optional(
                        sequence(
                          optional(
                            token("WITH")
                          ),
                          token("NO"),
                          token("REWIND")
                        )
                      )
                    )
                  )
                ),
                sequence(
                  token("I-O"),
                  plus(
                    fileName()
                  )
                ),
                sequence(
                  token("EXTEND"),
                  plus(
                    fileName()
                  )
                )
              )
            )
          )
        );
      }
    
      return openStatementParser;
    }
    
    // ========================================================
    // performStatement
    // ........................................................
    
    private ParserCombinator performStatementParser = null;
    
    public final Start performStatement = Start.on(getNamespace(), "performStatement");
    
    public ParserCombinator performStatement() {
      if (performStatementParser == null) {
        FutureParser future = scoped("performStatement", PUBLIC, true);
        performStatementParser = future;
        future.setParser(
          sequence(
            token("PERFORM"),
            choice(
              sequence(
                optional(
                  choice(
                    times(),
                    until(),
                    varying()
                  )
                ),
                choice(
                  sequence(
                    nestedStatements(),
                    token("END-PERFORM")
                  ),
                  as("nestedStatements",
                    sequence(
                      statement(),
                      not(
                        token("THRU")
                      ),
                      not(
                        token("THROUGH")
                      )
                    )
                  ),
                  token("END-PERFORM")
                )
              ),
              sequence(
                procedureName(),
                optional(
                  sequence(
                    choice(
                      token("THROUGH"),
                      token("THRU")
                    ),
                    procedureName()
                  )
                ),
                optional(
                  choice(
                    times(),
                    until(),
                    varying()
                  )
                )
              )
            )
          )
        );
      }
    
      return performStatementParser;
    }
    
    // ========================================================
    // times
    // ........................................................
    
    private ParserCombinator timesParser = null;
    
    public final Start times = Start.on(getNamespace(), "times");
    
    public ParserCombinator times() {
      if (timesParser == null) {
        FutureParser future = scoped("times", PUBLIC, true);
        timesParser = future;
        future.setParser(
          sequence(
            choice(
              identifier(),
              integer()
            ),
            token("TIMES")
          )
        );
      }
    
      return timesParser;
    }
    
    // ========================================================
    // testPosition
    // ........................................................
    
    private ParserCombinator testPositionParser = null;
    
    public final Start testPosition = Start.on(getNamespace(), "testPosition");
    
    public ParserCombinator testPosition() {
      if (testPositionParser == null) {
        FutureParser future = scoped("testPosition", PUBLIC, true);
        testPositionParser = future;
        future.setParser(
          sequence(
            optional(
              token("WITH")
            ),
            token("TEST"),
            choice(
              token("BEFORE"),
              token("AFTER")
            )
          )
        );
      }
    
      return testPositionParser;
    }
    
    // ========================================================
    // until
    // ........................................................
    
    private ParserCombinator untilParser = null;
    
    public final Start until = Start.on(getNamespace(), "until");
    
    public ParserCombinator until() {
      if (untilParser == null) {
        FutureParser future = scoped("until", PUBLIC, true);
        untilParser = future;
        future.setParser(
          sequence(
            optional(
              testPosition()
            ),
            choice(
              sequence(
                token("UNTIL"),
                choice(
                  condition(),
                  token("EXIT")
                )
              ),
              token("FOREVER")
            )
          )
        );
      }
    
      return untilParser;
    }
    
    // ========================================================
    // varying
    // ........................................................
    
    private ParserCombinator varyingParser = null;
    
    public final Start varying = Start.on(getNamespace(), "varying");
    
    public ParserCombinator varying() {
      if (varyingParser == null) {
        FutureParser future = scoped("varying", PUBLIC, true);
        varyingParser = future;
        future.setParser(
          sequence(
            optional(
              testPosition()
            ),
            token("VARYING"),
            identifier(),
            as("from",
              sequence(
                token("FROM"),
                choice(
                  literal(),
                  identifier()
                )
              )
            ),
            as("by",
              sequence(
                token("BY"),
                choice(
                  literal(),
                  identifier()
                )
              )
            ),
            as("until",
              sequence(
                token("UNTIL"),
                condition()
              )
            ),
            star(
              as("after",
                sequence(
                  token("AFTER"),
                  identifier(),
                  as("from",
                    sequence(
                      token("FROM"),
                      choice(
                        literal(),
                        identifier()
                      )
                    )
                  ),
                  as("by",
                    sequence(
                      token("BY"),
                      choice(
                        literal(),
                        identifier()
                      )
                    )
                  ),
                  as("until",
                    sequence(
                      token("UNTIL"),
                      condition()
                    )
                  )
                )
              )
            )
          )
        );
      }
    
      return varyingParser;
    }
    
    // ========================================================
    // purgeStatement
    // ........................................................
    
    private ParserCombinator purgeStatementParser = null;
    
    public final Start purgeStatement = Start.on(getNamespace(), "purgeStatement");
    
    public ParserCombinator purgeStatement() {
      if (purgeStatementParser == null) {
        FutureParser future = scoped("purgeStatement", PUBLIC, true);
        purgeStatementParser = future;
        future.setParser(
          sequence(
            token("PURGE"),
            cdName()
          )
        );
      }
    
      return purgeStatementParser;
    }
    
    // ========================================================
    // raiseStatement
    // ........................................................
    
    private ParserCombinator raiseStatementParser = null;
    
    public final Start raiseStatement = Start.on(getNamespace(), "raiseStatement");
    
    public ParserCombinator raiseStatement() {
      if (raiseStatementParser == null) {
        FutureParser future = scoped("raiseStatement", PUBLIC, true);
        raiseStatementParser = future;
        future.setParser(
          sequence(
            token("RAISE"),
            optional(
              identifier()
            )
          )
        );
      }
    
      return raiseStatementParser;
    }
    
    // ========================================================
    // readStatement
    // ........................................................
    
    private ParserCombinator readStatementParser = null;
    
    public final Start readStatement = Start.on(getNamespace(), "readStatement");
    
    public ParserCombinator readStatement() {
      if (readStatementParser == null) {
        FutureParser future = scoped("readStatement", PUBLIC, true);
        readStatementParser = future;
        future.setParser(
          sequence(
            token("READ"),
            fileName(),
            optional(
              choice(
                token("NEXT"),
                token("PREVIOUS")
              )
            ),
            optional(
              token("RECORD")
            ),
            optional(
              sequence(
                token("INTO"),
                identifier_format2()
              )
            ),
            optional(
              choice(
                sequence(
                  token("ADVANCING"),
                  optional(
                    token("ON")
                  ),
                  token("LOCK")
                ),
                sequence(
                  token("IGNORING"),
                  token("LOCK")
                ),
                sequence(
                  optional(
                    token("WITH")
                  ),
                  choice(
                    sequence(
                      optional(
                        choice(
                          token("KEPT"),
                          token("NO"),
                          token("IGNORE")
                        )
                      ),
                      token("LOCK")
                    ),
                    token("WAIT")
                  )
                ),
                retryPhrase()
              )
            ),
            optional(
              sequence(
                token("KEY"),
                optional(
                  token("IS")
                ),
                qualifiedDataName()
              )
            ),
            optional(
              atEnd()
            ),
            optional(
              notAtEnd()
            ),
            optional(
              invalidKey()
            ),
            optional(
              notInvalidKey()
            ),
            optional(
              token("END-READ")
            )
          )
        );
      }
    
      return readStatementParser;
    }
    
    // ========================================================
    // readWithClause
    // ........................................................
    
    private ParserCombinator readWithClauseParser = null;
    
    public final Start readWithClause = Start.on(getNamespace(), "readWithClause");
    
    public ParserCombinator readWithClause() {
      if (readWithClauseParser == null) {
        FutureParser future = scoped("readWithClause", PUBLIC, true);
        readWithClauseParser = future;
        future.setParser(
          sequence(
            optional(
              token("WITH")
            ),
            choice(
              readLockClause(),
              token("WAIT")
            )
          )
        );
      }
    
      return readWithClauseParser;
    }
    
    // ========================================================
    // readLockClause
    // ........................................................
    
    private ParserCombinator readLockClauseParser = null;
    
    public final Start readLockClause = Start.on(getNamespace(), "readLockClause");
    
    public ParserCombinator readLockClause() {
      if (readLockClauseParser == null) {
        FutureParser future = scoped("readLockClause", PUBLIC, true);
        readLockClauseParser = future;
        future.setParser(
          sequence(
            optional(
              choice(
                token("KEPT"),
                token("NO"),
                token("IGNORE")
              )
            ),
            token("LOCK")
          )
        );
      }
    
      return readLockClauseParser;
    }
    
    // ========================================================
    // readyTraceStatement
    // ........................................................
    
    private ParserCombinator readyTraceStatementParser = null;
    
    public final Start readyTraceStatement = Start.on(getNamespace(), "readyTraceStatement");
    
    public ParserCombinator readyTraceStatement() {
      if (readyTraceStatementParser == null) {
        FutureParser future = scoped("readyTraceStatement", PUBLIC, true);
        readyTraceStatementParser = future;
        future.setParser(
          sequence(
            token("READY"),
            token("TRACE"),
            optional(
              literal(".")
            )
          )
        );
      }
    
      return readyTraceStatementParser;
    }
    
    // ========================================================
    // receiveStatement
    // ........................................................
    
    private ParserCombinator receiveStatementParser = null;
    
    public final Start receiveStatement = Start.on(getNamespace(), "receiveStatement");
    
    public ParserCombinator receiveStatement() {
      if (receiveStatementParser == null) {
        FutureParser future = scoped("receiveStatement", PUBLIC, true);
        receiveStatementParser = future;
        future.setParser(
          sequence(
            token("RECEIVE"),
            choice(
              sequence(
                dataName(),
                token("FROM"),
                choice(
                  sequence(
                    token("THREAD"),
                    dataName()
                  ),
                  sequence(
                    token("LAST"),
                    token("THREAD")
                  ),
                  sequence(
                    token("ANY"),
                    token("THREAD")
                  )
                ),
                optional(
                  permuted(
                    sequence(
                      token("BEFORE"),
                      optional(
                        token("TIME")
                      ),
                      choice(
                        numeric(),
                        identifier()
                      )
                    ),
                    sequence(
                      optional(
                        token("WITH")
                      ),
                      token("NO"),
                      token("WAIT")
                    ),
                    sequence(
                      token("THREAD"),
                      optional(
                        token("IN")
                      ),
                      dataName()
                    ),
                    sequence(
                      token("SIZE"),
                      optional(
                        token("IN")
                      ),
                      choice(
                        numeric(),
                        identifier()
                      )
                    ),
                    sequence(
                      token("STATUS"),
                      optional(
                        token("IN")
                      ),
                      choice(
                        alphanumericLiteral(),
                        identifier()
                      )
                    ),
                    onException(),
                    notOnException()
                  )
                )
              ),
              sequence(
                cdName(),
                choice(
                  token("MESSAGE"),
                  token("SEGMENT")
                ),
                optional(
                  token("INTO")
                ),
                identifier(),
                optional(
                  noData()
                ),
                optional(
                  withData()
                )
              )
            ),
            optional(
              token("END-RECEIVE")
            )
          )
        );
      }
    
      return receiveStatementParser;
    }
    
    // ========================================================
    // noData
    // ........................................................
    
    private ParserCombinator noDataParser = null;
    
    public final Start noData = Start.on(getNamespace(), "noData");
    
    public ParserCombinator noData() {
      if (noDataParser == null) {
        FutureParser future = scoped("noData", PUBLIC, true);
        noDataParser = future;
        future.setParser(
          sequence(
            token("NO"),
            token("DATA"),
            nestedStatements()
          )
        );
      }
    
      return noDataParser;
    }
    
    // ========================================================
    // withData
    // ........................................................
    
    private ParserCombinator withDataParser = null;
    
    public final Start withData = Start.on(getNamespace(), "withData");
    
    public ParserCombinator withData() {
      if (withDataParser == null) {
        FutureParser future = scoped("withData", PUBLIC, true);
        withDataParser = future;
        future.setParser(
          sequence(
            token("WITH"),
            token("DATA"),
            nestedStatements()
          )
        );
      }
    
      return withDataParser;
    }
    
    // ========================================================
    // releaseStatement
    // ........................................................
    
    private ParserCombinator releaseStatementParser = null;
    
    public final Start releaseStatement = Start.on(getNamespace(), "releaseStatement");
    
    public ParserCombinator releaseStatement() {
      if (releaseStatementParser == null) {
        FutureParser future = scoped("releaseStatement", PUBLIC, true);
        releaseStatementParser = future;
        future.setParser(
          sequence(
            token("RELEASE"),
            recordName(),
            optional(
              sequence(
                token("FROM"),
                identifier()
              )
            )
          )
        );
      }
    
      return releaseStatementParser;
    }
    
    // ========================================================
    // resetTraceStatement
    // ........................................................
    
    private ParserCombinator resetTraceStatementParser = null;
    
    public final Start resetTraceStatement = Start.on(getNamespace(), "resetTraceStatement");
    
    public ParserCombinator resetTraceStatement() {
      if (resetTraceStatementParser == null) {
        FutureParser future = scoped("resetTraceStatement", PUBLIC, true);
        resetTraceStatementParser = future;
        future.setParser(
          sequence(
            token("RESET"),
            token("TRACE"),
            optional(
              literal(".")
            )
          )
        );
      }
    
      return resetTraceStatementParser;
    }
    
    // ========================================================
    // returnStatement
    // ........................................................
    
    private ParserCombinator returnStatementParser = null;
    
    public final Start returnStatement = Start.on(getNamespace(), "returnStatement");
    
    public ParserCombinator returnStatement() {
      if (returnStatementParser == null) {
        FutureParser future = scoped("returnStatement", PUBLIC, true);
        returnStatementParser = future;
        future.setParser(
          sequence(
            token("RETURN"),
            fileName(),
            optional(
              token("RECORD")
            ),
            optional(
              as("into",
                sequence(
                  token("INTO"),
                  identifier()
                )
              )
            ),
            atEnd(),
            optional(
              notAtEnd()
            ),
            optional(
              token("END-RETURN")
            )
          )
        );
      }
    
      return returnStatementParser;
    }
    
    // ========================================================
    // rewriteStatement
    // ........................................................
    
    private ParserCombinator rewriteStatementParser = null;
    
    public final Start rewriteStatement = Start.on(getNamespace(), "rewriteStatement");
    
    public ParserCombinator rewriteStatement() {
      if (rewriteStatementParser == null) {
        FutureParser future = scoped("rewriteStatement", PUBLIC, true);
        rewriteStatementParser = future;
        future.setParser(
          sequence(
            token("REWRITE"),
            choice(
              sequence(
                token("FILE"),
                fileName()
              ),
              recordName()
            ),
            optional(
              sequence(
                token("FROM"),
                choice(
                  identifier(),
                  literal()
                )
              )
            ),
            optional(
              retryPhrase()
            ),
            optional(
              sequence(
                optional(
                  token("WITH")
                ),
                optional(
                  token("NO")
                ),
                token("LOCK")
              )
            ),
            optional(
              invalidKey()
            ),
            optional(
              notInvalidKey()
            ),
            optional(
              token("END-REWRITE")
            )
          )
        );
      }
    
      return rewriteStatementParser;
    }
    
    // ========================================================
    // rollbackStatement
    // ........................................................
    
    private ParserCombinator rollbackStatementParser = null;
    
    public final Start rollbackStatement = Start.on(getNamespace(), "rollbackStatement");
    
    public ParserCombinator rollbackStatement() {
      if (rollbackStatementParser == null) {
        FutureParser future = scoped("rollbackStatement", PUBLIC, true);
        rollbackStatementParser = future;
        future.setParser(
          token("ROLLBACK")
        );
      }
    
      return rollbackStatementParser;
    }
    
    // ========================================================
    // searchStatement
    // ........................................................
    
    private ParserCombinator searchStatementParser = null;
    
    public final Start searchStatement = Start.on(getNamespace(), "searchStatement");
    
    public ParserCombinator searchStatement() {
      if (searchStatementParser == null) {
        FutureParser future = scoped("searchStatement", PUBLIC, true);
        searchStatementParser = future;
        future.setParser(
          sequence(
            token("SEARCH"),
            choice(
              sequence(
                token("ALL"),
                identifier()
              ),
              sequence(
                identifier(),
                optional(
                  sequence(
                    token("VARYING"),
                    choice(
                      identifier(),
                      indexName()
                    )
                  )
                )
              )
            ),
            optional(
              atEnd()
            ),
            plus(
              as("when",
                sequence(
                  token("WHEN"),
                  condition(),
                  choice(
                    nestedStatements(),
                    sequence(
                      token("NEXT"),
                      token("SENTENCE")
                    )
                  )
                )
              )
            ),
            optional(
              token("END-SEARCH")
            )
          )
        );
      }
    
      return searchStatementParser;
    }
    
    // ========================================================
    // atEnd
    // ........................................................
    
    private ParserCombinator atEndParser = null;
    
    public final Start atEnd = Start.on(getNamespace(), "atEnd");
    
    public ParserCombinator atEnd() {
      if (atEndParser == null) {
        FutureParser future = scoped("atEnd", PUBLIC, true);
        atEndParser = future;
        future.setParser(
          sequence(
            optional(
              token("AT")
            ),
            token("END"),
            nestedStatements()
          )
        );
      }
    
      return atEndParser;
    }
    
    // ========================================================
    // notAtEnd
    // ........................................................
    
    private ParserCombinator notAtEndParser = null;
    
    public final Start notAtEnd = Start.on(getNamespace(), "notAtEnd");
    
    public ParserCombinator notAtEnd() {
      if (notAtEndParser == null) {
        FutureParser future = scoped("notAtEnd", PUBLIC, true);
        notAtEndParser = future;
        future.setParser(
          sequence(
            token("NOT"),
            optional(
              token("AT")
            ),
            token("END"),
            nestedStatements()
          )
        );
      }
    
      return notAtEndParser;
    }
    
    // ========================================================
    // sendStatement
    // ........................................................
    
    private ParserCombinator sendStatementParser = null;
    
    public final Start sendStatement = Start.on(getNamespace(), "sendStatement");
    
    public ParserCombinator sendStatement() {
      if (sendStatementParser == null) {
        FutureParser future = scoped("sendStatement", PUBLIC, true);
        sendStatementParser = future;
        future.setParser(
          sequence(
            token("SEND"),
            choice(
              sequence(
                dataName(),
                token("TO"),
                choice(
                  sequence(
                    token("LAST"),
                    token("THREAD")
                  ),
                  sequence(
                    token("ALL"),
                    token("THREADS")
                  ),
                  plus(
                    sequence(
                      optional(
                        token("THREAD")
                      ),
                      dataName()
                    )
                  )
                )
              ),
              sequence(
                cdName(),
                optional(
                  sequence(
                    token("FROM"),
                    identifier()
                  )
                ),
                optional(
                  sequence(
                    optional(
                      token("WITH")
                    ),
                    choice(
                      token("ESI"),
                      token("EMI"),
                      token("EGI"),
                      identifier()
                    ),
                    optional(
                      sequence(
                        choice(
                          token("BEFORE"),
                          token("AFTER")
                        ),
                        optional(
                          token("ADVANCING")
                        ),
                        choice(
                          token("PAGE"),
                          sequence(
                            choice(
                              zero(),
                              integer(),
                              identifier()
                            ),
                            optional(
                              choice(
                                token("LINE"),
                                token("LINES")
                              )
                            )
                          ),
                          mnemonicName()
                        )
                      )
                    ),
                    optional(
                      sequence(
                        token("REPLACING"),
                        optional(
                          token("LINE")
                        )
                      )
                    )
                  )
                )
              )
            )
          )
        );
      }
    
      return sendStatementParser;
    }
    
    // ========================================================
    // serviceStatement
    // ........................................................
    
    private ParserCombinator serviceStatementParser = null;
    
    public final Start serviceStatement = Start.on(getNamespace(), "serviceStatement");
    
    public ParserCombinator serviceStatement() {
      if (serviceStatementParser == null) {
        FutureParser future = scoped("serviceStatement", PUBLIC, true);
        serviceStatementParser = future;
        future.setParser(
          sequence(
            token("SERVICE"),
            choice(
              token("LABEL"),
              sequence(
                token("RELOAD"),
                identifier()
              )
            )
          )
        );
      }
    
      return serviceStatementParser;
    }
    
    // ========================================================
    // sortStatement
    // ........................................................
    
    private ParserCombinator sortStatementParser = null;
    
    public final Start sortStatement = Start.on(getNamespace(), "sortStatement");
    
    public ParserCombinator sortStatement() {
      if (sortStatementParser == null) {
        FutureParser future = scoped("sortStatement", PUBLIC, true);
        sortStatementParser = future;
        future.setParser(
          choice(
            sequence(
              token("SORT"),
              fileName(),
              plus(
                sequence(
                  optional(
                    token("ON")
                  ),
                  plus(
                    as("key",
                      sequence(
                        choice(
                          as("asc",
                            token("ASCENDING")
                          ),
                          as("desc",
                            token("DESCENDING")
                          )
                        ),
                        optional(
                          token("KEY")
                        ),
                        optional(
                          token("IS")
                        ),
                        plus(
                          qualifiedDataName()
                        )
                      )
                    )
                  )
                )
              ),
              optional(
                as("duplicates",
                  sequence(
                    optional(
                      token("WITH")
                    ),
                    token("DUPLICATES"),
                    optional(
                      sequence(
                        token("IN"),
                        token("ORDER")
                      )
                    )
                  )
                )
              ),
              optional(
                as("sequence",
                  sequence(
                    optional(
                      token("COLLATING")
                    ),
                    token("SEQUENCE"),
                    optional(
                      token("IS")
                    ),
                    alphabetName()
                  )
                )
              ),
              choice(
                as("input",
                  sequence(
                    token("INPUT"),
                    token("PROCEDURE"),
                    optional(
                      token("IS")
                    ),
                    procedureName(),
                    optional(
                      sequence(
                        choice(
                          token("THROUGH"),
                          token("THRU")
                        ),
                        procedureName()
                      )
                    )
                  )
                ),
                as("using",
                  sequence(
                    token("USING"),
                    plus(
                      fileName()
                    )
                  )
                )
              ),
              choice(
                as("output",
                  sequence(
                    token("OUTPUT"),
                    token("PROCEDURE"),
                    optional(
                      token("IS")
                    ),
                    procedureName(),
                    optional(
                      sequence(
                        choice(
                          token("THROUGH"),
                          token("THRU")
                        ),
                        procedureName()
                      )
                    )
                  )
                ),
                as("giving",
                  sequence(
                    token("GIVING"),
                    plus(
                      fileName()
                    )
                  )
                )
              )
            ),
            sequence(
              token("SORT"),
              dataName(),
              plus(
                sequence(
                  optional(
                    token("ON")
                  ),
                  plus(
                    as("key",
                      sequence(
                        choice(
                          as("asc",
                            token("ASCENDING")
                          ),
                          as("desc",
                            token("DESCENDING")
                          )
                        ),
                        optional(
                          token("KEY")
                        ),
                        optional(
                          token("IS")
                        ),
                        plus(
                          qualifiedDataName()
                        )
                      )
                    )
                  )
                )
              ),
              optional(
                as("duplicates",
                  sequence(
                    optional(
                      token("WITH")
                    ),
                    token("DUPLICATES"),
                    optional(
                      sequence(
                        token("IN"),
                        token("ORDER")
                      )
                    )
                  )
                )
              ),
              optional(
                as("sequence",
                  sequence(
                    optional(
                      token("COLLATING")
                    ),
                    token("SEQUENCE"),
                    optional(
                      token("IS")
                    ),
                    alphabetName()
                  )
                )
              )
            )
          )
        );
      }
    
      return sortStatementParser;
    }
    
    // ========================================================
    // setStatement
    // ........................................................
    
    private ParserCombinator setStatementParser = null;
    
    public final Start setStatement = Start.on(getNamespace(), "setStatement");
    
    public ParserCombinator setStatement() {
      if (setStatementParser == null) {
        FutureParser future = scoped("setStatement", PUBLIC, true);
        setStatementParser = future;
        future.setParser(
          sequence(
            token("SET"),
            choice(
              setEnvironmentVariable(),
              setOther()
            ),
            optional(
              as("unknown",
                skipto(
                  somethingFollowingAStatement()
                )
              )
            )
          )
        );
      }
    
      return setStatementParser;
    }
    
    // ========================================================
    // setEnvironmentVariable
    // ........................................................
    
    private ParserCombinator setEnvironmentVariableParser = null;
    
    public final Start setEnvironmentVariable = Start.on(getNamespace(), "setEnvironmentVariable");
    
    public ParserCombinator setEnvironmentVariable() {
      if (setEnvironmentVariableParser == null) {
        FutureParser future = scoped("setEnvironmentVariable", PUBLIC, true);
        setEnvironmentVariableParser = future;
        future.setParser(
          sequence(
            token("ENVIRONMENT"),
            literal(),
            token("TO"),
            literal()
          )
        );
      }
    
      return setEnvironmentVariableParser;
    }
    
    // ========================================================
    // setOther
    // ........................................................
    
    private ParserCombinator setOtherParser = null;
    
    public final Start setOther = Start.on(getNamespace(), "setOther");
    
    public ParserCombinator setOther() {
      if (setOtherParser == null) {
        FutureParser future = scoped("setOther", PUBLIC, true);
        setOtherParser = future;
        future.setParser(
          sequence(
            plus(
              choice(
                sequence(
                  token("ADDRESS"),
                  optional(
                    token("OF")
                  ),
                  identifier()
                ),
                qualifiedDataName(),
                identifier()
              )
            ),
            choice(
              sequence(
                token("TO"),
                choice(
                  token("ON"),
                  token("OFF"),
                  token("TRUE"),
                  token("FALSE"),
                  sequence(
                    token("ADDRESS"),
                    optional(
                      token("OF")
                    ),
                    identifier()
                  ),
                  sequence(
                    optional(
                      token("NOT")
                    ),
                    choice(
                      token("BROWSING"),
                      token("READING"),
                      token("WRITING")
                    ),
                    optional(
                      sequence(
                        token("CONVERTING"),
                        token("FROM"),
                        choice(
                          token("BROWSING"),
                          token("WRITING")
                        )
                      )
                    )
                  ),
                  sequence(
                    token("ENTRY"),
                    choice(
                      identifier(),
                      literal()
                    )
                  ),
                  token("NULL"),
                  token("NULLS"),
                  figurativeConstant(),
                  name(),
                  identifier(),
                  integer()
                )
              ),
              sequence(
                choice(
                  token("UP"),
                  token("DOWN")
                ),
                token("BY"),
                choice(
                  identifier(),
                  integer()
                )
              )
            )
          )
        );
      }
    
      return setOtherParser;
    }
    
    // ========================================================
    // startStatement
    // ........................................................
    
    private ParserCombinator startStatementParser = null;
    
    public final Start startStatement = Start.on(getNamespace(), "startStatement");
    
    public ParserCombinator startStatement() {
      if (startStatementParser == null) {
        FutureParser future = scoped("startStatement", PUBLIC, true);
        startStatementParser = future;
        future.setParser(
          sequence(
            token("START"),
            fileName(),
            optional(
              sequence(
                optional(
                  token("WITH")
                ),
                token("NO"),
                token("LOCK")
              )
            ),
            optional(
              choice(
                token("FIRST"),
                token("LAST"),
                sequence(
                  token("KEY"),
                  relop(),
                  identifier(),
                  optional(
                    sequence(
                      optional(
                        token("WITH")
                      ),
                      token("LENGTH"),
                      arithmeticExpression()
                    )
                  )
                )
              )
            ),
            optional(
              sizeModifier()
            ),
            optional(
              whileKeyModifier()
            ),
            optional(
              invalidKey()
            ),
            optional(
              notInvalidKey()
            ),
            optional(
              token("END-START")
            )
          )
        );
      }
    
      return startStatementParser;
    }
    
    // ========================================================
    // sizeModifier
    // ........................................................
    
    private ParserCombinator sizeModifierParser = null;
    
    public final Start sizeModifier = Start.on(getNamespace(), "sizeModifier");
    
    public ParserCombinator sizeModifier() {
      if (sizeModifierParser == null) {
        FutureParser future = scoped("sizeModifier", PUBLIC, true);
        sizeModifierParser = future;
        future.setParser(
          sequence(
            optional(
              token("WITH")
            ),
            token("SIZE"),
            choice(
              identifier(),
              integer()
            )
          )
        );
      }
    
      return sizeModifierParser;
    }
    
    // ========================================================
    // whileKeyModifier
    // ........................................................
    
    private ParserCombinator whileKeyModifierParser = null;
    
    public final Start whileKeyModifier = Start.on(getNamespace(), "whileKeyModifier");
    
    public ParserCombinator whileKeyModifier() {
      if (whileKeyModifierParser == null) {
        FutureParser future = scoped("whileKeyModifier", PUBLIC, true);
        whileKeyModifierParser = future;
        future.setParser(
          sequence(
            token("WHILE"),
            optional(
              sequence(
                token("KEY"),
                optional(
                  token("IS")
                )
              )
            ),
            optional(
              token("NOT")
            ),
            token("LIKE"),
            star(
              likeMods()
            ),
            choice(
              identifier(),
              literal()
            )
          )
        );
      }
    
      return whileKeyModifierParser;
    }
    
    // ========================================================
    // likeMods
    // ........................................................
    
    private ParserCombinator likeModsParser = null;
    
    public final Start likeMods = Start.on(getNamespace(), "likeMods");
    
    public ParserCombinator likeMods() {
      if (likeModsParser == null) {
        FutureParser future = scoped("likeMods", PUBLIC, true);
        likeModsParser = future;
        future.setParser(
          choice(
            as("trimmedRight",
              sequence(
                token("TRIMMED"),
                token("RIGHT")
              )
            ),
            as("trimmedLeft",
              sequence(
                token("TRIMMED"),
                token("LEFT")
              )
            ),
            as("caseSensitive",
              token("CASE-SENSITIVE")
            ),
            as("caseInsensitive",
              token("CASE-INSENSITIVE")
            )
          )
        );
      }
    
      return likeModsParser;
    }
    
    // ========================================================
    // stopStatement
    // ........................................................
    
    private ParserCombinator stopStatementParser = null;
    
    public final Start stopStatement = Start.on(getNamespace(), "stopStatement");
    
    public ParserCombinator stopStatement() {
      if (stopStatementParser == null) {
        FutureParser future = scoped("stopStatement", PUBLIC, true);
        stopStatementParser = future;
        future.setParser(
          sequence(
            token("STOP"),
            choice(
              sequence(
                as("endpoint",
                  token("RUN")
                ),
                optional(
                  choice(
                    sequence(
                      choice(
                        token("GIVING"),
                        token("RETURNING")
                      ),
                      choice(
                        addressOf(),
                        identifier(),
                        sequence(
                          integer(),
                          optional(
                            sequence(
                              token("SIZE"),
                              optional(
                                token("IS")
                              ),
                              integer()
                            )
                          )
                        )
                      )
                    ),
                    sequence(
                      optional(
                        token("WITH")
                      ),
                      choice(
                        token("ERROR"),
                        token("NORMAL")
                      ),
                      optional(
                        token("STATUS")
                      ),
                      optional(
                        choice(
                          identifier(),
                          literal()
                        )
                      )
                    )
                  )
                )
              ),
              as("endpoint",
                token("ITERATOR")
              ),
              literal()
            )
          )
        );
      }
    
      return stopStatementParser;
    }
    
    // ========================================================
    // stringStatement
    // ........................................................
    
    private ParserCombinator stringStatementParser = null;
    
    public final Start stringStatement = Start.on(getNamespace(), "stringStatement");
    
    public ParserCombinator stringStatement() {
      if (stringStatementParser == null) {
        FutureParser future = scoped("stringStatement", PUBLIC, true);
        stringStatementParser = future;
        future.setParser(
          sequence(
            token("STRING"),
            plus(
              sequence(
                choice(
                  identifier(),
                  literal()
                ),
                optional(
                  sequence(
                    token("DELIMITED"),
                    optional(
                      token("BY")
                    ),
                    choice(
                      token("SIZE"),
                      identifier(),
                      literal()
                    )
                  )
                )
              )
            ),
            token("INTO"),
            identifier(),
            optional(
              sequence(
                optional(
                  token("WITH")
                ),
                token("POINTER"),
                identifier()
              )
            ),
            optional(
              onOverflow()
            ),
            optional(
              notOnOverflow()
            ),
            optional(
              token("END-STRING")
            )
          )
        );
      }
    
      return stringStatementParser;
    }
    
    // ========================================================
    // subtractStatement
    // ........................................................
    
    private ParserCombinator subtractStatementParser = null;
    
    public final Start subtractStatement = Start.on(getNamespace(), "subtractStatement");
    
    public ParserCombinator subtractStatement() {
      if (subtractStatementParser == null) {
        FutureParser future = scoped("subtractStatement", PUBLIC, true);
        subtractStatementParser = future;
        future.setParser(
          sequence(
            token("SUBTRACT"),
            choice(
              subtractStatement$format1(),
              subtractStatement$format2(),
              subtractStatement$format3()
            ),
            optional(
              onSizeError()
            ),
            optional(
              notOnSizeError()
            ),
            optional(
              token("END-SUBTRACT")
            )
          )
        );
      }
    
      return subtractStatementParser;
    }
    
    // ========================================================
    // format1
    // ........................................................
    
    private ParserCombinator subtractStatement$format1Parser = null;
    
    protected final Start subtractStatement$format1 = Start.on(getNamespace(), "format1");
    
    protected ParserCombinator subtractStatement$format1() {
      if (subtractStatement$format1Parser == null) {
        FutureParser future = scoped("format1", PRIVATE, true);
        subtractStatement$format1Parser = future;
        future.setParser(
          sequence(
            as("corresponding",
              sequence(
                choice(
                  token("CORRESPONDING"),
                  token("CORR")
                ),
                identifier()
              )
            ),
            as("from",
              sequence(
                token("FROM"),
                identifier(),
                optional(
                  token("ROUNDED")
                )
              )
            )
          )
        );
      }
    
      return subtractStatement$format1Parser;
    }
    
    // ========================================================
    // format2
    // ........................................................
    
    private ParserCombinator subtractStatement$format2Parser = null;
    
    protected final Start subtractStatement$format2 = Start.on(getNamespace(), "format2");
    
    protected ParserCombinator subtractStatement$format2() {
      if (subtractStatement$format2Parser == null) {
        FutureParser future = scoped("format2", PRIVATE, true);
        subtractStatement$format2Parser = future;
        future.setParser(
          sequence(
            plus(
              choice(
                identifier(),
                literal()
              )
            ),
            optional(
              as("from",
                sequence(
                  token("FROM"),
                  choice(
                    identifier(),
                    literal()
                  )
                )
              )
            ),
            as("giving",
              sequence(
                token("GIVING"),
                plus(
                  sequence(
                    identifier(),
                    optional(
                      token("ROUNDED")
                    )
                  )
                )
              )
            )
          )
        );
      }
    
      return subtractStatement$format2Parser;
    }
    
    // ========================================================
    // format3
    // ........................................................
    
    private ParserCombinator subtractStatement$format3Parser = null;
    
    protected final Start subtractStatement$format3 = Start.on(getNamespace(), "format3");
    
    protected ParserCombinator subtractStatement$format3() {
      if (subtractStatement$format3Parser == null) {
        FutureParser future = scoped("format3", PRIVATE, true);
        subtractStatement$format3Parser = future;
        future.setParser(
          sequence(
            plus(
              choice(
                identifier(),
                literal()
              )
            ),
            as("from",
              sequence(
                token("FROM"),
                plus(
                  sequence(
                    identifier(),
                    optional(
                      token("ROUNDED")
                    )
                  )
                )
              )
            )
          )
        );
      }
    
      return subtractStatement$format3Parser;
    }
    
    // ========================================================
    // suppressStatement
    // ........................................................
    
    private ParserCombinator suppressStatementParser = null;
    
    public final Start suppressStatement = Start.on(getNamespace(), "suppressStatement");
    
    public ParserCombinator suppressStatement() {
      if (suppressStatementParser == null) {
        FutureParser future = scoped("suppressStatement", PUBLIC, true);
        suppressStatementParser = future;
        future.setParser(
          sequence(
            token("SUPPRESS"),
            optional(
              token("PRINTING")
            )
          )
        );
      }
    
      return suppressStatementParser;
    }
    
    // ========================================================
    // terminateStatement
    // ........................................................
    
    private ParserCombinator terminateStatementParser = null;
    
    public final Start terminateStatement = Start.on(getNamespace(), "terminateStatement");
    
    public ParserCombinator terminateStatement() {
      if (terminateStatementParser == null) {
        FutureParser future = scoped("terminateStatement", PUBLIC, true);
        terminateStatementParser = future;
        future.setParser(
          sequence(
            token("TERMINATE"),
            plus(
              reportName()
            )
          )
        );
      }
    
      return terminateStatementParser;
    }
    
    // ========================================================
    // transformStatement
    // ........................................................
    
    private ParserCombinator transformStatementParser = null;
    
    public final Start transformStatement = Start.on(getNamespace(), "transformStatement");
    
    public ParserCombinator transformStatement() {
      if (transformStatementParser == null) {
        FutureParser future = scoped("transformStatement", PUBLIC, true);
        transformStatementParser = future;
        future.setParser(
          sequence(
            token("TRANSFORM"),
            identifier(),
            optional(
              token("CHARACTERS")
            ),
            token("FROM"),
            choice(
              figurativeConstant(),
              alphanumericLiteral(),
              identifier()
            ),
            token("TO"),
            choice(
              figurativeConstant(),
              alphanumericLiteral(),
              identifier()
            )
          )
        );
      }
    
      return transformStatementParser;
    }
    
    // ========================================================
    // unlockStatement
    // ........................................................
    
    private ParserCombinator unlockStatementParser = null;
    
    public final Start unlockStatement = Start.on(getNamespace(), "unlockStatement");
    
    public ParserCombinator unlockStatement() {
      if (unlockStatementParser == null) {
        FutureParser future = scoped("unlockStatement", PUBLIC, true);
        unlockStatementParser = future;
        future.setParser(
          sequence(
            token("UNLOCK"),
            fileName(),
            optional(
              choice(
                token("RECORD"),
                token("RECORDS")
              )
            )
          )
        );
      }
    
      return unlockStatementParser;
    }
    
    // ========================================================
    // unstringStatement
    // ........................................................
    
    private ParserCombinator unstringStatementParser = null;
    
    public final Start unstringStatement = Start.on(getNamespace(), "unstringStatement");
    
    public ParserCombinator unstringStatement() {
      if (unstringStatementParser == null) {
        FutureParser future = scoped("unstringStatement", PUBLIC, true);
        unstringStatementParser = future;
        future.setParser(
          sequence(
            token("UNSTRING"),
            identifier(),
            optional(
              sequence(
                token("DELIMITED"),
                optional(
                  token("BY")
                ),
                optional(
                  token("ALL")
                ),
                choice(
                  identifier(),
                  literal()
                ),
                star(
                  sequence(
                    token("OR"),
                    optional(
                      token("ALL")
                    ),
                    choice(
                      identifier(),
                      literal()
                    )
                  )
                )
              )
            ),
            token("INTO"),
            plus(
              sequence(
                identifier(),
                optional(
                  sequence(
                    token("DELIMITER"),
                    optional(
                      token("IN")
                    ),
                    identifier()
                  )
                ),
                optional(
                  sequence(
                    token("COUNT"),
                    optional(
                      token("IN")
                    ),
                    identifier()
                  )
                )
              )
            ),
            optional(
              sequence(
                optional(
                  token("WITH")
                ),
                token("POINTER"),
                identifier()
              )
            ),
            optional(
              sequence(
                token("TALLYING"),
                optional(
                  token("IN")
                ),
                identifier()
              )
            ),
            optional(
              onOverflow()
            ),
            optional(
              notOnOverflow()
            ),
            optional(
              token("END-UNSTRING")
            )
          )
        );
      }
    
      return unstringStatementParser;
    }
    
    // ========================================================
    // useStatement
    // ........................................................
    
    private ParserCombinator useStatementParser = null;
    
    public final Start useStatement = Start.on(getNamespace(), "useStatement");
    
    public ParserCombinator useStatement() {
      if (useStatementParser == null) {
        FutureParser future = scoped("useStatement", PUBLIC, true);
        useStatementParser = future;
        future.setParser(
          sequence(
            token("USE"),
            choice(
              errorDeclarative(),
              debugDeclarative(),
              labelDeclarative(),
              beforeReportingDeclarative()
            )
          )
        );
      }
    
      return useStatementParser;
    }
    
    // ========================================================
    // errorDeclarative
    // ........................................................
    
    private ParserCombinator errorDeclarativeParser = null;
    
    public final Start errorDeclarative = Start.on(getNamespace(), "errorDeclarative");
    
    public ParserCombinator errorDeclarative() {
      if (errorDeclarativeParser == null) {
        FutureParser future = scoped("errorDeclarative", PUBLIC, true);
        errorDeclarativeParser = future;
        future.setParser(
          sequence(
            optional(
              token("GLOBAL")
            ),
            token("AFTER"),
            optional(
              token("STANDARD")
            ),
            choice(
              token("ERROR"),
              token("EXCEPTION")
            ),
            token("PROCEDURE"),
            optional(
              token("ON")
            ),
            choice(
              token("INPUT"),
              token("OUTPUT"),
              token("I-O"),
              token("EXTEND"),
              star(
                fileName()
              )
            ),
            optional(
              sequence(
                token("GIVING"),
                dataName(),
                optional(
                  dataName()
                )
              )
            )
          )
        );
      }
    
      return errorDeclarativeParser;
    }
    
    // ========================================================
    // debugDeclarative
    // ........................................................
    
    private ParserCombinator debugDeclarativeParser = null;
    
    public final Start debugDeclarative = Start.on(getNamespace(), "debugDeclarative");
    
    public ParserCombinator debugDeclarative() {
      if (debugDeclarativeParser == null) {
        FutureParser future = scoped("debugDeclarative", PUBLIC, true);
        debugDeclarativeParser = future;
        future.setParser(
          sequence(
            optional(
              token("FOR")
            ),
            token("DEBUGGING"),
            optional(
              token("ON")
            ),
            star(
              choice(
                sequence(
                  token("ALL"),
                  token("PROCEDURES")
                ),
                sequence(
                  optional(
                    sequence(
                      token("ALL"),
                      optional(
                        token("REFERENCES")
                      ),
                      optional(
                        token("OF")
                      )
                    )
                  ),
                  identifier()
                ),
                procedureName(),
                fileName()
              )
            )
          )
        );
      }
    
      return debugDeclarativeParser;
    }
    
    // ========================================================
    // labelDeclarative
    // ........................................................
    
    private ParserCombinator labelDeclarativeParser = null;
    
    public final Start labelDeclarative = Start.on(getNamespace(), "labelDeclarative");
    
    public ParserCombinator labelDeclarative() {
      if (labelDeclarativeParser == null) {
        FutureParser future = scoped("labelDeclarative", PUBLIC, true);
        labelDeclarativeParser = future;
        future.setParser(
          sequence(
            optional(
              token("GLOBAL")
            ),
            token("AFTER"),
            optional(
              token("STANDARD")
            ),
            optional(
              choice(
                token("BEGINNING"),
                token("ENDING")
              )
            ),
            optional(
              choice(
                token("FILE"),
                token("REEL"),
                token("UNIT")
              )
            ),
            token("LABEL"),
            token("PROCEDURE"),
            optional(
              token("ON")
            ),
            choice(
              token("INPUT"),
              token("OUTPUT"),
              token("I-O"),
              token("EXTEND"),
              star(
                fileName()
              )
            )
          )
        );
      }
    
      return labelDeclarativeParser;
    }
    
    // ========================================================
    // beforeReportingDeclarative
    // ........................................................
    
    private ParserCombinator beforeReportingDeclarativeParser = null;
    
    public final Start beforeReportingDeclarative = Start.on(getNamespace(), "beforeReportingDeclarative");
    
    public ParserCombinator beforeReportingDeclarative() {
      if (beforeReportingDeclarativeParser == null) {
        FutureParser future = scoped("beforeReportingDeclarative", PUBLIC, true);
        beforeReportingDeclarativeParser = future;
        future.setParser(
          sequence(
            optional(
              token("GLOBAL")
            ),
            token("BEFORE"),
            token("REPORTING"),
            identifier()
          )
        );
      }
    
      return beforeReportingDeclarativeParser;
    }
    
    // ========================================================
    // waitStatement
    // ........................................................
    
    private ParserCombinator waitStatementParser = null;
    
    public final Start waitStatement = Start.on(getNamespace(), "waitStatement");
    
    public ParserCombinator waitStatement() {
      if (waitStatementParser == null) {
        FutureParser future = scoped("waitStatement", PUBLIC, true);
        waitStatementParser = future;
        future.setParser(
          choice(
            sequence(
              token("WAIT"),
              optional(
                token("FOR")
              ),
              threadPointer(),
              optional(
                sequence(
                  token("RETURNING"),
                  optional(
                    token("INTO")
                  ),
                  identifier()
                )
              ),
              optional(
                sequence(
                  token("STATUS"),
                  optional(
                    token("IS")
                  ),
                  identifier()
                )
              ),
              optional(
                onException()
              ),
              optional(
                notOnException()
              ),
              optional(
                token("END-WAIT")
              )
            ),
            sequence(
              token("WAIT"),
              optional(
                token("FOR")
              ),
              eventPointer()
            )
          )
        );
      }
    
      return waitStatementParser;
    }
    
    // ========================================================
    // writeStatement
    // ........................................................
    
    private ParserCombinator writeStatementParser = null;
    
    public final Start writeStatement = Start.on(getNamespace(), "writeStatement");
    
    public ParserCombinator writeStatement() {
      if (writeStatementParser == null) {
        FutureParser future = scoped("writeStatement", PUBLIC, true);
        writeStatementParser = future;
        future.setParser(
          sequence(
            token("WRITE"),
            choice(
              sequence(
                token("FILE"),
                fileName()
              ),
              recordName()
            ),
            optional(
              sequence(
                token("FROM"),
                choice(
                  identifier(),
                  literal()
                )
              )
            ),
            optional(
              sequence(
                choice(
                  token("AFTER"),
                  token("BEFORE")
                ),
                optional(
                  choice(
                    token("ADVANCING"),
                    token("POSITIONING")
                  )
                ),
                choice(
                  token("TAB"),
                  token("FORMFEED"),
                  token("PAGE"),
                  sequence(
                    choice(
                      identifier(),
                      integer(),
                      zero()
                    ),
                    optional(
                      choice(
                        token("LINE"),
                        token("LINES")
                      )
                    )
                  ),
                  mnemonicName()
                )
              )
            ),
            optional(
              atEndOfPage()
            ),
            optional(
              notAtEndOfPage()
            ),
            optional(
              retryPhrase()
            ),
            optional(
              sequence(
                optional(
                  token("WITH")
                ),
                optional(
                  token("NO")
                ),
                token("LOCK")
              )
            ),
            optional(
              invalidKey()
            ),
            optional(
              notInvalidKey()
            ),
            optional(
              token("END-WRITE")
            )
          )
        );
      }
    
      return writeStatementParser;
    }
    
    // ========================================================
    // atEndOfPage
    // ........................................................
    
    private ParserCombinator atEndOfPageParser = null;
    
    public final Start atEndOfPage = Start.on(getNamespace(), "atEndOfPage");
    
    public ParserCombinator atEndOfPage() {
      if (atEndOfPageParser == null) {
        FutureParser future = scoped("atEndOfPage", PUBLIC, true);
        atEndOfPageParser = future;
        future.setParser(
          sequence(
            optional(
              token("AT")
            ),
            choice(
              token("END-OF-PAGE"),
              token("EOP")
            ),
            nestedStatements()
          )
        );
      }
    
      return atEndOfPageParser;
    }
    
    // ========================================================
    // notAtEndOfPage
    // ........................................................
    
    private ParserCombinator notAtEndOfPageParser = null;
    
    public final Start notAtEndOfPage = Start.on(getNamespace(), "notAtEndOfPage");
    
    public ParserCombinator notAtEndOfPage() {
      if (notAtEndOfPageParser == null) {
        FutureParser future = scoped("notAtEndOfPage", PUBLIC, true);
        notAtEndOfPageParser = future;
        future.setParser(
          sequence(
            token("NOT"),
            optional(
              token("AT")
            ),
            choice(
              token("END-OF-PAGE"),
              token("EOP")
            ),
            nestedStatements()
          )
        );
      }
    
      return notAtEndOfPageParser;
    }
    
    // ========================================================
    // xmlGenerateStatement
    // ........................................................
    
    private ParserCombinator xmlGenerateStatementParser = null;
    
    public final Start xmlGenerateStatement = Start.on(getNamespace(), "xmlGenerateStatement");
    
    public ParserCombinator xmlGenerateStatement() {
      if (xmlGenerateStatementParser == null) {
        FutureParser future = scoped("xmlGenerateStatement", PUBLIC, true);
        xmlGenerateStatementParser = future;
        future.setParser(
          sequence(
            token("XML"),
            token("GENERATE"),
            identifier(),
            token("FROM"),
            identifier(),
            optional(
              sequence(
                token("COUNT"),
                optional(
                  token("IN")
                ),
                identifier()
              )
            ),
            optional(
              sequence(
                optional(
                  token("WITH")
                ),
                token("ENCODING"),
                cobolWord()
              )
            ),
            optional(
              sequence(
                optional(
                  token("WITH")
                ),
                token("XML-DECLARATION")
              )
            ),
            optional(
              sequence(
                optional(
                  token("WITH")
                ),
                token("ATTRIBUTES")
              )
            ),
            optional(
              sequence(
                token("NAMESPACE"),
                optional(
                  token("IS")
                ),
                choice(
                  identifier(),
                  literal()
                ),
                optional(
                  sequence(
                    token("NAMESPACE-PREFIX"),
                    optional(
                      token("IS")
                    ),
                    choice(
                      identifier(),
                      literal()
                    )
                  )
                )
              )
            ),
            optional(
              onException()
            ),
            optional(
              notOnException()
            ),
            optional(
              token("END-XML")
            )
          )
        );
      }
    
      return xmlGenerateStatementParser;
    }
    
    // ========================================================
    // xmlParseStatement
    // ........................................................
    
    private ParserCombinator xmlParseStatementParser = null;
    
    public final Start xmlParseStatement = Start.on(getNamespace(), "xmlParseStatement");
    
    public ParserCombinator xmlParseStatement() {
      if (xmlParseStatementParser == null) {
        FutureParser future = scoped("xmlParseStatement", PUBLIC, true);
        xmlParseStatementParser = future;
        future.setParser(
          sequence(
            token("XML"),
            token("PARSE"),
            identifier(),
            optional(
              sequence(
                token("PROCESSING"),
                token("PROCEDURE"),
                optional(
                  token("IS")
                ),
                procedureName()
              )
            ),
            optional(
              sequence(
                choice(
                  token("THROUGH"),
                  token("THRU")
                ),
                procedureName()
              )
            ),
            optional(
              onException()
            ),
            optional(
              notOnException()
            ),
            optional(
              token("END-XML")
            )
          )
        );
      }
    
      return xmlParseStatementParser;
    }
    
    // ========================================================
    // attributeClause
    // ........................................................
    
    private ParserCombinator attributeClauseParser = null;
    
    public final Start attributeClause = Start.on(getNamespace(), "attributeClause");
    
    public ParserCombinator attributeClause() {
      if (attributeClauseParser == null) {
        FutureParser future = scoped("attributeClause", PUBLIC, true);
        attributeClauseParser = future;
        future.setParser(
          plus(
            choice(
              sequence(
                token("ATTRIBUTE"),
                attributeName(),
                literal("("),
                skipto(
                  literal(")")
                ),
                literal(")")
              ),
              sequence(
                token("CUSTOM-ATTRIBUTE"),
                token("IS"),
                className(),
                optional(
                  sequence(
                    literal("("),
                    skipto(
                      literal(")")
                    ),
                    literal(")")
                  )
                )
              )
            )
          )
        );
      }
    
      return attributeClauseParser;
    }
    
    // ========================================================
    // onOverflow
    // ........................................................
    
    private ParserCombinator onOverflowParser = null;
    
    public final Start onOverflow = Start.on(getNamespace(), "onOverflow");
    
    public ParserCombinator onOverflow() {
      if (onOverflowParser == null) {
        FutureParser future = scoped("onOverflow", PUBLIC, true);
        onOverflowParser = future;
        future.setParser(
          sequence(
            optional(
              token("ON")
            ),
            token("OVERFLOW"),
            nestedStatements()
          )
        );
      }
    
      return onOverflowParser;
    }
    
    // ========================================================
    // notOnOverflow
    // ........................................................
    
    private ParserCombinator notOnOverflowParser = null;
    
    public final Start notOnOverflow = Start.on(getNamespace(), "notOnOverflow");
    
    public ParserCombinator notOnOverflow() {
      if (notOnOverflowParser == null) {
        FutureParser future = scoped("notOnOverflow", PUBLIC, true);
        notOnOverflowParser = future;
        future.setParser(
          sequence(
            token("NOT"),
            optional(
              token("ON")
            ),
            token("OVERFLOW"),
            nestedStatements()
          )
        );
      }
    
      return notOnOverflowParser;
    }
    
    // ========================================================
    // onException
    // ........................................................
    
    private ParserCombinator onExceptionParser = null;
    
    public final Start onException = Start.on(getNamespace(), "onException");
    
    public ParserCombinator onException() {
      if (onExceptionParser == null) {
        FutureParser future = scoped("onException", PUBLIC, true);
        onExceptionParser = future;
        future.setParser(
          sequence(
            optional(
              token("ON")
            ),
            token("EXCEPTION"),
            nestedStatements()
          )
        );
      }
    
      return onExceptionParser;
    }
    
    // ========================================================
    // notOnException
    // ........................................................
    
    private ParserCombinator notOnExceptionParser = null;
    
    public final Start notOnException = Start.on(getNamespace(), "notOnException");
    
    public ParserCombinator notOnException() {
      if (notOnExceptionParser == null) {
        FutureParser future = scoped("notOnException", PUBLIC, true);
        notOnExceptionParser = future;
        future.setParser(
          sequence(
            token("NOT"),
            optional(
              token("ON")
            ),
            token("EXCEPTION"),
            nestedStatements()
          )
        );
      }
    
      return notOnExceptionParser;
    }
    
    // ========================================================
    // onSizeError
    // ........................................................
    
    private ParserCombinator onSizeErrorParser = null;
    
    public final Start onSizeError = Start.on(getNamespace(), "onSizeError");
    
    public ParserCombinator onSizeError() {
      if (onSizeErrorParser == null) {
        FutureParser future = scoped("onSizeError", PUBLIC, true);
        onSizeErrorParser = future;
        future.setParser(
          sequence(
            optional(
              token("ON")
            ),
            token("SIZE"),
            token("ERROR"),
            nestedStatements()
          )
        );
      }
    
      return onSizeErrorParser;
    }
    
    // ========================================================
    // notOnSizeError
    // ........................................................
    
    private ParserCombinator notOnSizeErrorParser = null;
    
    public final Start notOnSizeError = Start.on(getNamespace(), "notOnSizeError");
    
    public ParserCombinator notOnSizeError() {
      if (notOnSizeErrorParser == null) {
        FutureParser future = scoped("notOnSizeError", PUBLIC, true);
        notOnSizeErrorParser = future;
        future.setParser(
          sequence(
            token("NOT"),
            optional(
              token("ON")
            ),
            token("SIZE"),
            token("ERROR"),
            nestedStatements()
          )
        );
      }
    
      return notOnSizeErrorParser;
    }
    
    // ========================================================
    // onEscape
    // ........................................................
    
    private ParserCombinator onEscapeParser = null;
    
    public final Start onEscape = Start.on(getNamespace(), "onEscape");
    
    public ParserCombinator onEscape() {
      if (onEscapeParser == null) {
        FutureParser future = scoped("onEscape", PUBLIC, true);
        onEscapeParser = future;
        future.setParser(
          sequence(
            optional(
              token("ON")
            ),
            token("ESCAPE"),
            nestedStatements()
          )
        );
      }
    
      return onEscapeParser;
    }
    
    // ========================================================
    // notOnEscape
    // ........................................................
    
    private ParserCombinator notOnEscapeParser = null;
    
    public final Start notOnEscape = Start.on(getNamespace(), "notOnEscape");
    
    public ParserCombinator notOnEscape() {
      if (notOnEscapeParser == null) {
        FutureParser future = scoped("notOnEscape", PUBLIC, true);
        notOnEscapeParser = future;
        future.setParser(
          sequence(
            token("NOT"),
            optional(
              token("ON")
            ),
            token("ESCAPE"),
            nestedStatements()
          )
        );
      }
    
      return notOnEscapeParser;
    }
    
    // ========================================================
    // compilerStatement
    // ........................................................
    
    private ParserCombinator compilerStatementParser = null;
    
    public final Start compilerStatement = Start.on(getNamespace(), "compilerStatement");
    
    public ParserCombinator compilerStatement() {
      if (compilerStatementParser == null) {
        FutureParser future = scoped("compilerStatement", PUBLIC, true);
        compilerStatementParser = future;
        future.setParser(
          choice(
            compilerDirective(),
            compilerIfStatement(),
            compilerDisplayStatement(),
            copyStatement(),
            replaceStatement(),
            sequence(
              useStatement(),
              literal(".")
            )
          )
        );
      }
    
      return compilerStatementParser;
    }
    
    // ========================================================
    // compilerDirective
    // ........................................................
    
    private ParserCombinator compilerDirectiveParser = null;
    
    public final Start compilerDirective = Start.on(getNamespace(), "compilerDirective");
    
    public ParserCombinator compilerDirective() {
      if (compilerDirectiveParser == null) {
        FutureParser future = scoped("compilerDirective", PUBLIC, true);
        compilerDirectiveParser = future;
        future.setParser(
          sequence(
            sequence(
              literal("\u0024"),
              token("SET")
            ),
            skipto(
              choice(
                sequence(
                  literal("\u0024"),
                  token("SET")
                ),
                divisionStart(),
                sourceUnit(),
                verb()
              )
            )
          )
        );
      }
    
      return compilerDirectiveParser;
    }
    
    // ========================================================
    // compilerIfStatement
    // ........................................................
    
    private ParserCombinator compilerIfStatementParser = null;
    
    public final Start compilerIfStatement = Start.on(getNamespace(), "compilerIfStatement");
    
    public ParserCombinator compilerIfStatement() {
      if (compilerIfStatementParser == null) {
        FutureParser future = scoped("compilerIfStatement", PUBLIC, true);
        compilerIfStatementParser = future;
        future.setParser(
          sequence(
            literal("\u0024"),
            token("IF"),
            operand(),
            optional(
              choice(
                token("SET"),
                sequence(
                  optional(
                    token("NOT")
                  ),
                  token("DEFINED")
                ),
                sequence(
                  optional(
                    token("NOT")
                  ),
                  choice(
                    literal("<"),
                    literal(">"),
                    literal("=")
                  ),
                  operand()
                )
              )
            ),
            choice(
              compilerStatement(),
              nestedStatements()
            ),
            optional(
              sequence(
                literal("\u0024"),
                token("ELSE"),
                choice(
                  compilerStatement(),
                  nestedStatements()
                )
              )
            ),
            literal("\u0024"),
            token("END")
          )
        );
      }
    
      return compilerIfStatementParser;
    }
    
    // ========================================================
    // compilerDisplayStatement
    // ........................................................
    
    private ParserCombinator compilerDisplayStatementParser = null;
    
    public final Start compilerDisplayStatement = Start.on(getNamespace(), "compilerDisplayStatement");
    
    public ParserCombinator compilerDisplayStatement() {
      if (compilerDisplayStatementParser == null) {
        FutureParser future = scoped("compilerDisplayStatement", PUBLIC, true);
        compilerDisplayStatementParser = future;
        future.setParser(
          sequence(
            literal("\u0024"),
            token("DISPLAY"),
            choice(
              sequence(
                token("VCS"),
                literal("="),
                literal()
              ),
              textName()
            )
          )
        );
      }
    
      return compilerDisplayStatementParser;
    }
    
    // ========================================================
    // copyOperandName
    // ........................................................
    
    private ParserCombinator copyOperandNameParser = null;
    
    public final Start copyOperandName = Start.on(getNamespace(), "copyOperandName");
    
    public ParserCombinator copyOperandName() {
      if (copyOperandNameParser == null) {
        FutureParser future = scoped("copyOperandName", PUBLIC, true);
        copyOperandNameParser = future;
        future.setParser(
          choice(
            sequence(
              optional(
                choice(
                  token("LEADING"),
                  token("TRAILING")
                )
              ),
              pseudoLiteral()
            ),
            verb(),
            literal(),
            identifier(),
            cobolWord()
          )
        );
      }
    
      return copyOperandNameParser;
    }
    
    // ========================================================
    // divisionStart
    // ........................................................
    
    private ParserCombinator divisionStartParser = null;
    
    public final Start divisionStart = Start.on(getNamespace(), "divisionStart");
    
    public ParserCombinator divisionStart() {
      if (divisionStartParser == null) {
        FutureParser future = scoped("divisionStart", PUBLIC, true);
        divisionStartParser = future;
        future.setParser(
          sequence(
            choice(
              sequence(
                choice(
                  token("ID"),
                  token("IDENTIFICATION")
                ),
                token("DIVISION")
              ),
              sequence(
                token("ENVIRONMENT"),
                token("DIVISION")
              ),
              sequence(
                token("DATA"),
                token("DIVISION")
              ),
              sequence(
                token("PROCEDURE"),
                token("DIVISION"),
                skipto(
                  literal(".")
                )
              )
            ),
            literal(".")
          )
        );
      }
    
      return divisionStartParser;
    }
    
    // ========================================================
    // sectionStart
    // ........................................................
    
    private ParserCombinator sectionStartParser = null;
    
    public final Start sectionStart = Start.on(getNamespace(), "sectionStart");
    
    public ParserCombinator sectionStart() {
      if (sectionStartParser == null) {
        FutureParser future = scoped("sectionStart", PUBLIC, true);
        sectionStartParser = future;
        future.setParser(
          sequence(
            choice(
              token("CONFIGURATION"),
              token("INPUT-OUTPUT"),
              token("FILE"),
              token("WORKING-STORAGE"),
              token("THREAD-LOCAL-STORAGE"),
              token("OBJECT-STORAGE"),
              token("LOCAL-STORAGE"),
              token("LINKAGE"),
              token("COMMUNICATION"),
              token("OBJECT"),
              token("REPORT"),
              token("SCREEN")
            ),
            token("SECTION"),
            literal(".")
          )
        );
      }
    
      return sectionStartParser;
    }
    
    // ========================================================
    // paragraphStart
    // ........................................................
    
    private ParserCombinator paragraphStartParser = null;
    
    public final Start paragraphStart = Start.on(getNamespace(), "paragraphStart");
    
    public ParserCombinator paragraphStart() {
      if (paragraphStartParser == null) {
        FutureParser future = scoped("paragraphStart", PUBLIC, true);
        paragraphStartParser = future;
        future.setParser(
          sequence(
            choice(
              token("SOURCE-COMPUTER"),
              token("OBJECT-COMPUTER"),
              token("SPECIAL-NAMES"),
              token("REPOSITORY"),
              token("CONSTRAINTS"),
              token("CLASS-ATTRIBUTES"),
              token("ASSEMBLY-ATTRIBUTES"),
              token("FILE-CONTROL"),
              token("I-O-CONTROL"),
              token("CLASS-CONTROL")
            ),
            literal(".")
          )
        );
      }
    
      return paragraphStartParser;
    }
    
    // ========================================================
    // function
    // ........................................................
    
    private ParserCombinator functionParser = null;
    
    public final Start function = Start.on(getNamespace(), "function");
    
    public ParserCombinator function() {
      if (functionParser == null) {
        FutureParser future = scoped("function", PUBLIC, true);
        functionParser = future;
        future.setParser(
          sequence(
            token("FUNCTION"),
            choice(
              as("functionName",
                choice(
                  literal("CURRENT-DATE"),
                  literal("E"),
                  literal("EXCEPTION-FILE"),
                  literal("EXCEPTION-LOCATION"),
                  literal("EXCEPTION-STATEMENT"),
                  literal("EXCEPTION-STATUS"),
                  literal("PI"),
                  literal("SECONDS-PAST-MIDNIGHT"),
                  literal("WHEN-COMPILED")
                )
              ),
              sequence(
                as("functionName",
                  choice(
                    literal("ABS"),
                    literal("ACOS"),
                    literal("ASIN"),
                    literal("ATAN"),
                    literal("BYTE-LENGTH"),
                    literal("CHAR"),
                    literal("CHAR-NATIONAL"),
                    literal("COS"),
                    literal("DATE-OF-INTEGER"),
                    literal("DAY-OF-INTEGER"),
                    literal("EXP"),
                    literal("EXP10"),
                    literal("FACTORIAL"),
                    literal("FRACTION-PART"),
                    literal("INTEGER"),
                    literal("INTEGER-OF-BOOLEAN"),
                    literal("INTEGER-OF-DATE"),
                    literal("INTEGER-OF-DAY"),
                    literal("INTEGER-PART"),
                    literal("LENGTH"),
                    literal("LENGTH-AN"),
                    literal("LOG"),
                    literal("LOG10"),
                    literal("LOWER-CASE"),
                    literal("NUMVAL"),
                    literal("ORD"),
                    literal("REVERSE"),
                    literal("SIGN"),
                    literal("SIN"),
                    literal("SQRT"),
                    literal("STORED-CHAR-LENGTH"),
                    literal("TAN"),
                    literal("TEST-DATE-YYYYMMDD"),
                    literal("TEST-DAY-YYYYDDD"),
                    literal("UPPER-CASE")
                  )
                ),
                literal("("),
                argument(),
                literal(")")
              ),
              sequence(
                as("functionName",
                  literal("RANDOM")
                ),
                optional(
                  sequence(
                    literal("("),
                    optional(
                      argument()
                    ),
                    literal(")")
                  )
                )
              ),
              sequence(
                as("functionName",
                  literal("TRIM")
                ),
                literal("("),
                argument(),
                optional(
                  choice(
                    token("LEADING"),
                    token("TRAILING")
                  )
                ),
                literal(")")
              ),
              sequence(
                as("functionName",
                  choice(
                    literal("ANNUITY"),
                    literal("BOOLEAN-OF-INTEGER"),
                    literal("COMBINED-DATETIME"),
                    literal("MOD"),
                    literal("REM"),
                    literal("SECONDS-FROM-FORMATTED-TIME")
                  )
                ),
                literal("("),
                argument(),
                optional(
                  literal(",")
                ),
                argument(),
                literal(")")
              ),
              sequence(
                as("functionName",
                  choice(
                    literal("DATE-TO-YYYYMMDD"),
                    literal("DAY-TO-YYYYDDD"),
                    literal("DISPLAY-OF"),
                    literal("LOCALE-DATE"),
                    literal("LOCALE-TIME"),
                    literal("LOCALE-TIME-FROM-SECS"),
                    literal("NATIONAL-OF"),
                    literal("NUMVAL-C"),
                    literal("YEAR-TO-YYYY")
                  )
                ),
                literal("("),
                argument(),
                optional(
                  sequence(
                    optional(
                      literal(",")
                    ),
                    argument()
                  )
                ),
                literal(")")
              ),
              sequence(
                as("functionName",
                  choice(
                    literal("CONCATENATE"),
                    literal("MAX"),
                    literal("MEAN"),
                    literal("MEDIAN"),
                    literal("MIDRANGE"),
                    literal("MIN"),
                    literal("ORD-MAX"),
                    literal("ORD-MIN"),
                    literal("PRESENT-VALUE"),
                    literal("RANGE"),
                    literal("STANDARD-DEVIATION"),
                    literal("SUBSTITUTE"),
                    literal("SUBSTITUTE-CASE"),
                    literal("SUM"),
                    literal("VARIANCE")
                  )
                ),
                literal("("),
                argument(),
                star(
                  sequence(
                    optional(
                      literal(",")
                    ),
                    argument()
                  )
                ),
                literal(")")
              ),
              sequence(
                functionName(),
                optional(
                  sequence(
                    literal("("),
                    argument(),
                    star(
                      sequence(
                        optional(
                          literal(",")
                        ),
                        argument()
                      )
                    ),
                    literal(")")
                  )
                )
              )
            )
          )
        );
      }
    
      return functionParser;
    }
    
    // ========================================================
    // identifier
    // ........................................................
    
    private ParserCombinator identifierParser = null;
    
    public final Start identifier = Start.on(getNamespace(), "identifier");
    
    public ParserCombinator identifier() {
      if (identifierParser == null) {
        FutureParser future = scoped("identifier", PUBLIC, true);
        identifierParser = future;
        future.setParser(
          choice(
            qualifiedLinageCounter(),
            qualifiedReportCounter(),
            identifier_format6(),
            identifier_format1(),
            identifier_format2(),
            dataAddressIdentifier()
          )
        );
      }
    
      return identifierParser;
    }
    
    // ========================================================
    // identifier_format1
    // ........................................................
    
    private ParserCombinator identifier_format1Parser = null;
    
    public final Start identifier_format1 = Start.on(getNamespace(), "identifier_format1");
    
    public ParserCombinator identifier_format1() {
      if (identifier_format1Parser == null) {
        FutureParser future = scoped("identifier_format1", PUBLIC, true);
        identifier_format1Parser = future;
        future.setParser(
          sequence(
            function(),
            optional(
              referenceModifier()
            )
          )
        );
      }
    
      return identifier_format1Parser;
    }
    
    // ========================================================
    // identifier_format2
    // ........................................................
    
    private ParserCombinator identifier_format2Parser = null;
    
    public final Start identifier_format2 = Start.on(getNamespace(), "identifier_format2");
    
    public ParserCombinator identifier_format2() {
      if (identifier_format2Parser == null) {
        FutureParser future = scoped("identifier_format2", PUBLIC, true);
        identifier_format2Parser = future;
        future.setParser(
          sequence(
            qualifiedDataName(),
            optional(
              referenceModifier()
            )
          )
        );
      }
    
      return identifier_format2Parser;
    }
    
    // ========================================================
    // identifier_format6
    // ........................................................
    
    private ParserCombinator identifier_format6Parser = null;
    
    public final Start identifier_format6 = Start.on(getNamespace(), "identifier_format6");
    
    public ParserCombinator identifier_format6() {
      if (identifier_format6Parser == null) {
        FutureParser future = scoped("identifier_format6", PUBLIC, true);
        identifier_format6Parser = future;
        future.setParser(
          choice(
            token("EXCEPTION-OBJECT"),
            token("NULL"),
            token("SELF"),
            sequence(
              optional(
                sequence(
                  className(),
                  token("OF")
                )
              ),
              token("SUPER")
            )
          )
        );
      }
    
      return identifier_format6Parser;
    }
    
    // ========================================================
    // dataAddressIdentifier
    // ........................................................
    
    private ParserCombinator dataAddressIdentifierParser = null;
    
    public final Start dataAddressIdentifier = Start.on(getNamespace(), "dataAddressIdentifier");
    
    public ParserCombinator dataAddressIdentifier() {
      if (dataAddressIdentifierParser == null) {
        FutureParser future = scoped("dataAddressIdentifier", PUBLIC, true);
        dataAddressIdentifierParser = future;
        future.setParser(
          sequence(
            token("ADDRESS"),
            optional(
              token("OF")
            ),
            identifier()
          )
        );
      }
    
      return dataAddressIdentifierParser;
    }
    
    // ========================================================
    // qualifiedLinageCounter
    // ........................................................
    
    private ParserCombinator qualifiedLinageCounterParser = null;
    
    public final Start qualifiedLinageCounter = Start.on(getNamespace(), "qualifiedLinageCounter");
    
    public ParserCombinator qualifiedLinageCounter() {
      if (qualifiedLinageCounterParser == null) {
        FutureParser future = scoped("qualifiedLinageCounter", PUBLIC, true);
        qualifiedLinageCounterParser = future;
        future.setParser(
          sequence(
            token("LINAGE-COUNTER"),
            optional(
              sequence(
                choice(
                  token("IN"),
                  token("OF")
                ),
                as("fileName",
                  name()
                )
              )
            )
          )
        );
      }
    
      return qualifiedLinageCounterParser;
    }
    
    // ========================================================
    // qualifiedReportCounter
    // ........................................................
    
    private ParserCombinator qualifiedReportCounterParser = null;
    
    public final Start qualifiedReportCounter = Start.on(getNamespace(), "qualifiedReportCounter");
    
    public ParserCombinator qualifiedReportCounter() {
      if (qualifiedReportCounterParser == null) {
        FutureParser future = scoped("qualifiedReportCounter", PUBLIC, true);
        qualifiedReportCounterParser = future;
        future.setParser(
          sequence(
            choice(
              as("pageCounter",
                token("PAGE-COUNTER")
              ),
              as("lineCounter",
                token("LINE-COUNTER")
              )
            ),
            optional(
              sequence(
                choice(
                  token("IN"),
                  token("OF")
                ),
                as("reportName",
                  name()
                )
              )
            )
          )
        );
      }
    
      return qualifiedReportCounterParser;
    }
    
    // ========================================================
    // argument
    // ........................................................
    
    private ParserCombinator argumentParser = null;
    
    public final Start argument = Start.on(getNamespace(), "argument");
    
    public ParserCombinator argument() {
      if (argumentParser == null) {
        FutureParser future = scoped("argument", PUBLIC, true);
        argumentParser = future;
        future.setParser(
          choice(
            sequence(
              literal(),
              not(
                moreArithmeticOp()
              )
            ),
            sequence(
              identifier(),
              not(
                moreArithmeticOp()
              )
            ),
            arithmeticExpression()
          )
        );
      }
    
      return argumentParser;
    }
    
    // ========================================================
    // qualifier
    // ........................................................
    
    private ParserCombinator qualifierParser = null;
    
    public final Start qualifier = Start.on(getNamespace(), "qualifier");
    
    public ParserCombinator qualifier() {
      if (qualifierParser == null) {
        FutureParser future = scoped("qualifier", PUBLIC, true);
        qualifierParser = future;
        future.setParser(
          plus(
            sequence(
              choice(
                token("IN"),
                token("OF")
              ),
              dataName()
            )
          )
        );
      }
    
      return qualifierParser;
    }
    
    // ========================================================
    // subscript
    // ........................................................
    
    private ParserCombinator subscriptParser = null;
    
    public final Start subscript = Start.on(getNamespace(), "subscript");
    
    public ParserCombinator subscript() {
      if (subscriptParser == null) {
        FutureParser future = scoped("subscript", PUBLIC, true);
        subscriptParser = future;
        future.setParser(
          choice(
            relativeSubscript(),
            directSubscript()
          )
        );
      }
    
      return subscriptParser;
    }
    
    // ========================================================
    // directSubscript
    // ........................................................
    
    private ParserCombinator directSubscriptParser = null;
    
    public final Start directSubscript = Start.on(getNamespace(), "directSubscript");
    
    public ParserCombinator directSubscript() {
      if (directSubscriptParser == null) {
        FutureParser future = scoped("directSubscript", PUBLIC, true);
        directSubscriptParser = future;
        future.setParser(
          choice(
            token("ALL"),
            identifier(),
            integer()
          )
        );
      }
    
      return directSubscriptParser;
    }
    
    // ========================================================
    // relativeSubscript
    // ........................................................
    
    private ParserCombinator relativeSubscriptParser = null;
    
    public final Start relativeSubscript = Start.on(getNamespace(), "relativeSubscript");
    
    public ParserCombinator relativeSubscript() {
      if (relativeSubscriptParser == null) {
        FutureParser future = scoped("relativeSubscript", PUBLIC, true);
        relativeSubscriptParser = future;
        future.setParser(
          sequence(
            identifier(),
            choice(
              literal("+"),
              literal("-")
            ),
            integer()
          )
        );
      }
    
      return relativeSubscriptParser;
    }
    
    // ========================================================
    // referenceModifier
    // ........................................................
    
    private ParserCombinator referenceModifierParser = null;
    
    public final Start referenceModifier = Start.on(getNamespace(), "referenceModifier");
    
    public ParserCombinator referenceModifier() {
      if (referenceModifierParser == null) {
        FutureParser future = scoped("referenceModifier", PUBLIC, true);
        referenceModifierParser = future;
        future.setParser(
          sequence(
            literal("("),
            arithmeticExpression(),
            literal(":"),
            optional(
              arithmeticExpression()
            ),
            literal(")")
          )
        );
      }
    
      return referenceModifierParser;
    }
    
    // ========================================================
    // arithmeticExpression
    // ........................................................
    
    private ParserCombinator arithmeticExpressionParser = null;
    
    public final Start arithmeticExpression = Start.on(getNamespace(), "arithmeticExpression");
    
    public ParserCombinator arithmeticExpression() {
      if (arithmeticExpressionParser == null) {
        FutureParser future = scoped("arithmeticExpression", PUBLIC, true);
        arithmeticExpressionParser = future;
        future.setParser(
          bitwiseInclusiveDisjunction()
        );
      }
    
      return arithmeticExpressionParser;
    }
    
    // ========================================================
    // bitwiseInclusiveDisjunction
    // ........................................................
    
    private ParserCombinator bitwiseInclusiveDisjunctionParser = null;
    
    public final Start bitwiseInclusiveDisjunction = Start.on(getNamespace(), "bitwiseInclusiveDisjunction");
    
    public ParserCombinator bitwiseInclusiveDisjunction() {
      if (bitwiseInclusiveDisjunctionParser == null) {
        FutureParser future = scoped("bitwiseInclusiveDisjunction", HIDING, true);
        bitwiseInclusiveDisjunctionParser = future;
        future.setParser(
          sequence(
            bitwiseExclusiveDisjunction(),
            star(
              sequence(
                token("B-OR"),
                bitwiseExclusiveDisjunction()
              )
            )
          )
        );
      }
    
      return bitwiseInclusiveDisjunctionParser;
    }
    
    // ========================================================
    // bitwiseExclusiveDisjunction
    // ........................................................
    
    private ParserCombinator bitwiseExclusiveDisjunctionParser = null;
    
    public final Start bitwiseExclusiveDisjunction = Start.on(getNamespace(), "bitwiseExclusiveDisjunction");
    
    public ParserCombinator bitwiseExclusiveDisjunction() {
      if (bitwiseExclusiveDisjunctionParser == null) {
        FutureParser future = scoped("bitwiseExclusiveDisjunction", HIDING, true);
        bitwiseExclusiveDisjunctionParser = future;
        future.setParser(
          sequence(
            bitwiseConjunction(),
            star(
              sequence(
                choice(
                  token("B-XOR"),
                  token("B-EXOR")
                ),
                bitwiseConjunction()
              )
            )
          )
        );
      }
    
      return bitwiseExclusiveDisjunctionParser;
    }
    
    // ========================================================
    // bitwiseConjunction
    // ........................................................
    
    private ParserCombinator bitwiseConjunctionParser = null;
    
    public final Start bitwiseConjunction = Start.on(getNamespace(), "bitwiseConjunction");
    
    public ParserCombinator bitwiseConjunction() {
      if (bitwiseConjunctionParser == null) {
        FutureParser future = scoped("bitwiseConjunction", HIDING, true);
        bitwiseConjunctionParser = future;
        future.setParser(
          sequence(
            expression(),
            star(
              sequence(
                token("B-AND"),
                expression()
              )
            )
          )
        );
      }
    
      return bitwiseConjunctionParser;
    }
    
    // ========================================================
    // expression
    // ........................................................
    
    private ParserCombinator expressionParser = null;
    
    public final Start expression = Start.on(getNamespace(), "expression");
    
    public ParserCombinator expression() {
      if (expressionParser == null) {
        FutureParser future = scoped("expression", HIDING, true);
        expressionParser = future;
        future.setParser(
          sequence(
            term(),
            star(
              choice(
                as("add",
                  sequence(
                    literal("+"),
                    term()
                  )
                ),
                as("subtract",
                  sequence(
                    literal("-"),
                    term()
                  )
                )
              )
            )
          )
        );
      }
    
      return expressionParser;
    }
    
    // ========================================================
    // term
    // ........................................................
    
    private ParserCombinator termParser = null;
    
    public final Start term = Start.on(getNamespace(), "term");
    
    public ParserCombinator term() {
      if (termParser == null) {
        FutureParser future = scoped("term", HIDING, true);
        termParser = future;
        future.setParser(
          sequence(
            factor(),
            star(
              choice(
                as("multiply",
                  sequence(
                    literal("*"),
                    factor()
                  )
                ),
                as("divide",
                  sequence(
                    literal("/"),
                    factor()
                  )
                )
              )
            )
          )
        );
      }
    
      return termParser;
    }
    
    // ========================================================
    // factor
    // ........................................................
    
    private ParserCombinator factorParser = null;
    
    public final Start factor = Start.on(getNamespace(), "factor");
    
    public ParserCombinator factor() {
      if (factorParser == null) {
        FutureParser future = scoped("factor", HIDING, true);
        factorParser = future;
        future.setParser(
          sequence(
            base(),
            star(
              as("power",
                sequence(
                  literal("**"),
                  base()
                )
              )
            )
          )
        );
      }
    
      return factorParser;
    }
    
    // ========================================================
    // base
    // ........................................................
    
    private ParserCombinator baseParser = null;
    
    public final Start base = Start.on(getNamespace(), "base");
    
    public ParserCombinator base() {
      if (baseParser == null) {
        FutureParser future = scoped("base", HIDING, true);
        baseParser = future;
        future.setParser(
          sequence(
            optional(
              choice(
                as("pos",
                  literal("+")
                ),
                as("neg",
                  literal("-")
                ),
                as("bNOT",
                  token("B-NOT")
                )
              )
            ),
            atom()
          )
        );
      }
    
      return baseParser;
    }
    
    // ========================================================
    // atom
    // ........................................................
    
    private ParserCombinator atomParser = null;
    
    protected final Start atom = Start.on(getNamespace(), "atom");
    
    protected ParserCombinator atom() {
      if (atomParser == null) {
        FutureParser future = scoped("atom", PRIVATE, true);
        atomParser = future;
        future.setParser(
          choice(
            as("zeroAtom",
              zero()
            ),
            as("identifierAtom",
              identifier()
            ),
            as("numericAtom",
              numeric()
            ),
            as("nested",
              sequence(
                literal("("),
                bitwiseInclusiveDisjunction(),
                literal(")")
              )
            )
          )
        );
      }
    
      return atomParser;
    }
    
    // ========================================================
    // moreArithmeticOp
    // ........................................................
    
    private ParserCombinator moreArithmeticOpParser = null;
    
    protected final Start moreArithmeticOp = Start.on(getNamespace(), "moreArithmeticOp");
    
    protected ParserCombinator moreArithmeticOp() {
      if (moreArithmeticOpParser == null) {
        FutureParser future = scoped("moreArithmeticOp", PRIVATE, true);
        moreArithmeticOpParser = future;
        future.setParser(
          choice(
            token("B-AND"),
            token("B-OR"),
            token("B-XOR"),
            token("B-EXOR"),
            literal("+"),
            literal("-"),
            literal("*"),
            literal("/"),
            literal("**")
          )
        );
      }
    
      return moreArithmeticOpParser;
    }
    
    // ========================================================
    // condition
    // ........................................................
    
    private ParserCombinator conditionParser = null;
    
    public final Start condition = Start.on(getNamespace(), "condition");
    
    public ParserCombinator condition() {
      if (conditionParser == null) {
        FutureParser future = scoped("condition", PUBLIC, true);
        conditionParser = future;
        future.setParser(
          disjunction()
        );
      }
    
      return conditionParser;
    }
    
    // ========================================================
    // disjunction
    // ........................................................
    
    private ParserCombinator disjunctionParser = null;
    
    public final Start disjunction = Start.on(getNamespace(), "disjunction");
    
    public ParserCombinator disjunction() {
      if (disjunctionParser == null) {
        FutureParser future = scoped("disjunction", HIDING, true);
        disjunctionParser = future;
        future.setParser(
          sequence(
            conjunction(),
            star(
              sequence(
                token("OR"),
                conjunction()
              )
            )
          )
        );
      }
    
      return disjunctionParser;
    }
    
    // ========================================================
    // conjunction
    // ........................................................
    
    private ParserCombinator conjunctionParser = null;
    
    public final Start conjunction = Start.on(getNamespace(), "conjunction");
    
    public ParserCombinator conjunction() {
      if (conjunctionParser == null) {
        FutureParser future = scoped("conjunction", HIDING, true);
        conjunctionParser = future;
        future.setParser(
          sequence(
            negation(),
            star(
              sequence(
                token("AND"),
                negation()
              )
            )
          )
        );
      }
    
      return conjunctionParser;
    }
    
    // ========================================================
    // negation
    // ........................................................
    
    private ParserCombinator negationParser = null;
    
    public final Start negation = Start.on(getNamespace(), "negation");
    
    public ParserCombinator negation() {
      if (negationParser == null) {
        FutureParser future = scoped("negation", HIDING, true);
        negationParser = future;
        future.setParser(
          sequence(
            optional(
              token("NOT")
            ),
            simpleCondition()
          )
        );
      }
    
      return negationParser;
    }
    
    // ========================================================
    // simpleCondition
    // ........................................................
    
    private ParserCombinator simpleConditionParser = null;
    
    protected final Start simpleCondition = Start.on(getNamespace(), "simpleCondition");
    
    protected ParserCombinator simpleCondition() {
      if (simpleConditionParser == null) {
        FutureParser future = scoped("simpleCondition", PRIVATE, true);
        simpleConditionParser = future;
        future.setParser(
          choice(
            as("true",
              token("TRUE")
            ),
            as("false",
              token("FALSE")
            ),
            parenthesizedCondition(),
            signCondition(),
            omittedArgumentCondition(),
            relationCondition(),
            classCondition(),
            conditionNameCondition()
          )
        );
      }
    
      return simpleConditionParser;
    }
    
    // ========================================================
    // parenthesizedCondition
    // ........................................................
    
    private ParserCombinator parenthesizedConditionParser = null;
    
    public final Start parenthesizedCondition = Start.on(getNamespace(), "parenthesizedCondition");
    
    public ParserCombinator parenthesizedCondition() {
      if (parenthesizedConditionParser == null) {
        FutureParser future = scoped("parenthesizedCondition", PUBLIC, true);
        parenthesizedConditionParser = future;
        future.setParser(
          sequence(
            literal("("),
            disjunction(),
            literal(")"),
            not(
              choice(
                relop(),
                moreArithmeticOp()
              )
            )
          )
        );
      }
    
      return parenthesizedConditionParser;
    }
    
    // ========================================================
    // classCondition
    // ........................................................
    
    private ParserCombinator classConditionParser = null;
    
    public final Start classCondition = Start.on(getNamespace(), "classCondition");
    
    public ParserCombinator classCondition() {
      if (classConditionParser == null) {
        FutureParser future = scoped("classCondition", PUBLIC, true);
        classConditionParser = future;
        future.setParser(
          sequence(
            identifier(),
            not(
              relop()
            ),
            optional(
              token("IS")
            ),
            optional(
              as("not",
                token("NOT")
              )
            ),
            classType()
          )
        );
      }
    
      return classConditionParser;
    }
    
    // ========================================================
    // classType
    // ........................................................
    
    private ParserCombinator classTypeParser = null;
    
    public final Start classType = Start.on(getNamespace(), "classType");
    
    public ParserCombinator classType() {
      if (classTypeParser == null) {
        FutureParser future = scoped("classType", PUBLIC, true);
        classTypeParser = future;
        future.setParser(
          choice(
            token("NUMERIC"),
            token("ALPHABETIC"),
            token("ALPHABETIC-LOWER"),
            token("ALPHABETIC-UPPER"),
            token("DBCS"),
            token("KANJI"),
            token("BOOLEAN"),
            token("INFINITY"),
            token("REPRESENTS-NOT-A-NUMBER"),
            name()
          )
        );
      }
    
      return classTypeParser;
    }
    
    // ========================================================
    // signCondition
    // ........................................................
    
    private ParserCombinator signConditionParser = null;
    
    public final Start signCondition = Start.on(getNamespace(), "signCondition");
    
    public ParserCombinator signCondition() {
      if (signConditionParser == null) {
        FutureParser future = scoped("signCondition", PUBLIC, true);
        signConditionParser = future;
        future.setParser(
          sequence(
            arithmeticExpression(),
            optional(
              token("IS")
            ),
            optional(
              as("not",
                token("NOT")
              )
            ),
            signType()
          )
        );
      }
    
      return signConditionParser;
    }
    
    // ========================================================
    // signType
    // ........................................................
    
    private ParserCombinator signTypeParser = null;
    
    public final Start signType = Start.on(getNamespace(), "signType");
    
    public ParserCombinator signType() {
      if (signTypeParser == null) {
        FutureParser future = scoped("signType", PUBLIC, true);
        signTypeParser = future;
        future.setParser(
          choice(
            token("POSITIVE"),
            token("NEGATIVE"),
            zero()
          )
        );
      }
    
      return signTypeParser;
    }
    
    // ========================================================
    // omittedArgumentCondition
    // ........................................................
    
    private ParserCombinator omittedArgumentConditionParser = null;
    
    public final Start omittedArgumentCondition = Start.on(getNamespace(), "omittedArgumentCondition");
    
    public ParserCombinator omittedArgumentCondition() {
      if (omittedArgumentConditionParser == null) {
        FutureParser future = scoped("omittedArgumentCondition", PUBLIC, true);
        omittedArgumentConditionParser = future;
        future.setParser(
          sequence(
            dataName(),
            optional(
              token("IS")
            ),
            optional(
              as("not",
                token("NOT")
              )
            ),
            token("OMITTED")
          )
        );
      }
    
      return omittedArgumentConditionParser;
    }
    
    // ========================================================
    // relationCondition
    // ........................................................
    
    private ParserCombinator relationConditionParser = null;
    
    public final Start relationCondition = Start.on(getNamespace(), "relationCondition");
    
    public ParserCombinator relationCondition() {
      if (relationConditionParser == null) {
        FutureParser future = scoped("relationCondition", PUBLIC, true);
        relationConditionParser = future;
        future.setParser(
          sequence(
            relationSubject(),
            at(
              sequence(
                optional(
                  token("NOT")
                ),
                relop()
              )
            ),
            abbreviatedDisjunction()
          )
        );
      }
    
      return relationConditionParser;
    }
    
    // ========================================================
    // abbreviatedDisjunction
    // ........................................................
    
    private ParserCombinator abbreviatedDisjunctionParser = null;
    
    public final Start abbreviatedDisjunction = Start.on(getNamespace(), "abbreviatedDisjunction");
    
    public ParserCombinator abbreviatedDisjunction() {
      if (abbreviatedDisjunctionParser == null) {
        FutureParser future = scoped("abbreviatedDisjunction", HIDING, true);
        abbreviatedDisjunctionParser = future;
        future.setParser(
          sequence(
            abbreviatedConjunction(),
            star(
              sequence(
                token("OR"),
                abbreviatedConjunction()
              )
            )
          )
        );
      }
    
      return abbreviatedDisjunctionParser;
    }
    
    // ========================================================
    // abbreviatedConjunction
    // ........................................................
    
    private ParserCombinator abbreviatedConjunctionParser = null;
    
    public final Start abbreviatedConjunction = Start.on(getNamespace(), "abbreviatedConjunction");
    
    public ParserCombinator abbreviatedConjunction() {
      if (abbreviatedConjunctionParser == null) {
        FutureParser future = scoped("abbreviatedConjunction", HIDING, true);
        abbreviatedConjunctionParser = future;
        future.setParser(
          sequence(
            abbreviatedNegation(),
            star(
              sequence(
                token("AND"),
                abbreviatedNegation()
              )
            )
          )
        );
      }
    
      return abbreviatedConjunctionParser;
    }
    
    // ========================================================
    // abbreviatedNegation
    // ........................................................
    
    private ParserCombinator abbreviatedNegationParser = null;
    
    public final Start abbreviatedNegation = Start.on(getNamespace(), "abbreviatedNegation");
    
    public ParserCombinator abbreviatedNegation() {
      if (abbreviatedNegationParser == null) {
        FutureParser future = scoped("abbreviatedNegation", HIDING, true);
        abbreviatedNegationParser = future;
        future.setParser(
          sequence(
            optional(
              token("NOT")
            ),
            relationObject()
          )
        );
      }
    
      return abbreviatedNegationParser;
    }
    
    // ========================================================
    // relationSubject
    // ........................................................
    
    private ParserCombinator relationSubjectParser = null;
    
    public final Start relationSubject = Start.on(getNamespace(), "relationSubject");
    
    public ParserCombinator relationSubject() {
      if (relationSubjectParser == null) {
        FutureParser future = scoped("relationSubject", PUBLIC, true);
        relationSubjectParser = future;
        future.setParser(
          relationOperand()
        );
      }
    
      return relationSubjectParser;
    }
    
    // ========================================================
    // relationObject
    // ........................................................
    
    private ParserCombinator relationObjectParser = null;
    
    public final Start relationObject = Start.on(getNamespace(), "relationObject");
    
    public ParserCombinator relationObject() {
      if (relationObjectParser == null) {
        FutureParser future = scoped("relationObject", PUBLIC, true);
        relationObjectParser = future;
        future.setParser(
          sequence(
            optional(
              relop()
            ),
            choice(
              as("operand",
                relationOperand()
              ),
              sequence(
                literal("("),
                abbreviatedDisjunction(),
                literal(")")
              )
            ),
            not(
              choice(
                literal("("),
                token("IS"),
                token("NOT"),
                token("OMITTED"),
                relop(),
                classType(),
                signType()
              )
            )
          )
        );
      }
    
      return relationObjectParser;
    }
    
    // ========================================================
    // relationOperand
    // ........................................................
    
    private ParserCombinator relationOperandParser = null;
    
    protected final Start relationOperand = Start.on(getNamespace(), "relationOperand");
    
    protected ParserCombinator relationOperand() {
      if (relationOperandParser == null) {
        FutureParser future = scoped("relationOperand", PRIVATE, true);
        relationOperandParser = future;
        future.setParser(
          choice(
            as("figurativeConstant",
              choice(
                token("NULL"),
                token("NULLS")
              )
            ),
            addressOf(),
            sequence(
              literal(),
              not(
                moreArithmeticOp()
              )
            ),
            sequence(
              identifier(),
              not(
                moreArithmeticOp()
              )
            ),
            arithmeticExpression()
          )
        );
      }
    
      return relationOperandParser;
    }
    
    // ========================================================
    // relop
    // ........................................................
    
    private ParserCombinator relopParser = null;
    
    public final Start relop = Start.on(getNamespace(), "relop");
    
    public ParserCombinator relop() {
      if (relopParser == null) {
        FutureParser future = scoped("relop", PUBLIC, true);
        relopParser = future;
        future.setParser(
          choice(
            sequence(
              optional(
                choice(
                  token("IS"),
                  token("ARE")
                )
              ),
              choice(
                sequence(
                  optional(
                    as("not",
                      token("NOT")
                    )
                  ),
                  greaterOrEqualOp()
                ),
                sequence(
                  optional(
                    as("not",
                      token("NOT")
                    )
                  ),
                  lessOrEqualOp()
                ),
                sequence(
                  optional(
                    as("not",
                      token("NOT")
                    )
                  ),
                  greaterThanOp()
                ),
                sequence(
                  optional(
                    as("not",
                      token("NOT")
                    )
                  ),
                  lessThanOp()
                ),
                sequence(
                  optional(
                    as("not",
                      token("NOT")
                    )
                  ),
                  equalToOp()
                ),
                unequalToOp()
              )
            ),
            exceedsOp(),
            equalsOp()
          )
        );
      }
    
      return relopParser;
    }
    
    // ========================================================
    // greaterThanOp
    // ........................................................
    
    private ParserCombinator greaterThanOpParser = null;
    
    public final Start greaterThanOp = Start.on(getNamespace(), "greaterThanOp");
    
    public ParserCombinator greaterThanOp() {
      if (greaterThanOpParser == null) {
        FutureParser future = scoped("greaterThanOp", PUBLIC, true);
        greaterThanOpParser = future;
        future.setParser(
          choice(
            sequence(
              token("GREATER"),
              optional(
                token("THAN")
              )
            ),
            literal(">")
          )
        );
      }
    
      return greaterThanOpParser;
    }
    
    // ========================================================
    // lessThanOp
    // ........................................................
    
    private ParserCombinator lessThanOpParser = null;
    
    public final Start lessThanOp = Start.on(getNamespace(), "lessThanOp");
    
    public ParserCombinator lessThanOp() {
      if (lessThanOpParser == null) {
        FutureParser future = scoped("lessThanOp", PUBLIC, true);
        lessThanOpParser = future;
        future.setParser(
          choice(
            sequence(
              token("LESS"),
              optional(
                token("THAN")
              )
            ),
            literal("<")
          )
        );
      }
    
      return lessThanOpParser;
    }
    
    // ========================================================
    // equalToOp
    // ........................................................
    
    private ParserCombinator equalToOpParser = null;
    
    public final Start equalToOp = Start.on(getNamespace(), "equalToOp");
    
    public ParserCombinator equalToOp() {
      if (equalToOpParser == null) {
        FutureParser future = scoped("equalToOp", PUBLIC, true);
        equalToOpParser = future;
        future.setParser(
          choice(
            sequence(
              token("EQUAL"),
              optional(
                token("TO")
              )
            ),
            literal("=")
          )
        );
      }
    
      return equalToOpParser;
    }
    
    // ========================================================
    // greaterOrEqualOp
    // ........................................................
    
    private ParserCombinator greaterOrEqualOpParser = null;
    
    public final Start greaterOrEqualOp = Start.on(getNamespace(), "greaterOrEqualOp");
    
    public ParserCombinator greaterOrEqualOp() {
      if (greaterOrEqualOpParser == null) {
        FutureParser future = scoped("greaterOrEqualOp", PUBLIC, true);
        greaterOrEqualOpParser = future;
        future.setParser(
          choice(
            sequence(
              token("GREATER"),
              optional(
                token("THAN")
              ),
              token("OR"),
              token("EQUAL"),
              optional(
                token("TO")
              )
            ),
            literal(">=")
          )
        );
      }
    
      return greaterOrEqualOpParser;
    }
    
    // ========================================================
    // lessOrEqualOp
    // ........................................................
    
    private ParserCombinator lessOrEqualOpParser = null;
    
    public final Start lessOrEqualOp = Start.on(getNamespace(), "lessOrEqualOp");
    
    public ParserCombinator lessOrEqualOp() {
      if (lessOrEqualOpParser == null) {
        FutureParser future = scoped("lessOrEqualOp", PUBLIC, true);
        lessOrEqualOpParser = future;
        future.setParser(
          choice(
            sequence(
              token("LESS"),
              optional(
                token("THAN")
              ),
              token("OR"),
              token("EQUAL"),
              optional(
                token("TO")
              )
            ),
            literal("<=")
          )
        );
      }
    
      return lessOrEqualOpParser;
    }
    
    // ========================================================
    // unequalToOp
    // ........................................................
    
    private ParserCombinator unequalToOpParser = null;
    
    public final Start unequalToOp = Start.on(getNamespace(), "unequalToOp");
    
    public ParserCombinator unequalToOp() {
      if (unequalToOpParser == null) {
        FutureParser future = scoped("unequalToOp", PUBLIC, true);
        unequalToOpParser = future;
        future.setParser(
          choice(
            sequence(
              token("UNEQUAL"),
              optional(
                token("TO")
              )
            ),
            literal("<>")
          )
        );
      }
    
      return unequalToOpParser;
    }
    
    // ========================================================
    // exceedsOp
    // ........................................................
    
    private ParserCombinator exceedsOpParser = null;
    
    public final Start exceedsOp = Start.on(getNamespace(), "exceedsOp");
    
    public ParserCombinator exceedsOp() {
      if (exceedsOpParser == null) {
        FutureParser future = scoped("exceedsOp", PUBLIC, true);
        exceedsOpParser = future;
        future.setParser(
          token("EXCEEDS")
        );
      }
    
      return exceedsOpParser;
    }
    
    // ========================================================
    // equalsOp
    // ........................................................
    
    private ParserCombinator equalsOpParser = null;
    
    public final Start equalsOp = Start.on(getNamespace(), "equalsOp");
    
    public ParserCombinator equalsOp() {
      if (equalsOpParser == null) {
        FutureParser future = scoped("equalsOp", PUBLIC, true);
        equalsOpParser = future;
        future.setParser(
          token("EQUALS")
        );
      }
    
      return equalsOpParser;
    }
    
    // ========================================================
    // conditionNameCondition
    // ........................................................
    
    private ParserCombinator conditionNameConditionParser = null;
    
    public final Start conditionNameCondition = Start.on(getNamespace(), "conditionNameCondition");
    
    public ParserCombinator conditionNameCondition() {
      if (conditionNameConditionParser == null) {
        FutureParser future = scoped("conditionNameCondition", PUBLIC, true);
        conditionNameConditionParser = future;
        future.setParser(
          sequence(
            conditionName(),
            not(
              choice(
                literal("("),
                relop()
              )
            )
          )
        );
      }
    
      return conditionNameConditionParser;
    }
    
    // ========================================================
    // programName
    // ........................................................
    
    private ParserCombinator programNameParser = null;
    
    public final Start programName = Start.on(getNamespace(), "programName");
    
    public ParserCombinator programName() {
      if (programNameParser == null) {
        FutureParser future = scoped("programName", PUBLIC, true);
        programNameParser = future;
        future.setParser(
          choice(
            cobolWord(),
            alphanumeric()
          )
        );
      }
    
      return programNameParser;
    }
    
    // ========================================================
    // dataName
    // ........................................................
    
    private ParserCombinator dataNameParser = null;
    
    public final Start dataName = Start.on(getNamespace(), "dataName");
    
    public ParserCombinator dataName() {
      if (dataNameParser == null) {
        FutureParser future = scoped("dataName", PUBLIC, true);
        dataNameParser = future;
        future.setParser(
          cobolWord()
        );
      }
    
      return dataNameParser;
    }
    
    // ========================================================
    // qualifiedDataName
    // ........................................................
    
    private ParserCombinator qualifiedDataNameParser = null;
    
    public final Start qualifiedDataName = Start.on(getNamespace(), "qualifiedDataName");
    
    public ParserCombinator qualifiedDataName() {
      if (qualifiedDataNameParser == null) {
        FutureParser future = scoped("qualifiedDataName", PUBLIC, true);
        qualifiedDataNameParser = future;
        future.setParser(
          sequence(
            dataName(),
            optional(
              qualifier()
            ),
            optional(
              sequence(
                literal("("),
                plus(
                  subscript()
                ),
                literal(")")
              )
            )
          )
        );
      }
    
      return qualifiedDataNameParser;
    }
    
    // ========================================================
    // screenName
    // ........................................................
    
    private ParserCombinator screenNameParser = null;
    
    public final Start screenName = Start.on(getNamespace(), "screenName");
    
    public ParserCombinator screenName() {
      if (screenNameParser == null) {
        FutureParser future = scoped("screenName", PUBLIC, true);
        screenNameParser = future;
        future.setParser(
          cobolWord()
        );
      }
    
      return screenNameParser;
    }
    
    // ========================================================
    // sectionName
    // ........................................................
    
    private ParserCombinator sectionNameParser = null;
    
    public final Start sectionName = Start.on(getNamespace(), "sectionName");
    
    public ParserCombinator sectionName() {
      if (sectionNameParser == null) {
        FutureParser future = scoped("sectionName", PUBLIC, true);
        sectionNameParser = future;
        future.setParser(
          name()
        );
      }
    
      return sectionNameParser;
    }
    
    // ========================================================
    // paragraphName
    // ........................................................
    
    private ParserCombinator paragraphNameParser = null;
    
    public final Start paragraphName = Start.on(getNamespace(), "paragraphName");
    
    public ParserCombinator paragraphName() {
      if (paragraphNameParser == null) {
        FutureParser future = scoped("paragraphName", PUBLIC, true);
        paragraphNameParser = future;
        future.setParser(
          name()
        );
      }
    
      return paragraphNameParser;
    }
    
    // ========================================================
    // procedureName
    // ........................................................
    
    private ParserCombinator procedureNameParser = null;
    
    public final Start procedureName = Start.on(getNamespace(), "procedureName");
    
    public ParserCombinator procedureName() {
      if (procedureNameParser == null) {
        FutureParser future = scoped("procedureName", PUBLIC, true);
        procedureNameParser = future;
        future.setParser(
          sequence(
            choice(
              literal("COMMIT"),
              name()
            ),
            optional(
              sequence(
                choice(
                  token("IN"),
                  token("OF")
                ),
                sectionName()
              )
            )
          )
        );
      }
    
      return procedureNameParser;
    }
    
    // ========================================================
    // name
    // ........................................................
    
    private ParserCombinator nameParser = null;
    
    public final Start name = Start.on(getNamespace(), "name");
    
    public ParserCombinator name() {
      if (nameParser == null) {
        FutureParser future = scoped("name", PUBLIC, true);
        nameParser = future;
        future.setParser(
          choice(
            cobolWord(),
            integer()
          )
        );
      }
    
      return nameParser;
    }
    
    // ========================================================
    // segmentNumber
    // ........................................................
    
    private ParserCombinator segmentNumberParser = null;
    
    public final Start segmentNumber = Start.on(getNamespace(), "segmentNumber");
    
    public ParserCombinator segmentNumber() {
      if (segmentNumberParser == null) {
        FutureParser future = scoped("segmentNumber", PUBLIC, true);
        segmentNumberParser = future;
        future.setParser(
          integer()
        );
      }
    
      return segmentNumberParser;
    }
    
    // ========================================================
    // operand
    // ........................................................
    
    private ParserCombinator operandParser = null;
    
    public final Start operand = Start.on(getNamespace(), "operand");
    
    public ParserCombinator operand() {
      if (operandParser == null) {
        FutureParser future = scoped("operand", PUBLIC, true);
        operandParser = future;
        future.setParser(
          choice(
            sequence(
              identifier(),
              not(
                moreArithmeticOp()
              )
            ),
            sequence(
              literal(),
              not(
                moreArithmeticOp()
              )
            ),
            sequence(
              indexName(),
              not(
                moreArithmeticOp()
              )
            ),
            arithmeticExpression()
          )
        );
      }
    
      return operandParser;
    }
    
    // ========================================================
    // threadPointer
    // ........................................................
    
    private ParserCombinator threadPointerParser = null;
    
    public final Start threadPointer = Start.on(getNamespace(), "threadPointer");
    
    public ParserCombinator threadPointer() {
      if (threadPointerParser == null) {
        FutureParser future = scoped("threadPointer", PUBLIC, true);
        threadPointerParser = future;
        future.setParser(
          cobolWord()
        );
      }
    
      return threadPointerParser;
    }
    
    // ========================================================
    // eventPointer
    // ........................................................
    
    private ParserCombinator eventPointerParser = null;
    
    public final Start eventPointer = Start.on(getNamespace(), "eventPointer");
    
    public ParserCombinator eventPointer() {
      if (eventPointerParser == null) {
        FutureParser future = scoped("eventPointer", PUBLIC, true);
        eventPointerParser = future;
        future.setParser(
          cobolWord()
        );
      }
    
      return eventPointerParser;
    }
    
    // ========================================================
    // conditionName
    // ........................................................
    
    private ParserCombinator conditionNameParser = null;
    
    public final Start conditionName = Start.on(getNamespace(), "conditionName");
    
    public ParserCombinator conditionName() {
      if (conditionNameParser == null) {
        FutureParser future = scoped("conditionName", PUBLIC, true);
        conditionNameParser = future;
        future.setParser(
          identifier()
        );
      }
    
      return conditionNameParser;
    }
    
    // ========================================================
    // indexName
    // ........................................................
    
    private ParserCombinator indexNameParser = null;
    
    public final Start indexName = Start.on(getNamespace(), "indexName");
    
    public ParserCombinator indexName() {
      if (indexNameParser == null) {
        FutureParser future = scoped("indexName", PUBLIC, true);
        indexNameParser = future;
        future.setParser(
          cobolWord()
        );
      }
    
      return indexNameParser;
    }
    
    // ========================================================
    // className
    // ........................................................
    
    private ParserCombinator classNameParser = null;
    
    public final Start className = Start.on(getNamespace(), "className");
    
    public ParserCombinator className() {
      if (classNameParser == null) {
        FutureParser future = scoped("className", PUBLIC, true);
        classNameParser = future;
        future.setParser(
          cobolWord()
        );
      }
    
      return classNameParser;
    }
    
    // ========================================================
    // typeSpecifier
    // ........................................................
    
    private ParserCombinator typeSpecifierParser = null;
    
    public final Start typeSpecifier = Start.on(getNamespace(), "typeSpecifier");
    
    public ParserCombinator typeSpecifier() {
      if (typeSpecifierParser == null) {
        FutureParser future = scoped("typeSpecifier", PUBLIC, true);
        typeSpecifierParser = future;
        future.setParser(
          cobolWord()
        );
      }
    
      return typeSpecifierParser;
    }
    
    // ========================================================
    // parameterName
    // ........................................................
    
    private ParserCombinator parameterNameParser = null;
    
    public final Start parameterName = Start.on(getNamespace(), "parameterName");
    
    public ParserCombinator parameterName() {
      if (parameterNameParser == null) {
        FutureParser future = scoped("parameterName", PUBLIC, true);
        parameterNameParser = future;
        future.setParser(
          cobolWord()
        );
      }
    
      return parameterNameParser;
    }
    
    // ========================================================
    // interfaceName
    // ........................................................
    
    private ParserCombinator interfaceNameParser = null;
    
    public final Start interfaceName = Start.on(getNamespace(), "interfaceName");
    
    public ParserCombinator interfaceName() {
      if (interfaceNameParser == null) {
        FutureParser future = scoped("interfaceName", PUBLIC, true);
        interfaceNameParser = future;
        future.setParser(
          cobolWord()
        );
      }
    
      return interfaceNameParser;
    }
    
    // ========================================================
    // methodName
    // ........................................................
    
    private ParserCombinator methodNameParser = null;
    
    public final Start methodName = Start.on(getNamespace(), "methodName");
    
    public ParserCombinator methodName() {
      if (methodNameParser == null) {
        FutureParser future = scoped("methodName", PUBLIC, true);
        methodNameParser = future;
        future.setParser(
          cobolWord()
        );
      }
    
      return methodNameParser;
    }
    
    // ========================================================
    // propertyName
    // ........................................................
    
    private ParserCombinator propertyNameParser = null;
    
    public final Start propertyName = Start.on(getNamespace(), "propertyName");
    
    public ParserCombinator propertyName() {
      if (propertyNameParser == null) {
        FutureParser future = scoped("propertyName", PUBLIC, true);
        propertyNameParser = future;
        future.setParser(
          choice(
            identifier(),
            alphanumeric()
          )
        );
      }
    
      return propertyNameParser;
    }
    
    // ========================================================
    // propertyValue
    // ........................................................
    
    private ParserCombinator propertyValueParser = null;
    
    public final Start propertyValue = Start.on(getNamespace(), "propertyValue");
    
    public ParserCombinator propertyValue() {
      if (propertyValueParser == null) {
        FutureParser future = scoped("propertyValue", PUBLIC, true);
        propertyValueParser = future;
        future.setParser(
          choice(
            identifier(),
            literal()
          )
        );
      }
    
      return propertyValueParser;
    }
    
    // ========================================================
    // delegateName
    // ........................................................
    
    private ParserCombinator delegateNameParser = null;
    
    public final Start delegateName = Start.on(getNamespace(), "delegateName");
    
    public ParserCombinator delegateName() {
      if (delegateNameParser == null) {
        FutureParser future = scoped("delegateName", PUBLIC, true);
        delegateNameParser = future;
        future.setParser(
          cobolWord()
        );
      }
    
      return delegateNameParser;
    }
    
    // ========================================================
    // iteratorName
    // ........................................................
    
    private ParserCombinator iteratorNameParser = null;
    
    public final Start iteratorName = Start.on(getNamespace(), "iteratorName");
    
    public ParserCombinator iteratorName() {
      if (iteratorNameParser == null) {
        FutureParser future = scoped("iteratorName", PUBLIC, true);
        iteratorNameParser = future;
        future.setParser(
          cobolWord()
        );
      }
    
      return iteratorNameParser;
    }
    
    // ========================================================
    // enumName
    // ........................................................
    
    private ParserCombinator enumNameParser = null;
    
    public final Start enumName = Start.on(getNamespace(), "enumName");
    
    public ParserCombinator enumName() {
      if (enumNameParser == null) {
        FutureParser future = scoped("enumName", PUBLIC, true);
        enumNameParser = future;
        future.setParser(
          cobolWord()
        );
      }
    
      return enumNameParser;
    }
    
    // ========================================================
    // valuetypeName
    // ........................................................
    
    private ParserCombinator valuetypeNameParser = null;
    
    public final Start valuetypeName = Start.on(getNamespace(), "valuetypeName");
    
    public ParserCombinator valuetypeName() {
      if (valuetypeNameParser == null) {
        FutureParser future = scoped("valuetypeName", PUBLIC, true);
        valuetypeNameParser = future;
        future.setParser(
          cobolWord()
        );
      }
    
      return valuetypeNameParser;
    }
    
    // ========================================================
    // typeName
    // ........................................................
    
    private ParserCombinator typeNameParser = null;
    
    public final Start typeName = Start.on(getNamespace(), "typeName");
    
    public ParserCombinator typeName() {
      if (typeNameParser == null) {
        FutureParser future = scoped("typeName", PUBLIC, true);
        typeNameParser = future;
        future.setParser(
          cobolWord()
        );
      }
    
      return typeNameParser;
    }
    
    // ========================================================
    // attributeName
    // ........................................................
    
    private ParserCombinator attributeNameParser = null;
    
    public final Start attributeName = Start.on(getNamespace(), "attributeName");
    
    public ParserCombinator attributeName() {
      if (attributeNameParser == null) {
        FutureParser future = scoped("attributeName", PUBLIC, true);
        attributeNameParser = future;
        future.setParser(
          cobolWord()
        );
      }
    
      return attributeNameParser;
    }
    
    // ========================================================
    // typedefName
    // ........................................................
    
    private ParserCombinator typedefNameParser = null;
    
    public final Start typedefName = Start.on(getNamespace(), "typedefName");
    
    public ParserCombinator typedefName() {
      if (typedefNameParser == null) {
        FutureParser future = scoped("typedefName", PUBLIC, true);
        typedefNameParser = future;
        future.setParser(
          cobolWord()
        );
      }
    
      return typedefNameParser;
    }
    
    // ========================================================
    // fileName
    // ........................................................
    
    private ParserCombinator fileNameParser = null;
    
    public final Start fileName = Start.on(getNamespace(), "fileName");
    
    public ParserCombinator fileName() {
      if (fileNameParser == null) {
        FutureParser future = scoped("fileName", PUBLIC, true);
        fileNameParser = future;
        future.setParser(
          choice(
            cobolWord(),
            alphanumeric()
          )
        );
      }
    
      return fileNameParser;
    }
    
    // ========================================================
    // computerName
    // ........................................................
    
    private ParserCombinator computerNameParser = null;
    
    public final Start computerName = Start.on(getNamespace(), "computerName");
    
    public ParserCombinator computerName() {
      if (computerNameParser == null) {
        FutureParser future = scoped("computerName", PUBLIC, true);
        computerNameParser = future;
        future.setParser(
          cobolWord()
        );
      }
    
      return computerNameParser;
    }
    
    // ========================================================
    // functionName
    // ........................................................
    
    private ParserCombinator functionNameParser = null;
    
    public final Start functionName = Start.on(getNamespace(), "functionName");
    
    public ParserCombinator functionName() {
      if (functionNameParser == null) {
        FutureParser future = scoped("functionName", PUBLIC, true);
        functionNameParser = future;
        future.setParser(
          cobolWord()
        );
      }
    
      return functionNameParser;
    }
    
    // ========================================================
    // recordName
    // ........................................................
    
    private ParserCombinator recordNameParser = null;
    
    public final Start recordName = Start.on(getNamespace(), "recordName");
    
    public ParserCombinator recordName() {
      if (recordNameParser == null) {
        FutureParser future = scoped("recordName", PUBLIC, true);
        recordNameParser = future;
        future.setParser(
          identifier()
        );
      }
    
      return recordNameParser;
    }
    
    // ========================================================
    // mnemonicName
    // ........................................................
    
    private ParserCombinator mnemonicNameParser = null;
    
    public final Start mnemonicName = Start.on(getNamespace(), "mnemonicName");
    
    public ParserCombinator mnemonicName() {
      if (mnemonicNameParser == null) {
        FutureParser future = scoped("mnemonicName", PUBLIC, true);
        mnemonicNameParser = future;
        future.setParser(
          choice(
            identifier(),
            cobolWord()
          )
        );
      }
    
      return mnemonicNameParser;
    }
    
    // ========================================================
    // environmentName
    // ........................................................
    
    private ParserCombinator environmentNameParser = null;
    
    public final Start environmentName = Start.on(getNamespace(), "environmentName");
    
    public ParserCombinator environmentName() {
      if (environmentNameParser == null) {
        FutureParser future = scoped("environmentName", PUBLIC, true);
        environmentNameParser = future;
        future.setParser(
          choice(
            token("SYSIN"),
            token("SYSIPT"),
            token("SYSOUT"),
            token("SYSLIST"),
            token("SYSLST"),
            token("SYSPUNCH"),
            token("SYSPCH"),
            token("CONSOLE"),
            token("CRT"),
            token("CRT-UNDER"),
            token("C01"),
            token("C02"),
            token("C03"),
            token("C04"),
            token("C05"),
            token("C06"),
            token("C07"),
            token("C08"),
            token("C09"),
            token("C10"),
            token("C11"),
            token("C12"),
            token("CSP"),
            token("S01"),
            token("S02"),
            token("S03"),
            token("S04"),
            token("S05"),
            token("AFP-5A")
          )
        );
      }
    
      return environmentNameParser;
    }
    
    // ========================================================
    // alphabetName
    // ........................................................
    
    private ParserCombinator alphabetNameParser = null;
    
    public final Start alphabetName = Start.on(getNamespace(), "alphabetName");
    
    public ParserCombinator alphabetName() {
      if (alphabetNameParser == null) {
        FutureParser future = scoped("alphabetName", PUBLIC, true);
        alphabetNameParser = future;
        future.setParser(
          cobolWord()
        );
      }
    
      return alphabetNameParser;
    }
    
    // ========================================================
    // cdName
    // ........................................................
    
    private ParserCombinator cdNameParser = null;
    
    public final Start cdName = Start.on(getNamespace(), "cdName");
    
    public ParserCombinator cdName() {
      if (cdNameParser == null) {
        FutureParser future = scoped("cdName", PUBLIC, true);
        cdNameParser = future;
        future.setParser(
          cobolWord()
        );
      }
    
      return cdNameParser;
    }
    
    // ========================================================
    // reportName
    // ........................................................
    
    private ParserCombinator reportNameParser = null;
    
    public final Start reportName = Start.on(getNamespace(), "reportName");
    
    public ParserCombinator reportName() {
      if (reportNameParser == null) {
        FutureParser future = scoped("reportName", PUBLIC, true);
        reportNameParser = future;
        future.setParser(
          cobolWord()
        );
      }
    
      return reportNameParser;
    }
    
    // ========================================================
    // literal
    // ........................................................
    
    private ParserCombinator literalParser = null;
    
    public final Start literal = Start.on(getNamespace(), "literal");
    
    public ParserCombinator literal() {
      if (literalParser == null) {
        FutureParser future = scoped("literal", PUBLIC, true);
        literalParser = future;
        future.setParser(
          choice(
            sequence(
              literalValue(),
              star(
                concatenatedLiteral()
              )
            ),
            sequence(
              constant(),
              plus(
                concatenatedLiteral()
              )
            )
          )
        );
      }
    
      return literalParser;
    }
    
    // ========================================================
    // literalValue
    // ........................................................
    
    private ParserCombinator literalValueParser = null;
    
    public final Start literalValue = Start.on(getNamespace(), "literalValue");
    
    public ParserCombinator literalValue() {
      if (literalValueParser == null) {
        FutureParser future = scoped("literalValue", PUBLIC, true);
        literalValueParser = future;
        future.setParser(
          choice(
            numericLiteral(),
            alphanumericLiteral(),
            figurativeConstant(),
            token("TRUE"),
            token("FALSE")
          )
        );
      }
    
      return literalValueParser;
    }
    
    // ========================================================
    // concatenatedLiteral
    // ........................................................
    
    private ParserCombinator concatenatedLiteralParser = null;
    
    public final Start concatenatedLiteral = Start.on(getNamespace(), "concatenatedLiteral");
    
    public ParserCombinator concatenatedLiteral() {
      if (concatenatedLiteralParser == null) {
        FutureParser future = scoped("concatenatedLiteral", PUBLIC, true);
        concatenatedLiteralParser = future;
        future.setParser(
          sequence(
            literal("&"),
            choice(
              literalValue(),
              constant()
            )
          )
        );
      }
    
      return concatenatedLiteralParser;
    }
    
    // ========================================================
    // value
    // ........................................................
    
    private ParserCombinator valueParser = null;
    
    public final Start value = Start.on(getNamespace(), "value");
    
    public ParserCombinator value() {
      if (valueParser == null) {
        FutureParser future = scoped("value", PUBLIC, true);
        valueParser = future;
        future.setParser(
          choice(
            literal(),
            integerConstant(),
            alphanumericConstant()
          )
        );
      }
    
      return valueParser;
    }
    
    // ========================================================
    // figurativeConstant
    // ........................................................
    
    private ParserCombinator figurativeConstantParser = null;
    
    public final Start figurativeConstant = Start.on(getNamespace(), "figurativeConstant");
    
    public ParserCombinator figurativeConstant() {
      if (figurativeConstantParser == null) {
        FutureParser future = scoped("figurativeConstant", PUBLIC, true);
        figurativeConstantParser = future;
        future.setParser(
          choice(
            sequence(
              token("ALL"),
              literal()
            ),
            sequence(
              optional(
                token("ALL")
              ),
              choice(
                zero(),
                space(),
                token("HIGH-VALUE"),
                token("HIGH-VALUES"),
                token("LOW-VALUE"),
                token("LOW-VALUES"),
                token("QUOTE"),
                token("QUOTES")
              )
            ),
            token("NULL"),
            token("NULLS")
          )
        );
      }
    
      return figurativeConstantParser;
    }
    
    // ========================================================
    // numericLiteral
    // ........................................................
    
    private ParserCombinator numericLiteralParser = null;
    
    public final Start numericLiteral = Start.on(getNamespace(), "numericLiteral");
    
    public ParserCombinator numericLiteral() {
      if (numericLiteralParser == null) {
        FutureParser future = scoped("numericLiteral", PUBLIC, true);
        numericLiteralParser = future;
        future.setParser(
          choice(
            decimal(),
            integerLiteral(),
            booleanLiteral(),
            hexadecimal(),
            sequence(
              choice(
                token("LENGTH"),
                token("BYTE-LENGTH")
              ),
              optional(
                token("OF")
              ),
              identifier()
            )
          )
        );
      }
    
      return numericLiteralParser;
    }
    
    // ========================================================
    // numeric
    // ........................................................
    
    private ParserCombinator numericParser = null;
    
    public final Start numeric = Start.on(getNamespace(), "numeric");
    
    public ParserCombinator numeric() {
      if (numericParser == null) {
        FutureParser future = scoped("numeric", PUBLIC, true);
        numericParser = future;
        future.setParser(
          choice(
            decimal(),
            integer(),
            booleanLiteral(),
            hexadecimal(),
            zero()
          )
        );
      }
    
      return numericParser;
    }
    
    // ========================================================
    // integer
    // ........................................................
    
    private ParserCombinator integerParser = null;
    
    public final Start integer = Start.on(getNamespace(), "integer");
    
    public ParserCombinator integer() {
      if (integerParser == null) {
        FutureParser future = scoped("integer", PUBLIC, true);
        integerParser = future;
        future.setParser(
          choice(
            integerLiteral(),
            integerConstant(),
            lengthOf(),
            byteLengthOf()
          )
        );
      }
    
      return integerParser;
    }
    
    // ========================================================
    // addressOf
    // ........................................................
    
    private ParserCombinator addressOfParser = null;
    
    public final Start addressOf = Start.on(getNamespace(), "addressOf");
    
    public ParserCombinator addressOf() {
      if (addressOfParser == null) {
        FutureParser future = scoped("addressOf", PUBLIC, true);
        addressOfParser = future;
        future.setParser(
          sequence(
            token("ADDRESS"),
            token("OF"),
            identifier()
          )
        );
      }
    
      return addressOfParser;
    }
    
    // ========================================================
    // lengthOf
    // ........................................................
    
    private ParserCombinator lengthOfParser = null;
    
    public final Start lengthOf = Start.on(getNamespace(), "lengthOf");
    
    public ParserCombinator lengthOf() {
      if (lengthOfParser == null) {
        FutureParser future = scoped("lengthOf", PUBLIC, true);
        lengthOfParser = future;
        future.setParser(
          sequence(
            token("LENGTH"),
            optional(
              token("OF")
            ),
            identifier()
          )
        );
      }
    
      return lengthOfParser;
    }
    
    // ========================================================
    // byteLengthOf
    // ........................................................
    
    private ParserCombinator byteLengthOfParser = null;
    
    public final Start byteLengthOf = Start.on(getNamespace(), "byteLengthOf");
    
    public ParserCombinator byteLengthOf() {
      if (byteLengthOfParser == null) {
        FutureParser future = scoped("byteLengthOf", PUBLIC, true);
        byteLengthOfParser = future;
        future.setParser(
          sequence(
            token("BYTE-LENGTH"),
            optional(
              token("OF")
            ),
            identifier()
          )
        );
      }
    
      return byteLengthOfParser;
    }
    
    // ========================================================
    // constant
    // ........................................................
    
    private ParserCombinator constantParser = null;
    
    public final Start constant = Start.on(getNamespace(), "constant");
    
    public ParserCombinator constant() {
      if (constantParser == null) {
        FutureParser future = scoped("constant", PUBLIC, true);
        constantParser = future;
        future.setParser(
          choice(
            integerConstant(),
            alphanumericConstant()
          )
        );
      }
    
      return constantParser;
    }
    
    // ========================================================
    // integerConstant
    // ........................................................
    
    private ParserCombinator integerConstantParser = null;
    
    public final Start integerConstant = Start.on(getNamespace(), "integerConstant");
    
    public ParserCombinator integerConstant() {
      if (integerConstantParser == null) {
        FutureParser future = scoped("integerConstant", PUBLIC, true);
        integerConstantParser = future;
        future.setParser(
          cobolWord()
        );
      }
    
      return integerConstantParser;
    }
    
    // ========================================================
    // alphanumeric
    // ........................................................
    
    private ParserCombinator alphanumericParser = null;
    
    public final Start alphanumeric = Start.on(getNamespace(), "alphanumeric");
    
    public ParserCombinator alphanumeric() {
      if (alphanumericParser == null) {
        FutureParser future = scoped("alphanumeric", PUBLIC, true);
        alphanumericParser = future;
        future.setParser(
          choice(
            alphanumericLiteral(),
            alphanumericConstant()
          )
        );
      }
    
      return alphanumericParser;
    }
    
    // ========================================================
    // alphanumericConstant
    // ........................................................
    
    private ParserCombinator alphanumericConstantParser = null;
    
    public final Start alphanumericConstant = Start.on(getNamespace(), "alphanumericConstant");
    
    public ParserCombinator alphanumericConstant() {
      if (alphanumericConstantParser == null) {
        FutureParser future = scoped("alphanumericConstant", PUBLIC, true);
        alphanumericConstantParser = future;
        future.setParser(
          cobolWord()
        );
      }
    
      return alphanumericConstantParser;
    }
    
}
