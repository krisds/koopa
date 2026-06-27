package koopa.core.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import koopa.core.grammars.Grammar;
import koopa.core.parsers.ParserCombinator;

public class Reflect {

	@SuppressWarnings("unchecked")
	public static <T> T asInstanceOf(Class<T> baseClass, String className) {

		try {
			Class<?> clazz = Class.forName(className);
			if (baseClass.isAssignableFrom(clazz))
				return (T) clazz.getDeclaredConstructor().newInstance();
		} catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException
				| InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static ParserCombinator getParser(Grammar grammar, String ruleName) {

		try {
			Method method = grammar.getClass().getMethod(ruleName);
			if (ParserCombinator.class.isAssignableFrom(method.getReturnType()))
				return (ParserCombinator) method.invoke(grammar);

		} catch (NoSuchMethodException | SecurityException | IllegalAccessException |
				IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return null;
	}

}
