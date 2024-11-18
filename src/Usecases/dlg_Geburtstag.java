package Usecases;

import java.util.Calendar;

public class dlg_Geburtstag {

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
			if (day < 105) {
				result = 104 - day;
			} else {
				result = 104 - day + 365;
			}
		} else {
			if (next_leapyear == true) {
				if (day < 104) {
					result = 103 - day;
				} else {
					result = 104 - day + 365;
				}
			} else {
				if (day < 104) {
					result = 103 - day;
				} else {
					result = 103 - day + 365;
				}
			}
		}
		if (result != 0) {
			System.out.println("Hallo Johannes! In " + result + " Tagen ist dein Geburtstag!");
		} else {
			System.out.println("Alles gute zum Geburtstag lieber Johannes!");
		}

	}

}
