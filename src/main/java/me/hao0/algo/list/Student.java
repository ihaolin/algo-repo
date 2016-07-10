package me.hao0.algo.list;

/**
 * ѧ��
 * @author haol
 * @since 2013
 * @focus data structure����
 */
public class Student {
	private String name;
	private String number;
	private Integer age;
	
	public Student(String name, String number, Integer age) {
		this.name = name;
		this.number = number;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [age=" + age + ", name=" + name + ", number=" + number
				+ "]";
	}
}
