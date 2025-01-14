package Arrays;

public class Selectionsort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] numbers = new int [100000];
		int k = 0,i,min = 0,counter=0;
		long start, end, time;
		
		start=System.currentTimeMillis();
		
		for(counter=0;counter<=numbers.length-1;counter++) {
			numbers [counter] = (int)(Math.random()*100000)+1; 
		}
		
		counter=0;
		while(counter<=numbers.length-1) {
			min=numbers[counter];
			i=counter+1;
			while(i<=numbers.length-1) {
				if(min<=numbers[i]) {
					
				}
				else {
					min=numbers[i];
					k=i;
				}
				i++;
			}
			numbers[k]=numbers[counter];
			numbers[counter]=min;
			counter++;
		}
		for(Integer l: numbers) {
			System.out.println(l);
		}
		end=System.currentTimeMillis();
		time=end-start;
		System.out.println("Es hat "+time+" Millisekunden gedauert!");
		

	}

}
