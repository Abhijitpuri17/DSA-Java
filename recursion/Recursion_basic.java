package recursion;

import java.math.BigInteger; ;

public class Recursion_basic 
{
	/**
	 * @param n = natural number
	 * @return sum of first n natural numbers
	 */
	static int sum(int n)
	{
		if (n == 0) return 0 ;
		return sum(n-1)+n ;
	}
	
	/**
	 * @param n = natural number
	 * @return factorial of n
	 * BigInteger is a built-in class in java which can handle very big integers
	 */
	static BigInteger fact(int n)
	{
		if (n == 1) return BigInteger.ONE;
		return fact(n-1).multiply(BigInteger.valueOf(n)) ;
	}
	
	/**
	 * @param a = base
	 * @param b = power
	 * @return a to the power b
	 */
	static long fastpower(long a, long b)
	{
		if (b == 0) return 1 ;
		if ((b & 1) == 0) return fastpower((a * a) , b/2)  ;
		return fastpower(a, b-1) * a ;
	}
	
	
	public static void main(String[] args) 
	{
	
		System.out.println(sum(10));
		System.out.println(fact(100));
		System.out.println(fastpower(10, 7));

	}

}
