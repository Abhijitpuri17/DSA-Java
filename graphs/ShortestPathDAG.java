package graphs;

import java.util.ArrayList;
import java.util.Stack;

public class ShortestPathDAG {

    static void topoSort(int node, boolean[] visited, Stack<Integer> st, ArrayList<ArrayList<Pair>> adj)
    {
        visited[node] = true ;

        for (Pair x: adj.get(node)){
            if (!visited[x.v]) {
                topoSort(x.getV(), visited, st, adj);
            }
        }
        st.add(node) ;
    }

    static int[] shortestPath(int s, ArrayList<ArrayList<Pair>> adj, int n){
        Stack<Integer> st = new Stack<>() ;

        boolean[] visited = new boolean[n] ;
        int[] dist = new int[n] ;

        for (int i = 0 ; i < n ; i++){
            if (!visited[i]){
                topoSort(i, visited, st, adj);
            }
        }

        for (int i = 0 ; i < n ; i++) dist[i] = Integer.MAX_VALUE ;

        dist[s] = 0 ;

        while (!st.isEmpty()) {
            int node = st.pop() ;
            if (dist[node] != Integer.MAX_VALUE) {
                for (Pair p : adj.get(node)) {
                    if (dist[node] + p.getWeight() < dist[p.getV()]){
                        dist[p.getV()] = dist[node] + p.getWeight() ;
                    }
                }
            }
        }

        return dist ;
    }

    static class Pair {
        private int v;
        private int weight;

        Pair(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        int getV() {
            return v;
        }

        int getWeight() {
            return weight;
        }
    }

    public static void main(String[] args)
    {
        int n = 6 ;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>() ;

        for (int i = 0 ; i < n; i++) adj.add(new ArrayList<>()) ;

        adj.get(0).add(new Pair(1,2)) ;
        adj.get(0).add(new Pair(4,1)) ;
        adj.get(1).add(new Pair(2,3)) ;
        adj.get(2).add(new Pair(3,6)) ;
        adj.get(4).add(new Pair(2,2)) ;
        adj.get(4).add(new Pair(5,4)) ;
        adj.get(5).add(new Pair(3,1)) ;

        int[] dist = shortestPath(0, adj, 6) ;

        for  (int i = 0 ; i < n ; i++){
            System.out.println(i + " " + dist[i]);
        }

    }

}
