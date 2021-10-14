package queue;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeating 
{
	
	// A string is given. For each position find the first non-repeating letter in that
	// string from starting to the current position

	static char[] firstNonRepeating(String s)
	{
		int n = s.length();
		int[] freq = new int[27] ;
		
		char[] ans = new char[n] ;
		
		Queue<Character> q = new LinkedList<>();
		
		for (int i = 0 ; i < n ; i++)
		{
			char ch = s.charAt(i) ;
			freq[ch - 'a']++ ;
			q.add(ch) ;
			
			while (!q.isEmpty()) 
			{
				char top = q.peek();
				if (freq[top - 'a'] > 1) q.poll();
				else 
				{
					ans[i] = top ;
					break ;
				}
			}
			if (q.isEmpty()) ans[i] = '-' ;
		}
		
		
		return ans ;
	}
	
	
	public static void main(String[] args) 
	{
		String s = "aabccbcd" ;
		char[] ans = firstNonRepeating(s) ;
		
		for (char ch : ans) System.out.print(ch + " ");
		
	}

}
