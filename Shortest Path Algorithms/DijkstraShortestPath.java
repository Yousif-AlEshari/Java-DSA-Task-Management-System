
public class DijkstraShortestPath {
	static final int NUM_VERTICES = 8;
	
	int findMinDistanceVertex(int distances[], Boolean shortestPathTreeSet[]) {
		int minDistance = Integer.MAX_VALUE;
		int minDistanceVertex = -1;
		
		for (int temp = 0; temp < NUM_VERTICES; temp++) {
			if(!shortestPathTreeSet[temp] && distances[temp] <= minDistance) {
				minDistance = distances[temp];
				minDistanceVertex = temp;
			}
		}
		return minDistanceVertex;
	}
	
	void printSolution(int distances[]) {
		System.out.println("Vertex \t\t Distance from Source");
		for(int i=0;i<NUM_VERTICES; i++) {
			System.out.println(i + " \t\t " + distances[i]);
		}
	}
	
	void dijkstra(int graph[][], int sourceVertex) {
		int [] distances = new int[NUM_VERTICES];
		Boolean[] shortestPathTreeSet = new Boolean[NUM_VERTICES];
		
		for (int i =0; i < NUM_VERTICES; i++) {
			distances[i] = Integer.MAX_VALUE;
			shortestPathTreeSet[i] = false;
		}
		
		distances[sourceVertex] = 0;
		
		for (int count = 0; count < NUM_VERTICES -1; count++) {
			int A = findMinDistanceVertex(distances, shortestPathTreeSet);
			
			shortestPathTreeSet[A] = true;
			
			for( int iterate = 0; iterate< NUM_VERTICES; iterate++) {
				if(!shortestPathTreeSet[iterate]
						&& graph[A][iterate] != 0 && distances[A] != Integer.MAX_VALUE && distances[A] + graph[A][iterate] < distances[iterate]) {
					distances[iterate] = distances[A] +graph[A][iterate];
				}
			}
		}
		printSolution(distances);
	}

	public static void main(String[] args) {
		int graph[][] = new int [][] {/*Task1*/{0,  4,  7,  5,  8, 12,  9, 29},
									  /*Task2*/{0,  0,  2,  7,  0, 0,  0, 0},
									  /*Task3*/{0,  0,  0,  2,  0, 0,  0, 1},
									  /*Task4*/{0,  0,  0,  0,  0, 0, 1, 10},
									  /*Task5*/{0,  0,  0,  0,  0, 1, 5, 0},
									  /*Task6*/{0,  0,  0,  0,  0, 0,  0, 3},
									  /*Task7*/{0,  0,  0,  0,  0, 0,  0, 0},
									  /*Task8*/{0,  0,  0,  0,  0, 0,  0, 0}};
		
		DijkstraShortestPath shortestPath = new DijkstraShortestPath();
		
		shortestPath.dijkstra(graph, 0);
	}
}
