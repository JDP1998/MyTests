package Spongebob;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class dlg_Spongebob {
	public static ArrayList <Folge> lst_Folgen = new ArrayList();
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int counter=1,punkte=0,zufall,eingabe,loesung;
		String folge;
		fill_list();
		while(counter<=10) {
			zufall=(int)(Math.random()*lst_Folgen.size());
			folge=lst_Folgen.get(zufall).name;
			System.out.println("Dies ist Runde "+counter+" von 10. Aus welche Staffel ist die Folge "+folge+"?");
			eingabe=s.nextInt();
			loesung=get_Season(folge);
			if(loesung>0) {
				if (eingabe == loesung) {
					punkte++;
				}
			}
			System.out.println("Die Folge ist aus Staffel "+loesung+". Damit hast du "+punkte+" Punkte!");
			System.out.println("\r\n");
			lst_Folgen.remove(zufall);
			counter++;
		}
		System.out.println("Das Spiel ist vorbei. Du hast "+punkte+" Punkte erzielt!");

	}

	private static int get_Season(String folge) throws InterruptedException {
		// TODO Auto-generated method stub
		String [] teile;
		int loesung=-1;
		System.setProperty("gecko.driver","C:\\Users\\Johannes\\OneDrive\\Dokumente\\Geckodriver\\geckodriver.exe");
		WebDriver d = new FirefoxDriver();
		d.manage().window().maximize();
		d.get("http://de.spongepedia.org/index.php/Hauptseite");
		Thread.sleep(2000);
		d.findElement(By.xpath("//*[@id=\"searchInput\"]")).sendKeys(folge+" (Episode)");
		Thread.sleep(2000);
		d.findElement(By.xpath("//*[@id=\"searchButton\"]")).click();
		Thread.sleep(2000);
		List <WebElement> lst_Elements = d.findElements(By.xpath("/html/body/div[3]/div/div[3]/div[4]/table[1]/tbody/tr[4]/td[2]"));
		Thread.sleep(2000);
		if(lst_Elements.size()>0) {
			teile = d.findElement(By.xpath("/html/body/div[3]/div/div[3]/div[4]/table[1]/tbody/tr[4]/td[2]")).getText().split("/");
			loesung = Integer.valueOf(teile[0]);
		}
		d.quit();
		return loesung;
	}

	private static void fill_list() throws IOException {
		// TODO Auto-generated method stub
		String line;
		File f = new File("src//Spongebob//Folgen.txt");
		if(f.exists()==false) {
			f.createNewFile();
		}
		BufferedReader bReader = new BufferedReader(new FileReader(f));
		while((line=bReader.readLine())!=null) {
			Folge akt_folge = new Folge();
			akt_folge.name=line;
			lst_Folgen.add(akt_folge);
		}
		bReader.close();
	}

}
