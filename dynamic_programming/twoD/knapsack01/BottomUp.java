public class BottomUp
{

    static int knapsack(int val[], int weight[], int w)
    {
        int n = weight.length ;
        int dp[][] = new int[n+1][w+1] ;

        for (int i = 0 ; i <= n ; i++)
        {
            for (int j = 0 ; j <= w; j++)
            {
                if (i == 0 || j == 0) dp[i][j] = 0 ;
                else
                if (j >= weight[i-1])
                {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - weight[i-1]] + val[i-1]) ;
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][w] ;

    }

    public static void main(String[] args)
    {
        int val[]  = {1, 2, 3};
        int weight[] = {4, 5, 1};

        int capacity = 4 ;

        System.out.println(knapsack(val, weight, capacity));
    }
}
