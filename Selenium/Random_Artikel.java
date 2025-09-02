package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Random_Artikel {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Hello!");
		int i=0;
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\jportzeh\\Downloads\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.get("http://de.spongepedia.org/index.php/Hauptseite");
		Thread.sleep(1000);
		while(i<=9) {
			driver.findElement(By.xpath("//*[@id=\"n-randompage\"]/a")).click();
			Thread.sleep(1000);
			i++;
		}
		System.out.println(driver.findElement(By.xpath("/html/body/div[3]/div/h1/span")).getText());
		driver.quit();
	}

}
