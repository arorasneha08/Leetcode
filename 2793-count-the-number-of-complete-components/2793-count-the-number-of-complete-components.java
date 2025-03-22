class Solution {
    class DisjointSet {
        ArrayList<Integer> parent ;
        ArrayList<Integer> rank ; 

        DisjointSet(int n){
            parent = new ArrayList<>();
            rank = new ArrayList<>();
            for(int i = 0 ; i < n ; i++){
                parent.add(i);
                rank.add(1); 
            }
        }

        int getParent(int node){
            if(node == parent.get(node)){
                return node ; 
            }
            int ul_parent = getParent(parent.get(node)); 
            parent.set(node , ul_parent); 
            return ul_parent; 
        }

        void union(int u , int v){
            int pu = getParent(u);
            int pv = getParent(v);
            if(pu == pv) return ; 

            if(rank.get(pu) > rank.get(pv)){
                parent.set(pv , pu); 
            }
            else if(rank.get(pu) < rank.get(pv)){
                parent.set(pu , pv); 
            }
            else{
                parent.set(pv, pu);
                rank.set(pu , rank.get(pu) + 1); 
            }
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        DisjointSet ds = new DisjointSet(n) ;
        for(int edge[] : edges){
            ds.union(edge[0] , edge[1]); 
        }
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        Map<Integer , List<Integer>> mpp = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            int parent = ds.getParent(i); 
            mpp.putIfAbsent(parent , new ArrayList<>()); 
            mpp.get(parent).add(i); 
        }
        int count = 0 ; 
        for(Map.Entry<Integer , List<Integer>> entry : mpp.entrySet()){
            List<Integer> comp = entry.getValue(); 
            boolean complete = true; 
            int size = comp.size(); 
            for(int node : comp){
                if(adj.get(node).size() != size - 1){
                    complete = false; 
                    break ; 
                }
            }
            if(complete) count ++ ; 
        }
        return count; 
    }
}