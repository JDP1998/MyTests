package Usecases;

public class dlg_Zeichnung {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int random,linecounter=0,counter=0;
		String druckzeile;
		
		while(linecounter<30) {
			counter=0;
			druckzeile="";
			while(counter<150) {
				random=(int)(Math.random()*100)+1;
				if(random%2==0) {
					druckzeile=druckzeile+"*";
				}
				else {
					druckzeile=druckzeile+" ";
				}
				counter++;
			}
			System.out.println(druckzeile);
			linecounter++;
		}

	}

}
