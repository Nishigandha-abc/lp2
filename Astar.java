import java.util.*;

class AStar {
    static int V = 5;

    static int h[] = {7,6,2,1,0};

    static int g[][] = {
        {0,1,4,0,0},
        {1,0,2,5,0},
        {4,2,0,1,3},
        {0,5,1,0,2},
        {0,0,3,2,0}
    };

    static void aStar(int s, int goal) {

        PriorityQueue<int[]> pq =
            new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        int dist[] = new int[V];
        int parent[] = new int[V];

        Arrays.fill(dist, 999);

        pq.add(new int[]{s, h[s]});
        dist[s] = 0;
        parent[s] = -1;

        while (!pq.isEmpty()) {
            int node = pq.poll()[0];

            if (node == goal) break;

            for (int i = 0; i < V; i++) {
                if (g[node][i] != 0) {

                    int newCost = dist[node] + g[node][i];

                    if (newCost < dist[i]) {
                        dist[i] = newCost;
                        parent[i] = node;

                        pq.add(new int[]{i, newCost + h[i]});
                    }
                }
            }
        }

        print(parent, goal);
        System.out.println("\nCost = " + dist[goal]);
    }

    static void print(int p[], int j) {
        if (j == -1) return;
        print(p, p[j]);
        System.out.print(j + " ");
    }

    public static void main(String[] args) {
        aStar(0,4);
    }
}
