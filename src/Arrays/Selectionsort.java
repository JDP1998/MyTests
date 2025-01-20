package Arrays;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Selectionsort {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int [] numbers = new int [100000];
		int k = 0,i,min = 0,counter=0;
		long start, end, time;
		
		start=System.currentTimeMillis();
		
		File f = new File("C:\\Users\\jportzeh\\git\\MyTests\\src\\Arrays\\Numbers.txt");
		if(f.exists()==false) {
			f.createNewFile();
		}
		
		BufferedWriter bWriter = new BufferedWriter(new FileWriter(f,false));
		
		for(counter=0;counter<=numbers.length-1;counter++) {
			numbers [counter] = (int)(Math.random()*100000)+1; 
			bWriter.write(String.valueOf(numbers[counter]));
			bWriter.write("\r\n");
		}
		bWriter.close();
		
		counter=0;
		while(counter<=numbers.length-1) {
			min=numbers[counter];
			i=counter+1;
			while(i<=numbers.length-1) {
				if(min<=numbers[i]) {
					
				}
				else {
					min=numbers[i];
					k=i;
				}
				i++;
			}
			numbers[k]=numbers[counter];
			numbers[counter]=min;
			counter++;
		}
		for(Integer l: numbers) {
			System.out.println(l);
		}
		end=System.currentTimeMillis();
		time=end-start;
		System.out.println("Es hat "+time+" Millisekunden gedauert!");
		

		File f2 = new File("C:\\Users\\jportzeh\\git\\MyTests\\src\\Arrays\\Time.txt");
		if(f2.exists()==false) {
			f2.createNewFile();
		}
		
		BufferedWriter bWriter2 = new BufferedWriter(new FileWriter(f2,false));
		bWriter2.write("Selectionsort: "+time);
		bWriter2.write("\r\n");
		bWriter2.close();
	}

}
