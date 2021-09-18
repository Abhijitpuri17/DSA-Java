package array;

public class WaterTrapping 
{
	/**
	 * Given an array representing height of block at that position.
	 * Find how much water (one unit is equivalent to one block) is trapped.
	 */
	
	static int trappedWater(int heights[])
	{
		int i = 0 , j = heights.length - 1, l_max = 0, r_max = 0 ;
		int water = 0 ;
		while (i <= j)
		{
			if (heights[i] < heights[j]) 
			{
				if (heights[i] > l_max) l_max = heights[i] ;
				else water += l_max - heights[i] ;
				i++ ;
			} 
			else 
			{
				if (heights[j] > r_max) r_max = heights[j] ;
				else water += r_max - heights[j]  ;
				j-- ;
			}
		}
		return water ;
	}

	public static void main(String[] args) 
	{
		int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1} ;
		System.out.println(trappedWater(arr));
	}

}
