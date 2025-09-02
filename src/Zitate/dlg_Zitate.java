package Zitate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Spongebob.Folge;

public class dlg_Zitate {
	public static ArrayList <Folge> lst_Folgen = new ArrayList();
	public static ArrayList <String> lst_Quotes = new ArrayList();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String folge;
		int counter=1,random;
		fill_list();
		while(counter<=1) {
			random=(int)(Math.random()*lst_Folgen.size());
			folge=(lst_Folgen.get(random).name);
			fill_qoutes(folge);
			counter++;
		}
		

	}

	private static void fill_qoutes(String folge) {
		// TODO Auto-generated method stub
		String search,searchbtn,result,mitschrift;
		search="//*[@id=\"searchInput\"]";
		searchbtn="//*[@id=\"searchButton\"]";
		result="/html/body/div[3]/div/div[3]/div[4]/table[1]/tbody/tr[4]/td[2]";
		mitschrift="//a[contains(text(),'Lies dir die Episodenmitschrift durch!')]";
		System.setProperty("gecko.driver","Drivers//geckodriver.exe");
	    FirefoxOptions options = new FirefoxOptions();
	    //options.addArguments("headless");
		WebDriver d = new FirefoxDriver(options);
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));
		d.manage().window().maximize();
		d.get("http://de.spongepedia.org/index.php/Hauptseite");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(search)));
		d.findElement(By.xpath(search)).sendKeys(folge+" (Episode)");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(searchbtn)));
		d.findElement(By.xpath(searchbtn)).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(mitschrift)));
		d.findElement(By.xpath(mitschrift)).click();
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
