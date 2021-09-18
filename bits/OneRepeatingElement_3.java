package bits;

public class OneRepeatingElement_3 
{

	/**
	 * Given an array where each element occurs k except one element
	 * find the element occurring only once
	 */
	
	public static void main(String[] args) 
	{
		int arr[] = {1, 2, 1, 2, 2, 4, 5, 6, 4, 5, 6, 1 , 3 , 4 , 5 , 6, 1, 2, 4 , 5, 6} ; 
		int k = 4 ;
		
		int bitsArr[] = new int[32] ;
		
		/**
		 * bitsArr tells how many numbers have setBit at given position
		 * For num occurring only once, if it has setBit at some position,
		 * bitsArr[at that position] % k = 1
		 */
		for (int i = 0 ; i < arr.length ; i++)
		{
			int pos = 0 , curr = arr[i];
			
			while (curr != 0) {
				if ((curr & 1) != 0) {
					bitsArr[pos]++ ;
				}
				curr >>= 1 ;
				pos++ ;
			}
		}
		
		long ans = 0 ;
		
		for (int i = 0 ; i < bitsArr.length ; i++)
		{
			if ((bitsArr[i] % k) != 0) ans = setBit(ans, i) ;
		}
		
		System.out.println(ans);
		
	
	}
	
	static int findBit(long a, long pos)
	{
		long mask = 1 << pos ;
		if ((a & mask) == 0) return 0 ;
		return 1 ;
	}
	
	static long setBit(long a, long pos)
	{
		return a | (1 << pos) ;
	}

}
