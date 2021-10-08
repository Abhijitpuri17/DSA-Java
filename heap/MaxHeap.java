package heap;

public class MaxHeap 
{
	/** Similar to binary tree where every descendant of a node is less or equal
	 * Array representation is used
	 * for node at i , children are at 2*i and 2*i + 1
	 * 
	 * MaxHeap can be used as priority queue
	 */
	
	
	// HEAP SORT //
	
	public static void main(String[] args) 
	{
		
		int arr[] = {10,5,1,2,3,4,50,25,30,15} ;
		
		// inserting each element makes this array a max heap
		for (int i = 1 ; i <= arr.length ; i++) insert(arr, i);
		
		for (int i = 0 ; i < arr.length ; i++) System.out.print(arr[i] + " ");
		System.out.println();
		
		// deleting element from root and inserting it last of heap. So finally arr is sorted
		for (int i = arr.length ; i >= 1 ; i--) delete(arr, i);
		
		for (int i = 0 ; i < arr.length ; i++) System.out.print(arr[i] + " ");	
	}
	
	// O(log n)
	static void insert(int arr[] , int i) 
	{
		int temp = arr[i-1] ;
				
		while (i > 1 && arr[i/2-1] < temp) 
		{
				arr[i-1] = arr[i/2-1] ;
				i = i/2 ;
	    }
		
		arr[i-1] = temp ;
	}
	
	// O(log n)
	static void delete(int arr[] , int n)
	{
		int temp = arr[0] ;
		int i = 1, j = 2*i ;
		arr[0] = arr[n-1] ;
		
		while (j < n) 
		{
			if (arr[j] > arr[j-1]) j++ ;
			if (arr[i-1] < arr[j-1]) 
			{
				int temp2 = arr[i-1] ;
				arr[i-1] = arr[j-1] ;
				arr[j-1]=temp2 ;
			}
			i = j ;
			j = 2*i ;
		}
		arr[n-1] = temp;
	}
	
	
}
