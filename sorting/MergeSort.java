package sorting;


public class MergeSort 
{

	public static void main(String[] args) 
	{
		int arr[] = {10,1,2,3,42,100,4,2,3};
		
		mergeSort(arr, 0, arr.length) ;                   // start = 0 and end = lastPos + 1
		
		for (int i = 0 ; i < arr.length ; i++)
		System.out.print(arr[i] + " ") ;
	}
	
	static void mergeSort(int arr[] , int start , int end)
	{
		if (end - start < 2) return ;               // only 1 element
		
		int mid = (start+end)/2 ;                  
		
		mergeSort(arr, start, mid);
		mergeSort(arr, mid, end);
		merge(arr, start,mid , end);
	}
	
	static void merge(int arr[] , int start , int mid , int end)
	{
		if (arr[mid-1] < arr[mid]) return ;
		
		int i = start ;
		int j = mid ;
		int tempIndex =0 ;
		int temp[] = new int[end-start] ;
		while (i < mid && j < end)
		{
			temp[tempIndex++] = arr[i] <= arr[j] ? arr[i++] : arr[j++] ;
		}
		
		System.arraycopy(arr, i, arr, start+tempIndex, mid-i) ;
		System.arraycopy(temp, 0, arr, start, tempIndex) ;
	}

}
