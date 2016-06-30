package koopa.cobol.grammar.preprocessing;

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
import koopa.cobol.grammar.preprocessing.CobolPreprocessingBaseGrammar;
import koopa.core.data.tags.AreaTag;

public class CobolPreprocessingGrammar extends CobolPreprocessingBaseGrammar {
    public CobolPreprocessingGrammar() {
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
              sequence(
                token("SUPPRESS"),
                optional(
                  token("PRINTING")
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
            token("REPLACING"),
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
            token("BY"),
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
          token("LEADING")
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
          token("TRAILING")
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
            token("REPLACE"),
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
                token("ALSO")
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
                token("LAST")
              )
            ),
            token("OFF")
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
              intgr(),
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
    // intgr
    // ........................................................
    
    private ParserCombinator intgrParser = null;
    
    protected final Start intgr = Start.on(getNamespace(), "intgr");
    
    protected ParserCombinator intgr() {
      if (intgrParser == null) {
        FutureParser future = scoped("intgr", PRIVATE, true);
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
    
    private ParserCombinator uintgrParser = null;
    
    protected final Start uintgr = Start.on(getNamespace(), "uintgr");
    
    protected ParserCombinator uintgr() {
      if (uintgrParser == null) {
        FutureParser future = scoped("uintgr", PRIVATE, true);
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
