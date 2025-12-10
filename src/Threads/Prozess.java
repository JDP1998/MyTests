package Threads;

public class Prozess implements Runnable {
	int name,position;

	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name=name;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position=position;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i=0,random;
		random=(int)(Math.random()*10000);
		for(i=0;i<=10;i++) {
			try {
				Thread.sleep(random);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Thread "+getName()+" ist fertig!");
		setPosition(dlg_Threads.position);
		dlg_Threads.position++;
		if(getPosition()==1) {
			dlg_Threads.winner=getName();
		}
	}
	

}
