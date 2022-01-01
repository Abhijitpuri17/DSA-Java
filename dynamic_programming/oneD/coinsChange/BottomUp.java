package dynamic_programming.oneD.coinsChange;

public class BottomUp 
{
	
	static int minNumOfCoinsForChange(int[] denoms, int totalMoney)
	{
		int dp[] = new int[totalMoney+1] ;
		
		for (int i = 1 ; i <= totalMoney; i++)
		{
			dp[i] = Integer.MAX_VALUE;
			
			for (int c: denoms)
			{
				if (i - c >= 0 && dp[i - c] != Integer.MAX_VALUE)
					dp[i] = Math.min(dp[i], dp[i - c] + 1) ;
			}
			
		}
		
		if (dp[totalMoney] != Integer.MAX_VALUE)
			return dp[totalMoney] ;
		
		return -1 ;
	}

	public static void main(String[] args) 
	{
		// types of coins
		int[] denoms = {3,5,7,9} ;

		int totalMoney = 17 ;
		
		System.out.println(minNumOfCoinsForChange(denoms, totalMoney));
		
	
	}

}
