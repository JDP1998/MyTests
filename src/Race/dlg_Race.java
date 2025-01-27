package Race;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class dlg_Race {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		boolean is_race_finished = false, add_new_racer = true;
		int seasoncount,racecount,count=1,minutes,seconds;
		long start,end,time;
		String name;
		
		start=System.currentTimeMillis();
		
		Racemanager.get_Counter();
		Racemanager.fill_list_venues();
		Racemanager.fill_list_racers();
		Racemanager.fill_list_points();
		Racemanager.fill_list_teams();
		
		racecount=Racemanager.getVenueCount()+1;
		
		seasoncount=Racemanager.getSeasonCount();
		
		name=Racemanager.getVenues().get(Racemanager.getVenueCount()).getName();
		
		if (Racemanager.getVenueCount() < 19) {
			System.out.println("Hello everyone. Welcome to season "+seasoncount+" of the WCR. We are at " + name + " today. This is race " + racecount + " of 20!");
			System.out.println("\r\n");
		} else {
			System.out.println("Welcome to the finale of season "+seasoncount+". Today we are in " + name + "!");
			System.out.println("\r\n");
		}
		
		Thread.sleep(2000);
		
		System.out.println("Here are the current standings!");
		System.out.println("\r\n");
		
		Racemanager.get_Standings();
		
		System.out.println("\r\n");
		System.out.println("The race begins!");
		System.out.println("\r\n");
		
		for(Racer r: Racemanager.getRacers()) {
			r.start();
		}
		
		while (is_race_finished == false) {
			is_race_finished = true;
			for (Racer r2 : Racemanager.getRacers()) {
				if (r2.isAlive() == true) {
					is_race_finished = false;
				}
			}
			if (is_race_finished == false) {
				Thread.sleep(1000);
			} else {
				System.out.println("\r\n");
				System.out.println("The race is completed");
				System.out.println("\r\n");
				for(count=1;count<=Racemanager.getRacers().size();count++) {
					for(Racer r3 : Racemanager.getRacers()) {
						if(r3.getRacerPosition()==count) {
								System.out.println(r3.getRacerName() + " has finished the race in position " + r3.getRacerPosition() + " and is racing for "+r3.getTeam()+"!");
								r3.setRacerPoints(r3.getRacerPoints()+Racemanager.getPoints().get(count-1).getPoint());
								break;
						}
					}
				}
				is_race_finished = true;
			}
		}
		end = System.currentTimeMillis();
		time=end-start;
		time=time/1000;
		minutes=(int) (time/60);
		seconds = (int) (time%60);
		System.out.println("\r\n");
		System.out.println("The race last "+minutes+" minutes and "+seconds+" seconds. Thank you for joyning");
		
		Racemanager.update_table();
		Racemanager.update_counter();
		
		System.out.println("\r\n");
		System.out.println("Here are the updated standings!");
		System.out.println("\r\n");
		
		Racemanager.get_Standings();
		
		if(racecount==20) {
			Racemanager.print_winner();
			Racemanager.reset_table();
			Racemanager.reset_counter();
		}
	}

}
