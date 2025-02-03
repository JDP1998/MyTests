package Threads;

public class Reader implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		dlg_ReadAndRide.number++;
		System.out.println("Thread schreibt "+dlg_ReadAndRide.number);
	}

}
