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
		// array before i - 1 pos has become a max heap. Now arr[i-1] has to be inserted in heap.
    
        	// Process of inserting element in maxHeap :
    		// 1) insert it last pos. 2) check the parent of that element(for the ith element parent = element at i/2)
   		// if parent is smaller, swap them. .. Keep repeating step 2 until we get parent > children or we reach at root
		
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
		
		// Delete the root .So now size of heap decreases and one remaining place is there. We place the deleted element there.

    		// Process of deleting from heap :
    		// 1) Delete the root.  2) Insert the last element of heap at root.  3) if root is smaller than any one of the children. 
		//    Swap the elements from parent and children
    		// keep repeating step 2 until we get parent > children or we reach at last of the heap

		
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
