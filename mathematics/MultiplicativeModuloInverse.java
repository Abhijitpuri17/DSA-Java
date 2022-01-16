public class MultiplicativeModuloInverse
{

    static int[] extendedGcd(int a, int b)
    {

        if (b == 0)
        {
            return new int[]{1, 0} ;
        }

        int arr[] = extendedGcd(b, a%b) ;

        int x = arr[1] ;
        int y = arr[0] - (a/b)*(arr[1]) ;

        return new int[]{x, y} ;

    }


    static int mmi(int a, int m)
    {
        int[] res = extendedGcd(a, m) ;

        int gcd = a*res[0] + m*res[1] ;

        if (gcd != 1) {
            System.out.println("NO MMI");
            return -1 ;
        }

        int ans = res[0] ;

        ans = (ans%m + m)%m ;

        return ans ;

    }

    public static void main(String[] args)
    {
       int a = 7, b = 8 ;

       System.out.println(mmi(a, b));
    }


}
