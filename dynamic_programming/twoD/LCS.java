package dynamic_programming.twoD;

public class LCS
{
	// finding length of longest common subsequence
	// in given 2 strings
	static int lcs(String a, String b)
	{
		
		int n1 = a.length(), n2 = b.length();
		
		int dp[][] = new int[n1+1][n2+1] ;
		String ans = "" ;
		
		for (int i = 1 ; i <= n1; i++)
		{
			for (int j = 1 ; j <= n2; j++)
			{
				if (a.charAt(i-1) == b.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1 ;
					ans += a.charAt(i-1) ;
				}
				else {
					 int op1 = dp[i-1][j] ;
					 int op2 = dp[i][j-1] ;
					 
					 dp[i][j] = Math.max(op1, op2) ;
				}
			}
		}
		
		System.out.println(ans);
		return dp[n1][n2] ;
	}

	public static void main(String[] args) 
	{
		String a = "ABCD" ;
		String b = "ABEDG" ;
		
		System.out.println(lcs(a, b));

	}

}
