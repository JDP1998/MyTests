package Rekursion;

public class Fibonacci {
public static void main (String[] args) {
	long start,end,time;
	start=System.currentTimeMillis();
	int seconds,minutes,i=0,z;
	z=50;
	for(i=0;i<=z;i++) {
		System.out.println("Fibonacci von "+i+" ist "+Fibonacci(i));
	}
	end=System.currentTimeMillis();
	time=end-start;
	time=time/1000;
	minutes=(int)(time/60);
	seconds=(int)(time%60);
	System.out.println("Es hat "+minutes+" Minute(-n) und "+seconds+" Sekunde(-n) gedauert.");
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
