package Usecases;

public class dlg_Formzahlen {
	public static int counter;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		counter=(int)(Math.random()*90)+10;
		System.out.println("Dreieckzahlen bis "+counter+": ");
		dreieckzahlen(counter);
		System.out.println("\r\n");
		System.out.println("Viereckzahlen bis "+counter+": ");
		viereckzahlen(counter);
		System.out.println("\r\n");
		System.out.println("Fünfeckzahl bis "+counter+": ");
		fuenfeckzahlen(counter);
		
		
	}
	private static void fuenfeckzahlen(int limit) {
		// TODO Auto-generated method stub
		int number=1, addcounter=4, result=1;
		while(number<limit) {
			if(number>1) {
				result=result+addcounter;
				addcounter=addcounter+3;
			}
			else {
				result=1;
			}
			System.out.println(result);
			number++;
		}
	}
	private static void viereckzahlen(int limit) {
		// TODO Auto-generated method stub
		int number=1, addcounter=3, result=1;
		while(number<limit) {
			if(number>1) {
				result=result+addcounter;
				addcounter=addcounter+2;
			}
			else {
				result=1;
			}
			System.out.println(result);
			number++;
		}
	}
	private static void dreieckzahlen(int limit) {
		// TODO Auto-generated method stub
		int number=1, addcounter=2, result=1;
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
