package koopa.cobol.sql.grammar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import koopa.core.data.Token;
import koopa.core.data.markers.Start;
import koopa.core.grammars.Block;
import koopa.core.grammars.KoopaGrammar;
import koopa.core.parsers.Parser;
import koopa.core.parsers.FutureParser;
import koopa.core.parsers.ParseStream;

import static koopa.core.grammars.Opt.NOSKIP;

import static koopa.cobol.data.tags.SyntacticTag.STRING_LITERAL;
import koopa.cobol.sql.grammar.SQLBaseGrammar;
import static koopa.cobol.data.tags.SyntacticTag.CHARACTER_STRING;

public class SQLGrammar extends SQLBaseGrammar {
    public SQLGrammar() {
    }
    
    // ========================================================
    // Compiled grammar rules. These were generated from the
    // grammar.
    // --------------------------------------------------------

    // ========================================================
    // sqlStatement
    // ........................................................

    private Parser sqlStatementParser = null;

    public final Start sqlStatement = Start.on(getNamespace(), "sqlStatement");

    public Parser sqlStatement() {
        if (sqlStatementParser == null) {
           FutureParser future = scoped("sqlStatement", true);
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
                   openStatement()
               )
           );
        }

        return sqlStatementParser;
    }

    // ========================================================
    // includeStatement
    // ........................................................

    private Parser includeStatementParser = null;

    public final Start includeStatement = Start.on(getNamespace(), "includeStatement");

    public Parser includeStatement() {
        if (includeStatementParser == null) {
           FutureParser future = scoped("includeStatement", true);
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

    private Parser declareSessionStatementParser = null;

    public final Start declareSessionStatement = Start.on(getNamespace(), "declareSessionStatement");

    public Parser declareSessionStatement() {
        if (declareSessionStatementParser == null) {
           FutureParser future = scoped("declareSessionStatement", true);
           declareSessionStatementParser = future;
           future.setParser(
               sequence(
                   token("DECLARE"),
                   token("SESSION"),
                   token("."),
                   name(),
                   token("TABLE"),
                   star(
                       any()
                   )
               )
           );
        }

        return declareSessionStatementParser;
    }

    // ========================================================
    // declareCursorStatement
    // ........................................................

    private Parser declareCursorStatementParser = null;

    public final Start declareCursorStatement = Start.on(getNamespace(), "declareCursorStatement");

    public Parser declareCursorStatement() {
        if (declareCursorStatementParser == null) {
           FutureParser future = scoped("declareCursorStatement", true);
           declareCursorStatementParser = future;
           future.setParser(
               sequence(
                   token("DECLARE"),
                   name(),
                   token("CURSOR"),
                   optional(
                       skipto(
                           token("FOR")
                       )
                   ),
                   token("FOR"),
                   selectStatement(),
                   star(
                       any()
                   )
               )
           );
        }

        return declareCursorStatementParser;
    }

    // ========================================================
    // selectStatement
    // ........................................................

    private Parser selectStatementParser = null;

    public final Start selectStatement = Start.on(getNamespace(), "selectStatement");

    public Parser selectStatement() {
        if (selectStatementParser == null) {
           FutureParser future = scoped("selectStatement", true);
           selectStatementParser = future;
           future.setParser(
               sequence(
                   token("SELECT"),
                   optional(
                       skipto(
                           token("FROM")
                       )
                   ),
                   token("FROM"),
                   optional(
                       sequence(
                           schemaName(),
                           token(".")
                       )
                   ),
                   tableName()
               )
           );
        }

        return selectStatementParser;
    }

    // ========================================================
    // insertStatement
    // ........................................................

    private Parser insertStatementParser = null;

    public final Start insertStatement = Start.on(getNamespace(), "insertStatement");

    public Parser insertStatement() {
        if (insertStatementParser == null) {
           FutureParser future = scoped("insertStatement", true);
           insertStatementParser = future;
           future.setParser(
               sequence(
                   token("INSERT"),
                   token("INTO"),
                   optional(
                       sequence(
                           schemaName(),
                           token(".")
                       )
                   ),
                   tableName()
               )
           );
        }

        return insertStatementParser;
    }

    // ========================================================
    // updateStatement
    // ........................................................

    private Parser updateStatementParser = null;

    public final Start updateStatement = Start.on(getNamespace(), "updateStatement");

    public Parser updateStatement() {
        if (updateStatementParser == null) {
           FutureParser future = scoped("updateStatement", true);
           updateStatementParser = future;
           future.setParser(
               sequence(
                   token("UPDATE"),
                   optional(
                       sequence(
                           schemaName(),
                           token(".")
                       )
                   ),
                   tableName()
               )
           );
        }

        return updateStatementParser;
    }

    // ========================================================
    // deleteStatement
    // ........................................................

    private Parser deleteStatementParser = null;

    public final Start deleteStatement = Start.on(getNamespace(), "deleteStatement");

    public Parser deleteStatement() {
        if (deleteStatementParser == null) {
           FutureParser future = scoped("deleteStatement", true);
           deleteStatementParser = future;
           future.setParser(
               sequence(
                   token("DELETE"),
                   token("FROM"),
                   optional(
                       sequence(
                           schemaName(),
                           token(".")
                       )
                   ),
                   tableName()
               )
           );
        }

        return deleteStatementParser;
    }

    // ========================================================
    // openStatement
    // ........................................................

    private Parser openStatementParser = null;

    public final Start openStatement = Start.on(getNamespace(), "openStatement");

    public Parser openStatement() {
        if (openStatementParser == null) {
           FutureParser future = scoped("openStatement", true);
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
    // textName
    // ........................................................

    private Parser textNameParser = null;

    public final Start textName = Start.on(getNamespace(), "textName");

    public Parser textName() {
        if (textNameParser == null) {
           FutureParser future = scoped("textName", true);
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

    private Parser nameParser = null;

    public final Start name = Start.on(getNamespace(), "name");

    public Parser name() {
        if (nameParser == null) {
           FutureParser future = scoped("name", true);
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

    private Parser schemaNameParser = null;

    public final Start schemaName = Start.on(getNamespace(), "schemaName");

    public Parser schemaName() {
        if (schemaNameParser == null) {
           FutureParser future = scoped("schemaName", true);
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

    private Parser tableNameParser = null;

    public final Start tableName = Start.on(getNamespace(), "tableName");

    public Parser tableName() {
        if (tableNameParser == null) {
           FutureParser future = scoped("tableName", true);
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

    private Parser delimitedIdentifierParser = null;

    public final Start delimitedIdentifier = Start.on(getNamespace(), "delimitedIdentifier");

    public Parser delimitedIdentifier() {
        if (delimitedIdentifierParser == null) {
           FutureParser future = scoped("delimitedIdentifier", true);
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

    private Parser identifierParser = null;

    public final Start identifier = Start.on(getNamespace(), "identifier");

    public Parser identifier() {
        if (identifierParser == null) {
           FutureParser future = scoped("identifier", true);
           identifierParser = future;
           future.setParser(
               any()
           );
        }

        return identifierParser;
    }

}