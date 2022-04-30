package graphs;

import java.util.ArrayList;
import java.util.List;

public class DFS {


    static List<Integer> dfs(GraphL g){

        boolean[] visited = new boolean[g.vertices+1] ;

        List<Integer> ans = new ArrayList<>() ;

        /**
         * One function call on rDfs gives one component
         */

        for (int i = 1 ; i <= g.vertices ; i++){
            if (visited[i]) continue;
            rDfs(g, i, visited, ans);
        }

        return ans ;
    }

    static void rDfs(GraphL g, int curr, boolean[] visited, List<Integer> ans){

        if (visited[curr]) return;

        /**
         * add curr element to ans
         */

        ans.add(curr) ;
        visited[curr] = true ;

        /**
         * traverse its neighbors and call dfs for them
         */

        for (int x : g.adjList.get(curr)){
            if (!visited[x])
            rDfs(g, x, visited, ans);
        }
    }



    public static void main(String[] args) {
        GraphL g = new GraphL(7) ;

        g.addEdge(1,2, false);
        g.addEdge(2,3, false);
        g.addEdge(2,5, false);

        g.addEdge(3, 5, false);
        g.addEdge(6,7, false);
        g.addEdge(4,6,false);

        List<Integer> dfsList = dfs(g) ;

        for (int x: dfsList) System.out.print(x+ " ") ;

        System.out.println() ;
    }

}
