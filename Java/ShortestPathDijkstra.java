import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

public class ShortestPathDijkstra {
    public int n;
    public ArrayList<Integer>[] graph;
    public int[] distance;
    public boolean[] visited;

    static class Distance {
        int node;
        int distance;

        public Distance(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    static class DistanceComparator implements Comparator<Distance> {
        public int compare(Distance node1, Distance node2) {
            if(node1.distance < node2.distance) {
                return -1;
            }
            else if(node1.distance > node2.distance) {
                return 1;
            }
            else {
                return 0;
            }
        }
    }

    public ShortestPathDijkstra(int n) {
        this.n = n;
        graph = new ArrayList[n+1];
        makeEdges();
        resetNodeDistances();
        resetVisitedNodes();
    }

    public void makeEdges() {
        for(int i=0; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    public void addEdge(int u, int v) {
        graph[u].add(v);
        graph[v].add(u);
    }

    public void resetNodeDistances() {
        distance = new int[n+1];
        for(int i=0; i<=n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
    }

    public void resetVisitedNodes() {
        visited = new boolean[n+1];
    }

    public int computeShortestPath(int source, int destination) {
        distance[source] = 0;
        PriorityQueue<Distance> queue = new PriorityQueue<>(new DistanceComparator());
        queue.add(new Distance(source, distance[source]));

        while(!queue.isEmpty()) {
            Distance distNode = queue.poll();
            int node = distNode.node;
            for(int neighbour: graph[node]) {
                if(!visited[neighbour] && (distance[neighbour] > (distance[node] + 1))){
                    distance[neighbour] = distance[node] + 1;
                    queue.add(new Distance(neighbour, distance[neighbour]));
                }
            }
            visited[node] = true;
        }

        int shortestDistance = distance[destination];
        resetNodeDistances();
        resetVisitedNodes();
        return shortestDistance;
    }

    public static void main(String[] args) {
        //Create a Bi-directional Connected Graph;
        int n = 10;
        ShortestPathDijkstra shortestPath = new ShortestPathDijkstra(n);
        shortestPath.addEdge(1,9);
        shortestPath.addEdge(1,5);
        shortestPath.addEdge(5,3);
        shortestPath.addEdge(5,2);
        shortestPath.addEdge(3,7);
        shortestPath.addEdge(7,10);
        shortestPath.addEdge(2,10);

        //Compute Shortest Path between two nodes
        System.out.println("Shortest Path between Node 2 and Node 3 is: " + shortestPath.computeShortestPath(2, 3));
        System.out.println("Shortest Path between Node 1 and Node 7 is: " + shortestPath.computeShortestPath(1, 7));
        System.out.println("Shortest Path between Node 10 and Node 9 is: " + shortestPath.computeShortestPath(9, 10));
    }
}