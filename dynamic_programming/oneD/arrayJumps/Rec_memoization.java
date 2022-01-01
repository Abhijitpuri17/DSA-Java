package dynamic_programming.oneD.arrayJumps;

public class Rec_memoization
{
	// Given an array. You can take a jump of arr[i] from i
	// find minimum number of jumps to reach end of array (n-1) pos

	static int minJumps(int arr[], int s, int n ,int dp[])
	{
		
		if (s >= arr.length-1) return 0 ;
		
		int ans = Integer.MAX_VALUE;
		
		for (int jump = 1; jump <= arr[s] && s+jump < n; jump++)
		{
			
		  int curr_ans ;
		  
		  if (dp[s+jump] != 0) 
			  curr_ans = dp[s+jump] ;
		  
		  else 
			  curr_ans = minJumps(arr, s+jump, n , dp) ;
		  
		  ans = Math.min(ans, curr_ans) ; 
		}
		
		return dp[s] = ans+1;
	}
	
	
	public static void main(String[] args) 
	{
	  int arr[] = {3, 4, 2, 1, 2, 3, 10, 1, 1, 1, 2, 5};
	  
	  System.out.println(minJumps(arr, 0, arr.length, new int[arr.length]));

	}

}
