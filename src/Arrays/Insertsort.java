package Arrays;

public class Insertsort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] numbers = new int [1000000];
		int k,i,min,counter=0;
		long start, end, time;
		
		start=System.currentTimeMillis();
		for(counter=0;counter<=numbers.length-1;counter++) {
			numbers [counter] = (int)(Math.random()*1000000)+1; 
		}
		counter=0;
		while(counter<=numbers.length-1) {
			System.out.println("Der Counter ist bei "+counter);
			min=numbers[counter];
			i=counter+1;
			for(i=0;i<=numbers.length-1;i++) {
				if(min>=numbers[i]) {
					
				}
				else {
					k=numbers[i];
					numbers[i]=numbers[counter];
					numbers[counter]=k;
					min=k;
				}
			}
			counter++;
		}
		for(Integer l: numbers) {
			System.out.println(l);
		}
		end=System.currentTimeMillis();
		time=end-start;
		time=time/1000;
		System.out.println("Es hat "+time+" Sekunden gedauert!");
		

	}

}
