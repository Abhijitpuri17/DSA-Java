package graphs.cycleDetection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS
{

    static class Pair{
        int x, y ;
        Pair(int x, int y){
            this.x = x ;
            this.y = y ;
        }
    }


    static boolean bfs(GraphL g, boolean[] visited, int curr){

        Queue<Pair> q = new LinkedList<>() ;

        q.add(new Pair(curr, -1)) ;
        visited[curr] = true ;

        while (!q.isEmpty())
        {
            Pair p = q.poll() ;

            int currNode = p.x ;
            int parent = p.y ;

            for (int k : g.adjList.get(currNode)){
                if (!visited[k]){
                    visited[k] = true ;
                    q.add(new Pair(k, currNode)) ;
                } else if (k != parent) return true ;
            }
        }

        return false ;
    }

    static boolean cycle(GraphL g){

        boolean[] visited = new boolean[g.vertices+1] ;

        for (int i = 1 ; i <= g.vertices ; i++)
        {
            if (!visited[i]){
                boolean isCycle = bfs(g, visited, i) ;
                if (isCycle) return true ;
            }
        }

        return false ;
    }


    public static void main(String[] args) {

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
