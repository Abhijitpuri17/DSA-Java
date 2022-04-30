package binarySearch;

import java.util.Arrays;

public class MinPairs 
{
	
	/**
	 * Given two arrays. Select two elements, one from each array such that
	 * absolute difference is minimum
	 */
	
	static int lower_bound(int arr[], int key)
	{
		int s = 0, e = arr.length - 1 ;
		while(s < e)
		{
			int mid = (s+e)/2 ;
			if (arr[mid] < key) s = mid+1 ;
			else e = mid ;
		}
		
		if (arr[s] >= key) return s ;
		
		return arr.length ;			
    }
	
	static void minPairs(int a[], int b[])
	{
		// sort the second array
		Arrays.sort(b);
		int min = Integer.MAX_VALUE, p = -1 , q = -1 ;
		

	  // loop through first array. Find lower_bound for that element in second array  (lower_bound = pos of nearest element in sorted arr such that 
	  // element at pos is greater than or equal to given key )
		for (int i = 0 ; i < a.length ; i++)
		{
			int lb = lower_bound(b, a[i]) ;
			
			// check diff between key and upper bound and update ans accordingly
			if ( lb-1 >= 0 && a[i] - b[lb-1] < min) {
				min = a[i] - b[lb-1] ;
				p = a[i] ;
				q = b[lb - 1] ;
			}
			
			// now check diff between key and lower bound and update ans accordingly
			if ( lb < b.length && b[lb] - a[i] < min){
				min = b[lb] - a[i] ;
				p = b[lb] ;
				q = a[i] ;
			}	
		}
		
		System.out.println(p + " " + q);
	}
	
	public static void main(String[] args) 
	{
	   int arr[] = {1, 10, 15, 17, 25, 28} ;
	   int brr[] = {-1, -1, -1} ;   // 
	   minPairs(arr, brr);
	}

}
