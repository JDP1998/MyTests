package Search;

import java.util.Arrays;

public class Binary_Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] numbers = new int [499999999];
		int begin = 0,end,number, rounds=1,middle=0,counter=0;
		boolean is_gefunden=false;
		
		//Declare number
		number=(int)(Math.random()*499999999)+1;
		System.out.println(number);
		System.out.println("\r\n");
		
		//Declare end
		end=numbers.length;
		
		//Fill Array
		for(counter=0;counter<=numbers.length-1;counter++) {
			numbers[counter]=counter+1;
		}
		
		//Sort Array
		Arrays.sort(numbers);
		
		while(is_gefunden==false) {
			middle=end-begin;
			middle=middle/2;
			middle=middle+begin;
			if(numbers[middle]==number) {
				is_gefunden=true;
			}
			else {
				if(numbers[middle]>number) {
					end=middle;
				}
				else {
					begin=middle;
				}
			}
			System.out.println("Anfang "+begin);
			System.out.println("Ende "+end);
			System.out.println("\r\n");
			rounds++;
		}
		System.out.println("The number "+number+" was found. It took "+rounds+" turns to find it!");

	}

}
