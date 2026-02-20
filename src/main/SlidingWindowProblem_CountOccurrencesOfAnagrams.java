package main;

import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SlidingWindowProblem_CountOccurrencesOfAnagrams {

	public static void main(String args[]) {
		
		
		// Base String 
		
		String baseSting = "abc";
		//                  0123456789////
		String anagram = "";
		
		if (anagram == null || baseSting == null 
		        || anagram.length() == 0 
		        || anagram.length() > baseSting.length()) {
		    System.out.println("Anagram count is : 0");
		    return;
		}
		int val=0;
		// Map of anagram
		
		Map<Character, Long> anagramStore = 
		anagram.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		// count var for calculation
		int count = anagramStore.size();
		
		int i=0;
		int j=0;
		
		int patternSize =anagram.length();
		
		
		while(j<baseSting.length())
		{
			char cj= baseSting.charAt(j);
			char ci=  baseSting.charAt(i);
			if(anagramStore.containsKey(cj))
			{
				anagramStore.put(cj, anagramStore.get(cj)-1);
				if(anagramStore.get(cj)==0)
					count--;
			}
			
			if(j-i+1< patternSize)
			{
				j++;
			}
			else if (j-i+1 ==  patternSize)
			{
				
				if(count ==0)
					val++;
				if(anagramStore.containsKey(ci))
				{
					anagramStore.put(ci, anagramStore.get(ci)+1);
					if(anagramStore.get(ci) == 1)
					count++;
					
				}
				
				
				
			i++;
			j++;
			}
		}
		
		System.out.println("Anagram count is :"+ val);
	}
	
	
}
