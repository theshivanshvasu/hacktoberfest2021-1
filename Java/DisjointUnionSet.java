//Disjoint Union Set implementation
class DisjointUnionSet {
    int n;
    int[] rank;
    int[] parent;

    public DisjointUnionSet(int n) {
        this.n = n;
        parent = new int[n+1];
        rank = new int[n+1];
        markParent();
    }

    public void markParent() {
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if(x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int u, int v) {
        if(u > n || v > n || u <= 0 || v <= 0) {
            System.out.println("Invalid Nodes");
            return;
        }
        int parentU = find(u);
        int parentV = find(v);
        if(parentU != parentV) {
            if(rank[parentU] > rank[parentV]) {
                parent[parentV] = parentU;
            }
            else if(rank[parentU] < rank[parentV]) {
                parent[parentU] = parentV;
            }
            else {
                parent[parentV] = parentU;
                rank[parentU]++;
            }
        }
    }

    public static void main(String[] args) {
        int n = 6;  // Number of Components
        DisjointUnionSet dus = new DisjointUnionSet(n);
        dus.union(1,3); // Connecting Node 1 with Node 3
        dus.union(2,6); // Connecting Node 2 with Node 6
        dus.union(2,5); // Connecting Node 2 with Node 5

        System.out.println("Parent of Node 3 is: " + dus.find(3));
        System.out.println("Parent of Node 5 is: " + dus.find(5));
        System.out.println("Parent of Node 6 is: " + dus.find(6));
        System.out.println("Parent of Node 4 is: " + dus.find(4));
    }
}