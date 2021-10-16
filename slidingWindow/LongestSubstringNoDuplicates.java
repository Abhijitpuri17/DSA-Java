package slidingWindow;

import java.util.LinkedHashSet;

public class LongestSubstringNoDuplicates
{
	
	static String unique_substring(String s)
	{
		
		// elements are stored in same order we add them in linkedHashSet
		LinkedHashSet<Character> set = new LinkedHashSet<>();
		
		int i = 0 , j = 0 , start = 0, end = 0;
		
		
		while (j < s.length())
		{
			char c = s.charAt(j) ;
			
			// if c is already present in window. Start contracting the window from left till c is not removed.
			while (set.contains(c))
			{
				set.remove(set.iterator().next()) ;
				i++ ;
			}
			
			// now add c at last and check if this substring can be longest or not
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
