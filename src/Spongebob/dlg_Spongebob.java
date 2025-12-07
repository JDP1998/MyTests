package Spongebob;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
			else {
				System.out.println("Da ist ein Fehler passiert!");
				counter=counter-1;
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
		String search,searchbtn,result;
		search="//*[@id=\"searchInput\"]";
		searchbtn="//*[@id=\"searchButton\"]";
		result="/html/body/div[3]/div/div[3]/div[4]/table[1]/tbody/tr[4]/td[2]";
		int loesung=-1;
		System.setProperty("gecko.driver","Drivers//geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--headless=new");
		options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
		WebDriver d = new FirefoxDriver(options);
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));
		d.manage().window().maximize();
		d.get("http://de.spongepedia.org/index.php/Hauptseite");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(search)));
		d.findElement(By.xpath(search)).sendKeys(folge+" (Episode)");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(searchbtn)));
		d.findElement(By.xpath(searchbtn)).click();
		try{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(result)));
			teile = d.findElement(By.xpath(result)).getText().split("/");
			loesung = Integer.valueOf(teile[0]);
		}
		catch(TimeoutException e) {
			loesung=-1;
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
