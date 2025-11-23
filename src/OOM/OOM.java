package OOM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Darts.Player;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class OOM extends JFrame {
	
	public static ArrayList <Player> lst_Players = new ArrayList();
	public static int guesscounter=0,random1,random2;
	public static JButton btn_Player2 = new JButton("");
	public static JButton btn_Player1 = new JButton("");
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OOM frame = new OOM();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OOM() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btn_Player1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lst_Players.get(random1).get_Number()<lst_Players.get(random2).get_Number()) {
					guesscounter++;
					random1=(int)(Math.random()*lst_Players.size());
					random2=random1;
					while(random2==random1) {
						random2=(int)(Math.random()*lst_Players.size());
					}
					btn_Player1.setText(lst_Players.get(random1).get_Name());
					btn_Player2.setText(lst_Players.get(random2).get_Name());
				}
				else {
					JOptionPane.showMessageDialog(btn_Player1, "Gameover. Du hast "+guesscounter+" mal richtig geraten");
					setVisible(false);
					dispose();
				}
			}
		});
		btn_Player1.setEnabled(false);
		btn_Player1.setBounds(22, 47, 160, 23);
		contentPane.add(btn_Player1);
		btn_Player2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lst_Players.get(random2).get_Number()<lst_Players.get(random1).get_Number()) {
					guesscounter++;
					random1=(int)(Math.random()*lst_Players.size());
					random2=random1;
					while(random2==random1) {
						random2=(int)(Math.random()*lst_Players.size());
					}
					btn_Player1.setText(lst_Players.get(random1).get_Name());
					btn_Player2.setText(lst_Players.get(random2).get_Name());
				}
				else {
					JOptionPane.showMessageDialog(btn_Player1, "Gameover. Du hast "+guesscounter+" mal richtig geraten");
					setVisible(false);
					dispose();
				}
			}
		});
		

		btn_Player2.setEnabled(false);
		btn_Player2.setBounds(22, 106, 160, 23);
		contentPane.add(btn_Player2);
		
		JLabel lbl_Player1 = new JLabel("Spieler 1:");
		lbl_Player1.setBounds(22, 22, 114, 14);
		contentPane.add(lbl_Player1);
		
		JLabel lbl_Player2 = new JLabel("Spieler 2:");
		lbl_Player2.setBounds(22, 81, 114, 14);
		contentPane.add(lbl_Player2);
		
		JButton bnt_Start = new JButton("Start");
		bnt_Start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int counter=1;
				System.setProperty("gecko.driver","Drivers//geckodriver.exe");
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=new");
				options.addArguments("--disable-gpu");
		        options.addArguments("--window-size=1920,1080");
				WebDriver d = new FirefoxDriver(options);
				WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));
				d.manage().window().minimize();
				d.get("https://www.dartsrankings.com/");
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//td//child::a")));
				List <WebElement> lst_WebElements = d.findElements(By.xpath("//td//child::a"));
				for(WebElement element: lst_WebElements) {
					Player akt_Player = new Player();
					akt_Player.set_Name(element.getText());
					akt_Player.set_Number(counter);
					lst_Players.add(akt_Player);
					counter++;
				}
				random1=(int)(Math.random()*lst_Players.size());
				random2=random1;
				while(random2==random1) {
					random2=(int)(Math.random()*lst_Players.size());
				}
				btn_Player1.setText(lst_Players.get(random1).get_Name());
				btn_Player2.setText(lst_Players.get(random2).get_Name());
				btn_Player1.setEnabled(true);
				btn_Player2.setEnabled(true);
			}
		});
		bnt_Start.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bnt_Start.setBounds(22, 169, 80, 80);
		contentPane.add(bnt_Start);
	}
}
