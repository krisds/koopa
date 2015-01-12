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

		scope.enter("one", 1);
		Assert.assertEquals(1, scope.getReference());
		Assert.assertEquals(2, scope.getDepth());

		scope.enter("two", 2);
		Assert.assertEquals(2, scope.getReference());
		Assert.assertEquals(3, scope.getDepth());

		scope.enter("three", 3);
		Assert.assertEquals(3, scope.getReference());
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

		scope.enter("identification division", null);
		scope.set("name", "Cobol");
		scope.setReturnValueFrom("name");
		scope.leave("identification division");

		Assert.assertEquals("Cobol", scope.get("program name"));
	}
}
