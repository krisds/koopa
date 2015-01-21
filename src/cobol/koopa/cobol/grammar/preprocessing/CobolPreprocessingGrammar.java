package koopa.cobol.grammar.preprocessing;

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
    // Compiled grammar rules. These were generated from the
    // grammar.
    // --------------------------------------------------------

    // ========================================================
    // preprocessing
    // ........................................................

    private Parser preprocessingParser = null;

    public Parser preprocessing() {
        if (preprocessingParser == null) {
           FutureParser future = scoped("preprocessing");
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

    private Parser preprocessingDirectiveParser = null;

    public Parser preprocessingDirective() {
        if (preprocessingDirectiveParser == null) {
           FutureParser future = scoped("preprocessingDirective");
           preprocessingDirectiveParser = future;
           future.setParser(
               copyStatement()
           );
        }

        return preprocessingDirectiveParser;
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
                   sequence(
                       optional(
                           choice(
                               token("LEADING"),
                               token("TRAILING")
                           )
                       ),
                       pseudoLiteral()
                   ),
                   literal(),
                   cobolWord()
               )
           );
        }

        return copyOperandNameParser;
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
                   alphanumericLiteral()
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
                   alphanumericLiteral()
               )
           );
        }

        return literalParser;
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

    private Parser decimalParser = null;

    public Parser decimal() {
        if (decimalParser == null) {
           FutureParser future = scoped("decimal");
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

    public Parser intgr() {
        if (intgrParser == null) {
           FutureParser future = scoped("intgr");
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

    public Parser uintgr() {
        if (uintgrParser == null) {
           FutureParser future = scoped("uintgr");
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