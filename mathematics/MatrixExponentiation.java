public class MatrixExponentiation
{

    static int mod = 1000000007 ;
    static class Mat
    {
        int m[][] ;
        int size = 0 ;

        Mat(int size)
        {
            this.size = size ;
            m  = new int[size][size] ;
        }

        void identity()
        {
            for (int i = 0 ; i < size ; i++) m[i][i] = 1 ;
        }

        Mat multiply(Mat b)
        {
            Mat res = new Mat(size);

            for (int i = 0; i < size ; i++)
            {
                for (int j = 0 ; j < size ; j++) {
                    for (int k = 0; k < size; k++) {
                        res.m[i][j] += m[i][k] % mod * b.m[k][j] % mod;
                        res.m[i][j] %= mod;
                    }
                }
            }
            return res ;
        }

    }

    static int fib(int n)
    {
        Mat res = new Mat(2);
        res.identity();

        Mat T = new Mat(2) ;
        T.m[0][0] = T.m[0][1] = T.m[1][0] = 1 ;
        T.m[1][1] = 0 ;

        if (n < 2) return n ;

        n -= 2 ;
        while (n > 0)
        {
            if ((n&1)!=0) res = res.multiply(T) ;

            T = T.multiply(T) ;

            n >>= 1 ;
        }

        int ans = (res.m[0][0]%mod + res.m[0][1]%mod )%mod ;

        return ans ;

    }

    public static void main(String[] args)
    {
        for (int  i = 1 ; i <= 10 ; i++) System.out.println(fib(i));
    }
}
