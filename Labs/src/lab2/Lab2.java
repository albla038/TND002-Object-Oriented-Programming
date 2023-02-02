package lab2;

public class Lab2 {

	public static void main(String[] args) {
		Dictionary d1 = new Dictionary();
		
		d1.addString("test");
		d1.addString("test");
		d1.addString("test");
		d1.addString("test2");
		d1.addString("test");
		d1.addString("test2");
		d1.addString("test2");
		d1.addString("test2");
		d1.addString("test2");
		d1.addString("test2");
		d1.addString("test2");
		d1.addString("test2");
		
		System.out.println(d1);
		
		System.out.println(d1.sortList(Word.BYNAME));
		System.out.println(d1);
	}

}
