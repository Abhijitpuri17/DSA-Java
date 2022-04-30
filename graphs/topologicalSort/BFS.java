package graphs.topologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS
{


    static List<Integer> topologicalSort(GraphL g){

        int[] indegree = new int[g.vertices+1] ;

        for (int i = 1 ; i <= g.vertices ; i++){
            for (int x: g.adjList.get(i)){
                indegree[x]++ ;
            }
        }

        Queue<Integer> q = new LinkedList<>() ;

        for (int i = 1 ; i <= g.vertices; i++) {
            if (indegree[i] == 0) q.add(i) ;
        }

        List<Integer> ans = new ArrayList<>() ;

        while(!q.isEmpty()){

            int curr = q.poll() ;

            ans.add(curr) ;

            for (int x: g.adjList.get(curr)){
                indegree[x]-- ;
                if (indegree[x] == 0) {
                    q.add(x) ;
                }
            }

        }

        return ans ;
    }



    public static void main(String[] args) {
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

