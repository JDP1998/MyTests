package Usecases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Fibonacci {
public static void main (String[] args) throws IOException {
	File f = new File("C:\\Users\\jportzeh\\Desktop\\Java Dateien\\Time.txt");
	String mstring,sstring;
	if(f.exists()==false) {
		f.createNewFile();
	}
	long start,end,time;
	start=System.currentTimeMillis();
	int seconds,minutes,i=0,z;
	z=55;
	for(i=0;i<=z;i++) {
		System.out.println("Fibonacci von "+i+" ist "+Fibonacci(i));
	}
	end=System.currentTimeMillis();
	time=end-start;
	time=time/1000;
	minutes=(int)(time/60);
	seconds=(int)(time%60);
	System.out.println("Es hat "+minutes+" Minute(-n) und "+seconds+" Sekunde(-n) gedauert.");
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
	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f,true));
	bufferedWriter.write(mstring+":"+sstring);
	bufferedWriter.write("\r\n");
	bufferedWriter.close();
}

private static int Fibonacci(int i) {
	// TODO Auto-generated method stub
	if(i<=1) {
		return 1;
	}
	else {
		return Fibonacci(i-1)+Fibonacci(i-2);
	}
}
}
