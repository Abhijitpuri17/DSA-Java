package sorting.quickSort;

public class QuickSelect 
{
	/**
	 * Find kth smallest element in the given array
	 */

	static int quick_select(int arr[], int s, int e, int k)
	{
		
		int pivot_ind = partition(arr, s, e) ;
		if (pivot_ind == k) return arr[k]  ;
		
		if (pivot_ind > k) 
			return quick_select(arr, s, pivot_ind-1, k) ;
		
		return quick_select(arr, pivot_ind+1, e, k) ;
	}
	
	static int partition(int arr[], int s, int e)
	{
		
		int pivot = arr[s] ;
		int i = s + 1 , j = e ;
		
		do
		{
			while (arr[i] < pivot && i < e) i++ ;
			
			while (arr[j] > pivot && j > s) j-- ;
			
			if (i < j)
				swap(arr, i , j) ;	
		} while (i < j);
		
		swap(arr, s, j);
		
		return j ;
		
	}
	
	
	public static void swap(int arr[] , int i , int j)
    {
     	if (i == j) return ;
	                 
     	int temp = arr[i] ;
	    arr[i] = arr[j] ;
	    arr[j] = temp ; 
    }
	
	
	public static void main(String[] args) 
	{
	
		int arr[] = {10, 1, 5, 2, 48, 4, 50, 100, 900, 254} ;
		System.out.println(quick_select(arr, 0, arr.length-1, 1));
	}

}
