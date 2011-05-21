package koopa.grammars.cobol.test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class CobolGrammarTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Cobol Grammar test suite.");

		suite.addTestSuite(SourceFormatTest.class);

		suite.addTestSuite(LowLevelTest.class);
		suite.addTestSuite(IdentifierTest.class);
		suite.addTestSuite(CatchAllStatementsTest.class);

		suite.addTestSuite(ArithmeticExpressionTest.class);

		suite.addTestSuite(AddStatementTest.class);
		suite.addTestSuite(CallStatementTest.class);
		suite.addTestSuite(CancelStatementTest.class);
		suite.addTestSuite(CloseStatementTest.class);
		suite.addTestSuite(ComputeStatementTest.class);
		suite.addTestSuite(CopyStatementTest.class);
		suite.addTestSuite(DataDivisionTest.class);
		suite.addTestSuite(DeleteStatementTest.class);
		suite.addTestSuite(DivideStatementTest.class);
		suite.addTestSuite(EntryStatementTest.class);
		suite.addTestSuite(EnvironmentDivisionTest.class);
		suite.addTestSuite(EvaluateStatementTest.class);
		suite.addTestSuite(ExecStatementTest.class);
		suite.addTestSuite(ExitStatementTest.class);
		suite.addTestSuite(FileDescriptionEntryTest.class);
		suite.addTestSuite(FunctionTest.class);
		suite.addTestSuite(GoToStatementTest.class);
		suite.addTestSuite(IdentificationDivisionTest.class);
		suite.addTestSuite(IfStatementTest.class);
		suite.addTestSuite(InspectStatementTest.class);
		suite.addTestSuite(MoveStatementTest.class);
		suite.addTestSuite(MultiplyStatementTest.class);
		suite.addTestSuite(OpenStatementTest.class);
		suite.addTestSuite(PerformStatementTest.class);
		suite.addTestSuite(ProcedureDivisionTest.class);
		suite.addTestSuite(ReadStatementTest.class);
		suite.addTestSuite(ReleaseStatementTest.class);
		suite.addTestSuite(ReturnStatementTest.class);
		suite.addTestSuite(RewriteStatementTest.class);
		suite.addTestSuite(SearchStatementTest.class);
		suite.addTestSuite(StartStatementTest.class);
		suite.addTestSuite(StopStatementTest.class);
		suite.addTestSuite(StringStatementTest.class);
		suite.addTestSuite(SubtractStatementTest.class);
		suite.addTestSuite(UnstringStatementTest.class);
		suite.addTestSuite(WriteStatementTest.class);

		return suite;
	}
}
