tree grammar CobolTreeParser;

options {
  tokenVocab = Cobol;
  language = Java;
  output = none;
}

@header {
  package koopa.grammars.cobol.antlr;
}

// ========================================================
// compilationGroup
// ........................................................

compilationGroup
  : ^(COMPILATION_GROUP
      ( compilationUnit )*
    )
  ;

// ========================================================
// copybook
// ........................................................

copybook
  : ^(COPYBOOK
      ( copybookHoldingData
      | copybookHoldingBehaviour
      )
    )
  ;

// ========================================================
// copybookHoldingData
// ........................................................

copybookHoldingData
  : ^(COPYBOOK_HOLDING_DATA
      ( ( dataDescriptionEntry
      | specialNameStatement
      | ( fileDescriptionEntry
        ( recordDescriptionEntry )*
      )
      | ( selectStatement
        ( '.' )?
      )
      | copyStatement
      | replaceStatement
      | ( execStatement
        ( '.' )?
      )
      ) )+
    )
  ;

// ========================================================
// copybookHoldingBehaviour
// ........................................................

copybookHoldingBehaviour
  : ^(COPYBOOK_HOLDING_BEHAVIOUR
      ( ( sentence )*
        ( paragraph )*
        ( section )*
      )
    )
  ;

// ========================================================
// compilationUnit
// ........................................................

compilationUnit
  : ^(COMPILATION_UNIT
      ( identificationDivision
        ( environmentDivision )?
        ( dataDivision )?
        ( ( procedureDivision
          ( compilationUnit )*
        ) )?
        ( ( 'END'
          'PROGRAM'
          programName
          '.'
        ) )?
      )
    )
  ;

// ========================================================
// identificationDivision
// ........................................................

identificationDivision
  : ^(IDENTIFICATION_DIVISION
      ( ( 'ID'
      | 'IDENTIFICATION'
      )
        'DIVISION'
        '.'
        'PROGRAM-ID'
        ( '.' )?
        programName
        ( ( ( 'IS' )?
          ( ( 'INITIAL'
            ( 'COMMON' )?
          )
          | ( 'COMMON'
            ( 'INITIAL' )?
          )
          )
          ( 'PROGRAM' )?
        ) )?
        ( '.' )?
        (water)?
      )
    )
  ;

// ========================================================
// environmentDivision
// ........................................................

environmentDivision
  : ^(ENVIRONMENT_DIVISION
      ( 'ENVIRONMENT'
        'DIVISION'
        '.'
        ( configurationSection )?
        ( ioSection )?
        (water)?
      )
    )
  ;

// ========================================================
// configurationSection
// ........................................................

configurationSection
  : ^(CONFIGURATION_SECTION
      ( 'CONFIGURATION'
        'SECTION'
        '.'
        ( ( sourceComputerParagraph
        | objectComputerParagraph
        | specialNamesParagraph
        ) )*
        (water)?
      )
    )
  ;

// ========================================================
// sourceComputerParagraph
// ........................................................

sourceComputerParagraph
  : ^(SOURCE_COMPUTER_PARAGRAPH
      ( 'SOURCE-COMPUTER'
        '.'
        ( ( computerName
          ( withDebuggingMode )?
          '.'
        ) )?
        (water)?
      )
    )
  ;

// ========================================================
// withDebuggingMode
// ........................................................

withDebuggingMode
  : ^(WITH_DEBUGGING_MODE
      ( ( 'WITH' )?
        'DEBUGGING'
        'MODE'
      )
    )
  ;

// ========================================================
// objectComputerParagraph
// ........................................................

objectComputerParagraph
  : ^(OBJECT_COMPUTER_PARAGRAPH
      ( 'OBJECT-COMPUTER'
        '.'
        ( ( computerName
          (water)?
          '.'
        ) )?
        (water)?
      )
    )
  ;

// ========================================================
// genericStringDef
// ........................................................

genericStringDef
  : ^(GENERIC_STRING_DEF
      ( ( alphanumeric )*
        ( ( 'WITH'
          'DEBUGGING'
        ) )?
        ( '.' )?
      )
    )
  ;

// ========================================================
// specialNamesParagraph
// ........................................................

specialNamesParagraph
  : ^(SPECIAL_NAMES_PARAGRAPH
      ( 'SPECIAL-NAMES'
        '.'
        ( ( copyStatement
        | specialNameStatement
        ) )*
        ( '.' )?
        (water)?
      )
    )
  ;

// ========================================================
// specialNameStatement
// ........................................................

specialNameStatement
  : ^(SPECIAL_NAME_STATEMENT
      ( decimalIsComma
      | currencySignIs
      | consoleIsCRT
      | cursorIs
      | crtStatusIs
      | numericSignIs
      | classIs
      | symbolicChars
      | alphabetIs
      | mnemonicClause
      )
    )
  ;

// ========================================================
// decimalIsComma
// ........................................................

decimalIsComma
  : ^(DECIMAL_IS_COMMA
      ( 'DECIMAL-POINT'
        ( 'IS' )?
        'COMMA'
      )
    )
  ;

// ========================================================
// currencySignIs
// ........................................................

currencySignIs
  : ^(CURRENCY_SIGN_IS
      ( 'CURRENCY'
        ( 'SIGN' )?
        ( 'IS' )?
        literal
      )
    )
  ;

// ========================================================
// consoleIsCRT
// ........................................................

consoleIsCRT
  : ^(CONSOLE_IS_C_R_T
      ( 'CONSOLE'
        ( 'IS' )?
        'CRT'
      )
    )
  ;

// ========================================================
// cursorIs
// ........................................................

cursorIs
  : ^(CURSOR_IS
      ( 'CURSOR'
        ( 'IS' )?
        dataName
      )
    )
  ;

// ========================================================
// crtStatusIs
// ........................................................

crtStatusIs
  : ^(CRT_STATUS_IS
      ( 'CRT'
        'STATUS'
        ( 'IS' )?
        dataName
      )
    )
  ;

// ========================================================
// numericSignIs
// ........................................................

numericSignIs
  : ^(NUMERIC_SIGN_IS
      ( 'NUMERIC'
        'SIGN'
        ( 'IS' )?
        ( 'LEADING'
        | 'TRAILING'
        )
        ( ( 'SEPARATE'
          ( 'CHARACTER' )?
        ) )?
      )
    )
  ;

// ========================================================
// classIs
// ........................................................

classIs
  : ^(CLASS_IS
      ( 'CLASS'
        identifier
        ( 'IS' )?
        ( ( literalRange
        | literal
        ) )+
      )
    )
  ;

// ========================================================
// literalRange
// ........................................................

literalRange
  : ^(LITERAL_RANGE
      ( literal
        ( 'THROUGH'
        | 'THRU'
        )
        literal
      )
    )
  ;

// ========================================================
// symbolicChars
// ........................................................

symbolicChars
  : ^(SYMBOLIC_CHARS
      ( 'SYMBOLIC'
        ( ( 'CHARACTER'
        | 'CHARACTERS'
        ) )?
        ( ( ( literal )+
          ( ( 'IS'
          | 'ARE'
          ) )?
          ( integer )+
        ) )+
        ( ( 'IN'
          identifier
        ) )?
      )
    )
  ;

// ========================================================
// alphabetIs
// ........................................................

alphabetIs
  : ^(ALPHABET_IS
      ( ( 'ALPHABET' )?
        identifier
        ( 'IS' )?
        alphabetType
      )
    )
  ;

// ========================================================
// alphabetType
// ........................................................

alphabetType
  : ^(ALPHABET_TYPE
      ( standard1AlphabetType
      | standard2AlphabetType
      | nativeAlphabetType
      | explicitAlphabetType
      | codeNameAlphabetType
      )
    )
  ;

// ========================================================
// standard1AlphabetType
// ........................................................

standard1AlphabetType
  : ^(STANDARD1_ALPHABET_TYPE
      'STANDARD-1'
    )
  ;

// ========================================================
// standard2AlphabetType
// ........................................................

standard2AlphabetType
  : ^(STANDARD2_ALPHABET_TYPE
      'STANDARD-2'
    )
  ;

// ========================================================
// nativeAlphabetType
// ........................................................

nativeAlphabetType
  : ^(NATIVE_ALPHABET_TYPE
      'NATIVE'
    )
  ;

// ========================================================
// explicitAlphabetType
// ........................................................

explicitAlphabetType
  : ^(EXPLICIT_ALPHABET_TYPE
      ( ( literalRange
      | literal
      )
        ( ( 'ALSO'
          ( literalRange
          | literal
          )
        ) )*
      )
    )
  ;

// ========================================================
// codeNameAlphabetType
// ........................................................

codeNameAlphabetType
  : ^(CODE_NAME_ALPHABET_TYPE
      cobolWord
    )
  ;

// ========================================================
// mnemonicClause
// ........................................................

mnemonicClause
  : ^(MNEMONIC_CLAUSE
      ( 'DECIMAL-POINT'
        ( 'IS' )?
        'COMMA'
      )
    )
  ;

// ========================================================
// confParagraphStart
// ........................................................

confParagraphStart
  : ^(CONF_PARAGRAPH_START
      ( ( 'SOURCE-COMPUTER'
      | 'OBJECT-COMPUTER'
      | 'SPECIAL-NAMES'
      )
        '.'
      )
    )
  ;

// ========================================================
// ioSection
// ........................................................

ioSection
  : ^(IO_SECTION
      ( 'INPUT-OUTPUT'
        'SECTION'
        '.'
        fileControlParagraph
        ( ioControlParagraph )?
        (water)?
      )
    )
  ;

// ========================================================
// fileControlParagraph
// ........................................................

fileControlParagraph
  : ^(FILE_CONTROL_PARAGRAPH
      ( 'FILE-CONTROL'
        '.'
        ( ( selectStatement
        | copyStatement
        ) )*
      )
    )
  ;

// ========================================================
// selectStatement
// ........................................................

selectStatement
  : ^(SELECT_STATEMENT
      ( selectClause
        assignClause
        ( ( organizationIsSequentialClause
        | fileStatusClause
        ) )*
        (water)?
        '.'
      )
    )
  ;

// ========================================================
// selectClause
// ........................................................

selectClause
  : ^(SELECT_CLAUSE
      ( 'SELECT'
        ( 'OPTIONAL' )?
        fileName
      )
    )
  ;

// ========================================================
// assignClause
// ........................................................

assignClause
  : ^(ASSIGN_CLAUSE
      ( 'ASSIGN'
        ( assignUsingClause
        | assignToClause
        )
      )
    )
  ;

// ========================================================
// assignUsingClause
// ........................................................

assignUsingClause
  : ^(ASSIGN_USING_CLAUSE
      ( 'USING'
        dataName
      )
    )
  ;

// ========================================================
// assignToClause
// ........................................................

assignToClause
  : ^(ASSIGN_TO_CLAUSE
      ( ( 'TO' )?
        assignmentName
      )
    )
  ;

// ========================================================
// organizationIsSequentialClause
// ........................................................

organizationIsSequentialClause
  : ^(ORGANIZATION_IS_SEQUENTIAL_CLAUSE
      ( ( ( 'ORGANIZATION'
        ( 'IS' )?
      ) )?
        'SEQUENTIAL'
      )
    )
  ;

// ========================================================
// fileStatusClause
// ........................................................

fileStatusClause
  : ^(FILE_STATUS_CLAUSE
      ( ( 'FILE' )?
        'STATUS'
        ( 'IS' )?
        dataName
        ( dataName )?
      )
    )
  ;

// ========================================================
// ioControlParagraph
// ........................................................

ioControlParagraph
  : ^(IO_CONTROL_PARAGRAPH
      ( 'I-O-CONTROL'
        '.'
        (water)?
      )
    )
  ;

// ========================================================
// environmentSectionStart
// ........................................................

environmentSectionStart
  : ^(ENVIRONMENT_SECTION_START
      ( ( 'CONFIGURATION'
      | 'INPUT-OUTPUT'
      )
        'SECTION'
        '.'
      )
    )
  ;

// ========================================================
// dataDivision
// ........................................................

dataDivision
  : ^(DATA_DIVISION
      ( 'DATA'
        'DIVISION'
        '.'
        ( fileSection )?
        ( workingStorageSection )?
        ( localStorageSection )?
        ( linkageSection )?
        ( communicationSection )?
        ( reportSection )?
      )
    )
  ;

// ========================================================
// fileSection
// ........................................................

fileSection
  : ^(FILE_SECTION
      ( 'FILE'
        'SECTION'
        '.'
        ( ( copyStatement
        | ( fileDescriptionEntry
          ( recordDescriptionEntry )*
        )
        ) )*
        (water)?
      )
    )
  ;

// ========================================================
// recordDescriptionEntry
// ........................................................

recordDescriptionEntry
  : ^(RECORD_DESCRIPTION_ENTRY
      ( dataDescriptionEntry
      | copyStatement
      )
    )
  ;

// ========================================================
// localStorageSection
// ........................................................

localStorageSection
  : ^(LOCAL_STORAGE_SECTION
      ( 'LOCAL-STORAGE'
        'SECTION'
        '.'
        ( ( recordDescriptionEntry
        | replaceStatement
        | ( execStatement
          ( '.' )?
        )
        ) )*
      )
    )
  ;

// ========================================================
// workingStorageSection
// ........................................................

workingStorageSection
  : ^(WORKING_STORAGE_SECTION
      ( 'WORKING-STORAGE'
        'SECTION'
        '.'
        ( ( recordDescriptionEntry
        | replaceStatement
        | ( execStatement
          ( '.' )?
        )
        ) )*
      )
    )
  ;

// ========================================================
// linkageSection
// ........................................................

linkageSection
  : ^(LINKAGE_SECTION
      ( 'LINKAGE'
        'SECTION'
        '.'
        ( ( recordDescriptionEntry
        | replaceStatement
        | ( execStatement
          ( '.' )?
        )
        ) )*
      )
    )
  ;

// ========================================================
// communicationSection
// ........................................................

communicationSection
  : ^(COMMUNICATION_SECTION
      ( 'COMMUNICATION'
        'SECTION'
        '.'
        (water)?
      )
    )
  ;

// ========================================================
// reportSection
// ........................................................

reportSection
  : ^(REPORT_SECTION
      ( 'REPORT'
        'SECTION'
        '.'
        (water)?
      )
    )
  ;

// ========================================================
// fileDescriptionEntry
// ........................................................

fileDescriptionEntry
  : ^(FILE_DESCRIPTION_ENTRY
      ( fdFileDescriptionEntry
      | sdFileDescriptionEntry
      )
    )
  ;

// ========================================================
// fdFileDescriptionEntry
// ........................................................

fdFileDescriptionEntry
  : ^(FD_FILE_DESCRIPTION_ENTRY
      ( 'FD'
        fileName
        ( ( blockContains
        | codeSet
        | dataRecords
        | external
        | global
        | labelRecords
        | linage
        | record
        | recordingMode
        | valueOf
        | report
        ) )*
        (water)?
        '.'
      )
    )
  ;

// ========================================================
// sdFileDescriptionEntry
// ........................................................

sdFileDescriptionEntry
  : ^(SD_FILE_DESCRIPTION_ENTRY
      ( 'SD'
        fileName
        ( ( blockContains
        | dataRecords
        | labelRecords
        | record
        | recordingMode
        ) )*
        (water)?
        '.'
      )
    )
  ;

// ========================================================
// blockContains
// ........................................................

blockContains
  : ^(BLOCK_CONTAINS
      ( 'BLOCK'
        ( 'CONTAINS' )?
        integer
        ( ( 'TO'
          integer
        ) )?
        ( ( 'CHARACTERS'
        | 'RECORDS'
        ) )?
      )
    )
  ;

// ========================================================
// codeSet
// ........................................................

codeSet
  : ^(CODE_SET
      ( 'CODE-SET'
        ( 'IS' )?
        alphabetName
      )
    )
  ;

// ========================================================
// dataRecords
// ........................................................

dataRecords
  : ^(DATA_RECORDS
      ( ( 'DATA' )?
        ( 'RECORD'
        | 'RECORDS'
        )
        ( ( 'IS'
        | 'ARE'
        ) )?
        ( dataName )+
      )
    )
  ;

// ========================================================
// labelRecords
// ........................................................

labelRecords
  : ^(LABEL_RECORDS
      ( 'LABEL'
        ( 'RECORD'
        | 'RECORDS'
        )
        ( ( 'IS'
        | 'ARE'
        ) )?
        ( 'OMITTED'
        | 'STANDARD'
        | ( dataName )+
        )
      )
    )
  ;

// ========================================================
// linage
// ........................................................

linage
  : ^(LINAGE
      ( 'LINAGE'
        ( 'IS' )?
        ( dataName
        | integer
        )
        ( 'LINES' )?
        ( footing )?
        ( linesAtTop )?
        ( linesAtBottom )?
      )
    )
  ;

// ========================================================
// footing
// ........................................................

footing
  : ^(FOOTING
      ( ( 'WITH' )?
        'FOOTING'
        ( 'AT' )?
        ( dataName
        | integer
        )
      )
    )
  ;

// ========================================================
// linesAtTop
// ........................................................

linesAtTop
  : ^(LINES_AT_TOP
      ( ( 'LINES' )?
        ( 'AT' )?
        'TOP'
        ( dataName
        | integer
        )
      )
    )
  ;

// ========================================================
// linesAtBottom
// ........................................................

linesAtBottom
  : ^(LINES_AT_BOTTOM
      ( ( 'LINES' )?
        ( 'AT' )?
        'BOTTOM'
        ( dataName
        | integer
        )
      )
    )
  ;

// ========================================================
// record
// ........................................................

record
  : ^(RECORD
      ( 'RECORD'
        ( ( ( 'CONTAINS' )?
          integer
          ( ( 'TO'
            integer
          ) )?
          ( 'CHARACTERS' )?
        )
        | ( ( 'IS' )?
          'VARYING'
          ( 'IN' )?
          ( 'SIZE' )?
          ( ( ( 'FROM' )?
            integer
            ( ( 'TO'
              integer
            ) )?
            ( 'CHARACTERS' )?
          ) )?
          ( ( 'DEPENDING'
            ( 'ON' )?
            fileName
          ) )?
        )
        )
      )
    )
  ;

// ========================================================
// recordingMode
// ........................................................

recordingMode
  : ^(RECORDING_MODE
      ( 'RECORDING'
        ( 'MODE' )?
        ( 'IS' )?
        ( 'F'
        | 'V'
        | 'U'
        | 'S'
        )
      )
    )
  ;

// ========================================================
// valueOf
// ........................................................

valueOf
  : ^(VALUE_OF
      ( 'VALUE'
        'OF'
        ( ( ( 'IDENTIFICATION'
        | 'ID'
        | cobolWord
        )
          ( 'IS' )?
          ( dataName
          | literal
          )
        ) )+
      )
    )
  ;

// ========================================================
// report
// ........................................................

report
  : ^(REPORT
      ( ( 'REPORT'
      | 'REPORTS'
      )
        ( ( 'IS'
        | 'ARE'
        ) )?
        ( reportName )+
      )
    )
  ;

// ========================================================
// dataDescriptionEntry
// ........................................................

dataDescriptionEntry
  : ^(DATA_DESCRIPTION_ENTRY
      ( dataDescriptionEntry_format1
      | dataDescriptionEntry_format2
      | dataDescriptionEntry_format3
      )
    )
  ;

// ========================================================
// dataDescriptionEntry_format1
// ........................................................

dataDescriptionEntry_format1
  : ^(DATA_DESCRIPTION_ENTRY_FORMAT1
      ( levelNumber
        ( dataName )?
        ( redefines )?
        ( ( blankWhenZero
        | external
        | global
        | justified
        | occurs
        | picture
        | sign
        | sync
        | usage
        | value
        ) )*
        (water)?
        '.'
      )
    )
  ;

// ========================================================
// dataDescriptionEntry_format2
// ........................................................

dataDescriptionEntry_format2
  : ^(DATA_DESCRIPTION_ENTRY_FORMAT2
      ( '66'
        dataName
        'RENAMES'
        dataName
        ( qualifier )*
        ( ( ( 'THROUGH'
        | 'THRU'
        )
          dataName
          ( qualifier )*
        ) )?
        '.'
      )
    )
  ;

// ========================================================
// dataDescriptionEntry_format3
// ........................................................

dataDescriptionEntry_format3
  : ^(DATA_DESCRIPTION_ENTRY_FORMAT3
      ( '88'
        cobolWord
        ( ( 'VALUE'
          ( 'IS' )?
        )
        | ( 'VALUES'
          ( 'ARE' )?
        )
        )
        ( ( literal
          ( ( ( 'THROUGH'
          | 'THRU'
          )
            literal
          ) )?
        ) )+
        '.'
      )
    )
  ;

// ========================================================
// redefines
// ........................................................

redefines
  : ^(REDEFINES
      ( 'REDEFINES'
        cobolWord
      )
    )
  ;

// ========================================================
// blankWhenZero
// ........................................................

blankWhenZero
  : ^(BLANK_WHEN_ZERO
      ( 'BLANK'
        ( 'WHEN' )?
        ( 'ZERO'
        | 'ZEROS'
        | 'ZEROES'
        )
      )
    )
  ;

// ========================================================
// external
// ........................................................

external
  : ^(EXTERNAL
      ( ( 'IS' )?
        'EXTERNAL'
      )
    )
  ;

// ========================================================
// global
// ........................................................

global
  : ^(GLOBAL
      ( ( 'IS' )?
        'GLOBAL'
      )
    )
  ;

// ========================================================
// justified
// ........................................................

justified
  : ^(JUSTIFIED
      ( ( 'JUSTIFIED'
      | 'JUST'
      )
        ( 'RIGHT' )?
      )
    )
  ;

// ========================================================
// occurs
// ........................................................

occurs
  : ^(OCCURS
      ( 'OCCURS'
        integer
        ( ( 'TO'
          integer
        ) )?
        ( 'TIMES' )?
        ( ( 'DEPENDING'
          ( 'ON' )?
          dataName
          ( qualifier )*
        ) )?
        ( ( ( 'ASCENDING'
        | 'DESCENDING'
        )
          ( 'KEY' )?
          ( 'IS' )?
          ( ( dataName
            ( qualifier )*
          ) )+
        ) )*
        ( ( 'INDEXED'
          ( 'BY' )?
          ( indexName )+
        ) )?
      )
    )
  ;

// ========================================================
// picture
// ........................................................

picture
  : ^(PICTURE
      ( ( 'PIC'
      | 'PICTURE'
      )
        ( 'IS' )?
        pictureString
      )
    )
  ;

// ========================================================
// sign
// ........................................................

sign
  : ^(SIGN
      ( ( ( 'SIGN'
        ( 'IS' )?
      ) )?
        ( 'LEADING'
        | 'TRAILING'
        )
        ( ( 'SEPARATE'
          ( 'CHARACTER' )?
        ) )?
      )
    )
  ;

// ========================================================
// sync
// ........................................................

sync
  : ^(SYNC
      ( ( 'SYNCHRONIZED'
      | 'SYNC'
      )
        ( ( 'LEFT'
        | 'RIGHT'
        ) )?
      )
    )
  ;

// ========================================================
// usage
// ........................................................

usage
  : ^(USAGE
      ( ( ( 'USAGE'
        ( 'IS' )?
      ) )?
        ( 'BINARY'
        | 'COMPUTATIONAL'
        | 'COMP'
        | 'DISPLAY'
        | 'INDEX'
        | 'PACKED-DECIMAL'
        | 'COMPUTATIONAL-1'
        | 'COMP-1'
        | 'COMPUTATIONAL-2'
        | 'COMP-2'
        | 'COMPUTATIONAL-3'
        | 'COMP-3'
        | 'COMPUTATIONAL-4'
        | 'COMP-4'
        | 'COMPUTATIONAL-5'
        | 'COMP-5'
        | 'POINTER'
        )
      )
    )
  ;

// ========================================================
// value
// ........................................................

value
  : ^(VALUE
      ( 'VALUE'
        ( 'IS' )?
        literal
      )
    )
  ;

// ========================================================
// procedureDivision
// ........................................................

procedureDivision
  : ^(PROCEDURE_DIVISION
      ( 'PROCEDURE'
        'DIVISION'
        ( usingPhrase )?
        ( returningPhrase )?
        '.'
        ( declaratives )?
        ( sentence )*
        ( paragraph )*
        ( section )*
      )
    )
  ;

// ========================================================
// usingPhrase
// ........................................................

usingPhrase
  : ^(USING_PHRASE
      ( 'USING'
        ( ( dataReference
        | dataValue
        ) )*
      )
    )
  ;

// ========================================================
// dataReference
// ........................................................

dataReference
  : ^(DATA_REFERENCE
      ( ( ( ( 'BY' )?
        'REFERENCE'
      ) )?
        dataName
      )
    )
  ;

// ========================================================
// dataValue
// ........................................................

dataValue
  : ^(DATA_VALUE
      ( ( 'BY' )?
        'VALUE'
        dataName
      )
    )
  ;

// ========================================================
// returningPhrase
// ........................................................

returningPhrase
  : ^(RETURNING_PHRASE
      ( 'RETURNING'
        dataName
      )
    )
  ;

// ========================================================
// declaratives
// ........................................................

declaratives
  : ^(DECLARATIVES
      ( 'DECLARATIVES'
        '.'
        ( declarativeSection )+
        'END'
        'DECLARATIVES'
        '.'
      )
    )
  ;

// ========================================================
// declarativeSection
// ........................................................

declarativeSection
  : ^(DECLARATIVE_SECTION
      ( sectionName
        'SECTION'
        '.'
        useStatement
        ( paragraph )*
      )
    )
  ;

// ========================================================
// section
// ........................................................

section
  : ^(SECTION
      ( sectionName
        'SECTION'
        ( segmentNumber )?
        '.'
        ( sentence )*
        ( paragraph )*
      )
    )
  ;

// ========================================================
// paragraph
// ........................................................

paragraph
  : ^(PARAGRAPH
      ( paragraphName
        '.'
        ( sentence )*
      )
    )
  ;

// ========================================================
// sentence
// ........................................................

sentence
  : ^(SENTENCE
      ( ( statement
        ( ( statement
        | continuationOfStatement
        ) )*
        '.'
      )
      | copyStatement
      | replaceStatement
      | useStatement
      | '.'
      )
    )
  ;

// ========================================================
// statement
// ........................................................

statement
  : ^(STATEMENT
      ( addStatement
      | callStatement
      | cancelStatement
      | closeStatement
      | computeStatement
      | deleteStatement
      | divideStatement
      | entryStatement
      | evaluateStatement
      | execStatement
      | exitStatement
      | gobackStatement
      | goToStatement
      | ifStatement
      | moveStatement
      | multiplyStatement
      | openStatement
      | performStatement
      | readStatement
      | releaseStatement
      | returnStatement
      | rewriteStatement
      | searchStatement
      | startStatement
      | stopStatement
      | stringStatement
      | subtractStatement
      | unstringStatement
      | writeStatement
      | setStatement
      | initializeStatement
      | displayStatement
      | inspectStatement
      | ( verb
        (water)?
      )
      )
    )
  ;

// ========================================================
// subStatementMarker
// ........................................................

subStatementMarker
  : ^(SUB_STATEMENT_MARKER
      ( 'ELSE'
      | 'WHEN'
      | ( 'NOT'
        'INVALID'
      )
      | 'INVALID'
      | ( 'NOT'
        ( 'ON' )?
        'SIZE'
      )
      | ( ( 'ON' )?
        'SIZE'
      )
      | ( 'NOT'
        ( 'ON' )?
        'OVERFLOW'
      )
      | ( ( 'ON' )?
        'OVERFLOW'
      )
      | ( 'NOT'
        ( 'ON' )?
        'EXCEPTION'
      )
      | ( ( 'ON' )?
        'EXCEPTION'
      )
      | ( 'NOT'
        ( 'AT' )?
        'END'
      )
      | ( ( 'AT' )?
        'END'
      )
      | ( 'NOT'
        ( 'AT' )?
        'END-OF-PAGE'
      )
      | ( 'NOT'
        ( 'AT' )?
        'EOP'
      )
      | ( ( 'AT' )?
        'END-OF-PAGE'
      )
      | ( ( 'AT' )?
        'EOP'
      )
      )
    )
  ;

// ========================================================
// continuationOfStatement
// ........................................................

continuationOfStatement
  : ^(CONTINUATION_OF_STATEMENT
      ( ( eventPhrase
        statement
      )
      | endOfStatementMarker
      )
    )
  ;

// ========================================================
// nestedStatements
// ........................................................

nestedStatements
  : ^(NESTED_STATEMENTS
      ( statement )+
    )
  ;

// ========================================================
// eventPhrase
// ........................................................

eventPhrase
  : ^(EVENT_PHRASE
      ( ( 'NOT' )?
        ( ( 'ON'
        | 'AT'
        ) )?
        ( 'EXCEPTION'
        | ( 'SIZE'
          'ERROR'
        )
        | 'OVERFLOW'
        | ( 'INVALID'
          ( 'KEY' )?
        )
        | 'END'
        | 'END-OF-PAGE'
        | 'EOP'
        )
      )
    )
  ;

// ========================================================
// endOfStatementMarker
// ........................................................

endOfStatementMarker
  : ^(END_OF_STATEMENT_MARKER
      ( 'END-ACCEPT'
      | 'END-ADD'
      | 'END-CALL'
      | 'END-COMPUTE'
      | 'END-DELETE'
      | 'END-DIVIDE'
      | 'END-EVALUATE'
      | 'END-EXEC'
      | 'END-IF'
      | 'END-MULTIPLY'
      | 'END-PERFORM'
      | 'END-READ'
      | 'END-RETURN'
      | 'END-REWRITE'
      | 'END-SEARCH'
      | 'END-START'
      | 'END-STRING'
      | 'END-SUBTRACT'
      | 'END-UNSTRING'
      | 'END-WRITE'
      )
    )
  ;

// ========================================================
// verb
// ........................................................

verb
  : ^(VERB
      ( 'ADD'
      | 'CALL'
      | 'CANCEL'
      | 'CLOSE'
      | 'DELETE'
      | 'DIVIDE'
      | 'ENTRY'
      | 'EVALUATE'
      | 'EXEC'
      | 'EXIT'
      | 'GOBACK'
      | 'GO'
      | 'IF'
      | 'MOVE'
      | 'MULTIPLY'
      | 'OPEN'
      | 'PERFORM'
      | 'READ'
      | 'RELEASE'
      | 'RETURN'
      | 'REWRITE'
      | 'SEARCH'
      | 'STOP'
      | 'STRING'
      | 'SUBTRACT'
      | 'UNSTRING'
      | 'WRITE'
      | 'SET'
      | 'INITIALIZE'
      | 'DISPLAY'
      | 'COMPUTE'
      | 'INSPECT'
      | 'START'
      | 'USE'
      | 'ACCEPT'
      | 'ALTER'
      | 'CONTINUE'
      | 'MERGE'
      | 'SORT'
      | 'ENABLE'
      | 'DISABLE'
      | 'SEND'
      | 'RECEIVE'
      | 'PURGE'
      | 'INITIATE'
      | 'GENERATE'
      | 'TERMINATE'
      )
    )
  ;

// ========================================================
// addStatement
// ........................................................

addStatement
  : ^(ADD_STATEMENT
      ( 'ADD'
        ( addition_format1
        | addition_format2
        | addition_format3
        )
        ( ( ( 'ON' )?
          'SIZE'
          'ERROR'
          nestedStatements
        ) )?
        ( ( 'NOT'
          ( 'ON' )?
          'SIZE'
          'ERROR'
          nestedStatements
        ) )?
        ( 'END-ADD' )?
      )
    )
  ;

// ========================================================
// addition_format1
// ........................................................

addition_format1
  : ^(ADDITION_FORMAT1
      ( ( 'CORRESPONDING'
      | 'CORR'
      )
        identifier
        'TO'
        identifier
        ( 'ROUNDED' )?
      )
    )
  ;

// ========================================================
// addition_format2
// ........................................................

addition_format2
  : ^(ADDITION_FORMAT2
      ( ( ( identifier
      | literal
      ) )+
        ( ( 'TO'
          ( identifier
          | literal
          )
        ) )?
        'GIVING'
        ( ( identifier
          ( 'ROUNDED' )?
        ) )+
      )
    )
  ;

// ========================================================
// addition_format3
// ........................................................

addition_format3
  : ^(ADDITION_FORMAT3
      ( ( ( identifier
      | literal
      ) )+
        'TO'
        ( ( identifier
          ( 'ROUNDED' )?
        ) )+
      )
    )
  ;

// ========================================================
// callStatement
// ........................................................

callStatement
  : ^(CALL_STATEMENT
      ( 'CALL'
        programID
        ( callUsing )?
        ( ( onOverflow
        | ( onException
          ( notOnException )?
        )
        | notOnException
        ) )?
        ( 'END-CALL' )?
      )
    )
  ;

// ========================================================
// callUsing
// ........................................................

callUsing
  : ^(CALL_USING
      ( 'USING'
        ( identifier )*
        ( ( ( ( 'BY' )?
          'REFERENCE'
          ( ( identifier
          | 'OMITTED'
          ) )+
        )
        | ( ( 'BY' )?
          'CONTENT'
          ( ( literal
          | identifier
          ) )+
        )
        | ( ( 'BY' )?
          'VALUE'
          ( ( literal
          | identifier
          ) )+
        )
        ) )*
      )
    )
  ;

// ========================================================
// onOverflow
// ........................................................

onOverflow
  : ^(ON_OVERFLOW
      ( ( 'ON' )?
        'OVERFLOW'
        nestedStatements
      )
    )
  ;

// ========================================================
// onException
// ........................................................

onException
  : ^(ON_EXCEPTION
      ( ( 'ON' )?
        'EXCEPTION'
        nestedStatements
      )
    )
  ;

// ========================================================
// notOnException
// ........................................................

notOnException
  : ^(NOT_ON_EXCEPTION
      ( 'NOT'
        ( 'ON' )?
        'EXCEPTION'
        nestedStatements
      )
    )
  ;

// ========================================================
// programID
// ........................................................

programID
  : ^(PROGRAM_I_D
      ( identifier
      | alphanumeric
      )
    )
  ;

// ========================================================
// cancelStatement
// ........................................................

cancelStatement
  : ^(CANCEL_STATEMENT
      ( 'CANCEL'
        ( ( identifier
        | alphanumeric
        ) )+
      )
    )
  ;

// ========================================================
// closeStatement
// ........................................................

closeStatement
  : ^(CLOSE_STATEMENT
      ( 'CLOSE'
        ( ( fileName
          ( ( ( ( 'WITH' )?
            ( ( 'NO'
              'REWIND'
            )
            | 'LOCK'
            )
          )
          | ( ( 'REEL'
          | 'UNIT'
          )
            ( ( ( 'FOR' )?
              'REMOVAL'
            ) )?
          )
          | ( ( 'FOR' )?
            'REMOVAL'
          )
          ) )?
        ) )+
      )
    )
  ;

// ========================================================
// computeStatement
// ........................................................

computeStatement
  : ^(COMPUTE_STATEMENT
      ( 'COMPUTE'
        ( ( identifier
          ( 'ROUNDED' )?
        ) )+
        ( '='
        | 'EQUAL'
        )
        arithmeticExpression
        ( ( ( 'ON' )?
          'SIZE'
          'ERROR'
          nestedStatements
        ) )?
        ( ( 'NOT'
          ( 'ON' )?
          'SIZE'
          'ERROR'
          nestedStatements
        ) )?
        ( 'END-COMPUTE' )?
      )
    )
  ;

// ========================================================
// deleteStatement
// ........................................................

deleteStatement
  : ^(DELETE_STATEMENT
      ( 'DELETE'
        fileName
        ( 'RECORD' )?
        ( ( 'INVALID'
          ( 'KEY' )?
          nestedStatements
        ) )?
        ( ( 'NOT'
          'INVALID'
          ( 'KEY' )?
          nestedStatements
        ) )?
        ( 'END-DELETE' )?
      )
    )
  ;

// ========================================================
// displayStatement
// ........................................................

displayStatement
  : ^(DISPLAY_STATEMENT
      ( 'DISPLAY'
        ( displayUponFormat
        | displayTerminalFormat
        | displayScreenFormat
        | (water)?
        )
      )
    )
  ;

// ========================================================
// displayUponFormat
// ........................................................

displayUponFormat
  : ^(DISPLAY_UPON_FORMAT
      ( ( ( identifier
      | literal
      ) )+
        uponClause
        ( withNoAdvancing )?
      )
    )
  ;

// ========================================================
// uponClause
// ........................................................

uponClause
  : ^(UPON_CLAUSE
      ( 'UPON'
        ( environmentName
        | mnemonicName
        )
      )
    )
  ;

// ========================================================
// withNoAdvancing
// ........................................................

withNoAdvancing
  : ^(WITH_NO_ADVANCING
      ( ( 'WITH' )?
        'NO'
        'ADVANCING'
      )
    )
  ;

// ========================================================
// displayTerminalFormat
// ........................................................

displayTerminalFormat
  : ^(DISPLAY_TERMINAL_FORMAT
      ( ( ( identifier
      | literal
      )
        ( ( 'UNIT'
          ( identifier
          | literal
          )
        ) )?
        ( displayTerminalMods )?
      ) )+
    )
  ;

// ========================================================
// displayTerminalMods
// ........................................................

displayTerminalMods
  : ^(DISPLAY_TERMINAL_MODS
      ( ( dtBellMod
      | dtBlinkMod
      | dtControlMod
      | dtConvertMod
      | dtEraseMod
      | dtLightingMod
      | dtPositioningMod
      | dtModeBlockMod
      | dtReverseMod
      | dtSizeMod
      ) )+
    )
  ;

// ========================================================
// dtBellMod
// ........................................................

dtBellMod
  : ^(DT_BELL_MOD
      ( ( 'WITH' )?
        ( 'BEEP'
        | 'BELL'
        )
      )
    )
  ;

// ========================================================
// dtBlinkMod
// ........................................................

dtBlinkMod
  : ^(DT_BLINK_MOD
      ( ( 'WITH' )?
        'BLINK'
      )
    )
  ;

// ========================================================
// dtControlMod
// ........................................................

dtControlMod
  : ^(DT_CONTROL_MOD
      ( ( 'WITH' )?
        'CONTROL'
        ( identifier
        | literal
        )
      )
    )
  ;

// ========================================================
// dtConvertMod
// ........................................................

dtConvertMod
  : ^(DT_CONVERT_MOD
      ( ( 'WITH' )?
        'CONVERT'
      )
    )
  ;

// ========================================================
// dtEraseMod
// ........................................................

dtEraseMod
  : ^(DT_ERASE_MOD
      ( ( 'WITH' )?
        'ERASE'
        ( 'EOL'
        | 'EOS'
        )
      )
    )
  ;

// ========================================================
// dtLightingMod
// ........................................................

dtLightingMod
  : ^(DT_LIGHTING_MOD
      ( ( 'WITH' )?
        ( 'HIGH'
        | 'HIGHLIGHT'
        | 'LOW'
        | 'LOWLIGHT'
        )
      )
    )
  ;

// ========================================================
// dtPositioningMod
// ........................................................

dtPositioningMod
  : ^(DT_POSITIONING_MOD
      ( ( 'WITH' )?
        ( dtAtPositioning
        | dtLineColPositioning
        )
      )
    )
  ;

// ========================================================
// dtModeBlockMod
// ........................................................

dtModeBlockMod
  : ^(DT_MODE_BLOCK_MOD
      ( ( 'WITH' )?
        'MODE'
        ( 'IS' )?
        'BLOCK'
      )
    )
  ;

// ========================================================
// dtReverseMod
// ........................................................

dtReverseMod
  : ^(DT_REVERSE_MOD
      ( ( 'WITH' )?
        ( 'REVERSED'
        | 'REVERSE-VIDEO'
        | 'REVERSE'
        )
      )
    )
  ;

// ========================================================
// dtSizeMod
// ........................................................

dtSizeMod
  : ^(DT_SIZE_MOD
      ( ( 'WITH' )?
        'SIZE'
        ( identifier
        | literal
        )
      )
    )
  ;

// ========================================================
// dtAtPositioning
// ........................................................

dtAtPositioning
  : ^(DT_AT_POSITIONING
      ( 'AT'
        ( identifier
        | literal
        )
      )
    )
  ;

// ========================================================
// dtLineColPositioning
// ........................................................

dtLineColPositioning
  : ^(DT_LINE_COL_POSITIONING
      ( ( 'AT' )?
        ( ( dtLinePos
        | dtColPos
        ) )+
      )
    )
  ;

// ========================================================
// dtLinePos
// ........................................................

dtLinePos
  : ^(DT_LINE_POS
      ( 'LINE'
        ( identifier
        | literal
        )
      )
    )
  ;

// ========================================================
// dtColPos
// ........................................................

dtColPos
  : ^(DT_COL_POS
      ( ( 'COL'
      | 'COLUMN'
      | 'POSITION'
      )
        ( identifier
        | literal
        )
      )
    )
  ;

// ========================================================
// displayScreenFormat
// ........................................................

displayScreenFormat
  : ^(DISPLAY_SCREEN_FORMAT
      ( ( ( identifier
      | literal
      )
        ( screenLineColClause
        | screenAtClause
        )
      ) )+
    )
  ;

// ========================================================
// screenAtClause
// ........................................................

screenAtClause
  : ^(SCREEN_AT_CLAUSE
      ( 'AT'
        ( identifier
        | integer
        )
      )
    )
  ;

// ========================================================
// screenLineColClause
// ........................................................

screenLineColClause
  : ^(SCREEN_LINE_COL_CLAUSE
      ( ( 'AT' )?
        ( ( ( 'LINE'
          ( 'NUMBER' )?
          ( identifier
          | integer
          )
        )
        | ( ( 'COLUMN'
        | 'COL'
        )
          ( 'NUMBER' )?
          ( identifier
          | integer
          )
        )
        ) )+
      )
    )
  ;

// ========================================================
// divideStatement
// ........................................................

divideStatement
  : ^(DIVIDE_STATEMENT
      ( 'DIVIDE'
        ( division_format1
        | division_format2
        | division_format3
        )
        ( ( ( 'ON' )?
          'SIZE'
          'ERROR'
          nestedStatements
        ) )?
        ( ( 'NOT'
          ( 'ON' )?
          'SIZE'
          'ERROR'
          nestedStatements
        ) )?
        ( 'END-DIVIDE' )?
      )
    )
  ;

// ========================================================
// division_format1
// ........................................................

division_format1
  : ^(DIVISION_FORMAT1
      ( ( identifier
      | literal
      )
        ( 'INTO'
        | 'BY'
        )
        ( identifier
        | literal
        )
        'GIVING'
        identifier
        ( 'ROUNDED' )?
        'REMAINDER'
        identifier
      )
    )
  ;

// ========================================================
// division_format2
// ........................................................

division_format2
  : ^(DIVISION_FORMAT2
      ( ( identifier
      | literal
      )
        ( 'INTO'
        | 'BY'
        )
        ( identifier
        | literal
        )
        'GIVING'
        ( ( identifier
          ( 'ROUNDED' )?
        ) )+
      )
    )
  ;

// ========================================================
// division_format3
// ........................................................

division_format3
  : ^(DIVISION_FORMAT3
      ( ( identifier
      | literal
      )
        'INTO'
        ( ( identifier
          ( 'ROUNDED' )?
        ) )+
      )
    )
  ;

// ========================================================
// entryStatement
// ........................................................

entryStatement
  : ^(ENTRY_STATEMENT
      ( 'ENTRY'
        alphanumeric
        ( ( 'USING'
          ( dataName )+
        ) )?
      )
    )
  ;

// ========================================================
// evaluateStatement
// ........................................................

evaluateStatement
  : ^(EVALUATE_STATEMENT
      ( 'EVALUATE'
        subject
        ( ( 'ALSO'
          subject
        ) )*
        ( when )+
        ( whenOther )?
        ( 'END-EVALUATE' )?
      )
    )
  ;

// ========================================================
// subject
// ........................................................

subject
  : ^(SUBJECT
      ( condition
      | identifier
      | arithmeticExpression
      | literal
      )
    )
  ;

// ========================================================
// when
// ........................................................

when
  : ^(WHEN
      ( ( ( 'WHEN'
        object
        ( ( 'ALSO'
          object
        ) )*
      ) )+
        nestedStatements
      )
    )
  ;

// ========================================================
// whenOther
// ........................................................

whenOther
  : ^(WHEN_OTHER
      ( 'WHEN'
        'OTHER'
        nestedStatements
      )
    )
  ;

// ========================================================
// object
// ........................................................

object
  : ^(OBJECT
      ( 'ANY'
      | rangeExpression
      | 'TRUE'
      | 'FALSE'
      | condition
      | ( ( 'NOT' )?
        ( identifier
        | literal
        | arithmeticExpression
        )
      )
      | ( '('
        object
        ')'
      )
      )
    )
  ;

// ========================================================
// rangeExpression
// ........................................................

rangeExpression
  : ^(RANGE_EXPRESSION
      ( ( 'NOT' )?
        ( identifier
        | literal
        | arithmeticExpression
        )
        ( 'THROUGH'
        | 'THRU'
        )
        ( identifier
        | literal
        | arithmeticExpression
        )
      )
    )
  ;

// ========================================================
// execStatement
// ........................................................

execStatement
  : ^(EXEC_STATEMENT
      ( execSQLStatement
      | execCICSStatement
      | ( 'EXEC'
        cobolWord
        (water)?
        'END-EXEC'
      )
      )
    )
  ;

// ========================================================
// execSQLStatement
// ........................................................

execSQLStatement
  : ^(EXEC_S_Q_L_STATEMENT
      ( 'EXEC'
        'SQL'
        sqlStatement
        (water)?
        'END-EXEC'
      )
    )
  ;

// ========================================================
// sqlStatement
// ........................................................

sqlStatement
  : ^(SQL_STATEMENT
      ( sqlInclude
      | sqlSelect
      | sqlInsert
      | sqlUpdate
      | sqlDelete
      )
    )
  ;

// ========================================================
// sqlInclude
// ........................................................

sqlInclude
  : ^(SQL_INCLUDE
      ( 'INCLUDE'
        textName
      )
    )
  ;

// ========================================================
// sqlSelect
// ........................................................

sqlSelect
  : ^(SQL_SELECT
      ( ( 'SELECT'
      | ( 'DECLARE'
        (water)?
        'SELECT'
      )
      )
        (water)?
        'FROM'
        ( ( identifier
          '.'
        ) )?
        tableName
      )
    )
  ;

// ========================================================
// sqlInsert
// ........................................................

sqlInsert
  : ^(SQL_INSERT
      ( 'INSERT'
        'INTO'
        ( ( identifier
          '.'
        ) )?
        tableName
      )
    )
  ;

// ========================================================
// sqlUpdate
// ........................................................

sqlUpdate
  : ^(SQL_UPDATE
      ( 'UPDATE'
        ( ( identifier
          '.'
        ) )?
        tableName
      )
    )
  ;

// ========================================================
// sqlDelete
// ........................................................

sqlDelete
  : ^(SQL_DELETE
      ( 'DELETE'
        'FROM'
        ( ( identifier
          '.'
        ) )?
        tableName
      )
    )
  ;

// ========================================================
// tableName
// ........................................................

tableName
  : ^(TABLE_NAME
      cobolWord
    )
  ;

// ========================================================
// execCICSStatement
// ........................................................

execCICSStatement
  : ^(EXEC_C_I_C_S_STATEMENT
      ( 'EXEC'
        'CICS'
        cicsStatement
        (water)?
        'END-EXEC'
      )
    )
  ;

// ========================================================
// cicsStatement
// ........................................................

cicsStatement
  : ^(CICS_STATEMENT
      ( cicsReadQ
      | cicsWriteQ
      | cicsDeleteQ
      | cicsReadFile
      | cicsWriteFile
      | cicsLink
      | cicsXctl
      | cicsLoad
      | cicsStart
      )
    )
  ;

// ========================================================
// dataArea
// ........................................................

dataArea
  : ^(DATA_AREA
      ( literal
      | identifier
      )
    )
  ;

// ========================================================
// cicsReadQ
// ........................................................

cicsReadQ
  : ^(CICS_READ_Q
      ( 'READQ'
        ( ( 'TS'
          ( 'QUEUE'
          | 'QNAME'
          )
          '('
          queueName
          ')'
          ( ( ( ( 'SYSID'
          | 'SYS'
          )
            '('
            cicsSysid
            ')'
          )
          | ( ( 'SET'
          | 'INTO'
          )
            '('
            dataArea
            ')'
            ( ( 'LENGTH'
              cicsWaterInBrackets
            ) )?
          )
          | ( ( 'ITEM'
            cicsWaterInBrackets
          )
          | 'NEXT'
          )
          | ( 'NUMITEMS'
            cicsWaterInBrackets
          )
          ) )*
        )
        | ( 'TD'
          'QUEUE'
          '('
          ( literal
          | identifier
          )
          ')'
        )
        )
      )
    )
  ;

// ========================================================
// cicsWriteQ
// ........................................................

cicsWriteQ
  : ^(CICS_WRITE_Q
      ( 'WRITEQ'
        ( ( 'TS'
          ( 'QUEUE'
          | 'QNAME'
          )
          '('
          queueName
          ')'
          ( ( ( ( 'SYSID'
          | 'SYS'
          )
            '('
            cicsSysid
            ')'
          )
          | ( 'FROM'
            '('
            dataArea
            ')'
            ( ( 'LENGTH'
              cicsWaterInBrackets
            ) )?
          )
          | ( ( 'NUMITEMS'
            cicsWaterInBrackets
          )
          | ( 'ITEM'
            cicsWaterInBrackets
            ( 'REWRITE' )?
          )
          )
          | 'NOSUSPEND'
          | ( 'MAIN'
          | 'AUXILIARY'
          )
          ) )*
        )
        | ( 'TD'
          'QUEUE'
          '('
          queueName
          ')'
        )
        )
      )
    )
  ;

// ========================================================
// cicsDeleteQ
// ........................................................

cicsDeleteQ
  : ^(CICS_DELETE_Q
      ( 'DELETEQ'
        ( 'TS'
        | 'TD'
        )
        ( 'QUEUE'
        | 'QNAME'
        )
        '('
        queueName
        ')'
        ( ( ( 'SYSID'
        | 'SYS'
        )
          '('
          cicsSysid
          ')'
        ) )?
      )
    )
  ;

// ========================================================
// cicsReadFile
// ........................................................

cicsReadFile
  : ^(CICS_READ_FILE
      ( ( 'READ'
        ( 'FILE'
        | 'DATASET'
        )
        '('
        fileName
        ')'
        ( ( ( ( 'SYSID'
        | 'SYS'
        )
          '('
          cicsSysid
          ')'
        )
        | ( ( 'SET'
        | 'INTO'
        )
          '('
          dataArea
          ')'
          ( ( 'LENGTH'
            cicsWaterInBrackets
          ) )?
        )
        | ( 'RIDFLD'
          cicsWaterInBrackets
          ( ( 'KEYLENGTH'
            cicsWaterInBrackets
            ( 'GENERIC' )?
          ) )?
        )
        | ( 'GTEQ'
        | 'EQUAL'
        )
        | ( 'UNCOMMITTED'
        | 'CONSISTENT'
        | 'REPEATABLE'
        | ( 'UPDATE'
          'TOKEN'
          cicsWaterInBrackets
        )
        )
        | 'NOSUSPEND'
        ) )*
      )
      | ( 'READNEXT'
        ( 'FILE'
        | 'DATASET'
        )
        '('
        fileName
        ')'
        ( ( ( ( 'SYSID'
        | 'SYS'
        )
          '('
          cicsSysid
          ')'
        )
        | ( ( 'SET'
        | 'INTO'
        )
          '('
          dataArea
          ')'
          ( ( 'LENGTH'
            cicsWaterInBrackets
          ) )?
        )
        | ( 'RIDFLD'
          cicsWaterInBrackets
          ( ( 'KEYLENGTH'
            cicsWaterInBrackets
          ) )?
        )
        | ( 'RBA'
        | 'XRBA'
        | 'RRN'
        )
        | ( 'UNCOMMITTED'
        | 'CONSISTENT'
        | 'REPEATABLE'
        | ( 'UPDATE'
          'TOKEN'
          cicsWaterInBrackets
        )
        )
        | 'NOSUSPEND'
        ) )*
      )
      )
    )
  ;

// ========================================================
// cicsWriteFile
// ........................................................

cicsWriteFile
  : ^(CICS_WRITE_FILE
      ( 'WRITE'
        ( 'FILE'
        | 'DATASET'
        )
        '('
        fileName
        ')'
        ( ( ( ( 'SYSID'
        | 'SYS'
        )
          '('
          cicsSysid
          ')'
        )
        | ( 'FROM'
          '('
          dataArea
          ')'
          ( ( 'LENGTH'
            cicsWaterInBrackets
          ) )?
        )
        | ( 'RIDFLD'
          cicsWaterInBrackets
          ( ( 'KEYLENGTH'
            cicsWaterInBrackets
          ) )?
        )
        | ( 'RBA'
        | 'XRBA'
        | 'RRN'
        )
        | 'MASSINSERT'
        | 'NOSUSPEND'
        ) )*
      )
    )
  ;

// ========================================================
// cicsLink
// ........................................................

cicsLink
  : ^(CICS_LINK
      ( 'LINK'
        'PROGRAM'
        '('
        programID
        ')'
        ( ( ( ( 'SYSID'
        | 'SYS'
        )
          '('
          cicsSysid
          ')'
        )
        | ( 'COMMAREA'
          '('
          commareaName
          ')'
          ( ( 'LENGTH'
            cicsWaterInBrackets
          ) )?
          ( ( 'DATALENGTH'
            cicsWaterInBrackets
          ) )?
        )
        | 'SYNCONRETURN'
        | ( 'TRANSID'
          cicsWaterInBrackets
        )
        | ( 'INPUTMSG'
          cicsWaterInBrackets
          ( ( 'INPUTMSGLEN'
            cicsWaterInBrackets
          ) )?
        )
        | ( 'CHANNEL'
          cicsWaterInBrackets
        )
        ) )*
      )
    )
  ;

// ========================================================
// cicsXctl
// ........................................................

cicsXctl
  : ^(CICS_XCTL
      ( 'XCTL'
        'PROGRAM'
        '('
        programID
        ')'
        ( ( ( 'COMMAREA'
          '('
          commareaName
          ')'
          ( ( 'LENGTH'
            cicsWaterInBrackets
          ) )?
        )
        | ( 'INPUTMSG'
          cicsWaterInBrackets
          ( ( 'INPUTMSGLEN'
            cicsWaterInBrackets
          ) )?
        )
        | ( 'CHANNEL'
          cicsWaterInBrackets
        )
        ) )*
      )
    )
  ;

// ========================================================
// cicsLoad
// ........................................................

cicsLoad
  : ^(CICS_LOAD
      ( 'LOAD'
        'PROGRAM'
        '('
        programID
        ')'
      )
    )
  ;

// ========================================================
// cicsStart
// ........................................................

cicsStart
  : ^(CICS_START
      ( 'START'
        ( 'TRANSID'
        | 'TR'
        )
        '('
        transactionName
        ')'
      )
    )
  ;

// ========================================================
// cicsSysid
// ........................................................

cicsSysid
  : ^(CICS_SYSID
      ( literal
      | identifier
      )
    )
  ;

// ========================================================
// queueName
// ........................................................

queueName
  : ^(QUEUE_NAME
      ( literal
      | identifier
      )
    )
  ;

// ========================================================
// transactionName
// ........................................................

transactionName
  : ^(TRANSACTION_NAME
      ( literal
      | identifier
      )
    )
  ;

// ========================================================
// commareaName
// ........................................................

commareaName
  : ^(COMMAREA_NAME
      ( literal
      | identifier
      )
    )
  ;

// ========================================================
// cicsWaterInBrackets
// ........................................................

cicsWaterInBrackets
  : ^(CICS_WATER_IN_BRACKETS
      ( '('
        (water)?
        ')'
      )
    )
  ;

// ========================================================
// exitStatement
// ........................................................

exitStatement
  : ^(EXIT_STATEMENT
      ( 'EXIT'
        ( ( 'PROGRAM'
        | 'PARAGRAPH'
        | 'SECTION'
        | ( 'PERFORM'
          ( 'CYCLE' )?
        )
        ) )?
      )
    )
  ;

// ========================================================
// gobackStatement
// ........................................................

gobackStatement
  : ^(GOBACK_STATEMENT
      'GOBACK'
    )
  ;

// ========================================================
// goToStatement
// ........................................................

goToStatement
  : ^(GO_TO_STATEMENT
      ( 'GO'
        ( 'TO' )?
        ( ( procedureName
          ( ( ( procedureName )*
            'DEPENDING'
            ( 'ON' )?
            identifier
          ) )?
        ) )?
      )
    )
  ;

// ========================================================
// ifStatement
// ........................................................

ifStatement
  : ^(IF_STATEMENT
      ( 'IF'
        condition
        ( 'THEN' )?
        ( nestedStatements
        | ( 'NEXT'
          'SENTENCE'
        )
        )
        ( ( 'ELSE'
          ( nestedStatements
          | ( 'NEXT'
            'SENTENCE'
          )
          )
        ) )?
        ( 'END-IF' )?
      )
    )
  ;

// ========================================================
// initializeStatement
// ........................................................

initializeStatement
  : ^(INITIALIZE_STATEMENT
      ( 'INITIALIZE'
        ( identifier )+
        ( replacingInitClause )?
        (water)?
      )
    )
  ;

// ========================================================
// replacingInitClause
// ........................................................

replacingInitClause
  : ^(REPLACING_INIT_CLAUSE
      ( 'REPLACING'
        replacementTarget
        ( 'DATA' )?
        'BY'
        ( identifier
        | literal
        )
      )
    )
  ;

// ========================================================
// replacementTarget
// ........................................................

replacementTarget
  : ^(REPLACEMENT_TARGET
      ( 'ALPHABETIC'
      | 'ALPHANUMERIC'
      | 'ALPHANUMERIC-EDITED'
      | 'NATIONAL'
      | 'NATIONAL-EDITED'
      | 'NUMERIC'
      | 'NUMERIC-EDITED'
      | 'DBCS'
      | 'EGCS'
      )
    )
  ;

// ========================================================
// inspectStatement
// ........................................................

inspectStatement
  : ^(INSPECT_STATEMENT
      ( 'INSPECT'
        identifier
        ( convertingPhrase
        | ( tallyingPhrase
          ( replacingPhrase )?
        )
        | replacingPhrase
        )
      )
    )
  ;

// ========================================================
// convertingPhrase
// ........................................................

convertingPhrase
  : ^(CONVERTING_PHRASE
      ( 'CONVERTING'
        ( identifier
        | literal
        )
        'TO'
        ( identifier
        | literal
        )
        ( locationPhrase )*
      )
    )
  ;

// ========================================================
// tallyingPhrase
// ........................................................

tallyingPhrase
  : ^(TALLYING_PHRASE
      ( 'TALLYING'
        ( ( identifier
          'FOR'
          ( ( tallyingCharactersPhrase
          | tallyingAllLeadingPhrase
          ) )*
        ) )*
      )
    )
  ;

// ========================================================
// tallyingCharactersPhrase
// ........................................................

tallyingCharactersPhrase
  : ^(TALLYING_CHARACTERS_PHRASE
      ( 'CHARACTERS'
        ( locationPhrase )*
      )
    )
  ;

// ========================================================
// tallyingAllLeadingPhrase
// ........................................................

tallyingAllLeadingPhrase
  : ^(TALLYING_ALL_LEADING_PHRASE
      ( ( 'ALL'
      | 'LEADING'
      )
        ( ( ( identifier
        | literal
        )
          ( locationPhrase )*
        ) )*
      )
    )
  ;

// ========================================================
// replacingPhrase
// ........................................................

replacingPhrase
  : ^(REPLACING_PHRASE
      ( 'REPLACING'
        ( ( replacingCharactersPhrase
        | replacingAllLeadingFirstPhrase
        ) )*
      )
    )
  ;

// ========================================================
// replacingCharactersPhrase
// ........................................................

replacingCharactersPhrase
  : ^(REPLACING_CHARACTERS_PHRASE
      ( 'CHARACTERS'
        'BY'
        ( identifier
        | literal
        )
        ( locationPhrase )*
      )
    )
  ;

// ========================================================
// replacingAllLeadingFirstPhrase
// ........................................................

replacingAllLeadingFirstPhrase
  : ^(REPLACING_ALL_LEADING_FIRST_PHRASE
      ( ( 'ALL'
      | 'LEADING'
      | 'FIRST'
      )
        ( ( ( identifier
        | literal
        )
          'BY'
          ( identifier
          | literal
          )
          ( locationPhrase )*
        ) )*
      )
    )
  ;

// ========================================================
// locationPhrase
// ........................................................

locationPhrase
  : ^(LOCATION_PHRASE
      ( ( 'BEFORE'
      | 'AFTER'
      )
        ( 'INITIAL' )?
        ( identifier
        | literal
        )
      )
    )
  ;

// ========================================================
// moveStatement
// ........................................................

moveStatement
  : ^(MOVE_STATEMENT
      ( 'MOVE'
        ( ( 'LENGTH'
          ( 'OF' )?
          identifier
        )
        | ( ( ( 'CORRESPONDING'
        | 'CORR'
        ) )?
          identifier
        )
        | literal
        )
        'TO'
        ( identifier )+
      )
    )
  ;

// ========================================================
// multiplyStatement
// ........................................................

multiplyStatement
  : ^(MULTIPLY_STATEMENT
      ( 'MULTIPLY'
        ( multiplication_format1
        | multiplication_format2
        )
        ( ( ( 'ON' )?
          'SIZE'
          'ERROR'
          nestedStatements
        ) )?
        ( ( 'NOT'
          ( 'ON' )?
          'SIZE'
          'ERROR'
          nestedStatements
        ) )?
        ( 'END-MULTIPLY' )?
      )
    )
  ;

// ========================================================
// multiplication_format1
// ........................................................

multiplication_format1
  : ^(MULTIPLICATION_FORMAT1
      ( ( identifier
      | literal
      )
        'BY'
        ( identifier
        | literal
        )
        'GIVING'
        ( ( identifier
          ( 'ROUNDED' )?
        ) )+
      )
    )
  ;

// ========================================================
// multiplication_format2
// ........................................................

multiplication_format2
  : ^(MULTIPLICATION_FORMAT2
      ( ( identifier
      | literal
      )
        'BY'
        ( ( identifier
          ( 'ROUNDED' )?
        ) )+
      )
    )
  ;

// ========================================================
// openStatement
// ........................................................

openStatement
  : ^(OPEN_STATEMENT
      ( 'OPEN'
        ( ( ( 'INPUT'
          ( ( fileName
            ( ( 'REVERSED'
            | ( ( 'WITH' )?
              'NO'
              'REWIND'
            )
            ) )?
          ) )+
        )
        | ( 'OUTPUT'
          ( ( fileName
            ( ( ( 'WITH' )?
              'NO'
              'REWIND'
            ) )?
          ) )+
        )
        | ( 'I-O'
          ( fileName )+
        )
        | ( 'EXTEND'
          ( fileName )+
        )
        ) )+
      )
    )
  ;

// ========================================================
// performStatement
// ........................................................

performStatement
  : ^(PERFORM_STATEMENT
      ( 'PERFORM'
        ( ( ( ( times
        | until
        | varying
        ) )?
          ( nestedStatements )?
          'END-PERFORM'
        )
        | ( procedureName
          ( ( ( 'THROUGH'
          | 'THRU'
          )
            procedureName
          ) )?
          ( ( times
          | until
          | varying
          ) )?
        )
        )
      )
    )
  ;

// ========================================================
// times
// ........................................................

times
  : ^(TIMES
      ( ( identifier
      | integer
      )
        'TIMES'
      )
    )
  ;

// ========================================================
// until
// ........................................................

until
  : ^(UNTIL
      ( ( testPosition )?
        'UNTIL'
        condition
      )
    )
  ;

// ========================================================
// testPosition
// ........................................................

testPosition
  : ^(TEST_POSITION
      ( ( 'WITH' )?
        'TEST'
        ( 'BEFORE'
        | 'AFTER'
        )
      )
    )
  ;

// ========================================================
// varying
// ........................................................

varying
  : ^(VARYING
      ( ( ( ( 'WITH' )?
        'TEST'
        ( 'BEFORE'
        | 'AFTER'
        )
      ) )?
        'VARYING'
        identifier
        'FROM'
        ( literal
        | identifier
        )
        'BY'
        ( literal
        | identifier
        )
        'UNTIL'
        condition
        ( ( 'AFTER'
          identifier
          'FROM'
          ( literal
          | identifier
          )
          'BY'
          ( literal
          | identifier
          )
          'UNTIL'
          condition
        ) )*
      )
    )
  ;

// ========================================================
// readStatement
// ........................................................

readStatement
  : ^(READ_STATEMENT
      ( 'READ'
        fileName
        ( ( ( 'WITH' )?
          ( 'NO' )?
          'LOCK'
        ) )?
        ( ( 'NEXT'
        | 'PREVIOUS'
        ) )?
        ( 'RECORD' )?
        ( ( 'INTO'
          identifier
        ) )?
        ( ( 'KEY'
          ( 'IS' )?
          dataName
        ) )?
        ( ( ( 'AT' )?
          'END'
          nestedStatements
        ) )?
        ( ( 'NOT'
          ( 'AT' )?
          'END'
          nestedStatements
        ) )?
        ( ( 'INVALID'
          ( 'KEY' )?
          nestedStatements
        ) )?
        ( ( 'NOT'
          'INVALID'
          ( 'KEY' )?
          nestedStatements
        ) )?
        ( 'END-READ' )?
      )
    )
  ;

// ========================================================
// releaseStatement
// ........................................................

releaseStatement
  : ^(RELEASE_STATEMENT
      ( 'RELEASE'
        recordName
        ( ( 'FROM'
          identifier
        ) )?
      )
    )
  ;

// ========================================================
// returnStatement
// ........................................................

returnStatement
  : ^(RETURN_STATEMENT
      ( 'RETURN'
        fileName
        ( 'RECORD' )?
        ( ( 'INTO'
          identifier
        ) )?
        atEnd
        ( notAtEnd )?
        ( 'END-RETURN' )?
      )
    )
  ;

// ========================================================
// rewriteStatement
// ........................................................

rewriteStatement
  : ^(REWRITE_STATEMENT
      ( 'REWRITE'
        recordName
        ( ( 'FROM'
          identifier
        ) )?
        ( ( 'INVALID'
          ( 'KEY' )?
          nestedStatements
        ) )?
        ( ( 'NOT'
          'INVALID'
          ( 'KEY' )?
          nestedStatements
        ) )?
        ( 'END-REWRITE' )?
      )
    )
  ;

// ========================================================
// searchStatement
// ........................................................

searchStatement
  : ^(SEARCH_STATEMENT
      ( 'SEARCH'
        ( ( 'ALL'
          identifier
        )
        | ( identifier
          ( ( 'VARYING'
            ( identifier
            | indexName
            )
          ) )?
        )
        )
        ( atEnd )?
        ( ( 'WHEN'
          condition
          ( nestedStatements
          | ( 'NEXT'
            'SENTENCE'
          )
          )
        ) )+
        ( 'END-SEARCH' )?
      )
    )
  ;

// ========================================================
// atEnd
// ........................................................

atEnd
  : ^(AT_END
      ( ( 'AT' )?
        'END'
        nestedStatements
      )
    )
  ;

// ========================================================
// notAtEnd
// ........................................................

notAtEnd
  : ^(NOT_AT_END
      ( 'NOT'
        ( 'AT' )?
        'END'
        nestedStatements
      )
    )
  ;

// ========================================================
// setStatement
// ........................................................

setStatement
  : ^(SET_STATEMENT
      ( 'SET'
        ( setFormat1
        | setFormat2
        | setFormat3
        )
        (water)?
      )
    )
  ;

// ========================================================
// setFormat1
// ........................................................

setFormat1
  : ^(SET_FORMAT1
      ( ( ( indexName
      | addressOfIdentifier
      | identifier
      ) )+
        'TO'
        ( indexName
        | addressOfIdentifier
        | identifier
        | integer
        )
      )
    )
  ;

// ========================================================
// setFormat2
// ........................................................

setFormat2
  : ^(SET_FORMAT2
      ( ( mnemonicName )+
        'TO'
        ( 'ON'
        | 'OFF'
        )
      )
    )
  ;

// ========================================================
// setFormat3
// ........................................................

setFormat3
  : ^(SET_FORMAT3
      ( ( identifier )+
        'TO'
        'TRUE'
      )
    )
  ;

// ========================================================
// startStatement
// ........................................................

startStatement
  : ^(START_STATEMENT
      ( 'START'
        fileName
        ( keyModifier )?
        ( sizeModifier )?
        ( whileKeyModifier )?
        ( ( 'INVALID'
          ( 'KEY' )?
          nestedStatements
        ) )?
        ( ( 'NOT'
          'INVALID'
          ( 'KEY' )?
          nestedStatements
        ) )?
        ( 'END-START' )?
      )
    )
  ;

// ========================================================
// keyModifier
// ........................................................

keyModifier
  : ^(KEY_MODIFIER
      ( 'KEY'
        ( 'IS' )?
        ( generalRelationOp
        | 'FIRST'
        | 'LAST'
        )
        identifier
        ( ( 'IN'
          identifier
        ) )*
      )
    )
  ;

// ========================================================
// sizeModifier
// ........................................................

sizeModifier
  : ^(SIZE_MODIFIER
      ( ( 'WITH' )?
        'SIZE'
        ( identifier
        | integer
        )
      )
    )
  ;

// ========================================================
// whileKeyModifier
// ........................................................

whileKeyModifier
  : ^(WHILE_KEY_MODIFIER
      ( 'WHILE'
        ( ( 'KEY'
          ( 'IS' )?
        ) )?
        ( negationOp )?
        'LIKE'
        ( likeMods )*
        ( identifier
        | literal
        )
      )
    )
  ;

// ========================================================
// likeMods
// ........................................................

likeMods
  : ^(LIKE_MODS
      ( trimmedRight
      | trimmedLeft
      | caseSensitive
      | caseInsensitive
      )
    )
  ;

// ========================================================
// trimmedRight
// ........................................................

trimmedRight
  : ^(TRIMMED_RIGHT
      ( 'TRIMMED'
        'RIGHT'
      )
    )
  ;

// ========================================================
// trimmedLeft
// ........................................................

trimmedLeft
  : ^(TRIMMED_LEFT
      ( 'TRIMMED'
        'LEFT'
      )
    )
  ;

// ========================================================
// caseSensitive
// ........................................................

caseSensitive
  : ^(CASE_SENSITIVE
      'CASE-SENSITIVE'
    )
  ;

// ========================================================
// caseInsensitive
// ........................................................

caseInsensitive
  : ^(CASE_INSENSITIVE
      'CASE-INSENSITIVE'
    )
  ;

// ========================================================
// stopStatement
// ........................................................

stopStatement
  : ^(STOP_STATEMENT
      ( 'STOP'
        ( 'RUN'
        | literal
        )
      )
    )
  ;

// ========================================================
// stringStatement
// ........................................................

stringStatement
  : ^(STRING_STATEMENT
      ( 'STRING'
        ( ( ( identifier
        | literal
        )
          ( ( 'DELIMITED'
            ( 'BY' )?
            ( 'SIZE'
            | identifier
            | literal
            )
          ) )?
        ) )+
        'INTO'
        identifier
        ( ( ( 'WITH' )?
          'POINTER'
          identifier
        ) )?
        ( ( ( 'ON' )?
          'OVERFLOW'
          nestedStatements
        ) )?
        ( ( 'NOT'
          ( 'ON' )?
          'OVERFLOW'
          nestedStatements
        ) )?
        ( 'END-STRING' )?
      )
    )
  ;

// ========================================================
// subtractStatement
// ........................................................

subtractStatement
  : ^(SUBTRACT_STATEMENT
      ( 'SUBTRACT'
        ( subtraction_format1
        | subtraction_format2
        | subtraction_format3
        )
        ( ( ( 'ON' )?
          'SIZE'
          'ERROR'
          nestedStatements
        ) )?
        ( ( 'NOT'
          ( 'ON' )?
          'SIZE'
          'ERROR'
          nestedStatements
        ) )?
        ( 'END-SUBTRACT' )?
      )
    )
  ;

// ========================================================
// subtraction_format1
// ........................................................

subtraction_format1
  : ^(SUBTRACTION_FORMAT1
      ( ( 'CORRESPONDING'
      | 'CORR'
      )
        identifier
        'FROM'
        identifier
        ( 'ROUNDED' )?
      )
    )
  ;

// ========================================================
// subtraction_format2
// ........................................................

subtraction_format2
  : ^(SUBTRACTION_FORMAT2
      ( ( ( identifier
      | literal
      ) )+
        ( ( 'FROM'
          ( identifier
          | literal
          )
        ) )?
        'GIVING'
        ( ( identifier
          ( 'ROUNDED' )?
        ) )+
      )
    )
  ;

// ========================================================
// subtraction_format3
// ........................................................

subtraction_format3
  : ^(SUBTRACTION_FORMAT3
      ( ( ( identifier
      | literal
      ) )+
        'FROM'
        ( ( identifier
          ( 'ROUNDED' )?
        ) )+
      )
    )
  ;

// ========================================================
// unstringStatement
// ........................................................

unstringStatement
  : ^(UNSTRING_STATEMENT
      ( 'UNSTRING'
        identifier
        ( ( 'DELIMITED'
          ( 'BY' )?
          ( 'ALL' )?
          ( identifier
          | literal
          )
          ( ( 'OR'
            ( 'ALL' )?
            ( identifier
            | literal
            )
          ) )*
        ) )?
        'INTO'
        ( ( identifier
          ( ( 'DELIMITER'
            ( 'IN' )?
            identifier
          ) )?
          ( ( 'COUNT'
            ( 'IN' )?
            identifier
          ) )?
        ) )+
        ( ( ( 'WITH' )?
          'POINTER'
          identifier
        ) )?
        ( ( 'TALLYING'
          ( 'IN' )?
          identifier
        ) )?
        ( ( ( 'ON' )?
          'OVERFLOW'
          nestedStatements
        ) )?
        ( ( 'NOT'
          ( 'ON' )?
          'OVERFLOW'
          nestedStatements
        ) )?
        ( 'END-UNSTRING' )?
      )
    )
  ;

// ========================================================
// useStatement
// ........................................................

useStatement
  : ^(USE_STATEMENT
      ( 'USE'
        ( errorDeclarative
        | debugOnAllDeclarative
        | debugDeclarative
        | labelDeclarative
        )
        '.'
      )
    )
  ;

// ========================================================
// errorDeclarative
// ........................................................

errorDeclarative
  : ^(ERROR_DECLARATIVE
      ( ( 'GLOBAL' )?
        'AFTER'
        ( 'STANDARD' )?
        ( 'ERROR'
        | 'EXCEPTION'
        )
        'PROCEDURE'
        ( 'ON' )?
        ( ( 'INPUT'
        | 'OUTPUT'
        | 'I-O'
        | 'EXTEND'
        | fileName
        ) )*
      )
    )
  ;

// ========================================================
// debugDeclarative
// ........................................................

debugDeclarative
  : ^(DEBUG_DECLARATIVE
      ( ( 'FOR' )?
        'DEBUGGING'
        ( 'ON' )?
        ( ( procedureName
        | fileName
        | ( ( ( 'ALL'
          ( ( 'REFERENCES'
            'OF'
          ) )?
        ) )?
          identifier
        )
        ) )*
      )
    )
  ;

// ========================================================
// debugOnAllDeclarative
// ........................................................

debugOnAllDeclarative
  : ^(DEBUG_ON_ALL_DECLARATIVE
      ( ( 'FOR' )?
        'DEBUGGING'
        ( 'ON' )?
        'ALL'
        'PROCEDURES'
      )
    )
  ;

// ========================================================
// labelDeclarative
// ........................................................

labelDeclarative
  : ^(LABEL_DECLARATIVE
      ( ( 'GLOBAL' )?
        'AFTER'
        ( 'STANDARD' )?
        ( ( 'BEGINNING'
        | 'ENDING'
        ) )?
        ( ( 'FILE'
        | 'REEL'
        | 'UNIT'
        ) )?
        'LABEL'
        'PROCEDURE'
        ( 'ON' )?
        ( ( 'INPUT'
        | 'OUTPUT'
        | 'I-O'
        | 'EXTEND'
        | fileName
        ) )*
      )
    )
  ;

// ========================================================
// writeStatement
// ........................................................

writeStatement
  : ^(WRITE_STATEMENT
      ( 'WRITE'
        recordName
        ( ( 'FROM'
          identifier
        ) )?
        ( ( ( 'AFTER'
        | 'BEFORE'
        )
          ( 'ADVANCING' )?
          ( ( ( identifier
          | integer
          | 'ZERO'
          )
            ( ( 'LINE'
            | 'LINES'
            ) )?
          )
          | mnemonicName
          | 'PAGE'
          )
        ) )?
        ( ( ( 'AT' )?
          ( 'END-OF-PAGE'
          | 'EOP'
          )
          nestedStatements
        ) )?
        ( ( 'NOT'
          ( 'AT' )?
          ( 'END-OF-PAGE'
          | 'EOP'
          )
          nestedStatements
        ) )?
        ( ( 'INVALID'
          ( 'KEY' )?
          nestedStatements
        ) )?
        ( ( 'NOT'
          'INVALID'
          ( 'KEY' )?
          nestedStatements
        ) )?
        ( 'END-WRITE' )?
      )
    )
  ;

// ========================================================
// copyStatement
// ........................................................

copyStatement
  : ^(COPY_STATEMENT
      ( 'COPY'
        textName
        ( ( ( 'OF'
        | 'IN'
        )
          libraryName
        ) )?
        ( 'SUPPRESS' )?
        ( copyReplacingPhrase )?
        '.'
      )
    )
  ;

// ========================================================
// copyReplacingPhrase
// ........................................................

copyReplacingPhrase
  : ^(COPY_REPLACING_PHRASE
      ( 'REPLACING'
        ( copyReplacementInstruction )+
      )
    )
  ;

// ========================================================
// copyReplacementInstruction
// ........................................................

copyReplacementInstruction
  : ^(COPY_REPLACEMENT_INSTRUCTION
      ( copyOperandName
        'BY'
        copyOperandName
      )
    )
  ;

// ========================================================
// copyOperandName
// ........................................................

copyOperandName
  : ^(COPY_OPERAND_NAME
      ( pseudoLiteral
      | verb
      | literal
      | identifier
      | cobolWord
      )
    )
  ;

// ========================================================
// replaceStatement
// ........................................................

replaceStatement
  : ^(REPLACE_STATEMENT
      ( 'REPLACE'
        (water)?
        '.'
      )
    )
  ;

// ========================================================
// divisionStart
// ........................................................

divisionStart
  : ^(DIVISION_START
      ( ( ( 'IDENTIFICATION'
        'DIVISION'
      )
      | ( 'ENVIRONMENT'
        'DIVISION'
      )
      | ( 'DATA'
        'DIVISION'
      )
      | ( 'PROCEDURE'
        'DIVISION'
        ( usingPhrase )?
        ( returningPhrase )?
      )
      )
        '.'
      )
    )
  ;

// ========================================================
// dataSectionStart
// ........................................................

dataSectionStart
  : ^(DATA_SECTION_START
      ( ( 'FILE'
      | 'WORKING-STORAGE'
      | 'LINKAGE'
      | 'COMMUNICATION'
      | 'REPORT'
      )
        'SECTION'
        '.'
      )
    )
  ;

// ========================================================
// endOfStatement
// ........................................................

endOfStatement
  : ^(END_OF_STATEMENT
      ( verb
      | 'ELSE'
      | 'WHEN'
      | 'END-ACCEPT'
      | 'END-ADD'
      | 'END-CALL'
      | 'END-COMPUTE'
      | 'END-DELETE'
      | 'END-DISPLAY'
      | 'END-DIVIDE'
      | 'END-EVALUATE'
      | 'END-EXEC'
      | 'END-IF'
      | 'END-MULTIPLY'
      | 'END-PERFORM'
      | 'END-READ'
      | 'END-RETURN'
      | 'END-REWRITE'
      | 'END-SEARCH'
      | 'END-START'
      | 'END-STRING'
      | 'END-SUBTRACT'
      | 'END-UNSTRING'
      | 'END-WRITE'
      | ( ( 'NOT' )?
        ( ( 'ON'
        | 'AT'
        ) )?
        ( 'OVERFLOW'
        | 'EXCEPTION'
        | ( 'SIZE'
          'ERROR'
        )
        | ( 'INVALID'
          ( 'KEY' )?
        )
        | 'END'
        | 'END-OF-PAGE'
        | 'EOP'
        )
      )
      )
    )
  ;

// ========================================================
// identifier
// ........................................................

identifier
  : ^(IDENTIFIER
      ( identifier_format1
      | identifier_format2
      )
    )
  ;

// ========================================================
// identifier_format1
// ........................................................

identifier_format1
  : ^(IDENTIFIER_FORMAT1
      ( 'FUNCTION'
        functionName
        ( ( '('
          ( argument )+
          ')'
        ) )?
        ( referenceModifier )?
      )
    )
  ;

// ========================================================
// identifier_format2
// ........................................................

identifier_format2
  : ^(IDENTIFIER_FORMAT2
      ( dataName
        ( qualifier )*
        ( ( '('
          ( subscript )+
          ')'
        ) )?
        ( referenceModifier )?
      )
    )
  ;

// ========================================================
// addressOfIdentifier
// ........................................................

addressOfIdentifier
  : ^(ADDRESS_OF_IDENTIFIER
      ( 'ADDRESS'
        'OF'
        identifier
      )
    )
  ;

// ========================================================
// argument
// ........................................................

argument
  : ^(ARGUMENT
      ( arithmeticExpression
      | identifier
      | literal
      )
    )
  ;

// ========================================================
// qualifier
// ........................................................

qualifier
  : ^(QUALIFIER
      ( ( 'IN'
      | 'OF'
      )
        dataName
      )
    )
  ;

// ========================================================
// subscript
// ........................................................

subscript
  : ^(SUBSCRIPT
      ( relativeSubscript
      | directSubscript
      )
    )
  ;

// ========================================================
// directSubscript
// ........................................................

directSubscript
  : ^(DIRECT_SUBSCRIPT
      ( integer
      | identifier
      | 'ALL'
      )
    )
  ;

// ========================================================
// relativeSubscript
// ........................................................

relativeSubscript
  : ^(RELATIVE_SUBSCRIPT
      ( identifier
        ( '+'
        | '-'
        )
        integer
      )
    )
  ;

// ========================================================
// referenceModifier
// ........................................................

referenceModifier
  : ^(REFERENCE_MODIFIER
      ( '('
        arithmeticExpression
        ':'
        ( arithmeticExpression )?
        ')'
      )
    )
  ;

// ========================================================
// arithmeticExpression
// ........................................................

arithmeticExpression
  : ^(ARITHMETIC_EXPRESSION
      ( summand
        ( ( signDef
          summand
        ) )*
      )
    )
  ;

// ========================================================
// signDef
// ........................................................

signDef
  : ^(SIGN_DEF
      ( '+'
      | '-'
      )
    )
  ;

// ========================================================
// summand
// ........................................................

summand
  : ^(SUMMAND
      ( factor
        ( ( ( '*'
        | '/'
        )
          factor
        ) )*
      )
    )
  ;

// ========================================================
// factor
// ........................................................

factor
  : ^(FACTOR
      ( ( signDef )?
        atomicExpression
        ( ( '**'
          atomicExpression
        ) )*
      )
    )
  ;

// ========================================================
// atomicExpression
// ........................................................

atomicExpression
  : ^(ATOMIC_EXPRESSION
      ( 'ZERO'
      | identifier
      | numeric
      | ( '('
        arithmeticExpression
        ')'
      )
      )
    )
  ;

// ========================================================
// condition
// ........................................................

condition
  : ^(CONDITION
      ( ( primaryCondition
      | ( ( negationOp )?
        '('
        condition
        ')'
      )
      )
        ( ( conditionalRelationOP
          ( primaryCondition
          | ( ( negationOp )?
            '('
            condition
            ')'
          )
          )
        ) )*
      )
    )
  ;

// ========================================================
// primaryCondition
// ........................................................

primaryCondition
  : ^(PRIMARY_CONDITION
      ( ( negationOp )?
        primaryCondDef
      )
    )
  ;

// ========================================================
// primaryCondDef
// ........................................................

primaryCondDef
  : ^(PRIMARY_COND_DEF
      ( booleanLiteral
      | ( classPrimaryCondition
        ( ( conditionalRelationOP
          ( negationOp )?
          classSecondaryCondition
        ) )*
      )
      | signPrimaryCondition
      | ( generalPrimaryCondition
        ( ( conditionalRelationOP
          ( negationOp )?
          generalSecondaryCondition
        ) )*
      )
      | ( monoElemPrimaryCondition
        ( ( ( 'IS' )?
          ( negationOp )?
          monoElemPrimaryCondition
        ) )*
      )
      )
    )
  ;

// ========================================================
// generalPrimaryCondition
// ........................................................

generalPrimaryCondition
  : ^(GENERAL_PRIMARY_CONDITION
      ( operand
        generalRelationOp
        operand
      )
    )
  ;

// ========================================================
// signPrimaryCondition
// ........................................................

signPrimaryCondition
  : ^(SIGN_PRIMARY_CONDITION
      ( ( arithmeticExpression
      | identifier
      )
        ( 'IS' )?
        ( negationOp )?
        signType
      )
    )
  ;

// ========================================================
// signType
// ........................................................

signType
  : ^(SIGN_TYPE
      ( 'POSITIVE'
      | 'NEGATIVE'
      | 'ZERO'
      )
    )
  ;

// ========================================================
// monoElemPrimaryCondition
// ........................................................

monoElemPrimaryCondition
  : ^(MONO_ELEM_PRIMARY_CONDITION
      ( ( 'IS' )?
        ( conditionName
        | className
        )
      )
    )
  ;

// ========================================================
// classPrimaryCondition
// ........................................................

classPrimaryCondition
  : ^(CLASS_PRIMARY_CONDITION
      ( identifier
        ( 'IS' )?
        ( negationOp )?
        classType
      )
    )
  ;

// ========================================================
// classType
// ........................................................

classType
  : ^(CLASS_TYPE
      ( 'NUMERIC'
      | 'ALPHABETIC'
      | 'ALPHABETIC-LOWER'
      | 'ALPHABETIC-UPPER'
      | 'DBCS'
      | 'KANJI'
      )
    )
  ;

// ========================================================
// generalSecondaryCondition
// ........................................................

generalSecondaryCondition
  : ^(GENERAL_SECONDARY_CONDITION
      ( ( generalRelationOp )?
        operand
      )
    )
  ;

// ========================================================
// classSecondaryCondition
// ........................................................

classSecondaryCondition
  : ^(CLASS_SECONDARY_CONDITION
      ( ( 'IS' )?
        ( negationOp )?
        classType
      )
    )
  ;

// ========================================================
// conditionalRelationOP
// ........................................................

conditionalRelationOP
  : ^(CONDITIONAL_RELATION_O_P
      ( 'AND'
      | 'OR'
      )
    )
  ;

// ========================================================
// generalRelationOp
// ........................................................

generalRelationOp
  : ^(GENERAL_RELATION_OP
      ( ( 'IS' )?
        ( greaterOrEqualOp
        | lessOrEqualOp
        | greaterThanOp
        | notGreaterThanOp
        | lessThanOp
        | notLessThanOp
        | equalToOp
        | notEqualToOp
        )
      )
    )
  ;

// ========================================================
// negationOp
// ........................................................

negationOp
  : ^(NEGATION_OP
      'NOT'
    )
  ;

// ========================================================
// greaterThanOp
// ........................................................

greaterThanOp
  : ^(GREATER_THAN_OP
      ( ( 'GREATER'
        ( 'THAN' )?
      )
      | '>'
      )
    )
  ;

// ========================================================
// notGreaterThanOp
// ........................................................

notGreaterThanOp
  : ^(NOT_GREATER_THAN_OP
      ( 'NOT'
        ( ( 'GREATER'
          ( 'THAN' )?
        )
        | '>'
        )
      )
    )
  ;

// ========================================================
// lessThanOp
// ........................................................

lessThanOp
  : ^(LESS_THAN_OP
      ( ( 'LESS'
        ( 'THAN' )?
      )
      | '<'
      )
    )
  ;

// ========================================================
// notLessThanOp
// ........................................................

notLessThanOp
  : ^(NOT_LESS_THAN_OP
      ( 'NOT'
        ( ( 'LESS'
          ( 'THAN' )?
        )
        | '<'
        )
      )
    )
  ;

// ========================================================
// equalToOp
// ........................................................

equalToOp
  : ^(EQUAL_TO_OP
      ( ( 'EQUAL'
        ( 'TO' )?
      )
      | '='
      )
    )
  ;

// ========================================================
// notEqualToOp
// ........................................................

notEqualToOp
  : ^(NOT_EQUAL_TO_OP
      ( 'NOT'
        ( ( 'EQUAL'
          ( 'TO' )?
        )
        | '='
        )
      )
    )
  ;

// ========================================================
// greaterOrEqualOp
// ........................................................

greaterOrEqualOp
  : ^(GREATER_OR_EQUAL_OP
      ( ( 'GREATER'
        ( 'THAN' )?
        'OR'
        'EQUAL'
        ( 'TO' )?
      )
      | '>='
      )
    )
  ;

// ========================================================
// lessOrEqualOp
// ........................................................

lessOrEqualOp
  : ^(LESS_OR_EQUAL_OP
      ( ( 'LESS'
        ( 'THAN' )?
        'OR'
        'EQUAL'
        ( 'TO' )?
      )
      | '<='
      )
    )
  ;

// ========================================================
// programName
// ........................................................

programName
  : ^(PROGRAM_NAME
      ( cobolWord
      | alphanumeric
      )
    )
  ;

// ========================================================
// dataName
// ........................................................

dataName
  : ^(DATA_NAME
      ( cobolWord
      | 'FILLER'
      | 'CURSOR'
      )
    )
  ;

// ========================================================
// sectionName
// ........................................................

sectionName
  : ^(SECTION_NAME
      ( cobolWord
      | integer
      )
    )
  ;

// ========================================================
// paragraphName
// ........................................................

paragraphName
  : ^(PARAGRAPH_NAME
      ( cobolWord
      | integer
      )
    )
  ;

// ========================================================
// procedureName
// ........................................................

procedureName
  : ^(PROCEDURE_NAME
      ( ( cobolWord
      | integer
      )
        ( ( ( 'IN'
        | 'OF'
        )
          cobolWord
        ) )?
      )
    )
  ;

// ========================================================
// segmentNumber
// ........................................................

segmentNumber
  : ^(SEGMENT_NUMBER
      integer
    )
  ;

// ========================================================
// operand
// ........................................................

operand
  : ^(OPERAND
      ( arithmeticExpression
      | identifier
      | literal
      | indexName
      )
    )
  ;

// ========================================================
// conditionName
// ........................................................

conditionName
  : ^(CONDITION_NAME
      identifier
    )
  ;

// ========================================================
// indexName
// ........................................................

indexName
  : ^(INDEX_NAME
      cobolWord
    )
  ;

// ========================================================
// className
// ........................................................

className
  : ^(CLASS_NAME
      cobolWord
    )
  ;

// ========================================================
// fileName
// ........................................................

fileName
  : ^(FILE_NAME
      ( cobolWord
      | alphanumeric
      )
    )
  ;

// ========================================================
// computerName
// ........................................................

computerName
  : ^(COMPUTER_NAME
      cobolWord
    )
  ;

// ========================================================
// functionName
// ........................................................

functionName
  : ^(FUNCTION_NAME
      cobolWord
    )
  ;

// ========================================================
// textName
// ........................................................

textName
  : ^(TEXT_NAME
      ( cobolWord
      | alphanumeric
      )
    )
  ;

// ========================================================
// libraryName
// ........................................................

libraryName
  : ^(LIBRARY_NAME
      cobolWord
    )
  ;

// ========================================================
// recordName
// ........................................................

recordName
  : ^(RECORD_NAME
      identifier
    )
  ;

// ========================================================
// mnemonicName
// ........................................................

mnemonicName
  : ^(MNEMONIC_NAME
      ( cobolWord
      | identifier
      )
    )
  ;

// ========================================================
// environmentName
// ........................................................

environmentName
  : ^(ENVIRONMENT_NAME
      ( 'SYSIN'
      | 'SYSIPT'
      | 'SYSOUT'
      | 'SYSLIST'
      | 'SYSLST'
      | 'SYSPUNCH'
      | 'SYSPCH'
      | 'CONSOLE'
      | 'C01'
      | 'C02'
      | 'C03'
      | 'C04'
      | 'C05'
      | 'C06'
      | 'C07'
      | 'C08'
      | 'C09'
      | 'C10'
      | 'C11'
      | 'C12'
      | 'CSP'
      | 'S01'
      | 'S02'
      | 'S03'
      | 'S04'
      | 'S05'
      | 'AFP-5A'
      )
    )
  ;

// ========================================================
// alphabetName
// ........................................................

alphabetName
  : ^(ALPHABET_NAME
      cobolWord
    )
  ;

// ========================================================
// reportName
// ........................................................

reportName
  : ^(REPORT_NAME
      cobolWord
    )
  ;

// ========================================================
// assignmentName
// ........................................................

assignmentName
  : ^(ASSIGNMENT_NAME
      ( cobolWord
      | literal
      )
    )
  ;

// ========================================================
// literal
// ........................................................

literal
  : ^(LITERAL
      ( numeric
      | alphanumeric
      | figurativeConstant
      | booleanLiteral
      )
    )
  ;

// ========================================================
// booleanLiteral
// ........................................................

booleanLiteral
  : ^(BOOLEAN_LITERAL
      ( 'TRUE'
      | 'FALSE'
      )
    )
  ;

// ========================================================
// figurativeConstant
// ........................................................

figurativeConstant
  : ^(FIGURATIVE_CONSTANT
      ( ( 'ALL'
        literal
      )
      | ( ( 'ALL' )?
        ( 'ZERO'
        | 'ZEROS'
        | 'ZEROES'
        | 'SPACE'
        | 'SPACES'
        | 'HIGH-VALUE'
        | 'HIGH-VALUES'
        | 'LOW-VALUE'
        | 'LOW-VALUES'
        | 'QUOTE'
        | 'QUOTES'
        )
      )
      | 'NULL'
      | 'NULLS'
      )
    )
  ;

// ========================================================
// numeric
// ........................................................

numeric
  : ^(NUMERIC
      ( integer
      | decimal
      | hexadecimal
      | ( 'LENGTH'
        'OF'
        identifier
      )
      )
    )
  ;

// ========================================================

water
  : ^(WATER token*)
  ;

token
  : TOKEN
  | '('
  | ')'
  | '*'
  | '**'
  | '+'
  | '-'
  | '.'
  | '/'
  | '66'
  | '88'
  | ':'
  | '<'
  | '<='
  | '='
  | '>'
  | '>='
  | 'ACCEPT'
  | 'ADD'
  | 'ADDRESS'
  | 'ADVANCING'
  | 'AFP-5A'
  | 'AFTER'
  | 'ALL'
  | 'ALPHABET'
  | 'ALPHABETIC'
  | 'ALPHABETIC-LOWER'
  | 'ALPHABETIC-UPPER'
  | 'ALPHANUMERIC'
  | 'ALPHANUMERIC-EDITED'
  | 'ALSO'
  | 'ALTER'
  | 'AND'
  | 'ANY'
  | 'ARE'
  | 'ASCENDING'
  | 'ASSIGN'
  | 'AT'
  | 'AUXILIARY'
  | 'BEEP'
  | 'BEFORE'
  | 'BEGINNING'
  | 'BELL'
  | 'BINARY'
  | 'BLANK'
  | 'BLINK'
  | 'BLOCK'
  | 'BOTTOM'
  | 'BY'
  | 'C01'
  | 'C02'
  | 'C03'
  | 'C04'
  | 'C05'
  | 'C06'
  | 'C07'
  | 'C08'
  | 'C09'
  | 'C10'
  | 'C11'
  | 'C12'
  | 'CALL'
  | 'CANCEL'
  | 'CASE-INSENSITIVE'
  | 'CASE-SENSITIVE'
  | 'CHANNEL'
  | 'CHARACTER'
  | 'CHARACTERS'
  | 'CICS'
  | 'CLASS'
  | 'CLOSE'
  | 'CODE-SET'
  | 'COL'
  | 'COLUMN'
  | 'COMMA'
  | 'COMMAREA'
  | 'COMMON'
  | 'COMMUNICATION'
  | 'COMP'
  | 'COMP-1'
  | 'COMP-2'
  | 'COMP-3'
  | 'COMP-4'
  | 'COMP-5'
  | 'COMPUTATIONAL'
  | 'COMPUTATIONAL-1'
  | 'COMPUTATIONAL-2'
  | 'COMPUTATIONAL-3'
  | 'COMPUTATIONAL-4'
  | 'COMPUTATIONAL-5'
  | 'COMPUTE'
  | 'CONFIGURATION'
  | 'CONSISTENT'
  | 'CONSOLE'
  | 'CONTAINS'
  | 'CONTENT'
  | 'CONTINUE'
  | 'CONTROL'
  | 'CONVERT'
  | 'CONVERTING'
  | 'COPY'
  | 'CORR'
  | 'CORRESPONDING'
  | 'COUNT'
  | 'CRT'
  | 'CSP'
  | 'CURRENCY'
  | 'CURSOR'
  | 'CYCLE'
  | 'DATA'
  | 'DATALENGTH'
  | 'DATASET'
  | 'DBCS'
  | 'DEBUGGING'
  | 'DECIMAL-POINT'
  | 'DECLARATIVES'
  | 'DECLARE'
  | 'DELETE'
  | 'DELETEQ'
  | 'DELIMITED'
  | 'DELIMITER'
  | 'DEPENDING'
  | 'DESCENDING'
  | 'DISABLE'
  | 'DISPLAY'
  | 'DIVIDE'
  | 'DIVISION'
  | 'EGCS'
  | 'ELSE'
  | 'ENABLE'
  | 'END'
  | 'END-ACCEPT'
  | 'END-ADD'
  | 'END-CALL'
  | 'END-COMPUTE'
  | 'END-DELETE'
  | 'END-DISPLAY'
  | 'END-DIVIDE'
  | 'END-EVALUATE'
  | 'END-EXEC'
  | 'END-IF'
  | 'END-MULTIPLY'
  | 'END-OF-PAGE'
  | 'END-PERFORM'
  | 'END-READ'
  | 'END-RETURN'
  | 'END-REWRITE'
  | 'END-SEARCH'
  | 'END-START'
  | 'END-STRING'
  | 'END-SUBTRACT'
  | 'END-UNSTRING'
  | 'END-WRITE'
  | 'ENDING'
  | 'ENTRY'
  | 'ENVIRONMENT'
  | 'EOL'
  | 'EOP'
  | 'EOS'
  | 'EQUAL'
  | 'ERASE'
  | 'ERROR'
  | 'EVALUATE'
  | 'EXCEPTION'
  | 'EXEC'
  | 'EXIT'
  | 'EXTEND'
  | 'EXTERNAL'
  | 'F'
  | 'FALSE'
  | 'FD'
  | 'FILE'
  | 'FILE-CONTROL'
  | 'FILLER'
  | 'FIRST'
  | 'FOOTING'
  | 'FOR'
  | 'FROM'
  | 'FUNCTION'
  | 'GENERATE'
  | 'GENERIC'
  | 'GIVING'
  | 'GLOBAL'
  | 'GO'
  | 'GOBACK'
  | 'GREATER'
  | 'GTEQ'
  | 'HIGH'
  | 'HIGH-VALUE'
  | 'HIGH-VALUES'
  | 'HIGHLIGHT'
  | 'I-O'
  | 'I-O-CONTROL'
  | 'ID'
  | 'IDENTIFICATION'
  | 'IF'
  | 'IN'
  | 'INCLUDE'
  | 'INDEX'
  | 'INDEXED'
  | 'INITIAL'
  | 'INITIALIZE'
  | 'INITIATE'
  | 'INPUT'
  | 'INPUT-OUTPUT'
  | 'INPUTMSG'
  | 'INPUTMSGLEN'
  | 'INSERT'
  | 'INSPECT'
  | 'INTO'
  | 'INVALID'
  | 'IS'
  | 'ITEM'
  | 'JUST'
  | 'JUSTIFIED'
  | 'KANJI'
  | 'KEY'
  | 'KEYLENGTH'
  | 'LABEL'
  | 'LAST'
  | 'LEADING'
  | 'LEFT'
  | 'LENGTH'
  | 'LESS'
  | 'LIKE'
  | 'LINAGE'
  | 'LINE'
  | 'LINES'
  | 'LINK'
  | 'LINKAGE'
  | 'LOAD'
  | 'LOCAL-STORAGE'
  | 'LOCK'
  | 'LOW'
  | 'LOW-VALUE'
  | 'LOW-VALUES'
  | 'LOWLIGHT'
  | 'MAIN'
  | 'MASSINSERT'
  | 'MERGE'
  | 'MODE'
  | 'MOVE'
  | 'MULTIPLY'
  | 'NATIONAL'
  | 'NATIONAL-EDITED'
  | 'NATIVE'
  | 'NEGATIVE'
  | 'NEXT'
  | 'NO'
  | 'NOSUSPEND'
  | 'NOT'
  | 'NULL'
  | 'NULLS'
  | 'NUMBER'
  | 'NUMERIC'
  | 'NUMERIC-EDITED'
  | 'NUMITEMS'
  | 'OBJECT-COMPUTER'
  | 'OCCURS'
  | 'OF'
  | 'OFF'
  | 'OMITTED'
  | 'ON'
  | 'OPEN'
  | 'OPTIONAL'
  | 'OR'
  | 'ORGANIZATION'
  | 'OTHER'
  | 'OUTPUT'
  | 'OVERFLOW'
  | 'PACKED-DECIMAL'
  | 'PAGE'
  | 'PARAGRAPH'
  | 'PERFORM'
  | 'PIC'
  | 'PICTURE'
  | 'POINTER'
  | 'POSITION'
  | 'POSITIVE'
  | 'PREVIOUS'
  | 'PROCEDURE'
  | 'PROCEDURES'
  | 'PROGRAM'
  | 'PROGRAM-ID'
  | 'PURGE'
  | 'QNAME'
  | 'QUEUE'
  | 'QUOTE'
  | 'QUOTES'
  | 'RBA'
  | 'READ'
  | 'READNEXT'
  | 'READQ'
  | 'RECEIVE'
  | 'RECORD'
  | 'RECORDING'
  | 'RECORDS'
  | 'REDEFINES'
  | 'REEL'
  | 'REFERENCE'
  | 'REFERENCES'
  | 'RELEASE'
  | 'REMAINDER'
  | 'REMOVAL'
  | 'RENAMES'
  | 'REPEATABLE'
  | 'REPLACE'
  | 'REPLACING'
  | 'REPORT'
  | 'REPORTS'
  | 'RETURN'
  | 'RETURNING'
  | 'REVERSE'
  | 'REVERSE-VIDEO'
  | 'REVERSED'
  | 'REWIND'
  | 'REWRITE'
  | 'RIDFLD'
  | 'RIGHT'
  | 'ROUNDED'
  | 'RRN'
  | 'RUN'
  | 'S'
  | 'S01'
  | 'S02'
  | 'S03'
  | 'S04'
  | 'S05'
  | 'SD'
  | 'SEARCH'
  | 'SECTION'
  | 'SELECT'
  | 'SEND'
  | 'SENTENCE'
  | 'SEPARATE'
  | 'SEQUENTIAL'
  | 'SET'
  | 'SIGN'
  | 'SIZE'
  | 'SORT'
  | 'SOURCE-COMPUTER'
  | 'SPACE'
  | 'SPACES'
  | 'SPECIAL-NAMES'
  | 'SQL'
  | 'STANDARD'
  | 'STANDARD-1'
  | 'STANDARD-2'
  | 'START'
  | 'STATUS'
  | 'STOP'
  | 'STRING'
  | 'SUBTRACT'
  | 'SUPPRESS'
  | 'SYMBOLIC'
  | 'SYNC'
  | 'SYNCHRONIZED'
  | 'SYNCONRETURN'
  | 'SYS'
  | 'SYSID'
  | 'SYSIN'
  | 'SYSIPT'
  | 'SYSLIST'
  | 'SYSLST'
  | 'SYSOUT'
  | 'SYSPCH'
  | 'SYSPUNCH'
  | 'TALLYING'
  | 'TD'
  | 'TERMINATE'
  | 'TEST'
  | 'THAN'
  | 'THEN'
  | 'THROUGH'
  | 'THRU'
  | 'TIMES'
  | 'TO'
  | 'TOKEN'
  | 'TOP'
  | 'TR'
  | 'TRAILING'
  | 'TRANSID'
  | 'TRIMMED'
  | 'TRUE'
  | 'TS'
  | 'U'
  | 'UNCOMMITTED'
  | 'UNIT'
  | 'UNSTRING'
  | 'UNTIL'
  | 'UPDATE'
  | 'UPON'
  | 'USAGE'
  | 'USE'
  | 'USING'
  | 'V'
  | 'VALUE'
  | 'VALUES'
  | 'VARYING'
  | 'WHEN'
  | 'WHILE'
  | 'WITH'
  | 'WORKING-STORAGE'
  | 'WRITE'
  | 'WRITEQ'
  | 'XCTL'
  | 'XRBA'
  | 'ZERO'
  | 'ZEROES'
  | 'ZEROS'
  ;

// ========================================================

cobolWord
  : ^(COBOL_WORD token)
  ;

integer
  : ^(INTEGER token)
  ;

decimal
  : ^(DECIMAL token)
  ;

hexadecimal
  : ^(HEXADECIMAL token)
  ;

alphanumeric
  : ^(ALPHANUMERIC token)
  ;

pictureString
  : ^(PICTURE_STRING token+)
  ;

levelNumber
  : ^(LEVEL_NUMBER token)
  ;

pseudoLiteral
  : ^(PSEUDO_LITERAL token)
  ;
