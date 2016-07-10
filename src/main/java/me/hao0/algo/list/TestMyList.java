package me.hao0.algo.list;

public class TestMyList {
	public static void main(String[] args) {
		MyList<Student> stus = new MyList<Student>();
		for (int i=0; i<5; i++){
			stus.add(new Student("ѧ��"+i, "ѧ��"+i, 20+i));
		}
		
		System.out.println("before remove:");
		for (int i=0; i<stus.size(); i++){
			System.out.println(stus.get(i));
		}
		
		stus.remove(3);
		
		System.out.println("after remove:");
		for (int i=0; i<stus.size(); i++){
			System.out.println(stus.get(i));
		}
	}
}
