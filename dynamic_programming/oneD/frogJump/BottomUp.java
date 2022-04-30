package dynamic_programming.oneD.frogJump;

public class BottomUp
{

    static long frogJump(long[] heights, int n)
    {
        long prev2 = 0, prev = Math.abs(heights[1] - heights[0]) ;

        for (int i = 2 ; i < n ; i++)
        {
            long jump1 = Math.abs(heights[i] - heights[i-1]) + prev ;

            long jump2 = Math.abs(heights[i] - heights[i-2]) + prev2 ;

            long curr = Math.min(jump1, jump2) ;

            prev2 = prev ;
            prev = curr ;

        }

        return prev ;
    }


    public static void main(String[] args) {
        long[] heights = {10,20,30,50,40,20,10} ;

        System.out.println(frogJump(heights, heights.length)) ;

    }

}
