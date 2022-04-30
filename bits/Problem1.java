package bits;

public class Problem1 
{
	/**
	 * Given two numbers a and b
	 * find number of bits to change to make a and b equal
	 */

	public static void main(String[] args) 
	{
		int a = 5 , b = 9 ;
		
		/**
		 * all the positions where bits in xor which are 1,
		 * have different bits in a and b
		 * We have to find number of setBits in xor
		 */
		int xor = a^b ;
		
		int ans = 0 ;
		
		/**
		 * a = a & (a-1) ==> This clears the rightmost setBit in a
		 */
		while (xor != 0) {
			ans++ ;
			xor = xor & (xor-1) ;
		}
		
		System.out.println(ans);
	}

}
