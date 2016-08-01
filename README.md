# Koopa Cobol Parser

Koopa is a Cobol parser (generator). It can handle source files in isolation (no preprocessing required) and doesn't mind the presence of CICS/SQL fragments. The grammar is easily extensible in a way which minimizes the impact on the overall code.

## Features

* Island parser generator
* Cobol lexer and parser
* Accepts free and fixed format Cobol
* Covered by a Cobol 85 testsuite, and grammar unit testing
* Cobol viewer with syntax highlighting, outline, quick navigation and XPath-based querying
* XML dumps of parse trees
* Cobol preprocessor:
** copybook expansion with (limited) support for `REPLACING`
** `REPLACE` statement

## Licensing

Everything in Koopa is covered by a BSD license, unless noted differently in the actual file or folder.

The files in the `testsuite/cobol85` folder are a Cobol85 test suite by the National Computing Centre, UK, found originally at [www.itl.nist.gov](http://www.itl.nist.gov/div897/ctg/cobol_form.htm). The version here differs only in that it splits up the different programs in separate files, where the original puts them all in one big file. The licensing is unclear, but the code is offered publicly at the above site.

## Configuration options

Some runtime customisation of Koopa is possible by the user.

### Command line

Following options can be set on the command line by passing them as  "-D<option>=<value>" to the JVM.

* `koopa.maxCobolWordLength`: defaults to 31. Use a value greater than zero to override this. Setting it to 0 makes it use the default value. Setting it to a negative value disables the length check all together. (Cfr. the `koopa.cobol.CobolWords` class.)
* `koopa.sources`: a comma-separated list of file extensions use to identify Cobol source files. This defaults to "cbl,cob". (Cfr. the `koopa.cobol.CobolFiles` class.)
* `koopa.copybooks`: a comma-separated list of file extensions use to identify Cobol copybook files. This defaults to "cpy,copy". (Cfr. the `koopa.cobol.CobolFiles` class.)
* `koopa.copybooks.locator`: use a specific `koopa.cobol.copybooks.CopybookLocator` subclass when searching for copybooks on the file system. This defaults to `koopa.cobol.copybooks.DefaultCopybookLocator`.


### GUI

Some (most) of the command line options can also be set directly from the Koopa GUI, through the `Parser settings` menu.


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

### Java 5

The minimum target runtime environment for Koopa is Java 5. To that end the build script forces everything to be compiled to Java 5 compatible bytecode. This, however, is not enough to ensure Java 5 compatibility as you may still be compiling against the library of a later Java version. For that reason you also need to specify where the Java 5 runtime library can be found, by setting the `JAVA5_BOOTCLASSES` environment variable to its location.

You may see following message when building the project with ANT:

>     Please make sure JAVA5_BOOTCLASSES is set to a valid Java 5 bootstrap classpath.
>     You may get builds which are not compatible with java 5 otherwise.

This is a reminder from the build script that you have not specified where the Java 5 runtime library may be found.

### Parser Generation

Koopa Grammar files end in ".kg" (for "Koopa grammar"). These are processed by the koopa.dsl.kg.KGG class. You can pass it one of the following:

  1. A path to a specific .kg file, which it will then translate.
  2. A path to a folder, which will then be searched for .kg files, all of which will get translated.

All of this is taken care of by the ANT build script. If you make modifications to the standard Cobol.kg or one of the tests all you need to do is rerun ANT and everything should be taken care of.

If you're using an IDE such as Eclipse you may need to refresh your workspace after building with ANT.

### Tests

Koopa has unit tests covering the Koopa implementation. Look for package names named `test`, or check the different `run-FOO-tests` targets in the build script.

Note that many, if not most tests, are defined using custom formats. The grammar unit tests, for instance, are all in `.stage` files. I do this to reduce the amount of friction writing individual tests, so that new tests can be written more easily and in a shorter amount of time.

There is also support for regression testing based on the cobol85 testsuite. This will attempt to parse all source files (once with and once without preprocessing), and compare the results with those of a previous run. Look for the `run-cobol-regression-tests` build target.

All unit tests can be triggered from ANT. Simply invoke `ant run-tests` on the command line.


## Further reading

[Koopa Cobol Parser Web Site](http://koopa.sourceforge.net/); especially take a look at the [guide](http://koopa.sourceforge.net/guide.pdf).
