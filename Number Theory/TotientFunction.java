import java.util.ArrayList;
import java.util.List;

public class TotientFunction
{
    // Totient(i) = number of co-primes in 1 to i with i

    static List<Integer> seive(int n)
    {
        int arr[] = new int[n+1] ;

        for (int i = 2 ; i <= Math.sqrt(n); i++)
        {
            if (arr[i] != 0) continue;
            for (int j = i*i ; j <= n ; j += i)
            {
                arr[j] = i ;
            }
        }

        List<Integer> primes = new ArrayList<>() ;

        for (int i = 2 ; i <= n ; i++)
        {
            if (arr[i] == 0) primes.add(i) ;
        }

        return primes ;
    }

    static int[] totient(int n)
    {
        int tot[] = new int[n+1] ;
        List<Integer> primes = seive(n) ;

        for (int i = 1 ; i <= n ; i++) {
            float ans = i * 1.0f;
            for (int x : primes) {
                if (x > i) break;
                if (i%x == 0)
                ans *= (1.0 - (1.0 /(float)x));
            }
            tot[i] = (int)ans ;
        }
        return tot ;
    }

    public static void main(String[] args)
    {
        int tot[] = totient(100) ;
        for (int i = 1 ; i <= 100 ; i++)
        {
            System.out.println(i + " " + tot[i]);
        }
    }



}
