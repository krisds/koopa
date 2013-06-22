package koopa.grammars.cobol;

import java.util.Set;
import java.util.HashSet;

import koopa.parsers.Block;
import koopa.parsers.KoopaGrammar;
import koopa.parsers.Parser;
import koopa.parsers.FutureParser;

import koopa.tokenizers.cobol.tags.TokenizerTag;
import koopa.tokenizers.cobol.tags.SyntacticTag;
import koopa.tokenizers.cobol.tags.ContinuationsTag;
import koopa.tokens.CompositeToken;
import koopa.tokens.Token;
import koopa.tokenstreams.TokenStream;

public class CobolGrammar extends KoopaGrammar {
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

    public Parser compilationGroup() {
        if (compilationGroupParser == null) {
           FutureParser future = scoped("compilationGroup");
           compilationGroupParser = future;
           future.setParser(
               star(
                   compilationUnit()
               )
           );
        }

        return compilationGroupParser;
    }

    // ========================================================
    // copybook
    // ........................................................

    private Parser copybookParser = null;

    public Parser copybook() {
        if (copybookParser == null) {
           FutureParser future = scoped("copybook");
           copybookParser = future;
           future.setParser(
               choice(
                   copybookHoldingData(),
                   copybookHoldingBehaviour()
               )
           );
        }

        return copybookParser;
    }

    // ========================================================
    // copybookHoldingData
    // ........................................................

    private Parser copybookHoldingDataParser = null;

    public Parser copybookHoldingData() {
        if (copybookHoldingDataParser == null) {
           FutureParser future = scoped("copybookHoldingData");
           copybookHoldingDataParser = future;
           future.setParser(
               plus(
                   choice(
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

    public Parser copybookHoldingBehaviour() {
        if (copybookHoldingBehaviourParser == null) {
           FutureParser future = scoped("copybookHoldingBehaviour");
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
                   )
               )
           );
        }

        return copybookHoldingBehaviourParser;
    }

    // ========================================================
    // compilationUnit
    // ........................................................

    private Parser compilationUnitParser = null;

    public Parser compilationUnit() {
        if (compilationUnitParser == null) {
           FutureParser future = scoped("compilationUnit");
           compilationUnitParser = future;
           future.setParser(
               sequence(
                   identificationDivision(),
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
                               compilationUnit()
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

        return compilationUnitParser;
    }

    // ========================================================
    // identificationDivision
    // ........................................................

    private Parser identificationDivisionParser = null;

    public Parser identificationDivision() {
        if (identificationDivisionParser == null) {
           FutureParser future = scoped("identificationDivision");
           identificationDivisionParser = future;
           future.setParser(
               sequence(
                   choice(
                       token("ID"),
                       token("IDENTIFICATION")
                   ),
                   token("DIVISION"),
                   token("."),
                   token("PROGRAM-ID"),
                   optional(
                       token(".")
                   ),
                   programName(),
                   optional(
                       sequence(
                           optional(
                               token("IS")
                           ),
                           choice(
                               sequence(
                                   token("INITIAL"),
                                   optional(
                                       token("COMMON")
                                   )
                               ),
                               sequence(
                                   token("COMMON"),
                                   optional(
                                       token("INITIAL")
                                   )
                               )
                           ),
                           optional(
                               token("PROGRAM")
                           )
                       )
                   ),
                   optional(
                       token(".")
                   ),
                   optional(
                       skipto(
                           divisionStart()
                       )
                   )
               )
           );
        }

        return identificationDivisionParser;
    }

    // ========================================================
    // environmentDivision
    // ........................................................

    private Parser environmentDivisionParser = null;

    public Parser environmentDivision() {
        if (environmentDivisionParser == null) {
           FutureParser future = scoped("environmentDivision");
           environmentDivisionParser = future;
           future.setParser(
               sequence(
                   token("ENVIRONMENT"),
                   token("DIVISION"),
                   token("."),
                   optional(
                       configurationSection()
                   ),
                   optional(
                       ioSection()
                   ),
                   optional(
                       skipto(
                           divisionStart()
                       )
                   )
               )
           );
        }

        return environmentDivisionParser;
    }

    // ========================================================
    // configurationSection
    // ........................................................

    private Parser configurationSectionParser = null;

    public Parser configurationSection() {
        if (configurationSectionParser == null) {
           FutureParser future = scoped("configurationSection");
           configurationSectionParser = future;
           future.setParser(
               sequence(
                   token("CONFIGURATION"),
                   token("SECTION"),
                   token("."),
                   permuted(
                       sourceComputerParagraph(),
                       objectComputerParagraph(),
                       specialNamesParagraph()
                   ),
                   optional(
                       skipto(
                           choice(
                               environmentSectionStart(),
                               divisionStart()
                           )
                       )
                   )
               )
           );
        }

        return configurationSectionParser;
    }

    // ========================================================
    // sourceComputerParagraph
    // ........................................................

    private Parser sourceComputerParagraphParser = null;

    public Parser sourceComputerParagraph() {
        if (sourceComputerParagraphParser == null) {
           FutureParser future = scoped("sourceComputerParagraph");
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
                               confParagraphStart(),
                               environmentSectionStart(),
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

    public Parser withDebuggingMode() {
        if (withDebuggingModeParser == null) {
           FutureParser future = scoped("withDebuggingMode");
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

    public Parser objectComputerParagraph() {
        if (objectComputerParagraphParser == null) {
           FutureParser future = scoped("objectComputerParagraph");
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
                               confParagraphStart(),
                               environmentSectionStart(),
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
    // genericStringDef
    // ........................................................

    private Parser genericStringDefParser = null;

    public Parser genericStringDef() {
        if (genericStringDefParser == null) {
           FutureParser future = scoped("genericStringDef");
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

    public Parser specialNamesParagraph() {
        if (specialNamesParagraphParser == null) {
           FutureParser future = scoped("specialNamesParagraph");
           specialNamesParagraphParser = future;
           future.setParser(
               sequence(
                   token("SPECIAL-NAMES"),
                   token("."),
                   star(
                       choice(
                           copyStatement(),
                           specialNameStatement()
                       )
                   ),
                   optional(
                       token(".")
                   ),
                   optional(
                       skipto(
                           choice(
                               confParagraphStart(),
                               environmentSectionStart(),
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

    public Parser specialNameStatement() {
        if (specialNameStatementParser == null) {
           FutureParser future = scoped("specialNameStatement");
           specialNameStatementParser = future;
           future.setParser(
               choice(
                   decimalIsComma(),
                   currencySignIs(),
                   consoleIsCRT(),
                   cursorIs(),
                   crtStatusIs(),
                   numericSignIs(),
                   classIs(),
                   symbolicChars(),
                   alphabetIs(),
                   mnemonicClause()
               )
           );
        }

        return specialNameStatementParser;
    }

    // ========================================================
    // decimalIsComma
    // ........................................................

    private Parser decimalIsCommaParser = null;

    public Parser decimalIsComma() {
        if (decimalIsCommaParser == null) {
           FutureParser future = scoped("decimalIsComma");
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
    // currencySignIs
    // ........................................................

    private Parser currencySignIsParser = null;

    public Parser currencySignIs() {
        if (currencySignIsParser == null) {
           FutureParser future = scoped("currencySignIs");
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
    // consoleIsCRT
    // ........................................................

    private Parser consoleIsCRTParser = null;

    public Parser consoleIsCRT() {
        if (consoleIsCRTParser == null) {
           FutureParser future = scoped("consoleIsCRT");
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
    // cursorIs
    // ........................................................

    private Parser cursorIsParser = null;

    public Parser cursorIs() {
        if (cursorIsParser == null) {
           FutureParser future = scoped("cursorIs");
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

    public Parser crtStatusIs() {
        if (crtStatusIsParser == null) {
           FutureParser future = scoped("crtStatusIs");
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
    // numericSignIs
    // ........................................................

    private Parser numericSignIsParser = null;

    public Parser numericSignIs() {
        if (numericSignIsParser == null) {
           FutureParser future = scoped("numericSignIs");
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
    // classIs
    // ........................................................

    private Parser classIsParser = null;

    public Parser classIs() {
        if (classIsParser == null) {
           FutureParser future = scoped("classIs");
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
    // literalRange
    // ........................................................

    private Parser literalRangeParser = null;

    public Parser literalRange() {
        if (literalRangeParser == null) {
           FutureParser future = scoped("literalRange");
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

    public Parser symbolicChars() {
        if (symbolicCharsParser == null) {
           FutureParser future = scoped("symbolicChars");
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
    // alphabetIs
    // ........................................................

    private Parser alphabetIsParser = null;

    public Parser alphabetIs() {
        if (alphabetIsParser == null) {
           FutureParser future = scoped("alphabetIs");
           alphabetIsParser = future;
           future.setParser(
               sequence(
                   optional(
                       token("ALPHABET")
                   ),
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

    public Parser alphabetType() {
        if (alphabetTypeParser == null) {
           FutureParser future = scoped("alphabetType");
           alphabetTypeParser = future;
           future.setParser(
               choice(
                   standard1AlphabetType(),
                   standard2AlphabetType(),
                   nativeAlphabetType(),
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

    public Parser standard1AlphabetType() {
        if (standard1AlphabetTypeParser == null) {
           FutureParser future = scoped("standard1AlphabetType");
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

    public Parser standard2AlphabetType() {
        if (standard2AlphabetTypeParser == null) {
           FutureParser future = scoped("standard2AlphabetType");
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

    public Parser nativeAlphabetType() {
        if (nativeAlphabetTypeParser == null) {
           FutureParser future = scoped("nativeAlphabetType");
           nativeAlphabetTypeParser = future;
           future.setParser(
               token("NATIVE")
           );
        }

        return nativeAlphabetTypeParser;
    }

    // ========================================================
    // explicitAlphabetType
    // ........................................................

    private Parser explicitAlphabetTypeParser = null;

    public Parser explicitAlphabetType() {
        if (explicitAlphabetTypeParser == null) {
           FutureParser future = scoped("explicitAlphabetType");
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

    public Parser codeNameAlphabetType() {
        if (codeNameAlphabetTypeParser == null) {
           FutureParser future = scoped("codeNameAlphabetType");
           codeNameAlphabetTypeParser = future;
           future.setParser(
               cobolWord()
           );
        }

        return codeNameAlphabetTypeParser;
    }

    // ========================================================
    // mnemonicClause
    // ........................................................

    private Parser mnemonicClauseParser = null;

    public Parser mnemonicClause() {
        if (mnemonicClauseParser == null) {
           FutureParser future = scoped("mnemonicClause");
           mnemonicClauseParser = future;
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

        return mnemonicClauseParser;
    }

    // ========================================================
    // confParagraphStart
    // ........................................................

    private Parser confParagraphStartParser = null;

    public Parser confParagraphStart() {
        if (confParagraphStartParser == null) {
           FutureParser future = scoped("confParagraphStart");
           confParagraphStartParser = future;
           future.setParser(
               sequence(
                   choice(
                       token("SOURCE-COMPUTER"),
                       token("OBJECT-COMPUTER"),
                       token("SPECIAL-NAMES")
                   ),
                   token(".")
               )
           );
        }

        return confParagraphStartParser;
    }

    // ========================================================
    // ioSection
    // ........................................................

    private Parser ioSectionParser = null;

    public Parser ioSection() {
        if (ioSectionParser == null) {
           FutureParser future = scoped("ioSection");
           ioSectionParser = future;
           future.setParser(
               sequence(
                   token("INPUT-OUTPUT"),
                   token("SECTION"),
                   token("."),
                   fileControlParagraph(),
                   optional(
                       ioControlParagraph()
                   ),
                   optional(
                       skipto(
                           divisionStart()
                       )
                   )
               )
           );
        }

        return ioSectionParser;
    }

    // ========================================================
    // fileControlParagraph
    // ........................................................

    private Parser fileControlParagraphParser = null;

    public Parser fileControlParagraph() {
        if (fileControlParagraphParser == null) {
           FutureParser future = scoped("fileControlParagraph");
           fileControlParagraphParser = future;
           future.setParser(
               sequence(
                   token("FILE-CONTROL"),
                   token("."),
                   star(
                       choice(
                           selectStatement(),
                           copyStatement()
                       )
                   )
               )
           );
        }

        return fileControlParagraphParser;
    }

    // ========================================================
    // selectStatement
    // ........................................................

    private Parser selectStatementParser = null;

    public Parser selectStatement() {
        if (selectStatementParser == null) {
           FutureParser future = scoped("selectStatement");
           selectStatementParser = future;
           future.setParser(
               sequence(
                   selectClause(),
                   assignClause(),
                   permuted(
                       organizationIsSequentialClause(),
                       fileStatusClause()
                   ),
                   optional(
                       skipto(
                           token(".")
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

    public Parser selectClause() {
        if (selectClauseParser == null) {
           FutureParser future = scoped("selectClause");
           selectClauseParser = future;
           future.setParser(
               sequence(
                   token("SELECT"),
                   optional(
                       token("OPTIONAL")
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

    public Parser assignClause() {
        if (assignClauseParser == null) {
           FutureParser future = scoped("assignClause");
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

    public Parser assignUsingClause() {
        if (assignUsingClauseParser == null) {
           FutureParser future = scoped("assignUsingClause");
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

    public Parser assignToClause() {
        if (assignToClauseParser == null) {
           FutureParser future = scoped("assignToClause");
           assignToClauseParser = future;
           future.setParser(
               sequence(
                   optional(
                       token("TO")
                   ),
                   assignmentName()
               )
           );
        }

        return assignToClauseParser;
    }

    // ========================================================
    // organizationIsSequentialClause
    // ........................................................

    private Parser organizationIsSequentialClauseParser = null;

    public Parser organizationIsSequentialClause() {
        if (organizationIsSequentialClauseParser == null) {
           FutureParser future = scoped("organizationIsSequentialClause");
           organizationIsSequentialClauseParser = future;
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
                   token("SEQUENTIAL")
               )
           );
        }

        return organizationIsSequentialClauseParser;
    }

    // ========================================================
    // fileStatusClause
    // ........................................................

    private Parser fileStatusClauseParser = null;

    public Parser fileStatusClause() {
        if (fileStatusClauseParser == null) {
           FutureParser future = scoped("fileStatusClause");
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
    // ioControlParagraph
    // ........................................................

    private Parser ioControlParagraphParser = null;

    public Parser ioControlParagraph() {
        if (ioControlParagraphParser == null) {
           FutureParser future = scoped("ioControlParagraph");
           ioControlParagraphParser = future;
           future.setParser(
               sequence(
                   token("I-O-CONTROL"),
                   token("."),
                   optional(
                       skipto(
                           divisionStart()
                       )
                   )
               )
           );
        }

        return ioControlParagraphParser;
    }

    // ========================================================
    // environmentSectionStart
    // ........................................................

    private Parser environmentSectionStartParser = null;

    public Parser environmentSectionStart() {
        if (environmentSectionStartParser == null) {
           FutureParser future = scoped("environmentSectionStart");
           environmentSectionStartParser = future;
           future.setParser(
               sequence(
                   choice(
                       token("CONFIGURATION"),
                       token("INPUT-OUTPUT")
                   ),
                   token("SECTION"),
                   token(".")
               )
           );
        }

        return environmentSectionStartParser;
    }

    // ========================================================
    // dataDivision
    // ........................................................

    private Parser dataDivisionParser = null;

    public Parser dataDivision() {
        if (dataDivisionParser == null) {
           FutureParser future = scoped("dataDivision");
           dataDivisionParser = future;
           future.setParser(
               sequence(
                   token("DATA"),
                   token("DIVISION"),
                   token("."),
                   optional(
                       fileSection()
                   ),
                   optional(
                       workingStorageSection()
                   ),
                   optional(
                       localStorageSection()
                   ),
                   optional(
                       linkageSection()
                   ),
                   optional(
                       communicationSection()
                   ),
                   optional(
                       reportSection()
                   )
               )
           );
        }

        return dataDivisionParser;
    }

    // ========================================================
    // fileSection
    // ........................................................

    private Parser fileSectionParser = null;

    public Parser fileSection() {
        if (fileSectionParser == null) {
           FutureParser future = scoped("fileSection");
           fileSectionParser = future;
           future.setParser(
               sequence(
                   token("FILE"),
                   token("SECTION"),
                   token("."),
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
                               dataSectionStart(),
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
    // recordDescriptionEntry
    // ........................................................

    private Parser recordDescriptionEntryParser = null;

    public Parser recordDescriptionEntry() {
        if (recordDescriptionEntryParser == null) {
           FutureParser future = scoped("recordDescriptionEntry");
           recordDescriptionEntryParser = future;
           future.setParser(
               choice(
                   dataDescriptionEntry(),
                   copyStatement()
               )
           );
        }

        return recordDescriptionEntryParser;
    }

    // ========================================================
    // localStorageSection
    // ........................................................

    private Parser localStorageSectionParser = null;

    public Parser localStorageSection() {
        if (localStorageSectionParser == null) {
           FutureParser future = scoped("localStorageSection");
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
    // workingStorageSection
    // ........................................................

    private Parser workingStorageSectionParser = null;

    public Parser workingStorageSection() {
        if (workingStorageSectionParser == null) {
           FutureParser future = scoped("workingStorageSection");
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
    // linkageSection
    // ........................................................

    private Parser linkageSectionParser = null;

    public Parser linkageSection() {
        if (linkageSectionParser == null) {
           FutureParser future = scoped("linkageSection");
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

    public Parser communicationSection() {
        if (communicationSectionParser == null) {
           FutureParser future = scoped("communicationSection");
           communicationSectionParser = future;
           future.setParser(
               sequence(
                   token("COMMUNICATION"),
                   token("SECTION"),
                   token("."),
                   optional(
                       skipto(
                           choice(
                               dataSectionStart(),
                               divisionStart()
                           )
                       )
                   )
               )
           );
        }

        return communicationSectionParser;
    }

    // ========================================================
    // reportSection
    // ........................................................

    private Parser reportSectionParser = null;

    public Parser reportSection() {
        if (reportSectionParser == null) {
           FutureParser future = scoped("reportSection");
           reportSectionParser = future;
           future.setParser(
               sequence(
                   token("REPORT"),
                   token("SECTION"),
                   token("."),
                   optional(
                       skipto(
                           choice(
                               dataSectionStart(),
                               divisionStart()
                           )
                       )
                   )
               )
           );
        }

        return reportSectionParser;
    }

    // ========================================================
    // fileDescriptionEntry
    // ........................................................

    private Parser fileDescriptionEntryParser = null;

    public Parser fileDescriptionEntry() {
        if (fileDescriptionEntryParser == null) {
           FutureParser future = scoped("fileDescriptionEntry");
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

    public Parser fdFileDescriptionEntry() {
        if (fdFileDescriptionEntryParser == null) {
           FutureParser future = scoped("fdFileDescriptionEntry");
           fdFileDescriptionEntryParser = future;
           future.setParser(
               sequence(
                   token("FD"),
                   fileName(),
                   permuted(
                       blockContains(),
                       codeSet(),
                       dataRecords(),
                       external(),
                       global(),
                       labelRecords(),
                       linage(),
                       record(),
                       recordingMode(),
                       valueOf(),
                       report()
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

    public Parser sdFileDescriptionEntry() {
        if (sdFileDescriptionEntryParser == null) {
           FutureParser future = scoped("sdFileDescriptionEntry");
           sdFileDescriptionEntryParser = future;
           future.setParser(
               sequence(
                   token("SD"),
                   fileName(),
                   permuted(
                       blockContains(),
                       dataRecords(),
                       labelRecords(),
                       record(),
                       recordingMode()
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
    // blockContains
    // ........................................................

    private Parser blockContainsParser = null;

    public Parser blockContains() {
        if (blockContainsParser == null) {
           FutureParser future = scoped("blockContains");
           blockContainsParser = future;
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

        return blockContainsParser;
    }

    // ========================================================
    // codeSet
    // ........................................................

    private Parser codeSetParser = null;

    public Parser codeSet() {
        if (codeSetParser == null) {
           FutureParser future = scoped("codeSet");
           codeSetParser = future;
           future.setParser(
               sequence(
                   token("CODE-SET"),
                   optional(
                       token("IS")
                   ),
                   alphabetName()
               )
           );
        }

        return codeSetParser;
    }

    // ========================================================
    // dataRecords
    // ........................................................

    private Parser dataRecordsParser = null;

    public Parser dataRecords() {
        if (dataRecordsParser == null) {
           FutureParser future = scoped("dataRecords");
           dataRecordsParser = future;
           future.setParser(
               sequence(
                   optional(
                       token("DATA")
                   ),
                   choice(
                       token("RECORD"),
                       token("RECORDS")
                   ),
                   optional(
                       choice(
                           token("IS"),
                           token("ARE")
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

    public Parser labelRecords() {
        if (labelRecordsParser == null) {
           FutureParser future = scoped("labelRecords");
           labelRecordsParser = future;
           future.setParser(
               sequence(
                   token("LABEL"),
                   choice(
                       token("RECORD"),
                       token("RECORDS")
                   ),
                   optional(
                       choice(
                           token("IS"),
                           token("ARE")
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
    // linage
    // ........................................................

    private Parser linageParser = null;

    public Parser linage() {
        if (linageParser == null) {
           FutureParser future = scoped("linage");
           linageParser = future;
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
                       footing()
                   ),
                   optional(
                       linesAtTop()
                   ),
                   optional(
                       linesAtBottom()
                   )
               )
           );
        }

        return linageParser;
    }

    // ========================================================
    // footing
    // ........................................................

    private Parser footingParser = null;

    public Parser footing() {
        if (footingParser == null) {
           FutureParser future = scoped("footing");
           footingParser = future;
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

        return footingParser;
    }

    // ========================================================
    // linesAtTop
    // ........................................................

    private Parser linesAtTopParser = null;

    public Parser linesAtTop() {
        if (linesAtTopParser == null) {
           FutureParser future = scoped("linesAtTop");
           linesAtTopParser = future;
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

        return linesAtTopParser;
    }

    // ========================================================
    // linesAtBottom
    // ........................................................

    private Parser linesAtBottomParser = null;

    public Parser linesAtBottom() {
        if (linesAtBottomParser == null) {
           FutureParser future = scoped("linesAtBottom");
           linesAtBottomParser = future;
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

        return linesAtBottomParser;
    }

    // ========================================================
    // record
    // ........................................................

    private Parser recordParser = null;

    public Parser record() {
        if (recordParser == null) {
           FutureParser future = scoped("record");
           recordParser = future;
           future.setParser(
               sequence(
                   token("RECORD"),
                   choice(
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
                       ),
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
                   )
               )
           );
        }

        return recordParser;
    }

    // ========================================================
    // recordingMode
    // ........................................................

    private Parser recordingModeParser = null;

    public Parser recordingMode() {
        if (recordingModeParser == null) {
           FutureParser future = scoped("recordingMode");
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
                       token("S")
                   )
               )
           );
        }

        return recordingModeParser;
    }

    // ========================================================
    // valueOf
    // ........................................................

    private Parser valueOfParser = null;

    public Parser valueOf() {
        if (valueOfParser == null) {
           FutureParser future = scoped("valueOf");
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
    // report
    // ........................................................

    private Parser reportParser = null;

    public Parser report() {
        if (reportParser == null) {
           FutureParser future = scoped("report");
           reportParser = future;
           future.setParser(
               sequence(
                   choice(
                       token("REPORT"),
                       token("REPORTS")
                   ),
                   optional(
                       choice(
                           token("IS"),
                           token("ARE")
                       )
                   ),
                   plus(
                       reportName()
                   )
               )
           );
        }

        return reportParser;
    }

    // ========================================================
    // dataDescriptionEntry
    // ........................................................

    private Parser dataDescriptionEntryParser = null;

    public Parser dataDescriptionEntry() {
        if (dataDescriptionEntryParser == null) {
           FutureParser future = scoped("dataDescriptionEntry");
           dataDescriptionEntryParser = future;
           future.setParser(
               choice(
                   dataDescriptionEntry_format1(),
                   dataDescriptionEntry_format2(),
                   dataDescriptionEntry_format3(),
                   constantDescriptionEntry()
               )
           );
        }

        return dataDescriptionEntryParser;
    }

    // ========================================================
    // dataDescriptionEntry_format1
    // ........................................................

    private Parser dataDescriptionEntry_format1Parser = null;

    public Parser dataDescriptionEntry_format1() {
        if (dataDescriptionEntry_format1Parser == null) {
           FutureParser future = scoped("dataDescriptionEntry_format1");
           dataDescriptionEntry_format1Parser = future;
           future.setParser(
               sequence(
                   levelNumber(),
                   optional(
                       dataName()
                   ),
                   optional(
                       redefines()
                   ),
                   permuted(
                       blankWhenZero(),
                       external(),
                       global(),
                       justified(),
                       occurs(),
                       picture(),
                       sign(),
                       sync(),
                       usage(),
                       valueIs(),
                       based()
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

    public Parser dataDescriptionEntry_format2() {
        if (dataDescriptionEntry_format2Parser == null) {
           FutureParser future = scoped("dataDescriptionEntry_format2");
           dataDescriptionEntry_format2Parser = future;
           future.setParser(
               sequence(
                   token("66"),
                   dataName(),
                   token("RENAMES"),
                   dataName(),
                   star(
                       qualifier()
                   ),
                   optional(
                       sequence(
                           choice(
                               token("THROUGH"),
                               token("THRU")
                           ),
                           dataName(),
                           star(
                               qualifier()
                           )
                       )
                   ),
                   token(".")
               )
           );
        }

        return dataDescriptionEntry_format2Parser;
    }

    // ========================================================
    // dataDescriptionEntry_format3
    // ........................................................

    private Parser dataDescriptionEntry_format3Parser = null;

    public Parser dataDescriptionEntry_format3() {
        if (dataDescriptionEntry_format3Parser == null) {
           FutureParser future = scoped("dataDescriptionEntry_format3");
           dataDescriptionEntry_format3Parser = future;
           future.setParser(
               sequence(
                   token("88"),
                   cobolWord(),
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
                       sequence(
                           not(
                               token("FALSE")
                           ),
                           literal(),
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
                       whenSetToFalseClause()
                   ),
                   token(".")
               )
           );
        }

        return dataDescriptionEntry_format3Parser;
    }

    // ========================================================
    // whenSetToFalseClause
    // ........................................................

    private Parser whenSetToFalseClauseParser = null;

    public Parser whenSetToFalseClause() {
        if (whenSetToFalseClauseParser == null) {
           FutureParser future = scoped("whenSetToFalseClause");
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
    // constantDescriptionEntry
    // ........................................................

    private Parser constantDescriptionEntryParser = null;

    public Parser constantDescriptionEntry() {
        if (constantDescriptionEntryParser == null) {
           FutureParser future = scoped("constantDescriptionEntry");
           constantDescriptionEntryParser = future;
           future.setParser(
               sequence(
                   token("78"),
                   cobolWord(),
                   optional(
                       valueIs()
                   ),
                   token(".")
               )
           );
        }

        return constantDescriptionEntryParser;
    }

    // ========================================================
    // redefines
    // ........................................................

    private Parser redefinesParser = null;

    public Parser redefines() {
        if (redefinesParser == null) {
           FutureParser future = scoped("redefines");
           redefinesParser = future;
           future.setParser(
               sequence(
                   token("REDEFINES"),
                   cobolWord()
               )
           );
        }

        return redefinesParser;
    }

    // ========================================================
    // blankWhenZero
    // ........................................................

    private Parser blankWhenZeroParser = null;

    public Parser blankWhenZero() {
        if (blankWhenZeroParser == null) {
           FutureParser future = scoped("blankWhenZero");
           blankWhenZeroParser = future;
           future.setParser(
               sequence(
                   token("BLANK"),
                   optional(
                       token("WHEN")
                   ),
                   choice(
                       token("ZERO"),
                       token("ZEROS"),
                       token("ZEROES")
                   )
               )
           );
        }

        return blankWhenZeroParser;
    }

    // ========================================================
    // external
    // ........................................................

    private Parser externalParser = null;

    public Parser external() {
        if (externalParser == null) {
           FutureParser future = scoped("external");
           externalParser = future;
           future.setParser(
               sequence(
                   optional(
                       token("IS")
                   ),
                   token("EXTERNAL")
               )
           );
        }

        return externalParser;
    }

    // ========================================================
    // global
    // ........................................................

    private Parser globalParser = null;

    public Parser global() {
        if (globalParser == null) {
           FutureParser future = scoped("global");
           globalParser = future;
           future.setParser(
               sequence(
                   optional(
                       token("IS")
                   ),
                   token("GLOBAL")
               )
           );
        }

        return globalParser;
    }

    // ========================================================
    // justified
    // ........................................................

    private Parser justifiedParser = null;

    public Parser justified() {
        if (justifiedParser == null) {
           FutureParser future = scoped("justified");
           justifiedParser = future;
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

        return justifiedParser;
    }

    // ========================================================
    // occurs
    // ........................................................

    private Parser occursParser = null;

    public Parser occurs() {
        if (occursParser == null) {
           FutureParser future = scoped("occurs");
           occursParser = future;
           future.setParser(
               sequence(
                   token("OCCURS"),
                   integer(),
                   optional(
                       sequence(
                           token("TO"),
                           integer()
                       )
                   ),
                   optional(
                       token("TIMES")
                   ),
                   optional(
                       sequence(
                           token("DEPENDING"),
                           optional(
                               token("ON")
                           ),
                           dataName(),
                           star(
                               qualifier()
                           )
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
                               sequence(
                                   dataName(),
                                   star(
                                       qualifier()
                                   )
                               )
                           )
                       )
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
           );
        }

        return occursParser;
    }

    // ========================================================
    // picture
    // ........................................................

    private Parser pictureParser = null;

    public Parser picture() {
        if (pictureParser == null) {
           FutureParser future = scoped("picture");
           pictureParser = future;
           future.setParser(
               sequence(
                   choice(
                       token("PIC"),
                       token("PICTURE")
                   ),
                   optional(
                       token("IS")
                   ),
                   pictureString()
               )
           );
        }

        return pictureParser;
    }

    // ========================================================
    // sign
    // ........................................................

    private Parser signParser = null;

    public Parser sign() {
        if (signParser == null) {
           FutureParser future = scoped("sign");
           signParser = future;
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

        return signParser;
    }

    // ========================================================
    // sync
    // ........................................................

    private Parser syncParser = null;

    public Parser sync() {
        if (syncParser == null) {
           FutureParser future = scoped("sync");
           syncParser = future;
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

        return syncParser;
    }

    // ========================================================
    // usage
    // ........................................................

    private Parser usageParser = null;

    public Parser usage() {
        if (usageParser == null) {
           FutureParser future = scoped("usage");
           usageParser = future;
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
                   choice(
                       token("BINARY"),
                       token("COMPUTATIONAL"),
                       token("COMP"),
                       token("DISPLAY"),
                       token("INDEX"),
                       token("PACKED-DECIMAL"),
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
                       token("POINTER")
                   )
               )
           );
        }

        return usageParser;
    }

    // ========================================================
    // valueIs
    // ........................................................

    private Parser valueIsParser = null;

    public Parser valueIs() {
        if (valueIsParser == null) {
           FutureParser future = scoped("valueIs");
           valueIsParser = future;
           future.setParser(
               sequence(
                   token("VALUE"),
                   optional(
                       token("IS")
                   ),
                   value()
               )
           );
        }

        return valueIsParser;
    }

    // ========================================================
    // based
    // ........................................................

    private Parser basedParser = null;

    public Parser based() {
        if (basedParser == null) {
           FutureParser future = scoped("based");
           basedParser = future;
           future.setParser(
               token("BASED")
           );
        }

        return basedParser;
    }

    // ========================================================
    // procedureDivision
    // ........................................................

    private Parser procedureDivisionParser = null;

    public Parser procedureDivision() {
        if (procedureDivisionParser == null) {
           FutureParser future = scoped("procedureDivision");
           procedureDivisionParser = future;
           future.setParser(
               sequence(
                   token("PROCEDURE"),
                   token("DIVISION"),
                   optional(
                       usingOrChainingPhrase()
                   ),
                   optional(
                       returningPhrase()
                   ),
                   token("."),
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
    // usingOrChainingPhrase
    // ........................................................

    private Parser usingOrChainingPhraseParser = null;

    public Parser usingOrChainingPhrase() {
        if (usingOrChainingPhraseParser == null) {
           FutureParser future = scoped("usingOrChainingPhrase");
           usingOrChainingPhraseParser = future;
           future.setParser(
               sequence(
                   choice(
                       token("USING"),
                       token("CHAINING")
                   ),
                   star(
                       choice(
                           dataReference(),
                           dataValue()
                       )
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

    public Parser dataReference() {
        if (dataReferenceParser == null) {
           FutureParser future = scoped("dataReference");
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
                   dataName()
               )
           );
        }

        return dataReferenceParser;
    }

    // ========================================================
    // dataValue
    // ........................................................

    private Parser dataValueParser = null;

    public Parser dataValue() {
        if (dataValueParser == null) {
           FutureParser future = scoped("dataValue");
           dataValueParser = future;
           future.setParser(
               sequence(
                   optional(
                       token("BY")
                   ),
                   token("VALUE"),
                   dataName()
               )
           );
        }

        return dataValueParser;
    }

    // ========================================================
    // returningPhrase
    // ........................................................

    private Parser returningPhraseParser = null;

    public Parser returningPhrase() {
        if (returningPhraseParser == null) {
           FutureParser future = scoped("returningPhrase");
           returningPhraseParser = future;
           future.setParser(
               sequence(
                   token("RETURNING"),
                   dataName()
               )
           );
        }

        return returningPhraseParser;
    }

    // ========================================================
    // declaratives
    // ........................................................

    private Parser declarativesParser = null;

    public Parser declaratives() {
        if (declarativesParser == null) {
           FutureParser future = scoped("declaratives");
           declarativesParser = future;
           future.setParser(
               sequence(
                   token("DECLARATIVES"),
                   token("."),
                   plus(
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

    public Parser declarativeSection() {
        if (declarativeSectionParser == null) {
           FutureParser future = scoped("declarativeSection");
           declarativeSectionParser = future;
           future.setParser(
               sequence(
                   sectionName(),
                   token("SECTION"),
                   token("."),
                   useStatement(),
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

    public Parser section() {
        if (sectionParser == null) {
           FutureParser future = scoped("section");
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

    public Parser paragraph() {
        if (paragraphParser == null) {
           FutureParser future = scoped("paragraph");
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

    public Parser sentence() {
        if (sentenceParser == null) {
           FutureParser future = scoped("sentence");
           sentenceParser = future;
           future.setParser(
               choice(
                   sequence(
                       statement(),
                       star(
                           choice(
                               statement(),
                               continuationOfStatement()
                           )
                       ),
                       token(".")
                   ),
                   copyStatement(),
                   replaceStatement(),
                   useStatement(),
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

    public Parser statement() {
        if (statementParser == null) {
           FutureParser future = scoped("statement");
           statementParser = future;
           future.setParser(
               choice(
                   addStatement(),
                   callStatement(),
                   cancelStatement(),
                   closeStatement(),
                   computeStatement(),
                   deleteStatement(),
                   divideStatement(),
                   entryStatement(),
                   evaluateStatement(),
                   execStatement(),
                   exitStatement(),
                   gobackStatement(),
                   goToStatement(),
                   ifStatement(),
                   moveStatement(),
                   multiplyStatement(),
                   openStatement(),
                   performStatement(),
                   readStatement(),
                   releaseStatement(),
                   returnStatement(),
                   rewriteStatement(),
                   searchStatement(),
                   startStatement(),
                   stopStatement(),
                   stringStatement(),
                   subtractStatement(),
                   unstringStatement(),
                   writeStatement(),
                   setStatement(),
                   initializeStatement(),
                   displayStatement(),
                   inspectStatement(),
                   allocateStatement(),
                   freeStatement(),
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

    public Parser subStatementMarker() {
        if (subStatementMarkerParser == null) {
           FutureParser future = scoped("subStatementMarker");
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

    public Parser continuationOfStatement() {
        if (continuationOfStatementParser == null) {
           FutureParser future = scoped("continuationOfStatement");
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

    public Parser nestedStatements() {
        if (nestedStatementsParser == null) {
           FutureParser future = scoped("nestedStatements");
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

    public Parser eventPhrase() {
        if (eventPhraseParser == null) {
           FutureParser future = scoped("eventPhrase");
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
    // endOfStatementMarker
    // ........................................................

    private Parser endOfStatementMarkerParser = null;

    public Parser endOfStatementMarker() {
        if (endOfStatementMarkerParser == null) {
           FutureParser future = scoped("endOfStatementMarker");
           endOfStatementMarkerParser = future;
           future.setParser(
               sequence(
                   choice(
                       assign("t", token("END-ACCEPT")),
                       assign("t", token("END-ADD")),
                       assign("t", token("END-CALL")),
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

    public Parser verb() {
        if (verbParser == null) {
           FutureParser future = scoped("verb");
           verbParser = future;
           future.setParser(
               choice(
                   token("ADD"),
                   token("CALL"),
                   token("CANCEL"),
                   token("CLOSE"),
                   token("DELETE"),
                   token("DIVIDE"),
                   token("ENTRY"),
                   token("EVALUATE"),
                   token("EXEC"),
                   token("EXIT"),
                   token("GOBACK"),
                   token("GO"),
                   token("IF"),
                   token("MOVE"),
                   token("MULTIPLY"),
                   token("OPEN"),
                   token("PERFORM"),
                   token("READ"),
                   token("RELEASE"),
                   token("RETURN"),
                   token("REWRITE"),
                   token("SEARCH"),
                   token("STOP"),
                   token("STRING"),
                   token("SUBTRACT"),
                   token("UNSTRING"),
                   token("WRITE"),
                   token("SET"),
                   token("INITIALIZE"),
                   token("DISPLAY"),
                   token("COMPUTE"),
                   token("INSPECT"),
                   token("ALLOCATE"),
                   token("FREE"),
                   token("START"),
                   token("USE"),
                   token("ACCEPT"),
                   token("ALTER"),
                   token("CONTINUE"),
                   token("MERGE"),
                   token("SORT"),
                   token("ENABLE"),
                   token("DISABLE"),
                   token("SEND"),
                   token("RECEIVE"),
                   token("PURGE"),
                   token("INITIATE"),
                   token("GENERATE"),
                   token("TERMINATE")
               )
           );
        }

        return verbParser;
    }

    // ========================================================
    // addStatement
    // ........................................................

    private Parser addStatementParser = null;

    public Parser addStatement() {
        if (addStatementParser == null) {
           FutureParser future = scoped("addStatement");
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
                       sequence(
                           optional(
                               token("ON")
                           ),
                           token("SIZE"),
                           token("ERROR"),
                           nestedStatements()
                       )
                   ),
                   optional(
                       sequence(
                           token("NOT"),
                           optional(
                               token("ON")
                           ),
                           token("SIZE"),
                           token("ERROR"),
                           nestedStatements()
                       )
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

    public Parser addition_format1() {
        if (addition_format1Parser == null) {
           FutureParser future = scoped("addition_format1");
           addition_format1Parser = future;
           future.setParser(
               sequence(
                   choice(
                       token("CORRESPONDING"),
                       token("CORR")
                   ),
                   identifier(),
                   token("TO"),
                   identifier(),
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

    public Parser addition_format2() {
        if (addition_format2Parser == null) {
           FutureParser future = scoped("addition_format2");
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
                           identifier(),
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

    public Parser addition_format3() {
        if (addition_format3Parser == null) {
           FutureParser future = scoped("addition_format3");
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

    public Parser allocateStatement() {
        if (allocateStatementParser == null) {
           FutureParser future = scoped("allocateStatement");
           allocateStatementParser = future;
           future.setParser(
               sequence(
                   token("ALLOCATE"),
                   choice(
                       sequence(
                           arithmeticExpression(),
                           token("CHARACTERS")
                       ),
                       identifier()
                   ),
                   optional(
                       token("INITIALIZED")
                   ),
                   optional(
                       sequence(
                           token("RETURNING"),
                           identifier()
                       )
                   )
               )
           );
        }

        return allocateStatementParser;
    }

    // ========================================================
    // callStatement
    // ........................................................

    private Parser callStatementParser = null;

    public Parser callStatement() {
        if (callStatementParser == null) {
           FutureParser future = scoped("callStatement");
           callStatementParser = future;
           future.setParser(
               sequence(
                   token("CALL"),
                   programID(),
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

    public Parser callUsing() {
        if (callUsingParser == null) {
           FutureParser future = scoped("callUsing");
           callUsingParser = future;
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
                                       identifier(),
                                       token("OMITTED")
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
                                       literal(),
                                       identifier()
                                   )
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

    public Parser callGivingOrReturning() {
        if (callGivingOrReturningParser == null) {
           FutureParser future = scoped("callGivingOrReturning");
           callGivingOrReturningParser = future;
           future.setParser(
               sequence(
                   choice(
                       token("GIVING"),
                       token("RETURNING")
                   ),
                   optional(
                       token("INTO")
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

    public Parser onOverflow() {
        if (onOverflowParser == null) {
           FutureParser future = scoped("onOverflow");
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
    // onException
    // ........................................................

    private Parser onExceptionParser = null;

    public Parser onException() {
        if (onExceptionParser == null) {
           FutureParser future = scoped("onException");
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

    public Parser notOnException() {
        if (notOnExceptionParser == null) {
           FutureParser future = scoped("notOnException");
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
    // programID
    // ........................................................

    private Parser programIDParser = null;

    public Parser programID() {
        if (programIDParser == null) {
           FutureParser future = scoped("programID");
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

    public Parser cancelStatement() {
        if (cancelStatementParser == null) {
           FutureParser future = scoped("cancelStatement");
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
    // closeStatement
    // ........................................................

    private Parser closeStatementParser = null;

    public Parser closeStatement() {
        if (closeStatementParser == null) {
           FutureParser future = scoped("closeStatement");
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
    // computeStatement
    // ........................................................

    private Parser computeStatementParser = null;

    public Parser computeStatement() {
        if (computeStatementParser == null) {
           FutureParser future = scoped("computeStatement");
           computeStatementParser = future;
           future.setParser(
               sequence(
                   token("COMPUTE"),
                   plus(
                       sequence(
                           identifier(),
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
                       sequence(
                           optional(
                               token("ON")
                           ),
                           token("SIZE"),
                           token("ERROR"),
                           nestedStatements()
                       )
                   ),
                   optional(
                       sequence(
                           token("NOT"),
                           optional(
                               token("ON")
                           ),
                           token("SIZE"),
                           token("ERROR"),
                           nestedStatements()
                       )
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
    // deleteStatement
    // ........................................................

    private Parser deleteStatementParser = null;

    public Parser deleteStatement() {
        if (deleteStatementParser == null) {
           FutureParser future = scoped("deleteStatement");
           deleteStatementParser = future;
           future.setParser(
               sequence(
                   token("DELETE"),
                   fileName(),
                   optional(
                       token("RECORD")
                   ),
                   optional(
                       sequence(
                           token("INVALID"),
                           optional(
                               token("KEY")
                           ),
                           nestedStatements()
                       )
                   ),
                   optional(
                       sequence(
                           token("NOT"),
                           token("INVALID"),
                           optional(
                               token("KEY")
                           ),
                           nestedStatements()
                       )
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
    // displayStatement
    // ........................................................

    private Parser displayStatementParser = null;

    public Parser displayStatement() {
        if (displayStatementParser == null) {
           FutureParser future = scoped("displayStatement");
           displayStatementParser = future;
           future.setParser(
               sequence(
                   token("DISPLAY"),
                   choice(
                       displayUponFormat(),
                       displayTerminalFormat(),
                       displayScreenFormat(),
                       skipto(
                           choice(
                               token("."),
                               endOfStatement()
                           )
                       )
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
    // displayUponFormat
    // ........................................................

    private Parser displayUponFormatParser = null;

    public Parser displayUponFormat() {
        if (displayUponFormatParser == null) {
           FutureParser future = scoped("displayUponFormat");
           displayUponFormatParser = future;
           future.setParser(
               sequence(
                   plus(
                       choice(
                           identifier(),
                           literal()
                       )
                   ),
                   uponClause(),
                   optional(
                       withNoAdvancing()
                   )
               )
           );
        }

        return displayUponFormatParser;
    }

    // ========================================================
    // uponClause
    // ........................................................

    private Parser uponClauseParser = null;

    public Parser uponClause() {
        if (uponClauseParser == null) {
           FutureParser future = scoped("uponClause");
           uponClauseParser = future;
           future.setParser(
               sequence(
                   token("UPON"),
                   choice(
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

    public Parser withNoAdvancing() {
        if (withNoAdvancingParser == null) {
           FutureParser future = scoped("withNoAdvancing");
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

    public Parser displayTerminalFormat() {
        if (displayTerminalFormatParser == null) {
           FutureParser future = scoped("displayTerminalFormat");
           displayTerminalFormatParser = future;
           future.setParser(
               plus(
                   sequence(
                       choice(
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
                       optional(
                           displayTerminalMods()
                       )
                   )
               )
           );
        }

        return displayTerminalFormatParser;
    }

    // ========================================================
    // displayTerminalMods
    // ........................................................

    private Parser displayTerminalModsParser = null;

    public Parser displayTerminalMods() {
        if (displayTerminalModsParser == null) {
           FutureParser future = scoped("displayTerminalMods");
           displayTerminalModsParser = future;
           future.setParser(
               plus(
                   choice(
                       dtBellMod(),
                       dtBlinkMod(),
                       dtControlMod(),
                       dtConvertMod(),
                       dtEraseMod(),
                       dtLightingMod(),
                       dtPositioningMod(),
                       dtModeBlockMod(),
                       dtReverseMod(),
                       dtSizeMod()
                   )
               )
           );
        }

        return displayTerminalModsParser;
    }

    // ========================================================
    // dtBellMod
    // ........................................................

    private Parser dtBellModParser = null;

    public Parser dtBellMod() {
        if (dtBellModParser == null) {
           FutureParser future = scoped("dtBellMod");
           dtBellModParser = future;
           future.setParser(
               sequence(
                   optional(
                       token("WITH")
                   ),
                   choice(
                       token("BEEP"),
                       token("BELL")
                   )
               )
           );
        }

        return dtBellModParser;
    }

    // ========================================================
    // dtBlinkMod
    // ........................................................

    private Parser dtBlinkModParser = null;

    public Parser dtBlinkMod() {
        if (dtBlinkModParser == null) {
           FutureParser future = scoped("dtBlinkMod");
           dtBlinkModParser = future;
           future.setParser(
               sequence(
                   optional(
                       token("WITH")
                   ),
                   token("BLINK")
               )
           );
        }

        return dtBlinkModParser;
    }

    // ========================================================
    // dtControlMod
    // ........................................................

    private Parser dtControlModParser = null;

    public Parser dtControlMod() {
        if (dtControlModParser == null) {
           FutureParser future = scoped("dtControlMod");
           dtControlModParser = future;
           future.setParser(
               sequence(
                   optional(
                       token("WITH")
                   ),
                   token("CONTROL"),
                   choice(
                       identifier(),
                       literal()
                   )
               )
           );
        }

        return dtControlModParser;
    }

    // ========================================================
    // dtConvertMod
    // ........................................................

    private Parser dtConvertModParser = null;

    public Parser dtConvertMod() {
        if (dtConvertModParser == null) {
           FutureParser future = scoped("dtConvertMod");
           dtConvertModParser = future;
           future.setParser(
               sequence(
                   optional(
                       token("WITH")
                   ),
                   token("CONVERT")
               )
           );
        }

        return dtConvertModParser;
    }

    // ========================================================
    // dtEraseMod
    // ........................................................

    private Parser dtEraseModParser = null;

    public Parser dtEraseMod() {
        if (dtEraseModParser == null) {
           FutureParser future = scoped("dtEraseMod");
           dtEraseModParser = future;
           future.setParser(
               sequence(
                   optional(
                       token("WITH")
                   ),
                   token("ERASE"),
                   choice(
                       token("EOL"),
                       token("EOS")
                   )
               )
           );
        }

        return dtEraseModParser;
    }

    // ========================================================
    // dtLightingMod
    // ........................................................

    private Parser dtLightingModParser = null;

    public Parser dtLightingMod() {
        if (dtLightingModParser == null) {
           FutureParser future = scoped("dtLightingMod");
           dtLightingModParser = future;
           future.setParser(
               sequence(
                   optional(
                       token("WITH")
                   ),
                   choice(
                       token("HIGH"),
                       token("HIGHLIGHT"),
                       token("LOW"),
                       token("LOWLIGHT")
                   )
               )
           );
        }

        return dtLightingModParser;
    }

    // ========================================================
    // dtPositioningMod
    // ........................................................

    private Parser dtPositioningModParser = null;

    public Parser dtPositioningMod() {
        if (dtPositioningModParser == null) {
           FutureParser future = scoped("dtPositioningMod");
           dtPositioningModParser = future;
           future.setParser(
               sequence(
                   optional(
                       token("WITH")
                   ),
                   choice(
                       dtAtPositioning(),
                       dtLineColPositioning()
                   )
               )
           );
        }

        return dtPositioningModParser;
    }

    // ========================================================
    // dtModeBlockMod
    // ........................................................

    private Parser dtModeBlockModParser = null;

    public Parser dtModeBlockMod() {
        if (dtModeBlockModParser == null) {
           FutureParser future = scoped("dtModeBlockMod");
           dtModeBlockModParser = future;
           future.setParser(
               sequence(
                   optional(
                       token("WITH")
                   ),
                   token("MODE"),
                   optional(
                       token("IS")
                   ),
                   token("BLOCK")
               )
           );
        }

        return dtModeBlockModParser;
    }

    // ========================================================
    // dtReverseMod
    // ........................................................

    private Parser dtReverseModParser = null;

    public Parser dtReverseMod() {
        if (dtReverseModParser == null) {
           FutureParser future = scoped("dtReverseMod");
           dtReverseModParser = future;
           future.setParser(
               sequence(
                   optional(
                       token("WITH")
                   ),
                   choice(
                       token("REVERSED"),
                       token("REVERSE-VIDEO"),
                       token("REVERSE")
                   )
               )
           );
        }

        return dtReverseModParser;
    }

    // ========================================================
    // dtSizeMod
    // ........................................................

    private Parser dtSizeModParser = null;

    public Parser dtSizeMod() {
        if (dtSizeModParser == null) {
           FutureParser future = scoped("dtSizeMod");
           dtSizeModParser = future;
           future.setParser(
               sequence(
                   optional(
                       token("WITH")
                   ),
                   token("SIZE"),
                   choice(
                       identifier(),
                       literal()
                   )
               )
           );
        }

        return dtSizeModParser;
    }

    // ========================================================
    // dtAtPositioning
    // ........................................................

    private Parser dtAtPositioningParser = null;

    public Parser dtAtPositioning() {
        if (dtAtPositioningParser == null) {
           FutureParser future = scoped("dtAtPositioning");
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

    public Parser dtLineColPositioning() {
        if (dtLineColPositioningParser == null) {
           FutureParser future = scoped("dtLineColPositioning");
           dtLineColPositioningParser = future;
           future.setParser(
               sequence(
                   optional(
                       token("AT")
                   ),
                   plus(
                       choice(
                           dtLinePos(),
                           dtColPos()
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

    public Parser dtLinePos() {
        if (dtLinePosParser == null) {
           FutureParser future = scoped("dtLinePos");
           dtLinePosParser = future;
           future.setParser(
               sequence(
                   token("LINE"),
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

    public Parser dtColPos() {
        if (dtColPosParser == null) {
           FutureParser future = scoped("dtColPos");
           dtColPosParser = future;
           future.setParser(
               sequence(
                   choice(
                       token("COL"),
                       token("COLUMN"),
                       token("POSITION")
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
    // displayScreenFormat
    // ........................................................

    private Parser displayScreenFormatParser = null;

    public Parser displayScreenFormat() {
        if (displayScreenFormatParser == null) {
           FutureParser future = scoped("displayScreenFormat");
           displayScreenFormatParser = future;
           future.setParser(
               plus(
                   sequence(
                       choice(
                           identifier(),
                           literal()
                       ),
                       choice(
                           screenLineColClause(),
                           screenAtClause()
                       )
                   )
               )
           );
        }

        return displayScreenFormatParser;
    }

    // ========================================================
    // screenAtClause
    // ........................................................

    private Parser screenAtClauseParser = null;

    public Parser screenAtClause() {
        if (screenAtClauseParser == null) {
           FutureParser future = scoped("screenAtClause");
           screenAtClauseParser = future;
           future.setParser(
               sequence(
                   token("AT"),
                   choice(
                       identifier(),
                       integer()
                   )
               )
           );
        }

        return screenAtClauseParser;
    }

    // ========================================================
    // screenLineColClause
    // ........................................................

    private Parser screenLineColClauseParser = null;

    public Parser screenLineColClause() {
        if (screenLineColClauseParser == null) {
           FutureParser future = scoped("screenLineColClause");
           screenLineColClauseParser = future;
           future.setParser(
               sequence(
                   optional(
                       token("AT")
                   ),
                   plus(
                       choice(
                           sequence(
                               token("LINE"),
                               optional(
                                   token("NUMBER")
                               ),
                               choice(
                                   identifier(),
                                   integer()
                               )
                           ),
                           sequence(
                               choice(
                                   token("COLUMN"),
                                   token("COL")
                               ),
                               optional(
                                   token("NUMBER")
                               ),
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

        return screenLineColClauseParser;
    }

    // ========================================================
    // divideStatement
    // ........................................................

    private Parser divideStatementParser = null;

    public Parser divideStatement() {
        if (divideStatementParser == null) {
           FutureParser future = scoped("divideStatement");
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
                       sequence(
                           optional(
                               token("ON")
                           ),
                           token("SIZE"),
                           token("ERROR"),
                           nestedStatements()
                       )
                   ),
                   optional(
                       sequence(
                           token("NOT"),
                           optional(
                               token("ON")
                           ),
                           token("SIZE"),
                           token("ERROR"),
                           nestedStatements()
                       )
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

    public Parser division_format1() {
        if (division_format1Parser == null) {
           FutureParser future = scoped("division_format1");
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
                   identifier(),
                   optional(
                       token("ROUNDED")
                   ),
                   token("REMAINDER"),
                   identifier()
               )
           );
        }

        return division_format1Parser;
    }

    // ========================================================
    // division_format2
    // ........................................................

    private Parser division_format2Parser = null;

    public Parser division_format2() {
        if (division_format2Parser == null) {
           FutureParser future = scoped("division_format2");
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
                           identifier(),
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

    public Parser division_format3() {
        if (division_format3Parser == null) {
           FutureParser future = scoped("division_format3");
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
                           identifier(),
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
    // entryStatement
    // ........................................................

    private Parser entryStatementParser = null;

    public Parser entryStatement() {
        if (entryStatementParser == null) {
           FutureParser future = scoped("entryStatement");
           entryStatementParser = future;
           future.setParser(
               sequence(
                   token("ENTRY"),
                   alphanumeric(),
                   optional(
                       sequence(
                           token("USING"),
                           plus(
                               dataName()
                           )
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

    public Parser evaluateStatement() {
        if (evaluateStatementParser == null) {
           FutureParser future = scoped("evaluateStatement");
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

    public Parser subject() {
        if (subjectParser == null) {
           FutureParser future = scoped("subject");
           subjectParser = future;
           future.setParser(
               choice(
                   condition(),
                   identifier(),
                   arithmeticExpression(),
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

    public Parser when() {
        if (whenParser == null) {
           FutureParser future = scoped("when");
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

    public Parser whenOther() {
        if (whenOtherParser == null) {
           FutureParser future = scoped("whenOther");
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

    public Parser object() {
        if (objectParser == null) {
           FutureParser future = scoped("object");
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
                           identifier(),
                           literal(),
                           arithmeticExpression()
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

    public Parser rangeExpression() {
        if (rangeExpressionParser == null) {
           FutureParser future = scoped("rangeExpression");
           rangeExpressionParser = future;
           future.setParser(
               sequence(
                   optional(
                       token("NOT")
                   ),
                   choice(
                       identifier(),
                       literal(),
                       arithmeticExpression()
                   ),
                   choice(
                       token("THROUGH"),
                       token("THRU")
                   ),
                   choice(
                       identifier(),
                       literal(),
                       arithmeticExpression()
                   )
               )
           );
        }

        return rangeExpressionParser;
    }

    // ========================================================
    // execStatement
    // ........................................................

    private Parser execStatementParser = null;

    public Parser execStatement() {
        if (execStatementParser == null) {
           FutureParser future = scoped("execStatement");
           execStatementParser = future;
           future.setParser(
               choice(
                   execSQLStatement(),
                   execCICSStatement(),
                   sequence(
                       token("EXEC"),
                       cobolWord(),
                       optional(
                           skipto(
                               token("END-EXEC")
                           )
                       ),
                       token("END-EXEC")
                   )
               )
           );
        }

        return execStatementParser;
    }

    // ========================================================
    // execSQLStatement
    // ........................................................

    private Parser execSQLStatementParser = null;

    public Parser execSQLStatement() {
        if (execSQLStatementParser == null) {
           FutureParser future = scoped("execSQLStatement");
           execSQLStatementParser = future;
           future.setParser(
               sequence(
                   token("EXEC"),
                   token("SQL"),
                   sqlStatement(),
                   optional(
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
    // sqlStatement
    // ........................................................

    private Parser sqlStatementParser = null;

    public Parser sqlStatement() {
        if (sqlStatementParser == null) {
           FutureParser future = scoped("sqlStatement");
           sqlStatementParser = future;
           future.setParser(
               choice(
                   sqlInclude(),
                   sqlSelect(),
                   sqlInsert(),
                   sqlUpdate(),
                   sqlDelete()
               )
           );
        }

        return sqlStatementParser;
    }

    // ========================================================
    // sqlInclude
    // ........................................................

    private Parser sqlIncludeParser = null;

    public Parser sqlInclude() {
        if (sqlIncludeParser == null) {
           FutureParser future = scoped("sqlInclude");
           sqlIncludeParser = future;
           future.setParser(
               sequence(
                   token("INCLUDE"),
                   textName()
               )
           );
        }

        return sqlIncludeParser;
    }

    // ========================================================
    // sqlSelect
    // ........................................................

    private Parser sqlSelectParser = null;

    public Parser sqlSelect() {
        if (sqlSelectParser == null) {
           FutureParser future = scoped("sqlSelect");
           sqlSelectParser = future;
           future.setParser(
               sequence(
                   choice(
                       token("SELECT"),
                       sequence(
                           token("DECLARE"),
                           optional(
                               skipto(
                                   token("SELECT")
                               )
                           ),
                           token("SELECT")
                       )
                   ),
                   optional(
                       skipto(
                           token("FROM")
                       )
                   ),
                   token("FROM"),
                   optional(
                       sequence(
                           identifier(),
                           token(".")
                       )
                   ),
                   tableName()
               )
           );
        }

        return sqlSelectParser;
    }

    // ========================================================
    // sqlInsert
    // ........................................................

    private Parser sqlInsertParser = null;

    public Parser sqlInsert() {
        if (sqlInsertParser == null) {
           FutureParser future = scoped("sqlInsert");
           sqlInsertParser = future;
           future.setParser(
               sequence(
                   token("INSERT"),
                   token("INTO"),
                   optional(
                       sequence(
                           identifier(),
                           token(".")
                       )
                   ),
                   tableName()
               )
           );
        }

        return sqlInsertParser;
    }

    // ========================================================
    // sqlUpdate
    // ........................................................

    private Parser sqlUpdateParser = null;

    public Parser sqlUpdate() {
        if (sqlUpdateParser == null) {
           FutureParser future = scoped("sqlUpdate");
           sqlUpdateParser = future;
           future.setParser(
               sequence(
                   token("UPDATE"),
                   optional(
                       sequence(
                           identifier(),
                           token(".")
                       )
                   ),
                   tableName()
               )
           );
        }

        return sqlUpdateParser;
    }

    // ========================================================
    // sqlDelete
    // ........................................................

    private Parser sqlDeleteParser = null;

    public Parser sqlDelete() {
        if (sqlDeleteParser == null) {
           FutureParser future = scoped("sqlDelete");
           sqlDeleteParser = future;
           future.setParser(
               sequence(
                   token("DELETE"),
                   token("FROM"),
                   optional(
                       sequence(
                           identifier(),
                           token(".")
                       )
                   ),
                   tableName()
               )
           );
        }

        return sqlDeleteParser;
    }

    // ========================================================
    // tableName
    // ........................................................

    private Parser tableNameParser = null;

    public Parser tableName() {
        if (tableNameParser == null) {
           FutureParser future = scoped("tableName");
           tableNameParser = future;
           future.setParser(
               cobolWord()
           );
        }

        return tableNameParser;
    }

    // ========================================================
    // execCICSStatement
    // ........................................................

    private Parser execCICSStatementParser = null;

    public Parser execCICSStatement() {
        if (execCICSStatementParser == null) {
           FutureParser future = scoped("execCICSStatement");
           execCICSStatementParser = future;
           future.setParser(
               sequence(
                   token("EXEC"),
                   token("CICS"),
                   cicsStatement(),
                   optional(
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
    // cicsStatement
    // ........................................................

    private Parser cicsStatementParser = null;

    public Parser cicsStatement() {
        if (cicsStatementParser == null) {
           FutureParser future = scoped("cicsStatement");
           cicsStatementParser = future;
           future.setParser(
               choice(
                   cicsReadQ(),
                   cicsWriteQ(),
                   cicsDeleteQ(),
                   cicsReadFile(),
                   cicsWriteFile(),
                   cicsLink(),
                   cicsXctl(),
                   cicsLoad(),
                   cicsStart()
               )
           );
        }

        return cicsStatementParser;
    }

    // ========================================================
    // dataArea
    // ........................................................

    private Parser dataAreaParser = null;

    public Parser dataArea() {
        if (dataAreaParser == null) {
           FutureParser future = scoped("dataArea");
           dataAreaParser = future;
           future.setParser(
               choice(
                   literal(),
                   identifier()
               )
           );
        }

        return dataAreaParser;
    }

    // ========================================================
    // cicsReadQ
    // ........................................................

    private Parser cicsReadQParser = null;

    public Parser cicsReadQ() {
        if (cicsReadQParser == null) {
           FutureParser future = scoped("cicsReadQ");
           cicsReadQParser = future;
           future.setParser(
               sequence(
                   token("READQ"),
                   choice(
                       sequence(
                           token("TS"),
                           choice(
                               token("QUEUE"),
                               token("QNAME")
                           ),
                           token("("),
                           queueName(),
                           token(")"),
                           permuted(
                               sequence(
                                   choice(
                                       token("SYSID"),
                                       token("SYS")
                                   ),
                                   token("("),
                                   cicsSysid(),
                                   token(")")
                               ),
                               sequence(
                                   choice(
                                       token("SET"),
                                       token("INTO")
                                   ),
                                   token("("),
                                   dataArea(),
                                   token(")"),
                                   optional(
                                       sequence(
                                           token("LENGTH"),
                                           cicsWaterInBrackets()
                                       )
                                   )
                               ),
                               choice(
                                   sequence(
                                       token("ITEM"),
                                       cicsWaterInBrackets()
                                   ),
                                   token("NEXT")
                               ),
                               sequence(
                                   token("NUMITEMS"),
                                   cicsWaterInBrackets()
                               )
                           )
                       ),
                       sequence(
                           token("TD"),
                           token("QUEUE"),
                           token("("),
                           choice(
                               literal(),
                               identifier()
                           ),
                           token(")")
                       )
                   )
               )
           );
        }

        return cicsReadQParser;
    }

    // ========================================================
    // cicsWriteQ
    // ........................................................

    private Parser cicsWriteQParser = null;

    public Parser cicsWriteQ() {
        if (cicsWriteQParser == null) {
           FutureParser future = scoped("cicsWriteQ");
           cicsWriteQParser = future;
           future.setParser(
               sequence(
                   token("WRITEQ"),
                   choice(
                       sequence(
                           token("TS"),
                           choice(
                               token("QUEUE"),
                               token("QNAME")
                           ),
                           token("("),
                           queueName(),
                           token(")"),
                           permuted(
                               sequence(
                                   choice(
                                       token("SYSID"),
                                       token("SYS")
                                   ),
                                   token("("),
                                   cicsSysid(),
                                   token(")")
                               ),
                               sequence(
                                   token("FROM"),
                                   token("("),
                                   dataArea(),
                                   token(")"),
                                   optional(
                                       sequence(
                                           token("LENGTH"),
                                           cicsWaterInBrackets()
                                       )
                                   )
                               ),
                               choice(
                                   sequence(
                                       token("NUMITEMS"),
                                       cicsWaterInBrackets()
                                   ),
                                   sequence(
                                       token("ITEM"),
                                       cicsWaterInBrackets(),
                                       optional(
                                           token("REWRITE")
                                       )
                                   )
                               ),
                               token("NOSUSPEND"),
                               choice(
                                   token("MAIN"),
                                   token("AUXILIARY")
                               )
                           )
                       ),
                       sequence(
                           token("TD"),
                           token("QUEUE"),
                           token("("),
                           queueName(),
                           token(")")
                       )
                   )
               )
           );
        }

        return cicsWriteQParser;
    }

    // ========================================================
    // cicsDeleteQ
    // ........................................................

    private Parser cicsDeleteQParser = null;

    public Parser cicsDeleteQ() {
        if (cicsDeleteQParser == null) {
           FutureParser future = scoped("cicsDeleteQ");
           cicsDeleteQParser = future;
           future.setParser(
               sequence(
                   token("DELETEQ"),
                   choice(
                       token("TS"),
                       token("TD")
                   ),
                   choice(
                       token("QUEUE"),
                       token("QNAME")
                   ),
                   token("("),
                   queueName(),
                   token(")"),
                   optional(
                       sequence(
                           choice(
                               token("SYSID"),
                               token("SYS")
                           ),
                           token("("),
                           cicsSysid(),
                           token(")")
                       )
                   )
               )
           );
        }

        return cicsDeleteQParser;
    }

    // ========================================================
    // cicsReadFile
    // ........................................................

    private Parser cicsReadFileParser = null;

    public Parser cicsReadFile() {
        if (cicsReadFileParser == null) {
           FutureParser future = scoped("cicsReadFile");
           cicsReadFileParser = future;
           future.setParser(
               choice(
                   sequence(
                       token("READ"),
                       choice(
                           token("FILE"),
                           token("DATASET")
                       ),
                       token("("),
                       fileName(),
                       token(")"),
                       permuted(
                           sequence(
                               choice(
                                   token("SYSID"),
                                   token("SYS")
                               ),
                               token("("),
                               cicsSysid(),
                               token(")")
                           ),
                           sequence(
                               choice(
                                   token("SET"),
                                   token("INTO")
                               ),
                               token("("),
                               dataArea(),
                               token(")"),
                               optional(
                                   sequence(
                                       token("LENGTH"),
                                       cicsWaterInBrackets()
                                   )
                               )
                           ),
                           sequence(
                               token("RIDFLD"),
                               cicsWaterInBrackets(),
                               optional(
                                   sequence(
                                       token("KEYLENGTH"),
                                       cicsWaterInBrackets(),
                                       optional(
                                           token("GENERIC")
                                       )
                                   )
                               )
                           ),
                           choice(
                               token("GTEQ"),
                               token("EQUAL")
                           ),
                           choice(
                               token("UNCOMMITTED"),
                               token("CONSISTENT"),
                               token("REPEATABLE"),
                               sequence(
                                   token("UPDATE"),
                                   token("TOKEN"),
                                   cicsWaterInBrackets()
                               )
                           ),
                           token("NOSUSPEND")
                       )
                   ),
                   sequence(
                       token("READNEXT"),
                       choice(
                           token("FILE"),
                           token("DATASET")
                       ),
                       token("("),
                       fileName(),
                       token(")"),
                       permuted(
                           sequence(
                               choice(
                                   token("SYSID"),
                                   token("SYS")
                               ),
                               token("("),
                               cicsSysid(),
                               token(")")
                           ),
                           sequence(
                               choice(
                                   token("SET"),
                                   token("INTO")
                               ),
                               token("("),
                               dataArea(),
                               token(")"),
                               optional(
                                   sequence(
                                       token("LENGTH"),
                                       cicsWaterInBrackets()
                                   )
                               )
                           ),
                           sequence(
                               token("RIDFLD"),
                               cicsWaterInBrackets(),
                               optional(
                                   sequence(
                                       token("KEYLENGTH"),
                                       cicsWaterInBrackets()
                                   )
                               )
                           ),
                           choice(
                               token("RBA"),
                               token("XRBA"),
                               token("RRN")
                           ),
                           choice(
                               token("UNCOMMITTED"),
                               token("CONSISTENT"),
                               token("REPEATABLE"),
                               sequence(
                                   token("UPDATE"),
                                   token("TOKEN"),
                                   cicsWaterInBrackets()
                               )
                           ),
                           token("NOSUSPEND")
                       )
                   )
               )
           );
        }

        return cicsReadFileParser;
    }

    // ========================================================
    // cicsWriteFile
    // ........................................................

    private Parser cicsWriteFileParser = null;

    public Parser cicsWriteFile() {
        if (cicsWriteFileParser == null) {
           FutureParser future = scoped("cicsWriteFile");
           cicsWriteFileParser = future;
           future.setParser(
               sequence(
                   token("WRITE"),
                   choice(
                       token("FILE"),
                       token("DATASET")
                   ),
                   token("("),
                   fileName(),
                   token(")"),
                   permuted(
                       sequence(
                           choice(
                               token("SYSID"),
                               token("SYS")
                           ),
                           token("("),
                           cicsSysid(),
                           token(")")
                       ),
                       sequence(
                           token("FROM"),
                           token("("),
                           dataArea(),
                           token(")"),
                           optional(
                               sequence(
                                   token("LENGTH"),
                                   cicsWaterInBrackets()
                               )
                           )
                       ),
                       sequence(
                           token("RIDFLD"),
                           cicsWaterInBrackets(),
                           optional(
                               sequence(
                                   token("KEYLENGTH"),
                                   cicsWaterInBrackets()
                               )
                           )
                       ),
                       choice(
                           token("RBA"),
                           token("XRBA"),
                           token("RRN")
                       ),
                       token("MASSINSERT"),
                       token("NOSUSPEND")
                   )
               )
           );
        }

        return cicsWriteFileParser;
    }

    // ========================================================
    // cicsLink
    // ........................................................

    private Parser cicsLinkParser = null;

    public Parser cicsLink() {
        if (cicsLinkParser == null) {
           FutureParser future = scoped("cicsLink");
           cicsLinkParser = future;
           future.setParser(
               sequence(
                   token("LINK"),
                   token("PROGRAM"),
                   token("("),
                   programID(),
                   token(")"),
                   permuted(
                       sequence(
                           choice(
                               token("SYSID"),
                               token("SYS")
                           ),
                           token("("),
                           cicsSysid(),
                           token(")")
                       ),
                       sequence(
                           token("COMMAREA"),
                           token("("),
                           commareaName(),
                           token(")"),
                           optional(
                               sequence(
                                   token("LENGTH"),
                                   cicsWaterInBrackets()
                               )
                           ),
                           optional(
                               sequence(
                                   token("DATALENGTH"),
                                   cicsWaterInBrackets()
                               )
                           )
                       ),
                       token("SYNCONRETURN"),
                       sequence(
                           token("TRANSID"),
                           cicsWaterInBrackets()
                       ),
                       sequence(
                           token("INPUTMSG"),
                           cicsWaterInBrackets(),
                           optional(
                               sequence(
                                   token("INPUTMSGLEN"),
                                   cicsWaterInBrackets()
                               )
                           )
                       ),
                       sequence(
                           token("CHANNEL"),
                           cicsWaterInBrackets()
                       )
                   )
               )
           );
        }

        return cicsLinkParser;
    }

    // ========================================================
    // cicsXctl
    // ........................................................

    private Parser cicsXctlParser = null;

    public Parser cicsXctl() {
        if (cicsXctlParser == null) {
           FutureParser future = scoped("cicsXctl");
           cicsXctlParser = future;
           future.setParser(
               sequence(
                   token("XCTL"),
                   token("PROGRAM"),
                   token("("),
                   programID(),
                   token(")"),
                   permuted(
                       sequence(
                           token("COMMAREA"),
                           token("("),
                           commareaName(),
                           token(")"),
                           optional(
                               sequence(
                                   token("LENGTH"),
                                   cicsWaterInBrackets()
                               )
                           )
                       ),
                       sequence(
                           token("INPUTMSG"),
                           cicsWaterInBrackets(),
                           optional(
                               sequence(
                                   token("INPUTMSGLEN"),
                                   cicsWaterInBrackets()
                               )
                           )
                       ),
                       sequence(
                           token("CHANNEL"),
                           cicsWaterInBrackets()
                       )
                   )
               )
           );
        }

        return cicsXctlParser;
    }

    // ========================================================
    // cicsLoad
    // ........................................................

    private Parser cicsLoadParser = null;

    public Parser cicsLoad() {
        if (cicsLoadParser == null) {
           FutureParser future = scoped("cicsLoad");
           cicsLoadParser = future;
           future.setParser(
               sequence(
                   token("LOAD"),
                   token("PROGRAM"),
                   token("("),
                   programID(),
                   token(")")
               )
           );
        }

        return cicsLoadParser;
    }

    // ========================================================
    // cicsStart
    // ........................................................

    private Parser cicsStartParser = null;

    public Parser cicsStart() {
        if (cicsStartParser == null) {
           FutureParser future = scoped("cicsStart");
           cicsStartParser = future;
           future.setParser(
               sequence(
                   token("START"),
                   choice(
                       token("TRANSID"),
                       token("TR")
                   ),
                   token("("),
                   transactionName(),
                   token(")")
               )
           );
        }

        return cicsStartParser;
    }

    // ========================================================
    // cicsSysid
    // ........................................................

    private Parser cicsSysidParser = null;

    public Parser cicsSysid() {
        if (cicsSysidParser == null) {
           FutureParser future = scoped("cicsSysid");
           cicsSysidParser = future;
           future.setParser(
               choice(
                   literal(),
                   identifier()
               )
           );
        }

        return cicsSysidParser;
    }

    // ========================================================
    // queueName
    // ........................................................

    private Parser queueNameParser = null;

    public Parser queueName() {
        if (queueNameParser == null) {
           FutureParser future = scoped("queueName");
           queueNameParser = future;
           future.setParser(
               choice(
                   literal(),
                   identifier()
               )
           );
        }

        return queueNameParser;
    }

    // ========================================================
    // transactionName
    // ........................................................

    private Parser transactionNameParser = null;

    public Parser transactionName() {
        if (transactionNameParser == null) {
           FutureParser future = scoped("transactionName");
           transactionNameParser = future;
           future.setParser(
               choice(
                   literal(),
                   identifier()
               )
           );
        }

        return transactionNameParser;
    }

    // ========================================================
    // commareaName
    // ........................................................

    private Parser commareaNameParser = null;

    public Parser commareaName() {
        if (commareaNameParser == null) {
           FutureParser future = scoped("commareaName");
           commareaNameParser = future;
           future.setParser(
               choice(
                   literal(),
                   identifier()
               )
           );
        }

        return commareaNameParser;
    }

    // ========================================================
    // cicsWaterInBrackets
    // ........................................................

    private Parser cicsWaterInBracketsParser = null;

    public Parser cicsWaterInBrackets() {
        if (cicsWaterInBracketsParser == null) {
           FutureParser future = scoped("cicsWaterInBrackets");
           cicsWaterInBracketsParser = future;
           future.setParser(
               sequence(
                   token("("),
                   optional(
                       skipto(
                           token(")")
                       )
                   ),
                   token(")")
               )
           );
        }

        return cicsWaterInBracketsParser;
    }

    // ========================================================
    // exitStatement
    // ........................................................

    private Parser exitStatementParser = null;

    public Parser exitStatement() {
        if (exitStatementParser == null) {
           FutureParser future = scoped("exitStatement");
           exitStatementParser = future;
           future.setParser(
               sequence(
                   token("EXIT"),
                   optional(
                       choice(
                           token("PROGRAM"),
                           token("PARAGRAPH"),
                           token("SECTION"),
                           sequence(
                               token("PERFORM"),
                               optional(
                                   token("CYCLE")
                               )
                           )
                       )
                   )
               )
           );
        }

        return exitStatementParser;
    }

    // ========================================================
    // freeStatement
    // ........................................................

    private Parser freeStatementParser = null;

    public Parser freeStatement() {
        if (freeStatementParser == null) {
           FutureParser future = scoped("freeStatement");
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
                           identifier()
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

    public Parser gobackStatement() {
        if (gobackStatementParser == null) {
           FutureParser future = scoped("gobackStatement");
           gobackStatementParser = future;
           future.setParser(
               token("GOBACK")
           );
        }

        return gobackStatementParser;
    }

    // ========================================================
    // goToStatement
    // ........................................................

    private Parser goToStatementParser = null;

    public Parser goToStatement() {
        if (goToStatementParser == null) {
           FutureParser future = scoped("goToStatement");
           goToStatementParser = future;
           future.setParser(
               sequence(
                   token("GO"),
                   optional(
                       token("TO")
                   ),
                   optional(
                       sequence(
                           procedureName(),
                           optional(
                               sequence(
                                   star(
                                       procedureName()
                                   ),
                                   token("DEPENDING"),
                                   optional(
                                       token("ON")
                                   ),
                                   identifier()
                               )
                           )
                       )
                   )
               )
           );
        }

        return goToStatementParser;
    }

    // ========================================================
    // ifStatement
    // ........................................................

    private Parser ifStatementParser = null;

    public Parser ifStatement() {
        if (ifStatementParser == null) {
           FutureParser future = scoped("ifStatement");
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
                       sequence(
                           token("NEXT"),
                           token("SENTENCE")
                       )
                   ),
                   optional(
                       sequence(
                           token("ELSE"),
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
                       token("END-IF")
                   )
               )
           );
        }

        return ifStatementParser;
    }

    // ========================================================
    // initializeStatement
    // ........................................................

    private Parser initializeStatementParser = null;

    public Parser initializeStatement() {
        if (initializeStatementParser == null) {
           FutureParser future = scoped("initializeStatement");
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

    public Parser replacingInitClause() {
        if (replacingInitClauseParser == null) {
           FutureParser future = scoped("replacingInitClause");
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

    public Parser replacementTarget() {
        if (replacementTargetParser == null) {
           FutureParser future = scoped("replacementTarget");
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

    public Parser inspectStatement() {
        if (inspectStatementParser == null) {
           FutureParser future = scoped("inspectStatement");
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

    public Parser convertingPhrase() {
        if (convertingPhraseParser == null) {
           FutureParser future = scoped("convertingPhrase");
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

    public Parser tallyingPhrase() {
        if (tallyingPhraseParser == null) {
           FutureParser future = scoped("tallyingPhrase");
           tallyingPhraseParser = future;
           future.setParser(
               sequence(
                   token("TALLYING"),
                   star(
                       sequence(
                           identifier(),
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

    public Parser tallyingCharactersPhrase() {
        if (tallyingCharactersPhraseParser == null) {
           FutureParser future = scoped("tallyingCharactersPhrase");
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

    public Parser tallyingAllLeadingOrTrailingPhrase() {
        if (tallyingAllLeadingOrTrailingPhraseParser == null) {
           FutureParser future = scoped("tallyingAllLeadingOrTrailingPhrase");
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

    public Parser replacingPhrase() {
        if (replacingPhraseParser == null) {
           FutureParser future = scoped("replacingPhrase");
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

    public Parser replacingCharactersPhrase() {
        if (replacingCharactersPhraseParser == null) {
           FutureParser future = scoped("replacingCharactersPhrase");
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

    public Parser replacingAllLeadingFirstOrTrailingPhrase() {
        if (replacingAllLeadingFirstOrTrailingPhraseParser == null) {
           FutureParser future = scoped("replacingAllLeadingFirstOrTrailingPhrase");
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

    public Parser locationPhrase() {
        if (locationPhraseParser == null) {
           FutureParser future = scoped("locationPhrase");
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
    // moveStatement
    // ........................................................

    private Parser moveStatementParser = null;

    public Parser moveStatement() {
        if (moveStatementParser == null) {
           FutureParser future = scoped("moveStatement");
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

    public Parser multiplyStatement() {
        if (multiplyStatementParser == null) {
           FutureParser future = scoped("multiplyStatement");
           multiplyStatementParser = future;
           future.setParser(
               sequence(
                   token("MULTIPLY"),
                   choice(
                       multiplication_format1(),
                       multiplication_format2()
                   ),
                   optional(
                       sequence(
                           optional(
                               token("ON")
                           ),
                           token("SIZE"),
                           token("ERROR"),
                           nestedStatements()
                       )
                   ),
                   optional(
                       sequence(
                           token("NOT"),
                           optional(
                               token("ON")
                           ),
                           token("SIZE"),
                           token("ERROR"),
                           nestedStatements()
                       )
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

    public Parser multiplication_format1() {
        if (multiplication_format1Parser == null) {
           FutureParser future = scoped("multiplication_format1");
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
                           identifier(),
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

    public Parser multiplication_format2() {
        if (multiplication_format2Parser == null) {
           FutureParser future = scoped("multiplication_format2");
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
                           identifier(),
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
    // openStatement
    // ........................................................

    private Parser openStatementParser = null;

    public Parser openStatement() {
        if (openStatementParser == null) {
           FutureParser future = scoped("openStatement");
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

    public Parser performStatement() {
        if (performStatementParser == null) {
           FutureParser future = scoped("performStatement");
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
                           optional(
                               nestedStatements()
                           ),
                           token("END-PERFORM")
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

    private Parser timesParser = null;

    public Parser times() {
        if (timesParser == null) {
           FutureParser future = scoped("times");
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
    // until
    // ........................................................

    private Parser untilParser = null;

    public Parser until() {
        if (untilParser == null) {
           FutureParser future = scoped("until");
           untilParser = future;
           future.setParser(
               sequence(
                   optional(
                       testPosition()
                   ),
                   token("UNTIL"),
                   condition()
               )
           );
        }

        return untilParser;
    }

    // ========================================================
    // testPosition
    // ........................................................

    private Parser testPositionParser = null;

    public Parser testPosition() {
        if (testPositionParser == null) {
           FutureParser future = scoped("testPosition");
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
    // varying
    // ........................................................

    private Parser varyingParser = null;

    public Parser varying() {
        if (varyingParser == null) {
           FutureParser future = scoped("varying");
           varyingParser = future;
           future.setParser(
               sequence(
                   optional(
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
    // readStatement
    // ........................................................

    private Parser readStatementParser = null;

    public Parser readStatement() {
        if (readStatementParser == null) {
           FutureParser future = scoped("readStatement");
           readStatementParser = future;
           future.setParser(
               sequence(
                   token("READ"),
                   fileName(),
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
                           identifier()
                       )
                   ),
                   optional(
                       sequence(
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
                               token("AT")
                           ),
                           token("END"),
                           nestedStatements()
                       )
                   ),
                   optional(
                       sequence(
                           token("NOT"),
                           optional(
                               token("AT")
                           ),
                           token("END"),
                           nestedStatements()
                       )
                   ),
                   optional(
                       sequence(
                           token("INVALID"),
                           optional(
                               token("KEY")
                           ),
                           nestedStatements()
                       )
                   ),
                   optional(
                       sequence(
                           token("NOT"),
                           token("INVALID"),
                           optional(
                               token("KEY")
                           ),
                           nestedStatements()
                       )
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
    // releaseStatement
    // ........................................................

    private Parser releaseStatementParser = null;

    public Parser releaseStatement() {
        if (releaseStatementParser == null) {
           FutureParser future = scoped("releaseStatement");
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
    // returnStatement
    // ........................................................

    private Parser returnStatementParser = null;

    public Parser returnStatement() {
        if (returnStatementParser == null) {
           FutureParser future = scoped("returnStatement");
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

    public Parser rewriteStatement() {
        if (rewriteStatementParser == null) {
           FutureParser future = scoped("rewriteStatement");
           rewriteStatementParser = future;
           future.setParser(
               sequence(
                   token("REWRITE"),
                   recordName(),
                   optional(
                       sequence(
                           token("FROM"),
                           identifier()
                       )
                   ),
                   optional(
                       sequence(
                           token("INVALID"),
                           optional(
                               token("KEY")
                           ),
                           nestedStatements()
                       )
                   ),
                   optional(
                       sequence(
                           token("NOT"),
                           token("INVALID"),
                           optional(
                               token("KEY")
                           ),
                           nestedStatements()
                       )
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
    // searchStatement
    // ........................................................

    private Parser searchStatementParser = null;

    public Parser searchStatement() {
        if (searchStatementParser == null) {
           FutureParser future = scoped("searchStatement");
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

    public Parser atEnd() {
        if (atEndParser == null) {
           FutureParser future = scoped("atEnd");
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

    public Parser notAtEnd() {
        if (notAtEndParser == null) {
           FutureParser future = scoped("notAtEnd");
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
    // setStatement
    // ........................................................

    private Parser setStatementParser = null;

    public Parser setStatement() {
        if (setStatementParser == null) {
           FutureParser future = scoped("setStatement");
           setStatementParser = future;
           future.setParser(
               sequence(
                   token("SET"),
                   choice(
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

    public Parser setFormat1() {
        if (setFormat1Parser == null) {
           FutureParser future = scoped("setFormat1");
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

    public Parser setFormat2() {
        if (setFormat2Parser == null) {
           FutureParser future = scoped("setFormat2");
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

    public Parser setFormat3() {
        if (setFormat3Parser == null) {
           FutureParser future = scoped("setFormat3");
           setFormat3Parser = future;
           future.setParser(
               sequence(
                   plus(
                       identifier()
                   ),
                   token("TO"),
                   token("TRUE")
               )
           );
        }

        return setFormat3Parser;
    }

    // ========================================================
    // startStatement
    // ........................................................

    private Parser startStatementParser = null;

    public Parser startStatement() {
        if (startStatementParser == null) {
           FutureParser future = scoped("startStatement");
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
                       sequence(
                           token("INVALID"),
                           optional(
                               token("KEY")
                           ),
                           nestedStatements()
                       )
                   ),
                   optional(
                       sequence(
                           token("NOT"),
                           token("INVALID"),
                           optional(
                               token("KEY")
                           ),
                           nestedStatements()
                       )
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

    public Parser keyModifier() {
        if (keyModifierParser == null) {
           FutureParser future = scoped("keyModifier");
           keyModifierParser = future;
           future.setParser(
               sequence(
                   token("KEY"),
                   optional(
                       token("IS")
                   ),
                   choice(
                       generalRelationOp(),
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

    public Parser sizeModifier() {
        if (sizeModifierParser == null) {
           FutureParser future = scoped("sizeModifier");
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

    public Parser whileKeyModifier() {
        if (whileKeyModifierParser == null) {
           FutureParser future = scoped("whileKeyModifier");
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
                       negationOp()
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

    public Parser likeMods() {
        if (likeModsParser == null) {
           FutureParser future = scoped("likeMods");
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

    public Parser trimmedRight() {
        if (trimmedRightParser == null) {
           FutureParser future = scoped("trimmedRight");
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

    public Parser trimmedLeft() {
        if (trimmedLeftParser == null) {
           FutureParser future = scoped("trimmedLeft");
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

    public Parser caseSensitive() {
        if (caseSensitiveParser == null) {
           FutureParser future = scoped("caseSensitive");
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

    public Parser caseInsensitive() {
        if (caseInsensitiveParser == null) {
           FutureParser future = scoped("caseInsensitive");
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

    public Parser stopStatement() {
        if (stopStatementParser == null) {
           FutureParser future = scoped("stopStatement");
           stopStatementParser = future;
           future.setParser(
               sequence(
                   token("STOP"),
                   choice(
                       token("RUN"),
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

    public Parser stringStatement() {
        if (stringStatementParser == null) {
           FutureParser future = scoped("stringStatement");
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
                       sequence(
                           optional(
                               token("ON")
                           ),
                           token("OVERFLOW"),
                           nestedStatements()
                       )
                   ),
                   optional(
                       sequence(
                           token("NOT"),
                           optional(
                               token("ON")
                           ),
                           token("OVERFLOW"),
                           nestedStatements()
                       )
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

    public Parser subtractStatement() {
        if (subtractStatementParser == null) {
           FutureParser future = scoped("subtractStatement");
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
                       sequence(
                           optional(
                               token("ON")
                           ),
                           token("SIZE"),
                           token("ERROR"),
                           nestedStatements()
                       )
                   ),
                   optional(
                       sequence(
                           token("NOT"),
                           optional(
                               token("ON")
                           ),
                           token("SIZE"),
                           token("ERROR"),
                           nestedStatements()
                       )
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

    public Parser subtraction_format1() {
        if (subtraction_format1Parser == null) {
           FutureParser future = scoped("subtraction_format1");
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

    public Parser subtraction_format2() {
        if (subtraction_format2Parser == null) {
           FutureParser future = scoped("subtraction_format2");
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

    public Parser subtraction_format3() {
        if (subtraction_format3Parser == null) {
           FutureParser future = scoped("subtraction_format3");
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
    // unstringStatement
    // ........................................................

    private Parser unstringStatementParser = null;

    public Parser unstringStatement() {
        if (unstringStatementParser == null) {
           FutureParser future = scoped("unstringStatement");
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
                       sequence(
                           optional(
                               token("ON")
                           ),
                           token("OVERFLOW"),
                           nestedStatements()
                       )
                   ),
                   optional(
                       sequence(
                           token("NOT"),
                           optional(
                               token("ON")
                           ),
                           token("OVERFLOW"),
                           nestedStatements()
                       )
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

    public Parser useStatement() {
        if (useStatementParser == null) {
           FutureParser future = scoped("useStatement");
           useStatementParser = future;
           future.setParser(
               sequence(
                   token("USE"),
                   choice(
                       errorDeclarative(),
                       debugOnAllDeclarative(),
                       debugDeclarative(),
                       labelDeclarative()
                   ),
                   token(".")
               )
           );
        }

        return useStatementParser;
    }

    // ========================================================
    // errorDeclarative
    // ........................................................

    private Parser errorDeclarativeParser = null;

    public Parser errorDeclarative() {
        if (errorDeclarativeParser == null) {
           FutureParser future = scoped("errorDeclarative");
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
                   star(
                       choice(
                           token("INPUT"),
                           token("OUTPUT"),
                           token("I-O"),
                           token("EXTEND"),
                           fileName()
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

    public Parser debugDeclarative() {
        if (debugDeclarativeParser == null) {
           FutureParser future = scoped("debugDeclarative");
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
                           procedureName(),
                           fileName(),
                           sequence(
                               optional(
                                   sequence(
                                       token("ALL"),
                                       optional(
                                           sequence(
                                               token("REFERENCES"),
                                               token("OF")
                                           )
                                       )
                                   )
                               ),
                               identifier()
                           )
                       )
                   )
               )
           );
        }

        return debugDeclarativeParser;
    }

    // ========================================================
    // debugOnAllDeclarative
    // ........................................................

    private Parser debugOnAllDeclarativeParser = null;

    public Parser debugOnAllDeclarative() {
        if (debugOnAllDeclarativeParser == null) {
           FutureParser future = scoped("debugOnAllDeclarative");
           debugOnAllDeclarativeParser = future;
           future.setParser(
               sequence(
                   optional(
                       token("FOR")
                   ),
                   token("DEBUGGING"),
                   optional(
                       token("ON")
                   ),
                   token("ALL"),
                   token("PROCEDURES")
               )
           );
        }

        return debugOnAllDeclarativeParser;
    }

    // ========================================================
    // labelDeclarative
    // ........................................................

    private Parser labelDeclarativeParser = null;

    public Parser labelDeclarative() {
        if (labelDeclarativeParser == null) {
           FutureParser future = scoped("labelDeclarative");
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
                   star(
                       choice(
                           token("INPUT"),
                           token("OUTPUT"),
                           token("I-O"),
                           token("EXTEND"),
                           fileName()
                       )
                   )
               )
           );
        }

        return labelDeclarativeParser;
    }

    // ========================================================
    // writeStatement
    // ........................................................

    private Parser writeStatementParser = null;

    public Parser writeStatement() {
        if (writeStatementParser == null) {
           FutureParser future = scoped("writeStatement");
           writeStatementParser = future;
           future.setParser(
               sequence(
                   token("WRITE"),
                   recordName(),
                   optional(
                       sequence(
                           token("FROM"),
                           identifier()
                       )
                   ),
                   optional(
                       sequence(
                           choice(
                               token("AFTER"),
                               token("BEFORE")
                           ),
                           optional(
                               token("ADVANCING")
                           ),
                           choice(
                               sequence(
                                   choice(
                                       identifier(),
                                       integer(),
                                       token("ZERO")
                                   ),
                                   optional(
                                       choice(
                                           token("LINE"),
                                           token("LINES")
                                       )
                                   )
                               ),
                               mnemonicName(),
                               token("PAGE")
                           )
                       )
                   ),
                   optional(
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
                   ),
                   optional(
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
                   ),
                   optional(
                       sequence(
                           token("INVALID"),
                           optional(
                               token("KEY")
                           ),
                           nestedStatements()
                       )
                   ),
                   optional(
                       sequence(
                           token("NOT"),
                           token("INVALID"),
                           optional(
                               token("KEY")
                           ),
                           nestedStatements()
                       )
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
    // copyStatement
    // ........................................................

    private Parser copyStatementParser = null;

    public Parser copyStatement() {
        if (copyStatementParser == null) {
           FutureParser future = scoped("copyStatement");
           copyStatementParser = future;
           future.setParser(
               sequence(
                   token("COPY"),
                   textName(),
                   optional(
                       sequence(
                           choice(
                               token("OF"),
                               token("IN")
                           ),
                           libraryName()
                       )
                   ),
                   optional(
                       token("SUPPRESS")
                   ),
                   optional(
                       copyReplacingPhrase()
                   ),
                   token(".")
               )
           );
        }

        return copyStatementParser;
    }

    // ========================================================
    // copyReplacingPhrase
    // ........................................................

    private Parser copyReplacingPhraseParser = null;

    public Parser copyReplacingPhrase() {
        if (copyReplacingPhraseParser == null) {
           FutureParser future = scoped("copyReplacingPhrase");
           copyReplacingPhraseParser = future;
           future.setParser(
               sequence(
                   token("REPLACING"),
                   plus(
                       copyReplacementInstruction()
                   )
               )
           );
        }

        return copyReplacingPhraseParser;
    }

    // ========================================================
    // copyReplacementInstruction
    // ........................................................

    private Parser copyReplacementInstructionParser = null;

    public Parser copyReplacementInstruction() {
        if (copyReplacementInstructionParser == null) {
           FutureParser future = scoped("copyReplacementInstruction");
           copyReplacementInstructionParser = future;
           future.setParser(
               sequence(
                   copyOperandName(),
                   token("BY"),
                   copyOperandName()
               )
           );
        }

        return copyReplacementInstructionParser;
    }

    // ========================================================
    // copyOperandName
    // ........................................................

    private Parser copyOperandNameParser = null;

    public Parser copyOperandName() {
        if (copyOperandNameParser == null) {
           FutureParser future = scoped("copyOperandName");
           copyOperandNameParser = future;
           future.setParser(
               choice(
                   pseudoLiteral(),
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

    public Parser replaceStatement() {
        if (replaceStatementParser == null) {
           FutureParser future = scoped("replaceStatement");
           replaceStatementParser = future;
           future.setParser(
               sequence(
                   token("REPLACE"),
                   skipto(
                       token(".")
                   ),
                   token(".")
               )
           );
        }

        return replaceStatementParser;
    }

    // ========================================================
    // divisionStart
    // ........................................................

    private Parser divisionStartParser = null;

    public Parser divisionStart() {
        if (divisionStartParser == null) {
           FutureParser future = scoped("divisionStart");
           divisionStartParser = future;
           future.setParser(
               sequence(
                   choice(
                       sequence(
                           token("IDENTIFICATION"),
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
                               returningPhrase()
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
    // dataSectionStart
    // ........................................................

    private Parser dataSectionStartParser = null;

    public Parser dataSectionStart() {
        if (dataSectionStartParser == null) {
           FutureParser future = scoped("dataSectionStart");
           dataSectionStartParser = future;
           future.setParser(
               sequence(
                   choice(
                       token("FILE"),
                       token("WORKING-STORAGE"),
                       token("LINKAGE"),
                       token("COMMUNICATION"),
                       token("REPORT")
                   ),
                   token("SECTION"),
                   token(".")
               )
           );
        }

        return dataSectionStartParser;
    }

    // ========================================================
    // endOfStatement
    // ........................................................

    private Parser endOfStatementParser = null;

    public Parser endOfStatement() {
        if (endOfStatementParser == null) {
           FutureParser future = scoped("endOfStatement");
           endOfStatementParser = future;
           future.setParser(
               choice(
                   verb(),
                   token("ELSE"),
                   token("WHEN"),
                   token("END-ACCEPT"),
                   token("END-ADD"),
                   token("END-CALL"),
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
                   token("END-RETURN"),
                   token("END-REWRITE"),
                   token("END-SEARCH"),
                   token("END-START"),
                   token("END-STRING"),
                   token("END-SUBTRACT"),
                   token("END-UNSTRING"),
                   token("END-WRITE"),
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
    // identifier
    // ........................................................

    private Parser identifierParser = null;

    public Parser identifier() {
        if (identifierParser == null) {
           FutureParser future = scoped("identifier");
           identifierParser = future;
           future.setParser(
               choice(
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

    public Parser identifier_format1() {
        if (identifier_format1Parser == null) {
           FutureParser future = scoped("identifier_format1");
           identifier_format1Parser = future;
           future.setParser(
               sequence(
                   token("FUNCTION"),
                   functionName(),
                   optional(
                       sequence(
                           token("("),
                           plus(
                               argument()
                           ),
                           token(")")
                       )
                   ),
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

    public Parser identifier_format2() {
        if (identifier_format2Parser == null) {
           FutureParser future = scoped("identifier_format2");
           identifier_format2Parser = future;
           future.setParser(
               sequence(
                   dataName(),
                   star(
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
                   ),
                   optional(
                       referenceModifier()
                   )
               )
           );
        }

        return identifier_format2Parser;
    }

    // ========================================================
    // dataAddressIdentifier
    // ........................................................

    private Parser dataAddressIdentifierParser = null;

    public Parser dataAddressIdentifier() {
        if (dataAddressIdentifierParser == null) {
           FutureParser future = scoped("dataAddressIdentifier");
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

    public Parser argument() {
        if (argumentParser == null) {
           FutureParser future = scoped("argument");
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

    public Parser qualifier() {
        if (qualifierParser == null) {
           FutureParser future = scoped("qualifier");
           qualifierParser = future;
           future.setParser(
               sequence(
                   choice(
                       token("IN"),
                       token("OF")
                   ),
                   dataName()
               )
           );
        }

        return qualifierParser;
    }

    // ========================================================
    // subscript
    // ........................................................

    private Parser subscriptParser = null;

    public Parser subscript() {
        if (subscriptParser == null) {
           FutureParser future = scoped("subscript");
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

    public Parser directSubscript() {
        if (directSubscriptParser == null) {
           FutureParser future = scoped("directSubscript");
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

    public Parser relativeSubscript() {
        if (relativeSubscriptParser == null) {
           FutureParser future = scoped("relativeSubscript");
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

    public Parser referenceModifier() {
        if (referenceModifierParser == null) {
           FutureParser future = scoped("referenceModifier");
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

    public Parser arithmeticExpression() {
        if (arithmeticExpressionParser == null) {
           FutureParser future = scoped("arithmeticExpression");
           arithmeticExpressionParser = future;
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

        return arithmeticExpressionParser;
    }

    // ========================================================
    // signDef
    // ........................................................

    private Parser signDefParser = null;

    public Parser signDef() {
        if (signDefParser == null) {
           FutureParser future = scoped("signDef");
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

    public Parser summand() {
        if (summandParser == null) {
           FutureParser future = scoped("summand");
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
    // factor
    // ........................................................

    private Parser factorParser = null;

    public Parser factor() {
        if (factorParser == null) {
           FutureParser future = scoped("factor");
           factorParser = future;
           future.setParser(
               sequence(
                   optional(
                       signDef()
                   ),
                   atomicExpression(),
                   star(
                       sequence(
                           token("**"),
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

    public Parser atomicExpression() {
        if (atomicExpressionParser == null) {
           FutureParser future = scoped("atomicExpression");
           atomicExpressionParser = future;
           future.setParser(
               choice(
                   token("ZERO"),
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

    public Parser condition() {
        if (conditionParser == null) {
           FutureParser future = scoped("condition");
           conditionParser = future;
           future.setParser(
               sequence(
                   choice(
                       primaryCondition(),
                       sequence(
                           optional(
                               negationOp()
                           ),
                           token("("),
                           condition(),
                           token(")")
                       )
                   ),
                   star(
                       sequence(
                           conditionalRelationOP(),
                           choice(
                               primaryCondition(),
                               sequence(
                                   optional(
                                       negationOp()
                                   ),
                                   token("("),
                                   condition(),
                                   token(")")
                               )
                           )
                       )
                   )
               )
           );
        }

        return conditionParser;
    }

    // ========================================================
    // primaryCondition
    // ........................................................

    private Parser primaryConditionParser = null;

    public Parser primaryCondition() {
        if (primaryConditionParser == null) {
           FutureParser future = scoped("primaryCondition");
           primaryConditionParser = future;
           future.setParser(
               sequence(
                   optional(
                       negationOp()
                   ),
                   primaryCondDef()
               )
           );
        }

        return primaryConditionParser;
    }

    // ========================================================
    // primaryCondDef
    // ........................................................

    private Parser primaryCondDefParser = null;

    public Parser primaryCondDef() {
        if (primaryCondDefParser == null) {
           FutureParser future = scoped("primaryCondDef");
           primaryCondDefParser = future;
           future.setParser(
               choice(
                   booleanLiteral(),
                   sequence(
                       classPrimaryCondition(),
                       star(
                           sequence(
                               conditionalRelationOP(),
                               optional(
                                   negationOp()
                               ),
                               classSecondaryCondition()
                           )
                       )
                   ),
                   signPrimaryCondition(),
                   sequence(
                       generalPrimaryCondition(),
                       star(
                           sequence(
                               conditionalRelationOP(),
                               optional(
                                   negationOp()
                               ),
                               generalSecondaryCondition(),
                               not(
                                   choice(
                                       generalRelationOp(),
                                       token("IS"),
                                       sequence(
                                           optional(
                                               token("NOT")
                                           ),
                                           classType()
                                       ),
                                       signType()
                                   )
                               )
                           )
                       )
                   ),
                   sequence(
                       monoElemPrimaryCondition(),
                       star(
                           sequence(
                               optional(
                                   token("IS")
                               ),
                               optional(
                                   negationOp()
                               ),
                               monoElemPrimaryCondition()
                           )
                       )
                   )
               )
           );
        }

        return primaryCondDefParser;
    }

    // ========================================================
    // generalPrimaryCondition
    // ........................................................

    private Parser generalPrimaryConditionParser = null;

    public Parser generalPrimaryCondition() {
        if (generalPrimaryConditionParser == null) {
           FutureParser future = scoped("generalPrimaryCondition");
           generalPrimaryConditionParser = future;
           future.setParser(
               sequence(
                   operand(),
                   generalRelationOp(),
                   operand()
               )
           );
        }

        return generalPrimaryConditionParser;
    }

    // ========================================================
    // signPrimaryCondition
    // ........................................................

    private Parser signPrimaryConditionParser = null;

    public Parser signPrimaryCondition() {
        if (signPrimaryConditionParser == null) {
           FutureParser future = scoped("signPrimaryCondition");
           signPrimaryConditionParser = future;
           future.setParser(
               sequence(
                   choice(
                       arithmeticExpression(),
                       identifier()
                   ),
                   optional(
                       token("IS")
                   ),
                   optional(
                       negationOp()
                   ),
                   signType()
               )
           );
        }

        return signPrimaryConditionParser;
    }

    // ========================================================
    // signType
    // ........................................................

    private Parser signTypeParser = null;

    public Parser signType() {
        if (signTypeParser == null) {
           FutureParser future = scoped("signType");
           signTypeParser = future;
           future.setParser(
               choice(
                   token("POSITIVE"),
                   token("NEGATIVE"),
                   token("ZERO")
               )
           );
        }

        return signTypeParser;
    }

    // ========================================================
    // monoElemPrimaryCondition
    // ........................................................

    private Parser monoElemPrimaryConditionParser = null;

    public Parser monoElemPrimaryCondition() {
        if (monoElemPrimaryConditionParser == null) {
           FutureParser future = scoped("monoElemPrimaryCondition");
           monoElemPrimaryConditionParser = future;
           future.setParser(
               sequence(
                   optional(
                       token("IS")
                   ),
                   choice(
                       conditionName(),
                       className()
                   )
               )
           );
        }

        return monoElemPrimaryConditionParser;
    }

    // ========================================================
    // classPrimaryCondition
    // ........................................................

    private Parser classPrimaryConditionParser = null;

    public Parser classPrimaryCondition() {
        if (classPrimaryConditionParser == null) {
           FutureParser future = scoped("classPrimaryCondition");
           classPrimaryConditionParser = future;
           future.setParser(
               sequence(
                   identifier(),
                   optional(
                       token("IS")
                   ),
                   optional(
                       negationOp()
                   ),
                   classType()
               )
           );
        }

        return classPrimaryConditionParser;
    }

    // ========================================================
    // classType
    // ........................................................

    private Parser classTypeParser = null;

    public Parser classType() {
        if (classTypeParser == null) {
           FutureParser future = scoped("classType");
           classTypeParser = future;
           future.setParser(
               choice(
                   token("NUMERIC"),
                   token("ALPHABETIC"),
                   token("ALPHABETIC-LOWER"),
                   token("ALPHABETIC-UPPER"),
                   token("DBCS"),
                   token("KANJI")
               )
           );
        }

        return classTypeParser;
    }

    // ========================================================
    // generalSecondaryCondition
    // ........................................................

    private Parser generalSecondaryConditionParser = null;

    public Parser generalSecondaryCondition() {
        if (generalSecondaryConditionParser == null) {
           FutureParser future = scoped("generalSecondaryCondition");
           generalSecondaryConditionParser = future;
           future.setParser(
               sequence(
                   optional(
                       generalRelationOp()
                   ),
                   operand()
               )
           );
        }

        return generalSecondaryConditionParser;
    }

    // ========================================================
    // classSecondaryCondition
    // ........................................................

    private Parser classSecondaryConditionParser = null;

    public Parser classSecondaryCondition() {
        if (classSecondaryConditionParser == null) {
           FutureParser future = scoped("classSecondaryCondition");
           classSecondaryConditionParser = future;
           future.setParser(
               sequence(
                   optional(
                       token("IS")
                   ),
                   optional(
                       negationOp()
                   ),
                   classType()
               )
           );
        }

        return classSecondaryConditionParser;
    }

    // ========================================================
    // conditionalRelationOP
    // ........................................................

    private Parser conditionalRelationOPParser = null;

    public Parser conditionalRelationOP() {
        if (conditionalRelationOPParser == null) {
           FutureParser future = scoped("conditionalRelationOP");
           conditionalRelationOPParser = future;
           future.setParser(
               choice(
                   token("AND"),
                   token("OR")
               )
           );
        }

        return conditionalRelationOPParser;
    }

    // ========================================================
    // generalRelationOp
    // ........................................................

    private Parser generalRelationOpParser = null;

    public Parser generalRelationOp() {
        if (generalRelationOpParser == null) {
           FutureParser future = scoped("generalRelationOp");
           generalRelationOpParser = future;
           future.setParser(
               sequence(
                   optional(
                       token("IS")
                   ),
                   choice(
                       greaterOrEqualOp(),
                       lessOrEqualOp(),
                       greaterThanOp(),
                       notGreaterThanOp(),
                       lessThanOp(),
                       notLessThanOp(),
                       equalToOp(),
                       notEqualToOp()
                   )
               )
           );
        }

        return generalRelationOpParser;
    }

    // ========================================================
    // negationOp
    // ........................................................

    private Parser negationOpParser = null;

    public Parser negationOp() {
        if (negationOpParser == null) {
           FutureParser future = scoped("negationOp");
           negationOpParser = future;
           future.setParser(
               token("NOT")
           );
        }

        return negationOpParser;
    }

    // ========================================================
    // greaterThanOp
    // ........................................................

    private Parser greaterThanOpParser = null;

    public Parser greaterThanOp() {
        if (greaterThanOpParser == null) {
           FutureParser future = scoped("greaterThanOp");
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
    // notGreaterThanOp
    // ........................................................

    private Parser notGreaterThanOpParser = null;

    public Parser notGreaterThanOp() {
        if (notGreaterThanOpParser == null) {
           FutureParser future = scoped("notGreaterThanOp");
           notGreaterThanOpParser = future;
           future.setParser(
               sequence(
                   token("NOT"),
                   choice(
                       sequence(
                           token("GREATER"),
                           optional(
                               token("THAN")
                           )
                       ),
                       token(">")
                   )
               )
           );
        }

        return notGreaterThanOpParser;
    }

    // ========================================================
    // lessThanOp
    // ........................................................

    private Parser lessThanOpParser = null;

    public Parser lessThanOp() {
        if (lessThanOpParser == null) {
           FutureParser future = scoped("lessThanOp");
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
    // notLessThanOp
    // ........................................................

    private Parser notLessThanOpParser = null;

    public Parser notLessThanOp() {
        if (notLessThanOpParser == null) {
           FutureParser future = scoped("notLessThanOp");
           notLessThanOpParser = future;
           future.setParser(
               sequence(
                   token("NOT"),
                   choice(
                       sequence(
                           token("LESS"),
                           optional(
                               token("THAN")
                           )
                       ),
                       token("<")
                   )
               )
           );
        }

        return notLessThanOpParser;
    }

    // ========================================================
    // equalToOp
    // ........................................................

    private Parser equalToOpParser = null;

    public Parser equalToOp() {
        if (equalToOpParser == null) {
           FutureParser future = scoped("equalToOp");
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
    // notEqualToOp
    // ........................................................

    private Parser notEqualToOpParser = null;

    public Parser notEqualToOp() {
        if (notEqualToOpParser == null) {
           FutureParser future = scoped("notEqualToOp");
           notEqualToOpParser = future;
           future.setParser(
               sequence(
                   token("NOT"),
                   choice(
                       sequence(
                           token("EQUAL"),
                           optional(
                               token("TO")
                           )
                       ),
                       token("=")
                   )
               )
           );
        }

        return notEqualToOpParser;
    }

    // ========================================================
    // greaterOrEqualOp
    // ........................................................

    private Parser greaterOrEqualOpParser = null;

    public Parser greaterOrEqualOp() {
        if (greaterOrEqualOpParser == null) {
           FutureParser future = scoped("greaterOrEqualOp");
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

    public Parser lessOrEqualOp() {
        if (lessOrEqualOpParser == null) {
           FutureParser future = scoped("lessOrEqualOp");
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

    public Parser programName() {
        if (programNameParser == null) {
           FutureParser future = scoped("programName");
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

    public Parser dataName() {
        if (dataNameParser == null) {
           FutureParser future = scoped("dataName");
           dataNameParser = future;
           future.setParser(
               choice(
                   cobolWord(),
                   token("FILLER"),
                   token("CURSOR")
               )
           );
        }

        return dataNameParser;
    }

    // ========================================================
    // sectionName
    // ........................................................

    private Parser sectionNameParser = null;

    public Parser sectionName() {
        if (sectionNameParser == null) {
           FutureParser future = scoped("sectionName");
           sectionNameParser = future;
           future.setParser(
               choice(
                   cobolWord(),
                   integer()
               )
           );
        }

        return sectionNameParser;
    }

    // ========================================================
    // paragraphName
    // ........................................................

    private Parser paragraphNameParser = null;

    public Parser paragraphName() {
        if (paragraphNameParser == null) {
           FutureParser future = scoped("paragraphName");
           paragraphNameParser = future;
           future.setParser(
               choice(
                   cobolWord(),
                   integer()
               )
           );
        }

        return paragraphNameParser;
    }

    // ========================================================
    // procedureName
    // ........................................................

    private Parser procedureNameParser = null;

    public Parser procedureName() {
        if (procedureNameParser == null) {
           FutureParser future = scoped("procedureName");
           procedureNameParser = future;
           future.setParser(
               sequence(
                   choice(
                       cobolWord(),
                       integer()
                   ),
                   optional(
                       sequence(
                           choice(
                               token("IN"),
                               token("OF")
                           ),
                           cobolWord()
                       )
                   )
               )
           );
        }

        return procedureNameParser;
    }

    // ========================================================
    // segmentNumber
    // ........................................................

    private Parser segmentNumberParser = null;

    public Parser segmentNumber() {
        if (segmentNumberParser == null) {
           FutureParser future = scoped("segmentNumber");
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

    public Parser operand() {
        if (operandParser == null) {
           FutureParser future = scoped("operand");
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
    // conditionName
    // ........................................................

    private Parser conditionNameParser = null;

    public Parser conditionName() {
        if (conditionNameParser == null) {
           FutureParser future = scoped("conditionName");
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

    public Parser indexName() {
        if (indexNameParser == null) {
           FutureParser future = scoped("indexName");
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

    public Parser className() {
        if (classNameParser == null) {
           FutureParser future = scoped("className");
           classNameParser = future;
           future.setParser(
               cobolWord()
           );
        }

        return classNameParser;
    }

    // ========================================================
    // fileName
    // ........................................................

    private Parser fileNameParser = null;

    public Parser fileName() {
        if (fileNameParser == null) {
           FutureParser future = scoped("fileName");
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

    public Parser computerName() {
        if (computerNameParser == null) {
           FutureParser future = scoped("computerName");
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

    public Parser functionName() {
        if (functionNameParser == null) {
           FutureParser future = scoped("functionName");
           functionNameParser = future;
           future.setParser(
               cobolWord()
           );
        }

        return functionNameParser;
    }

    // ========================================================
    // textName
    // ........................................................

    private Parser textNameParser = null;

    public Parser textName() {
        if (textNameParser == null) {
           FutureParser future = scoped("textName");
           textNameParser = future;
           future.setParser(
               choice(
                   cobolWord(),
                   alphanumeric()
               )
           );
        }

        return textNameParser;
    }

    // ========================================================
    // libraryName
    // ........................................................

    private Parser libraryNameParser = null;

    public Parser libraryName() {
        if (libraryNameParser == null) {
           FutureParser future = scoped("libraryName");
           libraryNameParser = future;
           future.setParser(
               cobolWord()
           );
        }

        return libraryNameParser;
    }

    // ========================================================
    // recordName
    // ........................................................

    private Parser recordNameParser = null;

    public Parser recordName() {
        if (recordNameParser == null) {
           FutureParser future = scoped("recordName");
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

    public Parser mnemonicName() {
        if (mnemonicNameParser == null) {
           FutureParser future = scoped("mnemonicName");
           mnemonicNameParser = future;
           future.setParser(
               choice(
                   cobolWord(),
                   identifier()
               )
           );
        }

        return mnemonicNameParser;
    }

    // ========================================================
    // environmentName
    // ........................................................

    private Parser environmentNameParser = null;

    public Parser environmentName() {
        if (environmentNameParser == null) {
           FutureParser future = scoped("environmentName");
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

    public Parser alphabetName() {
        if (alphabetNameParser == null) {
           FutureParser future = scoped("alphabetName");
           alphabetNameParser = future;
           future.setParser(
               cobolWord()
           );
        }

        return alphabetNameParser;
    }

    // ========================================================
    // reportName
    // ........................................................

    private Parser reportNameParser = null;

    public Parser reportName() {
        if (reportNameParser == null) {
           FutureParser future = scoped("reportName");
           reportNameParser = future;
           future.setParser(
               cobolWord()
           );
        }

        return reportNameParser;
    }

    // ========================================================
    // assignmentName
    // ........................................................

    private Parser assignmentNameParser = null;

    public Parser assignmentName() {
        if (assignmentNameParser == null) {
           FutureParser future = scoped("assignmentName");
           assignmentNameParser = future;
           future.setParser(
               choice(
                   cobolWord(),
                   literal()
               )
           );
        }

        return assignmentNameParser;
    }

    // ========================================================
    // literal
    // ........................................................

    private Parser literalParser = null;

    public Parser literal() {
        if (literalParser == null) {
           FutureParser future = scoped("literal");
           literalParser = future;
           future.setParser(
               choice(
                   numericLiteral(),
                   alphanumericLiteral(),
                   figurativeConstant(),
                   booleanLiteral()
               )
           );
        }

        return literalParser;
    }

    // ========================================================
    // value
    // ........................................................

    private Parser valueParser = null;

    public Parser value() {
        if (valueParser == null) {
           FutureParser future = scoped("value");
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
    // booleanLiteral
    // ........................................................

    private Parser booleanLiteralParser = null;

    public Parser booleanLiteral() {
        if (booleanLiteralParser == null) {
           FutureParser future = scoped("booleanLiteral");
           booleanLiteralParser = future;
           future.setParser(
               choice(
                   token("TRUE"),
                   token("FALSE")
               )
           );
        }

        return booleanLiteralParser;
    }

    // ========================================================
    // figurativeConstant
    // ........................................................

    private Parser figurativeConstantParser = null;

    public Parser figurativeConstant() {
        if (figurativeConstantParser == null) {
           FutureParser future = scoped("figurativeConstant");
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
                           token("ZERO"),
                           token("ZEROS"),
                           token("ZEROES"),
                           token("SPACE"),
                           token("SPACES"),
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

    public Parser numericLiteral() {
        if (numericLiteralParser == null) {
           FutureParser future = scoped("numericLiteral");
           numericLiteralParser = future;
           future.setParser(
               choice(
                   integerLiteral(),
                   decimal(),
                   hexadecimal(),
                   sequence(
                       token("LENGTH"),
                       token("OF"),
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

    public Parser numeric() {
        if (numericParser == null) {
           FutureParser future = scoped("numeric");
           numericParser = future;
           future.setParser(
               choice(
                   integer(),
                   decimal(),
                   hexadecimal(),
                   sequence(
                       token("LENGTH"),
                       token("OF"),
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

    public Parser integer() {
        if (integerParser == null) {
           FutureParser future = scoped("integer");
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
    // integerConstant
    // ........................................................

    private Parser integerConstantParser = null;

    public Parser integerConstant() {
        if (integerConstantParser == null) {
           FutureParser future = scoped("integerConstant");
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

    public Parser alphanumeric() {
        if (alphanumericParser == null) {
           FutureParser future = scoped("alphanumeric");
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

    public Parser alphanumericConstant() {
        if (alphanumericConstantParser == null) {
           FutureParser future = scoped("alphanumericConstant");
           alphanumericConstantParser = future;
           future.setParser(
               cobolWord()
           );
        }

        return alphanumericConstantParser;
    }

    // ========================================================
    // Code provided by the user.
    // --------------------------------------------------------

    // Note: If you add/remove parsers in the kg-usercode file you will need to
    // update the antlr-tokens and antlr-rules files as well!

    // ============================================================================
    // Reserved keywords. Based on the list found in Fujitsu Siemens, document
    // U41112-J-Z125-3-76 (p. 67 and on).
    //
    // ----------------------------------------------------------------------------

    public static final Set<String> RESERVED_WORDS = new HashSet<String>();

    static {
        RESERVED_WORDS.add("ACCEPT");
        RESERVED_WORDS.add("ACCESS");
        RESERVED_WORDS.add("ACTIVE-CLASS");
        RESERVED_WORDS.add("ADD");
        RESERVED_WORDS.add("ADDRESS");
        RESERVED_WORDS.add("ADVANCING");
        RESERVED_WORDS.add("AFTER");
        RESERVED_WORDS.add("ALL");
        RESERVED_WORDS.add("ALLOCATE");
        RESERVED_WORDS.add("ALPHABET");
        RESERVED_WORDS.add("ALPHABETIC");
        RESERVED_WORDS.add("ALPHABETIC-LOWER");
        RESERVED_WORDS.add("ALPHABETIC-UPPER");
        RESERVED_WORDS.add("ALPHANUMERIC");
        RESERVED_WORDS.add("ALPHANUMERIC-EDITED");
        RESERVED_WORDS.add("ALSO");
        RESERVED_WORDS.add("ALTER");
        RESERVED_WORDS.add("ALTERNATE");
        RESERVED_WORDS.add("AND");
        RESERVED_WORDS.add("ANY");
        RESERVED_WORDS.add("ANYCASE");
        RESERVED_WORDS.add("ARE");
        RESERVED_WORDS.add("AREA");
        RESERVED_WORDS.add("AREAS");
        RESERVED_WORDS.add("AS");
        RESERVED_WORDS.add("ASCENDING");
        RESERVED_WORDS.add("ASSIGN");
        RESERVED_WORDS.add("AT");
        RESERVED_WORDS.add("AUTHOR");
        RESERVED_WORDS.add("B-AND");
        RESERVED_WORDS.add("B-NOT");
        RESERVED_WORDS.add("B-OR");
        RESERVED_WORDS.add("B-XOR");
        RESERVED_WORDS.add("BASED");
        RESERVED_WORDS.add("BEFORE");
        RESERVED_WORDS.add("BEGINNING");
        RESERVED_WORDS.add("BINARY");
        RESERVED_WORDS.add("BINARY-CHAR");
        RESERVED_WORDS.add("BINARY-DOUBLE");
        RESERVED_WORDS.add("BINARY-LONG");
        RESERVED_WORDS.add("BINARY-SHORT");
        RESERVED_WORDS.add("BIT");
        RESERVED_WORDS.add("BLANK");
        RESERVED_WORDS.add("BLOCK");
        RESERVED_WORDS.add("BOOLEAN");
        RESERVED_WORDS.add("BOTTOM");
        RESERVED_WORDS.add("BY");
        RESERVED_WORDS.add("CALL");
        RESERVED_WORDS.add("CANCEL");
        // RESERVED_WORDS.add("CASE");
        RESERVED_WORDS.add("CBL-CTR");
        RESERVED_WORDS.add("CF");
        RESERVED_WORDS.add("CH");
        RESERVED_WORDS.add("CHAINING");
        RESERVED_WORDS.add("CHARACTER");
        RESERVED_WORDS.add("CHARACTERS");
        RESERVED_WORDS.add("CHECKING");
        RESERVED_WORDS.add("CLASS");
        RESERVED_WORDS.add("CLASS-ID");
        RESERVED_WORDS.add("CLOCK-UNITS");
        RESERVED_WORDS.add("CLOSE");
        RESERVED_WORDS.add("CODE");
        RESERVED_WORDS.add("CODE-SET");
        RESERVED_WORDS.add("COL");
        RESERVED_WORDS.add("COLLATING");
        RESERVED_WORDS.add("COLS");
        RESERVED_WORDS.add("COLUMN");
        RESERVED_WORDS.add("COLUMNS");
        RESERVED_WORDS.add("COMMA");
        RESERVED_WORDS.add("COMMIT");
        RESERVED_WORDS.add("COMMON");
        RESERVED_WORDS.add("COMMUNICATION");
        RESERVED_WORDS.add("COMP");
        RESERVED_WORDS.add("COMP-1");
        RESERVED_WORDS.add("COMP-2");
        RESERVED_WORDS.add("COMP-3");
        RESERVED_WORDS.add("COMP-5");
        RESERVED_WORDS.add("COMPUTATIONAL");
        RESERVED_WORDS.add("COMPUTATIONAL-1");
        RESERVED_WORDS.add("COMPUTATIONAL-2");
        RESERVED_WORDS.add("COMPUTATIONAL-3");
        RESERVED_WORDS.add("COMPUTATIONAL-5");
        RESERVED_WORDS.add("COMPUTE");
        RESERVED_WORDS.add("CONDITION");
        RESERVED_WORDS.add("CONFIGURATION");
        // RESERVED_WORDS.add("CONNECT");
        RESERVED_WORDS.add("CONSTANT");
        RESERVED_WORDS.add("CONTAINS");
        RESERVED_WORDS.add("CONTENT");
        RESERVED_WORDS.add("CONTINUE");
        RESERVED_WORDS.add("CONTROL");
        RESERVED_WORDS.add("CONTROLS");
        RESERVED_WORDS.add("CONVERTING");
        RESERVED_WORDS.add("COPY");
        RESERVED_WORDS.add("CORR");
        RESERVED_WORDS.add("CORRESPONDING");
        RESERVED_WORDS.add("COUNT");
        RESERVED_WORDS.add("CREATING");
        RESERVED_WORDS.add("CRT");
        RESERVED_WORDS.add("CURRENCY");
        // RESERVED_WORDS.add("CURRENT");
        RESERVED_WORDS.add("CURSOR");
        RESERVED_WORDS.add("DATA");
        RESERVED_WORDS.add("DATA-POINTER");
        // RESERVED_WORDS.add("DATABASE-EXCEPTION");
        RESERVED_WORDS.add("DATABASE-KEY");
        RESERVED_WORDS.add("DATABASE-KEY-LONG");
        RESERVED_WORDS.add("DATE");
        RESERVED_WORDS.add("DATE-COMPILED");
        RESERVED_WORDS.add("DATE-WRITTEN");
        RESERVED_WORDS.add("DAY");
        RESERVED_WORDS.add("DAY-OF-WEEK");
        // RESERVED_WORDS.add("DB");
        RESERVED_WORDS.add("DE");
        // RESERVED_WORDS.add("DEBUG-CONTENTS");
        // RESERVED_WORDS.add("DEBUG-ITEM");
        // RESERVED_WORDS.add("DEBUG-LINE");
        // RESERVED_WORDS.add("DEBUG-NAME");
        // RESERVED_WORDS.add("DEBUG-SUB-1");
        // RESERVED_WORDS.add("DEBUG-SUB-2");
        // RESERVED_WORDS.add("DEBUG-SUB-3");
        RESERVED_WORDS.add("DEBUGGING");
        RESERVED_WORDS.add("DECIMAL-POINT");
        RESERVED_WORDS.add("DECLARATIVES");
        RESERVED_WORDS.add("DEFAULT");
        RESERVED_WORDS.add("DELETE");
        RESERVED_WORDS.add("DELIMITED");
        RESERVED_WORDS.add("DELIMITER");
        RESERVED_WORDS.add("DEPENDING");
        RESERVED_WORDS.add("DESCENDING");
        RESERVED_WORDS.add("DETAIL");
        RESERVED_WORDS.add("DISABLE");
        RESERVED_WORDS.add("DISC");
        // RESERVED_WORDS.add("DISCONNECT");
        RESERVED_WORDS.add("DISPLAY");
        RESERVED_WORDS.add("DIVIDE");
        RESERVED_WORDS.add("DIVISION");
        RESERVED_WORDS.add("DOWN");
        // RESERVED_WORDS.add("DUPLICATE");
        RESERVED_WORDS.add("DUPLICATES");
        RESERVED_WORDS.add("DYNAMIC");
        RESERVED_WORDS.add("EBCDIC");
        RESERVED_WORDS.add("EC");
        RESERVED_WORDS.add("ELSE");
        // RESERVED_WORDS.add("EMPTY");
        RESERVED_WORDS.add("ENABLE");
        RESERVED_WORDS.add("END");
        RESERVED_WORDS.add("END-ACCEPT");
        RESERVED_WORDS.add("END-ADD");
        RESERVED_WORDS.add("END-CALL");
        RESERVED_WORDS.add("END-COMPUTE");
        RESERVED_WORDS.add("END-DELETE");
        RESERVED_WORDS.add("END-DISPLAY");
        RESERVED_WORDS.add("END-DIVIDE");
        RESERVED_WORDS.add("END-EVALUATE");
        RESERVED_WORDS.add("END-IF");
        RESERVED_WORDS.add("END-INVOKE");
        RESERVED_WORDS.add("END-MULTIPLY");
        RESERVED_WORDS.add("END-OF-PAGE");
        RESERVED_WORDS.add("END-PERFORM");
        RESERVED_WORDS.add("END-READ");
        RESERVED_WORDS.add("END-RECEIVE");
        RESERVED_WORDS.add("END-RETURN");
        RESERVED_WORDS.add("END-REWRITE");
        RESERVED_WORDS.add("END-SEARCH");
        RESERVED_WORDS.add("END-START");
        RESERVED_WORDS.add("END-STRING");
        RESERVED_WORDS.add("END-SUBTRACT");
        RESERVED_WORDS.add("END-UNSTRING");
        RESERVED_WORDS.add("END-WRITE");
        RESERVED_WORDS.add("ENDING");
        RESERVED_WORDS.add("ENTRY");
        RESERVED_WORDS.add("ENVIRONMENT");
        RESERVED_WORDS.add("EO");
        RESERVED_WORDS.add("EO");
        RESERVED_WORDS.add("EOP");
        RESERVED_WORDS.add("EOP");
        RESERVED_WORDS.add("EQUAL");
        RESERVED_WORDS.add("EQUAL");
        RESERVED_WORDS.add("ERASE");
        RESERVED_WORDS.add("ERROR");
        RESERVED_WORDS.add("ESCAPE");
        RESERVED_WORDS.add("EVALUATE");
        RESERVED_WORDS.add("EVERY");
        RESERVED_WORDS.add("EXCEPTION");
        RESERVED_WORDS.add("EXCEPTION-OBJECT");
        // RESERVED_WORDS.add("EXCLUSIVE");
        RESERVED_WORDS.add("EXEC");
        RESERVED_WORDS.add("EXIT");
        RESERVED_WORDS.add("EXTEND");
        RESERVED_WORDS.add("EXTENDED");
        RESERVED_WORDS.add("EXTERNAL");
        RESERVED_WORDS.add("FACTORY");
        // RESERVED_WORDS.add("FALSE");
        RESERVED_WORDS.add("FD");
        // RESERVED_WORDS.add("FETCH");
        RESERVED_WORDS.add("FILE");
        RESERVED_WORDS.add("FILE-CONTROL");
        RESERVED_WORDS.add("FILLER");
        RESERVED_WORDS.add("FINAL");
        // RESERVED_WORDS.add("FIND");
        // RESERVED_WORDS.add("FINISH");
        RESERVED_WORDS.add("FIRST");
        RESERVED_WORDS.add("FLOAT-EXTENDED");
        RESERVED_WORDS.add("FLOAT-LONG");
        RESERVED_WORDS.add("FLOAT-SHORT");
        RESERVED_WORDS.add("FOOTING");
        RESERVED_WORDS.add("FOR");
        RESERVED_WORDS.add("FORMAT");
        RESERVED_WORDS.add("FREE");
        RESERVED_WORDS.add("FROM");
        RESERVED_WORDS.add("FUNCTION");
        RESERVED_WORDS.add("FUNCTION-ID");
        RESERVED_WORDS.add("GENERATE");
        RESERVED_WORDS.add("GET");
        RESERVED_WORDS.add("GIVING");
        RESERVED_WORDS.add("GLOBAL");
        RESERVED_WORDS.add("GO");
        RESERVED_WORDS.add("GOBACK");
        RESERVED_WORDS.add("GREATER");
        RESERVED_WORDS.add("GROUP");
        RESERVED_WORDS.add("GROUP-USAGE");
        RESERVED_WORDS.add("HEADING");
        RESERVED_WORDS.add("HIGH-VALUE");
        RESERVED_WORDS.add("HIGH-VALUES");
        RESERVED_WORDS.add("I-O");
        RESERVED_WORDS.add("I-O-CONTROL");
        RESERVED_WORDS.add("ID");
        RESERVED_WORDS.add("IDENTIFICATION");
        RESERVED_WORDS.add("IF");
        RESERVED_WORDS.add("IGNORING");
        RESERVED_WORDS.add("IN");
        // RESERVED_WORDS.add("INCLUDING");
        RESERVED_WORDS.add("INDEX");
        RESERVED_WORDS.add("INDEXED");
        RESERVED_WORDS.add("INDICATE");
        RESERVED_WORDS.add("INHERITS");
        RESERVED_WORDS.add("INITIAL");
        RESERVED_WORDS.add("INITIALIZE");
        RESERVED_WORDS.add("INITIATE");
        RESERVED_WORDS.add("INPUT");
        RESERVED_WORDS.add("INPUT-OUTPUT");
        RESERVED_WORDS.add("INSPECT");
        RESERVED_WORDS.add("INSTALLATION");
        RESERVED_WORDS.add("INTERFACE");
        RESERVED_WORDS.add("INTERFACE-ID");
        RESERVED_WORDS.add("INTO");
        RESERVED_WORDS.add("INVALID");
        RESERVED_WORDS.add("INVOKE");
        RESERVED_WORDS.add("IS");
        RESERVED_WORDS.add("JUST");
        RESERVED_WORDS.add("JUSTIFIED");
        // RESERVED_WORDS.add("KEEP");
        RESERVED_WORDS.add("KEY");
        RESERVED_WORDS.add("LABEL");
        RESERVED_WORDS.add("LAST");
        // RESERVED_WORDS.add("LEADING");
        RESERVED_WORDS.add("LEFT");
        // RESERVED_WORDS.add("LENGTH");
        RESERVED_WORDS.add("LESS");
        RESERVED_WORDS.add("LIMIT");
        // RESERVED_WORDS.add("LIMITED");
        RESERVED_WORDS.add("LIMITS");
        RESERVED_WORDS.add("LINAGE");
        RESERVED_WORDS.add("LINE");
        // RESERVED_WORDS.add("LINE-COUNTER");
        RESERVED_WORDS.add("LINES");
        RESERVED_WORDS.add("LINKAGE");
        RESERVED_WORDS.add("LOCAL-STORAGE");
        RESERVED_WORDS.add("LOCALE");
        RESERVED_WORDS.add("LOCK");
        RESERVED_WORDS.add("LOW-VALUE");
        RESERVED_WORDS.add("LOW-VALUES");
        // RESERVED_WORDS.add("MASK");
        // RESERVED_WORDS.add("MATCHING");
        // RESERVED_WORDS.add("MEMBER");
        // RESERVED_WORDS.add("MEMBERS");
        // RESERVED_WORDS.add("MEMBERSHIP");
        RESERVED_WORDS.add("MEMORY");
        RESERVED_WORDS.add("MERGE");
        RESERVED_WORDS.add("MESSAGE");
        RESERVED_WORDS.add("METHOD");
        RESERVED_WORDS.add("METHOD-ID");
        RESERVED_WORDS.add("MINUS");
        RESERVED_WORDS.add("MODE");
        // RESERVED_WORDS.add("MODIFY");
        RESERVED_WORDS.add("MODULES");
        RESERVED_WORDS.add("MORE-LABELS");
        RESERVED_WORDS.add("MOVE");
        RESERVED_WORDS.add("MULTIPLE");
        RESERVED_WORDS.add("MULTIPLY");
        RESERVED_WORDS.add("NATIONAL");
        RESERVED_WORDS.add("NATIONAL-EDITED");
        RESERVED_WORDS.add("NATIVE");
        RESERVED_WORDS.add("NEGATIVE");
        RESERVED_WORDS.add("NESTED");
        RESERVED_WORDS.add("NEXT");
        RESERVED_WORDS.add("NO");
        RESERVED_WORDS.add("NOT");
        RESERVED_WORDS.add("NULL");
        RESERVED_WORDS.add("NUMBER");
        RESERVED_WORDS.add("NUMERIC");
        RESERVED_WORDS.add("NUMERIC-EDITED");
        RESERVED_WORDS.add("OBJECT");
        RESERVED_WORDS.add("OBJECT-COMPUTER");
        // RESERVED_WORDS.add("OCCURENCE");
        RESERVED_WORDS.add("OCCURS");
        RESERVED_WORDS.add("OF");
        RESERVED_WORDS.add("OFF");
        RESERVED_WORDS.add("OMITTED");
        RESERVED_WORDS.add("ON");
        RESERVED_WORDS.add("OPEN");
        RESERVED_WORDS.add("OPTIONAL");
        // RESERVED_WORDS.add("OPTIONS");
        RESERVED_WORDS.add("OR");
        RESERVED_WORDS.add("ORDER");
        RESERVED_WORDS.add("ORGANIZATION");
        RESERVED_WORDS.add("OTHER");
        RESERVED_WORDS.add("OUTPUT");
        RESERVED_WORDS.add("OVERFLOW");
        RESERVED_WORDS.add("OVERRIDE");
        // RESERVED_WORDS.add("OWNER");
        RESERVED_WORDS.add("PACKED-DECIMAL");
        RESERVED_WORDS.add("PADDING");
        RESERVED_WORDS.add("PAGE");
        // RESERVED_WORDS.add("PAGE-COUNTER");
        RESERVED_WORDS.add("PERFORM");
        // RESERVED_WORDS.add("PERMANENT");
        RESERVED_WORDS.add("PF");
        RESERVED_WORDS.add("PH");
        RESERVED_WORDS.add("PIC");
        RESERVED_WORDS.add("PICTURE");
        RESERVED_WORDS.add("PLUS");
        RESERVED_WORDS.add("POINTER");
        RESERVED_WORDS.add("POSITION");
        RESERVED_WORDS.add("POSITIVE");
        RESERVED_WORDS.add("PRESENT");
        RESERVED_WORDS.add("PRINT-SWITCH");
        RESERVED_WORDS.add("PRINTING");
        // RESERVED_WORDS.add("PRIOR");
        RESERVED_WORDS.add("PROCEDURE");
        RESERVED_WORDS.add("PROCEED");
        RESERVED_WORDS.add("PROGRAM");
        RESERVED_WORDS.add("PROGRAM-ID");
        RESERVED_WORDS.add("PROGRAM-POINTER");
        RESERVED_WORDS.add("PROPERTY");
        // RESERVED_WORDS.add("PROTECTED");
        RESERVED_WORDS.add("PROTOTYPE");
        RESERVED_WORDS.add("PURGE");
        RESERVED_WORDS.add("QUOTE");
        RESERVED_WORDS.add("QUOTES");
        RESERVED_WORDS.add("RAISE");
        RESERVED_WORDS.add("RAISING");
        // RESERVED_WORDS.add("RANDOM");
        RESERVED_WORDS.add("RD");
        RESERVED_WORDS.add("READ");
        // RESERVED_WORDS.add("READY");
        // RESERVED_WORDS.add("REALM");
        // RESERVED_WORDS.add("REALM-NAME");
        RESERVED_WORDS.add("RECEIVE");
        RESERVED_WORDS.add("RECORD");
        RESERVED_WORDS.add("RECORDING");
        RESERVED_WORDS.add("RECORDS");
        RESERVED_WORDS.add("REDEFINES");
        RESERVED_WORDS.add("REEL");
        RESERVED_WORDS.add("REFERENCE");
        RESERVED_WORDS.add("RELATIVE");
        RESERVED_WORDS.add("RELEASE");
        RESERVED_WORDS.add("REMAINDER");
        RESERVED_WORDS.add("REMOVAL");
        RESERVED_WORDS.add("RENAMES");
        RESERVED_WORDS.add("REPEATED");
        RESERVED_WORDS.add("REPLACE");
        RESERVED_WORDS.add("REPLACING");
        RESERVED_WORDS.add("REPORT");
        RESERVED_WORDS.add("REPORTING");
        RESERVED_WORDS.add("REPORTS");
        RESERVED_WORDS.add("REPOSITORY");
        RESERVED_WORDS.add("RERUN");
        RESERVED_WORDS.add("RESERVE");
        RESERVED_WORDS.add("RESET");
        // RESERVED_WORDS.add("RESULT");
        RESERVED_WORDS.add("RESUME");
        // RESERVED_WORDS.add("RETAINING");
        // RESERVED_WORDS.add("RETRIEVAL");
        RESERVED_WORDS.add("RETRY");
        RESERVED_WORDS.add("RETURN");
        RESERVED_WORDS.add("RETURNING");
        RESERVED_WORDS.add("REVERSED");
        RESERVED_WORDS.add("REWIND");
        RESERVED_WORDS.add("REWRITE");
        RESERVED_WORDS.add("RF");
        RESERVED_WORDS.add("RH");
        RESERVED_WORDS.add("RIGHT");
        RESERVED_WORDS.add("ROLLBACK");
        RESERVED_WORDS.add("ROUNDED");
        RESERVED_WORDS.add("RUN");
        RESERVED_WORDS.add("SAME");
        RESERVED_WORDS.add("SCREEN");
        RESERVED_WORDS.add("SD");
        RESERVED_WORDS.add("SEARCH");
        RESERVED_WORDS.add("SECTION");
        RESERVED_WORDS.add("SECURITY");
        RESERVED_WORDS.add("SEGMENT-LIMIT");
        RESERVED_WORDS.add("SELECT");
        // RESERVED_WORDS.add("SELECTIVE");
        RESERVED_WORDS.add("SELF");
        RESERVED_WORDS.add("SEND");
        RESERVED_WORDS.add("SENTENCE");
        RESERVED_WORDS.add("SEPARATE");
        RESERVED_WORDS.add("SEQUENCE");
        RESERVED_WORDS.add("SEQUENTIAL");
        RESERVED_WORDS.add("SET");
        // RESERVED_WORDS.add("SET-SELECTION");
        // RESERVED_WORDS.add("SETS");
        RESERVED_WORDS.add("SHARING");
        RESERVED_WORDS.add("SIGN");
        RESERVED_WORDS.add("SIZE");
        RESERVED_WORDS.add("SORT");
        RESERVED_WORDS.add("SORT-MERGE");
        RESERVED_WORDS.add("SORT-TAPE");
        RESERVED_WORDS.add("SORT-TAPES");
        // RESERVED_WORDS.add("SORTED");
        RESERVED_WORDS.add("SOURCE");
        RESERVED_WORDS.add("SOURCE-COMPUTER");
        RESERVED_WORDS.add("SOURCES");
        RESERVED_WORDS.add("SPACE");
        RESERVED_WORDS.add("SPACES");
        RESERVED_WORDS.add("SPECIAL-NAMES");
        RESERVED_WORDS.add("STANDARD");
        RESERVED_WORDS.add("STANDARD-1");
        RESERVED_WORDS.add("STANDARD-2");
        RESERVED_WORDS.add("START");
        RESERVED_WORDS.add("STATUS");
        RESERVED_WORDS.add("STOP");
        // RESERVED_WORDS.add("STORE");
        RESERVED_WORDS.add("STRING");
        // RESERVED_WORDS.add("SUB-SCHEMA");
        RESERVED_WORDS.add("SUBTRACT");
        // RESERVED_WORDS.add("SUM");
        RESERVED_WORDS.add("SUPER");
        RESERVED_WORDS.add("SUPPRESS");
        RESERVED_WORDS.add("SUPPRESSING");
        RESERVED_WORDS.add("SYMBOLIC");
        RESERVED_WORDS.add("SYNC");
        RESERVED_WORDS.add("SYNCHRONIZED");
        // RESERVED_WORDS.add("SYSTEM");
        RESERVED_WORDS.add("SYSTEM-DEFAULT");
        RESERVED_WORDS.add("TABLE");
        // RESERVED_WORDS.add("TALLY");
        RESERVED_WORDS.add("TALLYING");
        RESERVED_WORDS.add("TAPE");
        RESERVED_WORDS.add("TAPES");
        // RESERVED_WORDS.add("TENANT");
        RESERVED_WORDS.add("TERMINAL");
        RESERVED_WORDS.add("TERMINATE");
        RESERVED_WORDS.add("TEST");
        RESERVED_WORDS.add("THAN");
        RESERVED_WORDS.add("THEN");
        RESERVED_WORDS.add("THROUGH");
        RESERVED_WORDS.add("THRU");
        RESERVED_WORDS.add("TIME");
        RESERVED_WORDS.add("TIMES");
        RESERVED_WORDS.add("TO");
        RESERVED_WORDS.add("TOP");
        // RESERVED_WORDS.add("TRAILING");
        // RESERVED_WORDS.add("TRUE");
        RESERVED_WORDS.add("TRY");
        RESERVED_WORDS.add("TYPE");
        RESERVED_WORDS.add("TYPEDEF");
        RESERVED_WORDS.add("UNIT");
        RESERVED_WORDS.add("UNITS");
        RESERVED_WORDS.add("UNIVERSAL");
        RESERVED_WORDS.add("UNLOCK");
        RESERVED_WORDS.add("UNSTRING");
        RESERVED_WORDS.add("UNTIL");
        RESERVED_WORDS.add("UP");
        // RESERVED_WORDS.add("UPDATE");
        RESERVED_WORDS.add("UPON");
        RESERVED_WORDS.add("USAGE");
        // RESERVED_WORDS.add("USAGE-MODE");
        RESERVED_WORDS.add("USE");
        RESERVED_WORDS.add("USER-DEFAULT");
        RESERVED_WORDS.add("USING");
        RESERVED_WORDS.add("VAL-STATUS");
        RESERVED_WORDS.add("VALID");
        RESERVED_WORDS.add("VALIDATE");
        RESERVED_WORDS.add("VALIDATE-STATUS");
        RESERVED_WORDS.add("VALUE");
        RESERVED_WORDS.add("VALUES");
        RESERVED_WORDS.add("VARYING");
        // RESERVED_WORDS.add("VIA");
        RESERVED_WORDS.add("WHEN");
        RESERVED_WORDS.add("WITH");
        // RESERVED_WORDS.add("WITHIN");
        RESERVED_WORDS.add("WORDS");
        RESERVED_WORDS.add("WORKING-STORAGE");
        RESERVED_WORDS.add("WRITE");
        RESERVED_WORDS.add("ZERO");
        RESERVED_WORDS.add("ZEROES");
        RESERVED_WORDS.add("ZEROS");
    }

    private static final int DEFAULT_MAX_COBOL_WORD_LENGTH = 31;
    private static final int MAX_COBOL_WORD_LENGTH;

    static {
    	String maxCobolWordLengthSetting = System.getProperty("koopa.maxCobolWordLength", "" + DEFAULT_MAX_COBOL_WORD_LENGTH);
    	
    	int maxCobolWordLengthValue;
    	try {
    		maxCobolWordLengthValue = Integer.parseInt(maxCobolWordLengthSetting);
    		
    	} catch(NumberFormatException e) {
    		System.err.println("Warning: value for koopa.maxCobolWordLength is not a number: " + maxCobolWordLengthSetting);
    		maxCobolWordLengthValue = DEFAULT_MAX_COBOL_WORD_LENGTH;
    	}
    	
    	if (maxCobolWordLengthValue == 0)
    	    maxCobolWordLengthValue = DEFAULT_MAX_COBOL_WORD_LENGTH;
    	
    	MAX_COBOL_WORD_LENGTH = maxCobolWordLengthValue;
    }

    // ============================================================================
    // cobolWord
    // ............................................................................

    private Parser cobolWordParser = null;

    public Parser cobolWord() {
    	if (cobolWordParser == null) {
    	    FutureParser future = scoped("cobolWord");
    	    cobolWordParser = future;
    	    future.setParser(new Parser() {
    			protected boolean accepts(TokenStream stream) {
    	            Token token = null;
    	            
    	            // Skipping past commas and semi-colons which leaked through to the parser.
    	            do  {
    	                token = stream.nextToken();
    	            } while (token != null && (token.getText().equals(",") || token.getText().equals(";")));
    	
    	            if (token != null
    	                    && token.hasTag(SyntacticTag.CHARACTER_STRING)
    	                    && !RESERVED_WORDS.contains(token.getText().toUpperCase())
    	                    && isCobolWord(token.getText())) {
    	
    	                returnToken(token);
    	                return true;
    	
    	            } else
    	                return false;
    	        }
    	
    	        private boolean isCobolWord(String text) {
    	            /*
    	             * A word consists of 1-31 characters from the following set:
    	             * A-Z, a-z, 0-9, - (hyphen). No distinction is made between
    	             * uppercase and lowercase letters. A word may neither begin nor
    	             * end with a hyphen, must not contain space characters, and
    	             * must contain at least one letter.
    	             * 
    	             * Description from: Fujitsu Siemens, document
    	             * U41112-J-Z125-3-76.
    	             *
    	             * -------------------------------------------------------------
    	             * Except where specific rules apply, the hyphen (-) and the
    	             * underline (_) are treated as the same character in a user-
    	             * defined word. The underline (_), however, can begin or end a
    	             * user-defined word, and the hyphen (-) cannot.
    	             *
    	             * Description from: HP COBOL Reference Manual
    	             * http://h71000.www7.hp.com/doc/82final/6296/6296pro_002.html
    	             */
    	            final int len = text.length();
    	            if (len < 1 || (MAX_COBOL_WORD_LENGTH > 0 && len > MAX_COBOL_WORD_LENGTH))
    	                return false;
    	
    	            if (text.charAt(0) == '-')
    	                return false;
    	
    	            if (text.charAt(len - 1) == '-')
    	                return false;
    	
    	            boolean hasALetter = false;
    	            for (int i = 0; i < len; i++) {
    	                final char c = text.charAt(i);
    	
    	                if (c >= 'A' && c <= 'Z') {
    	                    hasALetter = true;
    	                    continue;
    	                }
    	
    	                if (c >= 'a' && c <= 'z') {
    	                    hasALetter = true;
    	                    continue;
    	                }
    	
    	                if (c >= '0' && c <= '9') {
    	                    continue;
    	                }
    	
    	                if (c == '-') {
    	                    continue;
    	                }
    	
    	                if (c == '_') {
    	                    continue;
    	                }
    	
    	                return false;
    	            }
    	
    	            return hasALetter;
    	        }
    	    });
    	}
        return cobolWordParser;
    }

    // ============================================================================
    // integerLiteral
    // ............................................................................

    private Parser integerLiteralParser = null;

    public Parser integerLiteral() {
    	if (integerLiteralParser == null) {
    	    FutureParser future = scoped("integerLiteral");
    	    integerLiteralParser = future;
    	    future.setParser(new Parser() {
    			protected boolean accepts(TokenStream stream) {
    	            Token token = null;
    	            
    	            // Skipping past commas and semi-colons which leaked through to the parser.
    	            do  {
    	                token = stream.nextToken();
    	            } while (token != null && (token.getText().equals(",") || token.getText().equals(";")));
    	
    				if (token != null
    						&& token.hasTag(SyntacticTag.CHARACTER_STRING)) {
    					if (token.hasTag(SyntacticTag.INTEGER_LITERAL)) {
    	
    						returnToken(token);
    						return true;
    	
    					} else
    						return false;
    	
    				} else
    					return false;
    			}
    		});
    	}
    	return integerLiteralParser;
    }

    // ============================================================================
    // decimal
    // ............................................................................

    private Parser decimalParser = null;

    public Parser decimal() {
    	if (decimalParser == null) {
    	    FutureParser future = scoped("decimal");
    	    decimalParser = future;
    	    future.setParser(new Parser() {
    			protected boolean accepts(TokenStream stream) {
    	            Token token = null;
    	            
    	            // Skipping past commas and semi-colons which leaked through to the parser.
    	            do  {
    	                token = stream.nextToken();
    	            } while (token != null && (token.getText().equals(",") || token.getText().equals(";")));
    	
    				if (token != null
    						&& token.hasTag(SyntacticTag.CHARACTER_STRING)) {
    					if (token.hasTag(SyntacticTag.DECIMAL_LITERAL)) {
    	
    						returnToken(token);
    						return true;
    	
    					} else
    						return false;
    	
    				} else
    					return false;
    			}
    		});
    	}
    	return decimalParser;
    }

    // ============================================================================
    // hexadecimal
    // ............................................................................

    private Parser hexadecimalParser = null;

    public Parser hexadecimal() {
    	if (hexadecimalParser == null) {
    	    FutureParser future = scoped("hexadecimal");
    	    hexadecimalParser = future;
    	    future.setParser(new Parser() {
    			protected boolean accepts(TokenStream stream) {
    	            Token token = null;
    	            
    	            // Skipping past commas and semi-colons which leaked through to the parser.
    	            do  {
    	                token = stream.nextToken();
    	            } while (token != null && (token.getText().equals(",") || token.getText().equals(";")));
    	
    				if (token != null
    						&& token.hasTag(SyntacticTag.CHARACTER_STRING)) {
    					if (token.hasTag(SyntacticTag.HEXADECIMAL_LITERAL)) {
    	
    						returnToken(token);
    						return true;
    	
    					} else
    						return false;
    	
    				} else
    					return false;
    			}
    		});
    	}
    	return hexadecimalParser;
    }

    // ============================================================================
    // alphanumericLiteral
    // ............................................................................

    private Parser alphanumericLiteralParser = null;

    public Parser alphanumericLiteral() {
    	if (alphanumericLiteralParser == null) {
    	    FutureParser future = scoped("alphanumericLiteral");
    	    alphanumericLiteralParser = future;
    	    future.setParser(new Parser() {
    			protected boolean accepts(TokenStream stream) {
    	            Token token = null;
    	            
    	            // Skipping past commas and semi-colons which leaked through to the parser.
    	            do  {
    	                token = stream.nextToken();
    	            } while (token != null && (token.getText().equals(",") || token.getText().equals(";")));
    	
    				if (token != null
    						&& token.hasTag(SyntacticTag.CHARACTER_STRING)) {
    					if (token.hasTag(SyntacticTag.STRING_LITERAL)) {
    	
    						returnToken(token);
    						return true;
    	
    					} else
    						return false;
    	
    				} else
    					return false;
    			}
    		});
    	}
    	return alphanumericLiteralParser;
    }

    // ============================================================================
    // pictureString
    // ............................................................................

    private Parser pictureStringParser = null;

    public Parser pictureString() {
    	if (pictureStringParser == null) {
    	    FutureParser future = scoped("pictureString");
    	    pictureStringParser = future;
    	    future.setParser(new Parser() {
    			protected boolean accepts(TokenStream stream) {
    	
    				int numberOfTokens = 0;
    				CompositeToken picture = new CompositeToken();

    				while (true) {
    					final Token token = stream.nextToken();
    	
    					if (token == null) {
    						break;
    					}
    	
    					if (numberOfTokens > 0 && !token.hasTag(TokenizerTag.CHAINED)) {
    						stream.pushback(token);
    						break;
    					}
    					
    					picture.addToken(token);
    					numberOfTokens += 1;
    				}
    				
    				if (numberOfTokens == 0) {
    					return false;
    				}
    				
    				final Token lastToken = picture.getToken(numberOfTokens - 1);
    				if (lastToken.hasTag(SyntacticTag.SEPARATOR) && lastToken.getText().equals(".")) {
    					picture.removeToken(numberOfTokens - 1);
    					stream.pushback(lastToken);
    				}
    				
    				returnToken(picture);
    				return true;
    			}
    		});
    	}
    	return pictureStringParser;
    }

    // ============================================================================
    // levelNumber
    // ............................................................................

    private Parser levelNumberParser = null;

    public Parser levelNumber() {
    	if (levelNumberParser == null) {
    	    FutureParser future = scoped("levelNumber");
    	    levelNumberParser = future;
    	    future.setParser(new Parser() {
    			protected boolean accepts(TokenStream stream) {
    	            Token token = null;
    	            
    	            // Skipping past commas and semi-colons which leaked through to the parser.
    	            do  {
    	                token = stream.nextToken();
    	            } while (token != null && (token.getText().equals(",") || token.getText().equals(";")));
    	
    	            if (token != null
    	                    && token.hasTag(SyntacticTag.CHARACTER_STRING)
    	                    && isLevelNumber(token.getText())) {
    	
    	                returnToken(token);
    	                return true;
    	
    	            } else
    	                return false;
    	        }
    	
    	        private boolean isLevelNumber(String text) {
    	            /*
    	             * The level number is a special numeric literal consisting of one
    	             * to two digits. A level number which is less than 10 may be
    	             * written either as a single digit or with a leading zero. 
    	             * 
    	             * Description from: Fujitsu Siemens, document
    	             * U41112-J-Z125-3-76.
    	             */
    	            final int len = text.length();
    	            if (len == 0 || len > 2) {
    	                return false;
    	            }
    	
    	            final char c = text.charAt(0);
    	            if (c < '0' || c > '9') {
    	                return false;
    	            }
    	
    	            if (len == 2) {
    	                final char d = text.charAt(0);
    	                if (d < '0' || d > '9') {
    	                    return false;
    	                }
    	            }
    	
    	            int val = Integer.parseInt(text);
    	
    	            return (val > 0 && val <= 49) || (val == 77);
    	        }
    	    });
    	}
        return levelNumberParser;
    }

    // ============================================================================
    // pseudo literal
    // ............................................................................

    private Parser pseudoLiteralParser = null;

    public Parser pseudoLiteral() {
    	if (pseudoLiteralParser == null) {
    	    FutureParser future = scoped("pseudoLiteral");
    	    pseudoLiteralParser = future;
    	    future.setParser(new Parser() {
    			protected boolean accepts(TokenStream stream) {
    	            Token token = null;
    	            
    	            // Skipping past commas and semi-colons which leaked through to the parser.
    	            do  {
    	                token = stream.nextToken();
    	            } while (token != null && (token.getText().equals(",") || token.getText().equals(";")));
    	
    				if (token != null
    						&& token.hasTag(SyntacticTag.CHARACTER_STRING)) {
    					if (token.hasTag(SyntacticTag.PSEUDO_LITERAL)) {
    	
    						returnToken(token);
    						return true;
    	
    					} else
    						return false;
    	
    				} else
    					return false;
    			}
    		});
    	}
    	return pseudoLiteralParser;
    }


}