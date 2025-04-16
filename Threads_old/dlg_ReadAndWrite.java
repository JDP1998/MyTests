package Threads_old;

import java.util.ArrayList;

public class dlg_ReadAndWrite {
	public static int number=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList <Thread> lst_Threads = new ArrayList<>();
		int i=1,anz=10;
		while(i<=anz) {
			Reader r = new Reader();
			Writer w = new Writer();
			Thread read_thread = new Thread(r);
			Thread write_thread = new Thread(w);
			lst_Threads.add(read_thread);
			lst_Threads.add(write_thread);
			i++;
		}
		for(Thread t: lst_Threads) {
			t.start();
		}
		System.out.println("Number "+number);

	}

}
