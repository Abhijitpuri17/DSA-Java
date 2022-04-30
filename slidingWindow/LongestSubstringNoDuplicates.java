package slidingWindow;

import java.util.LinkedHashSet;

public class LongestSubstringNoDuplicates
{
	
	// Find the longest substring from string s such that substring has no duplicate
	
	static String unique_substring(String s)
	{
		
		LinkedHashSet<Character> set = new LinkedHashSet<>();
		
		int i = 0 , j = 0 , start = 0, end = 0;
		
		while (j < s.length())
		{
			char c = s.charAt(j) ;
			
			// if our ans string already contains c, contract the window from
			// starting until c is removed from window
			while (set.contains(c))
			{
				set.remove(set.iterator().next()) ;
				i++ ;
			}
			
			// now add c to ans string and check if it longest till now
			set.add(c) ;
			if (j - i > end - start) {
				start = i ;
				end = j ;
			}
			j++ ;	
		}
		
		return s.substring(start, end+1) ;
	}
	

	public static void main(String[] args) 
	{
		String s = "aabcb" ;
		System.out.println(unique_substring(s));
	}

}
