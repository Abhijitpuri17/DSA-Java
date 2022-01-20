public class ModuloArithmetic
{

    static int add(int a, int b, int mod)
    {
        int ans = (a%mod + b%mod)%mod ;
        return ans ;
    }

    static int multiply(int a, int b, int mod)
    {
        int ans = (a%mod * b%mod)%mod ;
        return ans ;
    }

    static int subtract(int a, int b, int mod)
    {
        int ans = (a%mod - b%mod)%mod ;

        if (ans < 0) ans = (ans + mod)%mod ;

        return ans ;
    }


    public static void main(String[] args)
    {

        System.out.println(add(5,5,3));

        System.out.println(multiply(5,3,3));

        System.out.println(subtract(-5,3,3));

    }

}
