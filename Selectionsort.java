//Selection sort

import java.util.*;

public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {64, 25, 12, 22, 11};
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            // swap
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }

        System.out.println("Sorted array:");
        for (int x : arr)
            System.out.print(x + " ");
    }
}


//Dijktras
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

//Prims

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
