package dynamic_programming.oneD.arrayJumps;

public class BottomUp 
{
	
	static int minJumps(int[] arr)
	{
		int n = arr.length;
		
		int[] dp = new int[n] ;
		
		for (int i = n-2; i >= 0 ; i--)
		{
			int maxJump = arr[i] ;
			
			int ans = Integer.MAX_VALUE;
			
			for (int jump = 1 ; jump <= maxJump && i + jump < n; jump++)
			{
				ans = Math.min(ans, dp[i+jump]) ;
			}
			
			dp[i] = ans + 1 ;
		} 
		
		return dp[0] ;
	}

	public static void main(String[] args) 
	{
		int[] arr = {3, 4, 2, 1, 2, 3, 10, 1, 1, 1, 2, 5} ;
		System.out.println(minJumps(arr));

	}

}
