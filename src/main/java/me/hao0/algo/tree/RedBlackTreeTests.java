package me.hao0.algo.tree;

import org.junit.Before;
import org.junit.Test;

/***
 * 2叉树demo
 * 
 *        stu9(B)
 *        /     \
 *    stu6(B)  stu91(B)
 *    /     \       \
 * stu5(R) stu7(R) stua(R)
 * 
 * 添加new Student("stuz"), 需左旋:
 * 
 *         stu9(B)
 *        /      \
 *      /         \
 *  stu6(B)        stua(B)
 *  /     \          /  \
 * /       \        /    \
 stu5(R) stu7(R) stu91(R) stuz(R)
 * 
 */
public class RedBlackTreeTests {
	private static RedBlackTree<Student> students 
						= new RedBlackTree<Student>();
	@Before
	public void init(){
		Student s = new Student("stu9");
		students.insert(s);
		s = new Student("stu6");
		students.insert(s);
		s = new Student("stu91");
		students.insert(s);
		s = new Student("stu5");
		students.insert(s);
		s = new Student("stu7");
		students.insert(s);
		s = new Student("stua");
		students.insert(s);
		
		s = new Student("stuz");
		students.insert(s);
		
		s = new Student("stu901");
		students.insert(s);
		
		s = new Student("stu902");
		students.insert(s);
	}
	
	@Test
	public void testLeftRootRight(){
		students.leftRootRight();
	}
	
	@Test
	public void testRmRoot(){
		System.out.println("before removed stu9");
		students.leftRootRight();
		students.remove(new Student("stu9"));
		System.out.println("-----------------------------");
		System.out.println("after removed stu9");
		students.leftRootRight();
	}
	
	/**
	 * 删除末端红节点
	 */
	@Test
	public void testRmLastRedNode(){
		System.out.println("before removed stuz");
		students.leftRootRight();
		students.remove(new Student("stuz"));
		System.out.println("after removed stuz");
		students.leftRootRight();
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
