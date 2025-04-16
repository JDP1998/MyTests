package List;

import java.util.ArrayList;

public class dlg_ArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean contains;
		int index;
		ArrayList <String> lst_Cars = new ArrayList<>(); 
		lst_Cars.add("Audi");
		lst_Cars.add("BMW");
		lst_Cars.add("Mercedes");
		contains=lst_Cars.contains("Audi");
		System.out.println(contains);
		contains=lst_Cars.contains("Porsche");
		System.out.println(contains);
        index=lst_Cars.lastIndexOf("Mercedes");
        System.out.println(index);
        lst_Cars.subList(0, 1);
        for(String s: lst_Cars) {
        	System.out.println(s);
        }
	}

}
