class Solution {
    private int timer = 1 ; 
    private void dfs(int node , int parent , int visited[] , ArrayList<ArrayList<Integer>> adj , int[] tin ,
                 int[] low , List<List<Integer>> bridges){
            visited[node] = 1; 
            tin[node] = low[node] = timer ; 
            timer ++ ; 

            for(int adjNode : adj.get(node)){
                if(adjNode == parent ) continue ; 
                if(visited[adjNode] == 0){
                    dfs(adjNode , node , visited ,adj ,  tin , low , bridges); 
                    low[node] = Math.min(low[node] , low[adjNode]); 
                    if(low[adjNode] > tin[node]){
                        bridges.add(Arrays.asList(adjNode , node));
                    }
                }
                else{
                    low[node] = Math.min(low[node] , low[adjNode]); 
                }
            }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); 
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>()); 
        }
        for(List<Integer> it : connections){
            int u = it.get(0) ; 
            int v = it.get(1) ; 
            adj.get(u).add(v);
            adj.get(v).add(u); 
        }
        int visited[] = new int[n];
        int tin[]  = new int[n];
        int low[] = new int[n] ; 
        List<List<Integer>> bridges = new ArrayList<>(); 
        dfs(0 , -1 , visited, adj , tin , low , bridges); 
        return bridges ; 
    }
}