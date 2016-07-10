package me.hao0.algo.tree;

public class Student implements Comparable<Student>{
	private String number;

	public Student(String number) {
		super();
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public int compareTo(Student o) {
		return number.compareTo(o.number);
	}

	@Override
	public String toString() {
		return "Student [number=" + number + "]";
	}
}
