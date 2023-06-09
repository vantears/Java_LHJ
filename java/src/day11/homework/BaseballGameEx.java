package day11.homework;
import java.util.Scanner;

import array.Array;

public class BaseballGameEx {

	public static void main(String[] args) {
		
		int com[] = new int[3];
		int user[] = new int[3];
		int min =1, max = 9;
		int strike = 0;
		int ball = 0;
		Scanner sc = new Scanner(System.in);
		
		Array.createRandomArray(min, max, com);
		//Array.printArray(com);
		
		do {
			// 사용자가 숫자 3개를 입력
			System.out.print("User : ");
			for(int i = 0; i < user.length; i++) {
				user[i] = sc.nextInt();
			}
			//사용자 입력 체크
			if(Array.arrayCheck(user)) {
				System.out.println("You shouldn't put same numbers in it");
				continue;
			}
			//판별

			//스트라이크 개수 판별
			strike = strike(com, user);
			//볼의 개수 판별
			ball = ball(com, user) - strike;
			//스트라이크와 볼의 개수에 맞게 출력
			printResult(strike, ball);
		}while(strike < 3);
		System.out.println("HOME RUN!");
		
		sc.close();
	}
	
	/** 스트라이크 개수를 판별하는 메서드
	 * => 두 배열에서 같은 번지에 있는 값들이 몇개 같은지 알려주는 메서드
	 * 매개변수 : 두 배열=>int arr1[], int arr2[]
	 * 리턴타입 : 같은 번지에 있는 값들이 몇개 같은지 => 몇개 => 정수 => int
	 * 메서드명 : strike
	 * */
	public static int strike(int arr1[], int arr2[]) {
		//배열 생성이 안된 배열이 1개라도 있으면 비교할 수 없어서 0을 리턴
		if(arr1 == null || arr2 == null) {
			return 0;
		}
		//배열의 개수가 다른 경우 작은 크기의 배열을 기준으로 비교하기 위해 size 계산
		int size = arr1.length < arr2.length ? arr1.length : arr2.length;
		
		int count = 0;
		for(int i = 0; i < size; i++) {
			if(arr1[i] == arr2[i]) {
				count++;
				}
			}
		return count;
	}
	
	public static int ball(int arr1[], int arr2[]) {
		if(arr1 == null || arr2 == null) {
			return 0;
		}
		
		int count = 0;
		for(int tmp : arr1) {
			if(Array.contains(arr2, tmp, arr2.length)) {
				count++;
			}
		}
		return count;
	}
	
	public static void printResult(int strike, int ball) {
		if(strike > 0) {
			System.out.print(strike + "S");
		}
		if(ball > 0) {
			System.out.print(ball + "B");
		}
		if(ball == 0 && strike == 0) {
			System.out.print("OUT!");
		}
		System.out.println();
	}

}


