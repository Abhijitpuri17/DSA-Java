public class FermatsTheorem
{

    // pow(a , p) is congruent to a%p
    // pow(a , p-2) is congruent to (1/a)%p

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

    public static void main(String[] args)
    {
        System.out.println(divide(30,5, 4 ));
    }

}
