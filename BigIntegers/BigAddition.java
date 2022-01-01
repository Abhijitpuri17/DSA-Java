public class BigAddition
{

    public static void main(String[] args)
    {

    }


    static String bigAdd(String a, String b)
    {
        StringBuilder ans = new StringBuilder("") ;

        int i = a.length()-1;
        int j = b.length() - 1 ;
        int carry = 0 ;

        while (i >=0 || j >= 0)
        {
            int x ;
            if (i >=0) x = a.charAt(i) - '0' ;
            else x = 0 ;
            int y;
            if (j >=0) y = b.charAt(j) - '0' ;
            else y = 0 ;
            int sum = x + y + carry ;
            ans.append(sum%10) ;
            carry = sum/10 ;
            i--; j-- ;
        }

        if (carry > 0){
            ans.append(carry) ;
        }

        ans.reverse() ;

        return ans.toString() ;
    }

}
