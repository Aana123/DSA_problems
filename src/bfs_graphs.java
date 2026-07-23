import java.util.*;

public class bfs_graphs {
    public static void main(String[] args) {

    }
    //undirected connected graphs
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();

        int src = 0;
        Queue<Integer> q = new LinkedList<>();
        visited[src] = true;
        q.add(src);

        while (!q.isEmpty()) {
            int curr = q.poll();
            res.add(curr);

            // visit all the unvisited
            // neighbours of current node
            for (int x : adj.get(curr)) {
                if (!visited[x]) {
                    visited[x] = true;
                    q.add(x);
                }
            }
        }

        return res;
    }

    //undirected disconnected graph
    // BFS for a single connected component
    static void bfsConnected(ArrayList<ArrayList<Integer>> adj, int src, boolean[] visited, ArrayList<Integer> res) {
        Queue<Integer> q = new LinkedList<>();
        visited[src] = true;
        q.add(src);

        while (!q.isEmpty()) {
            int curr = q.poll();
            res.add(curr);

            // visit all the unvisited
            // neighbours of current node
            for (int x : adj.get(curr)) {
                if (!visited[x]) {
                    visited[x] = true;
                    q.add(x);
                }
            }
        }
    }

    // BFS for all components (handles disconnected graphs)
    static ArrayList<Integer> bfs1(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                bfsConnected(adj, i, visited, res);
        }
        return res;
    }
}
