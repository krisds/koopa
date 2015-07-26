package koopa.cobol.cics.grammar;

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

import koopa.cobol.cics.grammar.CICSBaseGrammar;
import static koopa.cobol.data.tags.SyntacticTag.SEPARATOR;

public class CICSGrammar extends CICSBaseGrammar {
    public CICSGrammar() {
    }
    
    // ========================================================
    // cicsStatement
    // ........................................................
    
    private ParserCombinator cicsStatementParser = null;
    
    public final Start cicsStatement = Start.on(getNamespace(), "cicsStatement");
    
    public ParserCombinator cicsStatement() {
      if (cicsStatementParser == null) {
        FutureParser future = scoped("cicsStatement", true);
        cicsStatementParser = future;
        future.setParser(
          sequence(
            command(),
            star(
              option()
            )
          )
        );
      }
    
      return cicsStatementParser;
    }
    
    // ========================================================
    // command
    // ........................................................
    
    private ParserCombinator commandParser = null;
    
    public final Start command = Start.on(getNamespace(), "command");
    
    public ParserCombinator command() {
      if (commandParser == null) {
        FutureParser future = scoped("command", true);
        commandParser = future;
        future.setParser(
          choice(
            token("ABEND"),
            token("ACQUIRE"),
            token("ADD"),
            token("ADDRESS"),
            token("ALLOCATE"),
            token("ASKTIME"),
            token("ASSIGN"),
            token("BIF"),
            token("BUILD"),
            token("CANCEL"),
            token("CHANGE"),
            token("CHECK"),
            token("CONNECT"),
            token("CONVERSE"),
            token("CONVERTTIME"),
            token("DEFINE"),
            token("DELAY"),
            token("DELETE"),
            token("DELETEQ"),
            token("DEQ"),
            token("DOCUMENT"),
            token("DUMP"),
            token("ENDBR"),
            token("ENDBROWSE"),
            token("ENQ"),
            token("ENTER"),
            token("EXTRACT"),
            token("FORCE"),
            token("FORMATTIME"),
            token("FREE"),
            token("FREEMAIN"),
            token("GET"),
            token("GETMAIN"),
            token("GETNEXT"),
            token("HANDLE"),
            token("IGNORE"),
            token("INQUIRE"),
            token("INVOKE"),
            token("ISSUE"),
            token("JOURNAL"),
            token("LINK"),
            token("LOAD"),
            token("MONITOR"),
            token("MOVE"),
            token("POINT"),
            token("POP"),
            token("POST"),
            token("PURGE"),
            token("PUSH"),
            token("PUT"),
            token("QUERY"),
            token("READ"),
            token("READNEXT"),
            token("READPREV"),
            token("READQ"),
            token("RECEIVE"),
            token("RELEASE"),
            token("REMOVE"),
            token("RESET"),
            token("RESETBR"),
            token("RESUME"),
            token("RETRIEVE"),
            token("RETURN"),
            token("REWIND"),
            token("REWRITE"),
            token("ROUTE"),
            token("RUN"),
            token("SEND"),
            token("SIGNAL"),
            token("SIGNOFF"),
            token("SIGNON"),
            token("SOAPFAULT"),
            token("SPOOLCLOSE"),
            token("SPOOLOPEN"),
            token("SPOOLREAD"),
            token("SPOOLWRITE"),
            token("START"),
            token("STARTBR"),
            token("STARTBROWSE"),
            token("SUSPEND"),
            token("SYNCPOINT"),
            token("TEST"),
            token("TRANSFORM"),
            token("UNLOCK"),
            token("UPDATE"),
            token("VERIFY"),
            token("WAIT"),
            token("WAITCICS"),
            token("WEB"),
            token("WRITE"),
            token("WRITEQ"),
            token("WSACONTEXT"),
            token("WSAEPR"),
            token("XCTL")
          )
        );
      }
    
      return commandParser;
    }
    
    // ========================================================
    // option
    // ........................................................
    
    private ParserCombinator optionParser = null;
    
    public final Start option = Start.on(getNamespace(), "option");
    
    public ParserCombinator option() {
      if (optionParser == null) {
        FutureParser future = scoped("option", true);
        optionParser = future;
        future.setParser(
          sequence(
            name(),
            optional(
              sequence(
                literal("("),
                value(),
                literal(")")
              )
            )
          )
        );
      }
    
      return optionParser;
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
          sequence(
            not(
              literal("(")
            ),
            not(
              literal(")")
            ),
            any()
          )
        );
      }
    
      return nameParser;
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
          plus(
            param()
          )
        );
      }
    
      return valueParser;
    }
    
    // ========================================================
    // param
    // ........................................................
    
    private ParserCombinator paramParser = null;
    
    private final Start param = Start.on(getNamespace(), "param");
    
    private ParserCombinator param() {
      if (paramParser == null) {
        FutureParser future = scoped("param", false);
        paramParser = future;
        future.setParser(
          choice(
            sequence(
              literal("("),
              plus(
                param()
              ),
              literal(")")
            ),
            sequence(
              not(
                literal("(")
              ),
              not(
                literal(")")
              ),
              any()
            )
          )
        );
      }
    
      return paramParser;
    }
    
}
