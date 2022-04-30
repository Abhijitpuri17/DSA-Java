package dynamic_programming.twoD.uniquePaths;

import java.util.Arrays;

public class BottomUp
{

    static long uniquePaths(int n, int m)
    {
        long[] prev = new long[m] ;
        Arrays.fill(prev, 1);

        for (int i = 1 ; i < n ; i++)
        {
            long[] curr = new long[m] ;
            for (int j = 0; j < m ; j++)
            {
                long left = 0, up = 0 ;
                if (j > 0) left = curr[j-1] ;
                up = prev[j] ;
                curr[j] = left + up ;
            }

            prev = curr ;
        }

        return prev[m-1];

    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,7));
    }

}
