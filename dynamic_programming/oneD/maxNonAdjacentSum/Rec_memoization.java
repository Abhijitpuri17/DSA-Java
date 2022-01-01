package dynamic_programming.oneD.maxNonAdjacentSum;

public class Rec_memoization 
{
	
	static int maxNonAdjacentSum(int arr[], int i, int dp[])
	{
		if (i >= arr.length) return 0 ;
		
		int inclSum = arr[i] ;
		if (i+2 < arr.length && dp[i+2] != 0)
			inclSum += dp[i+2] ;
		else
		inclSum += maxNonAdjacentSum(arr, i + 2, dp) ;
		
		int exclSum = 0 ;
		if (i + 1 < arr.length && dp[i+1] != 0)
			exclSum = dp[i + 1] ;
		else 
			exclSum = maxNonAdjacentSum(arr, i + 1, dp) ;
		
		return dp[i] = Math.max(inclSum, exclSum) ;
		
	}

	public static void main(String[] args) 
	{
		int arr[] = {6, 10, 12, 7, 9, 14} ;
		System.out.println(maxNonAdjacentSum(arr, 0, new int[arr.length+1]));
	}

}
