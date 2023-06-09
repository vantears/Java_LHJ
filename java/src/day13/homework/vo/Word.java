package day13.homework.vo;

public class Word {
	//멤버 변수
	private String title;
	private String meaning[];
	private int meaningCount = 0;
	//생성자
	public Word(String title, String meaning) {
		this.title = title;
		this.meaning = new String[5];//기본 5개
		this.meaning[0] = meaning;
		meaningCount++;
	}
	public Word(String title) {
		this.title = title;
		this.meaning = new String[5];
	}
	
	public Word(Word w) {
		title = w.title;
		meaning = new String[5];
		for(int i = 0; i < w.meaningCount; i++) {
			meaning[i] = w.meaning[i];
		}
		meaningCount = w.meaningCount;
	}
	//메서드
	/**단어와 뜻을 출력하는 메서드
	 * 
	 */
	public void print() {
		System.out.println("Word : " + title);
		System.out.println("meaning : ");
		for(int i = 0; i < meaningCount; i++) {
				System.out.println(i + 1 + ". " + meaning[i]);
			}
	}
	
	/**뜻을 추가하는 메소드
	 * 매개변수 :
	 * 리턴타입 :
	 * 메서드명 :
	 */
	public void addMeaning(String meaning) {
		if(meaningCount == this.meaning.length) {
			System.out.println("The word's meaning list is full!");
			return;
		}
		this.meaning[meaningCount] = meaning;
		meaningCount++;
	}
	
	public boolean removeMeaning(int num) {
		if(num > meaningCount || num < 1) {
			//System.out.println("Out of meaning list!");
			return false;
		}
		for(int i = num - 1; i < meaningCount - 1; i++) {
			meaning[i] = meaning[i + 1];
		}
		meaning[meaningCount - 1] = null;
		meaningCount--;
		return true;
	}
	
	public boolean updateMeaning(int meaningNum, String meaning) {
		if(meaningNum > meaningCount || meaningNum <= 0) {
			return false;
		}
		this.meaning[meaningNum - 1 ] = meaning;
		return true;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


}