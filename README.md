# Koopa Cobol Parser

Koopa is a Cobol parser (generator). It can handle source files in isolation (no preprocessing required) and doesn't mind the presence of CICS/SQL fragments. The grammar is easily extensible in a way which minimizes the impact on the overall code.

## Features

* Cobol lexer and parser (generator)
* Accepts free and fixed format Cobol
* Covered by a Cobol 85 testsuite, and grammar unit testing
* Cobol viewer with syntax highlighting, outline, quick navigation and XPath-based querying
* XML dumps of parse trees
* Experimental, work in progress: Cobol preprocessor (copy book expansion only)

## Licensing

Everything in Koopa is covered by a BSD license, unless noted differently in the actual file or folder.

The files in the testsuite/cobol85 folder are a Cobol85 test suite by the National Computing Centre, UK, found originally at [www.itl.nist.gov](http://www.itl.nist.gov/div897/ctg/cobol_form.htm). The version here differs only in that it splits up the different programs in separate files, where the original puts them all in one big file. The licensing is unclear, but the code is offered publicly at the above site.

## Configuration options

Some customisation of Koopa is possible by the user.

### Command line

Following options can be set on the command line by passing them as  "-D<option>=<value>" to the JVM.

* koopa.maxCobolWordLength: defaults to 31. Use a value greater than zero to override this. Setting it to 0 makes it use the default value. Setting it to a negative value disables the length check all together.

### Custom columns

The user can add custom XPath queries to the standard parsing overview tab.

To enable this, users should update their koopa.properties file with a `koopa.customColumns` property containing a comma-separated list of string identifiers. For every identifier, there should be `koopa.customColumn.<identifier>.title` and `koopa.customColumn.<identifier>.xpath` properties.

For example:

    koopa.customColumns=statements,functions

    koopa.customColumn.statements.title=Statement Calls
    koopa.customColumn.statements.xpath=count(//statement)

    koopa.customColumn.functions.title=Function Calls
    koopa.customColumn.functions.xpath=count(//function)

Complex XPath query results should be presented in serialized form.

## Technical Info (for Developers)

### Parser Generation

Koopa Grammar files end in ".kg" (for "Koopa grammar"). These are processed by the koopa.grammars.generator.KGG class, which needs three arguments:

  1. The name of the grammar, without the ".kg" extension.
  2. The target java package the generated parser will be part of.
  3. The target folder to save the generated parser in.

Koopa can also take these grammar files and translate them into an equivalent ANTLR tree grammar. These tree grammars may then be used (modified or not) in the backend. The generator is class koopa.trees.antlr.generator.KGToANTLR.

All of this is taken care of by the ANT build script. If you make modifications to the standard Cobol.kg or one of the tests all you need to do is rerun ANT and everything should be taken care of.

If you're using an IDE such as Eclipse you may need to refresh your workspace after building with ANT.

### Unit Tests

Koopa has unit tests covering (parts of) the Koopa implementation. These can be found in koopa.parsers.test.

Koopa also has unit tests covering (part of) the generated Cobol parser. These reside in koopa.grammars.cobol.test. The unit tests are generated from the ".stage" files which reside in the same folder. Generation is handled by the koopa.grammars.test.generator.GenerateUnitTests class (also triggered by the build script).

All unit tests can be triggered from ANT. Simply invoke "ant run-tests" on the command line.

There is also support for regression testing based on the cobol85 testsuite. The class which takes care of this is koopa.grammars.test.RegressionTest. Again, you can also run this test through an ANT call: "ant run-regression-test".

### Other Tests

Aside from the unit tests there are a few other test applications inside the sandbox. One is TokenizerTest, which verifies if a certain line yields the expected number of tokens (if the line is annotated with the expected number). There is also ParserTest which attempts to parse a testsuite of Cobol files. Finally, there is CommonTreeBuildingTest which parses the same testsuite, builds ANTLR ASTs for each file, and the uses the generated ANTLR tree parser to parse those ASTs.

Some tests may complain about not being able to parse the following file: testsuite/cobol85/OBNC1M.CBL. This is normal. The file in question tests comment-entries, which were deprecated in the 1985 standard. The Koopa Cobol parser does not know how to handle these. Given the deprecated nature of this language feature I won't be adding support for it either.

There may be other warnings and errors. This is quite likely as expected. When in doubt, contact the maintainers.

### KG.tokens

In koopa.trees.antlr.generator, KG.tokens is a copy of the file with the same name from koopa.grammars.generator. If the original ever changes this means that the KGToANTLR generator is broken. In that case you need to update its tokens file. Again, the ANT build script takes care of this for you.

## Further reading

[Koopa Cobol Parser Web Site](http://koopa.sourceforge.net/).

## "The BSD License"

Copyright (c) 2009, the Koopa Cobol Parser. All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

* Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.

* Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
    
* Neither the name of the Koopa Cobol Parser nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
