package Threads;



public class dlg_ReadAndWrite {
	public static int number=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=1,anz=10;
		while(i<=anz) {
			Reader r = new Reader();
			Writer w = new Writer();
			Thread read_thread = new Thread(r);
			Thread write_thread = new Thread(w);
			read_thread.start();
			write_thread.start();
			i++;
		}
		System.out.println("Number "+number);

	}

}
