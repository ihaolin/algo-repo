package me.hao0.algo;

public class SwapTest {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int count = 1000000;
		int a = 2, b = 3;
		
		for (int i=0; i<count; i++){
			//int temp = a;
			//a = b;
			//b = temp;
			
			a = a^b;
			b = b^a;
			a = a^b;
		}
		
		System.out.println("swap "+count+" times costs " 
							+ (System.currentTimeMillis()-start));
	}
}	
