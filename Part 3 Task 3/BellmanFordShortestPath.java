import java.util.ArrayList;
import java.util.Arrays;

class BellmanFordShortestPath {
    private static void bellmanFord(int n, int m, int src, ArrayList<ArrayList<Integer>> edges) {
        int[] path = new int[n];
        Arrays.fill(path, Integer.MAX_VALUE);
        path[src] = 0;

        // Relax edges up to n-1 times
        for (int i = 1; i < n; i++) {
            for (int z = 0; z < m; z++) {
                int u = edges.get(z).get(0);
                int v = edges.get(z).get(1);
                int w = edges.get(z).get(2);
                if (path[u] != Integer.MAX_VALUE && path[u] + w < path[v]) {
                    path[v] = path[u] + w;
                }
            }
        }

        // Check for negative-weight cycles
        for (int j = 0; j < m; j++) {
            int u = edges.get(j).get(0);
            int v = edges.get(j).get(1);
            int w = edges.get(j).get(2);
            if (path[u] != Integer.MAX_VALUE && path[u] + w < path[v]) {
                System.out.println("There is a negative cycle in the graph");
                return;
            }
        }

        // Print the shortest paths
        for (int i = 0; i < n; i++) {
            System.out.print("The shortest path between " + src + " and " + i + " is: ");
            if (path[i] == Integer.MAX_VALUE) {
                System.out.println("No path");
            } else {
                System.out.println(path[i]);
            }
        }
    }

    public static void main(String[] args) {
        int nodes = 8, edge = 16, src = 0;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        
        edges.add(new ArrayList<>(Arrays.asList(0, 1, 4)));
        edges.add(new ArrayList<>(Arrays.asList(0, 2, 7)));
        edges.add(new ArrayList<>(Arrays.asList(0, 3, 5)));
        edges.add(new ArrayList<>(Arrays.asList(0, 4, 8)));
        edges.add(new ArrayList<>(Arrays.asList(0, 5, 12)));
        edges.add(new ArrayList<>(Arrays.asList(0, 6, 9)));
        edges.add(new ArrayList<>(Arrays.asList(0, 7, 29)));
        edges.add(new ArrayList<>(Arrays.asList(1, 2, 2)));
        edges.add(new ArrayList<>(Arrays.asList(1, 3, 7)));
        edges.add(new ArrayList<>(Arrays.asList(2, 3, 2)));
        edges.add(new ArrayList<>(Arrays.asList(2, 7, 1)));
        edges.add(new ArrayList<>(Arrays.asList(3, 6, -1)));
        edges.add(new ArrayList<>(Arrays.asList(3, 7, 10)));
        edges.add(new ArrayList<>(Arrays.asList(4, 5, 1)));
        edges.add(new ArrayList<>(Arrays.asList(4, 6, 5)));
        edges.add(new ArrayList<>(Arrays.asList(5, 7, -3)));

        bellmanFord(nodes, edge, src, edges);
    }
}
