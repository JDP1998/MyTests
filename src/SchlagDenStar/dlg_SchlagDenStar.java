package SchlagDenStar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class dlg_SchlagDenStar {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Table> lst_Tables = new ArrayList();
		ArrayList <Table> lst_Random_Tables = new ArrayList();
		String table,name;
		File f = new File("C:\\Users\\Johannes\\Documents\\Tische.txt");
		int counter = 0, random;
		if (f.exists() == false) {
			f.createNewFile();
		}
		BufferedReader breader = new BufferedReader(new FileReader(f));
		while ((name = breader.readLine()) != null) {
			Table s = new Table();
			s.setName(name);
			lst_Tables.add(s);
		}
		breader.close();
		while(lst_Tables.size()>0) {
			random = (int) (Math.random() * lst_Tables.size());
			lst_Random_Tables.add(lst_Tables.get(random));
			lst_Tables.remove(random);
		}
		//System.out.println(lst_Random_Tables.size());
		while (counter <= 15) {
			random = (int) (Math.random() * lst_Random_Tables.size());
			table = lst_Random_Tables.get(random).getName();
			lst_Random_Tables.remove(random);
			System.out.println(table);
			counter++;
		}
	}

}
