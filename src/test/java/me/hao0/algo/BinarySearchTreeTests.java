package me.hao0.algo;

import me.hao0.algo.tree.BinarySearchTree;
import me.hao0.algo.tree.Student;
import org.junit.Before;
import org.junit.Test;

/***
 * 2叉树demo
 * 
 *        stu9
 *      /     \
 *    stu6   stu91
 *   /   \       \
 * stu5  stu7   stua
 */
public class BinarySearchTreeTests {
	private static BinarySearchTree<Student> students
						= new BinarySearchTree<Student>();
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
	}
	
	@Test
	public void testPrev(){
		System.out.println(students.prev(new Student("stu6")));
	}
	
	@Test
	public void testNext(){
		System.out.println(students.next(new Student("stu7")));
		System.out.println(students.next(new Student("stua")));
	}
	
	@Test
	public void testLRR() {
		System.out.println("中序遍历: ");
		students.leftRootRight();
	}
	
	@Test
	public void testGet(){
		System.out.println(students.get(new Student("stu7")));
	}
	
	@Test
	public void testMin(){
		System.out.println(students.min());
	}
	
	@Test
	public void testMax(){
		System.out.println(students.max());
	}
	
	@Test
	public void testRemove0(){
		System.out.println("remove before: ");
		students.leftRootRight();
		System.out.println(students.remove(new Student("stu7")));
		System.out.println("remove after: ");
		students.leftRootRight();
	}
	
	@Test
	public void testRemove1(){
		System.out.println("remove before: ");
		students.leftRootRight();
		System.out.println(students.remove(new Student("stu91")));
		System.out.println("remove after: ");
		students.leftRootRight();
	}
	
	@Test
	public void testRemove2(){
		System.out.println("remove before: ");
		students.leftRootRight();
		System.out.println(students.remove(new Student("stu6")));
		System.out.println("remove after: ");
		students.leftRootRight();
	}
	
	@Test
	public void testRemoveRoot(){
		System.out.println("remove before: ");
		students.leftRootRight();
		System.out.println(students.remove(new Student("stu9")));
		System.out.println("remove after: ");
		students.leftRootRight();
	}
}
