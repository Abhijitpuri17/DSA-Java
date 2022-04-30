package dynamic_programming.oneD.frogJump;

public class rec_memoization
{

    // given n stones of heights[i] = height, It can jump one or two stones ahead
    // and cost to jump  = abs(height diff). Find minimum cost to reach at end

    static long frogJump(long[] heights, int i, long[] dp)
    {
        if (i == 0) return 0 ;

        if (dp[i] != 0) return dp[i] ;

        // jump by one stone
        long jump1  = frogJump(heights, i-1, dp) + Math.abs(heights[i] - heights[i-1]) ;

        // jump by two stones
        long jump2 = Long.MAX_VALUE ;
        if (i > 1)
            jump2 = frogJump(heights, i-2, dp) + Math.abs(heights[i] - heights[i-2]) ;

        return dp[i] = Math.min(jump1, jump2) ;
    }

    public static void main(String[] args) {

        long[] heights = {10,20,30,50,40,20,10} ;

    }

}
