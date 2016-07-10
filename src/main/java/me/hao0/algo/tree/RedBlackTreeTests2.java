package me.hao0.algo.tree;

import org.junit.Before;
import org.junit.Test;

/***
 * 2叉树demo:
 * 
 * 依次插入: 20, 17 ,14 ,18, 5, 16, 3, 30后:
		      17(B)
		      /    \
		     /      \
		    /        \
		  14(R)       20(B)
		  /  \        /  \
		 /    \      /    \
	  5(B)  16(B)  18(R)  30(R)
      /
     /
   3(R)
 */
public class RedBlackTreeTests2 {
	private static RedBlackTree<Integer> numbers 
						= new RedBlackTree<Integer>();
	@Before
	public void init(){
		Integer n = new Integer(20);
		numbers.insert(n);
		
		n = new Integer(17);
		numbers.insert(n);
		
		n = new Integer(14);
		numbers.insert(n);
		
		n = new Integer(18);
		numbers.insert(n);
		
		n = new Integer(5);
		numbers.insert(n);
		
		n = new Integer(16);
		numbers.insert(n);
		
		n = new Integer(3);
		numbers.insert(n);
		
		n = new Integer(30);
		numbers.insert(n);
	}
	
	@Test
	public void testLeftRootRight(){
		numbers.leftRootRight();
	}
	
	@Test
	public void testRm20(){
		System.out.println("before removed 20");
		numbers.leftRootRight();
		numbers.remove(20);
		System.out.println("-----------------------------");
		System.out.println("after removed 20");
		numbers.leftRootRight();
	}
	
	/**
	 * 删除末端红节点
	 */
	@Test
	public void testRm18(){
		System.out.println("before removed 18");
		numbers.leftRootRight();
		numbers.remove(18);
		System.out.println("after removed 18");
		numbers.leftRootRight();
	}
	
	/**
	 * 删除末端红节点
	 */
	@Test
	public void testRm17(){
		System.out.println("before removed 17");
		numbers.leftRootRight();
		numbers.remove(17);
		System.out.println("after removed 17");
		numbers.leftRootRight();
	}
	
	/**
	 * 删除末端红节点
	 */
	@Test
	public void testRm14(){
		System.out.println("before removed 14");
		numbers.leftRootRight();
		numbers.remove(14);
		System.out.println("after removed 14");
		numbers.leftRootRight();
	}
	
	/**
	 * 删除末端红节点
	 */
	@Test
	public void testRm16(){
		System.out.println("before removed 16");
		numbers.leftRootRight();
		numbers.remove(16);
		System.out.println("after removed 16");
		numbers.leftRootRight();
	}
	
	@Test
	public void testString(){
		String a = "aabb" + 1;
		String b = "aabb1";
		String c = new String("aabb1");
		String d = new String("aabb1");
		
		System.out.println(a == b);
		System.out.println(b == c);
		System.out.println(c == d);
	}
}
