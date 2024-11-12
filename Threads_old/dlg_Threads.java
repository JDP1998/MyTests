package Threads_old;
import Threads_old.Prozess;

public class dlg_Threads {
	public static void main (String[]args)
	{
		int i, anz;
		i = 0;
		anz = 10;
		while (i <= anz) {
			Threads_old.Prozess p = new Threads_old.Prozess();
			p.name = i;
			Thread t = new Thread(p);
			t.start();
			i++;
		}
	}

}


