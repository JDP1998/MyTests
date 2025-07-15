package Koordinaten;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class dlg_Koordinaten {
	public static String city, längengrad, breitengrad;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nach welcher Stadt willst du suchen?");
		city=scanner.nextLine();
		calculate_coordinates();
		System.out.println("Der Breitengrad ist: "+breitengrad);
		System.out.println("Der Längegrad ist: "+längengrad);

	}

	private static void calculate_coordinates() throws InterruptedException {
		// TODO Auto-generated method stub
		String [] ergebnis;
		System.setProperty("gecko.driver","Driver//geckodriver.exe");
		WebDriver d = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));
		d.manage().window().maximize();
		d.get("https://www.google.de/maps/");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/c-wiz/div/div/div/div[2]/div[1]/div[3]/div[1]/div[1]/form[2]/div/div/button/span[6]")));
		d.findElement(By.xpath("/html/body/c-wiz/div/div/div/div[2]/div[1]/div[3]/div[1]/div[1]/form[2]/div/div/button/span[6]")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"searchboxinput\"]")));
		d.findElement(By.xpath("//*[@id=\"searchboxinput\"]")).sendKeys(city);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"searchbox-searchbutton\"]")));
		d.findElement(By.xpath("//*[@id=\"searchbox-searchbutton\"]")).click();
		Thread.sleep(5000);
		ergebnis=d.getCurrentUrl().split("@");
		d.quit();
		ergebnis=ergebnis[1].split(",");
		breitengrad=ergebnis[0];
		längengrad=ergebnis[1];
		
		
	}

}
