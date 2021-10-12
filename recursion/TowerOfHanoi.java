package recursion;

public class TowerOfHanoi 
{
	/**
	 * There are 3 towers. First tower has n discs where sizes decrease from bottom to top
	 * We have to transfer all discs to third tower.
	 * 1) At a time only one disc can be moved
	 * 2) larger disc can not be placed on smaller disc
	 */
	static void toh(int n, int source, int helper, int destination)
	{
		if (n > 0)
		{
			// transfer n-1 disks from source to helper using recursion
			toh(n-1, source, destination, helper);
			
			// transfer largest disk from source to destination
			System.out.println(source + " --> "+ destination);
			
			// transfer these n-1 disks from helper to destination using recursion
			toh(n-1, helper,source, destination);
		}
		
	}
	
	public static void main(String[] args) 
	{
		toh(3, 1, 2, 3) ;
	}

}
