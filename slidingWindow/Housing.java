package slidingWindow;

import java.util.ArrayList;
import java.util.List;

public class Housing 
{

	/*
	 * Along a side of a road there is sequence of vacant plots of lands. 
	 * Each plot has some non-zero area. a1, a2, a3, a4, ....
	 * 
	 * You want to buy K acres of land to build a house. So find all the 
	 * segments of contiguous plots whose sum of areas is k.
	 * 
	 */
	
	
	static List<Integer[]> housing(int plots[], int k)
	{
		List<Integer[]> ans = new ArrayList<>();
		int i = 0 , j = 0 ;
		int n = plots.length;
		int curr_sum = 0 ;
		
		while (j <= n && i <= j)
		{
			if (curr_sum < k && j < n) {
				curr_sum += plots[j++] ;
			} 
			else if (curr_sum == k) 
			{
				ans.add(new Integer[] {i, j-1}) ;
				if (j < n && i < n)
				curr_sum += plots[j] - plots[i] ;
				
				i++ ; j++ ;
			} 
			else if (i < j)
			{
				curr_sum -= plots[i] ;
				i++ ;
			}
		}
		
		return ans ;
	}
	
	
	public static void main(String[] args) 
	{
		int plots[] = {1, 3, 2, 1, 4, 1, 3, 2, 1, 1, 4};
		int k = 8 ;
		List<Integer[]> ans = housing(plots, k) ;
		
		for (Integer[] x : ans) System.out.println(x[0] + " " + x[1]);
		

	}

}
