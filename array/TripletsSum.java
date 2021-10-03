package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletsSum 
{
	
	/**
	 * From given array arr, find all the triplets such that their sum = target
	 */

	static List<Integer[]> triplet_sum(int arr[], int target)
	{
		List<Integer[]> ans = new ArrayList<>();
		
		Arrays.sort(arr);
		int n = arr.length;
		
		for (int i = 0 ; i < n-2 ; i++)
		{
			int j = i + 1 , k = n-1 ; 
			
			
			while (j < k)
			{
				int curr_sum = arr[i] + arr[j] + arr[k] ;
				
				 if (curr_sum == target) 
				{
					ans.add(new Integer[] {arr[i], arr[j], arr[k]}) ;
					j++ ;
					k-- ;
				} 
				 else if (curr_sum < target) j++ ;
				 else k-- ;
			}	
		}

		return ans ;	
	}
	
	
	public static void main(String[] args) 
	{
	     int arr[] = {3, 4, 5, 1, 2, 15, 8, 9, 6, 7} ;
	     int target = 18 ;
	     List<Integer[]> ans = triplet_sum(arr, target) ;

	     for (Integer[] a : ans) {
	    	 for (int i = 0 ; i < a.length ; i++) System.out.print(a[i] + " ");
	    	 System.out.println();
	     }
	     
	     
	}

}
