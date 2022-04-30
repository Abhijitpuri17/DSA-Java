package graphs.topologicalSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS
{

    static List<Integer> topologicalSort(GraphL g){

        boolean[] visited = new boolean[g.vertices+1] ;
        Stack<Integer> st = new Stack<>() ;

        for (int i = 1 ; i <= g.vertices ; i++){
            if (!visited[i]){
                dfs(g, visited, i, st) ;
            }
        }

        List<Integer> ans = new ArrayList<>() ;

        while (!st.isEmpty()) ans.add(st.pop()) ;

        return ans ;
    }

    static void dfs(GraphL g, boolean[] visited, int curr, Stack<Integer> st){
        visited[curr] = true ;
        for (int x: g.adjList.get(curr)){
            if (!visited[x]){
                dfs(g, visited, x, st);
            }
        }
        st.push(curr) ;
    }


    public static void main(String[] args)
    {
        GraphL g = new GraphL(7) ;
        g.addEdge(1,2,true);
        g.addEdge(1,3,true);
        g.addEdge(2,4,true);
        g.addEdge(2,6,true);
        g.addEdge(4,3,true);
        g.addEdge(4,7,true);
        g.addEdge(3,5,true);

        List<Integer> topoSort = topologicalSort(g) ;
        for (int x: topoSort) System.out.print(x + " ");
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

}
