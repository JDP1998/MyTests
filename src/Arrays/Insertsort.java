package Arrays;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Insertsort {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[] numbers = new int[10000];
		int tausch,counter = 0, i = 1, l = 0, k, place = 0;
		boolean is_found = false;
		long start, end, time;
		
		start = System.currentTimeMillis();
		
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
	}
}
