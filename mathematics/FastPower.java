package mathematics;

public class FastPower 
{
	static final int mod = 1000000007 ;
	
	/**
	 * fast power with modulo
	 */
	static long fastpower(long a, long b, int mod)
	{
		long ans = 1 ;
		while (b > 0)
		{
			if ((b & 1) != 0) ans = (ans * a % mod) % mod ;
			a = (a % mod * a % mod) % mod ;
			b >>= 1 ;
		}
		return ans ;
	}
	
	/**
	 * fastPower without modulo
	 */
	static long fastpower(long a, long b)
	{
		long ans = 1 ;
		while (b > 0)
		{
			if ((b & 1) != 0) ans *= a ;
			a *= a  ;
			b >>= 1 ;
		}
		return ans ;
	}

	public static void main(String[] args) 
	{
	 System.out.println(fastpower(10, 10, mod));
	}

}
