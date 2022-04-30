package array;

import java.util.HashSet;

public class LongestConsecutiveSubsequence 
{
	// find the max length of subsequence such that all the elements in subsequence are consecutive
	// 1,5,2,3,4 forms a consecutive elements band
	// 1,2,3,10 does not form
	
	static int longest_subsequence(int arr[])
	{
		
		HashSet<Integer> set = new HashSet<>();		
		int n = arr.length, ans = 0;
		
		 // add all elements to a hash-set
		for (int i = 0; i < n ; i++) set.add(arr[i]) ;
		
		for (int i = 0 ; i < n ; i++)
		{
			 // check if arr[i] can be start of a band(consecutive numbers)
			if (!set.contains(arr[i] - 1)) 
			{
				 // if arr[i] is start of band find its length
				int curr = arr[i] ;
				
				while (set.contains(curr)) 
					curr++ ;
				
                // if it is greater than maxTillNow update max
				ans = Math.max(curr - arr[i], ans) ;	
			}
		}
			
		return ans ;
	}
	
	
	public static void main(String[] args) 
	{
		 int arr[] = { 1, 9, 3, 10, 4, 20, 2 };
		 System.out.println("Length of longest consecutive subsequence : " + longest_subsequence(arr));
	}

}
