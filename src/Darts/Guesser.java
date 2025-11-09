package Darts;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import javax.swing.JList;

public class Guesser extends JFrame {
	public static int length=224;
	public static String names [] = new String [length];
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Guesser frame = new Guesser();
					frame.setVisible(true);
					frame.setTitle("Johannes's Ratespiel");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Guesser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_Start = new JButton("Start");
		btn_Start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int counter = 0;
				System.setProperty("gecko.driver","Drivers//geckodriver.exe");
				WebDriver d = new FirefoxDriver();
				WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));
				d.manage().window().maximize();
				d.get("https://www.dartsrankings.com/");
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//td//child::a")));
				List <WebElement> lst_WebElements = d.findElements(By.xpath("//td//child::a"));
				length=lst_WebElements.size();
				for(WebElement element: lst_WebElements) {
					names[counter]=element.getText();
					counter++;
				}
				d.quit();
				
			}
		});
		btn_Start.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_Start.setBounds(10, 164, 76, 72);
		contentPane.add(btn_Start);
		
		JList list_Players = new JList(names);
		list_Players.setBounds(10, 23, 150, 116);
		contentPane.add(list_Players);
		
	}
}
