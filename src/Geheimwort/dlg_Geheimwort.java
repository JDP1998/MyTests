package Geheimwort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class dlg_Geheimwort {
	public static ArrayList <Country> lst_Countries = new ArrayList();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		boolean is_in_list=false,play=true,solved=false;
		int round=1,result = 0,random;
		Scanner s = new Scanner (System.in);
		Scanner s2 = new Scanner(System.in);
		String guess,solution;
		fill_list();
		random=(int)(Math.random()*lst_Countries.size());
		solution=lst_Countries.get(random).name;
		random++;
		while(round <= 10 && solved == false) {
			result=-1;
			is_in_list=false;
			System.out.println("Runde "+round+" von 10! Bitte gib ein Land ein!");
			guess=s.nextLine();
			for(Country c : lst_Countries) {
				if(guess.equals(c.name)) {
					if(c.number>=random) {
						result=c.number-random;
					}
					else {
						result=random-c.number;
					}
					is_in_list=true;
					break;
				}
			}
			if(result==0) {
				System.out.println("\r\n");
				System.out.println("Du hast das Geheimwort gelöst. Es war "+solution+"! Du hast "+round+" Runden gebraucht");
				solved=true;
			}
			else {
				if(is_in_list==false) {
					if(round<10) {
						System.out.println("\r\n");
						System.out.println("Das Land existiert nicht versuch es nochmal!");
						System.out.println("\r\n");
					}
				}
				else {
					if(round<10) {
						System.out.println("\r\n");
						System.out.println("Du bist " + result + " von der Lösung entfernt");
						System.out.println("\r\n");
					}
				}
			}
			round++;
		}
		if(solved==true) {
		}
		else {
			System.out.println("\r\n");
			System.out.println("Du hast es leider nicht geschafft. Die Lösung war "+solution);
		}

	}

	private static void fill_list() throws IOException {
		// TODO Auto-generated method stub
		String line;
		int counter=1;
		File f = new File("src//Geheimwort//Laender.txt");
		if(f.exists()==false) {
			f.createNewFile();
		}
		BufferedReader bReader = new BufferedReader (new FileReader(f));
		while((line=bReader.readLine())!=null) {
			Country c = new Country();
			c.name=line;
			c.number=counter;
			lst_Countries.add(c);
			counter++;
		}
		bReader.close();
	}

}
