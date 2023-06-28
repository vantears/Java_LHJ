package day21.practice;
import java.util.*;

public class LottoEx {

	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<>();
		HashSet<Integer> customer = new HashSet<>();
		int count = 0;
		int bonus;
		Scanner sc = new Scanner(System.in);
		
		while(set.size() < 6) {
			set.add((int)(Math.random() * 45 + 1));
		}
		do {
			bonus = (int)(Math.random() * 45 + 1);
		}while(set.contains(bonus));
		
		System.out.println(set);
		System.out.println("Bonus : " + bonus);
		System.out.print("Enter Lotto numbers : ");
		while(customer.size() < 6) {
			customer.add(sc.nextInt());
		}
		for(Integer tmp : customer) {
			if(set.contains(tmp)) {
				count++;
			}
		}
		
		switch(count){
			case 6:
				System.out.println("You won the first prize!");
				break;
			case 5:
				if(customer.contains(bonus)) {
					System.out.println("You won the second prize!");
				} else {
					System.out.println("You won the third prize!");					
				}
				break;
			case 4:
				System.out.println("You won the fourth prize!");
				break;
			case 3:
				System.out.println("You won the fifth prize!");
				break;
			default:
				System.out.println("You won nothing!");
		}
		
		sc.close();
	}

}
