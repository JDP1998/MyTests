package Entfernung;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class dlg_Entfernung {
	public static ArrayList <Stadt> lst_Staedte = new ArrayList();

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int eingabe,loesung,differenz=0,guthaben=0,runde=1,fallnr=0;
		String stadt1,stadt2;
		fill_List();
		System.out.println("Herzlich Willkommen zu Johannes Entfernungsspiel. Möchtest du ein kurzes(1), mittlere(2) oder langes(3) Spiel?");
		fallnr=s.nextInt();
		switch(fallnr) {
		case 1: guthaben=1000;break;
		case 2: guthaben=2500;break;
		case 3: guthaben=5000;break;
		default: System.out.println("Das ist ein Fehler passiert!");break;
		}
		System.out.println("\r\n");
		while(guthaben>=0) {
			stadt1=lst_Staedte.get((int)(Math.random()*lst_Staedte.size())).name;
			stadt2=lst_Staedte.get((int)(Math.random()*lst_Staedte.size())).name;
			System.out.println("Die ist Runde "+runde+"! Was ist die Entfernung zwischen "+stadt1+" und "+stadt2+"?");
			eingabe=s.nextInt();
			loesung=check_Distance(stadt1, stadt2);
			if(loesung>-1) {
				if (eingabe >= loesung) {
					differenz = eingabe - loesung;
				} else {
					differenz = loesung - eingabe;
				}
			}
			else {
				differenz=0;
				runde--;
			}
			guthaben=guthaben-differenz;
			runde++;
			System.out.println("Die Entfernung zwischen "+stadt1+" und "+stadt2+"ist "+loesung+"! Damit beträgt dein Guthaben "+guthaben+"!");
			System.out.println("\r\n");
		}
		System.out.println("Das Spiel ist vorbei. Du hast "+runde+" Runden überstanden!");
		

	}

	private static int check_Distance(String stadt1, String stadt2) throws InterruptedException {
		int ergebnis = -1;
		String ergebnis_string;
		String [] arr;
		System.setProperty("gecko.driver","C:\\Users\\Johannes\\OneDrive\\Dokumente\\Geckodriver\\geckodriver.exe");
		WebDriver d = new FirefoxDriver();
		d.manage().window().maximize();
		d.get("https://www.google.de/maps/");
		Thread.sleep(2000);
		d.findElement(By.xpath("/html/body/c-wiz/div/div/div/div[2]/div[1]/div[3]/div[1]/div[1]/form[2]/div/div/button/span[6]")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("/html/body/div[1]/div[3]/div[8]/div[3]/div[1]/div[1]/div/div[1]/div[2]/button/span")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("/html/body/div[1]/div[3]/div[8]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div[1]/div[2]/div[1]/div/input")).sendKeys(stadt1);
		Thread.sleep(2000);
		d.findElement(By.xpath("/html/body/div[1]/div[3]/div[8]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[2]/div[1]/div/input")).sendKeys(stadt2);
		Thread.sleep(2000);
		d.findElement(By.xpath("/html/body/div[1]/div[3]/div[8]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[2]/button[1]/span")).click();
		Thread.sleep(3000);
		List <WebElement> lst_Elements = d.findElements(By.xpath("/html/body/div[1]/div[3]/div[8]/div[9]/div/div/div[1]/div[2]/div/div[1]/div/div/div[5]/div[1]/div[1]/div/div[1]/div[2]/div"));
		if(lst_Elements.size()>0) {
			ergebnis_string=d.findElement(By.xpath("/html/body/div[1]/div[3]/div[8]/div[9]/div/div/div[1]/div[2]/div/div[1]/div/div/div[5]/div[1]/div[1]/div/div[1]/div[2]/div")).getText();
			arr=ergebnis_string.split(" ");
			ergebnis_string=arr[0].replace(".", "");
			if(ergebnis_string.contains(",")) {
				ergebnis_string=ergebnis_string.substring(0,ergebnis_string.length()-2);
			}
			
			ergebnis=Integer.valueOf(ergebnis_string);
		}
		d.quit();
		return ergebnis;
	}

	private static void fill_List() throws IOException {
		// TODO Auto-generated method stub
		String line;
		File f = new File("src//Entfernung//Staedte.txt");
		if(f.exists()==false) {
			f.createNewFile();
		}
		BufferedReader bReader = new BufferedReader (new FileReader(f));
		while((line=bReader.readLine())!=null) {
			Stadt s = new Stadt();
			s.name=line.substring(0,line.length()-3);
			lst_Staedte.add(s);
		}
		bReader.close();
	}

}
