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
            textName()
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
            name(),
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
            name(),
            token("CURSOR"),
            optional(
              as("unknown",
                skipto(
                  token("FOR")
                )
              )
            ),
            token("FOR"),
            selectStatement(),
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
            token("FROM"),
            optional(
              sequence(
                schemaName(),
                literal(".")
              )
            ),
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
    
      return selectStatementParser;
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
            optional(
              sequence(
                schemaName(),
                literal(".")
              )
            ),
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
            optional(
              sequence(
                schemaName(),
                literal(".")
              )
            ),
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
    
      return updateStatementParser;
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
            optional(
              sequence(
                schemaName(),
                literal(".")
              )
            ),
            tableName(),
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
            name()
          )
        );
      }
    
      return openStatementParser;
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
            delimitedIdentifier(),
            identifier()
          )
        );
      }
    
      return textNameParser;
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
          identifier()
        );
      }
    
      return nameParser;
    }
    
    // ========================================================
    // schemaName
    // ........................................................
    
    private ParserCombinator schemaNameParser = null;
    
    public final Start schemaName = Start.on(getNamespace(), "schemaName");
    
    public ParserCombinator schemaName() {
      if (schemaNameParser == null) {
        FutureParser future = scoped("schemaName", PUBLIC, true);
        schemaNameParser = future;
        future.setParser(
          identifier()
        );
      }
    
      return schemaNameParser;
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
          identifier()
        );
      }
    
      return tableNameParser;
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
    // identifier
    // ........................................................
    
    private ParserCombinator identifierParser = null;
    
    public final Start identifier = Start.on(getNamespace(), "identifier");
    
    public ParserCombinator identifier() {
      if (identifierParser == null) {
        FutureParser future = scoped("identifier", PUBLIC, true);
        identifierParser = future;
        future.setParser(
          any()
        );
      }
    
      return identifierParser;
    }
    
}
