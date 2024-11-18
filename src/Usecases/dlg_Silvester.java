package Usecases;

import java.util.Calendar;

public class dlg_Silvester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = 0, day, year;
		boolean cur_leapyear, next_leapyear;
		day = Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
		year = Calendar.getInstance().get(Calendar.YEAR);
		cur_leapyear = false;
		next_leapyear = false;
		if (year % 4 == 0) {
			cur_leapyear = true;
		} else {
			year++;
			if (year % 4 == 0) {
				next_leapyear = true;
			}
		}

		if (cur_leapyear == true) {
			result = 366 - day;
		} else {
			result = 365 - day;
		}
		if (result != 0) {
			System.out.println("Hallo Johannes! In " + result + " Tagen ist Silvester!");
		} else {
			System.out.println("Frohes Neues!");
		}

	}

}
