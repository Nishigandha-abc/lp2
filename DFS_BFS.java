import java.util.*;
class Graph {
    static int V = 5;
    static LinkedList<Integer>[] adj = new LinkedList[V];
    static boolean[] visited = new boolean[V];

    // DFS
    static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int n : adj[v]) {
            if (!visited[n])
                dfs(n);
        }
    }

    // BFS
    static void bfs(int s) {
        Queue<Integer> q = new LinkedList<>();

        visited = new boolean[V]; // reset
        visited[s] = true;
        q.add(s);

        while (!q.isEmpty()) {
            int v = q.poll();
            System.out.print(v + " ");

            for (int n : adj[v]) {
                if (!visited[n]) {
                    visited[n] = true;
                    q.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {

        // Initialize graph
        for (int i = 0; i < V; i++)
            adj[i] = new LinkedList<>();

        // Edges
        adj[0].add(1); adj[1].add(0);
        adj[0].add(2); adj[2].add(0);
        adj[1].add(3); adj[3].add(1);
        adj[2].add(4); adj[4].add(2);

        System.out.print("DFS: ");
        dfs(0);

        System.out.print("\nBFS: ");
        bfs(0);
    }
}
