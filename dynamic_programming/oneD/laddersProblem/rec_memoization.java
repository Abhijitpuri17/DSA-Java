package dynamic_programming.oneD.laddersProblem;

public class rec_memoization 
{

	/*
	 * Given a ladder of size n and an integer k, write a function
	 * to compute no of ways to climb the ladder if you can take a
	 * jump of at most k at every step
	 */
	
	static int ladder(int n, int k, int dp[])
	{
		int ways = 0 ;
		if (n == 0) return 1 ;
		
		if (dp[n] != 0) return dp[n] ;
		
		for (int i = 1 ; i <= k && n-i >= 0 ; i++)
		{
			ways += ladder(n-i, k, dp) ;
		}
		return dp[n] = ways ;
	}
	
	
	public static void main(String[] args)
	{
	
		System.out.println(ladder(4, 3, new int[5]));
		
	}

}
