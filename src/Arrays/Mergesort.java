package Arrays;

import java.util.Arrays;

import javax.naming.ldap.SortControl;

public class Mergesort {
    public static int mid;
    public static int [] numbers = new int [100];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start, end, time;
		int counter=0;
		
        start=System.currentTimeMillis();
		
		for(counter=0;counter<=numbers.length-1;counter++) {
			numbers [counter] = (int)(Math.random()*100)+1; 
		}
		
		int [] sorted = sort(0,numbers.length-1);
		
		for(Integer i: sorted) {
			System.out.println(sorted[i]);
		}

	}
	private static int[] sort(int l, int r) {
		// TODO Auto-generated method stub
		if(l<r) {
			int q = (l + r) / 2;
			sort(l, q);
			sort(q + 1, r);
			merge(l, q, r);
		}
		return numbers;
	}
	private static void merge(int l, int q, int r) {
		// TODO Auto-generated method stub
		int[] arr = new int [numbers.length]; 
		int i,j;
		for(i=l;i<=q;i++) {
			arr[i]=numbers[i];
		}
		for(j=q+1;j<=r;j++) {
			arr[r+q+1-j]=numbers[j];
		}
		i=l;
		j=r;
		for(int k=l;k<=r;k++) {
			if(arr[i] <= arr[j]) {
				numbers[k] = arr[i];
				k++;
			}
			else {
				numbers[k] = arr[j];
				j--;
			}
		}
	}

}
