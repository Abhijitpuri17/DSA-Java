package graphs.cycleDetection;

import java.util.ArrayList;

public class DFS
{

    static boolean dfs(GraphL g, int i, int parent, boolean[] visited){
        visited[i] = true ;
        for (int x: g.adjList.get(i)){
            if (!visited[x]) {
                boolean isCycle = dfs(g, x, i, visited) ;
                if (isCycle) return true ;
            } else if (x != parent) return true ;
        }
        return false ;
    }

    static boolean cycle(GraphL g){
        boolean[] visited = new boolean[g.vertices + 1] ;
        for (int i = 1 ; i <= g.vertices ; i++)
        {
            if (!visited[i])
            {
                boolean isCycle = dfs(g, i, -1, visited) ;
                if (isCycle) return true ;
            }
        }
        return false ;
    }


    public static void main(String[] args)
    {
        GraphL g = new GraphL(8) ;

        g.addEdge(1,2, false);
        g.addEdge(2,3, false);
        g.addEdge(2,5, false);
        g.addEdge(3,4, false);
        //g.addEdge(4, 5, false);
        g.addEdge(6,7, false);
        g.addEdge(7,8,false);
        //g.addEdge(6,8,false);

        System.out.println(cycle(g));

    }


    static class GraphL{
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>() ;
        int vertices = 0 ;

        GraphL(int vertices){
            this.vertices = vertices ;
            for (int i = 0 ; i <= vertices ; i++){
                adjList.add(new ArrayList<>()) ;
            }
        }

        void addEdge(int u, int v, boolean isDirected){
            adjList.get(u).add(v) ;
            if (!isDirected) adjList.get(v).add(u) ;
        }
    }

}
