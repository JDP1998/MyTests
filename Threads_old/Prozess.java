package Threads_old;

public class Prozess implements Runnable {
	int name;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i=0;
		for(i=0;i<=10;i++) {
			//System.out.println("Thread "+name+" z�hlt "+i);
		}
		System.out.println("Thread "+name+" ist fertig.");
	}
	

}
