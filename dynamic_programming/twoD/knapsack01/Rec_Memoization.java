public class Rec_Memoization
{


    static int knapsack(int val[], int weight[], int w, int n, int dp[][])
    {
        if (n == 0 || w == 0) return 0 ;

        if (dp[n][w] != 0) return dp[n][w] ;

        if (weight[n-1] <= w)
        {
            return dp[n][w] = Math.max(val[n-1] + knapsack(val, weight, w - weight[n-1], n-1, dp),
                    knapsack(val, weight, w, n-1, dp)) ;
        }
        else {
            return dp[n][w] =  knapsack(val, weight, w, n-1, dp) ;
        }
    }


    public static void main(String[] args)
    {
        int val[]  = {60, 100, 120};
        int weight[] = {10, 20, 30};

        int n = val.length ;

        int capacity = 30 ;

        System.out.println(knapsack(val, weight, capacity, val.length, new int[n+1][capacity+1]));


    }

}
