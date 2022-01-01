package dynamic_programming.oneD.laddersProblem;

public class BottomUp 
{
	
	// O(n) ,,,, dynamic programming + sliding window
	static int ladder(int n , int k)
	{
		int dp[] = new int[n+1] ;
		dp[0] = 1 ;
		
		int start_window = 1 ;
		int curr = dp[0] ;
		
		// fill dp array for first k pos 0 to k-1
		for (int i = 1 ; i < k ; i++)
		{
			dp[i] = curr;
			curr += dp[i] ;
		}
		
		// use sliding window with window size = k to get sum of all
		// elements in window for current pos. ==> curr holds
		// sum of elements in window.
		for (int i = k ; i <= n ; i++)
		{
			dp[i] = curr;
			curr += dp[i] - dp[start_window++] ;
		}
		
		return dp[n] ;
	}

	public static void main(String[] args)
	{
		System.out.println(ladder(4, 3));

	}

}
