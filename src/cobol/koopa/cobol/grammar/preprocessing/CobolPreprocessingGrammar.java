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

import koopa.core.data.tags.AreaTag;
import koopa.cobol.grammar.preprocessing.CobolPreprocessingBaseGrammar;
import koopa.cobol.data.tags.SyntacticTag;
import static koopa.cobol.data.tags.SyntacticTag.UNSIGNED;
import koopa.core.data.tags.TokenizerTag;
import static koopa.cobol.data.tags.SyntacticTag.INTEGER_LITERAL;

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
        FutureParser future = scoped("preprocessing", PUBLIC);
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
        FutureParser future = scoped("preprocessingDirective", PUBLIC);
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
        FutureParser future = scoped("copyStatement", PUBLIC);
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
              sequence(
                token("SUPPRESS"),
                optional(
                  token("PRINTING")
                )
              )
            ),
            optional(
              copyReplacingPhrase()
            ),
            literal(".")
          )
        );
      }
    
      return copyStatementParser;
    }
    
    // ========================================================
    // copyReplacingPhrase
    // ........................................................
    
    private ParserCombinator copyReplacingPhraseParser = null;
    
    public final Start copyReplacingPhrase = Start.on(getNamespace(), "copyReplacingPhrase");
    
    public ParserCombinator copyReplacingPhrase() {
      if (copyReplacingPhraseParser == null) {
        FutureParser future = scoped("copyReplacingPhrase", PUBLIC);
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
    
    private ParserCombinator copyReplacementInstructionParser = null;
    
    public final Start copyReplacementInstruction = Start.on(getNamespace(), "copyReplacementInstruction");
    
    public ParserCombinator copyReplacementInstruction() {
      if (copyReplacementInstructionParser == null) {
        FutureParser future = scoped("copyReplacementInstruction", PUBLIC);
        copyReplacementInstructionParser = future;
        future.setParser(
          sequence(
            optional(
              choice(
                leading(),
                trailing()
              )
            ),
            copyOperandName(),
            token("BY"),
            copyOperandName()
          )
        );
      }
    
      return copyReplacementInstructionParser;
    }
    
    // ========================================================
    // leading
    // ........................................................
    
    private ParserCombinator leadingParser = null;
    
    public final Start leading = Start.on(getNamespace(), "leading");
    
    public ParserCombinator leading() {
      if (leadingParser == null) {
        FutureParser future = scoped("leading", PUBLIC);
        leadingParser = future;
        future.setParser(
          token("LEADING")
        );
      }
    
      return leadingParser;
    }
    
    // ========================================================
    // trailing
    // ........................................................
    
    private ParserCombinator trailingParser = null;
    
    public final Start trailing = Start.on(getNamespace(), "trailing");
    
    public ParserCombinator trailing() {
      if (trailingParser == null) {
        FutureParser future = scoped("trailing", PUBLIC);
        trailingParser = future;
        future.setParser(
          token("TRAILING")
        );
      }
    
      return trailingParser;
    }
    
    // ========================================================
    // copyOperandName
    // ........................................................
    
    private ParserCombinator copyOperandNameParser = null;
    
    public final Start copyOperandName = Start.on(getNamespace(), "copyOperandName");
    
    public ParserCombinator copyOperandName() {
      if (copyOperandNameParser == null) {
        FutureParser future = scoped("copyOperandName", PUBLIC);
        copyOperandNameParser = future;
        future.setParser(
          choice(
            pseudoLiteral(),
            literal(),
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
        FutureParser future = scoped("replaceStatement", PUBLIC);
        replaceStatementParser = future;
        future.setParser(
          choice(
            replaceStatement_format1(),
            replaceStatement_format2()
          )
        );
      }
    
      return replaceStatementParser;
    }
    
    // ========================================================
    // replaceStatement_format1
    // ........................................................
    
    private ParserCombinator replaceStatement_format1Parser = null;
    
    private final Start replaceStatement_format1 = Start.on(getNamespace(), "replaceStatement_format1");
    
    private ParserCombinator replaceStatement_format1() {
      if (replaceStatement_format1Parser == null) {
        FutureParser future = scoped("replaceStatement_format1", PRIVATE);
        replaceStatement_format1Parser = future;
        future.setParser(
          sequence(
            token("REPLACE"),
            optional(
              token("ALSO")
            ),
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
            ),
            literal(".")
          )
        );
      }
    
      return replaceStatement_format1Parser;
    }
    
    // ========================================================
    // replaceStatement_format2
    // ........................................................
    
    private ParserCombinator replaceStatement_format2Parser = null;
    
    private final Start replaceStatement_format2 = Start.on(getNamespace(), "replaceStatement_format2");
    
    private ParserCombinator replaceStatement_format2() {
      if (replaceStatement_format2Parser == null) {
        FutureParser future = scoped("replaceStatement_format2", PRIVATE);
        replaceStatement_format2Parser = future;
        future.setParser(
          sequence(
            token("REPLACE"),
            optional(
              token("LAST")
            ),
            token("OFF"),
            literal(".")
          )
        );
      }
    
      return replaceStatement_format2Parser;
    }
    
    // ========================================================
    // textName
    // ........................................................
    
    private ParserCombinator textNameParser = null;
    
    public final Start textName = Start.on(getNamespace(), "textName");
    
    public ParserCombinator textName() {
      if (textNameParser == null) {
        FutureParser future = scoped("textName", PUBLIC);
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
        FutureParser future = scoped("libraryName", PUBLIC);
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
        FutureParser future = scoped("literal", PUBLIC);
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
        FutureParser future = scoped("numeric", PUBLIC);
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
        FutureParser future = scoped("decimal", PUBLIC);
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
    
    private final Start unsigned_decimal = Start.on(getNamespace(), "unsigned_decimal");
    
    private ParserCombinator unsigned_decimal() {
      if (unsigned_decimalParser == null) {
        FutureParser future = scoped("unsigned_decimal", PRIVATE);
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
    
    private final Start intgr = Start.on(getNamespace(), "intgr");
    
    private ParserCombinator intgr() {
      if (intgrParser == null) {
        FutureParser future = scoped("intgr", PRIVATE);
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
    
    private final Start uintgr = Start.on(getNamespace(), "uintgr");
    
    private ParserCombinator uintgr() {
      if (uintgrParser == null) {
        FutureParser future = scoped("uintgr", PRIVATE);
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
