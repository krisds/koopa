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
            renameStatement(),
            wheneverStatement(),
            declareSectionStatement()
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
            tableName(),
            optional(
              columnDefinitions()
            ),
            optional(
              declareGlobalTempTableStatement$onCommit()
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
    
      return declareGlobalTempTableStatementParser;
    }
    
    // ========================================================
    // onCommit
    // ........................................................
    
    private ParserCombinator declareGlobalTempTableStatement$onCommitParser = null;
    
    public final Start declareGlobalTempTableStatement$onCommit = Start.on(getNamespace(), "onCommit");
    
    public ParserCombinator declareGlobalTempTableStatement$onCommit() {
      if (declareGlobalTempTableStatement$onCommitParser == null) {
        FutureParser future = scoped("onCommit", PUBLIC, true);
        declareGlobalTempTableStatement$onCommitParser = future;
        future.setParser(
          sequence(
            keyword("ON"),
            keyword("COMMIT"),
            choice(
              keyword("PRESERVE"),
              keyword("DELETE"),
              keyword("DROP")
            ),
            choice(
              keyword("ROWS"),
              keyword("TABLE")
            )
          )
        );
      }
    
      return declareGlobalTempTableStatement$onCommitParser;
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
              columnDefinitions()
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
    // columnDefinitions
    // ........................................................
    
    private ParserCombinator columnDefinitionsParser = null;
    
    public final Start columnDefinitions = Start.on(getNamespace(), "columnDefinitions");
    
    public ParserCombinator columnDefinitions() {
      if (columnDefinitionsParser == null) {
        FutureParser future = scoped("columnDefinitions", PUBLIC, true);
        columnDefinitionsParser = future;
        future.setParser(
          sequence(
            literal("("),
            columnDefinitions$columnDefinition(),
            star(
              sequence(
                literal(","),
                columnDefinitions$columnDefinition()
              )
            ),
            literal(")")
          )
        );
      }
    
      return columnDefinitionsParser;
    }
    
    // ========================================================
    // columnDefinition
    // ........................................................
    
    private ParserCombinator columnDefinitions$columnDefinitionParser = null;
    
    public final Start columnDefinitions$columnDefinition = Start.on(getNamespace(), "columnDefinition");
    
    public ParserCombinator columnDefinitions$columnDefinition() {
      if (columnDefinitions$columnDefinitionParser == null) {
        FutureParser future = scoped("columnDefinition", PUBLIC, true);
        columnDefinitions$columnDefinitionParser = future;
        future.setParser(
          sequence(
            columnDefinitions$columnName(),
            dataType(),
            optional(
              sequence(
                keyword("FOR"),
                choice(
                  keyword("BIT"),
                  keyword("SBCS"),
                  keyword("MIXED")
                ),
                keyword("DATA")
              )
            ),
            optional(
              as("notNull",
                sequence(
                  keyword("NOT"),
                  keyword("NULL")
                )
              )
            ),
            optional(
              as("withDefault",
                sequence(
                  keyword("WITH"),
                  keyword("DEFAULT")
                )
              )
            )
          )
        );
      }
    
      return columnDefinitions$columnDefinitionParser;
    }
    
    // ========================================================
    // columnName
    // ........................................................
    
    private ParserCombinator columnDefinitions$columnNameParser = null;
    
    public final Start columnDefinitions$columnName = Start.on(getNamespace(), "columnName");
    
    public ParserCombinator columnDefinitions$columnName() {
      if (columnDefinitions$columnNameParser == null) {
        FutureParser future = scoped("columnName", PUBLIC, true);
        columnDefinitions$columnNameParser = future;
        future.setParser(
          identifier()
        );
      }
    
      return columnDefinitions$columnNameParser;
    }
    
    // ========================================================
    // dataType
    // ........................................................
    
    private ParserCombinator dataTypeParser = null;
    
    public final Start dataType = Start.on(getNamespace(), "dataType");
    
    public ParserCombinator dataType() {
      if (dataTypeParser == null) {
        FutureParser future = scoped("dataType", PUBLIC, true);
        dataTypeParser = future;
        future.setParser(
          sequence(
            dataType$typeName(),
            optional(
              sequence(
                literal("("),
                numericLiteral(),
                optional(
                  sequence(
                    literal(","),
                    numericLiteral()
                  )
                ),
                literal(")")
              )
            )
          )
        );
      }
    
      return dataTypeParser;
    }
    
    // ========================================================
    // typeName
    // ........................................................
    
    private ParserCombinator dataType$typeNameParser = null;
    
    public final Start dataType$typeName = Start.on(getNamespace(), "typeName");
    
    public ParserCombinator dataType$typeName() {
      if (dataType$typeNameParser == null) {
        FutureParser future = scoped("typeName", PUBLIC, true);
        dataType$typeNameParser = future;
        future.setParser(
          choice(
            keyword("CHARACTER"),
            keyword("CHAR"),
            keyword("VARCHAR"),
            keyword("GRAPHIC"),
            keyword("VARGRAPHIC"),
            keyword("SMALLINT"),
            keyword("INTEGER"),
            keyword("INT"),
            keyword("BIGINT"),
            keyword("DECIMAL"),
            keyword("DEC"),
            keyword("NUMERIC"),
            keyword("FLOAT"),
            keyword("REAL"),
            keyword("DOUBLE"),
            keyword("DATE"),
            keyword("TIME"),
            keyword("TIMESTAMP"),
            keyword("CLOB"),
            keyword("BLOB"),
            keyword("DBCLOB"),
            keyword("ROWID")
          )
        );
      }
    
      return dataType$typeNameParser;
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
              valuesIntoStatement$valuesRow()
            ),
            optional(
              valuesIntoStatement$valuesInto()
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
    
      return valuesIntoStatementParser;
    }
    
    // ========================================================
    // valuesRow
    // ........................................................
    
    private ParserCombinator valuesIntoStatement$valuesRowParser = null;
    
    public final Start valuesIntoStatement$valuesRow = Start.on(getNamespace(), "valuesRow");
    
    public ParserCombinator valuesIntoStatement$valuesRow() {
      if (valuesIntoStatement$valuesRowParser == null) {
        FutureParser future = scoped("valuesRow", PUBLIC, true);
        valuesIntoStatement$valuesRowParser = future;
        future.setParser(
          choice(
            sequence(
              literal("("),
              extendedValueExpression(),
              star(
                sequence(
                  literal(","),
                  extendedValueExpression()
                )
              ),
              literal(")")
            ),
            extendedValueExpression()
          )
        );
      }
    
      return valuesIntoStatement$valuesRowParser;
    }
    
    // ========================================================
    // valuesInto
    // ........................................................
    
    private ParserCombinator valuesIntoStatement$valuesIntoParser = null;
    
    public final Start valuesIntoStatement$valuesInto = Start.on(getNamespace(), "valuesInto");
    
    public ParserCombinator valuesIntoStatement$valuesInto() {
      if (valuesIntoStatement$valuesIntoParser == null) {
        FutureParser future = scoped("valuesInto", PUBLIC, true);
        valuesIntoStatement$valuesIntoParser = future;
        future.setParser(
          sequence(
            keyword("INTO"),
            choice(
              sequence(
                literal("("),
                hostParameterSpecification(),
                star(
                  sequence(
                    literal(","),
                    hostParameterSpecification()
                  )
                ),
                literal(")")
              ),
              sequence(
                hostParameterSpecification(),
                star(
                  sequence(
                    literal(","),
                    hostParameterSpecification()
                  )
                )
              )
            )
          )
        );
      }
    
      return valuesIntoStatement$valuesIntoParser;
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
            withSelectStatement(),
            as("statementName",
              identifier()
            ),
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
            optional(
              selectStatement$from()
            ),
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
            star(
              sequence(
                choice(
                  selectStatement$updatability(),
                  selectStatement$isolation(),
                  selectStatement$optimizeFor(),
                  selectStatement$queryno(),
                  selectStatement$fetchFirst()
                ),
                optional(
                  as("unknown",
                    skipto(
                      selectStatement$nextBlockOrEnd()
                    )
                  )
                )
              )
            ),
            star(
              sequence(
                selectStatement$setOperator(),
                selectStatement()
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
          sequence(
            selectStatement$selectList$sublist(),
            star(
              sequence(
                literal(","),
                selectStatement$selectList$sublist()
              )
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
          sequence(
            choice(
              aggregateFunction(),
              as("allColumns",
                literal("*")
              ),
              extendedValueExpression(),
              as("unknown",
                skipto(
                  choice(
                    literal(","),
                    keyword("INTO"),
                    keyword("FROM"),
                    eof()
                  )
                )
              )
            ),
            optional(
              selectStatement$selectList$columnLabel()
            ),
            optional(
              as("unknown",
                skipto(
                  choice(
                    literal(","),
                    keyword("INTO"),
                    keyword("FROM"),
                    eof()
                  )
                )
              )
            )
          )
        );
      }
    
      return selectStatement$selectList$sublistParser;
    }
    
    // ========================================================
    // columnLabel
    // ........................................................
    
    private ParserCombinator selectStatement$selectList$columnLabelParser = null;
    
    public final Start selectStatement$selectList$columnLabel = Start.on(getNamespace(), "columnLabel");
    
    public ParserCombinator selectStatement$selectList$columnLabel() {
      if (selectStatement$selectList$columnLabelParser == null) {
        FutureParser future = scoped("columnLabel", PUBLIC, true);
        selectStatement$selectList$columnLabelParser = future;
        future.setParser(
          sequence(
            keyword("AS"),
            selectStatement$selectList$columnLabel$columnAlias()
          )
        );
      }
    
      return selectStatement$selectList$columnLabelParser;
    }
    
    // ========================================================
    // columnAlias
    // ........................................................
    
    private ParserCombinator selectStatement$selectList$columnLabel$columnAliasParser = null;
    
    public final Start selectStatement$selectList$columnLabel$columnAlias = Start.on(getNamespace(), "columnAlias");
    
    public ParserCombinator selectStatement$selectList$columnLabel$columnAlias() {
      if (selectStatement$selectList$columnLabel$columnAliasParser == null) {
        FutureParser future = scoped("columnAlias", PUBLIC, true);
        selectStatement$selectList$columnLabel$columnAliasParser = future;
        future.setParser(
          identifier()
        );
      }
    
      return selectStatement$selectList$columnLabel$columnAliasParser;
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
                choice(
                  searchCondition(),
                  as("unknown",
                    star(
                      any()
                    )
                  )
                ),
                // Closure:
                selectStatement$where$whereBoundary()
              )
            )
          )
        );
      }
    
      return selectStatement$whereParser;
    }
    
    // ========================================================
    // whereBoundary
    // ........................................................
    
    private ParserCombinator selectStatement$where$whereBoundaryParser = null;
    
    protected final Start selectStatement$where$whereBoundary = Start.on(getNamespace(), "whereBoundary");
    
    protected ParserCombinator selectStatement$where$whereBoundary() {
      if (selectStatement$where$whereBoundaryParser == null) {
        FutureParser future = scoped("whereBoundary", PRIVATE, true);
        selectStatement$where$whereBoundaryParser = future;
        future.setParser(
          choice(
            notNested(
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
                keyword("UNION"),
                keyword("EXCEPT"),
                keyword("INTERSECT")
              )
            ),
            keyword("WINDOW"),
            keyword("FOR"),
            keyword("WITH"),
            keyword("OPTIMIZE"),
            keyword("QUERYNO"),
            eof()
          )
        );
      }
    
      return selectStatement$where$whereBoundaryParser;
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
            optional(
              sequence(
                selectStatement$groupBy$groupingColumn(),
                star(
                  sequence(
                    literal(","),
                    selectStatement$groupBy$groupingColumn()
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
    
      return selectStatement$groupByParser;
    }
    
    // ========================================================
    // groupingColumn
    // ........................................................
    
    private ParserCombinator selectStatement$groupBy$groupingColumnParser = null;
    
    public final Start selectStatement$groupBy$groupingColumn = Start.on(getNamespace(), "groupingColumn");
    
    public ParserCombinator selectStatement$groupBy$groupingColumn() {
      if (selectStatement$groupBy$groupingColumnParser == null) {
        FutureParser future = scoped("groupingColumn", PUBLIC, true);
        selectStatement$groupBy$groupingColumnParser = future;
        future.setParser(
          choice(
            columnReference(),
            numericLiteral()
          )
        );
      }
    
      return selectStatement$groupBy$groupingColumnParser;
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
                choice(
                  searchCondition(),
                  as("unknown",
                    star(
                      any()
                    )
                  )
                ),
                // Closure:
                selectStatement$having$havingBoundary()
              )
            )
          )
        );
      }
    
      return selectStatement$havingParser;
    }
    
    // ========================================================
    // havingBoundary
    // ........................................................
    
    private ParserCombinator selectStatement$having$havingBoundaryParser = null;
    
    protected final Start selectStatement$having$havingBoundary = Start.on(getNamespace(), "havingBoundary");
    
    protected ParserCombinator selectStatement$having$havingBoundary() {
      if (selectStatement$having$havingBoundaryParser == null) {
        FutureParser future = scoped("havingBoundary", PRIVATE, true);
        selectStatement$having$havingBoundaryParser = future;
        future.setParser(
          choice(
            notNested(
              choice(
                keyword("FROM"),
                keyword("WHERE"),
                sequence(
                  keyword("GROUP"),
                  keyword("BY")
                ),
                sequence(
                  keyword("ORDER"),
                  keyword("BY")
                ),
                sequence(
                  keyword("FETCH"),
                  keyword("FIRST")
                ),
                keyword("UNION"),
                keyword("EXCEPT"),
                keyword("INTERSECT")
              )
            ),
            keyword("WINDOW"),
            keyword("FOR"),
            keyword("WITH"),
            keyword("OPTIMIZE"),
            keyword("QUERYNO"),
            eof()
          )
        );
      }
    
      return selectStatement$having$havingBoundaryParser;
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
              caseExpression(),
              extendedValueExpression()
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
                    columnReference(),
                    star(
                      sequence(
                        literal(","),
                        columnReference()
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
    // isolation
    // ........................................................
    
    private ParserCombinator selectStatement$isolationParser = null;
    
    public final Start selectStatement$isolation = Start.on(getNamespace(), "isolation");
    
    public ParserCombinator selectStatement$isolation() {
      if (selectStatement$isolationParser == null) {
        FutureParser future = scoped("isolation", PUBLIC, true);
        selectStatement$isolationParser = future;
        future.setParser(
          sequence(
            keyword("WITH"),
            choice(
              as("ur",
                keyword("UR")
              ),
              as("cs",
                keyword("CS")
              ),
              as("rs",
                keyword("RS")
              ),
              as("rr",
                keyword("RR")
              )
            )
          )
        );
      }
    
      return selectStatement$isolationParser;
    }
    
    // ========================================================
    // optimizeFor
    // ........................................................
    
    private ParserCombinator selectStatement$optimizeForParser = null;
    
    public final Start selectStatement$optimizeFor = Start.on(getNamespace(), "optimizeFor");
    
    public ParserCombinator selectStatement$optimizeFor() {
      if (selectStatement$optimizeForParser == null) {
        FutureParser future = scoped("optimizeFor", PUBLIC, true);
        selectStatement$optimizeForParser = future;
        future.setParser(
          sequence(
            keyword("OPTIMIZE"),
            keyword("FOR"),
            numericLiteral(),
            choice(
              keyword("ROW"),
              keyword("ROWS")
            )
          )
        );
      }
    
      return selectStatement$optimizeForParser;
    }
    
    // ========================================================
    // queryno
    // ........................................................
    
    private ParserCombinator selectStatement$querynoParser = null;
    
    public final Start selectStatement$queryno = Start.on(getNamespace(), "queryno");
    
    public ParserCombinator selectStatement$queryno() {
      if (selectStatement$querynoParser == null) {
        FutureParser future = scoped("queryno", PUBLIC, true);
        selectStatement$querynoParser = future;
        future.setParser(
          sequence(
            keyword("QUERYNO"),
            numericLiteral()
          )
        );
      }
    
      return selectStatement$querynoParser;
    }
    
    // ========================================================
    // setOperator
    // ........................................................
    
    private ParserCombinator selectStatement$setOperatorParser = null;
    
    public final Start selectStatement$setOperator = Start.on(getNamespace(), "setOperator");
    
    public ParserCombinator selectStatement$setOperator() {
      if (selectStatement$setOperatorParser == null) {
        FutureParser future = scoped("setOperator", PUBLIC, true);
        selectStatement$setOperatorParser = future;
        future.setParser(
          sequence(
            choice(
              keyword("UNION"),
              keyword("EXCEPT"),
              keyword("INTERSECT")
            ),
            optional(
              choice(
                keyword("ALL"),
                keyword("DISTINCT")
              )
            )
          )
        );
      }
    
      return selectStatement$setOperatorParser;
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
            keyword("OPTIMIZE"),
            keyword("QUERYNO"),
            keyword("UNION"),
            keyword("EXCEPT"),
            keyword("INTERSECT"),
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
              insertColumns()
            ),
            optional(
              insertStatement$insertSource()
            ),
            optional(
              insertRows()
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
    
      return insertStatementParser;
    }
    
    // ========================================================
    // insertSource
    // ........................................................
    
    private ParserCombinator insertStatement$insertSourceParser = null;
    
    public final Start insertStatement$insertSource = Start.on(getNamespace(), "insertSource");
    
    public ParserCombinator insertStatement$insertSource() {
      if (insertStatement$insertSourceParser == null) {
        FutureParser future = scoped("insertSource", PUBLIC, true);
        insertStatement$insertSourceParser = future;
        future.setParser(
          choice(
            insertValues(),
            subquery(),
            selectStatement()
          )
        );
      }
    
      return insertStatement$insertSourceParser;
    }
    
    // ========================================================
    // insertColumns
    // ........................................................
    
    private ParserCombinator insertColumnsParser = null;
    
    public final Start insertColumns = Start.on(getNamespace(), "insertColumns");
    
    public ParserCombinator insertColumns() {
      if (insertColumnsParser == null) {
        FutureParser future = scoped("insertColumns", PUBLIC, true);
        insertColumnsParser = future;
        future.setParser(
          sequence(
            literal("("),
            columnReference(),
            star(
              sequence(
                literal(","),
                columnReference()
              )
            ),
            literal(")")
          )
        );
      }
    
      return insertColumnsParser;
    }
    
    // ========================================================
    // insertRows
    // ........................................................
    
    private ParserCombinator insertRowsParser = null;
    
    public final Start insertRows = Start.on(getNamespace(), "insertRows");
    
    public ParserCombinator insertRows() {
      if (insertRowsParser == null) {
        FutureParser future = scoped("insertRows", PUBLIC, true);
        insertRowsParser = future;
        future.setParser(
          sequence(
            keyword("FOR"),
            choice(
              hostParameterSpecification(),
              numericLiteral()
            ),
            keyword("ROWS"),
            optional(
              sequence(
                optional(
                  keyword("NOT")
                ),
                keyword("ATOMIC"),
                optional(
                  sequence(
                    keyword("CONTINUE"),
                    keyword("ON"),
                    keyword("SQLEXCEPTION")
                  )
                )
              )
            )
          )
        );
      }
    
      return insertRowsParser;
    }
    
    // ========================================================
    // insertValues
    // ........................................................
    
    private ParserCombinator insertValuesParser = null;
    
    public final Start insertValues = Start.on(getNamespace(), "insertValues");
    
    public ParserCombinator insertValues() {
      if (insertValuesParser == null) {
        FutureParser future = scoped("insertValues", PUBLIC, true);
        insertValuesParser = future;
        future.setParser(
          sequence(
            keyword("VALUES"),
            literal("("),
            insertValues$valueItem(),
            star(
              sequence(
                literal(","),
                insertValues$valueItem()
              )
            ),
            literal(")")
          )
        );
      }
    
      return insertValuesParser;
    }
    
    // ========================================================
    // valueItem
    // ........................................................
    
    private ParserCombinator insertValues$valueItemParser = null;
    
    public final Start insertValues$valueItem = Start.on(getNamespace(), "valueItem");
    
    public ParserCombinator insertValues$valueItem() {
      if (insertValues$valueItemParser == null) {
        FutureParser future = scoped("valueItem", HIDING, true);
        insertValues$valueItemParser = future;
        future.setParser(
          choice(
            valueExpression(),
            keyword("NULL"),
            keyword("DEFAULT"),
            as("identifier",
              as("regularIdentifier",
                cobolWord()
              )
            )
          )
        );
      }
    
      return insertValues$valueItemParser;
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
            optional(
              sequence(
                optional(
                  keyword("AS")
                ),
                not(
                  keyword("SET")
                ),
                updateStatement$correlationName()
              )
            ),
            set(),
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
    // correlationName
    // ........................................................
    
    private ParserCombinator updateStatement$correlationNameParser = null;
    
    public final Start updateStatement$correlationName = Start.on(getNamespace(), "correlationName");
    
    public ParserCombinator updateStatement$correlationName() {
      if (updateStatement$correlationNameParser == null) {
        FutureParser future = scoped("correlationName", PUBLIC, true);
        updateStatement$correlationNameParser = future;
        future.setParser(
          identifier()
        );
      }
    
      return updateStatement$correlationNameParser;
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
    // set
    // ........................................................
    
    private ParserCombinator setParser = null;
    
    public final Start set = Start.on(getNamespace(), "set");
    
    public ParserCombinator set() {
      if (setParser == null) {
        FutureParser future = scoped("set", PUBLIC, true);
        setParser = future;
        future.setParser(
          sequence(
            keyword("SET"),
            optional(
              sequence(
                set$assignment(),
                star(
                  sequence(
                    literal(","),
                    set$assignment()
                  )
                )
              )
            ),
            optional(
              as("unknown",
                skipto(
                  choice(
                    keyword("WHERE"),
                    eof()
                  )
                )
              )
            )
          )
        );
      }
    
      return setParser;
    }
    
    // ========================================================
    // assignment
    // ........................................................
    
    private ParserCombinator set$assignmentParser = null;
    
    public final Start set$assignment = Start.on(getNamespace(), "assignment");
    
    public ParserCombinator set$assignment() {
      if (set$assignmentParser == null) {
        FutureParser future = scoped("assignment", PUBLIC, true);
        set$assignmentParser = future;
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
            upto(
              sequence(
                set$assignment$assignmentTargets(),
                literal("="),
                choice(
                  sequence(
                    extendedValueExpression(),
                    optional(
                      as("unknown",
                        plus(
                          any()
                        )
                      )
                    )
                  ),
                  sequence(
                    subquery(),
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
              ),
              // Closure:
              notNested(
                choice(
                  literal(","),
                  keyword("WHERE")
                )
              )
            )
          )
        );
      }
    
      return set$assignmentParser;
    }
    
    // ========================================================
    // assignmentTargets
    // ........................................................
    
    private ParserCombinator set$assignment$assignmentTargetsParser = null;
    
    public final Start set$assignment$assignmentTargets = Start.on(getNamespace(), "assignmentTargets");
    
    public ParserCombinator set$assignment$assignmentTargets() {
      if (set$assignment$assignmentTargetsParser == null) {
        FutureParser future = scoped("assignmentTargets", PUBLIC, true);
        set$assignment$assignmentTargetsParser = future;
        future.setParser(
          choice(
            sequence(
              literal("("),
              columnReference(),
              star(
                sequence(
                  literal(","),
                  columnReference()
                )
              ),
              literal(")")
            ),
            columnReference()
          )
        );
      }
    
      return set$assignment$assignmentTargetsParser;
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
            optional(
              keyword("FROM")
            ),
            targetTable(),
            optional(
              deleteStatement$where()
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
    
      return deleteStatementParser;
    }
    
    // ========================================================
    // where
    // ........................................................
    
    private ParserCombinator deleteStatement$whereParser = null;
    
    public final Start deleteStatement$where = Start.on(getNamespace(), "where");
    
    public ParserCombinator deleteStatement$where() {
      if (deleteStatement$whereParser == null) {
        FutureParser future = scoped("where", PUBLIC, true);
        deleteStatement$whereParser = future;
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
    
      return deleteStatement$whereParser;
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
              mergeStatement$mergeTargetCorr()
            ),
            optional(
              mergeUsing()
            ),
            optional(
              mergeStatement$mergeOn()
            ),
            star(
              mergeStatement$mergeWhen()
            ),
            optional(
              sequence(
                keyword("ELSE"),
                keyword("IGNORE")
              )
            ),
            optional(
              mergeStatement$mergeAtomicity()
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
    
      return mergeStatementParser;
    }
    
    // ========================================================
    // mergeTargetCorr
    // ........................................................
    
    private ParserCombinator mergeStatement$mergeTargetCorrParser = null;
    
    public final Start mergeStatement$mergeTargetCorr = Start.on(getNamespace(), "mergeTargetCorr");
    
    public ParserCombinator mergeStatement$mergeTargetCorr() {
      if (mergeStatement$mergeTargetCorrParser == null) {
        FutureParser future = scoped("mergeTargetCorr", PUBLIC, true);
        mergeStatement$mergeTargetCorrParser = future;
        future.setParser(
          sequence(
            optional(
              keyword("AS")
            ),
            not(
              keyword("USING")
            ),
            identifier()
          )
        );
      }
    
      return mergeStatement$mergeTargetCorrParser;
    }
    
    // ========================================================
    // mergeAtomicity
    // ........................................................
    
    private ParserCombinator mergeStatement$mergeAtomicityParser = null;
    
    public final Start mergeStatement$mergeAtomicity = Start.on(getNamespace(), "mergeAtomicity");
    
    public ParserCombinator mergeStatement$mergeAtomicity() {
      if (mergeStatement$mergeAtomicityParser == null) {
        FutureParser future = scoped("mergeAtomicity", PUBLIC, true);
        mergeStatement$mergeAtomicityParser = future;
        future.setParser(
          sequence(
            optional(
              keyword("NOT")
            ),
            keyword("ATOMIC"),
            optional(
              sequence(
                keyword("CONTINUE"),
                keyword("ON"),
                as("unknown",
                  skipto(
                    eof()
                  )
                )
              )
            )
          )
        );
      }
    
      return mergeStatement$mergeAtomicityParser;
    }
    
    // ========================================================
    // mergeOn
    // ........................................................
    
    private ParserCombinator mergeStatement$mergeOnParser = null;
    
    public final Start mergeStatement$mergeOn = Start.on(getNamespace(), "mergeOn");
    
    public ParserCombinator mergeStatement$mergeOn() {
      if (mergeStatement$mergeOnParser == null) {
        FutureParser future = scoped("mergeOn", PUBLIC, true);
        mergeStatement$mergeOnParser = future;
        future.setParser(
          sequence(
            keyword("ON"),
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
              choice(
                keyword("WHEN"),
                eof()
              )
            ),
            optional(
              as("unknown",
                skipto(
                  choice(
                    keyword("WHEN"),
                    eof()
                  )
                )
              )
            )
          )
        );
      }
    
      return mergeStatement$mergeOnParser;
    }
    
    // ========================================================
    // mergeWhen
    // ........................................................
    
    private ParserCombinator mergeStatement$mergeWhenParser = null;
    
    public final Start mergeStatement$mergeWhen = Start.on(getNamespace(), "mergeWhen");
    
    public ParserCombinator mergeStatement$mergeWhen() {
      if (mergeStatement$mergeWhenParser == null) {
        FutureParser future = scoped("mergeWhen", PUBLIC, true);
        mergeStatement$mergeWhenParser = future;
        future.setParser(
          sequence(
            keyword("WHEN"),
            optional(
              keyword("NOT")
            ),
            keyword("MATCHED"),
            optional(
              sequence(
                keyword("AND"),
                as("unknown",
                  skipto(
                    keyword("THEN")
                  )
                )
              )
            ),
            keyword("THEN"),
            choice(
              mergeStatement$mergeWhen$mergeUpdate(),
              mergeStatement$mergeWhen$mergeInsert(),
              as("mergeDelete",
                keyword("DELETE")
              ),
              sequence(
                keyword("SIGNAL"),
                as("unknown",
                  skipto(
                    choice(
                      keyword("WHEN"),
                      eof()
                    )
                  )
                )
              ),
              as("unknown",
                skipto(
                  choice(
                    keyword("WHEN"),
                    eof()
                  )
                )
              )
            )
          )
        );
      }
    
      return mergeStatement$mergeWhenParser;
    }
    
    // ========================================================
    // mergeUpdate
    // ........................................................
    
    private ParserCombinator mergeStatement$mergeWhen$mergeUpdateParser = null;
    
    public final Start mergeStatement$mergeWhen$mergeUpdate = Start.on(getNamespace(), "mergeUpdate");
    
    public ParserCombinator mergeStatement$mergeWhen$mergeUpdate() {
      if (mergeStatement$mergeWhen$mergeUpdateParser == null) {
        FutureParser future = scoped("mergeUpdate", PUBLIC, true);
        mergeStatement$mergeWhen$mergeUpdateParser = future;
        future.setParser(
          sequence(
            keyword("UPDATE"),
            upto(
              set(),
              // Closure:
              choice(
                keyword("WHEN"),
                eof()
              )
            )
          )
        );
      }
    
      return mergeStatement$mergeWhen$mergeUpdateParser;
    }
    
    // ========================================================
    // mergeInsert
    // ........................................................
    
    private ParserCombinator mergeStatement$mergeWhen$mergeInsertParser = null;
    
    public final Start mergeStatement$mergeWhen$mergeInsert = Start.on(getNamespace(), "mergeInsert");
    
    public ParserCombinator mergeStatement$mergeWhen$mergeInsert() {
      if (mergeStatement$mergeWhen$mergeInsertParser == null) {
        FutureParser future = scoped("mergeInsert", PUBLIC, true);
        mergeStatement$mergeWhen$mergeInsertParser = future;
        future.setParser(
          sequence(
            keyword("INSERT"),
            optional(
              insertColumns()
            ),
            optional(
              insertValues()
            ),
            optional(
              as("unknown",
                skipto(
                  choice(
                    keyword("WHEN"),
                    eof()
                  )
                )
              )
            )
          )
        );
      }
    
      return mergeStatement$mergeWhen$mergeInsertParser;
    }
    
    // ========================================================
    // mergeUsing
    // ........................................................
    
    private ParserCombinator mergeUsingParser = null;
    
    public final Start mergeUsing = Start.on(getNamespace(), "mergeUsing");
    
    public ParserCombinator mergeUsing() {
      if (mergeUsingParser == null) {
        FutureParser future = scoped("mergeUsing", PUBLIC, true);
        mergeUsingParser = future;
        future.setParser(
          sequence(
            keyword("USING"),
            choice(
              mergeUsing$mergeSourceTable(),
              mergeUsing$mergeSourceValues()
            )
          )
        );
      }
    
      return mergeUsingParser;
    }
    
    // ========================================================
    // mergeSourceValues
    // ........................................................
    
    private ParserCombinator mergeUsing$mergeSourceValuesParser = null;
    
    public final Start mergeUsing$mergeSourceValues = Start.on(getNamespace(), "mergeSourceValues");
    
    public ParserCombinator mergeUsing$mergeSourceValues() {
      if (mergeUsing$mergeSourceValuesParser == null) {
        FutureParser future = scoped("mergeSourceValues", PUBLIC, true);
        mergeUsing$mergeSourceValuesParser = future;
        future.setParser(
          sequence(
            literal("("),
            choice(
              sequence(
                insertValues(),
                optional(
                  insertRows()
                )
              ),
              selectStatement()
            ),
            literal(")"),
            optional(
              mergeUsing$correlation()
            )
          )
        );
      }
    
      return mergeUsing$mergeSourceValuesParser;
    }
    
    // ========================================================
    // mergeSourceTable
    // ........................................................
    
    private ParserCombinator mergeUsing$mergeSourceTableParser = null;
    
    public final Start mergeUsing$mergeSourceTable = Start.on(getNamespace(), "mergeSourceTable");
    
    public ParserCombinator mergeUsing$mergeSourceTable() {
      if (mergeUsing$mergeSourceTableParser == null) {
        FutureParser future = scoped("mergeSourceTable", PUBLIC, true);
        mergeUsing$mergeSourceTableParser = future;
        future.setParser(
          sequence(
            tableName(),
            optional(
              mergeUsing$correlation()
            )
          )
        );
      }
    
      return mergeUsing$mergeSourceTableParser;
    }
    
    // ========================================================
    // correlation
    // ........................................................
    
    private ParserCombinator mergeUsing$correlationParser = null;
    
    public final Start mergeUsing$correlation = Start.on(getNamespace(), "correlation");
    
    public ParserCombinator mergeUsing$correlation() {
      if (mergeUsing$correlationParser == null) {
        FutureParser future = scoped("correlation", PUBLIC, true);
        mergeUsing$correlationParser = future;
        future.setParser(
          sequence(
            optional(
              keyword("AS")
            ),
            identifier(),
            optional(
              insertColumns()
            )
          )
        );
      }
    
      return mergeUsing$correlationParser;
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
          sequence(
            keyword("ROLLBACK"),
            optional(
              keyword("WORK")
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
              sequence(
                keyword("PART"),
                numericLiteral()
              )
            ),
            optional(
              sequence(
                keyword("IN"),
                choice(
                  keyword("SHARE"),
                  keyword("EXCLUSIVE")
                ),
                keyword("MODE")
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
              choice(
                keyword("SENSITIVE"),
                keyword("INSENSITIVE")
              )
            ),
            optional(
              fetchStatement$fetchOrientation()
            ),
            optional(
              fetchStatement$rowsetClause()
            ),
            optional(
              keyword("FROM")
            ),
            cursorName(),
            optional(
              fetchStatement$fetchFor()
            ),
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
            keyword("CURRENT"),
            as("absolute",
              sequence(
                keyword("ABSOLUTE"),
                choice(
                  hostParameterSpecification(),
                  numericLiteral()
                )
              )
            ),
            as("relative",
              sequence(
                keyword("RELATIVE"),
                choice(
                  hostParameterSpecification(),
                  numericLiteral()
                )
              )
            )
          )
        );
      }
    
      return fetchStatement$fetchOrientationParser;
    }
    
    // ========================================================
    // rowsetClause
    // ........................................................
    
    private ParserCombinator fetchStatement$rowsetClauseParser = null;
    
    public final Start fetchStatement$rowsetClause = Start.on(getNamespace(), "rowsetClause");
    
    public ParserCombinator fetchStatement$rowsetClause() {
      if (fetchStatement$rowsetClauseParser == null) {
        FutureParser future = scoped("rowsetClause", PUBLIC, true);
        fetchStatement$rowsetClauseParser = future;
        future.setParser(
          sequence(
            keyword("ROWSET"),
            optional(
              sequence(
                keyword("STARTING"),
                keyword("AT"),
                choice(
                  keyword("ABSOLUTE"),
                  keyword("RELATIVE")
                ),
                choice(
                  hostParameterSpecification(),
                  numericLiteral()
                )
              )
            )
          )
        );
      }
    
      return fetchStatement$rowsetClauseParser;
    }
    
    // ========================================================
    // fetchFor
    // ........................................................
    
    private ParserCombinator fetchStatement$fetchForParser = null;
    
    public final Start fetchStatement$fetchFor = Start.on(getNamespace(), "fetchFor");
    
    public ParserCombinator fetchStatement$fetchFor() {
      if (fetchStatement$fetchForParser == null) {
        FutureParser future = scoped("fetchFor", PUBLIC, true);
        fetchStatement$fetchForParser = future;
        future.setParser(
          sequence(
            keyword("FOR"),
            choice(
              hostParameterSpecification(),
              numericLiteral()
            ),
            choice(
              keyword("ROW"),
              keyword("ROWS")
            )
          )
        );
      }
    
      return fetchStatement$fetchForParser;
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
              sequence(
                setStatement$hostAssignment(),
                star(
                  sequence(
                    literal(","),
                    setStatement$hostAssignment()
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
    
      return setStatementParser;
    }
    
    // ========================================================
    // hostAssignment
    // ........................................................
    
    private ParserCombinator setStatement$hostAssignmentParser = null;
    
    public final Start setStatement$hostAssignment = Start.on(getNamespace(), "hostAssignment");
    
    public ParserCombinator setStatement$hostAssignment() {
      if (setStatement$hostAssignmentParser == null) {
        FutureParser future = scoped("hostAssignment", PUBLIC, true);
        setStatement$hostAssignmentParser = future;
        future.setParser(
          sequence(
            hostParameterSpecification(),
            literal("="),
            choice(
              sequence(
                extendedValueExpression(),
                optional(
                  as("unknown",
                    skipto(
                      choice(
                        literal(","),
                        eof()
                      )
                    )
                  )
                )
              ),
              as("unknown",
                skipto(
                  choice(
                    literal(","),
                    eof()
                  )
                )
              )
            )
          )
        );
      }
    
      return setStatement$hostAssignmentParser;
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
              sequence(
                keyword("CONDITION"),
                choice(
                  hostParameterName(),
                  numericLiteral()
                )
              )
            ),
            optional(
              sequence(
                getDiagnosticsStatement$diagnosticsItem(),
                star(
                  sequence(
                    literal(","),
                    getDiagnosticsStatement$diagnosticsItem()
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
    
      return getDiagnosticsStatementParser;
    }
    
    // ========================================================
    // diagnosticsItem
    // ........................................................
    
    private ParserCombinator getDiagnosticsStatement$diagnosticsItemParser = null;
    
    public final Start getDiagnosticsStatement$diagnosticsItem = Start.on(getNamespace(), "diagnosticsItem");
    
    public ParserCombinator getDiagnosticsStatement$diagnosticsItem() {
      if (getDiagnosticsStatement$diagnosticsItemParser == null) {
        FutureParser future = scoped("diagnosticsItem", PUBLIC, true);
        getDiagnosticsStatement$diagnosticsItemParser = future;
        future.setParser(
          sequence(
            hostParameterSpecification(),
            literal("="),
            getDiagnosticsStatement$diagnosticsItem$itemName()
          )
        );
      }
    
      return getDiagnosticsStatement$diagnosticsItemParser;
    }
    
    // ========================================================
    // itemName
    // ........................................................
    
    private ParserCombinator getDiagnosticsStatement$diagnosticsItem$itemNameParser = null;
    
    public final Start getDiagnosticsStatement$diagnosticsItem$itemName = Start.on(getNamespace(), "itemName");
    
    public ParserCombinator getDiagnosticsStatement$diagnosticsItem$itemName() {
      if (getDiagnosticsStatement$diagnosticsItem$itemNameParser == null) {
        FutureParser future = scoped("itemName", PUBLIC, true);
        getDiagnosticsStatement$diagnosticsItem$itemNameParser = future;
        future.setParser(
          identifier()
        );
      }
    
      return getDiagnosticsStatement$diagnosticsItem$itemNameParser;
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
            choice(
              hostParameterSpecification(),
              as("unknown",
                skipto(
                  eof()
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
              sequence(
                literal("("),
                optional(
                  sequence(
                    functionArgument(),
                    star(
                      sequence(
                        literal(","),
                        functionArgument()
                      )
                    )
                  )
                ),
                literal(")")
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
              sequence(
                literal("("),
                hostParameterSpecification(),
                star(
                  sequence(
                    literal(","),
                    hostParameterSpecification()
                  )
                ),
                literal(")")
              )
            ),
            optional(
              sequence(
                keyword("WITH"),
                keyword("PROCEDURE"),
                associateLocatorsStatement$procedureName()
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
    
      return associateLocatorsStatementParser;
    }
    
    // ========================================================
    // procedureName
    // ........................................................
    
    private ParserCombinator associateLocatorsStatement$procedureNameParser = null;
    
    public final Start associateLocatorsStatement$procedureName = Start.on(getNamespace(), "procedureName");
    
    public ParserCombinator associateLocatorsStatement$procedureName() {
      if (associateLocatorsStatement$procedureNameParser == null) {
        FutureParser future = scoped("procedureName", PUBLIC, true);
        associateLocatorsStatement$procedureNameParser = future;
        future.setParser(
          choice(
            hostParameterSpecification(),
            tableName()
          )
        );
      }
    
      return associateLocatorsStatement$procedureNameParser;
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
              sequence(
                keyword("FOR"),
                keyword("RESULT"),
                keyword("SET"),
                hostParameterSpecification()
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
            choice(
              sequence(
                withSelectStatement$commonTableExpression(),
                star(
                  sequence(
                    literal(","),
                    withSelectStatement$commonTableExpression()
                  )
                ),
                choice(
                  selectStatement(),
                  as("unknown",
                    skipto(
                      eof()
                    )
                  )
                )
              ),
              as("unknown",
                skipto(
                  eof()
                )
              )
            )
          )
        );
      }
    
      return withSelectStatementParser;
    }
    
    // ========================================================
    // commonTableExpression
    // ........................................................
    
    private ParserCombinator withSelectStatement$commonTableExpressionParser = null;
    
    public final Start withSelectStatement$commonTableExpression = Start.on(getNamespace(), "commonTableExpression");
    
    public ParserCombinator withSelectStatement$commonTableExpression() {
      if (withSelectStatement$commonTableExpressionParser == null) {
        FutureParser future = scoped("commonTableExpression", PUBLIC, true);
        withSelectStatement$commonTableExpressionParser = future;
        future.setParser(
          sequence(
            withSelectStatement$commonTableExpression$cteName(),
            optional(
              sequence(
                literal("("),
                columnReference(),
                star(
                  sequence(
                    literal(","),
                    columnReference()
                  )
                ),
                literal(")")
              )
            ),
            keyword("AS"),
            subquery()
          )
        );
      }
    
      return withSelectStatement$commonTableExpressionParser;
    }
    
    // ========================================================
    // cteName
    // ........................................................
    
    private ParserCombinator withSelectStatement$commonTableExpression$cteNameParser = null;
    
    public final Start withSelectStatement$commonTableExpression$cteName = Start.on(getNamespace(), "cteName");
    
    public ParserCombinator withSelectStatement$commonTableExpression$cteName() {
      if (withSelectStatement$commonTableExpression$cteNameParser == null) {
        FutureParser future = scoped("cteName", PUBLIC, true);
        withSelectStatement$commonTableExpression$cteNameParser = future;
        future.setParser(
          identifier()
        );
      }
    
      return withSelectStatement$commonTableExpression$cteNameParser;
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
              indexDefinition()
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
    // indexDefinition
    // ........................................................
    
    private ParserCombinator indexDefinitionParser = null;
    
    public final Start indexDefinition = Start.on(getNamespace(), "indexDefinition");
    
    public ParserCombinator indexDefinition() {
      if (indexDefinitionParser == null) {
        FutureParser future = scoped("indexDefinition", PUBLIC, true);
        indexDefinitionParser = future;
        future.setParser(
          sequence(
            tableName(),
            keyword("ON"),
            tableName(),
            literal("("),
            indexDefinition$indexKeyColumn(),
            star(
              sequence(
                literal(","),
                indexDefinition$indexKeyColumn()
              )
            ),
            literal(")"),
            star(
              indexDefinition$indexOption()
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
    
      return indexDefinitionParser;
    }
    
    // ========================================================
    // indexKeyColumn
    // ........................................................
    
    private ParserCombinator indexDefinition$indexKeyColumnParser = null;
    
    public final Start indexDefinition$indexKeyColumn = Start.on(getNamespace(), "indexKeyColumn");
    
    public ParserCombinator indexDefinition$indexKeyColumn() {
      if (indexDefinition$indexKeyColumnParser == null) {
        FutureParser future = scoped("indexKeyColumn", PUBLIC, true);
        indexDefinition$indexKeyColumnParser = future;
        future.setParser(
          sequence(
            columnReference(),
            optional(
              choice(
                keyword("ASC"),
                keyword("DESC"),
                keyword("RANDOM")
              )
            )
          )
        );
      }
    
      return indexDefinition$indexKeyColumnParser;
    }
    
    // ========================================================
    // indexOption
    // ........................................................
    
    private ParserCombinator indexDefinition$indexOptionParser = null;
    
    public final Start indexDefinition$indexOption = Start.on(getNamespace(), "indexOption");
    
    public ParserCombinator indexDefinition$indexOption() {
      if (indexDefinition$indexOptionParser == null) {
        FutureParser future = scoped("indexOption", PUBLIC, true);
        indexDefinition$indexOptionParser = future;
        future.setParser(
          choice(
            sequence(
              keyword("USING"),
              keyword("STOGROUP"),
              identifier()
            ),
            sequence(
              keyword("PRIQTY"),
              optional(
                literal("-")
              ),
              numericLiteral()
            ),
            sequence(
              keyword("SECQTY"),
              optional(
                literal("-")
              ),
              numericLiteral()
            ),
            sequence(
              keyword("FREEPAGE"),
              numericLiteral()
            ),
            sequence(
              keyword("PCTFREE"),
              numericLiteral()
            ),
            sequence(
              keyword("BUFFERPOOL"),
              identifier()
            ),
            sequence(
              keyword("GBPCACHE"),
              choice(
                keyword("CHANGED"),
                keyword("ALL"),
                keyword("NONE"),
                keyword("SYSTEM")
              )
            ),
            sequence(
              keyword("ERASE"),
              choice(
                keyword("YES"),
                keyword("NO")
              )
            ),
            sequence(
              keyword("CLOSE"),
              choice(
                keyword("YES"),
                keyword("NO")
              )
            ),
            sequence(
              keyword("COPY"),
              choice(
                keyword("YES"),
                keyword("NO")
              )
            ),
            sequence(
              keyword("COMPRESS"),
              choice(
                keyword("YES"),
                keyword("NO")
              )
            ),
            sequence(
              optional(
                keyword("NOT")
              ),
              keyword("PADDED")
            ),
            sequence(
              optional(
                keyword("NOT")
              ),
              keyword("CLUSTER")
            ),
            sequence(
              keyword("DEFINE"),
              choice(
                keyword("YES"),
                keyword("NO")
              )
            )
          )
        );
      }
    
      return indexDefinition$indexOptionParser;
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
              tableName()
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
    // wheneverStatement
    // ........................................................
    
    private ParserCombinator wheneverStatementParser = null;
    
    public final Start wheneverStatement = Start.on(getNamespace(), "wheneverStatement");
    
    public ParserCombinator wheneverStatement() {
      if (wheneverStatementParser == null) {
        FutureParser future = scoped("wheneverStatement", PUBLIC, true);
        wheneverStatementParser = future;
        future.setParser(
          sequence(
            keyword("WHENEVER"),
            choice(
              sequence(
                keyword("NOT"),
                keyword("FOUND")
              ),
              keyword("SQLERROR"),
              keyword("SQLWARNING")
            ),
            choice(
              keyword("CONTINUE"),
              sequence(
                choice(
                  sequence(
                    keyword("GO"),
                    keyword("TO")
                  ),
                  keyword("GOTO")
                ),
                optional(
                  literal(":")
                ),
                wheneverStatement$hostLabel()
              )
            )
          )
        );
      }
    
      return wheneverStatementParser;
    }
    
    // ========================================================
    // hostLabel
    // ........................................................
    
    private ParserCombinator wheneverStatement$hostLabelParser = null;
    
    public final Start wheneverStatement$hostLabel = Start.on(getNamespace(), "hostLabel");
    
    public ParserCombinator wheneverStatement$hostLabel() {
      if (wheneverStatement$hostLabelParser == null) {
        FutureParser future = scoped("hostLabel", PUBLIC, true);
        wheneverStatement$hostLabelParser = future;
        future.setParser(
          sequence(
            choice(
              sequence(
                tagged(WORD),
                any()
              ),
              sequence(
                tagged(NUMBER),
                any()
              )
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
                  ),
                  literal("_"),
                  literal("-")
                )
              )
            )
          )
        );
      }
    
      return wheneverStatement$hostLabelParser;
    }
    
    // ========================================================
    // declareSectionStatement
    // ........................................................
    
    private ParserCombinator declareSectionStatementParser = null;
    
    public final Start declareSectionStatement = Start.on(getNamespace(), "declareSectionStatement");
    
    public ParserCombinator declareSectionStatement() {
      if (declareSectionStatementParser == null) {
        FutureParser future = scoped("declareSectionStatement", PUBLIC, true);
        declareSectionStatementParser = future;
        future.setParser(
          sequence(
            choice(
              keyword("BEGIN"),
              keyword("END")
            ),
            keyword("DECLARE"),
            keyword("SECTION")
          )
        );
      }
    
      return declareSectionStatementParser;
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
            conjunction$conjunct(),
            star(
              sequence(
                conjunction$and(),
                conjunction$conjunct()
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
    // conjunct
    // ........................................................
    
    private ParserCombinator conjunction$conjunctParser = null;
    
    public final Start conjunction$conjunct = Start.on(getNamespace(), "conjunct");
    
    public ParserCombinator conjunction$conjunct() {
      if (conjunction$conjunctParser == null) {
        FutureParser future = scoped("conjunct", HIDING, true);
        conjunction$conjunctParser = future;
        future.setParser(
          choice(
            sequence(
              betweenPredicate(),
              optional(
                upto(
                  as("unknown",
                    star(
                      any()
                    )
                  ),
                  // Closure:
                  choice(
                    conjunction$and(),
                    eof()
                  )
                )
              )
            ),
            upto(
              negation(),
              // Closure:
              choice(
                conjunction$and(),
                eof()
              )
            )
          )
        );
      }
    
      return conjunction$conjunctParser;
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
            existsPredicate(),
            inPredicate(),
            nullPredicate(),
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
            choice(
              sequence(
                comparand(),
                optional(
                  as("unknown",
                    star(
                      any()
                    )
                  )
                )
              ),
              as("unknown",
                star(
                  any()
                )
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
                hostParameterSpecification(),
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
    // inPredicate
    // ........................................................
    
    private ParserCombinator inPredicateParser = null;
    
    public final Start inPredicate = Start.on(getNamespace(), "inPredicate");
    
    public ParserCombinator inPredicate() {
      if (inPredicateParser == null) {
        FutureParser future = scoped("inPredicate", PUBLIC, true);
        inPredicateParser = future;
        future.setParser(
          sequence(
            comparand(),
            optional(
              keyword("NOT")
            ),
            keyword("IN"),
            choice(
              subquery(),
              inPredicate$inValueList(),
              hostParameterSpecification(),
              as("unknown",
                plus(
                  any()
                )
              )
            )
          )
        );
      }
    
      return inPredicateParser;
    }
    
    // ========================================================
    // inValueList
    // ........................................................
    
    private ParserCombinator inPredicate$inValueListParser = null;
    
    public final Start inPredicate$inValueList = Start.on(getNamespace(), "inValueList");
    
    public ParserCombinator inPredicate$inValueList() {
      if (inPredicate$inValueListParser == null) {
        FutureParser future = scoped("inValueList", PUBLIC, true);
        inPredicate$inValueListParser = future;
        future.setParser(
          sequence(
            literal("("),
            comparand(),
            star(
              sequence(
                literal(","),
                comparand()
              )
            ),
            literal(")")
          )
        );
      }
    
      return inPredicate$inValueListParser;
    }
    
    // ========================================================
    // nullPredicate
    // ........................................................
    
    private ParserCombinator nullPredicateParser = null;
    
    public final Start nullPredicate = Start.on(getNamespace(), "nullPredicate");
    
    public ParserCombinator nullPredicate() {
      if (nullPredicateParser == null) {
        FutureParser future = scoped("nullPredicate", PUBLIC, true);
        nullPredicateParser = future;
        future.setParser(
          sequence(
            comparand(),
            keyword("IS"),
            optional(
              keyword("NOT")
            ),
            keyword("NULL")
          )
        );
      }
    
      return nullPredicateParser;
    }
    
    // ========================================================
    // betweenPredicate
    // ........................................................
    
    private ParserCombinator betweenPredicateParser = null;
    
    public final Start betweenPredicate = Start.on(getNamespace(), "betweenPredicate");
    
    public ParserCombinator betweenPredicate() {
      if (betweenPredicateParser == null) {
        FutureParser future = scoped("betweenPredicate", PUBLIC, true);
        betweenPredicateParser = future;
        future.setParser(
          sequence(
            comparand(),
            optional(
              keyword("NOT")
            ),
            keyword("BETWEEN"),
            valueExpression(),
            keyword("AND"),
            valueExpression()
          )
        );
      }
    
      return betweenPredicateParser;
    }
    
    // ========================================================
    // existsPredicate
    // ........................................................
    
    private ParserCombinator existsPredicateParser = null;
    
    public final Start existsPredicate = Start.on(getNamespace(), "existsPredicate");
    
    public ParserCombinator existsPredicate() {
      if (existsPredicateParser == null) {
        FutureParser future = scoped("existsPredicate", PUBLIC, true);
        existsPredicateParser = future;
        future.setParser(
          sequence(
            keyword("EXISTS"),
            choice(
              subquery(),
              as("unknown",
                plus(
                  any()
                )
              )
            )
          )
        );
      }
    
      return existsPredicateParser;
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
                valueExpression(),
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
                subquery(),
                optional(
                  as("unknown",
                    plus(
                      any()
                    )
                  )
                )
              ),
              sequence(
                extendedValueExpression(),
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
    // valueExpression
    // ........................................................
    
    private ParserCombinator valueExpressionParser = null;
    
    public final Start valueExpression = Start.on(getNamespace(), "valueExpression");
    
    public ParserCombinator valueExpression() {
      if (valueExpressionParser == null) {
        FutureParser future = scoped("valueExpression", HIDING, true);
        valueExpressionParser = future;
        future.setParser(
          sequence(
            comparand(),
            star(
              sequence(
                arithmeticOperator(),
                choice(
                  duration(),
                  comparand()
                )
              )
            )
          )
        );
      }
    
      return valueExpressionParser;
    }
    
    // ========================================================
    // duration
    // ........................................................
    
    private ParserCombinator durationParser = null;
    
    public final Start duration = Start.on(getNamespace(), "duration");
    
    public ParserCombinator duration() {
      if (durationParser == null) {
        FutureParser future = scoped("duration", PUBLIC, true);
        durationParser = future;
        future.setParser(
          sequence(
            choice(
              numericLiteral(),
              hostParameterSpecification()
            ),
            choice(
              keyword("MICROSECOND"),
              keyword("MICROSECONDS"),
              keyword("SECOND"),
              keyword("SECONDS"),
              keyword("MINUTE"),
              keyword("MINUTES"),
              keyword("HOUR"),
              keyword("HOURS"),
              keyword("DAY"),
              keyword("DAYS"),
              keyword("MONTH"),
              keyword("MONTHS"),
              keyword("YEAR"),
              keyword("YEARS")
            )
          )
        );
      }
    
      return durationParser;
    }
    
    // ========================================================
    // arithmeticOperator
    // ........................................................
    
    private ParserCombinator arithmeticOperatorParser = null;
    
    protected final Start arithmeticOperator = Start.on(getNamespace(), "arithmeticOperator");
    
    protected ParserCombinator arithmeticOperator() {
      if (arithmeticOperatorParser == null) {
        FutureParser future = scoped("arithmeticOperator", PRIVATE, true);
        arithmeticOperatorParser = future;
        future.setParser(
          choice(
            literal("+"),
            literal("-"),
            literal("*"),
            literal("/"),
            concatOperator()
          )
        );
      }
    
      return arithmeticOperatorParser;
    }
    
    // ========================================================
    // concatOperator
    // ........................................................
    
    private ParserCombinator concatOperatorParser = null;
    
    protected final Start concatOperator = Start.on(getNamespace(), "concatOperator");
    
    protected ParserCombinator concatOperator() {
      if (concatOperatorParser == null) {
        FutureParser future = scoped("concatOperator", PRIVATE, true);
        concatOperatorParser = future;
        future.setParser(
          sequence(
            literal("|"),
            opt(NOSKIP,
              literal("|")
            )
          )
        );
      }
    
      return concatOperatorParser;
    }
    
    // ========================================================
    // comparand
    // ........................................................
    
    private ParserCombinator comparandParser = null;
    
    public final Start comparand = Start.on(getNamespace(), "comparand");
    
    public ParserCombinator comparand() {
      if (comparandParser == null) {
        FutureParser future = scoped("comparand", HIDING, true);
        comparandParser = future;
        future.setParser(
          choice(
            specialRegister(),
            sequenceReference(),
            hostParameterSpecification(),
            hexLiteral(),
            stringLiteral(),
            numericLiteral(),
            signedNumericLiteral(),
            subquery(),
            scalarFunctionCall(),
            columnReference()
          )
        );
      }
    
      return comparandParser;
    }
    
    // ========================================================
    // signedNumericLiteral
    // ........................................................
    
    private ParserCombinator signedNumericLiteralParser = null;
    
    public final Start signedNumericLiteral = Start.on(getNamespace(), "signedNumericLiteral");
    
    public ParserCombinator signedNumericLiteral() {
      if (signedNumericLiteralParser == null) {
        FutureParser future = scoped("signedNumericLiteral", PUBLIC, true);
        signedNumericLiteralParser = future;
        future.setParser(
          sequence(
            choice(
              literal("+"),
              literal("-")
            ),
            numericLiteral()
          )
        );
      }
    
      return signedNumericLiteralParser;
    }
    
    // ========================================================
    // sequenceReference
    // ........................................................
    
    private ParserCombinator sequenceReferenceParser = null;
    
    public final Start sequenceReference = Start.on(getNamespace(), "sequenceReference");
    
    public ParserCombinator sequenceReference() {
      if (sequenceReferenceParser == null) {
        FutureParser future = scoped("sequenceReference", PUBLIC, true);
        sequenceReferenceParser = future;
        future.setParser(
          sequence(
            choice(
              sequence(
                choice(
                  keyword("NEXT"),
                  keyword("PREVIOUS")
                ),
                keyword("VALUE")
              ),
              keyword("NEXTVAL"),
              keyword("PREVVAL")
            ),
            keyword("FOR"),
            tableName()
          )
        );
      }
    
      return sequenceReferenceParser;
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
            notEqualsOp(),
            greaterThanOrEqualsOp(),
            lessThanOrEqualsOp(),
            equalsOp(),
            greaterThanOp(),
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
              literal(">")
            ),
            sequence(
              literal("!"),
              literal("=")
            ),
            sequence(
              literal("^"),
              literal("=")
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
              literal("=")
            ),
            sequence(
              literal("!"),
              literal("<")
            ),
            sequence(
              literal("^"),
              literal("<")
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
              literal("=")
            ),
            sequence(
              literal("!"),
              literal(">")
            ),
            sequence(
              literal("^"),
              literal(">")
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
    // scalarFunctionCall
    // ........................................................
    
    private ParserCombinator scalarFunctionCallParser = null;
    
    public final Start scalarFunctionCall = Start.on(getNamespace(), "scalarFunctionCall");
    
    public ParserCombinator scalarFunctionCall() {
      if (scalarFunctionCallParser == null) {
        FutureParser future = scoped("scalarFunctionCall", PUBLIC, true);
        scalarFunctionCallParser = future;
        future.setParser(
          sequence(
            scalarFunctionCall$functionName(),
            literal("("),
            optional(
              sequence(
                functionArgument(),
                star(
                  sequence(
                    literal(","),
                    functionArgument()
                  )
                )
              )
            ),
            literal(")")
          )
        );
      }
    
      return scalarFunctionCallParser;
    }
    
    // ========================================================
    // functionName
    // ........................................................
    
    private ParserCombinator scalarFunctionCall$functionNameParser = null;
    
    public final Start scalarFunctionCall$functionName = Start.on(getNamespace(), "functionName");
    
    public ParserCombinator scalarFunctionCall$functionName() {
      if (scalarFunctionCall$functionNameParser == null) {
        FutureParser future = scoped("functionName", PUBLIC, true);
        scalarFunctionCall$functionNameParser = future;
        future.setParser(
          identifier()
        );
      }
    
      return scalarFunctionCall$functionNameParser;
    }
    
    // ========================================================
    // functionArgument
    // ........................................................
    
    private ParserCombinator functionArgumentParser = null;
    
    public final Start functionArgument = Start.on(getNamespace(), "functionArgument");
    
    public ParserCombinator functionArgument() {
      if (functionArgumentParser == null) {
        FutureParser future = scoped("functionArgument", PUBLIC, true);
        functionArgumentParser = future;
        future.setParser(
          sequence(
            choice(
              as("allColumns",
                literal("*")
              ),
              caseExpression(),
              parenthesizedExpression(),
              extendedValueExpression(),
              as("unknown",
                skipto(
                  choice(
                    literal(","),
                    literal(")"),
                    eof()
                  )
                )
              )
            ),
            optional(
              sequence(
                keyword("AS"),
                dataType()
              )
            ),
            optional(
              as("unknown",
                skipto(
                  choice(
                    literal(","),
                    literal(")"),
                    eof()
                  )
                )
              )
            )
          )
        );
      }
    
      return functionArgumentParser;
    }
    
    // ========================================================
    // parenthesizedExpression
    // ........................................................
    
    private ParserCombinator parenthesizedExpressionParser = null;
    
    public final Start parenthesizedExpression = Start.on(getNamespace(), "parenthesizedExpression");
    
    public ParserCombinator parenthesizedExpression() {
      if (parenthesizedExpressionParser == null) {
        FutureParser future = scoped("parenthesizedExpression", PUBLIC, true);
        parenthesizedExpressionParser = future;
        future.setParser(
          sequence(
            literal("("),
            extendedValueExpression(),
            literal(")")
          )
        );
      }
    
      return parenthesizedExpressionParser;
    }
    
    // ========================================================
    // extendedValueExpression
    // ........................................................
    
    private ParserCombinator extendedValueExpressionParser = null;
    
    public final Start extendedValueExpression = Start.on(getNamespace(), "extendedValueExpression");
    
    public ParserCombinator extendedValueExpression() {
      if (extendedValueExpressionParser == null) {
        FutureParser future = scoped("extendedValueExpression", HIDING, true);
        extendedValueExpressionParser = future;
        future.setParser(
          sequence(
            choice(
              caseExpression(),
              comparand(),
              parenthesizedExpression()
            ),
            star(
              sequence(
                arithmeticOperator(),
                choice(
                  duration(),
                  caseExpression(),
                  comparand(),
                  parenthesizedExpression()
                )
              )
            )
          )
        );
      }
    
      return extendedValueExpressionParser;
    }
    
    // ========================================================
    // caseExpression
    // ........................................................
    
    private ParserCombinator caseExpressionParser = null;
    
    public final Start caseExpression = Start.on(getNamespace(), "caseExpression");
    
    public ParserCombinator caseExpression() {
      if (caseExpressionParser == null) {
        FutureParser future = scoped("caseExpression", PUBLIC, true);
        caseExpressionParser = future;
        future.setParser(
          sequence(
            keyword("CASE"),
            optional(
              caseExpression$caseOperand()
            ),
            caseExpression$whenClause(),
            star(
              caseExpression$whenClause()
            ),
            optional(
              caseExpression$elseClause()
            ),
            keyword("END"),
            optional(
              keyword("CASE")
            )
          )
        );
      }
    
      return caseExpressionParser;
    }
    
    // ========================================================
    // caseOperand
    // ........................................................
    
    private ParserCombinator caseExpression$caseOperandParser = null;
    
    public final Start caseExpression$caseOperand = Start.on(getNamespace(), "caseOperand");
    
    public ParserCombinator caseExpression$caseOperand() {
      if (caseExpression$caseOperandParser == null) {
        FutureParser future = scoped("caseOperand", PUBLIC, true);
        caseExpression$caseOperandParser = future;
        future.setParser(
          sequence(
            not(
              keyword("WHEN")
            ),
            choice(
              extendedValueExpression(),
              as("unknown",
                skipto(
                  keyword("WHEN")
                )
              )
            )
          )
        );
      }
    
      return caseExpression$caseOperandParser;
    }
    
    // ========================================================
    // whenClause
    // ........................................................
    
    private ParserCombinator caseExpression$whenClauseParser = null;
    
    public final Start caseExpression$whenClause = Start.on(getNamespace(), "whenClause");
    
    public ParserCombinator caseExpression$whenClause() {
      if (caseExpression$whenClauseParser == null) {
        FutureParser future = scoped("whenClause", PUBLIC, true);
        caseExpression$whenClauseParser = future;
        future.setParser(
          sequence(
            keyword("WHEN"),
            caseExpression$whenClause$whenCondition(),
            keyword("THEN"),
            choice(
              sequence(
                extendedValueExpression(),
                optional(
                  as("unknown",
                    skipto(
                      choice(
                        keyword("WHEN"),
                        keyword("ELSE"),
                        keyword("END")
                      )
                    )
                  )
                )
              ),
              as("unknown",
                skipto(
                  choice(
                    keyword("WHEN"),
                    keyword("ELSE"),
                    keyword("END")
                  )
                )
              )
            )
          )
        );
      }
    
      return caseExpression$whenClauseParser;
    }
    
    // ========================================================
    // whenCondition
    // ........................................................
    
    private ParserCombinator caseExpression$whenClause$whenConditionParser = null;
    
    public final Start caseExpression$whenClause$whenCondition = Start.on(getNamespace(), "whenCondition");
    
    public ParserCombinator caseExpression$whenClause$whenCondition() {
      if (caseExpression$whenClause$whenConditionParser == null) {
        FutureParser future = scoped("whenCondition", HIDING, true);
        caseExpression$whenClause$whenConditionParser = future;
        future.setParser(
          choice(
            upto(
              valueExpression(),
              // Closure:
              keyword("THEN")
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
              keyword("THEN")
            )
          )
        );
      }
    
      return caseExpression$whenClause$whenConditionParser;
    }
    
    // ========================================================
    // elseClause
    // ........................................................
    
    private ParserCombinator caseExpression$elseClauseParser = null;
    
    public final Start caseExpression$elseClause = Start.on(getNamespace(), "elseClause");
    
    public ParserCombinator caseExpression$elseClause() {
      if (caseExpression$elseClauseParser == null) {
        FutureParser future = scoped("elseClause", PUBLIC, true);
        caseExpression$elseClauseParser = future;
        future.setParser(
          sequence(
            keyword("ELSE"),
            choice(
              sequence(
                extendedValueExpression(),
                optional(
                  as("unknown",
                    skipto(
                      keyword("END")
                    )
                  )
                )
              ),
              as("unknown",
                skipto(
                  keyword("END")
                )
              )
            )
          )
        );
      }
    
      return caseExpression$elseClauseParser;
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
            optional(
              functionArgument()
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
            optional(
              sequence(
                functionArgument(),
                star(
                  sequence(
                    literal(","),
                    functionArgument()
                  )
                )
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
            hostParameterName$hostIdentifier(),
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
            choice(
              sequence(
                tagged(WORD),
                any()
              ),
              sequence(
                tagged(NUMBER),
                any()
              )
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
                  sequence(
                    choice(
                      searchCondition(),
                      as("unknown",
                        star(
                          any()
                        )
                      )
                    ),
                    optional(
                      as("unknown",
                        star(
                          any()
                        )
                      )
                    )
                  ),
                  // Closure:
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
            notNested(
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
                keyword("UNION"),
                keyword("EXCEPT"),
                keyword("INTERSECT")
              )
            ),
            keyword("WINDOW"),
            keyword("FOR"),
            keyword("WITH"),
            keyword("OPTIMIZE"),
            keyword("QUERYNO"),
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
            choice(
              tableReference$derivedTable(),
              tableName()
            ),
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
    // derivedTable
    // ........................................................
    
    private ParserCombinator tableReference$derivedTableParser = null;
    
    public final Start tableReference$derivedTable = Start.on(getNamespace(), "derivedTable");
    
    public ParserCombinator tableReference$derivedTable() {
      if (tableReference$derivedTableParser == null) {
        FutureParser future = scoped("derivedTable", PUBLIC, true);
        tableReference$derivedTableParser = future;
        future.setParser(
          subquery()
        );
      }
    
      return tableReference$derivedTableParser;
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
            cursorName$cursorIdentifier()
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
    // cursorIdentifier
    // ........................................................
    
    private ParserCombinator cursorName$cursorIdentifierParser = null;
    
    public final Start cursorName$cursorIdentifier = Start.on(getNamespace(), "cursorIdentifier");
    
    public ParserCombinator cursorName$cursorIdentifier() {
      if (cursorName$cursorIdentifierParser == null) {
        FutureParser future = scoped("cursorIdentifier", HIDING, true);
        cursorName$cursorIdentifierParser = future;
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
    
      return cursorName$cursorIdentifierParser;
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
    // subquery
    // ........................................................
    
    private ParserCombinator subqueryParser = null;
    
    public final Start subquery = Start.on(getNamespace(), "subquery");
    
    public ParserCombinator subquery() {
      if (subqueryParser == null) {
        FutureParser future = scoped("subquery", PUBLIC, true);
        subqueryParser = future;
        future.setParser(
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
                selectStatement(),
                // Closure:
                notNested(
                  literal(")")
                )
              )
            ),
            literal(")")
          )
        );
      }
    
      return subqueryParser;
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
                sequence(
                  keyword("TIMESTAMP"),
                  optional(
                    sequence(
                      literal("("),
                      numericLiteral(),
                      literal(")")
                    )
                  )
                ),
                keyword("TIME"),
                keyword("SERVER"),
                keyword("SQLID"),
                keyword("SCHEMA"),
                keyword("PATH"),
                keyword("TIMEZONE"),
                keyword("DEGREE"),
                keyword("MEMBER")
              )
            ),
            sequence(
              keyword("CURRENT"),
              opt(NOSKIP,
                literal("_"),
                choice(
                  keyword("DATE"),
                  sequence(
                    keyword("TIMESTAMP"),
                    optional(
                      sequence(
                        literal("("),
                        numericLiteral(),
                        literal(")")
                      )
                    )
                  ),
                  keyword("TIME"),
                  keyword("TIMEZONE"),
                  keyword("SERVER"),
                  keyword("SQLID"),
                  keyword("SCHEMA"),
                  keyword("PATH")
                )
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
    // hexLiteral
    // ........................................................
    
    private ParserCombinator hexLiteralParser = null;
    
    public final Start hexLiteral = Start.on(getNamespace(), "hexLiteral");
    
    public ParserCombinator hexLiteral() {
      if (hexLiteralParser == null) {
        FutureParser future = scoped("hexLiteral", PUBLIC, true);
        hexLiteralParser = future;
        future.setParser(
          sequence(
            keyword("X"),
            opt(NOSKIP,
              str()
            )
          )
        );
      }
    
      return hexLiteralParser;
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
                  literal("_"),
                  literal("$"),
                  literal("#"),
                  literal("@")
                )
              )
            )
          )
        );
      }
    
      return wordParser;
    }
    
}
