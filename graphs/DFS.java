package graphs;


public class DFS 
{
	static boolean visited[] ;

	public static void main(String[] args) 
	{
		int graph[][] = {
				{0, 0, 0, 0, 0, 0, 0},
				{10, 0, 1, 1, 0, 0, 0},
				{20, 1, 0, 0, 1, 0, 0},
				{30, 1, 0, 0, 1, 0, 0},
				{40, 0, 1, 1, 0, 1, 1},
				{50, 0, 0, 0, 1, 0, 0},
				{60, 0, 0, 0, 1, 0, 0},
			} ;
		visited = new boolean[graph.length];

		dfs(graph, 1);

	}
	
	static void dfs(int graph[][], int i)
	{
		if (visited[i] == false)
		{
			System.out.print(graph[i][0] + " ");
			visited[i] = true ;
			for (int j = 1 ; j < graph.length ; j++)
			{
				if(graph[i][j] == 1 && !visited[j])
				{
					dfs(graph, j);
				}
			}
		}	
	}

}
