package me.hao0.algo.utils;

public class ArrayUtil {
	/**
	 * 交换数组对应索引的值
	 * 
	 * @param arr
	 *            对应数组
	 * @param i
	 *            索引i
	 * @param j
	 *            索引j
	 */
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
