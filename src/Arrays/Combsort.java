package Arrays;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Combsort {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int [] numbers = new int [100000];
		long  start, end, time;
		int durchgaenge=0,gap,counter=0,i,k;
		boolean is_sorted=false;
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
		
		i=0;
		gap=numbers.length-1;
		while(is_sorted==false&&gap>1) {
			is_sorted=true;
			i=0;
			for(i=0;i+gap<=numbers.length-1;i++) {
				if(numbers[i]>numbers[i+gap]) {
					k=numbers[i+gap];
					numbers[i+gap]=numbers[i]; 
					numbers[i]=k;
					is_sorted=false;
				}
			}
			if(gap>1) {
				gap = (int) (gap / 1.3);
			}
			durchgaenge++;
		}
		for(Integer z : numbers) {
			System.out.println(z);
		}
		end=System.currentTimeMillis();
		time=end-start;
		System.out.println("Es hat "+time+" Millisekunden gedauert! Es wurden "+durchgaenge+" Durchläufe benötigt!");
		
		File f2 = new File("C:\\Users\\jportzeh\\Desktop\\Java Dateien\\Time.txt");
		if(f2.exists()==false) {
			f2.createNewFile();
		}
		
		BufferedWriter bWriter2 = new BufferedWriter(new FileWriter(f2,true));
		bWriter2.write("Combsort: "+time);
		bWriter2.write("\r\n");
		bWriter2.close();
		
		
	}

}
