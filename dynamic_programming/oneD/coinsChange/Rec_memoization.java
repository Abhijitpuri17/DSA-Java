package dynamic_programming.oneD.coinsChange;

public class Rec_memoization 
{

	// given different demons of coins and also totalMoney.
	// calculate minimum number of coins to get the totalMoney
	
	static int minNumOfCoinsForChange(int[] denoms, int totalMoney, int[] dp)
	{
		if (totalMoney == 0) 
			return 0 ;
		
		if (totalMoney < 0) 
			return -1 ;
		
		
		int min = Integer.MAX_VALUE;
		for (int c: denoms)
		{
			int curr = -1 ;
			
			if (totalMoney - c >= 0 && dp[totalMoney-c] != 0) 
				curr = dp[totalMoney-c] ;
			else
				curr = minNumOfCoinsForChange(denoms, totalMoney-c, dp);
			
			if (curr != -1)
				min = Math.min(curr, min) ;
		}
		
		if (min == Integer.MAX_VALUE) return -1 ;
		
		return dp[totalMoney] = min+1 ;
	}

	public static void main(String[] args) 
	{
		int[] denoms = {3,5,7,9} ;

		int totalMoney = 11 ;
		
		System.out.println(minNumOfCoinsForChange(denoms, totalMoney, new int[totalMoney+1])) ;

	}

}
