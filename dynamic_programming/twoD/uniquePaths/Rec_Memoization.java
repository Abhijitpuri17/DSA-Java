package dynamic_programming.twoD.uniquePaths;

public class Rec_Memoization
{

    // number of unique paths to reach at n,m from 0,0

    static long uniquePaths(int n, int m, long[][] dp)
    {
        if (n==0 || m == 0) return 1 ;

        if (dp[n][m] != 0) return dp[n][m] ;

        long left = uniquePaths(n, m-1, dp) ;
        long up = uniquePaths(n-1, m, dp) ;

        return dp[n][m] = left + up ;

    }


    public static void main(String[] args)
    {
        int n = 3, m = 7 ;
        long[][] dp = new long[n][m] ;
        System.out.println(uniquePaths(n-1, m-1, dp));
    }

}
