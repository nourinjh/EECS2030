
public class WordDefinitionPair {
	private String word;
	private String definition;

	public WordDefinitionPair(String w, String d) {
		this.word = w;
		this.definition = d;
	}

	public String getWord() {
		return this.word;
	}

	public String getDefinition() {
		return this.definition;
	}

	@Override
	public String toString() {

		return this.word + " " + this.definition;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null)
			return false;

		if (getClass() != o.getClass())
			return false;

		WordDefinitionPair w = (WordDefinitionPair) o;

		return this.word.equals(w.word) && this.definition.equals(w.definition);
	}
}
