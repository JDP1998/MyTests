package Threads_old;


public class dlg_Threads {
	public static void main (String[]args)
	{
		int i, anz;
		i = 0;
		anz = 10;
		while (i <= anz) {
			Prozess p = new Prozess();
			p.name = i;
			Thread t = new Thread(p);
			t.start();
			i++;
		}
	}

}


