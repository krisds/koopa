package koopa.examples.treegrammars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import koopa.core.treegrammars.TreeGrammar;

public abstract class CobolStructureBaseGrammar extends TreeGrammar {

	private Map<String, Integer> wordFrequencies = new HashMap<String, Integer>();

	protected void process(String type, String name) {

		String[] words = name.split("(\\s+|-+)");

		for (String word : words) {
			if (word.matches("^\\d+$"))
				continue;

			if (!wordFrequencies.containsKey(word))
				wordFrequencies.put(word, 1);
			else
				wordFrequencies.put(word, wordFrequencies.get(word) + 1);
		}
	}

	protected void reportWordFrequencies() {
		System.out.println("-- Word Frequencies --");

		final List<String> words = new ArrayList<String>(
				wordFrequencies.keySet());
		Collections.sort(words);

		for (int i = 0; i < words.size(); i++) {
			String word = words.get(i);

			if (i > 0)
				System.out.print(", ");

			if (i > 0 && i % 5 == 0)
				System.out.println();

			final int frequency = wordFrequencies.get(word);
			if (frequency == 1)
				System.out.print(word);
			else
				System.out.print(word + "/" + frequency);
		}

		System.out.println();
	}
}
