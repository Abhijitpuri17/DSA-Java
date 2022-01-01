package dynamic_programming.oneD.longestIncreasingSubSequence;

public class BottomUp 
{
	
	static int lis(int arr[])
	{
		int n = arr.length ;
		int dp[] = new int[n] ;
		
		dp[0] = 1 ;
		int max_lis = 0 ;
		for (int i = 1 ; i < n ; i++)
		{
			int curr_ans = 0 ;
			for (int j = 0 ; j < i ; j++)
			{
				if (arr[j] < arr[i]) 
					curr_ans = Math.max(curr_ans, dp[j]) ;
			}
			dp[i] = curr_ans + 1 ;
			
			max_lis = Math.max(max_lis, dp[i]) ;
			
		}
		
		return max_lis ;
	}

	public static void main(String[] args) 
	{
		int arr[] = {50, 4, 10, 8, 30, 100, 2};
		System.out.println(lis(arr));

	}

}
