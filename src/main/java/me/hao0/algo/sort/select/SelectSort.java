package me.hao0.algo.sort.select;

/**
 * 插入排序
 */
public class SelectSort {

	public static void main(String[] args) {
		int[] arr = new int[]{23, 22,1,43, -3, 79, 15, 9, 22};
		System.out.println("before sort: ");
		print(arr);
		selectSort(arr, false);
		System.out.println("after sort: ");
		print(arr); 
	}

	/**
	 * 冒泡排序
	 * @param arr 待排序数组
	 * @param isAsc true: 升序, false: 降序
	 */
	private static void selectSort(int[] arr, boolean isAsc) {
		for (int i=0; i<arr.length; i++){
			for (int j=i+1; j<arr.length; j++){
				if ((arr[j] > arr[i]) ^ isAsc){
					arr[j] = arr[j] ^ arr[i];
					arr[i] = arr[i] ^ arr[j];
					arr[j] = arr[j] ^ arr[i];
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
