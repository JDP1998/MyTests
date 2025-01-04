package DealOrNoDeal;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	 */
	public DealOrNoDeal() {
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
		
		pane.add("Rekorde",panel4);
		panel4.setLayout(null);
		
		pane.add("Anleitung",panel5);
		panel4.setLayout(null);
		panel5.setLayout(null);
		
		JLabel lbl_rules = new JLabel("New label");
		lbl_rules.setBounds(0, 95, 1359, 457);
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
