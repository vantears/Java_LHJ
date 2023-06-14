package day11.array;

public class ArrayCopyEx {

	public static void main(String[] args) {
		int arr1[] = new int[] {1, 2, 3, 4, 5};
		int arr2[] = arr1;
		
		arr2[0] = 10;
		
		for(int tmp : arr1) {
			System.out.println(tmp);
		}
		
		arr2[0] = 1;
		
		arr2 = new int[arr1.length];
		
		for(int i = 0; i < arr1.length; i++) {
			arr2[i] = arr1[i];
		}
		
		arr2[0] = 10;
		
		System.out.println("===========");
		for(int tmp : arr1) {
			System.out.println(tmp);
		}
		
		int arr3[] = new int[arr1.length];
		System.arraycopy(arr1, 0, arr3, 0, arr1.length - 2);
		
		arr3[0] = 10;
		
		System.out.println("===========");
		for(int tmp : arr3) {
			System.out.println(tmp);
		}

	}

}
