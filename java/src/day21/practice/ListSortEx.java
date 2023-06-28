package day21.practice;

import java.util.ArrayList;
import java.util.Comparator;

public class ListSortEx {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(10);
		list.add(4);
		list.add(8);
		System.out.println(list);
		//list.sort((Integer o1, Integer o2)->o1-o2);
		list.sort(null);
		System.out.println(list);
		

	} 

}

class IntegerCompare implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return o1 - o2;
	}
	
}