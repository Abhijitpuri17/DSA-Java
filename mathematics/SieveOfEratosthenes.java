package mathematics;

import java.util.ArrayList;
import java.util.List;


public class SieveOfEratosthenes 
{
	static List<Integer> seive(int n) 
	{
		// all are false by default
		// false -> prime, true -> composite
		boolean nums[] = new boolean[n+1] ;
		
		for (int i = 2 ; i <= Math.sqrt(n); i++)
		{
			if  (nums[i] == false) 
			{
				for (int j = i*i ; j <= n ; j += i)
				{
					nums[j] = true ;
				}
			}
		}
		
		List<Integer> primes = new ArrayList<>();
		
		for (int i = 2 ; i <= n ;i++)
		{
			if (nums[i] == false) primes.add(i) ;
		}
		

		return primes ;
	}

	public static void main(String[] args) 
	{
		List<Integer> prime_nums = seive(100) ;
		for (int x: prime_nums) System.out.print(x + " ");

	}

}
