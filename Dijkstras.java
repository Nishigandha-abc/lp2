import java.util.*;

public class Dijkstra {
    public static void main(String[] args) {
        int graph[][] = {
            {0, 10, 0, 30, 0},
            {10, 0, 50, 0, 0},
            {0, 50, 0, 20, 10},
            {30, 0, 20, 0, 60},
            {0, 0, 10, 60, 0}
        };

        int n = 5;
        int dist[] = new int[n];
        boolean visited[] = new boolean[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0; // source

        for (int i = 0; i < n - 1; i++) {
            int u = -1, min = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                if (!visited[j] && dist[j] < min) {
                    min = dist[j];
                    u = j;
                }
            }

            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && !visited[v] &&
                    dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        System.out.println("Shortest distances:");
        for (int d : dist)
            System.out.print(d + " ");
    }
}
