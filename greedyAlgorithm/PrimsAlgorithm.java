package graphs;

public class PrimsAlgorithm 
{
	
	// First selected minimum cost edge. Now mainting the connection with selected nodes, keep finding min edges
	
	
	
	static final long I = Long.MAX_VALUE;
	
	static long costs[][] = { 
			{I, I, I, I, I, I, I, I},
			{I, I, 25, I, I, I, 5, I},
			{I, 25, I, 12, I, I, I, 10},
			{I, I, 12, I, 8, I, I, I},
			{I, I, I, 8, I, 16, I, 24},
			{I, I, I, I, 16, I, 20, 18},
			{I, 5, I, I, I, 20, I, I},
			{I, I, 10, I, 24, 18, I, I}
			} ;
	
	// near array denotes min cost of edge connecting ith vertex with previously selected vertics
	static long near[] = {I, I, I, I, I, I, I, I};
	
	static long ans[][] = new long[2][6] ;
	
	

	public static void main(String[] args) 
	{
		int u = 0, v = 0, n = 8;
		long min = Long.MAX_VALUE;
		
		// fist find the minimum cost edge and add that edge to answer
		for (int i = 0 ; i < n ; i++)
		{
			for (int j = i ; j < n ; j++)
			{
				if (costs[i][j] < min) {
					min = costs[i][j] ;
					u = i ; v = j ;
				}
			}
		}
		
		ans[0][0] = u ; ans[1][0] = v ;
		near[u] = near[v] = 0 ;
		
		// For each vertex check which edge(with u or with v) has min cost
		for (int i = 1 ; i < n ; i++)
		{
			if (near[i] == 0) continue;
			if (costs[i][u] < costs[i][v]) near[i] = u ;
			else near[i] = v; 
		}
		
		
		int k = 0;
		
		// now repeat the process for remaining edges of spanning tree
		for (int i = 1 ; i < n-2 ; i++)
		{
			long min_curr = I ;
			
			// find min cost edge (but should have connection with previously selected edge)
			for (int j = 1 ; j < n ; j++)
			{
				if (near[j] != 0 && costs[j][(int) near[j]] < min_curr)
				{
					min_curr = costs[j][(int) near[j]];
					k = j ;
				}
			}
			
			
			ans[0][i] = k ; ans[1][i] = near[k] ;
			near[k] = 0 ;
			
			// update near array... i.e. for each vertex which edge has min cost (with previously selected only)
			for (int j = 1 ; j < n ; j++)
			{
				if (near[j] != 0 && costs[j][k] < costs[j][(int) near[j]])
				{
					near[j] = k ;
				}
			}
				
		}
		
		
		for (int j = 0 ; j < ans[0].length ; j++)
		{
			System.out.println(ans[0][j] + " " + ans[1][j]);
		}
		
		
		

	}

}
