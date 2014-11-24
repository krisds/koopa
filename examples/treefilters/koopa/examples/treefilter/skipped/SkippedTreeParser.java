// $ANTLR 3.1.1 examples/treefilters/koopa/examples/treefilter/skipped/SkippedTreeParser.g 2014-11-24 20:28:34

  package koopa.examples.treefilter.skipped;
  
  import koopa.core.util.ANTLR;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class SkippedTreeParser extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "TOKEN", "WATER", "COMMENT", "PREPROCESSING", "PREPROCESSING_DIRECTIVE", "COPY_STATEMENT", "'COPY'", "'OF'", "'IN'", "'SUPPRESS'", "'.'", "COPY_REPLACING_PHRASE", "'REPLACING'", "COPY_REPLACEMENT_INSTRUCTION", "'BY'", "COPY_OPERAND_NAME", "'LEADING'", "'TRAILING'", "TEXT_NAME", "LIBRARY_NAME", "LITERAL", "NUMERIC", "DECIMAL", "','", "INTGR", "UINTGR", "HEXADECIMAL", "ALPHANUMERIC_LITERAL", "COBOL_WORD", "INTEGER_LITERAL", "BOOLEAN_LITERAL", "PSEUDO_LITERAL", "COMPILATION_GROUP", "COPYBOOK", "COPYBOOK_HOLDING_DATA", "COPYBOOK_HOLDING_BEHAVIOUR", "COMPILATION_UNIT", "END_MARKER", "'END'", "'FUNCTION'", "'CLASS'", "'FACTORY'", "'STATIC'", "'OBJECT'", "'OPERATOR'", "'METHOD'", "'INTERFACE'", "'DELEGATE'", "'ENUM'", "'VALUETYPE'", "'PROGRAM'", "IDENTIFICATION_DIVISION", "'ID'", "'IDENTIFICATION'", "'DIVISION'", "IDENTIFICATION_DIVISION_BODY", "'AUTHOR'", "'INSTALLATION'", "'DATE-WRITTEN'", "'DATE-COMPILED'", "'SECURITY'", "'REMARKS'", "CALL_PROTOTYPE_ID_PARAGRAPH", "'PROGRAM-ID'", "'IS'", "'EXTERNAL'", "PROGRAM_PROTOTYPE_ID_PARAGRAPH", "'AS'", "'PROTOTYPE'", "PROGRAM_ID_PARAGRAPH", "'INITIAL'", "'COMMON'", "'RECURSIVE'", "CLASS_ID_PARAGRAH", "'CLASS-ID'", "'INHERITS'", "'FROM'", "'PARTIAL'", "'FINAL'", "'ABSTRACT'", "'PUBLIC'", "'INTERNAL'", "'IMPLEMENTS'", "'USING'", "FACTORY_PARAGRAPH", "OBJECT_PARAGRAPH", "METHOD_ID_PARAGRAPH", "'METHOD-ID'", "'GET'", "'SET'", "'PROPERTY'", "'SYNC'", "'EXTENSION'", "'PRIVATE'", "'PROTECTED'", "'OVERRIDE'", "'REDEFINE'", "'FOR'", "INTERFACE_ID_PARAGRAPH", "'INTERFACE-ID'", "FUNCTION_ID_PARAGRAPH", "'FUNCTION-ID'", "DELEGATE_ID_PARAGRAPH", "'DELEGATE-ID'", "ENUM_ID_PARAGRAPH", "'ENUM-ID'", "ITERATOR_ID_PARAGRAPH", "'ITERATOR-ID'", "OPERATOR_ID_PARAGRAPH", "'OPERATOR-ID'", "'='", "'<>'", "'>='", "'>'", "'<='", "'<'", "'+'", "'-'", "'*'", "'/'", "'B-AND'", "'B-OR'", "'B-XOR'", "'B-NOT'", "'B-LEFT'", "'B-RIGHT'", "'IMPLICIT'", "'EXPLICIT'", "VALUETYPE_ID_PARAGRAPH", "'VALUETYPE-ID'", "ATTRIBUTE_CLAUSE", "'ATTRIBUTE'", "'('", "'NAME'", "')'", "'CUSTOM-ATTRIBUTE'", "ENVIRONMENT_DIVISION", "'ENVIRONMENT'", "ENVIRONMENT_DIVISION_BODY", "CONFIGURATION_SECTION", "'CONFIGURATION'", "'SECTION'", "CONFIGURATION_SECTION_BODY", "SOURCE_COMPUTER_PARAGRAPH", "'SOURCE-COMPUTER'", "WITH_DEBUGGING_MODE", "'WITH'", "'DEBUGGING'", "'MODE'", "OBJECT_COMPUTER_PARAGRAPH", "'OBJECT-COMPUTER'", "CONSTRAINTS_PARAGRAPH", "'CONSTRAINTS'", "CLASS_ATTRIBUTES_PARAGRAPH", "'CLASS-ATTRIBUTES'", "ASSEMBLY_ATTRIBUTES_PARAGRAPH", "'ASSEMBLY-ATTRIBUTES'", "GENERIC_STRING_DEF", "SPECIAL_NAMES_PARAGRAPH", "'SPECIAL-NAMES'", "SPECIAL_NAME_STATEMENT", "'ON'", "'OFF'", "'STATUS'", "CONSOLE_IS_C_R_T", "'CONSOLE'", "'CRT'", "COBOL_DEVICE", "'SYSIN'", "'SYSIPT'", "'SYSOUT'", "'SYSLIST'", "'SYSLST'", "'SYSPCH'", "'SYSPUNCH'", "'TAB'", "'PRINTER'", "'FORMFEED'", "'COMMAND-LINE'", "'ARGUMENT-NUMBER'", "'ENVIRONMENT-NAME'", "'ENVIRONMENT-VALUE'", "'SYSERR'", "'C01'", "'C02'", "'C03'", "'C04'", "'C05'", "'C06'", "'C07'", "'C08'", "'C09'", "'C10'", "'C11'", "'C12'", "'S01'", "'S02'", "'S03'", "'S04'", "'S05'", "'CSP'", "COBOL_SWITCH", "'SWITCH-0'", "'SWITCH-1'", "'SWITCH-2'", "'SWITCH-3'", "'SWITCH-4'", "'SWITCH-5'", "'SWITCH-6'", "'SWITCH-7'", "'SWITCH-8'", "ALPHABET_IS", "'ALPHABET'", "ALPHABET_TYPE", "STANDARD1_ALPHABET_TYPE", "'STANDARD-1'", "STANDARD2_ALPHABET_TYPE", "'STANDARD-2'", "NATIVE_ALPHABET_TYPE", "'NATIVE'", "ASCII_ALPHABET_TYPE", "'ASCII'", "EBCDIC_ALPHABET_TYPE", "'EBCDIC'", "EXPLICIT_ALPHABET_TYPE", "'ALSO'", "CODE_NAME_ALPHABET_TYPE", "LITERAL_RANGE", "'THROUGH'", "'THRU'", "SYMBOLIC_CHARS", "'SYMBOLIC'", "'CHARACTER'", "'CHARACTERS'", "'ARE'", "CLASS_IS", "LOCALE_IS", "'LOCALE'", "CURRENCY_SIGN_IS", "'CURRENCY'", "'SIGN'", "DECIMAL_IS_COMMA", "'DECIMAL-POINT'", "'COMMA'", "NUMERIC_SIGN_IS", "'NUMERIC'", "'SEPARATE'", "CALL_CONVENTION", "'CALL-CONVENTION'", "CURSOR_IS", "'CURSOR'", "CRT_STATUS_IS", "XML_SCHEMA_IS", "'XML-SCHEMA'", "SCREEN_CONTROL_IS", "'SCREEN'", "'CONTROL'", "EVENT_STATUS_IS", "'EVENT'", "REPOSITORY_PARAGRAPH", "'REPOSITORY'", "CLASS_SPECIFIER", "'EXPANDS'", "INTERFACE_SPECIFIER", "PROGRAM_SPECIFIER", "PROPERTY_SPECIFIER", "FUNCTION_SPECIFIER", "'ALL'", "'INTRINSIC'", "DELEGATE_SPECIFIER", "ENUM_SPECIFIER", "IO_SECTION", "'INPUT-OUTPUT'", "IO_SECTION_BODY", "FILE_CONTROL_PARAGRAPH", "'FILE-CONTROL'", "FILE_CONTROL_ENTRY", "SELECT_STATEMENT", "SELECT_CLAUSE", "'SELECT'", "'OPTIONAL'", "'NOT'", "ASSIGN_CLAUSE", "'ASSIGN'", "ASSIGN_USING_CLAUSE", "ASSIGN_TO_CLAUSE", "'TO'", "'DYNAMIC'", "DISK_CLAUSE", "'DISK'", "'LINE'", "'ADVANCING'", "'FILE'", "'MULTIPLE'", "'REEL'", "'UNIT'", "'DISPLAY'", "'KEYBOARD'", "'PRINTER-1'", "COLLATION_CLAUSE", "'COLLATING'", "'SEQUENCE'", "RECORD_DELIMITER_CLAUSE", "'RECORD'", "'DELIMITER'", "RESERVE_CLAUSE", "'RESERVE'", "'NO'", "'ALTERNATE'", "'AREA'", "'AREAS'", "ORGANIZATION_CLAUSE", "'ORGANIZATION'", "'BINARY'", "'SEQUENTIAL'", "'RELATIVE'", "'INDEXED'", "ACCESS_MODE_CLAUSE", "'ACCESS'", "'RANDOM'", "'EXCLUSIVE'", "'MANUAL'", "'AUTOMATIC'", "LOCK_MODE_CLAUSE", "'LOCK'", "LOCK_MODE_WITH_CLAUSE", "'ROLLBACK'", "'RECORDS'", "RELATIVE_KEY_CLAUSE", "'KEY'", "RECORD_KEY_CLAUSE", "ALTERNATE_RECORD_KEY_CLAUSE", "'DUPLICATES'", "RECORD_KEY_DEFINITION", "'SOURCE'", "FILE_STATUS_CLAUSE", "'SORT'", "PASSWORD_CLAUSE", "'PASSWORD'", "SUPPRESS_CLAUSE", "'WHEN'", "SHARING_CLAUSE", "'SHARING'", "'READ'", "'ONLY'", "'OTHER'", "PADDING_CLAUSE", "'PADDING'", "IO_CONTROL_PARAGRAPH", "'I-O-CONTROL'", "OBJECT_SECTION", "OBJECT_SECTION_BODY", "CLASS_CONTROL_PARAGRAPH", "'CLASS-CONTROL'", "DATA_DIVISION", "'DATA'", "DATA_DIVISION_BODY", "FILE_SECTION", "FILE_SECTION_BODY", "RECORD_DESCRIPTION_ENTRY", "WORKING_STORAGE_SECTION", "'WORKING-STORAGE'", "THREAD_LOCAL_STORAGE_SECTION", "'THREAD-LOCAL-STORAGE'", "OBJECT_STORAGE_SECTION", "'OBJECT-STORAGE'", "LOCAL_STORAGE_SECTION", "'LOCAL-STORAGE'", "LINKAGE_SECTION", "'LINKAGE'", "COMMUNICATION_SECTION", "'COMMUNICATION'", "COMMUNICATION_DESCRIPTION_ENTRY", "COMMUNICATION_DESCRIPTION_ENTRY_FORMAT1", "'CD'", "'INPUT'", "'QUEUE'", "'SUB-QUEUE-1'", "'SUB-QUEUE-2'", "'SUB-QUEUE-3'", "'MESSAGE'", "'DATE'", "'TIME'", "'TEXT'", "'LENGTH'", "'COUNT'", "COMMUNICATION_DESCRIPTION_ENTRY_FORMAT2", "'OUTPUT'", "'DESTINATION'", "'TABLE'", "'OCCURS'", "'TIMES'", "'ERROR'", "COMMUNICATION_DESCRIPTION_ENTRY_FORMAT3", "'I-O'", "'TERMINAL'", "REPORT_SECTION", "'REPORT'", "REPORT_DESCRIPTION_ENTRY", "'RD'", "'GLOBAL'", "'CODE'", "'CONTROLS'", "'PAGE'", "'LIMIT'", "'LIMITS'", "'LINES'", "'HEADING'", "'FIRST'", "'DETAIL'", "'LAST'", "'FOOTING'", "REPORT_GROUP_DESCRIPTION_ENTRY", "REPORT_GROUP_DESCRIPTION_ENTRY_FORMAT1", "'01'", "'NUMBER'", "'NEXT'", "'PLUS'", "'GROUP'", "'TYPE'", "'RH'", "'PH'", "'CH'", "'DE'", "'CF'", "'PF'", "'RF'", "'USAGE'", "'DISPLAY-1'", "REPORT_GROUP_DESCRIPTION_ENTRY_FORMAT2", "REPORT_GROUP_DESCRIPTION_ENTRY_FORMAT3", "'JUSTIFIED'", "'JUST'", "'RIGHT'", "'BLANK'", "'COLUMN'", "'VALUE'", "'SUM'", "'UPON'", "'RESET'", "'INDICATE'", "SCREEN_SECTION", "SCREEN_DESCRIPTION_ENTRY", "'FILLER'", "FILE_DESCRIPTION_ENTRY", "FD_FILE_DESCRIPTION_ENTRY", "'FD'", "SD_FILE_DESCRIPTION_ENTRY", "'SD'", "BLOCK_CONTAINS", "'BLOCK'", "'CONTAINS'", "CODE_SET", "'CODE-SET'", "DATA_RECORDS", "LABEL_RECORDS", "'LABEL'", "'OMITTED'", "'STANDARD'", "LINAGE", "'LINAGE'", "FOOTING", "'AT'", "LINES_AT_TOP", "'TOP'", "LINES_AT_BOTTOM", "'BOTTOM'", "RECORD", "'VARYING'", "'SIZE'", "'DEPENDING'", "RECORDING_MODE", "'RECORDING'", "'F'", "'V'", "'U'", "'S'", "'FIXED'", "'VARIABLE'", "VALUE_OF_FILE_ID", "'FILE-ID'", "VALUE_OF", "REPORT", "'REPORTS'", "DATA_DESCRIPTION_ENTRY", "DATA_DESCRIPTION_ENTRY_FORMAT1", "DATA_DESCRIPTION_ENTRY_FORMAT2", "'66'", "'RENAMES'", "DATA_DESCRIPTION_ENTRY_FORMAT3", "'88'", "'VALUES'", "'FALSE'", "CICS_VALUE", "'DFHVALUE'", "'DFHRESP'", "WHEN_SET_TO_FALSE_CLAUSE", "CONSTANT_DESCRIPTION_ENTRY", "'78'", "'1'", "'CONSTANT'", "REDEFINES", "'REDEFINES'", "BLANK_WHEN_ZERO", "ANY_LENGTH_CLAUSE", "'ANY'", "EXTERNAL", "GLOBAL", "TYPEDEF_CLAUSE", "'TYPEDEF'", "THREAD_LOCAL_CLAUSE", "'THREAD-LOCAL'", "ZERO", "'ZERO'", "'ZEROS'", "'ZEROES'", "SPACE", "'SPACE'", "'SPACES'", "JUSTIFIED", "'LEFT'", "'CENTERED'", "OCCURS", "'ASCENDING'", "'DESCENDING'", "PICTURE", "'PIC'", "'PICTURE'", "SIGN", "SYNC", "'SYNCHRONIZED'", "USAGE", "USAGE_CLAUSE", "'BINARY-CHAR'", "'SIGNED'", "'UNSIGNED'", "'BINARY-SHORT'", "'BINARY-LONG'", "'BINARY-DOUBLE'", "'BINARY-C-LONG'", "'FLOAT-SHORT'", "'FLOAT-LONG'", "'FLOAT-EXTENDED'", "'BIT'", "'COMPUTATIONAL'", "'COMP'", "'COMPUTATIONAL-1'", "'COMP-1'", "'COMPUTATIONAL-2'", "'COMP-2'", "'COMPUTATIONAL-3'", "'COMP-3'", "'COMPUTATIONAL-4'", "'COMP-4'", "'COMPUTATIONAL-5'", "'COMP-5'", "'COMPUTATIONAL-X'", "'COMP-X'", "'CONDITION-VALUE'", "'DECIMAL'", "'INDEX'", "'MONITOR-POINTER'", "'MUTEX-POINTER'", "'NATIONAL'", "'REFERENCE'", "'ACTIVE-CLASS'", "'PACKED-DECIMAL'", "'POINTER'", "'PROCEDURE-POINTER'", "'PROGRAM-POINTER'", "'SEMAPHORE-POINTER'", "'SIGNED-INT'", "'SIGNED-LONG'", "'SIGNED-SHORT'", "'UNSIGNED-INT'", "'UNSIGNED-LONG'", "'UNSIGNED-SHORT'", "'STRING'", "'THREAD-POINTER'", "VALUE_CLAUSE", "VALUE_CLAUSE_START", "VALUE_CLAUSE_FORMAT1", "VALUE_CLAUSE_FORMAT2", "VALUE_IS_OPERAND", "'START'", "VALUE_IS_OPERATOR", "'AND'", "'OR'", "'&'", "BASED", "'BASED'", "PROPERTY_CLAUSE", "PROCEDURE_DIVISION", "'PROCEDURE'", "USING_OR_CHAINING_PHRASE", "'CHAINING'", "'GIVING'", "DATA_REFERENCE", "'DELIMITED'", "DATA_VALUE", "DATA_OUTPUT", "REPEATED_PHRASE", "'REPEATED'", "RETURNING_PROCEDURE_PHRASE", "'RETURNING'", "'YIELDING'", "DECLARATIVES", "'DECLARATIVES'", "DECLARATIVE_SECTION", "SECTION", "PARAGRAPH", "SENTENCE", "STATEMENT", "SUB_STATEMENT_MARKER", "'ELSE'", "'INVALID'", "'OVERFLOW'", "'EXCEPTION'", "'END-OF-PAGE'", "'EOP'", "CONTINUATION_OF_STATEMENT", "NESTED_STATEMENTS", "EVENT_PHRASE", "RETRY_PHRASE", "'RETRY'", "'SECONDS'", "'FOREVER'", "END_OF_STATEMENT_MARKER", "'END-ACCEPT'", "'END-ADD'", "'END-CALL'", "'END-CHAIN'", "'END-COMPUTE'", "'END-DELETE'", "'END-DIVIDE'", "'END-EVALUATE'", "'END-EXEC'", "'END-IF'", "'END-MULTIPLY'", "'END-PERFORM'", "'END-READ'", "'END-RETURN'", "'END-REWRITE'", "'END-SEARCH'", "'END-START'", "'END-STRING'", "'END-SUBTRACT'", "'END-UNSTRING'", "'END-WAIT'", "'END-WRITE'", "VERB", "'ADD'", "'ALTER'", "'CALL'", "'CANCEL'", "'CHAIN'", "'CLOSE'", "'COMMIT'", "'CONTINUE'", "'DELETE'", "'DIVIDE'", "'EJECT'", "'ENTRY'", "'EVALUATE'", "'EXEC'", "'EXIT'", "'GENERATE'", "'GOBACK'", "'GO'", "'IDENTIFIED'", "'IF'", "'INITIATE'", "'INVOKE'", "'MERGE'", "'MOVE'", "'MULTIPLY'", "'SENTENCE'", "'OPEN'", "'PERFORM'", "'RAISE'", "'READY'", "'TRACE'", "'RELEASE'", "'REPLACE'", "'RETURN'", "'REWRITE'", "'SEARCH'", "'SERVICE'", "'SKIP1'", "'SKIP2'", "'SKIP3'", "'STOP'", "'SUBTRACT'", "'TERMINATE'", "'TITLE'", "'UNSTRING'", "'WAIT'", "'WRITE'", "'XML'", "'PARSE'", "'INITIALIZE'", "'COMPUTE'", "'INSPECT'", "'ACCEPT'", "'ALLOCATE'", "'FREE'", "'ENABLE'", "'DISABLE'", "'SEND'", "'RECEIVE'", "'PURGE'", "'USE'", "ACCEPT_STATEMENT", "ACCEPT_FROM_MNEMONIC", "ACCEPT_FROM_OTHER", "'TERMINAL-INFO'", "'SYSTEM-INFO'", "'ESCAPE'", "'USER'", "'THREAD'", "'HANDLE'", "'WINDOW'", "ACCEPT_SCREEN_FORMAT", "ACCEPT_FROM_DATE", "'YYYYMMDD'", "'CENTURY-DATE'", "'DAY'", "'YYYYDDD'", "'CENTURY-DAY'", "'DAY-OF-WEEK'", "'YEAR'", "ACCEPT_MESSAGE_COUNT", "UNIT_PHRASE", "MODE_IS_BLOCK_PHRASE", "ADD_STATEMENT", "ADDITION_FORMAT1", "'CORRESPONDING'", "'CORR'", "'ROUNDED'", "ADDITION_FORMAT2", "ADDITION_FORMAT3", "ALLOCATE_STATEMENT", "'INITIALIZED'", "ALTER_STATEMENT", "'PROCEED'", "CALL_STATEMENT", "'NESTED'", "CALL_USING", "'ADDRESS'", "'CONTENT'", "CALL_GIVING_OR_RETURNING", "'INTO'", "ON_OVERFLOW", "ON_EXCEPTION", "NOT_ON_EXCEPTION", "ON_ESCAPE", "NOT_ON_ESCAPE", "PROGRAM_I_D", "CANCEL_STATEMENT", "CHAIN_STATEMENT", "CHAIN_USING", "CLOSE_STATEMENT", "'REWIND'", "'REMOVAL'", "COMMIT_STATEMENT", "COMPUTE_STATEMENT", "'EQUAL'", "CONTINUE_STATEMENT", "DELETE_STATEMENT", "DELETE_FILE_STATEMENT", "DISABLE_STATEMENT", "DISPLAY_STATEMENT", "'END-DISPLAY'", "DISPLAY_DEVICE_FORMAT", "UPON_CLAUSE", "WITH_NO_ADVANCING", "DISPLAY_TERMINAL_FORMAT", "DT_AT_POSITIONING", "DT_LINE_COL_POSITIONING", "DT_LINE_POS", "DT_COL_POS", "'COL'", "'POSITION'", "'POS'", "SCREEN_ENTRY_PHRASE", "AUTO_PHRASE", "'AUTO'", "'AUTO-SKIP'", "BACKGROUND_PHRASE", "'BACKGROUND-COLOR'", "'BACKGROUND-COLOUR'", "BEEP_PHRASE", "'BEEP'", "'BELL'", "BLANK_PHRASE", "BLINK_PHRASE", "'BLINKING'", "'BLINK'", "BOLD_PHRASE", "'BOLD'", "CAPITALIZATION_PHRASE", "'UPPER'", "'LOWER'", "CONTROL_PHRASE", "CONVERT_PHRASE", "'CONVERT'", "'CONVERSION'", "CURSOR_PHRASE", "ECHO_PHRASE", "'ECHO'", "ERASE_PHRASE", "'ERASE'", "'EOL'", "'EOS'", "FOREGROUND_PHRASE", "'FOREGROUND-COLOR'", "'FOREGROUND-COLOUR'", "FULL_PHRASE", "'FULL'", "'LENGTH-CHECK'", "GRID_PHRASE", "'GRID'", "HIGH_PHRASE", "'HIGH'", "'HIGHLIGHT'", "LINE_PHRASE", "'LEFTLINE'", "'OVERLINE'", "'UNDERLINE'", "LOW_PHRASE", "'LOW'", "'LOWLIGHT'", "OFF_PHRASE", "PROMPT_PHRASE", "'PROMPT'", "REQUIRED_PHRASE", "'REQUIRED'", "'EMPTY-CHECK'", "REVERSE_PHRASE", "'REVERSE'", "'REVERSED'", "'REVERSE-VIDEO'", "SCROLL_PHRASE", "'SCROLL'", "'UP'", "'DOWN'", "SECURE_PHRASE", "'SECURE'", "'NO-ECHO'", "SIZE_PHRASE", "STANDARD_PHRASE", "TAB_PHRASE", "TIME_PHRASE", "'BEFORE'", "TIMEOUT_PHRASE", "'TIME-OUT'", "'TIMEOUT'", "'AFTER'", "JUSTIFICATION_PHRASE", "'LEFT-JUSTIFY'", "'RIGHT-JUSTIFY'", "FILL_PHRASE", "'SPACE-FILL'", "'ZERO-FILL'", "TRAILING_SIGN_PHRASE", "'TRAILING-SIGN'", "UPDATE_PHRASE", "'UPDATE'", "DIVIDE_STATEMENT", "DIVISION_FORMAT1", "'REMAINDER'", "DIVISION_FORMAT2", "DIVISION_FORMAT3", "ENABLE_STATEMENT", "ENTRY_STATEMENT", "EVALUATE_STATEMENT", "SUBJECT", "WHEN", "WHEN_OTHER", "OBJECT", "'TRUE'", "RANGE_EXPRESSION", "EXAMINE_STATEMENT", "'EXAMINE'", "'TALLYING'", "'UNTIL'", "EXEC_STATEMENT", "EXEC_S_Q_L_STATEMENT", "'EXECUTE'", "'SQL'", "SQL_STATEMENT", "SQL_INCLUDE", "'INCLUDE'", "SQL_SELECT", "'DECLARE'", "SQL_INSERT", "'INSERT'", "SQL_UPDATE", "SQL_DELETE", "TABLE_NAME", "EXEC_C_I_C_S_STATEMENT", "'CICS'", "CICS_STATEMENT", "DATA_AREA", "CICS_READ_Q", "'READQ'", "'TS'", "'QNAME'", "'SYSID'", "'SYS'", "'ITEM'", "'NUMITEMS'", "'TD'", "CICS_WRITE_Q", "'WRITEQ'", "'NOSUSPEND'", "'MAIN'", "'AUXILIARY'", "CICS_DELETE_Q", "'DELETEQ'", "CICS_READ_FILE", "'DATASET'", "'RIDFLD'", "'KEYLENGTH'", "'GENERIC'", "'GTEQ'", "'UNCOMMITTED'", "'CONSISTENT'", "'REPEATABLE'", "'TOKEN'", "'READNEXT'", "'RBA'", "'XRBA'", "'RRN'", "CICS_WRITE_FILE", "'MASSINSERT'", "CICS_LINK", "'LINK'", "'COMMAREA'", "'DATALENGTH'", "'SYNCONRETURN'", "'TRANSID'", "'INPUTMSG'", "'INPUTMSGLEN'", "'CHANNEL'", "CICS_XCTL", "'XCTL'", "CICS_LOAD", "'LOAD'", "CICS_START", "'TR'", "CICS_SYSID", "QUEUE_NAME", "TRANSACTION_NAME", "COMMAREA_NAME", "CICS_WATER_IN_BRACKETS", "EXEC_D_L_I_STATEMENT", "'DLI'", "EXEC_H_T_M_L_STATEMENT", "'HTML'", "EXEC_TEXT_DATA_STATEMENT", "EXIT_STATEMENT", "'PARAGRAPH'", "'CYCLE'", "'ITERATOR'", "RETURNING_PHRASE", "GENERATE_STATEMENT", "FREE_STATEMENT", "GOBACK_STATEMENT", "GO_TO_STATEMENT", "IF_STATEMENT", "'THEN'", "INITIATE_STATEMENT", "INVOKE_STATEMENT", "EXHIBIT_STATEMENT", "'EXHIBIT'", "'NAMED'", "'CHANGED'", "IDENTIFIED_BY_STATEMENT", "INITIALIZE_STATEMENT", "REPLACING_INIT_CLAUSE", "REPLACEMENT_TARGET", "'ALPHABETIC'", "'ALPHANUMERIC'", "'ALPHANUMERIC-EDITED'", "'NATIONAL-EDITED'", "'NUMERIC-EDITED'", "'DBCS'", "'EGCS'", "INSPECT_STATEMENT", "CONVERTING_PHRASE", "'CONVERTING'", "TALLYING_PHRASE", "TALLYING_CHARACTERS_PHRASE", "TALLYING_ALL_LEADING_OR_TRAILING_PHRASE", "REPLACING_PHRASE", "REPLACING_CHARACTERS_PHRASE", "REPLACING_ALL_LEADING_FIRST_OR_TRAILING_PHRASE", "LOCATION_PHRASE", "MERGE_STATEMENT", "MOVE_STATEMENT", "MULTIPLY_STATEMENT", "MULTIPLICATION_FORMAT1", "MULTIPLICATION_FORMAT2", "NEXT_SENTENCE_STATEMENT", "ON_STATEMENT", "'EVERY'", "'OTHERWISE'", "OPEN_STATEMENT", "'EXTEND'", "PERFORM_STATEMENT", "TIMES", "TEST_POSITION", "'TEST'", "UNTIL", "VARYING", "PURGE_STATEMENT", "RAISE_STATEMENT", "READ_STATEMENT", "'PREVIOUS'", "'IGNORING'", "'KEPT'", "'IGNORE'", "READ_WITH_CLAUSE", "READ_LOCK_CLAUSE", "READY_TRACE_STATEMENT", "RECEIVE_STATEMENT", "'SEGMENT'", "'END-RECEIVE'", "RELEASE_STATEMENT", "RESET_TRACE_STATEMENT", "RETURN_STATEMENT", "REWRITE_STATEMENT", "ROLLBACK_STATEMENT", "SEARCH_STATEMENT", "AT_END", "NOT_AT_END", "SEND_STATEMENT", "'THREADS'", "'ESI'", "'EMI'", "'EGI'", "SERVICE_STATEMENT", "'RELOAD'", "SORT_STATEMENT", "'ORDER'", "SET_STATEMENT", "SET_FORMAT1", "SET_FORMAT2", "SET_FORMAT3", "SET_FORMAT_DATA_POINTER_ASSIGNMENT", "'NULL'", "'NULLS'", "SET_FORMAT_PROCEDURE_POINTER_ASSIGNMENT", "SET_FORMAT_MONITOR_VALUE", "'BROWSING'", "'READING'", "'WRITING'", "SET_FORMAT_SEMAPHORE_VALUE", "START_STATEMENT", "KEY_MODIFIER", "SIZE_MODIFIER", "WHILE_KEY_MODIFIER", "'WHILE'", "'LIKE'", "LIKE_MODS", "TRIMMED_RIGHT", "'TRIMMED'", "TRIMMED_LEFT", "CASE_SENSITIVE", "'CASE-SENSITIVE'", "CASE_INSENSITIVE", "'CASE-INSENSITIVE'", "STOP_STATEMENT", "'RUN'", "STRING_STATEMENT", "SUBTRACT_STATEMENT", "SUBTRACTION_FORMAT1", "SUBTRACTION_FORMAT2", "SUBTRACTION_FORMAT3", "SUPPRESS_STATEMENT", "'PRINTING'", "TERMINATE_STATEMENT", "TRANSFORM_STATEMENT", "'TRANSFORM'", "UNLOCK_STATEMENT", "'UNLOCK'", "UNSTRING_STATEMENT", "USE_STATEMENT", "ERROR_DECLARATIVE", "DEBUG_DECLARATIVE", "'PROCEDURES'", "'REFERENCES'", "LABEL_DECLARATIVE", "'BEGINNING'", "'ENDING'", "BEFORE_REPORTING_DECLARATIVE", "'REPORTING'", "WAIT_STATEMENT", "WRITE_STATEMENT", "'POSITIONING'", "XML_GENERATE_STATEMENT", "'END-XML'", "XML_PARSE_STATEMENT", "'PROCESSING'", "COMPILER_STATEMENT", "COMPILER_DIRECTIVE", "'u0024'", "COMPILER_IF_STATEMENT", "'DEFINED'", "COMPILER_DISPLAY_STATEMENT", "'VCS'", "REPLACE_STATEMENT", "SOURCE_FORMATTING_DIRECTIVE", "EJECT_STATEMENT", "SKIP_STATEMENT", "TITLE_STATEMENT", "DIVISION_START", "SECTION_START", "PARAGRAPH_START", "END_OF_STATEMENT", "FUNCTION", "'ABS'", "'ACOS'", "'ANNUITY'", "'ASIN'", "'ATAN'", "'BOOLEAN-OF-INTEGER'", "'BYTE-LENGTH'", "'CHAR'", "'CHAR-NATIONAL'", "'COMBINED-DATETIME'", "'CONCATENATE'", "'COS'", "'CURRENT-DATE'", "'DATE-OF-INTEGER'", "'DATE-TO-YYYYMMDD'", "'DAY-OF-INTEGER'", "'DAY-TO-YYYYDDD'", "'DISPLAY-OF'", "'E'", "'EXCEPTION-FILE'", "'EXCEPTION-LOCATION'", "'EXCEPTION-STATEMENT'", "'EXCEPTION-STATUS'", "'EXP'", "'EXP10'", "'FACTORIAL'", "'FRACTION-PART'", "'INTEGER'", "'INTEGER-OF-BOOLEAN'", "'INTEGER-OF-DATE'", "'INTEGER-OF-DAY'", "'INTEGER-PART'", "'LENGTH-AN'", "'LOCALE-DATE'", "'LOCALE-TIME'", "'LOCALE-TIME-FROM-SECS'", "'LOG'", "'LOG10'", "'LOWER-CASE'", "'MAX'", "'MEAN'", "'MEDIAN'", "'MIDRANGE'", "'MIN'", "'MOD'", "'NATIONAL-OF'", "'NUMVAL'", "'NUMVAL-C'", "'ORD'", "'ORD-MAX'", "'ORD-MIN'", "'PI'", "'PRESENT-VALUE'", "'RANGE'", "'REM'", "'SECONDS-FROM-FORMATTED-TIME'", "'SECONDS-PAST-MIDNIGHT'", "'SIN'", "'SQRT'", "'STANDARD-DEVIATION'", "'STORED-CHAR-LENGTH'", "'SUBSTITUTE'", "'SUBSTITUTE-CASE'", "'TAN'", "'TEST-DATE-YYYYMMDD'", "'TEST-DAY-YYYYDDD'", "'TRIM'", "'UPPER-CASE'", "'VARIANCE'", "'WHEN-COMPILED'", "'YEAR-TO-YYYY'", "IDENTIFIER", "IDENTIFIER_FORMAT1", "IDENTIFIER_FORMAT2", "IDENTIFIER_FORMAT6", "'EXCEPTION-OBJECT'", "'SELF'", "'SUPER'", "DATA_ADDRESS_IDENTIFIER", "ARGUMENT", "QUALIFIER", "SUBSCRIPT", "DIRECT_SUBSCRIPT", "RELATIVE_SUBSCRIPT", "REFERENCE_MODIFIER", "':'", "ARITHMETIC_EXPRESSION", "BITWISE_OPERATOR", "'B-EXOR'", "BITWISE_OPERAND", "SIGN_DEF", "SUMMAND", "UNARY_OPERATOR", "FACTOR", "'**'", "ATOMIC_EXPRESSION", "CONDITION", "CONDITION_START", "FURTHER_CONDITION", "CLASS_TYPE", "'ALPHABETIC-LOWER'", "'ALPHABETIC-UPPER'", "'KANJI'", "'BOOLEAN'", "'INFINITY'", "'REPRESENTS-NOT-A-NUMBER'", "SIGN_TYPE", "'POSITIVE'", "'NEGATIVE'", "RELOP", "GREATER_THAN_OP", "'GREATER'", "'THAN'", "LESS_THAN_OP", "'LESS'", "EQUAL_TO_OP", "EXCEEDS_OP", "'EXCEEDS'", "EQUALS_OP", "'EQUALS'", "UNEQUAL_TO_OP", "'UNEQUAL'", "GREATER_OR_EQUAL_OP", "LESS_OR_EQUAL_OP", "PROGRAM_NAME", "DATA_NAME", "QUALIFIED_DATA_NAME", "DATA_DESC_NAME", "SCREEN_NAME", "SECTION_NAME", "PARAGRAPH_NAME", "PROCEDURE_NAME", "SEGMENT_NUMBER", "OPERAND", "THREAD_POINTER", "EVENT_POINTER", "CONDITION_NAME", "INDEX_NAME", "CLASS_NAME", "TYPE_SPECIFIER", "PARAMETER_NAME", "INTERFACE_NAME", "METHOD_NAME", "PROPERTY_NAME", "PROPERTY_VALUE", "DELEGATE_NAME", "ITERATOR_NAME", "ENUM_NAME", "VALUETYPE_NAME", "TYPE_NAME", "ATTRIBUTE_NAME", "TYPEDEF_NAME", "FILE_NAME", "COMPUTER_NAME", "FUNCTION_NAME", "RECORD_NAME", "MNEMONIC_NAME", "ENVIRONMENT_NAME", "'CRT-UNDER'", "'AFP-5A'", "ALPHABET_NAME", "CD_NAME", "REPORT_NAME", "ASSIGNMENT_NAME", "LITERAL_VALUE", "CONCATENATED_LITERAL", "VALUE", "FIGURATIVE_CONSTANT", "'HIGH-VALUE'", "'HIGH-VALUES'", "'LOW-VALUE'", "'LOW-VALUES'", "'QUOTE'", "'QUOTES'", "NUMERIC_LITERAL", "INTEGER", "CONSTANT", "INTEGER_CONSTANT", "ALPHANUMERIC", "ALPHANUMERIC_CONSTANT", "LEVEL_NUMBER", "PICTURE_STRING"
    };
    public static final int HIGH_PHRASE=833;
    public static final int FUNCTION=1132;
    public static final int CLASS_ID_PARAGRAH=84;
    public static final int EXEC_TEXT_DATA_STATEMENT=971;
    public static final int REPLACING_INIT_CLAUSE=991;
    public static final int QUALIFIED_DATA_NAME=1259;
    public static final int VALUE_CLAUSE_START=591;
    public static final int ENABLE_STATEMENT=884;
    public static final int CAPITALIZATION_PHRASE=811;
    public static final int TITLE_STATEMENT=1127;
    public static final int CURSOR_PHRASE=818;
    public static final int CODE_SET=463;
    public static final int CURRENCY_SIGN_IS=249;
    public static final int TIME_PHRASE=863;
    public static final int BASED=600;
    public static final int MODE_IS_BLOCK_PHRASE=744;
    public static final int SQL_STATEMENT=901;
    public static final int DATA_VALUE=610;
    public static final int CONCATENATED_LITERAL=1298;
    public static final int SELECT_STATEMENT=288;
    public static final int TOKEN=11;
    public static final int CALL_CONVENTION=258;
    public static final int DATA_NAME=1258;
    public static final int DECLARATIVES=617;
    public static final int VALUE_IS_OPERAND=594;
    public static final int RETURNING_PROCEDURE_PHRASE=614;
    public static final int LINES_AT_BOTTOM=476;
    public static final int BLINK_PHRASE=806;
    public static final int RETRY_PHRASE=634;
    public static final int FD_FILE_DESCRIPTION_ENTRY=456;
    public static final int INTERFACE_NAME=1274;
    public static final int FOOTING=472;
    public static final int PARAGRAPH_NAME=1263;
    public static final int DELEGATE_SPECIFIER=280;
    public static final int CONVERTING_PHRASE=1001;
    public static final int PURGE_STATEMENT=1027;
    public static final int PADDING_CLAUSE=357;
    public static final int DEBUG_DECLARATIVE=1101;
    public static final int ECHO_PHRASE=819;
    public static final int PARAMETER_NAME=1273;
    public static final int SEND_STATEMENT=1048;
    public static final int READ_LOCK_CLAUSE=1035;
    public static final int BITWISE_OPERAND=1222;
    public static final int CICS_XCTL=956;
    public static final int OBJECT_SECTION=361;
    public static final int EXEC_D_L_I_STATEMENT=967;
    public static final int VALUE=1299;
    public static final int ATTRIBUTE_NAME=1283;
    public static final int ASCII_ALPHABET_TYPE=231;
    public static final int DATA_RECORDS=465;
    public static final int IF_STATEMENT=981;
    public static final int CICS_DELETE_Q=929;
    public static final int COMMUNICATION_DESCRIPTION_ENTRY=383;
    public static final int LIBRARY_NAME=30;
    public static final int CLASS_CONTROL_PARAGRAPH=363;
    public static final int SQL_DELETE=909;
    public static final int RECEIVE_STATEMENT=1037;
    public static final int SCREEN_ENTRY_PHRASE=795;
    public static final int SUMMAND=1224;
    public static final int GENERIC_STRING_DEF=168;
    public static final int OBJECT_COMPUTER_PARAGRAPH=160;
    public static final int ACCEPT_FROM_MNEMONIC=724;
    public static final int CONSTANT=1309;
    public static final int RELATIVE_SUBSCRIPT=1216;
    public static final int DELEGATE_NAME=1278;
    public static final int ACCEPT_STATEMENT=723;
    public static final int PROGRAM_NAME=1257;
    public static final int SUBJECT=887;
    public static final int ITERATOR_NAME=1279;
    public static final int TRIMMED_RIGHT=1077;
    public static final int TAB_PHRASE=862;
    public static final int REPORT=493;
    public static final int SUPPRESS_CLAUSE=350;
    public static final int REPORT_SECTION=407;
    public static final int ACCEPT_MESSAGE_COUNT=742;
    public static final int NUMERIC_LITERAL=1307;
    public static final int COPYBOOK_HOLDING_DATA=45;
    public static final int SUBTRACT_STATEMENT=1087;
    public static final int CALL_USING=758;
    public static final int CONSOLE_IS_C_R_T=175;
    public static final int CASE_INSENSITIVE=1082;
    public static final int SCREEN_SECTION=452;
    public static final int ZERO=523;
    public static final int TERMINATE_STATEMENT=1093;
    public static final int TALLYING_PHRASE=1003;
    public static final int PROCEDURE_DIVISION=603;
    public static final int SQL_SELECT=904;
    public static final int VALUE_OF_FILE_ID=490;
    public static final int CANCEL_STATEMENT=769;
    public static final int QUEUE_NAME=963;
    public static final int ACCESS_MODE_CLAUSE=328;
    public static final int DATA_DESCRIPTION_ENTRY_FORMAT2=497;
    public static final int TYPEDEF_CLAUSE=519;
    public static final int DATA_DESCRIPTION_ENTRY_FORMAT3=500;
    public static final int ARGUMENT=1212;
    public static final int VALUETYPE_ID_PARAGRAPH=139;
    public static final int DATA_DESCRIPTION_ENTRY_FORMAT1=496;
    public static final int RESET_TRACE_STATEMENT=1041;
    public static final int DISK_CLAUSE=299;
    public static final int SCREEN_NAME=1261;
    public static final int EXCEEDS_OP=1249;
    public static final int ENVIRONMENT_DIVISION=147;
    public static final int RAISE_STATEMENT=1028;
    public static final int END_OF_STATEMENT_MARKER=638;
    public static final int SQL_INCLUDE=902;
    public static final int SECURE_PHRASE=857;
    public static final int VALUE_OF=492;
    public static final int CD_NAME=1294;
    public static final int COMMIT_STATEMENT=775;
    public static final int LOCALE_IS=247;
    public static final int CLASS_NAME=1271;
    public static final int CICS_SYSID=962;
    public static final int LINKAGE_SECTION=379;
    public static final int FILE_SECTION=368;
    public static final int ENVIRONMENT_NAME=1290;
    public static final int ENUM_SPECIFIER=281;
    public static final int LIKE_MODS=1076;
    public static final int CASE_SENSITIVE=1080;
    public static final int INDEX_NAME=1270;
    public static final int END_MARKER=48;
    public static final int ACCEPT_SCREEN_FORMAT=733;
    public static final int ENTRY_STATEMENT=885;
    public static final int IDENTIFIER_FORMAT6=1207;
    public static final int CLOSE_STATEMENT=772;
    public static final int LOCK_MODE_WITH_CLAUSE=336;
    public static final int COBOL_WORD=39;
    public static final int INITIALIZE_STATEMENT=990;
    public static final int ATOMIC_EXPRESSION=1228;
    public static final int LEVEL_NUMBER=1313;
    public static final int IDENTIFIER_FORMAT2=1206;
    public static final int IDENTIFIER_FORMAT1=1205;
    public static final int FILE_NAME=1285;
    public static final int DECIMAL_IS_COMMA=252;
    public static final int ASSEMBLY_ATTRIBUTES_PARAGRAPH=166;
    public static final int FILE_CONTROL_PARAGRAPH=285;
    public static final int UNARY_OPERATOR=1225;
    public static final int NESTED_STATEMENTS=632;
    public static final int COBOL_SWITCH=212;
    public static final int READ_STATEMENT=1029;
    public static final int RECORD_DESCRIPTION_ENTRY=370;
    public static final int UPON_CLAUSE=785;
    public static final int ALPHABET_TYPE=224;
    public static final int CLASS_TYPE=1232;
    public static final int REVERSE_PHRASE=849;
    public static final int BEFORE_REPORTING_DECLARATIVE=1107;
    public static final int DATA_DIVISION=365;
    public static final int ON_OVERFLOW=763;
    public static final int SIGN_TYPE=1239;
    public static final int REDEFINES=512;
    public static final int WORKING_STORAGE_SECTION=371;
    public static final int ALTERNATE_RECORD_KEY_CLAUSE=342;
    public static final int CLASS_SPECIFIER=272;
    public static final int EVENT_PHRASE=633;
    public static final int COMPUTE_STATEMENT=776;
    public static final int DIVISION_START=1128;
    public static final int CICS_READ_Q=915;
    public static final int DATA_OUTPUT=611;
    public static final int EXEC_STATEMENT=897;
    public static final int NUMERIC_SIGN_IS=255;
    public static final int ERASE_PHRASE=821;
    public static final int XML_GENERATE_STATEMENT=1112;
    public static final int CICS_START=960;
    public static final int COLLATION_CLAUSE=310;
    public static final int EXAMINE_STATEMENT=893;
    public static final int TIMEOUT_PHRASE=865;
    public static final int COMPILER_DISPLAY_STATEMENT=1121;
    public static final int RESERVE_CLAUSE=316;
    public static final int COMMENT=13;
    public static final int EJECT_STATEMENT=1125;
    public static final int REPEATED_PHRASE=612;
    public static final int THREAD_LOCAL_STORAGE_SECTION=373;
    public static final int COPYBOOK=44;
    public static final int INTERFACE_SPECIFIER=274;
    public static final int CONVERT_PHRASE=815;
    public static final int PROPERTY_SPECIFIER=276;
    public static final int SEGMENT_NUMBER=1265;
    public static final int SECTION=620;
    public static final int DELETE_FILE_STATEMENT=780;
    public static final int WHEN_OTHER=889;
    public static final int DT_LINE_POS=790;
    public static final int LITERAL_RANGE=238;
    public static final int COPY_OPERAND_NAME=26;
    public static final int DATA_DESC_NAME=1260;
    public static final int CHAIN_USING=771;
    public static final int EVENT_STATUS_IS=268;
    public static final int SPECIAL_NAME_STATEMENT=171;
    public static final int LINAGE=470;
    public static final int NUMERIC=32;
    public static final int LINES_AT_TOP=474;
    public static final int INVOKE_STATEMENT=984;
    public static final int FILE_CONTROL_ENTRY=287;
    public static final int SET_STATEMENT=1057;
    public static final int RANGE_EXPRESSION=892;
    public static final int CICS_READ_FILE=931;
    public static final int ON_EXCEPTION=764;
    public static final int IO_CONTROL_PARAGRAPH=359;
    public static final int UNEQUAL_TO_OP=1253;
    public static final int JUSTIFIED=530;
    public static final int CONDITION_START=1230;
    public static final int EVENT_POINTER=1268;
    public static final int SIZE_MODIFIER=1072;
    public static final int CONDITION_NAME=1269;
    public static final int CONTINUE_STATEMENT=778;
    public static final int SOURCE_COMPUTER_PARAGRAPH=154;
    public static final int STANDARD1_ALPHABET_TYPE=225;
    public static final int OPERATOR_ID_PARAGRAPH=119;
    public static final int CONTINUATION_OF_STATEMENT=631;
    public static final int STANDARD_PHRASE=861;
    public static final int UPDATE_PHRASE=877;
    public static final int LOCAL_STORAGE_SECTION=377;
    public static final int SCROLL_PHRASE=853;
    public static final int COMPILER_STATEMENT=1116;
    public static final int VALUE_IS_OPERATOR=596;
    public static final int RELATIVE_KEY_CLAUSE=339;
    public static final int AT_END=1046;
    public static final int EXIT_STATEMENT=972;
    public static final int WAIT_STATEMENT=1109;
    public static final int PROMPT_PHRASE=844;
    public static final int ROLLBACK_STATEMENT=1044;
    public static final int PROCEDURE_NAME=1264;
    public static final int SPACE=527;
    public static final int USAGE=542;
    public static final int CRT_STATUS_IS=262;
    public static final int REPLACING_ALL_LEADING_FIRST_OR_TRAILING_PHRASE=1008;
    public static final int VERB=661;
    public static final int TRIMMED_LEFT=1079;
    public static final int GO_TO_STATEMENT=980;
    public static final int OPERAND=1266;
    public static final int BITWISE_OPERATOR=1220;
    public static final int TYPE_NAME=1282;
    public static final int ADDITION_FORMAT2=750;
    public static final int ADDITION_FORMAT3=751;
    public static final int SQL_INSERT=906;
    public static final int INTEGER_CONSTANT=1310;
    public static final int TEXT_NAME=29;
    public static final int DATA_AREA=914;
    public static final int VALUETYPE_NAME=1281;
    public static final int ADDITION_FORMAT1=746;
    public static final int FACTORY_PARAGRAPH=95;
    public static final int SUBTRACTION_FORMAT2=1089;
    public static final int SUBTRACTION_FORMAT3=1090;
    public static final int COPYBOOK_HOLDING_BEHAVIOUR=46;
    public static final int REPORT_NAME=1295;
    public static final int SYMBOLIC_CHARS=241;
    public static final int REPLACEMENT_TARGET=992;
    public static final int PERFORM_STATEMENT=1021;
    public static final int HEXADECIMAL=37;
    public static final int DELEGATE_ID_PARAGRAPH=113;
    public static final int CURSOR_IS=260;
    public static final int FREE_STATEMENT=978;
    public static final int OBJECT_SECTION_BODY=362;
    public static final int SUBTRACTION_FORMAT1=1088;
    public static final int PASSWORD_CLAUSE=348;
    public static final int PICTURE=536;
    public static final int FILE_DESCRIPTION_ENTRY=455;
    public static final int SECTION_NAME=1262;
    public static final int GREATER_THAN_OP=1243;
    public static final int DATA_REFERENCE=608;
    public static final int GLOBAL=518;
    public static final int LESS_OR_EQUAL_OP=1256;
    public static final int GENERATE_STATEMENT=977;
    public static final int ASSIGNMENT_NAME=1296;
    public static final int PREPROCESSING_DIRECTIVE=15;
    public static final int CICS_LINK=947;
    public static final int GRID_PHRASE=831;
    public static final int SERVICE_STATEMENT=1053;
    public static final int DT_COL_POS=791;
    public static final int EVALUATE_STATEMENT=886;
    public static final int EXEC_H_T_M_L_STATEMENT=969;
    public static final int DT_LINE_COL_POSITIONING=789;
    public static final int ALTER_STATEMENT=754;
    public static final int CONDITION=1229;
    public static final int EOF=-1;
    public static final int STATEMENT=623;
    public static final int SCREEN_CONTROL_IS=265;
    public static final int UNIT_PHRASE=743;
    public static final int STOP_STATEMENT=1084;
    public static final int ENUM_NAME=1280;
    public static final int ACCEPT_FROM_DATE=734;
    public static final int GOBACK_STATEMENT=979;
    public static final int PROGRAM_SPECIFIER=275;
    public static final int SENTENCE=622;
    public static final int TALLYING_ALL_LEADING_OR_TRAILING_PHRASE=1005;
    public static final int CONSTANT_DESCRIPTION_ENTRY=508;
    public static final int COMPILATION_UNIT=47;
    public static final int SET_FORMAT_PROCEDURE_POINTER_ASSIGNMENT=1064;
    public static final int IDENTIFIED_BY_STATEMENT=989;
    public static final int SELECT_CLAUSE=289;
    public static final int NEXT_SENTENCE_STATEMENT=1015;
    public static final int REPLACING_CHARACTERS_PHRASE=1007;
    public static final int WITH_DEBUGGING_MODE=156;
    public static final int FULL_PHRASE=828;
    public static final int CONSTRAINTS_PARAGRAPH=162;
    public static final int WRITE_STATEMENT=1110;
    public static final int ITERATOR_ID_PARAGRAPH=117;
    public static final int ALPHANUMERIC_CONSTANT=1312;
    public static final int PROPERTY_CLAUSE=602;
    public static final int SET_FORMAT_SEMAPHORE_VALUE=1069;
    public static final int INITIATE_STATEMENT=983;
    public static final int LABEL_DECLARATIVE=1104;
    public static final int USING_OR_CHAINING_PHRASE=605;
    public static final int USE_STATEMENT=1099;
    public static final int UNLOCK_STATEMENT=1096;
    public static final int BEEP_PHRASE=802;
    public static final int REPOSITORY_PARAGRAPH=270;
    public static final int RETURNING_PHRASE=976;
    public static final int SET_FORMAT_MONITOR_VALUE=1065;
    public static final int SOURCE_FORMATTING_DIRECTIVE=1124;
    public static final int BLOCK_CONTAINS=460;
    public static final int FUNCTION_ID_PARAGRAPH=111;
    public static final int SD_FILE_DESCRIPTION_ENTRY=458;
    public static final int INTERFACE_ID_PARAGRAPH=109;
    public static final int EXHIBIT_STATEMENT=985;
    public static final int LOCATION_PHRASE=1009;
    public static final int PICTURE_STRING=1314;
    public static final int TRANSFORM_STATEMENT=1094;
    public static final int RELEASE_STATEMENT=1040;
    public static final int CLASS_IS=246;
    public static final int COMPILER_IF_STATEMENT=1119;
    public static final int XML_SCHEMA_IS=263;
    public static final int ALPHANUMERIC_LITERAL=38;
    public static final int EXPLICIT_ALPHABET_TYPE=235;
    public static final int MULTIPLY_STATEMENT=1012;
    public static final int COMMUNICATION_SECTION=381;
    public static final int REFERENCE_MODIFIER=1217;
    public static final int DISPLAY_TERMINAL_FORMAT=787;
    public static final int XML_PARSE_STATEMENT=1114;
    public static final int EQUAL_TO_OP=1248;
    public static final int FILE_SECTION_BODY=369;
    public static final int SIGN_DEF=1223;
    public static final int SUPPRESS_STATEMENT=1091;
    public static final int FILL_PHRASE=872;
    public static final int PREPROCESSING=14;
    public static final int SHARING_CLAUSE=352;
    public static final int PROGRAM_ID_PARAGRAPH=80;
    public static final int EXEC_C_I_C_S_STATEMENT=911;
    public static final int DATA_ADDRESS_IDENTIFIER=1211;
    public static final int OCCURS=533;
    public static final int INTGR=35;
    public static final int COMMAREA_NAME=965;
    public static final int VALUE_CLAUSE=590;
    public static final int DT_AT_POSITIONING=788;
    public static final int REPORT_GROUP_DESCRIPTION_ENTRY_FORMAT1=424;
    public static final int BACKGROUND_PHRASE=799;
    public static final int TEST_POSITION=1023;
    public static final int ORGANIZATION_CLAUSE=322;
    public static final int ON_STATEMENT=1016;
    public static final int REPLACING_PHRASE=1006;
    public static final int NOT_ON_EXCEPTION=765;
    public static final int IDENTIFICATION_DIVISION=62;
    public static final int PROPERTY_VALUE=1277;
    public static final int ENVIRONMENT_DIVISION_BODY=149;
    public static final int REPORT_GROUP_DESCRIPTION_ENTRY_FORMAT2=440;
    public static final int REPORT_GROUP_DESCRIPTION_ENTRY_FORMAT3=441;
    public static final int RECORD_NAME=1288;
    public static final int IDENTIFICATION_DIVISION_BODY=66;
    public static final int OBJECT_PARAGRAPH=96;
    public static final int REPORT_GROUP_DESCRIPTION_ENTRY=423;
    public static final int NOT_ON_ESCAPE=767;
    public static final int READ_WITH_CLAUSE=1034;
    public static final int PROGRAM_PROTOTYPE_ID_PARAGRAPH=77;
    public static final int STRING_STATEMENT=1086;
    public static final int INTEGER=1308;
    public static final int CALL_PROTOTYPE_ID_PARAGRAPH=73;
    public static final int MULTIPLICATION_FORMAT2=1014;
    public static final int MULTIPLICATION_FORMAT1=1013;
    public static final int QUALIFIER=1213;
    public static final int CICS_LOAD=958;
    public static final int COMPILER_DIRECTIVE=1117;
    public static final int CONFIGURATION_SECTION_BODY=153;
    public static final int FOREGROUND_PHRASE=825;
    public static final int COMPILATION_GROUP=43;
    public static final int OPEN_STATEMENT=1019;
    public static final int BOOLEAN_LITERAL=41;
    public static final int CHAIN_STATEMENT=770;
    public static final int LABEL_RECORDS=466;
    public static final int DECIMAL=33;
    public static final int WITH_NO_ADVANCING=786;
    public static final int WHEN=888;
    public static final int BOLD_PHRASE=809;
    public static final int REQUIRED_PHRASE=846;
    public static final int RECORD_DELIMITER_CLAUSE=313;
    public static final int FUNCTION_NAME=1287;
    public static final int FURTHER_CONDITION=1231;
    public static final int RELOP=1242;
    public static final int EBCDIC_ALPHABET_TYPE=233;
    public static final int SIGN=539;
    public static final int LOW_PHRASE=840;
    public static final int EXTERNAL=517;
    public static final int TYPE_SPECIFIER=1272;
    public static final int DISABLE_STATEMENT=781;
    public static final int RECORD_KEY_CLAUSE=341;
    public static final int PROGRAM_I_D=768;
    public static final int START_STATEMENT=1070;
    public static final int VARYING=1026;
    public static final int OFF_PHRASE=843;
    public static final int DELETE_STATEMENT=779;
    public static final int RECORD_KEY_DEFINITION=344;
    public static final int WATER=12;
    public static final int SORT_STATEMENT=1055;
    public static final int REPORT_DESCRIPTION_ENTRY=409;
    public static final int EXEC_S_Q_L_STATEMENT=898;
    public static final int SKIP_STATEMENT=1126;
    public static final int TABLE_NAME=910;
    public static final int TYPEDEF_NAME=1284;
    public static final int INSPECT_STATEMENT=1000;
    public static final int COBOL_DEVICE=178;
    public static final int PROPERTY_NAME=1276;
    public static final int REWRITE_STATEMENT=1043;
    public static final int BLANK_PHRASE=805;
    public static final int CICS_WATER_IN_BRACKETS=966;
    public static final int WHILE_KEY_MODIFIER=1073;
    public static final int DISPLAY_DEVICE_FORMAT=784;
    public static final int TRANSACTION_NAME=964;
    public static final int AUTO_PHRASE=796;
    public static final int COPY_STATEMENT=16;
    public static final int ACCEPT_FROM_OTHER=725;
    public static final int NATIVE_ALPHABET_TYPE=229;
    public static final int RECORD=478;
    public static final int SCREEN_DESCRIPTION_ENTRY=453;
    public static final int FILE_STATUS_CLAUSE=346;
    public static final int COPY_REPLACEMENT_INSTRUCTION=24;
    public static final int EQUALS_OP=1251;
    public static final int COPY_REPLACING_PHRASE=22;
    public static final int ALPHABET_IS=222;
    public static final int DIVIDE_STATEMENT=879;
    public static final int ARITHMETIC_EXPRESSION=1219;
    public static final int TRAILING_SIGN_PHRASE=875;
    public static final int METHOD_NAME=1275;
    public static final int CICS_STATEMENT=913;
    public static final int TALLYING_CHARACTERS_PHRASE=1004;
    public static final int CLASS_ATTRIBUTES_PARAGRAPH=164;
    public static final int PSEUDO_LITERAL=42;
    public static final int RECORDING_MODE=482;
    public static final int DIRECT_SUBSCRIPT=1215;
    public static final int ON_ESCAPE=766;
    public static final int PARAGRAPH_START=1130;
    public static final int SUBSCRIPT=1214;
    public static final int UNTIL=1025;
    public static final int INTEGER_LITERAL=40;
    public static final int MERGE_STATEMENT=1010;
    public static final int LOCK_MODE_CLAUSE=334;
    public static final int ASSIGN_TO_CLAUSE=296;
    public static final int VALUE_CLAUSE_FORMAT2=593;
    public static final int JUSTIFICATION_PHRASE=869;
    public static final int VALUE_CLAUSE_FORMAT1=592;
    public static final int COMMUNICATION_DESCRIPTION_ENTRY_FORMAT1=384;
    public static final int CICS_WRITE_Q=924;
    public static final int COMMUNICATION_DESCRIPTION_ENTRY_FORMAT2=397;
    public static final int COMMUNICATION_DESCRIPTION_ENTRY_FORMAT3=404;
    public static final int READY_TRACE_STATEMENT=1036;
    public static final int GREATER_OR_EQUAL_OP=1255;
    public static final int BLANK_WHEN_ZERO=514;
    public static final int FIGURATIVE_CONSTANT=1300;
    public static final int IO_SECTION_BODY=284;
    public static final int STANDARD2_ALPHABET_TYPE=227;
    public static final int KEY_MODIFIER=1071;
    public static final int SECTION_START=1129;
    public static final int LITERAL_VALUE=1297;
    public static final int CALL_STATEMENT=756;
    public static final int UNSTRING_STATEMENT=1098;
    public static final int FUNCTION_SPECIFIER=277;
    public static final int THREAD_POINTER=1267;
    public static final int RETURN_STATEMENT=1042;
    public static final int PARAGRAPH=621;
    public static final int OBJECT=890;
    public static final int FACTOR=1226;
    public static final int IDENTIFIER=1204;
    public static final int COMPUTER_NAME=1286;
    public static final int ALPHANUMERIC=1311;
    public static final int MOVE_STATEMENT=1011;
    public static final int CONFIGURATION_SECTION=150;
    public static final int SPECIAL_NAMES_PARAGRAPH=169;
    public static final int ENUM_ID_PARAGRAPH=115;
    public static final int CICS_VALUE=504;
    public static final int USAGE_CLAUSE=543;
    public static final int END_OF_STATEMENT=1131;
    public static final int LESS_THAN_OP=1246;
    public static final int IO_SECTION=282;
    public static final int NOT_AT_END=1047;
    public static final int SIZE_PHRASE=860;
    public static final int CONTROL_PHRASE=814;
    public static final int CICS_WRITE_FILE=945;
    public static final int SYNC=540;
    public static final int DIVISION_FORMAT3=883;
    public static final int DIVISION_FORMAT1=880;
    public static final int WHEN_SET_TO_FALSE_CLAUSE=507;
    public static final int DIVISION_FORMAT2=882;
    public static final int SET_FORMAT3=1060;
    public static final int SET_FORMAT2=1059;
    public static final int DECLARATIVE_SECTION=619;
    public static final int ADD_STATEMENT=745;
    public static final int SET_FORMAT1=1058;
    public static final int LITERAL=31;
    public static final int ALLOCATE_STATEMENT=752;
    public static final int DISPLAY_STATEMENT=782;
    public static final int METHOD_ID_PARAGRAPH=97;
    public static final int ASSIGN_USING_CLAUSE=295;
    public static final int REPLACE_STATEMENT=1123;
    public static final int ALPHABET_NAME=1293;
    public static final int LINE_PHRASE=836;
    public static final int SET_FORMAT_DATA_POINTER_ASSIGNMENT=1061;
    public static final int ANY_LENGTH_CLAUSE=515;
    public static final int CODE_NAME_ALPHABET_TYPE=237;
    public static final int DATA_DIVISION_BODY=367;
    public static final int ATTRIBUTE_CLAUSE=141;
    public static final int OBJECT_STORAGE_SECTION=375;
    public static final int CALL_GIVING_OR_RETURNING=761;
    public static final int MNEMONIC_NAME=1289;
    public static final int TIMES=1022;
    public static final int UINTGR=36;
    public static final int ASSIGN_CLAUSE=293;
    public static final int ERROR_DECLARATIVE=1100;
    public static final int DATA_DESCRIPTION_ENTRY=495;
    public static final int SEARCH_STATEMENT=1045;
    public static final int SQL_UPDATE=908;
    public static final int THREAD_LOCAL_CLAUSE=521;
    public static final int SUB_STATEMENT_MARKER=624;

    // delegates
    // delegators


        public SkippedTreeParser(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public SkippedTreeParser(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return SkippedTreeParser.tokenNames; }
    public String getGrammarFileName() { return "examples/treefilters/koopa/examples/treefilter/skipped/SkippedTreeParser.g"; }


      private int count = 0;



    // $ANTLR start "compilationGroup"
    // examples/treefilters/koopa/examples/treefilter/skipped/SkippedTreeParser.g:23:1: compilationGroup : ( skipped )* ;
    public final void compilationGroup() throws RecognitionException {
        try {
            // examples/treefilters/koopa/examples/treefilter/skipped/SkippedTreeParser.g:24:3: ( ( skipped )* )
            // examples/treefilters/koopa/examples/treefilter/skipped/SkippedTreeParser.g:24:5: ( skipped )*
            {
            // examples/treefilters/koopa/examples/treefilter/skipped/SkippedTreeParser.g:24:5: ( skipped )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==WATER) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // examples/treefilters/koopa/examples/treefilter/skipped/SkippedTreeParser.g:24:5: skipped
            	    {
            	    pushFollow(FOLLOW_skipped_in_compilationGroup62);
            	    skipped();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             System.out.println("Found " + this.count + " token(s) which got skipped in this program."); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "compilationGroup"


    // $ANTLR start "copybook"
    // examples/treefilters/koopa/examples/treefilter/skipped/SkippedTreeParser.g:32:1: copybook : ( skipped )* ;
    public final void copybook() throws RecognitionException {
        try {
            // examples/treefilters/koopa/examples/treefilter/skipped/SkippedTreeParser.g:33:3: ( ( skipped )* )
            // examples/treefilters/koopa/examples/treefilter/skipped/SkippedTreeParser.g:33:5: ( skipped )*
            {
            // examples/treefilters/koopa/examples/treefilter/skipped/SkippedTreeParser.g:33:5: ( skipped )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==WATER) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // examples/treefilters/koopa/examples/treefilter/skipped/SkippedTreeParser.g:33:5: skipped
            	    {
            	    pushFollow(FOLLOW_skipped_in_copybook86);
            	    skipped();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             System.out.println("Found " + this.count + " token(s) which got skipped in this copybook."); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "copybook"


    // $ANTLR start "skipped"
    // examples/treefilters/koopa/examples/treefilter/skipped/SkippedTreeParser.g:41:1: skipped : WATER ;
    public final void skipped() throws RecognitionException {
        Object WATER1=null;

        try {
            // examples/treefilters/koopa/examples/treefilter/skipped/SkippedTreeParser.g:42:3: ( WATER )
            // examples/treefilters/koopa/examples/treefilter/skipped/SkippedTreeParser.g:42:5: WATER
            {
            WATER1=(Object)match(input,WATER,FOLLOW_WATER_in_skipped110); 
             this.count += ((Tree) WATER1).getChildCount(); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "skipped"

    // Delegated rules


 

    public static final BitSet FOLLOW_skipped_in_compilationGroup62 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_skipped_in_copybook86 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_WATER_in_skipped110 = new BitSet(new long[]{0x0000000000000002L});

}