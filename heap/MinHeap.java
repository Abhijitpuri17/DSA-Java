package heap;

public class MinHeap 
{

	public static void main(String[] args) 
	{
	
        int arr[] = {4, 5, 6, 7, 8, 9, 2, 1, 3} ;
		
		// inserting each element makes this array a min heap
		for (int i = 1 ; i <= arr.length ; i++) insert(arr, i);
		
		for (int i = 0 ; i < arr.length ; i++) System.out.print(arr[i] + " ");
		System.out.println();
		
		// deleting element from root and inserting it last of heap.
		//So finally arr is sorted in reverse order
		for (int i = arr.length ; i >= 1 ; i--) delete(arr, i);
		
		for (int i = 0 ; i < arr.length ; i++) System.out.print(arr[i] + " ");	

	}
	
	static void insert(int arr[], int i)
	{
		int temp = arr[i - 1] ;
		while (i > 1 && arr[i/2] > temp)
		{
			arr[i-1] = arr[i/2 - 1] ;
			i = i/2 ;
		}
		arr[i-1] = temp ;
	}
	
	static void delete(int arr[], int n)
	{
		int temp = arr[0] ;
		arr[0] = arr[n-1] ;
		int i = 1 ; 
		int j = 2*i ;
		
		while (j < n)
		{
			if (arr[j] < arr[j-1]) j++ ;
			if (arr[i-1] > arr[j-1]) 
			{
				int curr = arr[i-1] ;
				arr[i-1] = arr[j-1] ;
				arr[j-1] = curr ;
			}
			i = j ;
			j = 2*i ;
		}
		
		arr[n - 1] = temp ;
			
	}

}
