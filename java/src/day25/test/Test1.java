package day25.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test1 {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		Iterator iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}

		
	}
	
	

}