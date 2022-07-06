public class Solution {
  
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight)
    {
        return helper(profit, weight, n-1, w, new int[n][w+1]) ;
    }
    
    public static int helper(int[] profit, int[] weight, int ind, int W, int[][] dp)
    {
        if (W < 0 || ind < 0) return 0 ;
        
        if(dp[ind][W] != 0) return dp[ind][W] ;
        
        int take = 0 ;
        if (weight[ind] <= W)
            take = profit[ind] + helper(profit, weight, ind, W - weight[ind], dp) ;
        
        int notTake = helper(profit,  weight, ind-1, W, dp) ;
        
        return dp[ind][W] = Math.max(take, notTake)  ;
    }
}
