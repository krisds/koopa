package koopa.grammars.cobol;

import java.util.Set;
import java.util.HashSet;

import koopa.parsers.Block;
import koopa.parsers.KoopaGrammar;
import koopa.parsers.Parser;
import koopa.parsers.FutureParser;

import koopa.tokenizers.cobol.tags.SyntacticTag;
import koopa.tokens.CompositeToken;
import koopa.tokens.Token;
import koopa.tokenstreams.TokenStream;

public class CobolGrammar extends KoopaGrammar {
    public CobolGrammar() {
    }

    // ========================================================
    // Reserved keywords. This set is generated from the
    // grammar.
    // --------------------------------------------------------

    public static final Set<String> RESERVED_WORDS = new HashSet<String>();

    static {
      RESERVED_WORDS.add("FUNCTION");
      RESERVED_WORDS.add("END-WRITE");
      RESERVED_WORDS.add("POINTER");
      RESERVED_WORDS.add("ENABLE");
      RESERVED_WORDS.add("QUOTES");
      RESERVED_WORDS.add("NOT");
      RESERVED_WORDS.add("SUBTRACT");
      RESERVED_WORDS.add("CHARACTER");
      RESERVED_WORDS.add("EOP");
      RESERVED_WORDS.add("SUPPRESS");
      RESERVED_WORDS.add("DECLARATIVES");
      RESERVED_WORDS.add("ARE");
      RESERVED_WORDS.add("END-PERFORM");
      RESERVED_WORDS.add("USING");
      RESERVED_WORDS.add("SENTENCE");
      RESERVED_WORDS.add("RETURN");
      RESERVED_WORDS.add("DIVISION");
      RESERVED_WORDS.add("ROUNDED");
      RESERVED_WORDS.add("COMMON");
      RESERVED_WORDS.add("SEND");
      RESERVED_WORDS.add("EVALUATE");
      RESERVED_WORDS.add("DIVIDE");
      RESERVED_WORDS.add("DISABLE");
      RESERVED_WORDS.add("LOW-VALUE");
      RESERVED_WORDS.add("PIC");
      RESERVED_WORDS.add("END-OF-PAGE");
      RESERVED_WORDS.add("END-UNSTRING");
      RESERVED_WORDS.add("KEY");
      RESERVED_WORDS.add("INITIAL");
      RESERVED_WORDS.add("BLANK");
      RESERVED_WORDS.add("ELSE");
      RESERVED_WORDS.add("TRAILING");
      RESERVED_WORDS.add("SEPARATE");
      RESERVED_WORDS.add("ZEROS");
      RESERVED_WORDS.add("STOP");
      RESERVED_WORDS.add("LOW-VALUES");
      RESERVED_WORDS.add("CONTENT");
      RESERVED_WORDS.add("VALUE");
      RESERVED_WORDS.add("FILE");
      RESERVED_WORDS.add("INVALID");
      RESERVED_WORDS.add("LEADING");
      RESERVED_WORDS.add("REWRITE");
      RESERVED_WORDS.add("DEPENDING");
      RESERVED_WORDS.add("READ");
      RESERVED_WORDS.add("END-CALL");
      RESERVED_WORDS.add("ALSO");
      RESERVED_WORDS.add("INSPECT");
      RESERVED_WORDS.add("SEARCH");
      RESERVED_WORDS.add("CALL");
      RESERVED_WORDS.add("GO");
      RESERVED_WORDS.add("END");
      RESERVED_WORDS.add("END-MULTIPLY");
      RESERVED_WORDS.add("SIZE");
      RESERVED_WORDS.add("COMPUTATIONAL-2");
      RESERVED_WORDS.add("COMPUTATIONAL-1");
      RESERVED_WORDS.add("ALTER");
      RESERVED_WORDS.add("REPORT");
      RESERVED_WORDS.add("END-RETURN");
      RESERVED_WORDS.add("COMPUTATIONAL-3");
      RESERVED_WORDS.add("COMPUTATIONAL-5");
      RESERVED_WORDS.add("OCCURS");
      RESERVED_WORDS.add("LINES");
      RESERVED_WORDS.add("END-DISPLAY");
      RESERVED_WORDS.add("ASCENDING");
      RESERVED_WORDS.add("ZERO");
      RESERVED_WORDS.add("AT");
      RESERVED_WORDS.add("66");
      RESERVED_WORDS.add("THEN");
      RESERVED_WORDS.add("REPLACE");
      RESERVED_WORDS.add("LEFT");
      RESERVED_WORDS.add("PREVIOUS");
      RESERVED_WORDS.add("END-EVALUATE");
      RESERVED_WORDS.add("COMMUNICATION");
      RESERVED_WORDS.add("FILLER");
      RESERVED_WORDS.add("ADD");
      RESERVED_WORDS.add("BY");
      RESERVED_WORDS.add("DELIMITED");
      RESERVED_WORDS.add("TO");
      RESERVED_WORDS.add("COMP-1");
      RESERVED_WORDS.add("COMP-3");
      RESERVED_WORDS.add("MERGE");
      RESERVED_WORDS.add("COMP-2");
      RESERVED_WORDS.add("COMP-5");
      RESERVED_WORDS.add("SORT");
      RESERVED_WORDS.add("RIGHT");
      RESERVED_WORDS.add("SET");
      RESERVED_WORDS.add("EXEC");
      RESERVED_WORDS.add("END-READ");
      RESERVED_WORDS.add("REPLACING");
      RESERVED_WORDS.add("ACCEPT");
      RESERVED_WORDS.add("LINE");
      RESERVED_WORDS.add("HIGH-VALUES");
      RESERVED_WORDS.add("ZEROES");
      RESERVED_WORDS.add("OMITTED");
      RESERVED_WORDS.add("CLOSE");
      RESERVED_WORDS.add("WHEN");
      RESERVED_WORDS.add("MOVE");
      RESERVED_WORDS.add("START");
      RESERVED_WORDS.add("PROGRAM");
      RESERVED_WORDS.add("DESCENDING");
      RESERVED_WORDS.add("RECEIVE");
      RESERVED_WORDS.add("ENVIRONMENT");
      RESERVED_WORDS.add("STRING");
      RESERVED_WORDS.add("DELIMITER");
      RESERVED_WORDS.add("SIGN");
      RESERVED_WORDS.add("EXTERNAL");
      RESERVED_WORDS.add("END-REWRITE");
      RESERVED_WORDS.add("REDEFINES");
      RESERVED_WORDS.add("COMPUTE");
      RESERVED_WORDS.add("VARYING");
      RESERVED_WORDS.add("PACKED-DECIMAL");
      RESERVED_WORDS.add("COUNT");
      RESERVED_WORDS.add("THRU");
      RESERVED_WORDS.add("RELEASE");
      RESERVED_WORDS.add("CANCEL");
      RESERVED_WORDS.add("QUOTE");
      RESERVED_WORDS.add("OVERFLOW");
      RESERVED_WORDS.add("END-COMPUTE");
      RESERVED_WORDS.add("GENERATE");
      RESERVED_WORDS.add("LINKAGE");
      RESERVED_WORDS.add("INTO");
      RESERVED_WORDS.add("EXCEPTION");
      RESERVED_WORDS.add("EXIT");
      RESERVED_WORDS.add("RECORD");
      RESERVED_WORDS.add("INITIALIZE");
      RESERVED_WORDS.add("SECTION");
      RESERVED_WORDS.add("NO");
      RESERVED_WORDS.add("RENAMES");
      RESERVED_WORDS.add("ON");
      RESERVED_WORDS.add("DELETE");
      RESERVED_WORDS.add("ERROR");
      RESERVED_WORDS.add("OF");
      RESERVED_WORDS.add("TERMINATE");
      RESERVED_WORDS.add("REMAINDER");
      RESERVED_WORDS.add("UNSTRING");
      RESERVED_WORDS.add("SPACES");
      RESERVED_WORDS.add("UNTIL");
      RESERVED_WORDS.add("DISPLAY");
      RESERVED_WORDS.add("OR");
      RESERVED_WORDS.add("JUSTIFIED");
      RESERVED_WORDS.add("TEST");
      RESERVED_WORDS.add("HIGH-VALUE");
      RESERVED_WORDS.add("USE");
      RESERVED_WORDS.add("FROM");
      RESERVED_WORDS.add("FALSE");
      RESERVED_WORDS.add("END-IF");
      RESERVED_WORDS.add("88");
      RESERVED_WORDS.add("CORR");
      RESERVED_WORDS.add("END-START");
      RESERVED_WORDS.add("END-DIVIDE");
      RESERVED_WORDS.add("END-ACCEPT");
      RESERVED_WORDS.add("ID");
      RESERVED_WORDS.add("SPACE");
      RESERVED_WORDS.add("LENGTH");
      RESERVED_WORDS.add("USAGE");
      RESERVED_WORDS.add("LOCK");
      RESERVED_WORDS.add("IF");
      RESERVED_WORDS.add("END-SEARCH");
      RESERVED_WORDS.add("INDEX");
      RESERVED_WORDS.add("SYNCHRONIZED");
      RESERVED_WORDS.add("IN");
      RESERVED_WORDS.add("END-STRING");
      RESERVED_WORDS.add("MULTIPLY");
      RESERVED_WORDS.add("CONTINUE");
      RESERVED_WORDS.add("IS");
      RESERVED_WORDS.add("COPY");
      RESERVED_WORDS.add("TALLYING");
      RESERVED_WORDS.add("ALL");
      RESERVED_WORDS.add("NEXT");
      RESERVED_WORDS.add("ADVANCING");
      RESERVED_WORDS.add("WITH");
      RESERVED_WORDS.add("OTHER");
      RESERVED_WORDS.add("END-DELETE");
      RESERVED_WORDS.add("SYNC");
      RESERVED_WORDS.add("GOBACK");
      RESERVED_WORDS.add("END-EXEC");
      RESERVED_WORDS.add("VALUES");
      RESERVED_WORDS.add("PROGRAM-ID");
      RESERVED_WORDS.add("REFERENCE");
      RESERVED_WORDS.add("END-SUBTRACT");
      RESERVED_WORDS.add("PURGE");
      RESERVED_WORDS.add("BEFORE");
      RESERVED_WORDS.add("ENTRY");
      RESERVED_WORDS.add("COMP");
      RESERVED_WORDS.add("GIVING");
      RESERVED_WORDS.add("AFTER");
      RESERVED_WORDS.add("IDENTIFICATION");
      RESERVED_WORDS.add("TRUE");
      RESERVED_WORDS.add("END-ADD");
      RESERVED_WORDS.add("PROCEDURE");
      RESERVED_WORDS.add("WRITE");
      RESERVED_WORDS.add("CORRESPONDING");
      RESERVED_WORDS.add("INDEXED");
      RESERVED_WORDS.add("PICTURE");
      RESERVED_WORDS.add("OPEN");
      RESERVED_WORDS.add("RUN");
      RESERVED_WORDS.add("INITIATE");
      RESERVED_WORDS.add("ANY");
      RESERVED_WORDS.add("PAGE");
      RESERVED_WORDS.add("COMPUTATIONAL");
      RESERVED_WORDS.add("THROUGH");
      RESERVED_WORDS.add("JUST");
      RESERVED_WORDS.add("BINARY");
      RESERVED_WORDS.add("GLOBAL");
      RESERVED_WORDS.add("TIMES");
      RESERVED_WORDS.add("DATA");
      RESERVED_WORDS.add("PERFORM");
      RESERVED_WORDS.add("WORKING-STORAGE");
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
                   token("."),
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
                           dataDescriptionEntry(),
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
                           dataDescriptionEntry(),
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
                   dataDescriptionEntry_format3()
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
                       choice(
                           token("FILLER"),
                           dataName()
                       )
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
                       value()
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
                   token(".")
               )
           );
        }

        return dataDescriptionEntry_format3Parser;
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
                               dataName()
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
    // value
    // ........................................................

    private Parser valueParser = null;

    public Parser value() {
        if (valueParser == null) {
           FutureParser future = scoped("value");
           valueParser = future;
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

        return valueParser;
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
                       usingPhrase()
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
    // usingPhrase
    // ........................................................

    private Parser usingPhraseParser = null;

    public Parser usingPhrase() {
        if (usingPhraseParser == null) {
           FutureParser future = scoped("usingPhrase");
           usingPhraseParser = future;
           future.setParser(
               sequence(
                   token("USING"),
                   plus(
                       dataName()
                   )
               )
           );
        }

        return usingPhraseParser;
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
                   skipto(
                       token(".")
                   ),
                   token(".")
               )
           );
        }

        return useStatementParser;
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
                       optional(
                           token(".")
                       )
                   ),
                   copyStatement(),
                   replaceStatement(),
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
                   performStatement(),
                   readStatement(),
                   returnStatement(),
                   rewriteStatement(),
                   searchStatement(),
                   startStatement(),
                   stopStatement(),
                   stringStatement(),
                   subtractStatement(),
                   unstringStatement(),
                   writeStatement(),
                   sequence(
                       verb(),
                       optional(
                           skipto(
                               choice(
                                   token("."),
                                   endOfStatement()
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
                       assign("t", token("END-DISPLAY")),
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
                   token("PERFORM"),
                   token("READ"),
                   token("RETURN"),
                   token("REWRITE"),
                   token("SEARCH"),
                   token("STOP"),
                   token("STRING"),
                   token("SUBTRACT"),
                   token("UNSTRING"),
                   token("WRITE"),
                   token("COMPUTE"),
                   token("START"),
                   token("ACCEPT"),
                   token("ALTER"),
                   token("CLOSE"),
                   token("CONTINUE"),
                   token("DISPLAY"),
                   token("INITIALIZE"),
                   token("INSPECT"),
                   token("MERGE"),
                   token("OPEN"),
                   token("RELEASE"),
                   token("SET"),
                   token("SORT"),
                   token("USE"),
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
                   choice(
                       identifier(),
                       alphanumeric()
                   ),
                   optional(
                       sequence(
                           token("USING"),
                           star(
                               identifier()
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
                   skipto(
                       choice(
                           sequence(
                               optional(
                                   token("NOT")
                               ),
                               optional(
                                   token("ON")
                               ),
                               token("SIZE"),
                               token("ERROR")
                           ),
                           token("END-COMPUTE"),
                           token("."),
                           endOfStatement()
                       )
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
               skipto(
                   choice(
                       token("WHEN"),
                       token("ALSO")
                   )
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
                   condition(),
                   token("TRUE"),
                   token("FALSE"),
                   sequence(
                       optional(
                           token("NOT")
                       ),
                       choice(
                           identifier(),
                           literal(),
                           arithmeticExpression()
                       ),
                       optional(
                           sequence(
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
                       )
                   )
               )
           );
        }

        return objectParser;
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
           );
        }

        return execStatementParser;
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
                       token("PROGRAM")
                   )
               )
           );
        }

        return exitStatementParser;
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
                           nestedStatements(),
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
                   token("UNTIL"),
                   condition()
               )
           );
        }

        return untilParser;
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
                           token("NO"),
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
                   skipto(
                       choice(
                           sequence(
                               optional(
                                   token("NOT")
                               ),
                               token("INVALID"),
                               optional(
                                   token("KEY")
                               )
                           ),
                           token("END-START"),
                           token("."),
                           endOfStatement()
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
                       token("END-START")
                   )
               )
           );
        }

        return startStatementParser;
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
                       sequence(
                           token("REPLACING"),
                           plus(
                               sequence(
                                   choice(
                                       identifier(),
                                       literal(),
                                       pseudoLiteral()
                                   ),
                                   token("BY"),
                                   choice(
                                       identifier(),
                                       literal(),
                                       pseudoLiteral()
                                   )
                               )
                           )
                       )
                   ),
                   token(".")
               )
           );
        }

        return copyStatementParser;
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
                       token("IDENTIFICATION"),
                       token("ENVIRONMENT"),
                       token("DATA"),
                       token("PROCEDURE")
                   ),
                   token("DIVISION"),
                   optional(
                       usingPhrase()
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
                   identifier_format2()
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
    // argument
    // ........................................................

    private Parser argumentParser = null;

    public Parser argument() {
        if (argumentParser == null) {
           FutureParser future = scoped("argument");
           argumentParser = future;
           future.setParser(
               choice(
                   identifier(),
                   arithmeticExpression(),
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
                   integer(),
                   identifier(),
                   token("ALL")
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
                   timesDiv(),
                   star(
                       sequence(
                           choice(
                               token("+"),
                               token("-")
                           ),
                           timesDiv()
                       )
                   )
               )
           );
        }

        return arithmeticExpressionParser;
    }

    // ========================================================
    // timesDiv
    // ........................................................

    private Parser timesDivParser = null;

    public Parser timesDiv() {
        if (timesDivParser == null) {
           FutureParser future = scoped("timesDiv");
           timesDivParser = future;
           future.setParser(
               sequence(
                   power(),
                   star(
                       sequence(
                           choice(
                               token("*"),
                               token("/")
                           ),
                           power()
                       )
                   )
               )
           );
        }

        return timesDivParser;
    }

    // ========================================================
    // power
    // ........................................................

    private Parser powerParser = null;

    public Parser power() {
        if (powerParser == null) {
           FutureParser future = scoped("power");
           powerParser = future;
           future.setParser(
               sequence(
                   optional(
                       choice(
                           token("+"),
                           token("-")
                       )
                   ),
                   basis(),
                   star(
                       sequence(
                           token("**"),
                           basis()
                       )
                   )
               )
           );
        }

        return powerParser;
    }

    // ========================================================
    // basis
    // ........................................................

    private Parser basisParser = null;

    public Parser basis() {
        if (basisParser == null) {
           FutureParser future = scoped("basis");
           basisParser = future;
           future.setParser(
               choice(
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

        return basisParser;
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
               skipto(
                   choice(
                       token("THEN"),
                       verb(),
                       sequence(
                           token("NEXT"),
                           token("SENTENCE")
                       ),
                       token("END-PERFORM"),
                       token("AFTER"),
                       token("WHEN"),
                       token("ALSO"),
                       token(".")
                   )
               )
           );
        }

        return conditionParser;
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
               cobolWord()
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
    // fileName
    // ........................................................

    private Parser fileNameParser = null;

    public Parser fileName() {
        if (fileNameParser == null) {
           FutureParser future = scoped("fileName");
           fileNameParser = future;
           future.setParser(
               cobolWord()
           );
        }

        return fileNameParser;
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
               cobolWord()
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
               cobolWord()
           );
        }

        return mnemonicNameParser;
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
                   numeric(),
                   alphanumeric(),
                   figurativeConstant()
               )
           );
        }

        return literalParser;
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
                   )
               )
           );
        }

        return figurativeConstantParser;
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
    // Code provided by the user.
    // --------------------------------------------------------

    // Note: If you add/remove parsers in the kg-usercode file
    // you will need to update the antlr-tokens and antlr-rules
    // files as well!

    // ========================================================
    // cobolWord
    // ........................................................

    private Parser cobolWordParser = null;

    public Parser cobolWord() {
    	if (cobolWordParser == null) {
    	    FutureParser future = scoped("cobolWord");
    	    cobolWordParser = future;
    	    future.setParser(new Parser() {
    			protected boolean accepts(TokenStream stream) {
    	            final Token token = stream.nextToken();
    	
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
    	            if (len < 1 || len > 31)
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

    // ========================================================
    // integer
    // ........................................................

    private Parser integerParser = null;

    public Parser integer() {
    	if (integerParser == null) {
    	    FutureParser future = scoped("integer");
    	    integerParser = future;
    	    future.setParser(new Parser() {
    			protected boolean accepts(TokenStream stream) {
    				final Token token = stream.nextToken();
    	
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
    	return integerParser;
    }

    // ========================================================
    // decimal
    // ........................................................

    private Parser decimalParser = null;

    public Parser decimal() {
    	if (decimalParser == null) {
    	    FutureParser future = scoped("decimal");
    	    decimalParser = future;
    	    future.setParser(new Parser() {
    			protected boolean accepts(TokenStream stream) {
    				final Token token = stream.nextToken();
    	
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

    // ========================================================
    // alphanumeric
    // ........................................................

    private Parser alphanumericParser = null;

    public Parser alphanumeric() {
    	if (alphanumericParser == null) {
    	    FutureParser future = scoped("alphanumeric");
    	    alphanumericParser = future;
    	    future.setParser(new Parser() {
    			protected boolean accepts(TokenStream stream) {
    				final Token token = stream.nextToken();
    	
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
    	return alphanumericParser;
    }

    // ========================================================
    // pictureString
    // ........................................................

    private Parser pictureStringParser = null;

    public Parser pictureString() {
    	if (pictureStringParser == null) {
    	    FutureParser future = scoped("pictureString");
    	    pictureStringParser = future;
    	    future.setParser(new Parser() {
    			protected boolean accepts(TokenStream stream) {
    	
    				boolean inParen = false;
    				int count = 0;
    				CompositeToken picture = new CompositeToken();
    				int lastPosition = -1;
    				while (true) {
    					final Token token = stream.nextToken();
    	
    					if (token == null) {
    						break;
    					}
    	
    					if (lastPosition >= 0
    							&& token.getStart().getPositionInFile() != lastPosition + 1) {
    						// Token is separated from rest of picture. Hence it is
    						// not part of the picture.
    						stream.pushback(token);
    						break;
    	
    					} else {
    						lastPosition = token.getEnd().getPositionInFile();
    					}
    	
    					if (!inParen && token.hasTag(SyntacticTag.SEPARATOR)
    							&& token.getText().equals("(")) {
    						picture.addToken(token);
    						inParen = true;
    						count = 0;
    						continue;
    					}
    	
    					if (inParen && token.hasTag(SyntacticTag.SEPARATOR)
    							&& token.getText().equals(")")) {
    						picture.addToken(token);
    						inParen = false;
    						count = 0;
    						continue;
    					}
    	
    					if (inParen && count == 0
    							&& token.hasTag(SyntacticTag.INTEGER_LITERAL)) {
    						picture.addToken(token);
    						count = 1;
    						continue;
    					}
    	
    					if (!inParen
    							&& count == 0
    							&& token
    									.hasTag(SyntacticTag.CHARACTER_STRING)) {
    						// TODO Should check if text is valid in a picture.
    						picture.addToken(token);
    						count = 1;
    						continue;
    					}
    	
    					// Token not part of picture.
    					stream.pushback(token);
    					break;
    				}
    	
    				if (!inParen && picture.size() > 0) {
    					returnToken(picture.size() == 1 ? picture.getToken(0)
    							: picture);
    					return true;
    	
    				} else
    					return false;
    			}
    		});
    	}
    	return pictureStringParser;
    }

    // ========================================================
    // levelNumber
    // ........................................................

    private Parser levelNumberParser = null;

    public Parser levelNumber() {
    	if (levelNumberParser == null) {
    	    FutureParser future = scoped("levelNumber");
    	    levelNumberParser = future;
    	    future.setParser(new Parser() {
    			protected boolean accepts(TokenStream stream) {
    	            final Token token = stream.nextToken();
    	
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

    // ========================================================
    // pseudo literal
    // ........................................................

    private Parser pseudoLiteralParser = null;

    public Parser pseudoLiteral() {
    	if (pseudoLiteralParser == null) {
    	    FutureParser future = scoped("pseudoLiteral");
    	    pseudoLiteralParser = future;
    	    future.setParser(new Parser() {
    			protected boolean accepts(TokenStream stream) {
    				final Token token = stream.nextToken();
    	
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