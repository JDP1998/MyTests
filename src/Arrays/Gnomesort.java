package Arrays;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Gnomesort {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int [] numbers = new int [10000];
		int k,gnome=0,counter=0;
		long start, end, time;
		String help;
		start=System.currentTimeMillis();
		
		File f = new File("C:\\Users\\jportzeh\\Desktop\\Java Dateien\\Numbers.txt");
		if(f.exists()==false) {
			f.createNewFile();
		}
		BufferedReader bReader = new BufferedReader(new FileReader(f));
		while((help=(bReader.readLine()))!=null) {
			numbers[counter]=Integer.valueOf(help);
			counter++;
		}
		bReader.close();
		
		while(gnome<=numbers.length-2) {
			if(numbers[gnome]>numbers[gnome+1]) {
				k=numbers[gnome+1];
				numbers[gnome+1]=numbers[gnome];
				numbers[gnome]=k;
				if(gnome>0) {
					gnome--;
				}
				else {
					gnome++;
				}
			}
			else {
				gnome++;
			}
		}
		for(Integer l: numbers) {
			System.out.println(l);
		}
		end=System.currentTimeMillis();
		time=end-start;
		System.out.println("Es hat "+time+" Millisekunden gedauert!");

	}

}
