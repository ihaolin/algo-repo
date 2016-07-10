package me.hao0.algo.sort.count;


import me.hao0.algo.utils.Printer;

/**
 * 计数排序实现：
 * 计算出数组中小于输入元素x的个数，然后x就处于数组的第x+1个位置上
 */
public class CountingSort {
	public static void main(String[] args) {
		 int[] A = new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
		 int[] B = new int[A.length];
		 System.out.println("before counting sort:");
		 Printer.print(A);
		 //countingSort(A, B, 100);
		 B = countSort(A);
		 System.out.println("after counting sort:");
		 Printer.print(B);
	}
	
	/**
	 * 计数排序
	 * @param A 待排序数组
	 * @param B 对应A排序后的数组, 
	 * @param k A数组中最大元素
	 */
	public static void countingSort(int[] A, int[] B, int k){ 
		//用于记录A中每个元素出现的次数
		int[] C = new int[k];
		//统计A[i]每个元素出现的次数，并放到C中A[i]的位置
		for (int i=0; i<A.length; i++){
			C[A[i]] += 1;
		}
		//求计数和
		for (int i=1; i<k; i++){
			C[i] = C[i] + C[i-1];
		}
		//整理
		for (int j = A.length - 1; j >= 0; j--) {
            int a = A[j];
            B[C[a] - 1] = a;
            C[a] -= 1;
        }
	}
	
	public static int[] countSort(int []a){
		int b[] = new int[a.length];
		int max = a[0], min = a[0];
		//找出最大，最小元素
		for(int i : a){
			if(i > max){
				max = i;
			}
			if(i < min){
				min = i;
			}
		}
		//这里k的大小是要排序的数组中，元素大小的极值差+1
		int k = max - min + 1;
		int c[] = new int[k];
		for(int i = 0; i < a.length; ++i){
			c[a[i]-min] += 1;
		}
		//求计数和
		for(int i = 1; i < c.length; ++i){
			c[i] = c[i] + c[i-1];
		}
		//根据各个元素的出现次数，开始反填
		for(int i = a.length-1; i >= 0; --i){
			b[--c[a[i]-min]] = a[i];
		}
		return b;
	}
}
