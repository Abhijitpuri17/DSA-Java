public class GameOfGreed
{

    // given an array of coins. Partition them in k parts and distribute in k friend
    // you get min of these partitions. Find the maximum value you can get

    static int gameOfGreed(int arr[], int k)
    {
        int sum = 0 ;
        for (int i = 0 ; i < arr.length; i++)
        {
            sum += arr[i] ;
        }

        // ans lies in range [0, sum]
        int start = 0, end = sum ;

        int ans = 0 ;

        // binary search
        while (start <= end)
        {
            int mid = start + ((end - start) >> 1) ;

            // if ans = mid is possible , store it and check for greater values
            if (isPossible(arr, k, mid))
            {
                ans = mid ;
                start = mid + 1 ;
            }
            // if ans = mid is not possible, check for smaller values
            else {
                end = mid - 1 ;
            }
        }

        return ans ;
    }

    static boolean isPossible(int arr[], int k, int ans)
    {
        int curr = 0 ;

        int partitions = 0 ;
        for (int i = 0 ; i < arr.length; i++)
        {
            curr += arr[i] ;
            if (curr >= ans) {
                partitions++ ;
                curr = 0 ;
            }
        }

        return partitions >= k ;

    }

    public static void main(String[] args)
    {
        int coins[] = {10,20,40,30} ;
        int k = 3 ;
        System.out.println(gameOfGreed(coins, k));

    }
}
