package DealOrNoDeal;

public class Manager_Kandidat extends DealOrNoDeal {

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
			lst_Ammounts.remove(random);
		}
	}

	

}
