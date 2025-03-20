class Solution {
    public class DisjointSet {
        ArrayList<Integer> parent;
        ArrayList<Integer> rank;
        ArrayList<Integer> minAndValue; 

        DisjointSet(int n) {
            parent = new ArrayList<>();
            rank = new ArrayList<>();
            minAndValue = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                parent.add(i);
                rank.add(0);
                minAndValue.add(Integer.MAX_VALUE); 
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

        public void unionByRank(int u, int v, int weight) {
            int ul_parent_u = findParent(u);
            int ul_parent_v = findParent(v);

            if (ul_parent_u == ul_parent_v) {
                minAndValue.set(ul_parent_u, minAndValue.get(ul_parent_u) & weight);
                return;
            }

            if (rank.get(ul_parent_u) > rank.get(ul_parent_v)) {
                parent.set(ul_parent_v, ul_parent_u);
                minAndValue.set(ul_parent_u, minAndValue.get(ul_parent_u) & minAndValue.get(ul_parent_v) & weight);
            } else if (rank.get(ul_parent_u) < rank.get(ul_parent_v)) {
                parent.set(ul_parent_u, ul_parent_v);
                minAndValue.set(ul_parent_v, minAndValue.get(ul_parent_u) & minAndValue.get(ul_parent_v) & weight);
            } else {
                parent.set(ul_parent_u, ul_parent_v);
                rank.set(ul_parent_v, rank.get(ul_parent_v) + 1);
                minAndValue.set(ul_parent_v, minAndValue.get(ul_parent_u) & minAndValue.get(ul_parent_v) & weight);
            }
        }
    }

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        DisjointSet dsu = new DisjointSet(n);

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            dsu.unionByRank(u, v, w);
        }

        int[] result = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int u = query[i][0], v = query[i][1];

            if (dsu.findParent(u) == dsu.findParent(v)) {
                result[i] = dsu.minAndValue.get(dsu.findParent(u));
            } else {
                result[i] = -1;
            }
        }

        return result;
    }
}
