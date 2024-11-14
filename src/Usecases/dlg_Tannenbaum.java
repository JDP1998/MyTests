package Usecases;

public class dlg_Tannenbaum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0, hoehe, breite, start, anz_sterne=1, stammbreite, akt_hoehe=0;
		String druckzeile;
		//Oberer Teil
		breite = (int) (Math.random() * 45) + 5;
		if (breite % 2 == 0) {
			breite = breite + 1;
		}
		start = (int) (breite / 2) + 1;	
		while (start >= 1) {
			i = 0;
			druckzeile = "";
			// Blanks
			for (i = 0; i < start; i++) {
				druckzeile = druckzeile + " ";
			}
			// Sterne
			i = 0;
			for (i = 0; i < anz_sterne; i++) {
				druckzeile = druckzeile + "*";
			}
			System.out.println(druckzeile);
			anz_sterne = anz_sterne + 2;
			start = start - 1;
		}
		//Unterer Teil
		hoehe=(int)(breite/4);
		stammbreite=(int)(breite/2);
		if(stammbreite%2==0) {
			stammbreite=stammbreite+1;
		}
		start=breite-stammbreite;
		start=start/2;
		while(akt_hoehe<hoehe) {
			i=0;
			druckzeile="";
			//Blanks
			for(i=0;i<=start;i++) {
				druckzeile = druckzeile + " ";
			}
			i=0;
			//Stars
			for(i=0;i<stammbreite;i++) {
				druckzeile=druckzeile+"*";
			}
			System.out.println(druckzeile);
			akt_hoehe++;
		}

	}

}
