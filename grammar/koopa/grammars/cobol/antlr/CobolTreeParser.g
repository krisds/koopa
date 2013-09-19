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
      ( ( compilerDirective
      | compilationUnit
      ) )*
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
      ( ( ( identificationDivision
        ( environmentDivision )?
        ( dataDivision )?
      )
      | ( environmentDivision
        ( dataDivision )?
      )
      | dataDivision
      )
        ( ( procedureDivision
          ( compilationUnit )*
        ) )?
        ( endMarker )?
      )
    )
  ;

// ========================================================
// endMarker
// ........................................................

endMarker
  : ^(END_MARKER
      ( ( 'END'
        'FUNCTION'
        functionName
        '.'
      )
      | ( 'END'
        'CLASS'
        className
        '.'
      )
      | ( 'END'
        'FACTORY'
        '.'
      )
      | ( 'END'
        'STATIC'
        '.'
      )
      | ( 'END'
        'OBJECT'
        '.'
      )
      | ( 'END'
        'OPERATOR'
        '.'
      )
      | ( 'END'
        'METHOD'
        ( methodName )?
        '.'
      )
      | ( 'END'
        'INTERFACE'
        interfaceName
        '.'
      )
      | ( 'END'
        'DELEGATE'
        delegateName
        '.'
      )
      | ( 'END'
        'ENUM'
        enumName
        '.'
      )
      | ( 'END'
        'OPERATOR'
        cobolWord
        '.'
      )
      | ( 'END'
        'VALUETYPE'
        valuetypeName
        '.'
      )
      | ( 'END'
        'PROGRAM'
        programName
        '.'
      )
      )
    )
  ;

// ========================================================
// identificationDivision
// ........................................................

identificationDivision
  : ^(IDENTIFICATION_DIVISION
      ( ( ( 'ID'
      | 'IDENTIFICATION'
      )
        'DIVISION'
        '.'
        ( identificationDivisionBody )?
      )
      | identificationDivisionBody
      )
    )
  ;

// ========================================================
// identificationDivisionBody
// ........................................................

identificationDivisionBody
  : ^(IDENTIFICATION_DIVISION_BODY
      ( ( ( callPrototypeIdParagraph
      | programPrototypeIdParagraph
      | programIdParagraph
      | classIdParagrah
      | factoryParagraph
      | objectParagraph
      | methodIdParagraph
      | interfaceIdParagraph
      | functionIdParagraph
      | delegateIdParagraph
      | enumIdParagraph
      | iteratorIdParagraph
      | operatorIdParagraph
      | valuetypeIdParagraph
      | ( 'AUTHOR'
        '.'
        (water)?
        '.'
      )
      | ( 'INSTALLATION'
        '.'
        (water)?
        '.'
      )
      | ( 'DATE-WRITTEN'
        '.'
        (water)?
        '.'
      )
      | ( 'DATE-COMPILED'
        '.'
        (water)?
        '.'
      )
      | ( 'SECURITY'
        '.'
        (water)?
        '.'
      )
      | ( 'REMARKS'
        '.'
        (water)?
        '.'
      )
      ) )+
        (water)?
      )
    )
  ;

// ========================================================
// callPrototypeIdParagraph
// ........................................................

callPrototypeIdParagraph
  : ^(CALL_PROTOTYPE_ID_PARAGRAPH
      ( 'PROGRAM-ID'
        ( '.' )?
        programName
        ( 'IS' )?
        'EXTERNAL'
        ( 'PROGRAM' )?
        ( '.' )?
      )
    )
  ;

// ========================================================
// programPrototypeIdParagraph
// ........................................................

programPrototypeIdParagraph
  : ^(PROGRAM_PROTOTYPE_ID_PARAGRAPH
      ( 'PROGRAM-ID'
        ( '.' )?
        programName
        ( ( 'AS'
          literal
        ) )?
        ( 'IS' )?
        'PROTOTYPE'
        ( '.' )?
      )
    )
  ;

// ========================================================
// programIdParagraph
// ........................................................

programIdParagraph
  : ^(PROGRAM_ID_PARAGRAPH
      ( 'PROGRAM-ID'
        ( '.' )?
        programName
        ( ( 'AS'
          literal
        ) )?
        ( ( ( 'IS' )?
          ( ( 'INITIAL'
            ( 'COMMON' )?
          )
          | ( 'COMMON'
            ( 'INITIAL' )?
          )
          | 'RECURSIVE'
          )
          ( 'PROGRAM' )?
        ) )?
        ( ( (water)?
          '.'
        ) )?
      )
    )
  ;

// ========================================================
// classIdParagrah
// ........................................................

classIdParagrah
  : ^(CLASS_ID_PARAGRAH
      ( 'CLASS-ID'
        ( '.' )?
        className
        ( ( 'AS'
          literal
        ) )?
        ( ( 'INHERITS'
          ( 'FROM' )?
          ( typeSpecifier )+
        ) )?
        ( ( ( 'IS' )?
          'STATIC'
        ) )?
        ( ( ( 'IS' )?
          ( ( 'PARTIAL'
          | 'FINAL'
          | 'ABSTRACT'
          ) )+
        ) )?
        ( ( ( 'IS' )?
          ( 'PUBLIC'
          | 'INTERNAL'
          )
        ) )?
        ( attributeClause )?
        ( ( 'IMPLEMENTS'
          ( typeSpecifier )+
        ) )?
        ( ( 'USING'
          ( parameterName )+
        ) )?
        ( '.' )?
      )
    )
  ;

// ========================================================
// factoryParagraph
// ........................................................

factoryParagraph
  : ^(FACTORY_PARAGRAPH
      ( ( 'FACTORY'
      | 'STATIC'
      )
        ( '.' )?
        ( ( 'IMPLEMENTS'
          ( interfaceName )+
          '.'
        ) )?
      )
    )
  ;

// ========================================================
// objectParagraph
// ........................................................

objectParagraph
  : ^(OBJECT_PARAGRAPH
      ( 'OBJECT'
        ( '.' )?
        ( ( 'IMPLEMENTS'
          ( interfaceName )+
          '.'
        ) )?
      )
    )
  ;

// ========================================================
// methodIdParagraph
// ........................................................

methodIdParagraph
  : ^(METHOD_ID_PARAGRAPH
      ( 'METHOD-ID'
        ( '.' )?
        ( methodName
        | ( ( 'GET'
        | 'SET'
        )
          'PROPERTY'
          propertyName
        )
        )
        ( ( 'AS'
          literal
        ) )?
        ( 'SYNC' )?
        ( ( ( 'IS' )?
          ( 'STATIC'
          | ( ( 'STATIC' )?
            'EXTENSION'
          )
          )
        ) )?
        ( ( ( 'IS' )?
          ( 'PUBLIC'
          | 'PRIVATE'
          | 'PROTECTED'
          | 'INTERNAL'
          )
        ) )?
        ( ( 'OVERRIDE'
        | 'REDEFINE'
        ) )?
        ( ( ( 'IS' )?
          ( 'FINAL'
          | 'ABSTRACT'
          )
        ) )?
        ( ( 'FOR'
          interfaceName
        ) )?
        ( attributeClause )?
        ( ( 'USING'
          ( parameterName )+
        ) )?
        ( '.' )?
      )
    )
  ;

// ========================================================
// interfaceIdParagraph
// ........................................................

interfaceIdParagraph
  : ^(INTERFACE_ID_PARAGRAPH
      ( 'INTERFACE-ID'
        ( '.' )?
        interfaceName
        ( ( 'AS'
          literal
        ) )?
        ( ( ( 'IS' )?
          ( 'PUBLIC'
          | 'INTERNAL'
          )
        ) )?
        ( ( 'INHERITS'
          ( 'FROM' )?
          ( typeSpecifier )+
        ) )?
        ( attributeClause )?
        ( ( 'USING'
          ( parameterName )+
        ) )?
        ( '.' )?
      )
    )
  ;

// ========================================================
// functionIdParagraph
// ........................................................

functionIdParagraph
  : ^(FUNCTION_ID_PARAGRAPH
      ( 'FUNCTION-ID'
        ( '.' )?
        functionName
        ( ( 'AS'
          literal
        ) )?
        ( ( ( 'IS' )?
          'PROTOTYPE'
        ) )?
        ( '.' )?
      )
    )
  ;

// ========================================================
// delegateIdParagraph
// ........................................................

delegateIdParagraph
  : ^(DELEGATE_ID_PARAGRAPH
      ( 'DELEGATE-ID'
        ( '.' )?
        delegateName
        ( ( 'AS'
          literal
        ) )?
        ( ( ( 'IS' )?
          ( ( 'PUBLIC'
          | 'PRIVATE'
          | 'PROTECTED'
          | 'INTERNAL'
          ) )+
        ) )?
        ( attributeClause )?
        ( '.' )?
      )
    )
  ;

// ========================================================
// enumIdParagraph
// ........................................................

enumIdParagraph
  : ^(ENUM_ID_PARAGRAPH
      ( 'ENUM-ID'
        ( '.' )?
        enumName
        ( ( 'AS'
          literal
        ) )?
        ( ( ( 'IS' )?
          ( ( 'PUBLIC'
          | 'PRIVATE'
          | 'PROTECTED'
          | 'INTERNAL'
          ) )+
        ) )?
        ( attributeClause )?
        ( '.' )?
      )
    )
  ;

// ========================================================
// iteratorIdParagraph
// ........................................................

iteratorIdParagraph
  : ^(ITERATOR_ID_PARAGRAPH
      ( 'ITERATOR-ID'
        ( '.' )?
        iteratorName
        ( ( 'AS'
          literal
        ) )?
        ( ( ( 'IS' )?
          ( ( 'PUBLIC'
          | 'PRIVATE'
          | 'PROTECTED'
          | 'INTERNAL'
          ) )+
        ) )?
        ( attributeClause )?
        ( '.' )?
      )
    )
  ;

// ========================================================
// operatorIdParagraph
// ........................................................

operatorIdParagraph
  : ^(OPERATOR_ID_PARAGRAPH
      ( 'OPERATOR-ID'
        ( '.' )?
        ( ( '='
          ( 'EXTENSION' )?
        )
        | '<>'
        | '>='
        | '>'
        | '<='
        | '<'
        | '+'
        | '-'
        | '*'
        | '/'
        | 'B-AND'
        | 'B-OR'
        | 'B-XOR'
        | 'B-NOT'
        | 'B-LEFT'
        | 'B-RIGHT'
        | 'IMPLICIT'
        | 'EXPLICIT'
        )
        ( '.' )?
      )
    )
  ;

// ========================================================
// valuetypeIdParagraph
// ........................................................

valuetypeIdParagraph
  : ^(VALUETYPE_ID_PARAGRAPH
      ( 'VALUETYPE-ID'
        ( '.' )?
        valuetypeName
        ( ( 'AS'
          literal
        ) )?
        ( ( ( 'IS' )?
          ( 'FINAL'
          | 'PARTIAL'
          | 'ABSTRACT'
          )
        ) )?
        ( ( ( 'IS' )?
          ( 'PUBLIC'
          | 'INTERNAL'
          )
        ) )?
        ( attributeClause )?
        ( ( 'IMPLEMENTS'
          ( interfaceName )+
        ) )?
        ( '.' )?
      )
    )
  ;

// ========================================================
// attributeClause
// ........................................................

attributeClause
  : ^(ATTRIBUTE_CLAUSE
      ( ( ( 'ATTRIBUTE'
        attributeName
        '('
        ( ( ( 'NAME'
          propertyName
          '='
          propertyValue
        )
        | parameterName
        ) )*
        ')'
      )
      | ( 'CUSTOM-ATTRIBUTE'
        'IS'
        className
        ( ( '('
          ( ( ( propertyName
            '='
            propertyValue
          )
          | parameterName
          ) )*
          ')'
        ) )?
      )
      ) )+
    )
  ;

// ========================================================
// environmentDivision
// ........................................................

environmentDivision
  : ^(ENVIRONMENT_DIVISION
      ( ( 'ENVIRONMENT'
        'DIVISION'
        '.'
        ( environmentDivisionBody )?
      )
      | environmentDivisionBody
      | ( configurationSectionBody
        ( ioSection )?
        (water)?
      )
      | ( ioSectionBody
        ( configurationSection )?
        (water)?
      )
      )
    )
  ;

// ========================================================
// environmentDivisionBody
// ........................................................

environmentDivisionBody
  : ^(ENVIRONMENT_DIVISION_BODY
      ( ( ( configurationSection
      | ioSection
      | objectSection
      ) )+
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
        ( configurationSectionBody )?
      )
    )
  ;

// ========================================================
// configurationSectionBody
// ........................................................

configurationSectionBody
  : ^(CONFIGURATION_SECTION_BODY
      ( ( ( sourceComputerParagraph
      | objectComputerParagraph
      | specialNamesParagraph
      | repositoryParagraph
      | constraintsParagraph
      | classAttributesParagraph
      | assemblyAttributesParagraph
      ) )+
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
// constraintsParagraph
// ........................................................

constraintsParagraph
  : ^(CONSTRAINTS_PARAGRAPH
      ( 'CONSTRAINTS'
        '.'
        (water)?
      )
    )
  ;

// ========================================================
// classAttributesParagraph
// ........................................................

classAttributesParagraph
  : ^(CLASS_ATTRIBUTES_PARAGRAPH
      ( 'CLASS-ATTRIBUTES'
        '.'
        (water)?
      )
    )
  ;

// ========================================================
// assemblyAttributesParagraph
// ........................................................

assemblyAttributesParagraph
  : ^(ASSEMBLY_ATTRIBUTES_PARAGRAPH
      ( 'ASSEMBLY-ATTRIBUTES'
        '.'
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
        ( ( specialNameStatement
        | copyStatement
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
      ( consoleIsCRT
      | alphabetIs
      | symbolicChars
      | classIs
      | localeIs
      | currencySignIs
      | decimalIsComma
      | numericSignIs
      | callConvention
      | cursorIs
      | crtStatusIs
      | xmlSchemaIs
      | screenControlIs
      | eventStatusIs
      | ( cobolSwitch
        'IS'
        mnemonicName
        ( ( ( 'ON'
        | 'OFF'
        )
          ( 'STATUS' )?
          ( 'IS' )?
          conditionName
        ) )*
      )
      | ( cobolDevice
        'IS'
        mnemonicName
      )
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
// cobolDevice
// ........................................................

cobolDevice
  : ^(COBOL_DEVICE
      ( 'SYSIN'
      | 'SYSIPT'
      | 'SYSOUT'
      | 'SYSLIST'
      | 'SYSLST'
      | 'SYSPCH'
      | 'SYSPUNCH'
      | 'CONSOLE'
      | 'TAB'
      | 'PRINTER'
      | 'FORMFEED'
      | 'COMMAND-LINE'
      | 'ARGUMENT-NUMBER'
      | 'ENVIRONMENT-NAME'
      | 'ENVIRONMENT-VALUE'
      | 'SYSERR'
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
      | 'S01'
      | 'S02'
      | 'S03'
      | 'S04'
      | 'S05'
      | 'CSP'
      | alphanumericLiteral
      | cobolWord
      )
    )
  ;

// ========================================================
// cobolSwitch
// ........................................................

cobolSwitch
  : ^(COBOL_SWITCH
      ( 'SWITCH-0'
      | 'SWITCH-1'
      | 'SWITCH-2'
      | 'SWITCH-3'
      | 'SWITCH-4'
      | 'SWITCH-5'
      | 'SWITCH-6'
      | 'SWITCH-7'
      | 'SWITCH-8'
      )
    )
  ;

// ========================================================
// alphabetIs
// ........................................................

alphabetIs
  : ^(ALPHABET_IS
      ( 'ALPHABET'
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
      | asciiAlphabetType
      | ebcdicAlphabetType
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
// asciiAlphabetType
// ........................................................

asciiAlphabetType
  : ^(ASCII_ALPHABET_TYPE
      'ASCII'
    )
  ;

// ========================================================
// ebcdicAlphabetType
// ........................................................

ebcdicAlphabetType
  : ^(EBCDIC_ALPHABET_TYPE
      'EBCDIC'
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
// localeIs
// ........................................................

localeIs
  : ^(LOCALE_IS
      ( 'LOCALE'
        identifier
        ( 'IS' )?
        identifier
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
// callConvention
// ........................................................

callConvention
  : ^(CALL_CONVENTION
      ( 'CALL-CONVENTION'
        integer
        ( 'IS' )?
        mnemonicName
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
// xmlSchemaIs
// ........................................................

xmlSchemaIs
  : ^(XML_SCHEMA_IS
      ( 'XML-SCHEMA'
        identifier
        ( 'IS' )?
        ( dataName
        | literal
        )
      )
    )
  ;

// ========================================================
// screenControlIs
// ........................................................

screenControlIs
  : ^(SCREEN_CONTROL_IS
      ( 'SCREEN'
        'CONTROL'
        ( 'IS' )?
        identifier
      )
    )
  ;

// ========================================================
// eventStatusIs
// ........................................................

eventStatusIs
  : ^(EVENT_STATUS_IS
      ( 'EVENT'
        'STATUS'
        ( 'IS' )?
        identifier
      )
    )
  ;

// ========================================================
// repositoryParagraph
// ........................................................

repositoryParagraph
  : ^(REPOSITORY_PARAGRAPH
      ( 'REPOSITORY'
        '.'
        ( ( ( ( classSpecifier
        | interfaceSpecifier
        | programSpecifier
        | propertySpecifier
        | functionSpecifier
        | delegateSpecifier
        | enumSpecifier
        ) )+
          '.'
        ) )?
      )
    )
  ;

// ========================================================
// classSpecifier
// ........................................................

classSpecifier
  : ^(CLASS_SPECIFIER
      ( 'CLASS'
        className
        ( ( 'AS'
          literal
        ) )?
        ( ( 'EXPANDS'
          className
          'USING'
          ( className
          | interfaceName
          )
        ) )?
      )
    )
  ;

// ========================================================
// interfaceSpecifier
// ........................................................

interfaceSpecifier
  : ^(INTERFACE_SPECIFIER
      ( 'INTERFACE'
        interfaceName
        ( ( 'AS'
          literal
        ) )?
        ( ( 'EXPANDS'
          interfaceName
          'USING'
          ( className
          | interfaceName
          )
        ) )?
      )
    )
  ;

// ========================================================
// programSpecifier
// ........................................................

programSpecifier
  : ^(PROGRAM_SPECIFIER
      ( 'PROGRAM'
        programName
        ( ( 'AS'
          literal
        ) )?
      )
    )
  ;

// ========================================================
// propertySpecifier
// ........................................................

propertySpecifier
  : ^(PROPERTY_SPECIFIER
      ( 'PROPERTY'
        propertyName
        ( ( 'AS'
          literal
        ) )?
      )
    )
  ;

// ========================================================
// functionSpecifier
// ........................................................

functionSpecifier
  : ^(FUNCTION_SPECIFIER
      ( 'FUNCTION'
        ( ( ( 'ALL'
        | functionName
        )
          'INTRINSIC'
        )
        | ( functionName
          ( ( 'AS'
            literal
          ) )?
        )
        )
      )
    )
  ;

// ========================================================
// delegateSpecifier
// ........................................................

delegateSpecifier
  : ^(DELEGATE_SPECIFIER
      ( 'DELEGATE'
        delegateName
        ( ( 'AS'
          literal
        ) )?
      )
    )
  ;

// ========================================================
// enumSpecifier
// ........................................................

enumSpecifier
  : ^(ENUM_SPECIFIER
      ( 'ENUM'
        enumName
        ( ( 'AS'
          literal
        ) )?
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
        ( ioSectionBody )?
      )
    )
  ;

// ========================================================
// ioSectionBody
// ........................................................

ioSectionBody
  : ^(IO_SECTION_BODY
      ( ( ( fileControlParagraph
      | ioControlParagraph
      ) )+
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
        ( fileControlEntry )?
      )
    )
  ;

// ========================================================
// fileControlEntry
// ........................................................

fileControlEntry
  : ^(FILE_CONTROL_ENTRY
      ( ( selectStatement
      | copyStatement
      ) )+
    )
  ;

// ========================================================
// selectStatement
// ........................................................

selectStatement
  : ^(SELECT_STATEMENT
      ( selectClause
        assignClause
        ( ( organizationClause
        | collationClause
        | recordDelimiterClause
        | reserveClause
        | accessModeClause
        | lockModeClause
        | relativeKeyClause
        | recordKeyClause
        | alternateRecordKeyClause
        | fileStatusClause
        | sharingClause
        | paddingClause
        ) )*
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
        ( ( 'OPTIONAL'
        | ( 'NOT'
          'OPTIONAL'
        )
        ) )?
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
        ( ( 'EXTERNAL'
        | 'DYNAMIC'
        ) )?
        ( diskClause
        | dataName
        | assignmentName
        )
      )
    )
  ;

// ========================================================
// diskClause
// ........................................................

diskClause
  : ^(DISK_CLAUSE
      ( ( 'DISK'
        'FROM'
        dataName
      )
      | ( 'LINE'
        'ADVANCING'
        ( 'FILE' )?
        ( ( dataName
        | literal
        ) )+
      )
      | ( ( 'MULTIPLE' )?
        ( 'REEL'
        | 'UNIT'
        )
        ( 'FILE' )?
        ( ( dataName
        | literal
        ) )+
      )
      | ( ( 'DISK' )?
        'FILE'
        ( ( dataName
        | literal
        ) )+
      )
      | ( ( 'DISK'
      | 'PRINTER'
      )
        'DISPLAY'
      )
      | ( ( ( 'DISK'
      | 'KEYBOARD'
      | 'DISPLAY'
      | 'PRINTER'
      | 'PRINTER-1'
      ) )?
        ( ( dataName
        | literal
        ) )*
      )
      )
    )
  ;

// ========================================================
// collationClause
// ........................................................

collationClause
  : ^(COLLATION_CLAUSE
      ( 'COLLATING'
        ( 'SEQUENCE' )?
        ( 'IS' )?
        alphabetName
      )
    )
  ;

// ========================================================
// recordDelimiterClause
// ........................................................

recordDelimiterClause
  : ^(RECORD_DELIMITER_CLAUSE
      ( 'RECORD'
        'DELIMITER'
        ( 'IS' )?
        ( 'STANDARD-1'
        | alphanumericLiteral
        )
      )
    )
  ;

// ========================================================
// reserveClause
// ........................................................

reserveClause
  : ^(RESERVE_CLAUSE
      ( 'RESERVE'
        ( integer
        | 'NO'
        )
        ( 'ALTERNATE' )?
        ( 'AREA'
        | 'AREAS'
        )
      )
    )
  ;

// ========================================================
// organizationClause
// ........................................................

organizationClause
  : ^(ORGANIZATION_CLAUSE
      ( ( ( 'ORGANIZATION'
        ( 'IS' )?
      ) )?
        ( ( 'LINE'
        | ( 'RECORD'
          'BINARY'
        )
        | 'RECORD'
        | 'BINARY'
        ) )?
        ( 'SEQUENTIAL'
        | 'RELATIVE'
        | 'INDEXED'
        )
      )
    )
  ;

// ========================================================
// accessModeClause
// ........................................................

accessModeClause
  : ^(ACCESS_MODE_CLAUSE
      ( 'ACCESS'
        ( 'MODE' )?
        ( 'IS' )?
        ( 'SEQUENTIAL'
        | 'RANDOM'
        | 'DYNAMIC'
        | 'EXCLUSIVE'
        | ( 'MANUAL'
          ( lockModeWithClause )?
        )
        | ( 'AUTOMATIC'
          ( lockModeWithClause )?
        )
        )
      )
    )
  ;

// ========================================================
// lockModeClause
// ........................................................

lockModeClause
  : ^(LOCK_MODE_CLAUSE
      ( 'LOCK'
        ( 'MODE' )?
        ( 'IS' )?
        ( 'EXCLUSIVE'
        | ( 'MANUAL'
          ( lockModeWithClause )?
        )
        | ( 'AUTOMATIC'
          ( lockModeWithClause )?
        )
        )
      )
    )
  ;

// ========================================================
// lockModeWithClause
// ........................................................

lockModeWithClause
  : ^(LOCK_MODE_WITH_CLAUSE
      ( ( 'WITH' )?
        ( 'ROLLBACK'
        | ( 'LOCK'
          'ON'
          ( 'MULTIPLE' )?
          ( 'RECORD'
          | 'RECORDS'
          )
        )
        )
      )
    )
  ;

// ========================================================
// relativeKeyClause
// ........................................................

relativeKeyClause
  : ^(RELATIVE_KEY_CLAUSE
      ( 'RELATIVE'
        ( 'KEY' )?
        ( 'IS' )?
        recordKeyDefinition
      )
    )
  ;

// ========================================================
// recordKeyClause
// ........................................................

recordKeyClause
  : ^(RECORD_KEY_CLAUSE
      ( 'RECORD'
        ( 'KEY' )?
        ( 'IS' )?
        recordKeyDefinition
        ( passwordClause )?
      )
    )
  ;

// ========================================================
// alternateRecordKeyClause
// ........................................................

alternateRecordKeyClause
  : ^(ALTERNATE_RECORD_KEY_CLAUSE
      ( 'ALTERNATE'
        ( 'RECORD' )?
        ( 'KEY' )?
        ( 'IS' )?
        recordKeyDefinition
        ( ( passwordClause
        | suppressClause
        | ( ( 'WITH' )?
          'DUPLICATES'
        )
        ) )*
      )
    )
  ;

// ========================================================
// recordKeyDefinition
// ........................................................

recordKeyDefinition
  : ^(RECORD_KEY_DEFINITION
      ( ( ( literal
      | identifier
      )
        ( '='
        | ( 'SOURCE'
          ( 'IS' )?
        )
        )
        ( dataName )+
      )
      | dataName
      )
    )
  ;

// ========================================================
// fileStatusClause
// ........................................................

fileStatusClause
  : ^(FILE_STATUS_CLAUSE
      ( ( ( 'FILE'
      | 'SORT'
      ) )?
        'STATUS'
        ( 'IS' )?
        dataName
        ( dataName )?
      )
    )
  ;

// ========================================================
// passwordClause
// ........................................................

passwordClause
  : ^(PASSWORD_CLAUSE
      ( 'PASSWORD'
        ( 'IS' )?
        dataName
      )
    )
  ;

// ========================================================
// suppressClause
// ........................................................

suppressClause
  : ^(SUPPRESS_CLAUSE
      ( 'SUPPRESS'
        ( 'WHEN' )?
        ( zero
        | space
        | ( ( 'ALL' )?
          literal
        )
        )
      )
    )
  ;

// ========================================================
// sharingClause
// ........................................................

sharingClause
  : ^(SHARING_CLAUSE
      ( 'SHARING'
        ( 'WITH' )?
        ( ( 'READ'
          'ONLY'
        )
        | ( ( 'ALL'
        | 'NO'
        )
          ( 'OTHER' )?
        )
        )
      )
    )
  ;

// ========================================================
// paddingClause
// ........................................................

paddingClause
  : ^(PADDING_CLAUSE
      ( 'PADDING'
        ( 'CHARACTER' )?
        ( 'IS' )?
        ( literal
        | identifier
        )
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
// objectSection
// ........................................................

objectSection
  : ^(OBJECT_SECTION
      ( ( 'OBJECT'
        'SECTION'
        '.'
        ( objectSectionBody )?
      )
      | objectSectionBody
      )
    )
  ;

// ========================================================
// objectSectionBody
// ........................................................

objectSectionBody
  : ^(OBJECT_SECTION_BODY
      ( ( classControlParagraph
      | copyStatement
      ) )+
    )
  ;

// ========================================================
// classControlParagraph
// ........................................................

classControlParagraph
  : ^(CLASS_CONTROL_PARAGRAPH
      ( 'CLASS-CONTROL'
        '.'
        ( ( ( className
          'IS'
          'CLASS'
          literal
        )
        | copyStatement
        ) )+
        ( '.' )?
      )
    )
  ;

// ========================================================
// dataDivision
// ........................................................

dataDivision
  : ^(DATA_DIVISION
      ( ( 'DATA'
        'DIVISION'
        '.'
        ( dataDivisionBody )?
      )
      | dataDivisionBody
      )
    )
  ;

// ========================================================
// dataDivisionBody
// ........................................................

dataDivisionBody
  : ^(DATA_DIVISION_BODY
      ( ( fileSection
      | workingStorageSection
      | threadLocalStorageSection
      | objectStorageSection
      | localStorageSection
      | linkageSection
      | communicationSection
      | reportSection
      | screenSection
      ) )+
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
        ( fileSectionBody )?
      )
    )
  ;

// ========================================================
// fileSectionBody
// ........................................................

fileSectionBody
  : ^(FILE_SECTION_BODY
      ( ( ( copyStatement
      | ( fileDescriptionEntry
        ( recordDescriptionEntry )*
      )
      ) )+
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
// threadLocalStorageSection
// ........................................................

threadLocalStorageSection
  : ^(THREAD_LOCAL_STORAGE_SECTION
      ( 'THREAD-LOCAL-STORAGE'
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
// objectStorageSection
// ........................................................

objectStorageSection
  : ^(OBJECT_STORAGE_SECTION
      ( 'OBJECT-STORAGE'
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
        ( ( communicationDescriptionEntry
        | recordDescriptionEntry
        ) )*
      )
    )
  ;

// ========================================================
// communicationDescriptionEntry
// ........................................................

communicationDescriptionEntry
  : ^(COMMUNICATION_DESCRIPTION_ENTRY
      ( communicationDescriptionEntry_format1
      | communicationDescriptionEntry_format2
      | communicationDescriptionEntry_format3
      )
    )
  ;

// ========================================================
// communicationDescriptionEntry_format1
// ........................................................

communicationDescriptionEntry_format1
  : ^(COMMUNICATION_DESCRIPTION_ENTRY_FORMAT1
      ( 'CD'
        cdName
        ( 'FOR' )?
        ( 'INITIAL' )?
        'INPUT'
        ( ( dataDescName )+
        | ( ( ( ( 'SYMBOLIC' )?
          'QUEUE'
          ( 'IS' )?
          dataDescName
        )
        | ( ( 'SYMBOLIC' )?
          'SUB-QUEUE-1'
          ( 'IS' )?
          dataDescName
        )
        | ( ( 'SYMBOLIC' )?
          'SUB-QUEUE-2'
          ( 'IS' )?
          dataDescName
        )
        | ( ( 'SYMBOLIC' )?
          'SUB-QUEUE-3'
          ( 'IS' )?
          dataDescName
        )
        | ( 'MESSAGE'
          'DATE'
          ( 'IS' )?
          dataDescName
        )
        | ( 'MESSAGE'
          'TIME'
          ( 'IS' )?
          dataDescName
        )
        | ( ( 'SYMBOLIC' )?
          'SOURCE'
          ( 'IS' )?
          dataDescName
        )
        | ( 'TEXT'
          'LENGTH'
          ( 'IS' )?
          dataDescName
        )
        | ( 'END'
          'KEY'
          ( 'IS' )?
          dataDescName
        )
        | ( 'STATUS'
          'KEY'
          ( 'IS' )?
          dataDescName
        )
        | ( ( 'MESSAGE' )?
          'COUNT'
          ( 'IS' )?
          dataDescName
        )
        ) )*
        )
        '.'
      )
    )
  ;

// ========================================================
// communicationDescriptionEntry_format2
// ........................................................

communicationDescriptionEntry_format2
  : ^(COMMUNICATION_DESCRIPTION_ENTRY_FORMAT2
      ( 'CD'
        cdName
        ( 'FOR' )?
        'OUTPUT'
        ( ( 'DESTINATION'
          'COUNT'
          ( 'IS' )?
          dataDescName
        ) )?
        ( ( 'TEXT'
          'LENGTH'
          ( 'IS' )?
          dataDescName
        ) )?
        ( ( 'STATUS'
          'KEY'
          ( 'IS' )?
          dataDescName
        ) )?
        ( ( 'DESTINATION'
          'TABLE'
          'OCCURS'
          integer
          ( 'TIMES' )?
          ( ( 'INDEXED'
            ( 'BY' )?
            ( indexName )+
          ) )?
        ) )?
        ( ( 'ERROR'
          'KEY'
          ( 'IS' )?
          dataDescName
        ) )?
        ( ( ( 'SYMBOLIC' )?
          'DESTINATION'
          ( 'IS' )?
          dataDescName
        ) )?
        '.'
      )
    )
  ;

// ========================================================
// communicationDescriptionEntry_format3
// ........................................................

communicationDescriptionEntry_format3
  : ^(COMMUNICATION_DESCRIPTION_ENTRY_FORMAT3
      ( 'CD'
        cdName
        ( 'FOR' )?
        ( 'INITIAL' )?
        'I-O'
        ( ( dataDescName )+
        | ( ( ( 'MESSAGE'
          'DATE'
          ( 'IS' )?
          dataDescName
        )
        | ( 'MESSAGE'
          'TIME'
          ( 'IS' )?
          dataDescName
        )
        | ( ( 'SYMBOLIC' )?
          'TERMINAL'
          ( 'IS' )?
          dataDescName
        )
        | ( 'TEXT'
          'LENGTH'
          ( 'IS' )?
          dataDescName
        )
        | ( 'END'
          'KEY'
          ( 'IS' )?
          dataDescName
        )
        | ( 'STATUS'
          'KEY'
          ( 'IS' )?
          dataDescName
        )
        ) )*
        )
        '.'
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
        ( ( reportDescriptionEntry
          ( reportGroupDescriptionEntry )+
        ) )*
      )
    )
  ;

// ========================================================
// reportDescriptionEntry
// ........................................................

reportDescriptionEntry
  : ^(REPORT_DESCRIPTION_ENTRY
      ( 'RD'
        reportName
        ( ( ( 'IS' )?
          'GLOBAL'
        ) )?
        ( ( ( 'WITH' )?
          'CODE'
          ( literal
          | mnemonicName
          )
        ) )?
        ( ( ( ( 'CONTROL'
          ( 'IS' )?
        )
        | ( 'CONTROLS'
          ( 'ARE' )?
        )
        )
          ( ( 'FINAL'
            ( dataName )*
          )
          | ( dataName )+
          )
        ) )?
        ( ( 'PAGE'
          ( ( 'LIMIT'
          | 'LIMITS'
          ) )?
          ( ( 'IS'
          | 'ARE'
          ) )?
          integer
          ( ( 'LINE'
          | 'LINES'
          ) )?
          ( ( 'HEADING'
            integer
          ) )?
          ( ( 'FIRST'
            'DETAIL'
            integer
          ) )?
          ( ( 'LAST'
            'DETAIL'
            integer
          ) )?
          ( ( 'FOOTING'
            integer
          ) )?
        ) )?
        '.'
      )
    )
  ;

// ========================================================
// reportGroupDescriptionEntry
// ........................................................

reportGroupDescriptionEntry
  : ^(REPORT_GROUP_DESCRIPTION_ENTRY
      ( reportGroupDescriptionEntry_format1
      | reportGroupDescriptionEntry_format2
      | reportGroupDescriptionEntry_format3
      )
    )
  ;

// ========================================================
// reportGroupDescriptionEntry_format1
// ........................................................

reportGroupDescriptionEntry_format1
  : ^(REPORT_GROUP_DESCRIPTION_ENTRY_FORMAT1
      ( '01'
        ( dataName )?
        ( ( 'LINE'
          ( 'NUMBER' )?
          ( 'IS' )?
          ( ( integer
            ( ( ( 'ON' )?
              'NEXT'
              'PAGE'
            ) )?
          )
          | ( 'PLUS'
            integer
          )
          | ( 'NEXT'
            'PAGE'
          )
          )
        ) )?
        ( ( 'NEXT'
          'GROUP'
          ( 'IS' )?
          ( integer
          | ( 'PLUS'
            integer
          )
          | ( 'NEXT'
            'PAGE'
          )
          )
        ) )?
        'TYPE'
        ( 'IS' )?
        ( ( 'RH'
        | ( 'REPORT'
          'HEADING'
        )
        )
        | ( 'PH'
        | ( 'PAGE'
          'HEADING'
        )
        )
        | ( ( 'CH'
        | ( 'CONTROL'
          'HEADING'
        )
        )
          ( 'FINAL'
          | dataName
          )
        )
        | ( 'DE'
        | 'DETAIL'
        )
        | ( ( 'CF'
        | ( 'CONTROL'
          'FOOTING'
        )
        )
          ( 'FINAL'
          | dataName
          )
        )
        | ( 'PF'
        | ( 'PAGE'
          'FOOTING'
        )
        )
        | ( 'RF'
        | ( 'REPORT'
          'FOOTING'
        )
        )
        )
        ( ( 'USAGE'
          ( 'IS' )?
          ( 'DISPLAY'
          | 'DISPLAY-1'
          )
        ) )?
        '.'
      )
    )
  ;

// ========================================================
// reportGroupDescriptionEntry_format2
// ........................................................

reportGroupDescriptionEntry_format2
  : ^(REPORT_GROUP_DESCRIPTION_ENTRY_FORMAT2
      ( levelNumber
        ( dataName )?
        ( ( 'LINE'
          ( 'NUMBER' )?
          ( 'IS' )?
          ( ( integer
            ( ( ( 'ON' )?
              'NEXT'
              'PAGE'
            ) )?
          )
          | ( 'PLUS'
            integer
          )
          | ( 'NEXT'
            'PAGE'
          )
          )
        ) )?
        ( ( 'USAGE'
          ( 'IS' )?
          ( 'DISPLAY'
          | 'DISPLAY-1'
          )
        ) )?
        '.'
      )
    )
  ;

// ========================================================
// reportGroupDescriptionEntry_format3
// ........................................................

reportGroupDescriptionEntry_format3
  : ^(REPORT_GROUP_DESCRIPTION_ENTRY_FORMAT3
      ( levelNumber
        ( dataName )?
        ( ( picture
        | ( 'USAGE'
          ( 'IS' )?
          ( 'DISPLAY'
          | 'DISPLAY-1'
          )
        )
        | ( 'SIGN'
          ( 'IS' )?
          ( 'LEADING'
          | 'TRAILING'
          )
          'SEPARATE'
          ( 'CHARACTER' )?
        )
        | ( ( 'JUSTIFIED'
        | 'JUST'
        )
          ( 'RIGHT' )?
        )
        | ( 'BLANK'
          ( 'WHEN' )?
          zero
        )
        | ( 'LINE'
          ( 'NUMBER' )?
          ( 'IS' )?
          ( ( integer
            ( ( ( 'ON' )?
              'NEXT'
              'PAGE'
            ) )?
          )
          | ( 'PLUS'
            integer
          )
          | ( 'NEXT'
            'PAGE'
          )
          )
        )
        | ( 'COLUMN'
          ( 'NUMBER' )?
          ( 'IS' )?
          integer
        )
        | ( ( 'SOURCE'
          ( 'IS' )?
          identifier
        )
        | ( 'VALUE'
          ( 'IS' )?
          literal
        )
        | ( ( 'SUM'
          identifier
          ( ( 'UPON'
            ( dataName )+
          ) )?
        )
          ( ( 'RESET'
            ( 'ON' )?
            ( 'FINAL'
            | dataName
            )
          ) )?
        )
        )
        | ( 'GROUP'
          ( 'INDICATE' )?
        )
        ) )*
        '.'
      )
    )
  ;

// ========================================================
// screenSection
// ........................................................

screenSection
  : ^(SCREEN_SECTION
      ( 'SCREEN'
        'SECTION'
        '.'
        (water)?
      )
    )
  ;

// ========================================================
// screenDescriptionEntry
// ........................................................

screenDescriptionEntry
  : ^(SCREEN_DESCRIPTION_ENTRY
      ( levelNumber
        ( ( 'FILLER'
        | screenName
        ) )?
        ( screenEntryPhrase )*
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
        | threadLocalClause
        | labelRecords
        | linage
        | record
        | recordingMode
        | valueOfFileId
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
        | valueOfFileId
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
        ( ( 'FOR'
          ( identifier )+
        ) )?
      )
    )
  ;

// ========================================================
// dataRecords
// ........................................................

dataRecords
  : ^(DATA_RECORDS
      ( ( 'DATA' )?
        ( ( 'RECORD'
          ( 'IS' )?
        )
        | ( 'RECORDS'
          ( 'ARE' )?
        )
        )
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
        ( ( 'RECORD'
          ( 'IS' )?
        )
        | ( 'RECORDS'
          ( 'ARE' )?
        )
        )
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
        | 'FIXED'
        | 'VARIABLE'
        )
      )
    )
  ;

// ========================================================
// valueOfFileId
// ........................................................

valueOfFileId
  : ^(VALUE_OF_FILE_ID
      ( 'VALUE'
        'OF'
        'FILE-ID'
        ( 'IS' )?
        ( dataName
        | literal
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
      ( constantDescriptionEntry
      | dataDescriptionEntry_format3
      | dataDescriptionEntry_format2
      | dataDescriptionEntry_format1
      )
    )
  ;

// ========================================================
// dataDescriptionEntry_format1
// ........................................................

dataDescriptionEntry_format1
  : ^(DATA_DESCRIPTION_ENTRY_FORMAT1
      ( levelNumber
        ( dataDescName )?
        ( ( redefines
        | external
        | global
        | typedefClause
        | threadLocalClause
        | picture
        | occurs
        | dtLinePos
        | dtColPos
        | sign
        | valueClause
        | sync
        | justified
        | blankWhenZero
        | anyLengthClause
        | autoPhrase
        | backgroundPhrase
        | beepPhrase
        | blinkPhrase
        | controlPhrase
        | erasePhrase
        | fillPhrase
        | foregroundPhrase
        | fullPhrase
        | gridPhrase
        | highPhrase
        | lowPhrase
        | linePhrase
        | promptPhrase
        | requiredPhrase
        | reversePhrase
        | securePhrase
        | sizePhrase
        | propertyClause
        | ( 'USING'
          identifier
        )
        | ( 'FROM'
          ( identifier
          | literal
          )
          ( ( 'TO'
            identifier
          ) )?
        )
        | 'PUBLIC'
        | 'PRIVATE'
        | 'PROTECTED'
        | 'INTERNAL'
        | based
        | attributeClause
        | usage
        | literal
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
        qualifiedDataName
        ( ( ( 'THROUGH'
        | 'THRU'
        )
          qualifiedDataName
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
        conditionName
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
        ( whenSetToFalseClause )?
        '.'
      )
    )
  ;

// ========================================================
// whenSetToFalseClause
// ........................................................

whenSetToFalseClause
  : ^(WHEN_SET_TO_FALSE_CLAUSE
      ( ( 'WHEN' )?
        ( 'SET' )?
        ( 'TO' )?
        'FALSE'
        ( 'IS' )?
        literal
      )
    )
  ;

// ========================================================
// constantDescriptionEntry
// ........................................................

constantDescriptionEntry
  : ^(CONSTANT_DESCRIPTION_ENTRY
      ( ( ( '78'
        cobolWord
        'VALUE'
        ( 'IS' )?
        valueIsOperand
        ( ( valueIsOperator
          valueIsOperand
        ) )*
      )
      | ( ( '1'
      | '01'
      )
        cobolWord
        'CONSTANT'
        ( global )?
        ( ( ( 'AS' )?
          identifier
        )
        | ( 'FROM'
          cobolWord
        )
        )
      )
      )
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
        zero
      )
    )
  ;

// ========================================================
// anyLengthClause
// ........................................................

anyLengthClause
  : ^(ANY_LENGTH_CLAUSE
      ( 'ANY'
        'LENGTH'
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
        ( ( ( 'AS'
        | 'BY'
        )
          literal
        ) )?
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
// typedefClause
// ........................................................

typedefClause
  : ^(TYPEDEF_CLAUSE
      ( ( 'IS' )?
        'TYPEDEF'
      )
    )
  ;

// ========================================================
// threadLocalClause
// ........................................................

threadLocalClause
  : ^(THREAD_LOCAL_CLAUSE
      ( ( 'IS' )?
        'THREAD-LOCAL'
      )
    )
  ;

// ========================================================
// zero
// ........................................................

zero
  : ^(ZERO
      ( 'ZERO'
      | 'ZEROS'
      | 'ZEROES'
      )
    )
  ;

// ========================================================
// space
// ........................................................

space
  : ^(SPACE
      ( 'SPACE'
      | 'SPACES'
      )
    )
  ;

// ========================================================
// justified
// ........................................................

justified
  : ^(JUSTIFIED
      ( ( 'OUTPUT' )?
        ( 'JUSTIFIED'
        | 'JUST'
        )
        ( ( 'LEFT'
        | 'RIGHT'
        | 'CENTERED'
        ) )?
      )
    )
  ;

// ========================================================
// occurs
// ........................................................

occurs
  : ^(OCCURS
      ( 'OCCURS'
        ( ( ( ( ( integer
          'TO'
        ) )?
          integer
          ( 'TIMES' )?
          ( ( 'DEPENDING'
            ( 'ON' )?
            qualifiedDataName
          ) )?
          ( ( ( 'ASCENDING'
          | 'DESCENDING'
          )
            ( 'KEY' )?
            ( 'IS' )?
            ( qualifiedDataName )+
          ) )*
          ( ( 'INDEXED'
            ( 'BY' )?
            ( indexName )+
          ) )*
        )
        | 'ANY'
        ) )+
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
        usageClause
      )
    )
  ;

// ========================================================
// usageClause
// ........................................................

usageClause
  : ^(USAGE_CLAUSE
      ( 'BINARY'
      | ( 'BINARY-CHAR'
        ( ( 'SIGNED'
        | 'UNSIGNED'
        ) )?
      )
      | ( 'BINARY-SHORT'
        ( ( 'SIGNED'
        | 'UNSIGNED'
        ) )?
      )
      | ( 'BINARY-LONG'
        ( ( 'SIGNED'
        | 'UNSIGNED'
        ) )?
      )
      | ( 'BINARY-DOUBLE'
        ( ( 'SIGNED'
        | 'UNSIGNED'
        ) )?
      )
      | 'BINARY-C-LONG'
      | 'FLOAT-SHORT'
      | 'FLOAT-LONG'
      | 'FLOAT-EXTENDED'
      | 'BIT'
      | 'CHARACTER'
      | 'COMPUTATIONAL'
      | 'COMP'
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
      | 'COMPUTATIONAL-X'
      | 'COMP-X'
      | 'CONDITION-VALUE'
      | 'DECIMAL'
      | 'DISPLAY'
      | 'INDEX'
      | 'MONITOR-POINTER'
      | 'MUTEX-POINTER'
      | 'NATIONAL'
      | ( 'OBJECT'
        'REFERENCE'
        ( ( ( ( ( 'FACTORY'
          'OF'
        ) )?
          'ACTIVE-CLASS'
        )
        | ( ( ( 'FACTORY'
          'OF'
        ) )?
          className
          ( ( 'ONLY'
          | 'EVENT'
          ) )?
        )
        ) )?
      )
      | 'OBJECT'
      | 'PACKED-DECIMAL'
      | 'POINTER'
      | 'PROCEDURE-POINTER'
      | ( 'PROGRAM-POINTER'
        ( ( ( 'TO' )?
          programName
        ) )?
      )
      | 'SEMAPHORE-POINTER'
      | 'SIGNED-INT'
      | 'SIGNED-LONG'
      | 'SIGNED-SHORT'
      | 'UNSIGNED-INT'
      | 'UNSIGNED-LONG'
      | 'UNSIGNED-SHORT'
      | 'STRING'
      | 'THREAD-POINTER'
      | typedefName
      | className
      )
    )
  ;

// ========================================================
// valueClause
// ........................................................

valueClause
  : ^(VALUE_CLAUSE
      ( valueClause_format2
      | valueClause_format1
      )
    )
  ;

// ========================================================
// valueClause_start
// ........................................................

valueClause_start
  : ^(VALUE_CLAUSE_START
      ( ( 'VALUE'
        ( 'IS' )?
      )
      | ( 'VALUES'
        ( 'ARE' )?
      )
      )
    )
  ;

// ========================================================
// valueClause_format1
// ........................................................

valueClause_format1
  : ^(VALUE_CLAUSE_FORMAT1
      ( valueClause_start
        ( literal
        | constant
        )
      )
    )
  ;

// ========================================================
// valueClause_format2
// ........................................................

valueClause_format2
  : ^(VALUE_CLAUSE_FORMAT2
      ( valueClause_start
        ( ( ( literal )+
          'FROM'
          '('
          ( subscript )+
          ')'
          ( ( 'TO'
            '('
            ( subscript )+
            ')'
          ) )?
        ) )+
      )
    )
  ;

// ========================================================
// valueIsOperand
// ........................................................

valueIsOperand
  : ^(VALUE_IS_OPERAND
      ( 'NEXT'
      | ( 'START'
        ( 'OF' )?
        dataName
      )
      | ( 'LENGTH'
        ( 'OF' )?
        dataName
      )
      | arithmeticExpression
      | literal
      )
    )
  ;

// ========================================================
// valueIsOperator
// ........................................................

valueIsOperator
  : ^(VALUE_IS_OPERATOR
      ( 'AND'
      | 'OR'
      | '&'
      | '+'
      | '-'
      | '*'
      | '/'
      )
    )
  ;

// ========================================================
// based
// ........................................................

based
  : ^(BASED
      'BASED'
    )
  ;

// ========================================================
// propertyClause
// ........................................................

propertyClause
  : ^(PROPERTY_CLAUSE
      ( 'PROPERTY'
        ( ( ( 'WITH' )?
          'NO'
          ( 'GET'
          | 'SET'
          )
        ) )?
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
        ( mnemonicName )?
        ( usingOrChainingPhrase )?
        ( returningProcedurePhrase )?
        '.'
        ( declaratives )?
        ( sentence )*
        ( paragraph )*
        ( section )*
      )
    )
  ;

// ========================================================
// usingOrChainingPhrase
// ........................................................

usingOrChainingPhrase
  : ^(USING_OR_CHAINING_PHRASE
      ( ( 'USING'
      | 'CHAINING'
      | 'GIVING'
      )
        ( ( dataReference
        | dataValue
        | dataOutput
        ) )+
        ( repeatedPhrase )?
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
        ( ( 'ANY'
        | ( ( 'OPTIONAL' )?
          dataName
          ( ( 'DELIMITED'
            ( ( 'BY'
              'SIZE'
            ) )?
          ) )?
          ( ( 'AS'
            typeName
            ( attributeClause )?
          ) )?
        )
        | typedefName
        ) )+
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
        ( ( 'ANY'
        | ( dataName
          ( ( 'AS'
            typeName
            ( attributeClause )?
          ) )?
        )
        | typedefName
        ) )+
      )
    )
  ;

// ========================================================
// dataOutput
// ........................................................

dataOutput
  : ^(DATA_OUTPUT
      ( ( 'BY' )?
        'OUTPUT'
        ( ( dataName
          'AS'
          typeName
          ( attributeClause )?
        ) )*
      )
    )
  ;

// ========================================================
// repeatedPhrase
// ........................................................

repeatedPhrase
  : ^(REPEATED_PHRASE
      ( 'REPEATED'
        ( ( integer
          'TO'
          integer
        ) )?
      )
    )
  ;

// ========================================================
// returningProcedurePhrase
// ........................................................

returningProcedurePhrase
  : ^(RETURNING_PROCEDURE_PHRASE
      ( ( 'RETURNING'
      | 'YIELDING'
      | 'GIVING'
      )
        dataName
        ( ( 'AS'
          typeName
          ( attributeClause )?
        ) )?
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
        ( declarativeSection )*
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
        ( sentence )*
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
      ( compilerStatement
      | ( statement
        ( ( compilerStatement
        | statement
        | continuationOfStatement
        ) )*
        '.'
      )
      | '.'
      )
    )
  ;

// ========================================================
// statement
// ........................................................

statement
  : ^(STATEMENT
      ( acceptStatement
      | addStatement
      | alterStatement
      | callStatement
      | chainStatement
      | cancelStatement
      | closeStatement
      | commitStatement
      | computeStatement
      | continueStatement
      | deleteFileStatement
      | deleteStatement
      | disableStatement
      | divideStatement
      | enableStatement
      | entryStatement
      | evaluateStatement
      | examineStatement
      | execStatement
      | exhibitStatement
      | exitStatement
      | generateStatement
      | gobackStatement
      | goToStatement
      | identifiedByStatement
      | ifStatement
      | initiateStatement
      | invokeStatement
      | mergeStatement
      | moveStatement
      | multiplyStatement
      | nextSentenceStatement
      | onStatement
      | openStatement
      | performStatement
      | raiseStatement
      | readStatement
      | readyTraceStatement
      | receiveStatement
      | releaseStatement
      | resetTraceStatement
      | returnStatement
      | rewriteStatement
      | rollbackStatement
      | purgeStatement
      | searchStatement
      | sendStatement
      | serviceStatement
      | sortStatement
      | startStatement
      | stopStatement
      | stringStatement
      | subtractStatement
      | suppressStatement
      | terminateStatement
      | transformStatement
      | unlockStatement
      | unstringStatement
      | waitStatement
      | writeStatement
      | xmlGenerateStatement
      | xmlParseStatement
      | setStatement
      | initializeStatement
      | displayStatement
      | inspectStatement
      | allocateStatement
      | freeStatement
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
// retryPhrase
// ........................................................

retryPhrase
  : ^(RETRY_PHRASE
      ( 'RETRY'
        ( ( ( identifier
        | integer
        )
          'TIMES'
        )
        | ( 'FOR'
          ( identifier
          | integer
          )
          'SECONDS'
        )
        | 'FOREVER'
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
      | 'END-CHAIN'
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
      | 'END-WAIT'
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
      | 'ALTER'
      | 'CALL'
      | 'CANCEL'
      | 'CHAIN'
      | 'CLOSE'
      | 'COMMIT'
      | 'CONTINUE'
      | 'DELETE'
      | 'DIVIDE'
      | 'EJECT'
      | 'ENTRY'
      | 'EVALUATE'
      | 'EXEC'
      | 'EXIT'
      | 'GENERATE'
      | 'GOBACK'
      | 'GO'
      | 'IDENTIFIED'
      | 'IF'
      | 'INITIATE'
      | 'INVOKE'
      | 'MERGE'
      | 'MOVE'
      | 'MULTIPLY'
      | ( 'NEXT'
        'SENTENCE'
      )
      | 'OPEN'
      | 'PERFORM'
      | 'RAISE'
      | 'READ'
      | ( 'READY'
        'TRACE'
      )
      | 'RELEASE'
      | 'REPLACE'
      | ( 'RESET'
        'TRACE'
      )
      | 'RETURN'
      | 'REWRITE'
      | 'ROLLBACK'
      | 'SEARCH'
      | 'SERVICE'
      | 'SKIP1'
      | 'SKIP2'
      | 'SKIP3'
      | 'SORT'
      | 'STOP'
      | 'STRING'
      | 'SUBTRACT'
      | 'SUPPRESS'
      | 'TERMINATE'
      | 'TITLE'
      | 'UNSTRING'
      | 'WAIT'
      | 'WRITE'
      | ( 'XML'
        'GENERATE'
      )
      | ( 'XML'
        'PARSE'
      )
      | 'SET'
      | 'INITIALIZE'
      | 'DISPLAY'
      | 'COMPUTE'
      | 'INSPECT'
      | 'ACCEPT'
      | 'ALLOCATE'
      | 'FREE'
      | 'ENABLE'
      | 'DISABLE'
      | 'SEND'
      | 'RECEIVE'
      | 'PURGE'
      | 'START'
      | 'USE'
      )
    )
  ;

// ========================================================
// acceptStatement
// ........................................................

acceptStatement
  : ^(ACCEPT_STATEMENT
      ( 'ACCEPT'
        ( acceptFromDate
        | acceptFromOther
        | acceptFromMnemonic
        | acceptMessageCount
        | acceptScreenFormat
        )
        ( 'END-ACCEPT' )?
      )
    )
  ;

// ========================================================
// acceptFromMnemonic
// ........................................................

acceptFromMnemonic
  : ^(ACCEPT_FROM_MNEMONIC
      ( identifier_format2
        'FROM'
        mnemonicName
        ( ( onException
        | onEscape
        ) )?
        ( ( notOnException
        | notOnEscape
        ) )?
      )
    )
  ;

// ========================================================
// acceptFromOther
// ........................................................

acceptFromOther
  : ^(ACCEPT_FROM_OTHER
      ( identifier_format2
        'FROM'
        ( 'TERMINAL-INFO'
        | 'SYSTEM-INFO'
        | ( 'INPUT'
          'STATUS'
        )
        | ( 'ESCAPE'
          'KEY'
        )
        | ( 'EXCEPTION'
          'STATUS'
        )
        | ( 'LINE'
          'NUMBER'
        )
        | ( 'USER'
          'NAME'
        )
        | 'COMMAND-LINE'
        | ( 'STANDARD'
          'OBJECT'
          identifier
        )
        | ( 'THREAD'
          'HANDLE'
        )
        | ( 'WINDOW'
          'HANDLE'
        )
        )
      )
    )
  ;

// ========================================================
// acceptScreenFormat
// ........................................................

acceptScreenFormat
  : ^(ACCEPT_SCREEN_FORMAT
      ( ( 'OMITTED'
      | identifier
      )
        ( unitPhrase )?
        ( ( dtLineColPositioning
        | dtAtPositioning
        ) )?
        ( ( 'FROM'
          'CRT'
        ) )?
        ( modeIsBlockPhrase )?
        ( ( 'WITH'
          ( screenEntryPhrase )+
        ) )?
        ( ( onException
        | onEscape
        ) )?
        ( ( notOnException
        | notOnEscape
        ) )?
      )
    )
  ;

// ========================================================
// acceptFromDate
// ........................................................

acceptFromDate
  : ^(ACCEPT_FROM_DATE
      ( identifier_format2
        'FROM'
        ( ( 'DATE'
          ( ( 'YYYYMMDD'
          | 'CENTURY-DATE'
          ) )?
        )
        | ( 'DAY'
          ( ( 'YYYYDDD'
          | 'CENTURY-DAY'
          ) )?
        )
        | 'DAY-OF-WEEK'
        | 'TIME'
        | 'YEAR'
        | 'YYYYMMDD'
        | 'CENTURY-DATE'
        | 'YYYYDDD'
        | 'CENTURY-DAY'
        )
      )
    )
  ;

// ========================================================
// acceptMessageCount
// ........................................................

acceptMessageCount
  : ^(ACCEPT_MESSAGE_COUNT
      ( identifier
        ( 'MESSAGE' )?
        'COUNT'
      )
    )
  ;

// ========================================================
// unitPhrase
// ........................................................

unitPhrase
  : ^(UNIT_PHRASE
      ( 'UNIT'
        ( identifier
        | literal
        )
      )
    )
  ;

// ========================================================
// modeIsBlockPhrase
// ........................................................

modeIsBlockPhrase
  : ^(MODE_IS_BLOCK_PHRASE
      ( 'MODE'
        ( 'IS' )?
        'BLOCK'
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
        qualifiedDataName
        'TO'
        qualifiedDataName
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
        ( ( qualifiedDataName
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
// allocateStatement
// ........................................................

allocateStatement
  : ^(ALLOCATE_STATEMENT
      ( 'ALLOCATE'
        ( ( arithmeticExpression
          'CHARACTERS'
        )
        | qualifiedDataName
        )
        ( 'INITIALIZED' )?
        ( ( 'RETURNING'
          qualifiedDataName
        ) )?
      )
    )
  ;

// ========================================================
// alterStatement
// ........................................................

alterStatement
  : ^(ALTER_STATEMENT
      ( 'ALTER'
        ( ( procedureName
          'TO'
          ( ( 'PROCEED'
            'TO'
          ) )?
          procedureName
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
        ( 'NESTED'
        | ( mnemonicName
          ( alphanumericLiteral
          | identifier
          )
        )
        | ( ( alphanumericLiteral
        | identifier
        )
          ( ( 'AS'
            ( 'NESTED'
            | programName
            )
          ) )?
        )
        )
        ( callUsing )?
        ( callGivingOrReturning )?
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
        ( ( ( ( ( ( 'BY' )?
          'REFERENCE'
        ) )?
          ( ( 'ADDRESS'
            'OF'
            identifier
          )
          | 'OMITTED'
          | identifier
          | literal
          )
        )
        | ( ( 'BY' )?
          'CONTENT'
          ( ( 'LENGTH'
            'OF'
            identifier
          )
          | arithmeticExpression
          | identifier
          | literal
          )
        )
        | ( ( 'BY' )?
          'VALUE'
          ( ( 'LENGTH'
            'OF'
            identifier
            ( ( 'SIZE'
              ( 'IS' )?
              ( ( ( 'LENGTH'
                'OF'
                identifier
              )
              | integer
              ) )?
            ) )?
          )
          | ( integer
            'SIZE'
            ( 'IS' )?
            ( ( ( 'LENGTH'
              'OF'
              identifier
            )
            | integer
            ) )?
          )
          | arithmeticExpression
          | identifier
          | literal
          )
        )
        ) )+
      )
    )
  ;

// ========================================================
// callGivingOrReturning
// ........................................................

callGivingOrReturning
  : ^(CALL_GIVING_OR_RETURNING
      ( ( 'GIVING'
      | 'RETURNING'
      )
        ( ( 'INTO'
        | ( 'ADDRESS'
          'OF'
        )
        ) )?
        identifier
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
// onEscape
// ........................................................

onEscape
  : ^(ON_ESCAPE
      ( ( 'ON' )?
        'ESCAPE'
        nestedStatements
      )
    )
  ;

// ========================================================
// notOnEscape
// ........................................................

notOnEscape
  : ^(NOT_ON_ESCAPE
      ( 'NOT'
        ( 'ON' )?
        'ESCAPE'
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
// chainStatement
// ........................................................

chainStatement
  : ^(CHAIN_STATEMENT
      ( 'CHAIN'
        ( identifier
        | literal
        )
        ( chainUsing )?
        ( 'END-CHAIN' )?
      )
    )
  ;

// ========================================================
// chainUsing
// ........................................................

chainUsing
  : ^(CHAIN_USING
      ( 'USING'
        ( ( literal
        | identifier
        ) )*
        ( ( ( ( 'BY' )?
          'REFERENCE'
          ( ( ( ( ( 'ADDRESS'
            'OF'
          ) )?
            identifier
          )
          | 'OMITTED'
          | literal
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
          ( ( ( ( ( 'LENGTH'
            'OF'
          ) )?
            identifier
          )
          | ( integer
            ( ( 'SIZE'
              ( 'IS' )?
              integer
            ) )?
          )
          | literal
          ) )+
        )
        ) )*
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
// commitStatement
// ........................................................

commitStatement
  : ^(COMMIT_STATEMENT
      'COMMIT'
    )
  ;

// ========================================================
// computeStatement
// ........................................................

computeStatement
  : ^(COMPUTE_STATEMENT
      ( 'COMPUTE'
        ( ( qualifiedDataName
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
// continueStatement
// ........................................................

continueStatement
  : ^(CONTINUE_STATEMENT
      'CONTINUE'
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
// deleteFileStatement
// ........................................................

deleteFileStatement
  : ^(DELETE_FILE_STATEMENT
      ( 'DELETE'
        'FILE'
        ( fileName )+
      )
    )
  ;

// ========================================================
// disableStatement
// ........................................................

disableStatement
  : ^(DISABLE_STATEMENT
      ( 'DISABLE'
        ( ( 'INPUT'
          ( 'TERMINAL' )?
        )
        | ( 'I-O'
          'TERMINAL'
        )
        | 'OUTPUT'
        )
        cdName
        ( 'WITH' )?
        'KEY'
        ( literal
        | identifier
        )
      )
    )
  ;

// ========================================================
// displayStatement
// ........................................................

displayStatement
  : ^(DISPLAY_STATEMENT
      ( 'DISPLAY'
        ( displayTerminalFormat
        | displayDeviceFormat
        )
        ( 'END-DISPLAY' )?
      )
    )
  ;

// ========================================================
// displayDeviceFormat
// ........................................................

displayDeviceFormat
  : ^(DISPLAY_DEVICE_FORMAT
      ( ( ( identifier
      | literal
      ) )+
        ( uponClause )?
        ( withNoAdvancing )?
        ( onException )?
        ( notOnException )?
      )
    )
  ;

// ========================================================
// uponClause
// ........................................................

uponClause
  : ^(UPON_CLAUSE
      ( 'UPON'
        ( 'ARGUMENT-NUMBER'
        | 'COMMAND-LINE'
        | 'ENVIRONMENT-VALUE'
        | 'ENVIRONMENT-NAME'
        | environmentName
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
      ( ( ( 'OMITTED'
      | identifier
      | literal
      )
        ( ( 'UNIT'
          ( identifier
          | literal
          )
        ) )?
        ( dtAtPositioning
        | dtLineColPositioning
        )
        ( uponClause )?
        ( modeIsBlockPhrase )?
        ( ( ( 'WITH' )?
          ( screenEntryPhrase )+
        ) )?
      ) )+
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
      ( ( ( 'AT'
      | 'FROM'
      ) )?
        ( ( dtLinePos
          ( dtColPos )?
        )
        | ( dtColPos
          ( dtLinePos )?
        )
        )
      )
    )
  ;

// ========================================================
// dtLinePos
// ........................................................

dtLinePos
  : ^(DT_LINE_POS
      ( 'LINE'
        ( 'NUMBER' )?
        ( 'IS' )?
        ( ( 'PLUS'
        | '+'
        | '-'
        ) )?
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
      | 'POS'
      )
        ( 'NUMBER' )?
        ( 'IS' )?
        ( ( 'PLUS'
        | '+'
        | '-'
        ) )?
        ( identifier
        | literal
        )
      )
    )
  ;

// ========================================================
// screenEntryPhrase
// ........................................................

screenEntryPhrase
  : ^(SCREEN_ENTRY_PHRASE
      ( autoPhrase
      | beepPhrase
      | blankPhrase
      | blankWhenZero
      | blinkPhrase
      | boldPhrase
      | capitalizationPhrase
      | controlPhrase
      | convertPhrase
      | cursorPhrase
      | echoPhrase
      | erasePhrase
      | fillPhrase
      | fullPhrase
      | gridPhrase
      | justificationPhrase
      | justified
      | highPhrase
      | lowPhrase
      | linePhrase
      | offPhrase
      | picture
      | promptPhrase
      | requiredPhrase
      | reversePhrase
      | scrollPhrase
      | securePhrase
      | sizePhrase
      | standardPhrase
      | foregroundPhrase
      | backgroundPhrase
      | timeoutPhrase
      | trailingSignPhrase
      | tabPhrase
      | timePhrase
      | updatePhrase
      )
    )
  ;

// ========================================================
// autoPhrase
// ........................................................

autoPhrase
  : ^(AUTO_PHRASE
      ( 'AUTO'
      | 'AUTO-SKIP'
      )
    )
  ;

// ========================================================
// backgroundPhrase
// ........................................................

backgroundPhrase
  : ^(BACKGROUND_PHRASE
      ( ( 'BACKGROUND-COLOR'
      | 'BACKGROUND-COLOUR'
      )
        ( 'IS' )?
        integer
      )
    )
  ;

// ========================================================
// beepPhrase
// ........................................................

beepPhrase
  : ^(BEEP_PHRASE
      ( ( 'NO' )?
        ( 'BEEP'
        | 'BELL'
        )
      )
    )
  ;

// ========================================================
// blankPhrase
// ........................................................

blankPhrase
  : ^(BLANK_PHRASE
      ( 'BLANK'
        ( 'SCREEN'
        | 'LINE'
        )
      )
    )
  ;

// ========================================================
// blinkPhrase
// ........................................................

blinkPhrase
  : ^(BLINK_PHRASE
      ( 'BLINKING'
      | 'BLINK'
      )
    )
  ;

// ========================================================
// boldPhrase
// ........................................................

boldPhrase
  : ^(BOLD_PHRASE
      'BOLD'
    )
  ;

// ========================================================
// capitalizationPhrase
// ........................................................

capitalizationPhrase
  : ^(CAPITALIZATION_PHRASE
      ( 'UPPER'
      | 'LOWER'
      )
    )
  ;

// ========================================================
// controlPhrase
// ........................................................

controlPhrase
  : ^(CONTROL_PHRASE
      ( 'CONTROL'
        ( 'IS' )?
        ( identifier_format2
        | literal
        )
      )
    )
  ;

// ========================================================
// convertPhrase
// ........................................................

convertPhrase
  : ^(CONVERT_PHRASE
      ( 'CONVERT'
      | 'CONVERSION'
      )
    )
  ;

// ========================================================
// cursorPhrase
// ........................................................

cursorPhrase
  : ^(CURSOR_PHRASE
      ( 'CURSOR'
        ( identifier
        | literal
        )
      )
    )
  ;

// ========================================================
// echoPhrase
// ........................................................

echoPhrase
  : ^(ECHO_PHRASE
      'ECHO'
    )
  ;

// ========================================================
// erasePhrase
// ........................................................

erasePhrase
  : ^(ERASE_PHRASE
      ( 'ERASE'
        ( ( 'EOL'
        | 'EOS'
        ) )?
      )
    )
  ;

// ========================================================
// foregroundPhrase
// ........................................................

foregroundPhrase
  : ^(FOREGROUND_PHRASE
      ( ( 'FOREGROUND-COLOR'
      | 'FOREGROUND-COLOUR'
      )
        ( 'IS' )?
        integer
      )
    )
  ;

// ========================================================
// fullPhrase
// ........................................................

fullPhrase
  : ^(FULL_PHRASE
      ( 'FULL'
      | 'LENGTH-CHECK'
      )
    )
  ;

// ========================================================
// gridPhrase
// ........................................................

gridPhrase
  : ^(GRID_PHRASE
      'GRID'
    )
  ;

// ========================================================
// highPhrase
// ........................................................

highPhrase
  : ^(HIGH_PHRASE
      ( 'HIGH'
      | 'HIGHLIGHT'
      )
    )
  ;

// ========================================================
// linePhrase
// ........................................................

linePhrase
  : ^(LINE_PHRASE
      ( 'LEFTLINE'
      | 'OVERLINE'
      | 'UNDERLINE'
      )
    )
  ;

// ========================================================
// lowPhrase
// ........................................................

lowPhrase
  : ^(LOW_PHRASE
      ( 'LOW'
      | 'LOWLIGHT'
      )
    )
  ;

// ========================================================
// offPhrase
// ........................................................

offPhrase
  : ^(OFF_PHRASE
      'OFF'
    )
  ;

// ========================================================
// promptPhrase
// ........................................................

promptPhrase
  : ^(PROMPT_PHRASE
      ( 'PROMPT'
        ( ( ( 'CHARACTER'
          ( 'IS' )?
          identifier
        )
        | ( ( 'CHARACTER' )?
          ( 'IS' )?
          literal
        )
        ) )?
      )
    )
  ;

// ========================================================
// requiredPhrase
// ........................................................

requiredPhrase
  : ^(REQUIRED_PHRASE
      ( 'REQUIRED'
      | 'EMPTY-CHECK'
      )
    )
  ;

// ========================================================
// reversePhrase
// ........................................................

reversePhrase
  : ^(REVERSE_PHRASE
      ( 'REVERSE'
      | 'REVERSED'
      | 'REVERSE-VIDEO'
      )
    )
  ;

// ========================================================
// scrollPhrase
// ........................................................

scrollPhrase
  : ^(SCROLL_PHRASE
      ( 'SCROLL'
        ( 'UP'
        | 'DOWN'
        )
        ( ( ( 'BY' )?
          ( integer
          | identifier
          )
          ( 'LINE'
          | 'LINES'
          )
        ) )?
      )
    )
  ;

// ========================================================
// securePhrase
// ........................................................

securePhrase
  : ^(SECURE_PHRASE
      ( 'SECURE'
      | 'NO-ECHO'
      )
    )
  ;

// ========================================================
// sizePhrase
// ........................................................

sizePhrase
  : ^(SIZE_PHRASE
      ( 'SIZE'
        ( 'IS' )?
        ( identifier
        | literal
        )
      )
    )
  ;

// ========================================================
// standardPhrase
// ........................................................

standardPhrase
  : ^(STANDARD_PHRASE
      'STANDARD'
    )
  ;

// ========================================================
// tabPhrase
// ........................................................

tabPhrase
  : ^(TAB_PHRASE
      'TAB'
    )
  ;

// ========================================================
// timePhrase
// ........................................................

timePhrase
  : ^(TIME_PHRASE
      ( ( 'BEFORE' )?
        'TIME'
        ( identifier
        | literal
        )
      )
    )
  ;

// ========================================================
// timeoutPhrase
// ........................................................

timeoutPhrase
  : ^(TIMEOUT_PHRASE
      ( ( 'TIME-OUT'
      | 'TIMEOUT'
      )
        'AFTER'
        ( identifier
        | integer
        )
      )
    )
  ;

// ========================================================
// justificationPhrase
// ........................................................

justificationPhrase
  : ^(JUSTIFICATION_PHRASE
      ( 'LEFT-JUSTIFY'
      | 'RIGHT-JUSTIFY'
      )
    )
  ;

// ========================================================
// fillPhrase
// ........................................................

fillPhrase
  : ^(FILL_PHRASE
      ( 'SPACE-FILL'
      | 'ZERO-FILL'
      )
    )
  ;

// ========================================================
// trailingSignPhrase
// ........................................................

trailingSignPhrase
  : ^(TRAILING_SIGN_PHRASE
      'TRAILING-SIGN'
    )
  ;

// ========================================================
// updatePhrase
// ........................................................

updatePhrase
  : ^(UPDATE_PHRASE
      'UPDATE'
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
        qualifiedDataName
        ( 'ROUNDED' )?
        'REMAINDER'
        qualifiedDataName
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
        ( ( qualifiedDataName
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
        ( ( qualifiedDataName
          ( 'ROUNDED' )?
        ) )+
      )
    )
  ;

// ========================================================
// enableStatement
// ........................................................

enableStatement
  : ^(ENABLE_STATEMENT
      ( 'ENABLE'
        ( ( 'INPUT'
          ( 'TERMINAL' )?
        )
        | ( 'I-O'
          'TERMINAL'
        )
        | 'OUTPUT'
        )
        cdName
        ( 'WITH' )?
        'KEY'
        ( literal
        | identifier
        )
      )
    )
  ;

// ========================================================
// entryStatement
// ........................................................

entryStatement
  : ^(ENTRY_STATEMENT
      ( 'ENTRY'
        literal
        ( mnemonicName )?
        ( ( 'USING'
          ( ( ( ( ( 'BY' )?
            ( 'REFERENCE'
            | 'VALUE'
            )
          ) )?
            ( 'ANY'
            | ( dataName
              ( ( 'DELIMITED'
                ( ( 'BY'
                  'SIZE'
                ) )?
              ) )?
            )
            )
          ) )+
          ( ( 'REPEATED'
            ( ( integer
              'TO'
              integer
            ) )?
          ) )?
        ) )?
        ( ( ( 'GIVING'
        | 'RETURNING'
        )
          dataName
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
      | arithmeticExpression
      | identifier
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
        ( arithmeticExpression
        | identifier
        | literal
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
        ( arithmeticExpression
        | identifier
        | literal
        )
        ( 'THROUGH'
        | 'THRU'
        )
        ( arithmeticExpression
        | identifier
        | literal
        )
      )
    )
  ;

// ========================================================
// examineStatement
// ........................................................

examineStatement
  : ^(EXAMINE_STATEMENT
      ( 'EXAMINE'
        identifier
        ( ( 'TALLYING'
          ( ( 'UNTIL'
            'FIRST'
          )
          | 'ALL'
          | 'LEADING'
          )
          literal
          ( ( 'REPLACING'
            'BY'
            literal
          ) )?
        )
        | ( 'REPLACING'
          ( 'ALL'
          | 'LEADING'
          | 'FIRST'
          | ( 'UNTIL'
            'FIRST'
          )
          )
          literal
          'BY'
          literal
        )
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
      | execDLIStatement
      | execHTMLStatement
      | execTextDataStatement
      )
    )
  ;

// ========================================================
// execSQLStatement
// ........................................................

execSQLStatement
  : ^(EXEC_S_Q_L_STATEMENT
      ( ( 'EXEC'
      | 'EXECUTE'
      )
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
      ( ( 'EXEC'
      | 'EXECUTE'
      )
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
// execDLIStatement
// ........................................................

execDLIStatement
  : ^(EXEC_D_L_I_STATEMENT
      ( ( 'EXEC'
      | 'EXECUTE'
      )
        'DLI'
        (water)?
        'END-EXEC'
      )
    )
  ;

// ========================================================
// execHTMLStatement
// ........................................................

execHTMLStatement
  : ^(EXEC_H_T_M_L_STATEMENT
      ( ( 'EXEC'
      | 'EXECUTE'
      )
        'HTML'
        (water)?
        'END-EXEC'
      )
    )
  ;

// ========================================================
// execTextDataStatement
// ........................................................

execTextDataStatement
  : ^(EXEC_TEXT_DATA_STATEMENT
      ( ( 'EXEC'
      | 'EXECUTE'
      )
        textName
        (water)?
        'END-EXEC'
      )
    )
  ;

// ========================================================
// exitStatement
// ........................................................

exitStatement
  : ^(EXIT_STATEMENT
      ( 'EXIT'
        ( ( ( 'PROGRAM'
          ( returningPhrase )?
        )
        | 'PARAGRAPH'
        | 'SECTION'
        | ( 'PERFORM'
          ( 'CYCLE' )?
        )
        | 'METHOD'
        | 'FUNCTION'
        | 'ITERATOR'
        ) )?
      )
    )
  ;

// ========================================================
// returningPhrase
// ........................................................

returningPhrase
  : ^(RETURNING_PHRASE
      ( ( 'GIVING'
      | 'RETURNING'
      )
        ( integer
        | ( 'ADDRESS'
          'OF'
          identifier
        )
        )
      )
    )
  ;

// ========================================================
// generateStatement
// ........................................................

generateStatement
  : ^(GENERATE_STATEMENT
      ( 'GENERATE'
        ( dataName
        | reportName
        )
      )
    )
  ;

// ========================================================
// freeStatement
// ........................................................

freeStatement
  : ^(FREE_STATEMENT
      ( 'FREE'
        ( ( ( ( 'ADDRESS'
          ( 'OF' )?
        ) )?
          qualifiedDataName
        ) )+
      )
    )
  ;

// ========================================================
// gobackStatement
// ........................................................

gobackStatement
  : ^(GOBACK_STATEMENT
      ( 'GOBACK'
        ( ( ( 'GIVING'
        | 'RETURNING'
        )
          ( ( ( ( 'ADDRESS'
            'OF'
          ) )?
            identifier
          )
          | integer
          )
        ) )?
      )
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
// initiateStatement
// ........................................................

initiateStatement
  : ^(INITIATE_STATEMENT
      ( 'INITIATE'
        ( reportName )+
      )
    )
  ;

// ========================================================
// invokeStatement
// ........................................................

invokeStatement
  : ^(INVOKE_STATEMENT
      ( 'INVOKE'
        identifier
        ( ( 'AS'
          ( 'OBJECT'
          | identifier
          )
        ) )?
        ( literal
        | identifier
        )
        ( ( 'USING'
          ( ( ( ( ( ( 'BY' )?
            'REFERENCE'
          ) )?
            ( ( 'ADDRESS'
              'OF'
              identifier
            )
            | 'OMITTED'
            | literal
            | identifier
            )
          )
          | ( ( 'BY' )?
            'CONTENT'
            ( ( 'LENGTH'
              'OF'
              identifier
            )
            | arithmeticExpression
            | literal
            | identifier
            )
          )
          | ( ( 'BY' )?
            'VALUE'
            ( ( 'LENGTH'
              'OF'
              identifier
            )
            | ( integer
              'SIZE'
              ( 'IS' )?
              integer
            )
            | arithmeticExpression
            | integer
            | identifier
            )
          )
          ) )+
        ) )?
        ( ( ( 'GIVING'
        | 'RETURNING'
        )
          ( ( 'INTO'
          | ( 'ADDRESS'
            'OF'
          )
          ) )?
          identifier
        ) )?
      )
    )
  ;

// ========================================================
// exhibitStatement
// ........................................................

exhibitStatement
  : ^(EXHIBIT_STATEMENT
      ( 'EXHIBIT'
        ( 'NAMED'
        | ( 'CHANGED'
          'NAMED'
        )
        | 'CHANGED'
        )
        ( identifier
        | literal
        )
      )
    )
  ;

// ========================================================
// identifiedByStatement
// ........................................................

identifiedByStatement
  : ^(IDENTIFIED_BY_STATEMENT
      ( 'IDENTIFIED'
        ( 'BY' )?
        ( dataName
        | literal
        )
        ( ( ( 'IS' )?
          'ATTRIBUTE'
        ) )?
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
        ( ( qualifiedDataName
          'FOR'
          ( ( tallyingCharactersPhrase
          | tallyingAllLeadingOrTrailingPhrase
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
// tallyingAllLeadingOrTrailingPhrase
// ........................................................

tallyingAllLeadingOrTrailingPhrase
  : ^(TALLYING_ALL_LEADING_OR_TRAILING_PHRASE
      ( ( 'ALL'
      | 'LEADING'
      | 'TRAILING'
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
        | replacingAllLeadingFirstOrTrailingPhrase
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
// replacingAllLeadingFirstOrTrailingPhrase
// ........................................................

replacingAllLeadingFirstOrTrailingPhrase
  : ^(REPLACING_ALL_LEADING_FIRST_OR_TRAILING_PHRASE
      ( ( 'ALL'
      | 'LEADING'
      | 'FIRST'
      | 'TRAILING'
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
// mergeStatement
// ........................................................

mergeStatement
  : ^(MERGE_STATEMENT
      ( 'MERGE'
        fileName
        ( ( ( 'ON' )?
          ( 'ASCENDING'
          | 'DESCENDING'
          )
          ( 'KEY' )?
          ( 'IS' )?
          ( dataName )+
        ) )+
        ( ( ( 'COLLATING' )?
          'SEQUENCE'
          ( 'IS' )?
          alphabetName
        ) )?
        'USING'
        fileName
        ( fileName )+
        ( ( 'OUTPUT'
          'PROCEDURE'
          ( 'IS' )?
          procedureName
          ( ( ( 'THROUGH'
          | 'THRU'
          )
            procedureName
          ) )?
        )
        | ( 'GIVING'
          ( fileName )+
        )
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
        (water)?
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
        ( ( qualifiedDataName
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
        ( ( qualifiedDataName
          ( 'ROUNDED' )?
        ) )+
      )
    )
  ;

// ========================================================
// nextSentenceStatement
// ........................................................

nextSentenceStatement
  : ^(NEXT_SENTENCE_STATEMENT
      ( 'NEXT'
        'SENTENCE'
      )
    )
  ;

// ========================================================
// onStatement
// ........................................................

onStatement
  : ^(ON_STATEMENT
      ( 'ON'
        ( literal
        | identifier
        )
        ( ( 'AND'
          'EVERY'
          ( literal
          | identifier
          )
        ) )?
        ( ( 'UNTIL'
          ( literal
          | identifier
          )
        ) )?
        ( nestedStatements
        | ( 'NEXT'
          'SENTENCE'
        )
        )
        ( ( ( 'ELSE'
        | 'OTHERWISE'
        )
          ( nestedStatements
          | ( 'NEXT'
            'SENTENCE'
          )
          )
        ) )?
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
          ( ( nestedStatements
            'END-PERFORM'
          )
          | statement
          | 'END-PERFORM'
          )
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
        | ( 'VARYING'
          identifier
          'THROUGH'
          identifier
          nestedStatements
          'END-PERFORM'
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
// until
// ........................................................

until
  : ^(UNTIL
      ( ( testPosition )?
        'UNTIL'
        ( condition
        | 'EXIT'
        )
      )
    )
  ;

// ========================================================
// varying
// ........................................................

varying
  : ^(VARYING
      ( ( testPosition )?
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
// purgeStatement
// ........................................................

purgeStatement
  : ^(PURGE_STATEMENT
      ( 'PURGE'
        cdName
      )
    )
  ;

// ========================================================
// raiseStatement
// ........................................................

raiseStatement
  : ^(RAISE_STATEMENT
      ( 'RAISE'
        ( identifier )?
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
        ( ( 'NEXT'
        | 'PREVIOUS'
        ) )?
        ( 'RECORD' )?
        ( ( 'INTO'
          identifier_format2
        ) )?
        ( ( ( 'ADVANCING'
          ( 'ON' )?
          'LOCK'
        )
        | ( 'IGNORING'
          'LOCK'
        )
        | ( ( 'WITH' )?
          ( ( ( ( 'KEPT'
          | 'NO'
          | 'IGNORE'
          ) )?
            'LOCK'
          )
          | 'WAIT'
          )
        )
        | retryPhrase
        ) )?
        ( ( 'KEY'
          ( 'IS' )?
          qualifiedDataName
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
// readWithClause
// ........................................................

readWithClause
  : ^(READ_WITH_CLAUSE
      ( ( 'WITH' )?
        ( readLockClause
        | 'WAIT'
        )
      )
    )
  ;

// ========================================================
// readLockClause
// ........................................................

readLockClause
  : ^(READ_LOCK_CLAUSE
      ( ( ( 'KEPT'
      | 'NO'
      | 'IGNORE'
      ) )?
        'LOCK'
      )
    )
  ;

// ========================================================
// readyTraceStatement
// ........................................................

readyTraceStatement
  : ^(READY_TRACE_STATEMENT
      ( 'READY'
        'TRACE'
        ( '.' )?
      )
    )
  ;

// ========================================================
// receiveStatement
// ........................................................

receiveStatement
  : ^(RECEIVE_STATEMENT
      ( 'RECEIVE'
        ( ( dataName
          'FROM'
          ( ( 'THREAD'
            dataName
          )
          | ( 'LAST'
            'THREAD'
          )
          | ( 'ANY'
            'THREAD'
          )
          )
          ( ( ( 'BEFORE'
            ( 'TIME' )?
            ( numeric
            | identifier
            )
          )
          | ( ( 'WITH' )?
            'NO'
            'WAIT'
          )
          | ( 'THREAD'
            ( 'IN' )?
            dataName
          )
          | ( 'SIZE'
            ( 'IN' )?
            ( numeric
            | identifier
            )
          )
          | ( 'STATUS'
            ( 'IN' )?
            ( alphanumericLiteral
            | identifier
            )
          )
          | onException
          | notOnException
          ) )*
        )
        | ( cdName
          ( 'MESSAGE'
          | 'SEGMENT'
          )
          ( 'INTO' )?
          identifier
          ( ( 'NO'
            'DATA'
            nestedStatements
          ) )?
          ( ( 'WITH'
            'DATA'
            nestedStatements
          ) )?
        )
        )
        ( 'END-RECEIVE' )?
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
// resetTraceStatement
// ........................................................

resetTraceStatement
  : ^(RESET_TRACE_STATEMENT
      ( 'RESET'
        'TRACE'
        ( '.' )?
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
          ( identifier
          | literal
          )
        ) )?
        ( retryPhrase )?
        ( ( ( 'WITH' )?
          ( 'NO' )?
          'LOCK'
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
// rollbackStatement
// ........................................................

rollbackStatement
  : ^(ROLLBACK_STATEMENT
      'ROLLBACK'
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
// sendStatement
// ........................................................

sendStatement
  : ^(SEND_STATEMENT
      ( 'SEND'
        ( ( dataName
          'TO'
          ( ( 'LAST'
            'THREAD'
          )
          | ( 'ALL'
            'THREADS'
          )
          | ( ( ( 'THREAD' )?
            dataName
          ) )+
          )
        )
        | ( cdName
          ( ( 'FROM'
            identifier
          ) )?
          ( ( ( 'WITH' )?
            ( 'ESI'
            | 'EMI'
            | 'EGI'
            | identifier
            )
            ( ( ( 'BEFORE'
            | 'AFTER'
            )
              ( 'ADVANCING' )?
              ( 'PAGE'
              | ( ( zero
              | integer
              | identifier
              )
                ( ( 'LINE'
                | 'LINES'
                ) )?
              )
              | mnemonicName
              )
            ) )?
            ( ( 'REPLACING'
              ( 'LINE' )?
            ) )?
          ) )?
        )
        )
      )
    )
  ;

// ========================================================
// serviceStatement
// ........................................................

serviceStatement
  : ^(SERVICE_STATEMENT
      ( 'SERVICE'
        ( 'LABEL'
        | ( 'RELOAD'
          identifier
        )
        )
      )
    )
  ;

// ========================================================
// sortStatement
// ........................................................

sortStatement
  : ^(SORT_STATEMENT
      ( ( 'SORT'
        fileName
        ( ( 'ON'
          ( ( ( 'ASCENDING'
          | 'DESCENDING'
          )
            ( 'KEY' )?
            ( 'IS' )?
            ( qualifiedDataName )+
          ) )+
        ) )+
        ( ( ( 'WITH' )?
          'DUPLICATES'
          ( ( 'IN'
            'ORDER'
          ) )?
        ) )?
        ( ( ( 'COLLATING' )?
          'SEQUENCE'
          ( 'IS' )?
          alphabetName
        ) )?
        ( ( 'INPUT'
          'PROCEDURE'
          ( 'IS' )?
          procedureName
          ( ( ( 'THROUGH'
          | 'THRU'
          )
            procedureName
          ) )?
        )
        | ( 'USING'
          ( fileName )+
        )
        )
        ( ( 'OUTPUT'
          'PROCEDURE'
          ( 'IS' )?
          procedureName
          ( ( ( 'THROUGH'
          | 'THRU'
          )
            procedureName
          ) )?
        )
        | ( 'GIVING'
          ( fileName )+
        )
        )
      )
      | ( 'SORT'
        dataName
        ( ( 'ON'
          ( ( ( 'ASCENDING'
          | 'DESCENDING'
          )
            ( 'KEY' )?
            ( 'IS' )?
            ( qualifiedDataName )+
          ) )+
        ) )+
        ( ( ( 'WITH' )?
          'DUPLICATES'
          ( ( 'IN'
            'ORDER'
          ) )?
        ) )?
        ( ( ( 'COLLATING' )?
          'SEQUENCE'
          ( 'IS' )?
          alphabetName
        ) )?
      )
      )
    )
  ;

// ========================================================
// setStatement
// ........................................................

setStatement
  : ^(SET_STATEMENT
      ( 'SET'
        ( setFormatMonitorValue
        | setFormatDataPointerAssignment
        | setFormatProcedurePointerAssignment
        | setFormatSemaphoreValue
        | setFormat1
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
      | identifier
      ) )+
        'TO'
        ( indexName
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
        ( 'TRUE'
        | 'FALSE'
        )
      )
    )
  ;

// ========================================================
// setFormatDataPointerAssignment
// ........................................................

setFormatDataPointerAssignment
  : ^(SET_FORMAT_DATA_POINTER_ASSIGNMENT
      ( ( ( ( 'ADDRESS'
        ( 'OF' )?
        identifier
      )
      | identifier
      ) )+
        'TO'
        ( ( 'ADDRESS'
          ( 'OF' )?
          identifier
        )
        | mnemonicName
        | 'NULL'
        | 'NULLS'
        )
      )
    )
  ;

// ========================================================
// setFormatProcedurePointerAssignment
// ........................................................

setFormatProcedurePointerAssignment
  : ^(SET_FORMAT_PROCEDURE_POINTER_ASSIGNMENT
      ( procedureName
        'TO'
        ( procedureName
        | ( 'ENTRY'
          ( identifier
          | literal
          )
        )
        | 'NULL'
        | 'NULLS'
        )
      )
    )
  ;

// ========================================================
// setFormatMonitorValue
// ........................................................

setFormatMonitorValue
  : ^(SET_FORMAT_MONITOR_VALUE
      ( ( mnemonicName )+
        'TO'
        ( 'NOT' )?
        ( 'BROWSING'
        | 'READING'
        | 'WRITING'
        )
        ( ( 'CONVERTING'
          'FROM'
          ( 'BROWSING'
          | 'WRITING'
          )
        ) )?
      )
    )
  ;

// ========================================================
// setFormatSemaphoreValue
// ........................................................

setFormatSemaphoreValue
  : ^(SET_FORMAT_SEMAPHORE_VALUE
      ( ( mnemonicName )+
        'TO'
        ( 'UP'
        | 'DOWN'
        )
        'BY'
        ( integer
        | identifier
        )
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
      ( ( 'STOP'
        literal
      )
      | ( 'STOP'
        'RUN'
        ( ( ( 'GIVING'
        | 'RETURNING'
        )
          ( ( ( ( 'ADDRESS'
            'OF'
          ) )?
            identifier
          )
          | ( integer
            ( ( 'SIZE'
              ( 'IS' )?
              integer
            ) )?
          )
          )
        ) )?
      )
      | ( 'STOP'
        'ITERATOR'
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
// suppressStatement
// ........................................................

suppressStatement
  : ^(SUPPRESS_STATEMENT
      ( 'SUPPRESS'
        ( 'PRINTING' )?
      )
    )
  ;

// ========================================================
// terminateStatement
// ........................................................

terminateStatement
  : ^(TERMINATE_STATEMENT
      ( 'TERMINATE'
        ( reportName )+
      )
    )
  ;

// ========================================================
// transformStatement
// ........................................................

transformStatement
  : ^(TRANSFORM_STATEMENT
      ( 'TRANSFORM'
        identifier
        ( 'CHARACTERS' )?
        'FROM'
        ( figurativeConstant
        | alphanumericLiteral
        | identifier
        )
        'TO'
        ( figurativeConstant
        | alphanumericLiteral
        | identifier
        )
      )
    )
  ;

// ========================================================
// unlockStatement
// ........................................................

unlockStatement
  : ^(UNLOCK_STATEMENT
      ( 'UNLOCK'
        fileName
        ( ( 'RECORD'
        | 'RECORDS'
        ) )?
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
        | debugDeclarative
        | labelDeclarative
        | beforeReportingDeclarative
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
        ( 'INPUT'
        | 'OUTPUT'
        | 'I-O'
        | 'EXTEND'
        | ( fileName )*
        )
        ( ( 'GIVING'
          dataName
          ( dataName )?
        ) )?
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
        ( ( ( 'ALL'
          'PROCEDURES'
        )
        | ( ( ( 'ALL'
          ( 'REFERENCES' )?
          ( 'OF' )?
        ) )?
          identifier
        )
        | procedureName
        | fileName
        ) )*
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
        ( 'INPUT'
        | 'OUTPUT'
        | 'I-O'
        | 'EXTEND'
        | ( fileName )*
        )
      )
    )
  ;

// ========================================================
// beforeReportingDeclarative
// ........................................................

beforeReportingDeclarative
  : ^(BEFORE_REPORTING_DECLARATIVE
      ( ( 'GLOBAL' )?
        'BEFORE'
        'REPORTING'
        identifier
      )
    )
  ;

// ========================================================
// waitStatement
// ........................................................

waitStatement
  : ^(WAIT_STATEMENT
      ( ( 'WAIT'
        ( 'FOR' )?
        threadPointer
        ( ( 'RETURNING'
          ( 'INTO' )?
          identifier
        ) )?
        ( ( 'STATUS'
          ( 'IS' )?
          identifier
        ) )?
        ( onException )?
        ( notOnException )?
        ( 'END-WAIT' )?
      )
      | ( 'WAIT'
        ( 'FOR' )?
        eventPointer
      )
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
          ( identifier
          | literal
          )
        ) )?
        ( ( ( 'AFTER'
        | 'BEFORE'
        )
          ( ( 'ADVANCING'
          | 'POSITIONING'
          ) )?
          ( ( ( identifier
          | integer
          | zero
          )
            ( ( 'LINE'
            | 'LINES'
            ) )?
          )
          | mnemonicName
          | 'PAGE'
          | 'TAB'
          | 'FORMFEED'
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
        ( retryPhrase )?
        ( ( ( 'WITH' )?
          ( 'NO' )?
          'LOCK'
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
// xmlGenerateStatement
// ........................................................

xmlGenerateStatement
  : ^(XML_GENERATE_STATEMENT
      ( 'XML'
        'GENERATE'
        identifier
        'FROM'
        identifier
        ( ( 'COUNT'
          ( 'IN' )?
          identifier
        ) )?
        ( ( ( 'ON' )?
          'EXCEPTION'
          statement
        ) )?
        ( ( 'NOT'
          ( 'ON' )?
          'EXCEPTION'
          statement
        ) )?
        ( 'END-XML' )?
      )
    )
  ;

// ========================================================
// xmlParseStatement
// ........................................................

xmlParseStatement
  : ^(XML_PARSE_STATEMENT
      ( 'XML'
        'PARSE'
        identifier
        ( ( 'PROCESSING'
          'PROCEDURE'
          ( 'IS' )?
          procedureName
        ) )?
        ( ( ( 'THROUGH'
        | 'THRU'
        )
          procedureName
        ) )?
        ( ( ( 'ON' )?
          'EXCEPTION'
          statement
        ) )?
        ( ( 'NOT'
          ( 'ON' )?
          'EXCEPTION'
          statement
        ) )?
        ( 'END-XML' )?
      )
    )
  ;

// ========================================================
// compilerStatement
// ........................................................

compilerStatement
  : ^(COMPILER_STATEMENT
      ( compilerDirective
      | compilerIfStatement
      | compilerDisplayStatement
      | copyStatement
      | replaceStatement
      | useStatement
      )
    )
  ;

// ========================================================
// compilerDirective
// ........................................................

compilerDirective
  : ^(COMPILER_DIRECTIVE
      ( ( '\u0024'
        'SET'
      )
        (water)?
      )
    )
  ;

// ========================================================
// compilerIfStatement
// ........................................................

compilerIfStatement
  : ^(COMPILER_IF_STATEMENT
      ( '\u0024'
        'IF'
        operand
        ( ( 'SET'
        | ( ( 'NOT' )?
          'DEFINED'
        )
        | ( ( 'NOT' )?
          ( '<'
          | '>'
          | '='
          )
          operand
        )
        ) )?
        ( compilerStatement
        | nestedStatements
        )
        ( ( '\u0024'
          'ELSE'
          ( compilerStatement
          | nestedStatements
          )
        ) )?
        '\u0024'
        'END'
      )
    )
  ;

// ========================================================
// compilerDisplayStatement
// ........................................................

compilerDisplayStatement
  : ^(COMPILER_DISPLAY_STATEMENT
      ( '\u0024'
        'DISPLAY'
        ( ( 'VCS'
          '='
          literal
        )
        | textName
        )
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
      ( ( ( ( 'LEADING'
      | 'TRAILING'
      ) )?
        pseudoLiteral
      )
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
        ( 'OFF'
        | ( ( ( pseudoLiteral
          'BY'
          pseudoLiteral
        )
        | ( ( 'LEADING'
        | 'TRAILING'
        )
          pseudoLiteral
          'BY'
          pseudoLiteral
        )
        ) )+
        )
        ( '.' )?
      )
    )
  ;

// ========================================================
// pseudoText
// ........................................................

pseudoText
  : ^(PSEUDO_TEXT
      cobolWord
    )
  ;

// ========================================================
// partialWord
// ........................................................

partialWord
  : ^(PARTIAL_WORD
      cobolWord
    )
  ;

// ========================================================
// sourceFormattingDirective
// ........................................................

sourceFormattingDirective
  : ^(SOURCE_FORMATTING_DIRECTIVE
      ( ejectStatement
      | skipStatement
      | titleStatement
      )
    )
  ;

// ========================================================
// ejectStatement
// ........................................................

ejectStatement
  : ^(EJECT_STATEMENT
      ( 'EJECT'
        ( '.' )?
      )
    )
  ;

// ========================================================
// skipStatement
// ........................................................

skipStatement
  : ^(SKIP_STATEMENT
      ( ( 'SKIP1'
      | 'SKIP2'
      | 'SKIP3'
      )
        ( '.' )?
      )
    )
  ;

// ========================================================
// titleStatement
// ........................................................

titleStatement
  : ^(TITLE_STATEMENT
      ( 'TITLE'
        literal
        ( '.' )?
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
        ( usingOrChainingPhrase )?
        ( returningProcedurePhrase )?
      )
      )
        '.'
      )
    )
  ;

// ========================================================
// sectionStart
// ........................................................

sectionStart
  : ^(SECTION_START
      ( ( 'CONFIGURATION'
      | 'INPUT-OUTPUT'
      | 'FILE'
      | 'WORKING-STORAGE'
      | 'THREAD-LOCAL-STORAGE'
      | 'OBJECT-STORAGE'
      | 'LOCAL-STORAGE'
      | 'LINKAGE'
      | 'COMMUNICATION'
      | 'OBJECT'
      | 'REPORT'
      | 'SCREEN'
      )
        'SECTION'
        '.'
      )
    )
  ;

// ========================================================
// paragraphStart
// ........................................................

paragraphStart
  : ^(PARAGRAPH_START
      ( ( 'SOURCE-COMPUTER'
      | 'OBJECT-COMPUTER'
      | 'SPECIAL-NAMES'
      | 'REPOSITORY'
      | 'CONSTRAINTS'
      | 'CLASS-ATTRIBUTES'
      | 'ASSEMBLY-ATTRIBUTES'
      | 'FILE-CONTROL'
      | 'I-O-CONTROL'
      | 'CLASS-CONTROL'
      )
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
      | 'END-CHAIN'
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
      | 'END-RECEIVE'
      | 'END-RETURN'
      | 'END-REWRITE'
      | 'END-SEARCH'
      | 'END-START'
      | 'END-STRING'
      | 'END-SUBTRACT'
      | 'END-UNSTRING'
      | 'END-WAIT'
      | 'END-WRITE'
      | 'END-XML'
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
// function
// ........................................................

function
  : ^(FUNCTION
      ( 'FUNCTION'
        ( ( 'ABS'
          '('
          argument
          ')'
        )
        | ( 'ACOS'
          '('
          argument
          ')'
        )
        | ( 'ANNUITY'
          '('
          argument
          argument
          ')'
        )
        | ( 'ASIN'
          '('
          argument
          ')'
        )
        | ( 'ATAN'
          '('
          argument
          ')'
        )
        | ( 'BOOLEAN-OF-INTEGER'
          '('
          argument
          argument
          ')'
        )
        | ( 'BYTE-LENGTH'
          '('
          argument
          ')'
        )
        | ( 'CHAR'
          '('
          argument
          ')'
        )
        | ( 'CHAR-NATIONAL'
          '('
          argument
          ')'
        )
        | ( 'COMBINED-DATETIME'
          '('
          argument
          argument
          ')'
        )
        | ( 'CONCATENATE'
          '('
          ( argument )+
          ')'
        )
        | ( 'COS'
          '('
          argument
          ')'
        )
        | 'CURRENT-DATE'
        | ( 'DATE-OF-INTEGER'
          '('
          argument
          ')'
        )
        | ( 'DATE-TO-YYYYMMDD'
          '('
          argument
          ( argument )?
          ')'
        )
        | ( 'DAY-OF-INTEGER'
          '('
          argument
          ')'
        )
        | ( 'DAY-TO-YYYYDDD'
          '('
          argument
          ( argument )?
          ')'
        )
        | ( 'DISPLAY-OF'
          '('
          argument
          ( argument )?
          ')'
        )
        | 'E'
        | 'EXCEPTION-FILE'
        | 'EXCEPTION-LOCATION'
        | 'EXCEPTION-STATEMENT'
        | 'EXCEPTION-STATUS'
        | ( 'EXP'
          '('
          argument
          ')'
        )
        | ( 'EXP10'
          '('
          argument
          ')'
        )
        | ( 'FACTORIAL'
          '('
          argument
          ')'
        )
        | ( 'FRACTION-PART'
          '('
          argument
          ')'
        )
        | ( 'INTEGER'
          '('
          argument
          ')'
        )
        | ( 'INTEGER-OF-BOOLEAN'
          '('
          argument
          ')'
        )
        | ( 'INTEGER-OF-DATE'
          '('
          argument
          ')'
        )
        | ( 'INTEGER-OF-DAY'
          '('
          argument
          ')'
        )
        | ( 'INTEGER-PART'
          '('
          argument
          ')'
        )
        | ( 'LENGTH'
          '('
          argument
          ')'
        )
        | ( 'LENGTH-AN'
          '('
          argument
          ')'
        )
        | ( 'LOCALE-DATE'
          '('
          argument
          ( argument )?
          ')'
        )
        | ( 'LOCALE-TIME'
          '('
          argument
          ( argument )?
          ')'
        )
        | ( 'LOCALE-TIME-FROM-SECS'
          '('
          argument
          ( argument )?
          ')'
        )
        | ( 'LOG'
          '('
          argument
          ')'
        )
        | ( 'LOG10'
          '('
          argument
          ')'
        )
        | ( 'LOWER-CASE'
          '('
          argument
          ')'
        )
        | ( 'MAX'
          '('
          ( argument )+
          ')'
        )
        | ( 'MEAN'
          '('
          ( argument )+
          ')'
        )
        | ( 'MEDIAN'
          '('
          ( argument )+
          ')'
        )
        | ( 'MIDRANGE'
          '('
          ( argument )+
          ')'
        )
        | ( 'MIN'
          '('
          ( argument )+
          ')'
        )
        | ( 'MOD'
          '('
          argument
          argument
          ')'
        )
        | ( 'NATIONAL-OF'
          '('
          argument
          ( argument )?
          ')'
        )
        | ( 'NUMVAL'
          '('
          argument
          ')'
        )
        | ( 'NUMVAL-C'
          '('
          argument
          ( argument )?
          ')'
        )
        | ( 'ORD'
          '('
          argument
          ')'
        )
        | ( 'ORD-MAX'
          '('
          ( argument )+
          ')'
        )
        | ( 'ORD-MIN'
          '('
          ( argument )+
          ')'
        )
        | 'PI'
        | ( 'PRESENT-VALUE'
          '('
          argument
          ( argument )+
          ')'
        )
        | ( 'RANDOM'
          ( ( '('
            argument
            ')'
          ) )?
        )
        | ( 'RANGE'
          '('
          ( argument )+
          ')'
        )
        | ( 'REM'
          '('
          argument
          argument
          ')'
        )
        | ( 'REVERSE'
          '('
          argument
          ')'
        )
        | ( 'SECONDS-FROM-FORMATTED-TIME'
          '('
          argument
          argument
          ')'
        )
        | 'SECONDS-PAST-MIDNIGHT'
        | ( 'SIGN'
          '('
          argument
          ')'
        )
        | ( 'SIN'
          '('
          argument
          ')'
        )
        | ( 'SQRT'
          '('
          argument
          ')'
        )
        | ( 'STANDARD-DEVIATION'
          '('
          ( argument )+
          ')'
        )
        | ( 'STORED-CHAR-LENGTH'
          '('
          argument
          ')'
        )
        | ( 'SUBSTITUTE'
          '('
          ( argument )+
          ')'
        )
        | ( 'SUBSTITUTE-CASE'
          '('
          ( argument )+
          ')'
        )
        | ( 'SUM'
          '('
          ( argument )+
          ')'
        )
        | ( 'TAN'
          '('
          argument
          ')'
        )
        | ( 'TEST-DATE-YYYYMMDD'
          '('
          argument
          ')'
        )
        | ( 'TEST-DAY-YYYYDDD'
          '('
          argument
          ')'
        )
        | ( 'TRIM'
          '('
          argument
          ( ( 'LEADING'
          | 'TRAILING'
          ) )?
          ')'
        )
        | ( 'UPPER-CASE'
          '('
          argument
          ')'
        )
        | ( 'VARIANCE'
          '('
          ( argument )+
          ')'
        )
        | 'WHEN-COMPILED'
        | ( 'YEAR-TO-YYYY'
          '('
          argument
          ( argument )?
          ')'
        )
        | ( functionName
          ( ( '('
            ( argument )+
            ')'
          ) )?
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
      ( identifier_format6
      | identifier_format1
      | identifier_format2
      | dataAddressIdentifier
      )
    )
  ;

// ========================================================
// identifier_format1
// ........................................................

identifier_format1
  : ^(IDENTIFIER_FORMAT1
      ( function
        ( referenceModifier )?
      )
    )
  ;

// ========================================================
// identifier_format2
// ........................................................

identifier_format2
  : ^(IDENTIFIER_FORMAT2
      ( qualifiedDataName
        ( referenceModifier )?
      )
    )
  ;

// ========================================================
// identifier_format6
// ........................................................

identifier_format6
  : ^(IDENTIFIER_FORMAT6
      ( 'EXCEPTION-OBJECT'
      | 'NULL'
      | 'SELF'
      | ( ( ( className
        'OF'
      ) )?
        'SUPER'
      )
      )
    )
  ;

// ========================================================
// dataAddressIdentifier
// ........................................................

dataAddressIdentifier
  : ^(DATA_ADDRESS_IDENTIFIER
      ( 'ADDRESS'
        ( 'OF' )?
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
      ( ( ( 'IN'
      | 'OF'
      )
        dataName
      ) )*
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
      ( 'ALL'
      | identifier
      | integer
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
      ( bitwiseOperand
        ( ( bitwiseOperator
          bitwiseOperand
        ) )*
      )
    )
  ;

// ========================================================
// bitwiseOperator
// ........................................................

bitwiseOperator
  : ^(BITWISE_OPERATOR
      ( 'B-AND'
      | 'B-OR'
      | 'B-XOR'
      | 'B-EXOR'
      )
    )
  ;

// ========================================================
// bitwiseOperand
// ........................................................

bitwiseOperand
  : ^(BITWISE_OPERAND
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
// unaryOperator
// ........................................................

unaryOperator
  : ^(UNARY_OPERATOR
      ( '+'
      | '-'
      | 'B-NOT'
      )
    )
  ;

// ========================================================
// factor
// ........................................................

factor
  : ^(FACTOR
      ( ( unaryOperator )?
        atomicExpression
        ( ( '**'
          ( unaryOperator )?
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
      ( zero
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
      ( bit
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
      | zero
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
      ( ( ( 'IS'
      | 'ARE'
      ) )?
        ( ( ( negationOp )?
          greaterOrEqualOp
        )
        | ( ( negationOp )?
          lessOrEqualOp
        )
        | ( ( negationOp )?
          greaterThanOp
        )
        | ( ( negationOp )?
          lessThanOp
        )
        | ( ( negationOp )?
          equalToOp
        )
        | exceedsOp
        | equalsOp
        | unequalToOp
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
// exceedsOp
// ........................................................

exceedsOp
  : ^(EXCEEDS_OP
      'EXCEEDS'
    )
  ;

// ========================================================
// equalsOp
// ........................................................

equalsOp
  : ^(EQUALS_OP
      'EQUALS'
    )
  ;

// ========================================================
// unequalToOp
// ........................................................

unequalToOp
  : ^(UNEQUAL_TO_OP
      ( ( 'UNEQUAL'
        ( 'TO' )?
      )
      | '<>'
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
      cobolWord
    )
  ;

// ========================================================
// qualifiedDataName
// ........................................................

qualifiedDataName
  : ^(QUALIFIED_DATA_NAME
      ( dataName
        qualifier
        ( ( '('
          ( subscript )+
          ')'
        ) )?
      )
    )
  ;

// ========================================================
// dataDescName
// ........................................................

dataDescName
  : ^(DATA_DESC_NAME
      ( 'FILLER'
      | 'CURSOR'
      | dataName
      )
    )
  ;

// ========================================================
// screenName
// ........................................................

screenName
  : ^(SCREEN_NAME
      cobolWord
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
// threadPointer
// ........................................................

threadPointer
  : ^(THREAD_POINTER
      cobolWord
    )
  ;

// ========================================================
// eventPointer
// ........................................................

eventPointer
  : ^(EVENT_POINTER
      cobolWord
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
// typeSpecifier
// ........................................................

typeSpecifier
  : ^(TYPE_SPECIFIER
      cobolWord
    )
  ;

// ========================================================
// parameterName
// ........................................................

parameterName
  : ^(PARAMETER_NAME
      cobolWord
    )
  ;

// ========================================================
// interfaceName
// ........................................................

interfaceName
  : ^(INTERFACE_NAME
      cobolWord
    )
  ;

// ========================================================
// methodName
// ........................................................

methodName
  : ^(METHOD_NAME
      cobolWord
    )
  ;

// ========================================================
// propertyName
// ........................................................

propertyName
  : ^(PROPERTY_NAME
      ( identifier
      | alphanumeric
      )
    )
  ;

// ========================================================
// propertyValue
// ........................................................

propertyValue
  : ^(PROPERTY_VALUE
      ( identifier
      | literal
      )
    )
  ;

// ========================================================
// delegateName
// ........................................................

delegateName
  : ^(DELEGATE_NAME
      cobolWord
    )
  ;

// ========================================================
// iteratorName
// ........................................................

iteratorName
  : ^(ITERATOR_NAME
      cobolWord
    )
  ;

// ========================================================
// enumName
// ........................................................

enumName
  : ^(ENUM_NAME
      cobolWord
    )
  ;

// ========================================================
// valuetypeName
// ........................................................

valuetypeName
  : ^(VALUETYPE_NAME
      cobolWord
    )
  ;

// ========================================================
// typeName
// ........................................................

typeName
  : ^(TYPE_NAME
      cobolWord
    )
  ;

// ========================================================
// attributeName
// ........................................................

attributeName
  : ^(ATTRIBUTE_NAME
      cobolWord
    )
  ;

// ========================================================
// typedefName
// ........................................................

typedefName
  : ^(TYPEDEF_NAME
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
      ( identifier
      | cobolWord
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
      | 'CRT'
      | 'CRT-UNDER'
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
// cdName
// ........................................................

cdName
  : ^(CD_NAME
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
      ( ( literalValue
        ( concatenatedLiteral )*
      )
      | ( constant
        ( concatenatedLiteral )+
      )
      )
    )
  ;

// ========================================================
// literalValue
// ........................................................

literalValue
  : ^(LITERAL_VALUE
      ( numericLiteral
      | alphanumericLiteral
      | figurativeConstant
      | bit
      )
    )
  ;

// ========================================================
// concatenatedLiteral
// ........................................................

concatenatedLiteral
  : ^(CONCATENATED_LITERAL
      ( '&'
        ( literalValue
        | constant
        )
      )
    )
  ;

// ========================================================
// value
// ........................................................

value
  : ^(VALUE
      ( literal
      | integerConstant
      | alphanumericConstant
      )
    )
  ;

// ========================================================
// bit
// ........................................................

bit
  : ^(BIT
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
        ( zero
        | space
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
// numericLiteral
// ........................................................

numericLiteral
  : ^(NUMERIC_LITERAL
      ( integerLiteral
      | decimal
      | booleanLiteral
      | hexadecimal
      | ( ( 'LENGTH'
      | 'BYTE-LENGTH'
      )
        ( 'OF' )?
        identifier
      )
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
      | booleanLiteral
      | hexadecimal
      | zero
      | ( ( 'LENGTH'
      | 'BYTE-LENGTH'
      )
        ( 'OF' )?
        identifier
      )
      )
    )
  ;

// ========================================================
// integer
// ........................................................

integer
  : ^(INTEGER
      ( integerLiteral
      | integerConstant
      )
    )
  ;

// ========================================================
// constant
// ........................................................

constant
  : ^(CONSTANT
      ( integerConstant
      | alphanumericConstant
      )
    )
  ;

// ========================================================
// integerConstant
// ........................................................

integerConstant
  : ^(INTEGER_CONSTANT
      cobolWord
    )
  ;

// ========================================================
// alphanumeric
// ........................................................

alphanumeric
  : ^(ALPHANUMERIC
      ( alphanumericLiteral
      | alphanumericConstant
      )
    )
  ;

// ========================================================
// alphanumericConstant
// ........................................................

alphanumericConstant
  : ^(ALPHANUMERIC_CONSTANT
      cobolWord
    )
  ;

// ========================================================

water
  : ^(WATER token*)
  ;

token
  : TOKEN
  | '&'
  | '('
  | ')'
  | '*'
  | '**'
  | '+'
  | '-'
  | '.'
  | '/'
  | '01'
  | '1'
  | '66'
  | '78'
  | '88'
  | ':'
  | '<'
  | '<='
  | '<>'
  | '='
  | '>'
  | '>='
  | 'ABS'
  | 'ABSTRACT'
  | 'ACCEPT'
  | 'ACCESS'
  | 'ACOS'
  | 'ACTIVE-CLASS'
  | 'ADD'
  | 'ADDRESS'
  | 'ADVANCING'
  | 'AFP-5A'
  | 'AFTER'
  | 'ALL'
  | 'ALLOCATE'
  | 'ALPHABET'
  | 'ALPHABETIC'
  | 'ALPHABETIC-LOWER'
  | 'ALPHABETIC-UPPER'
  | 'ALPHANUMERIC'
  | 'ALPHANUMERIC-EDITED'
  | 'ALSO'
  | 'ALTER'
  | 'ALTERNATE'
  | 'AND'
  | 'ANNUITY'
  | 'ANY'
  | 'ARE'
  | 'AREA'
  | 'AREAS'
  | 'ARGUMENT-NUMBER'
  | 'AS'
  | 'ASCENDING'
  | 'ASCII'
  | 'ASIN'
  | 'ASSEMBLY-ATTRIBUTES'
  | 'ASSIGN'
  | 'AT'
  | 'ATAN'
  | 'ATTRIBUTE'
  | 'AUTHOR'
  | 'AUTO'
  | 'AUTO-SKIP'
  | 'AUTOMATIC'
  | 'AUXILIARY'
  | 'B-AND'
  | 'B-EXOR'
  | 'B-LEFT'
  | 'B-NOT'
  | 'B-OR'
  | 'B-RIGHT'
  | 'B-XOR'
  | 'BACKGROUND-COLOR'
  | 'BACKGROUND-COLOUR'
  | 'BASED'
  | 'BEEP'
  | 'BEFORE'
  | 'BEGINNING'
  | 'BELL'
  | 'BINARY'
  | 'BINARY-C-LONG'
  | 'BINARY-CHAR'
  | 'BINARY-DOUBLE'
  | 'BINARY-LONG'
  | 'BINARY-SHORT'
  | 'BIT'
  | 'BLANK'
  | 'BLINK'
  | 'BLINKING'
  | 'BLOCK'
  | 'BOLD'
  | 'BOOLEAN-OF-INTEGER'
  | 'BOTTOM'
  | 'BROWSING'
  | 'BY'
  | 'BYTE-LENGTH'
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
  | 'CALL-CONVENTION'
  | 'CANCEL'
  | 'CASE-INSENSITIVE'
  | 'CASE-SENSITIVE'
  | 'CD'
  | 'CENTERED'
  | 'CENTURY-DATE'
  | 'CENTURY-DAY'
  | 'CF'
  | 'CH'
  | 'CHAIN'
  | 'CHAINING'
  | 'CHANGED'
  | 'CHANNEL'
  | 'CHAR'
  | 'CHAR-NATIONAL'
  | 'CHARACTER'
  | 'CHARACTERS'
  | 'CICS'
  | 'CLASS'
  | 'CLASS-ATTRIBUTES'
  | 'CLASS-CONTROL'
  | 'CLASS-ID'
  | 'CLOSE'
  | 'CODE'
  | 'CODE-SET'
  | 'COL'
  | 'COLLATING'
  | 'COLUMN'
  | 'COMBINED-DATETIME'
  | 'COMMA'
  | 'COMMAND-LINE'
  | 'COMMAREA'
  | 'COMMIT'
  | 'COMMON'
  | 'COMMUNICATION'
  | 'COMP'
  | 'COMP-1'
  | 'COMP-2'
  | 'COMP-3'
  | 'COMP-4'
  | 'COMP-5'
  | 'COMP-X'
  | 'COMPUTATIONAL'
  | 'COMPUTATIONAL-1'
  | 'COMPUTATIONAL-2'
  | 'COMPUTATIONAL-3'
  | 'COMPUTATIONAL-4'
  | 'COMPUTATIONAL-5'
  | 'COMPUTATIONAL-X'
  | 'COMPUTE'
  | 'CONCATENATE'
  | 'CONDITION-VALUE'
  | 'CONFIGURATION'
  | 'CONSISTENT'
  | 'CONSOLE'
  | 'CONSTANT'
  | 'CONSTRAINTS'
  | 'CONTAINS'
  | 'CONTENT'
  | 'CONTINUE'
  | 'CONTROL'
  | 'CONTROLS'
  | 'CONVERSION'
  | 'CONVERT'
  | 'CONVERTING'
  | 'COPY'
  | 'CORR'
  | 'CORRESPONDING'
  | 'COS'
  | 'COUNT'
  | 'CRT'
  | 'CRT-UNDER'
  | 'CSP'
  | 'CURRENCY'
  | 'CURRENT-DATE'
  | 'CURSOR'
  | 'CUSTOM-ATTRIBUTE'
  | 'CYCLE'
  | 'DATA'
  | 'DATALENGTH'
  | 'DATASET'
  | 'DATE'
  | 'DATE-COMPILED'
  | 'DATE-OF-INTEGER'
  | 'DATE-TO-YYYYMMDD'
  | 'DATE-WRITTEN'
  | 'DAY'
  | 'DAY-OF-INTEGER'
  | 'DAY-OF-WEEK'
  | 'DAY-TO-YYYYDDD'
  | 'DBCS'
  | 'DE'
  | 'DEBUGGING'
  | 'DECIMAL'
  | 'DECIMAL-POINT'
  | 'DECLARATIVES'
  | 'DECLARE'
  | 'DEFINED'
  | 'DELEGATE'
  | 'DELEGATE-ID'
  | 'DELETE'
  | 'DELETEQ'
  | 'DELIMITED'
  | 'DELIMITER'
  | 'DEPENDING'
  | 'DESCENDING'
  | 'DESTINATION'
  | 'DETAIL'
  | 'DISABLE'
  | 'DISK'
  | 'DISPLAY'
  | 'DISPLAY-1'
  | 'DISPLAY-OF'
  | 'DIVIDE'
  | 'DIVISION'
  | 'DLI'
  | 'DOWN'
  | 'DUPLICATES'
  | 'DYNAMIC'
  | 'E'
  | 'EBCDIC'
  | 'ECHO'
  | 'EGCS'
  | 'EGI'
  | 'EJECT'
  | 'ELSE'
  | 'EMI'
  | 'EMPTY-CHECK'
  | 'ENABLE'
  | 'END'
  | 'END-ACCEPT'
  | 'END-ADD'
  | 'END-CALL'
  | 'END-CHAIN'
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
  | 'END-RECEIVE'
  | 'END-RETURN'
  | 'END-REWRITE'
  | 'END-SEARCH'
  | 'END-START'
  | 'END-STRING'
  | 'END-SUBTRACT'
  | 'END-UNSTRING'
  | 'END-WAIT'
  | 'END-WRITE'
  | 'END-XML'
  | 'ENDING'
  | 'ENTRY'
  | 'ENUM'
  | 'ENUM-ID'
  | 'ENVIRONMENT'
  | 'ENVIRONMENT-NAME'
  | 'ENVIRONMENT-VALUE'
  | 'EOL'
  | 'EOP'
  | 'EOS'
  | 'EQUAL'
  | 'EQUALS'
  | 'ERASE'
  | 'ERROR'
  | 'ESCAPE'
  | 'ESI'
  | 'EVALUATE'
  | 'EVENT'
  | 'EVERY'
  | 'EXAMINE'
  | 'EXCEEDS'
  | 'EXCEPTION'
  | 'EXCEPTION-FILE'
  | 'EXCEPTION-LOCATION'
  | 'EXCEPTION-OBJECT'
  | 'EXCEPTION-STATEMENT'
  | 'EXCEPTION-STATUS'
  | 'EXCLUSIVE'
  | 'EXEC'
  | 'EXECUTE'
  | 'EXHIBIT'
  | 'EXIT'
  | 'EXP'
  | 'EXP10'
  | 'EXPANDS'
  | 'EXPLICIT'
  | 'EXTEND'
  | 'EXTENSION'
  | 'EXTERNAL'
  | 'F'
  | 'FACTORIAL'
  | 'FACTORY'
  | 'FALSE'
  | 'FD'
  | 'FILE'
  | 'FILE-CONTROL'
  | 'FILE-ID'
  | 'FILLER'
  | 'FINAL'
  | 'FIRST'
  | 'FIXED'
  | 'FLOAT-EXTENDED'
  | 'FLOAT-LONG'
  | 'FLOAT-SHORT'
  | 'FOOTING'
  | 'FOR'
  | 'FOREGROUND-COLOR'
  | 'FOREGROUND-COLOUR'
  | 'FOREVER'
  | 'FORMFEED'
  | 'FRACTION-PART'
  | 'FREE'
  | 'FROM'
  | 'FULL'
  | 'FUNCTION'
  | 'FUNCTION-ID'
  | 'GENERATE'
  | 'GENERIC'
  | 'GET'
  | 'GIVING'
  | 'GLOBAL'
  | 'GO'
  | 'GOBACK'
  | 'GREATER'
  | 'GRID'
  | 'GROUP'
  | 'GTEQ'
  | 'HANDLE'
  | 'HEADING'
  | 'HIGH'
  | 'HIGH-VALUE'
  | 'HIGH-VALUES'
  | 'HIGHLIGHT'
  | 'HTML'
  | 'I-O'
  | 'I-O-CONTROL'
  | 'ID'
  | 'IDENTIFICATION'
  | 'IDENTIFIED'
  | 'IF'
  | 'IGNORE'
  | 'IGNORING'
  | 'IMPLEMENTS'
  | 'IMPLICIT'
  | 'IN'
  | 'INCLUDE'
  | 'INDEX'
  | 'INDEXED'
  | 'INDICATE'
  | 'INHERITS'
  | 'INITIAL'
  | 'INITIALIZE'
  | 'INITIALIZED'
  | 'INITIATE'
  | 'INPUT'
  | 'INPUT-OUTPUT'
  | 'INPUTMSG'
  | 'INPUTMSGLEN'
  | 'INSERT'
  | 'INSPECT'
  | 'INSTALLATION'
  | 'INTEGER'
  | 'INTEGER-OF-BOOLEAN'
  | 'INTEGER-OF-DATE'
  | 'INTEGER-OF-DAY'
  | 'INTEGER-PART'
  | 'INTERFACE'
  | 'INTERFACE-ID'
  | 'INTERNAL'
  | 'INTO'
  | 'INTRINSIC'
  | 'INVALID'
  | 'INVOKE'
  | 'IS'
  | 'ITEM'
  | 'ITERATOR'
  | 'ITERATOR-ID'
  | 'JUST'
  | 'JUSTIFIED'
  | 'KANJI'
  | 'KEPT'
  | 'KEY'
  | 'KEYBOARD'
  | 'KEYLENGTH'
  | 'LABEL'
  | 'LAST'
  | 'LEADING'
  | 'LEFT'
  | 'LEFT-JUSTIFY'
  | 'LEFTLINE'
  | 'LENGTH'
  | 'LENGTH-AN'
  | 'LENGTH-CHECK'
  | 'LESS'
  | 'LIKE'
  | 'LIMIT'
  | 'LIMITS'
  | 'LINAGE'
  | 'LINE'
  | 'LINES'
  | 'LINK'
  | 'LINKAGE'
  | 'LOAD'
  | 'LOCAL-STORAGE'
  | 'LOCALE'
  | 'LOCALE-DATE'
  | 'LOCALE-TIME'
  | 'LOCALE-TIME-FROM-SECS'
  | 'LOCK'
  | 'LOG'
  | 'LOG10'
  | 'LOW'
  | 'LOW-VALUE'
  | 'LOW-VALUES'
  | 'LOWER'
  | 'LOWER-CASE'
  | 'LOWLIGHT'
  | 'MAIN'
  | 'MANUAL'
  | 'MASSINSERT'
  | 'MAX'
  | 'MEAN'
  | 'MEDIAN'
  | 'MERGE'
  | 'MESSAGE'
  | 'METHOD'
  | 'METHOD-ID'
  | 'MIDRANGE'
  | 'MIN'
  | 'MOD'
  | 'MODE'
  | 'MONITOR-POINTER'
  | 'MOVE'
  | 'MULTIPLE'
  | 'MULTIPLY'
  | 'MUTEX-POINTER'
  | 'NAME'
  | 'NAMED'
  | 'NATIONAL'
  | 'NATIONAL-EDITED'
  | 'NATIONAL-OF'
  | 'NATIVE'
  | 'NEGATIVE'
  | 'NESTED'
  | 'NEXT'
  | 'NO'
  | 'NO-ECHO'
  | 'NOSUSPEND'
  | 'NOT'
  | 'NULL'
  | 'NULLS'
  | 'NUMBER'
  | 'NUMERIC'
  | 'NUMERIC-EDITED'
  | 'NUMITEMS'
  | 'NUMVAL'
  | 'NUMVAL-C'
  | 'OBJECT'
  | 'OBJECT-COMPUTER'
  | 'OBJECT-STORAGE'
  | 'OCCURS'
  | 'OF'
  | 'OFF'
  | 'OMITTED'
  | 'ON'
  | 'ONLY'
  | 'OPEN'
  | 'OPERATOR'
  | 'OPERATOR-ID'
  | 'OPTIONAL'
  | 'OR'
  | 'ORD'
  | 'ORD-MAX'
  | 'ORD-MIN'
  | 'ORDER'
  | 'ORGANIZATION'
  | 'OTHER'
  | 'OTHERWISE'
  | 'OUTPUT'
  | 'OVERFLOW'
  | 'OVERLINE'
  | 'OVERRIDE'
  | 'PACKED-DECIMAL'
  | 'PADDING'
  | 'PAGE'
  | 'PARAGRAPH'
  | 'PARSE'
  | 'PARTIAL'
  | 'PASSWORD'
  | 'PERFORM'
  | 'PF'
  | 'PH'
  | 'PI'
  | 'PIC'
  | 'PICTURE'
  | 'PLUS'
  | 'POINTER'
  | 'POS'
  | 'POSITION'
  | 'POSITIONING'
  | 'POSITIVE'
  | 'PRESENT-VALUE'
  | 'PREVIOUS'
  | 'PRINTER'
  | 'PRINTER-1'
  | 'PRINTING'
  | 'PRIVATE'
  | 'PROCEDURE'
  | 'PROCEDURE-POINTER'
  | 'PROCEDURES'
  | 'PROCEED'
  | 'PROCESSING'
  | 'PROGRAM'
  | 'PROGRAM-ID'
  | 'PROGRAM-POINTER'
  | 'PROMPT'
  | 'PROPERTY'
  | 'PROTECTED'
  | 'PROTOTYPE'
  | 'PUBLIC'
  | 'PURGE'
  | 'QNAME'
  | 'QUEUE'
  | 'QUOTE'
  | 'QUOTES'
  | 'RAISE'
  | 'RANDOM'
  | 'RANGE'
  | 'RBA'
  | 'RD'
  | 'READ'
  | 'READING'
  | 'READNEXT'
  | 'READQ'
  | 'READY'
  | 'RECEIVE'
  | 'RECORD'
  | 'RECORDING'
  | 'RECORDS'
  | 'RECURSIVE'
  | 'REDEFINE'
  | 'REDEFINES'
  | 'REEL'
  | 'REFERENCE'
  | 'REFERENCES'
  | 'RELATIVE'
  | 'RELEASE'
  | 'RELOAD'
  | 'REM'
  | 'REMAINDER'
  | 'REMARKS'
  | 'REMOVAL'
  | 'RENAMES'
  | 'REPEATABLE'
  | 'REPEATED'
  | 'REPLACE'
  | 'REPLACING'
  | 'REPORT'
  | 'REPORTING'
  | 'REPORTS'
  | 'REPOSITORY'
  | 'REQUIRED'
  | 'RESERVE'
  | 'RESET'
  | 'RETRY'
  | 'RETURN'
  | 'RETURNING'
  | 'REVERSE'
  | 'REVERSE-VIDEO'
  | 'REVERSED'
  | 'REWIND'
  | 'REWRITE'
  | 'RF'
  | 'RH'
  | 'RIDFLD'
  | 'RIGHT'
  | 'RIGHT-JUSTIFY'
  | 'ROLLBACK'
  | 'ROUNDED'
  | 'RRN'
  | 'RUN'
  | 'S'
  | 'S01'
  | 'S02'
  | 'S03'
  | 'S04'
  | 'S05'
  | 'SCREEN'
  | 'SCROLL'
  | 'SD'
  | 'SEARCH'
  | 'SECONDS'
  | 'SECONDS-FROM-FORMATTED-TIME'
  | 'SECONDS-PAST-MIDNIGHT'
  | 'SECTION'
  | 'SECURE'
  | 'SECURITY'
  | 'SEGMENT'
  | 'SELECT'
  | 'SELF'
  | 'SEMAPHORE-POINTER'
  | 'SEND'
  | 'SENTENCE'
  | 'SEPARATE'
  | 'SEQUENCE'
  | 'SEQUENTIAL'
  | 'SERVICE'
  | 'SET'
  | 'SHARING'
  | 'SIGN'
  | 'SIGNED'
  | 'SIGNED-INT'
  | 'SIGNED-LONG'
  | 'SIGNED-SHORT'
  | 'SIN'
  | 'SIZE'
  | 'SKIP1'
  | 'SKIP2'
  | 'SKIP3'
  | 'SORT'
  | 'SOURCE'
  | 'SOURCE-COMPUTER'
  | 'SPACE'
  | 'SPACE-FILL'
  | 'SPACES'
  | 'SPECIAL-NAMES'
  | 'SQL'
  | 'SQRT'
  | 'STANDARD'
  | 'STANDARD-1'
  | 'STANDARD-2'
  | 'STANDARD-DEVIATION'
  | 'START'
  | 'STATIC'
  | 'STATUS'
  | 'STOP'
  | 'STORED-CHAR-LENGTH'
  | 'STRING'
  | 'SUB-QUEUE-1'
  | 'SUB-QUEUE-2'
  | 'SUB-QUEUE-3'
  | 'SUBSTITUTE'
  | 'SUBSTITUTE-CASE'
  | 'SUBTRACT'
  | 'SUM'
  | 'SUPER'
  | 'SUPPRESS'
  | 'SWITCH-0'
  | 'SWITCH-1'
  | 'SWITCH-2'
  | 'SWITCH-3'
  | 'SWITCH-4'
  | 'SWITCH-5'
  | 'SWITCH-6'
  | 'SWITCH-7'
  | 'SWITCH-8'
  | 'SYMBOLIC'
  | 'SYNC'
  | 'SYNCHRONIZED'
  | 'SYNCONRETURN'
  | 'SYS'
  | 'SYSERR'
  | 'SYSID'
  | 'SYSIN'
  | 'SYSIPT'
  | 'SYSLIST'
  | 'SYSLST'
  | 'SYSOUT'
  | 'SYSPCH'
  | 'SYSPUNCH'
  | 'SYSTEM-INFO'
  | 'TAB'
  | 'TABLE'
  | 'TALLYING'
  | 'TAN'
  | 'TD'
  | 'TERMINAL'
  | 'TERMINAL-INFO'
  | 'TERMINATE'
  | 'TEST'
  | 'TEST-DATE-YYYYMMDD'
  | 'TEST-DAY-YYYYDDD'
  | 'TEXT'
  | 'THAN'
  | 'THEN'
  | 'THREAD'
  | 'THREAD-LOCAL'
  | 'THREAD-LOCAL-STORAGE'
  | 'THREAD-POINTER'
  | 'THREADS'
  | 'THROUGH'
  | 'THRU'
  | 'TIME'
  | 'TIME-OUT'
  | 'TIMEOUT'
  | 'TIMES'
  | 'TITLE'
  | 'TO'
  | 'TOKEN'
  | 'TOP'
  | 'TR'
  | 'TRACE'
  | 'TRAILING'
  | 'TRAILING-SIGN'
  | 'TRANSFORM'
  | 'TRANSID'
  | 'TRIM'
  | 'TRIMMED'
  | 'TRUE'
  | 'TS'
  | 'TYPE'
  | 'TYPEDEF'
  | 'U'
  | 'UNCOMMITTED'
  | 'UNDERLINE'
  | 'UNEQUAL'
  | 'UNIT'
  | 'UNLOCK'
  | 'UNSIGNED'
  | 'UNSIGNED-INT'
  | 'UNSIGNED-LONG'
  | 'UNSIGNED-SHORT'
  | 'UNSTRING'
  | 'UNTIL'
  | 'UP'
  | 'UPDATE'
  | 'UPON'
  | 'UPPER'
  | 'UPPER-CASE'
  | 'USAGE'
  | 'USE'
  | 'USER'
  | 'USING'
  | 'V'
  | 'VALUE'
  | 'VALUES'
  | 'VALUETYPE'
  | 'VALUETYPE-ID'
  | 'VARIABLE'
  | 'VARIANCE'
  | 'VARYING'
  | 'VCS'
  | 'WAIT'
  | 'WHEN'
  | 'WHEN-COMPILED'
  | 'WHILE'
  | 'WINDOW'
  | 'WITH'
  | 'WORKING-STORAGE'
  | 'WRITE'
  | 'WRITEQ'
  | 'WRITING'
  | 'XCTL'
  | 'XML'
  | 'XML-SCHEMA'
  | 'XRBA'
  | 'YEAR'
  | 'YEAR-TO-YYYY'
  | 'YIELDING'
  | 'YYYYDDD'
  | 'YYYYMMDD'
  | 'ZERO'
  | 'ZERO-FILL'
  | 'ZEROES'
  | 'ZEROS'
  | '\u0024'
  ;

// ========================================================

cobolWord
  : ^(COBOL_WORD token)
  ;

integerLiteral
  : ^(INTEGER_LITERAL token)
  ;

decimal
  : ^(DECIMAL token)
  ;

booleanLiteral
  : ^(BOOLEAN_LITERAL token)
  ;

hexadecimal
  : ^(HEXADECIMAL token)
  ;

alphanumericLiteral
  : ^(ALPHANUMERIC_LITERAL token)
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
