package me.hao0.algo.list;

/**
 * List, thread safe
 * @author haol
 * @since 2013
 * @focus data structure
 */
public class MyList<T> {
	Node<T> head = null;
	Node<T> tail = null;
	private int size;
	
	/**
	 * add an item
	 * @param t the item
	 * @return this
	 */
	public synchronized MyList<T> add(T t){
		Node<T> newNode = new Node<T>(t);
		if (head == null) head = newNode;
		if (tail == null){
			tail = newNode;
		} else{
			newNode.prev = this.tail;
			this.tail.next = newNode;
			this.tail = newNode;
		}
		size++;
		return this;
	}
	
	public T get(int index){
		Node<T> n = head;
		if (size < 0 || index > size-1){
			throw new ArrayIndexOutOfBoundsException(index);
		}
		while((index--)!=0){
			n = n.next;
		}
		return n.t;
	}
	
	
	/**
	 * remove an item
	 * @param index the item index, from 0
	 * @return the removed item
	 */
	public synchronized T remove(int index){
		Node<T> n = head;
		if (size < 0 || index > size-1){
			throw new ArrayIndexOutOfBoundsException(index);
		}
		while((index--)!=0){
			n = n.next;
		}
		n.prev.next = n.next;
		size--;
		return n.t;
	}
	
	/**
	 * @return the size of the list
	 */
	public int size(){
		return size;
	}
	
	/**
	 * inner node
	 * @author haol
	 * @since 2013
	 * @focus data structure����
	 */
	private static class Node<T>{
		private Node<T> next = null;
		private Node<T> prev = null;
		private T t = null;
		
		public Node(T t){
			this.t = t;
		}
	}
}
