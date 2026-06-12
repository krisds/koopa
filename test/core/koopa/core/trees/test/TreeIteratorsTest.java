package koopa.core.trees.test;

import static java.util.Arrays.asList;
import static koopa.core.util.Iterables.collect;
import static koopa.core.util.test.Util.t;
import static koopa.core.util.test.Util.tree;
import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.trees.Tree;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

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
				asList(new Token[] { rear, admiral, grace, m, dot, hopper }), //
				collect(subject.allTokens()));
		assertEquals(//
				asList(new Token[] { rear, admiral }), //
				collect(rank.allTokens()));
		assertEquals(//
				asList(new Token[] { m, dot }), //
				collect(initials.allTokens()));
		assertEquals(//
				asList(new Token[] { grace, m, dot, hopper }), //
				collect(name.allTokens()));
	}

	@Test
	public void childTokens() {
		assertEquals(//
				asList(new Token[] {}), //
				collect(subject.childTokens()));
		assertEquals(//
				asList(new Token[] { rear, admiral }), //
				collect(rank.childTokens()));
		assertEquals(//
				asList(new Token[] { m, dot }), //
				collect(initials.childTokens()));
		assertEquals(//
				asList(new Token[] { grace, hopper }), //
				collect(name.childTokens()));
	}

	@Test
	public void childData() {
		assertEquals(//
				asList(new Data[] { rank.getData(), name.getData() }), //
				collect(subject.childData()));
		assertEquals(//
				asList(new Data[] { rear, admiral }), //
				collect(rank.childData()));
		assertEquals(//
				asList(new Data[] { m, dot }), //
				collect(initials.childData()));
		assertEquals(//
				asList(new Data[] { grace, initials.getData(), hopper }), //
				collect(name.childData()));
	}

	@Test
	public void childTrees() {
		assertEquals(//
				asList(new Tree[] { rank, name }), //
				collect(subject.childTrees()));
		assertEquals(//
				asList(new Tree[] {}), //
				collect(rank.childTrees()));
		assertEquals(//
				asList(new Tree[] {}), //
				collect(initials.childTrees()));
		assertEquals(//
				asList(new Tree[] { initials }), //
				collect(name.childTrees()));
	}
}
