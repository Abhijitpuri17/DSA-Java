import java.util.LinkedList;

public class SubsetSum
{

    static boolean subSetSum(int arr[], int sum)
    {
        int n = arr.length ;

        boolean dp[][] = new boolean[n+1][sum+1] ;

        for (int i = 0 ; i <= n ; i++)
        {
            dp[i][0] = true ;
        }

        for (int i = 1 ; i <= sum ; i++)
        {
            dp[0][i] = false ;
        }

        for (int i = 1 ; i <= n ; i++)
        {
            for (int j = 1; j <= sum ; j++)
            {
                boolean excl = dp[i-1][j] ;
                if (arr[i-1] <= j)
                {
                    boolean incl = dp[i-1][j - arr[i-1]] ;
                    dp[i][j] = excl | incl ;
                }
                else {
                    dp[i][j] = excl;
                }
            }
        }

        LinkedList<Integer> l = new LinkedList<>() ;

        if (dp[n][sum])
        {
            int currN = n, currSum = sum ;

            while(currN != 0) {
                if (!dp[currN - 1][currSum]) {
                    l.addFirst(arr[currN - 1]);
                    currSum -= arr[currN - 1];
                } currN-- ;
            }

            for (int x: l) System.out.print(x + " ") ;
            System.out.println() ;
        }

        return dp[n][sum] ;
    }


    public static void main(String[] args)
    {
        int arr[] = {1,4,8,2,6,3} ;

        for (int i = 1 ; i <= 50 ; i++)
        {
            System.out.println(i + " " + subSetSum(arr, i));
        }
    }
}
