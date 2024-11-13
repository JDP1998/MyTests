package Race;

public class Racer extends Thread {
	public String name;
	public  int position,points;
    public  boolean is_printed;
    
    public boolean getPrinted() {
    	return is_printed;
    	
    }
    public void setPrinted(boolean is_printed) {
    	this.is_printed=is_printed;
    }
    
    public String getRacerName() {
    	return name;
    	
    }
    public void setRacerName(String name) {
    	this.name=name;
    }
    
    public int getRacerPosition() {
    	return position;
    	
    }
    public void setRacerPosition(int position) {
    	this.position=position;
    }
    
    public int getRacerPoints() {
    	return points;
    	
    }
    public void setRacerPoints(int points) {
    	this.points=points;
    }
    
    public void run() {
		long start, end, time;
		int fallnr = 0;
		start = System.currentTimeMillis();
		int i = 0, random, seconds, minutes;
		random = (int) (Math.random() * 50000000) + 1;
		while (i != random) {
			i = (int) (Math.random() * 50000000) + 1;
		}
		end = System.currentTimeMillis();
		time = end - start;
		time = time / 1000;
		minutes = (int) (time / 60);
		seconds = (int) (time % 60);
		Racemanager racemanager = new Racemanager();
		racemanager.setPosition(racemanager.getPosition()+1);
		position = racemanager.getPosition();
		if (position < 10 && seconds > 9) {
			fallnr = 1;
		}
		if (seconds < 10 && position > 9) {
			fallnr = 2;
		}
		if (position < 10 && seconds < 10) {
			fallnr = 3;
		}
		switch (fallnr) {
		case 0:
			System.out.println(
					"Rider " + position + " has finished the race. Her time is " + minutes + ":" + seconds + "!");
			break;
		case 1:
			System.out.println(
					"Rider 0" + position + " has finished the race. Her time is " + minutes + ":" + seconds + "!");
			break;
		case 2:
			System.out.println(
					"Rider " + position + " has finished the race. Her time is " + minutes + ":0" + seconds + "!");
			break;
		case 3:
			System.out.println(
					"Rider 0" + position + " has finished the race. Her time is " + minutes + ":0" + seconds + "!");
			break;
		default:
			System.out.println("Dont make a fool out of me man!");
			break;
		}
	}

}
