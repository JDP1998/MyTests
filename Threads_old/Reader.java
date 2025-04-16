package Threads_old;

public class Reader implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread liest "+dlg_ReadAndWrite.number);
	}

}
