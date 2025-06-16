package Race;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.interfaces.RSAKey;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import javax.sound.sampled.Line;



public class Racemanager {
	
	public static int seasoncount=0,position=0,venuecount=0;
	public static boolean is_execution_2=false;
    public static ArrayList <Racer> lst_Racers = new ArrayList<>();
    public static ArrayList <Venue> lst_Venues = new ArrayList<>();
    public static ArrayList <Point> lst_Points = new ArrayList<>();
    public static ArrayList <Team>  lst_Teams = new ArrayList<>();
    
    public static ArrayList <Team> getTeams() {
    	return lst_Teams;
    	
    }
    public void setTeams(ArrayList <Team> lst_Teams) {
    }
    
    public static ArrayList <Point> getPoints() {
    	return lst_Points;
    	
    }
    public void setPoints(ArrayList <Point> lst_Points) {
    	this.lst_Points=lst_Points;
    }
    
    public static ArrayList <Venue> getVenues() {
    	return lst_Venues;
    	
    }
    public void setVenues(ArrayList <Venue> lst_Venues) {
    	this.lst_Venues=lst_Venues;
    }
    
    public static ArrayList <Racer> getRacers() {
    	return lst_Racers;
    	
    }
    public void setRacers(ArrayList <Racer> lst_Racers) {
    	this.lst_Racers=lst_Racers;
    }
    
    public static int getPosition() {
    	return position;
    	
    }
    public void setPosition(int position) {
    	this.position=position;
    }
    
    public static int getVenueCount() {
    	return venuecount;
    	
    }
    public void setVenueCount(int venuecount) {
    	this.venuecount=venuecount;
    }
    
    public static int getSeasonCount() {
    	return seasoncount;
    	
    }
    public void setSeasonCount(int seasoncount) {
    	this.seasoncount=seasoncount;
    }
	public static void update_table() throws IOException {
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\jportzeh\\Documents\\Race\\Racers.txt");
		if (file.exists() == false) {
			file.createNewFile();
		}
		BufferedWriter bWriter = new BufferedWriter(new FileWriter(file, false));
		for (Racer r : lst_Racers) {
			bWriter.write(String.valueOf(r.getRacerName() + ":" + r.getRacerPoints()));
			bWriter.write("\r\n");
		}
		bWriter.close();
		
		File file2 = new File("C:\\Users\\jportzeh\\Documents\\Race\\Teams.txt");
		if (file2.exists() == false) {
			file2.createNewFile();
		}
		BufferedWriter bWriter2 = new BufferedWriter(new FileWriter(file2, false));
		for (Team t : lst_Teams) {
			bWriter2.write(String.valueOf(t.getName() + ":" + t.getPoints()));
			bWriter2.write("\r\n");
		}
		bWriter2.close();

	}

	public static void get_Standings() throws IOException {
		// TODO Auto-generated method stub
		int [] points = new int[33];
		int k,counter=0,i=0;
		boolean is_sorted=true;
		String line;
		for (Racer r : lst_Racers) {
			points[i]=r.getRacerPoints();
			i++;
		}
		Arrays.sort(points);
		i=points.length-1;
		if (is_execution_2 == true) {
			File file = new File("C:\\Users\\jportzeh\\Documents\\Race\\Standings.txt");
			if(file.exists()==false) {
				file.createNewFile();
			}
			BufferedWriter bWriter = new BufferedWriter(new FileWriter(file));
			for (i = points.length - 1; i >= 0; i--) {
				for (Racer r2 : lst_Racers) {
					if (r2.getRacerPoints() == points[i]) {
						r2.setPrinted(true);
						System.out.println(r2.getRacerName() + ":" + r2.getRacerPoints());
						line=r2.getRacerName() + ":" + r2.getRacerPoints();
						bWriter.write(String.valueOf(line));
						bWriter.write("\r\n");
						r2.setRacerPoints(-1);
						break;
					}
				}
			}
			bWriter.close();
			System.out.println("\r\n");
			System.out.println("Here are the updated Team standings!");
			System.out.println("\r\n");
			int [] teampoints = new int [8];
			for(Team t: lst_Teams) {
				teampoints[counter]=t.getPoints();
				counter++;
			}
			Arrays.sort(teampoints);
			counter=teampoints.length-1;
			for(counter=teampoints.length-1;counter>=0;counter--) {
				for(Team t: lst_Teams) {
					if(teampoints[counter]==t.getPoints()) {
						System.out.println(t.getName()+":"+t.getPoints());
					}
				}
			}

		} else {
			for (i = points.length - 1; i >= 0; i--) {
				for (Racer r2 : lst_Racers) {
					if (r2.getRacerPoints() == points[i] && r2.getPrinted() == false) {
						r2.setPrinted(true);
						System.out.println(r2.getRacerName() + ":" + r2.getRacerPoints());
						break;
					}
				}
			}
			is_execution_2 = true;
		}
	}

	public static void fill_list_points() throws IOException {
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\jportzeh\\Documents\\Race\\Points.txt");
		if (file.exists() == false) {
			file.createNewFile();
		}
		BufferedReader bReader = new BufferedReader(new FileReader(file));
		String line;
		while ((line = bReader.readLine()) != null) {
			Point p = new Point();
			p.setPoint(Integer.valueOf(line));
			lst_Points.add(p);
		}
		bReader.close();
	}

	public static void get_Counter() throws IOException {
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\jportzeh\\Documents\\Race\\Counter.txt");
		if (file.exists() == false) {
			file.createNewFile();
		}
		BufferedReader bReader = new BufferedReader(new FileReader(file));
		venuecount = Integer.valueOf(bReader.readLine());
		bReader.close();
		
		File file2 = new File("C:\\Users\\jportzeh\\Documents\\Race\\Season.txt");
		if (file2.exists() == false) {
			file2.createNewFile();
		}
		BufferedReader bReader2 = new BufferedReader(new FileReader(file2));
		seasoncount = Integer.valueOf(bReader2.readLine());
		bReader2.close();

	}

	public static void update_counter() throws IOException {
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\jportzeh\\Documents\\Race\\Counter.txt");
		if (file.exists() == false) {
			file.createNewFile();
		}
		venuecount++;
		BufferedWriter bWriter = new BufferedWriter(new FileWriter(file, false));
		bWriter.write(String.valueOf(venuecount));
		bWriter.close();

	}

	public static void fill_list_venues() throws IOException {
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\jportzeh\\Documents\\Race\\Venues.txt");
		if (file.exists() == false) {
			file.createNewFile();
		}
		BufferedReader bReader = new BufferedReader(new FileReader(file));
		String line;
		while ((line = bReader.readLine()) != null) {
			Venue v = new Venue();
			v.setName(line);
			lst_Venues.add(v);
		}
		bReader.close();
	}

	public static void print_list() {
		// TODO Auto-generated method stub
		System.out.println("The List of Racers!");
		for (Racer r : lst_Racers) {
			System.out.println(r.getRacerName());
		}
	}

	public static void fill_list_racers() throws IOException {
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\jportzeh\\Documents\\Race\\Racers.txt");
		int akt_team=0,counter=0;
		if (file.exists() == false) {
			file.createNewFile();
		}
		BufferedReader bReader = new BufferedReader(new FileReader(file));
		String line;
		String[] parts;
		while ((line = bReader.readLine()) != null) {
			Racer r = new Racer();
			parts = line.split(":");
			r.setRacerName(parts[0]);
			r.setRacerPoints(Integer.valueOf(parts[1]));
			r.setTeam(lst_Teams.get(akt_team).getName());
			r.setTeamnumber(akt_team);
			if(counter%4==3&&counter<30) {
				akt_team++;
			}
			lst_Racers.add(r);
			counter++;
		}
		bReader.close();
	}

	public static void reset_table() throws IOException {
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\jportzeh\\Documents\\Race\\Racers.txt");
		if (file.exists() == false) {
			file.createNewFile();
		}
		BufferedWriter bWriter = new BufferedWriter(new FileWriter(file, false));
		for (Racer r : lst_Racers) {
			bWriter.write(String.valueOf(r.getRacerName() + ":0"));
			bWriter.write("\r\n");
		}
		bWriter.close();
		
		File file2 = new File("C:\\Users\\jportzeh\\Documents\\Race\\Standings.txt");
		if (file2.exists() == false) {
			file2.createNewFile();
		}
		BufferedWriter bWriter2 = new BufferedWriter(new FileWriter(file2, false));
		for (Racer r : lst_Racers) {
			bWriter2.write(String.valueOf(r.getRacerName() + ":0"));
			bWriter2.write("\r\n");
		}
		bWriter2.close();
		
		File file3 = new File("C:\\Users\\jportzeh\\Documents\\Race\\Teams.txt");
		if (file3.exists() == false) {
			file3.createNewFile();
		}
		BufferedWriter bWriter3 = new BufferedWriter(new FileWriter(file3, false));
		for (Team t : lst_Teams) {
			bWriter3.write(String.valueOf(t.getName() + ":0"));
			bWriter3.write("\r\n");
		}
		bWriter3.close();
	}

	public static void reset_counter() throws IOException {
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\jportzeh\\Documents\\Race\\Counter.txt");
		if (file.exists() == false) {
			file.createNewFile();
		}
		BufferedWriter bWriter = new BufferedWriter(new FileWriter(file, false));
		bWriter.write("0");
		bWriter.close();
		
		File file2 = new File("C:\\Users\\jportzeh\\Documents\\Race\\Season.txt");
		if (file2.exists() == false) {
			file2.createNewFile();
		}
		seasoncount++;
		BufferedWriter bWriter2 = new BufferedWriter(new FileWriter(file2, false));
		bWriter2.write(String.valueOf(seasoncount));
		bWriter2.close();
	}

	public static void print_winner() throws IOException {
		// TODO Auto-generated method stub
		String line,winner,points;
		String teile[];
		File file = new File("C:\\Users\\jportzeh\\Documents\\Race\\Standings.txt");
		if(file.exists()==false) {
			file.createNewFile();
		}
		BufferedReader bReader = new BufferedReader(new FileReader(file));
		line=bReader.readLine();
		bReader.close();
		teile=line.split(":");
		winner=teile[0];
		points=teile[1];
		System.out.println("\r\n");
		System.out.println("The winner is "+winner+" with "+points);
		File file2 = new File("C:\\Users\\jportzeh\\Documents\\Race\\Winners.txt");
		if (file2.exists() == false) {
			file2.createNewFile();
		}
		BufferedWriter bWriter = new BufferedWriter(new FileWriter(file2, true));
		bWriter.write(String.valueOf("Season "+seasoncount+" : "+winner+" with "+points+" points"));
		bWriter.write("\r\n");
		bWriter.close();
	}
	
	public static void print_teamwinner() throws IOException {
		int [] points = new int [8];
		int i=0;
		for(i=0;i<=points.length-1;i++) {
			points[i]=lst_Teams.get(i).getPoints();
		}
		Arrays.sort(points);
		File file = new File("C:\\Users\\jportzeh\\Documents\\Race\\TeamWinners.txt");
		if(file.exists()==true) {
			file.createNewFile();
		}
		BufferedWriter bWriter = new BufferedWriter(new FileWriter(file, true));
		for(Team t: lst_Teams) {
			if(t.getPoints()==points[0]) {
				System.out.println("The winning team is "+t.getName()+" with "+t.getPoints());
				bWriter.write(String.valueOf("Season "+seasoncount+" : "+t.getName()+" with "+t.getPoints()+" points"));
				bWriter.close();
			}
		}
	}
	
	public static void fill_list_teams() throws IOException {
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\jportzeh\\Documents\\Race\\Teams.txt");
		int counter=0;
		if (file.exists() == false) {
			file.createNewFile();
		}
		BufferedReader bReader = new BufferedReader(new FileReader(file));
		String line;
		String[] parts;
		while ((line = bReader.readLine()) != null) {
			Team t = new Team();
			parts = line.split(":");
			t.setName(parts[0]);
			t.setNumber(counter);
			t.setPoints(Integer.valueOf(parts[1]));
			lst_Teams.add(t);
			counter++;
		}
		bReader.close();
	}
	public static void update_history() throws IOException {
		File file = new File("C:\\Users\\jportzeh\\Documents\\Race\\Standings.txt");
		File file2 = new File ("C:\\Users\\jportzeh\\Documents\\Race\\History.txt");
		String [] racerhistory = new String[32];
		String [] teile;
		String line, line2;
		int counter=0,points=32;
		if(file.exists()==false) {
			file.createNewFile();
		}
		if(file2.exists()==false) {
			file2.createNewFile();
		}
		BufferedReader bReader = new BufferedReader(new FileReader(file));
		while((line = bReader.readLine()) != null) {
			teile=line.split(":");
			racerhistory[counter]=teile[0];
			counter++;
		}
		bReader.close();
		ArrayList<Racer>lst_History=new ArrayList<>();
		BufferedReader bReader2 = new BufferedReader(new FileReader(file2));
		while((line = bReader2.readLine()) != null) {
			Racer r = new Racer();
			teile=line.split(":");
			r.setRacerName(teile[0]);
			r.setRacerPoints(Integer.valueOf(teile[1]));
			lst_History.add(r);
		}
		bReader2.close();
		BufferedWriter bWriter = new BufferedWriter(new FileWriter(file2));
		for(Racer r: lst_History) {
			if(r.getRacerName().equals(racerhistory[0])) {
				r.setRacerPoints(r.getRacerPoints()+1);
			}
			bWriter.write(r.getRacerName()+":"+String.valueOf(r.getRacerPoints()));
			bWriter.write(("\r\n");
		}
		bWriter.close();
		
		
	}
	
	public static void update_wins() throws IOException {
		String winner;
		String [] teile;
		ArrayList <Racer> lst_GrandPrix = new ArrayList(); 
		File file = new File("C:\\Users\\jportzeh\\Documents\\Race\\GrandPrixWins.txt");
		if(file.exists()==false) {
			file.createNewFile();
		}
		BufferedReader bReader = new BufferedReader(new FileReader(file));
		while((line = bReader.readLine()) != null) {
			Racer r = new Racer();
			teile=line.split(":");
			r.setRacerName(teile[0]);
			r.setRacerPoints(Integer.valueOf(teile[1]));
			lst_GrandPrix.add(r);
			counter++;
		}
		bReader.close();
		BufferedWriter bWriter = new BufferedWriter(new FileWriter(file));
		for(Racer r: lst_Racers) {
			if(r.getRacerPosition()==1) {
				winner=r.getRacerName();
				break;
			}
		}
		for(Racer r: lst_GranPrix) {
			if(r.getRacerName().equals(winner)) {
				r.setRacerPoints(r.getRacerPoints()+1);
			}
			bWriter.write(r.getRacerName()+":"+String.valueOf(r.getRacerPoints()));
			bWriter.write("\r\n");
		}
		bWriter.close();
	}

}
