import java.util.ArrayList;

public class Graphs {
    public static void main(String[] args) {
        int V = 5; // Number of vertices (0 to 4)
        int[][] matrix = new int[V][V];

        //edges: (0,1), (0,2), (1,3), (2,4)
        addEdge(matrix, 0, 1, false); // false = undirected graph
        addEdge(matrix, 0, 2, false);
        addEdge(matrix, 1, 3, true);
        addEdge(matrix, 2, 4, false);

        printGraph(matrix);
        System.out.println();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<>());
        }

        addEdges(adj, 0, 1, false); // false = undirected graph
        addEdges(adj, 0, 2, false);
        addEdges(adj, 1, 3, true);
        addEdges(adj, 2, 4, false);

        printGraphs(adj);

    }
    //Using adjacency matrix
    //TC - O(V^2)
    private static void addEdge(int[][] adj, int u, int v, boolean isDirected){
        adj[u][v] = 1;
        if(!isDirected){
            adj[v][u] = 1;
        }
    }
    private static void printGraph(int[][] adj){
        for(int i = 0; i<adj.length; i++){
            for(int j = 0; j<adj[i].length; j++){
                System.out.print(adj[i][j]+" ");
            }
            System.out.println();
        }
    }

    //Using adjacency list
    //TC - O(V+E)
    private static void addEdges(ArrayList<ArrayList<Integer>> adj, int u, int v, boolean isDirected){
        adj.get(u).add(v);
        if(!isDirected){
            adj.get(v).add(u);
        }
    }
    private static void printGraphs(ArrayList<ArrayList<Integer>> adj){
        for(int i = 0; i<adj.size(); i++){
            System.out.print(i+" -> ");
            for(int j : adj.get(i)){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
