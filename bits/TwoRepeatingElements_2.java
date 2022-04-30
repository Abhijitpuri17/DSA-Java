package bits;

public class TwoRepeatingElements_2 
{
	/**
	 * Given an array where each element occurs twice except two elements
	 * find the elements occurring only once
	 */
	public static void main(String[] args) 
	{
		int arr[] = {1, 2, 1, 3, 3, 4, 5, 6, 5,  6} ;
		
		int ans = 0 ;
		
		for (int i = 0 ; i < arr.length ; i++)
			 ans ^= arr[i] ;
		
		// Now ans = xor of two numbers occurring once
		
		/**
		 * Find the first position where these two nums have different bits
		 * Again loop through arr and take xor of nums where bits at this pos = 1
		 * So the num(one of the ans) having bit at that pos equal to 1 also gets cancelled
		 * we have one answer now.
		 */
		
		int pos = 0 ;
		while (findBit(ans, pos) == 0) pos++ ;
		
		int temp = ans ;
		for (int i = 0 ; i < arr.length ; i++)
		    if (findBit(arr[i], pos) == 1) temp ^= arr[i] ;
		
		// temp is one number and other number is ans ^ temp
		
		System.out.println(temp + " " + (temp ^ ans));
		
	}
	
	static int findBit(long a, long pos)
	{
		long mask = 1 << pos ;
		if ((a & mask) == 0) return 0 ;
		return 1 ;
	}

	
	// 1 2 3 4 5     4
	
	
	
	
	
	
	
	
	
	
}
