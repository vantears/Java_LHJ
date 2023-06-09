package day13.homework.controller;
import java.util.Scanner;

import javax.annotation.processing.AbstractProcessor;

import day13.homework.vo.VocabularyNote;

public class VocabularyNoteController {
	
	private Scanner sc = new Scanner(System.in);
	private VocabularyNote note = new VocabularyNote();
	
	public void run() {
		int menu;
		
		//DO WHILE(UNTIL 'QUIT' IS SELECTED)
		do {
			
			//PRINT MENU
			printMenu();
			//SELECT MENU
			menu = sc.nextInt();
			//OPERATE THE FUNTION OF THE MENU SELECTED
			runMenu(menu);

		} while(menu != 5);
		
		sc.close();
		
	}
	/**A METHOD TO PRINT MENU
	 * PARAMETER : Null
	 * RETURN TYPE : Void
	 * METHOD NAME : printMenu
	 */
	private void printMenu() {
		System.out.println("MENU");
		System.out.println("1. Add a word");
		System.out.println("2. Delete a word");
		System.out.println("3. Modify a word");
		System.out.println("4. Print a word");
		System.out.println("5. Quit");
		System.out.println("Select an option : ");
	}
	
	/**A METHOD TO OPERATE THE SELECTED MENU
	 * PARAMETER : Null
	 * RETURN TYPE : Void
	 * METHOD NAME : runMenu
	 */
	private void runMenu(int menu) {
		
		switch(menu) {
		
		//IF 1 IS SELECTED, OPERATE THE ADD WORD FUNCTION
		case 1:
			System.out.println("===================");
			insertWord();
			System.out.println("===================");
			break;
		//IF 2 IS SELECTED, OPERATE THE DELETE WORD FUNCTION
		case 2:
			System.out.println("===================");
			deleteWord();
			System.out.println("===================");
			break;
		//IF 3 IS SELECTED, OPERATE THE MODIFY WORD FUNCTION
		case 3:
			System.out.println("===================");
			updateWord();
			System.out.println("===================");
			break;
		//IF 4 IS SELECTED, OPERATE THE PRINT WORD FUNCTION
		case 4:
			System.out.println("===================");
			printWord();
			System.out.println("===================");
			break;
		//IF 5 IS SELECTED, QUIT THE PROGRAM
		case 5:
			System.out.println("===================");
			System.out.println("Quit the program!");
			System.out.println("===================");
			break;
		//IF OUT THE RANGE, PRINT "THE SELECTED OPTION IS WRONG"
		default:
			System.out.println("=============");
			System.out.println("The selected option is wrong!");
			System.out.println("=============");
		//PRINT SUB-MENU IF THERE IS
		
		//SELECT SUB-MENU
			}
		}
	
	private void insertWord() {
		//Enter a word to add
		System.out.print("Word : ");
		String title = sc.next();
		//process the enter key in the adding word
		sc.nextLine();
		//Enter a meaning to add
		System.out.print("Meaning : ");
		String meaning = sc.nextLine();
		//add the word and meaning into the vocabulary note.
		int result = note.insert(title, meaning);
		
		switch(result) {
		case 1: System.out.println("The word has been successfully added!"); break;
		case -1: System.out.println("The meaning has been successfully added!"); break;
		case 0: System.out.println("Failed to add the word!"); break;
		}
	}
	
	private void printWord() {
		//PRINT SUB-MENU
		printSubMenuPrint();
		//SELECT OPTIONS OF SUB-MENU
		int subMenu = sc.nextInt();
		//IF 1 IS SELECTED, PRINT ALL
		switch(subMenu){
		case 1:
			note.print();
			break;
		// IF 2 IS SELECTED, SEARCH
		case 2:
			//a word to look for
			System.out.print("Enter a word to search : ");
			String title = sc.next();
			//print
			note.search(title);
			break;
		default:
			
		}
	
	}
	
	private void printSubMenuPrint() {
		System.out.println("SUB-MENU");
		System.out.println("1. Print all");
		System.out.println("2. Search a word");
		System.out.print("Select an option of sub-menu : ");
	}
	
	private void deleteWord() {
		//ENTER A WORD TO DELETE
		System.out.print("Enter a word to delete : ");
		String title = sc.next();
		//DELETE THE WORD
		boolean result = note.delete(title);
		if(result) {
			System.out.println("The word is successfully deleted");
			} else {
				System.out.println("Failed to delete the word!");
			}
		}
	
	private void updateWord() {
		printSubMenuUpdate();
		int submenu = sc.nextInt();
		switch(submenu) {
		case 1:
			System.out.print("Enter a word to modify : ");
			String word = sc.next();
			System.out.print("Enter a new word : ");
			String updateWord = sc.next();
			if(note.updateTitle(word, updateWord)) {
				System.out.println("the modification has been successfully done!");
			} else {
				System.out.println("Failed to modify the word!");
			}
			break;
		case 2:
			System.out.print("Enter a word to modify a meaning of : ");
			String title = sc.next();
			if(!note.search(title)) {
				System.out.println("Failed to find the word!");
				return;
			}
			System.out.print("Enter the meaning number to modify : ");
			int num = sc.nextInt();
			sc.nextLine();
			System.out.print("Enter a new meaning : ");
			String meaning = sc.nextLine();
			if(!note.updateMeaning(title, num, meaning)) {
				System.out.println("Failed to modify the meaning!");
			} else {
				System.out.println("The modification has been successfully done!");
			}
			break;
			
		case 3:
			System.out.print("Enter a word to delete a meaning of : ");
			String title2 = sc.next();
			if(!note.search(title2)) {
				System.out.println("Failed to find the word!");
				return;
			}
			System.out.print("Enter the meaning number to delete : ");
			int num2 = sc.nextInt();
			if(!note.deleteMeaning(title2, num2)) {
				System.out.println("Failed to delete the meaning");
			} else {
				System.out.println("The deletion has been successfully done!");
			}
			break;
		default:
			
		}
		
	}
	
	private void printSubMenuUpdate() {
		System.out.println("SUB-MENU");
		System.out.println("1. Modify a word");
		System.out.println("2. Modify a meaning");
		System.out.println("3. Delete a meaning");
		System.out.print("Select an option of sub-menu : ");
	}
}
