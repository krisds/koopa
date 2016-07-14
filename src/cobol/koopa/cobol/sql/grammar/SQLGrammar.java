package koopa.cobol.sql.grammar;

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

import static koopa.cobol.data.tags.SyntacticTag.STRING_LITERAL;
import koopa.cobol.sql.grammar.SQLBaseGrammar;
import static koopa.cobol.data.tags.SyntacticTag.CHARACTER_STRING;

public class SQLGrammar extends SQLBaseGrammar {
    public SQLGrammar() {
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
            rollbackStatement()
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
            token("INCLUDE"),
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
            token("DECLARE"),
            token("SESSION"),
            literal("."),
            identifier(),
            token("TABLE"),
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
            token("DECLARE"),
            cursorName(),
            optional(
              declareCursorStatement$sensitivity()
            ),
            optional(
              declareCursorStatement$scrollability()
            ),
            token("CURSOR"),
            optional(
              declareCursorStatement$holdability()
            ),
            optional(
              declareCursorStatement$returnability()
            ),
            token("FOR"),
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
            token("SENSITIVE"),
            token("INSENSITIVE"),
            token("ASENSITIVE")
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
            token("SCROLL"),
            sequence(
              token("NO"),
              token("SCROLL")
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
              token("WITH"),
              token("HOLD")
            ),
            sequence(
              token("WITHOUT"),
              token("HOLD")
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
              token("WITH"),
              token("RETURN")
            ),
            sequence(
              token("WITHOUT"),
              token("RETURN")
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
            token("ORDER"),
            token("BY"),
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
            token("FOR"),
            choice(
              sequence(
                token("READ"),
                token("ONLY")
              ),
              sequence(
                token("UPDATE"),
                optional(
                  sequence(
                    token("OF"),
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
                token("ORDER"),
                token("BY")
              ),
              token("FOR"),
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
            token("SELECT"),
            optional(
              as("unknown",
                skipto(
                  token("FROM")
                )
              )
            ),
            selectStatement$from(),
            optional(
              sequence(
                optional(
                  as("unknown",
                    skipto(
                      token("WHERE")
                    )
                  )
                ),
                selectStatement$where()
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
            token("FROM"),
            tableReferenceList(),
            optional(
              selectStatement$unknown()
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
            token("WHERE"),
            optional(
              selectStatement$unknown()
            )
          )
        );
      }
    
      return selectStatement$whereParser;
    }
    
    // ========================================================
    // unknown
    // ........................................................
    
    private ParserCombinator selectStatement$unknownParser = null;
    
    public final Start selectStatement$unknown = Start.on(getNamespace(), "unknown");
    
    public ParserCombinator selectStatement$unknown() {
      if (selectStatement$unknownParser == null) {
        FutureParser future = scoped("unknown", PUBLIC, true);
        selectStatement$unknownParser = future;
        future.setParser(
          skipto(
            choice(
              token("FROM"),
              token("WHERE"),
              sequence(
                token("GROUP"),
                token("BY")
              ),
              token("HAVING"),
              token("WINDOW"),
              eof()
            )
          )
        );
      }
    
      return selectStatement$unknownParser;
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
            token("INSERT"),
            token("INTO"),
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
            token("UPDATE"),
            targetTable(),
            optional(
              sequence(
                optional(
                  as("unknown",
                    skipto(
                      token("WHERE")
                    )
                  )
                ),
                updateStatement$where()
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
    
      return updateStatementParser;
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
            token("WHERE"),
            choice(
              sequence(
                token("CURRENT"),
                token("OF"),
                updateStatement$unknown()
              ),
              updateStatement$unknown()
            )
          )
        );
      }
    
      return updateStatement$whereParser;
    }
    
    // ========================================================
    // unknown
    // ........................................................
    
    private ParserCombinator updateStatement$unknownParser = null;
    
    public final Start updateStatement$unknown = Start.on(getNamespace(), "unknown");
    
    public ParserCombinator updateStatement$unknown() {
      if (updateStatement$unknownParser == null) {
        FutureParser future = scoped("unknown", PUBLIC, true);
        updateStatement$unknownParser = future;
        future.setParser(
          skipto(
            eof()
          )
        );
      }
    
      return updateStatement$unknownParser;
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
            token("DELETE"),
            token("FROM"),
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
            token("OPEN"),
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
              token("USING"),
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
            token("CLOSE"),
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
          token("ROLLBACK")
        );
      }
    
      return rollbackStatementParser;
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
            regularIdentifier(),
            delimitedIdentifier()
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
          any()
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
          sequence(
            tagged(CHARACTER_STRING),
            tagged(STRING_LITERAL),
            any()
          )
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
          token("MODULE")
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
          token("MODULE")
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
              token("ONLY"),
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
    
}
