package graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath
{

    static int[] shortestDist(GraphL g, int src)
    {

        int[] dist = new int[g.vertices+1] ;

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0 ;

        Queue<Integer> q = new LinkedList<>() ;
        q.add(src) ;

        while (!q.isEmpty())
        {
            int curr = q.poll() ;

            for (int x: g.adjList.get(curr))
            {
                if (dist[curr] + 1 < dist[x]){
                    dist[x] = dist[curr]+1;
                    q.add(x) ;
                }
            }
        }

        return dist ;

    }


    public static void main(String[] args) {

        GraphL g = new GraphL(6) ;
        g.addEdge(1,2,false);
        g.addEdge(1,6,false);

        g.addEdge(3,2,false);
        g.addEdge(2,4,false);

        g.addEdge(3,5,false);
        g.addEdge(5,6,false);

        int[] dist = shortestDist(g, 1) ;
        for (int i = 1 ; i <= g.vertices; i++){
            System.out.println(dist[i]);
        }

    }

}
