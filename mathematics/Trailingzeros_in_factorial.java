package mathematics;

public class Trailingzeros_in_factorial 
{

	/**
	 * Find number of trailing zeros in factorial of given number
	 */
	
	/**
	 * Every 10 in multiplication gives a trailing zero
	 * 10 = 5*2 ==> Each multiple of 5 gives trailing zero because 2 will always occur more 
	 * times than 5
	 *
	 * 25 has 2 5's so it will give two 2 trailing zeros. 125 will give 3 trailing zeros .... and so on
	 */
	
	public static void main(String[] args)
	{
		int n = 1000 ;
		int ans = 0 , a = 5;
		while ((n / a) !=0)
		{
			ans += n/a ;
			a *= 5 ;
		}
		System.out.println(ans);

		
	}

}
