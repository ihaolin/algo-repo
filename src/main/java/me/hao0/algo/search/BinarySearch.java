package me.hao0.algo.search;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr  = new int[]{1,2,3,8,9,11,13,22,33,34};
		int search = 10;
		int index = bSearch(arr, search);
		System.out.println(search +"'s index in arr is " + index);
	}
	
	/**
	 * 2�ֲ���
	 * @param arr
	 * @param search
	 * @return
	 */
	private static int bSearch(int[] arr, int search) {
		int low = 0;
		int high = arr.length - 1;
		int medium = -1;
		int index = -1;
		while(low <= high){
			medium = (low + high) / 2;
			if (search < arr[medium]){
				high = medium - 1;
			} else if(search > arr[medium]){
				low = medium + 1;
			} else{
				index = medium;
				break;
			}
		}
		return index;
	}
}
