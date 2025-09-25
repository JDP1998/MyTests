package Usecases;

import java.text.SimpleDateFormat;
import java.time.format.FormatStyle;
import java.util.Date;

public class dlg_Date {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
		System.out.println("Hallo Johannes. Es ist der "+format.format(d)+" und es ist "+format2.format(d)+".");
	}

}
