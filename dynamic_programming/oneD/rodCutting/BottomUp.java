package dynamic_programming.oneD.rodCutting;

public class BottomUp 
{

	
	static int maxProfitRodCutting(int n, int[] prices)
	{
		int dp[] = new int [n + 1] ;
		
		for (int len = 1 ; len <= n ; len++)
		{
			
			int ans = Integer.MIN_VALUE;
			
			for (int i = 0 ; i < len ; i++)
			{
				int cut = i+1 ;
				
				int curr_ans = prices[i] + dp[len-cut] ;
				
				ans = Math.max(ans, curr_ans) ;
				
			}
			
			dp[len] = ans ;
		}
		
		return dp[n] ;	
	}
	
	public static void main(String[] args) 
	{
		
		int n = 8 ;
		
		int prices[] = {1, 5, 8, 9, 10, 17, 17, 20};
		
		System.out.println(maxProfitRodCutting(n, prices));

		
	}

}
