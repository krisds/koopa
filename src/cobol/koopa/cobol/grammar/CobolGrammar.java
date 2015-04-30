package koopa.cobol.grammar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import koopa.core.data.Token;
import koopa.core.data.markers.Start;
import koopa.core.grammars.Block;
import koopa.core.grammars.KoopaGrammar;
import koopa.core.parsers.Parser;
import koopa.core.parsers.FutureParser;
import koopa.core.parsers.ParseStream;

import static koopa.core.grammars.Opt.NOSKIP;

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

    private Parser compilationGroupParser = null;

    public final Start compilationGroup = Start.on(getNamespace(), "compilationGroup");

    public Parser compilationGroup() {
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

    private Parser copybookParser = null;

    public final Start copybook = Start.on(getNamespace(), "copybook");

    public Parser copybook() {
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

    private Parser copybookHoldingDataParser = null;

    public final Start copybookHoldingData = Start.on(getNamespace(), "copybookHoldingData");

    public Parser copybookHoldingData() {
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
                               token(".")
                           )
                       ),
                       copyStatement(),
                       replaceStatement(),
                       sequence(
                           execStatement(),
                           optional(
                               token(".")
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

    private Parser copybookHoldingBehaviourParser = null;

    public final Start copybookHoldingBehaviour = Start.on(getNamespace(), "copybookHoldingBehaviour");

    public Parser copybookHoldingBehaviour() {
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

    private Parser sourceUnitParser = null;

    public final Start sourceUnit = Start.on(getNamespace(), "sourceUnit");

    public Parser sourceUnit() {
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

    private Parser programPrototypeParser = null;

    public final Start programPrototype = Start.on(getNamespace(), "programPrototype");

    public Parser programPrototype() {
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
                                   token(".")
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
                   token(".")
               )
           );
        }

        return programPrototypeParser;
    }

    // ========================================================
    // programPrototypeIdParagraph
    // ........................................................

    private Parser programPrototypeIdParagraphParser = null;

    public final Start programPrototypeIdParagraph = Start.on(getNamespace(), "programPrototypeIdParagraph");

    public Parser programPrototypeIdParagraph() {
        if (programPrototypeIdParagraphParser == null) {
           FutureParser future = scoped("programPrototypeIdParagraph", true);
           programPrototypeIdParagraphParser = future;
           future.setParser(
               sequence(
                   token("PROGRAM-ID"),
                   optional(
                       token(".")
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
                       token(".")
                   )
               )
           );
        }

        return programPrototypeIdParagraphParser;
    }

    // ========================================================
    // functionPrototype
    // ........................................................

    private Parser functionPrototypeParser = null;

    public final Start functionPrototype = Start.on(getNamespace(), "functionPrototype");

    public Parser functionPrototype() {
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
                                   token(".")
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
                   token(".")
               )
           );
        }

        return functionPrototypeParser;
    }

    // ========================================================
    // functionPrototypeIdParagraph
    // ........................................................

    private Parser functionPrototypeIdParagraphParser = null;

    public final Start functionPrototypeIdParagraph = Start.on(getNamespace(), "functionPrototypeIdParagraph");

    public Parser functionPrototypeIdParagraph() {
        if (functionPrototypeIdParagraphParser == null) {
           FutureParser future = scoped("functionPrototypeIdParagraph", true);
           functionPrototypeIdParagraphParser = future;
           future.setParser(
               sequence(
                   token("FUNCTION-ID"),
                   optional(
                       token(".")
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
                       token(".")
                   )
               )
           );
        }

        return functionPrototypeIdParagraphParser;
    }

    // ========================================================
    // programDefinition
    // ........................................................

    private Parser programDefinitionParser = null;

    public final Start programDefinition = Start.on(getNamespace(), "programDefinition");

    public Parser programDefinition() {
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
                                   token(".")
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
                           token(".")
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

    private Parser programIdParagraphParser = null;

    public final Start programIdParagraph = Start.on(getNamespace(), "programIdParagraph");

    public Parser programIdParagraph() {
        if (programIdParagraphParser == null) {
           FutureParser future = scoped("programIdParagraph", true);
           programIdParagraphParser = future;
           future.setParser(
               sequence(
                   token("PROGRAM-ID"),
                   optional(
                       token(".")
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
                       token(".")
                   )
               )
           );
        }

        return programIdParagraphParser;
    }

    // ========================================================
    // functionDefinition
    // ........................................................

    private Parser functionDefinitionParser = null;

    public final Start functionDefinition = Start.on(getNamespace(), "functionDefinition");

    public Parser functionDefinition() {
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
                                   token(".")
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
                   token(".")
               )
           );
        }

        return functionDefinitionParser;
    }

    // ========================================================
    // functionIdParagraph
    // ........................................................

    private Parser functionIdParagraphParser = null;

    public final Start functionIdParagraph = Start.on(getNamespace(), "functionIdParagraph");

    public Parser functionIdParagraph() {
        if (functionIdParagraphParser == null) {
           FutureParser future = scoped("functionIdParagraph", true);
           functionIdParagraphParser = future;
           future.setParser(
               sequence(
                   token("FUNCTION-ID"),
                   optional(
                       token(".")
                   ),
                   name(),
                   optional(
                       sequence(
                           token("AS"),
                           literal()
                       )
                   ),
                   optional(
                       token(".")
                   )
               )
           );
        }

        return functionIdParagraphParser;
    }

    // ========================================================
    // classDefinition
    // ........................................................

    private Parser classDefinitionParser = null;

    public final Start classDefinition = Start.on(getNamespace(), "classDefinition");

    public Parser classDefinition() {
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
                                   token(".")
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
                   token(".")
               )
           );
        }

        return classDefinitionParser;
    }

    // ========================================================
    // classIdParagraph
    // ........................................................

    private Parser classIdParagraphParser = null;

    public final Start classIdParagraph = Start.on(getNamespace(), "classIdParagraph");

    public Parser classIdParagraph() {
        if (classIdParagraphParser == null) {
           FutureParser future = scoped("classIdParagraph", true);
           classIdParagraphParser = future;
           future.setParser(
               sequence(
                   token("CLASS-ID"),
                   optional(
                       token(".")
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
                       token(".")
                   )
               )
           );
        }

        return classIdParagraphParser;
    }

    // ========================================================
    // attributeClause
    // ........................................................

    private Parser attributeClauseParser = null;

    public final Start attributeClause = Start.on(getNamespace(), "attributeClause");

    public Parser attributeClause() {
        if (attributeClauseParser == null) {
           FutureParser future = scoped("attributeClause", true);
           attributeClauseParser = future;
           future.setParser(
               plus(
                   choice(
                       sequence(
                           token("ATTRIBUTE"),
                           attributeName(),
                           token("("),
                           star(
                               choice(
                                   sequence(
                                       token("NAME"),
                                       propertyName(),
                                       token("="),
                                       propertyValue()
                                   ),
                                   parameterName()
                               )
                           ),
                           token(")")
                       ),
                       sequence(
                           token("CUSTOM-ATTRIBUTE"),
                           token("IS"),
                           className(),
                           optional(
                               sequence(
                                   token("("),
                                   star(
                                       choice(
                                           sequence(
                                               propertyName(),
                                               token("="),
                                               propertyValue()
                                           ),
                                           parameterName()
                                       )
                                   ),
                                   token(")")
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

    private Parser factoryDefinitionParser = null;

    public final Start factoryDefinition = Start.on(getNamespace(), "factoryDefinition");

    public Parser factoryDefinition() {
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
                                   token(".")
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
                   token(".")
               )
           );
        }

        return factoryDefinitionParser;
    }

    // ========================================================
    // factoryParagraph
    // ........................................................

    private Parser factoryParagraphParser = null;

    public final Start factoryParagraph = Start.on(getNamespace(), "factoryParagraph");

    public Parser factoryParagraph() {
        if (factoryParagraphParser == null) {
           FutureParser future = scoped("factoryParagraph", true);
           factoryParagraphParser = future;
           future.setParser(
               sequence(
                   token("FACTORY"),
                   optional(
                       token(".")
                   ),
                   optional(
                       sequence(
                           token("IMPLEMENTS"),
                           plus(
                               name()
                           ),
                           token(".")
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

    private Parser instanceDefinitionParser = null;

    public final Start instanceDefinition = Start.on(getNamespace(), "instanceDefinition");

    public Parser instanceDefinition() {
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
                                   token(".")
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
                   token(".")
               )
           );
        }

        return instanceDefinitionParser;
    }

    // ========================================================
    // objectParagraph
    // ........................................................

    private Parser objectParagraphParser = null;

    public final Start objectParagraph = Start.on(getNamespace(), "objectParagraph");

    public Parser objectParagraph() {
        if (objectParagraphParser == null) {
           FutureParser future = scoped("objectParagraph", true);
           objectParagraphParser = future;
           future.setParser(
               sequence(
                   token("OBJECT"),
                   optional(
                       token(".")
                   ),
                   optional(
                       sequence(
                           token("IMPLEMENTS"),
                           plus(
                               name()
                           ),
                           optional(
                               token(".")
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

    private Parser interfaceDefinitionParser = null;

    public final Start interfaceDefinition = Start.on(getNamespace(), "interfaceDefinition");

    public Parser interfaceDefinition() {
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
                                   token(".")
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
                   token(".")
               )
           );
        }

        return interfaceDefinitionParser;
    }

    // ========================================================
    // interfaceIdParagraph
    // ........................................................

    private Parser interfaceIdParagraphParser = null;

    public final Start interfaceIdParagraph = Start.on(getNamespace(), "interfaceIdParagraph");

    public Parser interfaceIdParagraph() {
        if (interfaceIdParagraphParser == null) {
           FutureParser future = scoped("interfaceIdParagraph", true);
           interfaceIdParagraphParser = future;
           future.setParser(
               sequence(
                   token("INTERFACE-ID"),
                   optional(
                       token(".")
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
                       token(".")
                   )
               )
           );
        }

        return interfaceIdParagraphParser;
    }

    // ========================================================
    // methodDefinition
    // ........................................................

    private Parser methodDefinitionParser = null;

    public final Start methodDefinition = Start.on(getNamespace(), "methodDefinition");

    public Parser methodDefinition() {
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
                                   token(".")
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
                   token(".")
               )
           );
        }

        return methodDefinitionParser;
    }

    // ========================================================
    // methodIdParagraph
    // ........................................................

    private Parser methodIdParagraphParser = null;

    public final Start methodIdParagraph = Start.on(getNamespace(), "methodIdParagraph");

    public Parser methodIdParagraph() {
        if (methodIdParagraphParser == null) {
           FutureParser future = scoped("methodIdParagraph", true);
           methodIdParagraphParser = future;
           future.setParser(
               sequence(
                   token("METHOD-ID"),
                   optional(
                       token(".")
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
                       token(".")
                   )
               )
           );
        }

        return methodIdParagraphParser;
    }

    // ========================================================
    // callPrototypeDefinition
    // ........................................................

    private Parser callPrototypeDefinitionParser = null;

    public final Start callPrototypeDefinition = Start.on(getNamespace(), "callPrototypeDefinition");

    public Parser callPrototypeDefinition() {
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
                                   token(".")
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
                           token(".")
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

    private Parser callPrototypeIdParagraphParser = null;

    public final Start callPrototypeIdParagraph = Start.on(getNamespace(), "callPrototypeIdParagraph");

    public Parser callPrototypeIdParagraph() {
        if (callPrototypeIdParagraphParser == null) {
           FutureParser future = scoped("callPrototypeIdParagraph", true);
           callPrototypeIdParagraphParser = future;
           future.setParser(
               sequence(
                   token("PROGRAM-ID"),
                   optional(
                       token(".")
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
                       token(".")
                   )
               )
           );
        }

        return callPrototypeIdParagraphParser;
    }

    // ========================================================
    // delegateDefinition
    // ........................................................

    private Parser delegateDefinitionParser = null;

    public final Start delegateDefinition = Start.on(getNamespace(), "delegateDefinition");

    public Parser delegateDefinition() {
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
                                   token(".")
                               )
                           ),
                           delegateIdParagraph()
                       )
                   ),
                   procedureDivisionHeader(),
                   token("END"),
                   token("DELEGATE"),
                   token(".")
               )
           );
        }

        return delegateDefinitionParser;
    }

    // ========================================================
    // delegateIdParagraph
    // ........................................................

    private Parser delegateIdParagraphParser = null;

    public final Start delegateIdParagraph = Start.on(getNamespace(), "delegateIdParagraph");

    public Parser delegateIdParagraph() {
        if (delegateIdParagraphParser == null) {
           FutureParser future = scoped("delegateIdParagraph", true);
           delegateIdParagraphParser = future;
           future.setParser(
               sequence(
                   token("DELEGATE-ID"),
                   optional(
                       token(".")
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
                       token(".")
                   )
               )
           );
        }

        return delegateIdParagraphParser;
    }

    // ========================================================
    // enumDefinition
    // ........................................................

    private Parser enumDefinitionParser = null;

    public final Start enumDefinition = Start.on(getNamespace(), "enumDefinition");

    public Parser enumDefinition() {
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
                                   token(".")
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
                               token(".")
                           )
                       )
                   ),
                   token("END"),
                   token("ENUM"),
                   token(".")
               )
           );
        }

        return enumDefinitionParser;
    }

    // ========================================================
    // enumIdParagraph
    // ........................................................

    private Parser enumIdParagraphParser = null;

    public final Start enumIdParagraph = Start.on(getNamespace(), "enumIdParagraph");

    public Parser enumIdParagraph() {
        if (enumIdParagraphParser == null) {
           FutureParser future = scoped("enumIdParagraph", true);
           enumIdParagraphParser = future;
           future.setParser(
               sequence(
                   token("ENUM-ID"),
                   optional(
                       token(".")
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
                       token(".")
                   )
               )
           );
        }

        return enumIdParagraphParser;
    }

    // ========================================================
    // iteratorDefinition
    // ........................................................

    private Parser iteratorDefinitionParser = null;

    public final Start iteratorDefinition = Start.on(getNamespace(), "iteratorDefinition");

    public Parser iteratorDefinition() {
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
                                   token(".")
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
                               token(".")
                           )
                       )
                   ),
                   token("END"),
                   token("ITERATOR"),
                   token(".")
               )
           );
        }

        return iteratorDefinitionParser;
    }

    // ========================================================
    // iteratorIdParagraph
    // ........................................................

    private Parser iteratorIdParagraphParser = null;

    public final Start iteratorIdParagraph = Start.on(getNamespace(), "iteratorIdParagraph");

    public Parser iteratorIdParagraph() {
        if (iteratorIdParagraphParser == null) {
           FutureParser future = scoped("iteratorIdParagraph", true);
           iteratorIdParagraphParser = future;
           future.setParser(
               sequence(
                   token("ITERATOR-ID"),
                   optional(
                       token(".")
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
                       token(".")
                   )
               )
           );
        }

        return iteratorIdParagraphParser;
    }

    // ========================================================
    // operatorDefinition
    // ........................................................

    private Parser operatorDefinitionParser = null;

    public final Start operatorDefinition = Start.on(getNamespace(), "operatorDefinition");

    public Parser operatorDefinition() {
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
                                   token(".")
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
                               token(".")
                           )
                       )
                   ),
                   token("END"),
                   token("OPERATOR"),
                   token(".")
               )
           );
        }

        return operatorDefinitionParser;
    }

    // ========================================================
    // operatorIdParagraph
    // ........................................................

    private Parser operatorIdParagraphParser = null;

    public final Start operatorIdParagraph = Start.on(getNamespace(), "operatorIdParagraph");

    public Parser operatorIdParagraph() {
        if (operatorIdParagraphParser == null) {
           FutureParser future = scoped("operatorIdParagraph", true);
           operatorIdParagraphParser = future;
           future.setParser(
               sequence(
                   token("OPERATOR-ID"),
                   optional(
                       token(".")
                   ),
                   choice(
                       sequence(
                           token("="),
                           optional(
                               token("EXTENSION")
                           )
                       ),
                       token("<>"),
                       token(">="),
                       token(">"),
                       token("<="),
                       token("<"),
                       token("+"),
                       token("-"),
                       token("*"),
                       token("/"),
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
                       token(".")
                   )
               )
           );
        }

        return operatorIdParagraphParser;
    }

    // ========================================================
    // valueTypeDefinition
    // ........................................................

    private Parser valueTypeDefinitionParser = null;

    public final Start valueTypeDefinition = Start.on(getNamespace(), "valueTypeDefinition");

    public Parser valueTypeDefinition() {
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
                                   token(".")
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
                               token(".")
                           )
                       )
                   ),
                   token("END"),
                   token("VALUETYPE"),
                   token(".")
               )
           );
        }

        return valueTypeDefinitionParser;
    }

    // ========================================================
    // valueTypeIdParagraph
    // ........................................................

    private Parser valueTypeIdParagraphParser = null;

    public final Start valueTypeIdParagraph = Start.on(getNamespace(), "valueTypeIdParagraph");

    public Parser valueTypeIdParagraph() {
        if (valueTypeIdParagraphParser == null) {
           FutureParser future = scoped("valueTypeIdParagraph", true);
           valueTypeIdParagraphParser = future;
           future.setParser(
               sequence(
                   token("VALUETYPE-ID"),
                   optional(
                       token(".")
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
                       token(".")
                   )
               )
           );
        }

        return valueTypeIdParagraphParser;
    }

    // ========================================================
    // endMarker
    // ........................................................

    private Parser endMarkerParser = null;

    public final Start endMarker = Start.on(getNamespace(), "endMarker");

    public Parser endMarker() {
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
                   token(".")
               )
           );
        }

        return endMarkerParser;
    }

    // ========================================================
    // optionsParagraph
    // ........................................................

    private Parser optionsParagraphParser = null;

    public final Start optionsParagraph = Start.on(getNamespace(), "optionsParagraph");

    public Parser optionsParagraph() {
        if (optionsParagraphParser == null) {
           FutureParser future = scoped("optionsParagraph", true);
           optionsParagraphParser = future;
           future.setParser(
               sequence(
                   token("OPTIONS"),
                   token("."),
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
                   token(".")
               )
           );
        }

        return optionsParagraphParser;
    }

    // ========================================================
    // arithmeticClause
    // ........................................................

    private Parser arithmeticClauseParser = null;

    public final Start arithmeticClause = Start.on(getNamespace(), "arithmeticClause");

    public Parser arithmeticClause() {
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

    private Parser defaultRoundedClauseParser = null;

    public final Start defaultRoundedClause = Start.on(getNamespace(), "defaultRoundedClause");

    public Parser defaultRoundedClause() {
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

    private Parser entryConventionClauseParser = null;

    public final Start entryConventionClause = Start.on(getNamespace(), "entryConventionClause");

    public Parser entryConventionClause() {
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

    private Parser intermediateRoundingClauseParser = null;

    public final Start intermediateRoundingClause = Start.on(getNamespace(), "intermediateRoundingClause");

    public Parser intermediateRoundingClause() {
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

    private Parser metadataParser = null;

    public final Start metadata = Start.on(getNamespace(), "metadata");

    public Parser metadata() {
        if (metadataParser == null) {
           FutureParser future = scoped("metadata", true);
           metadataParser = future;
           future.setParser(
               sequence(
                   plus(
                       choice(
                           sequence(
                               token("AUTHOR"),
                               token("."),
                               optional(
                                   commentEntry()
                               )
                           ),
                           sequence(
                               token("INSTALLATION"),
                               token("."),
                               optional(
                                   commentEntry()
                               )
                           ),
                           sequence(
                               token("DATE-WRITTEN"),
                               token("."),
                               optional(
                                   commentEntry()
                               )
                           ),
                           sequence(
                               token("DATE-COMPILED"),
                               token("."),
                               optional(
                                   commentEntry()
                               )
                           ),
                           sequence(
                               token("SECURITY"),
                               token("."),
                               optional(
                                   commentEntry()
                               )
                           ),
                           sequence(
                               token("REMARKS"),
                               token("."),
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

    private Parser environmentDivisionParser = null;

    public final Start environmentDivision = Start.on(getNamespace(), "environmentDivision");

    public Parser environmentDivision() {
        if (environmentDivisionParser == null) {
           FutureParser future = scoped("environmentDivision", true);
           environmentDivisionParser = future;
           future.setParser(
               choice(
                   sequence(
                       token("ENVIRONMENT"),
                       token("DIVISION"),
                       token("."),
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

    private Parser environmentDivisionBodyParser = null;

    public final Start environmentDivisionBody = Start.on(getNamespace(), "environmentDivisionBody");

    public Parser environmentDivisionBody() {
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

    private Parser configurationSectionParser = null;

    public final Start configurationSection = Start.on(getNamespace(), "configurationSection");

    public Parser configurationSection() {
        if (configurationSectionParser == null) {
           FutureParser future = scoped("configurationSection", true);
           configurationSectionParser = future;
           future.setParser(
               sequence(
                   token("CONFIGURATION"),
                   token("SECTION"),
                   token("."),
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

    private Parser configurationSectionBodyParser = null;

    public final Start configurationSectionBody = Start.on(getNamespace(), "configurationSectionBody");

    public Parser configurationSectionBody() {
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

    private Parser sourceComputerParagraphParser = null;

    public final Start sourceComputerParagraph = Start.on(getNamespace(), "sourceComputerParagraph");

    public Parser sourceComputerParagraph() {
        if (sourceComputerParagraphParser == null) {
           FutureParser future = scoped("sourceComputerParagraph", true);
           sourceComputerParagraphParser = future;
           future.setParser(
               sequence(
                   token("SOURCE-COMPUTER"),
                   token("."),
                   optional(
                       sequence(
                           computerName(),
                           optional(
                               withDebuggingMode()
                           ),
                           token(".")
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

    private Parser withDebuggingModeParser = null;

    public final Start withDebuggingMode = Start.on(getNamespace(), "withDebuggingMode");

    public Parser withDebuggingMode() {
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

    private Parser objectComputerParagraphParser = null;

    public final Start objectComputerParagraph = Start.on(getNamespace(), "objectComputerParagraph");

    public Parser objectComputerParagraph() {
        if (objectComputerParagraphParser == null) {
           FutureParser future = scoped("objectComputerParagraph", true);
           objectComputerParagraphParser = future;
           future.setParser(
               sequence(
                   token("OBJECT-COMPUTER"),
                   token("."),
                   optional(
                       sequence(
                           computerName(),
                           optional(
                               skipto(
                                   token(".")
                               )
                           ),
                           token(".")
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

    private Parser constraintsParagraphParser = null;

    public final Start constraintsParagraph = Start.on(getNamespace(), "constraintsParagraph");

    public Parser constraintsParagraph() {
        if (constraintsParagraphParser == null) {
           FutureParser future = scoped("constraintsParagraph", true);
           constraintsParagraphParser = future;
           future.setParser(
               sequence(
                   token("CONSTRAINTS"),
                   token("."),
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

    private Parser classAttributesParagraphParser = null;

    public final Start classAttributesParagraph = Start.on(getNamespace(), "classAttributesParagraph");

    public Parser classAttributesParagraph() {
        if (classAttributesParagraphParser == null) {
           FutureParser future = scoped("classAttributesParagraph", true);
           classAttributesParagraphParser = future;
           future.setParser(
               sequence(
                   token("CLASS-ATTRIBUTES"),
                   token("."),
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

    private Parser assemblyAttributesParagraphParser = null;

    public final Start assemblyAttributesParagraph = Start.on(getNamespace(), "assemblyAttributesParagraph");

    public Parser assemblyAttributesParagraph() {
        if (assemblyAttributesParagraphParser == null) {
           FutureParser future = scoped("assemblyAttributesParagraph", true);
           assemblyAttributesParagraphParser = future;
           future.setParser(
               sequence(
                   token("ASSEMBLY-ATTRIBUTES"),
                   token("."),
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

    private Parser genericStringDefParser = null;

    public final Start genericStringDef = Start.on(getNamespace(), "genericStringDef");

    public Parser genericStringDef() {
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
                       token(".")
                   )
               )
           );
        }

        return genericStringDefParser;
    }

    // ========================================================
    // specialNamesParagraph
    // ........................................................

    private Parser specialNamesParagraphParser = null;

    public final Start specialNamesParagraph = Start.on(getNamespace(), "specialNamesParagraph");

    public Parser specialNamesParagraph() {
        if (specialNamesParagraphParser == null) {
           FutureParser future = scoped("specialNamesParagraph", true);
           specialNamesParagraphParser = future;
           future.setParser(
               sequence(
                   token("SPECIAL-NAMES"),
                   token("."),
                   star(
                       choice(
                           specialNameStatement(),
                           copyStatement()
                       )
                   ),
                   optional(
                       token(".")
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

    private Parser specialNameStatementParser = null;

    public final Start specialNameStatement = Start.on(getNamespace(), "specialNameStatement");

    public Parser specialNameStatement() {
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

    private Parser consoleIsCRTParser = null;

    public final Start consoleIsCRT = Start.on(getNamespace(), "consoleIsCRT");

    public Parser consoleIsCRT() {
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

    private Parser cobolDeviceParser = null;

    public final Start cobolDevice = Start.on(getNamespace(), "cobolDevice");

    public Parser cobolDevice() {
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

    private Parser cobolSwitchParser = null;

    public final Start cobolSwitch = Start.on(getNamespace(), "cobolSwitch");

    public Parser cobolSwitch() {
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

    private Parser alphabetIsParser = null;

    public final Start alphabetIs = Start.on(getNamespace(), "alphabetIs");

    public Parser alphabetIs() {
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

    private Parser alphabetTypeParser = null;

    public final Start alphabetType = Start.on(getNamespace(), "alphabetType");

    public Parser alphabetType() {
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

    private Parser standard1AlphabetTypeParser = null;

    public final Start standard1AlphabetType = Start.on(getNamespace(), "standard1AlphabetType");

    public Parser standard1AlphabetType() {
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

    private Parser standard2AlphabetTypeParser = null;

    public final Start standard2AlphabetType = Start.on(getNamespace(), "standard2AlphabetType");

    public Parser standard2AlphabetType() {
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

    private Parser nativeAlphabetTypeParser = null;

    public final Start nativeAlphabetType = Start.on(getNamespace(), "nativeAlphabetType");

    public Parser nativeAlphabetType() {
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

    private Parser asciiAlphabetTypeParser = null;

    public final Start asciiAlphabetType = Start.on(getNamespace(), "asciiAlphabetType");

    public Parser asciiAlphabetType() {
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

    private Parser ebcdicAlphabetTypeParser = null;

    public final Start ebcdicAlphabetType = Start.on(getNamespace(), "ebcdicAlphabetType");

    public Parser ebcdicAlphabetType() {
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

    private Parser explicitAlphabetTypeParser = null;

    public final Start explicitAlphabetType = Start.on(getNamespace(), "explicitAlphabetType");

    public Parser explicitAlphabetType() {
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

    private Parser codeNameAlphabetTypeParser = null;

    public final Start codeNameAlphabetType = Start.on(getNamespace(), "codeNameAlphabetType");

    public Parser codeNameAlphabetType() {
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

    private Parser literalRangeParser = null;

    public final Start literalRange = Start.on(getNamespace(), "literalRange");

    public Parser literalRange() {
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

    private Parser symbolicCharsParser = null;

    public final Start symbolicChars = Start.on(getNamespace(), "symbolicChars");

    public Parser symbolicChars() {
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

    private Parser classIsParser = null;

    public final Start classIs = Start.on(getNamespace(), "classIs");

    public Parser classIs() {
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

    private Parser localeIsParser = null;

    public final Start localeIs = Start.on(getNamespace(), "localeIs");

    public Parser localeIs() {
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

    private Parser currencySignIsParser = null;

    public final Start currencySignIs = Start.on(getNamespace(), "currencySignIs");

    public Parser currencySignIs() {
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

    private Parser decimalIsCommaParser = null;

    public final Start decimalIsComma = Start.on(getNamespace(), "decimalIsComma");

    public Parser decimalIsComma() {
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

    private Parser numericSignIsParser = null;

    public final Start numericSignIs = Start.on(getNamespace(), "numericSignIs");

    public Parser numericSignIs() {
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

    private Parser callConventionParser = null;

    public final Start callConvention = Start.on(getNamespace(), "callConvention");

    public Parser callConvention() {
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

    private Parser cursorIsParser = null;

    public final Start cursorIs = Start.on(getNamespace(), "cursorIs");

    public Parser cursorIs() {
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

    private Parser crtStatusIsParser = null;

    public final Start crtStatusIs = Start.on(getNamespace(), "crtStatusIs");

    public Parser crtStatusIs() {
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

    private Parser xmlSchemaIsParser = null;

    public final Start xmlSchemaIs = Start.on(getNamespace(), "xmlSchemaIs");

    public Parser xmlSchemaIs() {
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

    private Parser screenControlIsParser = null;

    public final Start screenControlIs = Start.on(getNamespace(), "screenControlIs");

    public Parser screenControlIs() {
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

    private Parser eventStatusIsParser = null;

    public final Start eventStatusIs = Start.on(getNamespace(), "eventStatusIs");

    public Parser eventStatusIs() {
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

    private Parser repositoryParagraphParser = null;

    public final Start repositoryParagraph = Start.on(getNamespace(), "repositoryParagraph");

    public Parser repositoryParagraph() {
        if (repositoryParagraphParser == null) {
           FutureParser future = scoped("repositoryParagraph", true);
           repositoryParagraphParser = future;
           future.setParser(
               sequence(
                   token("REPOSITORY"),
                   token("."),
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
                           token(".")
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

    private Parser classSpecifierParser = null;

    public final Start classSpecifier = Start.on(getNamespace(), "classSpecifier");

    public Parser classSpecifier() {
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

    private Parser interfaceSpecifierParser = null;

    public final Start interfaceSpecifier = Start.on(getNamespace(), "interfaceSpecifier");

    public Parser interfaceSpecifier() {
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

    private Parser programSpecifierParser = null;

    public final Start programSpecifier = Start.on(getNamespace(), "programSpecifier");

    public Parser programSpecifier() {
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

    private Parser propertySpecifierParser = null;

    public final Start propertySpecifier = Start.on(getNamespace(), "propertySpecifier");

    public Parser propertySpecifier() {
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

    private Parser functionSpecifierParser = null;

    public final Start functionSpecifier = Start.on(getNamespace(), "functionSpecifier");

    public Parser functionSpecifier() {
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

    private Parser delegateSpecifierParser = null;

    public final Start delegateSpecifier = Start.on(getNamespace(), "delegateSpecifier");

    public Parser delegateSpecifier() {
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

    private Parser enumSpecifierParser = null;

    public final Start enumSpecifier = Start.on(getNamespace(), "enumSpecifier");

    public Parser enumSpecifier() {
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

    private Parser ioSectionParser = null;

    public final Start ioSection = Start.on(getNamespace(), "ioSection");

    public Parser ioSection() {
        if (ioSectionParser == null) {
           FutureParser future = scoped("ioSection", true);
           ioSectionParser = future;
           future.setParser(
               sequence(
                   token("INPUT-OUTPUT"),
                   token("SECTION"),
                   token("."),
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

    private Parser ioSectionBodyParser = null;

    public final Start ioSectionBody = Start.on(getNamespace(), "ioSectionBody");

    public Parser ioSectionBody() {
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

    private Parser fileControlParagraphParser = null;

    public final Start fileControlParagraph = Start.on(getNamespace(), "fileControlParagraph");

    public Parser fileControlParagraph() {
        if (fileControlParagraphParser == null) {
           FutureParser future = scoped("fileControlParagraph", true);
           fileControlParagraphParser = future;
           future.setParser(
               sequence(
                   token("FILE-CONTROL"),
                   token("."),
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

    private Parser fileControlEntryParser = null;

    public final Start fileControlEntry = Start.on(getNamespace(), "fileControlEntry");

    public Parser fileControlEntry() {
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

    private Parser selectStatementParser = null;

    public final Start selectStatement = Start.on(getNamespace(), "selectStatement");

    public Parser selectStatement() {
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
                           sharingClause(),
                           paddingClause()
                       )
                   ),
                   token(".")
               )
           );
        }

        return selectStatementParser;
    }

    // ========================================================
    // selectClause
    // ........................................................

    private Parser selectClauseParser = null;

    public final Start selectClause = Start.on(getNamespace(), "selectClause");

    public Parser selectClause() {
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

    private Parser assignClauseParser = null;

    public final Start assignClause = Start.on(getNamespace(), "assignClause");

    public Parser assignClause() {
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

    private Parser assignUsingClauseParser = null;

    public final Start assignUsingClause = Start.on(getNamespace(), "assignUsingClause");

    public Parser assignUsingClause() {
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

    private Parser assignToClauseParser = null;

    public final Start assignToClause = Start.on(getNamespace(), "assignToClause");

    public Parser assignToClause() {
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

    private Parser diskClauseParser = null;

    public final Start diskClause = Start.on(getNamespace(), "diskClause");

    public Parser diskClause() {
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

    private Parser collationClauseParser = null;

    public final Start collationClause = Start.on(getNamespace(), "collationClause");

    public Parser collationClause() {
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

    private Parser recordDelimiterClauseParser = null;

    public final Start recordDelimiterClause = Start.on(getNamespace(), "recordDelimiterClause");

    public Parser recordDelimiterClause() {
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
                       alphanumericLiteral()
                   )
               )
           );
        }

        return recordDelimiterClauseParser;
    }

    // ========================================================
    // reserveClause
    // ........................................................

    private Parser reserveClauseParser = null;

    public final Start reserveClause = Start.on(getNamespace(), "reserveClause");

    public Parser reserveClause() {
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

    private Parser organizationClauseParser = null;

    public final Start organizationClause = Start.on(getNamespace(), "organizationClause");

    public Parser organizationClause() {
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

    private Parser accessModeClauseParser = null;

    public final Start accessModeClause = Start.on(getNamespace(), "accessModeClause");

    public Parser accessModeClause() {
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

    private Parser lockModeClauseParser = null;

    public final Start lockModeClause = Start.on(getNamespace(), "lockModeClause");

    public Parser lockModeClause() {
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

    private Parser lockModeWithClauseParser = null;

    public final Start lockModeWithClause = Start.on(getNamespace(), "lockModeWithClause");

    public Parser lockModeWithClause() {
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

    private Parser relativeKeyClauseParser = null;

    public final Start relativeKeyClause = Start.on(getNamespace(), "relativeKeyClause");

    public Parser relativeKeyClause() {
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

    private Parser recordKeyClauseParser = null;

    public final Start recordKeyClause = Start.on(getNamespace(), "recordKeyClause");

    public Parser recordKeyClause() {
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

    private Parser alternateRecordKeyClauseParser = null;

    public final Start alternateRecordKeyClause = Start.on(getNamespace(), "alternateRecordKeyClause");

    public Parser alternateRecordKeyClause() {
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

    private Parser recordKeyDefinitionParser = null;

    public final Start recordKeyDefinition = Start.on(getNamespace(), "recordKeyDefinition");

    public Parser recordKeyDefinition() {
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
                           token("="),
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

    private Parser fileStatusClauseParser = null;

    public final Start fileStatusClause = Start.on(getNamespace(), "fileStatusClause");

    public Parser fileStatusClause() {
        if (fileStatusClauseParser == null) {
           FutureParser future = scoped("fileStatusClause", true);
           fileStatusClauseParser = future;
           future.setParser(
               sequence(
                   optional(
                       choice(
                           token("FILE"),
                           token("SORT")
                       )
                   ),
                   token("STATUS"),
                   optional(
                       token("IS")
                   ),
                   dataName(),
                   optional(
                       dataName()
                   )
               )
           );
        }

        return fileStatusClauseParser;
    }

    // ========================================================
    // passwordClause
    // ........................................................

    private Parser passwordClauseParser = null;

    public final Start passwordClause = Start.on(getNamespace(), "passwordClause");

    public Parser passwordClause() {
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

    private Parser suppressClauseParser = null;

    public final Start suppressClause = Start.on(getNamespace(), "suppressClause");

    public Parser suppressClause() {
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

    private Parser sharingClauseParser = null;

    public final Start sharingClause = Start.on(getNamespace(), "sharingClause");

    public Parser sharingClause() {
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

    private Parser paddingClauseParser = null;

    public final Start paddingClause = Start.on(getNamespace(), "paddingClause");

    public Parser paddingClause() {
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

    private Parser ioControlParagraphParser = null;

    public final Start ioControlParagraph = Start.on(getNamespace(), "ioControlParagraph");

    public Parser ioControlParagraph() {
        if (ioControlParagraphParser == null) {
           FutureParser future = scoped("ioControlParagraph", true);
           ioControlParagraphParser = future;
           future.setParser(
               sequence(
                   token("I-O-CONTROL"),
                   token("."),
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

    private Parser objectSectionParser = null;

    public final Start objectSection = Start.on(getNamespace(), "objectSection");

    public Parser objectSection() {
        if (objectSectionParser == null) {
           FutureParser future = scoped("objectSection", true);
           objectSectionParser = future;
           future.setParser(
               choice(
                   sequence(
                       token("OBJECT"),
                       token("SECTION"),
                       token("."),
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

    private Parser objectSectionBodyParser = null;

    public final Start objectSectionBody = Start.on(getNamespace(), "objectSectionBody");

    public Parser objectSectionBody() {
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

    private Parser classControlParagraphParser = null;

    public final Start classControlParagraph = Start.on(getNamespace(), "classControlParagraph");

    public Parser classControlParagraph() {
        if (classControlParagraphParser == null) {
           FutureParser future = scoped("classControlParagraph", true);
           classControlParagraphParser = future;
           future.setParser(
               sequence(
                   token("CLASS-CONTROL"),
                   token("."),
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
                       token(".")
                   )
               )
           );
        }

        return classControlParagraphParser;
    }

    // ========================================================
    // dataDivision
    // ........................................................

    private Parser dataDivisionParser = null;

    public final Start dataDivision = Start.on(getNamespace(), "dataDivision");

    public Parser dataDivision() {
        if (dataDivisionParser == null) {
           FutureParser future = scoped("dataDivision", true);
           dataDivisionParser = future;
           future.setParser(
               choice(
                   sequence(
                       token("DATA"),
                       token("DIVISION"),
                       token("."),
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

    private Parser dataDivisionBodyParser = null;

    public final Start dataDivisionBody = Start.on(getNamespace(), "dataDivisionBody");

    public Parser dataDivisionBody() {
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

    private Parser fileSectionParser = null;

    public final Start fileSection = Start.on(getNamespace(), "fileSection");

    public Parser fileSection() {
        if (fileSectionParser == null) {
           FutureParser future = scoped("fileSection", true);
           fileSectionParser = future;
           future.setParser(
               sequence(
                   token("FILE"),
                   token("SECTION"),
                   token("."),
                   optional(
                       fileSectionBody()
                   )
               )
           );
        }

        return fileSectionParser;
    }

    // ========================================================
    // fileSectionBody
    // ........................................................

    private Parser fileSectionBodyParser = null;

    public final Start fileSectionBody = Start.on(getNamespace(), "fileSectionBody");

    public Parser fileSectionBody() {
        if (fileSectionBodyParser == null) {
           FutureParser future = scoped("fileSectionBody", true);
           fileSectionBodyParser = future;
           future.setParser(
               sequence(
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

        return fileSectionBodyParser;
    }

    // ========================================================
    // fileDescriptionEntry
    // ........................................................

    private Parser fileDescriptionEntryParser = null;

    public final Start fileDescriptionEntry = Start.on(getNamespace(), "fileDescriptionEntry");

    public Parser fileDescriptionEntry() {
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

    private Parser fdFileDescriptionEntryParser = null;

    public final Start fdFileDescriptionEntry = Start.on(getNamespace(), "fdFileDescriptionEntry");

    public Parser fdFileDescriptionEntry() {
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
                       token(".")
                   ),
                   token(".")
               )
           );
        }

        return fdFileDescriptionEntryParser;
    }

    // ========================================================
    // sdFileDescriptionEntry
    // ........................................................

    private Parser sdFileDescriptionEntryParser = null;

    public final Start sdFileDescriptionEntry = Start.on(getNamespace(), "sdFileDescriptionEntry");

    public Parser sdFileDescriptionEntry() {
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
                       token(".")
                   ),
                   token(".")
               )
           );
        }

        return sdFileDescriptionEntryParser;
    }

    // ========================================================
    // workingStorageSection
    // ........................................................

    private Parser workingStorageSectionParser = null;

    public final Start workingStorageSection = Start.on(getNamespace(), "workingStorageSection");

    public Parser workingStorageSection() {
        if (workingStorageSectionParser == null) {
           FutureParser future = scoped("workingStorageSection", true);
           workingStorageSectionParser = future;
           future.setParser(
               sequence(
                   token("WORKING-STORAGE"),
                   token("SECTION"),
                   token("."),
                   star(
                       choice(
                           recordDescriptionEntry(),
                           replaceStatement(),
                           sequence(
                               execStatement(),
                               optional(
                                   token(".")
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

    private Parser threadLocalStorageSectionParser = null;

    public final Start threadLocalStorageSection = Start.on(getNamespace(), "threadLocalStorageSection");

    public Parser threadLocalStorageSection() {
        if (threadLocalStorageSectionParser == null) {
           FutureParser future = scoped("threadLocalStorageSection", true);
           threadLocalStorageSectionParser = future;
           future.setParser(
               sequence(
                   token("THREAD-LOCAL-STORAGE"),
                   token("SECTION"),
                   token("."),
                   star(
                       choice(
                           recordDescriptionEntry(),
                           replaceStatement(),
                           sequence(
                               execStatement(),
                               optional(
                                   token(".")
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

    private Parser objectStorageSectionParser = null;

    public final Start objectStorageSection = Start.on(getNamespace(), "objectStorageSection");

    public Parser objectStorageSection() {
        if (objectStorageSectionParser == null) {
           FutureParser future = scoped("objectStorageSection", true);
           objectStorageSectionParser = future;
           future.setParser(
               sequence(
                   token("OBJECT-STORAGE"),
                   token("SECTION"),
                   token("."),
                   star(
                       choice(
                           recordDescriptionEntry(),
                           replaceStatement(),
                           sequence(
                               execStatement(),
                               optional(
                                   token(".")
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

    private Parser localStorageSectionParser = null;

    public final Start localStorageSection = Start.on(getNamespace(), "localStorageSection");

    public Parser localStorageSection() {
        if (localStorageSectionParser == null) {
           FutureParser future = scoped("localStorageSection", true);
           localStorageSectionParser = future;
           future.setParser(
               sequence(
                   token("LOCAL-STORAGE"),
                   token("SECTION"),
                   token("."),
                   star(
                       choice(
                           recordDescriptionEntry(),
                           replaceStatement(),
                           sequence(
                               execStatement(),
                               optional(
                                   token(".")
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

    private Parser linkageSectionParser = null;

    public final Start linkageSection = Start.on(getNamespace(), "linkageSection");

    public Parser linkageSection() {
        if (linkageSectionParser == null) {
           FutureParser future = scoped("linkageSection", true);
           linkageSectionParser = future;
           future.setParser(
               sequence(
                   token("LINKAGE"),
                   token("SECTION"),
                   token("."),
                   star(
                       choice(
                           recordDescriptionEntry(),
                           replaceStatement(),
                           sequence(
                               execStatement(),
                               optional(
                                   token(".")
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

    private Parser communicationSectionParser = null;

    public final Start communicationSection = Start.on(getNamespace(), "communicationSection");

    public Parser communicationSection() {
        if (communicationSectionParser == null) {
           FutureParser future = scoped("communicationSection", true);
           communicationSectionParser = future;
           future.setParser(
               sequence(
                   token("COMMUNICATION"),
                   token("SECTION"),
                   token("."),
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

    private Parser communicationDescriptionEntryParser = null;

    public final Start communicationDescriptionEntry = Start.on(getNamespace(), "communicationDescriptionEntry");

    public Parser communicationDescriptionEntry() {
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

    private Parser communicationDescriptionEntry_format1Parser = null;

    public final Start communicationDescriptionEntry_format1 = Start.on(getNamespace(), "communicationDescriptionEntry_format1");

    public Parser communicationDescriptionEntry_format1() {
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
                           sequence(
                               not(
                                   token("STATUS")
                               ),
                               dataDescName()
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
                                   dataDescName()
                               ),
                               sequence(
                                   optional(
                                       token("SYMBOLIC")
                                   ),
                                   token("SUB-QUEUE-1"),
                                   optional(
                                       token("IS")
                                   ),
                                   dataDescName()
                               ),
                               sequence(
                                   optional(
                                       token("SYMBOLIC")
                                   ),
                                   token("SUB-QUEUE-2"),
                                   optional(
                                       token("IS")
                                   ),
                                   dataDescName()
                               ),
                               sequence(
                                   optional(
                                       token("SYMBOLIC")
                                   ),
                                   token("SUB-QUEUE-3"),
                                   optional(
                                       token("IS")
                                   ),
                                   dataDescName()
                               ),
                               sequence(
                                   token("MESSAGE"),
                                   token("DATE"),
                                   optional(
                                       token("IS")
                                   ),
                                   dataDescName()
                               ),
                               sequence(
                                   token("MESSAGE"),
                                   token("TIME"),
                                   optional(
                                       token("IS")
                                   ),
                                   dataDescName()
                               ),
                               sequence(
                                   optional(
                                       token("SYMBOLIC")
                                   ),
                                   token("SOURCE"),
                                   optional(
                                       token("IS")
                                   ),
                                   dataDescName()
                               ),
                               sequence(
                                   token("TEXT"),
                                   token("LENGTH"),
                                   optional(
                                       token("IS")
                                   ),
                                   dataDescName()
                               ),
                               sequence(
                                   token("END"),
                                   token("KEY"),
                                   optional(
                                       token("IS")
                                   ),
                                   dataDescName()
                               ),
                               sequence(
                                   token("STATUS"),
                                   token("KEY"),
                                   optional(
                                       token("IS")
                                   ),
                                   dataDescName()
                               ),
                               sequence(
                                   optional(
                                       token("MESSAGE")
                                   ),
                                   token("COUNT"),
                                   optional(
                                       token("IS")
                                   ),
                                   dataDescName()
                               )
                           )
                       )
                   ),
                   token(".")
               )
           );
        }

        return communicationDescriptionEntry_format1Parser;
    }

    // ========================================================
    // communicationDescriptionEntry_format2
    // ........................................................

    private Parser communicationDescriptionEntry_format2Parser = null;

    public final Start communicationDescriptionEntry_format2 = Start.on(getNamespace(), "communicationDescriptionEntry_format2");

    public Parser communicationDescriptionEntry_format2() {
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
                           dataDescName()
                       )
                   ),
                   optional(
                       sequence(
                           token("TEXT"),
                           token("LENGTH"),
                           optional(
                               token("IS")
                           ),
                           dataDescName()
                       )
                   ),
                   optional(
                       sequence(
                           token("STATUS"),
                           token("KEY"),
                           optional(
                               token("IS")
                           ),
                           dataDescName()
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
                           dataDescName()
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
                           dataDescName()
                       )
                   ),
                   token(".")
               )
           );
        }

        return communicationDescriptionEntry_format2Parser;
    }

    // ========================================================
    // communicationDescriptionEntry_format3
    // ........................................................

    private Parser communicationDescriptionEntry_format3Parser = null;

    public final Start communicationDescriptionEntry_format3 = Start.on(getNamespace(), "communicationDescriptionEntry_format3");

    public Parser communicationDescriptionEntry_format3() {
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
                           dataDescName()
                       ),
                       optional(
                           permuted(
                               sequence(
                                   token("MESSAGE"),
                                   token("DATE"),
                                   optional(
                                       token("IS")
                                   ),
                                   dataDescName()
                               ),
                               sequence(
                                   token("MESSAGE"),
                                   token("TIME"),
                                   optional(
                                       token("IS")
                                   ),
                                   dataDescName()
                               ),
                               sequence(
                                   optional(
                                       token("SYMBOLIC")
                                   ),
                                   token("TERMINAL"),
                                   optional(
                                       token("IS")
                                   ),
                                   dataDescName()
                               ),
                               sequence(
                                   token("TEXT"),
                                   token("LENGTH"),
                                   optional(
                                       token("IS")
                                   ),
                                   dataDescName()
                               ),
                               sequence(
                                   token("END"),
                                   token("KEY"),
                                   optional(
                                       token("IS")
                                   ),
                                   dataDescName()
                               ),
                               sequence(
                                   token("STATUS"),
                                   token("KEY"),
                                   optional(
                                       token("IS")
                                   ),
                                   dataDescName()
                               )
                           )
                       )
                   ),
                   token(".")
               )
           );
        }

        return communicationDescriptionEntry_format3Parser;
    }

    // ========================================================
    // reportSection
    // ........................................................

    private Parser reportSectionParser = null;

    public final Start reportSection = Start.on(getNamespace(), "reportSection");

    public Parser reportSection() {
        if (reportSectionParser == null) {
           FutureParser future = scoped("reportSection", true);
           reportSectionParser = future;
           future.setParser(
               sequence(
                   token("REPORT"),
                   token("SECTION"),
                   token("."),
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

    private Parser reportDescriptionEntryParser = null;

    public final Start reportDescriptionEntry = Start.on(getNamespace(), "reportDescriptionEntry");

    public Parser reportDescriptionEntry() {
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
                   token(".")
               )
           );
        }

        return reportDescriptionEntryParser;
    }

    // ========================================================
    // reportGroupDescriptionEntry
    // ........................................................

    private Parser reportGroupDescriptionEntryParser = null;

    public final Start reportGroupDescriptionEntry = Start.on(getNamespace(), "reportGroupDescriptionEntry");

    public Parser reportGroupDescriptionEntry() {
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
                   token(".")
               )
           );
        }

        return reportGroupDescriptionEntryParser;
    }

    // ========================================================
    // screenSection
    // ........................................................

    private Parser screenSectionParser = null;

    public final Start screenSection = Start.on(getNamespace(), "screenSection");

    public Parser screenSection() {
        if (screenSectionParser == null) {
           FutureParser future = scoped("screenSection", true);
           screenSectionParser = future;
           future.setParser(
               sequence(
                   token("SCREEN"),
                   token("SECTION"),
                   token("."),
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

    private Parser screenDescriptionEntryParser = null;

    public final Start screenDescriptionEntry = Start.on(getNamespace(), "screenDescriptionEntry");

    public Parser screenDescriptionEntry() {
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
               )
           );
        }

        return screenDescriptionEntryParser;
    }

    // ========================================================
    // recordDescriptionEntry
    // ........................................................

    private Parser recordDescriptionEntryParser = null;

    public final Start recordDescriptionEntry = Start.on(getNamespace(), "recordDescriptionEntry");

    public Parser recordDescriptionEntry() {
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

    private Parser dataDescriptionEntryParser = null;

    public final Start dataDescriptionEntry = Start.on(getNamespace(), "dataDescriptionEntry");

    public Parser dataDescriptionEntry() {
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

    private Parser constantEntryParser = null;

    public final Start constantEntry = Start.on(getNamespace(), "constantEntry");

    public Parser constantEntry() {
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

    private Parser constantEntry_level01Parser = null;

    private Parser constantEntry_level01() {
        if (constantEntry_level01Parser == null) {
           FutureParser future = scoped("constantEntry_level01", false);
           constantEntry_level01Parser = future;
           future.setParser(
               sequence(
                   choice(
                       token("1"),
                       token("01")
                   ),
                   cobolWord(),
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
                   token(".")
               )
           );
        }

        return constantEntry_level01Parser;
    }

    // ========================================================
    // constantEntry_level78
    // ........................................................

    private Parser constantEntry_level78Parser = null;

    private Parser constantEntry_level78() {
        if (constantEntry_level78Parser == null) {
           FutureParser future = scoped("constantEntry_level78", false);
           constantEntry_level78Parser = future;
           future.setParser(
               sequence(
                   token("78"),
                   cobolWord(),
                   constantValueClause(),
                   token(".")
               )
           );
        }

        return constantEntry_level78Parser;
    }

    // ========================================================
    // dataDescriptionEntry_format1
    // ........................................................

    private Parser dataDescriptionEntry_format1Parser = null;

    private Parser dataDescriptionEntry_format1() {
        if (dataDescriptionEntry_format1Parser == null) {
           FutureParser future = scoped("dataDescriptionEntry_format1", false);
           dataDescriptionEntry_format1Parser = future;
           future.setParser(
               sequence(
                   levelNumber(),
                   optional(
                       dataDescName()
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
                       token(".")
                   ),
                   token(".")
               )
           );
        }

        return dataDescriptionEntry_format1Parser;
    }

    // ========================================================
    // dataDescriptionEntry_format2
    // ........................................................

    private Parser dataDescriptionEntry_format2Parser = null;

    private Parser dataDescriptionEntry_format2() {
        if (dataDescriptionEntry_format2Parser == null) {
           FutureParser future = scoped("dataDescriptionEntry_format2", false);
           dataDescriptionEntry_format2Parser = future;
           future.setParser(
               sequence(
                   token("66"),
                   dataName(),
                   renamesClause(),
                   token(".")
               )
           );
        }

        return dataDescriptionEntry_format2Parser;
    }

    // ========================================================
    // dataDescriptionEntry_format3_and_4
    // ........................................................

    private Parser dataDescriptionEntry_format3_and_4Parser = null;

    private Parser dataDescriptionEntry_format3_and_4() {
        if (dataDescriptionEntry_format3_and_4Parser == null) {
           FutureParser future = scoped("dataDescriptionEntry_format3_and_4", false);
           dataDescriptionEntry_format3_and_4Parser = future;
           future.setParser(
               sequence(
                   token("88"),
                   optional(
                       sequence(
                           not(
                               choice(
                                   token("VALUE"),
                                   token("VALUES")
                               )
                           ),
                           conditionName()
                       )
                   ),
                   valueClause(),
                   token(".")
               )
           );
        }

        return dataDescriptionEntry_format3_and_4Parser;
    }

    // ========================================================
    // dataRecords
    // ........................................................

    private Parser dataRecordsParser = null;

    public final Start dataRecords = Start.on(getNamespace(), "dataRecords");

    public Parser dataRecords() {
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

    private Parser labelRecordsParser = null;

    public final Start labelRecords = Start.on(getNamespace(), "labelRecords");

    public Parser labelRecords() {
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

    private Parser recordingModeParser = null;

    public final Start recordingMode = Start.on(getNamespace(), "recordingMode");

    public Parser recordingMode() {
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

    private Parser valueOfFileIdParser = null;

    public final Start valueOfFileId = Start.on(getNamespace(), "valueOfFileId");

    public Parser valueOfFileId() {
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

    private Parser valueOfParser = null;

    public final Start valueOf = Start.on(getNamespace(), "valueOf");

    public Parser valueOf() {
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

    private Parser cicsValueParser = null;

    public final Start cicsValue = Start.on(getNamespace(), "cicsValue");

    public Parser cicsValue() {
        if (cicsValueParser == null) {
           FutureParser future = scoped("cicsValue", true);
           cicsValueParser = future;
           future.setParser(
               sequence(
                   choice(
                       token("DFHVALUE"),
                       token("DFHRESP")
                   ),
                   token("("),
                   cobolWord(),
                   token(")")
               )
           );
        }

        return cicsValueParser;
    }

    // ========================================================
    // whenSetToFalseClause
    // ........................................................

    private Parser whenSetToFalseClauseParser = null;

    public final Start whenSetToFalseClause = Start.on(getNamespace(), "whenSetToFalseClause");

    public Parser whenSetToFalseClause() {
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

    private Parser blankWhenZeroParser = null;

    public final Start blankWhenZero = Start.on(getNamespace(), "blankWhenZero");

    public Parser blankWhenZero() {
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

    private Parser threadLocalClauseParser = null;

    public final Start threadLocalClause = Start.on(getNamespace(), "threadLocalClause");

    public Parser threadLocalClause() {
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

    private Parser zeroParser = null;

    public final Start zero = Start.on(getNamespace(), "zero");

    public Parser zero() {
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

    private Parser spaceParser = null;

    public final Start space = Start.on(getNamespace(), "space");

    public Parser space() {
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

    private Parser justifiedParser = null;

    public final Start justified = Start.on(getNamespace(), "justified");

    public Parser justified() {
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

    private Parser valueClauseParser = null;

    public final Start valueClause = Start.on(getNamespace(), "valueClause");

    public Parser valueClause() {
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
                                   literal()
                               ),
                               token("FROM"),
                               token("("),
                               plus(
                                   subscript()
                               ),
                               token(")"),
                               optional(
                                   sequence(
                                       token("TO"),
                                       token("("),
                                       plus(
                                           subscript()
                                       ),
                                       token(")")
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

    private Parser alignedClauseParser = null;

    public final Start alignedClause = Start.on(getNamespace(), "alignedClause");

    public Parser alignedClause() {
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

    private Parser anyLengthClauseParser = null;

    public final Start anyLengthClause = Start.on(getNamespace(), "anyLengthClause");

    public Parser anyLengthClause() {
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

    private Parser autoClauseParser = null;

    public final Start autoClause = Start.on(getNamespace(), "autoClause");

    public Parser autoClause() {
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

    private Parser backgroundColorClauseParser = null;

    public final Start backgroundColorClause = Start.on(getNamespace(), "backgroundColorClause");

    public Parser backgroundColorClause() {
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

    private Parser basedClauseParser = null;

    public final Start basedClause = Start.on(getNamespace(), "basedClause");

    public Parser basedClause() {
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

    private Parser bellClauseParser = null;

    public final Start bellClause = Start.on(getNamespace(), "bellClause");

    public Parser bellClause() {
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

    private Parser blankClauseParser = null;

    public final Start blankClause = Start.on(getNamespace(), "blankClause");

    public Parser blankClause() {
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

    private Parser blankWhenZeroClauseParser = null;

    public final Start blankWhenZeroClause = Start.on(getNamespace(), "blankWhenZeroClause");

    public Parser blankWhenZeroClause() {
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

    private Parser blinkClauseParser = null;

    public final Start blinkClause = Start.on(getNamespace(), "blinkClause");

    public Parser blinkClause() {
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

    private Parser blockContainsClauseParser = null;

    public final Start blockContainsClause = Start.on(getNamespace(), "blockContainsClause");

    public Parser blockContainsClause() {
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

    private Parser classClauseParser = null;

    public final Start classClause = Start.on(getNamespace(), "classClause");

    public Parser classClause() {
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

    private Parser codeClauseParser = null;

    public final Start codeClause = Start.on(getNamespace(), "codeClause");

    public Parser codeClause() {
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

    private Parser codeSetClauseParser = null;

    public final Start codeSetClause = Start.on(getNamespace(), "codeSetClause");

    public Parser codeSetClause() {
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

    private Parser columnClauseParser = null;

    public final Start columnClause = Start.on(getNamespace(), "columnClause");

    public Parser columnClause() {
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
                           token("+"),
                           token("MINUS"),
                           token("-")
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

    private Parser constantRecordClauseParser = null;

    public final Start constantRecordClause = Start.on(getNamespace(), "constantRecordClause");

    public Parser constantRecordClause() {
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

    private Parser constantValueClauseParser = null;

    public final Start constantValueClause = Start.on(getNamespace(), "constantValueClause");

    public Parser constantValueClause() {
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
                               token("&"),
                               token("+"),
                               token("-"),
                               token("*"),
                               token("/")
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

    private Parser controlClauseParser = null;

    public final Start controlClause = Start.on(getNamespace(), "controlClause");

    public Parser controlClause() {
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

    private Parser defaultClauseParser = null;

    public final Start defaultClause = Start.on(getNamespace(), "defaultClause");

    public Parser defaultClause() {
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

    private Parser destinationClauseParser = null;

    public final Start destinationClause = Start.on(getNamespace(), "destinationClause");

    public Parser destinationClause() {
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

    private Parser eraseClauseParser = null;

    public final Start eraseClause = Start.on(getNamespace(), "eraseClause");

    public Parser eraseClause() {
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

    private Parser externalClauseParser = null;

    public final Start externalClause = Start.on(getNamespace(), "externalClause");

    public Parser externalClause() {
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

    private Parser foregroundColorClauseParser = null;

    public final Start foregroundColorClause = Start.on(getNamespace(), "foregroundColorClause");

    public Parser foregroundColorClause() {
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

    private Parser formatClauseParser = null;

    public final Start formatClause = Start.on(getNamespace(), "formatClause");

    public Parser formatClause() {
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

    private Parser fullClauseParser = null;

    public final Start fullClause = Start.on(getNamespace(), "fullClause");

    public Parser fullClause() {
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

    private Parser globalClauseParser = null;

    public final Start globalClause = Start.on(getNamespace(), "globalClause");

    public Parser globalClause() {
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

    private Parser groupIndicateClauseParser = null;

    public final Start groupIndicateClause = Start.on(getNamespace(), "groupIndicateClause");

    public Parser groupIndicateClause() {
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

    private Parser groupUsageClauseParser = null;

    public final Start groupUsageClause = Start.on(getNamespace(), "groupUsageClause");

    public Parser groupUsageClause() {
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

    private Parser highlightClauseParser = null;

    public final Start highlightClause = Start.on(getNamespace(), "highlightClause");

    public Parser highlightClause() {
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

    private Parser invalidClauseParser = null;

    public final Start invalidClause = Start.on(getNamespace(), "invalidClause");

    public Parser invalidClause() {
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

    private Parser justifiedClauseParser = null;

    public final Start justifiedClause = Start.on(getNamespace(), "justifiedClause");

    public Parser justifiedClause() {
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

    private Parser linageClauseParser = null;

    public final Start linageClause = Start.on(getNamespace(), "linageClause");

    public Parser linageClause() {
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

    private Parser footingClauseParser = null;

    public final Start footingClause = Start.on(getNamespace(), "footingClause");

    public Parser footingClause() {
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

    private Parser linesAtTopClauseParser = null;

    public final Start linesAtTopClause = Start.on(getNamespace(), "linesAtTopClause");

    public Parser linesAtTopClause() {
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

    private Parser linesAtBottomClauseParser = null;

    public final Start linesAtBottomClause = Start.on(getNamespace(), "linesAtBottomClause");

    public Parser linesAtBottomClause() {
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

    private Parser lineClauseParser = null;

    public final Start lineClause = Start.on(getNamespace(), "lineClause");

    public Parser lineClause() {
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
                                       token("+")
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
                               token("+"),
                               token("MINUS"),
                               token("-")
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

    private Parser nextGroupClauseParser = null;

    public final Start nextGroupClause = Start.on(getNamespace(), "nextGroupClause");

    public Parser nextGroupClause() {
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

    private Parser occursClauseParser = null;

    public final Start occursClause = Start.on(getNamespace(), "occursClause");

    public Parser occursClause() {
        if (occursClauseParser == null) {
           FutureParser future = scoped("occursClause", true);
           occursClauseParser = future;
           future.setParser(
               sequence(
                   token("OCCURS"),
                   choice(
                       sequence(
                           choice(
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
                               ),
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
                           ),
                           optional(
                               sequence(
                                   token("DEPENDING"),
                                   optional(
                                       token("ON")
                                   ),
                                   qualifiedDataName()
                               )
                           ),
                           optional(
                               sequence(
                                   token("STEP"),
                                   integer()
                               )
                           ),
                           star(
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
                           ),
                           star(
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
                       ),
                       token("ANY")
                   )
               )
           );
        }

        return occursClauseParser;
    }

    // ========================================================
    // pageClause
    // ........................................................

    private Parser pageClauseParser = null;

    public final Start pageClause = Start.on(getNamespace(), "pageClause");

    public Parser pageClause() {
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

    private Parser pictureClauseParser = null;

    public final Start pictureClause = Start.on(getNamespace(), "pictureClause");

    public Parser pictureClause() {
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

    private Parser pictureLocaleClauseParser = null;

    public final Start pictureLocaleClause = Start.on(getNamespace(), "pictureLocaleClause");

    public Parser pictureLocaleClause() {
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

    private Parser presentWhenClauseParser = null;

    public final Start presentWhenClause = Start.on(getNamespace(), "presentWhenClause");

    public Parser presentWhenClause() {
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

    private Parser propertyClauseParser = null;

    public final Start propertyClause = Start.on(getNamespace(), "propertyClause");

    public Parser propertyClause() {
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

    private Parser recordClauseParser = null;

    public final Start recordClause = Start.on(getNamespace(), "recordClause");

    public Parser recordClause() {
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

    private Parser recordContainsClauseParser = null;

    public final Start recordContainsClause = Start.on(getNamespace(), "recordContainsClause");

    public Parser recordContainsClause() {
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

    private Parser recordIsVaryingClauseParser = null;

    public final Start recordIsVaryingClause = Start.on(getNamespace(), "recordIsVaryingClause");

    public Parser recordIsVaryingClause() {
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

    private Parser redefinesClauseParser = null;

    public final Start redefinesClause = Start.on(getNamespace(), "redefinesClause");

    public Parser redefinesClause() {
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

    private Parser renamesClauseParser = null;

    public final Start renamesClause = Start.on(getNamespace(), "renamesClause");

    public Parser renamesClause() {
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

    private Parser reportClauseParser = null;

    public final Start reportClause = Start.on(getNamespace(), "reportClause");

    public Parser reportClause() {
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

    private Parser reportGroupTypeClauseParser = null;

    public final Start reportGroupTypeClause = Start.on(getNamespace(), "reportGroupTypeClause");

    public Parser reportGroupTypeClause() {
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

    private Parser reportGroupUsageClauseParser = null;

    public final Start reportGroupUsageClause = Start.on(getNamespace(), "reportGroupUsageClause");

    public Parser reportGroupUsageClause() {
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

    private Parser reportSectionValueClauseParser = null;

    public final Start reportSectionValueClause = Start.on(getNamespace(), "reportSectionValueClause");

    public Parser reportSectionValueClause() {
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

    private Parser reverseVideoClauseParser = null;

    public final Start reverseVideoClause = Start.on(getNamespace(), "reverseVideoClause");

    public Parser reverseVideoClause() {
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

    private Parser requiredClauseParser = null;

    public final Start requiredClause = Start.on(getNamespace(), "requiredClause");

    public Parser requiredClause() {
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

    private Parser sameAsClauseParser = null;

    public final Start sameAsClause = Start.on(getNamespace(), "sameAsClause");

    public Parser sameAsClause() {
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

    private Parser screenFromClauseParser = null;

    public final Start screenFromClause = Start.on(getNamespace(), "screenFromClause");

    public Parser screenFromClause() {
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

    private Parser screenToClauseParser = null;

    public final Start screenToClause = Start.on(getNamespace(), "screenToClause");

    public Parser screenToClause() {
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

    private Parser screenUsingClauseParser = null;

    public final Start screenUsingClause = Start.on(getNamespace(), "screenUsingClause");

    public Parser screenUsingClause() {
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

    private Parser screenValueClauseParser = null;

    public final Start screenValueClause = Start.on(getNamespace(), "screenValueClause");

    public Parser screenValueClause() {
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

    private Parser secureClauseParser = null;

    public final Start secureClause = Start.on(getNamespace(), "secureClause");

    public Parser secureClause() {
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

    private Parser selectWhenClauseParser = null;

    public final Start selectWhenClause = Start.on(getNamespace(), "selectWhenClause");

    public Parser selectWhenClause() {
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

    private Parser signClauseParser = null;

    public final Start signClause = Start.on(getNamespace(), "signClause");

    public Parser signClause() {
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

    private Parser sourceClauseParser = null;

    public final Start sourceClause = Start.on(getNamespace(), "sourceClause");

    public Parser sourceClause() {
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
                           arithmeticExpression(),
                           identifier()
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

    private Parser sumClauseParser = null;

    public final Start sumClause = Start.on(getNamespace(), "sumClause");

    public Parser sumClause() {
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

    private Parser synchronizedClauseParser = null;

    public final Start synchronizedClause = Start.on(getNamespace(), "synchronizedClause");

    public Parser synchronizedClause() {
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

    private Parser typedefClauseParser = null;

    public final Start typedefClause = Start.on(getNamespace(), "typedefClause");

    public Parser typedefClause() {
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

    private Parser typeNameTypeClauseParser = null;

    public final Start typeNameTypeClause = Start.on(getNamespace(), "typeNameTypeClause");

    public Parser typeNameTypeClause() {
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

    private Parser underlineClauseParser = null;

    public final Start underlineClause = Start.on(getNamespace(), "underlineClause");

    public Parser underlineClause() {
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

    private Parser usageClauseParser = null;

    public final Start usageClause = Start.on(getNamespace(), "usageClause");

    public Parser usageClause() {
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

    private Parser usageOperandParser = null;

    public final Start usageOperand = Start.on(getNamespace(), "usageOperand");

    public Parser usageOperand() {
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

    private Parser validateStatusClauseParser = null;

    public final Start validateStatusClause = Start.on(getNamespace(), "validateStatusClause");

    public Parser validateStatusClause() {
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

    private Parser varyingClauseParser = null;

    public final Start varyingClause = Start.on(getNamespace(), "varyingClause");

    public Parser varyingClause() {
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

    private Parser procedureDivisionParser = null;

    public final Start procedureDivision = Start.on(getNamespace(), "procedureDivision");

    public Parser procedureDivision() {
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

    private Parser procedureDivisionHeaderParser = null;

    public final Start procedureDivisionHeader = Start.on(getNamespace(), "procedureDivisionHeader");

    public Parser procedureDivisionHeader() {
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
                   token(".")
               )
           );
        }

        return procedureDivisionHeaderParser;
    }

    // ========================================================
    // usingOrChainingPhrase
    // ........................................................

    private Parser usingOrChainingPhraseParser = null;

    public final Start usingOrChainingPhrase = Start.on(getNamespace(), "usingOrChainingPhrase");

    public Parser usingOrChainingPhrase() {
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

    private Parser dataReferenceParser = null;

    public final Start dataReference = Start.on(getNamespace(), "dataReference");

    public Parser dataReference() {
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

    private Parser dataValueParser = null;

    public final Start dataValue = Start.on(getNamespace(), "dataValue");

    public Parser dataValue() {
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

    private Parser dataOutputParser = null;

    public final Start dataOutput = Start.on(getNamespace(), "dataOutput");

    public Parser dataOutput() {
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

    private Parser repeatedPhraseParser = null;

    public final Start repeatedPhrase = Start.on(getNamespace(), "repeatedPhrase");

    public Parser repeatedPhrase() {
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

    private Parser returningProcedurePhraseParser = null;

    public final Start returningProcedurePhrase = Start.on(getNamespace(), "returningProcedurePhrase");

    public Parser returningProcedurePhrase() {
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

    private Parser roundedPhraseParser = null;

    public final Start roundedPhrase = Start.on(getNamespace(), "roundedPhrase");

    public Parser roundedPhrase() {
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

    private Parser declarativesParser = null;

    public final Start declaratives = Start.on(getNamespace(), "declaratives");

    public Parser declaratives() {
        if (declarativesParser == null) {
           FutureParser future = scoped("declaratives", true);
           declarativesParser = future;
           future.setParser(
               sequence(
                   token("DECLARATIVES"),
                   token("."),
                   star(
                       declarativeSection()
                   ),
                   token("END"),
                   token("DECLARATIVES"),
                   token(".")
               )
           );
        }

        return declarativesParser;
    }

    // ========================================================
    // declarativeSection
    // ........................................................

    private Parser declarativeSectionParser = null;

    public final Start declarativeSection = Start.on(getNamespace(), "declarativeSection");

    public Parser declarativeSection() {
        if (declarativeSectionParser == null) {
           FutureParser future = scoped("declarativeSection", true);
           declarativeSectionParser = future;
           future.setParser(
               sequence(
                   sectionName(),
                   token("SECTION"),
                   token("."),
                   as("sentence",
                       as("statement",
                           sequence(
                               useStatement(),
                               token(".")
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

    private Parser sectionParser = null;

    public final Start section = Start.on(getNamespace(), "section");

    public Parser section() {
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
                   token("."),
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

    private Parser paragraphParser = null;

    public final Start paragraph = Start.on(getNamespace(), "paragraph");

    public Parser paragraph() {
        if (paragraphParser == null) {
           FutureParser future = scoped("paragraph", true);
           paragraphParser = future;
           future.setParser(
               sequence(
                   paragraphName(),
                   token("."),
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

    private Parser sentenceParser = null;

    public final Start sentence = Start.on(getNamespace(), "sentence");

    public Parser sentence() {
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
                       token(".")
                   ),
                   token(".")
               )
           );
        }

        return sentenceParser;
    }

    // ========================================================
    // statement
    // ........................................................

    private Parser statementParser = null;

    public final Start statement = Start.on(getNamespace(), "statement");

    public Parser statement() {
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
                       new Parser[]{
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
                                   token("."),
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

    private Parser subStatementMarkerParser = null;

    public final Start subStatementMarker = Start.on(getNamespace(), "subStatementMarker");

    public Parser subStatementMarker() {
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

    private Parser continuationOfStatementParser = null;

    public final Start continuationOfStatement = Start.on(getNamespace(), "continuationOfStatement");

    public Parser continuationOfStatement() {
        if (continuationOfStatementParser == null) {
           FutureParser future = scoped("continuationOfStatement", true);
           continuationOfStatementParser = future;
           future.setParser(
               choice(
                   sequence(
                       assign("t", eventPhrase()),
                       apply(new Block() {
                           public void apply() {
                               Token t = (Token) scope().get("t");
                               { warn(t, "Nested statement found out of line."); }
                               scope().put("t", t);
                           }
                       }),
                       statement()
                   ),
                   sequence(
                       assign("t", endOfStatementMarker()),
                       apply(new Block() {
                           public void apply() {
                               Token t = (Token) scope().get("t");
                               { warn(t, "Loose end of statement."); }
                               scope().put("t", t);
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

    private Parser nestedStatementsParser = null;

    public final Start nestedStatements = Start.on(getNamespace(), "nestedStatements");

    public Parser nestedStatements() {
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

    private Parser eventPhraseParser = null;

    public final Start eventPhrase = Start.on(getNamespace(), "eventPhrase");

    public Parser eventPhrase() {
        if (eventPhraseParser == null) {
           FutureParser future = scoped("eventPhrase", true);
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
                       )
                   ),
                   returning("t")
               )
           );
        }

        return eventPhraseParser;
    }

    // ========================================================
    // retryPhrase
    // ........................................................

    private Parser retryPhraseParser = null;

    public final Start retryPhrase = Start.on(getNamespace(), "retryPhrase");

    public Parser retryPhrase() {
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

    private Parser endOfStatementMarkerParser = null;

    public final Start endOfStatementMarker = Start.on(getNamespace(), "endOfStatementMarker");

    public Parser endOfStatementMarker() {
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

    private Parser verbParser = null;

    public final Start verb = Start.on(getNamespace(), "verb");

    public Parser verb() {
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

    private Parser acceptStatementParser = null;

    public final Start acceptStatement = Start.on(getNamespace(), "acceptStatement");

    public Parser acceptStatement() {
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

    private Parser acceptFromMnemonicParser = null;

    public final Start acceptFromMnemonic = Start.on(getNamespace(), "acceptFromMnemonic");

    public Parser acceptFromMnemonic() {
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

    private Parser acceptFromOtherParser = null;

    public final Start acceptFromOther = Start.on(getNamespace(), "acceptFromOther");

    public Parser acceptFromOther() {
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

    private Parser acceptScreenFormatParser = null;

    public final Start acceptScreenFormat = Start.on(getNamespace(), "acceptScreenFormat");

    public Parser acceptScreenFormat() {
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

    private Parser acceptFromDateParser = null;

    public final Start acceptFromDate = Start.on(getNamespace(), "acceptFromDate");

    public Parser acceptFromDate() {
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

    private Parser acceptMessageCountParser = null;

    public final Start acceptMessageCount = Start.on(getNamespace(), "acceptMessageCount");

    public Parser acceptMessageCount() {
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

    private Parser unitPhraseParser = null;

    public final Start unitPhrase = Start.on(getNamespace(), "unitPhrase");

    public Parser unitPhrase() {
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

    private Parser modeIsBlockPhraseParser = null;

    public final Start modeIsBlockPhrase = Start.on(getNamespace(), "modeIsBlockPhrase");

    public Parser modeIsBlockPhrase() {
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

    private Parser acceptScreenSizeDataParser = null;

    public final Start acceptScreenSizeData = Start.on(getNamespace(), "acceptScreenSizeData");

    public Parser acceptScreenSizeData() {
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

    private Parser addStatementParser = null;

    public final Start addStatement = Start.on(getNamespace(), "addStatement");

    public Parser addStatement() {
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

    private Parser addition_format1Parser = null;

    public final Start addition_format1 = Start.on(getNamespace(), "addition_format1");

    public Parser addition_format1() {
        if (addition_format1Parser == null) {
           FutureParser future = scoped("addition_format1", true);
           addition_format1Parser = future;
           future.setParser(
               sequence(
                   choice(
                       token("CORRESPONDING"),
                       token("CORR")
                   ),
                   qualifiedDataName(),
                   token("TO"),
                   qualifiedDataName(),
                   optional(
                       token("ROUNDED")
                   )
               )
           );
        }

        return addition_format1Parser;
    }

    // ========================================================
    // addition_format2
    // ........................................................

    private Parser addition_format2Parser = null;

    public final Start addition_format2 = Start.on(getNamespace(), "addition_format2");

    public Parser addition_format2() {
        if (addition_format2Parser == null) {
           FutureParser future = scoped("addition_format2", true);
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
                       sequence(
                           token("TO"),
                           choice(
                               identifier(),
                               literal()
                           )
                       )
                   ),
                   token("GIVING"),
                   plus(
                       sequence(
                           qualifiedDataName(),
                           optional(
                               token("ROUNDED")
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

    private Parser addition_format3Parser = null;

    public final Start addition_format3 = Start.on(getNamespace(), "addition_format3");

    public Parser addition_format3() {
        if (addition_format3Parser == null) {
           FutureParser future = scoped("addition_format3", true);
           addition_format3Parser = future;
           future.setParser(
               sequence(
                   plus(
                       choice(
                           identifier(),
                           literal()
                       )
                   ),
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
           );
        }

        return addition_format3Parser;
    }

    // ========================================================
    // allocateStatement
    // ........................................................

    private Parser allocateStatementParser = null;

    public final Start allocateStatement = Start.on(getNamespace(), "allocateStatement");

    public Parser allocateStatement() {
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

    private Parser alterStatementParser = null;

    public final Start alterStatement = Start.on(getNamespace(), "alterStatement");

    public Parser alterStatement() {
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

    private Parser alterationClauseParser = null;

    public final Start alterationClause = Start.on(getNamespace(), "alterationClause");

    public Parser alterationClause() {
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

    private Parser callStatementParser = null;

    public final Start callStatement = Start.on(getNamespace(), "callStatement");

    public Parser callStatement() {
        if (callStatementParser == null) {
           FutureParser future = scoped("callStatement", true);
           callStatementParser = future;
           future.setParser(
               sequence(
                   token("CALL"),
                   choice(
                       token("NESTED"),
                       sequence(
                           mnemonicName(),
                           choice(
                               alphanumericLiteral(),
                               identifier()
                           )
                       ),
                       sequence(
                           choice(
                               alphanumericLiteral(),
                               identifier()
                           ),
                           optional(
                               sequence(
                                   token("AS"),
                                   choice(
                                       token("NESTED"),
                                       programName()
                                   )
                               )
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

    private Parser callUsingParser = null;

    public final Start callUsing = Start.on(getNamespace(), "callUsing");

    public Parser callUsing() {
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
                                   arithmeticExpression(),
                                   identifier(),
                                   literal()
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
                                   arithmeticExpression(),
                                   identifier(),
                                   literal()
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

    private Parser callGivingOrReturningParser = null;

    public final Start callGivingOrReturning = Start.on(getNamespace(), "callGivingOrReturning");

    public Parser callGivingOrReturning() {
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

    private Parser onOverflowParser = null;

    public final Start onOverflow = Start.on(getNamespace(), "onOverflow");

    public Parser onOverflow() {
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

    private Parser notOnOverflowParser = null;

    public final Start notOnOverflow = Start.on(getNamespace(), "notOnOverflow");

    public Parser notOnOverflow() {
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

    private Parser onExceptionParser = null;

    public final Start onException = Start.on(getNamespace(), "onException");

    public Parser onException() {
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

    private Parser notOnExceptionParser = null;

    public final Start notOnException = Start.on(getNamespace(), "notOnException");

    public Parser notOnException() {
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

    private Parser onSizeErrorParser = null;

    public final Start onSizeError = Start.on(getNamespace(), "onSizeError");

    public Parser onSizeError() {
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

    private Parser notOnSizeErrorParser = null;

    public final Start notOnSizeError = Start.on(getNamespace(), "notOnSizeError");

    public Parser notOnSizeError() {
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

    private Parser onEscapeParser = null;

    public final Start onEscape = Start.on(getNamespace(), "onEscape");

    public Parser onEscape() {
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

    private Parser notOnEscapeParser = null;

    public final Start notOnEscape = Start.on(getNamespace(), "notOnEscape");

    public Parser notOnEscape() {
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

    private Parser programIDParser = null;

    public final Start programID = Start.on(getNamespace(), "programID");

    public Parser programID() {
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

    private Parser cancelStatementParser = null;

    public final Start cancelStatement = Start.on(getNamespace(), "cancelStatement");

    public Parser cancelStatement() {
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

    private Parser chainStatementParser = null;

    public final Start chainStatement = Start.on(getNamespace(), "chainStatement");

    public Parser chainStatement() {
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

    private Parser chainUsingParser = null;

    public final Start chainUsing = Start.on(getNamespace(), "chainUsing");

    public Parser chainUsing() {
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

    private Parser closeStatementParser = null;

    public final Start closeStatement = Start.on(getNamespace(), "closeStatement");

    public Parser closeStatement() {
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

    private Parser commitStatementParser = null;

    public final Start commitStatement = Start.on(getNamespace(), "commitStatement");

    public Parser commitStatement() {
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

    private Parser computeStatementParser = null;

    public final Start computeStatement = Start.on(getNamespace(), "computeStatement");

    public Parser computeStatement() {
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
                       token("="),
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

    private Parser continueStatementParser = null;

    public final Start continueStatement = Start.on(getNamespace(), "continueStatement");

    public Parser continueStatement() {
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

    private Parser deleteStatementParser = null;

    public final Start deleteStatement = Start.on(getNamespace(), "deleteStatement");

    public Parser deleteStatement() {
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

    private Parser invalidKeyParser = null;

    public final Start invalidKey = Start.on(getNamespace(), "invalidKey");

    public Parser invalidKey() {
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

    private Parser notInvalidKeyParser = null;

    public final Start notInvalidKey = Start.on(getNamespace(), "notInvalidKey");

    public Parser notInvalidKey() {
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

    private Parser deleteFileStatementParser = null;

    public final Start deleteFileStatement = Start.on(getNamespace(), "deleteFileStatement");

    public Parser deleteFileStatement() {
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

    private Parser disableStatementParser = null;

    public final Start disableStatement = Start.on(getNamespace(), "disableStatement");

    public Parser disableStatement() {
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

    private Parser displayStatementParser = null;

    public final Start displayStatement = Start.on(getNamespace(), "displayStatement");

    public Parser displayStatement() {
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

    private Parser displayStatement__Parser = null;

    public final Start displayStatement__ = Start.on(getNamespace(), "displayStatement__");

    public Parser displayStatement__() {
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

    private Parser displayDeviceFormatParser = null;

    public final Start displayDeviceFormat = Start.on(getNamespace(), "displayDeviceFormat");

    public Parser displayDeviceFormat() {
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

    private Parser uponClauseParser = null;

    public final Start uponClause = Start.on(getNamespace(), "uponClause");

    public Parser uponClause() {
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

    private Parser withNoAdvancingParser = null;

    public final Start withNoAdvancing = Start.on(getNamespace(), "withNoAdvancing");

    public Parser withNoAdvancing() {
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

    private Parser displayTerminalFormatParser = null;

    public final Start displayTerminalFormat = Start.on(getNamespace(), "displayTerminalFormat");

    public Parser displayTerminalFormat() {
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

    private Parser dtAtPositioningParser = null;

    public final Start dtAtPositioning = Start.on(getNamespace(), "dtAtPositioning");

    public Parser dtAtPositioning() {
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

    private Parser dtLineColPositioningParser = null;

    public final Start dtLineColPositioning = Start.on(getNamespace(), "dtLineColPositioning");

    public Parser dtLineColPositioning() {
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

    private Parser dtLinePosParser = null;

    public final Start dtLinePos = Start.on(getNamespace(), "dtLinePos");

    public Parser dtLinePos() {
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
                           token("+"),
                           token("-")
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

    private Parser dtColPosParser = null;

    public final Start dtColPos = Start.on(getNamespace(), "dtColPos");

    public Parser dtColPos() {
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
                           token("+"),
                           token("-")
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

    private Parser screenEntryPhraseParser = null;

    public final Start screenEntryPhrase = Start.on(getNamespace(), "screenEntryPhrase");

    public Parser screenEntryPhrase() {
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

    private Parser autoPhraseParser = null;

    public final Start autoPhrase = Start.on(getNamespace(), "autoPhrase");

    public Parser autoPhrase() {
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

    private Parser backgroundPhraseParser = null;

    public final Start backgroundPhrase = Start.on(getNamespace(), "backgroundPhrase");

    public Parser backgroundPhrase() {
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

    private Parser beepPhraseParser = null;

    public final Start beepPhrase = Start.on(getNamespace(), "beepPhrase");

    public Parser beepPhrase() {
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

    private Parser blankPhraseParser = null;

    public final Start blankPhrase = Start.on(getNamespace(), "blankPhrase");

    public Parser blankPhrase() {
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

    private Parser blinkPhraseParser = null;

    public final Start blinkPhrase = Start.on(getNamespace(), "blinkPhrase");

    public Parser blinkPhrase() {
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

    private Parser boldPhraseParser = null;

    public final Start boldPhrase = Start.on(getNamespace(), "boldPhrase");

    public Parser boldPhrase() {
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

    private Parser capitalizationPhraseParser = null;

    public final Start capitalizationPhrase = Start.on(getNamespace(), "capitalizationPhrase");

    public Parser capitalizationPhrase() {
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

    private Parser controlPhraseParser = null;

    public final Start controlPhrase = Start.on(getNamespace(), "controlPhrase");

    public Parser controlPhrase() {
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

    private Parser convertPhraseParser = null;

    public final Start convertPhrase = Start.on(getNamespace(), "convertPhrase");

    public Parser convertPhrase() {
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

    private Parser cursorPhraseParser = null;

    public final Start cursorPhrase = Start.on(getNamespace(), "cursorPhrase");

    public Parser cursorPhrase() {
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

    private Parser echoPhraseParser = null;

    public final Start echoPhrase = Start.on(getNamespace(), "echoPhrase");

    public Parser echoPhrase() {
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

    private Parser erasePhraseParser = null;

    public final Start erasePhrase = Start.on(getNamespace(), "erasePhrase");

    public Parser erasePhrase() {
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

    private Parser foregroundPhraseParser = null;

    public final Start foregroundPhrase = Start.on(getNamespace(), "foregroundPhrase");

    public Parser foregroundPhrase() {
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

    private Parser fullPhraseParser = null;

    public final Start fullPhrase = Start.on(getNamespace(), "fullPhrase");

    public Parser fullPhrase() {
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

    private Parser gridPhraseParser = null;

    public final Start gridPhrase = Start.on(getNamespace(), "gridPhrase");

    public Parser gridPhrase() {
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

    private Parser highPhraseParser = null;

    public final Start highPhrase = Start.on(getNamespace(), "highPhrase");

    public Parser highPhrase() {
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

    private Parser linePhraseParser = null;

    public final Start linePhrase = Start.on(getNamespace(), "linePhrase");

    public Parser linePhrase() {
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

    private Parser lowPhraseParser = null;

    public final Start lowPhrase = Start.on(getNamespace(), "lowPhrase");

    public Parser lowPhrase() {
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

    private Parser offPhraseParser = null;

    public final Start offPhrase = Start.on(getNamespace(), "offPhrase");

    public Parser offPhrase() {
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

    private Parser promptPhraseParser = null;

    public final Start promptPhrase = Start.on(getNamespace(), "promptPhrase");

    public Parser promptPhrase() {
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

    private Parser requiredPhraseParser = null;

    public final Start requiredPhrase = Start.on(getNamespace(), "requiredPhrase");

    public Parser requiredPhrase() {
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

    private Parser reversePhraseParser = null;

    public final Start reversePhrase = Start.on(getNamespace(), "reversePhrase");

    public Parser reversePhrase() {
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

    private Parser scrollPhraseParser = null;

    public final Start scrollPhrase = Start.on(getNamespace(), "scrollPhrase");

    public Parser scrollPhrase() {
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

    private Parser securePhraseParser = null;

    public final Start securePhrase = Start.on(getNamespace(), "securePhrase");

    public Parser securePhrase() {
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

    private Parser sizePhraseParser = null;

    public final Start sizePhrase = Start.on(getNamespace(), "sizePhrase");

    public Parser sizePhrase() {
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

    private Parser standardPhraseParser = null;

    public final Start standardPhrase = Start.on(getNamespace(), "standardPhrase");

    public Parser standardPhrase() {
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

    private Parser tabPhraseParser = null;

    public final Start tabPhrase = Start.on(getNamespace(), "tabPhrase");

    public Parser tabPhrase() {
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

    private Parser timePhraseParser = null;

    public final Start timePhrase = Start.on(getNamespace(), "timePhrase");

    public Parser timePhrase() {
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

    private Parser timeoutPhraseParser = null;

    public final Start timeoutPhrase = Start.on(getNamespace(), "timeoutPhrase");

    public Parser timeoutPhrase() {
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

    private Parser justificationPhraseParser = null;

    public final Start justificationPhrase = Start.on(getNamespace(), "justificationPhrase");

    public Parser justificationPhrase() {
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

    private Parser fillPhraseParser = null;

    public final Start fillPhrase = Start.on(getNamespace(), "fillPhrase");

    public Parser fillPhrase() {
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

    private Parser trailingSignPhraseParser = null;

    public final Start trailingSignPhrase = Start.on(getNamespace(), "trailingSignPhrase");

    public Parser trailingSignPhrase() {
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

    private Parser updatePhraseParser = null;

    public final Start updatePhrase = Start.on(getNamespace(), "updatePhrase");

    public Parser updatePhrase() {
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

    private Parser divideStatementParser = null;

    public final Start divideStatement = Start.on(getNamespace(), "divideStatement");

    public Parser divideStatement() {
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

    private Parser division_format1Parser = null;

    public final Start division_format1 = Start.on(getNamespace(), "division_format1");

    public Parser division_format1() {
        if (division_format1Parser == null) {
           FutureParser future = scoped("division_format1", true);
           division_format1Parser = future;
           future.setParser(
               sequence(
                   choice(
                       identifier(),
                       literal()
                   ),
                   choice(
                       token("INTO"),
                       token("BY")
                   ),
                   choice(
                       identifier(),
                       literal()
                   ),
                   token("GIVING"),
                   qualifiedDataName(),
                   optional(
                       token("ROUNDED")
                   ),
                   token("REMAINDER"),
                   qualifiedDataName()
               )
           );
        }

        return division_format1Parser;
    }

    // ========================================================
    // division_format2
    // ........................................................

    private Parser division_format2Parser = null;

    public final Start division_format2 = Start.on(getNamespace(), "division_format2");

    public Parser division_format2() {
        if (division_format2Parser == null) {
           FutureParser future = scoped("division_format2", true);
           division_format2Parser = future;
           future.setParser(
               sequence(
                   choice(
                       identifier(),
                       literal()
                   ),
                   choice(
                       token("INTO"),
                       token("BY")
                   ),
                   choice(
                       identifier(),
                       literal()
                   ),
                   token("GIVING"),
                   plus(
                       sequence(
                           qualifiedDataName(),
                           optional(
                               token("ROUNDED")
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

    private Parser division_format3Parser = null;

    public final Start division_format3 = Start.on(getNamespace(), "division_format3");

    public Parser division_format3() {
        if (division_format3Parser == null) {
           FutureParser future = scoped("division_format3", true);
           division_format3Parser = future;
           future.setParser(
               sequence(
                   choice(
                       identifier(),
                       literal()
                   ),
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
           );
        }

        return division_format3Parser;
    }

    // ========================================================
    // enableStatement
    // ........................................................

    private Parser enableStatementParser = null;

    public final Start enableStatement = Start.on(getNamespace(), "enableStatement");

    public Parser enableStatement() {
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

    private Parser entryStatementParser = null;

    public final Start entryStatement = Start.on(getNamespace(), "entryStatement");

    public Parser entryStatement() {
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

    private Parser evaluateStatementParser = null;

    public final Start evaluateStatement = Start.on(getNamespace(), "evaluateStatement");

    public Parser evaluateStatement() {
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

    private Parser subjectParser = null;

    public final Start subject = Start.on(getNamespace(), "subject");

    public Parser subject() {
        if (subjectParser == null) {
           FutureParser future = scoped("subject", true);
           subjectParser = future;
           future.setParser(
               choice(
                   condition(),
                   arithmeticExpression(),
                   identifier(),
                   literal()
               )
           );
        }

        return subjectParser;
    }

    // ========================================================
    // when
    // ........................................................

    private Parser whenParser = null;

    public final Start when = Start.on(getNamespace(), "when");

    public Parser when() {
        if (whenParser == null) {
           FutureParser future = scoped("when", true);
           whenParser = future;
           future.setParser(
               sequence(
                   plus(
                       sequence(
                           token("WHEN"),
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

    private Parser whenOtherParser = null;

    public final Start whenOther = Start.on(getNamespace(), "whenOther");

    public Parser whenOther() {
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

    private Parser objectParser = null;

    public final Start object = Start.on(getNamespace(), "object");

    public Parser object() {
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
                           arithmeticExpression(),
                           identifier(),
                           literal()
                       )
                   ),
                   sequence(
                       token("("),
                       object(),
                       token(")")
                   )
               )
           );
        }

        return objectParser;
    }

    // ========================================================
    // rangeExpression
    // ........................................................

    private Parser rangeExpressionParser = null;

    public final Start rangeExpression = Start.on(getNamespace(), "rangeExpression");

    public Parser rangeExpression() {
        if (rangeExpressionParser == null) {
           FutureParser future = scoped("rangeExpression", true);
           rangeExpressionParser = future;
           future.setParser(
               sequence(
                   optional(
                       token("NOT")
                   ),
                   choice(
                       arithmeticExpression(),
                       identifier(),
                       literal()
                   ),
                   choice(
                       token("THROUGH"),
                       token("THRU")
                   ),
                   choice(
                       arithmeticExpression(),
                       identifier(),
                       literal()
                   )
               )
           );
        }

        return rangeExpressionParser;
    }

    // ========================================================
    // examineStatement
    // ........................................................

    private Parser examineStatementParser = null;

    public final Start examineStatement = Start.on(getNamespace(), "examineStatement");

    public Parser examineStatement() {
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

    private Parser execStatementParser = null;

    private Parser execStatement() {
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

    private Parser execSQLStatementParser = null;

    public final Start execSQLStatement = Start.on(getNamespace(), "execSQLStatement");

    public Parser execSQLStatement() {
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

    private Parser execCICSStatementParser = null;

    public final Start execCICSStatement = Start.on(getNamespace(), "execCICSStatement");

    public Parser execCICSStatement() {
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

    private Parser execDLIStatementParser = null;

    public final Start execDLIStatement = Start.on(getNamespace(), "execDLIStatement");

    public Parser execDLIStatement() {
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

    private Parser execHTMLStatementParser = null;

    public final Start execHTMLStatement = Start.on(getNamespace(), "execHTMLStatement");

    public Parser execHTMLStatement() {
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

    private Parser execTextDataStatementParser = null;

    public final Start execTextDataStatement = Start.on(getNamespace(), "execTextDataStatement");

    public Parser execTextDataStatement() {
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

    private Parser exitStatementParser = null;

    public final Start exitStatement = Start.on(getNamespace(), "exitStatement");

    public Parser exitStatement() {
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

    private Parser returningPhraseParser = null;

    public final Start returningPhrase = Start.on(getNamespace(), "returningPhrase");

    public Parser returningPhrase() {
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

    private Parser generateStatementParser = null;

    public final Start generateStatement = Start.on(getNamespace(), "generateStatement");

    public Parser generateStatement() {
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

    private Parser freeStatementParser = null;

    public final Start freeStatement = Start.on(getNamespace(), "freeStatement");

    public Parser freeStatement() {
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

    private Parser gobackStatementParser = null;

    public final Start gobackStatement = Start.on(getNamespace(), "gobackStatement");

    public Parser gobackStatement() {
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

    private Parser goToStatementParser = null;

    public final Start goToStatement = Start.on(getNamespace(), "goToStatement");

    public Parser goToStatement() {
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

    private Parser dependingOnParser = null;

    public final Start dependingOn = Start.on(getNamespace(), "dependingOn");

    public Parser dependingOn() {
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

    private Parser ifStatementParser = null;

    public final Start ifStatement = Start.on(getNamespace(), "ifStatement");

    public Parser ifStatement() {
        if (ifStatementParser == null) {
           FutureParser future = scoped("ifStatement", true);
           ifStatementParser = future;
           future.setParser(
               sequence(
                   token("IF"),
                   condition(),
                   optional(
                       token("THEN")
                   ),
                   choice(
                       nestedStatements(),
                       as("statement",
                           nextSentence()
                       )
                   ),
                   optional(
                       sequence(
                           token("ELSE"),
                           choice(
                               nestedStatements(),
                               as("statement",
                                   nextSentence()
                               )
                           )
                       )
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
    // nextSentence
    // ........................................................

    private Parser nextSentenceParser = null;

    public final Start nextSentence = Start.on(getNamespace(), "nextSentence");

    public Parser nextSentence() {
        if (nextSentenceParser == null) {
           FutureParser future = scoped("nextSentence", true);
           nextSentenceParser = future;
           future.setParser(
               sequence(
                   token("NEXT"),
                   token("SENTENCE")
               )
           );
        }

        return nextSentenceParser;
    }

    // ========================================================
    // initiateStatement
    // ........................................................

    private Parser initiateStatementParser = null;

    public final Start initiateStatement = Start.on(getNamespace(), "initiateStatement");

    public Parser initiateStatement() {
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

    private Parser invokeStatementParser = null;

    public final Start invokeStatement = Start.on(getNamespace(), "invokeStatement");

    public Parser invokeStatement() {
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
                                           arithmeticExpression(),
                                           literal(),
                                           identifier()
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
                                           arithmeticExpression(),
                                           integer(),
                                           identifier()
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

    private Parser exhibitStatementParser = null;

    public final Start exhibitStatement = Start.on(getNamespace(), "exhibitStatement");

    public Parser exhibitStatement() {
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

    private Parser identifiedByStatementParser = null;

    public final Start identifiedByStatement = Start.on(getNamespace(), "identifiedByStatement");

    public Parser identifiedByStatement() {
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

    private Parser initializeStatementParser = null;

    public final Start initializeStatement = Start.on(getNamespace(), "initializeStatement");

    public Parser initializeStatement() {
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
                               token("."),
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

    private Parser replacingInitClauseParser = null;

    public final Start replacingInitClause = Start.on(getNamespace(), "replacingInitClause");

    public Parser replacingInitClause() {
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

    private Parser replacementTargetParser = null;

    public final Start replacementTarget = Start.on(getNamespace(), "replacementTarget");

    public Parser replacementTarget() {
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

    private Parser inspectStatementParser = null;

    public final Start inspectStatement = Start.on(getNamespace(), "inspectStatement");

    public Parser inspectStatement() {
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

    private Parser convertingPhraseParser = null;

    public final Start convertingPhrase = Start.on(getNamespace(), "convertingPhrase");

    public Parser convertingPhrase() {
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

    private Parser tallyingPhraseParser = null;

    public final Start tallyingPhrase = Start.on(getNamespace(), "tallyingPhrase");

    public Parser tallyingPhrase() {
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

    private Parser tallyingCharactersPhraseParser = null;

    public final Start tallyingCharactersPhrase = Start.on(getNamespace(), "tallyingCharactersPhrase");

    public Parser tallyingCharactersPhrase() {
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

    private Parser tallyingAllLeadingOrTrailingPhraseParser = null;

    public final Start tallyingAllLeadingOrTrailingPhrase = Start.on(getNamespace(), "tallyingAllLeadingOrTrailingPhrase");

    public Parser tallyingAllLeadingOrTrailingPhrase() {
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

    private Parser replacingPhraseParser = null;

    public final Start replacingPhrase = Start.on(getNamespace(), "replacingPhrase");

    public Parser replacingPhrase() {
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

    private Parser replacingCharactersPhraseParser = null;

    public final Start replacingCharactersPhrase = Start.on(getNamespace(), "replacingCharactersPhrase");

    public Parser replacingCharactersPhrase() {
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

    private Parser replacingAllLeadingFirstOrTrailingPhraseParser = null;

    public final Start replacingAllLeadingFirstOrTrailingPhrase = Start.on(getNamespace(), "replacingAllLeadingFirstOrTrailingPhrase");

    public Parser replacingAllLeadingFirstOrTrailingPhrase() {
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

    private Parser locationPhraseParser = null;

    public final Start locationPhrase = Start.on(getNamespace(), "locationPhrase");

    public Parser locationPhrase() {
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

    private Parser mergeStatementParser = null;

    public final Start mergeStatement = Start.on(getNamespace(), "mergeStatement");

    public Parser mergeStatement() {
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

    private Parser moveStatementParser = null;

    public final Start moveStatement = Start.on(getNamespace(), "moveStatement");

    public Parser moveStatement() {
        if (moveStatementParser == null) {
           FutureParser future = scoped("moveStatement", true);
           moveStatementParser = future;
           future.setParser(
               sequence(
                   token("MOVE"),
                   choice(
                       sequence(
                           token("LENGTH"),
                           optional(
                               token("OF")
                           ),
                           identifier()
                       ),
                       sequence(
                           optional(
                               choice(
                                   token("CORRESPONDING"),
                                   token("CORR")
                               )
                           ),
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
                               token("."),
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

    private Parser multiplyStatementParser = null;

    public final Start multiplyStatement = Start.on(getNamespace(), "multiplyStatement");

    public Parser multiplyStatement() {
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

    private Parser multiplication_format1Parser = null;

    public final Start multiplication_format1 = Start.on(getNamespace(), "multiplication_format1");

    public Parser multiplication_format1() {
        if (multiplication_format1Parser == null) {
           FutureParser future = scoped("multiplication_format1", true);
           multiplication_format1Parser = future;
           future.setParser(
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
                   token("GIVING"),
                   plus(
                       sequence(
                           qualifiedDataName(),
                           optional(
                               token("ROUNDED")
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

    private Parser multiplication_format2Parser = null;

    public final Start multiplication_format2 = Start.on(getNamespace(), "multiplication_format2");

    public Parser multiplication_format2() {
        if (multiplication_format2Parser == null) {
           FutureParser future = scoped("multiplication_format2", true);
           multiplication_format2Parser = future;
           future.setParser(
               sequence(
                   choice(
                       identifier(),
                       literal()
                   ),
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
           );
        }

        return multiplication_format2Parser;
    }

    // ========================================================
    // nextSentenceStatement
    // ........................................................

    private Parser nextSentenceStatementParser = null;

    public final Start nextSentenceStatement = Start.on(getNamespace(), "nextSentenceStatement");

    public Parser nextSentenceStatement() {
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

    private Parser onStatementParser = null;

    public final Start onStatement = Start.on(getNamespace(), "onStatement");

    public Parser onStatement() {
        if (onStatementParser == null) {
           FutureParser future = scoped("onStatement", true);
           onStatementParser = future;
           future.setParser(
               sequence(
                   token("ON"),
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

    private Parser openStatementParser = null;

    public final Start openStatement = Start.on(getNamespace(), "openStatement");

    public Parser openStatement() {
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

    private Parser performStatementParser = null;

    public final Start performStatement = Start.on(getNamespace(), "performStatement");

    public Parser performStatement() {
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
                               sequence(
                                   as("nestedStatements",
                                       statement()
                                   ),
                                   not(
                                       token("THRU")
                                   ),
                                   not(
                                       token("THROUGH")
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

    private Parser timesParser = null;

    public final Start times = Start.on(getNamespace(), "times");

    public Parser times() {
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

    private Parser testPositionParser = null;

    public final Start testPosition = Start.on(getNamespace(), "testPosition");

    public Parser testPosition() {
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

    private Parser untilParser = null;

    public final Start until = Start.on(getNamespace(), "until");

    public Parser until() {
        if (untilParser == null) {
           FutureParser future = scoped("until", true);
           untilParser = future;
           future.setParser(
               sequence(
                   optional(
                       testPosition()
                   ),
                   token("UNTIL"),
                   choice(
                       condition(),
                       token("EXIT")
                   )
               )
           );
        }

        return untilParser;
    }

    // ========================================================
    // varying
    // ........................................................

    private Parser varyingParser = null;

    public final Start varying = Start.on(getNamespace(), "varying");

    public Parser varying() {
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

    private Parser purgeStatementParser = null;

    public final Start purgeStatement = Start.on(getNamespace(), "purgeStatement");

    public Parser purgeStatement() {
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

    private Parser raiseStatementParser = null;

    public final Start raiseStatement = Start.on(getNamespace(), "raiseStatement");

    public Parser raiseStatement() {
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

    private Parser readStatementParser = null;

    public final Start readStatement = Start.on(getNamespace(), "readStatement");

    public Parser readStatement() {
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

    private Parser readWithClauseParser = null;

    public final Start readWithClause = Start.on(getNamespace(), "readWithClause");

    public Parser readWithClause() {
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

    private Parser readLockClauseParser = null;

    public final Start readLockClause = Start.on(getNamespace(), "readLockClause");

    public Parser readLockClause() {
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

    private Parser readyTraceStatementParser = null;

    public final Start readyTraceStatement = Start.on(getNamespace(), "readyTraceStatement");

    public Parser readyTraceStatement() {
        if (readyTraceStatementParser == null) {
           FutureParser future = scoped("readyTraceStatement", true);
           readyTraceStatementParser = future;
           future.setParser(
               sequence(
                   token("READY"),
                   token("TRACE"),
                   optional(
                       token(".")
                   )
               )
           );
        }

        return readyTraceStatementParser;
    }

    // ========================================================
    // receiveStatement
    // ........................................................

    private Parser receiveStatementParser = null;

    public final Start receiveStatement = Start.on(getNamespace(), "receiveStatement");

    public Parser receiveStatement() {
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

    private Parser noDataParser = null;

    public final Start noData = Start.on(getNamespace(), "noData");

    public Parser noData() {
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

    private Parser withDataParser = null;

    public final Start withData = Start.on(getNamespace(), "withData");

    public Parser withData() {
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

    private Parser releaseStatementParser = null;

    public final Start releaseStatement = Start.on(getNamespace(), "releaseStatement");

    public Parser releaseStatement() {
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

    private Parser resetTraceStatementParser = null;

    public final Start resetTraceStatement = Start.on(getNamespace(), "resetTraceStatement");

    public Parser resetTraceStatement() {
        if (resetTraceStatementParser == null) {
           FutureParser future = scoped("resetTraceStatement", true);
           resetTraceStatementParser = future;
           future.setParser(
               sequence(
                   token("RESET"),
                   token("TRACE"),
                   optional(
                       token(".")
                   )
               )
           );
        }

        return resetTraceStatementParser;
    }

    // ========================================================
    // returnStatement
    // ........................................................

    private Parser returnStatementParser = null;

    public final Start returnStatement = Start.on(getNamespace(), "returnStatement");

    public Parser returnStatement() {
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

    private Parser rewriteStatementParser = null;

    public final Start rewriteStatement = Start.on(getNamespace(), "rewriteStatement");

    public Parser rewriteStatement() {
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

    private Parser rollbackStatementParser = null;

    public final Start rollbackStatement = Start.on(getNamespace(), "rollbackStatement");

    public Parser rollbackStatement() {
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

    private Parser searchStatementParser = null;

    public final Start searchStatement = Start.on(getNamespace(), "searchStatement");

    public Parser searchStatement() {
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

    private Parser atEndParser = null;

    public final Start atEnd = Start.on(getNamespace(), "atEnd");

    public Parser atEnd() {
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

    private Parser notAtEndParser = null;

    public final Start notAtEnd = Start.on(getNamespace(), "notAtEnd");

    public Parser notAtEnd() {
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

    private Parser sendStatementParser = null;

    public final Start sendStatement = Start.on(getNamespace(), "sendStatement");

    public Parser sendStatement() {
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

    private Parser serviceStatementParser = null;

    public final Start serviceStatement = Start.on(getNamespace(), "serviceStatement");

    public Parser serviceStatement() {
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

    private Parser sortStatementParser = null;

    public final Start sortStatement = Start.on(getNamespace(), "sortStatement");

    public Parser sortStatement() {
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

    private Parser setStatementParser = null;

    public final Start setStatement = Start.on(getNamespace(), "setStatement");

    public Parser setStatement() {
        if (setStatementParser == null) {
           FutureParser future = scoped("setStatement", true);
           setStatementParser = future;
           future.setParser(
               sequence(
                   token("SET"),
                   choice(
                       setEnvironmentVariable(),
                       setFormatMonitorValue(),
                       setFormatDataPointerAssignment(),
                       setFormatProcedurePointerAssignment(),
                       setFormatSemaphoreValue(),
                       setFormat1(),
                       setFormat2(),
                       setFormat3()
                   ),
                   optional(
                       skipto(
                           choice(
                               token("."),
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
    // setFormat1
    // ........................................................

    private Parser setFormat1Parser = null;

    public final Start setFormat1 = Start.on(getNamespace(), "setFormat1");

    public Parser setFormat1() {
        if (setFormat1Parser == null) {
           FutureParser future = scoped("setFormat1", true);
           setFormat1Parser = future;
           future.setParser(
               sequence(
                   plus(
                       choice(
                           indexName(),
                           identifier()
                       )
                   ),
                   token("TO"),
                   choice(
                       indexName(),
                       identifier(),
                       integer()
                   )
               )
           );
        }

        return setFormat1Parser;
    }

    // ========================================================
    // setFormat2
    // ........................................................

    private Parser setFormat2Parser = null;

    public final Start setFormat2 = Start.on(getNamespace(), "setFormat2");

    public Parser setFormat2() {
        if (setFormat2Parser == null) {
           FutureParser future = scoped("setFormat2", true);
           setFormat2Parser = future;
           future.setParser(
               sequence(
                   plus(
                       mnemonicName()
                   ),
                   token("TO"),
                   choice(
                       token("ON"),
                       token("OFF")
                   )
               )
           );
        }

        return setFormat2Parser;
    }

    // ========================================================
    // setFormat3
    // ........................................................

    private Parser setFormat3Parser = null;

    public final Start setFormat3 = Start.on(getNamespace(), "setFormat3");

    public Parser setFormat3() {
        if (setFormat3Parser == null) {
           FutureParser future = scoped("setFormat3", true);
           setFormat3Parser = future;
           future.setParser(
               sequence(
                   plus(
                       identifier()
                   ),
                   token("TO"),
                   choice(
                       token("TRUE"),
                       token("FALSE")
                   )
               )
           );
        }

        return setFormat3Parser;
    }

    // ========================================================
    // setFormatDataPointerAssignment
    // ........................................................

    private Parser setFormatDataPointerAssignmentParser = null;

    public final Start setFormatDataPointerAssignment = Start.on(getNamespace(), "setFormatDataPointerAssignment");

    public Parser setFormatDataPointerAssignment() {
        if (setFormatDataPointerAssignmentParser == null) {
           FutureParser future = scoped("setFormatDataPointerAssignment", true);
           setFormatDataPointerAssignmentParser = future;
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
                           identifier()
                       )
                   ),
                   token("TO"),
                   choice(
                       sequence(
                           token("ADDRESS"),
                           optional(
                               token("OF")
                           ),
                           identifier()
                       ),
                       mnemonicName(),
                       token("NULL"),
                       token("NULLS")
                   )
               )
           );
        }

        return setFormatDataPointerAssignmentParser;
    }

    // ========================================================
    // setFormatProcedurePointerAssignment
    // ........................................................

    private Parser setFormatProcedurePointerAssignmentParser = null;

    public final Start setFormatProcedurePointerAssignment = Start.on(getNamespace(), "setFormatProcedurePointerAssignment");

    public Parser setFormatProcedurePointerAssignment() {
        if (setFormatProcedurePointerAssignmentParser == null) {
           FutureParser future = scoped("setFormatProcedurePointerAssignment", true);
           setFormatProcedurePointerAssignmentParser = future;
           future.setParser(
               sequence(
                   procedureName(),
                   token("TO"),
                   choice(
                       procedureName(),
                       sequence(
                           token("ENTRY"),
                           choice(
                               identifier(),
                               literal()
                           )
                       ),
                       token("NULL"),
                       token("NULLS")
                   )
               )
           );
        }

        return setFormatProcedurePointerAssignmentParser;
    }

    // ========================================================
    // setFormatMonitorValue
    // ........................................................

    private Parser setFormatMonitorValueParser = null;

    public final Start setFormatMonitorValue = Start.on(getNamespace(), "setFormatMonitorValue");

    public Parser setFormatMonitorValue() {
        if (setFormatMonitorValueParser == null) {
           FutureParser future = scoped("setFormatMonitorValue", true);
           setFormatMonitorValueParser = future;
           future.setParser(
               sequence(
                   plus(
                       mnemonicName()
                   ),
                   token("TO"),
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
               )
           );
        }

        return setFormatMonitorValueParser;
    }

    // ========================================================
    // setFormatSemaphoreValue
    // ........................................................

    private Parser setFormatSemaphoreValueParser = null;

    public final Start setFormatSemaphoreValue = Start.on(getNamespace(), "setFormatSemaphoreValue");

    public Parser setFormatSemaphoreValue() {
        if (setFormatSemaphoreValueParser == null) {
           FutureParser future = scoped("setFormatSemaphoreValue", true);
           setFormatSemaphoreValueParser = future;
           future.setParser(
               sequence(
                   plus(
                       mnemonicName()
                   ),
                   token("TO"),
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
           );
        }

        return setFormatSemaphoreValueParser;
    }

    // ========================================================
    // setEnvironmentVariable
    // ........................................................

    private Parser setEnvironmentVariableParser = null;

    public final Start setEnvironmentVariable = Start.on(getNamespace(), "setEnvironmentVariable");

    public Parser setEnvironmentVariable() {
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
    // startStatement
    // ........................................................

    private Parser startStatementParser = null;

    public final Start startStatement = Start.on(getNamespace(), "startStatement");

    public Parser startStatement() {
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

    private Parser keyModifierParser = null;

    public final Start keyModifier = Start.on(getNamespace(), "keyModifier");

    public Parser keyModifier() {
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

    private Parser sizeModifierParser = null;

    public final Start sizeModifier = Start.on(getNamespace(), "sizeModifier");

    public Parser sizeModifier() {
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

    private Parser whileKeyModifierParser = null;

    public final Start whileKeyModifier = Start.on(getNamespace(), "whileKeyModifier");

    public Parser whileKeyModifier() {
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

    private Parser likeModsParser = null;

    public final Start likeMods = Start.on(getNamespace(), "likeMods");

    public Parser likeMods() {
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

    private Parser trimmedRightParser = null;

    public final Start trimmedRight = Start.on(getNamespace(), "trimmedRight");

    public Parser trimmedRight() {
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

    private Parser trimmedLeftParser = null;

    public final Start trimmedLeft = Start.on(getNamespace(), "trimmedLeft");

    public Parser trimmedLeft() {
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

    private Parser caseSensitiveParser = null;

    public final Start caseSensitive = Start.on(getNamespace(), "caseSensitive");

    public Parser caseSensitive() {
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

    private Parser caseInsensitiveParser = null;

    public final Start caseInsensitive = Start.on(getNamespace(), "caseInsensitive");

    public Parser caseInsensitive() {
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

    private Parser stopStatementParser = null;

    public final Start stopStatement = Start.on(getNamespace(), "stopStatement");

    public Parser stopStatement() {
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

    private Parser stringStatementParser = null;

    public final Start stringStatement = Start.on(getNamespace(), "stringStatement");

    public Parser stringStatement() {
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

    private Parser subtractStatementParser = null;

    public final Start subtractStatement = Start.on(getNamespace(), "subtractStatement");

    public Parser subtractStatement() {
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

    private Parser subtraction_format1Parser = null;

    public final Start subtraction_format1 = Start.on(getNamespace(), "subtraction_format1");

    public Parser subtraction_format1() {
        if (subtraction_format1Parser == null) {
           FutureParser future = scoped("subtraction_format1", true);
           subtraction_format1Parser = future;
           future.setParser(
               sequence(
                   choice(
                       token("CORRESPONDING"),
                       token("CORR")
                   ),
                   identifier(),
                   token("FROM"),
                   identifier(),
                   optional(
                       token("ROUNDED")
                   )
               )
           );
        }

        return subtraction_format1Parser;
    }

    // ========================================================
    // subtraction_format2
    // ........................................................

    private Parser subtraction_format2Parser = null;

    public final Start subtraction_format2 = Start.on(getNamespace(), "subtraction_format2");

    public Parser subtraction_format2() {
        if (subtraction_format2Parser == null) {
           FutureParser future = scoped("subtraction_format2", true);
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
                       sequence(
                           token("FROM"),
                           choice(
                               identifier(),
                               literal()
                           )
                       )
                   ),
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
           );
        }

        return subtraction_format2Parser;
    }

    // ========================================================
    // subtraction_format3
    // ........................................................

    private Parser subtraction_format3Parser = null;

    public final Start subtraction_format3 = Start.on(getNamespace(), "subtraction_format3");

    public Parser subtraction_format3() {
        if (subtraction_format3Parser == null) {
           FutureParser future = scoped("subtraction_format3", true);
           subtraction_format3Parser = future;
           future.setParser(
               sequence(
                   plus(
                       choice(
                           identifier(),
                           literal()
                       )
                   ),
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
           );
        }

        return subtraction_format3Parser;
    }

    // ========================================================
    // suppressStatement
    // ........................................................

    private Parser suppressStatementParser = null;

    public final Start suppressStatement = Start.on(getNamespace(), "suppressStatement");

    public Parser suppressStatement() {
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

    private Parser terminateStatementParser = null;

    public final Start terminateStatement = Start.on(getNamespace(), "terminateStatement");

    public Parser terminateStatement() {
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

    private Parser transformStatementParser = null;

    public final Start transformStatement = Start.on(getNamespace(), "transformStatement");

    public Parser transformStatement() {
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

    private Parser unlockStatementParser = null;

    public final Start unlockStatement = Start.on(getNamespace(), "unlockStatement");

    public Parser unlockStatement() {
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

    private Parser unstringStatementParser = null;

    public final Start unstringStatement = Start.on(getNamespace(), "unstringStatement");

    public Parser unstringStatement() {
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

    private Parser useStatementParser = null;

    public final Start useStatement = Start.on(getNamespace(), "useStatement");

    public Parser useStatement() {
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

    private Parser errorDeclarativeParser = null;

    public final Start errorDeclarative = Start.on(getNamespace(), "errorDeclarative");

    public Parser errorDeclarative() {
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

    private Parser debugDeclarativeParser = null;

    public final Start debugDeclarative = Start.on(getNamespace(), "debugDeclarative");

    public Parser debugDeclarative() {
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

    private Parser labelDeclarativeParser = null;

    public final Start labelDeclarative = Start.on(getNamespace(), "labelDeclarative");

    public Parser labelDeclarative() {
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

    private Parser beforeReportingDeclarativeParser = null;

    public final Start beforeReportingDeclarative = Start.on(getNamespace(), "beforeReportingDeclarative");

    public Parser beforeReportingDeclarative() {
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

    private Parser waitStatementParser = null;

    public final Start waitStatement = Start.on(getNamespace(), "waitStatement");

    public Parser waitStatement() {
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

    private Parser writeStatementParser = null;

    public final Start writeStatement = Start.on(getNamespace(), "writeStatement");

    public Parser writeStatement() {
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

    private Parser atEndOfPageParser = null;

    public final Start atEndOfPage = Start.on(getNamespace(), "atEndOfPage");

    public Parser atEndOfPage() {
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

    private Parser notAtEndOfPageParser = null;

    public final Start notAtEndOfPage = Start.on(getNamespace(), "notAtEndOfPage");

    public Parser notAtEndOfPage() {
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

    private Parser xmlGenerateStatementParser = null;

    public final Start xmlGenerateStatement = Start.on(getNamespace(), "xmlGenerateStatement");

    public Parser xmlGenerateStatement() {
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

    private Parser xmlParseStatementParser = null;

    public final Start xmlParseStatement = Start.on(getNamespace(), "xmlParseStatement");

    public Parser xmlParseStatement() {
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

    private Parser compilerStatementParser = null;

    public final Start compilerStatement = Start.on(getNamespace(), "compilerStatement");

    public Parser compilerStatement() {
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
                       token(".")
                   )
               )
           );
        }

        return compilerStatementParser;
    }

    // ========================================================
    // compilerDirective
    // ........................................................

    private Parser compilerDirectiveParser = null;

    public final Start compilerDirective = Start.on(getNamespace(), "compilerDirective");

    public Parser compilerDirective() {
        if (compilerDirectiveParser == null) {
           FutureParser future = scoped("compilerDirective", true);
           compilerDirectiveParser = future;
           future.setParser(
               sequence(
                   sequence(
                       token("\u0024"),
                       token("SET")
                   ),
                   skipto(
                       choice(
                           sequence(
                               token("\u0024"),
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

    private Parser compilerIfStatementParser = null;

    public final Start compilerIfStatement = Start.on(getNamespace(), "compilerIfStatement");

    public Parser compilerIfStatement() {
        if (compilerIfStatementParser == null) {
           FutureParser future = scoped("compilerIfStatement", true);
           compilerIfStatementParser = future;
           future.setParser(
               sequence(
                   token("\u0024"),
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
                                   token("<"),
                                   token(">"),
                                   token("=")
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
                           token("\u0024"),
                           token("ELSE"),
                           choice(
                               compilerStatement(),
                               nestedStatements()
                           )
                       )
                   ),
                   token("\u0024"),
                   token("END")
               )
           );
        }

        return compilerIfStatementParser;
    }

    // ========================================================
    // compilerDisplayStatement
    // ........................................................

    private Parser compilerDisplayStatementParser = null;

    public final Start compilerDisplayStatement = Start.on(getNamespace(), "compilerDisplayStatement");

    public Parser compilerDisplayStatement() {
        if (compilerDisplayStatementParser == null) {
           FutureParser future = scoped("compilerDisplayStatement", true);
           compilerDisplayStatementParser = future;
           future.setParser(
               sequence(
                   token("\u0024"),
                   token("DISPLAY"),
                   choice(
                       sequence(
                           token("VCS"),
                           token("="),
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

    private Parser copyOperandNameParser = null;

    public final Start copyOperandName = Start.on(getNamespace(), "copyOperandName");

    public Parser copyOperandName() {
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

    private Parser replaceStatementParser = null;

    public final Start replaceStatement = Start.on(getNamespace(), "replaceStatement");

    public Parser replaceStatement() {
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
                       token(".")
                   )
               )
           );
        }

        return replaceStatementParser;
    }

    // ========================================================
    // sourceFormattingDirective
    // ........................................................

    private Parser sourceFormattingDirectiveParser = null;

    public final Start sourceFormattingDirective = Start.on(getNamespace(), "sourceFormattingDirective");

    public Parser sourceFormattingDirective() {
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

    private Parser ejectStatementParser = null;

    public final Start ejectStatement = Start.on(getNamespace(), "ejectStatement");

    public Parser ejectStatement() {
        if (ejectStatementParser == null) {
           FutureParser future = scoped("ejectStatement", true);
           ejectStatementParser = future;
           future.setParser(
               sequence(
                   token("EJECT"),
                   optional(
                       token(".")
                   )
               )
           );
        }

        return ejectStatementParser;
    }

    // ========================================================
    // skipStatement
    // ........................................................

    private Parser skipStatementParser = null;

    public final Start skipStatement = Start.on(getNamespace(), "skipStatement");

    public Parser skipStatement() {
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
                       token(".")
                   )
               )
           );
        }

        return skipStatementParser;
    }

    // ========================================================
    // titleStatement
    // ........................................................

    private Parser titleStatementParser = null;

    public final Start titleStatement = Start.on(getNamespace(), "titleStatement");

    public Parser titleStatement() {
        if (titleStatementParser == null) {
           FutureParser future = scoped("titleStatement", true);
           titleStatementParser = future;
           future.setParser(
               sequence(
                   token("TITLE"),
                   literal(),
                   optional(
                       token(".")
                   )
               )
           );
        }

        return titleStatementParser;
    }

    // ========================================================
    // divisionStart
    // ........................................................

    private Parser divisionStartParser = null;

    public final Start divisionStart = Start.on(getNamespace(), "divisionStart");

    public Parser divisionStart() {
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
                   token(".")
               )
           );
        }

        return divisionStartParser;
    }

    // ========================================================
    // sectionStart
    // ........................................................

    private Parser sectionStartParser = null;

    public final Start sectionStart = Start.on(getNamespace(), "sectionStart");

    public Parser sectionStart() {
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
                   token(".")
               )
           );
        }

        return sectionStartParser;
    }

    // ========================================================
    // paragraphStart
    // ........................................................

    private Parser paragraphStartParser = null;

    public final Start paragraphStart = Start.on(getNamespace(), "paragraphStart");

    public Parser paragraphStart() {
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
                   token(".")
               )
           );
        }

        return paragraphStartParser;
    }

    // ========================================================
    // endOfStatement
    // ........................................................

    private Parser endOfStatementParser = null;

    public final Start endOfStatement = Start.on(getNamespace(), "endOfStatement");

    public Parser endOfStatement() {
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

    private Parser functionParser = null;

    public final Start function = Start.on(getNamespace(), "function");

    public Parser function() {
        if (functionParser == null) {
           FutureParser future = scoped("function", true);
           functionParser = future;
           future.setParser(
               sequence(
                   token("FUNCTION"),
                   choice(
                       sequence(
                           token("ABS"),
                           token("("),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("ACOS"),
                           token("("),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("ANNUITY"),
                           token("("),
                           argument(),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("ASIN"),
                           token("("),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("ATAN"),
                           token("("),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("BOOLEAN-OF-INTEGER"),
                           token("("),
                           argument(),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("BYTE-LENGTH"),
                           token("("),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("CHAR"),
                           token("("),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("CHAR-NATIONAL"),
                           token("("),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("COMBINED-DATETIME"),
                           token("("),
                           argument(),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("CONCATENATE"),
                           token("("),
                           plus(
                               argument()
                           ),
                           token(")")
                       ),
                       sequence(
                           token("COS"),
                           token("("),
                           argument(),
                           token(")")
                       ),
                       token("CURRENT-DATE"),
                       sequence(
                           token("DATE-OF-INTEGER"),
                           token("("),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("DATE-TO-YYYYMMDD"),
                           token("("),
                           argument(),
                           optional(
                               argument()
                           ),
                           token(")")
                       ),
                       sequence(
                           token("DAY-OF-INTEGER"),
                           token("("),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("DAY-TO-YYYYDDD"),
                           token("("),
                           argument(),
                           optional(
                               argument()
                           ),
                           token(")")
                       ),
                       sequence(
                           token("DISPLAY-OF"),
                           token("("),
                           argument(),
                           optional(
                               argument()
                           ),
                           token(")")
                       ),
                       token("E"),
                       token("EXCEPTION-FILE"),
                       token("EXCEPTION-LOCATION"),
                       token("EXCEPTION-STATEMENT"),
                       token("EXCEPTION-STATUS"),
                       sequence(
                           token("EXP"),
                           token("("),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("EXP10"),
                           token("("),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("FACTORIAL"),
                           token("("),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("FRACTION-PART"),
                           token("("),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("INTEGER"),
                           token("("),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("INTEGER-OF-BOOLEAN"),
                           token("("),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("INTEGER-OF-DATE"),
                           token("("),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("INTEGER-OF-DAY"),
                           token("("),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("INTEGER-PART"),
                           token("("),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("LENGTH"),
                           token("("),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("LENGTH-AN"),
                           token("("),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("LOCALE-DATE"),
                           token("("),
                           argument(),
                           optional(
                               argument()
                           ),
                           token(")")
                       ),
                       sequence(
                           token("LOCALE-TIME"),
                           token("("),
                           argument(),
                           optional(
                               argument()
                           ),
                           token(")")
                       ),
                       sequence(
                           token("LOCALE-TIME-FROM-SECS"),
                           token("("),
                           argument(),
                           optional(
                               argument()
                           ),
                           token(")")
                       ),
                       sequence(
                           token("LOG"),
                           token("("),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("LOG10"),
                           token("("),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("LOWER-CASE"),
                           token("("),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("MAX"),
                           token("("),
                           plus(
                               argument()
                           ),
                           token(")")
                       ),
                       sequence(
                           token("MEAN"),
                           token("("),
                           plus(
                               argument()
                           ),
                           token(")")
                       ),
                       sequence(
                           token("MEDIAN"),
                           token("("),
                           plus(
                               argument()
                           ),
                           token(")")
                       ),
                       sequence(
                           token("MIDRANGE"),
                           token("("),
                           plus(
                               argument()
                           ),
                           token(")")
                       ),
                       sequence(
                           token("MIN"),
                           token("("),
                           plus(
                               argument()
                           ),
                           token(")")
                       ),
                       sequence(
                           token("MOD"),
                           token("("),
                           argument(),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("NATIONAL-OF"),
                           token("("),
                           argument(),
                           optional(
                               argument()
                           ),
                           token(")")
                       ),
                       sequence(
                           token("NUMVAL"),
                           token("("),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("NUMVAL-C"),
                           token("("),
                           argument(),
                           optional(
                               argument()
                           ),
                           token(")")
                       ),
                       sequence(
                           token("ORD"),
                           token("("),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("ORD-MAX"),
                           token("("),
                           plus(
                               argument()
                           ),
                           token(")")
                       ),
                       sequence(
                           token("ORD-MIN"),
                           token("("),
                           plus(
                               argument()
                           ),
                           token(")")
                       ),
                       token("PI"),
                       sequence(
                           token("PRESENT-VALUE"),
                           token("("),
                           argument(),
                           plus(
                               argument()
                           ),
                           token(")")
                       ),
                       sequence(
                           token("RANDOM"),
                           optional(
                               sequence(
                                   token("("),
                                   argument(),
                                   token(")")
                               )
                           )
                       ),
                       sequence(
                           token("RANGE"),
                           token("("),
                           plus(
                               argument()
                           ),
                           token(")")
                       ),
                       sequence(
                           token("REM"),
                           token("("),
                           argument(),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("REVERSE"),
                           token("("),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("SECONDS-FROM-FORMATTED-TIME"),
                           token("("),
                           argument(),
                           argument(),
                           token(")")
                       ),
                       token("SECONDS-PAST-MIDNIGHT"),
                       sequence(
                           token("SIGN"),
                           token("("),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("SIN"),
                           token("("),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("SQRT"),
                           token("("),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("STANDARD-DEVIATION"),
                           token("("),
                           plus(
                               argument()
                           ),
                           token(")")
                       ),
                       sequence(
                           token("STORED-CHAR-LENGTH"),
                           token("("),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("SUBSTITUTE"),
                           token("("),
                           plus(
                               argument()
                           ),
                           token(")")
                       ),
                       sequence(
                           token("SUBSTITUTE-CASE"),
                           token("("),
                           plus(
                               argument()
                           ),
                           token(")")
                       ),
                       sequence(
                           token("SUM"),
                           token("("),
                           plus(
                               argument()
                           ),
                           token(")")
                       ),
                       sequence(
                           token("TAN"),
                           token("("),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("TEST-DATE-YYYYMMDD"),
                           token("("),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("TEST-DAY-YYYYDDD"),
                           token("("),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("TRIM"),
                           token("("),
                           argument(),
                           optional(
                               choice(
                                   token("LEADING"),
                                   token("TRAILING")
                               )
                           ),
                           token(")")
                       ),
                       sequence(
                           token("UPPER-CASE"),
                           token("("),
                           argument(),
                           token(")")
                       ),
                       sequence(
                           token("VARIANCE"),
                           token("("),
                           plus(
                               argument()
                           ),
                           token(")")
                       ),
                       token("WHEN-COMPILED"),
                       sequence(
                           token("YEAR-TO-YYYY"),
                           token("("),
                           argument(),
                           optional(
                               argument()
                           ),
                           token(")")
                       ),
                       sequence(
                           functionName(),
                           optional(
                               sequence(
                                   token("("),
                                   plus(
                                       argument()
                                   ),
                                   token(")")
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

    private Parser identifierParser = null;

    public final Start identifier = Start.on(getNamespace(), "identifier");

    public Parser identifier() {
        if (identifierParser == null) {
           FutureParser future = scoped("identifier", true);
           identifierParser = future;
           future.setParser(
               choice(
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

    private Parser identifier_format1Parser = null;

    public final Start identifier_format1 = Start.on(getNamespace(), "identifier_format1");

    public Parser identifier_format1() {
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

    private Parser identifier_format2Parser = null;

    public final Start identifier_format2 = Start.on(getNamespace(), "identifier_format2");

    public Parser identifier_format2() {
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

    private Parser identifier_format6Parser = null;

    public final Start identifier_format6 = Start.on(getNamespace(), "identifier_format6");

    public Parser identifier_format6() {
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

    private Parser dataAddressIdentifierParser = null;

    public final Start dataAddressIdentifier = Start.on(getNamespace(), "dataAddressIdentifier");

    public Parser dataAddressIdentifier() {
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
    // argument
    // ........................................................

    private Parser argumentParser = null;

    public final Start argument = Start.on(getNamespace(), "argument");

    public Parser argument() {
        if (argumentParser == null) {
           FutureParser future = scoped("argument", true);
           argumentParser = future;
           future.setParser(
               choice(
                   arithmeticExpression(),
                   identifier(),
                   literal()
               )
           );
        }

        return argumentParser;
    }

    // ========================================================
    // qualifier
    // ........................................................

    private Parser qualifierParser = null;

    public final Start qualifier = Start.on(getNamespace(), "qualifier");

    public Parser qualifier() {
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

    private Parser subscriptParser = null;

    public final Start subscript = Start.on(getNamespace(), "subscript");

    public Parser subscript() {
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

    private Parser directSubscriptParser = null;

    public final Start directSubscript = Start.on(getNamespace(), "directSubscript");

    public Parser directSubscript() {
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

    private Parser relativeSubscriptParser = null;

    public final Start relativeSubscript = Start.on(getNamespace(), "relativeSubscript");

    public Parser relativeSubscript() {
        if (relativeSubscriptParser == null) {
           FutureParser future = scoped("relativeSubscript", true);
           relativeSubscriptParser = future;
           future.setParser(
               sequence(
                   identifier(),
                   choice(
                       token("+"),
                       token("-")
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

    private Parser referenceModifierParser = null;

    public final Start referenceModifier = Start.on(getNamespace(), "referenceModifier");

    public Parser referenceModifier() {
        if (referenceModifierParser == null) {
           FutureParser future = scoped("referenceModifier", true);
           referenceModifierParser = future;
           future.setParser(
               sequence(
                   token("("),
                   arithmeticExpression(),
                   token(":"),
                   optional(
                       arithmeticExpression()
                   ),
                   token(")")
               )
           );
        }

        return referenceModifierParser;
    }

    // ========================================================
    // arithmeticExpression
    // ........................................................

    private Parser arithmeticExpressionParser = null;

    public final Start arithmeticExpression = Start.on(getNamespace(), "arithmeticExpression");

    public Parser arithmeticExpression() {
        if (arithmeticExpressionParser == null) {
           FutureParser future = scoped("arithmeticExpression", true);
           arithmeticExpressionParser = future;
           future.setParser(
               sequence(
                   bitwiseOperand(),
                   star(
                       sequence(
                           bitwiseOperator(),
                           bitwiseOperand()
                       )
                   )
               )
           );
        }

        return arithmeticExpressionParser;
    }

    // ========================================================
    // bitwiseOperator
    // ........................................................

    private Parser bitwiseOperatorParser = null;

    public final Start bitwiseOperator = Start.on(getNamespace(), "bitwiseOperator");

    public Parser bitwiseOperator() {
        if (bitwiseOperatorParser == null) {
           FutureParser future = scoped("bitwiseOperator", true);
           bitwiseOperatorParser = future;
           future.setParser(
               choice(
                   token("B-AND"),
                   token("B-OR"),
                   token("B-XOR"),
                   token("B-EXOR")
               )
           );
        }

        return bitwiseOperatorParser;
    }

    // ========================================================
    // bitwiseOperand
    // ........................................................

    private Parser bitwiseOperandParser = null;

    public final Start bitwiseOperand = Start.on(getNamespace(), "bitwiseOperand");

    public Parser bitwiseOperand() {
        if (bitwiseOperandParser == null) {
           FutureParser future = scoped("bitwiseOperand", true);
           bitwiseOperandParser = future;
           future.setParser(
               sequence(
                   summand(),
                   star(
                       sequence(
                           signDef(),
                           summand()
                       )
                   )
               )
           );
        }

        return bitwiseOperandParser;
    }

    // ========================================================
    // signDef
    // ........................................................

    private Parser signDefParser = null;

    public final Start signDef = Start.on(getNamespace(), "signDef");

    public Parser signDef() {
        if (signDefParser == null) {
           FutureParser future = scoped("signDef", true);
           signDefParser = future;
           future.setParser(
               choice(
                   token("+"),
                   token("-")
               )
           );
        }

        return signDefParser;
    }

    // ========================================================
    // summand
    // ........................................................

    private Parser summandParser = null;

    public final Start summand = Start.on(getNamespace(), "summand");

    public Parser summand() {
        if (summandParser == null) {
           FutureParser future = scoped("summand", true);
           summandParser = future;
           future.setParser(
               sequence(
                   factor(),
                   star(
                       sequence(
                           choice(
                               token("*"),
                               token("/")
                           ),
                           factor()
                       )
                   )
               )
           );
        }

        return summandParser;
    }

    // ========================================================
    // unaryOperator
    // ........................................................

    private Parser unaryOperatorParser = null;

    public final Start unaryOperator = Start.on(getNamespace(), "unaryOperator");

    public Parser unaryOperator() {
        if (unaryOperatorParser == null) {
           FutureParser future = scoped("unaryOperator", true);
           unaryOperatorParser = future;
           future.setParser(
               choice(
                   token("+"),
                   token("-"),
                   token("B-NOT")
               )
           );
        }

        return unaryOperatorParser;
    }

    // ========================================================
    // factor
    // ........................................................

    private Parser factorParser = null;

    public final Start factor = Start.on(getNamespace(), "factor");

    public Parser factor() {
        if (factorParser == null) {
           FutureParser future = scoped("factor", true);
           factorParser = future;
           future.setParser(
               sequence(
                   optional(
                       unaryOperator()
                   ),
                   atomicExpression(),
                   star(
                       sequence(
                           token("**"),
                           optional(
                               unaryOperator()
                           ),
                           atomicExpression()
                       )
                   )
               )
           );
        }

        return factorParser;
    }

    // ========================================================
    // atomicExpression
    // ........................................................

    private Parser atomicExpressionParser = null;

    public final Start atomicExpression = Start.on(getNamespace(), "atomicExpression");

    public Parser atomicExpression() {
        if (atomicExpressionParser == null) {
           FutureParser future = scoped("atomicExpression", true);
           atomicExpressionParser = future;
           future.setParser(
               choice(
                   zero(),
                   identifier(),
                   numeric(),
                   sequence(
                       token("("),
                       arithmeticExpression(),
                       token(")")
                   )
               )
           );
        }

        return atomicExpressionParser;
    }

    // ========================================================
    // condition
    // ........................................................

    private Parser conditionParser = null;

    public final Start condition = Start.on(getNamespace(), "condition");

    public Parser condition() {
        if (conditionParser == null) {
           FutureParser future = scoped("condition", true);
           conditionParser = future;
           future.setParser(
               sequence(
                   optional(
                       token("NOT")
                   ),
                   choice(
                       conditionStart(),
                       sequence(
                           token("("),
                           condition(),
                           token(")")
                       )
                   ),
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

    private Parser conditionStartParser = null;

    public final Start conditionStart = Start.on(getNamespace(), "conditionStart");

    public Parser conditionStart() {
        if (conditionStartParser == null) {
           FutureParser future = scoped("conditionStart", true);
           conditionStartParser = future;
           future.setParser(
               choice(
                   token("TRUE"),
                   token("FALSE"),
                   operand()
               )
           );
        }

        return conditionStartParser;
    }

    // ========================================================
    // furtherCondition
    // ........................................................

    private Parser furtherConditionParser = null;

    public final Start furtherCondition = Start.on(getNamespace(), "furtherCondition");

    public Parser furtherCondition() {
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
                       operand()
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
                       token("("),
                       condition(),
                       token(")")
                   )
               )
           );
        }

        return furtherConditionParser;
    }

    // ========================================================
    // classType
    // ........................................................

    private Parser classTypeParser = null;

    public final Start classType = Start.on(getNamespace(), "classType");

    public Parser classType() {
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

    private Parser signTypeParser = null;

    public final Start signType = Start.on(getNamespace(), "signType");

    public Parser signType() {
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

    private Parser relopParser = null;

    public final Start relop = Start.on(getNamespace(), "relop");

    public Parser relop() {
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

    private Parser greaterThanOpParser = null;

    public final Start greaterThanOp = Start.on(getNamespace(), "greaterThanOp");

    public Parser greaterThanOp() {
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
                   token(">")
               )
           );
        }

        return greaterThanOpParser;
    }

    // ========================================================
    // lessThanOp
    // ........................................................

    private Parser lessThanOpParser = null;

    public final Start lessThanOp = Start.on(getNamespace(), "lessThanOp");

    public Parser lessThanOp() {
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
                   token("<")
               )
           );
        }

        return lessThanOpParser;
    }

    // ========================================================
    // equalToOp
    // ........................................................

    private Parser equalToOpParser = null;

    public final Start equalToOp = Start.on(getNamespace(), "equalToOp");

    public Parser equalToOp() {
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
                   token("=")
               )
           );
        }

        return equalToOpParser;
    }

    // ========================================================
    // exceedsOp
    // ........................................................

    private Parser exceedsOpParser = null;

    public final Start exceedsOp = Start.on(getNamespace(), "exceedsOp");

    public Parser exceedsOp() {
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

    private Parser equalsOpParser = null;

    public final Start equalsOp = Start.on(getNamespace(), "equalsOp");

    public Parser equalsOp() {
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

    private Parser unequalToOpParser = null;

    public final Start unequalToOp = Start.on(getNamespace(), "unequalToOp");

    public Parser unequalToOp() {
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
                   token("<>")
               )
           );
        }

        return unequalToOpParser;
    }

    // ========================================================
    // greaterOrEqualOp
    // ........................................................

    private Parser greaterOrEqualOpParser = null;

    public final Start greaterOrEqualOp = Start.on(getNamespace(), "greaterOrEqualOp");

    public Parser greaterOrEqualOp() {
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
                   token(">=")
               )
           );
        }

        return greaterOrEqualOpParser;
    }

    // ========================================================
    // lessOrEqualOp
    // ........................................................

    private Parser lessOrEqualOpParser = null;

    public final Start lessOrEqualOp = Start.on(getNamespace(), "lessOrEqualOp");

    public Parser lessOrEqualOp() {
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
                   token("<=")
               )
           );
        }

        return lessOrEqualOpParser;
    }

    // ========================================================
    // programName
    // ........................................................

    private Parser programNameParser = null;

    public final Start programName = Start.on(getNamespace(), "programName");

    public Parser programName() {
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

    private Parser dataNameParser = null;

    public final Start dataName = Start.on(getNamespace(), "dataName");

    public Parser dataName() {
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

    private Parser qualifiedDataNameParser = null;

    public final Start qualifiedDataName = Start.on(getNamespace(), "qualifiedDataName");

    public Parser qualifiedDataName() {
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
                           token("("),
                           plus(
                               subscript()
                           ),
                           token(")")
                       )
                   )
               )
           );
        }

        return qualifiedDataNameParser;
    }

    // ========================================================
    // dataDescName
    // ........................................................

    private Parser dataDescNameParser = null;

    public final Start dataDescName = Start.on(getNamespace(), "dataDescName");

    public Parser dataDescName() {
        if (dataDescNameParser == null) {
           FutureParser future = scoped("dataDescName", true);
           dataDescNameParser = future;
           future.setParser(
               choice(
                   token("FILLER"),
                   token("CURSOR"),
                   dataName()
               )
           );
        }

        return dataDescNameParser;
    }

    // ========================================================
    // screenName
    // ........................................................

    private Parser screenNameParser = null;

    public final Start screenName = Start.on(getNamespace(), "screenName");

    public Parser screenName() {
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

    private Parser sectionNameParser = null;

    public final Start sectionName = Start.on(getNamespace(), "sectionName");

    public Parser sectionName() {
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

    private Parser paragraphNameParser = null;

    public final Start paragraphName = Start.on(getNamespace(), "paragraphName");

    public Parser paragraphName() {
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

    private Parser procedureNameParser = null;

    public final Start procedureName = Start.on(getNamespace(), "procedureName");

    public Parser procedureName() {
        if (procedureNameParser == null) {
           FutureParser future = scoped("procedureName", true);
           procedureNameParser = future;
           future.setParser(
               sequence(
                   name(),
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

    private Parser nameParser = null;

    public final Start name = Start.on(getNamespace(), "name");

    public Parser name() {
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

    private Parser segmentNumberParser = null;

    public final Start segmentNumber = Start.on(getNamespace(), "segmentNumber");

    public Parser segmentNumber() {
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

    private Parser operandParser = null;

    public final Start operand = Start.on(getNamespace(), "operand");

    public Parser operand() {
        if (operandParser == null) {
           FutureParser future = scoped("operand", true);
           operandParser = future;
           future.setParser(
               choice(
                   arithmeticExpression(),
                   identifier(),
                   literal(),
                   indexName()
               )
           );
        }

        return operandParser;
    }

    // ========================================================
    // threadPointer
    // ........................................................

    private Parser threadPointerParser = null;

    public final Start threadPointer = Start.on(getNamespace(), "threadPointer");

    public Parser threadPointer() {
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

    private Parser eventPointerParser = null;

    public final Start eventPointer = Start.on(getNamespace(), "eventPointer");

    public Parser eventPointer() {
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

    private Parser conditionNameParser = null;

    public final Start conditionName = Start.on(getNamespace(), "conditionName");

    public Parser conditionName() {
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

    private Parser indexNameParser = null;

    public final Start indexName = Start.on(getNamespace(), "indexName");

    public Parser indexName() {
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

    private Parser classNameParser = null;

    public final Start className = Start.on(getNamespace(), "className");

    public Parser className() {
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

    private Parser typeSpecifierParser = null;

    public final Start typeSpecifier = Start.on(getNamespace(), "typeSpecifier");

    public Parser typeSpecifier() {
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

    private Parser parameterNameParser = null;

    public final Start parameterName = Start.on(getNamespace(), "parameterName");

    public Parser parameterName() {
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

    private Parser interfaceNameParser = null;

    public final Start interfaceName = Start.on(getNamespace(), "interfaceName");

    public Parser interfaceName() {
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

    private Parser methodNameParser = null;

    public final Start methodName = Start.on(getNamespace(), "methodName");

    public Parser methodName() {
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

    private Parser propertyNameParser = null;

    public final Start propertyName = Start.on(getNamespace(), "propertyName");

    public Parser propertyName() {
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

    private Parser propertyValueParser = null;

    public final Start propertyValue = Start.on(getNamespace(), "propertyValue");

    public Parser propertyValue() {
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

    private Parser delegateNameParser = null;

    public final Start delegateName = Start.on(getNamespace(), "delegateName");

    public Parser delegateName() {
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

    private Parser iteratorNameParser = null;

    public final Start iteratorName = Start.on(getNamespace(), "iteratorName");

    public Parser iteratorName() {
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

    private Parser enumNameParser = null;

    public final Start enumName = Start.on(getNamespace(), "enumName");

    public Parser enumName() {
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

    private Parser valuetypeNameParser = null;

    public final Start valuetypeName = Start.on(getNamespace(), "valuetypeName");

    public Parser valuetypeName() {
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

    private Parser typeNameParser = null;

    public final Start typeName = Start.on(getNamespace(), "typeName");

    public Parser typeName() {
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

    private Parser attributeNameParser = null;

    public final Start attributeName = Start.on(getNamespace(), "attributeName");

    public Parser attributeName() {
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

    private Parser typedefNameParser = null;

    public final Start typedefName = Start.on(getNamespace(), "typedefName");

    public Parser typedefName() {
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

    private Parser fileNameParser = null;

    public final Start fileName = Start.on(getNamespace(), "fileName");

    public Parser fileName() {
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

    private Parser computerNameParser = null;

    public final Start computerName = Start.on(getNamespace(), "computerName");

    public Parser computerName() {
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

    private Parser functionNameParser = null;

    public final Start functionName = Start.on(getNamespace(), "functionName");

    public Parser functionName() {
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

    private Parser recordNameParser = null;

    public final Start recordName = Start.on(getNamespace(), "recordName");

    public Parser recordName() {
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

    private Parser mnemonicNameParser = null;

    public final Start mnemonicName = Start.on(getNamespace(), "mnemonicName");

    public Parser mnemonicName() {
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

    private Parser environmentNameParser = null;

    public final Start environmentName = Start.on(getNamespace(), "environmentName");

    public Parser environmentName() {
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

    private Parser alphabetNameParser = null;

    public final Start alphabetName = Start.on(getNamespace(), "alphabetName");

    public Parser alphabetName() {
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

    private Parser cdNameParser = null;

    public final Start cdName = Start.on(getNamespace(), "cdName");

    public Parser cdName() {
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

    private Parser reportNameParser = null;

    public final Start reportName = Start.on(getNamespace(), "reportName");

    public Parser reportName() {
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

    private Parser literalParser = null;

    public final Start literal = Start.on(getNamespace(), "literal");

    public Parser literal() {
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

    private Parser literalValueParser = null;

    public final Start literalValue = Start.on(getNamespace(), "literalValue");

    public Parser literalValue() {
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

    private Parser concatenatedLiteralParser = null;

    public final Start concatenatedLiteral = Start.on(getNamespace(), "concatenatedLiteral");

    public Parser concatenatedLiteral() {
        if (concatenatedLiteralParser == null) {
           FutureParser future = scoped("concatenatedLiteral", true);
           concatenatedLiteralParser = future;
           future.setParser(
               sequence(
                   token("&"),
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

    private Parser valueParser = null;

    public final Start value = Start.on(getNamespace(), "value");

    public Parser value() {
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

    private Parser figurativeConstantParser = null;

    public final Start figurativeConstant = Start.on(getNamespace(), "figurativeConstant");

    public Parser figurativeConstant() {
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

    private Parser numericLiteralParser = null;

    public final Start numericLiteral = Start.on(getNamespace(), "numericLiteral");

    public Parser numericLiteral() {
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

    private Parser numericParser = null;

    public final Start numeric = Start.on(getNamespace(), "numeric");

    public Parser numeric() {
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

    private Parser integerParser = null;

    public final Start integer = Start.on(getNamespace(), "integer");

    public Parser integer() {
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

    private Parser constantParser = null;

    public final Start constant = Start.on(getNamespace(), "constant");

    public Parser constant() {
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

    private Parser integerConstantParser = null;

    public final Start integerConstant = Start.on(getNamespace(), "integerConstant");

    public Parser integerConstant() {
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

    private Parser alphanumericParser = null;

    public final Start alphanumeric = Start.on(getNamespace(), "alphanumeric");

    public Parser alphanumeric() {
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

    private Parser alphanumericConstantParser = null;

    public final Start alphanumericConstant = Start.on(getNamespace(), "alphanumericConstant");

    public Parser alphanumericConstant() {
        if (alphanumericConstantParser == null) {
           FutureParser future = scoped("alphanumericConstant", true);
           alphanumericConstantParser = future;
           future.setParser(
               cobolWord()
           );
        }

        return alphanumericConstantParser;
    }

    // ========================================================
    // decimal
    // ........................................................

    private Parser decimalParser = null;

    public final Start decimal = Start.on(getNamespace(), "decimal");

    public Parser decimal() {
        if (decimalParser == null) {
           FutureParser future = scoped("decimal", true);
           decimalParser = future;
           future.setParser(
               choice(
                   sequence(
                       intgr(),
                       opt(NOSKIP,
                           sequence(
                               choice(
                                   token(","),
                                   token(".")
                               ),
                               uintgr()
                           )
                       )
                   ),
                   sequence(
                       token("."),
                       opt(NOSKIP,
                           uintgr()
                       )
                   )
               )
           );
        }

        return decimalParser;
    }

    // ========================================================
    // intgr
    // ........................................................

    private Parser intgrParser = null;

    public final Start intgr = Start.on(getNamespace(), "intgr");

    public Parser intgr() {
        if (intgrParser == null) {
           FutureParser future = scoped("intgr", true);
           intgrParser = future;
           future.setParser(
               sequence(
                   tagged(INTEGER_LITERAL),
                   any()
               )
           );
        }

        return intgrParser;
    }

    // ========================================================
    // uintgr
    // ........................................................

    private Parser uintgrParser = null;

    public final Start uintgr = Start.on(getNamespace(), "uintgr");

    public Parser uintgr() {
        if (uintgrParser == null) {
           FutureParser future = scoped("uintgr", true);
           uintgrParser = future;
           future.setParser(
               sequence(
                   tagged(UNSIGNED),
                   tagged(INTEGER_LITERAL),
                   any()
               )
           );
        }

        return uintgrParser;
    }

}