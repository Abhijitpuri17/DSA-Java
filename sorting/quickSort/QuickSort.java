package sorting.quickSort;

public class QuickSort 
{

	
	public static void main(String[] args) 
	{
		int arr[] = {10,2,3,4,5,1,100,50,24} ;
			quickSort(arr, 0, arr.length-1) ;
			for (int i = 0  ; i  < arr.length ; i++) System.out.print(arr[i] + " ") ;
	}
	

	public static void quickSort(int arr[] , int start , int end)
	{
		if (start < end) 
		{
			// taking first element as pivot, find its correct pos in array
			// i.e. place all smaller elements to left and larger to right
			int pivotIndex = partition(arr , start , end) ;
		
			// Now make recursive calls for left and right part
			quickSort(arr, start, pivotIndex-1) ;
			quickSort(arr, pivotIndex+1, end) ;
			
		}	
	}
	
	public static int partition(int arr[] , int start , int end)
	{
		int pivot = arr[start] ;
		int i = start+1 , j = end ;
		do
		{
			// find the element greater than pivot by moving i to right which was
			//initially pointing at s+1.
			while (arr[i] < pivot && i < end) i++ ;
			
			 //find the element smaller than pivot by j to left which initially pointing at last.
			while (arr[j] > pivot && j > start) j-- ;
			
			// Now swap them
			if (i < j)
			swap(arr, i, j);
		} while (i < j) ;
		
		// finally we found pos of pivot = j
		   // so swap the pivot with element at j
		swap(arr, start, j);
		return j ;
	}
	
	public static void swap(int arr[] , int i , int j)
    {
     	if (i == j) return ;
	                 
     	int temp = arr[i] ;
	    arr[i] = arr[j] ;
	    arr[j] = temp ; 
    }
	
}
