public class Brackets
{
    // given an integer -n . Find all valid n permutations of brackets
    // Eg. ()()(), ((())), ()(())

    static void brackets(int n, int open, int close, StringBuilder sb)
    {

        // base case. Print bracket permutation
        if (open == close && open == n)
        {
            System.out.println(sb);
            return;
        }

        // we can add ( only if number previously add ( is less than n
        if (open < n){
            sb.append("(") ;
            brackets(n, open+1, close, sb);
            sb.deleteCharAt(sb.length()-1) ;
        }

        // we can not close a bracket without an opening bracket
        if (close < open){
            sb.append(")") ;
            brackets(n, open, close+1, sb);
            sb.deleteCharAt(sb.length()-1) ;
        }

    }


    public static void main(String[] args)
    {
      brackets(3,0,0,new StringBuilder(""));
    }
}
