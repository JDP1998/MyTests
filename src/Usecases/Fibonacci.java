package Usecases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Fibonacci {
public static void main (String[] args) throws IOException {
	int above,below,seconds,minutes,z;
	File f = new File("C:\\Users\\jportzeh\\Desktop\\Java Dateien\\Fibonacci.txt");
	File f2 = new File("C:\\Users\\jportzeh\\Desktop\\Java Dateien\\Fibonacci_Counter.txt");
	String mstring,sstring;
	if(f.exists()==false) {
		f.createNewFile();
	}
	if(f2.exists()==false) {
		f2.createNewFile();
	}
	BufferedReader bReader = new BufferedReader(new FileReader(f2));
	above=Integer.valueOf(bReader.readLine());
	below=Integer.valueOf(bReader.readLine());
	bReader.close();
	long start,end,time;
	start=System.currentTimeMillis();
	long i=0;
	z=50;
	for(i=0;i<=z;i++) {
		System.out.println("Fibonacci von "+i+" ist "+Fibonacci(i));
	}
	end=System.currentTimeMillis();
	time=end-start;
	time=time/1000;
	minutes=(int)(time/60);
	seconds=(int)(time%60);
	System.out.println("Es hat "+seconds+" Sekunde(-n) gedauert.");
	if(minutes<10) {
		mstring="0"+String.valueOf(minutes);
	}
	else {
		mstring=String.valueOf(minutes);
	}
	if(seconds<10) {
		sstring="0"+String.valueOf(seconds);
	}
	else {
		sstring=String.valueOf(seconds);
	}
	if(seconds<=47) {
		below++;
	}
	else {
		above++;
	}
	System.out.println("\r\n");
	System.out.println(below+" mal liegt die Zeit unter 47 Sekunden.");
	System.out.println("\r\n");
	System.out.println(above+" mal liegt die Zeit über 47 Sekunden.");
	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f,true));
	bufferedWriter.write(mstring+":"+sstring);
	bufferedWriter.write("\r\n");
	bufferedWriter.close();
	BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(f2,false));
	bufferedWriter2.write(String.valueOf(above));
	bufferedWriter2.write("\r\n");
	bufferedWriter2.write(String.valueOf(below));
	bufferedWriter2.close();
}

private static long Fibonacci(long i) {
	// TODO Auto-generated method stub
	if(i<=1) {
		return 1;
	}
	else {
		return Fibonacci(i-1)+Fibonacci(i-2);
	}
}
}
