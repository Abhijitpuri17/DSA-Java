public class BigMultiply
{

    public static void main(String[] args)
    {
        System.out.println(fact(20));
    }

    static String fact(int n)
    {
        String ans = "1" ;
        for (int i = 1 ; i <= n ; i++){
            ans = bigMultiply(ans, i) ;
        }
        return ans ;
    }

    static String bigMultiply(String a, int b)
    {
        StringBuilder ans = new StringBuilder("") ;

        int i = a.length() - 1 ;
        int carry = 0 ;

        while (i >= 0)
        {
            int curr = a.charAt(i) - '0';

            curr *= b ;

            curr += carry ;
            ans.append(curr%10) ;

            carry = curr/10 ;

            i-- ;
        }

        ans.reverse() ;

        String ansString = ans.toString() ;
        if (carry > 0){
            ansString = carry + ansString ;
        }

        return ansString ;
    }
}
