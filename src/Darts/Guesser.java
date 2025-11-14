package Darts;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
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
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Guesser extends JFrame {
	public static int length=224;
	public static String names [] = new String [length];
	public static ArrayList <String> lst_Top = new ArrayList<>();
	public static ArrayList <Field> lst_Fields = new ArrayList<>();
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
		setBounds(100, 100, 600, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		int counter=0,x=200,y=100;
		while(counter<=31) {
			Field aktField = new Field();
			aktField.setEditable(false);
			aktField.setFont(new Font("Tahoma", Font.PLAIN, 9));
			aktField.setBounds(x, y, 80, 26);
			aktField.set_number(counter);
			contentPane.add(aktField);
			lst_Fields.add(aktField);
			if(y<450) {
				y=y+50;
			}
			else {
				x=x+100;
				y=100;
			}
			counter++;
			
			
			
		}
		
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
					if(counter<=31) {
						lst_Top.add(element.getText());
					}
				}
				Arrays.sort(names);
				d.quit();
				
			}
		});
		btn_Start.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_Start.setBounds(120, 229, 60, 60);
		contentPane.add(btn_Start);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(0, 100, 100, 301);
		contentPane.add(scroll);
		
		JList list_Players = new JList(names);
		scroll.setViewportView(list_Players);
		list_Players.setFixedCellHeight(15);
		
		JButton btn_OK = new JButton("OK");
		btn_OK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selection;
				int pointer=-1;
				boolean is_part=false;
				selection = names[list_Players.getSelectedIndex()];
				for (String s: lst_Top) {
					if(s.equals(selection)==true) {
						is_part=true;
						pointer=lst_Top.indexOf(s);
						break;
					}
				}
				if(is_part==true) {
					for(Field f: lst_Fields) {
						if(f.get_number()==pointer) {
							f.setText(selection);
						}
					}
				}
				else {
					
				}
			}
		});
		btn_OK.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_OK.setBounds(120, 134, 60, 60);
		contentPane.add(btn_OK);
		
	}
}
