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
		suite.addTestSuite(AcceptStatementTest.class);
		suite.addTestSuite(AllocateStatementTest.class);
		suite.addTestSuite(CallStatementTest.class);
		suite.addTestSuite(CancelStatementTest.class);
		suite.addTestSuite(ChainStatementTest.class);
		suite.addTestSuite(CloseStatementTest.class);
		suite.addTestSuite(ComputeStatementTest.class);
		suite.addTestSuite(ConditionsTest.class);
		// suite.addTestSuite(ConditionalCompilationStatementsTest.class);
		suite.addTestSuite(CopyStatementTest.class);
		suite.addTestSuite(DataDivisionTest.class);
		suite.addTestSuite(DebugStatementsTest.class);
		suite.addTestSuite(DeleteStatementTest.class);
		suite.addTestSuite(DeleteFileStatementTest.class);
		suite.addTestSuite(DisplayStatementTest.class);
		suite.addTestSuite(DivideStatementTest.class);
		suite.addTestSuite(EntryStatementTest.class);
		suite.addTestSuite(EnvironmentDivisionTest.class);
		suite.addTestSuite(EvaluateStatementTest.class);
        suite.addTestSuite(ExamineStatementTest.class);
		suite.addTestSuite(ExecStatementTest.class);
		suite.addTestSuite(ExhibitStatementTest.class);
		suite.addTestSuite(ExitStatementTest.class);
        suite.addTestSuite(FileControlParagraphTest.class);
		suite.addTestSuite(FileDescriptionEntryTest.class);
		suite.addTestSuite(FileSectionTest.class);
		suite.addTestSuite(FreeStatementTest.class);
		suite.addTestSuite(FunctionTest.class);
		suite.addTestSuite(GobackStatementTest.class);
		suite.addTestSuite(GoToStatementTest.class);
		suite.addTestSuite(IdentificationDivisionTest.class);
		suite.addTestSuite(IdentifiedByStatementTest.class);
		suite.addTestSuite(IfStatementTest.class);
		suite.addTestSuite(InspectStatementTest.class);
		suite.addTestSuite(InvokeStatementTest.class);
		// suite.addTestSuite(ListingControlStatementsTest.class);
		suite.addTestSuite(MergeStatementTest.class);
		suite.addTestSuite(MoveStatementTest.class);
		suite.addTestSuite(MultiplyStatementTest.class);
		suite.addTestSuite(OnStatementTest.class);
		suite.addTestSuite(OpenStatementTest.class);
		suite.addTestSuite(PerformStatementTest.class);
		suite.addTestSuite(ProcedureDivisionTest.class);
        suite.addTestSuite(RaiseStatementTest.class);
		suite.addTestSuite(ReadStatementTest.class);
		suite.addTestSuite(ReleaseStatementTest.class);
		suite.addTestSuite(ReplaceStatementTest.class);
		suite.addTestSuite(ReportWriterStatementsTest.class);
        suite.addTestSuite(RepositoryParagraphTest.class);
		suite.addTestSuite(ReturnStatementTest.class);
		suite.addTestSuite(RewriteStatementTest.class);
		suite.addTestSuite(SearchStatementTest.class);
        suite.addTestSuite(ServiceStatementTest.class);
        suite.addTestSuite(SetStatementTest.class);
        suite.addTestSuite(SpecialNamesParagraphTest.class);
        suite.addTestSuite(SortStatementTest.class);
		suite.addTestSuite(StartStatementTest.class);
		suite.addTestSuite(StopStatementTest.class);
		suite.addTestSuite(StringStatementTest.class);
		suite.addTestSuite(SubtractStatementTest.class);
		suite.addTestSuite(TransactionStatementsTest.class);
		suite.addTestSuite(TransformStatementTest.class);
		suite.addTestSuite(UnlockStatementTest.class);
		suite.addTestSuite(UnstringStatementTest.class);
		suite.addTestSuite(UseStatementTest.class);
		suite.addTestSuite(WaitStatementTest.class);
		suite.addTestSuite(WriteStatementTest.class);
		suite.addTestSuite(XmlStatementsTest.class);
		suite.addTestSuite(KeywordsTest.class);
		return suite;
	}
}
