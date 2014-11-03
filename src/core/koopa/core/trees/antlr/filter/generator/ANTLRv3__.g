lexer grammar ANTLRv3;

@header {
  package koopa.core.trees.antlr.filter.generator;
}

SCOPE : 'scope' ;
FRAGMENT : 'fragment' ;
TREE_BEGIN : '^(' ;
ROOT : '^' ;
BANG : '!' ;
RANGE : '..' ;
REWRITE : '->' ;
T__65 : 'lexer' ;
T__66 : 'parser' ;
T__67 : 'tree' ;
T__68 : 'grammar' ;
T__69 : ';' ;
T__70 : '}' ;
T__71 : '=' ;
T__72 : '@' ;
T__73 : '::' ;
T__74 : '*' ;
T__75 : 'protected' ;
T__76 : 'public' ;
T__77 : 'private' ;
T__78 : 'returns' ;
T__79 : ':' ;
T__80 : 'throws' ;
T__81 : ',' ;
T__82 : '(' ;
T__83 : '|' ;
T__84 : ')' ;
T__85 : 'catch' ;
T__86 : 'finally' ;
T__87 : '+=' ;
T__88 : '=>' ;
T__89 : '~' ;
T__90 : '?' ;
T__91 : '+' ;
T__92 : '.' ;
T__93 : '$' ;

// $ANTLR src "src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3.g" 457
SL_COMMENT
 	:	'//'
 	 	(	' $ANTLR ' SRC // src directive
 		|	~('\r'|'\n')*
		)
		'\r'? '\n'
		{$channel=HIDDEN;}
	;

// $ANTLR src "src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3.g" 466
ML_COMMENT
	:	'/*' {if (input.LA(1)=='*') $type=DOC_COMMENT; else $channel=HIDDEN;} .* '*/'
	;

// $ANTLR src "src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3.g" 470
CHAR_LITERAL
	:	'\'' LITERAL_CHAR '\''
	;

// $ANTLR src "src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3.g" 474
STRING_LITERAL
	:	'\'' LITERAL_CHAR LITERAL_CHAR* '\''
	;

// $ANTLR src "src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3.g" 478
fragment
LITERAL_CHAR
	:	ESC
	|	~('\''|'\\')
	;

// $ANTLR src "src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3.g" 484
DOUBLE_QUOTE_STRING_LITERAL
	:	'"' (ESC | ~('\\'|'"'))* '"'
	;

// $ANTLR src "src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3.g" 488
DOUBLE_ANGLE_STRING_LITERAL
	:	'<<' .* '>>'
	;

// $ANTLR src "src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3.g" 492
fragment
ESC	:	'\\'
		(	'n'
		|	'r'
		|	't'
		|	'b'
		|	'f'
		|	'"'
		|	'\''
		|	'\\'
		|	'>'
		|	'u' XDIGIT XDIGIT XDIGIT XDIGIT
		|	. // unknown, leave as it is
		)
	;

// $ANTLR src "src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3.g" 508
fragment
XDIGIT :
		'0' .. '9'
	|	'a' .. 'f'
	|	'A' .. 'F'
	;

// $ANTLR src "src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3.g" 515
INT	:	'0'..'9'+
	;

// $ANTLR src "src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3.g" 518
ARG_ACTION
	:	NESTED_ARG_ACTION
	;

// $ANTLR src "src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3.g" 522
fragment
NESTED_ARG_ACTION :
	'['
	(	options {greedy=false; k=1;}
	:	NESTED_ARG_ACTION
	|	ACTION_STRING_LITERAL
	|	ACTION_CHAR_LITERAL
	|	.
	)*
	']'
	{setText(getText().substring(1, getText().length()-1));}
	;

// $ANTLR src "src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3.g" 535
ACTION
	:	NESTED_ACTION ( '?' {$type = SEMPRED;} )?
	;

// $ANTLR src "src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3.g" 539
fragment
NESTED_ACTION :
	'{'
	(	options {greedy=false; k=2;}
	:	NESTED_ACTION
	|	SL_COMMENT
	|	ML_COMMENT
	|	ACTION_STRING_LITERAL
	|	ACTION_CHAR_LITERAL
	|	.
	)*
	'}'
   ;

// $ANTLR src "src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3.g" 553
fragment
ACTION_CHAR_LITERAL
	:	'\'' (ACTION_ESC|~('\\'|'\'')) '\''
	;

// $ANTLR src "src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3.g" 558
fragment
ACTION_STRING_LITERAL
	:	'"' (ACTION_ESC|~('\\'|'"'))* '"'
	;

// $ANTLR src "src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3.g" 563
fragment
ACTION_ESC
	:	'\\\''
	|	'\\' '"' // ANTLR doesn't like: '\\"'
	|	'\\' ~('\''|'"')
	;

// $ANTLR src "src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3.g" 570
TOKEN_REF
	:	'A'..'Z' ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*
	;

// $ANTLR src "src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3.g" 574
RULE_REF
	:	'a'..'z' ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*
	;

// $ANTLR src "src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3.g" 578
/** Match the start of an options section.  Don't allow normal
 *  action processing on the {...} as it's not a action.
 */
OPTIONS
	:	'options' WS_LOOP '{'
	;
	
// $ANTLR src "src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3.g" 585
TOKENS
	:	'tokens' WS_LOOP '{'
	;

// $ANTLR src "src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3.g" 589
/** Reset the file and line information; useful when the grammar
 *  has been generated so that errors are shown relative to the
 *  original file like the old C preprocessor used to do.
 */
fragment
SRC	:	'src' ' ' file=ACTION_STRING_LITERAL ' ' line=INT
	;

// $ANTLR src "src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3.g" 597
WS	:	(	' '
		|	'\t'
		|	'\r'? '\n'
		)+
		{$channel=HIDDEN;}
	;

// $ANTLR src "src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3.g" 604
fragment
WS_LOOP
	:	(	WS
		|	SL_COMMENT
		|	ML_COMMENT
		)*
	;

