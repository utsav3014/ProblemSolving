package main;

/**
 * There is a problem defined that has 9 elements in the array
 * we need to find the max sum of sub-array of size 3
 * array {7,2,7,1,9,3,9,1,6,1}
 */

public class SlidingWindowProblem_MaxSumSubArrSizeK {

	private static int[] arr = {1, 4, 2, 10, 23, 3, 1, 0, 20};
	
	public static void main(String[] args) {
		// Given info
		
		int arrSize = arr.length;
		int windowSize = 5;
		
		//Let's first create few variable of use;
		
		int i=0;
		int j=0;
		int sumOfKElements =0;
		int max =0;
		// Parent Loop
		// creating window
		
		while(j<arrSize)
		{
			if(j-i+1 <= windowSize)
			{
				sumOfKElements += arr[j];
				max = sumOfKElements;
				j++;			
			}
			else {

				sumOfKElements = sumOfKElements +arr[j++] - arr[i++]; 
				if(sumOfKElements > max)
				{
					max = sumOfKElements;
				}
					
			}				
		}
		System.out.print("Largest Sub-Array Sum is : "+ max);
	}

}
