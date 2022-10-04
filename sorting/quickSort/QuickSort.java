package sorting.quickSort;

public class QuickSort 
{

	
	public static void main(String[] args) 
	{
		int arr[] = {10,2,3,4,5,1,100,50,24} ;
		quickSort(arr, 0, arr.length-1) ;
		
		for (int i = 0  ; i  < arr.length ; i++) 
			System.out.print(arr[i] + " ") ;
	}
	
	static void quickSort(int arr[], int low, int high)
	{
		if(low >= high)
		    return ;

		int pivotIndex = partition(arr, low, high) ;
		quickSort(arr, low, pivotIndex-1) ;
		quickSort(arr, pivotIndex+1, high) ;
    	}
	
	static int partition(int arr[], int low, int high)
	{
		int pivot = arr[high];
		int idx = low;

		for(int i = low; i <= high; i++)
		    if(arr[i] < pivot)
			swap(arr, idx++, i);

		swap(arr, idx, high);

		return idx;
	 } 
    
	static void swap(int[] arr, int i, int j)
	{
		int temp = arr[i] ;
		arr[i] = arr[j] ;
		arr[j] = temp ;
	}
	
}
