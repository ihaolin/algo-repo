package me.hao0.algo.sort.quick;

import me.hao0.algo.utils.ArrayUtil;
import me.hao0.algo.utils.Printer;

/**
 * 快速排序实现, 通过尾递归实现
 */
public class QuickSortTail {

	public static void main(String[] args) {
		int[] arr = new int[]{2, 8, 7, 1, 3, 5, 6, 4};
		System.out.println("before quick sort:");
		Printer.print(arr);
		quickSort(arr, 0, arr.length-1);
		System.out.println("after quick sort:");
		Printer.print(arr);
	}
	
	/**
	 * 快速排序实现(尾递归实现), 可减少堆栈深度:
	 * 将右边部分的排序通过迭代来实现
	 * @param arr 待排序数组
	 * @param p 数组起始索引
	 * @param r 数组结束索引
	 */
	private static void quickSort(int[] arr, int p, int r) {
		while (p < r){ // 4 3 5 2 1
			int q = partition(arr, p, r);
			quickSort(arr, p, r-1);
			p = q + 1;
		}
	}
	
	/**
	 * 对数组进行划分:
	 * [p..i]<=pivot, [i..j]>pivot
	 * @param arr 待分区数组
	 * @param p 数组起始索引
	 * @param r 数组结束索引
	 * @return 划分完后，基准数所在索引
	 */
	private static int partition(int[] arr, int p, int r) {
		// 选取最后一个元素为基准数
		int pivot = arr[r];
		int i = p - 1;
		for (int j=p; j <= r-1; j++){
			if (arr[j] <= pivot){ 
				i++;
				//交换 arr[i] <--> arr[j]
				ArrayUtil.swap(arr, i, j);
			}
		}
		//将基准数放到中间 arr[i+1] <--> arr[r]
		ArrayUtil.swap(arr, i+1, r);
		return i+1;
	}
}
