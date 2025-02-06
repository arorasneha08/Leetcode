class Solution {
    public class DisjointSet{
        List<Integer> rank;
        List<Integer> parent;

        public DisjointSet(int n) {
            rank = new ArrayList<>(n);
            parent = new ArrayList<>(n);
            
            for (int i = 0; i < n; i++) {
                rank.add(0);
                parent.add(i);
            }
        }

        public int findUParent(int node) {
            if (node == parent.get(node)) {
                return node;
            }
            int ul_parent = findUParent(parent.get(node)); 
            parent.set(node, ul_parent); // Path compression
            return ul_parent;
        }

        public void unionByRank(int u, int v) {
            int ul_parent_u = findUParent(u);
            int ul_parent_v = findUParent(v);

            if (ul_parent_u == ul_parent_v) return; // Already in the same set

            if (rank.get(ul_parent_u) < rank.get(ul_parent_v)) {
                parent.set(ul_parent_u, ul_parent_v);
            } else if (rank.get(ul_parent_u) > rank.get(ul_parent_v)) {
                parent.set(ul_parent_v, ul_parent_u);
            } else {
                parent.set(ul_parent_v, ul_parent_u);
                rank.set(ul_parent_u, rank.get(ul_parent_u) + 1);
            }
        }
    }
    public int removeStones(int[][] stones) {
        int n = stones.length ; 
        int maxRow = 0 ;
        int maxCol = 0 ; 
        for(int i = 0 ; i< n ; i++){
            maxRow = Math.max(maxRow , stones[i][0]);
            maxCol = Math.max(maxCol , stones[i][1]); 
        }
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 2) ;
        HashMap<Integer , Integer> mpp = new HashMap<>(); 
        for(int i = 0 ; i < n ; i++){
            int nodeRow = stones[i][0] ;
            int nodeCol = stones[i][1] + maxRow + 1;
            ds.unionByRank(nodeRow , nodeCol); 
            mpp.put(nodeRow , 1) ; 
            mpp.put(nodeCol , 1) ; 
        }
        int count = 0;
        for(Map.Entry<Integer, Integer> it : mpp.entrySet()){
            if(ds.findUParent(it.getKey()) == it.getKey()){
                count ++ ; 
            }
        }
        return n - count ; 
    }
}