package koopa.cobol.grammar;

import koopa.core.data.markers.Start;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.FutureParser;

import static koopa.core.parsers.combinators.Opt.NOSKIP;
import static koopa.core.grammars.combinators.Scoped.Visibility.PUBLIC;
import static koopa.core.grammars.combinators.Scoped.Visibility.PRIVATE;
import static koopa.core.grammars.combinators.Scoped.Visibility.HIDING;


/**
 * <b>This is generated code.<b>
 * <p>
 * @see <code>src/cobol/koopa/cobol/grammar/Cobol.kg</code>
 */
public class CobolGrammar extends CobolBaseGrammar {
    private static CobolGrammar INSTANCE = null;

    protected CobolGrammar() {
    }
    
    public static CobolGrammar instance() {
      if (INSTANCE == null)
        INSTANCE = new CobolGrammar();
        
      return INSTANCE;
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
            plus(
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
            star(
              copyStatement()
            ),
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
                  as("header",
                    sequence(
                      choice(
                        keyword("ID"),
                        keyword("IDENTIFICATION")
                      ),
                      keyword("DIVISION"),
                      literal(".")
                    )
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
            keyword("END"),
            keyword("PROGRAM"),
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
            keyword("PROGRAM-ID"),
            optional(
              literal(".")
            ),
            name(),
            optional(
              sequence(
                keyword("AS"),
                literal()
              )
            ),
            optional(
              keyword("IS")
            ),
            keyword("PROTOTYPE"),
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
                  as("header",
                    sequence(
                      choice(
                        keyword("ID"),
                        keyword("IDENTIFICATION")
                      ),
                      keyword("DIVISION"),
                      literal(".")
                    )
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
            keyword("END"),
            keyword("FUNCTION"),
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
            keyword("FUNCTION-ID"),
            optional(
              literal(".")
            ),
            name(),
            optional(
              sequence(
                keyword("AS"),
                literal()
              )
            ),
            optional(
              keyword("IS")
            ),
            keyword("PROTOTYPE"),
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
            notEmpty(
              sequence(
                optional(
                  as("identificationDivision",
                    notEmpty(
                      sequence(
                        optional(
                          as("header",
                            sequence(
                              choice(
                                keyword("ID"),
                                keyword("IDENTIFICATION")
                              ),
                              keyword("DIVISION"),
                              literal(".")
                            )
                          )
                        ),
                        optional(
                          programIdParagraph()
                        ),
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
                )
              )
            ),
            optional(
              sequence(
                keyword("END"),
                keyword("PROGRAM"),
                optional(
                  programName()
                ),
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
            keyword("PROGRAM-ID"),
            optional(
              literal(".")
            ),
            programName(),
            optional(
              sequence(
                keyword("AS"),
                literal()
              )
            ),
            optional(
              sequence(
                optional(
                  keyword("IS")
                ),
                permuted(
                  keyword("COMMON"),
                  choice(
                    keyword("INITIAL"),
                    keyword("RECURSIVE")
                  )
                ),
                optional(
                  keyword("PROGRAM")
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
                  as("header",
                    sequence(
                      choice(
                        keyword("ID"),
                        keyword("IDENTIFICATION")
                      ),
                      keyword("DIVISION"),
                      literal(".")
                    )
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
            keyword("END"),
            keyword("FUNCTION"),
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
            keyword("FUNCTION-ID"),
            optional(
              literal(".")
            ),
            name(),
            optional(
              sequence(
                keyword("AS"),
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
                  as("header",
                    sequence(
                      choice(
                        keyword("ID"),
                        keyword("IDENTIFICATION")
                      ),
                      keyword("DIVISION"),
                      literal(".")
                    )
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
            keyword("END"),
            keyword("CLASS"),
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
            keyword("CLASS-ID"),
            optional(
              literal(".")
            ),
            name(),
            optional(
              sequence(
                keyword("AS"),
                literal()
              )
            ),
            optional(
              sequence(
                keyword("INHERITS"),
                optional(
                  keyword("FROM")
                ),
                plus(
                  typeSpecifier()
                )
              )
            ),
            optional(
              sequence(
                optional(
                  keyword("IS")
                ),
                keyword("STATIC")
              )
            ),
            optional(
              sequence(
                optional(
                  keyword("IS")
                ),
                plus(
                  choice(
                    keyword("PARTIAL"),
                    keyword("FINAL"),
                    keyword("ABSTRACT")
                  )
                )
              )
            ),
            optional(
              sequence(
                optional(
                  keyword("IS")
                ),
                choice(
                  keyword("PUBLIC"),
                  keyword("INTERNAL")
                )
              )
            ),
            optional(
              attributeClause()
            ),
            optional(
              sequence(
                keyword("IMPLEMENTS"),
                plus(
                  typeSpecifier()
                )
              )
            ),
            optional(
              sequence(
                keyword("USING"),
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
                  as("header",
                    sequence(
                      choice(
                        keyword("ID"),
                        keyword("IDENTIFICATION")
                      ),
                      keyword("DIVISION"),
                      literal(".")
                    )
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
            keyword("END"),
            keyword("FACTORY"),
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
            keyword("FACTORY"),
            optional(
              literal(".")
            ),
            optional(
              sequence(
                keyword("IMPLEMENTS"),
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
                  as("header",
                    sequence(
                      choice(
                        keyword("ID"),
                        keyword("IDENTIFICATION")
                      ),
                      keyword("DIVISION"),
                      literal(".")
                    )
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
            keyword("END"),
            keyword("OBJECT"),
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
            keyword("OBJECT"),
            optional(
              literal(".")
            ),
            optional(
              sequence(
                keyword("IMPLEMENTS"),
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
                  as("header",
                    sequence(
                      choice(
                        keyword("ID"),
                        keyword("IDENTIFICATION")
                      ),
                      keyword("DIVISION"),
                      literal(".")
                    )
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
            keyword("END"),
            keyword("INTERFACE"),
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
            keyword("INTERFACE-ID"),
            optional(
              literal(".")
            ),
            name(),
            optional(
              sequence(
                keyword("AS"),
                literal()
              )
            ),
            optional(
              sequence(
                keyword("INHERITS"),
                optional(
                  keyword("FROM")
                ),
                plus(
                  name()
                )
              )
            ),
            optional(
              sequence(
                keyword("USING"),
                optional(
                  keyword("FROM")
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
                  as("header",
                    sequence(
                      choice(
                        keyword("ID"),
                        keyword("IDENTIFICATION")
                      ),
                      keyword("DIVISION"),
                      literal(".")
                    )
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
            keyword("END"),
            keyword("METHOD"),
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
            keyword("METHOD-ID"),
            optional(
              literal(".")
            ),
            choice(
              sequence(
                choice(
                  keyword("GET"),
                  keyword("SET")
                ),
                keyword("PROPERTY"),
                name()
              ),
              sequence(
                name(),
                optional(
                  sequence(
                    keyword("AS"),
                    literal()
                  )
                )
              )
            ),
            optional(
              keyword("OVERRIDE")
            ),
            optional(
              sequence(
                optional(
                  keyword("IS")
                ),
                keyword("FINAL")
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
                  as("header",
                    sequence(
                      choice(
                        keyword("ID"),
                        keyword("IDENTIFICATION")
                      ),
                      keyword("DIVISION"),
                      literal(".")
                    )
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
                keyword("END"),
                keyword("PROGRAM"),
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
            keyword("PROGRAM-ID"),
            optional(
              literal(".")
            ),
            programName(),
            optional(
              keyword("IS")
            ),
            keyword("EXTERNAL"),
            optional(
              keyword("PROGRAM")
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
                  as("header",
                    sequence(
                      choice(
                        keyword("ID"),
                        keyword("IDENTIFICATION")
                      ),
                      keyword("DIVISION"),
                      literal(".")
                    )
                  )
                ),
                delegateIdParagraph()
              )
            ),
            as("procedureDivisionHeader",
              procedureDivision$header()
            ),
            keyword("END"),
            keyword("DELEGATE"),
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
            keyword("DELEGATE-ID"),
            optional(
              literal(".")
            ),
            delegateName(),
            optional(
              sequence(
                keyword("AS"),
                literal()
              )
            ),
            optional(
              sequence(
                optional(
                  keyword("IS")
                ),
                plus(
                  choice(
                    keyword("PUBLIC"),
                    keyword("PRIVATE"),
                    keyword("PROTECTED"),
                    keyword("INTERNAL")
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
                  as("header",
                    sequence(
                      choice(
                        keyword("ID"),
                        keyword("IDENTIFICATION")
                      ),
                      keyword("DIVISION"),
                      literal(".")
                    )
                  )
                ),
                enumIdParagraph()
              )
            ),
            optional(
              skipto(
                sequence(
                  keyword("END"),
                  keyword("ENUM"),
                  literal(".")
                )
              )
            ),
            keyword("END"),
            keyword("ENUM"),
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
            keyword("ENUM-ID"),
            optional(
              literal(".")
            ),
            enumName(),
            optional(
              sequence(
                keyword("AS"),
                literal()
              )
            ),
            optional(
              sequence(
                optional(
                  keyword("IS")
                ),
                plus(
                  choice(
                    keyword("PUBLIC"),
                    keyword("PRIVATE"),
                    keyword("PROTECTED"),
                    keyword("INTERNAL")
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
                  as("header",
                    sequence(
                      choice(
                        keyword("ID"),
                        keyword("IDENTIFICATION")
                      ),
                      keyword("DIVISION"),
                      literal(".")
                    )
                  )
                ),
                iteratorIdParagraph()
              )
            ),
            optional(
              skipto(
                sequence(
                  keyword("END"),
                  keyword("ITERATOR"),
                  literal(".")
                )
              )
            ),
            keyword("END"),
            keyword("ITERATOR"),
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
            keyword("ITERATOR-ID"),
            optional(
              literal(".")
            ),
            iteratorName(),
            optional(
              sequence(
                keyword("AS"),
                literal()
              )
            ),
            optional(
              sequence(
                optional(
                  keyword("IS")
                ),
                plus(
                  choice(
                    keyword("PUBLIC"),
                    keyword("PRIVATE"),
                    keyword("PROTECTED"),
                    keyword("INTERNAL")
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
                  as("header",
                    sequence(
                      choice(
                        keyword("ID"),
                        keyword("IDENTIFICATION")
                      ),
                      keyword("DIVISION"),
                      literal(".")
                    )
                  )
                ),
                operatorIdParagraph()
              )
            ),
            optional(
              skipto(
                sequence(
                  keyword("END"),
                  keyword("ENUM"),
                  literal(".")
                )
              )
            ),
            keyword("END"),
            keyword("OPERATOR"),
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
            keyword("OPERATOR-ID"),
            optional(
              literal(".")
            ),
            choice(
              sequence(
                literal("="),
                optional(
                  keyword("EXTENSION")
                )
              ),
              sequence(
                literal("<"),
                opt(NOSKIP,
                  literal(">")
                )
              ),
              sequence(
                literal(">"),
                opt(NOSKIP,
                  literal("=")
                )
              ),
              literal(">"),
              sequence(
                literal("<"),
                opt(NOSKIP,
                  literal("=")
                )
              ),
              literal("<"),
              literal("+"),
              literal("-"),
              literal("*"),
              literal("/"),
              keyword("B-AND"),
              keyword("B-OR"),
              keyword("B-XOR"),
              keyword("B-NOT"),
              keyword("B-LEFT"),
              keyword("B-RIGHT"),
              keyword("IMPLICIT"),
              keyword("EXPLICIT")
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
                  as("header",
                    sequence(
                      choice(
                        keyword("ID"),
                        keyword("IDENTIFICATION")
                      ),
                      keyword("DIVISION"),
                      literal(".")
                    )
                  )
                ),
                valueTypeIdParagraph()
              )
            ),
            optional(
              skipto(
                sequence(
                  keyword("END"),
                  keyword("ENUM"),
                  literal(".")
                )
              )
            ),
            keyword("END"),
            keyword("VALUETYPE"),
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
            keyword("VALUETYPE-ID"),
            optional(
              literal(".")
            ),
            valuetypeName(),
            optional(
              sequence(
                keyword("AS"),
                literal()
              )
            ),
            optional(
              sequence(
                optional(
                  keyword("IS")
                ),
                choice(
                  keyword("FINAL"),
                  keyword("PARTIAL"),
                  keyword("ABSTRACT")
                )
              )
            ),
            optional(
              sequence(
                optional(
                  keyword("IS")
                ),
                choice(
                  keyword("PUBLIC"),
                  keyword("INTERNAL")
                )
              )
            ),
            optional(
              attributeClause()
            ),
            optional(
              sequence(
                keyword("IMPLEMENTS"),
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
            keyword("END"),
            choice(
              sequence(
                keyword("CLASS"),
                name()
              ),
              keyword("FACTORY"),
              sequence(
                keyword("FUNCTION"),
                name()
              ),
              sequence(
                keyword("INTERFACE"),
                name()
              ),
              sequence(
                keyword("METHOD"),
                optional(
                  name()
                )
              ),
              keyword("OBJECT"),
              sequence(
                keyword("PROGRAM"),
                programName()
              ),
              sequence(
                keyword("DELEGATE"),
                name()
              ),
              sequence(
                keyword("ENUM"),
                name()
              ),
              sequence(
                keyword("OPERATOR"),
                optional(
                  name()
                )
              ),
              keyword("STATIC"),
              sequence(
                keyword("VALUETYPE"),
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
            keyword("OPTIONS"),
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
            keyword("ARITHMETIC"),
            optional(
              keyword("IS")
            ),
            choice(
              keyword("NATIVE"),
              keyword("STANDARD"),
              keyword("STANDARD-BINARY"),
              keyword("STANDARD-DECIMAL")
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
            keyword("DEFAULT"),
            keyword("ROUNDED"),
            optional(
              keyword("MODE")
            ),
            optional(
              keyword("IS")
            ),
            choice(
              keyword("AWAY-FROM-ZERO"),
              keyword("NEAREST-AWAY-FROM-ZERO"),
              keyword("NEAREST-EVEN"),
              keyword("NEAREST-TOWARD-ZERO"),
              keyword("PROHIBITED"),
              keyword("TOWARD-GREATER"),
              keyword("TOWARD-LESSER"),
              keyword("TRUNCATION")
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
            keyword("ENTRY-CONVENTION"),
            optional(
              keyword("IS")
            ),
            choice(
              keyword("COBOL"),
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
            keyword("INTERMEDIATE"),
            keyword("ROUNDING"),
            optional(
              keyword("IS")
            ),
            choice(
              keyword("NEAREST-AWAY-FROM-ZERO"),
              keyword("NEAREST-EVEN"),
              keyword("PROHIBITED"),
              keyword("TRUNCATION")
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
                  keyword("AUTHOR"),
                  optional(
                    literal(".")
                  ),
                  optional(
                    commentEntry()
                  )
                ),
                sequence(
                  keyword("INSTALLATION"),
                  optional(
                    literal(".")
                  ),
                  optional(
                    commentEntry()
                  )
                ),
                sequence(
                  keyword("DATE-WRITTEN"),
                  optional(
                    literal(".")
                  ),
                  optional(
                    commentEntry()
                  )
                ),
                sequence(
                  keyword("DATE-COMPILED"),
                  optional(
                    literal(".")
                  ),
                  optional(
                    commentEntry()
                  )
                ),
                sequence(
                  keyword("SECURITY"),
                  optional(
                    literal(".")
                  ),
                  optional(
                    commentEntry()
                  )
                ),
                sequence(
                  keyword("REMARKS"),
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
          notEmpty(
            sequence(
              optional(
                as("header",
                  sequence(
                    keyword("ENVIRONMENT"),
                    keyword("DIVISION"),
                    literal(".")
                  )
                )
              ),
              optional(
                environmentDivision$body()
              )
            )
          )
        );
      }
    
      return environmentDivisionParser;
    }
    
    // ========================================================
    // body
    // ........................................................
    
    private ParserCombinator environmentDivision$bodyParser = null;
    
    protected final Start environmentDivision$body = Start.on(getNamespace(), "body");
    
    protected ParserCombinator environmentDivision$body() {
      if (environmentDivision$bodyParser == null) {
        FutureParser future = scoped("body", PRIVATE, true);
        environmentDivision$bodyParser = future;
        future.setParser(
          sequence(
            permuted(
              configurationSection(),
              ioSection(),
              objectSection()
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
    
      return environmentDivision$bodyParser;
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
          notEmpty(
            sequence(
              optional(
                as("header",
                  sequence(
                    keyword("CONFIGURATION"),
                    keyword("SECTION"),
                    literal(".")
                  )
                )
              ),
              optional(
                configurationSection$body()
              )
            )
          )
        );
      }
    
      return configurationSectionParser;
    }
    
    // ========================================================
    // body
    // ........................................................
    
    private ParserCombinator configurationSection$bodyParser = null;
    
    protected final Start configurationSection$body = Start.on(getNamespace(), "body");
    
    protected ParserCombinator configurationSection$body() {
      if (configurationSection$bodyParser == null) {
        FutureParser future = scoped("body", PRIVATE, true);
        configurationSection$bodyParser = future;
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
    
      return configurationSection$bodyParser;
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
            keyword("SOURCE-COMPUTER"),
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
              keyword("WITH")
            ),
            keyword("DEBUGGING"),
            keyword("MODE")
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
            keyword("OBJECT-COMPUTER"),
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
            keyword("CONSTRAINTS"),
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
            keyword("CLASS-ATTRIBUTES"),
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
            keyword("ASSEMBLY-ATTRIBUTES"),
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
                keyword("WITH"),
                keyword("DEBUGGING")
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
            as("header",
              sequence(
                keyword("SPECIAL-NAMES"),
                literal(".")
              )
            ),
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
              keyword("IS"),
              mnemonicName(),
              star(
                sequence(
                  choice(
                    keyword("ON"),
                    keyword("OFF")
                  ),
                  optional(
                    keyword("STATUS")
                  ),
                  optional(
                    keyword("IS")
                  ),
                  conditionName()
                )
              )
            ),
            sequence(
              cobolDevice(),
              keyword("IS"),
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
            keyword("CONSOLE"),
            optional(
              keyword("IS")
            ),
            keyword("CRT")
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
            keyword("SYSIN"),
            keyword("SYSIPT"),
            keyword("SYSOUT"),
            keyword("SYSLIST"),
            keyword("SYSLST"),
            keyword("SYSPCH"),
            keyword("SYSPUNCH"),
            keyword("CONSOLE"),
            keyword("TAB"),
            keyword("PRINTER"),
            keyword("FORMFEED"),
            keyword("COMMAND-LINE"),
            keyword("ARGUMENT-NUMBER"),
            keyword("ENVIRONMENT-NAME"),
            keyword("ENVIRONMENT-VALUE"),
            keyword("SYSERR"),
            keyword("C01"),
            keyword("C02"),
            keyword("C03"),
            keyword("C04"),
            keyword("C05"),
            keyword("C06"),
            keyword("C07"),
            keyword("C08"),
            keyword("C09"),
            keyword("C10"),
            keyword("C11"),
            keyword("C18"),
            keyword("S01"),
            keyword("S02"),
            keyword("S03"),
            keyword("S04"),
            keyword("S05"),
            keyword("CSP"),
            alphanumericLiteral(),
            justAName()
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
            keyword("SWITCH-0"),
            keyword("SWITCH-1"),
            keyword("SWITCH-2"),
            keyword("SWITCH-3"),
            keyword("SWITCH-4"),
            keyword("SWITCH-5"),
            keyword("SWITCH-6"),
            keyword("SWITCH-7"),
            keyword("SWITCH-8")
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
            keyword("ALPHABET"),
            identifier(),
            optional(
              keyword("IS")
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
          keyword("STANDARD-1")
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
          keyword("STANDARD-2")
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
          keyword("NATIVE")
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
          keyword("ASCII")
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
          keyword("EBCDIC")
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
                keyword("ALSO"),
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
          justAName()
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
              keyword("THROUGH"),
              keyword("THRU")
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
            keyword("SYMBOLIC"),
            optional(
              choice(
                keyword("CHARACTER"),
                keyword("CHARACTERS")
              )
            ),
            plus(
              sequence(
                plus(
                  literal()
                ),
                optional(
                  choice(
                    keyword("IS"),
                    keyword("ARE")
                  )
                ),
                plus(
                  integer()
                )
              )
            ),
            optional(
              sequence(
                keyword("IN"),
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
            keyword("CLASS"),
            identifier(),
            optional(
              keyword("IS")
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
            keyword("LOCALE"),
            identifier(),
            optional(
              keyword("IS")
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
            keyword("CURRENCY"),
            optional(
              keyword("SIGN")
            ),
            optional(
              keyword("IS")
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
              keyword("WITH")
            ),
            keyword("PICTURE"),
            keyword("SYMBOL"),
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
            keyword("DECIMAL-POINT"),
            optional(
              keyword("IS")
            ),
            keyword("COMMA")
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
            keyword("NUMERIC"),
            keyword("SIGN"),
            optional(
              keyword("IS")
            ),
            choice(
              as("leading",
                keyword("LEADING")
              ),
              as("trailing",
                keyword("TRAILING")
              )
            ),
            optional(
              as("separate",
                sequence(
                  keyword("SEPARATE"),
                  optional(
                    keyword("CHARACTER")
                  )
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
            keyword("CALL-CONVENTION"),
            integer(),
            optional(
              keyword("IS")
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
            keyword("CURSOR"),
            optional(
              keyword("IS")
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
            keyword("CRT"),
            keyword("STATUS"),
            optional(
              keyword("IS")
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
            keyword("XML-SCHEMA"),
            identifier(),
            optional(
              keyword("IS")
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
            keyword("SCREEN"),
            keyword("CONTROL"),
            optional(
              keyword("IS")
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
            keyword("EVENT"),
            keyword("STATUS"),
            optional(
              keyword("IS")
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
            keyword("REPOSITORY"),
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
            keyword("CLASS"),
            className(),
            optional(
              sequence(
                keyword("AS"),
                literal()
              )
            ),
            optional(
              sequence(
                keyword("EXPANDS"),
                className(),
                keyword("USING"),
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
            keyword("INTERFACE"),
            interfaceName(),
            optional(
              sequence(
                keyword("AS"),
                literal()
              )
            ),
            optional(
              sequence(
                keyword("EXPANDS"),
                interfaceName(),
                keyword("USING"),
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
            keyword("PROGRAM"),
            programName(),
            optional(
              sequence(
                keyword("AS"),
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
            keyword("PROPERTY"),
            propertyName(),
            optional(
              sequence(
                keyword("AS"),
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
            keyword("FUNCTION"),
            choice(
              sequence(
                choice(
                  keyword("ALL"),
                  plus(
                    functionName()
                  )
                ),
                keyword("INTRINSIC")
              ),
              sequence(
                functionName(),
                optional(
                  sequence(
                    keyword("AS"),
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
            keyword("DELEGATE"),
            delegateName(),
            optional(
              sequence(
                keyword("AS"),
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
            keyword("ENUM"),
            enumName(),
            optional(
              sequence(
                keyword("AS"),
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
          notEmpty(
            sequence(
              optional(
                as("header",
                  sequence(
                    keyword("INPUT-OUTPUT"),
                    keyword("SECTION"),
                    literal(".")
                  )
                )
              ),
              optional(
                ioSection$body()
              )
            )
          )
        );
      }
    
      return ioSectionParser;
    }
    
    // ========================================================
    // body
    // ........................................................
    
    private ParserCombinator ioSection$bodyParser = null;
    
    protected final Start ioSection$body = Start.on(getNamespace(), "body");
    
    protected ParserCombinator ioSection$body() {
      if (ioSection$bodyParser == null) {
        FutureParser future = scoped("body", PRIVATE, true);
        ioSection$bodyParser = future;
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
    
      return ioSection$bodyParser;
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
          notEmpty(
            sequence(
              optional(
                as("header",
                  sequence(
                    keyword("FILE-CONTROL"),
                    literal(".")
                  )
                )
              ),
              optional(
                fileControlEntry()
              )
            )
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
            keyword("SELECT"),
            optional(
              choice(
                keyword("OPTIONAL"),
                sequence(
                  keyword("NOT"),
                  keyword("OPTIONAL")
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
            keyword("ASSIGN"),
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
            keyword("USING"),
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
              keyword("TO")
            ),
            optional(
              choice(
                keyword("EXTERNAL"),
                keyword("DYNAMIC")
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
              keyword("DISK"),
              keyword("FROM"),
              dataName()
            ),
            sequence(
              keyword("LINE"),
              keyword("ADVANCING"),
              optional(
                keyword("FILE")
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
                keyword("MULTIPLE")
              ),
              choice(
                keyword("REEL"),
                keyword("UNIT")
              ),
              optional(
                keyword("FILE")
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
                keyword("DISK")
              ),
              keyword("FILE"),
              plus(
                choice(
                  dataName(),
                  literal()
                )
              )
            ),
            sequence(
              choice(
                keyword("DISK"),
                keyword("PRINTER")
              ),
              keyword("DISPLAY")
            ),
            sequence(
              choice(
                keyword("DISK"),
                keyword("KEYBOARD"),
                keyword("DISPLAY"),
                keyword("PRINTER-1"),
                keyword("PRINTER")
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
            keyword("COLLATING"),
            optional(
              keyword("SEQUENCE")
            ),
            optional(
              keyword("IS")
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
            keyword("RECORD"),
            keyword("DELIMITER"),
            optional(
              keyword("IS")
            ),
            choice(
              keyword("STANDARD-1"),
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
            keyword("RESERVE"),
            choice(
              integer(),
              keyword("NO")
            ),
            optional(
              keyword("ALTERNATE")
            ),
            optional(
              choice(
                keyword("AREA"),
                keyword("AREAS")
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
                keyword("ORGANIZATION"),
                optional(
                  keyword("IS")
                )
              )
            ),
            optional(
              choice(
                keyword("LINE"),
                sequence(
                  keyword("RECORD"),
                  keyword("BINARY")
                ),
                keyword("RECORD"),
                keyword("BINARY")
              )
            ),
            choice(
              keyword("SEQUENTIAL"),
              keyword("RELATIVE"),
              keyword("INDEXED")
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
            keyword("ACCESS"),
            optional(
              keyword("MODE")
            ),
            optional(
              keyword("IS")
            ),
            choice(
              keyword("SEQUENTIAL"),
              keyword("RANDOM"),
              keyword("DYNAMIC"),
              keyword("EXCLUSIVE"),
              sequence(
                keyword("MANUAL"),
                optional(
                  lockModeWithClause()
                )
              ),
              sequence(
                keyword("AUTOMATIC"),
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
            keyword("LOCK"),
            optional(
              keyword("MODE")
            ),
            optional(
              keyword("IS")
            ),
            choice(
              keyword("EXCLUSIVE"),
              sequence(
                keyword("MANUAL"),
                optional(
                  lockModeWithClause()
                )
              ),
              sequence(
                keyword("AUTOMATIC"),
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
              keyword("WITH")
            ),
            choice(
              keyword("ROLLBACK"),
              sequence(
                keyword("LOCK"),
                keyword("ON"),
                optional(
                  keyword("MULTIPLE")
                ),
                choice(
                  keyword("RECORD"),
                  keyword("RECORDS")
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
            keyword("RELATIVE"),
            optional(
              keyword("KEY")
            ),
            optional(
              keyword("IS")
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
            keyword("RECORD"),
            optional(
              keyword("KEY")
            ),
            optional(
              keyword("IS")
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
            keyword("ALTERNATE"),
            optional(
              keyword("RECORD")
            ),
            optional(
              keyword("KEY")
            ),
            optional(
              keyword("IS")
            ),
            recordKeyDefinition(),
            optional(
              permuted(
                passwordClause(),
                suppressClause(),
                sequence(
                  optional(
                    keyword("WITH")
                  ),
                  keyword("DUPLICATES")
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
                  keyword("SOURCE"),
                  optional(
                    keyword("IS")
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
              keyword("FILE")
            ),
            keyword("STATUS"),
            optional(
              keyword("IS")
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
            keyword("SORT"),
            keyword("STATUS"),
            optional(
              keyword("IS")
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
            keyword("PASSWORD"),
            optional(
              keyword("IS")
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
            keyword("SUPPRESS"),
            optional(
              keyword("WHEN")
            ),
            choice(
              zero(),
              space(),
              sequence(
                optional(
                  keyword("ALL")
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
            keyword("SHARING"),
            optional(
              keyword("WITH")
            ),
            choice(
              sequence(
                keyword("READ"),
                keyword("ONLY")
              ),
              sequence(
                choice(
                  keyword("ALL"),
                  keyword("NO")
                ),
                optional(
                  keyword("OTHER")
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
            keyword("PADDING"),
            optional(
              keyword("CHARACTER")
            ),
            optional(
              keyword("IS")
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
            keyword("I-O-CONTROL"),
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
          notEmpty(
            sequence(
              optional(
                as("header",
                  sequence(
                    keyword("OBJECT"),
                    keyword("SECTION"),
                    literal(".")
                  )
                )
              ),
              optional(
                objectSection$body()
              )
            )
          )
        );
      }
    
      return objectSectionParser;
    }
    
    // ========================================================
    // body
    // ........................................................
    
    private ParserCombinator objectSection$bodyParser = null;
    
    public final Start objectSection$body = Start.on(getNamespace(), "body");
    
    public ParserCombinator objectSection$body() {
      if (objectSection$bodyParser == null) {
        FutureParser future = scoped("body", PUBLIC, true);
        objectSection$bodyParser = future;
        future.setParser(
          plus(
            choice(
              classControlParagraph(),
              copyStatement()
            )
          )
        );
      }
    
      return objectSection$bodyParser;
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
            keyword("CLASS-CONTROL"),
            literal("."),
            plus(
              choice(
                sequence(
                  className(),
                  keyword("IS"),
                  keyword("CLASS"),
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
          notEmpty(
            sequence(
              optional(
                as("header",
                  sequence(
                    keyword("DATA"),
                    keyword("DIVISION"),
                    literal(".")
                  )
                )
              ),
              optional(
                dataDivision$body()
              )
            )
          )
        );
      }
    
      return dataDivisionParser;
    }
    
    // ========================================================
    // body
    // ........................................................
    
    private ParserCombinator dataDivision$bodyParser = null;
    
    protected final Start dataDivision$body = Start.on(getNamespace(), "body");
    
    protected ParserCombinator dataDivision$body() {
      if (dataDivision$bodyParser == null) {
        FutureParser future = scoped("body", PRIVATE, true);
        dataDivision$bodyParser = future;
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
    
      return dataDivision$bodyParser;
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
            notEmpty(
              sequence(
                optional(
                  as("header",
                    sequence(
                      keyword("FILE"),
                      keyword("SECTION"),
                      literal(".")
                    )
                  )
                ),
                optional(
                  fileSection$body()
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
    
      return fileSectionParser;
    }
    
    // ========================================================
    // body
    // ........................................................
    
    private ParserCombinator fileSection$bodyParser = null;
    
    protected final Start fileSection$body = Start.on(getNamespace(), "body");
    
    protected ParserCombinator fileSection$body() {
      if (fileSection$bodyParser == null) {
        FutureParser future = scoped("body", PRIVATE, true);
        fileSection$bodyParser = future;
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
    
      return fileSection$bodyParser;
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
            keyword("FD"),
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
            keyword("SD"),
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
            as("header",
              sequence(
                keyword("WORKING-STORAGE"),
                keyword("SECTION"),
                literal(".")
              )
            ),
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
            as("header",
              sequence(
                keyword("THREAD-LOCAL-STORAGE"),
                keyword("SECTION"),
                literal(".")
              )
            ),
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
            as("header",
              sequence(
                keyword("OBJECT-STORAGE"),
                keyword("SECTION"),
                literal(".")
              )
            ),
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
            as("header",
              sequence(
                keyword("LOCAL-STORAGE"),
                keyword("SECTION"),
                literal(".")
              )
            ),
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
            as("header",
              sequence(
                keyword("LINKAGE"),
                keyword("SECTION"),
                literal(".")
              )
            ),
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
            as("header",
              sequence(
                keyword("COMMUNICATION"),
                keyword("SECTION"),
                literal(".")
              )
            ),
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
            keyword("CD"),
            cdName(),
            optional(
              keyword("FOR")
            ),
            optional(
              keyword("INITIAL")
            ),
            keyword("INPUT"),
            optional(
              choice(
                permuted(
                  sequence(
                    optional(
                      keyword("SYMBOLIC")
                    ),
                    keyword("QUEUE"),
                    optional(
                      keyword("IS")
                    ),
                    dataName()
                  ),
                  sequence(
                    optional(
                      keyword("SYMBOLIC")
                    ),
                    keyword("SUB-QUEUE-1"),
                    optional(
                      keyword("IS")
                    ),
                    dataName()
                  ),
                  sequence(
                    optional(
                      keyword("SYMBOLIC")
                    ),
                    keyword("SUB-QUEUE-2"),
                    optional(
                      keyword("IS")
                    ),
                    dataName()
                  ),
                  sequence(
                    optional(
                      keyword("SYMBOLIC")
                    ),
                    keyword("SUB-QUEUE-3"),
                    optional(
                      keyword("IS")
                    ),
                    dataName()
                  ),
                  sequence(
                    keyword("MESSAGE"),
                    keyword("DATE"),
                    optional(
                      keyword("IS")
                    ),
                    dataName()
                  ),
                  sequence(
                    keyword("MESSAGE"),
                    keyword("TIME"),
                    optional(
                      keyword("IS")
                    ),
                    dataName()
                  ),
                  sequence(
                    optional(
                      keyword("SYMBOLIC")
                    ),
                    keyword("SOURCE"),
                    optional(
                      keyword("IS")
                    ),
                    dataName()
                  ),
                  sequence(
                    keyword("TEXT"),
                    keyword("LENGTH"),
                    optional(
                      keyword("IS")
                    ),
                    dataName()
                  ),
                  sequence(
                    keyword("END"),
                    keyword("KEY"),
                    optional(
                      keyword("IS")
                    ),
                    dataName()
                  ),
                  sequence(
                    keyword("STATUS"),
                    keyword("KEY"),
                    optional(
                      keyword("IS")
                    ),
                    dataName()
                  ),
                  sequence(
                    optional(
                      keyword("MESSAGE")
                    ),
                    keyword("COUNT"),
                    optional(
                      keyword("IS")
                    ),
                    dataName()
                  )
                ),
                plus(
                  choice(
                    keyword("FILLER"),
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
            keyword("CD"),
            cdName(),
            optional(
              keyword("FOR")
            ),
            keyword("OUTPUT"),
            optional(
              sequence(
                keyword("DESTINATION"),
                keyword("COUNT"),
                optional(
                  keyword("IS")
                ),
                dataName()
              )
            ),
            optional(
              sequence(
                keyword("TEXT"),
                keyword("LENGTH"),
                optional(
                  keyword("IS")
                ),
                dataName()
              )
            ),
            optional(
              sequence(
                keyword("STATUS"),
                keyword("KEY"),
                optional(
                  keyword("IS")
                ),
                dataName()
              )
            ),
            optional(
              sequence(
                keyword("DESTINATION"),
                keyword("TABLE"),
                keyword("OCCURS"),
                integer(),
                optional(
                  keyword("TIMES")
                ),
                optional(
                  sequence(
                    keyword("INDEXED"),
                    optional(
                      keyword("BY")
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
                keyword("ERROR"),
                keyword("KEY"),
                optional(
                  keyword("IS")
                ),
                dataName()
              )
            ),
            optional(
              sequence(
                optional(
                  keyword("SYMBOLIC")
                ),
                keyword("DESTINATION"),
                optional(
                  keyword("IS")
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
            keyword("CD"),
            cdName(),
            optional(
              keyword("FOR")
            ),
            optional(
              keyword("INITIAL")
            ),
            keyword("I-O"),
            choice(
              plus(
                choice(
                  keyword("FILLER"),
                  dataName()
                )
              ),
              optional(
                permuted(
                  sequence(
                    keyword("MESSAGE"),
                    keyword("DATE"),
                    optional(
                      keyword("IS")
                    ),
                    dataName()
                  ),
                  sequence(
                    keyword("MESSAGE"),
                    keyword("TIME"),
                    optional(
                      keyword("IS")
                    ),
                    dataName()
                  ),
                  sequence(
                    optional(
                      keyword("SYMBOLIC")
                    ),
                    keyword("TERMINAL"),
                    optional(
                      keyword("IS")
                    ),
                    dataName()
                  ),
                  sequence(
                    keyword("TEXT"),
                    keyword("LENGTH"),
                    optional(
                      keyword("IS")
                    ),
                    dataName()
                  ),
                  sequence(
                    keyword("END"),
                    keyword("KEY"),
                    optional(
                      keyword("IS")
                    ),
                    dataName()
                  ),
                  sequence(
                    keyword("STATUS"),
                    keyword("KEY"),
                    optional(
                      keyword("IS")
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
            as("header",
              sequence(
                keyword("REPORT"),
                keyword("SECTION"),
                literal(".")
              )
            ),
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
            keyword("RD"),
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
            as("header",
              sequence(
                keyword("SCREEN"),
                keyword("SECTION"),
                literal(".")
              )
            ),
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
                keyword("FILLER"),
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
                number("1"),
                number("01")
              )
            ),
            as("entryName",
              choice(
                keyword("FILLER"),
                justAName()
              )
            ),
            keyword("CONSTANT"),
            optional(
              globalClause()
            ),
            choice(
              sequence(
                optional(
                  keyword("AS")
                ),
                identifier()
              ),
              sequence(
                keyword("FROM"),
                justAName()
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
              number("78")
            ),
            choice(
              sequence(
                as("entryName",
                  justAName()
                ),
                constantValueClause()
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
                  keyword("FILLER"),
                  keyword("CURSOR"),
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
                  keyword("USING"),
                  identifier()
                ),
                sequence(
                  keyword("FROM"),
                  choice(
                    identifier(),
                    literal()
                  ),
                  optional(
                    sequence(
                      keyword("TO"),
                      identifier()
                    )
                  )
                ),
                keyword("PUBLIC"),
                keyword("PRIVATE"),
                keyword("PROTECTED"),
                keyword("INTERNAL"),
                attributeClause(),
                usageClause()
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
              number("66")
            ),
            choice(
              sequence(
                as("entryName",
                  dataName()
                ),
                renamesClause()
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
              number("88")
            ),
            choice(
              sequence(
                optional(
                  as("entryName",
                    sequence(
                      not(
                        choice(
                          keyword("VALUE"),
                          keyword("VALUES")
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
              keyword("DATA")
            ),
            choice(
              sequence(
                keyword("RECORD"),
                optional(
                  keyword("IS")
                )
              ),
              sequence(
                keyword("RECORDS"),
                optional(
                  keyword("ARE")
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
            keyword("LABEL"),
            choice(
              sequence(
                keyword("RECORD"),
                optional(
                  keyword("IS")
                )
              ),
              sequence(
                keyword("RECORDS"),
                optional(
                  keyword("ARE")
                )
              )
            ),
            choice(
              keyword("OMITTED"),
              keyword("STANDARD"),
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
            keyword("RECORDING"),
            optional(
              keyword("MODE")
            ),
            optional(
              keyword("IS")
            ),
            choice(
              keyword("F"),
              keyword("V"),
              keyword("U"),
              keyword("S"),
              keyword("FIXED"),
              keyword("VARIABLE")
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
            keyword("VALUE"),
            keyword("OF"),
            keyword("FILE-ID"),
            optional(
              keyword("IS")
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
            keyword("VALUE"),
            keyword("OF"),
            plus(
              sequence(
                choice(
                  keyword("IDENTIFICATION"),
                  keyword("ID"),
                  justAName()
                ),
                optional(
                  keyword("IS")
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
              keyword("DFHVALUE"),
              keyword("DFHRESP")
            ),
            literal("("),
            justAName(),
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
              keyword("WHEN")
            ),
            optional(
              keyword("SET")
            ),
            optional(
              keyword("TO")
            ),
            keyword("FALSE"),
            optional(
              keyword("IS")
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
            keyword("BLANK"),
            optional(
              keyword("WHEN")
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
              keyword("IS")
            ),
            keyword("THREAD-LOCAL")
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
            keyword("ZERO"),
            keyword("ZEROS"),
            keyword("ZEROES")
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
            keyword("SPACE"),
            keyword("SPACES")
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
              keyword("OUTPUT")
            ),
            choice(
              keyword("JUSTIFIED"),
              keyword("JUST")
            ),
            optional(
              choice(
                keyword("LEFT"),
                keyword("RIGHT"),
                keyword("CENTERED")
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
                keyword("VALUE"),
                optional(
                  keyword("IS")
                )
              ),
              sequence(
                keyword("VALUES"),
                optional(
                  keyword("ARE")
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
                          keyword("THROUGH"),
                          keyword("THRU")
                        )
                      ),
                      literal()
                    )
                  ),
                  keyword("FROM"),
                  literal("("),
                  plus(
                    subscript()
                  ),
                  literal(")"),
                  optional(
                    sequence(
                      keyword("TO"),
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
                          keyword("FALSE")
                        ),
                        literal()
                      )
                    ),
                    optional(
                      sequence(
                        choice(
                          keyword("THROUGH"),
                          keyword("THRU")
                        ),
                        literal()
                      )
                    )
                  )
                ),
                optional(
                  sequence(
                    optional(
                      keyword("IN")
                    ),
                    not(
                      keyword("FALSE")
                    ),
                    alphabetName()
                  )
                ),
                optional(
                  sequence(
                    optional(
                      keyword("WHEN")
                    ),
                    optional(
                      keyword("SET")
                    ),
                    optional(
                      keyword("TO")
                    ),
                    keyword("FALSE"),
                    optional(
                      keyword("IS")
                    ),
                    literal()
                  )
                ),
                optional(
                  sequence(
                    optional(
                      choice(
                        keyword("IS"),
                        keyword("ARE")
                      )
                    ),
                    choice(
                      keyword("INVALID"),
                      keyword("VALID")
                    )
                  )
                ),
                optional(
                  sequence(
                    keyword("WHEN"),
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
          keyword("ALIGNED")
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
            keyword("ANY"),
            keyword("LENGTH")
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
            keyword("AUTO"),
            keyword("AUTO-SKIP")
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
              keyword("BACKGROUND-COLOR"),
              keyword("BACKGROUND-COLOUR")
            ),
            optional(
              keyword("IS")
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
          keyword("BASED")
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
          keyword("BELL")
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
            keyword("BLANK"),
            choice(
              keyword("SCREEN"),
              keyword("LINE")
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
            keyword("BLANK"),
            optional(
              keyword("WHEN")
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
          keyword("BLINK")
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
            keyword("BLOCK"),
            optional(
              keyword("CONTAINS")
            ),
            integer(),
            optional(
              sequence(
                keyword("TO"),
                integer()
              )
            ),
            optional(
              choice(
                keyword("CHARACTERS"),
                keyword("RECORDS")
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
            keyword("CLASS"),
            optional(
              keyword("IS")
            ),
            choice(
              keyword("NUMERIC"),
              keyword("ALPHABETIC"),
              keyword("ALPHABETIC-LOWER"),
              keyword("ALPHABETIC-UPPER"),
              keyword("BOOLEAN"),
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
              keyword("WITH")
            ),
            keyword("CODE"),
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
            keyword("CODE-SET"),
            optional(
              keyword("IS")
            ),
            alphabetName(),
            optional(
              sequence(
                keyword("FOR"),
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
                  keyword("COL"),
                  keyword("COLUMN")
                ),
                optional(
                  choice(
                    keyword("NUMBER"),
                    keyword("NUMBERS")
                  )
                )
              ),
              keyword("COLUMNS"),
              keyword("COLS")
            ),
            optional(
              choice(
                keyword("LEFT"),
                keyword("CENTER"),
                keyword("RIGHT")
              )
            ),
            optional(
              choice(
                keyword("IS"),
                keyword("ARE")
              )
            ),
            optional(
              choice(
                keyword("PLUS"),
                literal("+"),
                keyword("MINUS"),
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
            keyword("CONSTANT"),
            keyword("RECORD")
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
            keyword("VALUE"),
            optional(
              keyword("IS")
            ),
            choice(
              keyword("NEXT"),
              sequence(
                keyword("START"),
                optional(
                  keyword("OF")
                ),
                dataName()
              ),
              sequence(
                keyword("LENGTH"),
                optional(
                  keyword("OF")
                ),
                dataName()
              ),
              literal()
            ),
            optional(
              sequence(
                choice(
                  keyword("AND"),
                  keyword("OR"),
                  literal("&"),
                  literal("+"),
                  literal("-"),
                  literal("*"),
                  literal("/")
                ),
                choice(
                  keyword("NEXT"),
                  sequence(
                    keyword("START"),
                    optional(
                      keyword("OF")
                    ),
                    dataName()
                  ),
                  sequence(
                    keyword("LENGTH"),
                    optional(
                      keyword("OF")
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
                keyword("CONTROL"),
                optional(
                  keyword("IS")
                )
              ),
              sequence(
                keyword("CONTROLS"),
                optional(
                  keyword("ARE")
                )
              )
            ),
            choice(
              sequence(
                keyword("FINAL"),
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
            keyword("DEFAULT"),
            optional(
              keyword("IS")
            ),
            choice(
              keyword("NONE"),
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
            keyword("DESTINATION"),
            optional(
              keyword("IS")
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
            keyword("ERASE"),
            optional(
              choice(
                keyword("EOL"),
                keyword("EOS"),
                sequence(
                  optional(
                    sequence(
                      keyword("END"),
                      keyword("OF")
                    )
                  ),
                  keyword("LINE")
                ),
                sequence(
                  optional(
                    sequence(
                      keyword("END"),
                      keyword("OF")
                    )
                  ),
                  keyword("SCREEN")
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
              keyword("IS")
            ),
            keyword("EXTERNAL"),
            optional(
              sequence(
                choice(
                  keyword("AS"),
                  keyword("BY")
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
              keyword("FOREGROUND-COLOR"),
              keyword("FOREGROUND-COLOUR")
            ),
            optional(
              keyword("IS")
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
            keyword("FORMAT"),
            permuted(
              keyword("BIT"),
              keyword("CHARACTER"),
              keyword("NUMERIC")
            ),
            keyword("DATA")
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
          keyword("FULL")
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
              keyword("IS")
            ),
            keyword("GLOBAL")
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
            keyword("GROUP"),
            optional(
              keyword("INDICATE")
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
            keyword("GROUP-USAGE"),
            optional(
              keyword("IS")
            ),
            choice(
              keyword("BIT"),
              keyword("NATIONAL")
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
            keyword("HIGHLIGHT"),
            keyword("LOWLIGHT")
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
            keyword("INVALID"),
            keyword("WHEN"),
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
              keyword("JUSTIFIED"),
              keyword("JUST")
            ),
            optional(
              keyword("RIGHT")
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
            keyword("LINAGE"),
            optional(
              keyword("IS")
            ),
            choice(
              dataName(),
              integer()
            ),
            optional(
              keyword("LINES")
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
              keyword("WITH")
            ),
            keyword("FOOTING"),
            optional(
              keyword("AT")
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
              keyword("LINES")
            ),
            optional(
              keyword("AT")
            ),
            keyword("TOP"),
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
              keyword("LINES")
            ),
            optional(
              keyword("AT")
            ),
            keyword("BOTTOM"),
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
                keyword("LINE"),
                optional(
                  choice(
                    keyword("NUMBER"),
                    keyword("NUMBERS")
                  )
                ),
                optional(
                  choice(
                    keyword("IS"),
                    keyword("ARE")
                  )
                )
              ),
              sequence(
                keyword("LINES"),
                optional(
                  keyword("ARE")
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
                          keyword("ON")
                        ),
                        keyword("NEXT"),
                        keyword("PAGE")
                      )
                    )
                  ),
                  sequence(
                    choice(
                      keyword("PLUS"),
                      literal("+")
                    ),
                    choice(
                      integer(),
                      identifier()
                    )
                  ),
                  sequence(
                    optional(
                      keyword("ON")
                    ),
                    keyword("NEXT"),
                    keyword("PAGE")
                  )
                )
              ),
              sequence(
                choice(
                  keyword("PLUS"),
                  literal("+"),
                  keyword("MINUS"),
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
            keyword("NEXT"),
            keyword("GROUP"),
            optional(
              keyword("IS")
            ),
            choice(
              integer(),
              sequence(
                keyword("PLUS"),
                integer()
              ),
              sequence(
                keyword("NEXT"),
                keyword("PAGE"),
                optional(
                  sequence(
                    optional(
                      keyword("WITH")
                    ),
                    keyword("RESET")
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
            keyword("OCCURS"),
            choice(
              sequence(
                choice(
                  as("dynamic",
                    sequence(
                      keyword("DYNAMIC"),
                      optional(
                        sequence(
                          keyword("CAPACITY"),
                          optional(
                            keyword("IN")
                          ),
                          dataName()
                        )
                      ),
                      optional(
                        sequence(
                          keyword("FROM"),
                          integer()
                        )
                      ),
                      optional(
                        sequence(
                          keyword("TO"),
                          integer()
                        )
                      ),
                      optional(
                        keyword("INITIALIZED")
                      )
                    )
                  ),
                  as("fixed",
                    sequence(
                      optional(
                        sequence(
                          as("min",
                            integer()
                          ),
                          keyword("TO")
                        )
                      ),
                      as("max",
                        integer()
                      ),
                      optional(
                        keyword("TIMES")
                      )
                    )
                  )
                ),
                optional(
                  as("dependingOn",
                    sequence(
                      keyword("DEPENDING"),
                      optional(
                        keyword("ON")
                      ),
                      qualifiedDataName()
                    )
                  )
                ),
                optional(
                  as("step",
                    sequence(
                      keyword("STEP"),
                      integer()
                    )
                  )
                ),
                star(
                  as("keyIs",
                    sequence(
                      choice(
                        as("ascending",
                          keyword("ASCENDING")
                        ),
                        as("descending",
                          keyword("DESCENDING")
                        )
                      ),
                      optional(
                        keyword("KEY")
                      ),
                      optional(
                        keyword("IS")
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
                      keyword("INDEXED"),
                      optional(
                        keyword("BY")
                      ),
                      plus(
                        indexName()
                      )
                    )
                  )
                )
              ),
              as("any",
                keyword("ANY")
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
            keyword("PAGE"),
            optional(
              choice(
                keyword("LIMIT"),
                keyword("LIMITS")
              )
            ),
            optional(
              choice(
                keyword("IS"),
                keyword("ARE")
              )
            ),
            integer(),
            optional(
              choice(
                keyword("LINE"),
                keyword("LINES")
              )
            ),
            optional(
              sequence(
                keyword("HEADING"),
                integer()
              )
            ),
            optional(
              sequence(
                keyword("FIRST"),
                keyword("DETAIL"),
                integer()
              )
            ),
            optional(
              sequence(
                keyword("LAST"),
                keyword("DETAIL"),
                integer()
              )
            ),
            optional(
              sequence(
                keyword("FOOTING"),
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
              keyword("PIC"),
              keyword("PICTURE")
            ),
            optional(
              keyword("IS")
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
            keyword("LOCALE"),
            optional(
              sequence(
                optional(
                  keyword("IS")
                ),
                justAName()
              )
            ),
            keyword("SIZE"),
            optional(
              keyword("IS")
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
            keyword("PRESENT"),
            keyword("WHEN"),
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
            keyword("PROPERTY"),
            optional(
              sequence(
                optional(
                  keyword("WITH")
                ),
                keyword("NO"),
                choice(
                  keyword("GET"),
                  keyword("SET")
                )
              )
            ),
            optional(
              sequence(
                optional(
                  keyword("IS")
                ),
                keyword("FINAL")
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
            keyword("RECORD"),
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
              keyword("CONTAINS")
            ),
            integer(),
            optional(
              sequence(
                keyword("TO"),
                integer()
              )
            ),
            optional(
              keyword("CHARACTERS")
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
              keyword("IS")
            ),
            keyword("VARYING"),
            optional(
              keyword("IN")
            ),
            optional(
              keyword("SIZE")
            ),
            optional(
              sequence(
                optional(
                  keyword("FROM")
                ),
                integer(),
                optional(
                  sequence(
                    keyword("TO"),
                    integer()
                  )
                ),
                optional(
                  keyword("CHARACTERS")
                )
              )
            ),
            optional(
              sequence(
                keyword("DEPENDING"),
                optional(
                  keyword("ON")
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
            keyword("REDEFINES"),
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
            keyword("RENAMES"),
            qualifiedDataName(),
            optional(
              sequence(
                choice(
                  keyword("THROUGH"),
                  keyword("THRU")
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
                keyword("REPORT"),
                optional(
                  keyword("IS")
                )
              ),
              sequence(
                keyword("REPORTS"),
                optional(
                  keyword("ARE")
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
            keyword("TYPE"),
            optional(
              keyword("IS")
            ),
            choice(
              choice(
                keyword("RH"),
                sequence(
                  keyword("REPORT"),
                  keyword("HEADING")
                )
              ),
              choice(
                keyword("PH"),
                sequence(
                  keyword("PAGE"),
                  keyword("HEADING")
                )
              ),
              sequence(
                choice(
                  keyword("CH"),
                  sequence(
                    keyword("CONTROL"),
                    keyword("HEADING")
                  )
                ),
                optional(
                  choice(
                    keyword("ON"),
                    keyword("FOR")
                  )
                ),
                choice(
                  keyword("FINAL"),
                  dataName()
                )
              ),
              choice(
                keyword("DE"),
                keyword("DETAIL")
              ),
              sequence(
                choice(
                  keyword("CF"),
                  sequence(
                    keyword("CONTROL"),
                    keyword("FOOTING")
                  )
                ),
                optional(
                  choice(
                    keyword("ON"),
                    keyword("FOR")
                  )
                ),
                choice(
                  keyword("FINAL"),
                  dataName()
                )
              ),
              choice(
                keyword("PF"),
                sequence(
                  keyword("PAGE"),
                  keyword("FOOTING")
                )
              ),
              choice(
                keyword("RF"),
                sequence(
                  keyword("REPORT"),
                  keyword("FOOTING")
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
            keyword("USAGE"),
            optional(
              keyword("IS")
            ),
            choice(
              keyword("DISPLAY"),
              keyword("DISPLAY-1")
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
                keyword("VALUE"),
                optional(
                  keyword("IS")
                )
              ),
              sequence(
                keyword("VALUES"),
                optional(
                  keyword("ARE")
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
          keyword("REVERSE-VIDEO")
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
          keyword("REQUIRED")
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
            keyword("SAME"),
            keyword("AS"),
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
            keyword("FROM"),
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
            keyword("TO"),
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
            keyword("USING"),
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
            keyword("VALUE"),
            optional(
              keyword("IS")
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
          keyword("SECURE")
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
            keyword("SELECT"),
            keyword("WHEN"),
            choice(
              keyword("OTHER"),
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
                keyword("SIGN"),
                optional(
                  keyword("IS")
                )
              )
            ),
            choice(
              as("leading",
                keyword("LEADING")
              ),
              as("trailing",
                keyword("TRAILING")
              )
            ),
            optional(
              as("separate",
                sequence(
                  keyword("SEPARATE"),
                  optional(
                    keyword("CHARACTER")
                  )
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
                keyword("SOURCE"),
                optional(
                  keyword("IS")
                )
              ),
              sequence(
                keyword("SOURCES"),
                optional(
                  keyword("ARE")
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
                as("expression",
                  arithmeticExpression()
                ),
                as("expression",
                  alphanumericLiteral()
                )
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
                keyword("SUM"),
                optional(
                  keyword("OF")
                ),
                plus(
                  sequence(
                    not(
                      keyword("UPON")
                    ),
                    identifier()
                  )
                ),
                optional(
                  sequence(
                    keyword("UPON"),
                    plus(
                      dataName()
                    )
                  )
                )
              )
            ),
            optional(
              sequence(
                keyword("RESET"),
                optional(
                  keyword("ON")
                ),
                choice(
                  keyword("FINAL"),
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
              keyword("SYNCHRONIZED"),
              keyword("SYNC")
            ),
            optional(
              choice(
                keyword("LEFT"),
                keyword("RIGHT")
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
              keyword("IS")
            ),
            keyword("TYPEDEF"),
            optional(
              keyword("STRONG")
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
            keyword("TYPE"),
            optional(
              keyword("TO")
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
          keyword("UNDERLINE")
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
                keyword("USAGE"),
                optional(
                  keyword("IS")
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
            keyword("BINARY"),
            keyword("BINARY-C-LONG"),
            sequence(
              keyword("BINARY-CHAR"),
              optional(
                choice(
                  keyword("SIGNED"),
                  keyword("UNSIGNED")
                )
              )
            ),
            sequence(
              keyword("BINARY-DOUBLE"),
              optional(
                choice(
                  keyword("SIGNED"),
                  keyword("UNSIGNED")
                )
              )
            ),
            sequence(
              keyword("BINARY-LONG"),
              optional(
                choice(
                  keyword("SIGNED"),
                  keyword("UNSIGNED")
                )
              )
            ),
            sequence(
              keyword("BINARY-SHORT"),
              optional(
                choice(
                  keyword("SIGNED"),
                  keyword("UNSIGNED")
                )
              )
            ),
            keyword("BIT"),
            keyword("CHARACTER"),
            keyword("COMPUTATIONAL"),
            keyword("COMP"),
            keyword("COMPUTATIONAL-1"),
            keyword("COMPUTATIONAL-2"),
            keyword("COMPUTATIONAL-3"),
            keyword("COMPUTATIONAL-4"),
            keyword("COMPUTATIONAL-5"),
            keyword("COMPUTATIONAL-6"),
            keyword("COMP-1"),
            keyword("COMP-2"),
            keyword("COMP-3"),
            keyword("COMP-4"),
            keyword("COMP-5"),
            keyword("COMP-6"),
            keyword("COMPUTATIONAL-X"),
            keyword("COMP-X"),
            keyword("COMPUTATIONAL-N"),
            keyword("COMP-N"),
            keyword("CONDITION-VALUE"),
            keyword("DECIMAL"),
            keyword("DISPLAY"),
            keyword("DISPLAY-1"),
            keyword("DOUBLE"),
            keyword("INDEX"),
            keyword("FLOAT"),
            keyword("FLOAT-EXTENDED"),
            keyword("FLOAT-LONG"),
            keyword("FLOAT-SHORT"),
            sequence(
              keyword("HANDLE"),
              optional(
                sequence(
                  optional(
                    keyword("OF")
                  ),
                  choice(
                    keyword("WINDOW"),
                    keyword("SUBWINDOW"),
                    sequence(
                      keyword("FONT"),
                      optional(
                        justAName()
                      )
                    ),
                    keyword("THREAD"),
                    keyword("MENU"),
                    keyword("VARIANT"),
                    sequence(
                      keyword("LAYOUT-MANAGER"),
                      optional(
                        justAName()
                      )
                    )
                  )
                )
              )
            ),
            keyword("MONITOR-POINTER"),
            keyword("MUTEX-POINTER"),
            keyword("NATIONAL"),
            sequence(
              keyword("OBJECT"),
              keyword("REFERENCE"),
              optional(
                choice(
                  sequence(
                    optional(
                      sequence(
                        keyword("FACTORY"),
                        keyword("OF")
                      )
                    ),
                    keyword("ACTIVE-CLASS")
                  ),
                  sequence(
                    optional(
                      sequence(
                        keyword("FACTORY"),
                        keyword("OF")
                      )
                    ),
                    className(),
                    optional(
                      choice(
                        keyword("ONLY"),
                        keyword("EVENT")
                      )
                    )
                  )
                )
              )
            ),
            keyword("OBJECT"),
            keyword("PACKED-DECIMAL"),
            keyword("POINTER"),
            keyword("PROCEDURE-POINTER"),
            sequence(
              keyword("PROGRAM-POINTER"),
              optional(
                sequence(
                  optional(
                    keyword("TO")
                  ),
                  programName()
                )
              )
            ),
            keyword("SEMAPHORE-POINTER"),
            keyword("SIGNED-INT"),
            keyword("SIGNED-LONG"),
            keyword("SIGNED-SHORT"),
            keyword("THREAD-POINTER"),
            keyword("UNSIGNED-INT"),
            keyword("UNSIGNED-LONG"),
            keyword("UNSIGNED-SHORT"),
            keyword("STRING"),
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
              keyword("VALIDATE-STATUS"),
              keyword("VAL-STATUS")
            ),
            optional(
              keyword("IS")
            ),
            choice(
              literal(),
              identifier()
            ),
            optional(
              keyword("WHEN")
            ),
            optional(
              keyword("NO")
            ),
            keyword("ERROR"),
            optional(
              sequence(
                keyword("ON"),
                permuted(
                  keyword("FORMAT"),
                  keyword("CONTENT"),
                  keyword("RELATION")
                )
              )
            ),
            keyword("FOR"),
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
            keyword("VARYING"),
            plus(
              sequence(
                dataName(),
                optional(
                  sequence(
                    keyword("FROM"),
                    arithmeticExpression()
                  )
                ),
                optional(
                  sequence(
                    keyword("BY"),
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
            keyword("PROCEDURE"),
            keyword("DIVISION"),
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
              keyword("USING"),
              keyword("CHAINING"),
              keyword("GIVING")
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
                  keyword("BY")
                ),
                keyword("REFERENCE")
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
              keyword("BY")
            ),
            keyword("VALUE"),
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
              keyword("BY")
            ),
            keyword("OUTPUT"),
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
              keyword("UNSIGNED")
            ),
            optional(
              procedureDivision$header$using$arg$sizeIs()
            ),
            optional(
              as("optional",
                keyword("OPTIONAL")
              )
            ),
            procedureDivision$header$using$arg$value(),
            optional(
              sequence(
                keyword("DELIMITED"),
                optional(
                  sequence(
                    keyword("BY"),
                    keyword("SIZE")
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
              keyword("ANY")
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
            keyword("SIZE"),
            optional(
              keyword("IS")
            ),
            choice(
              keyword("AUTO"),
              keyword("DEFAULT"),
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
            keyword("REPEATED"),
            optional(
              sequence(
                integer(),
                keyword("TO"),
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
            keyword("AS"),
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
              keyword("RETURNING"),
              keyword("YIELDING"),
              keyword("GIVING")
            ),
            dataName(),
            optional(
              sequence(
                keyword("AS"),
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
            keyword("ROUNDED"),
            optional(
              sequence(
                keyword("MODE"),
                optional(
                  keyword("IS")
                ),
                choice(
                  keyword("AWAY-FROM-ZERO"),
                  keyword("NEAREST-AWAY-FROM-ZERO"),
                  keyword("NEAREST-EVEN"),
                  keyword("NEAREST-TOWARD-ZERO"),
                  keyword("PROHIBITED"),
                  keyword("TOWARD-GREATER"),
                  keyword("TOWARD-LESSER"),
                  keyword("TRUNCATION")
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
            keyword("DECLARATIVES"),
            literal("."),
            star(
              declarativeSection()
            ),
            keyword("END"),
            keyword("DECLARATIVES"),
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
            keyword("SECTION"),
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
            keyword("SECTION"),
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
                "VALIDATE",
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
                validateStatement(),
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
              eventPhrase(),
              statement()
            ),
            endOfStatementMarker()
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
              keyword("NOT")
            ),
            optional(
              choice(
                keyword("ON"),
                keyword("AT")
              )
            ),
            eventType()
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
          choice(
            keyword("EXCEPTION"),
            sequence(
              keyword("SIZE"),
              keyword("ERROR")
            ),
            keyword("OVERFLOW"),
            sequence(
              keyword("INVALID"),
              optional(
                keyword("KEY")
              )
            ),
            keyword("END"),
            keyword("END-OF-PAGE"),
            keyword("EOP")
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
            keyword("RETRY"),
            choice(
              sequence(
                choice(
                  identifier(),
                  integer()
                ),
                keyword("TIMES")
              ),
              sequence(
                keyword("FOR"),
                choice(
                  identifier(),
                  integer()
                ),
                keyword("SECONDS")
              ),
              keyword("FOREVER")
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
          choice(
            keyword("END-ACCEPT"),
            keyword("END-ADD"),
            keyword("END-CALL"),
            keyword("END-CHAIN"),
            keyword("END-COMPUTE"),
            keyword("END-DELETE"),
            keyword("END-DIVIDE"),
            keyword("END-EVALUATE"),
            keyword("END-EXEC"),
            keyword("END-IF"),
            keyword("END-MULTIPLY"),
            keyword("END-PERFORM"),
            keyword("END-READ"),
            keyword("END-RETURN"),
            keyword("END-REWRITE"),
            keyword("END-SEARCH"),
            keyword("END-START"),
            keyword("END-STRING"),
            keyword("END-SUBTRACT"),
            keyword("END-UNSTRING"),
            keyword("END-WAIT"),
            keyword("END-WRITE")
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
            keyword("COPY"),
            keyword("ELSE"),
            keyword("WHEN"),
            keyword("END-ACCEPT"),
            keyword("END-ADD"),
            keyword("END-CALL"),
            keyword("END-CHAIN"),
            keyword("END-COMPUTE"),
            keyword("END-DELETE"),
            keyword("END-DISPLAY"),
            keyword("END-DIVIDE"),
            keyword("END-EVALUATE"),
            keyword("END-EXEC"),
            keyword("END-IF"),
            keyword("END-MULTIPLY"),
            keyword("END-PERFORM"),
            keyword("END-READ"),
            keyword("END-RECEIVE"),
            keyword("END-RETURN"),
            keyword("END-REWRITE"),
            keyword("END-SEARCH"),
            keyword("END-START"),
            keyword("END-STRING"),
            keyword("END-SUBTRACT"),
            keyword("END-UNSTRING"),
            keyword("END-WAIT"),
            keyword("END-WRITE"),
            keyword("END-XML"),
            sequence(
              optional(
                keyword("NOT")
              ),
              keyword("INVALID")
            ),
            sequence(
              optional(
                keyword("NOT")
              ),
              optional(
                keyword("ON")
              ),
              keyword("SIZE")
            ),
            sequence(
              optional(
                keyword("NOT")
              ),
              optional(
                keyword("ON")
              ),
              keyword("OVERFLOW")
            ),
            sequence(
              optional(
                keyword("NOT")
              ),
              optional(
                keyword("ON")
              ),
              keyword("EXCEPTION")
            ),
            sequence(
              optional(
                keyword("NOT")
              ),
              optional(
                keyword("AT")
              ),
              keyword("END")
            ),
            sequence(
              optional(
                keyword("NOT")
              ),
              optional(
                keyword("AT")
              ),
              keyword("END-OF-PAGE")
            ),
            sequence(
              optional(
                keyword("NOT")
              ),
              optional(
                keyword("AT")
              ),
              keyword("EOP")
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
            keyword("ADD"),
            keyword("ALTER"),
            keyword("CALL"),
            keyword("CANCEL"),
            keyword("CHAIN"),
            keyword("CLOSE"),
            keyword("COMMIT"),
            keyword("CONTINUE"),
            keyword("DELETE"),
            keyword("DIVIDE"),
            keyword("EJECT"),
            keyword("ENTRY"),
            keyword("EVALUATE"),
            keyword("EXEC"),
            keyword("EXIT"),
            keyword("GENERATE"),
            keyword("GOBACK"),
            keyword("GO"),
            keyword("IDENTIFIED"),
            keyword("IF"),
            keyword("INITIATE"),
            keyword("INVOKE"),
            keyword("MERGE"),
            keyword("MOVE"),
            keyword("MULTIPLY"),
            sequence(
              keyword("NEXT"),
              keyword("SENTENCE")
            ),
            keyword("OPEN"),
            keyword("PERFORM"),
            keyword("RAISE"),
            keyword("READ"),
            sequence(
              keyword("READY"),
              keyword("TRACE")
            ),
            keyword("RELEASE"),
            keyword("REPLACE"),
            sequence(
              keyword("RESET"),
              keyword("TRACE")
            ),
            keyword("RETURN"),
            keyword("REWRITE"),
            keyword("ROLLBACK"),
            keyword("SEARCH"),
            keyword("SERVICE"),
            keyword("SET"),
            keyword("SKIP1"),
            keyword("SKIP2"),
            keyword("SKIP3"),
            keyword("SORT"),
            keyword("STOP"),
            keyword("STRING"),
            keyword("SUBTRACT"),
            keyword("SUPPRESS"),
            keyword("TERMINATE"),
            keyword("TITLE"),
            keyword("UNSTRING"),
            keyword("VALIDATE"),
            keyword("WAIT"),
            keyword("WRITE"),
            sequence(
              keyword("XML"),
              keyword("GENERATE")
            ),
            sequence(
              keyword("XML"),
              keyword("PARSE")
            ),
            keyword("SET"),
            keyword("INITIALIZE"),
            keyword("DISPLAY"),
            keyword("COMPUTE"),
            keyword("INSPECT"),
            keyword("ACCEPT"),
            keyword("ALLOCATE"),
            keyword("FREE"),
            keyword("XML"),
            keyword("ENABLE"),
            keyword("DISABLE"),
            keyword("SEND"),
            keyword("RECEIVE"),
            keyword("PURGE"),
            keyword("START"),
            keyword("USE")
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
            keyword("ACCEPT"),
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
              as("end",
                keyword("END-ACCEPT")
              )
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
            keyword("FROM"),
            mnemonicName(),
            optional(
              permuted(
                onException(),
                notOnException(),
                onEscape(),
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
            keyword("FROM"),
            choice(
              keyword("TERMINAL-INFO"),
              keyword("SYSTEM-INFO"),
              sequence(
                keyword("INPUT"),
                keyword("STATUS")
              ),
              sequence(
                keyword("ESCAPE"),
                keyword("KEY")
              ),
              sequence(
                keyword("EXCEPTION"),
                keyword("STATUS")
              ),
              sequence(
                keyword("LINE"),
                keyword("NUMBER")
              ),
              sequence(
                keyword("USER"),
                keyword("NAME")
              ),
              keyword("COMMAND-LINE"),
              sequence(
                keyword("STANDARD"),
                keyword("OBJECT"),
                identifier()
              ),
              sequence(
                keyword("THREAD"),
                keyword("HANDLE")
              ),
              sequence(
                keyword("WINDOW"),
                keyword("HANDLE")
              ),
              sequence(
                keyword("ENVIRONMENT"),
                choice(
                  identifier(),
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
              keyword("OMITTED"),
              sequence(
                optional(
                  positionSpecification()
                ),
                identifier()
              )
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
                keyword("FROM"),
                keyword("CRT")
              )
            ),
            optional(
              modeIsBlockPhrase()
            ),
            optional(
              sequence(
                optional(
                  keyword("WITH")
                ),
                plus(
                  screenEntryPhrase()
                )
              )
            ),
            optional(
              permuted(
                onException(),
                notOnException(),
                onEscape(),
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
            keyword("FROM"),
            choice(
              sequence(
                keyword("DATE"),
                optional(
                  choice(
                    keyword("YYYYMMDD"),
                    keyword("CENTURY-DATE")
                  )
                )
              ),
              sequence(
                keyword("DAY"),
                optional(
                  choice(
                    keyword("YYYYDDD"),
                    keyword("CENTURY-DAY")
                  )
                )
              ),
              keyword("DAY-OF-WEEK"),
              keyword("TIME"),
              keyword("YEAR"),
              keyword("YYYYMMDD"),
              keyword("CENTURY-DATE"),
              keyword("YYYYDDD"),
              keyword("CENTURY-DAY")
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
              keyword("MESSAGE")
            ),
            keyword("COUNT")
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
            keyword("UNIT"),
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
            keyword("MODE"),
            optional(
              keyword("IS")
            ),
            keyword("BLOCK")
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
            keyword("FROM"),
            choice(
              keyword("LINES"),
              keyword("COLUMNS")
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
            keyword("FROM"),
            choice(
              keyword("COMMAND-LINE"),
              keyword("ARGUMENT-NUMBER"),
              keyword("ARGUMENT-VALUE")
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
            keyword("ADD"),
            choice(
              addStatement$format1(),
              addStatement$format2(),
              addStatement$format3()
            ),
            optional(
              permuted(
                onSizeError(),
                notOnSizeError()
              )
            ),
            optional(
              as("end",
                keyword("END-ADD")
              )
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
                  keyword("CORRESPONDING"),
                  keyword("CORR")
                ),
                as("identifier",
                  qualifiedDataName()
                )
              )
            ),
            as("to",
              sequence(
                keyword("TO"),
                qualifiedDataName(),
                optional(
                  keyword("ROUNDED")
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
                keyword("CORRESPONDING"),
                keyword("CORR")
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
                  keyword("TO"),
                  choice(
                    identifier(),
                    literal()
                  )
                )
              )
            ),
            as("giving",
              sequence(
                keyword("GIVING"),
                plus(
                  sequence(
                    identifier(),
                    optional(
                      keyword("ROUNDED")
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
                keyword("CORRESPONDING"),
                keyword("CORR")
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
                keyword("TO"),
                plus(
                  sequence(
                    identifier(),
                    optional(
                      keyword("ROUNDED")
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
            keyword("ALLOCATE"),
            choice(
              sequence(
                arithmeticExpression(),
                keyword("CHARACTERS")
              ),
              qualifiedDataName()
            ),
            optional(
              keyword("INITIALIZED")
            ),
            optional(
              sequence(
                keyword("RETURNING"),
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
            keyword("ALTER"),
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
            keyword("TO"),
            optional(
              sequence(
                keyword("PROCEED"),
                keyword("TO")
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
            keyword("CALL"),
            choice(
              sequence(
                optional(
                  sequence(
                    callStatement$programName(),
                    keyword("AS")
                  )
                ),
                keyword("NESTED")
              ),
              sequence(
                callStatement$programName(),
                keyword("AS"),
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
              as("end",
                keyword("END-CALL")
              )
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
            alphanumericLiteral(),
            identifier()
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
          justAName()
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
            keyword("USING"),
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
                  keyword("BY")
                ),
                keyword("REFERENCE")
              )
            ),
            plus(
              choice(
                callStatement$using$modifier(),
                callStatement$using$arg()
              )
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
              keyword("BY")
            ),
            keyword("CONTENT"),
            plus(
              choice(
                callStatement$using$modifier(),
                callStatement$using$arg()
              )
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
              keyword("BY")
            ),
            keyword("VALUE"),
            plus(
              choice(
                callStatement$using$modifier(),
                callStatement$using$arg()
              )
            )
          )
        );
      }
    
      return callStatement$using$byValueParser;
    }
    
    // ========================================================
    // modifier
    // ........................................................
    
    private ParserCombinator callStatement$using$modifierParser = null;
    
    public final Start callStatement$using$modifier = Start.on(getNamespace(), "modifier");
    
    public ParserCombinator callStatement$using$modifier() {
      if (callStatement$using$modifierParser == null) {
        FutureParser future = scoped("modifier", PUBLIC, true);
        callStatement$using$modifierParser = future;
        future.setParser(
          choice(
            as("unsigned",
              keyword("UNSIGNED")
            ),
            callStatement$using$modifier$sizeIs()
          )
        );
      }
    
      return callStatement$using$modifierParser;
    }
    
    // ========================================================
    // sizeIs
    // ........................................................
    
    private ParserCombinator callStatement$using$modifier$sizeIsParser = null;
    
    public final Start callStatement$using$modifier$sizeIs = Start.on(getNamespace(), "sizeIs");
    
    public ParserCombinator callStatement$using$modifier$sizeIs() {
      if (callStatement$using$modifier$sizeIsParser == null) {
        FutureParser future = scoped("sizeIs", PUBLIC, true);
        callStatement$using$modifier$sizeIsParser = future;
        future.setParser(
          sequence(
            keyword("SIZE"),
            optional(
              keyword("IS")
            ),
            choice(
              keyword("AUTO"),
              keyword("DEFAULT"),
              integer()
            )
          )
        );
      }
    
      return callStatement$using$modifier$sizeIsParser;
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
          choice(
            addressOf(),
            lengthOf(),
            as("omitted",
              keyword("OMITTED")
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
    
      return callStatement$using$argParser;
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
              keyword("GIVING"),
              keyword("RETURNING")
            ),
            choice(
              addressOf(),
              sequence(
                optional(
                  keyword("INTO")
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
            keyword("CANCEL"),
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
            keyword("CHAIN"),
            choice(
              identifier(),
              literal()
            ),
            optional(
              chainUsing()
            ),
            optional(
              as("end",
                keyword("END-CHAIN")
              )
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
            keyword("USING"),
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
                    keyword("BY")
                  ),
                  keyword("REFERENCE"),
                  plus(
                    choice(
                      addressOf(),
                      identifier(),
                      keyword("OMITTED"),
                      literal()
                    )
                  )
                ),
                sequence(
                  optional(
                    keyword("BY")
                  ),
                  keyword("CONTENT"),
                  plus(
                    choice(
                      literal(),
                      identifier()
                    )
                  )
                ),
                sequence(
                  optional(
                    keyword("BY")
                  ),
                  keyword("VALUE"),
                  plus(
                    choice(
                      identifier(),
                      sequence(
                        integer(),
                        optional(
                          sequence(
                            keyword("SIZE"),
                            optional(
                              keyword("IS")
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
            keyword("CLOSE"),
            plus(
              sequence(
                fileName(),
                optional(
                  choice(
                    sequence(
                      optional(
                        keyword("WITH")
                      ),
                      choice(
                        sequence(
                          keyword("NO"),
                          keyword("REWIND")
                        ),
                        keyword("LOCK")
                      )
                    ),
                    sequence(
                      choice(
                        keyword("REEL"),
                        keyword("UNIT")
                      ),
                      optional(
                        sequence(
                          optional(
                            keyword("FOR")
                          ),
                          keyword("REMOVAL")
                        )
                      )
                    ),
                    sequence(
                      optional(
                        keyword("FOR")
                      ),
                      keyword("REMOVAL")
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
            keyword("COMMIT"),
            optional(
              keyword("TRANSACTION")
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
            keyword("COMPUTE"),
            plus(
              sequence(
                qualifiedDataName(),
                optional(
                  keyword("ROUNDED")
                )
              )
            ),
            choice(
              literal("="),
              keyword("EQUAL")
            ),
            arithmeticExpression(),
            optional(
              permuted(
                onSizeError(),
                notOnSizeError()
              )
            ),
            optional(
              as("end",
                keyword("END-COMPUTE")
              )
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
          keyword("CONTINUE")
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
            keyword("DELETE"),
            fileName(),
            optional(
              keyword("RECORD")
            ),
            optional(
              retryPhrase()
            ),
            optional(
              permuted(
                invalidKey(),
                notInvalidKey()
              )
            ),
            optional(
              as("end",
                keyword("END-DELETE")
              )
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
            keyword("INVALID"),
            optional(
              keyword("KEY")
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
            keyword("NOT"),
            keyword("INVALID"),
            optional(
              keyword("KEY")
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
            keyword("DELETE"),
            keyword("FILE"),
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
            keyword("DISABLE"),
            choice(
              sequence(
                keyword("INPUT"),
                optional(
                  keyword("TERMINAL")
                )
              ),
              sequence(
                keyword("I-O"),
                keyword("TERMINAL")
              ),
              keyword("OUTPUT")
            ),
            cdName(),
            optional(
              keyword("WITH")
            ),
            keyword("KEY"),
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
            keyword("DISPLAY"),
            plus(
              sequence(
                optional(
                  positionSpecification()
                ),
                choice(
                  keyword("ERASE"),
                  keyword("OMITTED"),
                  identifier(),
                  literal()
                ),
                star(
                  choice(
                    uponClause(),
                    withNoAdvancing(),
                    sequence(
                      keyword("UNIT"),
                      choice(
                        identifier(),
                        literal()
                      )
                    ),
                    dtAtPositioning(),
                    dtLineColPositioning(),
                    modeIsBlockPhrase(),
                    sequence(
                      optional(
                        keyword("WITH")
                      ),
                      plus(
                        screenEntryPhrase()
                      )
                    )
                  )
                )
              )
            ),
            optional(
              permuted(
                onException(),
                notOnException()
              )
            ),
            optional(
              as("end",
                keyword("END-DISPLAY")
              )
            )
          )
        );
      }
    
      return displayStatementParser;
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
              permuted(
                onException(),
                notOnException()
              )
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
            keyword("UPON"),
            choice(
              keyword("ARGUMENT-NUMBER"),
              keyword("COMMAND-LINE"),
              keyword("ENVIRONMENT-VALUE"),
              keyword("ENVIRONMENT-NAME"),
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
              keyword("WITH")
            ),
            keyword("NO"),
            keyword("ADVANCING")
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
                keyword("OMITTED"),
                identifier(),
                literal()
              ),
              optional(
                sequence(
                  keyword("UNIT"),
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
                    keyword("WITH")
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
            keyword("AT"),
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
            optional(
              choice(
                keyword("AT"),
                keyword("FROM")
              )
            ),
            keyword("LINE"),
            optional(
              keyword("NUMBER")
            ),
            optional(
              keyword("IS")
            ),
            optional(
              choice(
                keyword("PLUS"),
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
            optional(
              choice(
                keyword("AT"),
                keyword("FROM")
              )
            ),
            choice(
              keyword("COL"),
              keyword("COLUMN"),
              keyword("POSITION"),
              keyword("POS")
            ),
            optional(
              keyword("NUMBER")
            ),
            optional(
              keyword("IS")
            ),
            optional(
              choice(
                keyword("PLUS"),
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
            noAdvancing(),
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
            keyword("AUTO"),
            keyword("AUTO-SKIP")
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
              keyword("BACKGROUND-COLOR"),
              keyword("BACKGROUND-COLOUR")
            ),
            optional(
              keyword("IS")
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
              keyword("NO")
            ),
            choice(
              keyword("BEEP"),
              keyword("BELL")
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
            keyword("BLANK"),
            optional(
              choice(
                keyword("LINE"),
                keyword("SCREEN"),
                keyword("EOL"),
                keyword("EOS"),
                sequence(
                  optional(
                    keyword("TO")
                  ),
                  keyword("END"),
                  optional(
                    keyword("OF")
                  ),
                  choice(
                    keyword("LINE"),
                    keyword("SCREEN")
                  )
                )
              )
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
            keyword("BLINKING"),
            keyword("BLINK")
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
          keyword("BOLD")
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
            keyword("UPPER"),
            keyword("LOWER")
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
            keyword("CONTROL"),
            optional(
              keyword("IS")
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
            keyword("CONVERT"),
            keyword("CONVERSION")
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
            keyword("CURSOR"),
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
          keyword("ECHO")
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
            keyword("ERASE"),
            optional(
              choice(
                keyword("LINE"),
                keyword("SCREEN"),
                keyword("EOL"),
                keyword("EOS"),
                sequence(
                  optional(
                    keyword("TO")
                  ),
                  keyword("END"),
                  optional(
                    keyword("OF")
                  ),
                  choice(
                    keyword("LINE"),
                    keyword("SCREEN")
                  )
                )
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
              keyword("FOREGROUND-COLOR"),
              keyword("FOREGROUND-COLOUR")
            ),
            optional(
              keyword("IS")
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
            keyword("FULL"),
            keyword("LENGTH-CHECK")
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
          keyword("GRID")
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
            keyword("HIGH"),
            keyword("HIGHLIGHT")
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
            keyword("LEFTLINE"),
            keyword("OVERLINE"),
            keyword("UNDERLINE")
          )
        );
      }
    
      return linePhraseParser;
    }
    
    // ========================================================
    // noAdvancing
    // ........................................................
    
    private ParserCombinator noAdvancingParser = null;
    
    public final Start noAdvancing = Start.on(getNamespace(), "noAdvancing");
    
    public ParserCombinator noAdvancing() {
      if (noAdvancingParser == null) {
        FutureParser future = scoped("noAdvancing", PUBLIC, true);
        noAdvancingParser = future;
        future.setParser(
          sequence(
            keyword("NO"),
            keyword("ADVANCING")
          )
        );
      }
    
      return noAdvancingParser;
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
            keyword("LOW"),
            keyword("LOWLIGHT")
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
          keyword("OFF")
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
            keyword("PROMPT"),
            optional(
              choice(
                sequence(
                  keyword("CHARACTER"),
                  optional(
                    keyword("IS")
                  ),
                  identifier()
                ),
                sequence(
                  optional(
                    keyword("CHARACTER")
                  ),
                  optional(
                    keyword("IS")
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
            keyword("REQUIRED"),
            keyword("EMPTY-CHECK")
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
            keyword("REVERSE"),
            keyword("REVERSED"),
            keyword("REVERSE-VIDEO")
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
            keyword("SCROLL"),
            choice(
              keyword("UP"),
              keyword("DOWN")
            ),
            optional(
              sequence(
                optional(
                  keyword("BY")
                ),
                choice(
                  integer(),
                  identifier()
                ),
                choice(
                  keyword("LINE"),
                  keyword("LINES")
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
            keyword("SECURE"),
            keyword("NO-ECHO")
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
            keyword("SIZE"),
            optional(
              keyword("IS")
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
          keyword("STANDARD")
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
          keyword("TAB")
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
              keyword("BEFORE")
            ),
            keyword("TIME"),
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
              keyword("TIME-OUT"),
              keyword("TIMEOUT")
            ),
            keyword("AFTER"),
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
            keyword("LEFT-JUSTIFY"),
            keyword("RIGHT-JUSTIFY")
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
            keyword("SPACE-FILL"),
            keyword("ZERO-FILL")
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
          keyword("TRAILING-SIGN")
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
          keyword("UPDATE")
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
            keyword("DIVIDE"),
            choice(
              divideStatement$format1(),
              divideStatement$format2(),
              divideStatement$format3()
            ),
            optional(
              permuted(
                onSizeError(),
                notOnSizeError()
              )
            ),
            optional(
              as("end",
                keyword("END-DIVIDE")
              )
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
                  keyword("INTO"),
                  keyword("BY")
                ),
                choice(
                  identifier(),
                  literal()
                )
              )
            ),
            as("giving",
              sequence(
                keyword("GIVING"),
                as("identifier",
                  qualifiedDataName()
                ),
                optional(
                  keyword("ROUNDED")
                )
              )
            ),
            as("remainder",
              sequence(
                keyword("REMAINDER"),
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
                  keyword("INTO"),
                  keyword("BY")
                ),
                choice(
                  identifier(),
                  literal()
                )
              )
            ),
            as("giving",
              sequence(
                keyword("GIVING"),
                plus(
                  sequence(
                    as("identifier",
                      qualifiedDataName()
                    ),
                    optional(
                      keyword("ROUNDED")
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
                keyword("INTO"),
                plus(
                  sequence(
                    qualifiedDataName(),
                    optional(
                      keyword("ROUNDED")
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
            keyword("ENABLE"),
            choice(
              sequence(
                keyword("INPUT"),
                optional(
                  keyword("TERMINAL")
                )
              ),
              sequence(
                keyword("I-O"),
                keyword("TERMINAL")
              ),
              keyword("OUTPUT")
            ),
            cdName(),
            optional(
              keyword("WITH")
            ),
            keyword("KEY"),
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
            keyword("ENTRY"),
            literal(),
            optional(
              mnemonicName()
            ),
            optional(
              sequence(
                keyword("USING"),
                plus(
                  sequence(
                    optional(
                      choice(
                        entryStatement$byReference(),
                        entryStatement$byValue(),
                        entryStatement$byContent()
                      )
                    ),
                    choice(
                      keyword("ANY"),
                      sequence(
                        dataName(),
                        optional(
                          sequence(
                            keyword("DELIMITED"),
                            optional(
                              sequence(
                                keyword("BY"),
                                keyword("SIZE")
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
                    keyword("REPEATED"),
                    optional(
                      sequence(
                        integer(),
                        keyword("TO"),
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
                  keyword("GIVING"),
                  keyword("RETURNING")
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
    // byReference
    // ........................................................
    
    private ParserCombinator entryStatement$byReferenceParser = null;
    
    public final Start entryStatement$byReference = Start.on(getNamespace(), "byReference");
    
    public ParserCombinator entryStatement$byReference() {
      if (entryStatement$byReferenceParser == null) {
        FutureParser future = scoped("byReference", PUBLIC, true);
        entryStatement$byReferenceParser = future;
        future.setParser(
          sequence(
            optional(
              keyword("BY")
            ),
            keyword("REFERENCE")
          )
        );
      }
    
      return entryStatement$byReferenceParser;
    }
    
    // ========================================================
    // byValue
    // ........................................................
    
    private ParserCombinator entryStatement$byValueParser = null;
    
    public final Start entryStatement$byValue = Start.on(getNamespace(), "byValue");
    
    public ParserCombinator entryStatement$byValue() {
      if (entryStatement$byValueParser == null) {
        FutureParser future = scoped("byValue", PUBLIC, true);
        entryStatement$byValueParser = future;
        future.setParser(
          sequence(
            optional(
              keyword("BY")
            ),
            keyword("VALUE")
          )
        );
      }
    
      return entryStatement$byValueParser;
    }
    
    // ========================================================
    // byContent
    // ........................................................
    
    private ParserCombinator entryStatement$byContentParser = null;
    
    public final Start entryStatement$byContent = Start.on(getNamespace(), "byContent");
    
    public ParserCombinator entryStatement$byContent() {
      if (entryStatement$byContentParser == null) {
        FutureParser future = scoped("byContent", PUBLIC, true);
        entryStatement$byContentParser = future;
        future.setParser(
          sequence(
            optional(
              keyword("BY")
            ),
            keyword("CONTENT")
          )
        );
      }
    
      return entryStatement$byContentParser;
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
            keyword("EVALUATE"),
            subject(),
            star(
              sequence(
                keyword("ALSO"),
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
              as("end",
                keyword("END-EVALUATE")
              )
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
                keyword("ALSO"),
                keyword("WHEN")
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
            keyword("WHEN"),
            not(
              keyword("OTHER")
            ),
            object(),
            star(
              sequence(
                keyword("ALSO"),
                object()
              )
            ),
            optional(
              nestedStatements()
            )
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
            keyword("WHEN"),
            keyword("OTHER"),
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
            keyword("ANY"),
            object$rangeExpression(),
            as("true",
              keyword("TRUE")
            ),
            as("false",
              keyword("FALSE")
            ),
            sequence(
              at(
                relop()
              ),
              abbreviatedDisjunction()
            ),
            abbreviatedSignCondition(),
            condition(),
            sequence(
              optional(
                keyword("NOT")
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
    
    private ParserCombinator object$rangeExpressionParser = null;
    
    public final Start object$rangeExpression = Start.on(getNamespace(), "rangeExpression");
    
    public ParserCombinator object$rangeExpression() {
      if (object$rangeExpressionParser == null) {
        FutureParser future = scoped("rangeExpression", PUBLIC, true);
        object$rangeExpressionParser = future;
        future.setParser(
          sequence(
            optional(
              keyword("NOT")
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
              keyword("THROUGH"),
              keyword("THRU")
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
    
      return object$rangeExpressionParser;
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
            keyword("EXAMINE"),
            identifier(),
            choice(
              sequence(
                keyword("TALLYING"),
                choice(
                  sequence(
                    keyword("UNTIL"),
                    keyword("FIRST")
                  ),
                  keyword("ALL"),
                  keyword("LEADING")
                ),
                literal(),
                optional(
                  sequence(
                    keyword("REPLACING"),
                    keyword("BY"),
                    literal()
                  )
                )
              ),
              sequence(
                keyword("REPLACING"),
                choice(
                  keyword("ALL"),
                  keyword("LEADING"),
                  keyword("FIRST"),
                  sequence(
                    keyword("UNTIL"),
                    keyword("FIRST")
                  )
                ),
                literal(),
                keyword("BY"),
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
              keyword("EXEC"),
              keyword("EXECUTE")
            ),
            keyword("SQL"),
            optional(
              limited(
                sqlGrammar().sqlStatement(),
                // Closure:
                keyword("END-EXEC")
              )
            ),
            optional(
              as("unknown",
                skipto(
                  keyword("END-EXEC")
                )
              )
            ),
            as("end",
              keyword("END-EXEC")
            )
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
              keyword("EXEC"),
              keyword("EXECUTE")
            ),
            keyword("CICS"),
            optional(
              limited(
                cicsGrammar().cicsStatement(),
                // Closure:
                keyword("END-EXEC")
              )
            ),
            optional(
              as("unknown",
                skipto(
                  keyword("END-EXEC")
                )
              )
            ),
            as("end",
              keyword("END-EXEC")
            )
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
              keyword("EXEC"),
              keyword("EXECUTE")
            ),
            keyword("DLI"),
            optional(
              as("unknown",
                skipto(
                  keyword("END-EXEC")
                )
              )
            ),
            as("end",
              keyword("END-EXEC")
            )
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
              keyword("EXEC"),
              keyword("EXECUTE")
            ),
            keyword("HTML"),
            optional(
              as("unknown",
                skipto(
                  keyword("END-EXEC")
                )
              )
            ),
            as("end",
              keyword("END-EXEC")
            )
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
              keyword("EXEC"),
              keyword("EXECUTE")
            ),
            textName(),
            optional(
              as("unknown",
                skipto(
                  keyword("END-EXEC")
                )
              )
            ),
            as("end",
              keyword("END-EXEC")
            )
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
            keyword("EXIT"),
            optional(
              as("endpoint",
                choice(
                  keyword("PROGRAM"),
                  keyword("PARAGRAPH"),
                  keyword("SECTION"),
                  sequence(
                    keyword("PERFORM"),
                    optional(
                      keyword("CYCLE")
                    )
                  ),
                  keyword("METHOD"),
                  keyword("FUNCTION"),
                  keyword("ITERATOR")
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
              keyword("GIVING"),
              keyword("RETURNING")
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
            keyword("GENERATE"),
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
            keyword("FREE"),
            plus(
              sequence(
                optional(
                  sequence(
                    keyword("ADDRESS"),
                    optional(
                      keyword("OF")
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
            keyword("GOBACK"),
            optional(
              sequence(
                choice(
                  keyword("GIVING"),
                  keyword("RETURNING")
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
            keyword("GO"),
            optional(
              keyword("TO")
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
            keyword("DEPENDING"),
            optional(
              keyword("ON")
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
            keyword("IF"),
            condition(),
            thenBranch(),
            optional(
              elseBranch()
            ),
            optional(
              as("end",
                keyword("END-IF")
              )
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
              keyword("THEN")
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
            keyword("ELSE"),
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
            keyword("INITIATE"),
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
            keyword("INVOKE"),
            identifier(),
            optional(
              sequence(
                keyword("AS"),
                choice(
                  keyword("OBJECT"),
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
                keyword("USING"),
                plus(
                  choice(
                    sequence(
                      optional(
                        sequence(
                          optional(
                            keyword("BY")
                          ),
                          keyword("REFERENCE")
                        )
                      ),
                      choice(
                        addressOf(),
                        keyword("OMITTED"),
                        literal(),
                        identifier()
                      )
                    ),
                    sequence(
                      optional(
                        keyword("BY")
                      ),
                      keyword("CONTENT"),
                      choice(
                        sequence(
                          keyword("LENGTH"),
                          keyword("OF"),
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
                        keyword("BY")
                      ),
                      keyword("VALUE"),
                      choice(
                        sequence(
                          keyword("LENGTH"),
                          keyword("OF"),
                          identifier()
                        ),
                        sequence(
                          integer(),
                          keyword("SIZE"),
                          optional(
                            keyword("IS")
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
                  keyword("GIVING"),
                  keyword("RETURNING")
                ),
                choice(
                  addressOf(),
                  sequence(
                    optional(
                      keyword("INTO")
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
            keyword("EXHIBIT"),
            choice(
              keyword("NAMED"),
              sequence(
                keyword("CHANGED"),
                keyword("NAMED")
              ),
              keyword("CHANGED")
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
            keyword("IDENTIFIED"),
            optional(
              keyword("BY")
            ),
            choice(
              dataName(),
              literal()
            ),
            optional(
              sequence(
                optional(
                  keyword("IS")
                ),
                keyword("ATTRIBUTE")
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
            keyword("INITIALIZE"),
            plus(
              identifier()
            ),
            optional(
              initializeStatement$withFiller()
            ),
            optional(
              initializeStatement$toValue()
            ),
            optional(
              initializeStatement$replacing()
            ),
            optional(
              initializeStatement$toDefault()
            )
          )
        );
      }
    
      return initializeStatementParser;
    }
    
    // ========================================================
    // withFiller
    // ........................................................
    
    private ParserCombinator initializeStatement$withFillerParser = null;
    
    public final Start initializeStatement$withFiller = Start.on(getNamespace(), "withFiller");
    
    public ParserCombinator initializeStatement$withFiller() {
      if (initializeStatement$withFillerParser == null) {
        FutureParser future = scoped("withFiller", PUBLIC, true);
        initializeStatement$withFillerParser = future;
        future.setParser(
          sequence(
            optional(
              keyword("WITH")
            ),
            keyword("FILLER")
          )
        );
      }
    
      return initializeStatement$withFillerParser;
    }
    
    // ========================================================
    // toValue
    // ........................................................
    
    private ParserCombinator initializeStatement$toValueParser = null;
    
    public final Start initializeStatement$toValue = Start.on(getNamespace(), "toValue");
    
    public ParserCombinator initializeStatement$toValue() {
      if (initializeStatement$toValueParser == null) {
        FutureParser future = scoped("toValue", PUBLIC, true);
        initializeStatement$toValueParser = future;
        future.setParser(
          sequence(
            choice(
              as("categoryName",
                keyword("ALL")
              ),
              initializeStatement$categoryName()
            ),
            optional(
              keyword("TO")
            ),
            keyword("VALUE")
          )
        );
      }
    
      return initializeStatement$toValueParser;
    }
    
    // ========================================================
    // replacing
    // ........................................................
    
    private ParserCombinator initializeStatement$replacingParser = null;
    
    public final Start initializeStatement$replacing = Start.on(getNamespace(), "replacing");
    
    public ParserCombinator initializeStatement$replacing() {
      if (initializeStatement$replacingParser == null) {
        FutureParser future = scoped("replacing", PUBLIC, true);
        initializeStatement$replacingParser = future;
        future.setParser(
          sequence(
            optional(
              keyword("THEN")
            ),
            keyword("REPLACING"),
            plus(
              as("entry",
                sequence(
                  initializeStatement$categoryName(),
                  optional(
                    keyword("DATA")
                  ),
                  keyword("BY"),
                  choice(
                    identifier(),
                    literal()
                  )
                )
              )
            )
          )
        );
      }
    
      return initializeStatement$replacingParser;
    }
    
    // ========================================================
    // toDefault
    // ........................................................
    
    private ParserCombinator initializeStatement$toDefaultParser = null;
    
    public final Start initializeStatement$toDefault = Start.on(getNamespace(), "toDefault");
    
    public ParserCombinator initializeStatement$toDefault() {
      if (initializeStatement$toDefaultParser == null) {
        FutureParser future = scoped("toDefault", PUBLIC, true);
        initializeStatement$toDefaultParser = future;
        future.setParser(
          sequence(
            optional(
              keyword("THEN")
            ),
            optional(
              keyword("TO")
            ),
            keyword("DEFAULT")
          )
        );
      }
    
      return initializeStatement$toDefaultParser;
    }
    
    // ========================================================
    // categoryName
    // ........................................................
    
    private ParserCombinator initializeStatement$categoryNameParser = null;
    
    public final Start initializeStatement$categoryName = Start.on(getNamespace(), "categoryName");
    
    public ParserCombinator initializeStatement$categoryName() {
      if (initializeStatement$categoryNameParser == null) {
        FutureParser future = scoped("categoryName", PUBLIC, true);
        initializeStatement$categoryNameParser = future;
        future.setParser(
          choice(
            keyword("ALPHABETIC"),
            keyword("ALPHANUMERIC"),
            keyword("ALPHANUMERIC-EDITED"),
            keyword("BOOLEAN"),
            keyword("DATA-POINTER"),
            keyword("FUNCTION-POINTER"),
            keyword("NATIONAL"),
            keyword("NATIONAL-EDITED"),
            keyword("NUMERIC"),
            keyword("NUMERIC-EDITED"),
            keyword("OBJECT-REFERENCE"),
            keyword("PROGRAM-POINTER"),
            keyword("DBCS"),
            keyword("EGCS")
          )
        );
      }
    
      return initializeStatement$categoryNameParser;
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
            keyword("INSPECT"),
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
            keyword("CONVERTING"),
            choice(
              identifier(),
              literal()
            ),
            keyword("TO"),
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
            keyword("TALLYING"),
            star(
              sequence(
                qualifiedDataName(),
                keyword("FOR"),
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
            keyword("CHARACTERS"),
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
              keyword("ALL"),
              keyword("LEADING"),
              keyword("TRAILING")
            ),
            star(
              sequence(
                choice(
                  sequence(
                    identifier(),
                    not(
                      keyword("FOR")
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
            keyword("REPLACING"),
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
            keyword("CHARACTERS"),
            keyword("BY"),
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
              keyword("ALL"),
              keyword("LEADING"),
              keyword("FIRST"),
              keyword("TRAILING")
            ),
            star(
              sequence(
                choice(
                  identifier(),
                  literal()
                ),
                keyword("BY"),
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
              keyword("BEFORE"),
              keyword("AFTER")
            ),
            optional(
              keyword("INITIAL")
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
            keyword("MERGE"),
            fileName(),
            plus(
              as("key",
                sequence(
                  optional(
                    keyword("ON")
                  ),
                  choice(
                    as("asc",
                      keyword("ASCENDING")
                    ),
                    as("desc",
                      keyword("DESCENDING")
                    )
                  ),
                  optional(
                    keyword("KEY")
                  ),
                  optional(
                    keyword("IS")
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
                      keyword("COLLATING")
                    )
                  ),
                  keyword("SEQUENCE"),
                  optional(
                    keyword("IS")
                  ),
                  alphabetName()
                )
              )
            ),
            as("using",
              sequence(
                keyword("USING"),
                fileName(),
                plus(
                  fileName()
                )
              )
            ),
            choice(
              as("output",
                sequence(
                  keyword("OUTPUT"),
                  keyword("PROCEDURE"),
                  optional(
                    keyword("IS")
                  ),
                  procedureName(),
                  optional(
                    sequence(
                      choice(
                        keyword("THROUGH"),
                        keyword("THRU")
                      ),
                      procedureName()
                    )
                  )
                )
              ),
              as("giving",
                sequence(
                  keyword("GIVING"),
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
            keyword("MOVE"),
            choice(
              as("corresponding",
                sequence(
                  choice(
                    keyword("CORRESPONDING"),
                    keyword("CORR")
                  ),
                  identifier()
                )
              ),
              as("sending",
                identifier()
              ),
              literal()
            ),
            keyword("TO"),
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
            keyword("MULTIPLY"),
            choice(
              multiplyStatement$format1(),
              multiplyStatement$format2()
            ),
            optional(
              permuted(
                onSizeError(),
                notOnSizeError()
              )
            ),
            optional(
              as("end",
                keyword("END-MULTIPLY")
              )
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
                keyword("BY"),
                choice(
                  identifier(),
                  literal()
                )
              )
            ),
            as("giving",
              sequence(
                keyword("GIVING"),
                plus(
                  sequence(
                    as("identifier",
                      qualifiedDataName()
                    ),
                    optional(
                      keyword("ROUNDED")
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
                keyword("BY"),
                plus(
                  sequence(
                    qualifiedDataName(),
                    optional(
                      keyword("ROUNDED")
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
            keyword("NEXT"),
            keyword("SENTENCE")
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
            keyword("ON"),
            not(
              eventType()
            ),
            choice(
              literal(),
              identifier()
            ),
            optional(
              sequence(
                keyword("AND"),
                keyword("EVERY"),
                choice(
                  literal(),
                  identifier()
                )
              )
            ),
            optional(
              sequence(
                keyword("UNTIL"),
                choice(
                  literal(),
                  identifier()
                )
              )
            ),
            choice(
              nestedStatements(),
              sequence(
                keyword("NEXT"),
                keyword("SENTENCE")
              )
            ),
            optional(
              sequence(
                choice(
                  keyword("ELSE"),
                  keyword("OTHERWISE")
                ),
                choice(
                  nestedStatements(),
                  sequence(
                    keyword("NEXT"),
                    keyword("SENTENCE")
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
            keyword("OPEN"),
            plus(
              choice(
                sequence(
                  keyword("INPUT"),
                  plus(
                    sequence(
                      fileName(),
                      optional(
                        choice(
                          keyword("REVERSED"),
                          sequence(
                            optional(
                              keyword("WITH")
                            ),
                            keyword("NO"),
                            keyword("REWIND")
                          )
                        )
                      )
                    )
                  )
                ),
                sequence(
                  keyword("OUTPUT"),
                  plus(
                    sequence(
                      fileName(),
                      optional(
                        sequence(
                          optional(
                            keyword("WITH")
                          ),
                          keyword("NO"),
                          keyword("REWIND")
                        )
                      )
                    )
                  )
                ),
                sequence(
                  keyword("I-O"),
                  plus(
                    fileName()
                  )
                ),
                sequence(
                  keyword("EXTEND"),
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
            keyword("PERFORM"),
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
                    as("end",
                      keyword("END-PERFORM")
                    )
                  ),
                  as("nestedStatements",
                    sequence(
                      statement(),
                      not(
                        keyword("THRU")
                      ),
                      not(
                        keyword("THROUGH")
                      )
                    )
                  ),
                  as("end",
                    keyword("END-PERFORM")
                  )
                )
              ),
              sequence(
                procedureName(),
                optional(
                  sequence(
                    choice(
                      keyword("THROUGH"),
                      keyword("THRU")
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
            keyword("TIMES")
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
              keyword("WITH")
            ),
            keyword("TEST"),
            choice(
              keyword("BEFORE"),
              keyword("AFTER")
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
                keyword("UNTIL"),
                choice(
                  condition(),
                  keyword("EXIT")
                )
              ),
              keyword("FOREVER")
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
            keyword("VARYING"),
            identifier(),
            as("from",
              sequence(
                keyword("FROM"),
                choice(
                  literal(),
                  identifier()
                )
              )
            ),
            as("by",
              sequence(
                keyword("BY"),
                choice(
                  literal(),
                  identifier()
                )
              )
            ),
            as("until",
              sequence(
                keyword("UNTIL"),
                condition()
              )
            ),
            star(
              as("after",
                sequence(
                  keyword("AFTER"),
                  identifier(),
                  as("from",
                    sequence(
                      keyword("FROM"),
                      choice(
                        literal(),
                        identifier()
                      )
                    )
                  ),
                  as("by",
                    sequence(
                      keyword("BY"),
                      choice(
                        literal(),
                        identifier()
                      )
                    )
                  ),
                  as("until",
                    sequence(
                      keyword("UNTIL"),
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
            keyword("PURGE"),
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
            keyword("RAISE"),
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
            keyword("READ"),
            fileName(),
            optional(
              choice(
                keyword("NEXT"),
                keyword("PREVIOUS")
              )
            ),
            optional(
              keyword("RECORD")
            ),
            optional(
              sequence(
                keyword("INTO"),
                identifier_format2()
              )
            ),
            optional(
              choice(
                sequence(
                  keyword("ADVANCING"),
                  optional(
                    keyword("ON")
                  ),
                  keyword("LOCK")
                ),
                sequence(
                  keyword("IGNORING"),
                  keyword("LOCK")
                ),
                sequence(
                  optional(
                    keyword("WITH")
                  ),
                  choice(
                    sequence(
                      optional(
                        choice(
                          keyword("KEPT"),
                          keyword("NO"),
                          keyword("IGNORE")
                        )
                      ),
                      keyword("LOCK")
                    ),
                    keyword("WAIT")
                  )
                ),
                retryPhrase()
              )
            ),
            optional(
              sequence(
                keyword("KEY"),
                optional(
                  keyword("IS")
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
              as("end",
                keyword("END-READ")
              )
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
              keyword("WITH")
            ),
            choice(
              readLockClause(),
              keyword("WAIT")
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
                keyword("KEPT"),
                keyword("NO"),
                keyword("IGNORE")
              )
            ),
            keyword("LOCK")
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
            keyword("READY"),
            keyword("TRACE"),
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
            keyword("RECEIVE"),
            choice(
              sequence(
                dataName(),
                keyword("FROM"),
                choice(
                  sequence(
                    keyword("THREAD"),
                    dataName()
                  ),
                  sequence(
                    keyword("LAST"),
                    keyword("THREAD")
                  ),
                  sequence(
                    keyword("ANY"),
                    keyword("THREAD")
                  )
                ),
                optional(
                  permuted(
                    sequence(
                      keyword("BEFORE"),
                      optional(
                        keyword("TIME")
                      ),
                      choice(
                        numeric(),
                        identifier()
                      )
                    ),
                    sequence(
                      optional(
                        keyword("WITH")
                      ),
                      keyword("NO"),
                      keyword("WAIT")
                    ),
                    sequence(
                      keyword("THREAD"),
                      optional(
                        keyword("IN")
                      ),
                      dataName()
                    ),
                    sequence(
                      keyword("SIZE"),
                      optional(
                        keyword("IN")
                      ),
                      choice(
                        numeric(),
                        identifier()
                      )
                    ),
                    sequence(
                      keyword("STATUS"),
                      optional(
                        keyword("IN")
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
                  keyword("MESSAGE"),
                  keyword("SEGMENT")
                ),
                optional(
                  keyword("INTO")
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
              as("end",
                keyword("END-RECEIVE")
              )
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
            keyword("NO"),
            keyword("DATA"),
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
            keyword("WITH"),
            keyword("DATA"),
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
            keyword("RELEASE"),
            recordName(),
            optional(
              sequence(
                keyword("FROM"),
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
            keyword("RESET"),
            keyword("TRACE"),
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
            keyword("RETURN"),
            fileName(),
            optional(
              keyword("RECORD")
            ),
            optional(
              as("into",
                sequence(
                  keyword("INTO"),
                  identifier()
                )
              )
            ),
            atEnd(),
            optional(
              notAtEnd()
            ),
            optional(
              as("end",
                keyword("END-RETURN")
              )
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
            keyword("REWRITE"),
            choice(
              sequence(
                keyword("FILE"),
                fileName()
              ),
              recordName()
            ),
            optional(
              sequence(
                keyword("FROM"),
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
                  keyword("WITH")
                ),
                optional(
                  keyword("NO")
                ),
                keyword("LOCK")
              )
            ),
            optional(
              invalidKey()
            ),
            optional(
              notInvalidKey()
            ),
            optional(
              as("end",
                keyword("END-REWRITE")
              )
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
          keyword("ROLLBACK")
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
            keyword("SEARCH"),
            choice(
              sequence(
                keyword("ALL"),
                identifier()
              ),
              sequence(
                identifier(),
                optional(
                  sequence(
                    keyword("VARYING"),
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
                  keyword("WHEN"),
                  condition(),
                  choice(
                    nestedStatements(),
                    sequence(
                      keyword("NEXT"),
                      keyword("SENTENCE")
                    )
                  )
                )
              )
            ),
            optional(
              as("end",
                keyword("END-SEARCH")
              )
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
              keyword("AT")
            ),
            keyword("END"),
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
            keyword("NOT"),
            optional(
              keyword("AT")
            ),
            keyword("END"),
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
            keyword("SEND"),
            choice(
              sequence(
                dataName(),
                keyword("TO"),
                choice(
                  sequence(
                    keyword("LAST"),
                    keyword("THREAD")
                  ),
                  sequence(
                    keyword("ALL"),
                    keyword("THREADS")
                  ),
                  plus(
                    sequence(
                      optional(
                        keyword("THREAD")
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
                    keyword("FROM"),
                    identifier()
                  )
                ),
                optional(
                  sequence(
                    optional(
                      keyword("WITH")
                    ),
                    choice(
                      keyword("ESI"),
                      keyword("EMI"),
                      keyword("EGI"),
                      identifier()
                    ),
                    optional(
                      sequence(
                        choice(
                          keyword("BEFORE"),
                          keyword("AFTER")
                        ),
                        optional(
                          keyword("ADVANCING")
                        ),
                        choice(
                          keyword("PAGE"),
                          sequence(
                            choice(
                              zero(),
                              integer(),
                              identifier()
                            ),
                            optional(
                              choice(
                                keyword("LINE"),
                                keyword("LINES")
                              )
                            )
                          ),
                          mnemonicName()
                        )
                      )
                    ),
                    optional(
                      sequence(
                        keyword("REPLACING"),
                        optional(
                          keyword("LINE")
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
            keyword("SERVICE"),
            choice(
              keyword("LABEL"),
              sequence(
                keyword("RELOAD"),
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
              keyword("SORT"),
              fileName(),
              plus(
                sequence(
                  optional(
                    keyword("ON")
                  ),
                  plus(
                    as("key",
                      sequence(
                        choice(
                          as("asc",
                            keyword("ASCENDING")
                          ),
                          as("desc",
                            keyword("DESCENDING")
                          )
                        ),
                        optional(
                          keyword("KEY")
                        ),
                        optional(
                          keyword("IS")
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
                      keyword("WITH")
                    ),
                    keyword("DUPLICATES"),
                    optional(
                      sequence(
                        keyword("IN"),
                        keyword("ORDER")
                      )
                    )
                  )
                )
              ),
              optional(
                as("sequence",
                  sequence(
                    optional(
                      keyword("COLLATING")
                    ),
                    keyword("SEQUENCE"),
                    optional(
                      keyword("IS")
                    ),
                    alphabetName()
                  )
                )
              ),
              choice(
                as("input",
                  sequence(
                    keyword("INPUT"),
                    keyword("PROCEDURE"),
                    optional(
                      keyword("IS")
                    ),
                    procedureName(),
                    optional(
                      sequence(
                        choice(
                          keyword("THROUGH"),
                          keyword("THRU")
                        ),
                        procedureName()
                      )
                    )
                  )
                ),
                as("using",
                  sequence(
                    keyword("USING"),
                    plus(
                      fileName()
                    )
                  )
                )
              ),
              choice(
                as("output",
                  sequence(
                    keyword("OUTPUT"),
                    keyword("PROCEDURE"),
                    optional(
                      keyword("IS")
                    ),
                    procedureName(),
                    optional(
                      sequence(
                        choice(
                          keyword("THROUGH"),
                          keyword("THRU")
                        ),
                        procedureName()
                      )
                    )
                  )
                ),
                as("giving",
                  sequence(
                    keyword("GIVING"),
                    plus(
                      fileName()
                    )
                  )
                )
              )
            ),
            sequence(
              keyword("SORT"),
              dataName(),
              plus(
                sequence(
                  optional(
                    keyword("ON")
                  ),
                  plus(
                    as("key",
                      sequence(
                        choice(
                          as("asc",
                            keyword("ASCENDING")
                          ),
                          as("desc",
                            keyword("DESCENDING")
                          )
                        ),
                        optional(
                          keyword("KEY")
                        ),
                        optional(
                          keyword("IS")
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
                      keyword("WITH")
                    ),
                    keyword("DUPLICATES"),
                    optional(
                      sequence(
                        keyword("IN"),
                        keyword("ORDER")
                      )
                    )
                  )
                )
              ),
              optional(
                as("sequence",
                  sequence(
                    optional(
                      keyword("COLLATING")
                    ),
                    keyword("SEQUENCE"),
                    optional(
                      keyword("IS")
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
            keyword("SET"),
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
    
    protected final Start setEnvironmentVariable = Start.on(getNamespace(), "setEnvironmentVariable");
    
    protected ParserCombinator setEnvironmentVariable() {
      if (setEnvironmentVariableParser == null) {
        FutureParser future = scoped("setEnvironmentVariable", PRIVATE, true);
        setEnvironmentVariableParser = future;
        future.setParser(
          sequence(
            as("environment",
              sequence(
                keyword("ENVIRONMENT"),
                literal()
              )
            ),
            as("to",
              sequence(
                keyword("TO"),
                literal()
              )
            )
          )
        );
      }
    
      return setEnvironmentVariableParser;
    }
    
    // ========================================================
    // setOther
    // ........................................................
    
    private ParserCombinator setOtherParser = null;
    
    protected final Start setOther = Start.on(getNamespace(), "setOther");
    
    protected ParserCombinator setOther() {
      if (setOtherParser == null) {
        FutureParser future = scoped("setOther", PRIVATE, true);
        setOtherParser = future;
        future.setParser(
          sequence(
            plus(
              choice(
                addressOf(),
                qualifiedDataName(),
                identifier()
              )
            ),
            choice(
              as("to",
                sequence(
                  keyword("TO"),
                  choice(
                    as("on",
                      keyword("ON")
                    ),
                    as("off",
                      keyword("OFF")
                    ),
                    as("true",
                      keyword("TRUE")
                    ),
                    as("false",
                      keyword("FALSE")
                    ),
                    addressOf(),
                    as("formatMonitor",
                      sequence(
                        optional(
                          keyword("NOT")
                        ),
                        choice(
                          keyword("BROWSING"),
                          keyword("READING"),
                          keyword("WRITING")
                        ),
                        optional(
                          sequence(
                            keyword("CONVERTING"),
                            keyword("FROM"),
                            choice(
                              keyword("BROWSING"),
                              keyword("WRITING")
                            )
                          )
                        )
                      )
                    ),
                    as("entry",
                      sequence(
                        keyword("ENTRY"),
                        choice(
                          identifier(),
                          literal()
                        )
                      )
                    ),
                    as("null",
                      keyword("NULL")
                    ),
                    as("null",
                      keyword("NULLS")
                    ),
                    figurativeConstant(),
                    name(),
                    identifier(),
                    integer()
                  )
                )
              ),
              as("up",
                sequence(
                  keyword("UP"),
                  keyword("BY"),
                  choice(
                    identifier(),
                    integer()
                  )
                )
              ),
              as("down",
                sequence(
                  keyword("DOWN"),
                  keyword("BY"),
                  choice(
                    identifier(),
                    integer()
                  )
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
            keyword("START"),
            fileName(),
            optional(
              startStatement$noLock()
            ),
            optional(
              choice(
                keyword("FIRST"),
                keyword("LAST"),
                sequence(
                  keyword("KEY"),
                  relop(),
                  identifier(),
                  optional(
                    sequence(
                      optional(
                        keyword("WITH")
                      ),
                      keyword("LENGTH"),
                      arithmeticExpression()
                    )
                  )
                )
              )
            ),
            optional(
              startStatement$size()
            ),
            optional(
              startStatement$whileKey()
            ),
            optional(
              permuted(
                invalidKey(),
                notInvalidKey()
              )
            ),
            optional(
              as("end",
                keyword("END-START")
              )
            )
          )
        );
      }
    
      return startStatementParser;
    }
    
    // ========================================================
    // noLock
    // ........................................................
    
    private ParserCombinator startStatement$noLockParser = null;
    
    public final Start startStatement$noLock = Start.on(getNamespace(), "noLock");
    
    public ParserCombinator startStatement$noLock() {
      if (startStatement$noLockParser == null) {
        FutureParser future = scoped("noLock", PUBLIC, true);
        startStatement$noLockParser = future;
        future.setParser(
          sequence(
            optional(
              keyword("WITH")
            ),
            keyword("NO"),
            keyword("LOCK")
          )
        );
      }
    
      return startStatement$noLockParser;
    }
    
    // ========================================================
    // size
    // ........................................................
    
    private ParserCombinator startStatement$sizeParser = null;
    
    public final Start startStatement$size = Start.on(getNamespace(), "size");
    
    public ParserCombinator startStatement$size() {
      if (startStatement$sizeParser == null) {
        FutureParser future = scoped("size", PUBLIC, true);
        startStatement$sizeParser = future;
        future.setParser(
          sequence(
            optional(
              keyword("WITH")
            ),
            keyword("SIZE"),
            choice(
              identifier(),
              integer()
            )
          )
        );
      }
    
      return startStatement$sizeParser;
    }
    
    // ========================================================
    // whileKey
    // ........................................................
    
    private ParserCombinator startStatement$whileKeyParser = null;
    
    public final Start startStatement$whileKey = Start.on(getNamespace(), "whileKey");
    
    public ParserCombinator startStatement$whileKey() {
      if (startStatement$whileKeyParser == null) {
        FutureParser future = scoped("whileKey", PUBLIC, true);
        startStatement$whileKeyParser = future;
        future.setParser(
          sequence(
            keyword("WHILE"),
            optional(
              keyword("KEY")
            ),
            optional(
              keyword("IS")
            ),
            optional(
              keyword("NOT")
            ),
            keyword("LIKE"),
            optional(
              startStatement$whileKey$mods()
            ),
            choice(
              identifier(),
              literal()
            )
          )
        );
      }
    
      return startStatement$whileKeyParser;
    }
    
    // ========================================================
    // mods
    // ........................................................
    
    private ParserCombinator startStatement$whileKey$modsParser = null;
    
    public final Start startStatement$whileKey$mods = Start.on(getNamespace(), "mods");
    
    public ParserCombinator startStatement$whileKey$mods() {
      if (startStatement$whileKey$modsParser == null) {
        FutureParser future = scoped("mods", PUBLIC, true);
        startStatement$whileKey$modsParser = future;
        future.setParser(
          permuted(
            sequence(
              keyword("TRIMMED"),
              optional(
                choice(
                  keyword("LEFT"),
                  keyword("RIGHT")
                )
              )
            ),
            choice(
              keyword("CASE-SENSITIVE"),
              keyword("CASE-INSENSITIVE")
            )
          )
        );
      }
    
      return startStatement$whileKey$modsParser;
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
            keyword("STOP"),
            choice(
              sequence(
                as("endpoint",
                  keyword("RUN")
                ),
                optional(
                  choice(
                    sequence(
                      choice(
                        keyword("GIVING"),
                        keyword("RETURNING")
                      ),
                      choice(
                        addressOf(),
                        identifier(),
                        sequence(
                          integer(),
                          optional(
                            sequence(
                              keyword("SIZE"),
                              optional(
                                keyword("IS")
                              ),
                              integer()
                            )
                          )
                        )
                      )
                    ),
                    sequence(
                      optional(
                        keyword("WITH")
                      ),
                      choice(
                        keyword("ERROR"),
                        keyword("NORMAL")
                      ),
                      optional(
                        keyword("STATUS")
                      ),
                      optional(
                        choice(
                          identifier(),
                          literal()
                        )
                      )
                    ),
                    identifier(),
                    literal()
                  )
                )
              ),
              as("endpoint",
                keyword("ITERATOR")
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
            keyword("STRING"),
            plus(
              sequence(
                choice(
                  identifier(),
                  literal()
                ),
                optional(
                  sequence(
                    keyword("DELIMITED"),
                    optional(
                      keyword("BY")
                    ),
                    choice(
                      keyword("SIZE"),
                      identifier(),
                      literal()
                    )
                  )
                )
              )
            ),
            keyword("INTO"),
            identifier(),
            optional(
              sequence(
                optional(
                  keyword("WITH")
                ),
                keyword("POINTER"),
                identifier()
              )
            ),
            optional(
              permuted(
                onOverflow(),
                notOnOverflow()
              )
            ),
            optional(
              as("end",
                keyword("END-STRING")
              )
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
            keyword("SUBTRACT"),
            choice(
              subtractStatement$format1(),
              subtractStatement$format2(),
              subtractStatement$format3()
            ),
            optional(
              permuted(
                onSizeError(),
                notOnSizeError()
              )
            ),
            optional(
              as("end",
                keyword("END-SUBTRACT")
              )
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
                  keyword("CORRESPONDING"),
                  keyword("CORR")
                ),
                identifier()
              )
            ),
            as("from",
              sequence(
                keyword("FROM"),
                identifier(),
                optional(
                  keyword("ROUNDED")
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
                  keyword("FROM"),
                  choice(
                    identifier(),
                    literal()
                  )
                )
              )
            ),
            as("giving",
              sequence(
                keyword("GIVING"),
                plus(
                  sequence(
                    identifier(),
                    optional(
                      keyword("ROUNDED")
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
                keyword("FROM"),
                plus(
                  sequence(
                    identifier(),
                    optional(
                      keyword("ROUNDED")
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
            keyword("SUPPRESS"),
            optional(
              keyword("PRINTING")
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
            keyword("TERMINATE"),
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
            keyword("TRANSFORM"),
            identifier(),
            optional(
              keyword("CHARACTERS")
            ),
            keyword("FROM"),
            choice(
              figurativeConstant(),
              alphanumericLiteral(),
              identifier()
            ),
            keyword("TO"),
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
            keyword("UNLOCK"),
            fileName(),
            optional(
              choice(
                keyword("RECORD"),
                keyword("RECORDS")
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
            keyword("UNSTRING"),
            identifier(),
            optional(
              sequence(
                keyword("DELIMITED"),
                optional(
                  keyword("BY")
                ),
                optional(
                  keyword("ALL")
                ),
                choice(
                  identifier(),
                  literal()
                ),
                star(
                  sequence(
                    keyword("OR"),
                    optional(
                      keyword("ALL")
                    ),
                    choice(
                      identifier(),
                      literal()
                    )
                  )
                )
              )
            ),
            keyword("INTO"),
            plus(
              sequence(
                identifier(),
                optional(
                  sequence(
                    keyword("DELIMITER"),
                    optional(
                      keyword("IN")
                    ),
                    identifier()
                  )
                ),
                optional(
                  sequence(
                    keyword("COUNT"),
                    optional(
                      keyword("IN")
                    ),
                    identifier()
                  )
                )
              )
            ),
            optional(
              sequence(
                optional(
                  keyword("WITH")
                ),
                keyword("POINTER"),
                identifier()
              )
            ),
            optional(
              sequence(
                keyword("TALLYING"),
                optional(
                  keyword("IN")
                ),
                identifier()
              )
            ),
            optional(
              permuted(
                onOverflow(),
                notOnOverflow()
              )
            ),
            optional(
              as("end",
                keyword("END-UNSTRING")
              )
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
            keyword("USE"),
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
              keyword("GLOBAL")
            ),
            keyword("AFTER"),
            optional(
              keyword("STANDARD")
            ),
            choice(
              keyword("ERROR"),
              keyword("EXCEPTION")
            ),
            keyword("PROCEDURE"),
            optional(
              keyword("ON")
            ),
            choice(
              keyword("INPUT"),
              keyword("OUTPUT"),
              keyword("I-O"),
              keyword("EXTEND"),
              star(
                fileName()
              )
            ),
            optional(
              sequence(
                keyword("GIVING"),
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
              keyword("FOR")
            ),
            keyword("DEBUGGING"),
            optional(
              keyword("ON")
            ),
            star(
              choice(
                sequence(
                  keyword("ALL"),
                  keyword("PROCEDURES")
                ),
                sequence(
                  optional(
                    sequence(
                      keyword("ALL"),
                      optional(
                        keyword("REFERENCES")
                      ),
                      optional(
                        keyword("OF")
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
              keyword("GLOBAL")
            ),
            keyword("AFTER"),
            optional(
              keyword("STANDARD")
            ),
            optional(
              choice(
                keyword("BEGINNING"),
                keyword("ENDING")
              )
            ),
            optional(
              choice(
                keyword("FILE"),
                keyword("REEL"),
                keyword("UNIT")
              )
            ),
            keyword("LABEL"),
            keyword("PROCEDURE"),
            optional(
              keyword("ON")
            ),
            choice(
              keyword("INPUT"),
              keyword("OUTPUT"),
              keyword("I-O"),
              keyword("EXTEND"),
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
              keyword("GLOBAL")
            ),
            keyword("BEFORE"),
            keyword("REPORTING"),
            identifier()
          )
        );
      }
    
      return beforeReportingDeclarativeParser;
    }
    
    // ========================================================
    // validateStatement
    // ........................................................
    
    private ParserCombinator validateStatementParser = null;
    
    public final Start validateStatement = Start.on(getNamespace(), "validateStatement");
    
    public ParserCombinator validateStatement() {
      if (validateStatementParser == null) {
        FutureParser future = scoped("validateStatement", PUBLIC, true);
        validateStatementParser = future;
        future.setParser(
          sequence(
            keyword("VALIDATE"),
            plus(
              identifier()
            )
          )
        );
      }
    
      return validateStatementParser;
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
              keyword("WAIT"),
              optional(
                keyword("FOR")
              ),
              threadPointer(),
              optional(
                sequence(
                  keyword("RETURNING"),
                  optional(
                    keyword("INTO")
                  ),
                  identifier()
                )
              ),
              optional(
                sequence(
                  keyword("STATUS"),
                  optional(
                    keyword("IS")
                  ),
                  identifier()
                )
              ),
              optional(
                permuted(
                  onException(),
                  notOnException()
                )
              ),
              optional(
                as("end",
                  keyword("END-WAIT")
                )
              )
            ),
            sequence(
              keyword("WAIT"),
              optional(
                keyword("FOR")
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
            keyword("WRITE"),
            choice(
              sequence(
                keyword("FILE"),
                fileName()
              ),
              recordName()
            ),
            optional(
              sequence(
                keyword("FROM"),
                choice(
                  identifier(),
                  literal()
                )
              )
            ),
            optional(
              sequence(
                choice(
                  keyword("AFTER"),
                  keyword("BEFORE")
                ),
                optional(
                  choice(
                    keyword("ADVANCING"),
                    keyword("POSITIONING")
                  )
                ),
                choice(
                  keyword("TAB"),
                  keyword("FORMFEED"),
                  keyword("PAGE"),
                  sequence(
                    choice(
                      identifier(),
                      integer(),
                      zero()
                    ),
                    optional(
                      choice(
                        keyword("LINE"),
                        keyword("LINES")
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
                  keyword("WITH")
                ),
                optional(
                  keyword("NO")
                ),
                keyword("LOCK")
              )
            ),
            optional(
              invalidKey()
            ),
            optional(
              notInvalidKey()
            ),
            optional(
              as("end",
                keyword("END-WRITE")
              )
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
              keyword("AT")
            ),
            choice(
              keyword("END-OF-PAGE"),
              keyword("EOP")
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
            keyword("NOT"),
            optional(
              keyword("AT")
            ),
            choice(
              keyword("END-OF-PAGE"),
              keyword("EOP")
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
            keyword("XML"),
            keyword("GENERATE"),
            identifier(),
            keyword("FROM"),
            identifier(),
            optional(
              sequence(
                keyword("COUNT"),
                optional(
                  keyword("IN")
                ),
                identifier()
              )
            ),
            optional(
              sequence(
                optional(
                  keyword("WITH")
                ),
                keyword("ENCODING"),
                xmlGenerateStatement$codepage()
              )
            ),
            optional(
              sequence(
                optional(
                  keyword("WITH")
                ),
                keyword("XML-DECLARATION")
              )
            ),
            optional(
              sequence(
                optional(
                  keyword("WITH")
                ),
                keyword("ATTRIBUTES")
              )
            ),
            optional(
              sequence(
                keyword("NAMESPACE"),
                optional(
                  keyword("IS")
                ),
                choice(
                  identifier(),
                  literal()
                ),
                optional(
                  sequence(
                    keyword("NAMESPACE-PREFIX"),
                    optional(
                      keyword("IS")
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
              permuted(
                onException(),
                notOnException()
              )
            ),
            optional(
              as("end",
                keyword("END-XML")
              )
            )
          )
        );
      }
    
      return xmlGenerateStatementParser;
    }
    
    // ========================================================
    // codepage
    // ........................................................
    
    private ParserCombinator xmlGenerateStatement$codepageParser = null;
    
    public final Start xmlGenerateStatement$codepage = Start.on(getNamespace(), "codepage");
    
    public ParserCombinator xmlGenerateStatement$codepage() {
      if (xmlGenerateStatement$codepageParser == null) {
        FutureParser future = scoped("codepage", PUBLIC, true);
        xmlGenerateStatement$codepageParser = future;
        future.setParser(
          choice(
            integer(),
            justAName()
          )
        );
      }
    
      return xmlGenerateStatement$codepageParser;
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
            keyword("XML"),
            keyword("PARSE"),
            identifier(),
            optional(
              sequence(
                optional(
                  keyword("WITH")
                ),
                keyword("ENCODING"),
                xmlParseStatement$codepage()
              )
            ),
            optional(
              sequence(
                keyword("RETURNING"),
                keyword("NATIONAL")
              )
            ),
            optional(
              sequence(
                keyword("VALIDATING"),
                optional(
                  keyword("WITH")
                ),
                choice(
                  sequence(
                    keyword("FILE"),
                    xmlParseStatement$xmlSchemaName()
                  ),
                  identifier()
                )
              )
            ),
            keyword("PROCESSING"),
            keyword("PROCEDURE"),
            optional(
              keyword("IS")
            ),
            procedureName(),
            optional(
              sequence(
                choice(
                  keyword("THROUGH"),
                  keyword("THRU")
                ),
                procedureName()
              )
            ),
            optional(
              permuted(
                onException(),
                notOnException()
              )
            ),
            optional(
              as("end",
                keyword("END-XML")
              )
            )
          )
        );
      }
    
      return xmlParseStatementParser;
    }
    
    // ========================================================
    // codepage
    // ........................................................
    
    private ParserCombinator xmlParseStatement$codepageParser = null;
    
    public final Start xmlParseStatement$codepage = Start.on(getNamespace(), "codepage");
    
    public ParserCombinator xmlParseStatement$codepage() {
      if (xmlParseStatement$codepageParser == null) {
        FutureParser future = scoped("codepage", PUBLIC, true);
        xmlParseStatement$codepageParser = future;
        future.setParser(
          choice(
            integer(),
            justAName()
          )
        );
      }
    
      return xmlParseStatement$codepageParser;
    }
    
    // ========================================================
    // xmlSchemaName
    // ........................................................
    
    private ParserCombinator xmlParseStatement$xmlSchemaNameParser = null;
    
    public final Start xmlParseStatement$xmlSchemaName = Start.on(getNamespace(), "xmlSchemaName");
    
    public ParserCombinator xmlParseStatement$xmlSchemaName() {
      if (xmlParseStatement$xmlSchemaNameParser == null) {
        FutureParser future = scoped("xmlSchemaName", PUBLIC, true);
        xmlParseStatement$xmlSchemaNameParser = future;
        future.setParser(
          justAName()
        );
      }
    
      return xmlParseStatement$xmlSchemaNameParser;
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
                keyword("ATTRIBUTE"),
                attributeName(),
                literal("("),
                skipto(
                  literal(")")
                ),
                literal(")")
              ),
              sequence(
                keyword("CUSTOM-ATTRIBUTE"),
                keyword("IS"),
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
    // positionSpecification
    // ........................................................
    
    private ParserCombinator positionSpecificationParser = null;
    
    public final Start positionSpecification = Start.on(getNamespace(), "positionSpecification");
    
    public ParserCombinator positionSpecification() {
      if (positionSpecificationParser == null) {
        FutureParser future = scoped("positionSpecification", PUBLIC, true);
        positionSpecificationParser = future;
        future.setParser(
          sequence(
            literal("("),
            optional(
              positionSpecification$lin()
            ),
            literal(","),
            optional(
              positionSpecification$col()
            ),
            literal(")")
          )
        );
      }
    
      return positionSpecificationParser;
    }
    
    // ========================================================
    // lin
    // ........................................................
    
    private ParserCombinator positionSpecification$linParser = null;
    
    public final Start positionSpecification$lin = Start.on(getNamespace(), "lin");
    
    public ParserCombinator positionSpecification$lin() {
      if (positionSpecification$linParser == null) {
        FutureParser future = scoped("lin", PUBLIC, true);
        positionSpecification$linParser = future;
        future.setParser(
          sequence(
            not(
              literal(",")
            ),
            choice(
              integerLiteral(),
              sequence(
                choice(
                  keyword("LIN"),
                  identifier()
                ),
                optional(
                  sequence(
                    choice(
                      literal("+"),
                      literal("-")
                    ),
                    integerLiteral()
                  )
                )
              )
            )
          )
        );
      }
    
      return positionSpecification$linParser;
    }
    
    // ========================================================
    // col
    // ........................................................
    
    private ParserCombinator positionSpecification$colParser = null;
    
    public final Start positionSpecification$col = Start.on(getNamespace(), "col");
    
    public ParserCombinator positionSpecification$col() {
      if (positionSpecification$colParser == null) {
        FutureParser future = scoped("col", PUBLIC, true);
        positionSpecification$colParser = future;
        future.setParser(
          choice(
            integerLiteral(),
            sequence(
              choice(
                keyword("COL"),
                identifier()
              ),
              optional(
                sequence(
                  choice(
                    literal("+"),
                    literal("-")
                  ),
                  integerLiteral()
                )
              )
            )
          )
        );
      }
    
      return positionSpecification$colParser;
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
              keyword("ON")
            ),
            keyword("OVERFLOW"),
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
            keyword("NOT"),
            optional(
              keyword("ON")
            ),
            keyword("OVERFLOW"),
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
              keyword("ON")
            ),
            keyword("EXCEPTION"),
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
            keyword("NOT"),
            optional(
              keyword("ON")
            ),
            keyword("EXCEPTION"),
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
              keyword("ON")
            ),
            keyword("SIZE"),
            keyword("ERROR"),
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
            keyword("NOT"),
            optional(
              keyword("ON")
            ),
            keyword("SIZE"),
            keyword("ERROR"),
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
              keyword("ON")
            ),
            keyword("ESCAPE"),
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
            keyword("NOT"),
            optional(
              keyword("ON")
            ),
            keyword("ESCAPE"),
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
              keyword("SET")
            ),
            skipto(
              choice(
                sequence(
                  literal("\u0024"),
                  keyword("SET")
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
            keyword("IF"),
            operand(),
            optional(
              choice(
                keyword("SET"),
                sequence(
                  optional(
                    keyword("NOT")
                  ),
                  keyword("DEFINED")
                ),
                sequence(
                  optional(
                    keyword("NOT")
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
                keyword("ELSE"),
                choice(
                  compilerStatement(),
                  nestedStatements()
                )
              )
            ),
            literal("\u0024"),
            keyword("END")
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
            keyword("DISPLAY"),
            choice(
              sequence(
                keyword("VCS"),
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
    // replacementOperand
    // ........................................................
    
    private ParserCombinator replacementOperandParser = null;
    
    public final Start replacementOperand = Start.on(getNamespace(), "replacementOperand");
    
    public ParserCombinator replacementOperand() {
      if (replacementOperandParser == null) {
        FutureParser future = scoped("replacementOperand", PUBLIC, true);
        replacementOperandParser = future;
        future.setParser(
          choice(
            pseudoLiteral(),
            verb(),
            literal(),
            identifier(),
            justAName()
          )
        );
      }
    
      return replacementOperandParser;
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
                  keyword("ID"),
                  keyword("IDENTIFICATION")
                ),
                keyword("DIVISION")
              ),
              sequence(
                keyword("ENVIRONMENT"),
                keyword("DIVISION")
              ),
              sequence(
                keyword("DATA"),
                keyword("DIVISION")
              ),
              sequence(
                keyword("PROCEDURE"),
                keyword("DIVISION"),
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
              keyword("CONFIGURATION"),
              keyword("INPUT-OUTPUT"),
              keyword("FILE"),
              keyword("WORKING-STORAGE"),
              keyword("THREAD-LOCAL-STORAGE"),
              keyword("OBJECT-STORAGE"),
              keyword("LOCAL-STORAGE"),
              keyword("LINKAGE"),
              keyword("COMMUNICATION"),
              keyword("OBJECT"),
              keyword("REPORT"),
              keyword("SCREEN")
            ),
            keyword("SECTION"),
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
              keyword("SOURCE-COMPUTER"),
              keyword("OBJECT-COMPUTER"),
              keyword("SPECIAL-NAMES"),
              keyword("REPOSITORY"),
              keyword("CONSTRAINTS"),
              keyword("CLASS-ATTRIBUTES"),
              keyword("ASSEMBLY-ATTRIBUTES"),
              keyword("FILE-CONTROL"),
              keyword("I-O-CONTROL"),
              keyword("CLASS-CONTROL")
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
            keyword("FUNCTION"),
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
                    keyword("LEADING"),
                    keyword("TRAILING")
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
            keyword("EXCEPTION-OBJECT"),
            keyword("NULL"),
            keyword("SELF"),
            sequence(
              optional(
                sequence(
                  className(),
                  keyword("OF")
                )
              ),
              keyword("SUPER")
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
            keyword("ADDRESS"),
            optional(
              keyword("OF")
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
            keyword("LINAGE-COUNTER"),
            optional(
              sequence(
                choice(
                  keyword("IN"),
                  keyword("OF")
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
                keyword("PAGE-COUNTER")
              ),
              as("lineCounter",
                keyword("LINE-COUNTER")
              )
            ),
            optional(
              sequence(
                choice(
                  keyword("IN"),
                  keyword("OF")
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
                keyword("IN"),
                keyword("OF")
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
            keyword("ALL"),
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
                keyword("B-OR"),
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
                  keyword("B-XOR"),
                  keyword("B-EXOR")
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
                keyword("B-AND"),
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
                  sequence(
                    literal("*"),
                    opt(NOSKIP,
                      literal("*")
                    )
                  ),
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
                  keyword("B-NOT")
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
            keyword("B-AND"),
            keyword("B-OR"),
            keyword("B-XOR"),
            keyword("B-EXOR"),
            literal("+"),
            literal("-"),
            sequence(
              literal("*"),
              opt(NOSKIP,
                literal("*")
              )
            ),
            literal("*"),
            literal("/")
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
                keyword("OR"),
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
                keyword("AND"),
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
              keyword("NOT")
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
              keyword("TRUE")
            ),
            as("false",
              keyword("FALSE")
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
              keyword("IS")
            ),
            optional(
              as("not",
                keyword("NOT")
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
            keyword("NUMERIC"),
            keyword("ALPHABETIC"),
            keyword("ALPHABETIC-LOWER"),
            keyword("ALPHABETIC-UPPER"),
            keyword("DBCS"),
            keyword("KANJI"),
            keyword("BOOLEAN"),
            keyword("INFINITY"),
            keyword("REPRESENTS-NOT-A-NUMBER"),
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
            signCondition$test()
          )
        );
      }
    
      return signConditionParser;
    }
    
    // ========================================================
    // test
    // ........................................................
    
    private ParserCombinator signCondition$testParser = null;
    
    protected final Start signCondition$test = Start.on(getNamespace(), "test");
    
    protected ParserCombinator signCondition$test() {
      if (signCondition$testParser == null) {
        FutureParser future = scoped("test", PRIVATE, true);
        signCondition$testParser = future;
        future.setParser(
          sequence(
            optional(
              keyword("IS")
            ),
            optional(
              as("not",
                keyword("NOT")
              )
            ),
            signCondition$signType()
          )
        );
      }
    
      return signCondition$testParser;
    }
    
    // ========================================================
    // signType
    // ........................................................
    
    private ParserCombinator signCondition$signTypeParser = null;
    
    public final Start signCondition$signType = Start.on(getNamespace(), "signType");
    
    public ParserCombinator signCondition$signType() {
      if (signCondition$signTypeParser == null) {
        FutureParser future = scoped("signType", PUBLIC, true);
        signCondition$signTypeParser = future;
        future.setParser(
          choice(
            keyword("POSITIVE"),
            keyword("NEGATIVE"),
            zero()
          )
        );
      }
    
      return signCondition$signTypeParser;
    }
    
    // ========================================================
    // abbreviatedSignCondition
    // ........................................................
    
    private ParserCombinator abbreviatedSignConditionParser = null;
    
    public final Start abbreviatedSignCondition = Start.on(getNamespace(), "abbreviatedSignCondition");
    
    public ParserCombinator abbreviatedSignCondition() {
      if (abbreviatedSignConditionParser == null) {
        FutureParser future = scoped("abbreviatedSignCondition", PUBLIC, true);
        abbreviatedSignConditionParser = future;
        future.setParser(
          signCondition$test()
        );
      }
    
      return abbreviatedSignConditionParser;
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
              keyword("IS")
            ),
            optional(
              as("not",
                keyword("NOT")
              )
            ),
            keyword("OMITTED")
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
                  keyword("NOT")
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
                keyword("OR"),
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
                keyword("AND"),
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
              keyword("NOT")
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
                keyword("IS"),
                keyword("NOT"),
                keyword("OMITTED"),
                relop(),
                classType(),
                signCondition$signType()
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
                keyword("NULL"),
                keyword("NULLS")
              )
            ),
            addressOf(),
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
                  keyword("IS"),
                  keyword("ARE")
                )
              ),
              choice(
                sequence(
                  optional(
                    as("not",
                      keyword("NOT")
                    )
                  ),
                  greaterOrEqualOp()
                ),
                sequence(
                  optional(
                    as("not",
                      keyword("NOT")
                    )
                  ),
                  lessOrEqualOp()
                ),
                unequalToOp(),
                sequence(
                  optional(
                    as("not",
                      keyword("NOT")
                    )
                  ),
                  greaterThanOp()
                ),
                sequence(
                  optional(
                    as("not",
                      keyword("NOT")
                    )
                  ),
                  lessThanOp()
                ),
                sequence(
                  optional(
                    as("not",
                      keyword("NOT")
                    )
                  ),
                  equalToOp()
                )
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
              keyword("GREATER"),
              optional(
                keyword("THAN")
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
              keyword("LESS"),
              optional(
                keyword("THAN")
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
              keyword("EQUAL"),
              optional(
                keyword("TO")
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
              keyword("GREATER"),
              optional(
                keyword("THAN")
              ),
              keyword("OR"),
              keyword("EQUAL"),
              optional(
                keyword("TO")
              )
            ),
            sequence(
              literal(">"),
              opt(NOSKIP,
                literal("=")
              )
            )
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
              keyword("LESS"),
              optional(
                keyword("THAN")
              ),
              keyword("OR"),
              keyword("EQUAL"),
              optional(
                keyword("TO")
              )
            ),
            sequence(
              literal("<"),
              opt(NOSKIP,
                literal("=")
              )
            )
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
              keyword("UNEQUAL"),
              optional(
                keyword("TO")
              )
            ),
            sequence(
              literal("<"),
              opt(NOSKIP,
                literal(">")
              )
            )
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
          keyword("EXCEEDS")
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
          keyword("EQUALS")
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
            alphanumeric(),
            justAName()
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
          justAName()
        );
      }
    
      return dataNameParser;
    }
    
    // ========================================================
    // justAName
    // ........................................................
    
    private ParserCombinator justANameParser = null;
    
    protected final Start justAName = Start.on(getNamespace(), "justAName");
    
    protected ParserCombinator justAName() {
      if (justANameParser == null) {
        FutureParser future = scoped("justAName", PRIVATE, true);
        justANameParser = future;
        future.setParser(
          sequence(
            not(
              hexadecimalLiteral()
            ),
            cobolWord()
          )
        );
      }
    
      return justANameParser;
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
          justAName()
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
                  keyword("IN"),
                  keyword("OF")
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
            justAName(),
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
          justAName()
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
          justAName()
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
          justAName()
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
          justAName()
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
          justAName()
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
          justAName()
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
          justAName()
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
          justAName()
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
          justAName()
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
          justAName()
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
          justAName()
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
          justAName()
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
          justAName()
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
          justAName()
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
          justAName()
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
            alphanumeric(),
            justAName()
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
          justAName()
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
          justAName()
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
            justAName()
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
            keyword("SYSIN"),
            keyword("SYSIPT"),
            keyword("SYSOUT"),
            keyword("SYSLIST"),
            keyword("SYSLST"),
            keyword("SYSPUNCH"),
            keyword("SYSPCH"),
            keyword("CONSOLE"),
            keyword("CRT"),
            keyword("CRT-UNDER"),
            keyword("C01"),
            keyword("C02"),
            keyword("C03"),
            keyword("C04"),
            keyword("C05"),
            keyword("C06"),
            keyword("C07"),
            keyword("C08"),
            keyword("C09"),
            keyword("C10"),
            keyword("C11"),
            keyword("C12"),
            keyword("CSP"),
            keyword("S01"),
            keyword("S02"),
            keyword("S03"),
            keyword("S04"),
            keyword("S05"),
            keyword("AFP-5A")
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
          justAName()
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
          justAName()
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
          justAName()
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
            as("true",
              keyword("TRUE")
            ),
            as("false",
              keyword("FALSE")
            )
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
              keyword("ALL"),
              literal()
            ),
            sequence(
              optional(
                keyword("ALL")
              ),
              choice(
                zero(),
                space(),
                keyword("HIGH-VALUE"),
                keyword("HIGH-VALUES"),
                keyword("LOW-VALUE"),
                keyword("LOW-VALUES"),
                keyword("QUOTE"),
                keyword("QUOTES")
              )
            ),
            keyword("NULL"),
            keyword("NULLS")
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
            floatingPoint(),
            decimal(),
            integerLiteral(),
            booleanLiteral(),
            hexadecimal(),
            sequence(
              choice(
                keyword("LENGTH"),
                keyword("BYTE-LENGTH")
              ),
              optional(
                keyword("OF")
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
    // floatingPoint
    // ........................................................
    
    private ParserCombinator floatingPointParser = null;
    
    public final Start floatingPoint = Start.on(getNamespace(), "floatingPoint");
    
    public ParserCombinator floatingPoint() {
      if (floatingPointParser == null) {
        FutureParser future = scoped("floatingPoint", PUBLIC, true);
        floatingPointParser = future;
        future.setParser(
          sequence(
            choice(
              sequence(
                optional(
                  choice(
                    literal("+"),
                    literal("-")
                  )
                ),
                opt(NOSKIP,
                  uintgr()
                )
              ),
              uintgr()
            ),
            opt(NOSKIP,
              literal("."),
              uintgr(),
              literal("E"),
              optional(
                choice(
                  literal("+"),
                  literal("-")
                )
              ),
              uintgr()
            )
          )
        );
      }
    
      return floatingPointParser;
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
            keyword("ADDRESS"),
            optional(
              keyword("OF")
            ),
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
            keyword("LENGTH"),
            optional(
              keyword("OF")
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
            keyword("BYTE-LENGTH"),
            optional(
              keyword("OF")
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
          justAName()
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
          justAName()
        );
      }
    
      return alphanumericConstantParser;
    }
    
}
