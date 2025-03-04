package Usecases;

public class dlg_Hourglass {
	
	public static int length;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		length=(int)(Math.random()*30)+1;
		//length=9;
		if(length%2==0) {
			length++;
		}
		draw_header();
		draw_bottom();

	}

	private static void draw_bottom() {
		// TODO Auto-generated method stub
		String print;
		int counter=0,space, gap=0;
		space=length/2+1;
		while(space>=1) {
			counter=0;
			print="";
			while(counter<=space-1) {
				print=print+" ";
				counter++;
			}
			print=print+"*";
			if(gap>0) {
				counter=0;
				while(counter<gap-1) {
					print=print+" ";
					counter++;
				}
				print=print+"*";
			}
			System.out.println(print);
			gap=gap+2;
			space--;
		}
		print="";
		counter=-2;
		while(counter<length) {
			print=print+"*";
			counter++;
		}
		System.out.println(print);
		
	}

	private static void draw_header() {
		// TODO Auto-generated method stub
		String print = "";
		int counter=0,space=1, gap=length-4;
		counter=-2;
		while(counter<length) {
			print=print+"*";
			counter++;
		}
		System.out.println(print);
		while(space<=length/2) {
			print="";
			counter=0;
			while(counter<=space-1) {
				print=print+" ";
				counter++;
			}
			print=print+"*";
			if(gap>=-1) {
				counter=-1;
				while(counter<=gap) {
					print=print+" ";
					counter++;
				}
				print=print+"*";
				gap=gap-2;
			}
			System.out.println(print);
			space++;
		}
	
	}

}
