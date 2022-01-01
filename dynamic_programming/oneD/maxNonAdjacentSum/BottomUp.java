package dynamic_programming.oneD.maxNonAdjacentSum;

public class BottomUp 
{

	static int maxNonAdjacentSum(int arr[])
	{
		int n = arr.length;
		int dp[] = new int[n];
		
		dp[0] = arr[0] ;
		dp[1] = arr[1] ;
		
		int j = 0, curr_max = dp[0] ;
		
		for (int i = 2 ; i < n ; i++)
		{
			dp[i] = curr_max + arr[i] ;
			curr_max = Math.max(curr_max, dp[j++]) ;
		}
		
		return dp[n-1] ;
	}
	
	
	public static void main(String[] args) 
	{
		int arr[] = {6, 10, 12, 7, 9, 14} ;
		System.out.println(maxNonAdjacentSum(arr));

	}

}
