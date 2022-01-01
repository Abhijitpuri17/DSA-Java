package dynamic_programming.oneD;

public class MultistageGraph 
{
	static final Long I = Long.MAX_VALUE;
	
	static long graph[][] = {
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 2, 1, 3, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 2, 3, 0, 0},
			{0, 0, 0, 0, 0, 6, 7, 0, 0},
			{0, 0, 0, 0, 0, 6, 8, 9, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 6},
			{0, 0, 0, 0, 0, 0, 0, 0, 4},
			{0, 0, 0, 0, 0, 0, 0, 0, 5},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},};
	
	static long cost[] = new long[9] ;
	static long path[] = new long[9] ;
	
	
	public static void main(String[] args) 
	{
		int n = 8 ;
		
		for (int i = n-1 ; i >= 1 ; i--)
		{
			long min = I ;
			for (int j = i+1 ; j <= n ; j++)
			{
				if (graph[i][j] != 0 && graph[i][j] + cost[j] < min)
				{
					min = graph[i][j] + cost[j] ;
					path[i] = j ;
				}
			}
			cost[i] = min ;
		}
		
		System.out.println("Minimum costs to rach from 1 to n : " + cost[1]);
		System.out.print("Path: ");
	    long i = 1 ;
		while (i < n)
		{
			
			System.out.print(i + " ");
			i = path[(int)i] ;
		}
		System.out.println(n);
		
		

	}

}
