package Threads;

public class dlg_Threads {
	public static void main (String[]args)
	{
		int i, anz;
		i = 1;
		anz = 10;
		while (i <= anz) {
			Prozess p = new Prozess();
			p.setName(i);
			Thread t = new Thread(p);
			t.start();
			i++;
		}
	}

}


