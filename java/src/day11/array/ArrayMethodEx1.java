package day11.array;

public class ArrayMethodEx1 {

	public static void main(String[] args) {
		int num1 = 10, num2 = 20;
		System.out.println("num1 = " + num1 + ", num2 = " + num2);
		
		int tmp = num1;
		num1 = num2;
		num2 = tmp;
		System.out.println("num1 = " + num1 + ", num2 = " + num2);
		System.out.println("===================");
		
		num1 = 10;
		num2 = 20;
		System.out.println("num1 = " + num1 + ", num2 = " + num2);
		swap(num1, num2);
		System.out.println("num1 = " + num1 + ", num2 = " + num2);
		
		int arr1[] = {1, 2, 3, 4};
		int arr2[] = {5, 6, 7, 8};
		
		int tmpArr[] = new int [arr1.length];
		
		tmpArr = arr1;
		arr1 = arr2;
		arr2 = tmpArr;
		
		System.out.println("===================");
		printArr(arr1);
		printArr(arr2);
		
		swap(arr1, arr2);
		System.out.println("===================");
		printArr(arr1);
		printArr(arr2);
		
		swap2(arr1, arr2);
		System.out.println("===================");
		printArr(arr1);
		printArr(arr2);
		
		System.out.println("===================");
		int arr3[] = {1, 2, 3, 4};
		printArr(arr3);
		test1(arr3);
		printArr(arr3);
		
		System.out.println("===================");
		int arr4[] = {1, 2, 3, 4};
		printArr(arr4);
		test2(arr4);
		printArr(arr4);

	}
	
	public static void test1(int arr[]) {
		arr = new int [4];
		arr[0] = 3;
	}
	
	public static void test2(int arr[]) {
		arr[0] = 3;
	}
	
	public static void printArr(int arr[]) {
		for(int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
	
	public static void swap2(int arr1[], int arr2[]) {
		int tmp[] = new int [arr1.length];
		for(int i = 0; i < arr1.length; i++) {
			tmp[i] = arr1[i];
			arr1[i] = arr2[i];
			arr2[i] = tmp[i];
		}
	}
	
	public static void swap(int num1[], int num2[]) {
		int tmp[] = num1;
		num1 = num2;
		num2 = tmp;
	}
	
	public static void swap(int num1, int num2) {
		int tmp = num1;
		num1 = num2;
		num2 = tmp;
	}

}
