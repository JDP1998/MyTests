package Usecases;

public class dlg_Plus {
	
	public static int size;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		size=(int)(Math.random()*100)+1;
		draw_header();
		draw_body();
		draw_header();

	}

	private static void draw_body() {
		// TODO Auto-generated method stub
		int counter=0, rows=0;
		String print="";
		while(rows<=size-1) {
			print="";
			counter=0;
			while(counter<size*3){
				print=print+"*";
				counter++;
			}
			System.out.println(print);
			rows++;
		}
	}

	private static void draw_header() {
		// TODO Auto-generated method stub
		int counter=0, rows=0;
		String print="";
		while(rows<=size-1) {
			print="";
			counter=0;
			while(counter<=size-1) {
				print=print+" ";
				counter++;
			}
			counter=0;
			while(counter<=size-1) {
				print=print+"*";
				counter++;
			}
			System.out.println(print);
			rows++;
		}
	}

}
