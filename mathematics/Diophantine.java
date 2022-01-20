public class Diophantine
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

    static int[] diophantine(int a, int b, int c)
    {
        int res[] = extendedGcd(a, b) ;

        int gcd = res[0]*a + res[1]*b ;


        if (c%gcd != 0) {
            System.out.println("NO Integral answer: ");
            return new int[]{0,0} ;
        }

        int k = c/gcd ;

        int x = res[0]*k;
        int y = res[1]*k ;

        // x + (b/g)t,  y - (b/g)t are all solutions
        return new int[]{x, y} ;
    }


    public static void main(String[] args)
    {
       int a = 4, b = 6 , c = 5;

       int[] ans = diophantine(a, b, c) ;
       System.out.println(ans[0] + " " + ans[1]);
    }


}
