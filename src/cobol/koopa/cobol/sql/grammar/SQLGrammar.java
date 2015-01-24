package koopa.cobol.sql.grammar;

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

    public Parser sqlStatement() {
        if (sqlStatementParser == null) {
           FutureParser future = scoped("sqlStatement");
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

    public Parser includeStatement() {
        if (includeStatementParser == null) {
           FutureParser future = scoped("includeStatement");
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

    public Parser declareSessionStatement() {
        if (declareSessionStatementParser == null) {
           FutureParser future = scoped("declareSessionStatement");
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

    public Parser declareCursorStatement() {
        if (declareCursorStatementParser == null) {
           FutureParser future = scoped("declareCursorStatement");
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

    public Parser selectStatement() {
        if (selectStatementParser == null) {
           FutureParser future = scoped("selectStatement");
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

    public Parser insertStatement() {
        if (insertStatementParser == null) {
           FutureParser future = scoped("insertStatement");
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

    public Parser updateStatement() {
        if (updateStatementParser == null) {
           FutureParser future = scoped("updateStatement");
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

    public Parser deleteStatement() {
        if (deleteStatementParser == null) {
           FutureParser future = scoped("deleteStatement");
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

    public Parser openStatement() {
        if (openStatementParser == null) {
           FutureParser future = scoped("openStatement");
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

    public Parser textName() {
        if (textNameParser == null) {
           FutureParser future = scoped("textName");
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

    public Parser name() {
        if (nameParser == null) {
           FutureParser future = scoped("name");
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

    public Parser schemaName() {
        if (schemaNameParser == null) {
           FutureParser future = scoped("schemaName");
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

    public Parser tableName() {
        if (tableNameParser == null) {
           FutureParser future = scoped("tableName");
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

    public Parser delimitedIdentifier() {
        if (delimitedIdentifierParser == null) {
           FutureParser future = scoped("delimitedIdentifier");
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

    public Parser identifier() {
        if (identifierParser == null) {
           FutureParser future = scoped("identifier");
           identifierParser = future;
           future.setParser(
               any()
           );
        }

        return identifierParser;
    }

}