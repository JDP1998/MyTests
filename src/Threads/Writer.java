package Threads;

public class Writer implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		dlg_ReadAndWrite.number++;
		System.out.println("Thread schreibt: "+dlg_ReadAndWrite.number);
	}

}
