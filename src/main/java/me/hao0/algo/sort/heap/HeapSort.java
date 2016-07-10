package me.hao0.algo.sort.heap;

/**
 * 堆排序实现
 */
public class HeapSort {
	public static void main(String[] args) {
		int arr[] = new int[]{560, 706, 48, 137, 995, 678, 153, 741, 609, 37};
		System.out.println("before heap sort:");
		print(arr);
		//buildMaxHeap(arr);
		heapSort(arr);
		System.out.println("after heap sort:");
		print(arr);
	}
	
	/**
	 * 堆排序算法：
	 * 不停交换a[0]到最后
	 * @param arr 待排序数组
	 */
	private static void heapSort(int[] arr) {
		//将数组最大堆化
		buildMaxHeap(arr); 
		for (int i=arr.length-1; i>0; i--){
			arr[0] = arr[0]^arr[i];
			arr[i] = arr[i]^arr[0];
			arr[0] = arr[0]^arr[i];
			//将第一个(根)继续进行最大堆化, 
			//但经过上面的交换操作, 会依次排除排除最后一个元素
			maxHeapify(arr, 0, i-1); 
		}
	}

	/**
	 * 对整个数组进行最大堆化:
	 * 可对每个非叶子节点出发进行最大堆化，
	 * 		叶子节点索引为: [(arr.length-1)/2+1, +2...n]
	 * 将数组构建为最大堆的线性复杂度为: O(n)
	 * @param arr 对应数组
	 */
	private static void buildMaxHeap(int arr[]){
		for (int i=(arr.length-1)/2; i>=0; i--){
			maxHeapify(arr, i, arr.length-1);
		}
	}
	
	/**
	 * 最大堆化数组arr[index]为根的子树
	 * @param arr 对应数组
	 * @param index 根索引， 0 ～ arr.length-1
	 * @param lastIndex 比较操作的最大索引
	 */
	private static void maxHeapify(int arr[], int index, int lastIndex){
		int leftChildIndex = left(index);
		int rightChildIndex = right(index);
		
		int biggest = index;
		// 若果左边的孩子更大
		if ((leftChildIndex <= lastIndex)
				&& arr[index] < arr[leftChildIndex]){
			biggest = leftChildIndex;
		}
		// 若右边的孩子还更大
		if ((rightChildIndex <= lastIndex)
				&& arr[biggest] < arr[rightChildIndex]){
			biggest = rightChildIndex;
		}
		// 需要进行调整
		if (biggest != index){ 
			int temp = arr[biggest];
			arr[biggest] = arr[index];
			arr[index] = temp;
			// 递归最大堆化子树
			maxHeapify(arr, biggest, lastIndex); 
		}
	}
	
	private static int left(int index) {
		return 2*index+1;
	}
	
	private static int right(int index) {
		return 2*index+2;
	}
	
	private static void print(int[] arr) {
		for (int a : arr){
			System.out.print(a + " ");
		}
		System.out.println();
	}
}
