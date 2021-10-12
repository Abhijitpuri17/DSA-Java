package sorting.mergeSort;


public class MergeSort 
{
	
	/**
	 * 
	 *  It is a divide and conquer algorithm.  (dividing is logical not physical)
	 *  
	 *  A single element array is always sorted.
	 * 
	 *  Keep dividing the arrays until we get single element arrays. Then start merging them back in sorted order 
	 * 
	 */


	

	public static void main(String[] args) 
	{
		int arr[] = {10,1,2,3,42,100,4,2,3};
		
		mergeSort(arr, 0, arr.length-1) ;               
		
		for (int i = 0 ; i < arr.length ; i++)
		System.out.print(arr[i] + " ") ;
	}
	
	static void mergeSort(int arr[] , int start , int end)
	{
		if (end <= start) return ;        
		
		int mid = (start+end)/2 ;                  
		
		mergeSort(arr, start, mid);
		mergeSort(arr, mid+1, end);
		merge(arr, start,mid+1 , end);
	}
	
	// This is function to merge two sorted arrays.
	static void merge(int arr[] , int start , int mid , int end)
	{
		int temp[] = new int[end-start+1] ;
		
		int i = start , j = mid , k = 0 ;
		
		while (i < mid && j <= end)
		{
			if (arr[i] < arr[j]) temp[k++] = arr[i++] ;
			else temp[k++] = arr[j++] ;
		}
		
		while (i < mid) temp[k++] = arr[i++] ;
		while(j <= end) temp[k++] = arr[j++] ;
		
		for (i = start ; i <= end ; i++) arr[i] = temp[i-start] ;
	}

}
