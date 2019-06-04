package koopa.cobol.grammar.preprocessing;

import koopa.core.data.markers.Start;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.FutureParser;

import static koopa.core.parsers.combinators.Opt.NOSKIP;
import static koopa.core.grammars.combinators.Scoped.Visibility.PUBLIC;
import static koopa.core.grammars.combinators.Scoped.Visibility.PRIVATE;
import static koopa.core.grammars.combinators.Scoped.Visibility.HIDING;

import koopa.cobol.grammar.preprocessing.CobolPreprocessingBaseGrammar;
import static koopa.core.data.tags.SyntacticTag.NUMBER;
import static koopa.core.data.tags.SyntacticTag.STRING;
import static koopa.core.data.tags.SyntacticTag.WORD;

/**
 * <b>This is generated code.<b>
 * <p>
 * @see <code>src/cobol/koopa/cobol/grammar/preprocessing/CobolPreprocessing.kg</code>
 */
public class CobolPreprocessingGrammar extends CobolPreprocessingBaseGrammar {
    private static CobolPreprocessingGrammar INSTANCE = null;

    protected CobolPreprocessingGrammar() {
    }
    
    public static CobolPreprocessingGrammar instance() {
      if (INSTANCE == null)
        INSTANCE = new CobolPreprocessingGrammar();
        
      return INSTANCE;
    }
    
    // ========================================================
    // preprocessing
    // ........................................................
    
    private ParserCombinator preprocessingParser = null;
    
    public final Start preprocessing = Start.on(getNamespace(), "preprocessing");
    
    public ParserCombinator preprocessing() {
      if (preprocessingParser == null) {
        FutureParser future = scoped("preprocessing", PUBLIC, true);
        preprocessingParser = future;
        future.setParser(
          star(
            sequence(
              skipto(
                preprocessingDirective()
              ),
              preprocessingDirective()
            )
          )
        );
      }
    
      return preprocessingParser;
    }
    
    // ========================================================
    // preprocessingDirective
    // ........................................................
    
    private ParserCombinator preprocessingDirectiveParser = null;
    
    public final Start preprocessingDirective = Start.on(getNamespace(), "preprocessingDirective");
    
    public ParserCombinator preprocessingDirective() {
      if (preprocessingDirectiveParser == null) {
        FutureParser future = scoped("preprocessingDirective", PUBLIC, true);
        preprocessingDirectiveParser = future;
        future.setParser(
          choice(
            copyStatement(),
            replaceStatement()
          )
        );
      }
    
      return preprocessingDirectiveParser;
    }
    
    // ========================================================
    // copyStatement
    // ........................................................
    
    private ParserCombinator copyStatementParser = null;
    
    public final Start copyStatement = Start.on(getNamespace(), "copyStatement");
    
    public ParserCombinator copyStatement() {
      if (copyStatementParser == null) {
        FutureParser future = scoped("copyStatement", PUBLIC, true);
        copyStatementParser = future;
        future.setParser(
          sequence(
            copyStatementBody(),
            literal(".")
          )
        );
      }
    
      return copyStatementParser;
    }
    
    // ========================================================
    // copyStatementBody
    // ........................................................
    
    private ParserCombinator copyStatementBodyParser = null;
    
    protected final Start copyStatementBody = Start.on(getNamespace(), "copyStatementBody");
    
    protected ParserCombinator copyStatementBody() {
      if (copyStatementBodyParser == null) {
        FutureParser future = scoped("copyStatementBody", PRIVATE, true);
        copyStatementBodyParser = future;
        future.setParser(
          sequence(
            keyword("COPY"),
            textName(),
            optional(
              sequence(
                choice(
                  keyword("OF"),
                  keyword("IN")
                ),
                libraryName()
              )
            ),
            optional(
              sequence(
                keyword("SUPPRESS"),
                optional(
                  keyword("PRINTING")
                )
              )
            ),
            optional(
              copyStatementBody$replacing()
            )
          )
        );
      }
    
      return copyStatementBodyParser;
    }
    
    // ========================================================
    // replacing
    // ........................................................
    
    private ParserCombinator copyStatementBody$replacingParser = null;
    
    public final Start copyStatementBody$replacing = Start.on(getNamespace(), "replacing");
    
    public ParserCombinator copyStatementBody$replacing() {
      if (copyStatementBody$replacingParser == null) {
        FutureParser future = scoped("replacing", PUBLIC, true);
        copyStatementBody$replacingParser = future;
        future.setParser(
          sequence(
            keyword("REPLACING"),
            plus(
              replacementInstruction()
            )
          )
        );
      }
    
      return copyStatementBody$replacingParser;
    }
    
    // ========================================================
    // replacementInstruction
    // ........................................................
    
    private ParserCombinator replacementInstructionParser = null;
    
    public final Start replacementInstruction = Start.on(getNamespace(), "replacementInstruction");
    
    public ParserCombinator replacementInstruction() {
      if (replacementInstructionParser == null) {
        FutureParser future = scoped("replacementInstruction", PUBLIC, true);
        replacementInstructionParser = future;
        future.setParser(
          sequence(
            optional(
              choice(
                replacementInstruction$leading(),
                replacementInstruction$trailing()
              )
            ),
            replacementOperand(),
            keyword("BY"),
            replacementOperand()
          )
        );
      }
    
      return replacementInstructionParser;
    }
    
    // ========================================================
    // leading
    // ........................................................
    
    private ParserCombinator replacementInstruction$leadingParser = null;
    
    public final Start replacementInstruction$leading = Start.on(getNamespace(), "leading");
    
    public ParserCombinator replacementInstruction$leading() {
      if (replacementInstruction$leadingParser == null) {
        FutureParser future = scoped("leading", PUBLIC, true);
        replacementInstruction$leadingParser = future;
        future.setParser(
          keyword("LEADING")
        );
      }
    
      return replacementInstruction$leadingParser;
    }
    
    // ========================================================
    // trailing
    // ........................................................
    
    private ParserCombinator replacementInstruction$trailingParser = null;
    
    public final Start replacementInstruction$trailing = Start.on(getNamespace(), "trailing");
    
    public ParserCombinator replacementInstruction$trailing() {
      if (replacementInstruction$trailingParser == null) {
        FutureParser future = scoped("trailing", PUBLIC, true);
        replacementInstruction$trailingParser = future;
        future.setParser(
          keyword("TRAILING")
        );
      }
    
      return replacementInstruction$trailingParser;
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
            literal(),
            cobolWord()
          )
        );
      }
    
      return replacementOperandParser;
    }
    
    // ========================================================
    // replaceStatement
    // ........................................................
    
    private ParserCombinator replaceStatementParser = null;
    
    public final Start replaceStatement = Start.on(getNamespace(), "replaceStatement");
    
    public ParserCombinator replaceStatement() {
      if (replaceStatementParser == null) {
        FutureParser future = scoped("replaceStatement", PUBLIC, true);
        replaceStatementParser = future;
        future.setParser(
          sequence(
            keyword("REPLACE"),
            choice(
              replaceStatement$replacing(),
              replaceStatement$off()
            ),
            literal(".")
          )
        );
      }
    
      return replaceStatementParser;
    }
    
    // ========================================================
    // replacing
    // ........................................................
    
    private ParserCombinator replaceStatement$replacingParser = null;
    
    public final Start replaceStatement$replacing = Start.on(getNamespace(), "replacing");
    
    public ParserCombinator replaceStatement$replacing() {
      if (replaceStatement$replacingParser == null) {
        FutureParser future = scoped("replacing", PUBLIC, true);
        replaceStatement$replacingParser = future;
        future.setParser(
          sequence(
            optional(
              as("also",
                keyword("ALSO")
              )
            ),
            plus(
              replacementInstruction()
            )
          )
        );
      }
    
      return replaceStatement$replacingParser;
    }
    
    // ========================================================
    // off
    // ........................................................
    
    private ParserCombinator replaceStatement$offParser = null;
    
    public final Start replaceStatement$off = Start.on(getNamespace(), "off");
    
    public ParserCombinator replaceStatement$off() {
      if (replaceStatement$offParser == null) {
        FutureParser future = scoped("off", PUBLIC, true);
        replaceStatement$offParser = future;
        future.setParser(
          sequence(
            optional(
              as("last",
                keyword("LAST")
              )
            ),
            keyword("OFF")
          )
        );
      }
    
      return replaceStatement$offParser;
    }
    
    // ========================================================
    // textName
    // ........................................................
    
    private ParserCombinator textNameParser = null;
    
    public final Start textName = Start.on(getNamespace(), "textName");
    
    public ParserCombinator textName() {
      if (textNameParser == null) {
        FutureParser future = scoped("textName", PUBLIC, true);
        textNameParser = future;
        future.setParser(
          choice(
            cobolWord(),
            alphanumericLiteral()
          )
        );
      }
    
      return textNameParser;
    }
    
    // ========================================================
    // libraryName
    // ........................................................
    
    private ParserCombinator libraryNameParser = null;
    
    public final Start libraryName = Start.on(getNamespace(), "libraryName");
    
    public ParserCombinator libraryName() {
      if (libraryNameParser == null) {
        FutureParser future = scoped("libraryName", PUBLIC, true);
        libraryNameParser = future;
        future.setParser(
          choice(
            cobolWord(),
            alphanumericLiteral()
          )
        );
      }
    
      return libraryNameParser;
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
            numeric(),
            alphanumericLiteral()
          )
        );
      }
    
      return literalParser;
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
            integerLiteral(),
            decimal(),
            hexadecimal()
          )
        );
      }
    
      return numericParser;
    }
    
    // ========================================================
    // integerLiteral
    // ........................................................
    
    private ParserCombinator integerLiteralParser = null;
    
    public final Start integerLiteral = Start.on(getNamespace(), "integerLiteral");
    
    public ParserCombinator integerLiteral() {
      if (integerLiteralParser == null) {
        FutureParser future = scoped("integerLiteral", PUBLIC, true);
        integerLiteralParser = future;
        future.setParser(
          choice(
            sequence(
              literal("+"),
              opt(NOSKIP,
                uintgr()
              )
            ),
            sequence(
              literal("-"),
              opt(NOSKIP,
                uintgr()
              )
            ),
            sequence(
              uintgr(),
              opt(NOSKIP,
                choice(
                  at(
                    not(
                      choice(
                        literal("-"),
                        literal("_"),
                        sequence(
                          tagged(WORD),
                          any()
                        )
                      )
                    )
                  ),
                  eof()
                )
              )
            )
          )
        );
      }
    
      return integerLiteralParser;
    }
    
    // ========================================================
    // hexadecimal
    // ........................................................
    
    private ParserCombinator hexadecimalParser = null;
    
    public final Start hexadecimal = Start.on(getNamespace(), "hexadecimal");
    
    public ParserCombinator hexadecimal() {
      if (hexadecimalParser == null) {
        FutureParser future = scoped("hexadecimal", PUBLIC, true);
        hexadecimalParser = future;
        future.setParser(
          sequence(
            literal("H"),
            opt(NOSKIP,
              str()
            )
          )
        );
      }
    
      return hexadecimalParser;
    }
    
    // ========================================================
    // alphanumericHexadecimal
    // ........................................................
    
    private ParserCombinator alphanumericHexadecimalParser = null;
    
    public final Start alphanumericHexadecimal = Start.on(getNamespace(), "alphanumericHexadecimal");
    
    public ParserCombinator alphanumericHexadecimal() {
      if (alphanumericHexadecimalParser == null) {
        FutureParser future = scoped("alphanumericHexadecimal", PUBLIC, true);
        alphanumericHexadecimalParser = future;
        future.setParser(
          sequence(
            literal("X"),
            opt(NOSKIP,
              str()
            )
          )
        );
      }
    
      return alphanumericHexadecimalParser;
    }
    
    // ========================================================
    // nationalAlphanumericHexadecimal
    // ........................................................
    
    private ParserCombinator nationalAlphanumericHexadecimalParser = null;
    
    public final Start nationalAlphanumericHexadecimal = Start.on(getNamespace(), "nationalAlphanumericHexadecimal");
    
    public ParserCombinator nationalAlphanumericHexadecimal() {
      if (nationalAlphanumericHexadecimalParser == null) {
        FutureParser future = scoped("nationalAlphanumericHexadecimal", PUBLIC, true);
        nationalAlphanumericHexadecimalParser = future;
        future.setParser(
          sequence(
            literal("NX"),
            opt(NOSKIP,
              str()
            )
          )
        );
      }
    
      return nationalAlphanumericHexadecimalParser;
    }
    
    // ========================================================
    // booleanHexadecimal
    // ........................................................
    
    private ParserCombinator booleanHexadecimalParser = null;
    
    public final Start booleanHexadecimal = Start.on(getNamespace(), "booleanHexadecimal");
    
    public ParserCombinator booleanHexadecimal() {
      if (booleanHexadecimalParser == null) {
        FutureParser future = scoped("booleanHexadecimal", PUBLIC, true);
        booleanHexadecimalParser = future;
        future.setParser(
          sequence(
            literal("BX"),
            opt(NOSKIP,
              str()
            )
          )
        );
      }
    
      return booleanHexadecimalParser;
    }
    
    // ========================================================
    // hexadecimalLiteral
    // ........................................................
    
    private ParserCombinator hexadecimalLiteralParser = null;
    
    protected final Start hexadecimalLiteral = Start.on(getNamespace(), "hexadecimalLiteral");
    
    protected ParserCombinator hexadecimalLiteral() {
      if (hexadecimalLiteralParser == null) {
        FutureParser future = scoped("hexadecimalLiteral", PRIVATE, true);
        hexadecimalLiteralParser = future;
        future.setParser(
          choice(
            hexadecimal(),
            alphanumericHexadecimal(),
            nationalAlphanumericHexadecimal(),
            booleanHexadecimal()
          )
        );
      }
    
      return hexadecimalLiteralParser;
    }
    
    // ========================================================
    // booleanLiteral
    // ........................................................
    
    private ParserCombinator booleanLiteralParser = null;
    
    public final Start booleanLiteral = Start.on(getNamespace(), "booleanLiteral");
    
    public ParserCombinator booleanLiteral() {
      if (booleanLiteralParser == null) {
        FutureParser future = scoped("booleanLiteral", PUBLIC, true);
        booleanLiteralParser = future;
        future.setParser(
          choice(
            booleanHexadecimal(),
            sequence(
              literal("B"),
              opt(NOSKIP,
                str()
              )
            )
          )
        );
      }
    
      return booleanLiteralParser;
    }
    
    // ========================================================
    // nullTerminatedStringLiteral
    // ........................................................
    
    private ParserCombinator nullTerminatedStringLiteralParser = null;
    
    public final Start nullTerminatedStringLiteral = Start.on(getNamespace(), "nullTerminatedStringLiteral");
    
    public ParserCombinator nullTerminatedStringLiteral() {
      if (nullTerminatedStringLiteralParser == null) {
        FutureParser future = scoped("nullTerminatedStringLiteral", PUBLIC, true);
        nullTerminatedStringLiteralParser = future;
        future.setParser(
          sequence(
            literal("Z"),
            opt(NOSKIP,
              str()
            )
          )
        );
      }
    
      return nullTerminatedStringLiteralParser;
    }
    
    // ========================================================
    // nationalStringLiteral
    // ........................................................
    
    private ParserCombinator nationalStringLiteralParser = null;
    
    public final Start nationalStringLiteral = Start.on(getNamespace(), "nationalStringLiteral");
    
    public ParserCombinator nationalStringLiteral() {
      if (nationalStringLiteralParser == null) {
        FutureParser future = scoped("nationalStringLiteral", PUBLIC, true);
        nationalStringLiteralParser = future;
        future.setParser(
          sequence(
            literal("N"),
            opt(NOSKIP,
              str()
            )
          )
        );
      }
    
      return nationalStringLiteralParser;
    }
    
    // ========================================================
    // alphanumericLiteral
    // ........................................................
    
    private ParserCombinator alphanumericLiteralParser = null;
    
    public final Start alphanumericLiteral = Start.on(getNamespace(), "alphanumericLiteral");
    
    public ParserCombinator alphanumericLiteral() {
      if (alphanumericLiteralParser == null) {
        FutureParser future = scoped("alphanumericLiteral", PUBLIC, true);
        alphanumericLiteralParser = future;
        future.setParser(
          choice(
            alphanumericHexadecimal(),
            nationalAlphanumericHexadecimal(),
            nullTerminatedStringLiteral(),
            nationalStringLiteral(),
            str()
          )
        );
      }
    
      return alphanumericLiteralParser;
    }
    
    // ========================================================
    // str
    // ........................................................
    
    private ParserCombinator strParser = null;
    
    protected final Start str = Start.on(getNamespace(), "str");
    
    protected ParserCombinator str() {
      if (strParser == null) {
        FutureParser future = scoped("str", PRIVATE, true);
        strParser = future;
        future.setParser(
          sequence(
            sequence(
              tagged(STRING),
              any()
            ),
            optional(
              opt(NOSKIP,
                plus(
                  sequence(
                    tagged(STRING),
                    any()
                  )
                )
              )
            )
          )
        );
      }
    
      return strParser;
    }
    
    // ========================================================
    // pseudoLiteral
    // ........................................................
    
    private ParserCombinator pseudoLiteralParser = null;
    
    public final Start pseudoLiteral = Start.on(getNamespace(), "pseudoLiteral");
    
    public ParserCombinator pseudoLiteral() {
      if (pseudoLiteralParser == null) {
        FutureParser future = scoped("pseudoLiteral", PUBLIC, true);
        pseudoLiteralParser = future;
        future.setParser(
          sequence(
            sequence(
              literal("="),
              opt(NOSKIP,
                literal("=")
              )
            ),
            upto(
              star(
                any()
              ),
              // Closure:
              sequence(
                literal("="),
                opt(NOSKIP,
                  sequence(
                    literal("="),
                    not(
                      literal("=")
                    )
                  )
                )
              )
            ),
            sequence(
              literal("="),
              opt(NOSKIP,
                literal("=")
              )
            )
          )
        );
      }
    
      return pseudoLiteralParser;
    }
    
    // ========================================================
    // decimal
    // ........................................................
    
    private ParserCombinator decimalParser = null;
    
    public final Start decimal = Start.on(getNamespace(), "decimal");
    
    public ParserCombinator decimal() {
      if (decimalParser == null) {
        FutureParser future = scoped("decimal", PUBLIC, true);
        decimalParser = future;
        future.setParser(
          choice(
            sequence(
              choice(
                literal("+"),
                literal("-")
              ),
              opt(NOSKIP,
                unsigned_decimal()
              )
            ),
            unsigned_decimal()
          )
        );
      }
    
      return decimalParser;
    }
    
    // ========================================================
    // unsigned_decimal
    // ........................................................
    
    private ParserCombinator unsigned_decimalParser = null;
    
    protected final Start unsigned_decimal = Start.on(getNamespace(), "unsigned_decimal");
    
    protected ParserCombinator unsigned_decimal() {
      if (unsigned_decimalParser == null) {
        FutureParser future = scoped("unsigned_decimal", PRIVATE, true);
        unsigned_decimalParser = future;
        future.setParser(
          choice(
            sequence(
              uintgr(),
              opt(NOSKIP,
                sequence(
                  choice(
                    literal(","),
                    literal(".")
                  ),
                  uintgr()
                )
              )
            ),
            sequence(
              literal("."),
              opt(NOSKIP,
                uintgr()
              )
            )
          )
        );
      }
    
      return unsigned_decimalParser;
    }
    
    // ========================================================
    // uintgr
    // ........................................................
    
    private ParserCombinator uintgrParser = null;
    
    protected final Start uintgr = Start.on(getNamespace(), "uintgr");
    
    protected ParserCombinator uintgr() {
      if (uintgrParser == null) {
        FutureParser future = scoped("uintgr", PRIVATE, true);
        uintgrParser = future;
        future.setParser(
          sequence(
            tagged(NUMBER),
            any(),
            optional(
              opt(NOSKIP,
                plus(
                  sequence(
                    tagged(NUMBER),
                    any()
                  )
                )
              )
            )
          )
        );
      }
    
      return uintgrParser;
    }
    
}
