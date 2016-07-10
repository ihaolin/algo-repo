package me.hao0.algo.sort.merge;

/**
 * 归并排序实现
 */
public class MergeSort {
	public static void main(String[] args) {
		int[] arr = new int[]{31, 21, 8, 11, 5, 1};
		System.out.println("before sort: ");
		print(arr);
		mergeSort(arr, 0, arr.length - 1);
		System.out.println("after sort: ");
		print(arr);
	}
	
	/**
	 * 归并排序
	 * @param arr 待排序数组
	 * @param i 数组起始索引
	 * @param j 数组结束索引
	 */
	private static void mergeSort(int[] arr, int i, int j) {
		if (i < j){ 
			int k = (i+j) / 2;
			// 归并左边数组
			mergeSort(arr, i, k);
			// 归并右边数组
			mergeSort(arr, k+1, j);
			// 将两个[有序]数组合并
			merge(arr, i, k, j);
		}
	}

	/**
	 * 对数组arr的两个的两个子数组arr[i..j-1], arr[j..k]进行合并排序
	 * @param arr 待合并排序的数组
	 * @param p 第一个子数组的起始索引, 可从0开始
	 * @param q 两个子数组分割索引
	 * @param r 第二个子数组的结束索引, 最大为arr.length-1
	 */
	private static void merge(int[] arr, int p, int q, int r) {
		if (p < 0) 
			throw new ArrayIndexOutOfBoundsException("index can't less than 0: " + p);
		if (r > arr.length-1) 
			throw new ArrayIndexOutOfBoundsException("index can't more than "+arr.length+": "+ r);
		int[] leftArr = new int[q - p + 1];
		int[] rightArr = new int[r - q];
		
		// 初始化左边的子数组
		for (int i=0; i<leftArr.length; i++){
			leftArr[i] = arr[p+i];
		}
		// 初始化右边的子数组
		for (int i=0; i<rightArr.length; i++){
			rightArr[i] = arr[q+i+1];
		}
		
		int leftIndex=0, rightIndex=0;
		int arrIndex = p;
		while (arrIndex < r){
			if (leftArr[leftIndex] <= rightArr[rightIndex]){
				arr[arrIndex++] = leftArr[leftIndex++];
			} else {
				arr[arrIndex++] = rightArr[rightIndex++];
			}
			
			// 是否已经到数组尾部了
			if (leftIndex == leftArr.length 
					|| rightIndex == rightArr.length){
				break;
			}
		}
		// 如果左边子数组还有剩余, 接上
		if (leftIndex < leftArr.length){
			while(leftIndex < leftArr.length){
				arr[arrIndex++] = leftArr[leftIndex++];
			}
		}
		// 如果右边子数组还有剩余, 接上
		if (rightIndex < rightArr.length){
			while(rightIndex < rightArr.length){
				arr[arrIndex++] = rightArr[rightIndex++];
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
