package koopa.core.treegrammars.test;

import junit.framework.Assert;
import koopa.core.treegrammars.ParsingContext;

import org.junit.Test;

public class ParsingContextTest {

	@Test
	public void canStoreValue() {
		ParsingContext scope = new ParsingContext();

		scope.set("name", "Cobol");

		Assert.assertEquals("Cobol", scope.get("name"));
	}

	@Test
	public void canGrowAndUnwindTheStack() {
		ParsingContext scope = new ParsingContext();
		Assert.assertEquals(1, scope.getDepth());

		scope.enter("one");
		Assert.assertEquals(2, scope.getDepth());

		scope.enter("two");
		Assert.assertEquals(3, scope.getDepth());

		scope.enter("three");
		Assert.assertEquals(4, scope.getDepth());

		scope.leave("three");
		Assert.assertEquals(3, scope.getDepth());

		scope.leave("two");
		Assert.assertEquals(2, scope.getDepth());

		scope.leave("one");
		Assert.assertEquals(1, scope.getDepth());
	}

	@Test
	public void canGetReturnValueFromStackFrame() {
		ParsingContext scope = new ParsingContext();

		scope.setLValueReceiver("program name");

		scope.enter("identification division");
		scope.set("name", "Cobol");
		scope.setReturnValueFrom("name");
		scope.leave("identification division");

		Assert.assertEquals("Cobol", scope.get("program name"));
	}
}
