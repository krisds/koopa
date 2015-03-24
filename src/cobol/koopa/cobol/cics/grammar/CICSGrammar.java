package koopa.cobol.cics.grammar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import koopa.core.data.Token;
import koopa.core.grammars.Block;
import koopa.core.grammars.KoopaGrammar;
import koopa.core.parsers.Parser;
import koopa.core.parsers.FutureParser;
import koopa.core.parsers.ParseStream;

import static koopa.core.grammars.Opt.NOSKIP;

import koopa.cobol.cics.grammar.CICSBaseGrammar;

public class CICSGrammar extends CICSBaseGrammar {
    public CICSGrammar() {
    }
    
    // ========================================================
    // Compiled grammar rules. These were generated from the
    // grammar.
    // --------------------------------------------------------

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
                   cicsStart(),
                   cicsSendMap(),
                   cicsReceiveMap()
               )
           );
        }

        return cicsStatementParser;
    }

    // ========================================================
    // cicsSendMap
    // ........................................................

    private Parser cicsSendMapParser = null;

    public Parser cicsSendMap() {
        if (cicsSendMapParser == null) {
           FutureParser future = scoped("cicsSendMap");
           cicsSendMapParser = future;
           future.setParser(
               sequence(
                   token("SEND"),
                   token("MAP"),
                   token("("),
                   mapName(),
                   token(")"),
                   optional(
                       permuted(
                           sequence(
                               token("MAPSET"),
                               token("("),
                               mapsetName(),
                               token(")")
                           ),
                           sequence(
                               token("FROM"),
                               token("("),
                               dataArea(),
                               token(")")
                           ),
                           sequence(
                               token("LENGTH"),
                               token("("),
                               dataValue(),
                               token(")")
                           ),
                           choice(
                               token("DATAONLY"),
                               token("MAPONLY")
                           ),
                           sequence(
                               token("CURSOR"),
                               optional(
                                   sequence(
                                       token("("),
                                       cursorDataValue(),
                                       token(")")
                                   )
                               )
                           ),
                           token("FORMFEED"),
                           choice(
                               token("ERASE"),
                               token("ERASEAUP")
                           ),
                           token("PRINT"),
                           token("FREEKB"),
                           token("ALARM"),
                           token("FRSET"),
                           token("FORMFEED"),
                           token("NLEOM"),
                           token("ACCUM"),
                           choice(
                               token("PAGING"),
                               sequence(
                                   token("TERMINAL"),
                                   optional(
                                       token("WAIT")
                                   )
                               )
                           ),
                           token("LAST"),
                           choice(
                               token("L40"),
                               token("L64"),
                               token("L80"),
                               token("HONEOM")
                           ),
                           sequence(
                               token("REQID"),
                               token("("),
                               any(),
                               token(")")
                           )
                       )
                   )
               )
           );
        }

        return cicsSendMapParser;
    }

    // ========================================================
    // cicsReceiveMap
    // ........................................................

    private Parser cicsReceiveMapParser = null;

    public Parser cicsReceiveMap() {
        if (cicsReceiveMapParser == null) {
           FutureParser future = scoped("cicsReceiveMap");
           cicsReceiveMapParser = future;
           future.setParser(
               sequence(
                   token("RECEIVE"),
                   token("MAP"),
                   token("("),
                   mapName(),
                   token(")"),
                   optional(
                       permuted(
                           sequence(
                               token("MAPSET"),
                               token("("),
                               mapsetName(),
                               token(")")
                           ),
                           sequence(
                               token("INTO"),
                               token("("),
                               dataArea(),
                               token(")")
                           ),
                           sequence(
                               token("FROM"),
                               token("("),
                               dataArea(),
                               token(")")
                           ),
                           sequence(
                               token("LENGTH"),
                               token("("),
                               dataValue(),
                               token(")")
                           ),
                           sequence(
                               token("SET"),
                               token("("),
                               ptrRef(),
                               token(")")
                           ),
                           token("TERMINAL"),
                           token("ASIS")
                       )
                   )
               )
           );
        }

        return cicsReceiveMapParser;
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
                           optional(
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
                           )
                       ),
                       sequence(
                           token("TD"),
                           token("QUEUE"),
                           token("("),
                           any(),
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
                           optional(
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
                       optional(
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
                                   token(")")
                               ),
                               sequence(
                                   token("RIDFLD"),
                                   cicsWaterInBrackets()
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
                               token("NOSUSPEND"),
                               sequence(
                                   token("LENGTH"),
                                   cicsWaterInBrackets()
                               ),
                               sequence(
                                   token("KEYLENGTH"),
                                   cicsWaterInBrackets(),
                                   optional(
                                       token("GENERIC")
                                   )
                               )
                           )
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
                       optional(
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
                   optional(
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
                   optional(
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
                   optional(
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
    // mapName
    // ........................................................

    private Parser mapNameParser = null;

    public Parser mapName() {
        if (mapNameParser == null) {
           FutureParser future = scoped("mapName");
           mapNameParser = future;
           future.setParser(
               any()
           );
        }

        return mapNameParser;
    }

    // ========================================================
    // mapsetName
    // ........................................................

    private Parser mapsetNameParser = null;

    public Parser mapsetName() {
        if (mapsetNameParser == null) {
           FutureParser future = scoped("mapsetName");
           mapsetNameParser = future;
           future.setParser(
               any()
           );
        }

        return mapsetNameParser;
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
               any()
           );
        }

        return dataAreaParser;
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
               any()
           );
        }

        return dataValueParser;
    }

    // ========================================================
    // cursorDataValue
    // ........................................................

    private Parser cursorDataValueParser = null;

    public Parser cursorDataValue() {
        if (cursorDataValueParser == null) {
           FutureParser future = scoped("cursorDataValue");
           cursorDataValueParser = future;
           future.setParser(
               any()
           );
        }

        return cursorDataValueParser;
    }

    // ========================================================
    // ptrRef
    // ........................................................

    private Parser ptrRefParser = null;

    public Parser ptrRef() {
        if (ptrRefParser == null) {
           FutureParser future = scoped("ptrRef");
           ptrRefParser = future;
           future.setParser(
               any()
           );
        }

        return ptrRefParser;
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
               any()
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
               any()
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
               any()
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
               any()
           );
        }

        return commareaNameParser;
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
               any()
           );
        }

        return fileNameParser;
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
               any()
           );
        }

        return programIDParser;
    }

}