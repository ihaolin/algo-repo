package me.hao0.algo.sort.bubble;

/**
 * 插入排序
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = new int[]{23, 22,1,43, -3, 79, 15, 9, 22};
		System.out.println("before sort: ");
		print(arr);
		bubbleSort(arr, true);
		System.out.println("after sort: ");
		print(arr); 
	}

	/**
	 * 冒泡排序
	 * @param arr 待排序数组
	 * @param isAsc true: 升序, false: 降序
	 */
	private static void bubbleSort(int[] arr, boolean isAsc) {
		for (int i=1; i<arr.length; i++){
			for (int j=0; j < arr.length-i; j++){
				if ((arr[j] < arr[j+1]) ^ isAsc){
					arr[j+1] = arr[j+1] ^ arr[j];
					arr[j] = arr[j] ^ arr[j+1];
					arr[j+1] = arr[j+1] ^ arr[j];
				}
			}
		}
	}
	
	private static void print(int[] arr) {
		for (int a : arr){
			System.out.print(a + " ");
		}
		System.out.println();
	}
}
