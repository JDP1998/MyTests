package Mathe;

import java.util.ArrayList;

public class dlg_Primfaktorzerlegung {
	public static int counter=0,number, rest=1, grenze;
	public static ArrayList <Integer> lst_Primfaktoren = new ArrayList();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		number=(int)(Math.random()*100000)+100000;
		System.out.println("Folgende Nummer gilt es zu zerlegen "+number);
		rest=number;
		while(rest>1) {
			grenze_finden();
			zerlegung();
		}
		System.out.println("\r\n");
		if(lst_Primfaktoren.size()>0) {
			System.out.println("Primfaktoren:");
			for (Integer i : lst_Primfaktoren) {
				System.out.println(i);
			}
		}
		else {
			System.out.println("Die Zahl ist ein Primzahl!");
		}

	}
	private static void grenze_finden() {
		// TODO Auto-generated method stub
		counter=1;
		while(rest/counter>counter) {
			counter++;
		}
		grenze=counter;
	}
	private static void zerlegung() {
		// TODO Auto-generated method stub
		counter=2;
		while(rest%counter>0&&counter<=grenze) {
			counter++;
		}
		if(counter<grenze) {
			lst_Primfaktoren.add(counter);
			rest = rest / counter;
		}
		else {
			lst_Primfaktoren.add(rest);
			rest=0;
		}
	}

}
