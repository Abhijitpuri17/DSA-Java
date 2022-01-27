import java.util.Arrays;

public class NQueens
{

    // place n queens on nxn chase-board such that no queen kills any other queen


    // function to check whether we can place queen at pos (i, j)
    static boolean canPlace(char board[][], int i, int j, int n)
    {

        for (int k = 0 ; k < n ; k++)
        {
            if (board[i][k] == 'Q') return false ;
        }

        for (int k = 0 ; k <  n ; k++)
        {
            if (board[k][j] == 'Q') return false ;
        }

        for (int k = i , l = j ; k >= 0 && l >= 0 ; k--, l--)
        {
            if (board[k][l] == 'Q') return false ;
        }


        for (int k = i , l = j ; k >= 0 && l < n ; k--, l++)
        {
            if (board[k][l] == 'Q') return false ;
        }


        return true ;

    }


    static boolean nQueen(int n, char board[][], int i)
    {

        // base case. Print board
        if (i == n)
        {
            for (int k = 0 ; k < n ; k++)
            {
                for (int l = 0 ;  l < n ; l++)
                {
                    System.out.print(board[k][l] + " ") ;
                }
                System.out.println() ;
            }

         return true;
        }

        boolean subProblem = false ;

        // for current row check for each column.
        // if we can place queen then place it
        // and check for further sub-problem
        // if sub-problem can be solved return true.

        // if for no column in current row, we get true
        // for sub-problem. Then return false
        // i.e. backtrack and make changes in prev row
        for (int j = 0 ; j < n ; j++)
        {
            if (canPlace(board, i, j, n)) {
                board[i][j] = 'Q';
                subProblem = nQueen(n, board, i + 1);
                if (subProblem) return true;
                else board[i][j] = '.';
            }
        }

        return false ;

    }

    public static void main(String[] args)
    {
        int n  = 6 ;
        char board[][] = new char[n][n] ;
        for (int i = 0 ; i < n ; i++)
        {
            for (int j  = 0 ; j < n ; j++)
            {
                board[i][j] = '.' ;
            }
        }

        nQueen(n, board, 0) ;
    }
}
