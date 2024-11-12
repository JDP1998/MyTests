package Rekursion;

import java.util.Scanner;

public class Fibonacci {
public static void main (String[] args) {
	System.out.println("Welche Zahl möchtest du berechnen?");
	long start,end,time;
	start=System.currentTimeMillis();
	int i=0,z;
	z=50;
	for(i=0;i<=z;i++) {
		System.out.println("Fibonacci von "+i+" ist "+Fibonacci(i));
	}
	end=System.currentTimeMillis();
	time=end-start;
	time=time/1000;
	time=time/60;
	System.out.println("Es hat "+time+" Minuten gedauert.");
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
