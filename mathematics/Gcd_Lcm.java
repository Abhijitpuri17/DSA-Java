package mathematics;

public class Gcd_Lcm 
{
	static int gcd(int a , int b)
	{
		while ((a % b) != 0)
		{
			int temp = a % b ;
			a  = b ;
			b = temp ;
		}
		return b ;
	}
	
	// gcd * lcm = a * b
	static int lcm(int a , int b)
	{
		int lcm = (a * b)/gcd(a, b) ;
		return lcm ;
	}

	public static void main(String[] args) 
	{
		System.out.println(gcd(36, 24));
		System.out.println(lcm(8, 12));
	}
}
