package day12.practice;

public class VocabularyNoteEx {

	public static void main(String[] args) {
		Word word1 = new Word("Vocabulary", "The words that make up a language.");
		word1.addMeaning("A");
		word1.print();
		word1.addMeaning("B");
		word1.addMeaning("C");
		word1.addMeaning("D");
		word1.print();
		word1.addMeaning("E");
		word1.print();
		word1.removeMeaning(4);
		word1.print();
	}

}