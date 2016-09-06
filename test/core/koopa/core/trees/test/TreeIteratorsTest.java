package koopa.core.trees.test;

import static java.util.Arrays.asList;
import static koopa.core.util.Iterables.collect;
import static koopa.core.util.test.Util.t;
import static koopa.core.util.test.Util.tree;
import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.trees.Tree;

import org.junit.Assert;
import org.junit.Test;

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
		Assert.assertEquals(//
				asList(new Token[] { rear, admiral, grace, m, dot, hopper }), //
				collect(subject.allTokens()));
		Assert.assertEquals(//
				asList(new Token[] { rear, admiral }), //
				collect(rank.allTokens()));
		Assert.assertEquals(//
				asList(new Token[] { m, dot }), //
				collect(initials.allTokens()));
		Assert.assertEquals(//
				asList(new Token[] { grace, m, dot, hopper }), //
				collect(name.allTokens()));
	}

	@Test
	public void childTokens() {
		Assert.assertEquals(//
				asList(new Token[] {}), //
				collect(subject.childTokens()));
		Assert.assertEquals(//
				asList(new Token[] { rear, admiral }), //
				collect(rank.childTokens()));
		Assert.assertEquals(//
				asList(new Token[] { m, dot }), //
				collect(initials.childTokens()));
		Assert.assertEquals(//
				asList(new Token[] { grace, hopper }), //
				collect(name.childTokens()));
	}

	@Test
	public void childData() {
		Assert.assertEquals(//
				asList(new Data[] { rank.getData(), name.getData() }), //
				collect(subject.childData()));
		Assert.assertEquals(//
				asList(new Data[] { rear, admiral }), //
				collect(rank.childData()));
		Assert.assertEquals(//
				asList(new Data[] { m, dot }), //
				collect(initials.childData()));
		Assert.assertEquals(//
				asList(new Data[] { grace, initials.getData(), hopper }), //
				collect(name.childData()));
	}

	@Test
	public void childTrees() {
		Assert.assertEquals(//
				asList(new Tree[] { rank, name }), //
				collect(subject.childTrees()));
		Assert.assertEquals(//
				asList(new Tree[] {}), //
				collect(rank.childTrees()));
		Assert.assertEquals(//
				asList(new Tree[] {}), //
				collect(initials.childTrees()));
		Assert.assertEquals(//
				asList(new Tree[] { initials }), //
				collect(name.childTrees()));
	}
}
