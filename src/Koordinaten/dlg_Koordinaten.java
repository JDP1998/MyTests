package Koordinaten;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class dlg_Koordinaten {
	public static String city;
	public static int breite,länge;
	public static ArrayList <Stadt>lst_Staedte=new ArrayList();

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int differenz,guess_breite,guess_laenge,random,points=200;
		fill_list();
		while(points>0) {
			random = (int) (Math.random()*lst_Staedte.size());
			city = lst_Staedte.get(random).get_name();
			System.out.println("Was ist der Breitengrad von "+city+"?");
			guess_breite=scanner.nextInt();
			System.out.println("\r\n");
			System.out.println("Was ist der Längengrad von "+city+"?");
			guess_laenge=scanner.nextInt();
			System.out.println("\r\n");
			calculate_coordinates();
			System.out.println("Der Breitengrad ist: " + breite);
			System.out.println("\r\n");
			System.out.println("Der Längegrad ist: " + länge);
			System.out.println("\r\n");
			if(guess_breite>breite) {
				differenz=guess_breite-breite;
			}
			else {
				differenz=breite-guess_breite;
			}
			points=points-differenz;
			if(guess_laenge>länge) {
				differenz=guess_laenge-länge;
			}
			else {
				differenz=breite-guess_breite;
			}
			points=points-differenz;
			System.out.println("Du hast noch "+points+" Punkte.");
			System.out.println("\r\n");
		}

	}

	private static void fill_list() throws IOException {
		// TODO Auto-generated method stub
		String line;
		File f = new File("src//Koordinaten//Hauptstaedte.txt");
		if(f.exists()==false) {
			f.createNewFile();
		}
		BufferedReader bReader = new BufferedReader (new FileReader (f));
		while((line=bReader.readLine())!=null) {
			Stadt s = new Stadt();
			s.set_name(line);
			lst_Staedte.add(s);
		}
		bReader.close();
;	}

	private static void calculate_coordinates() throws InterruptedException {
		// TODO Auto-generated method stub
		String [] ergebnis;
		String längengrad,breitengrad;
		System.setProperty("gecko.driver","Driver//geckodriver.exe");
		WebDriver d = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));
		d.manage().window().maximize();
		d.get("https://www.google.de/maps/");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/c-wiz/div/div/div/div[2]/div[1]/div[3]/div[1]/div[1]/form[2]/div/div/button/span[6]")));
		d.findElement(By.xpath("/html/body/c-wiz/div/div/div/div[2]/div[1]/div[3]/div[1]/div[1]/form[2]/div/div/button/span[6]")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"searchboxinput\"]")));
		d.findElement(By.xpath("//*[@id=\"searchboxinput\"]")).sendKeys(city);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div[9]/div[3]/div[1]/div[1]/div/div[1]/div[1]/button")));
		d.findElement(By.xpath("/html/body/div[1]/div[2]/div[9]/div[3]/div[1]/div[1]/div/div[1]/div[1]/button")).click();
		Thread.sleep(5000);
		ergebnis=d.getCurrentUrl().split("@");
		d.quit();
		ergebnis=ergebnis[1].split(",");
		breitengrad=ergebnis[0];
		längengrad=ergebnis[1];
		breite=(int)(Math.round(Double.valueOf(breitengrad)));
		länge=(int)(Math.round(Double.valueOf(längengrad)));
		
	}

}
