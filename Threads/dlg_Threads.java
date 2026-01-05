package Threads;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class dlg_Threads {
	public static int position=1;
	public static String winner;
	public static void main (String[]args) throws IOException
	{
		ArrayList <Prozess> lst_Prozesses = new ArrayList<>();
		ArrayList <Thread> lst_Threads = new ArrayList<>();
		boolean is_alive=true;
		int i, counter=0, anz;
		i = 1;
		anz = 10;
		while (i <= anz) {
			Prozess p = new Prozess();
			p.setName("Thread "+i);
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
		
		File f = new File("C:\\Users\\jportzeh\\Desktop\\Java Dateien\\Threads.txt");
		if(f.exists()==false) {
			f.createNewFile();
		}
		BufferedReader bReader = new BufferedReader(new FileReader(f));
		for(Prozess p: lst_Prozesses) {
			if(p.getName().equals(winner)) {
				String parts[] = bReader.readLine().split(":");
				p.setWins(Integer.valueOf(parts[1])+1);
			}
			else {
				String parts[] = bReader.readLine().split(":");
				p.setWins(Integer.valueOf(parts[1]));
			}
		}
		bReader.close();
		
		BufferedWriter bWriter = new BufferedWriter(new FileWriter(f,false));
		for(Prozess p: lst_Prozesses) {
			bWriter.write(p.getName()+":"+String.valueOf(p.getWins()));
			bWriter.write("\r\n");
		}
		bWriter.close();
	}
	private static void print_winner() {
		// TODO Auto-generated method stub
		System.out.println("Der Gewinner ist "+winner+"!");
	}

}


