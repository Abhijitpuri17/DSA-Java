public class StringPerm
{
    static void perm(StringBuilder sb, int i)
    {

        // base case . Print string
        if (i == sb.length()){
            System.out.println(sb);
            return;
        }

        // swap char at i with all the chars at right and
        // call recursive call for next part of string
        for (int j = i ; j < sb.length(); j++)
        {
            swap(sb, i, j);
            perm(sb, i+1);
            // backtracking
            swap(sb, i, j);
        }
    }

    static void swap(StringBuilder sb, int i, int j)
    {
        char temp = sb.charAt(i) ;
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
    }

    public static void main(String[] args) {
        String s = "abc" ;

        perm(new StringBuilder(s), 0);
    }


}
