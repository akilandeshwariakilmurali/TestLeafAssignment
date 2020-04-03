package week1.day4;

import java.util.Arrays;

public class LearnArrays {

	public static void main(String[] args) {
		int[] a= {10,40,70,100};
		
	// Average of given numbers	
		int count = a.length;
		int sum =0;
		for (int i=0;i<a.length; i ++) {
			sum = sum + a[i];
		}
		int avg = sum/count;
		System.out.println(avg);
		
		// Min and max number 
		int[] b = { 200,500,10, 3000 };
		int min = b[0];
		int max = b[0];
		
		for (int i=0;i<b.length; i++) {
			if(b[i] <  min) {
				min = b[i];
			}
			if(b[i] > max) {
				max = b[i];
			}
		}
		System.out.println(min);
		System.out.println(max);
		
		// Another way - Min and max number 
		int count1 = b.length -1;
		Arrays.sort(b);
		System.out.println(b[0]);
		System.out.println(b[count1]);
	}

}
