package Threads;

public class Prozess implements Runnable {
	int name;

	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name=name;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i=0,random;
		random=(int)(Math.random()*10000);
		for(i=0;i<=10;i++) {
			//System.out.println("Thread "+name+" zählt "+i);
			try {
				Thread.sleep(random);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Thread "+getName()+" ist fertig.");
	}
	

}
