package Mathe;

import java.util.Scanner;

public class dlg_Heron {
public static int suchzahl,anz_stelle;
public static double suchergebnis;
public static void main (String[]args) {
	Scanner s = new Scanner(System.in);
	System.out.println("Von welcher Zahl wollen Sie die Wurzel annähern?");
	suchzahl=s.nextInt();
	System.out.println("Auf wie viele Stellen hinter dem Komma soll das Ergebnis angenähert werden?");
	anz_stelle=s.nextInt();
	suchergebnis=heron(suchzahl);
	System.out.println(suchergebnis);
}
private static double heron(int zahl) {
	// TODO Auto-generated method stub
	double ergebnis = 0,start=1;
	boolean ist_fertig=false;
	while(ist_fertig==false) {
		ergebnis=start+suchzahl/start;
		ergebnis=ergebnis/2;
		if(ergebnis!=start) {
			ist_fertig = stellenpruefer(start, ergebnis);
		}
		else {
			ist_fertig=true;
		}
		start=ergebnis;
	}
	ergebnis=runden(ergebnis);
	return ergebnis;
}
private static double runden(double ergebnis) {
	// TODO Auto-generated method stub
	String ergebnis_string = String.valueOf(ergebnis);
	int counter=0,zahl;
	boolean ist_dezimal=false;
	char number;
	while(counter<=ergebnis_string.length()-1) {
		if(ergebnis_string.charAt(counter)==46) {
			ist_dezimal=true;
			break;
		}
		counter++;
	}
	if(counter+anz_stelle<ergebnis_string.length()-1&&ist_dezimal==true) {
		if(ergebnis_string.charAt(counter+anz_stelle+1)>=53) {
			zahl=Integer.valueOf(ergebnis_string.charAt(counter+anz_stelle));
			zahl++;
			ergebnis_string=ergebnis_string.substring(0,counter+anz_stelle);
			number=(char)zahl;
			ergebnis_string=ergebnis_string+number;
		}
		else {
			ergebnis_string=ergebnis_string.substring(0,counter+anz_stelle+1);
		}
	}
	return Double.valueOf(ergebnis_string);
}
private static boolean stellenpruefer(double start, double ergebnis) {
	// TODO Auto-generated method stub
	boolean ist_gleich=true,ist_komma=false;
	int counter=0,stellen=-1;
	String start_string,ergebnis_string;
	start_string=String.valueOf(start);
	ergebnis_string=String.valueOf(ergebnis);
	while(stellen<=anz_stelle||counter<=start_string.length()-1) {
		if(start_string.charAt(counter)!=ergebnis_string.charAt(counter)) {
			ist_gleich=false;
			break;
		}
		else {
			if(start_string.charAt(counter)==46 || ergebnis_string.charAt(counter)==46) {
				ist_komma=true;
			}
			if(ist_komma==true) {
				stellen++;
			}
			counter++;
			
		}
	}
	return ist_gleich;
}
}
