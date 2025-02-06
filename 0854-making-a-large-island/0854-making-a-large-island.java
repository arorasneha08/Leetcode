class Solution {
    public class DisjointSet {
        List<Integer> rank;
        List<Integer> parent;
        List<Integer> size; 

        public DisjointSet(int n) {
            rank = new ArrayList<>(Collections.nCopies(n, 0));
            parent = new ArrayList<>();
            size = new ArrayList<>(Collections.nCopies(n, 1)); 

            for (int i = 0; i < n; i++) {
                parent.add(i);
            }
        }

        public int findParent(int node) {
            if (node == parent.get(node)) {
                return node;
            }
            int ul_parent = findParent(parent.get(node)); 
            parent.set(node, ul_parent); // Path compression
            return ul_parent;
        }

        public void unionBySize(int u, int v) {
            int ul_parent_u = findParent(u);
            int ul_parent_v = findParent(v);

            if (ul_parent_u == ul_parent_v) return; 

            if (rank.get(ul_parent_u) < rank.get(ul_parent_v)) {
                parent.set(ul_parent_u, ul_parent_v);
                size.set(ul_parent_v, size.get(ul_parent_v) + size.get(ul_parent_u)); 
            } else if (rank.get(ul_parent_u) > rank.get(ul_parent_v)) {
                parent.set(ul_parent_v, ul_parent_u);
                size.set(ul_parent_u, size.get(ul_parent_u) + size.get(ul_parent_v)); // Merge sizes
            } else {
                parent.set(ul_parent_v, ul_parent_u);
                size.set(ul_parent_u, size.get(ul_parent_u) + size.get(ul_parent_v)); // Merge sizes
                rank.set(ul_parent_u, rank.get(ul_parent_u) + 1);
            }
        }
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1}; 
        DisjointSet ds = new DisjointSet(n * m); 

        // Step 1: Connect existing '1's using DSU
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) continue;
                for (int k = 0; k < 4; k++) {
                    int newRow = i + delRow[k]; 
                    int newCol = j + delCol[k]; 

                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1) {
                        int nodeNo = i * m + j; 
                        int adjNodeNo = newRow * m + newCol; 
                        ds.unionBySize(nodeNo, adjNodeNo); 
                    }
                }
            }
        }

        // Step 2: Find max island size
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) continue;
                HashSet<Integer> set = new HashSet<>();
                for (int k = 0; k < 4; k++) {
                    int newRow = i + delRow[k]; 
                    int newCol = j + delCol[k]; 
                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1) {
                        set.add(ds.findParent(newRow * m + newCol)); 
                    }
                }
                int sizeTotal = 1; // Start with 1 since we are converting a '0' to '1'
                for (int parent : set) {
                    sizeTotal += ds.size.get(parent); 
                }
                max = Math.max(max, sizeTotal); 
            }
        }

        // Step 3: Check if the entire grid is already one island
        for (int i = 0; i < n * m; i++) {
            if (grid[i / m][i % m] == 1) {
                max = Math.max(max, ds.size.get(ds.findParent(i))); 
            }
        }

        return max; 
    }
}
