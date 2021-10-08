package sorting.quickSort;

public class QuickSort 
{

	
	public static void main(String[] args) 
	{
		int arr[] = {10,2,3,4,5,1,100,50,24} ; //{10,1,2,3,42,100,4,2,3};
			quickSort(arr, 0, arr.length-1) ;
			for (int i = 0  ; i  < arr.length ; i++) System.out.print(arr[i] + " ") ;
	}
	

	public static void quickSort(int arr[] , int start , int end)
	{
		if (start < end) 
		{
			int pivotIndex = partition(arr , start , end) ;
		
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
			while (arr[i] < pivot && i < end) i++ ;
			while (arr[j] > pivot && j > start) j-- ;
			if (i < j)
			swap(arr, i, j);
		} while (i < j) ;
		
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
