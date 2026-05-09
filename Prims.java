import java.util.*;

public class Prims {
    public static void main(String[] args) {
        int graph[][] = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };

        int n = 5;
        int key[] = new int[n];
        boolean mst[] = new boolean[n];

        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;

        for (int i = 0; i < n - 1; i++) {
            int u = -1, min = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                if (!mst[j] && key[j] < min) {
                    min = key[j];
                    u = j;
                }
            }

            mst[u] = true;

            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && !mst[v] &&
                    graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                }
            }
        }

        System.out.println("Minimum cost:");
        int sum = 0;
        for (int k : key) sum += k;
        System.out.println(sum);
    }
}
