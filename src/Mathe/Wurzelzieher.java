package Mathe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Wurzelzieher extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField text_Zahl;
	private JTextField text_Stellen;
	private JTextField text_Ergebnis;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Wurzelzieher frame = new Wurzelzieher();
					frame.setTitle("Johannes's Wurzelzieher");
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
	public Wurzelzieher() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		text_Zahl = new JTextField();
		text_Zahl.setBounds(107, 33, 163, 17);
		contentPane.add(text_Zahl);
		text_Zahl.setColumns(10);
		
		text_Stellen = new JTextField();
		text_Stellen.setBounds(107, 88, 163, 17);
		contentPane.add(text_Stellen);
		text_Stellen.setColumns(10);
		
		text_Ergebnis = new JTextField();
		text_Ergebnis.setBounds(107, 143, 163, 17);
		contentPane.add(text_Ergebnis);
		text_Ergebnis.setColumns(10);
		text_Ergebnis.setEnabled(false);
		
		JButton btn_Start = new JButton("Start");
		btn_Start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Heron.suchzahl=Integer.valueOf(text_Zahl.getText());
				Heron.anz_stelle=Integer.valueOf(text_Stellen.getText());
				Heron.suchergebnis=Heron.heron(Heron.suchzahl);
				text_Ergebnis.setText(String.valueOf(Heron.suchergebnis));
			}
		});
		btn_Start.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Start.setBounds(151, 184, 65, 56);
		contentPane.add(btn_Start);
		
		JLabel lbl_Zahl = new JLabel("Zahl:");
		lbl_Zahl.setBounds(8, 33, 65, 17);
		contentPane.add(lbl_Zahl);
		
		JLabel lbl_Stellen = new JLabel("Stellen:");
		lbl_Stellen.setBounds(8, 91, 65, 14);
		contentPane.add(lbl_Stellen);
		
		JLabel lbl_Ergebnis = new JLabel("Ergebnis:");
		lbl_Ergebnis.setBounds(8, 146, 65, 14);
		contentPane.add(lbl_Ergebnis);

	}
}
