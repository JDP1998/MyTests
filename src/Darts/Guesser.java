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
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Guesser extends JFrame {
	public static int length=224, guesscount=0;
	public static String names [] = new String [length];
	public static ArrayList <String> lst_Top = new ArrayList<>();
	public static ArrayList <Field> lst_Fields = new ArrayList<>();
	private JPanel contentPane;
	private JTextField txt_Counter;

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
		setBounds(100, 100, 1100, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		int counter=0,x=300,y=100;
		while(counter<=31) {
			Field aktField = new Field();
			aktField.setEditable(false);
			aktField.setFont(new Font("Tahoma", Font.PLAIN, 9));
			aktField.setBounds(x, y, 160, 60);
			aktField.set_number(counter);
			contentPane.add(aktField);
			lst_Fields.add(aktField);
			if(y<800) {
				y=y+100;
			}
			else {
				x=x+200;
				y=100;
			}
			counter++;
			
			
			
		}
		
		JButton btn_Start = new JButton("Start");
		btn_Start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int counter = 0;
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
				btn_Start.setEnabled(false);
				
			}
		});
		btn_Start.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_Start.setBounds(200, 293, 80, 80);
		contentPane.add(btn_Start);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(0, 100, 172, 496);
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
							guesscount++;
							txt_Counter.setText(String.valueOf(guesscount)+"/32");
							}
					}
				}
				else {
					JOptionPane.showMessageDialog(btn_OK, "Das Spiel ist vorbei! Du hast "+guesscount+" von 32 erkannt!");
					setVisible(false);
					dispose();
					
				}
			}
		});
		btn_OK.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_OK.setBounds(200, 134, 80, 80);
		contentPane.add(btn_OK);
		
		JLabel lbl_Counter = new JLabel("Counter:");
		lbl_Counter.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_Counter.setBounds(44, 39, 88, 42);
		contentPane.add(lbl_Counter);
		
		txt_Counter = new JTextField();
		txt_Counter.setEditable(false);
		txt_Counter.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txt_Counter.setText("0/32");
		txt_Counter.setBounds(131, 39, 79, 44);
		contentPane.add(txt_Counter);
		txt_Counter.setColumns(10);
		
	}
}
