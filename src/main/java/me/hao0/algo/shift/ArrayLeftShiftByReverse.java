package me.hao0.algo.shift;

import me.hao0.algo.utils.Printer;

/**
 * 数组右移算法, 通过逆序实现, 时间复杂度达到O(n)
 */
public class ArrayLeftShiftByReverse {
	
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println("original array: ");
		Printer.print(arr);
		System.out.println("moved array: ");
		int moveNum = 3;
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
		moveNum %= arr.length;
		reverse(arr, 0, arr.length-moveNum-1); //反转前[0..arr.length-moveNum-1]子数组
		reverse(arr, arr.length-moveNum, arr.length-1); //反转前[arr.length-moveNum..arr.length-moveNum-1]子数组
		reverse(arr, 0, arr.length-1); //反转整个数组
	}
	
	/**
	 * 反转数组arr[i..j]
	 * @param arr 数组
	 * @param i 起始索引
	 * @param j 结束索引
	 */
	private static void reverse(int[] arr, int i, int j) {
		for (; i<j; i++, j--){
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}
}
