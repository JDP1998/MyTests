package Spielerei;

public class dlg_Würfel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int einser=0,zweier=0,dreier=0,vierer=0,fuenfer=0,sechser=0,counter=0,zufall,fallnr=0;
		
		for(counter=0;counter<=1000;counter++) {
			zufall=(int)(Math.random()*6+1);
			if(zufall==1) {
				fallnr=1;
			}
			if(zufall==2) {
				fallnr=2;
			}
			if(zufall==3) {
				fallnr=3;
			}
			if(zufall==4) {
				fallnr=4;
			}
			if(zufall==5) {
				fallnr=5;
			}
			if(zufall==6) {
				fallnr=6;
			}
			switch(fallnr) {
			case 1: einser++;break;
			case 2: zweier++;break;
			case 3: dreier++;break;
			case 4: vierer++;break;
			case 5: fuenfer++;break;
			case 6: sechser++;break;
			default: System.out.println("Dont make a fool out of me man!");break;
			}
		}
		System.out.println("Einser: "+einser);
		System.out.println("Zweier: "+zweier);
		System.out.println("Dreier: "+dreier);
		System.out.println("Vierer: "+vierer);
		System.out.println("Fünfer: "+fuenfer);
		System.out.println("Sechser: "+sechser);

	}

}
