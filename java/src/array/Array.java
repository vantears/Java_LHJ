package array;

public class Array {

	public static void printArray(int n[]) {
		System.out.print("[");
		for(int i = 0; i < n.length; i++) {
			System.out.print(n[i] + (i == n.length - 1 ? "" : ","));
		}
		System.out.println("]");
	}
	
	//배열을 start번지부터 end-1번지까지 출력
	public static void printArray(int n[], int start, int end) {
		System.out.print("[");
		for(int i = start; i < end; i++) {
			if(i >= n.length) {
				break;
			}
			System.out.print(n[i] + (i == end-1? "":","));
		}
		System.out.println("]");
	}
	
	public static boolean contains(int n[], int num, int length) {
		for(int i = 0; i < length; i++) {
			if(num == n[i]) {
				return true;
			}
		}
		return false;
	}
	
	public static int [] createRandomArray(int min, int max, int n[]) {
		//max가 min보다 작으면 두 수를 교환
		if(max < min) {
			int tmp = max;
			max = min;
			min = max;
		}
		//배열이 생성되어 있지 않으면(배열이 null이면) 메서드 종료
		if(n == null) {
			n = new int[max - min + 1];
		}
		//랜덤으로 만들어지는 수의 개수가 배열의 크기보다 작으면 메서드를 종료
		//1~3 : 3개가 4개짜리 배열에 중복되지 않게 들어갈 수 없음
		if(max - min + 1 < n.length) {
			return null;
		}
		
		int count = 0;
		while(count < n.length) {
			int random = (int)(Math.random() * (max - min + 1) + min);
			if(!contains(n, random, count)) {
				n[count] = random;
				count++;
			}
		}
		return n;
	}
	
	public static boolean arrayCheck(int arr[]) {
		if(arr == null) {
			return false;
		}
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				if(arr[i] == arr[j] && i != j) {
					return true;
				}
			}
		}
		return false;
	}
	
}
