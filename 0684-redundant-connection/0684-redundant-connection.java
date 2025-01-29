class Solution {
    public boolean dfs(int node , int parent , ArrayList<ArrayList<Integer>> adj , int[] visited ){
        visited[node] = 1 ; 

        for(int adjNode : adj.get(node)){
            if(visited[adjNode] == 0){
                if(dfs(adjNode  , node , adj , visited)) return true ; 
            }
            else if (adjNode != parent) {
                return true; 
            }
        }
        return false; 
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length ;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); 

        for(int i = 0 ; i <= n ; i++){
            adj.add(new ArrayList<>());
        }

        int visited[] = new int[n+1] ; 

        for(int edge[] : edges){
            int u = edge[0] ;
            int v = edge[1] ;

            adj.get(u).add(v);
            adj.get(v).add(u); 

            Arrays.fill(visited, 0); 

            if(dfs(u , -1 , adj , visited)){
                return edge ; 
            }
        }
        return new int[0] ; 
    }
}