package me.hao0.algo.sort.insert;

/**
 * 插入排序
 */
public class InsertSort {

	public static void main(String[] args) {
		int[] arr = new int[]{23, 22,1,43, -3, 79, 15, 9, 22};
		System.out.println("before sort: ");
		print(arr);
		insertSort(arr, true);
		System.out.println("after sort: ");
		print(arr); 
	}

	/**
	 * 插入排序
	 * @param arr 待排序数组
	 * @param isAsc true: 升序, false: 降序
	 */
	private static void insertSort(int[] arr, boolean isAsc) {
		int key;
		for (int i=1; i<arr.length; i++){
			int j = i-1;
			key = arr[i];
			while (j >= 0 && ((arr[j] < key) ^ isAsc)){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
	}
	
	private static void print(int[] arr) {
		for (int a : arr){
			System.out.print(a + " ");
		}
		System.out.println();
	}
}
