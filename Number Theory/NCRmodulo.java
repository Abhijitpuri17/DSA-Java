public class NCRmodulo
{

    static int fact(int n, int M)
    {
        int res = 1 ;

        for (int i = 1 ; i <= n ; i++) {
            res = (res % M * i % M) % M;
        }

        return res ;
    }

    static int fastpower(int a, int b, int M)
    {
        int res = 1 ;
        while (b > 0)
        {
            if ((b&1) != 0) res = (res%M * a%M)%M ;
            a = (a%M * a%M)%M ;
            b >>= 1 ;
        }
        return res ;
    }

    static int multiply(int a, int b, int mod)
    {
        int ans = (a%mod * b%mod)%mod ;
        return ans ;
    }

    static int divide(int a, int b, int M)
    {
        int ans = multiply(a, fastpower(b, M-2, M), M) ;
        return ans ;
    }

    static int ncr(int n, int r, int M)
    {
        int denominator = multiply(fact(r, M), fact(n-r, M), M) ;

        int numerator = fact(n, M) ;

        int ans = divide(numerator, denominator, M) ;

        return ans ;

    }

    public static void main(String[] args)
    {
        System.out.println(ncr(8,6, 11));
    }

}
