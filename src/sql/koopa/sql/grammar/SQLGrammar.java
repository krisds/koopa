package koopa.sql.grammar;

import koopa.core.data.markers.Start;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.FutureParser;

import static koopa.core.parsers.combinators.Opt.NOSKIP;
import static koopa.core.grammars.combinators.Scoped.Visibility.PUBLIC;
import static koopa.core.grammars.combinators.Scoped.Visibility.PRIVATE;
import static koopa.core.grammars.combinators.Scoped.Visibility.HIDING;

import koopa.sql.grammar.SQLBaseGrammar;
import static koopa.core.data.tags.SyntacticTag.NUMBER;
import static koopa.core.data.tags.SyntacticTag.STRING;
import static koopa.core.data.tags.SyntacticTag.WORD;

/**
 * <b>This is generated code.<b>
 * <p>
 * @see <code>src/sql/koopa/sql/grammar/SQL.kg</code>
 */
public class SQLGrammar extends SQLBaseGrammar {
    private static SQLGrammar INSTANCE = null;

    protected SQLGrammar() {
    }
    
    public static SQLGrammar instance() {
      if (INSTANCE == null)
        INSTANCE = new SQLGrammar();
        
      return INSTANCE;
    }
    
    // ========================================================
    // sqlStatement
    // ........................................................
    
    private ParserCombinator sqlStatementParser = null;
    
    public final Start sqlStatement = Start.on(getNamespace(), "sqlStatement");
    
    public ParserCombinator sqlStatement() {
      if (sqlStatementParser == null) {
        FutureParser future = scoped("sqlStatement", PUBLIC, true);
        sqlStatementParser = future;
        future.setParser(
          choice(
            includeStatement(),
            declareSessionStatement(),
            declareGlobalTempTableStatement(),
            declareTableStatement(),
            declareCursorStatement(),
            valuesIntoStatement(),
            selectStatement(),
            insertStatement(),
            updateStatement(),
            deleteStatement(),
            mergeStatement(),
            fetchStatement(),
            openStatement(),
            closeStatement(),
            commitStatement(),
            rollbackStatement(),
            lockTableStatement(),
            setStatement(),
            getDiagnosticsStatement(),
            prepareStatement(),
            executeImmediateStatement(),
            executeStatement(),
            describeStatement(),
            callStatement(),
            associateLocatorsStatement(),
            allocateCursorStatement(),
            withSelectStatement(),
            alterStatement(),
            createStatement(),
            dropStatement(),
            renameStatement()
          )
        );
      }
    
      return sqlStatementParser;
    }
    
    // ========================================================
    // includeStatement
    // ........................................................
    
    private ParserCombinator includeStatementParser = null;
    
    public final Start includeStatement = Start.on(getNamespace(), "includeStatement");
    
    public ParserCombinator includeStatement() {
      if (includeStatementParser == null) {
        FutureParser future = scoped("includeStatement", PUBLIC, true);
        includeStatementParser = future;
        future.setParser(
          sequence(
            keyword("INCLUDE"),
            identifier()
          )
        );
      }
    
      return includeStatementParser;
    }
    
    // ========================================================
    // declareSessionStatement
    // ........................................................
    
    private ParserCombinator declareSessionStatementParser = null;
    
    public final Start declareSessionStatement = Start.on(getNamespace(), "declareSessionStatement");
    
    public ParserCombinator declareSessionStatement() {
      if (declareSessionStatementParser == null) {
        FutureParser future = scoped("declareSessionStatement", PUBLIC, true);
        declareSessionStatementParser = future;
        future.setParser(
          sequence(
            keyword("DECLARE"),
            keyword("SESSION"),
            literal("."),
            identifier(),
            keyword("TABLE"),
            optional(
              as("unknown",
                skipto(
                  eof()
                )
              )
            )
          )
        );
      }
    
      return declareSessionStatementParser;
    }
    
    // ========================================================
    // declareGlobalTempTableStatement
    // ........................................................
    
    private ParserCombinator declareGlobalTempTableStatementParser = null;
    
    public final Start declareGlobalTempTableStatement = Start.on(getNamespace(), "declareGlobalTempTableStatement");
    
    public ParserCombinator declareGlobalTempTableStatement() {
      if (declareGlobalTempTableStatementParser == null) {
        FutureParser future = scoped("declareGlobalTempTableStatement", PUBLIC, true);
        declareGlobalTempTableStatementParser = future;
        future.setParser(
          sequence(
            keyword("DECLARE"),
            keyword("GLOBAL"),
            keyword("TEMPORARY"),
            keyword("TABLE"),
            identifier(),
            optional(
              as("unknown",
                skipto(
                  eof()
                )
              )
            )
          )
        );
      }
    
      return declareGlobalTempTableStatementParser;
    }
    
    // ========================================================
    // declareTableStatement
    // ........................................................
    
    private ParserCombinator declareTableStatementParser = null;
    
    public final Start declareTableStatement = Start.on(getNamespace(), "declareTableStatement");
    
    public ParserCombinator declareTableStatement() {
      if (declareTableStatementParser == null) {
        FutureParser future = scoped("declareTableStatement", PUBLIC, true);
        declareTableStatementParser = future;
        future.setParser(
          sequence(
            keyword("DECLARE"),
            not(
              declareTableStatement$sessionQualifier()
            ),
            tableName(),
            keyword("TABLE"),
            optional(
              as("unknown",
                skipto(
                  eof()
                )
              )
            )
          )
        );
      }
    
      return declareTableStatementParser;
    }
    
    // ========================================================
    // sessionQualifier
    // ........................................................
    
    private ParserCombinator declareTableStatement$sessionQualifierParser = null;
    
    protected final Start declareTableStatement$sessionQualifier = Start.on(getNamespace(), "sessionQualifier");
    
    protected ParserCombinator declareTableStatement$sessionQualifier() {
      if (declareTableStatement$sessionQualifierParser == null) {
        FutureParser future = scoped("sessionQualifier", PRIVATE, true);
        declareTableStatement$sessionQualifierParser = future;
        future.setParser(
          sequence(
            keyword("SESSION"),
            literal(".")
          )
        );
      }
    
      return declareTableStatement$sessionQualifierParser;
    }
    
    // ========================================================
    // valuesIntoStatement
    // ........................................................
    
    private ParserCombinator valuesIntoStatementParser = null;
    
    public final Start valuesIntoStatement = Start.on(getNamespace(), "valuesIntoStatement");
    
    public ParserCombinator valuesIntoStatement() {
      if (valuesIntoStatementParser == null) {
        FutureParser future = scoped("valuesIntoStatement", PUBLIC, true);
        valuesIntoStatementParser = future;
        future.setParser(
          sequence(
            keyword("VALUES"),
            optional(
              as("unknown",
                skipto(
                  eof()
                )
              )
            )
          )
        );
      }
    
      return valuesIntoStatementParser;
    }
    
    // ========================================================
    // declareCursorStatement
    // ........................................................
    
    private ParserCombinator declareCursorStatementParser = null;
    
    public final Start declareCursorStatement = Start.on(getNamespace(), "declareCursorStatement");
    
    public ParserCombinator declareCursorStatement() {
      if (declareCursorStatementParser == null) {
        FutureParser future = scoped("declareCursorStatement", PUBLIC, true);
        declareCursorStatementParser = future;
        future.setParser(
          sequence(
            keyword("DECLARE"),
            cursorName(),
            optional(
              declareCursorStatement$sensitivity()
            ),
            optional(
              declareCursorStatement$scrollability()
            ),
            keyword("CURSOR"),
            optional(
              declareCursorStatement$holdability()
            ),
            optional(
              declareCursorStatement$returnability()
            ),
            optional(
              declareCursorStatement$positioning()
            ),
            keyword("FOR"),
            declareCursorStatement$queryExpression(),
            optional(
              as("unknown",
                skipto(
                  eof()
                )
              )
            )
          )
        );
      }
    
      return declareCursorStatementParser;
    }
    
    // ========================================================
    // sensitivity
    // ........................................................
    
    private ParserCombinator declareCursorStatement$sensitivityParser = null;
    
    public final Start declareCursorStatement$sensitivity = Start.on(getNamespace(), "sensitivity");
    
    public ParserCombinator declareCursorStatement$sensitivity() {
      if (declareCursorStatement$sensitivityParser == null) {
        FutureParser future = scoped("sensitivity", PUBLIC, true);
        declareCursorStatement$sensitivityParser = future;
        future.setParser(
          choice(
            keyword("SENSITIVE"),
            keyword("INSENSITIVE"),
            keyword("ASENSITIVE")
          )
        );
      }
    
      return declareCursorStatement$sensitivityParser;
    }
    
    // ========================================================
    // scrollability
    // ........................................................
    
    private ParserCombinator declareCursorStatement$scrollabilityParser = null;
    
    public final Start declareCursorStatement$scrollability = Start.on(getNamespace(), "scrollability");
    
    public ParserCombinator declareCursorStatement$scrollability() {
      if (declareCursorStatement$scrollabilityParser == null) {
        FutureParser future = scoped("scrollability", PUBLIC, true);
        declareCursorStatement$scrollabilityParser = future;
        future.setParser(
          choice(
            keyword("SCROLL"),
            sequence(
              keyword("NO"),
              keyword("SCROLL")
            )
          )
        );
      }
    
      return declareCursorStatement$scrollabilityParser;
    }
    
    // ========================================================
    // holdability
    // ........................................................
    
    private ParserCombinator declareCursorStatement$holdabilityParser = null;
    
    public final Start declareCursorStatement$holdability = Start.on(getNamespace(), "holdability");
    
    public ParserCombinator declareCursorStatement$holdability() {
      if (declareCursorStatement$holdabilityParser == null) {
        FutureParser future = scoped("holdability", PUBLIC, true);
        declareCursorStatement$holdabilityParser = future;
        future.setParser(
          choice(
            sequence(
              keyword("WITH"),
              keyword("HOLD")
            ),
            sequence(
              keyword("WITHOUT"),
              keyword("HOLD")
            )
          )
        );
      }
    
      return declareCursorStatement$holdabilityParser;
    }
    
    // ========================================================
    // returnability
    // ........................................................
    
    private ParserCombinator declareCursorStatement$returnabilityParser = null;
    
    public final Start declareCursorStatement$returnability = Start.on(getNamespace(), "returnability");
    
    public ParserCombinator declareCursorStatement$returnability() {
      if (declareCursorStatement$returnabilityParser == null) {
        FutureParser future = scoped("returnability", PUBLIC, true);
        declareCursorStatement$returnabilityParser = future;
        future.setParser(
          choice(
            sequence(
              keyword("WITH"),
              keyword("RETURN")
            ),
            sequence(
              keyword("WITHOUT"),
              keyword("RETURN")
            )
          )
        );
      }
    
      return declareCursorStatement$returnabilityParser;
    }
    
    // ========================================================
    // positioning
    // ........................................................
    
    private ParserCombinator declareCursorStatement$positioningParser = null;
    
    public final Start declareCursorStatement$positioning = Start.on(getNamespace(), "positioning");
    
    public ParserCombinator declareCursorStatement$positioning() {
      if (declareCursorStatement$positioningParser == null) {
        FutureParser future = scoped("positioning", PUBLIC, true);
        declareCursorStatement$positioningParser = future;
        future.setParser(
          sequence(
            keyword("WITH"),
            keyword("ROWSET"),
            keyword("POSITIONING")
          )
        );
      }
    
      return declareCursorStatement$positioningParser;
    }
    
    // ========================================================
    // queryExpression
    // ........................................................
    
    private ParserCombinator declareCursorStatement$queryExpressionParser = null;
    
    public final Start declareCursorStatement$queryExpression = Start.on(getNamespace(), "queryExpression");
    
    public ParserCombinator declareCursorStatement$queryExpression() {
      if (declareCursorStatement$queryExpressionParser == null) {
        FutureParser future = scoped("queryExpression", PUBLIC, true);
        declareCursorStatement$queryExpressionParser = future;
        future.setParser(
          choice(
            selectStatement(),
            as("unknown",
              skipto(
                eof()
              )
            )
          )
        );
      }
    
      return declareCursorStatement$queryExpressionParser;
    }
    
    // ========================================================
    // selectStatement
    // ........................................................
    
    private ParserCombinator selectStatementParser = null;
    
    public final Start selectStatement = Start.on(getNamespace(), "selectStatement");
    
    public ParserCombinator selectStatement() {
      if (selectStatementParser == null) {
        FutureParser future = scoped("selectStatement", PUBLIC, true);
        selectStatementParser = future;
        future.setParser(
          sequence(
            keyword("SELECT"),
            optional(
              selectStatement$setQuantifier()
            ),
            selectStatement$selectList(),
            optional(
              selectStatement$into()
            ),
            selectStatement$from(),
            optional(
              as("unknown",
                skipto(
                  selectStatement$nextBlockOrEnd()
                )
              )
            ),
            optional(
              selectStatement$where()
            ),
            optional(
              as("unknown",
                skipto(
                  selectStatement$nextBlockOrEnd()
                )
              )
            ),
            optional(
              selectStatement$groupBy()
            ),
            optional(
              as("unknown",
                skipto(
                  selectStatement$nextBlockOrEnd()
                )
              )
            ),
            optional(
              selectStatement$having()
            ),
            optional(
              as("unknown",
                skipto(
                  selectStatement$nextBlockOrEnd()
                )
              )
            ),
            optional(
              selectStatement$orderBy()
            ),
            optional(
              as("unknown",
                skipto(
                  selectStatement$nextBlockOrEnd()
                )
              )
            ),
            optional(
              selectStatement$fetchFirst()
            ),
            optional(
              as("unknown",
                skipto(
                  selectStatement$nextBlockOrEnd()
                )
              )
            ),
            optional(
              selectStatement$updatability()
            ),
            optional(
              as("unknown",
                skipto(
                  eof()
                )
              )
            )
          )
        );
      }
    
      return selectStatementParser;
    }
    
    // ========================================================
    // setQuantifier
    // ........................................................
    
    private ParserCombinator selectStatement$setQuantifierParser = null;
    
    public final Start selectStatement$setQuantifier = Start.on(getNamespace(), "setQuantifier");
    
    public ParserCombinator selectStatement$setQuantifier() {
      if (selectStatement$setQuantifierParser == null) {
        FutureParser future = scoped("setQuantifier", PUBLIC, true);
        selectStatement$setQuantifierParser = future;
        future.setParser(
          choice(
            as("distinct",
              keyword("DISTINCT")
            ),
            as("all",
              keyword("ALL")
            )
          )
        );
      }
    
      return selectStatement$setQuantifierParser;
    }
    
    // ========================================================
    // selectList
    // ........................................................
    
    private ParserCombinator selectStatement$selectListParser = null;
    
    public final Start selectStatement$selectList = Start.on(getNamespace(), "selectList");
    
    public ParserCombinator selectStatement$selectList() {
      if (selectStatement$selectListParser == null) {
        FutureParser future = scoped("selectList", PUBLIC, true);
        selectStatement$selectListParser = future;
        future.setParser(
          upto(
            sequence(
              selectStatement$selectList$sublist(),
              star(
                sequence(
                  literal(","),
                  selectStatement$selectList$sublist()
                )
              )
            ),
            // Closure:
            choice(
              keyword("INTO"),
              keyword("FROM")
            )
          )
        );
      }
    
      return selectStatement$selectListParser;
    }
    
    // ========================================================
    // sublist
    // ........................................................
    
    private ParserCombinator selectStatement$selectList$sublistParser = null;
    
    protected final Start selectStatement$selectList$sublist = Start.on(getNamespace(), "sublist");
    
    protected ParserCombinator selectStatement$selectList$sublist() {
      if (selectStatement$selectList$sublistParser == null) {
        FutureParser future = scoped("sublist", PRIVATE, true);
        selectStatement$selectList$sublistParser = future;
        future.setParser(
          upto(
            choice(
              sequence(
                aggregateFunction(),
                optional(
                  as("unknown",
                    plus(
                      any()
                    )
                  )
                )
              ),
              sequence(
                specialRegister(),
                optional(
                  as("unknown",
                    plus(
                      any()
                    )
                  )
                )
              ),
              sequence(
                columnReference(),
                optional(
                  as("unknown",
                    plus(
                      any()
                    )
                  )
                )
              ),
              as("unknown",
                plus(
                  any()
                )
              )
            ),
            // Closure:
            literal(",")
          )
        );
      }
    
      return selectStatement$selectList$sublistParser;
    }
    
    // ========================================================
    // into
    // ........................................................
    
    private ParserCombinator selectStatement$intoParser = null;
    
    public final Start selectStatement$into = Start.on(getNamespace(), "into");
    
    public ParserCombinator selectStatement$into() {
      if (selectStatement$intoParser == null) {
        FutureParser future = scoped("into", PUBLIC, true);
        selectStatement$intoParser = future;
        future.setParser(
          sequence(
            keyword("INTO"),
            upto(
              sequence(
                selectStatement$into$target(),
                star(
                  sequence(
                    literal(","),
                    selectStatement$into$target()
                  )
                )
              ),
              // Closure:
              keyword("FROM")
            )
          )
        );
      }
    
      return selectStatement$intoParser;
    }
    
    // ========================================================
    // target
    // ........................................................
    
    private ParserCombinator selectStatement$into$targetParser = null;
    
    protected final Start selectStatement$into$target = Start.on(getNamespace(), "target");
    
    protected ParserCombinator selectStatement$into$target() {
      if (selectStatement$into$targetParser == null) {
        FutureParser future = scoped("target", PRIVATE, true);
        selectStatement$into$targetParser = future;
        future.setParser(
          upto(
            choice(
              hostParameterSpecification(),
              as("unknown",
                plus(
                  any()
                )
              )
            ),
            // Closure:
            literal(",")
          )
        );
      }
    
      return selectStatement$into$targetParser;
    }
    
    // ========================================================
    // from
    // ........................................................
    
    private ParserCombinator selectStatement$fromParser = null;
    
    public final Start selectStatement$from = Start.on(getNamespace(), "from");
    
    public ParserCombinator selectStatement$from() {
      if (selectStatement$fromParser == null) {
        FutureParser future = scoped("from", PUBLIC, true);
        selectStatement$fromParser = future;
        future.setParser(
          sequence(
            keyword("FROM"),
            tableReferenceList(),
            optional(
              as("unknown",
                skipto(
                  selectStatement$nextBlockOrEnd()
                )
              )
            )
          )
        );
      }
    
      return selectStatement$fromParser;
    }
    
    // ========================================================
    // where
    // ........................................................
    
    private ParserCombinator selectStatement$whereParser = null;
    
    public final Start selectStatement$where = Start.on(getNamespace(), "where");
    
    public ParserCombinator selectStatement$where() {
      if (selectStatement$whereParser == null) {
        FutureParser future = scoped("where", PUBLIC, true);
        selectStatement$whereParser = future;
        future.setParser(
          sequence(
            keyword("WHERE"),
            upto(
              choice(
                searchCondition(),
                as("unknown",
                  star(
                    any()
                  )
                )
              ),
              // Closure:
              selectStatement$nextBlockOrEnd()
            )
          )
        );
      }
    
      return selectStatement$whereParser;
    }
    
    // ========================================================
    // groupBy
    // ........................................................
    
    private ParserCombinator selectStatement$groupByParser = null;
    
    public final Start selectStatement$groupBy = Start.on(getNamespace(), "groupBy");
    
    public ParserCombinator selectStatement$groupBy() {
      if (selectStatement$groupByParser == null) {
        FutureParser future = scoped("groupBy", PUBLIC, true);
        selectStatement$groupByParser = future;
        future.setParser(
          sequence(
            keyword("GROUP"),
            keyword("BY"),
            as("unknown",
              skipto(
                selectStatement$nextBlockOrEnd()
              )
            )
          )
        );
      }
    
      return selectStatement$groupByParser;
    }
    
    // ========================================================
    // having
    // ........................................................
    
    private ParserCombinator selectStatement$havingParser = null;
    
    public final Start selectStatement$having = Start.on(getNamespace(), "having");
    
    public ParserCombinator selectStatement$having() {
      if (selectStatement$havingParser == null) {
        FutureParser future = scoped("having", PUBLIC, true);
        selectStatement$havingParser = future;
        future.setParser(
          sequence(
            keyword("HAVING"),
            as("unknown",
              skipto(
                selectStatement$nextBlockOrEnd()
              )
            )
          )
        );
      }
    
      return selectStatement$havingParser;
    }
    
    // ========================================================
    // orderBy
    // ........................................................
    
    private ParserCombinator selectStatement$orderByParser = null;
    
    public final Start selectStatement$orderBy = Start.on(getNamespace(), "orderBy");
    
    public ParserCombinator selectStatement$orderBy() {
      if (selectStatement$orderByParser == null) {
        FutureParser future = scoped("orderBy", PUBLIC, true);
        selectStatement$orderByParser = future;
        future.setParser(
          sequence(
            keyword("ORDER"),
            keyword("BY"),
            optional(
              sequence(
                selectStatement$orderBy$sortKey(),
                star(
                  sequence(
                    literal(","),
                    selectStatement$orderBy$sortKey()
                  )
                )
              )
            ),
            optional(
              as("unknown",
                skipto(
                  selectStatement$nextBlockOrEnd()
                )
              )
            )
          )
        );
      }
    
      return selectStatement$orderByParser;
    }
    
    // ========================================================
    // sortKey
    // ........................................................
    
    private ParserCombinator selectStatement$orderBy$sortKeyParser = null;
    
    public final Start selectStatement$orderBy$sortKey = Start.on(getNamespace(), "sortKey");
    
    public ParserCombinator selectStatement$orderBy$sortKey() {
      if (selectStatement$orderBy$sortKeyParser == null) {
        FutureParser future = scoped("sortKey", PUBLIC, true);
        selectStatement$orderBy$sortKeyParser = future;
        future.setParser(
          sequence(
            choice(
              columnReference(),
              numericLiteral()
            ),
            optional(
              choice(
                as("ascending",
                  keyword("ASC")
                ),
                as("descending",
                  keyword("DESC")
                )
              )
            )
          )
        );
      }
    
      return selectStatement$orderBy$sortKeyParser;
    }
    
    // ========================================================
    // fetchFirst
    // ........................................................
    
    private ParserCombinator selectStatement$fetchFirstParser = null;
    
    public final Start selectStatement$fetchFirst = Start.on(getNamespace(), "fetchFirst");
    
    public ParserCombinator selectStatement$fetchFirst() {
      if (selectStatement$fetchFirstParser == null) {
        FutureParser future = scoped("fetchFirst", PUBLIC, true);
        selectStatement$fetchFirstParser = future;
        future.setParser(
          sequence(
            keyword("FETCH"),
            keyword("FIRST"),
            optional(
              selectStatement$fetchFirst$rowCount()
            ),
            optional(
              as("unknown",
                skipto(
                  choice(
                    keyword("ROW"),
                    keyword("ROWS"),
                    eof()
                  )
                )
              )
            ),
            choice(
              keyword("ROW"),
              keyword("ROWS")
            ),
            keyword("ONLY")
          )
        );
      }
    
      return selectStatement$fetchFirstParser;
    }
    
    // ========================================================
    // rowCount
    // ........................................................
    
    private ParserCombinator selectStatement$fetchFirst$rowCountParser = null;
    
    public final Start selectStatement$fetchFirst$rowCount = Start.on(getNamespace(), "rowCount");
    
    public ParserCombinator selectStatement$fetchFirst$rowCount() {
      if (selectStatement$fetchFirst$rowCountParser == null) {
        FutureParser future = scoped("rowCount", PUBLIC, true);
        selectStatement$fetchFirst$rowCountParser = future;
        future.setParser(
          numericLiteral()
        );
      }
    
      return selectStatement$fetchFirst$rowCountParser;
    }
    
    // ========================================================
    // updatability
    // ........................................................
    
    private ParserCombinator selectStatement$updatabilityParser = null;
    
    public final Start selectStatement$updatability = Start.on(getNamespace(), "updatability");
    
    public ParserCombinator selectStatement$updatability() {
      if (selectStatement$updatabilityParser == null) {
        FutureParser future = scoped("updatability", PUBLIC, true);
        selectStatement$updatabilityParser = future;
        future.setParser(
          sequence(
            keyword("FOR"),
            choice(
              sequence(
                keyword("READ"),
                keyword("ONLY")
              ),
              sequence(
                keyword("FETCH"),
                keyword("ONLY")
              ),
              sequence(
                keyword("UPDATE"),
                optional(
                  sequence(
                    keyword("OF"),
                    as("unknown",
                      skipto(
                        selectStatement$nextBlockOrEnd()
                      )
                    )
                  )
                )
              )
            )
          )
        );
      }
    
      return selectStatement$updatabilityParser;
    }
    
    // ========================================================
    // nextBlockOrEnd
    // ........................................................
    
    private ParserCombinator selectStatement$nextBlockOrEndParser = null;
    
    protected final Start selectStatement$nextBlockOrEnd = Start.on(getNamespace(), "nextBlockOrEnd");
    
    protected ParserCombinator selectStatement$nextBlockOrEnd() {
      if (selectStatement$nextBlockOrEndParser == null) {
        FutureParser future = scoped("nextBlockOrEnd", PRIVATE, true);
        selectStatement$nextBlockOrEndParser = future;
        future.setParser(
          choice(
            keyword("FROM"),
            keyword("WHERE"),
            sequence(
              keyword("GROUP"),
              keyword("BY")
            ),
            keyword("HAVING"),
            sequence(
              keyword("ORDER"),
              keyword("BY")
            ),
            sequence(
              keyword("FETCH"),
              keyword("FIRST")
            ),
            keyword("WINDOW"),
            keyword("FOR"),
            keyword("WITH"),
            eof()
          )
        );
      }
    
      return selectStatement$nextBlockOrEndParser;
    }
    
    // ========================================================
    // insertStatement
    // ........................................................
    
    private ParserCombinator insertStatementParser = null;
    
    public final Start insertStatement = Start.on(getNamespace(), "insertStatement");
    
    public ParserCombinator insertStatement() {
      if (insertStatementParser == null) {
        FutureParser future = scoped("insertStatement", PUBLIC, true);
        insertStatementParser = future;
        future.setParser(
          sequence(
            keyword("INSERT"),
            keyword("INTO"),
            tableName(),
            optional(
              as("unknown",
                skipto(
                  eof()
                )
              )
            )
          )
        );
      }
    
      return insertStatementParser;
    }
    
    // ========================================================
    // updateStatement
    // ........................................................
    
    private ParserCombinator updateStatementParser = null;
    
    public final Start updateStatement = Start.on(getNamespace(), "updateStatement");
    
    public ParserCombinator updateStatement() {
      if (updateStatementParser == null) {
        FutureParser future = scoped("updateStatement", PUBLIC, true);
        updateStatementParser = future;
        future.setParser(
          sequence(
            keyword("UPDATE"),
            targetTable(),
            updateStatement$set(),
            optional(
              updateStatement$where()
            ),
            optional(
              as("unknown",
                skipto(
                  eof()
                )
              )
            )
          )
        );
      }
    
      return updateStatementParser;
    }
    
    // ========================================================
    // set
    // ........................................................
    
    private ParserCombinator updateStatement$setParser = null;
    
    public final Start updateStatement$set = Start.on(getNamespace(), "set");
    
    public ParserCombinator updateStatement$set() {
      if (updateStatement$setParser == null) {
        FutureParser future = scoped("set", PUBLIC, true);
        updateStatement$setParser = future;
        future.setParser(
          sequence(
            keyword("SET"),
            as("unknown",
              skipto(
                choice(
                  keyword("WHERE"),
                  eof()
                )
              )
            )
          )
        );
      }
    
      return updateStatement$setParser;
    }
    
    // ========================================================
    // where
    // ........................................................
    
    private ParserCombinator updateStatement$whereParser = null;
    
    public final Start updateStatement$where = Start.on(getNamespace(), "where");
    
    public ParserCombinator updateStatement$where() {
      if (updateStatement$whereParser == null) {
        FutureParser future = scoped("where", PUBLIC, true);
        updateStatement$whereParser = future;
        future.setParser(
          sequence(
            keyword("WHERE"),
            choice(
              sequence(
                keyword("CURRENT"),
                keyword("OF"),
                cursorName()
              ),
              upto(
                choice(
                  searchCondition(),
                  as("unknown",
                    star(
                      any()
                    )
                  )
                ),
                // Closure:
                eof()
              )
            )
          )
        );
      }
    
      return updateStatement$whereParser;
    }
    
    // ========================================================
    // deleteStatement
    // ........................................................
    
    private ParserCombinator deleteStatementParser = null;
    
    public final Start deleteStatement = Start.on(getNamespace(), "deleteStatement");
    
    public ParserCombinator deleteStatement() {
      if (deleteStatementParser == null) {
        FutureParser future = scoped("deleteStatement", PUBLIC, true);
        deleteStatementParser = future;
        future.setParser(
          sequence(
            keyword("DELETE"),
            keyword("FROM"),
            targetTable(),
            optional(
              skipto(
                eof()
              )
            )
          )
        );
      }
    
      return deleteStatementParser;
    }
    
    // ========================================================
    // mergeStatement
    // ........................................................
    
    private ParserCombinator mergeStatementParser = null;
    
    public final Start mergeStatement = Start.on(getNamespace(), "mergeStatement");
    
    public ParserCombinator mergeStatement() {
      if (mergeStatementParser == null) {
        FutureParser future = scoped("mergeStatement", PUBLIC, true);
        mergeStatementParser = future;
        future.setParser(
          sequence(
            keyword("MERGE"),
            keyword("INTO"),
            tableName(),
            optional(
              as("unknown",
                skipto(
                  eof()
                )
              )
            )
          )
        );
      }
    
      return mergeStatementParser;
    }
    
    // ========================================================
    // openStatement
    // ........................................................
    
    private ParserCombinator openStatementParser = null;
    
    public final Start openStatement = Start.on(getNamespace(), "openStatement");
    
    public ParserCombinator openStatement() {
      if (openStatementParser == null) {
        FutureParser future = scoped("openStatement", PUBLIC, true);
        openStatementParser = future;
        future.setParser(
          sequence(
            keyword("OPEN"),
            cursorName(),
            optional(
              openStatement$inputUsing()
            )
          )
        );
      }
    
      return openStatementParser;
    }
    
    // ========================================================
    // inputUsing
    // ........................................................
    
    private ParserCombinator openStatement$inputUsingParser = null;
    
    public final Start openStatement$inputUsing = Start.on(getNamespace(), "inputUsing");
    
    public ParserCombinator openStatement$inputUsing() {
      if (openStatement$inputUsingParser == null) {
        FutureParser future = scoped("inputUsing", PUBLIC, true);
        openStatement$inputUsingParser = future;
        future.setParser(
          optional(
            sequence(
              keyword("USING"),
              as("unknown",
                skipto(
                  eof()
                )
              )
            )
          )
        );
      }
    
      return openStatement$inputUsingParser;
    }
    
    // ========================================================
    // closeStatement
    // ........................................................
    
    private ParserCombinator closeStatementParser = null;
    
    public final Start closeStatement = Start.on(getNamespace(), "closeStatement");
    
    public ParserCombinator closeStatement() {
      if (closeStatementParser == null) {
        FutureParser future = scoped("closeStatement", PUBLIC, true);
        closeStatementParser = future;
        future.setParser(
          sequence(
            keyword("CLOSE"),
            cursorName()
          )
        );
      }
    
      return closeStatementParser;
    }
    
    // ========================================================
    // rollbackStatement
    // ........................................................
    
    private ParserCombinator rollbackStatementParser = null;
    
    public final Start rollbackStatement = Start.on(getNamespace(), "rollbackStatement");
    
    public ParserCombinator rollbackStatement() {
      if (rollbackStatementParser == null) {
        FutureParser future = scoped("rollbackStatement", PUBLIC, true);
        rollbackStatementParser = future;
        future.setParser(
          keyword("ROLLBACK")
        );
      }
    
      return rollbackStatementParser;
    }
    
    // ========================================================
    // lockTableStatement
    // ........................................................
    
    private ParserCombinator lockTableStatementParser = null;
    
    public final Start lockTableStatement = Start.on(getNamespace(), "lockTableStatement");
    
    public ParserCombinator lockTableStatement() {
      if (lockTableStatementParser == null) {
        FutureParser future = scoped("lockTableStatement", PUBLIC, true);
        lockTableStatementParser = future;
        future.setParser(
          sequence(
            keyword("LOCK"),
            keyword("TABLE"),
            tableName(),
            optional(
              as("unknown",
                skipto(
                  eof()
                )
              )
            )
          )
        );
      }
    
      return lockTableStatementParser;
    }
    
    // ========================================================
    // fetchStatement
    // ........................................................
    
    private ParserCombinator fetchStatementParser = null;
    
    public final Start fetchStatement = Start.on(getNamespace(), "fetchStatement");
    
    public ParserCombinator fetchStatement() {
      if (fetchStatementParser == null) {
        FutureParser future = scoped("fetchStatement", PUBLIC, true);
        fetchStatementParser = future;
        future.setParser(
          sequence(
            keyword("FETCH"),
            optional(
              fetchStatement$fetchOrientation()
            ),
            cursorName(),
            optional(
              fetchStatement$fetchInto()
            ),
            optional(
              fetchStatement$fetchUsingDescriptor()
            ),
            optional(
              as("unknown",
                skipto(
                  eof()
                )
              )
            )
          )
        );
      }
    
      return fetchStatementParser;
    }
    
    // ========================================================
    // fetchOrientation
    // ........................................................
    
    private ParserCombinator fetchStatement$fetchOrientationParser = null;
    
    public final Start fetchStatement$fetchOrientation = Start.on(getNamespace(), "fetchOrientation");
    
    public ParserCombinator fetchStatement$fetchOrientation() {
      if (fetchStatement$fetchOrientationParser == null) {
        FutureParser future = scoped("fetchOrientation", PUBLIC, true);
        fetchStatement$fetchOrientationParser = future;
        future.setParser(
          choice(
            keyword("NEXT"),
            keyword("PRIOR"),
            keyword("FIRST"),
            keyword("LAST"),
            keyword("BEFORE"),
            keyword("AFTER"),
            keyword("CURRENT")
          )
        );
      }
    
      return fetchStatement$fetchOrientationParser;
    }
    
    // ========================================================
    // fetchInto
    // ........................................................
    
    private ParserCombinator fetchStatement$fetchIntoParser = null;
    
    public final Start fetchStatement$fetchInto = Start.on(getNamespace(), "fetchInto");
    
    public ParserCombinator fetchStatement$fetchInto() {
      if (fetchStatement$fetchIntoParser == null) {
        FutureParser future = scoped("fetchInto", PUBLIC, true);
        fetchStatement$fetchIntoParser = future;
        future.setParser(
          sequence(
            keyword("INTO"),
            sequence(
              fetchStatement$fetchInto$target(),
              star(
                sequence(
                  literal(","),
                  fetchStatement$fetchInto$target()
                )
              )
            )
          )
        );
      }
    
      return fetchStatement$fetchIntoParser;
    }
    
    // ========================================================
    // target
    // ........................................................
    
    private ParserCombinator fetchStatement$fetchInto$targetParser = null;
    
    protected final Start fetchStatement$fetchInto$target = Start.on(getNamespace(), "target");
    
    protected ParserCombinator fetchStatement$fetchInto$target() {
      if (fetchStatement$fetchInto$targetParser == null) {
        FutureParser future = scoped("target", PRIVATE, true);
        fetchStatement$fetchInto$targetParser = future;
        future.setParser(
          upto(
            choice(
              hostParameterSpecification(),
              as("unknown",
                plus(
                  any()
                )
              )
            ),
            // Closure:
            literal(",")
          )
        );
      }
    
      return fetchStatement$fetchInto$targetParser;
    }
    
    // ========================================================
    // fetchUsingDescriptor
    // ........................................................
    
    private ParserCombinator fetchStatement$fetchUsingDescriptorParser = null;
    
    public final Start fetchStatement$fetchUsingDescriptor = Start.on(getNamespace(), "fetchUsingDescriptor");
    
    public ParserCombinator fetchStatement$fetchUsingDescriptor() {
      if (fetchStatement$fetchUsingDescriptorParser == null) {
        FutureParser future = scoped("fetchUsingDescriptor", PUBLIC, true);
        fetchStatement$fetchUsingDescriptorParser = future;
        future.setParser(
          sequence(
            keyword("USING"),
            keyword("DESCRIPTOR"),
            as("unknown",
              skipto(
                eof()
              )
            )
          )
        );
      }
    
      return fetchStatement$fetchUsingDescriptorParser;
    }
    
    // ========================================================
    // commitStatement
    // ........................................................
    
    private ParserCombinator commitStatementParser = null;
    
    public final Start commitStatement = Start.on(getNamespace(), "commitStatement");
    
    public ParserCombinator commitStatement() {
      if (commitStatementParser == null) {
        FutureParser future = scoped("commitStatement", PUBLIC, true);
        commitStatementParser = future;
        future.setParser(
          sequence(
            keyword("COMMIT"),
            optional(
              keyword("WORK")
            )
          )
        );
      }
    
      return commitStatementParser;
    }
    
    // ========================================================
    // setStatement
    // ........................................................
    
    private ParserCombinator setStatementParser = null;
    
    public final Start setStatement = Start.on(getNamespace(), "setStatement");
    
    public ParserCombinator setStatement() {
      if (setStatementParser == null) {
        FutureParser future = scoped("setStatement", PUBLIC, true);
        setStatementParser = future;
        future.setParser(
          sequence(
            keyword("SET"),
            optional(
              as("unknown",
                skipto(
                  eof()
                )
              )
            )
          )
        );
      }
    
      return setStatementParser;
    }
    
    // ========================================================
    // getDiagnosticsStatement
    // ........................................................
    
    private ParserCombinator getDiagnosticsStatementParser = null;
    
    public final Start getDiagnosticsStatement = Start.on(getNamespace(), "getDiagnosticsStatement");
    
    public ParserCombinator getDiagnosticsStatement() {
      if (getDiagnosticsStatementParser == null) {
        FutureParser future = scoped("getDiagnosticsStatement", PUBLIC, true);
        getDiagnosticsStatementParser = future;
        future.setParser(
          sequence(
            keyword("GET"),
            keyword("DIAGNOSTICS"),
            optional(
              as("unknown",
                skipto(
                  eof()
                )
              )
            )
          )
        );
      }
    
      return getDiagnosticsStatementParser;
    }
    
    // ========================================================
    // prepareStatement
    // ........................................................
    
    private ParserCombinator prepareStatementParser = null;
    
    public final Start prepareStatement = Start.on(getNamespace(), "prepareStatement");
    
    public ParserCombinator prepareStatement() {
      if (prepareStatementParser == null) {
        FutureParser future = scoped("prepareStatement", PUBLIC, true);
        prepareStatementParser = future;
        future.setParser(
          sequence(
            keyword("PREPARE"),
            identifier(),
            optional(
              prepareStatement$prepareInto()
            ),
            keyword("FROM"),
            as("unknown",
              skipto(
                eof()
              )
            ),
            optional(
              as("unknown",
                skipto(
                  eof()
                )
              )
            )
          )
        );
      }
    
      return prepareStatementParser;
    }
    
    // ========================================================
    // prepareInto
    // ........................................................
    
    private ParserCombinator prepareStatement$prepareIntoParser = null;
    
    public final Start prepareStatement$prepareInto = Start.on(getNamespace(), "prepareInto");
    
    public ParserCombinator prepareStatement$prepareInto() {
      if (prepareStatement$prepareIntoParser == null) {
        FutureParser future = scoped("prepareInto", PUBLIC, true);
        prepareStatement$prepareIntoParser = future;
        future.setParser(
          sequence(
            keyword("INTO"),
            as("unknown",
              skipto(
                keyword("FROM")
              )
            )
          )
        );
      }
    
      return prepareStatement$prepareIntoParser;
    }
    
    // ========================================================
    // executeImmediateStatement
    // ........................................................
    
    private ParserCombinator executeImmediateStatementParser = null;
    
    public final Start executeImmediateStatement = Start.on(getNamespace(), "executeImmediateStatement");
    
    public ParserCombinator executeImmediateStatement() {
      if (executeImmediateStatementParser == null) {
        FutureParser future = scoped("executeImmediateStatement", PUBLIC, true);
        executeImmediateStatementParser = future;
        future.setParser(
          sequence(
            keyword("EXECUTE"),
            keyword("IMMEDIATE"),
            as("unknown",
              skipto(
                eof()
              )
            )
          )
        );
      }
    
      return executeImmediateStatementParser;
    }
    
    // ========================================================
    // executeStatement
    // ........................................................
    
    private ParserCombinator executeStatementParser = null;
    
    public final Start executeStatement = Start.on(getNamespace(), "executeStatement");
    
    public ParserCombinator executeStatement() {
      if (executeStatementParser == null) {
        FutureParser future = scoped("executeStatement", PUBLIC, true);
        executeStatementParser = future;
        future.setParser(
          sequence(
            keyword("EXECUTE"),
            identifier(),
            optional(
              executeStatement$executeUsing()
            ),
            optional(
              as("unknown",
                skipto(
                  eof()
                )
              )
            )
          )
        );
      }
    
      return executeStatementParser;
    }
    
    // ========================================================
    // executeUsing
    // ........................................................
    
    private ParserCombinator executeStatement$executeUsingParser = null;
    
    public final Start executeStatement$executeUsing = Start.on(getNamespace(), "executeUsing");
    
    public ParserCombinator executeStatement$executeUsing() {
      if (executeStatement$executeUsingParser == null) {
        FutureParser future = scoped("executeUsing", PUBLIC, true);
        executeStatement$executeUsingParser = future;
        future.setParser(
          sequence(
            keyword("USING"),
            as("unknown",
              skipto(
                eof()
              )
            )
          )
        );
      }
    
      return executeStatement$executeUsingParser;
    }
    
    // ========================================================
    // callStatement
    // ........................................................
    
    private ParserCombinator callStatementParser = null;
    
    public final Start callStatement = Start.on(getNamespace(), "callStatement");
    
    public ParserCombinator callStatement() {
      if (callStatementParser == null) {
        FutureParser future = scoped("callStatement", PUBLIC, true);
        callStatementParser = future;
        future.setParser(
          sequence(
            keyword("CALL"),
            choice(
              hostParameterSpecification(),
              callStatement$procedureName()
            ),
            optional(
              as("unknown",
                skipto(
                  eof()
                )
              )
            )
          )
        );
      }
    
      return callStatementParser;
    }
    
    // ========================================================
    // procedureName
    // ........................................................
    
    private ParserCombinator callStatement$procedureNameParser = null;
    
    public final Start callStatement$procedureName = Start.on(getNamespace(), "procedureName");
    
    public ParserCombinator callStatement$procedureName() {
      if (callStatement$procedureNameParser == null) {
        FutureParser future = scoped("procedureName", PUBLIC, true);
        callStatement$procedureNameParser = future;
        future.setParser(
          tableName()
        );
      }
    
      return callStatement$procedureNameParser;
    }
    
    // ========================================================
    // associateLocatorsStatement
    // ........................................................
    
    private ParserCombinator associateLocatorsStatementParser = null;
    
    public final Start associateLocatorsStatement = Start.on(getNamespace(), "associateLocatorsStatement");
    
    public ParserCombinator associateLocatorsStatement() {
      if (associateLocatorsStatementParser == null) {
        FutureParser future = scoped("associateLocatorsStatement", PUBLIC, true);
        associateLocatorsStatementParser = future;
        future.setParser(
          sequence(
            keyword("ASSOCIATE"),
            optional(
              sequence(
                keyword("RESULT"),
                keyword("SET")
              )
            ),
            choice(
              keyword("LOCATOR"),
              keyword("LOCATORS")
            ),
            optional(
              as("unknown",
                skipto(
                  eof()
                )
              )
            )
          )
        );
      }
    
      return associateLocatorsStatementParser;
    }
    
    // ========================================================
    // allocateCursorStatement
    // ........................................................
    
    private ParserCombinator allocateCursorStatementParser = null;
    
    public final Start allocateCursorStatement = Start.on(getNamespace(), "allocateCursorStatement");
    
    public ParserCombinator allocateCursorStatement() {
      if (allocateCursorStatementParser == null) {
        FutureParser future = scoped("allocateCursorStatement", PUBLIC, true);
        allocateCursorStatementParser = future;
        future.setParser(
          sequence(
            keyword("ALLOCATE"),
            cursorName(),
            keyword("CURSOR"),
            optional(
              as("unknown",
                skipto(
                  eof()
                )
              )
            )
          )
        );
      }
    
      return allocateCursorStatementParser;
    }
    
    // ========================================================
    // withSelectStatement
    // ........................................................
    
    private ParserCombinator withSelectStatementParser = null;
    
    public final Start withSelectStatement = Start.on(getNamespace(), "withSelectStatement");
    
    public ParserCombinator withSelectStatement() {
      if (withSelectStatementParser == null) {
        FutureParser future = scoped("withSelectStatement", PUBLIC, true);
        withSelectStatementParser = future;
        future.setParser(
          sequence(
            keyword("WITH"),
            as("unknown",
              skipto(
                eof()
              )
            )
          )
        );
      }
    
      return withSelectStatementParser;
    }
    
    // ========================================================
    // describeStatement
    // ........................................................
    
    private ParserCombinator describeStatementParser = null;
    
    public final Start describeStatement = Start.on(getNamespace(), "describeStatement");
    
    public ParserCombinator describeStatement() {
      if (describeStatementParser == null) {
        FutureParser future = scoped("describeStatement", PUBLIC, true);
        describeStatementParser = future;
        future.setParser(
          sequence(
            keyword("DESCRIBE"),
            identifier(),
            optional(
              describeStatement$describeInto()
            ),
            optional(
              as("unknown",
                skipto(
                  eof()
                )
              )
            )
          )
        );
      }
    
      return describeStatementParser;
    }
    
    // ========================================================
    // describeInto
    // ........................................................
    
    private ParserCombinator describeStatement$describeIntoParser = null;
    
    public final Start describeStatement$describeInto = Start.on(getNamespace(), "describeInto");
    
    public ParserCombinator describeStatement$describeInto() {
      if (describeStatement$describeIntoParser == null) {
        FutureParser future = scoped("describeInto", PUBLIC, true);
        describeStatement$describeIntoParser = future;
        future.setParser(
          sequence(
            keyword("INTO"),
            as("unknown",
              skipto(
                eof()
              )
            )
          )
        );
      }
    
      return describeStatement$describeIntoParser;
    }
    
    // ========================================================
    // alterStatement
    // ........................................................
    
    private ParserCombinator alterStatementParser = null;
    
    public final Start alterStatement = Start.on(getNamespace(), "alterStatement");
    
    public ParserCombinator alterStatement() {
      if (alterStatementParser == null) {
        FutureParser future = scoped("alterStatement", PUBLIC, true);
        alterStatementParser = future;
        future.setParser(
          sequence(
            keyword("ALTER"),
            optional(
              as("subject",
                choice(
                  keyword("DATABASE"),
                  keyword("DOMAIN"),
                  keyword("INDEX"),
                  sequence(
                    optional(
                      keyword("SPECIFIC")
                    ),
                    keyword("FUNCTION")
                  ),
                  keyword("MASK"),
                  keyword("PERMISSION"),
                  keyword("PROCEDURE"),
                  keyword("SEQUENCE"),
                  keyword("STOGROUP"),
                  keyword("TABLE"),
                  keyword("TABLESPACE"),
                  choice(
                    keyword("TRANSFORM"),
                    keyword("TRANSFORMS")
                  ),
                  keyword("TRIGGER"),
                  sequence(
                    keyword("TRUSTED"),
                    keyword("CONTEXT")
                  ),
                  keyword("VIEW"),
                  keyword("SESSION")
                )
              )
            ),
            optional(
              as("unknown",
                skipto(
                  eof()
                )
              )
            )
          )
        );
      }
    
      return alterStatementParser;
    }
    
    // ========================================================
    // createStatement
    // ........................................................
    
    private ParserCombinator createStatementParser = null;
    
    public final Start createStatement = Start.on(getNamespace(), "createStatement");
    
    public ParserCombinator createStatement() {
      if (createStatementParser == null) {
        FutureParser future = scoped("createStatement", PUBLIC, true);
        createStatementParser = future;
        future.setParser(
          sequence(
            keyword("CREATE"),
            optional(
              as("subject",
                choice(
                  sequence(
                    optional(
                      keyword("PUBLIC")
                    ),
                    keyword("ALIAS")
                  ),
                  keyword("ASSERTION"),
                  keyword("CAST"),
                  sequence(
                    keyword("CHARACTER"),
                    keyword("SET")
                  ),
                  keyword("COLLATION"),
                  keyword("DATABASE"),
                  keyword("DOMAIN"),
                  keyword("FUNCTION"),
                  sequence(
                    optional(
                      sequence(
                        keyword("UNIQUE"),
                        optional(
                          sequence(
                            keyword("WHERE"),
                            keyword("NOT"),
                            keyword("NULL")
                          )
                        )
                      )
                    ),
                    keyword("INDEX")
                  ),
                  keyword("MASK"),
                  sequence(
                    optional(
                      choice(
                        keyword("INSTANCE"),
                        keyword("STATIC"),
                        keyword("CONSTRUCTOR")
                      )
                    ),
                    keyword("METHOD")
                  ),
                  keyword("ORDERING"),
                  keyword("PERMISSION"),
                  keyword("PROCEDURE"),
                  keyword("ROLE"),
                  keyword("SCHEMA"),
                  keyword("SEQUENCE"),
                  sequence(
                    keyword("SPECIFIC"),
                    keyword("METHOD")
                  ),
                  keyword("STOGROUP"),
                  keyword("SYNONYM"),
                  sequence(
                    optional(
                      choice(
                        sequence(
                          choice(
                            keyword("GLOBAL"),
                            keyword("LOCAL")
                          ),
                          keyword("TEMPORARY")
                        ),
                        keyword("AUXILIARY"),
                        keyword("AUX")
                      )
                    ),
                    keyword("TABLE")
                  ),
                  sequence(
                    optional(
                      keyword("LOB")
                    ),
                    keyword("TABLESPACE")
                  ),
                  choice(
                    keyword("TRANSFORM"),
                    keyword("TRANSFORMS")
                  ),
                  keyword("TRANSLATION"),
                  keyword("TRIGGER"),
                  sequence(
                    keyword("TRUSTED"),
                    keyword("CONTEXT")
                  ),
                  keyword("TYPE"),
                  keyword("VARIABLE"),
                  sequence(
                    optional(
                      keyword("RECURSIVE")
                    ),
                    keyword("VIEW")
                  )
                )
              )
            ),
            optional(
              as("unknown",
                skipto(
                  eof()
                )
              )
            )
          )
        );
      }
    
      return createStatementParser;
    }
    
    // ========================================================
    // dropStatement
    // ........................................................
    
    private ParserCombinator dropStatementParser = null;
    
    public final Start dropStatement = Start.on(getNamespace(), "dropStatement");
    
    public ParserCombinator dropStatement() {
      if (dropStatementParser == null) {
        FutureParser future = scoped("dropStatement", PUBLIC, true);
        dropStatementParser = future;
        future.setParser(
          sequence(
            keyword("DROP"),
            optional(
              as("subject",
                choice(
                  sequence(
                    optional(
                      keyword("PUBLIC")
                    ),
                    keyword("ALIAS")
                  ),
                  keyword("CONSTRAINT"),
                  keyword("DATABASE"),
                  sequence(
                    optional(
                      keyword("SPECIFIC")
                    ),
                    keyword("FUNCTION")
                  ),
                  keyword("INDEX"),
                  keyword("MASK"),
                  keyword("PACKAGE"),
                  keyword("PERMISSION"),
                  keyword("PROCEDURE"),
                  keyword("ROLE"),
                  keyword("SCHEMA"),
                  keyword("SEQUENCE"),
                  keyword("STOGROUP"),
                  keyword("SYNONYM"),
                  keyword("TABLE"),
                  keyword("TABLESPACE"),
                  keyword("TRIGGER"),
                  sequence(
                    keyword("TRUSTED"),
                    keyword("CONTEXT")
                  ),
                  keyword("TYPE"),
                  keyword("VARIABLE"),
                  keyword("VIEW")
                )
              )
            ),
            optional(
              as("unknown",
                skipto(
                  eof()
                )
              )
            )
          )
        );
      }
    
      return dropStatementParser;
    }
    
    // ========================================================
    // renameStatement
    // ........................................................
    
    private ParserCombinator renameStatementParser = null;
    
    public final Start renameStatement = Start.on(getNamespace(), "renameStatement");
    
    public ParserCombinator renameStatement() {
      if (renameStatementParser == null) {
        FutureParser future = scoped("renameStatement", PUBLIC, true);
        renameStatementParser = future;
        future.setParser(
          sequence(
            keyword("RENAME"),
            optional(
              choice(
                keyword("TABLE"),
                keyword("INDEX")
              )
            ),
            optional(
              as("unknown",
                skipto(
                  eof()
                )
              )
            )
          )
        );
      }
    
      return renameStatementParser;
    }
    
    // ========================================================
    // searchCondition
    // ........................................................
    
    private ParserCombinator searchConditionParser = null;
    
    public final Start searchCondition = Start.on(getNamespace(), "searchCondition");
    
    public ParserCombinator searchCondition() {
      if (searchConditionParser == null) {
        FutureParser future = scoped("searchCondition", PUBLIC, true);
        searchConditionParser = future;
        future.setParser(
          balancing(
            // Closure:
            literal("("),
            // Closure:
            literal(")"),
            // Closure:
            literal("["),
            // Closure:
            literal("]"),
            // Closure:
            literal("{"),
            // Closure:
            literal("}"),
            // Closure:
            leftBracketTrigraph(),
            // Closure:
            rightBracketTrigraph(),
            disjunction()
          )
        );
      }
    
      return searchConditionParser;
    }
    
    // ========================================================
    // leftBracketTrigraph
    // ........................................................
    
    private ParserCombinator leftBracketTrigraphParser = null;
    
    protected final Start leftBracketTrigraph = Start.on(getNamespace(), "leftBracketTrigraph");
    
    protected ParserCombinator leftBracketTrigraph() {
      if (leftBracketTrigraphParser == null) {
        FutureParser future = scoped("leftBracketTrigraph", PRIVATE, true);
        leftBracketTrigraphParser = future;
        future.setParser(
          sequence(
            literal("?"),
            opt(NOSKIP,
              sequence(
                literal("?"),
                literal("(")
              )
            )
          )
        );
      }
    
      return leftBracketTrigraphParser;
    }
    
    // ========================================================
    // rightBracketTrigraph
    // ........................................................
    
    private ParserCombinator rightBracketTrigraphParser = null;
    
    protected final Start rightBracketTrigraph = Start.on(getNamespace(), "rightBracketTrigraph");
    
    protected ParserCombinator rightBracketTrigraph() {
      if (rightBracketTrigraphParser == null) {
        FutureParser future = scoped("rightBracketTrigraph", PRIVATE, true);
        rightBracketTrigraphParser = future;
        future.setParser(
          sequence(
            literal("?"),
            opt(NOSKIP,
              sequence(
                literal("?"),
                literal(")")
              )
            )
          )
        );
      }
    
      return rightBracketTrigraphParser;
    }
    
    // ========================================================
    // disjunction
    // ........................................................
    
    private ParserCombinator disjunctionParser = null;
    
    public final Start disjunction = Start.on(getNamespace(), "disjunction");
    
    public ParserCombinator disjunction() {
      if (disjunctionParser == null) {
        FutureParser future = scoped("disjunction", HIDING, true);
        disjunctionParser = future;
        future.setParser(
          sequence(
            upto(
              conjunction(),
              // Closure:
              choice(
                disjunction$or(),
                eof()
              )
            ),
            star(
              sequence(
                disjunction$or(),
                upto(
                  conjunction(),
                  // Closure:
                  choice(
                    disjunction$or(),
                    eof()
                  )
                )
              )
            )
          )
        );
      }
    
      return disjunctionParser;
    }
    
    // ========================================================
    // or
    // ........................................................
    
    private ParserCombinator disjunction$orParser = null;
    
    protected final Start disjunction$or = Start.on(getNamespace(), "or");
    
    protected ParserCombinator disjunction$or() {
      if (disjunction$orParser == null) {
        FutureParser future = scoped("or", PRIVATE, true);
        disjunction$orParser = future;
        future.setParser(
          notNested(
            keyword("OR")
          )
        );
      }
    
      return disjunction$orParser;
    }
    
    // ========================================================
    // conjunction
    // ........................................................
    
    private ParserCombinator conjunctionParser = null;
    
    public final Start conjunction = Start.on(getNamespace(), "conjunction");
    
    public ParserCombinator conjunction() {
      if (conjunctionParser == null) {
        FutureParser future = scoped("conjunction", HIDING, true);
        conjunctionParser = future;
        future.setParser(
          sequence(
            upto(
              negation(),
              // Closure:
              choice(
                conjunction$and(),
                eof()
              )
            ),
            star(
              sequence(
                conjunction$and(),
                upto(
                  negation(),
                  // Closure:
                  choice(
                    conjunction$and(),
                    eof()
                  )
                )
              )
            )
          )
        );
      }
    
      return conjunctionParser;
    }
    
    // ========================================================
    // and
    // ........................................................
    
    private ParserCombinator conjunction$andParser = null;
    
    protected final Start conjunction$and = Start.on(getNamespace(), "and");
    
    protected ParserCombinator conjunction$and() {
      if (conjunction$andParser == null) {
        FutureParser future = scoped("and", PRIVATE, true);
        conjunction$andParser = future;
        future.setParser(
          notNested(
            keyword("AND")
          )
        );
      }
    
      return conjunction$andParser;
    }
    
    // ========================================================
    // negation
    // ........................................................
    
    private ParserCombinator negationParser = null;
    
    public final Start negation = Start.on(getNamespace(), "negation");
    
    public ParserCombinator negation() {
      if (negationParser == null) {
        FutureParser future = scoped("negation", HIDING, true);
        negationParser = future;
        future.setParser(
          sequence(
            optional(
              keyword("NOT")
            ),
            term()
          )
        );
      }
    
      return negationParser;
    }
    
    // ========================================================
    // term
    // ........................................................
    
    private ParserCombinator termParser = null;
    
    public final Start term = Start.on(getNamespace(), "term");
    
    public ParserCombinator term() {
      if (termParser == null) {
        FutureParser future = scoped("term", HIDING, true);
        termParser = future;
        future.setParser(
          choice(
            sequence(
              literal("("),
              balancing(
                // Closure:
                literal("("),
                // Closure:
                literal(")"),
                // Closure:
                literal("["),
                // Closure:
                literal("]"),
                // Closure:
                literal("{"),
                // Closure:
                literal("}"),
                // Closure:
                leftBracketTrigraph(),
                // Closure:
                rightBracketTrigraph(),
                upto(
                  searchCondition(),
                  // Closure:
                  notNested(
                    literal(")")
                  )
                )
              ),
              literal(")")
            ),
            likePredicate(),
            comparison(),
            as("unknown",
              star(
                any()
              )
            )
          )
        );
      }
    
      return termParser;
    }
    
    // ========================================================
    // likePredicate
    // ........................................................
    
    private ParserCombinator likePredicateParser = null;
    
    public final Start likePredicate = Start.on(getNamespace(), "likePredicate");
    
    public ParserCombinator likePredicate() {
      if (likePredicateParser == null) {
        FutureParser future = scoped("likePredicate", PUBLIC, true);
        likePredicateParser = future;
        future.setParser(
          sequence(
            likePredicate$rowValuePredicand(),
            optional(
              keyword("NOT")
            ),
            keyword("LIKE"),
            likePredicate$pattern(),
            optional(
              likePredicate$escape()
            )
          )
        );
      }
    
      return likePredicateParser;
    }
    
    // ========================================================
    // rowValuePredicand
    // ........................................................
    
    private ParserCombinator likePredicate$rowValuePredicandParser = null;
    
    public final Start likePredicate$rowValuePredicand = Start.on(getNamespace(), "rowValuePredicand");
    
    public ParserCombinator likePredicate$rowValuePredicand() {
      if (likePredicate$rowValuePredicandParser == null) {
        FutureParser future = scoped("rowValuePredicand", PUBLIC, true);
        likePredicate$rowValuePredicandParser = future;
        future.setParser(
          upto(
            as("unknown",
              star(
                any()
              )
            ),
            // Closure:
            sequence(
              optional(
                keyword("NOT")
              ),
              keyword("LIKE")
            )
          )
        );
      }
    
      return likePredicate$rowValuePredicandParser;
    }
    
    // ========================================================
    // pattern
    // ........................................................
    
    private ParserCombinator likePredicate$patternParser = null;
    
    public final Start likePredicate$pattern = Start.on(getNamespace(), "pattern");
    
    public ParserCombinator likePredicate$pattern() {
      if (likePredicate$patternParser == null) {
        FutureParser future = scoped("pattern", PUBLIC, true);
        likePredicate$patternParser = future;
        future.setParser(
          sequence(
            limited(
              choice(
                stringLiteral(),
                as("unknown",
                  star(
                    any()
                  )
                )
              ),
              // Closure:
              choice(
                keyword("ESCAPE"),
                eof()
              )
            ),
            optional(
              skipto(
                choice(
                  keyword("ESCAPE"),
                  eof()
                )
              )
            )
          )
        );
      }
    
      return likePredicate$patternParser;
    }
    
    // ========================================================
    // escape
    // ........................................................
    
    private ParserCombinator likePredicate$escapeParser = null;
    
    public final Start likePredicate$escape = Start.on(getNamespace(), "escape");
    
    public ParserCombinator likePredicate$escape() {
      if (likePredicate$escapeParser == null) {
        FutureParser future = scoped("escape", PUBLIC, true);
        likePredicate$escapeParser = future;
        future.setParser(
          sequence(
            keyword("ESCAPE"),
            as("unknown",
              star(
                any()
              )
            )
          )
        );
      }
    
      return likePredicate$escapeParser;
    }
    
    // ========================================================
    // comparison
    // ........................................................
    
    private ParserCombinator comparisonParser = null;
    
    public final Start comparison = Start.on(getNamespace(), "comparison");
    
    public ParserCombinator comparison() {
      if (comparisonParser == null) {
        FutureParser future = scoped("comparison", PUBLIC, true);
        comparisonParser = future;
        future.setParser(
          sequence(
            choice(
              sequence(
                comparison$comparand(),
                optional(
                  as("unknown",
                    skipto(
                      comparisonOp()
                    )
                  )
                )
              ),
              as("unknown",
                skipto(
                  comparisonOp()
                )
              )
            ),
            comparisonOp(),
            choice(
              sequence(
                comparison$comparand(),
                optional(
                  as("unknown",
                    plus(
                      any()
                    )
                  )
                )
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
    
      return comparisonParser;
    }
    
    // ========================================================
    // comparand
    // ........................................................
    
    private ParserCombinator comparison$comparandParser = null;
    
    public final Start comparison$comparand = Start.on(getNamespace(), "comparand");
    
    public ParserCombinator comparison$comparand() {
      if (comparison$comparandParser == null) {
        FutureParser future = scoped("comparand", HIDING, true);
        comparison$comparandParser = future;
        future.setParser(
          choice(
            specialRegister(),
            hostParameterSpecification(),
            stringLiteral(),
            numericLiteral(),
            columnReference()
          )
        );
      }
    
      return comparison$comparandParser;
    }
    
    // ========================================================
    // comparisonOp
    // ........................................................
    
    private ParserCombinator comparisonOpParser = null;
    
    public final Start comparisonOp = Start.on(getNamespace(), "comparisonOp");
    
    public ParserCombinator comparisonOp() {
      if (comparisonOpParser == null) {
        FutureParser future = scoped("comparisonOp", PUBLIC, true);
        comparisonOpParser = future;
        future.setParser(
          choice(
            greaterThanOp(),
            lessThanOrEqualsOp(),
            greaterThanOrEqualsOp(),
            equalsOp(),
            notEqualsOp(),
            lessThanOp()
          )
        );
      }
    
      return comparisonOpParser;
    }
    
    // ========================================================
    // equalsOp
    // ........................................................
    
    private ParserCombinator equalsOpParser = null;
    
    public final Start equalsOp = Start.on(getNamespace(), "equalsOp");
    
    public ParserCombinator equalsOp() {
      if (equalsOpParser == null) {
        FutureParser future = scoped("equalsOp", PUBLIC, true);
        equalsOpParser = future;
        future.setParser(
          literal("=")
        );
      }
    
      return equalsOpParser;
    }
    
    // ========================================================
    // lessThanOp
    // ........................................................
    
    private ParserCombinator lessThanOpParser = null;
    
    public final Start lessThanOp = Start.on(getNamespace(), "lessThanOp");
    
    public ParserCombinator lessThanOp() {
      if (lessThanOpParser == null) {
        FutureParser future = scoped("lessThanOp", PUBLIC, true);
        lessThanOpParser = future;
        future.setParser(
          literal("<")
        );
      }
    
      return lessThanOpParser;
    }
    
    // ========================================================
    // greaterThanOp
    // ........................................................
    
    private ParserCombinator greaterThanOpParser = null;
    
    public final Start greaterThanOp = Start.on(getNamespace(), "greaterThanOp");
    
    public ParserCombinator greaterThanOp() {
      if (greaterThanOpParser == null) {
        FutureParser future = scoped("greaterThanOp", PUBLIC, true);
        greaterThanOpParser = future;
        future.setParser(
          literal(">")
        );
      }
    
      return greaterThanOpParser;
    }
    
    // ========================================================
    // notEqualsOp
    // ........................................................
    
    private ParserCombinator notEqualsOpParser = null;
    
    public final Start notEqualsOp = Start.on(getNamespace(), "notEqualsOp");
    
    public ParserCombinator notEqualsOp() {
      if (notEqualsOpParser == null) {
        FutureParser future = scoped("notEqualsOp", PUBLIC, true);
        notEqualsOpParser = future;
        future.setParser(
          choice(
            sequence(
              literal("<"),
              opt(NOSKIP,
                literal(">")
              )
            ),
            sequence(
              literal("!"),
              opt(NOSKIP,
                literal("=")
              )
            )
          )
        );
      }
    
      return notEqualsOpParser;
    }
    
    // ========================================================
    // greaterThanOrEqualsOp
    // ........................................................
    
    private ParserCombinator greaterThanOrEqualsOpParser = null;
    
    public final Start greaterThanOrEqualsOp = Start.on(getNamespace(), "greaterThanOrEqualsOp");
    
    public ParserCombinator greaterThanOrEqualsOp() {
      if (greaterThanOrEqualsOpParser == null) {
        FutureParser future = scoped("greaterThanOrEqualsOp", PUBLIC, true);
        greaterThanOrEqualsOpParser = future;
        future.setParser(
          choice(
            sequence(
              literal(">"),
              opt(NOSKIP,
                literal("=")
              )
            ),
            sequence(
              literal("!"),
              opt(NOSKIP,
                literal("<")
              )
            )
          )
        );
      }
    
      return greaterThanOrEqualsOpParser;
    }
    
    // ========================================================
    // lessThanOrEqualsOp
    // ........................................................
    
    private ParserCombinator lessThanOrEqualsOpParser = null;
    
    public final Start lessThanOrEqualsOp = Start.on(getNamespace(), "lessThanOrEqualsOp");
    
    public ParserCombinator lessThanOrEqualsOp() {
      if (lessThanOrEqualsOpParser == null) {
        FutureParser future = scoped("lessThanOrEqualsOp", PUBLIC, true);
        lessThanOrEqualsOpParser = future;
        future.setParser(
          choice(
            sequence(
              literal("<"),
              opt(NOSKIP,
                literal("=")
              )
            ),
            sequence(
              literal("!"),
              opt(NOSKIP,
                literal(">")
              )
            )
          )
        );
      }
    
      return lessThanOrEqualsOpParser;
    }
    
    // ========================================================
    // aggregateFunction
    // ........................................................
    
    private ParserCombinator aggregateFunctionParser = null;
    
    public final Start aggregateFunction = Start.on(getNamespace(), "aggregateFunction");
    
    public ParserCombinator aggregateFunction() {
      if (aggregateFunctionParser == null) {
        FutureParser future = scoped("aggregateFunction", PUBLIC, true);
        aggregateFunctionParser = future;
        future.setParser(
          choice(
            countAll(),
            countColumn(),
            generalAggregate()
          )
        );
      }
    
      return aggregateFunctionParser;
    }
    
    // ========================================================
    // countAll
    // ........................................................
    
    private ParserCombinator countAllParser = null;
    
    public final Start countAll = Start.on(getNamespace(), "countAll");
    
    public ParserCombinator countAll() {
      if (countAllParser == null) {
        FutureParser future = scoped("countAll", PUBLIC, true);
        countAllParser = future;
        future.setParser(
          sequence(
            keyword("COUNT"),
            literal("("),
            literal("*"),
            literal(")")
          )
        );
      }
    
      return countAllParser;
    }
    
    // ========================================================
    // countColumn
    // ........................................................
    
    private ParserCombinator countColumnParser = null;
    
    public final Start countColumn = Start.on(getNamespace(), "countColumn");
    
    public ParserCombinator countColumn() {
      if (countColumnParser == null) {
        FutureParser future = scoped("countColumn", PUBLIC, true);
        countColumnParser = future;
        future.setParser(
          sequence(
            keyword("COUNT"),
            literal("("),
            optional(
              countColumn$setQuantifier()
            ),
            as("unknown",
              skipto(
                literal(")")
              )
            ),
            literal(")")
          )
        );
      }
    
      return countColumnParser;
    }
    
    // ========================================================
    // setQuantifier
    // ........................................................
    
    private ParserCombinator countColumn$setQuantifierParser = null;
    
    public final Start countColumn$setQuantifier = Start.on(getNamespace(), "setQuantifier");
    
    public ParserCombinator countColumn$setQuantifier() {
      if (countColumn$setQuantifierParser == null) {
        FutureParser future = scoped("setQuantifier", PUBLIC, true);
        countColumn$setQuantifierParser = future;
        future.setParser(
          choice(
            as("distinct",
              keyword("DISTINCT")
            ),
            as("all",
              keyword("ALL")
            )
          )
        );
      }
    
      return countColumn$setQuantifierParser;
    }
    
    // ========================================================
    // generalAggregate
    // ........................................................
    
    private ParserCombinator generalAggregateParser = null;
    
    public final Start generalAggregate = Start.on(getNamespace(), "generalAggregate");
    
    public ParserCombinator generalAggregate() {
      if (generalAggregateParser == null) {
        FutureParser future = scoped("generalAggregate", PUBLIC, true);
        generalAggregateParser = future;
        future.setParser(
          sequence(
            generalAggregate$aggregateName(),
            literal("("),
            optional(
              generalAggregate$setQuantifier()
            ),
            as("unknown",
              skipto(
                literal(")")
              )
            ),
            literal(")")
          )
        );
      }
    
      return generalAggregateParser;
    }
    
    // ========================================================
    // aggregateName
    // ........................................................
    
    private ParserCombinator generalAggregate$aggregateNameParser = null;
    
    public final Start generalAggregate$aggregateName = Start.on(getNamespace(), "aggregateName");
    
    public ParserCombinator generalAggregate$aggregateName() {
      if (generalAggregate$aggregateNameParser == null) {
        FutureParser future = scoped("aggregateName", PUBLIC, true);
        generalAggregate$aggregateNameParser = future;
        future.setParser(
          choice(
            keyword("SUM"),
            keyword("AVG"),
            keyword("MIN"),
            keyword("MAX"),
            keyword("MEDIAN"),
            keyword("STDDEV"),
            keyword("VARIANCE"),
            keyword("VAR"),
            keyword("CORR"),
            keyword("CORRELATION"),
            keyword("COVAR"),
            keyword("COVARIANCE"),
            keyword("LISTAGG"),
            keyword("XMLAGG"),
            keyword("PERCENTILE_CONT"),
            keyword("PERCENTILE_DISC"),
            keyword("PERCENT_RANK"),
            keyword("CUME_DIST"),
            keyword("GROUPING")
          )
        );
      }
    
      return generalAggregate$aggregateNameParser;
    }
    
    // ========================================================
    // setQuantifier
    // ........................................................
    
    private ParserCombinator generalAggregate$setQuantifierParser = null;
    
    public final Start generalAggregate$setQuantifier = Start.on(getNamespace(), "setQuantifier");
    
    public ParserCombinator generalAggregate$setQuantifier() {
      if (generalAggregate$setQuantifierParser == null) {
        FutureParser future = scoped("setQuantifier", PUBLIC, true);
        generalAggregate$setQuantifierParser = future;
        future.setParser(
          choice(
            as("distinct",
              keyword("DISTINCT")
            ),
            as("all",
              keyword("ALL")
            )
          )
        );
      }
    
      return generalAggregate$setQuantifierParser;
    }
    
    // ========================================================
    // hostParameterSpecification
    // ........................................................
    
    private ParserCombinator hostParameterSpecificationParser = null;
    
    public final Start hostParameterSpecification = Start.on(getNamespace(), "hostParameterSpecification");
    
    public ParserCombinator hostParameterSpecification() {
      if (hostParameterSpecificationParser == null) {
        FutureParser future = scoped("hostParameterSpecification", PUBLIC, true);
        hostParameterSpecificationParser = future;
        future.setParser(
          sequence(
            hostParameterName(),
            optional(
              hostParameterSpecification$indicator()
            )
          )
        );
      }
    
      return hostParameterSpecificationParser;
    }
    
    // ========================================================
    // indicator
    // ........................................................
    
    private ParserCombinator hostParameterSpecification$indicatorParser = null;
    
    public final Start hostParameterSpecification$indicator = Start.on(getNamespace(), "indicator");
    
    public ParserCombinator hostParameterSpecification$indicator() {
      if (hostParameterSpecification$indicatorParser == null) {
        FutureParser future = scoped("indicator", PUBLIC, true);
        hostParameterSpecification$indicatorParser = future;
        future.setParser(
          sequence(
            optional(
              keyword("INDICATOR")
            ),
            hostParameterName()
          )
        );
      }
    
      return hostParameterSpecification$indicatorParser;
    }
    
    // ========================================================
    // hostParameterName
    // ........................................................
    
    private ParserCombinator hostParameterNameParser = null;
    
    public final Start hostParameterName = Start.on(getNamespace(), "hostParameterName");
    
    public ParserCombinator hostParameterName() {
      if (hostParameterNameParser == null) {
        FutureParser future = scoped("hostParameterName", PUBLIC, true);
        hostParameterNameParser = future;
        future.setParser(
          sequence(
            literal(":"),
            opt(NOSKIP,
              hostParameterName$hostIdentifier()
            ),
            optional(
              opt(NOSKIP,
                plus(
                  sequence(
                    literal("."),
                    opt(NOSKIP,
                      hostParameterName$hostIdentifier()
                    )
                  )
                )
              )
            )
          )
        );
      }
    
      return hostParameterNameParser;
    }
    
    // ========================================================
    // hostIdentifier
    // ........................................................
    
    private ParserCombinator hostParameterName$hostIdentifierParser = null;
    
    public final Start hostParameterName$hostIdentifier = Start.on(getNamespace(), "hostIdentifier");
    
    public ParserCombinator hostParameterName$hostIdentifier() {
      if (hostParameterName$hostIdentifierParser == null) {
        FutureParser future = scoped("hostIdentifier", HIDING, true);
        hostParameterName$hostIdentifierParser = future;
        future.setParser(
          as("identifier",
            choice(
              delimitedIdentifier(),
              as("regularIdentifier",
                cobolWord()
              )
            )
          )
        );
      }
    
      return hostParameterName$hostIdentifierParser;
    }
    
    // ========================================================
    // cobolWord
    // ........................................................
    
    private ParserCombinator cobolWordParser = null;
    
    protected final Start cobolWord = Start.on(getNamespace(), "cobolWord");
    
    protected ParserCombinator cobolWord() {
      if (cobolWordParser == null) {
        FutureParser future = scoped("cobolWord", PRIVATE, true);
        cobolWordParser = future;
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
                    tagged(NUMBER),
                    any()
                  ),
                  sequence(
                    tagged(WORD),
                    any()
                  ),
                  literal("_"),
                  literal("-")
                )
              )
            )
          )
        );
      }
    
      return cobolWordParser;
    }
    
    // ========================================================
    // identifier
    // ........................................................
    
    private ParserCombinator identifierParser = null;
    
    public final Start identifier = Start.on(getNamespace(), "identifier");
    
    public ParserCombinator identifier() {
      if (identifierParser == null) {
        FutureParser future = scoped("identifier", PUBLIC, true);
        identifierParser = future;
        future.setParser(
          choice(
            delimitedIdentifier(),
            regularIdentifier()
          )
        );
      }
    
      return identifierParser;
    }
    
    // ========================================================
    // regularIdentifier
    // ........................................................
    
    private ParserCombinator regularIdentifierParser = null;
    
    public final Start regularIdentifier = Start.on(getNamespace(), "regularIdentifier");
    
    public ParserCombinator regularIdentifier() {
      if (regularIdentifierParser == null) {
        FutureParser future = scoped("regularIdentifier", PUBLIC, true);
        regularIdentifierParser = future;
        future.setParser(
          word()
        );
      }
    
      return regularIdentifierParser;
    }
    
    // ========================================================
    // delimitedIdentifier
    // ........................................................
    
    private ParserCombinator delimitedIdentifierParser = null;
    
    public final Start delimitedIdentifier = Start.on(getNamespace(), "delimitedIdentifier");
    
    public ParserCombinator delimitedIdentifier() {
      if (delimitedIdentifierParser == null) {
        FutureParser future = scoped("delimitedIdentifier", PUBLIC, true);
        delimitedIdentifierParser = future;
        future.setParser(
          str()
        );
      }
    
      return delimitedIdentifierParser;
    }
    
    // ========================================================
    // tableReferenceList
    // ........................................................
    
    private ParserCombinator tableReferenceListParser = null;
    
    public final Start tableReferenceList = Start.on(getNamespace(), "tableReferenceList");
    
    public ParserCombinator tableReferenceList() {
      if (tableReferenceListParser == null) {
        FutureParser future = scoped("tableReferenceList", PUBLIC, true);
        tableReferenceListParser = future;
        future.setParser(
          sequence(
            tableReference(),
            star(
              sequence(
                tableReferenceList$joinOperator(),
                tableReference(),
                optional(
                  tableReferenceList$joinCondition()
                )
              )
            )
          )
        );
      }
    
      return tableReferenceListParser;
    }
    
    // ========================================================
    // joinOperator
    // ........................................................
    
    private ParserCombinator tableReferenceList$joinOperatorParser = null;
    
    protected final Start tableReferenceList$joinOperator = Start.on(getNamespace(), "joinOperator");
    
    protected ParserCombinator tableReferenceList$joinOperator() {
      if (tableReferenceList$joinOperatorParser == null) {
        FutureParser future = scoped("joinOperator", PRIVATE, true);
        tableReferenceList$joinOperatorParser = future;
        future.setParser(
          choice(
            literal(","),
            sequence(
              optional(
                choice(
                  keyword("INNER"),
                  sequence(
                    choice(
                      keyword("LEFT"),
                      keyword("RIGHT"),
                      keyword("FULL")
                    ),
                    optional(
                      keyword("OUTER")
                    )
                  ),
                  keyword("CROSS")
                )
              ),
              keyword("JOIN")
            )
          )
        );
      }
    
      return tableReferenceList$joinOperatorParser;
    }
    
    // ========================================================
    // joinCondition
    // ........................................................
    
    private ParserCombinator tableReferenceList$joinConditionParser = null;
    
    protected final Start tableReferenceList$joinCondition = Start.on(getNamespace(), "joinCondition");
    
    protected ParserCombinator tableReferenceList$joinCondition() {
      if (tableReferenceList$joinConditionParser == null) {
        FutureParser future = scoped("joinCondition", PRIVATE, true);
        tableReferenceList$joinConditionParser = future;
        future.setParser(
          choice(
            sequence(
              keyword("ON"),
              as("unknown",
                skipto(
                  tableReferenceList$afterJoinCondition()
                )
              )
            ),
            sequence(
              keyword("USING"),
              as("unknown",
                skipto(
                  tableReferenceList$afterJoinCondition()
                )
              )
            )
          )
        );
      }
    
      return tableReferenceList$joinConditionParser;
    }
    
    // ========================================================
    // afterJoinCondition
    // ........................................................
    
    private ParserCombinator tableReferenceList$afterJoinConditionParser = null;
    
    protected final Start tableReferenceList$afterJoinCondition = Start.on(getNamespace(), "afterJoinCondition");
    
    protected ParserCombinator tableReferenceList$afterJoinCondition() {
      if (tableReferenceList$afterJoinConditionParser == null) {
        FutureParser future = scoped("afterJoinCondition", PRIVATE, true);
        tableReferenceList$afterJoinConditionParser = future;
        future.setParser(
          choice(
            literal(","),
            keyword("INNER"),
            keyword("LEFT"),
            keyword("RIGHT"),
            keyword("FULL"),
            keyword("CROSS"),
            keyword("JOIN"),
            keyword("WHERE"),
            sequence(
              keyword("GROUP"),
              keyword("BY")
            ),
            keyword("HAVING"),
            sequence(
              keyword("ORDER"),
              keyword("BY")
            ),
            sequence(
              keyword("FETCH"),
              keyword("FIRST")
            ),
            keyword("WINDOW"),
            keyword("FOR"),
            keyword("WITH"),
            eof()
          )
        );
      }
    
      return tableReferenceList$afterJoinConditionParser;
    }
    
    // ========================================================
    // tableReference
    // ........................................................
    
    private ParserCombinator tableReferenceParser = null;
    
    public final Start tableReference = Start.on(getNamespace(), "tableReference");
    
    public ParserCombinator tableReference() {
      if (tableReferenceParser == null) {
        FutureParser future = scoped("tableReference", PUBLIC, true);
        tableReferenceParser = future;
        future.setParser(
          sequence(
            tableName(),
            optional(
              sequence(
                optional(
                  keyword("AS")
                ),
                not(
                  tableReference$reservedAfterTableReference()
                ),
                tableReference$correlationName()
              )
            )
          )
        );
      }
    
      return tableReferenceParser;
    }
    
    // ========================================================
    // correlationName
    // ........................................................
    
    private ParserCombinator tableReference$correlationNameParser = null;
    
    public final Start tableReference$correlationName = Start.on(getNamespace(), "correlationName");
    
    public ParserCombinator tableReference$correlationName() {
      if (tableReference$correlationNameParser == null) {
        FutureParser future = scoped("correlationName", PUBLIC, true);
        tableReference$correlationNameParser = future;
        future.setParser(
          identifier()
        );
      }
    
      return tableReference$correlationNameParser;
    }
    
    // ========================================================
    // reservedAfterTableReference
    // ........................................................
    
    private ParserCombinator tableReference$reservedAfterTableReferenceParser = null;
    
    protected final Start tableReference$reservedAfterTableReference = Start.on(getNamespace(), "reservedAfterTableReference");
    
    protected ParserCombinator tableReference$reservedAfterTableReference() {
      if (tableReference$reservedAfterTableReferenceParser == null) {
        FutureParser future = scoped("reservedAfterTableReference", PRIVATE, true);
        tableReference$reservedAfterTableReferenceParser = future;
        future.setParser(
          choice(
            keyword("INNER"),
            keyword("LEFT"),
            keyword("RIGHT"),
            keyword("FULL"),
            keyword("CROSS"),
            keyword("JOIN"),
            keyword("ON"),
            keyword("USING"),
            keyword("WHERE"),
            keyword("GROUP"),
            keyword("HAVING"),
            keyword("ORDER"),
            keyword("FETCH"),
            keyword("WINDOW"),
            keyword("FOR"),
            keyword("WITH"),
            keyword("UNION"),
            keyword("EXCEPT"),
            keyword("INTERSECT"),
            keyword("OPTIMIZE"),
            keyword("QUERYNO")
          )
        );
      }
    
      return tableReference$reservedAfterTableReferenceParser;
    }
    
    // ========================================================
    // cursorName
    // ........................................................
    
    private ParserCombinator cursorNameParser = null;
    
    public final Start cursorName = Start.on(getNamespace(), "cursorName");
    
    public ParserCombinator cursorName() {
      if (cursorNameParser == null) {
        FutureParser future = scoped("cursorName", PUBLIC, true);
        cursorNameParser = future;
        future.setParser(
          sequence(
            optional(
              sequence(
                cursorName$module(),
                literal(".")
              )
            ),
            identifier()
          )
        );
      }
    
      return cursorNameParser;
    }
    
    // ========================================================
    // module
    // ........................................................
    
    private ParserCombinator cursorName$moduleParser = null;
    
    public final Start cursorName$module = Start.on(getNamespace(), "module");
    
    public ParserCombinator cursorName$module() {
      if (cursorName$moduleParser == null) {
        FutureParser future = scoped("module", PUBLIC, true);
        cursorName$moduleParser = future;
        future.setParser(
          keyword("MODULE")
        );
      }
    
      return cursorName$moduleParser;
    }
    
    // ========================================================
    // tableName
    // ........................................................
    
    private ParserCombinator tableNameParser = null;
    
    public final Start tableName = Start.on(getNamespace(), "tableName");
    
    public ParserCombinator tableName() {
      if (tableNameParser == null) {
        FutureParser future = scoped("tableName", PUBLIC, true);
        tableNameParser = future;
        future.setParser(
          choice(
            sequence(
              tableName$catalogName(),
              literal("."),
              choice(
                tableName$module(),
                tableName$schemaName()
              ),
              literal("."),
              identifier()
            ),
            sequence(
              choice(
                tableName$module(),
                tableName$schemaName()
              ),
              literal("."),
              identifier()
            ),
            identifier()
          )
        );
      }
    
      return tableNameParser;
    }
    
    // ========================================================
    // module
    // ........................................................
    
    private ParserCombinator tableName$moduleParser = null;
    
    public final Start tableName$module = Start.on(getNamespace(), "module");
    
    public ParserCombinator tableName$module() {
      if (tableName$moduleParser == null) {
        FutureParser future = scoped("module", PUBLIC, true);
        tableName$moduleParser = future;
        future.setParser(
          keyword("MODULE")
        );
      }
    
      return tableName$moduleParser;
    }
    
    // ========================================================
    // schemaName
    // ........................................................
    
    private ParserCombinator tableName$schemaNameParser = null;
    
    public final Start tableName$schemaName = Start.on(getNamespace(), "schemaName");
    
    public ParserCombinator tableName$schemaName() {
      if (tableName$schemaNameParser == null) {
        FutureParser future = scoped("schemaName", PUBLIC, true);
        tableName$schemaNameParser = future;
        future.setParser(
          identifier()
        );
      }
    
      return tableName$schemaNameParser;
    }
    
    // ========================================================
    // catalogName
    // ........................................................
    
    private ParserCombinator tableName$catalogNameParser = null;
    
    public final Start tableName$catalogName = Start.on(getNamespace(), "catalogName");
    
    public ParserCombinator tableName$catalogName() {
      if (tableName$catalogNameParser == null) {
        FutureParser future = scoped("catalogName", PUBLIC, true);
        tableName$catalogNameParser = future;
        future.setParser(
          identifier()
        );
      }
    
      return tableName$catalogNameParser;
    }
    
    // ========================================================
    // targetTable
    // ........................................................
    
    private ParserCombinator targetTableParser = null;
    
    public final Start targetTable = Start.on(getNamespace(), "targetTable");
    
    public ParserCombinator targetTable() {
      if (targetTableParser == null) {
        FutureParser future = scoped("targetTable", PUBLIC, true);
        targetTableParser = future;
        future.setParser(
          choice(
            sequence(
              keyword("ONLY"),
              literal("("),
              tableName(),
              literal(")")
            ),
            tableName()
          )
        );
      }
    
      return targetTableParser;
    }
    
    // ========================================================
    // columnReference
    // ........................................................
    
    private ParserCombinator columnReferenceParser = null;
    
    public final Start columnReference = Start.on(getNamespace(), "columnReference");
    
    public ParserCombinator columnReference() {
      if (columnReferenceParser == null) {
        FutureParser future = scoped("columnReference", PUBLIC, true);
        columnReferenceParser = future;
        future.setParser(
          choice(
            sequence(
              columnReference$tableQualifier(),
              literal("."),
              identifier(),
              not(
                literal("(")
              )
            ),
            sequence(
              identifier(),
              not(
                choice(
                  literal("."),
                  literal("(")
                )
              )
            )
          )
        );
      }
    
      return columnReferenceParser;
    }
    
    // ========================================================
    // tableQualifier
    // ........................................................
    
    private ParserCombinator columnReference$tableQualifierParser = null;
    
    public final Start columnReference$tableQualifier = Start.on(getNamespace(), "tableQualifier");
    
    public ParserCombinator columnReference$tableQualifier() {
      if (columnReference$tableQualifierParser == null) {
        FutureParser future = scoped("tableQualifier", PUBLIC, true);
        columnReference$tableQualifierParser = future;
        future.setParser(
          identifier()
        );
      }
    
      return columnReference$tableQualifierParser;
    }
    
    // ========================================================
    // specialRegister
    // ........................................................
    
    private ParserCombinator specialRegisterParser = null;
    
    public final Start specialRegister = Start.on(getNamespace(), "specialRegister");
    
    public ParserCombinator specialRegister() {
      if (specialRegisterParser == null) {
        FutureParser future = scoped("specialRegister", PUBLIC, true);
        specialRegisterParser = future;
        future.setParser(
          choice(
            sequence(
              keyword("CURRENT"),
              choice(
                keyword("DATE"),
                keyword("TIME"),
                keyword("TIMESTAMP"),
                keyword("SERVER"),
                keyword("SQLID"),
                keyword("SCHEMA"),
                keyword("PATH"),
                keyword("TIMEZONE"),
                keyword("DEGREE"),
                keyword("MEMBER")
              )
            ),
            keyword("USER")
          )
        );
      }
    
      return specialRegisterParser;
    }
    
    // ========================================================
    // stringLiteral
    // ........................................................
    
    private ParserCombinator stringLiteralParser = null;
    
    public final Start stringLiteral = Start.on(getNamespace(), "stringLiteral");
    
    public ParserCombinator stringLiteral() {
      if (stringLiteralParser == null) {
        FutureParser future = scoped("stringLiteral", PUBLIC, true);
        stringLiteralParser = future;
        future.setParser(
          str()
        );
      }
    
      return stringLiteralParser;
    }
    
    // ========================================================
    // numericLiteral
    // ........................................................
    
    private ParserCombinator numericLiteralParser = null;
    
    public final Start numericLiteral = Start.on(getNamespace(), "numericLiteral");
    
    public ParserCombinator numericLiteral() {
      if (numericLiteralParser == null) {
        FutureParser future = scoped("numericLiteral", PUBLIC, true);
        numericLiteralParser = future;
        future.setParser(
          sequence(
            sequence(
              tagged(NUMBER),
              any()
            ),
            optional(
              opt(NOSKIP,
                sequence(
                  literal("."),
                  opt(NOSKIP,
                    sequence(
                      tagged(NUMBER),
                      any()
                    )
                  )
                )
              )
            )
          )
        );
      }
    
      return numericLiteralParser;
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
    // word
    // ........................................................
    
    private ParserCombinator wordParser = null;
    
    protected final Start word = Start.on(getNamespace(), "word");
    
    protected ParserCombinator word() {
      if (wordParser == null) {
        FutureParser future = scoped("word", PRIVATE, true);
        wordParser = future;
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
                    tagged(NUMBER),
                    any()
                  ),
                  sequence(
                    tagged(WORD),
                    any()
                  ),
                  literal("_")
                )
              )
            )
          )
        );
      }
    
      return wordParser;
    }
    
}
