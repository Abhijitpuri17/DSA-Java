package graphs;

public class AdjacencyMatrix
{
    public static void main(String[] args)
    {
        GraphM g = new GraphM(5) ;
        System.out.println(g.isConnected(1,2)) ;
        g.addEdge(1,2, false);

        System.out.println(g.isConnected(1,2)) ;
    }
}

class GraphM
{
    int vertices ;
    private final int[][] adjMatrix;

    GraphM(int vertices) {
        this.vertices = vertices ;
        adjMatrix = new int[vertices+1][vertices+1] ;
    }

    void addEdge(int u, int v, boolean isDirected) {
        adjMatrix[u][v] = 1 ;
        if (!isDirected) adjMatrix[v][u] = 1 ;
    }

    boolean isConnected(int u, int v){
        return adjMatrix[u][v] != 0 ;
    }

}