class Solution {
    public class DisjointSet{
        ArrayList<Integer> parent ; 
        ArrayList<Integer> rank ;

        DisjointSet(int n){
            parent = new ArrayList<>();
            rank = new ArrayList<>(); 

            for(int i = 0 ; i < n ; i++){
                parent.add(i) ;
                rank.add(0); 
            }
        }
        public int findParent(int node){
            if(node == parent.get(node)){
                return node;  
            }
            int ul_parent = findParent(parent.get(node)); 
            parent.set(node , ul_parent); 
            return ul_parent ; 
        }
        public void unionByRank(int u , int v){
            int ul_parent_u = findParent(u) ;
            int ul_parent_v = findParent(v) ; 

            if(ul_parent_u == ul_parent_v) return ; 

            if(rank.get(ul_parent_u) > rank.get(ul_parent_v)){
                parent.set(ul_parent_v , ul_parent_u) ; 
            }
            else if(rank.get(ul_parent_u) < rank.get(ul_parent_v)){
                parent.set(ul_parent_u , ul_parent_v); 
            }
            else{
                parent.set(ul_parent_u , ul_parent_v) ; 
                rank.set(ul_parent_v , ul_parent_u + ul_parent_v) ; 
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n) ; 

        int edge = 0 ;

        for(int row[] : connections){
            if(ds.findParent(row[0]) != ds.findParent(row[1])){
                ds.unionByRank(row[0] , row[1]); 
            }
            else {
                edge ++ ; 
            }
        }
        int count = 0 ; 
        for(int i = 0 ; i < n ; i++){
            if(ds.findParent(i) == i){
                count ++ ; 
            }
        }
        if(count - 1 <= edge){
            return count -1 ; 
        }
        return -1 ;
    }
}