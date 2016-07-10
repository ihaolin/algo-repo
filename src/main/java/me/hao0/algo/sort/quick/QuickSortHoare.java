package me.hao0.algo.sort.quick;

import me.hao0.algo.utils.Printer;

/**
 * 快速排序实现, 基于霍尔划分
 */
public class QuickSortHoare {

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 8, 7, 1, 3, 5, 6, 4 };
		System.out.println("before quick sort:");
		Printer.print(arr);
		quickSort(arr, 0, arr.length - 1);
		System.out.println("after quick sort:");
		Printer.print(arr);
	}

	/**
	 * 快速排序实现
	 * 
	 * @param arr
	 *            待排序数组
	 * @param p
	 *            数组起始索引
	 * @param r
	 *            数组结束索引
	 */
	private static void quickSort(int[] arr, int p, int r) {
		if (p < r) {
			int q = hoarePartition(arr, p, r);
			//System.out.println("arr[" + q + "]=" + arr[q]);
			//Printer.print(arr);
			quickSort(arr, p, q - 1);
			quickSort(arr, q + 1, r);
		}
	}

	/**
	 * 对数组进行霍尔划分
	 * 
	 * @param arr
	 *            待分区数组
	 * @param left
	 *            数组起始索引
	 * @param right
	 *            数组结束索引
	 * @return 划分完后，基准数所在索引
	 */
	private static int hoarePartition(int[] arr, int left, int right) {
		// 将第一个数作为基准数
		int pivot = arr[left];
		while(left < right){
			//依次找到从右边比基准数小的数
			while (left < right && arr[right] >= pivot){
				--right;
			}
			//将小数移到左边
			arr[left] = arr[right];
			//依次找到从左边比基准数大的数
			while (left < right && arr[left] <= pivot){
				++left;
			}
			//将大数移到右边
			arr[right] = arr[left];
		}
		arr[left] = pivot;
		return left;
	}
}
