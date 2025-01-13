package Arrays;

public class Bubblesort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] numbers = new int [1000000];
		long start, end, time;
		int counter=0,i,k;
		boolean is_sorted=false;

		start=System.currentTimeMillis();
		
		for(counter=0;counter<=numbers.length-1;counter++) {
			numbers [counter] = (int)(Math.random()*1000000)+1; 
		}
		i=0;
		while(is_sorted==false) {
			is_sorted=true;
			for(i=0;i<=numbers.length-2;i++) {
				if(numbers[i]<=numbers[i+1]) {
					
				}
				else {
					is_sorted=false;
					k=numbers[i+1];
					numbers[i+1]=numbers[i];
					numbers[i]=k;
				}
			}
		}
		for(Integer z : numbers) {
			System.out.println(z);
		}
		end=System.currentTimeMillis();
		time=end-start;
		time=time/1000;
		System.out.println("Es hat "+time+" Sekunden gedauert!");
	}

}
