package day27.iostream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharIOStreamEx {

	public static void main(String[] args) {
		try(FileReader fr = new FileReader("file.txt")){
			char buffer[] = new char[1024];
			while(fr.read(buffer) != -1) {
				System.out.println(buffer);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not Found!");
		} catch (IOException e) {
			System.out.println("Exception!");
		}
		output();
	}
	
	public static void output() {

		 FileWriter fw = null;

		 try {

		  fw = new FileWriter("file.txt", true);

		  fw.write(97);

		  fw.write(65);

		  fw.close();

		 } catch (FileNotFoundException e) {

		  e.printStackTrace();

		 } catch (IOException e) {

		  e.printStackTrace();

		 }

		}

}
