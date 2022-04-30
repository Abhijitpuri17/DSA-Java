package dynamic_programming.oneD.maxNonAdjacentSum;

public class BottomUp 
{

	static int maxNonAdjacentSum(int arr[])
	{
		int n = arr.length;
		int prev2 = arr[0], prev = Math.max(arr[0], arr[1]) ;

		for (int i = 2 ; i < n ; i++)
		{
			int curr = Math.max(prev2 + arr[i], prev);

			prev2 = prev ;
			prev = curr ;

		}
		
		return prev ;
	}
	
	
	public static void main(String[] args) 
	{
		int arr[] = {6, 10, 12, 7, 9, 14} ;
		System.out.println(maxNonAdjacentSum(arr));

	}

}
