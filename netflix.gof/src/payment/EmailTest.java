package payment;

import global.Category;

public class EmailTest {
	public static void main(String[] args) {
		for(Category f : Category.values()){
		    System.out.println(f + ":" + f.name() + ":" + f.ordinal());
		}
	}
}
