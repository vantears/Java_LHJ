package day21.set;
import java.util.ArrayList;
import java.util.HashSet;

public class SetRandomEx {

	public static void main(String[] args) {
		// store 3 random numbers ranged 1 to 9 with using array
		int arr[] = new int[3];
		int count = 0;
		int min = 1, max = 9;
		while(count < 3) {
			int r = random(min, max);
			int i;
			for(i = 0; i < count; i++) {
				if(arr[i] == r) {
					break;
				}
			}
			if(i == count) {
				arr[count++] = r;
			}
		}
		System.out.print("[");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + (i == arr.length-1?"":", "));
		}
		System.out.println("]");
		
		// store 3 random numbers ranged 1 to 9 with using list
		ArrayList<Integer> list = new ArrayList<>();
		
		while(list.size() < 3) {
			int r = random(min, max);
			if(!list.contains(r)) {
				list.add(r);
			}
		}
		System.out.println(list);
		
		// store 3 random numbers ranged 1 to 9 with using set
		HashSet<Integer> set = new HashSet<>();
		
		while(set.size() < 3) {
			int r = random(min, max);
			set.add(r);
		}
		System.out.println(set);
		
	}
	
	public static int random(int min, int max) {
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		return (int)(Math.random() * (max - min + 1) + min);
	}

}
