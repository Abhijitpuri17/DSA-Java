package array;

import java.util.HashSet;

public class LongestConsecutiveSubsequence 
{
	
	static int longest_subsequence(int arr[])
	{
		
		HashSet<Integer> set = new HashSet<>();
		int n = arr.length, ans = 0;
		for (int i = 0; i < n ; i++) set.add(arr[i]) ;
		
		for (int i = 0 ; i < n ; i++)
		{
			if (!set.contains(arr[i] - 1)) 
			{
				int curr = arr[i] ;
				
				while (set.contains(curr)) 
					curr++ ;
				
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
