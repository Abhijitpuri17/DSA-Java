package graphs;

import java.util.ArrayList;

public class AdjacencyList
{

    public static void main(String[] args) {

        GraphL g = new GraphL(5) ;

        System.out.println(g.isConnected(1,2)) ;

        g.addEdge(1,2, false) ;

        System.out.println(g.isConnected(1,2)) ;
    }

}

class GraphL{

    ArrayList<ArrayList<Integer>> adjList = new ArrayList<>() ;
    int vertices;

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

    boolean isConnected(int u, int v){
        ArrayList<Integer> curr = adjList.get(u) ;

        for (Integer integer : curr) {
            if (integer == v) return true;
        }
        return false ;
    }
}
