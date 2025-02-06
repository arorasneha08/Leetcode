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

        public int findParent(int node) {
            if (node == parent.get(node)) {
                return node;
            }
            int ul_parent = findParent(parent.get(node)); 
            parent.set(node, ul_parent); // Path compression
            return ul_parent;
        }

        public void unionByRank(int u, int v) {
            int ul_parent_u = findParent(u);
            int ul_parent_v = findParent(v);

            if (ul_parent_u == ul_parent_v) return; 

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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size(); 
        DisjointSet ds = new DisjointSet(n) ; 
        HashMap<String , Integer> mpp = new HashMap<>(); 
        for(int i = 0 ; i< n ; i++){
            for(int j = 1 ; j < accounts.get(i).size();  j++){
                String email = accounts.get(i).get(j); 
                if(!mpp.containsKey(email)){
                    mpp.put(email , i); 
                }
                else{
                    ds.unionByRank(i , mpp.get(email)); 
                }
            }
        }
        ArrayList<String>[] mergeEmail = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            mergeEmail[i] = new ArrayList<>();
        }

        for(Map.Entry<String , Integer> entry : mpp.entrySet()){
            String email = entry.getKey(); 
            int node = ds.findParent(entry.getValue()); 
            mergeEmail[node].add(email); 
        }

        List<List<String>> res = new ArrayList<>() ; 
        for(int i = 0 ; i < n ; i++){
            if(mergeEmail[i].size() == 0) continue ;
            Collections.sort(mergeEmail[i]); 
            List<String> temp = new ArrayList<>() ; 
            temp.add(accounts.get(i).get(0)) ; 
            for(String str : mergeEmail[i]){
                temp.add(str); 
            }
            res.add(temp); 
        }
        return res ; 
    }
}