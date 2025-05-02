package DealOrNoDeal;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.stream.events.StartDocument;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class DealOrNoDeal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static ArrayList <Integer> lst_Ammounts = new ArrayList<>(); 
	public static ArrayList <Ammount> lst_Fields = new ArrayList();
	public static ArrayList <Button> lst_Koffer = new ArrayList<>();
	public static int win,loss,quote;
	public static int [] deals = new int [5];
	private JTextField text_wins;
	private JTextField txt_loss;
	private JTextField textField;
	private JTextField txt_1;
	private JTextField txt_2;
	private JTextField txt_3;
	private JTextField txt_4;
	private JTextField txt_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DealOrNoDeal frame = new DealOrNoDeal();
					frame.setTitle("Deal or No Deal by Johannes Portzehl");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public DealOrNoDeal() throws IOException {
		int counter=0;
		File f = new File("src//DealOrNoDeal//History.txt");
		if(f.exists()==false) {
			f.createNewFile();
		}
		BufferedReader bReader = new BufferedReader(new FileReader(f));
		win = Integer.valueOf(bReader.readLine());
		loss = Integer.valueOf(bReader.readLine());
		quote = Integer.valueOf(bReader.readLine());
		bReader.close();
		File f2 = new File ("src//DealOrNoDeal//Deals.txt");
		if(f2.exists()==false) {
			f2.createNewFile();
		}
		BufferedReader bReader2 = new BufferedReader(new FileReader(f2));
		for(counter=0;counter<=deals.length-1;counter++) {
			deals[counter]=Integer.valueOf(bReader2.readLine());
		}
		bReader2.close();
		setFont(new Font("Dialog", Font.PLAIN, 20));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 1350, 720);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		JTabbedPane pane = new JTabbedPane();
		int i=0,x=300,y=0;
		pane.setBounds(0, 0, 1310, 700);
		
		pane.add("Spiel",panel1);
		panel1.setLayout(null);
		
		JButton btn_start = new JButton("Start");
		btn_start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manager_Kandidat.fill_Cases();
				JOptionPane.showMessageDialog(null, "Bitte wähle deinen Koffer!","Anweisung",JOptionPane.INFORMATION_MESSAGE);
				for(Button b : lst_Koffer) {
					b.setEnabled(true);
				}
				btn_start.setEnabled(false);
			}
		});
		btn_start.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn_start.setBounds(600, 532, 100, 100);
		panel1.add(btn_start);
		
		pane.add("Bank",panel2);
		panel2.setLayout(null);
		
		pane.add("Historie",panel3);
		panel3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kandidat Historie");
		lblNewLabel.setBounds(38, 81, 325, 39);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel3.add(lblNewLabel);
		
		text_wins = new JTextField();
		text_wins.setFont(new Font("Tahoma", Font.PLAIN, 20));
		text_wins.setBounds(210, 147, 86, 39);
		text_wins.setEnabled(false);
		text_wins.setText(String.valueOf(win));
		panel3.add(text_wins);
		text_wins.setColumns(10);
		
		JLabel lbl_wins = new JLabel("Siege: ");
		lbl_wins.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_wins.setBounds(65, 143, 74, 39);
		panel3.add(lbl_wins);
		
		txt_loss = new JTextField();
		txt_loss.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txt_loss.setBounds(210, 222, 86, 39);
		txt_loss.setEnabled(false);
		txt_loss.setText(String.valueOf(loss));
		panel3.add(txt_loss);
		txt_loss.setColumns(10);
		
		JLabel lbl_loss = new JLabel("Verloren:");
		lbl_loss.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_loss.setBounds(38, 222, 124, 33);
		panel3.add(lbl_loss);
		
		JTextField text_quote = new JTextField();
		text_quote.setFont(new Font("Tahoma", Font.PLAIN, 20));
		text_quote.setBounds(210, 300, 86, 39);
		text_quote.setEnabled(false);
		text_quote.setText(String.valueOf(quote));
		panel3.add(text_quote);
		text_quote.setColumns(10);
		
		JLabel lbl_quote = new JLabel("Quote:");
		lbl_quote.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_quote.setBounds(65, 300, 124, 33);
		panel3.add(lbl_quote);
		
		pane.add("Rekorde",panel4);
		
		pane.add("Anleitung",panel5);
		
		panel4.setLayout(null);
		
		JLabel ldl_header = new JLabel("Rekorde");
		ldl_header.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ldl_header.setBounds(65, 52, 143, 44);
		panel4.add(ldl_header);
		
		txt_1 = new JTextField();
		txt_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txt_1.setBounds(65, 110, 200, 40);
		txt_1.setText(String.valueOf(deals[0]));
		txt_1.setEnabled(false);
		panel4.add(txt_1);
		txt_1.setColumns(10);
		
		txt_2 = new JTextField();
		txt_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txt_2.setBounds(65, 170, 200, 40);
		txt_2.setText(String.valueOf(deals[1]));
		txt_2.setEnabled(false);
		panel4.add(txt_2);
		txt_2.setColumns(10);
		
		txt_3 = new JTextField();
		txt_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txt_3.setBounds(65, 230, 200, 40);
		txt_3.setText(String.valueOf(deals[2]));
		txt_3.setEnabled(false);
		panel4.add(txt_3);
		txt_3.setColumns(10);
		
		txt_4 = new JTextField();
		txt_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txt_4.setBounds(65, 290, 200, 40);
		txt_4.setText(String.valueOf(deals[3]));
		txt_4.setEnabled(false);
		panel4.add(txt_4);
		txt_4.setColumns(10);
		
		txt_5 = new JTextField();
		txt_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txt_5.setBounds(65, 350, 200, 40);
		txt_5.setText(String.valueOf(deals[4]));
		txt_5.setEnabled(false);
		panel4.add(txt_5);
		txt_5.setColumns(10);
		
		
		panel5.setLayout(null);
		
		JLabel lbl_rules = new JLabel("");
		lbl_rules.setBounds(0, 36, 1359, 611);
		panel5.add(lbl_rules);
		ImageIcon iconLogo = new ImageIcon("src//DealOrNoDeal//Rules.png");
		lbl_rules.setIcon(iconLogo);
		contentPane.add(pane);
		
		Manager_Kandidat.createAmmounts();
		
		for(i=0;i<=24;i++) {
			Button b = new Button();
			b.setFont(new Font("Tahoma", Font.PLAIN, 40));
			b.setBounds(x, y, 100, 90);
			b.setEnabled(false);
			b.nummer=i+1;
			b.setText(String.valueOf(b.nummer));
			b.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						Manager_Kandidat.openCase(b.nummer);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			});
			x=x+150;
			if(x==1050) {
				y=y+100;
				x=300;
			}
			panel1.add(b);
			lst_Koffer.add(b);
		}
		i=0;
		x=0;
		y=0;
		for(i=0;i<=24;i++) {
			Ammount a = new Ammount();
			a.setFont(new Font("Tahoma", Font.PLAIN, 20));
			a.setBounds(x, y, 100, 45);
			a.setEnabled(false);
			a.number=i+1;
			a.ammount=String.valueOf(lst_Ammounts.get(i));
			a.setText(String.valueOf(lst_Ammounts.get(i)));
			panel1.add(a);
			lst_Fields.add(a);
            y=y+50;
			if(y==650) {
				x=1200;
				y=0;
			}
		}
		
	}
}
