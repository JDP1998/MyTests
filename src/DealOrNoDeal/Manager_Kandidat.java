package DealOrNoDeal;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Manager_Kandidat extends DealOrNoDeal {

	public static int tausch,beendet=0,differenz,deal,runde=0,geöffnet=0,anzahl=5,case_ammount=0,tausch_ammount=0;
	public static boolean is_final=false,is_tausch=false,is_beendet=false;
	public static Object[] choices = {"Deal!", "No Deal!"};
	public static Object  [] choices2 = {"Tausch!","Kein Tausch!"};
	public static Object defaultChoice = choices[0];
	public static void createAmmounts() {
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
	
	public static void fill_Cases() {
		// TODO Auto-generated method stub
		int random=0;
		for(Button b: lst_Koffer) {
			random=(int)(Math.random()*lst_Ammounts.size());
			b.wert=lst_Ammounts.get(random);
			System.out.println(b.wert);
			lst_Ammounts.remove(random);
		}
	}

	public static void openCase(int nummer) {
		// TODO Auto-generated method stub
		if(runde==0) {
			case_ammount=lst_Koffer.get(nummer-1).wert;
			System.out.println("Dein Koffer: "+case_ammount);
			lst_Koffer.get(nummer-1).setEnabled(false);
			JOptionPane.showMessageDialog(null, "In dieser Runde musst du 5 Koffer öffnen!","Info",JOptionPane.INFORMATION_MESSAGE);
			runde++;
		}
		else {
			lst_Koffer.get(nummer-1).setEnabled(false);
			for(Ammount a:lst_Fields) {
				if(Integer.valueOf(a.ammount)==lst_Koffer.get(nummer-1).wert) {
					a.setText("");
					lst_Fields.remove(a);
					break;
				}
			}
			lst_Koffer.get(nummer-1);
			geöffnet++;
			int differenz=Integer.valueOf(lst_Fields.get(lst_Fields.size()-anzahl).getText())-Integer.valueOf(lst_Fields.get(lst_Fields.size()-anzahl-1).getText());
			if(geöffnet==anzahl) {
				if(anzahl>1) {
					if (runde == 1) {
						deal=(int)(Math.random()*differenz)+Integer.valueOf(lst_Fields.get(lst_Fields.size()-anzahl-1).getText());
						beendet=JOptionPane.showOptionDialog(null,
					             "Der Bänker bietet dir "+deal+"€ an. In der nächsten Runde musst du " + anzahl + " Koffer öffnen!",
					             "Information",
					             JOptionPane.YES_NO_OPTION,
					             JOptionPane.QUESTION_MESSAGE,
					             null,
					             choices,
					             defaultChoice);
						if(beendet==JOptionPane.YES_OPTION) {
							is_beendet=true;
						}
						runde++;
						geöffnet = 0;
					} else {
						anzahl--;
						deal=(int)(Math.random()*differenz)+Integer.valueOf(lst_Fields.get(lst_Fields.size()-anzahl-1).getText());
						beendet=JOptionPane.showOptionDialog(null, "Der Bänker bietet dir "+deal+"€ an. In der nächsten Runde musst du " + anzahl + " Koffer öffnen!",
								"Information", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,choices,defaultChoice);
						if (beendet == JOptionPane.YES_OPTION) {
							is_beendet=true;
						}
						geöffnet = 0;
						runde++;
					}

				}
				else {
					if(runde<=8) {
						
						deal=(int)(Math.random()*differenz)+Integer.valueOf(lst_Fields.get(lst_Fields.size()-anzahl-1).getText());
						beendet=JOptionPane.showOptionDialog(null, "Der Bänker bietet dir "+deal+"€ an. In der nächsten Runde musst du 1 Koffer öffnen!", "Information",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,choices,defaultChoice);
						if (beendet == JOptionPane.YES_OPTION) {
							is_beendet=true;
						}
						runde++;
						geöffnet = 0;
					}
					else {
						deal=(int)(Math.random()*differenz)+Integer.valueOf(lst_Fields.get(lst_Fields.size()-anzahl-1).getText());
						beendet=JOptionPane.showOptionDialog(null, "Der Bänker bietet dir "+deal+"€ an. In der nächsten Runde musst du 1 Koffer öffnen!", "Information",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,choices,defaultChoice);
						if (beendet == JOptionPane.YES_OPTION) {
							is_beendet=true;
						}
						else {
							tausch = JOptionPane.showOptionDialog(null, "Möchtest du deinen Koffer tauschen?",
									"Information", JOptionPane.INFORMATION_MESSAGE, JOptionPane.QUESTION_MESSAGE, null,
									choices2, defaultChoice);
							if (tausch == JOptionPane.YES_OPTION) {
								deal = lst_Koffer.get(nummer - 2).wert;
								is_tausch = true;
							} else {
								deal = case_ammount;
								case_ammount = lst_Koffer.get(nummer - 2).wert;

							}
							is_beendet = true;
							is_final = true;
						}
					}
				}
			}
			if(is_beendet==true) {
				System.out.println("Deal: "+deal);
				System.out.println("Case: "+case_ammount);
				if(is_final==false) {
					if(deal>case_ammount) {
						JOptionPane.showMessageDialog(null,
								"Das Spiel ist vorbei. Das war ein guter Deal! In deinem Koffer waren " + case_ammount + "€!", "Information",
								JOptionPane.INFORMATION_MESSAGE);
						System.exit(0);
					}
					else {
						JOptionPane.showMessageDialog(null,
								"Das Spiel ist vorbei. Das war ein schlechter Deal! In deinem Koffer waren " + case_ammount + "€!", "Information",
								JOptionPane.INFORMATION_MESSAGE);
						System.exit(0);
					}
				}
				else {
					 if(is_tausch==true) {
						 if(deal>case_ammount) {
							 JOptionPane.showMessageDialog(null,
										"Das Spiel ist vorbei. Das war ein guter Tausch! In deinem Koffer waren " + case_ammount + "€!", "Information",
										JOptionPane.INFORMATION_MESSAGE);
								System.exit(0);
						 }
						 else {
							 JOptionPane.showMessageDialog(null,
										"Das Spiel ist vorbei. Das war ein schlechter Tausch! In deinem Koffer waren " + case_ammount + "€!", "Information",
										JOptionPane.INFORMATION_MESSAGE);
								System.exit(0);
						 }
					 }
					 else {
						 if(deal>case_ammount) {
							 JOptionPane.showMessageDialog(null,
										"Das Spiel ist vorbei. Gut, dass du nicht getauscht hast! In deinem Koffer sind " + deal + "€!", "Information",
										JOptionPane.INFORMATION_MESSAGE);
								System.exit(0);
						 }
						 else {
							 JOptionPane.showMessageDialog(null,
										"Das Spiel ist vorbei. Du hättest tuaschen sollen! In deinem Koffer sind " + deal + "€!", "Information",
										JOptionPane.INFORMATION_MESSAGE);
								System.exit(0);
						 }
					 }
				}
			}
		}
	}

	

	

}
