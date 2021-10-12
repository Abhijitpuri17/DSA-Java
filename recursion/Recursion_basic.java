package recursion;

import java.math.BigInteger; ;

public class Recursion_basic 
{
	
	static int sum(int n)
	{
		// base case
		if (n == 0) return 0 ;
		
		// recursive case
		return sum(n-1)+n ;
	}
	
	
	static BigInteger fact(int n)
	{
		// base case
		if (n == 1) return BigInteger.ONE;
		
		// recursive case
		return fact(n-1).multiply(BigInteger.valueOf(n)) ;
	}
	
	static long fastpower(long a, long b)
	{
		// base case
		if (b == 0) return 1 ;
		
		// if power is even we can write a^b = (a*a)^b/2
		if ((b & 1) == 0) return fastpower((a * a) , b/2)  ;
		
		// if power is odd we can write a^b = a*(a^b-1)
		return fastpower(a, b-1) * a ;
	}
	
	
	public static void main(String[] args) 
	{
	
		System.out.println(sum(10));
		System.out.println(fact(100));
		System.out.println(fastpower(10, 7));

	}

}
