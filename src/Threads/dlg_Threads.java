package Threads;

import java.util.ArrayList;

public class dlg_Threads {
	public static int position=1;
	public static int winner;
	public static void main (String[]args)
	{
		ArrayList <Prozess> lst_Prozesses = new ArrayList<>();
		ArrayList <Thread> lst_Threads = new ArrayList<>();
		boolean is_alive=true;
		int i, counter=0, anz;
		i = 1;
		anz = 10;
		while (i <= anz) {
			Prozess p = new Prozess();
			p.setName(i);
			Thread t = new Thread(p);
			t.start();
			i++;
			lst_Threads.add(t);
			lst_Prozesses.add(p);
		}
		while(is_alive==true) {
			counter=0;
			is_alive=false;
			for(Thread t: lst_Threads) {
				if(t.isAlive()==true) {
					is_alive=true;
				}
			}
		}
		print_winner();
	}
	private static void print_winner() {
		// TODO Auto-generated method stub
		System.out.println("Der Gewinner ist "+winner+"!");
	}

}


