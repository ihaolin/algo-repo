package me.hao0.algo.sort.heap;

/**
 * 最大堆排序应用, 如优先级队列
 * 下面是一些相关的操作
 */
public class HeapSortApp {

	/**
	 * 获取最大堆最大数
	 * @param arr 对应数组
	 * @return 最大数
	 */
	public int maxHeapMax(int[] arr){
		return arr[0];
	}
	
	/**
	 * 取出最大堆中的最大数，注意最大堆结构的改变
	 * @param arr 最大堆数组
	 * @return 最大数
	 */
	public int maxHeapExtractMax(int[] arr){
		int max = arr[0];
		arr[0] = arr[arr.length-1];
		int[] newArr = new int[arr.length-1];
		System.arraycopy(arr, 0, newArr, 0, newArr.length);
		//对新的数组最大堆化
		maxHeapify(newArr, 0, newArr.length-1);
		arr = newArr;
		return max;
	}
	
	/**
	 * 将最大堆中索引i的值改为newValue，注意最大堆结构的改变
	 * 递归与parent比较交换
	 * @param arr 对应数组
	 * @param i 索引
	 * @param newKey 新值
	 */
	public void maxHeapIncreaseKey(int arr[], int i, int newKey){
		arr[i] = newKey;
		while ( i>0 && arr[parent(i)] < arr[i]){
			//交换
			int temp = arr[parent(i)];
			arr[parent(i)] = arr[i];
			arr[i] = temp;
			//继续比较根节点
			i = parent(i); 
		}
	}
	
	/**
	 * 在最大堆中新增一个Key:
	 * 添加到数组尾部，再调用maxHeapIncreaseKey
	 * 我们完全也可以通过该方法建立最大堆
	 * @param arr 对应数组
	 * @param newKey 新key
	 */
	public void maxHeapInsertKey(int arr[], int newKey){
		int[] newArr = new int[arr.length+1];
		newArr[newArr.length-1] = Integer.MIN_VALUE;
		System.arraycopy(arr, 0, newArr, 0, arr.length);
		maxHeapIncreaseKey(newArr, newArr.length-1, newKey);
		arr = newArr;
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
	
	/**
	 * 获取根索引
	 * @param index 孩子索引
	 * @return 根索引
	 */
	private static int parent(int index){
		return (index-1)/2;
	}
	
	/**
	 * 获取左孩子索引
	 * @param index 根索引
	 * @return 左孩子索引
	 */
	private static int left(int index) {
		return 2*index+1;
	}
	
	/**
	 * 获取右孩子索引
	 * @param index 根索引
	 * @return 右孩子索引
	 */
	private static int right(int index) {
		return 2*index+2;
	}
}
