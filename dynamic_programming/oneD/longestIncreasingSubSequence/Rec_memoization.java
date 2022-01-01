package dynamic_programming.oneD.longestIncreasingSubSequence;

public class Rec_memoization 
{
	static int lis_one(int arr[], int i, int dp[])
	{
		int curr_ans = 0 ;
		for (int j = i+1 ; j < arr.length ; j++)
		{
			if (arr[j] > arr[i]) 
			{
				if 
					(dp[j] != 0) curr_ans = Math.max(curr_ans, dp[j]) ;
				else
					curr_ans = Math.max(curr_ans, lis_one(arr, j, dp)) ;	
			}
		}
		
		return dp[i] = curr_ans + 1 ;
	}
	
	static int lis(int arr[])
	{
		int ans = 0 ;
		
		for (int i = 0 ; i < arr.length ; i++)
			ans  = Math.max(lis_one(arr, i, new int[arr.length]), ans) ;
		
		return ans;
	}
	

	public static void main(String[] args)
	{
		int arr[] = {50, 4, 10, 8, 30, 100, 2};
		System.out.println(lis(arr));
	}

}
