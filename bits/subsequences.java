Public class Test
{
  
    static void subSequences(String s)
    {

        int perms = (1 << s.length()) - 1 ;

        for (int i = 0 ; i <= perms ; i++)
        {
            int curr = i ;

            StringBuilder ans = new StringBuilder("") ;

            int j = 0 ;
            while (curr > 0)
            {
                if ((curr&1) != 0)
                {
                    ans.append(s.charAt(j++)) ;
                } else j++ ;

                curr >>= 1 ;
            }
            System.out.println(ans);
        }
    }
  

  public static void main(String[] args)
    {
        String s = "abc" ;
        subsequences(s) ;
    }
}
