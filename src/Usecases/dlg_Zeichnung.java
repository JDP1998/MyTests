package Usecases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class dlg_Zeichnung {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\jportzeh\\Desktop\\Java Dateien\\Zeichnung.txt");
		if(file.exists()==false) {
			file.createNewFile();
		}
		
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
		int random,linecounter=0,counter=0;
		String druckzeile;
		
		while(linecounter<35) {
			counter=0;
			druckzeile="";
			while(counter<170) {
				random=(int)(Math.random()*100)+1;
				if(random%2==0) {
					druckzeile=druckzeile+"*";
				}
				else {
					druckzeile=druckzeile+" ";
				}
				counter++;
			}
			bufferedWriter.write(druckzeile);
			bufferedWriter.write("\r\n");
			linecounter++;
		}
		
		bufferedWriter.close();

	}

}
