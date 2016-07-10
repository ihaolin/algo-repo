package me.hao0.algo.shift;

import me.hao0.algo.utils.Printer;

/**
 * 数组右移算法
 */
public class ArrayLeftShift {
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println("original array: ");
		Printer.print(arr);
		System.out.println("moved array: ");
		int moveNum = 4;
		leftShift(arr, moveNum);
		Printer.print(arr);
	}

	/**
	 * 右移数组
	 * 
	 * @param arr
	 *            数组
	 * @param moveNum
	 *            移动位数
	 */
	private static void leftShift(int[] arr, int moveNum) {
		moveNum = moveNum % arr.length;
		while (moveNum-- > 0) {
			int lastNum = arr[arr.length - 1];
			for (int j = arr.length - 1; j > 0; j--) {
				arr[j] = arr[j - 1];
			}
			arr[0] = lastNum;
		}
	}
}
