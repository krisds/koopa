package koopa.core.trees.test;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static koopa.core.util.Iterables.collect;
import static koopa.core.util.test.Util.t;
import static koopa.core.util.test.Util.tree;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import koopa.core.data.Token;
import koopa.core.trees.Tree;

public class TreeIteratorsTest {

	private static final Token rear = t("Rear");
	private static final Token admiral = t("Admiral");
	private static final Tree rank = tree("rank", rear, admiral);
	private static final Token m = t("M");
	private static final Token dot = t(".");
	private static final Tree initials = tree("initials", m, dot);
	private static final Token grace = t("Grace");
	private static final Token hopper = t("Hopper");
	private static final Tree name = tree("name", grace, initials, hopper);
	private static final Tree subject = tree("subject", rank, name);

	@Test
	public void allTokens() {
		assertEquals(//
				asList(rear, admiral, grace, m, dot, hopper), //
				collect(subject.allTokens()));
		assertEquals(//
				asList(rear, admiral), //
				collect(rank.allTokens()));
		assertEquals(//
				asList(m, dot), //
				collect(initials.allTokens()));
		assertEquals(//
				asList(grace, m, dot, hopper), //
				collect(name.allTokens()));
	}

	@Test
	public void childTokens() {
		assertEquals(//
				emptyList(), //
				collect(subject.childTokens()));
		assertEquals(//
				asList(rear, admiral), //
				collect(rank.childTokens()));
		assertEquals(//
				asList(m, dot), //
				collect(initials.childTokens()));
		assertEquals(//
				asList(grace, hopper), //
				collect(name.childTokens()));
	}

	@Test
	public void childData() {
		assertEquals(//
				asList(rank.getData(), name.getData()), //
				collect(subject.childData()));
		assertEquals(//
				asList(rear, admiral), //
				collect(rank.childData()));
		assertEquals(//
				asList(m, dot), //
				collect(initials.childData()));
		assertEquals(//
				asList(grace, initials.getData(), hopper), //
				collect(name.childData()));
	}

	@Test
	public void childTrees() {
		assertEquals(//
				asList(rank, name), //
				collect(subject.childTrees()));
		assertEquals(//
				emptyList(), //
				collect(rank.childTrees()));
		assertEquals(//
				emptyList(), //
				collect(initials.childTrees()));
		assertEquals(//
				asList(initials), //
				collect(name.childTrees()));
	}
}
