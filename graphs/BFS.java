package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS 
{

	public static void main(String[] args) 
	{
		/**
		 *  graph[i][0] = value of node at ith pos
		 *  other graph[i][j] represent to which element is ith node connected to
		*/
		int graph[][] = {
				{0, 0, 0, 0, 0, 0, 0, 0},
				{10, 0, 1, 1, 1, 0, 0, 0},
				{20, 1, 0, 1, 0, 0, 0, 0},
				{30, 1, 1, 0, 1, 1, 0, 0},
				{40, 1, 0, 1, 0, 1, 0, 0},
				{50, 0, 0, 1, 1, 0, 1, 1},
				{60, 0, 0, 0, 0, 1, 0, 0},
				{70, 0, 0, 0, 0, 1, 0, 0},
			} ;

		bfs(graph, 7);
		
	}
	
	static void bfs(int graph[][], int i)
	{
		boolean visited[] = new boolean[graph.length] ;
		Queue<Integer> q = new LinkedList<>();
		
		System.out.print(graph[i][0]+ " ");
		visited[i] = true ;
		q.add(i) ;
		
		while(!q.isEmpty())
		{
			int u = q.poll();
			for (int v = 1 ; v < graph.length ; v++)
			{
				if(graph[u][v] == 1 && !visited[v]) {
					System.out.print(graph[v][0] + " ");
					visited[v] = true ;
					q.add(v) ;
				}
			}
			System.out.println();
		}
		
	}

}
