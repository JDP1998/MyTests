package DealOrNoDeal;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	public ArrayList <Integer> lst_Ammounts = new ArrayList<>(); 
	public ArrayList <Button> lst_Koffer = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DealOrNoDeal frame = new DealOrNoDeal();
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
	public DealOrNoDeal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1350, 700);
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
		int i=0,x=0,y=0;
		pane.setBounds(0, 0, 1300, 620);
		
		pane.add("Spiel",panel1);
		panel1.setLayout(null);
		
		JButton btn_start = new JButton("Start");
		btn_start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Bitte w�hle deinen Koffer!","Anweisung",JOptionPane.INFORMATION_MESSAGE);
				create_Ammounts();
				fill_Cases();
				for(Button b : lst_Koffer) {
					b.setEnabled(true);
					//System.out.println("Koffer "+b.nummer+" hat: "+b.wert);
				}
				btn_start.setEnabled(false);
			}
		});
		btn_start.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn_start.setBounds(600, 500, 100, 100);
		panel1.add(btn_start);
		
		pane.add("Historie",panel2);
		panel2.setLayout(null);
		
		pane.add("Rekorde",panel3);
		panel3.setLayout(null);
		
		pane.add("Anleitung",panel4);
		panel4.setLayout(null);
		
		JLabel lbl_rules = new JLabel("New label");
		lbl_rules.setBounds(0, -74, 1293, 634);
		panel4.add(lbl_rules);
		ImageIcon iconLogo = new ImageIcon("C:\\Users\\jportzeh\\Desktop\\Java Dateien\\Rules.png");
		lbl_rules.setIcon(iconLogo);
		contentPane.add(pane);
		
		for(i=0;i<=24;i++) {
			Button b = new Button();
			b.setFont(new Font("Tahoma", Font.PLAIN, 40));
			b.setBounds(x, y, 100, 90);
			b.setEnabled(false);
			b.nummer=i+1;
			b.setText(String.valueOf(b.nummer));
			x=x+300;
			if(x==1500) {
				y=y+100;
				x=0;
			}
			panel1.add(b);
			lst_Koffer.add(b);
		}
		
	}

	protected void fill_Cases() {
		// TODO Auto-generated method stub
		int random=0;
		for(Button b: lst_Koffer) {
			random=(int)(Math.random()*lst_Ammounts.size());
			b.wert=lst_Ammounts.get(random);
			lst_Ammounts.remove(random);
		}
	}

	protected void create_Ammounts() {
		// TODO Auto-generated method stub
		lst_Ammounts.add(1);
		lst_Ammounts.add(5);
		lst_Ammounts.add(10);
		lst_Ammounts.add(25);
		lst_Ammounts.add(50);
		lst_Ammounts.add(75);
		lst_Ammounts.add(100);
		lst_Ammounts.add(200);
		lst_Ammounts.add(300);
		lst_Ammounts.add(400);
		lst_Ammounts.add(500);
		lst_Ammounts.add(750);
		lst_Ammounts.add(1000);
		lst_Ammounts.add(5000);
		lst_Ammounts.add(10000);
		lst_Ammounts.add(25000);
		lst_Ammounts.add(50000);
		lst_Ammounts.add(75000);
		lst_Ammounts.add(100000);
		lst_Ammounts.add(200000);
		lst_Ammounts.add(300000);
		lst_Ammounts.add(400000);
		lst_Ammounts.add(500000);
		lst_Ammounts.add(750000);
		lst_Ammounts.add(1000000);
	}
}