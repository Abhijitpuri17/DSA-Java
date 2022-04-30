package dynamic_programming.oneD;

public class Fibonacci 
{

	// 0 1 1 2 3 5 8 13 21 34
	static int fib(int n, int dp[])
	{
		// base cases
		if (n == 1 || n == 0) {
			return n ;
		}
		
		// if we already calculated some value directly return it
		if (dp[n] != 0) {
			return dp[n] ;
		}
	
		// store whenever calculate some value
		return dp[n] = fib(n-1, dp) + fib(n-2, dp) ; 
	}
	
	public static void main(String[] args) 
	{
		int f = 8 ;
		int dp[] = new int[8+1] ;

		System.out.println(fib(f, dp));
	}

}
