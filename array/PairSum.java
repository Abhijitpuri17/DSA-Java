package array;

import java.util.HashSet;



public class PairSum 
{
	
	/**
	 * From the given array arr print one pair of elements such that their sum = target
	 * if no such pair exists return 0, 0
	 */
	
	static int[] pair_sum(int arr[] , int target)
	{
		int ans[] = new int[2] ;
		
		HashSet<Integer> set = new HashSet<>() ;
		
		for (int i = 0 ; i < arr.length; i++)
		{
			// for each arr[i] we search for x = target-arr[i] in set. 
			// If present we got the answer
			int x = target - arr[i] ;
			
			if (set.contains(x)) 
			{
				ans[0] = arr[i] ;
				ans[1] = x;
				return ans ;
			}
			
	        // if x is not present in set. we add current element arr[i] in set and check for next element in arr
			set.add(arr[i]) ;
		}
		
		return ans ;
	}

	public static void main(String[] args) 
	{
		int arr[] = {10, 5, 2, 3, -6, 9, 11} ;
	    int ans[] = pair_sum(arr, 50) ;
	    print_arr(ans) ;
	}
	
	static void print_arr(int arr[])
	{
		for (int i = 0 ; i < arr.length ; i++)
		{
			System.out.print(arr[i] + " ");
		}
	}

}
