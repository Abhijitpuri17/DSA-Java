package binarySearch;

public class AngryBirds
{
	/**
	 *  There's a long wire. An array is given denoting positions of nests on this wire
	 *  
	 *  Also an integer b denoting number of birds is given. We have to place the birds 
	 *  such that distance between birds is as big as possible.
	 *  
	 *  After optimally placing the birds , find the smallest distance between any two birds
	 *  
	 */

	static boolean canPlaceBirds(int nests[], int d, int b)
	{
		int birds = 1 ;
		int last_loc = nests[0] ;
		
		for (int i = 1 ; i < nests.length; i++)
		{
			int curr_loc = nests[i] ;
			if (curr_loc-last_loc >= d) {
				birds++;
				last_loc = curr_loc;
			}
			
			if (birds == b) return true ;
		}
		
		return false ;
	}
	
	static int angryBirds(int nests[], int b)
	{
		int n = nests.length;
		int s = 0 , e = nests[n-1], ans = 0 ;
		
		while (s <= e)
		{
			int mid  = (s+e)/2 ;
			if (canPlaceBirds(nests, mid, b))
			{
				ans = mid ;
				s = mid + 1;
			}
			else e = mid - 1 ;
		}
		return ans ;
	}
	
	public static void main(String[] args) 
	{
		int nests[] = {1, 2, 4, 8, 9} ;
		int birds = 3 ;
		System.out.println(angryBirds(nests, birds));
	}

}
