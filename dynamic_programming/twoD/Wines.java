package dynamic_programming.twoD;

public class Wines 
{

	// rec_memoizatiob
	static int wines(int arr[], int l, int r, int y, int dp[][])
	{
		
		if (r < l) {
			return 0 ;
		}
		
		if (dp[l][r] != 0) {
			return dp[l][r] ;
		}
		
		int op1 = y*arr[l] + wines(arr, l+1, r, y+1, dp) ;
		int op2 = y*arr[r] + wines(arr, l, r-1, y+1, dp) ;
		
		
		return dp[l][r] =  Math.max(op1, op2) ;
	}
	
	public static void main(String[] args)
	{
		int arr[] = {2, 3, 5, 1, 4} ;
		System.out.println(wines(arr, 0, arr.length-1, 1, new int[5][5]));
	}
}
