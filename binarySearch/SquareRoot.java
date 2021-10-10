package binarySearch;

public class SquareRoot 
{
	static float square_root(int n, int p)
	{
		
		float ans = 0.0f ;
		int s = 0 , e = n ;
		
		// To get the integral part (using binary search)
		while (s <= e)
		{
			int mid = (s+e)/2 ;
			if (mid*mid == n) return mid ;
			
			if (mid*mid < n) {
				ans = mid ;
				s = mid + 1 ;
			}
			
			else e = mid - 1 ;
		}
		System.out.println(ans);
		// for getting decimal part we can perform linear search as p wont be that large
		float f_ans = 0.1f ;
		
		for (int i = 0 ; i < p ; i++)
		{
			while (ans*ans < n) ans += f_ans ;
			
			ans -= f_ans;
			
			f_ans = f_ans/10 ;
		}
		
		return ans ;
	}

	public static void main(String[] args) 
	{
		System.out.println(square_root(10, 3));

	}

}
