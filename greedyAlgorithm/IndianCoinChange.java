import java.util.Arrays;

public class IndianCoinChange
{

    // 1, 2, 5, 10, 20, 50, 200, 500, 2000
    // find minimum number of coins for given amount

    static int minCoins(int amount, int coins[])
    {
        Arrays.sort(coins);

        int ans = 0 ;

        for (int i = coins.length - 1; i >= 0 ; i--)
        {
            ans += amount / coins[i] ;

            amount -= coins[i] * (amount / coins[i]) ;
        }

        return ans ;

    }



    public static void main(String[] args)
    {

        int coins[] = {1, 2, 5, 10, 20, 100, 200, 500, 1000, 2000} ;

        System.out.println(minCoins(8, coins));

    }

}
