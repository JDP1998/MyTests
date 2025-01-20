package Arrays;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Insertsort {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[] numbers = new int[100000];
		int tausch,counter = 0, i = 1, l = 0, k, place = 0;
		boolean is_found = false;
		long start, end, time;
		String help;
		start = System.currentTimeMillis();
		
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
		
		counter = 0;
		for (counter = 0; counter <= numbers.length - 2; counter++) {
			if (numbers[counter] < numbers[i]) {
			} else {
				k=i;
				for(k=i;k>0;k--) {
					if (numbers[k - 1] > numbers[k]) {
						tausch = numbers[k];
						numbers[k] = numbers[k - 1];
						numbers[k - 1] = tausch;
					}
				}
			}
			i++;
		}
		for (Integer z : numbers) {
			System.out.println(z);
		}
		end=System.currentTimeMillis();
		time=end-start;
		System.out.println("Es hat "+time+" Millisekunden gedauert!");
		
		File f2 = new File("src//Arrays//Time.txt");
		if(f2.exists()==false) {
			f2.createNewFile();
		}
		
		BufferedWriter bWriter2 = new BufferedWriter(new FileWriter(f2,true));
		bWriter2.write("Insertsort: "+time);
		bWriter2.write("\r\n");
		bWriter2.close();
	}
}
