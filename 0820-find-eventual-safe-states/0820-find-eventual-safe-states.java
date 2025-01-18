class Solution {
    public boolean check(int node , int[][] graph , List<Integer> list , int[] visited, int[] pathVisited , int check[]){
        visited[node] = 1 ;
        pathVisited[node] = 1 ; 
        check[node] = 0 ; 

        for(int adjNode : graph[node]){
            if(visited[adjNode] == 0){
                if(check(adjNode , graph , list , visited , pathVisited , check) == true){
                    return true ; 
                }
            }
            else if(pathVisited[adjNode] == 1){
                return true ; 
            }
        }
        check[node] = 1 ; 
        pathVisited[node] = 0 ; 
        return false; 
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length ;
        int m = graph[0].length ; 
        int visited[] = new int[n];
        int pathVisited[] = new int[n] ; 
        int check[] = new int[n] ; 
        List<Integer> list = new ArrayList<>() ; 

        for(int i = 0 ; i<n ; i++){
            if(visited[i] == 0){
                check(i, graph , list , visited, pathVisited, check) ; 
            }
        }
        for(int i = 0 ; i<n ; i++){
            if(check[i] == 1){
                list.add(i) ; 
            }
        }
        return list ; 
    }
}