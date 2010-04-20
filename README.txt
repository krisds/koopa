This is Koopa, a parser generator made for the purpose of easily defining and
generating COBOL parsers.

Everything in Koopa is covered by a BSD license (see LICENSE.txt), unless noted
differently in the actual file or folder.

The files in the testsuite/cobol85 folder are a Cobol85 test suite by the National Computing Centre, UK, found originally at http://www.itl.nist.gov/div897/ctg/cobol_form.htm. The version here differs only in that it splits up the different programs in separate files, where the original puts them all in one big file. The licensing is unclear, but the code is offered publicly at the above site.

= Generation =

Grammar files end in ".kg" (for "Koopa grammar"). These are processed by the
koopa.grammars.generator.KGG class, which needs three arguments:

  1. The name of the grammar, without the ".kg" extension.
  2. The target java package the generated parser will be part of.
  3. The target folder to save the generated parser in.

Koopa can also take these grammar files and translate them into an equivalent
ANTLR tree grammar. These tree grammars may then be used (modified or not) in
the backend. The generator is class koopa.trees.antlr.generator.KGToANTLR.

All generation phases may be triggered manually. Alternatively you can also use
the ANT build script found in the root folder. Choose the "regenerate" target.
After any regeneration you need to refresh your Eclipse project. This will also
trigger the ANTLR builders which will process any newly generated grammars.

= Unit tests =

Koopa has unit tests covering (parts of) the Koopa implementation. These can
be found in koopa.parsers.test.

Koopa also has unit tests covering (part of) the generated Cobol parser. These
reside in koopa.grammars.cobol.test. The unit tests are generated from the
".stage" files which reside in the same folder. Generation is handled by the
koopa.grammars.test.generator.GenerateUnitTests class (also triggered by the
build script).

= Other tests =

Aside from the unit tests there are a few other test applications inside the
sandbox. One is TokenizerTest, which verifies if a certain line yields the
expected number of tokens (if the line is annotated with the expected number).
There is also ParserTest which attempts to parse a testsuite of Cobol files.
Finally, there is CommonTreeBuildingTest which parses the same testsuite, builds
ANTLR ASTs for each file, and the uses the generated ANTLR tree parser to parse
those ASTs.

Some tests may complain about not being able to parse the following file:
  testsuite/cobol85/OBNC1M.CBL
This is normal. The file in question tests comment-entries, which were
deprecated in the 1985 standard. The Koopa Cobol parser does not know how to
handle these. Given the deprecated nature of this language feature I won't be
adding support for it either.

There may be other warnings and errors. This is quite likely as expected. When
in doubt, contact the maintainers.

= KG.tokens =

In koopa.trees.antlr.generator, KG.tokens is a manual copy of the file with
the same name from koopa.grammars.generator. If the original ever changes this
means that the KGToANTLR generator is broken. In that case you need to update
its tokens file. The ANT build script has a target to do this for you
(SynchronizeKGTokens). 

Do note that if a tokens file has changed, the grammar may not automatically
get recompiled! If it doesn't you will likely start seeing very strange errors.
The only solution for now is to manually trigger a recompilation of the
affected grammars.
