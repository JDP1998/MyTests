package Arrays;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.w3c.dom.css.Counter;

public class Quicksort {
	public static boolean is_sorted=false;
	public static int pivot;
	public static int [] numbers = new int[10];
	public static void main(String[]args) throws IOException {
		int l,r,turns=1,counter=0,pivot = 0,random=0;
		long start, end, time;
		String help;
		start = System.currentTimeMillis();
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
		l=0;
		r=numbers.length-1;
		pivot=numbers[l+r/2];
		int [] sorted = Quicksort(l,r);
		end=System.currentTimeMillis();
		time=end-start;
		System.out.println("Es hat "+time+" Millisekunden gedauert!");
		
		for(Integer z: sorted) {
			System.out.println(z);
		}
		
		/*File f2 = new File("C:\\Users\\jportzeh\\Desktop\\Java Dateien\\Time.txt");
		if(f2.exists()==false) {
			f2.createNewFile();
		}
		
		BufferedWriter bWriter2 = new BufferedWriter(new FileWriter(f2,true));
		bWriter2.write("Quicksort: "+time);
		bWriter2.write("\r\n");
		bWriter2.close();*/
	}

	private static int[] Quicksort(int l, int r) {
		int k,i=l,j=r;
		while(i<j) {
			while(numbers[i]<pivot&&i<numbers.length-1) {
				i++;
			}
			while(numbers[j]>pivot&&j>=1) {
				j--;
			}
			if(i<j) {
				k=numbers[i];
				numbers[i]=numbers[j];
				numbers[j]=k;
				
			}
			if(j==-1) {
				k=numbers[l+r/2];
				numbers[l+r/2]=numbers[0];
				numbers[0]=k;
			}
			if(i==numbers.length-1) {
				k=numbers[l+r/2];
				numbers[l+r/2]=numbers[numbers.length-1];
				numbers[numbers.length-1]=k;
			}
		}
		return numbers;
		// TODO Auto-generated method stub
		
		
	}

}
