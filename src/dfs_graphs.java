import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class dfs_graphs {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.add(new ArrayList<>(Arrays.asList(2)));
        adj.add(new ArrayList<>(Arrays.asList(0, 3)));
        adj.add(new ArrayList<>(Arrays.asList(3)));

        ArrayList<Integer> res = dfs(adj);
        for (int node : res) System.out.print(node + " ");
        System.out.println();
    }
    //Connected undirected graph
    //Iterative
    private static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();

        boolean[] visited = new boolean[n];
        ArrayList<Integer> res = new ArrayList<>();

        Stack<Integer> st = new Stack<>();
        st.push(0);

        while (!st.isEmpty()) {
            int node = st.pop();

            if (!visited[node]) {
                // Mark this node as visited
                visited[node] = true;
                res.add(node);

                // Traverse all edges (as stack is used, so
                // push from right to left)
                int size = adj.get(node).size();
                for (int i = size - 1; i >= 0; i--) {
                    int v = adj.get(node).get(i);
                    if (!visited[v]) st.push(v);
                }
            }
        }

        return res;
    }
    //Recursive
    public ArrayList<Integer> dfs1(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        ArrayList<Integer> ans = new ArrayList<>();
        helper(adj,0,visited,ans);
        return ans;
    }
    private void helper(ArrayList<ArrayList<Integer>> adj, int idx, boolean[] visited, ArrayList<Integer> ans){
        visited[idx] = true;
        ans.add(idx);

        for(int i : adj.get(idx)){
            if(!visited[i]){
                helper(adj,i,visited,ans);
            }
        }
    }

    //Disconnected undirected graph
    public int numOfProvinces(int[][] isConnected) {
        int V = isConnected.length;
        boolean[] visited = new boolean[V];
        int ans = 0;
        for(int i = 0; i<V; i++){
            if(!visited[i]){
                ans++;
                helper(isConnected,i,visited);
            }
        }
        return ans;
    }
    private void helper(int[][] adj, int idx, boolean[] visited){
        visited[idx] = true;
        for(int i = 0; i<adj.length; i++){
            if(adj[idx][i] == 1 && !visited[i]){
                helper(adj,i,visited);
            }
        }
    }
}
