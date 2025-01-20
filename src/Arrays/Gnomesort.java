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
		int [] numbers = new int [100000];
		int k,gnome=0,counter=0;
		long start, end, time;
		String help;
		start=System.currentTimeMillis();
		
		File f = new File("src//Arrays//Numbers.txt");
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

		
		File f2 = new File("src//Arrays//Time.txt");
		if(f2.exists()==false) {
			f2.createNewFile();
		}
		
		BufferedWriter bWriter2 = new BufferedWriter(new FileWriter(f2,true));
		bWriter2.write("Gnomesort: "+time);
		bWriter2.write("\r\n");
		bWriter2.close();
	}

}
