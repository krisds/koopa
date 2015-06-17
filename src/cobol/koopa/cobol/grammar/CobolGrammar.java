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

import koopa.core.data.tags.AreaTag;
import koopa.cobol.data.tags.SyntacticTag;
import static koopa.cobol.data.tags.SyntacticTag.UNSIGNED;
import koopa.core.data.tags.TokenizerTag;
import static koopa.cobol.data.tags.SyntacticTag.INTEGER_LITERAL;
import koopa.cobol.grammar.preprocessing.CobolPreprocessingGrammar;

public class CobolGrammar extends CobolBaseGrammar {
    public CobolGrammar() {
    }
    
    // ========================================================
    // Compiled grammar rules. These were generated from the
    // grammar.
    // --------------------------------------------------------

    // ========================================================
    // compilationGroup
    // ........................................................

    private ParserCombinator compilationGroupParser = null;

    public final Start compilationGroup = Start.on(getNamespace(), "compilationGroup");

    public ParserCombinator compilationGroup() {
        if (compilationGroupParser == null) {
           FutureParser future = scoped("compilationGroup", true);
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
           FutureParser future = scoped("copybook", true);
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
           FutureParser future = scoped("copybookHoldingData", true);
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
           FutureParser future = scoped("copybookHoldingBehaviour", true);
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
           FutureParser future = scoped("sourceUnit", true);
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
           FutureParser future = scoped("programPrototype", true);
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
           FutureParser future = scoped("programPrototypeIdParagraph", true);
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
           FutureParser future = scoped("functionPrototype", true);
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
           FutureParser future = scoped("functionPrototypeIdParagraph", true);
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
           FutureParser future = scoped("programDefinition", true);
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
           FutureParser future = scoped("programIdParagraph", true);
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
           FutureParser future = scoped("functionDefinition", true);
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
           FutureParser future = scoped("functionIdParagraph", true);
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
           FutureParser future = scoped("classDefinition", true);
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
           FutureParser future = scoped("classIdParagraph", true);
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
    // attributeClause
    // ........................................................

    private ParserCombinator attributeClauseParser = null;

    public final Start attributeClause = Start.on(getNamespace(), "attributeClause");

    public ParserCombinator attributeClause() {
        if (attributeClauseParser == null) {
           FutureParser future = scoped("attributeClause", true);
           attributeClauseParser = future;
           future.setParser(
               plus(
                   choice(
                       sequence(
                           token("ATTRIBUTE"),
                           attributeName(),
                           literal("("),
                           star(
                               choice(
                                   sequence(
                                       token("NAME"),
                                       propertyName(),
                                       literal("="),
                                       propertyValue()
                                   ),
                                   parameterName()
                               )
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
                                   star(
                                       choice(
                                           sequence(
                                               propertyName(),
                                               literal("="),
                                               propertyValue()
                                           ),
                                           parameterName()
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

        return attributeClauseParser;
    }

    // ========================================================
    // factoryDefinition
    // ........................................................

    private ParserCombinator factoryDefinitionParser = null;

    public final Start factoryDefinition = Start.on(getNamespace(), "factoryDefinition");

    public ParserCombinator factoryDefinition() {
        if (factoryDefinitionParser == null) {
           FutureParser future = scoped("factoryDefinition", true);
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
           FutureParser future = scoped("factoryParagraph", true);
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
           FutureParser future = scoped("instanceDefinition", true);
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
           FutureParser future = scoped("objectParagraph", true);
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
           FutureParser future = scoped("interfaceDefinition", true);
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
           FutureParser future = scoped("interfaceIdParagraph", true);
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
           FutureParser future = scoped("methodDefinition", true);
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
           FutureParser future = scoped("methodIdParagraph", true);
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
           FutureParser future = scoped("callPrototypeDefinition", true);
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
           FutureParser future = scoped("callPrototypeIdParagraph", true);
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
           FutureParser future = scoped("delegateDefinition", true);
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
                   procedureDivisionHeader(),
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
           FutureParser future = scoped("delegateIdParagraph", true);
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
           FutureParser future = scoped("enumDefinition", true);
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
           FutureParser future = scoped("enumIdParagraph", true);
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
           FutureParser future = scoped("iteratorDefinition", true);
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
           FutureParser future = scoped("iteratorIdParagraph", true);
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
           FutureParser future = scoped("operatorDefinition", true);
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
           FutureParser future = scoped("operatorIdParagraph", true);
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
           FutureParser future = scoped("valueTypeDefinition", true);
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
           FutureParser future = scoped("valueTypeIdParagraph", true);
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
           FutureParser future = scoped("endMarker", true);
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
           FutureParser future = scoped("optionsParagraph", true);
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
           FutureParser future = scoped("arithmeticClause", true);
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
           FutureParser future = scoped("defaultRoundedClause", true);
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
           FutureParser future = scoped("entryConventionClause", true);
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
           FutureParser future = scoped("intermediateRoundingClause", true);
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
           FutureParser future = scoped("metadata", true);
           metadataParser = future;
           future.setParser(
               sequence(
                   plus(
                       choice(
                           sequence(
                               token("AUTHOR"),
                               literal("."),
                               optional(
                                   commentEntry()
                               )
                           ),
                           sequence(
                               token("INSTALLATION"),
                               literal("."),
                               optional(
                                   commentEntry()
                               )
                           ),
                           sequence(
                               token("DATE-WRITTEN"),
                               literal("."),
                               optional(
                                   commentEntry()
                               )
                           ),
                           sequence(
                               token("DATE-COMPILED"),
                               literal("."),
                               optional(
                                   commentEntry()
                               )
                           ),
                           sequence(
                               token("SECURITY"),
                               literal("."),
                               optional(
                                   commentEntry()
                               )
                           ),
                           sequence(
                               token("REMARKS"),
                               literal("."),
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
           FutureParser future = scoped("environmentDivision", true);
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
           FutureParser future = scoped("environmentDivisionBody", true);
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
           FutureParser future = scoped("configurationSection", true);
           configurationSectionParser = future;
           future.setParser(
               sequence(
                   token("CONFIGURATION"),
                   token("SECTION"),
                   literal("."),
                   optional(
                       configurationSectionBody()
                   )
               )
           );
        }

        return configurationSectionParser;
    }

    // ========================================================
    // configurationSectionBody
    // ........................................................

    private ParserCombinator configurationSectionBodyParser = null;

    public final Start configurationSectionBody = Start.on(getNamespace(), "configurationSectionBody");

    public ParserCombinator configurationSectionBody() {
        if (configurationSectionBodyParser == null) {
           FutureParser future = scoped("configurationSectionBody", true);
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
           FutureParser future = scoped("sourceComputerParagraph", true);
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
           FutureParser future = scoped("withDebuggingMode", true);
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
           FutureParser future = scoped("objectComputerParagraph", true);
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
           FutureParser future = scoped("constraintsParagraph", true);
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
           FutureParser future = scoped("classAttributesParagraph", true);
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
           FutureParser future = scoped("assemblyAttributesParagraph", true);
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
           FutureParser future = scoped("genericStringDef", true);
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
           FutureParser future = scoped("specialNamesParagraph", true);
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
           FutureParser future = scoped("specialNameStatement", true);
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
           FutureParser future = scoped("consoleIsCRT", true);
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
           FutureParser future = scoped("cobolDevice", true);
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
           FutureParser future = scoped("cobolSwitch", true);
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
           FutureParser future = scoped("alphabetIs", true);
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
           FutureParser future = scoped("alphabetType", true);
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
           FutureParser future = scoped("standard1AlphabetType", true);
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
           FutureParser future = scoped("standard2AlphabetType", true);
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
           FutureParser future = scoped("nativeAlphabetType", true);
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
           FutureParser future = scoped("asciiAlphabetType", true);
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
           FutureParser future = scoped("ebcdicAlphabetType", true);
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
           FutureParser future = scoped("explicitAlphabetType", true);
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
           FutureParser future = scoped("codeNameAlphabetType", true);
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
           FutureParser future = scoped("literalRange", true);
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
           FutureParser future = scoped("symbolicChars", true);
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
           FutureParser future = scoped("classIs", true);
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
           FutureParser future = scoped("localeIs", true);
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
           FutureParser future = scoped("currencySignIs", true);
           currencySignIsParser = future;
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

        return currencySignIsParser;
    }

    // ========================================================
    // decimalIsComma
    // ........................................................

    private ParserCombinator decimalIsCommaParser = null;

    public final Start decimalIsComma = Start.on(getNamespace(), "decimalIsComma");

    public ParserCombinator decimalIsComma() {
        if (decimalIsCommaParser == null) {
           FutureParser future = scoped("decimalIsComma", true);
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
           FutureParser future = scoped("numericSignIs", true);
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
           FutureParser future = scoped("callConvention", true);
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
           FutureParser future = scoped("cursorIs", true);
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
           FutureParser future = scoped("crtStatusIs", true);
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
           FutureParser future = scoped("xmlSchemaIs", true);
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
           FutureParser future = scoped("screenControlIs", true);
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
           FutureParser future = scoped("eventStatusIs", true);
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
           FutureParser future = scoped("repositoryParagraph", true);
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
           FutureParser future = scoped("classSpecifier", true);
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
           FutureParser future = scoped("interfaceSpecifier", true);
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
           FutureParser future = scoped("programSpecifier", true);
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
           FutureParser future = scoped("propertySpecifier", true);
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
           FutureParser future = scoped("functionSpecifier", true);
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
           FutureParser future = scoped("delegateSpecifier", true);
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
           FutureParser future = scoped("enumSpecifier", true);
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
           FutureParser future = scoped("ioSection", true);
           ioSectionParser = future;
           future.setParser(
               sequence(
                   token("INPUT-OUTPUT"),
                   token("SECTION"),
                   literal("."),
                   optional(
                       ioSectionBody()
                   )
               )
           );
        }

        return ioSectionParser;
    }

    // ========================================================
    // ioSectionBody
    // ........................................................

    private ParserCombinator ioSectionBodyParser = null;

    public final Start ioSectionBody = Start.on(getNamespace(), "ioSectionBody");

    public ParserCombinator ioSectionBody() {
        if (ioSectionBodyParser == null) {
           FutureParser future = scoped("ioSectionBody", true);
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
           FutureParser future = scoped("fileControlParagraph", true);
           fileControlParagraphParser = future;
           future.setParser(
               sequence(
                   token("FILE-CONTROL"),
                   literal("."),
                   optional(
                       fileControlEntry()
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
           FutureParser future = scoped("fileControlEntry", true);
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
           FutureParser future = scoped("selectStatement", true);
           selectStatementParser = future;
           future.setParser(
               sequence(
                   selectClause(),
                   assignClause(),
                   optional(
                       permuted(
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
           FutureParser future = scoped("selectClause", true);
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
           FutureParser future = scoped("assignClause", true);
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
           FutureParser future = scoped("assignUsingClause", true);
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
           FutureParser future = scoped("assignToClause", true);
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
           FutureParser future = scoped("diskClause", true);
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
           FutureParser future = scoped("collationClause", true);
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
           FutureParser future = scoped("recordDelimiterClause", true);
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
           FutureParser future = scoped("reserveClause", true);
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
           FutureParser future = scoped("organizationClause", true);
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
           FutureParser future = scoped("accessModeClause", true);
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
           FutureParser future = scoped("lockModeClause", true);
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
           FutureParser future = scoped("lockModeWithClause", true);
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
           FutureParser future = scoped("relativeKeyClause", true);
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
           FutureParser future = scoped("recordKeyClause", true);
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
           FutureParser future = scoped("alternateRecordKeyClause", true);
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
           FutureParser future = scoped("recordKeyDefinition", true);
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
           FutureParser future = scoped("fileStatusClause", true);
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
           FutureParser future = scoped("sortStatusClause", true);
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
           FutureParser future = scoped("passwordClause", true);
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
           FutureParser future = scoped("suppressClause", true);
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
           FutureParser future = scoped("sharingClause", true);
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
           FutureParser future = scoped("paddingClause", true);
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
           FutureParser future = scoped("ioControlParagraph", true);
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
           FutureParser future = scoped("objectSection", true);
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
           FutureParser future = scoped("objectSectionBody", true);
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
           FutureParser future = scoped("classControlParagraph", true);
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
           FutureParser future = scoped("dataDivision", true);
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
           FutureParser future = scoped("dataDivisionBody", true);
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
           FutureParser future = scoped("fileSection", true);
           fileSectionParser = future;
           future.setParser(
               sequence(
                   token("FILE"),
                   token("SECTION"),
                   literal("."),
                   star(
                       choice(
                           copyStatement(),
                           sequence(
                               fileDescriptionEntry(),
                               star(
                                   recordDescriptionEntry()
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

        return fileSectionParser;
    }

    // ========================================================
    // fileDescriptionEntry
    // ........................................................

    private ParserCombinator fileDescriptionEntryParser = null;

    public final Start fileDescriptionEntry = Start.on(getNamespace(), "fileDescriptionEntry");

    public ParserCombinator fileDescriptionEntry() {
        if (fileDescriptionEntryParser == null) {
           FutureParser future = scoped("fileDescriptionEntry", true);
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
           FutureParser future = scoped("fdFileDescriptionEntry", true);
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
           FutureParser future = scoped("sdFileDescriptionEntry", true);
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
           FutureParser future = scoped("workingStorageSection", true);
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
           FutureParser future = scoped("threadLocalStorageSection", true);
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
           FutureParser future = scoped("objectStorageSection", true);
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
           FutureParser future = scoped("localStorageSection", true);
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
           FutureParser future = scoped("linkageSection", true);
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
           FutureParser future = scoped("communicationSection", true);
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
           FutureParser future = scoped("communicationDescriptionEntry", true);
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
           FutureParser future = scoped("communicationDescriptionEntry_format1", true);
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
                   choice(
                       plus(
                           choice(
                               token("FILLER"),
                               sequence(
                                   not(
                                       token("STATUS")
                                   ),
                                   dataName()
                               )
                           )
                       ),
                       optional(
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
           FutureParser future = scoped("communicationDescriptionEntry_format2", true);
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
           FutureParser future = scoped("communicationDescriptionEntry_format3", true);
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
           FutureParser future = scoped("reportSection", true);
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
           FutureParser future = scoped("reportDescriptionEntry", true);
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
           FutureParser future = scoped("reportGroupDescriptionEntry", true);
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
                           choice(
                               sourceClause(),
                               reportSectionValueClause(),
                               sumClause()
                           ),
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
           FutureParser future = scoped("screenSection", true);
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
           FutureParser future = scoped("screenDescriptionEntry", true);
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
           FutureParser future = scoped("recordDescriptionEntry", true);
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
           FutureParser future = scoped("dataDescriptionEntry", true);
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
           FutureParser future = scoped("constantEntry", true);
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

    private ParserCombinator constantEntry_level01() {
        if (constantEntry_level01Parser == null) {
           FutureParser future = scoped("constantEntry_level01", false);
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

    private ParserCombinator constantEntry_level78() {
        if (constantEntry_level78Parser == null) {
           FutureParser future = scoped("constantEntry_level78", false);
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

    private ParserCombinator dataDescriptionEntry_format1() {
        if (dataDescriptionEntry_format1Parser == null) {
           FutureParser future = scoped("dataDescriptionEntry_format1", false);
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
                   skipto(
                       literal(".")
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

    private ParserCombinator dataDescriptionEntry_format2() {
        if (dataDescriptionEntry_format2Parser == null) {
           FutureParser future = scoped("dataDescriptionEntry_format2", false);
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

    private ParserCombinator dataDescriptionEntry_format3_and_4() {
        if (dataDescriptionEntry_format3_and_4Parser == null) {
           FutureParser future = scoped("dataDescriptionEntry_format3_and_4", false);
           dataDescriptionEntry_format3_and_4Parser = future;
           future.setParser(
               sequence(
                   as("levelNumber",
                       token("88")
                   ),
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
                   valueClause(),
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
           FutureParser future = scoped("dataRecords", true);
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
           FutureParser future = scoped("labelRecords", true);
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
           FutureParser future = scoped("recordingMode", true);
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
           FutureParser future = scoped("valueOfFileId", true);
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
           FutureParser future = scoped("valueOf", true);
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
           FutureParser future = scoped("cicsValue", true);
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
           FutureParser future = scoped("whenSetToFalseClause", true);
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
           FutureParser future = scoped("blankWhenZero", true);
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
           FutureParser future = scoped("threadLocalClause", true);
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
           FutureParser future = scoped("zero", true);
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
           FutureParser future = scoped("space", true);
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
           FutureParser future = scoped("justified", true);
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
           FutureParser future = scoped("valueClause", true);
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
           FutureParser future = scoped("alignedClause", true);
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
           FutureParser future = scoped("anyLengthClause", true);
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
           FutureParser future = scoped("autoClause", true);
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
           FutureParser future = scoped("backgroundColorClause", true);
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
           FutureParser future = scoped("basedClause", true);
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
           FutureParser future = scoped("bellClause", true);
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
           FutureParser future = scoped("blankClause", true);
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
           FutureParser future = scoped("blankWhenZeroClause", true);
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
           FutureParser future = scoped("blinkClause", true);
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
           FutureParser future = scoped("blockContainsClause", true);
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
           FutureParser future = scoped("classClause", true);
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
           FutureParser future = scoped("codeClause", true);
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
           FutureParser future = scoped("codeSetClause", true);
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
           FutureParser future = scoped("columnClause", true);
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
           FutureParser future = scoped("constantRecordClause", true);
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
           FutureParser future = scoped("constantValueClause", true);
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
           FutureParser future = scoped("controlClause", true);
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
           FutureParser future = scoped("defaultClause", true);
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
           FutureParser future = scoped("destinationClause", true);
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
           FutureParser future = scoped("eraseClause", true);
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
           FutureParser future = scoped("externalClause", true);
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
           FutureParser future = scoped("foregroundColorClause", true);
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
           FutureParser future = scoped("formatClause", true);
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
           FutureParser future = scoped("fullClause", true);
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
           FutureParser future = scoped("globalClause", true);
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
           FutureParser future = scoped("groupIndicateClause", true);
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
           FutureParser future = scoped("groupUsageClause", true);
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
           FutureParser future = scoped("highlightClause", true);
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
           FutureParser future = scoped("invalidClause", true);
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
           FutureParser future = scoped("justifiedClause", true);
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
           FutureParser future = scoped("linageClause", true);
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
           FutureParser future = scoped("footingClause", true);
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
           FutureParser future = scoped("linesAtTopClause", true);
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
           FutureParser future = scoped("linesAtBottomClause", true);
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
           FutureParser future = scoped("lineClause", true);
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
           FutureParser future = scoped("nextGroupClause", true);
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
           FutureParser future = scoped("occursClause", true);
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
           FutureParser future = scoped("pageClause", true);
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
           FutureParser future = scoped("pictureClause", true);
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
           FutureParser future = scoped("pictureLocaleClause", true);
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
           FutureParser future = scoped("presentWhenClause", true);
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
           FutureParser future = scoped("propertyClause", true);
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
           FutureParser future = scoped("recordClause", true);
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
           FutureParser future = scoped("recordContainsClause", true);
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
           FutureParser future = scoped("recordIsVaryingClause", true);
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
           FutureParser future = scoped("redefinesClause", true);
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
           FutureParser future = scoped("renamesClause", true);
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
           FutureParser future = scoped("reportClause", true);
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
           FutureParser future = scoped("reportGroupTypeClause", true);
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
           FutureParser future = scoped("reportGroupUsageClause", true);
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
           FutureParser future = scoped("reportSectionValueClause", true);
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
                       literal()
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
           FutureParser future = scoped("reverseVideoClause", true);
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
           FutureParser future = scoped("requiredClause", true);
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
           FutureParser future = scoped("sameAsClause", true);
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
           FutureParser future = scoped("screenFromClause", true);
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
           FutureParser future = scoped("screenToClause", true);
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
           FutureParser future = scoped("screenUsingClause", true);
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
           FutureParser future = scoped("screenValueClause", true);
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
           FutureParser future = scoped("secureClause", true);
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
           FutureParser future = scoped("selectWhenClause", true);
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
           FutureParser future = scoped("signClause", true);
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
           FutureParser future = scoped("sourceClause", true);
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
           FutureParser future = scoped("sumClause", true);
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
           FutureParser future = scoped("synchronizedClause", true);
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
           FutureParser future = scoped("typedefClause", true);
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
           FutureParser future = scoped("typeNameTypeClause", true);
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
           FutureParser future = scoped("underlineClause", true);
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
           FutureParser future = scoped("usageClause", true);
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
           FutureParser future = scoped("usageOperand", true);
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
           FutureParser future = scoped("validateStatusClause", true);
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
           FutureParser future = scoped("varyingClause", true);
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
           FutureParser future = scoped("procedureDivision", true);
           procedureDivisionParser = future;
           future.setParser(
               sequence(
                   procedureDivisionHeader(),
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
    // procedureDivisionHeader
    // ........................................................

    private ParserCombinator procedureDivisionHeaderParser = null;

    public final Start procedureDivisionHeader = Start.on(getNamespace(), "procedureDivisionHeader");

    public ParserCombinator procedureDivisionHeader() {
        if (procedureDivisionHeaderParser == null) {
           FutureParser future = scoped("procedureDivisionHeader", true);
           procedureDivisionHeaderParser = future;
           future.setParser(
               sequence(
                   token("PROCEDURE"),
                   token("DIVISION"),
                   optional(
                       mnemonicName()
                   ),
                   optional(
                       usingOrChainingPhrase()
                   ),
                   optional(
                       returningProcedurePhrase()
                   ),
                   literal(".")
               )
           );
        }

        return procedureDivisionHeaderParser;
    }

    // ========================================================
    // usingOrChainingPhrase
    // ........................................................

    private ParserCombinator usingOrChainingPhraseParser = null;

    public final Start usingOrChainingPhrase = Start.on(getNamespace(), "usingOrChainingPhrase");

    public ParserCombinator usingOrChainingPhrase() {
        if (usingOrChainingPhraseParser == null) {
           FutureParser future = scoped("usingOrChainingPhrase", true);
           usingOrChainingPhraseParser = future;
           future.setParser(
               sequence(
                   choice(
                       token("USING"),
                       token("CHAINING"),
                       token("GIVING")
                   ),
                   plus(
                       choice(
                           dataReference(),
                           dataValue(),
                           dataOutput()
                       )
                   ),
                   optional(
                       repeatedPhrase()
                   )
               )
           );
        }

        return usingOrChainingPhraseParser;
    }

    // ========================================================
    // dataReference
    // ........................................................

    private ParserCombinator dataReferenceParser = null;

    public final Start dataReference = Start.on(getNamespace(), "dataReference");

    public ParserCombinator dataReference() {
        if (dataReferenceParser == null) {
           FutureParser future = scoped("dataReference", true);
           dataReferenceParser = future;
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
                       choice(
                           token("ANY"),
                           sequence(
                               optional(
                                   token("OPTIONAL")
                               ),
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
                               ),
                               optional(
                                   sequence(
                                       token("AS"),
                                       typeName(),
                                       optional(
                                           attributeClause()
                                       )
                                   )
                               )
                           ),
                           typedefName()
                       )
                   )
               )
           );
        }

        return dataReferenceParser;
    }

    // ========================================================
    // dataValue
    // ........................................................

    private ParserCombinator dataValueParser = null;

    public final Start dataValue = Start.on(getNamespace(), "dataValue");

    public ParserCombinator dataValue() {
        if (dataValueParser == null) {
           FutureParser future = scoped("dataValue", true);
           dataValueParser = future;
           future.setParser(
               sequence(
                   optional(
                       token("BY")
                   ),
                   token("VALUE"),
                   plus(
                       choice(
                           token("ANY"),
                           sequence(
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
                           ),
                           typedefName()
                       )
                   )
               )
           );
        }

        return dataValueParser;
    }

    // ========================================================
    // dataOutput
    // ........................................................

    private ParserCombinator dataOutputParser = null;

    public final Start dataOutput = Start.on(getNamespace(), "dataOutput");

    public ParserCombinator dataOutput() {
        if (dataOutputParser == null) {
           FutureParser future = scoped("dataOutput", true);
           dataOutputParser = future;
           future.setParser(
               sequence(
                   optional(
                       token("BY")
                   ),
                   token("OUTPUT"),
                   star(
                       sequence(
                           dataName(),
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

        return dataOutputParser;
    }

    // ========================================================
    // repeatedPhrase
    // ........................................................

    private ParserCombinator repeatedPhraseParser = null;

    public final Start repeatedPhrase = Start.on(getNamespace(), "repeatedPhrase");

    public ParserCombinator repeatedPhrase() {
        if (repeatedPhraseParser == null) {
           FutureParser future = scoped("repeatedPhrase", true);
           repeatedPhraseParser = future;
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

        return repeatedPhraseParser;
    }

    // ========================================================
    // returningProcedurePhrase
    // ........................................................

    private ParserCombinator returningProcedurePhraseParser = null;

    public final Start returningProcedurePhrase = Start.on(getNamespace(), "returningProcedurePhrase");

    public ParserCombinator returningProcedurePhrase() {
        if (returningProcedurePhraseParser == null) {
           FutureParser future = scoped("returningProcedurePhrase", true);
           returningProcedurePhraseParser = future;
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

        return returningProcedurePhraseParser;
    }

    // ========================================================
    // roundedPhrase
    // ........................................................

    private ParserCombinator roundedPhraseParser = null;

    public final Start roundedPhrase = Start.on(getNamespace(), "roundedPhrase");

    public ParserCombinator roundedPhrase() {
        if (roundedPhraseParser == null) {
           FutureParser future = scoped("roundedPhrase", true);
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
           FutureParser future = scoped("declaratives", true);
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
           FutureParser future = scoped("declarativeSection", true);
           declarativeSectionParser = future;
           future.setParser(
               sequence(
                   sectionName(),
                   token("SECTION"),
                   literal("."),
                   as("sentence",
                       as("statement",
                           sequence(
                               useStatement(),
                               literal(".")
                           )
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
           FutureParser future = scoped("section", true);
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
           FutureParser future = scoped("paragraph", true);
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
           FutureParser future = scoped("sentence", true);
           sentenceParser = future;
           future.setParser(
               choice(
                   compilerStatement(),
                   sequence(
                       statement(),
                       star(
                           choice(
                               compilerStatement(),
                               statement(),
                               continuationOfStatement()
                           )
                       ),
                       literal(".")
                   ),
                   literal(".")
               )
           );
        }

        return sentenceParser;
    }

    // ========================================================
    // statement
    // ........................................................

    private ParserCombinator statementParser = null;

    public final Start statement = Start.on(getNamespace(), "statement");

    public ParserCombinator statement() {
        if (statementParser == null) {
           FutureParser future = scoped("statement", true);
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
                   "FREE"
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
                         freeStatement()
                       }
                   ),
                   sequence(
                       verb(),
                       optional(
                           skipto(
                               choice(
                                   literal("."),
                                   endOfStatement(),
                                   verb(),
                                   subStatementMarker()
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
    // subStatementMarker
    // ........................................................

    private ParserCombinator subStatementMarkerParser = null;

    public final Start subStatementMarker = Start.on(getNamespace(), "subStatementMarker");

    public ParserCombinator subStatementMarker() {
        if (subStatementMarkerParser == null) {
           FutureParser future = scoped("subStatementMarker", true);
           subStatementMarkerParser = future;
           future.setParser(
               choice(
                   token("ELSE"),
                   token("WHEN"),
                   sequence(
                       token("NOT"),
                       token("INVALID")
                   ),
                   token("INVALID"),
                   sequence(
                       token("NOT"),
                       optional(
                           token("ON")
                       ),
                       token("SIZE")
                   ),
                   sequence(
                       optional(
                           token("ON")
                       ),
                       token("SIZE")
                   ),
                   sequence(
                       token("NOT"),
                       optional(
                           token("ON")
                       ),
                       token("OVERFLOW")
                   ),
                   sequence(
                       optional(
                           token("ON")
                       ),
                       token("OVERFLOW")
                   ),
                   sequence(
                       token("NOT"),
                       optional(
                           token("ON")
                       ),
                       token("EXCEPTION")
                   ),
                   sequence(
                       optional(
                           token("ON")
                       ),
                       token("EXCEPTION")
                   ),
                   sequence(
                       token("NOT"),
                       optional(
                           token("AT")
                       ),
                       token("END")
                   ),
                   sequence(
                       optional(
                           token("AT")
                       ),
                       token("END")
                   ),
                   sequence(
                       token("NOT"),
                       optional(
                           token("AT")
                       ),
                       token("END-OF-PAGE")
                   ),
                   sequence(
                       token("NOT"),
                       optional(
                           token("AT")
                       ),
                       token("EOP")
                   ),
                   sequence(
                       optional(
                           token("AT")
                       ),
                       token("END-OF-PAGE")
                   ),
                   sequence(
                       optional(
                           token("AT")
                       ),
                       token("EOP")
                   )
               )
           );
        }

        return subStatementMarkerParser;
    }

    // ========================================================
    // continuationOfStatement
    // ........................................................

    private ParserCombinator continuationOfStatementParser = null;

    public final Start continuationOfStatement = Start.on(getNamespace(), "continuationOfStatement");

    public ParserCombinator continuationOfStatement() {
        if (continuationOfStatementParser == null) {
           FutureParser future = scoped("continuationOfStatement", true);
           continuationOfStatementParser = future;
           future.setParser(
               choice(
                   sequence(
                       assign("t", eventPhrase()),
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
                       assign("t", endOfStatementMarker()),
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
           FutureParser future = scoped("nestedStatements", true);
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

    private ParserCombinator eventPhrase() {
        if (eventPhraseParser == null) {
           FutureParser future = scoped("eventPhrase", false);
           eventPhraseParser = future;
           future.setParser(
               sequence(
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
                       assign("t", eventType())
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

    private ParserCombinator eventType() {
        if (eventTypeParser == null) {
           FutureParser future = scoped("eventType", false);
           eventTypeParser = future;
           future.setParser(
               sequence(
                   choice(
                       assign("t", token("EXCEPTION")),
                       sequence(
                           assign("t", token("SIZE")),
                           token("ERROR")
                       ),
                       assign("t", token("OVERFLOW")),
                       sequence(
                           assign("t", token("INVALID")),
                           optional(
                               token("KEY")
                           )
                       ),
                       assign("t", token("END")),
                       assign("t", token("END-OF-PAGE")),
                       assign("t", token("EOP"))
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
           FutureParser future = scoped("retryPhrase", true);
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

    public final Start endOfStatementMarker = Start.on(getNamespace(), "endOfStatementMarker");

    public ParserCombinator endOfStatementMarker() {
        if (endOfStatementMarkerParser == null) {
           FutureParser future = scoped("endOfStatementMarker", true);
           endOfStatementMarkerParser = future;
           future.setParser(
               sequence(
                   choice(
                       assign("t", token("END-ACCEPT")),
                       assign("t", token("END-ADD")),
                       assign("t", token("END-CALL")),
                       assign("t", token("END-CHAIN")),
                       assign("t", token("END-COMPUTE")),
                       assign("t", token("END-DELETE")),
                       assign("t", token("END-DIVIDE")),
                       assign("t", token("END-EVALUATE")),
                       assign("t", token("END-EXEC")),
                       assign("t", token("END-IF")),
                       assign("t", token("END-MULTIPLY")),
                       assign("t", token("END-PERFORM")),
                       assign("t", token("END-READ")),
                       assign("t", token("END-RETURN")),
                       assign("t", token("END-REWRITE")),
                       assign("t", token("END-SEARCH")),
                       assign("t", token("END-START")),
                       assign("t", token("END-STRING")),
                       assign("t", token("END-SUBTRACT")),
                       assign("t", token("END-UNSTRING")),
                       assign("t", token("END-WAIT")),
                       assign("t", token("END-WRITE"))
                   ),
                   returning("t")
               )
           );
        }

        return endOfStatementMarkerParser;
    }

    // ========================================================
    // verb
    // ........................................................

    private ParserCombinator verbParser = null;

    public final Start verb = Start.on(getNamespace(), "verb");

    public ParserCombinator verb() {
        if (verbParser == null) {
           FutureParser future = scoped("verb", true);
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
           FutureParser future = scoped("acceptStatement", true);
           acceptStatementParser = future;
           future.setParser(
               sequence(
                   token("ACCEPT"),
                   choice(
                       acceptFromDate(),
                       acceptScreenSizeData(),
                       acceptFromOther(),
                       acceptFromMnemonic(),
                       acceptMessageCount(),
                       acceptScreenFormat()
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
           FutureParser future = scoped("acceptFromMnemonic", true);
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
           FutureParser future = scoped("acceptFromOther", true);
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
           FutureParser future = scoped("acceptScreenFormat", true);
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
           FutureParser future = scoped("acceptFromDate", true);
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
           FutureParser future = scoped("acceptMessageCount", true);
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
           FutureParser future = scoped("unitPhrase", true);
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
           FutureParser future = scoped("modeIsBlockPhrase", true);
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
           FutureParser future = scoped("acceptScreenSizeData", true);
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
    // addStatement
    // ........................................................

    private ParserCombinator addStatementParser = null;

    public final Start addStatement = Start.on(getNamespace(), "addStatement");

    public ParserCombinator addStatement() {
        if (addStatementParser == null) {
           FutureParser future = scoped("addStatement", true);
           addStatementParser = future;
           future.setParser(
               sequence(
                   token("ADD"),
                   choice(
                       addition_format1(),
                       addition_format2(),
                       addition_format3()
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
    // addition_format1
    // ........................................................

    private ParserCombinator addition_format1Parser = null;

    private ParserCombinator addition_format1() {
        if (addition_format1Parser == null) {
           FutureParser future = scoped("addition_format1", false);
           addition_format1Parser = future;
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

        return addition_format1Parser;
    }

    // ========================================================
    // addition_format2
    // ........................................................

    private ParserCombinator addition_format2Parser = null;

    private ParserCombinator addition_format2() {
        if (addition_format2Parser == null) {
           FutureParser future = scoped("addition_format2", false);
           addition_format2Parser = future;
           future.setParser(
               sequence(
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

        return addition_format2Parser;
    }

    // ========================================================
    // addition_format3
    // ........................................................

    private ParserCombinator addition_format3Parser = null;

    private ParserCombinator addition_format3() {
        if (addition_format3Parser == null) {
           FutureParser future = scoped("addition_format3", false);
           addition_format3Parser = future;
           future.setParser(
               sequence(
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

        return addition_format3Parser;
    }

    // ========================================================
    // allocateStatement
    // ........................................................

    private ParserCombinator allocateStatementParser = null;

    public final Start allocateStatement = Start.on(getNamespace(), "allocateStatement");

    public ParserCombinator allocateStatement() {
        if (allocateStatementParser == null) {
           FutureParser future = scoped("allocateStatement", true);
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
           FutureParser future = scoped("alterStatement", true);
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
           FutureParser future = scoped("alterationClause", true);
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
           FutureParser future = scoped("callStatement", true);
           callStatementParser = future;
           future.setParser(
               sequence(
                   token("CALL"),
                   choice(
                       token("NESTED"),
                       alphanumericLiteral(),
                       sequence(
                           identifier(),
                           optional(
                               choice(
                                   alphanumericLiteral(),
                                   identifier()
                               )
                           )
                       )
                   ),
                   optional(
                       sequence(
                           token("AS"),
                           choice(
                               token("NESTED"),
                               programName()
                           )
                       )
                   ),
                   optional(
                       callUsing()
                   ),
                   optional(
                       callGivingOrReturning()
                   ),
                   optional(
                       choice(
                           onOverflow(),
                           sequence(
                               onException(),
                               optional(
                                   notOnException()
                               )
                           ),
                           notOnException()
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
    // callUsing
    // ........................................................

    private ParserCombinator callUsingParser = null;

    public final Start callUsing = Start.on(getNamespace(), "callUsing");

    public ParserCombinator callUsing() {
        if (callUsingParser == null) {
           FutureParser future = scoped("callUsing", true);
           callUsingParser = future;
           future.setParser(
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
                                   sequence(
                                       token("ADDRESS"),
                                       token("OF"),
                                       identifier()
                                   ),
                                   token("OMITTED"),
                                   identifier(),
                                   literal()
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
                               optional(
                                   token("BY")
                               ),
                               token("VALUE"),
                               choice(
                                   sequence(
                                       token("LENGTH"),
                                       token("OF"),
                                       identifier(),
                                       optional(
                                           sequence(
                                               token("SIZE"),
                                               optional(
                                                   token("IS")
                                               ),
                                               optional(
                                                   choice(
                                                       sequence(
                                                           token("LENGTH"),
                                                           token("OF"),
                                                           identifier()
                                                       ),
                                                       integer()
                                                   )
                                               )
                                           )
                                       )
                                   ),
                                   sequence(
                                       integer(),
                                       token("SIZE"),
                                       optional(
                                           token("IS")
                                       ),
                                       optional(
                                           choice(
                                               sequence(
                                                   token("LENGTH"),
                                                   token("OF"),
                                                   identifier()
                                               ),
                                               integer()
                                           )
                                       )
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
                           )
                       )
                   )
               )
           );
        }

        return callUsingParser;
    }

    // ========================================================
    // callGivingOrReturning
    // ........................................................

    private ParserCombinator callGivingOrReturningParser = null;

    public final Start callGivingOrReturning = Start.on(getNamespace(), "callGivingOrReturning");

    public ParserCombinator callGivingOrReturning() {
        if (callGivingOrReturningParser == null) {
           FutureParser future = scoped("callGivingOrReturning", true);
           callGivingOrReturningParser = future;
           future.setParser(
               sequence(
                   choice(
                       token("GIVING"),
                       token("RETURNING")
                   ),
                   optional(
                       choice(
                           token("INTO"),
                           sequence(
                               token("ADDRESS"),
                               token("OF")
                           )
                       )
                   ),
                   identifier()
               )
           );
        }

        return callGivingOrReturningParser;
    }

    // ========================================================
    // onOverflow
    // ........................................................

    private ParserCombinator onOverflowParser = null;

    public final Start onOverflow = Start.on(getNamespace(), "onOverflow");

    public ParserCombinator onOverflow() {
        if (onOverflowParser == null) {
           FutureParser future = scoped("onOverflow", true);
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
           FutureParser future = scoped("notOnOverflow", true);
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
           FutureParser future = scoped("onException", true);
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
           FutureParser future = scoped("notOnException", true);
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
           FutureParser future = scoped("onSizeError", true);
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
           FutureParser future = scoped("notOnSizeError", true);
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
           FutureParser future = scoped("onEscape", true);
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
           FutureParser future = scoped("notOnEscape", true);
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
    // programID
    // ........................................................

    private ParserCombinator programIDParser = null;

    public final Start programID = Start.on(getNamespace(), "programID");

    public ParserCombinator programID() {
        if (programIDParser == null) {
           FutureParser future = scoped("programID", true);
           programIDParser = future;
           future.setParser(
               choice(
                   identifier(),
                   alphanumeric()
               )
           );
        }

        return programIDParser;
    }

    // ========================================================
    // cancelStatement
    // ........................................................

    private ParserCombinator cancelStatementParser = null;

    public final Start cancelStatement = Start.on(getNamespace(), "cancelStatement");

    public ParserCombinator cancelStatement() {
        if (cancelStatementParser == null) {
           FutureParser future = scoped("cancelStatement", true);
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
           FutureParser future = scoped("chainStatement", true);
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
           FutureParser future = scoped("chainUsing", true);
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
                                       sequence(
                                           optional(
                                               sequence(
                                                   token("ADDRESS"),
                                                   token("OF")
                                               )
                                           ),
                                           identifier()
                                       ),
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
                                       sequence(
                                           optional(
                                               sequence(
                                                   token("LENGTH"),
                                                   token("OF")
                                               )
                                           ),
                                           identifier()
                                       ),
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
           FutureParser future = scoped("closeStatement", true);
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
           FutureParser future = scoped("commitStatement", true);
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
           FutureParser future = scoped("computeStatement", true);
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
           FutureParser future = scoped("continueStatement", true);
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
           FutureParser future = scoped("deleteStatement", true);
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
           FutureParser future = scoped("invalidKey", true);
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
           FutureParser future = scoped("notInvalidKey", true);
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
           FutureParser future = scoped("deleteFileStatement", true);
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
           FutureParser future = scoped("disableStatement", true);
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
           FutureParser future = scoped("displayStatement", true);
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
           FutureParser future = scoped("displayStatement__", true);
           displayStatement__Parser = future;
           future.setParser(
               sequence(
                   token("DISPLAY"),
                   choice(
                       displayTerminalFormat(),
                       displayDeviceFormat()
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
           FutureParser future = scoped("displayDeviceFormat", true);
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
           FutureParser future = scoped("uponClause", true);
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
           FutureParser future = scoped("withNoAdvancing", true);
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
           FutureParser future = scoped("displayTerminalFormat", true);
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
           FutureParser future = scoped("dtAtPositioning", true);
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
           FutureParser future = scoped("dtLineColPositioning", true);
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
           FutureParser future = scoped("dtLinePos", true);
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
           FutureParser future = scoped("dtColPos", true);
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
           FutureParser future = scoped("screenEntryPhrase", true);
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
           FutureParser future = scoped("autoPhrase", true);
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
           FutureParser future = scoped("backgroundPhrase", true);
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
           FutureParser future = scoped("beepPhrase", true);
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
           FutureParser future = scoped("blankPhrase", true);
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
           FutureParser future = scoped("blinkPhrase", true);
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
           FutureParser future = scoped("boldPhrase", true);
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
           FutureParser future = scoped("capitalizationPhrase", true);
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
           FutureParser future = scoped("controlPhrase", true);
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
           FutureParser future = scoped("convertPhrase", true);
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
           FutureParser future = scoped("cursorPhrase", true);
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
           FutureParser future = scoped("echoPhrase", true);
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
           FutureParser future = scoped("erasePhrase", true);
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
           FutureParser future = scoped("foregroundPhrase", true);
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
           FutureParser future = scoped("fullPhrase", true);
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
           FutureParser future = scoped("gridPhrase", true);
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
           FutureParser future = scoped("highPhrase", true);
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
           FutureParser future = scoped("linePhrase", true);
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
           FutureParser future = scoped("lowPhrase", true);
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
           FutureParser future = scoped("offPhrase", true);
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
           FutureParser future = scoped("promptPhrase", true);
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
           FutureParser future = scoped("requiredPhrase", true);
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
           FutureParser future = scoped("reversePhrase", true);
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
           FutureParser future = scoped("scrollPhrase", true);
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
           FutureParser future = scoped("securePhrase", true);
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
           FutureParser future = scoped("sizePhrase", true);
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
           FutureParser future = scoped("standardPhrase", true);
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
           FutureParser future = scoped("tabPhrase", true);
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
           FutureParser future = scoped("timePhrase", true);
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
           FutureParser future = scoped("timeoutPhrase", true);
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
           FutureParser future = scoped("justificationPhrase", true);
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
           FutureParser future = scoped("fillPhrase", true);
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
           FutureParser future = scoped("trailingSignPhrase", true);
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
           FutureParser future = scoped("updatePhrase", true);
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
           FutureParser future = scoped("divideStatement", true);
           divideStatementParser = future;
           future.setParser(
               sequence(
                   token("DIVIDE"),
                   choice(
                       division_format1(),
                       division_format2(),
                       division_format3()
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
    // division_format1
    // ........................................................

    private ParserCombinator division_format1Parser = null;

    private ParserCombinator division_format1() {
        if (division_format1Parser == null) {
           FutureParser future = scoped("division_format1", false);
           division_format1Parser = future;
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
                           assign("identifier", qualifiedDataName()),
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

        return division_format1Parser;
    }

    // ========================================================
    // division_format2
    // ........................................................

    private ParserCombinator division_format2Parser = null;

    private ParserCombinator division_format2() {
        if (division_format2Parser == null) {
           FutureParser future = scoped("division_format2", false);
           division_format2Parser = future;
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

        return division_format2Parser;
    }

    // ========================================================
    // division_format3
    // ........................................................

    private ParserCombinator division_format3Parser = null;

    private ParserCombinator division_format3() {
        if (division_format3Parser == null) {
           FutureParser future = scoped("division_format3", false);
           division_format3Parser = future;
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

        return division_format3Parser;
    }

    // ========================================================
    // enableStatement
    // ........................................................

    private ParserCombinator enableStatementParser = null;

    public final Start enableStatement = Start.on(getNamespace(), "enableStatement");

    public ParserCombinator enableStatement() {
        if (enableStatementParser == null) {
           FutureParser future = scoped("enableStatement", true);
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
           FutureParser future = scoped("entryStatement", true);
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
           FutureParser future = scoped("evaluateStatement", true);
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
           FutureParser future = scoped("subject", true);
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
           FutureParser future = scoped("when", true);
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
           FutureParser future = scoped("whenOther", true);
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
           FutureParser future = scoped("object", true);
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
           FutureParser future = scoped("rangeExpression", true);
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
           FutureParser future = scoped("examineStatement", true);
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

    private ParserCombinator execStatement() {
        if (execStatementParser == null) {
           FutureParser future = scoped("execStatement", false);
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
           FutureParser future = scoped("execSQLStatement", true);
           execSQLStatementParser = future;
           future.setParser(
               sequence(
                   choice(
                       token("EXEC"),
                       token("EXECUTE")
                   ),
                   token("SQL"),
                   sequence(
                       limited(
                           optional(
                               sqlStatement()
                           ),
                           token("END-EXEC")
                       ),
                       skipto(
                           token("END-EXEC")
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
           FutureParser future = scoped("execCICSStatement", true);
           execCICSStatementParser = future;
           future.setParser(
               sequence(
                   choice(
                       token("EXEC"),
                       token("EXECUTE")
                   ),
                   token("CICS"),
                   sequence(
                       limited(
                           optional(
                               cicsStatement()
                           ),
                           token("END-EXEC")
                       ),
                       skipto(
                           token("END-EXEC")
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
           FutureParser future = scoped("execDLIStatement", true);
           execDLIStatementParser = future;
           future.setParser(
               sequence(
                   choice(
                       token("EXEC"),
                       token("EXECUTE")
                   ),
                   token("DLI"),
                   optional(
                       skipto(
                           token("END-EXEC")
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
           FutureParser future = scoped("execHTMLStatement", true);
           execHTMLStatementParser = future;
           future.setParser(
               sequence(
                   choice(
                       token("EXEC"),
                       token("EXECUTE")
                   ),
                   token("HTML"),
                   optional(
                       skipto(
                           token("END-EXEC")
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
           FutureParser future = scoped("execTextDataStatement", true);
           execTextDataStatementParser = future;
           future.setParser(
               sequence(
                   choice(
                       token("EXEC"),
                       token("EXECUTE")
                   ),
                   textName(),
                   optional(
                       skipto(
                           token("END-EXEC")
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
           FutureParser future = scoped("exitStatement", true);
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
           FutureParser future = scoped("returningPhrase", true);
           returningPhraseParser = future;
           future.setParser(
               sequence(
                   choice(
                       token("GIVING"),
                       token("RETURNING")
                   ),
                   choice(
                       integer(),
                       sequence(
                           token("ADDRESS"),
                           token("OF"),
                           identifier()
                       )
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
           FutureParser future = scoped("generateStatement", true);
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
           FutureParser future = scoped("freeStatement", true);
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
           FutureParser future = scoped("gobackStatement", true);
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
                               sequence(
                                   optional(
                                       sequence(
                                           token("ADDRESS"),
                                           token("OF")
                                       )
                                   ),
                                   identifier()
                               ),
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
           FutureParser future = scoped("goToStatement", true);
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
           FutureParser future = scoped("dependingOn", true);
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
           FutureParser future = scoped("ifStatement", true);
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
           FutureParser future = scoped("thenBranch", true);
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
           FutureParser future = scoped("elseBranch", true);
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
           FutureParser future = scoped("initiateStatement", true);
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
           FutureParser future = scoped("invokeStatement", true);
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
                                           sequence(
                                               token("ADDRESS"),
                                               token("OF"),
                                               identifier()
                                           ),
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
                           optional(
                               choice(
                                   token("INTO"),
                                   sequence(
                                       token("ADDRESS"),
                                       token("OF")
                                   )
                               )
                           ),
                           identifier()
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
           FutureParser future = scoped("exhibitStatement", true);
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
           FutureParser future = scoped("identifiedByStatement", true);
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
           FutureParser future = scoped("initializeStatement", true);
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
                       skipto(
                           choice(
                               literal("."),
                               endOfStatement()
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
           FutureParser future = scoped("replacingInitClause", true);
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
           FutureParser future = scoped("replacementTarget", true);
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
           FutureParser future = scoped("inspectStatement", true);
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
           FutureParser future = scoped("convertingPhrase", true);
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
           FutureParser future = scoped("tallyingPhrase", true);
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
           FutureParser future = scoped("tallyingCharactersPhrase", true);
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
           FutureParser future = scoped("tallyingAllLeadingOrTrailingPhrase", true);
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
           FutureParser future = scoped("replacingPhrase", true);
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
           FutureParser future = scoped("replacingCharactersPhrase", true);
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
           FutureParser future = scoped("replacingAllLeadingFirstOrTrailingPhrase", true);
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
           FutureParser future = scoped("locationPhrase", true);
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
           FutureParser future = scoped("mergeStatement", true);
           mergeStatementParser = future;
           future.setParser(
               sequence(
                   token("MERGE"),
                   fileName(),
                   plus(
                       sequence(
                           optional(
                               token("ON")
                           ),
                           choice(
                               token("ASCENDING"),
                               token("DESCENDING")
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
                   ),
                   optional(
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
                   ),
                   token("USING"),
                   fileName(),
                   plus(
                       fileName()
                   ),
                   choice(
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
                       ),
                       sequence(
                           token("GIVING"),
                           plus(
                               fileName()
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
           FutureParser future = scoped("moveStatement", true);
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
                       skipto(
                           choice(
                               literal("."),
                               endOfStatement()
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
           FutureParser future = scoped("multiplyStatement", true);
           multiplyStatementParser = future;
           future.setParser(
               sequence(
                   token("MULTIPLY"),
                   choice(
                       multiplication_format1(),
                       multiplication_format2()
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
    // multiplication_format1
    // ........................................................

    private ParserCombinator multiplication_format1Parser = null;

    private ParserCombinator multiplication_format1() {
        if (multiplication_format1Parser == null) {
           FutureParser future = scoped("multiplication_format1", false);
           multiplication_format1Parser = future;
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

        return multiplication_format1Parser;
    }

    // ========================================================
    // multiplication_format2
    // ........................................................

    private ParserCombinator multiplication_format2Parser = null;

    private ParserCombinator multiplication_format2() {
        if (multiplication_format2Parser == null) {
           FutureParser future = scoped("multiplication_format2", false);
           multiplication_format2Parser = future;
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

        return multiplication_format2Parser;
    }

    // ========================================================
    // nextSentenceStatement
    // ........................................................

    private ParserCombinator nextSentenceStatementParser = null;

    public final Start nextSentenceStatement = Start.on(getNamespace(), "nextSentenceStatement");

    public ParserCombinator nextSentenceStatement() {
        if (nextSentenceStatementParser == null) {
           FutureParser future = scoped("nextSentenceStatement", true);
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
           FutureParser future = scoped("onStatement", true);
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
           FutureParser future = scoped("openStatement", true);
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
           FutureParser future = scoped("performStatement", true);
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
                       ),
                       sequence(
                           token("VARYING"),
                           identifier(),
                           token("THROUGH"),
                           identifier(),
                           nestedStatements(),
                           token("END-PERFORM")
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
           FutureParser future = scoped("times", true);
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
           FutureParser future = scoped("testPosition", true);
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
           FutureParser future = scoped("until", true);
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
           FutureParser future = scoped("varying", true);
           varyingParser = future;
           future.setParser(
               sequence(
                   optional(
                       testPosition()
                   ),
                   token("VARYING"),
                   identifier(),
                   token("FROM"),
                   choice(
                       literal(),
                       identifier()
                   ),
                   token("BY"),
                   choice(
                       literal(),
                       identifier()
                   ),
                   token("UNTIL"),
                   condition(),
                   star(
                       sequence(
                           token("AFTER"),
                           identifier(),
                           token("FROM"),
                           choice(
                               literal(),
                               identifier()
                           ),
                           token("BY"),
                           choice(
                               literal(),
                               identifier()
                           ),
                           token("UNTIL"),
                           condition()
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
           FutureParser future = scoped("purgeStatement", true);
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
           FutureParser future = scoped("raiseStatement", true);
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
           FutureParser future = scoped("readStatement", true);
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
           FutureParser future = scoped("readWithClause", true);
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
           FutureParser future = scoped("readLockClause", true);
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
           FutureParser future = scoped("readyTraceStatement", true);
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
           FutureParser future = scoped("receiveStatement", true);
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
           FutureParser future = scoped("noData", true);
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
           FutureParser future = scoped("withData", true);
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
           FutureParser future = scoped("releaseStatement", true);
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
           FutureParser future = scoped("resetTraceStatement", true);
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
           FutureParser future = scoped("returnStatement", true);
           returnStatementParser = future;
           future.setParser(
               sequence(
                   token("RETURN"),
                   fileName(),
                   optional(
                       token("RECORD")
                   ),
                   optional(
                       sequence(
                           token("INTO"),
                           identifier()
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
           FutureParser future = scoped("rewriteStatement", true);
           rewriteStatementParser = future;
           future.setParser(
               sequence(
                   token("REWRITE"),
                   recordName(),
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
           FutureParser future = scoped("rollbackStatement", true);
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
           FutureParser future = scoped("searchStatement", true);
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
           FutureParser future = scoped("atEnd", true);
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
           FutureParser future = scoped("notAtEnd", true);
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
           FutureParser future = scoped("sendStatement", true);
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
           FutureParser future = scoped("serviceStatement", true);
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
           FutureParser future = scoped("sortStatement", true);
           sortStatementParser = future;
           future.setParser(
               choice(
                   sequence(
                       token("SORT"),
                       fileName(),
                       plus(
                           sequence(
                               token("ON"),
                               plus(
                                   sequence(
                                       choice(
                                           token("ASCENDING"),
                                           token("DESCENDING")
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
                       ),
                       optional(
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
                       ),
                       optional(
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
                       ),
                       choice(
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
                           ),
                           sequence(
                               token("USING"),
                               plus(
                                   fileName()
                               )
                           )
                       ),
                       choice(
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
                           ),
                           sequence(
                               token("GIVING"),
                               plus(
                                   fileName()
                               )
                           )
                       )
                   ),
                   sequence(
                       token("SORT"),
                       dataName(),
                       plus(
                           sequence(
                               token("ON"),
                               plus(
                                   sequence(
                                       choice(
                                           token("ASCENDING"),
                                           token("DESCENDING")
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
                       ),
                       optional(
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
                       ),
                       optional(
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
           FutureParser future = scoped("setStatement", true);
           setStatementParser = future;
           future.setParser(
               sequence(
                   token("SET"),
                   choice(
                       setEnvironmentVariable(),
                       setOther()
                   ),
                   optional(
                       skipto(
                           choice(
                               literal("."),
                               endOfStatement()
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
           FutureParser future = scoped("setEnvironmentVariable", true);
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
           FutureParser future = scoped("setOther", true);
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
                           name(),
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
                               integer(),
                               identifier()
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
           FutureParser future = scoped("startStatement", true);
           startStatementParser = future;
           future.setParser(
               sequence(
                   token("START"),
                   fileName(),
                   optional(
                       keyModifier()
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
    // keyModifier
    // ........................................................

    private ParserCombinator keyModifierParser = null;

    public final Start keyModifier = Start.on(getNamespace(), "keyModifier");

    public ParserCombinator keyModifier() {
        if (keyModifierParser == null) {
           FutureParser future = scoped("keyModifier", true);
           keyModifierParser = future;
           future.setParser(
               sequence(
                   token("KEY"),
                   optional(
                       token("IS")
                   ),
                   choice(
                       relop(),
                       token("FIRST"),
                       token("LAST")
                   ),
                   identifier(),
                   star(
                       sequence(
                           token("IN"),
                           identifier()
                       )
                   )
               )
           );
        }

        return keyModifierParser;
    }

    // ========================================================
    // sizeModifier
    // ........................................................

    private ParserCombinator sizeModifierParser = null;

    public final Start sizeModifier = Start.on(getNamespace(), "sizeModifier");

    public ParserCombinator sizeModifier() {
        if (sizeModifierParser == null) {
           FutureParser future = scoped("sizeModifier", true);
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
           FutureParser future = scoped("whileKeyModifier", true);
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
           FutureParser future = scoped("likeMods", true);
           likeModsParser = future;
           future.setParser(
               choice(
                   trimmedRight(),
                   trimmedLeft(),
                   caseSensitive(),
                   caseInsensitive()
               )
           );
        }

        return likeModsParser;
    }

    // ========================================================
    // trimmedRight
    // ........................................................

    private ParserCombinator trimmedRightParser = null;

    public final Start trimmedRight = Start.on(getNamespace(), "trimmedRight");

    public ParserCombinator trimmedRight() {
        if (trimmedRightParser == null) {
           FutureParser future = scoped("trimmedRight", true);
           trimmedRightParser = future;
           future.setParser(
               sequence(
                   token("TRIMMED"),
                   token("RIGHT")
               )
           );
        }

        return trimmedRightParser;
    }

    // ========================================================
    // trimmedLeft
    // ........................................................

    private ParserCombinator trimmedLeftParser = null;

    public final Start trimmedLeft = Start.on(getNamespace(), "trimmedLeft");

    public ParserCombinator trimmedLeft() {
        if (trimmedLeftParser == null) {
           FutureParser future = scoped("trimmedLeft", true);
           trimmedLeftParser = future;
           future.setParser(
               sequence(
                   token("TRIMMED"),
                   token("LEFT")
               )
           );
        }

        return trimmedLeftParser;
    }

    // ========================================================
    // caseSensitive
    // ........................................................

    private ParserCombinator caseSensitiveParser = null;

    public final Start caseSensitive = Start.on(getNamespace(), "caseSensitive");

    public ParserCombinator caseSensitive() {
        if (caseSensitiveParser == null) {
           FutureParser future = scoped("caseSensitive", true);
           caseSensitiveParser = future;
           future.setParser(
               token("CASE-SENSITIVE")
           );
        }

        return caseSensitiveParser;
    }

    // ========================================================
    // caseInsensitive
    // ........................................................

    private ParserCombinator caseInsensitiveParser = null;

    public final Start caseInsensitive = Start.on(getNamespace(), "caseInsensitive");

    public ParserCombinator caseInsensitive() {
        if (caseInsensitiveParser == null) {
           FutureParser future = scoped("caseInsensitive", true);
           caseInsensitiveParser = future;
           future.setParser(
               token("CASE-INSENSITIVE")
           );
        }

        return caseInsensitiveParser;
    }

    // ========================================================
    // stopStatement
    // ........................................................

    private ParserCombinator stopStatementParser = null;

    public final Start stopStatement = Start.on(getNamespace(), "stopStatement");

    public ParserCombinator stopStatement() {
        if (stopStatementParser == null) {
           FutureParser future = scoped("stopStatement", true);
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
                                           sequence(
                                               optional(
                                                   sequence(
                                                       token("ADDRESS"),
                                                       token("OF")
                                                   )
                                               ),
                                               identifier()
                                           ),
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
           FutureParser future = scoped("stringStatement", true);
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
           FutureParser future = scoped("subtractStatement", true);
           subtractStatementParser = future;
           future.setParser(
               sequence(
                   token("SUBTRACT"),
                   choice(
                       subtraction_format1(),
                       subtraction_format2(),
                       subtraction_format3()
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
    // subtraction_format1
    // ........................................................

    private ParserCombinator subtraction_format1Parser = null;

    private ParserCombinator subtraction_format1() {
        if (subtraction_format1Parser == null) {
           FutureParser future = scoped("subtraction_format1", false);
           subtraction_format1Parser = future;
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

        return subtraction_format1Parser;
    }

    // ========================================================
    // subtraction_format2
    // ........................................................

    private ParserCombinator subtraction_format2Parser = null;

    private ParserCombinator subtraction_format2() {
        if (subtraction_format2Parser == null) {
           FutureParser future = scoped("subtraction_format2", false);
           subtraction_format2Parser = future;
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

        return subtraction_format2Parser;
    }

    // ========================================================
    // subtraction_format3
    // ........................................................

    private ParserCombinator subtraction_format3Parser = null;

    private ParserCombinator subtraction_format3() {
        if (subtraction_format3Parser == null) {
           FutureParser future = scoped("subtraction_format3", false);
           subtraction_format3Parser = future;
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

        return subtraction_format3Parser;
    }

    // ========================================================
    // suppressStatement
    // ........................................................

    private ParserCombinator suppressStatementParser = null;

    public final Start suppressStatement = Start.on(getNamespace(), "suppressStatement");

    public ParserCombinator suppressStatement() {
        if (suppressStatementParser == null) {
           FutureParser future = scoped("suppressStatement", true);
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
           FutureParser future = scoped("terminateStatement", true);
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
           FutureParser future = scoped("transformStatement", true);
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
           FutureParser future = scoped("unlockStatement", true);
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
           FutureParser future = scoped("unstringStatement", true);
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
           FutureParser future = scoped("useStatement", true);
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
           FutureParser future = scoped("errorDeclarative", true);
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
           FutureParser future = scoped("debugDeclarative", true);
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
           FutureParser future = scoped("labelDeclarative", true);
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
           FutureParser future = scoped("beforeReportingDeclarative", true);
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
           FutureParser future = scoped("waitStatement", true);
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
           FutureParser future = scoped("writeStatement", true);
           writeStatementParser = future;
           future.setParser(
               sequence(
                   token("WRITE"),
                   recordName(),
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
                               mnemonicName(),
                               token("PAGE"),
                               token("TAB"),
                               token("FORMFEED")
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
           FutureParser future = scoped("atEndOfPage", true);
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
           FutureParser future = scoped("notAtEndOfPage", true);
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
           FutureParser future = scoped("xmlGenerateStatement", true);
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
           FutureParser future = scoped("xmlParseStatement", true);
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
    // compilerStatement
    // ........................................................

    private ParserCombinator compilerStatementParser = null;

    public final Start compilerStatement = Start.on(getNamespace(), "compilerStatement");

    public ParserCombinator compilerStatement() {
        if (compilerStatementParser == null) {
           FutureParser future = scoped("compilerStatement", true);
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
           FutureParser future = scoped("compilerDirective", true);
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
           FutureParser future = scoped("compilerIfStatement", true);
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
           FutureParser future = scoped("compilerDisplayStatement", true);
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
           FutureParser future = scoped("copyOperandName", true);
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
    // replaceStatement
    // ........................................................

    private ParserCombinator replaceStatementParser = null;

    public final Start replaceStatement = Start.on(getNamespace(), "replaceStatement");

    public ParserCombinator replaceStatement() {
        if (replaceStatementParser == null) {
           FutureParser future = scoped("replaceStatement", true);
           replaceStatementParser = future;
           future.setParser(
               sequence(
                   token("REPLACE"),
                   choice(
                       token("OFF"),
                       plus(
                           choice(
                               sequence(
                                   pseudoLiteral(),
                                   token("BY"),
                                   pseudoLiteral()
                               ),
                               sequence(
                                   choice(
                                       token("LEADING"),
                                       token("TRAILING")
                                   ),
                                   pseudoLiteral(),
                                   token("BY"),
                                   pseudoLiteral()
                               )
                           )
                       )
                   ),
                   optional(
                       literal(".")
                   )
               )
           );
        }

        return replaceStatementParser;
    }

    // ========================================================
    // sourceFormattingDirective
    // ........................................................

    private ParserCombinator sourceFormattingDirectiveParser = null;

    public final Start sourceFormattingDirective = Start.on(getNamespace(), "sourceFormattingDirective");

    public ParserCombinator sourceFormattingDirective() {
        if (sourceFormattingDirectiveParser == null) {
           FutureParser future = scoped("sourceFormattingDirective", true);
           sourceFormattingDirectiveParser = future;
           future.setParser(
               choice(
                   ejectStatement(),
                   skipStatement(),
                   titleStatement()
               )
           );
        }

        return sourceFormattingDirectiveParser;
    }

    // ========================================================
    // ejectStatement
    // ........................................................

    private ParserCombinator ejectStatementParser = null;

    public final Start ejectStatement = Start.on(getNamespace(), "ejectStatement");

    public ParserCombinator ejectStatement() {
        if (ejectStatementParser == null) {
           FutureParser future = scoped("ejectStatement", true);
           ejectStatementParser = future;
           future.setParser(
               sequence(
                   token("EJECT"),
                   optional(
                       literal(".")
                   )
               )
           );
        }

        return ejectStatementParser;
    }

    // ========================================================
    // skipStatement
    // ........................................................

    private ParserCombinator skipStatementParser = null;

    public final Start skipStatement = Start.on(getNamespace(), "skipStatement");

    public ParserCombinator skipStatement() {
        if (skipStatementParser == null) {
           FutureParser future = scoped("skipStatement", true);
           skipStatementParser = future;
           future.setParser(
               sequence(
                   choice(
                       token("SKIP1"),
                       token("SKIP2"),
                       token("SKIP3")
                   ),
                   optional(
                       literal(".")
                   )
               )
           );
        }

        return skipStatementParser;
    }

    // ========================================================
    // titleStatement
    // ........................................................

    private ParserCombinator titleStatementParser = null;

    public final Start titleStatement = Start.on(getNamespace(), "titleStatement");

    public ParserCombinator titleStatement() {
        if (titleStatementParser == null) {
           FutureParser future = scoped("titleStatement", true);
           titleStatementParser = future;
           future.setParser(
               sequence(
                   token("TITLE"),
                   literal(),
                   optional(
                       literal(".")
                   )
               )
           );
        }

        return titleStatementParser;
    }

    // ========================================================
    // divisionStart
    // ........................................................

    private ParserCombinator divisionStartParser = null;

    public final Start divisionStart = Start.on(getNamespace(), "divisionStart");

    public ParserCombinator divisionStart() {
        if (divisionStartParser == null) {
           FutureParser future = scoped("divisionStart", true);
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
                           optional(
                               usingOrChainingPhrase()
                           ),
                           optional(
                               returningProcedurePhrase()
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
           FutureParser future = scoped("sectionStart", true);
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
           FutureParser future = scoped("paragraphStart", true);
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
    // endOfStatement
    // ........................................................

    private ParserCombinator endOfStatementParser = null;

    public final Start endOfStatement = Start.on(getNamespace(), "endOfStatement");

    public ParserCombinator endOfStatement() {
        if (endOfStatementParser == null) {
           FutureParser future = scoped("endOfStatement", true);
           endOfStatementParser = future;
           future.setParser(
               choice(
                   verb(),
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
                       optional(
                           choice(
                               token("ON"),
                               token("AT")
                           )
                       ),
                       choice(
                           token("OVERFLOW"),
                           token("EXCEPTION"),
                           sequence(
                               token("SIZE"),
                               token("ERROR")
                           ),
                           sequence(
                               token("INVALID"),
                               optional(
                                   token("KEY")
                               )
                           ),
                           token("END"),
                           token("END-OF-PAGE"),
                           token("EOP")
                       )
                   )
               )
           );
        }

        return endOfStatementParser;
    }

    // ========================================================
    // function
    // ........................................................

    private ParserCombinator functionParser = null;

    public final Start function = Start.on(getNamespace(), "function");

    public ParserCombinator function() {
        if (functionParser == null) {
           FutureParser future = scoped("function", true);
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
           FutureParser future = scoped("identifier", true);
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
           FutureParser future = scoped("identifier_format1", true);
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
           FutureParser future = scoped("identifier_format2", true);
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
           FutureParser future = scoped("identifier_format6", true);
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
           FutureParser future = scoped("dataAddressIdentifier", true);
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
           FutureParser future = scoped("qualifiedLinageCounter", true);
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
           FutureParser future = scoped("qualifiedReportCounter", true);
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
           FutureParser future = scoped("argument", true);
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
           FutureParser future = scoped("qualifier", true);
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
           FutureParser future = scoped("subscript", true);
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
           FutureParser future = scoped("directSubscript", true);
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
           FutureParser future = scoped("relativeSubscript", true);
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
           FutureParser future = scoped("referenceModifier", true);
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
           FutureParser future = scoped("arithmeticExpression", true);
           arithmeticExpressionParser = future;
           future.setParser(
               sequence(
                   expression(),
                   star(
                       sequence(
                           bitwiseOp(),
                           expression()
                       )
                   )
               )
           );
        }

        return arithmeticExpressionParser;
    }

    // ========================================================
    // bitwiseOp
    // ........................................................

    private ParserCombinator bitwiseOpParser = null;

    private ParserCombinator bitwiseOp() {
        if (bitwiseOpParser == null) {
           FutureParser future = scoped("bitwiseOp", false);
           bitwiseOpParser = future;
           future.setParser(
               choice(
                   as("bAND",
                       token("B-AND")
                   ),
                   as("bOR",
                       token("B-OR")
                   ),
                   as("bXOR",
                       choice(
                           token("B-XOR"),
                           token("B-EXOR")
                       )
                   )
               )
           );
        }

        return bitwiseOpParser;
    }

    // ========================================================
    // expression
    // ........................................................

    private ParserCombinator expressionParser = null;

    public final Start expression = Start.on(getNamespace(), "expression");

    public ParserCombinator expression() {
        if (expressionParser == null) {
           FutureParser future = scoped("expression", true);
           expressionParser = future;
           future.setParser(
               sequence(
                   term(),
                   star(
                       sequence(
                           addingOp(),
                           term()
                       )
                   )
               )
           );
        }

        return expressionParser;
    }

    // ========================================================
    // addingOp
    // ........................................................

    private ParserCombinator addingOpParser = null;

    private ParserCombinator addingOp() {
        if (addingOpParser == null) {
           FutureParser future = scoped("addingOp", false);
           addingOpParser = future;
           future.setParser(
               choice(
                   as("add",
                       literal("+")
                   ),
                   as("subtract",
                       literal("-")
                   )
               )
           );
        }

        return addingOpParser;
    }

    // ========================================================
    // term
    // ........................................................

    private ParserCombinator termParser = null;

    public final Start term = Start.on(getNamespace(), "term");

    public ParserCombinator term() {
        if (termParser == null) {
           FutureParser future = scoped("term", true);
           termParser = future;
           future.setParser(
               sequence(
                   factor(),
                   star(
                       sequence(
                           choice(
                               literal("*"),
                               literal("/")
                           ),
                           factor()
                       )
                   )
               )
           );
        }

        return termParser;
    }

    // ========================================================
    // multiplyingOp
    // ........................................................

    private ParserCombinator multiplyingOpParser = null;

    private ParserCombinator multiplyingOp() {
        if (multiplyingOpParser == null) {
           FutureParser future = scoped("multiplyingOp", false);
           multiplyingOpParser = future;
           future.setParser(
               choice(
                   as("multiply",
                       literal("*")
                   ),
                   as("divide",
                       literal("/")
                   )
               )
           );
        }

        return multiplyingOpParser;
    }

    // ========================================================
    // factor
    // ........................................................

    private ParserCombinator factorParser = null;

    public final Start factor = Start.on(getNamespace(), "factor");

    public ParserCombinator factor() {
        if (factorParser == null) {
           FutureParser future = scoped("factor", true);
           factorParser = future;
           future.setParser(
               sequence(
                   optional(
                       unaryOp()
                   ),
                   atom(),
                   star(
                       sequence(
                           exponentiationOp(),
                           optional(
                               unaryOp()
                           ),
                           atom()
                       )
                   )
               )
           );
        }

        return factorParser;
    }

    // ========================================================
    // unaryOp
    // ........................................................

    private ParserCombinator unaryOpParser = null;

    private ParserCombinator unaryOp() {
        if (unaryOpParser == null) {
           FutureParser future = scoped("unaryOp", false);
           unaryOpParser = future;
           future.setParser(
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
           );
        }

        return unaryOpParser;
    }

    // ========================================================
    // exponentiationOp
    // ........................................................

    private ParserCombinator exponentiationOpParser = null;

    private ParserCombinator exponentiationOp() {
        if (exponentiationOpParser == null) {
           FutureParser future = scoped("exponentiationOp", false);
           exponentiationOpParser = future;
           future.setParser(
               as("exp",
                   literal("**")
               )
           );
        }

        return exponentiationOpParser;
    }

    // ========================================================
    // atom
    // ........................................................

    private ParserCombinator atomParser = null;

    private ParserCombinator atom() {
        if (atomParser == null) {
           FutureParser future = scoped("atom", false);
           atomParser = future;
           future.setParser(
               choice(
                   zero(),
                   identifier(),
                   numeric(),
                   sequence(
                       literal("("),
                       arithmeticExpression(),
                       literal(")")
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

    private ParserCombinator moreArithmeticOp() {
        if (moreArithmeticOpParser == null) {
           FutureParser future = scoped("moreArithmeticOp", false);
           moreArithmeticOpParser = future;
           future.setParser(
               choice(
                   bitwiseOp(),
                   addingOp(),
                   multiplyingOp(),
                   exponentiationOp()
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
           FutureParser future = scoped("condition", true);
           conditionParser = future;
           future.setParser(
               sequence(
                   optional(
                       token("NOT")
                   ),
                   conditionStart(),
                   star(
                       furtherCondition()
                   )
               )
           );
        }

        return conditionParser;
    }

    // ========================================================
    // conditionStart
    // ........................................................

    private ParserCombinator conditionStartParser = null;

    public final Start conditionStart = Start.on(getNamespace(), "conditionStart");

    public ParserCombinator conditionStart() {
        if (conditionStartParser == null) {
           FutureParser future = scoped("conditionStart", true);
           conditionStartParser = future;
           future.setParser(
               choice(
                   token("TRUE"),
                   token("FALSE"),
                   sequence(
                       literal("("),
                       condition(),
                       literal(")")
                   ),
                   operand()
               )
           );
        }

        return conditionStartParser;
    }

    // ========================================================
    // furtherCondition
    // ........................................................

    private ParserCombinator furtherConditionParser = null;

    public final Start furtherCondition = Start.on(getNamespace(), "furtherCondition");

    public ParserCombinator furtherCondition() {
        if (furtherConditionParser == null) {
           FutureParser future = scoped("furtherCondition", true);
           furtherConditionParser = future;
           future.setParser(
               choice(
                   token("TRUE"),
                   token("FALSE"),
                   sequence(
                       optional(
                           token("IS")
                       ),
                       optional(
                           token("NOT")
                       ),
                       token("OMITTED")
                   ),
                   sequence(
                       optional(
                           token("IS")
                       ),
                       optional(
                           token("NOT")
                       ),
                       classType()
                   ),
                   sequence(
                       optional(
                           token("IS")
                       ),
                       optional(
                           token("NOT")
                       ),
                       signType()
                   ),
                   sequence(
                       optional(
                           choice(
                               token("AND"),
                               token("OR")
                           )
                       ),
                       optional(
                           token("IS")
                       ),
                       optional(
                           token("NOT")
                       ),
                       optional(
                           relop()
                       ),
                       literal("("),
                       condition(),
                       literal(")")
                   ),
                   sequence(
                       optional(
                           choice(
                               token("AND"),
                               token("OR")
                           )
                       ),
                       optional(
                           token("IS")
                       ),
                       optional(
                           token("NOT")
                       ),
                       optional(
                           relop()
                       ),
                       operand()
                   )
               )
           );
        }

        return furtherConditionParser;
    }

    // ========================================================
    // classType
    // ........................................................

    private ParserCombinator classTypeParser = null;

    public final Start classType = Start.on(getNamespace(), "classType");

    public ParserCombinator classType() {
        if (classTypeParser == null) {
           FutureParser future = scoped("classType", true);
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
                   token("REPRESENTS-NOT-A-NUMBER")
               )
           );
        }

        return classTypeParser;
    }

    // ========================================================
    // signType
    // ........................................................

    private ParserCombinator signTypeParser = null;

    public final Start signType = Start.on(getNamespace(), "signType");

    public ParserCombinator signType() {
        if (signTypeParser == null) {
           FutureParser future = scoped("signType", true);
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
    // relop
    // ........................................................

    private ParserCombinator relopParser = null;

    public final Start relop = Start.on(getNamespace(), "relop");

    public ParserCombinator relop() {
        if (relopParser == null) {
           FutureParser future = scoped("relop", true);
           relopParser = future;
           future.setParser(
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
                               token("NOT")
                           ),
                           greaterOrEqualOp()
                       ),
                       sequence(
                           optional(
                               token("NOT")
                           ),
                           lessOrEqualOp()
                       ),
                       sequence(
                           optional(
                               token("NOT")
                           ),
                           greaterThanOp()
                       ),
                       sequence(
                           optional(
                               token("NOT")
                           ),
                           lessThanOp()
                       ),
                       sequence(
                           optional(
                               token("NOT")
                           ),
                           equalToOp()
                       ),
                       exceedsOp(),
                       equalsOp(),
                       unequalToOp()
                   )
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
           FutureParser future = scoped("greaterThanOp", true);
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
           FutureParser future = scoped("lessThanOp", true);
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
           FutureParser future = scoped("equalToOp", true);
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
    // exceedsOp
    // ........................................................

    private ParserCombinator exceedsOpParser = null;

    public final Start exceedsOp = Start.on(getNamespace(), "exceedsOp");

    public ParserCombinator exceedsOp() {
        if (exceedsOpParser == null) {
           FutureParser future = scoped("exceedsOp", true);
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
           FutureParser future = scoped("equalsOp", true);
           equalsOpParser = future;
           future.setParser(
               token("EQUALS")
           );
        }

        return equalsOpParser;
    }

    // ========================================================
    // unequalToOp
    // ........................................................

    private ParserCombinator unequalToOpParser = null;

    public final Start unequalToOp = Start.on(getNamespace(), "unequalToOp");

    public ParserCombinator unequalToOp() {
        if (unequalToOpParser == null) {
           FutureParser future = scoped("unequalToOp", true);
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
    // greaterOrEqualOp
    // ........................................................

    private ParserCombinator greaterOrEqualOpParser = null;

    public final Start greaterOrEqualOp = Start.on(getNamespace(), "greaterOrEqualOp");

    public ParserCombinator greaterOrEqualOp() {
        if (greaterOrEqualOpParser == null) {
           FutureParser future = scoped("greaterOrEqualOp", true);
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
           FutureParser future = scoped("lessOrEqualOp", true);
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
    // programName
    // ........................................................

    private ParserCombinator programNameParser = null;

    public final Start programName = Start.on(getNamespace(), "programName");

    public ParserCombinator programName() {
        if (programNameParser == null) {
           FutureParser future = scoped("programName", true);
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
           FutureParser future = scoped("dataName", true);
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
           FutureParser future = scoped("qualifiedDataName", true);
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
           FutureParser future = scoped("screenName", true);
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
           FutureParser future = scoped("sectionName", true);
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
           FutureParser future = scoped("paragraphName", true);
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
           FutureParser future = scoped("procedureName", true);
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
           FutureParser future = scoped("name", true);
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
           FutureParser future = scoped("segmentNumber", true);
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
           FutureParser future = scoped("operand", true);
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
           FutureParser future = scoped("threadPointer", true);
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
           FutureParser future = scoped("eventPointer", true);
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
           FutureParser future = scoped("conditionName", true);
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
           FutureParser future = scoped("indexName", true);
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
           FutureParser future = scoped("className", true);
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
           FutureParser future = scoped("typeSpecifier", true);
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
           FutureParser future = scoped("parameterName", true);
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
           FutureParser future = scoped("interfaceName", true);
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
           FutureParser future = scoped("methodName", true);
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
           FutureParser future = scoped("propertyName", true);
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
           FutureParser future = scoped("propertyValue", true);
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
           FutureParser future = scoped("delegateName", true);
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
           FutureParser future = scoped("iteratorName", true);
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
           FutureParser future = scoped("enumName", true);
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
           FutureParser future = scoped("valuetypeName", true);
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
           FutureParser future = scoped("typeName", true);
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
           FutureParser future = scoped("attributeName", true);
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
           FutureParser future = scoped("typedefName", true);
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
           FutureParser future = scoped("fileName", true);
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
           FutureParser future = scoped("computerName", true);
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
           FutureParser future = scoped("functionName", true);
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
           FutureParser future = scoped("recordName", true);
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
           FutureParser future = scoped("mnemonicName", true);
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
           FutureParser future = scoped("environmentName", true);
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
           FutureParser future = scoped("alphabetName", true);
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
           FutureParser future = scoped("cdName", true);
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
           FutureParser future = scoped("reportName", true);
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
           FutureParser future = scoped("literal", true);
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
           FutureParser future = scoped("literalValue", true);
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
           FutureParser future = scoped("concatenatedLiteral", true);
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
           FutureParser future = scoped("value", true);
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
           FutureParser future = scoped("figurativeConstant", true);
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
           FutureParser future = scoped("numericLiteral", true);
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
           FutureParser future = scoped("numeric", true);
           numericParser = future;
           future.setParser(
               choice(
                   decimal(),
                   integer(),
                   booleanLiteral(),
                   hexadecimal(),
                   zero(),
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

        return numericParser;
    }

    // ========================================================
    // integer
    // ........................................................

    private ParserCombinator integerParser = null;

    public final Start integer = Start.on(getNamespace(), "integer");

    public ParserCombinator integer() {
        if (integerParser == null) {
           FutureParser future = scoped("integer", true);
           integerParser = future;
           future.setParser(
               choice(
                   integerLiteral(),
                   integerConstant()
               )
           );
        }

        return integerParser;
    }

    // ========================================================
    // constant
    // ........................................................

    private ParserCombinator constantParser = null;

    public final Start constant = Start.on(getNamespace(), "constant");

    public ParserCombinator constant() {
        if (constantParser == null) {
           FutureParser future = scoped("constant", true);
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
           FutureParser future = scoped("integerConstant", true);
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
           FutureParser future = scoped("alphanumeric", true);
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
           FutureParser future = scoped("alphanumericConstant", true);
           alphanumericConstantParser = future;
           future.setParser(
               cobolWord()
           );
        }

        return alphanumericConstantParser;
    }

}