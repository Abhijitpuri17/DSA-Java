public class CatalanNumber
{

    // number of bst that can be formed from nodes with value 1 to n

    static int catalan(int n, int dp[])
    {

        if (n == 0 || n == 1) return 1 ;

        if (dp[n] != 0) return dp[n] ;

        int ans = 0 ;
        for (int i = 1 ; i <= n ; i++)//left * right
            ans += catalan(i-1, dp) * catalan(n-i, dp) ;

        return dp[n] =  ans;
    }

    static int catalanBottomUp(int N)
    {
        int dp[] = new int[N+1] ;

        dp[0] = dp[1]  = 1 ;

        for (int n  = 2 ; n <= N ; n++)
        {
            for (int i = 1 ; i <= n ; i++)
            {
                dp[n] += dp[i-1] * dp[n-i] ;
            }
        }

        return dp[N] ;
    }



    public static void main(String[] args)
    {

        System.out.println(catalan(4, new int[4+1]));
        System.out.println(catalanBottomUp(4));
    }

}
