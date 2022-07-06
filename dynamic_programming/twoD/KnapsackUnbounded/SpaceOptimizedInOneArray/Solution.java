public class Solution 
{
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) 
    {
        int[] dp = new int[w+1] ;
        
        for (int ind = 0 ; ind < n ; ind++)
        {
            for (int wt = 0 ; wt <= w; wt++)
            {
                int take = 0, notTake = 0 ;
                if(ind > 0) {
                    notTake = dp[wt];
                }
                if (weight[ind] <= wt) {
                    take = profit[ind] + dp[wt - weight[ind]] ;
                }
                
                dp[wt] = Math.max(take, notTake) ;
            }
        }
        
        return dp[w] ;
    }
}
