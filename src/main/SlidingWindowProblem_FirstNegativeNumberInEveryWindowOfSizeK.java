package main;

import java.util.LinkedList;

public class SlidingWindowProblem_FirstNegativeNumberInEveryWindowOfSizeK {


	private static int[] arr = {12, 1, -7, 8, -15, 30, 16, 28,-3,1,4,-5,-10};
	
	public static void main(String[] args) {
	// Given info
		
		int arrSize = arr.length;
		int windowSize = 3;
		
		if(windowSize<=0 || windowSize > arrSize)
		{
			System.out.println("wrong inputs");
			return;
		}
		//Let's first create few variable of use;
		
		int i=0;
		int j=0;
		LinkedList<Integer> negativeQueue= new LinkedList<>(); 
		// Parent Loop
		// creating window
		
		while(j<arrSize)
		{
			if(arr[j]<0)
				negativeQueue.add(arr[j]);
			
			
			if(j-i+1 < windowSize)
			{
				j++;
			}
			
			else if(j-i+1 == windowSize) {
				if(!negativeQueue.isEmpty())
					System.out.println("Negative number:"+ negativeQueue.getFirst());
				else {
					System.out.println("No Negative number in window");
				}
				
				if(!negativeQueue.isEmpty() && arr[i] == negativeQueue.getFirst())
				{
					negativeQueue.removeFirst();
				}
			
				j++;
				i++;
			}
			
		}
	}

}
