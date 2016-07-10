package me.hao0.algo.sort.stooge;

import me.hao0.algo.utils.ArrayUtil;
import me.hao0.algo.utils.Printer;

/**
 * 臭皮匠排序实现
 */
public class StoogeSort {
	public static void main(String[] args) {
		int[] arr = new int[]{2, 8, 7, 1, 3, 5, 6, 4};
		System.out.println("before quick sort:");
		Printer.print(arr);
		stoogeSort(arr, 0, arr.length-1);
		System.out.println("after quick sort:");
		Printer.print(arr);
	}
	
	/**
	 * 臭皮匠排序实现
	 * @param arr 待排序数组
	 * @param i 数组起始索引
	 * @param j 数组结束索引
	 */
	private static void stoogeSort(int[] arr, int i, int j) {
		if(arr[j] < arr[i]){
			ArrayUtil.swap(arr, i, j);
		}
		if ((j-i+1) >= 3){
			int t = (j-i+1) / 3;
			stoogeSort(arr, i, j - t);
			stoogeSort(arr, i+t, j);
			stoogeSort(arr, i, j - t);
		}
	}
}
