package Arrays;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Bubblesort {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int [] numbers = new int [10000];
		long start, end, time;
		int durchgaenge=0,counter=0,i,k;
		boolean is_sorted=false;

		start=System.currentTimeMillis();
		
		File f = new File("C:\\Users\\jportzeh\\Desktop\\Java Dateien\\Numbers.txt");
		if(f.exists()==false) {
			f.createNewFile();
		}
		BufferedReader bReader = new BufferedReader(new FileReader(f));
		while(counter<=numbers.length-1) {
			numbers[counter]=Integer.valueOf(bReader.readLine());
			counter++;
		}
		bReader.close();
		i=0;
		while(is_sorted==false) {
			is_sorted=true;
			for(i=0;i<=numbers.length-2;i++) {
				if(numbers[i]<=numbers[i+1]) {
					
				}
				else {
					is_sorted=false;
					k=numbers[i+1];
					numbers[i+1]=numbers[i];
					numbers[i]=k;
				}
			}
			durchgaenge++;
		}
		for(Integer z : numbers) {
			System.out.println(z);
		}
		end=System.currentTimeMillis();
		time=end-start;
		System.out.println("Es hat "+time+" Millisekunden gedauert! Es wurden "+durchgaenge+" Durchläufe benötigt");
	}

}
