/*
 [The "BSD licence"]
 Copyright (c) 2005-2007 Terence Parr
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

/** ANTLR v3 tree grammar to walk trees created by ANTLRv3.g */
tree grammar ANTLRv3TreeFilter;

options {
	tokenVocab = ANTLRv3;
	ASTLabelType = CommonTree;
  output = template;
}

@header {
  package koopa.trees.antlr.filter.generator;
  
  import java.util.List;
  import java.util.LinkedList;
}

@members {
  private String scope = null;
}

grammarDef [String pack]
  : ^( grammarType ID
       
       { scope = $ID.text; }
       
       DOC_COMMENT? optionsSpec? tokensSpec? attrScope* action* (r+=rule)+ )
    
    -> filter(
       id = {$ID},
       rule={$r},
       pack = {pack}
    )
  ;

grammarType
  : LEXER_GRAMMAR
    { if (true) throw new UnsupportedSyntaxException("Only tree grammars are allowed."); }
  | PARSER_GRAMMAR
    { if (true) throw new UnsupportedSyntaxException("Only tree grammars are allowed."); }
  | TREE_GRAMMAR
  | COMBINED_GRAMMAR
    { if (true) throw new UnsupportedSyntaxException("Only tree grammars are allowed."); }
  ;

tokensSpec
	:	^(TOKENS tokenSpec+)
	;

tokenSpec
	:	^('=' TOKEN_REF STRING_LITERAL)
	|	^('=' TOKEN_REF CHAR_LITERAL)
	|	TOKEN_REF
	;

attrScope
	:	^('scope' ID ACTION)
	;

action
	:	^('@' ID ID ACTION)
	|	^('@' ID ACTION)
	;

optionsSpec
	:	^(OPTIONS option+)
	;

option
    :   ^('=' ID optionValue)
 	;
 	
optionValue
    :   ID
    |   STRING_LITERAL
    |   CHAR_LITERAL
    |   INT
    ;

rule
	:	^( RULE ID
	       
	     modifier? (^(ARG ARG_ACTION))? (^(RET ARG_ACTION))?
	     optionsSpec? ruleScopeSpec? ruleAction*
	     
	     al=altList
       
       exceptionGroup?
       EOR
    )
	     
	  -> rule(
	     id = {$ID},
	     body = {al}
	  )
	;

modifier
	:	'protected'|'public'|'private'|'fragment'
	;

/** Match stuff like @init {int i;} */
ruleAction
	:	^('@' ID ACTION)
	;

throwsSpec
	:	^('throws' ID+)
	;

ruleScopeSpec
	:	^('scope' ACTION)
	|	^('scope' ACTION ID+)
	|	^('scope' ID+)
	;

block
  : { List<StringTemplate> alts = new LinkedList<StringTemplate>(); }
  
    ^( BLOCK optionsSpec?
       ( a=alternative rewrite
         { if (!$a.st.toString().equals("epsilon")) {
             alts.add($a.st);
           }
         }
       )+
       EOB
    )
    
    -> {alts.size() == 1}? {alts.get(0)}
    -> or(
       alternative = {alts}
    )
  ;

altList
  : { List<StringTemplate> alts = new LinkedList<StringTemplate>(); }
  
    ^( BLOCK
       ( a=alternative rewrite
         { if (!$a.st.toString().equals("epsilon")) {
             alts.add($a.st);
           }
         }
       )+
       EOB
    )
    
    -> {alts.size() == 1}? {alts.get(0)}
    -> or(
       alternative = {alts}
    )
  ;

alternative
  : { List<StringTemplate> elts = new LinkedList<StringTemplate>(); }
  
    ^( ALT
       ( e=element
         { if (!$e.st.toString().equals("epsilon")) {
             elts.add($e.st);
           }
         }
       )+
       EOA
    )

    -> {elts.size() == 1}? {elts.get(0)}
    -> seq(
       element = {elts}
    )

  | ^( ALT EPSILON
       EOA
     )
     
     -> {%{"[>EPSILON<]"}}
  ;

exceptionGroup
	:	exceptionHandler+ finallyClause?
	|	finallyClause
    ;

exceptionHandler
    :    ^('catch' ARG_ACTION ACTION)
    ;

finallyClause
    :    ^('finally' ACTION)
    ;

element
	:	elementNoOptionSpec
	   
	   -> {$elementNoOptionSpec.st}
	;

elementNoOptionSpec
	:	^(('='|'+=') ID block)

    -> {$block.st}

	|	^(('='|'+=') ID atom)

    -> {$atom.st}

	|	atom

    -> {$atom.st}

	|	ebnf

    -> {$ebnf.st}

	|   ACTION

    -> {%{"epsilon"}}

	|   SEMPRED

    -> {%{"[>SEMPRED<]"}}

	|	GATED_SEMPRED

    -> {%{"[>GATED_SEMPRED<]"}}

	|   treeSpec

    -> {$treeSpec.st}
	;

atom
  : ^(('^'|'!') atom)

    -> {%{"[>^!atom<]"}}

	| range

    -> {%{"[>range<]"}}

	| notSet

    -> {%{"[>notset<]"}}

  | ^(RULE_REF ARG_ACTION)

    -> ref(
       id = {$RULE_REF}
    )

  | RULE_REF

    -> ref(
       id = {$RULE_REF}
    )

  | terminal

    -> {$terminal.st}
  ;

notSet
	:	^('~' notTerminal)
	|	^('~' block)
	;

treeSpec
	:	{ List<StringTemplate> elts = new LinkedList<StringTemplate>(); }
  
    ^( TREE_BEGIN
    
       // TODO Any "element" here is possible. Should throw unsupported exception error in non-token cases.
    
       TOKEN_REF
       
       ( e=element
         { if (!$e.st.toString().equals("epsilon")) {
             elts.add($e.st);
           }
         }
       )*
    )

    -> {elts.size() == 1}? subtree(
       element={elts.get(0)},
       scop={scope},
       id={$TOKEN_REF}
    ) 
    
    -> subtree(
       element={elts},
       scop={scope},
       id={$TOKEN_REF}
    )
	;

/** Matches ENBF blocks (and token sets via block rule) */
ebnf
	:	^(SYNPRED block)

    -> {%{"[>SYNPRED<]"}}

	|	SYN_SEMPRED

    -> {%{"[>SYN_SEMPRED<]"}}

  | ^(OPTIONAL block)

    -> opt(
      block = {$block.st}
    )

  | ^(CLOSURE block)

    -> star(
      block = {$block.st}
    )

  | ^(POSITIVE_CLOSURE block)

    { if (true) throw new UnsupportedSyntaxException("Positive closures not supported (yet)."); }

    -> {%{"[>POSITIVE_CLOSURE block<]"}}

	|	block

    -> {$block.st}

	;

range
	:	^(CHAR_RANGE CHAR_LITERAL CHAR_LITERAL)
	;

terminal
  : CHAR_LITERAL

    -> {%{"[>CHAR_LITERAL<]"}}

  |	TOKEN_REF

    -> token(
       id = {$TOKEN_REF},
       scop = {scope}
    )

  |	STRING_LITERAL

    { String val = $STRING_LITERAL.text;
      val = val.substring(1, val.length() - 1);
    }

    -> literal(
       value = {val}
    )

  |	^(TOKEN_REF ARG_ACTION)

    -> {%{"[>TOKEN_REF ARG_ACTION<]"}}

  |	'.'

    -> {%{"[>.<]"}}

	;

notTerminal
	: CHAR_LITERAL
	|	TOKEN_REF
	|	STRING_LITERAL
	;
	
ebnfSuffix
	:	OPTIONAL

    -> {%{"[>OPTIONAL<]"}}

  |	CLOSURE

    -> {%{"[>CLOSURE<]"}}

  |	POSITIVE_CLOSURE

    -> {%{"[>POSITIVE_CLOSURE<]"}}
	;
	
// R E W R I T E  S Y N T A X

rewrite
	:	(^('->' SEMPRED rewrite_alternative))* ^('->' rewrite_alternative)
	|
	;

rewrite_alternative
	:	rewrite_template
	|	rewrite_tree_alternative
   	|   ^(ALT EPSILON EOA)
	;
	
rewrite_tree_block
    :   ^(BLOCK rewrite_tree_alternative EOB)
    ;

rewrite_tree_alternative
    :	^(ALT rewrite_tree_element+ EOA)
    ;

rewrite_tree_element
	:	rewrite_tree_atom
	|	rewrite_tree
	|   rewrite_tree_block
	|   rewrite_tree_ebnf
	;

rewrite_tree_atom
    :   CHAR_LITERAL
	|   TOKEN_REF
	|   ^(TOKEN_REF ARG_ACTION) // for imaginary nodes
    |   RULE_REF
	|   STRING_LITERAL
	|   LABEL
	|	ACTION
	;

rewrite_tree_ebnf
	:	^(ebnfSuffix rewrite_tree_block)
	;
	
rewrite_tree
	:	^(TREE_BEGIN rewrite_tree_atom rewrite_tree_element* )
	;

rewrite_template
	:   ^( TEMPLATE ID rewrite_template_args
		   (DOUBLE_QUOTE_STRING_LITERAL | DOUBLE_ANGLE_STRING_LITERAL)
		 )
	|	rewrite_template_ref
	|	rewrite_indirect_template_head
	|	ACTION
	;

/** foo(a={...}, ...) */
rewrite_template_ref
	:	^(TEMPLATE ID rewrite_template_args)
	;

/** ({expr})(a={...}, ...) */
rewrite_indirect_template_head
	:	^(TEMPLATE ACTION rewrite_template_args)
	;

rewrite_template_args
	:	^(ARGLIST rewrite_template_arg+)
	|	ARGLIST
	;

rewrite_template_arg
	:   ^(ARG ID ACTION)
	;
