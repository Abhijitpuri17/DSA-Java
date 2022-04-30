package slidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MaxInWindow 
{
	
	/**
	 *  An array is given. For each position in array find max element in subarray of
	 *  size k starting from that position.
	 *  
	 *  Eg. :
	 *  
	 *  arr = 1 2 3 1 4 5 2 3 6 , k = 3
	 *  
	 *  ans = 3 3 4 5 5 5 6
	 *  
	 */

	static List<Integer> maxInWindow(int arr[], int k)
	{
		
		Deque<Integer> dq = new ArrayDeque<>();
		List<Integer> ans = new ArrayList<>();
		int n = arr.length;
		
		// first do the process for first k elements
		for (int i = 0 ; i < k ; i++)
		{
			// if element added before is less than current element, it is of no use
			// we remove them
			while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) dq.pollLast();
			
			// we are storing the positions of the elements so that we can easily check
			// if element can be present in current window or we have to remove it
			dq.offerLast(i) ;	
		}
		// first element in dq is max till now
		ans.add(arr[dq.getFirst()]) ;
		
		
		// now do the process for remaining all the windows
		for (int i = k ; i < n ; i++)
		{
			// remove all the elements which are out of range for current window
			while (!dq.isEmpty() && dq.peekFirst() <= i - k) dq.pollFirst();
			
			// remove if any smaller elements than current element are present in dq 
			while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) dq.pollLast();
			
			// add current element in dq
			dq.offerLast(i) ;
			
			// first element in dq is answer for current window
			ans.add(arr[dq.getFirst()]) ;
		}
		
		return ans ;
	}
	
	
	
	public static void main(String[] args) 
	{
	 int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
	 int k = 3 ;
	 List<Integer> ans = maxInWindow(arr, k) ;
	 
	 for (int x : ans) System.out.print(x + " ");
		
	}

}
