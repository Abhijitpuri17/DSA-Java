package recursion;

public class Taylor_series_e_raise_to_x 
{
	static double p ;
	
	/**
	 * e^x = 1 + x + x^2/2! + x^3/3! + x^4/4! + ....
	 */
	static double taylor_e(int x, int n)
	{
		p = 1 ;
		return taylor_e_(x, n) ;
	}
	
	static double taylor_e_(int x, int n)
	{
		if (n == 0) return 1 ;
		double r = taylor_e_(x, n-1) ;
		p *= (double)x/n ;
		return r + p ;
	}
	
	
	/**
	 * e^x = 1 + x{1 + x/2{1 + x/3{1 + x/4{....}}}}
	 */
	static double horner_e(int x, int n)
	{
		p = 1 ;
		return horner_e_(x, n);
	}
	
	static double horner_e_(int x , int n)
	{
		if (n == 0) return p ;
		p = 1 + p*x/n;
		return horner_e_(x, n-1) ;
	}

	
	public static void main(String[] args) 
	{
		System.out.println(taylor_e(3, 100));
		System.out.println(taylor_e(1, 10));
		System.out.println(horner_e(3, 100));
		System.out.println(horner_e(1, 10));
	}
}
