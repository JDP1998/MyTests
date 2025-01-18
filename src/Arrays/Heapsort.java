package Arrays;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Heapsort {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[] numbers = new int[10000];
		int k,i=0,parent=0,counter=0;
		long start, end, time;
		boolean is_sorted=false;
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
		counter=numbers.length-1;
		while(counter>1) {
			i = counter;
			for (i = counter; i > 0; i--) {
				parent = i / 2;
				if(i%2==0) {
					parent--;
				}
				else {
				}
				if (numbers[i] > numbers[parent]) {
					k = numbers[i];
					numbers[i] = numbers[parent];
					numbers[parent] = k;
				}
			}
			
			k=numbers[0];
			numbers[0]=numbers[counter];
			numbers[counter]=k;
			counter--;
		}
		for(Integer l: numbers) {
			System.out.println(l);
		}
		end=System.currentTimeMillis();
		time=end-start;
		System.out.println("Es hat "+time+" Millisekunden gedauert!");
		

	}

}
