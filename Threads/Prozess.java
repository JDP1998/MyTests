package Threads;

public class Prozess implements Runnable {
	private int position,wins;
	private String name;

	
	public void setWins(int wins) {
		this.wins=wins;
	}
	public int getWins() {
		return wins;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
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
		System.out.println(getName()+" ist fertig!");
		setPosition(dlg_Threads.position);
		dlg_Threads.position++;
		if(getPosition()==1) {
			dlg_Threads.winner=getName();
		}
	}
	

}
