package graphs.cycleDetection;

import java.util.ArrayList;

public class DirectedGraphDFS
{

    static boolean dfs(GraphL g, int curr, boolean[] visited, boolean[] dfsVisited){

        visited[curr] = true ;
        dfsVisited[curr] = true ;

        for (int x : g.adjList.get(curr)){
            if (!visited[x]){
                boolean isCycle = dfs(g, x, visited, dfsVisited) ;
                if (isCycle) return true ;
            } else if (dfsVisited[x]) return true ;
        }

        dfsVisited[curr] = false ;
        return false ;
    }


    static boolean cycle(GraphL g){

        boolean[] visited = new boolean[g.vertices+1] ;
        boolean[] dfsVisited = new boolean[g.vertices+1] ;

        for (int i = 1 ; i <= g.vertices ; i++)
        {
            if (!visited[i]){
                boolean isCycle = dfs(g, i, visited, dfsVisited) ;
                if (isCycle) return true ;
            }
        }

        return false ;
    }



    public static void main(String[] args)
    {

        GraphL g = new GraphL(9);
        g.addEdge(1,2,true);
        g.addEdge(2,3,true);
        g.addEdge(3,4,true);
        g.addEdge(3,6,true);
        g.addEdge(4,5,true);
        g.addEdge(6,5,true);
        g.addEdge(7,2,true);
        g.addEdge(7,8,true);
        g.addEdge(8,9,true);
        g.addEdge(7,9,true);

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
