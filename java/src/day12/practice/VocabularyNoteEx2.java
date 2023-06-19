package day12.practice;

public class VocabularyNoteEx2 {

	public static void main(String[] args) {
		Word wordList[] = {
				new Word("abc"),
				new Word("def", "def is define")
		};
		wordList[1].addMeaning("It is also different");
		Word w1 = new Word("Happy", "I'm Happy");
		VocabularyNote note = new VocabularyNote(wordList);
		note.print();
		note.addWord(w1);
		note.print();
		note.removeWord(1);
		note.print();
		note.addWord("def", "new meaning");
		note.print();
		

	}

}