package array;

public class SubarraySort 
{
	/**
	 * find the length of smallest sub-array such that if we sort this sub-array, entire array
	 * will be sorted
	 */
	
	static boolean is_out_of_order(int[] arr, int i)
	{
		int x = arr[i] ;
		if (i == 0) return x > arr[1] ;
		
		if (i == arr.length - 1) return x < arr[arr.length-2] ;
		
		return x > arr[i+1] || x < arr[i-1] ;
	}
	
	static int[] min_length_subarray_sort(int arr[])
	{
		int n = arr.length;
		
		// first we find the smallest and largest element which are out of order
		
		int smallest = Integer.MAX_VALUE , largest = Integer.MIN_VALUE ;
		
		for (int i = 1 ; i < n-1 ; i++)
		{
			if (is_out_of_order(arr, i))
			{
				if (arr[i] < smallest) smallest = arr[i] ;
				if (arr[i] > largest) largest = arr[i] ;
			}
		}
		
		if (smallest == Integer.MAX_VALUE) return new int[] {-1, -1} ;
		
		int smallest_ind = 0, largest_ind = n-1 ;
		
		 // find the position where that smallest element should be present
		while (smallest_ind < n) {
			if (arr[smallest_ind] <= smallest) smallest_ind++ ;
			else break ;
		}
		
	    // find the position where that largest element should be present
		while (largest_ind >= 0) {
			if (arr[largest_ind] >= largest) largest_ind-- ;
			else break ;
		}
		
		
		return new int[]{smallest_ind, largest_ind} ;
		
	}
	

	public static void main(String[] args) 
	{
		int arr[] = {1, 2, 3, 4, 5, 8, 6, 7, 9, 10, 11} ;
		int ans[] = min_length_subarray_sort(arr);
		
		for (int x : ans) System.out.print(x + " ");

	}

}
