package Mathe;

import java.util.ArrayList;

public class dlg_Primzahlsucher {
	public static int paare=0,bereich,counter;
	public static ArrayList <Integer> lst_Primzahlen = new ArrayList(); 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bereich = (int)(Math.random()*900000)+100000;
		System.out.println("Es werden Primzahlen im Bereich bis "+bereich+" gesucht!");
		System.out.println("\r\n");
		Primzahl_suchen(bereich);
		System.out.println("Primzahlen: ");
		for(Integer i: lst_Primzahlen) {
			System.out.println(i);
		}
		System.out.println("\r\n");
		System.out.println("Es wurden "+lst_Primzahlen.size()+" Primzahlen und "+paare+" Primzahlpaare gefunden");

	}
	private static void Primzahl_suchen(int zahl) {
		// TODO Auto-generated method stub
		int teiler=2;
		boolean is_primzahl;
		counter=2;
		while(counter<=bereich) {
			teiler=2;
			is_primzahl=true;
			while(teiler<counter) {
				if(counter%teiler==0) {
					is_primzahl=false;
				}
				teiler++;
			}
			if(is_primzahl==true) {
				lst_Primzahlen.add(counter);
			}
			counter++;
		}
		counter=1;
		while(counter<=lst_Primzahlen.size()-1) {
			if(lst_Primzahlen.get(counter)-lst_Primzahlen.get(counter-1)==2) {
				paare++;
			}
			counter++;
		}
	}

}
