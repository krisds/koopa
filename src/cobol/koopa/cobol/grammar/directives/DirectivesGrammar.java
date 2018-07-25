package koopa.cobol.grammar.directives;

import koopa.core.data.markers.Start;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.FutureParser;

import static koopa.core.parsers.combinators.Opt.NOSKIP;
import static koopa.core.grammars.combinators.Scoped.Visibility.PUBLIC;
import static koopa.core.grammars.combinators.Scoped.Visibility.PRIVATE;
import static koopa.core.grammars.combinators.Scoped.Visibility.HIDING;

import koopa.cobol.grammar.directives.DirectivesBaseGrammar;
import static koopa.cobol.data.tags.CobolAreaTag.SEQUENCE_NUMBER_AREA;
import static koopa.cobol.sources.SourceFormat.FIXED;
import static koopa.cobol.sources.SourceFormat.FREE;
import static koopa.cobol.sources.SourceFormat.VARIABLE;
import static koopa.core.data.tags.SyntacticTag.NUMBER;
import static koopa.core.data.tags.SyntacticTag.STRING;
import static koopa.core.data.tags.SyntacticTag.WHITESPACE;
import static koopa.core.data.tags.SyntacticTag.WORD;

/**
 * <b>This is generated code.<b>
 * <p>
 * @see <code>src/cobol/koopa/cobol/grammar/directives/Directives.kg</code>
 */
public class DirectivesGrammar extends DirectivesBaseGrammar {
    private static DirectivesGrammar INSTANCE = null;

    protected DirectivesGrammar() {
    }
    
    public static DirectivesGrammar instance() {
      if (INSTANCE == null)
        INSTANCE = new DirectivesGrammar();
        
      return INSTANCE;
    }
    
    // ========================================================
    // directive
    // ........................................................
    
    private ParserCombinator directiveParser = null;
    
    public final Start directive = Start.on(getNamespace(), "directive");
    
    public ParserCombinator directive() {
      if (directiveParser == null) {
        FutureParser future = scoped("directive", PUBLIC, true);
        directiveParser = future;
        future.setParser(
          choice(
            iso(),
            ibm(),
            mf(),
            listing()
          )
        );
      }
    
      return directiveParser;
    }
    
    // ========================================================
    // iso
    // ........................................................
    
    private ParserCombinator isoParser = null;
    
    public final Start iso = Start.on(getNamespace(), "iso");
    
    public ParserCombinator iso() {
      if (isoParser == null) {
        FutureParser future = scoped("iso", PUBLIC, true);
        isoParser = future;
        future.setParser(
          sequence(
            optional(
              as("sequenceNumber",
                sequence(
                  tagged(FIXED),
                  plus(
                    sequence(
                      ranged(1, 6),
                      any()
                    )
                  )
                )
              )
            ),
            iso$indicator(),
            iso$instruction(),
            optional(
              inlineComment()
            )
          )
        );
      }
    
      return isoParser;
    }
    
    // ========================================================
    // indicator
    // ........................................................
    
    private ParserCombinator iso$indicatorParser = null;
    
    protected final Start iso$indicator = Start.on(getNamespace(), "indicator");
    
    protected ParserCombinator iso$indicator() {
      if (iso$indicatorParser == null) {
        FutureParser future = scoped("indicator", PRIVATE, true);
        iso$indicatorParser = future;
        future.setParser(
          sequence(
            choice(
              tagged(FREE),
              ranged(8, -1)
            ),
            sequence(
              literal(">"),
              opt(NOSKIP,
                literal(">")
              )
            )
          )
        );
      }
    
      return iso$indicatorParser;
    }
    
    // ========================================================
    // instruction
    // ........................................................
    
    private ParserCombinator iso$instructionParser = null;
    
    public final Start iso$instruction = Start.on(getNamespace(), "instruction");
    
    public ParserCombinator iso$instruction() {
      if (iso$instructionParser == null) {
        FutureParser future = scoped("instruction", PUBLIC, true);
        iso$instructionParser = future;
        future.setParser(
          upto(
            choice(
              as("else",
                keyword("ELSE")
              ),
              as("endEvaluate",
                keyword("END-EVALUATE")
              ),
              as("endIf",
                keyword("END-IF")
              ),
              iso$instruction$source(),
              iso$instruction$callConvention(),
              iso$instruction$define(),
              iso$instruction$evaluate(),
              iso$instruction$when(),
              iso$instruction$flag02(),
              iso$instruction$flag85(),
              iso$instruction$flagNativeArithmetic(),
              iso$instruction$if(),
              iso$instruction$leapSecond(),
              iso$instruction$listing(),
              iso$instruction$page(),
              iso$instruction$propagate(),
              iso$instruction$checking(),
              iso$instruction$repository()
            ),
            // Closure:
            choice(
              eof(),
              inlineCommentIndicator()
            )
          )
        );
      }
    
      return iso$instructionParser;
    }
    
    // ========================================================
    // source
    // ........................................................
    
    private ParserCombinator iso$instruction$sourceParser = null;
    
    public final Start iso$instruction$source = Start.on(getNamespace(), "source");
    
    public ParserCombinator iso$instruction$source() {
      if (iso$instruction$sourceParser == null) {
        FutureParser future = scoped("source", PUBLIC, true);
        iso$instruction$sourceParser = future;
        future.setParser(
          sequence(
            keyword("SOURCE"),
            optional(
              keyword("FORMAT")
            ),
            optional(
              keyword("IS")
            ),
            as("format",
              choice(
                keyword("FIXED"),
                keyword("FREE")
              )
            )
          )
        );
      }
    
      return iso$instruction$sourceParser;
    }
    
    // ========================================================
    // callConvention
    // ........................................................
    
    private ParserCombinator iso$instruction$callConventionParser = null;
    
    public final Start iso$instruction$callConvention = Start.on(getNamespace(), "callConvention");
    
    public ParserCombinator iso$instruction$callConvention() {
      if (iso$instruction$callConventionParser == null) {
        FutureParser future = scoped("callConvention", PUBLIC, true);
        iso$instruction$callConventionParser = future;
        future.setParser(
          sequence(
            keyword("CALL-CONVENTION"),
            as("unknown",
              plus(
                any()
              )
            )
          )
        );
      }
    
      return iso$instruction$callConventionParser;
    }
    
    // ========================================================
    // define
    // ........................................................
    
    private ParserCombinator iso$instruction$defineParser = null;
    
    public final Start iso$instruction$define = Start.on(getNamespace(), "define");
    
    public ParserCombinator iso$instruction$define() {
      if (iso$instruction$defineParser == null) {
        FutureParser future = scoped("define", PUBLIC, true);
        iso$instruction$defineParser = future;
        future.setParser(
          sequence(
            keyword("DEFINE"),
            as("unknown",
              plus(
                any()
              )
            )
          )
        );
      }
    
      return iso$instruction$defineParser;
    }
    
    // ========================================================
    // evaluate
    // ........................................................
    
    private ParserCombinator iso$instruction$evaluateParser = null;
    
    public final Start iso$instruction$evaluate = Start.on(getNamespace(), "evaluate");
    
    public ParserCombinator iso$instruction$evaluate() {
      if (iso$instruction$evaluateParser == null) {
        FutureParser future = scoped("evaluate", PUBLIC, true);
        iso$instruction$evaluateParser = future;
        future.setParser(
          sequence(
            keyword("EVALUATE"),
            choice(
              as("true",
                keyword("TRUE")
              ),
              as("unknown",
                plus(
                  any()
                )
              )
            )
          )
        );
      }
    
      return iso$instruction$evaluateParser;
    }
    
    // ========================================================
    // when
    // ........................................................
    
    private ParserCombinator iso$instruction$whenParser = null;
    
    public final Start iso$instruction$when = Start.on(getNamespace(), "when");
    
    public ParserCombinator iso$instruction$when() {
      if (iso$instruction$whenParser == null) {
        FutureParser future = scoped("when", PUBLIC, true);
        iso$instruction$whenParser = future;
        future.setParser(
          sequence(
            keyword("WHEN"),
            as("unknown",
              plus(
                any()
              )
            )
          )
        );
      }
    
      return iso$instruction$whenParser;
    }
    
    // ========================================================
    // flag02
    // ........................................................
    
    private ParserCombinator iso$instruction$flag02Parser = null;
    
    public final Start iso$instruction$flag02 = Start.on(getNamespace(), "flag02");
    
    public ParserCombinator iso$instruction$flag02() {
      if (iso$instruction$flag02Parser == null) {
        FutureParser future = scoped("flag02", PUBLIC, true);
        iso$instruction$flag02Parser = future;
        future.setParser(
          sequence(
            sequence(
              keyword("FLAG-"),
              opt(NOSKIP,
                number("02")
              )
            ),
            as("unknown",
              plus(
                any()
              )
            )
          )
        );
      }
    
      return iso$instruction$flag02Parser;
    }
    
    // ========================================================
    // flag85
    // ........................................................
    
    private ParserCombinator iso$instruction$flag85Parser = null;
    
    public final Start iso$instruction$flag85 = Start.on(getNamespace(), "flag85");
    
    public ParserCombinator iso$instruction$flag85() {
      if (iso$instruction$flag85Parser == null) {
        FutureParser future = scoped("flag85", PUBLIC, true);
        iso$instruction$flag85Parser = future;
        future.setParser(
          sequence(
            sequence(
              keyword("FLAG-"),
              opt(NOSKIP,
                number("85")
              )
            ),
            as("unknown",
              plus(
                any()
              )
            )
          )
        );
      }
    
      return iso$instruction$flag85Parser;
    }
    
    // ========================================================
    // flagNativeArithmetic
    // ........................................................
    
    private ParserCombinator iso$instruction$flagNativeArithmeticParser = null;
    
    public final Start iso$instruction$flagNativeArithmetic = Start.on(getNamespace(), "flagNativeArithmetic");
    
    public ParserCombinator iso$instruction$flagNativeArithmetic() {
      if (iso$instruction$flagNativeArithmeticParser == null) {
        FutureParser future = scoped("flagNativeArithmetic", PUBLIC, true);
        iso$instruction$flagNativeArithmeticParser = future;
        future.setParser(
          sequence(
            keyword("FLAG-NATIVE-ARITHMETIC"),
            as("unknown",
              plus(
                any()
              )
            )
          )
        );
      }
    
      return iso$instruction$flagNativeArithmeticParser;
    }
    
    // ========================================================
    // if
    // ........................................................
    
    private ParserCombinator iso$instruction$ifParser = null;
    
    public final Start iso$instruction$if = Start.on(getNamespace(), "if");
    
    public ParserCombinator iso$instruction$if() {
      if (iso$instruction$ifParser == null) {
        FutureParser future = scoped("if", PUBLIC, true);
        iso$instruction$ifParser = future;
        future.setParser(
          sequence(
            keyword("IF"),
            as("unknown",
              plus(
                any()
              )
            )
          )
        );
      }
    
      return iso$instruction$ifParser;
    }
    
    // ========================================================
    // leapSecond
    // ........................................................
    
    private ParserCombinator iso$instruction$leapSecondParser = null;
    
    public final Start iso$instruction$leapSecond = Start.on(getNamespace(), "leapSecond");
    
    public ParserCombinator iso$instruction$leapSecond() {
      if (iso$instruction$leapSecondParser == null) {
        FutureParser future = scoped("leapSecond", PUBLIC, true);
        iso$instruction$leapSecondParser = future;
        future.setParser(
          sequence(
            keyword("LEAP-SECOND"),
            as("unknown",
              plus(
                any()
              )
            )
          )
        );
      }
    
      return iso$instruction$leapSecondParser;
    }
    
    // ========================================================
    // listing
    // ........................................................
    
    private ParserCombinator iso$instruction$listingParser = null;
    
    public final Start iso$instruction$listing = Start.on(getNamespace(), "listing");
    
    public ParserCombinator iso$instruction$listing() {
      if (iso$instruction$listingParser == null) {
        FutureParser future = scoped("listing", PUBLIC, true);
        iso$instruction$listingParser = future;
        future.setParser(
          sequence(
            keyword("LISTING"),
            as("unknown",
              plus(
                any()
              )
            )
          )
        );
      }
    
      return iso$instruction$listingParser;
    }
    
    // ========================================================
    // page
    // ........................................................
    
    private ParserCombinator iso$instruction$pageParser = null;
    
    public final Start iso$instruction$page = Start.on(getNamespace(), "page");
    
    public ParserCombinator iso$instruction$page() {
      if (iso$instruction$pageParser == null) {
        FutureParser future = scoped("page", PUBLIC, true);
        iso$instruction$pageParser = future;
        future.setParser(
          sequence(
            keyword("PAGE"),
            as("unknown",
              plus(
                any()
              )
            )
          )
        );
      }
    
      return iso$instruction$pageParser;
    }
    
    // ========================================================
    // propagate
    // ........................................................
    
    private ParserCombinator iso$instruction$propagateParser = null;
    
    public final Start iso$instruction$propagate = Start.on(getNamespace(), "propagate");
    
    public ParserCombinator iso$instruction$propagate() {
      if (iso$instruction$propagateParser == null) {
        FutureParser future = scoped("propagate", PUBLIC, true);
        iso$instruction$propagateParser = future;
        future.setParser(
          sequence(
            keyword("PROPAGATE"),
            as("unknown",
              plus(
                any()
              )
            )
          )
        );
      }
    
      return iso$instruction$propagateParser;
    }
    
    // ========================================================
    // checking
    // ........................................................
    
    private ParserCombinator iso$instruction$checkingParser = null;
    
    public final Start iso$instruction$checking = Start.on(getNamespace(), "checking");
    
    public ParserCombinator iso$instruction$checking() {
      if (iso$instruction$checkingParser == null) {
        FutureParser future = scoped("checking", PUBLIC, true);
        iso$instruction$checkingParser = future;
        future.setParser(
          sequence(
            keyword("TURN"),
            as("unknown",
              plus(
                any()
              )
            )
          )
        );
      }
    
      return iso$instruction$checkingParser;
    }
    
    // ========================================================
    // repository
    // ........................................................
    
    private ParserCombinator iso$instruction$repositoryParser = null;
    
    public final Start iso$instruction$repository = Start.on(getNamespace(), "repository");
    
    public ParserCombinator iso$instruction$repository() {
      if (iso$instruction$repositoryParser == null) {
        FutureParser future = scoped("repository", PUBLIC, true);
        iso$instruction$repositoryParser = future;
        future.setParser(
          sequence(
            keyword("REPOSITORY"),
            optional(
              keyword("UPDATE")
            ),
            choice(
              keyword("ON"),
              sequence(
                keyword("OFF"),
                optional(
                  sequence(
                    optional(
                      keyword("WITH")
                    ),
                    keyword("CHECKING")
                  )
                )
              )
            )
          )
        );
      }
    
      return iso$instruction$repositoryParser;
    }
    
    // ========================================================
    // ibm
    // ........................................................
    
    private ParserCombinator ibmParser = null;
    
    public final Start ibm = Start.on(getNamespace(), "ibm");
    
    public ParserCombinator ibm() {
      if (ibmParser == null) {
        FutureParser future = scoped("ibm", PUBLIC, true);
        ibmParser = future;
        future.setParser(
          choice(
            ibm$basis(),
            ibm$process(),
            ibm$control(),
            ibm$delete(),
            ibm$enter(),
            ibm$insert(),
            ibm$readyTrace(),
            ibm$resetTrace()
          )
        );
      }
    
      return ibmParser;
    }
    
    // ========================================================
    // basis
    // ........................................................
    
    private ParserCombinator ibm$basisParser = null;
    
    public final Start ibm$basis = Start.on(getNamespace(), "basis");
    
    public ParserCombinator ibm$basis() {
      if (ibm$basisParser == null) {
        FutureParser future = scoped("basis", PUBLIC, true);
        ibm$basisParser = future;
        future.setParser(
          sequence(
            optional(
              sequence(
                as("sequenceNumber",
                  sequence(
                    ranged(1, 6),
                    tagged(NUMBER),
                    any()
                  )
                ),
                opt(NOSKIP,
                  sequence(
                    tagged(WHITESPACE),
                    any()
                  )
                )
              )
            ),
            keyword("BASIS"),
            anything()
          )
        );
      }
    
      return ibm$basisParser;
    }
    
    // ========================================================
    // process
    // ........................................................
    
    private ParserCombinator ibm$processParser = null;
    
    public final Start ibm$process = Start.on(getNamespace(), "process");
    
    public ParserCombinator ibm$process() {
      if (ibm$processParser == null) {
        FutureParser future = scoped("process", PUBLIC, true);
        ibm$processParser = future;
        future.setParser(
          sequence(
            optional(
              sequence(
                as("sequenceNumber",
                  sequence(
                    ranged(1, 6),
                    tagged(NUMBER),
                    any(),
                    star(
                      sequence(
                        ranged(1, 6),
                        any()
                      )
                    )
                  )
                ),
                opt(NOSKIP,
                  sequence(
                    tagged(WHITESPACE),
                    any()
                  )
                )
              )
            ),
            choice(
              keyword("CBL"),
              keyword("PROCESS")
            ),
            star(
              anything()
            )
          )
        );
      }
    
      return ibm$processParser;
    }
    
    // ========================================================
    // control
    // ........................................................
    
    private ParserCombinator ibm$controlParser = null;
    
    public final Start ibm$control = Start.on(getNamespace(), "control");
    
    public ParserCombinator ibm$control() {
      if (ibm$controlParser == null) {
        FutureParser future = scoped("control", PUBLIC, true);
        ibm$controlParser = future;
        future.setParser(
          sequence(
            ibm$control$cblControl(),
            ibm$control$option(),
            star(
              sequence(
                optional(
                  literal(",")
                ),
                ibm$control$option()
              )
            ),
            optional(
              literal(".")
            )
          )
        );
      }
    
      return ibm$controlParser;
    }
    
    // ========================================================
    // cblControl
    // ........................................................
    
    private ParserCombinator ibm$control$cblControlParser = null;
    
    protected final Start ibm$control$cblControl = Start.on(getNamespace(), "cblControl");
    
    protected ParserCombinator ibm$control$cblControl() {
      if (ibm$control$cblControlParser == null) {
        FutureParser future = scoped("cblControl", PRIVATE, true);
        ibm$control$cblControlParser = future;
        future.setParser(
          sequence(
            sequence(
              ranged(7, -1),
              literal("*")
            ),
            opt(NOSKIP,
              choice(
                keyword("CBL"),
                keyword("CONTROL")
              )
            )
          )
        );
      }
    
      return ibm$control$cblControlParser;
    }
    
    // ========================================================
    // option
    // ........................................................
    
    private ParserCombinator ibm$control$optionParser = null;
    
    public final Start ibm$control$option = Start.on(getNamespace(), "option");
    
    public ParserCombinator ibm$control$option() {
      if (ibm$control$optionParser == null) {
        FutureParser future = scoped("option", PUBLIC, true);
        ibm$control$optionParser = future;
        future.setParser(
          choice(
            keyword("SOURCE"),
            keyword("NOSOURCE"),
            keyword("LIST"),
            keyword("NOLIST"),
            keyword("MAP"),
            keyword("NOMAP")
          )
        );
      }
    
      return ibm$control$optionParser;
    }
    
    // ========================================================
    // delete
    // ........................................................
    
    private ParserCombinator ibm$deleteParser = null;
    
    public final Start ibm$delete = Start.on(getNamespace(), "delete");
    
    public ParserCombinator ibm$delete() {
      if (ibm$deleteParser == null) {
        FutureParser future = scoped("delete", PUBLIC, true);
        ibm$deleteParser = future;
        future.setParser(
          sequence(
            optional(
              sequence(
                as("sequenceNumber",
                  sequence(
                    ranged(1, 6),
                    tagged(NUMBER),
                    any()
                  )
                ),
                opt(NOSKIP,
                  sequence(
                    tagged(WHITESPACE),
                    any()
                  )
                )
              )
            ),
            keyword("DELETE"),
            ibm$delete$sequenceNumberFieldOrRange(),
            star(
              sequence(
                literal(","),
                ibm$delete$sequenceNumberFieldOrRange()
              )
            )
          )
        );
      }
    
      return ibm$deleteParser;
    }
    
    // ========================================================
    // sequenceNumberFieldOrRange
    // ........................................................
    
    private ParserCombinator ibm$delete$sequenceNumberFieldOrRangeParser = null;
    
    protected final Start ibm$delete$sequenceNumberFieldOrRange = Start.on(getNamespace(), "sequenceNumberFieldOrRange");
    
    protected ParserCombinator ibm$delete$sequenceNumberFieldOrRange() {
      if (ibm$delete$sequenceNumberFieldOrRangeParser == null) {
        FutureParser future = scoped("sequenceNumberFieldOrRange", PRIVATE, true);
        ibm$delete$sequenceNumberFieldOrRangeParser = future;
        future.setParser(
          choice(
            as("sequenceNumberRange",
              sequence(
                ibm$sequenceNumberField(),
                opt(NOSKIP,
                  sequence(
                    literal("-"),
                    ibm$sequenceNumberField()
                  )
                )
              )
            ),
            ibm$sequenceNumberField()
          )
        );
      }
    
      return ibm$delete$sequenceNumberFieldOrRangeParser;
    }
    
    // ========================================================
    // enter
    // ........................................................
    
    private ParserCombinator ibm$enterParser = null;
    
    public final Start ibm$enter = Start.on(getNamespace(), "enter");
    
    public ParserCombinator ibm$enter() {
      if (ibm$enterParser == null) {
        FutureParser future = scoped("enter", PUBLIC, true);
        ibm$enterParser = future;
        future.setParser(
          sequence(
            keyword("ENTER"),
            anything(),
            optional(
              sequence(
                not(
                  literal(".")
                ),
                anything()
              )
            ),
            literal(".")
          )
        );
      }
    
      return ibm$enterParser;
    }
    
    // ========================================================
    // insert
    // ........................................................
    
    private ParserCombinator ibm$insertParser = null;
    
    public final Start ibm$insert = Start.on(getNamespace(), "insert");
    
    public ParserCombinator ibm$insert() {
      if (ibm$insertParser == null) {
        FutureParser future = scoped("insert", PUBLIC, true);
        ibm$insertParser = future;
        future.setParser(
          sequence(
            optional(
              sequence(
                as("sequenceNumber",
                  sequence(
                    ranged(1, 6),
                    tagged(NUMBER),
                    any()
                  )
                ),
                opt(NOSKIP,
                  sequence(
                    tagged(WHITESPACE),
                    any()
                  )
                )
              )
            ),
            keyword("INSERT"),
            ibm$sequenceNumberField()
          )
        );
      }
    
      return ibm$insertParser;
    }
    
    // ========================================================
    // readyTrace
    // ........................................................
    
    private ParserCombinator ibm$readyTraceParser = null;
    
    public final Start ibm$readyTrace = Start.on(getNamespace(), "readyTrace");
    
    public ParserCombinator ibm$readyTrace() {
      if (ibm$readyTraceParser == null) {
        FutureParser future = scoped("readyTrace", PUBLIC, true);
        ibm$readyTraceParser = future;
        future.setParser(
          sequence(
            keyword("READY"),
            keyword("TRACE"),
            literal(".")
          )
        );
      }
    
      return ibm$readyTraceParser;
    }
    
    // ========================================================
    // resetTrace
    // ........................................................
    
    private ParserCombinator ibm$resetTraceParser = null;
    
    public final Start ibm$resetTrace = Start.on(getNamespace(), "resetTrace");
    
    public ParserCombinator ibm$resetTrace() {
      if (ibm$resetTraceParser == null) {
        FutureParser future = scoped("resetTrace", PUBLIC, true);
        ibm$resetTraceParser = future;
        future.setParser(
          sequence(
            keyword("RESET"),
            keyword("TRACE"),
            literal(".")
          )
        );
      }
    
      return ibm$resetTraceParser;
    }
    
    // ========================================================
    // sequenceNumberField
    // ........................................................
    
    private ParserCombinator ibm$sequenceNumberFieldParser = null;
    
    public final Start ibm$sequenceNumberField = Start.on(getNamespace(), "sequenceNumberField");
    
    public ParserCombinator ibm$sequenceNumberField() {
      if (ibm$sequenceNumberFieldParser == null) {
        FutureParser future = scoped("sequenceNumberField", PUBLIC, true);
        ibm$sequenceNumberFieldParser = future;
        future.setParser(
          sequence(
            tagged(NUMBER),
            any()
          )
        );
      }
    
      return ibm$sequenceNumberFieldParser;
    }
    
    // ========================================================
    // mf
    // ........................................................
    
    private ParserCombinator mfParser = null;
    
    public final Start mf = Start.on(getNamespace(), "mf");
    
    public ParserCombinator mf() {
      if (mfParser == null) {
        FutureParser future = scoped("mf", PUBLIC, true);
        mfParser = future;
        future.setParser(
          choice(
            mf$inc(),
            mf$include(),
            mf$set(),
            mf$display(),
            mf$else(),
            mf$end(),
            mf$if()
          )
        );
      }
    
      return mfParser;
    }
    
    // ========================================================
    // inc
    // ........................................................
    
    private ParserCombinator mf$incParser = null;
    
    public final Start mf$inc = Start.on(getNamespace(), "inc");
    
    public ParserCombinator mf$inc() {
      if (mf$incParser == null) {
        FutureParser future = scoped("inc", PUBLIC, true);
        mf$incParser = future;
        future.setParser(
          sequence(
            sequence(
              sequence(
                ranged(1, 1),
                literal("-")
              ),
              opt(NOSKIP,
                literal("INC")
              )
            ),
            anything(),
            optional(
              as("comment",
                star(
                  anything()
                )
              )
            )
          )
        );
      }
    
      return mf$incParser;
    }
    
    // ========================================================
    // include
    // ........................................................
    
    private ParserCombinator mf$includeParser = null;
    
    public final Start mf$include = Start.on(getNamespace(), "include");
    
    public ParserCombinator mf$include() {
      if (mf$includeParser == null) {
        FutureParser future = scoped("include", PUBLIC, true);
        mf$includeParser = future;
        future.setParser(
          sequence(
            sequence(
              sequence(
                ranged(8, 8),
                literal("+")
              ),
              opt(NOSKIP,
                sequence(
                  literal("+"),
                  literal("INCLUDE")
                )
              )
            ),
            anything(),
            optional(
              as("comment",
                star(
                  anything()
                )
              )
            )
          )
        );
      }
    
      return mf$includeParser;
    }
    
    // ========================================================
    // set
    // ........................................................
    
    private ParserCombinator mf$setParser = null;
    
    public final Start mf$set = Start.on(getNamespace(), "set");
    
    public ParserCombinator mf$set() {
      if (mf$setParser == null) {
        FutureParser future = scoped("set", PUBLIC, true);
        mf$setParser = future;
        future.setParser(
          sequence(
            sequence(
              mf$indicator(),
              opt(NOSKIP,
                keyword("SET")
              )
            ),
            plus(
              choice(
                as("sourceformat",
                  sequence(
                    keyword("SOURCEFORMAT"),
                    mf$set$parameter()
                  )
                ),
                as("directive",
                  sequence(
                    name(),
                    optional(
                      mf$set$parameter()
                    )
                  )
                )
              )
            )
          )
        );
      }
    
      return mf$setParser;
    }
    
    // ========================================================
    // parameter
    // ........................................................
    
    private ParserCombinator mf$set$parameterParser = null;
    
    public final Start mf$set$parameter = Start.on(getNamespace(), "parameter");
    
    public ParserCombinator mf$set$parameter() {
      if (mf$set$parameterParser == null) {
        FutureParser future = scoped("parameter", PUBLIC, true);
        mf$set$parameterParser = future;
        future.setParser(
          choice(
            sequence(
              tagged(STRING),
              any()
            ),
            sequence(
              literal("("),
              plus(
                sequence(
                  not(
                    literal(")")
                  ),
                  any()
                )
              ),
              literal(")")
            )
          )
        );
      }
    
      return mf$set$parameterParser;
    }
    
    // ========================================================
    // display
    // ........................................................
    
    private ParserCombinator mf$displayParser = null;
    
    public final Start mf$display = Start.on(getNamespace(), "display");
    
    public ParserCombinator mf$display() {
      if (mf$displayParser == null) {
        FutureParser future = scoped("display", PUBLIC, true);
        mf$displayParser = future;
        future.setParser(
          sequence(
            sequence(
              mf$indicator(),
              opt(NOSKIP,
                keyword("DISPLAY")
              )
            ),
            optional(
              sequence(
                keyword("VCS"),
                literal("=")
              )
            ),
            plus(
              anything()
            )
          )
        );
      }
    
      return mf$displayParser;
    }
    
    // ========================================================
    // else
    // ........................................................
    
    private ParserCombinator mf$elseParser = null;
    
    public final Start mf$else = Start.on(getNamespace(), "else");
    
    public ParserCombinator mf$else() {
      if (mf$elseParser == null) {
        FutureParser future = scoped("else", PUBLIC, true);
        mf$elseParser = future;
        future.setParser(
          sequence(
            mf$indicator(),
            opt(NOSKIP,
              keyword("ELSE")
            )
          )
        );
      }
    
      return mf$elseParser;
    }
    
    // ========================================================
    // end
    // ........................................................
    
    private ParserCombinator mf$endParser = null;
    
    public final Start mf$end = Start.on(getNamespace(), "end");
    
    public ParserCombinator mf$end() {
      if (mf$endParser == null) {
        FutureParser future = scoped("end", PUBLIC, true);
        mf$endParser = future;
        future.setParser(
          sequence(
            mf$indicator(),
            opt(NOSKIP,
              keyword("END")
            )
          )
        );
      }
    
      return mf$endParser;
    }
    
    // ========================================================
    // if
    // ........................................................
    
    private ParserCombinator mf$ifParser = null;
    
    public final Start mf$if = Start.on(getNamespace(), "if");
    
    public ParserCombinator mf$if() {
      if (mf$ifParser == null) {
        FutureParser future = scoped("if", PUBLIC, true);
        mf$ifParser = future;
        future.setParser(
          sequence(
            sequence(
              mf$indicator(),
              opt(NOSKIP,
                keyword("IF")
              )
            ),
            as("unknown",
              plus(
                any()
              )
            )
          )
        );
      }
    
      return mf$ifParser;
    }
    
    // ========================================================
    // indicator
    // ........................................................
    
    private ParserCombinator mf$indicatorParser = null;
    
    public final Start mf$indicator = Start.on(getNamespace(), "indicator");
    
    public ParserCombinator mf$indicator() {
      if (mf$indicatorParser == null) {
        FutureParser future = scoped("indicator", PUBLIC, true);
        mf$indicatorParser = future;
        future.setParser(
          sequence(
            choice(
              sequence(
                tagged(FREE),
                ranged(1, 1)
              ),
              sequence(
                tagged(FIXED),
                ranged(7, 7)
              ),
              sequence(
                tagged(VARIABLE),
                ranged(7, 7)
              )
            ),
            literal("$")
          )
        );
      }
    
      return mf$indicatorParser;
    }
    
    // ========================================================
    // listing
    // ........................................................
    
    private ParserCombinator listingParser = null;
    
    public final Start listing = Start.on(getNamespace(), "listing");
    
    public ParserCombinator listing() {
      if (listingParser == null) {
        FutureParser future = scoped("listing", PUBLIC, true);
        listingParser = future;
        future.setParser(
          sequence(
            optional(
              as("sequenceNumber",
                sequence(
                  choice(
                    tagged(FIXED),
                    tagged(VARIABLE)
                  ),
                  plus(
                    sequence(
                      ranged(1, 6),
                      any()
                    )
                  )
                )
              )
            ),
            choice(
              listing$eject(),
              listing$skip(),
              listing$title()
            )
          )
        );
      }
    
      return listingParser;
    }
    
    // ========================================================
    // eject
    // ........................................................
    
    private ParserCombinator listing$ejectParser = null;
    
    public final Start listing$eject = Start.on(getNamespace(), "eject");
    
    public ParserCombinator listing$eject() {
      if (listing$ejectParser == null) {
        FutureParser future = scoped("eject", PUBLIC, true);
        listing$ejectParser = future;
        future.setParser(
          sequence(
            sequence(
              ranged(8, -1),
              keyword("EJECT")
            ),
            optional(
              literal(".")
            )
          )
        );
      }
    
      return listing$ejectParser;
    }
    
    // ========================================================
    // skip
    // ........................................................
    
    private ParserCombinator listing$skipParser = null;
    
    public final Start listing$skip = Start.on(getNamespace(), "skip");
    
    public ParserCombinator listing$skip() {
      if (listing$skipParser == null) {
        FutureParser future = scoped("skip", PUBLIC, true);
        listing$skipParser = future;
        future.setParser(
          sequence(
            sequence(
              ranged(8, -1),
              sequence(
                keyword("SKIP"),
                opt(NOSKIP,
                  choice(
                    number("1"),
                    number("2"),
                    number("3")
                  )
                )
              )
            ),
            optional(
              literal(".")
            )
          )
        );
      }
    
      return listing$skipParser;
    }
    
    // ========================================================
    // title
    // ........................................................
    
    private ParserCombinator listing$titleParser = null;
    
    public final Start listing$title = Start.on(getNamespace(), "title");
    
    public ParserCombinator listing$title() {
      if (listing$titleParser == null) {
        FutureParser future = scoped("title", PUBLIC, true);
        listing$titleParser = future;
        future.setParser(
          sequence(
            sequence(
              ranged(8, -1),
              keyword("TITLE")
            ),
            anything(),
            optional(
              literal(".")
            )
          )
        );
      }
    
      return listing$titleParser;
    }
    
    // ========================================================
    // inlineComment
    // ........................................................
    
    private ParserCombinator inlineCommentParser = null;
    
    public final Start inlineComment = Start.on(getNamespace(), "inlineComment");
    
    public ParserCombinator inlineComment() {
      if (inlineCommentParser == null) {
        FutureParser future = scoped("inlineComment", PUBLIC, true);
        inlineCommentParser = future;
        future.setParser(
          sequence(
            inlineCommentIndicator(),
            star(
              any()
            )
          )
        );
      }
    
      return inlineCommentParser;
    }
    
    // ========================================================
    // inlineCommentIndicator
    // ........................................................
    
    private ParserCombinator inlineCommentIndicatorParser = null;
    
    protected final Start inlineCommentIndicator = Start.on(getNamespace(), "inlineCommentIndicator");
    
    protected ParserCombinator inlineCommentIndicator() {
      if (inlineCommentIndicatorParser == null) {
        FutureParser future = scoped("inlineCommentIndicator", PRIVATE, true);
        inlineCommentIndicatorParser = future;
        future.setParser(
          sequence(
            literal("*"),
            opt(NOSKIP,
              literal(">")
            )
          )
        );
      }
    
      return inlineCommentIndicatorParser;
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
            sequence(
              tagged(WORD),
              any()
            ),
            opt(NOSKIP,
              star(
                choice(
                  sequence(
                    tagged(WORD),
                    any()
                  ),
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
    
      return nameParser;
    }
    
    // ========================================================
    // anything
    // ........................................................
    
    private ParserCombinator anythingParser = null;
    
    public final Start anything = Start.on(getNamespace(), "anything");
    
    public ParserCombinator anything() {
      if (anythingParser == null) {
        FutureParser future = scoped("anything", PUBLIC, true);
        anythingParser = future;
        future.setParser(
          sequence(
            any(),
            optional(
              opt(NOSKIP,
                star(
                  sequence(
                    not(
                      tagged(WHITESPACE)
                    ),
                    any()
                  )
                )
              )
            )
          )
        );
      }
    
      return anythingParser;
    }
    
}
