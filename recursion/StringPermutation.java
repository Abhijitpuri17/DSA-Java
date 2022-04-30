package recursion;

public class StringPermutation 
{
	static char ans[] ;

	static void perm(String s,boolean flags[], int k)
	{
		if (k == s.length()) {
			String ans_string = new String(ans) ;
			System.out.println(ans_string);
		}
		
		/**
		 * 	For kth position in ans , each character in string s should be added in ans
		 * 	after deciding kth pos, recursively call the fun with k = k+1
		 * 	Once all recursive calls after kth pos are completed. the char taken for kth
		 * 	pos will again be available for other positions
		 * 
		 */
		
		for (int i = 0 ; i < flags.length ; i++)
		{
			if (flags[i] == false)
			{
				flags[i] = true ;
				ans[k] = s.charAt(i) ;
				perm(s, flags, k+1);
				flags[i] = false ;
			}
		}
		
		
	}
	
	public static void main(String[] args) 
	{
		String s = "Abhijit" ;
	    ans = new char[s.length()];
	    boolean flags[] = new boolean[s.length()] ;
	    perm(s, flags, 0);
	}

}
