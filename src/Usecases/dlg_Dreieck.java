package Usecases;

public class dlg_Dreieck {
	public static int seitenlänge,mitte;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		seitenlänge=(int)(Math.random()*20)+5;
		if(seitenlänge%2==0) {
			seitenlänge++;
		}
		mitte=seitenlänge/2;
		mitte++;
		draw_body();
		draw_bottom();
	}
	private static void draw_bottom() {
		// TODO Auto-generated method stub
		int counter=0;
		String druckzeile = "";
		while(counter<seitenlänge) {
			druckzeile=druckzeile+"*";
			counter++;
		}
		System.out.println(druckzeile);
		
	}
	private static void draw_body() {
		// TODO Auto-generated method stub
		int counter=0,lücke=0,platzhalter;
		String druckzeile = "";
		platzhalter=mitte-1;
		while(platzhalter>=1) {
			druckzeile = "";
			counter = 0;
			while (counter < platzhalter) {
				druckzeile = druckzeile + " ";
				counter++;
			}
			druckzeile = druckzeile + "*";
			counter = 0;
			if (lücke > 0) {
				while (counter < lücke) {
					druckzeile = druckzeile + " ";
					counter++;
				}
				druckzeile = druckzeile + "*";
				lücke=lücke+2;
			}
			else {
				lücke++;
			}
			System.out.println(druckzeile);
			platzhalter--;
		}
		
	}

}
