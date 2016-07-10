package me.hao0.algo.list;

/**
 * 栈实现, 线程安全
 */
public class MyStack<T> {
	private Element<T> top; 	//栈顶
	private int depth;
	private Object lock;
	
	public MyStack(){
		top = null;
		depth = 0;
	}
	
	public void push(T t){
		if (t == null) throw new NullPointerException("element can't be null");
		Element<T> cur = new Element<T>(t);
		synchronized (lock) {
			if (top == null){
				cur.next = null;
			} else{
				cur.next = top;
			}
			top = cur;
			depth ++;
		}
	}
	
	public T pop(){
		synchronized(lock){
			if (top == null) throw new NullPointerException("there isn't an avaliable element.");
			T res = top.value;
			top = top.next;
			depth --;
			return res;
		}
	}
	
	public int depth(){
		return depth;
	}
	
	private static class Element<T>{
		public Element<T> next;
		private T value;
		
		public Element(T t){
			this.value = t;
		}
	}
}
