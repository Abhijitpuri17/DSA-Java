package dynamic_programming.oneD.rodCutting;

public class Rec_memoization 
{
	
	
	// given a rod of length = n .. Also given prices of rods of length
	// 1 , 2 , 3, .. n.    Find the maximum profit one can get if 
	// we can cut the rod into one or more pieces
	
	static int maxProfitRodCutting(int n, int[] prices, int dp[])
	{
		
		if (n <= 0) return 0 ;
		
		int maxProfit = 0 ;
		
		for (int i = 1 ; i <= n ; i++)
		{
			
			int curr ;
			if (dp[n-i] != 0) curr = prices[i] + dp[n-i] ;
			else
			curr = prices[i] + maxProfitRodCutting(n - i, prices, dp) ;
	
			if (curr > maxProfit) maxProfit = curr ;
		}
		
		return dp[n] = maxProfit ;
	}
	
	
	public static void main(String[] args)
	{
		int n = 8 ;
		int prices[] = {0, 1, 5, 8, 9, 10, 17, 17, 20};
		System.out.println(maxProfitRodCutting(n, prices, new int[n+1]));
	}

}
