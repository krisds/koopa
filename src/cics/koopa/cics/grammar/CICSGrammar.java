package koopa.cics.grammar;

import koopa.core.data.markers.Start;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.FutureParser;

import static koopa.core.parsers.combinators.Opt.NOSKIP;
import static koopa.core.grammars.combinators.Scoped.Visibility.PUBLIC;
import static koopa.core.grammars.combinators.Scoped.Visibility.PRIVATE;
import static koopa.core.grammars.combinators.Scoped.Visibility.HIDING;

import koopa.cics.grammar.CICSBaseGrammar;

/**
 * <b>This is generated code.<b>
 * <p>
 * @see <code>src/cics/koopa/cics/grammar/CICS.kg</code>
 */
public class CICSGrammar extends CICSBaseGrammar {
    private static CICSGrammar INSTANCE = null;

    protected CICSGrammar() {
    }
    
    public static CICSGrammar instance() {
      if (INSTANCE == null)
        INSTANCE = new CICSGrammar();
        
      return INSTANCE;
    }
    
    // ========================================================
    // cicsStatement
    // ........................................................
    
    private ParserCombinator cicsStatementParser = null;
    
    public final Start cicsStatement = Start.on(getNamespace(), "cicsStatement");
    
    public ParserCombinator cicsStatement() {
      if (cicsStatementParser == null) {
        FutureParser future = scoped("cicsStatement", PUBLIC, true);
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
        FutureParser future = scoped("command", PUBLIC, true);
        commandParser = future;
        future.setParser(
          choice(
            keyword("ABEND"),
            keyword("ACQUIRE"),
            keyword("ADD"),
            keyword("ADDRESS"),
            keyword("ALLOCATE"),
            keyword("ASKTIME"),
            keyword("ASSIGN"),
            keyword("BIF"),
            keyword("BUILD"),
            keyword("CANCEL"),
            keyword("CHANGE"),
            keyword("CHECK"),
            keyword("CONNECT"),
            keyword("CONVERSE"),
            keyword("CONVERTTIME"),
            keyword("DEFINE"),
            keyword("DELAY"),
            keyword("DELETE"),
            keyword("DELETEQ"),
            keyword("DEQ"),
            keyword("DOCUMENT"),
            keyword("DUMP"),
            keyword("ENDBR"),
            keyword("ENDBROWSE"),
            keyword("ENQ"),
            keyword("ENTER"),
            keyword("EXTRACT"),
            keyword("FORCE"),
            keyword("FORMATTIME"),
            keyword("FREE"),
            keyword("FREEMAIN"),
            keyword("GET"),
            keyword("GETMAIN"),
            keyword("GETNEXT"),
            keyword("HANDLE"),
            keyword("IGNORE"),
            keyword("INQUIRE"),
            keyword("INVOKE"),
            keyword("ISSUE"),
            keyword("JOURNAL"),
            keyword("LINK"),
            keyword("LOAD"),
            keyword("MONITOR"),
            keyword("MOVE"),
            keyword("POINT"),
            keyword("POP"),
            keyword("POST"),
            keyword("PURGE"),
            keyword("PUSH"),
            keyword("PUT"),
            keyword("QUERY"),
            keyword("READ"),
            keyword("READNEXT"),
            keyword("READPREV"),
            keyword("READQ"),
            keyword("RECEIVE"),
            keyword("RELEASE"),
            keyword("REMOVE"),
            keyword("RESET"),
            keyword("RESETBR"),
            keyword("RESUME"),
            keyword("RETRIEVE"),
            keyword("RETURN"),
            keyword("REWIND"),
            keyword("REWRITE"),
            keyword("ROUTE"),
            keyword("RUN"),
            keyword("SEND"),
            keyword("SIGNAL"),
            keyword("SIGNOFF"),
            keyword("SIGNON"),
            keyword("SOAPFAULT"),
            keyword("SPOOLCLOSE"),
            keyword("SPOOLOPEN"),
            keyword("SPOOLREAD"),
            keyword("SPOOLWRITE"),
            keyword("START"),
            keyword("STARTBR"),
            keyword("STARTBROWSE"),
            keyword("SUSPEND"),
            keyword("SYNCPOINT"),
            keyword("TEST"),
            keyword("TRANSFORM"),
            keyword("UNLOCK"),
            keyword("UPDATE"),
            keyword("VERIFY"),
            keyword("WAIT"),
            keyword("WAITCICS"),
            keyword("WEB"),
            keyword("WRITE"),
            keyword("WRITEQ"),
            keyword("WSACONTEXT"),
            keyword("WSAEPR"),
            keyword("XCTL")
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
        FutureParser future = scoped("option", PUBLIC, true);
        optionParser = future;
        future.setParser(
          choice(
            as("map",
              sequence(
                keyword("MAP"),
                optional(
                  sequence(
                    literal("("),
                    value(),
                    literal(")")
                  )
                )
              )
            ),
            as("queue",
              sequence(
                keyword("QUEUE"),
                optional(
                  sequence(
                    literal("("),
                    value(),
                    literal(")")
                  )
                )
              )
            ),
            as("file",
              sequence(
                keyword("FILE"),
                optional(
                  sequence(
                    literal("("),
                    value(),
                    literal(")")
                  )
                )
              )
            ),
            as("resp",
              sequence(
                keyword("RESP"),
                optional(
                  sequence(
                    literal("("),
                    value(),
                    literal(")")
                  )
                )
              )
            ),
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
        FutureParser future = scoped("name", PUBLIC, true);
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
        FutureParser future = scoped("value", PUBLIC, true);
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
    
    protected final Start param = Start.on(getNamespace(), "param");
    
    protected ParserCombinator param() {
      if (paramParser == null) {
        FutureParser future = scoped("param", PRIVATE, true);
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
