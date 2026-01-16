package Usecases;

public class Dreieckszahlen {
	public static int counter;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		counter=(int)(Math.random()*900)+100;
		dreieckzahlen(counter);
		
		
	}
	private static void dreieckzahlen(int limit) {
		// TODO Auto-generated method stub
		int number=1,addcounter=2,result=1;
		while(number<limit) {
			if(number>1) {
				result=result+addcounter;
				addcounter++;
			}
			else {
				result=1;
			}
			System.out.println(result);
			number++;
		}
	}

}
