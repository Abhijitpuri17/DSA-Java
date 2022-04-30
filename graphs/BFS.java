package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS
{


    static List<Integer> bfs(GraphL g)
    {

        List<Integer> ans  = new ArrayList<>() ;

        /**
         * initially all are false ==> no node is visited
         */

        boolean[] visited = new boolean[g.vertices+1] ;

        for (int i = 1 ; i <= g.vertices; i++) {

             if (visited[i]) continue;

             Queue<Integer> q = new LinkedList<>() ;
             q.add(i) ;
             visited[i] = true ;

             while (!q.isEmpty()) {
                 int curr = q.poll();
                 ans.add(curr);
                 List<Integer> l = g.adjList.get(curr);

                 /**
                  * Traverse all neighbours of curr
                  */
                 for (int x : l) {
                     /**
                      * If x is not visited add it to queue
                      */
                     if (!visited[x]) {
                         q.add(x);
                         /**
                          * make visited of x true so after this, x won't be visited again
                          */
                         visited[x] = true;
                     }
                 }
             }
        }
        return ans ;
    }


    public static void main(String[] args)
    {

        GraphL g = new GraphL(7) ;

        g.addEdge(1,2, false);
        g.addEdge(2,3, false);
        g.addEdge(2,5, false);
        g.addEdge(3,4, false);
        g.addEdge(3, 5, false);
        g.addEdge(6,7, false);

        List<Integer> bfsList = bfs(g) ;

        for (int x: bfsList) System.out.print(x+ " ") ;

        System.out.println() ;

    }


}
