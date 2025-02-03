package Threads;

public class Writer implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread liest "+dlg_ReadAndRide.number);
	}

}
