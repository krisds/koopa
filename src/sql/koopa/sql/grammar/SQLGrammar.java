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
            declareCursorStatement(),
            selectStatement(),
            insertStatement(),
            updateStatement(),
            deleteStatement(),
            openStatement(),
            closeStatement(),
            rollbackStatement(),
            lockTableStatement(),
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
            keyword("FOR"),
            declareCursorStatement$queryExpression(),
            optional(
              declareCursorStatement$orderBy()
            ),
            optional(
              declareCursorStatement$updatability()
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
    // queryExpression
    // ........................................................
    
    private ParserCombinator declareCursorStatement$queryExpressionParser = null;
    
    public final Start declareCursorStatement$queryExpression = Start.on(getNamespace(), "queryExpression");
    
    public ParserCombinator declareCursorStatement$queryExpression() {
      if (declareCursorStatement$queryExpressionParser == null) {
        FutureParser future = scoped("queryExpression", PUBLIC, true);
        declareCursorStatement$queryExpressionParser = future;
        future.setParser(
          declareCursorStatement$unknown()
        );
      }
    
      return declareCursorStatement$queryExpressionParser;
    }
    
    // ========================================================
    // orderBy
    // ........................................................
    
    private ParserCombinator declareCursorStatement$orderByParser = null;
    
    public final Start declareCursorStatement$orderBy = Start.on(getNamespace(), "orderBy");
    
    public ParserCombinator declareCursorStatement$orderBy() {
      if (declareCursorStatement$orderByParser == null) {
        FutureParser future = scoped("orderBy", PUBLIC, true);
        declareCursorStatement$orderByParser = future;
        future.setParser(
          sequence(
            keyword("ORDER"),
            keyword("BY"),
            declareCursorStatement$unknown()
          )
        );
      }
    
      return declareCursorStatement$orderByParser;
    }
    
    // ========================================================
    // updatability
    // ........................................................
    
    private ParserCombinator declareCursorStatement$updatabilityParser = null;
    
    public final Start declareCursorStatement$updatability = Start.on(getNamespace(), "updatability");
    
    public ParserCombinator declareCursorStatement$updatability() {
      if (declareCursorStatement$updatabilityParser == null) {
        FutureParser future = scoped("updatability", PUBLIC, true);
        declareCursorStatement$updatabilityParser = future;
        future.setParser(
          sequence(
            keyword("FOR"),
            choice(
              sequence(
                keyword("READ"),
                keyword("ONLY")
              ),
              sequence(
                keyword("UPDATE"),
                optional(
                  sequence(
                    keyword("OF"),
                    declareCursorStatement$unknown()
                  )
                )
              )
            )
          )
        );
      }
    
      return declareCursorStatement$updatabilityParser;
    }
    
    // ========================================================
    // unknown
    // ........................................................
    
    private ParserCombinator declareCursorStatement$unknownParser = null;
    
    public final Start declareCursorStatement$unknown = Start.on(getNamespace(), "unknown");
    
    public ParserCombinator declareCursorStatement$unknown() {
      if (declareCursorStatement$unknownParser == null) {
        FutureParser future = scoped("unknown", PUBLIC, true);
        declareCursorStatement$unknownParser = future;
        future.setParser(
          skipto(
            choice(
              sequence(
                keyword("ORDER"),
                keyword("BY")
              ),
              keyword("FOR"),
              eof()
            )
          )
        );
      }
    
      return declareCursorStatement$unknownParser;
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
                  keyword("WHERE")
                )
              )
            ),
            optional(
              selectStatement$where()
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
              aggregateFunction(),
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
            keyword("WINDOW"),
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
            as("unknown",
              skipto(
                comparisonOp()
              )
            ),
            comparisonOp(),
            as("unknown",
              plus(
                any()
              )
            )
          )
        );
      }
    
      return comparisonParser;
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
          countAll()
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
              identifier()
            )
          )
        );
      }
    
      return hostParameterNameParser;
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
                literal(","),
                tableReference()
              )
            )
          )
        );
      }
    
      return tableReferenceListParser;
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
          tableName()
        );
      }
    
      return tableReferenceParser;
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
