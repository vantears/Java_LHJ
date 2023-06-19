package day12.practice;

public class VocabularyNote {
	
	private Word wordList[];
	private int wordCount;
	
	public VocabularyNote() {
		wordList = new Word[10];
	}
	
	public VocabularyNote(Word word) {
		wordList = new Word[10];
		wordList[0] = new Word(word);
		wordCount++;
	}

	public VocabularyNote(Word wordList[]) {
		int size = wordList.length > 10 ? wordList.length : 10;
		this.wordList = new Word[size];
		for(int i = 0; i < wordList.length; i++) {
			this.wordList[i] = new Word(wordList[i]);
		}
		wordCount = wordList.length;
	}
	
	public void print() {
		System.out.println("==============");
		for(int i = 0; i < wordCount; i++) {
			wordList[i].print();
			if(i != wordCount-1) {
				System.out.println("--------------");				
			}
		}
		System.out.println("==============");
	}
	public void addWord(Word word) {
		if(wordCount == wordList.length) {
			System.out.println("The vocabulary list is full!");
			return;
		}
		wordList[wordCount] = new Word(word);
		wordCount++;
	}
	public void removeWord(int num) {
		if(num > wordCount || num < 1) {
			System.out.println("Out of word list!");
			return;
		}
		for(int i = num - 1; i < wordCount - 1; i++) {
			wordList[i] = wordList[i + 1];
		}
		wordList[wordCount - 1] = null;
		wordCount--;
	}
	
	public void addWord(String word, String meaning) {
		for(int i = 0; i > wordCount; i++) {
			if(!wordList[i].getTitle().equals(word)) {
				wordList[wordCount] = new Word(word, meaning);
				return;
			}
			wordList[i].addMeaning(meaning);
		}
	}

}
