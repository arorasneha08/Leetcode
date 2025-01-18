class Solution {
    public boolean check(int start , int n , int graph[][] , int color[]){
        Queue<Integer> q = new LinkedList<>() ; 
        q.offer(start); 
        color[start] = 0 ;

        while(!q.isEmpty()){
            int currNode = q.poll(); 

            for(int adjNode : graph[currNode]){
                if(color[adjNode] == -1){
                    color[adjNode] = 1 - color[currNode] ; 
                    q.offer(adjNode); 
                }
                else if(color[adjNode] == color[currNode] ){
                    return false ;
                }
            }
        }
        return true; 
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length ;
        int m = graph[0].length ; 
        int color[] = new int[n] ;
        Arrays.fill(color, -1);

        for(int i = 0 ; i < n ; i++){
            if(color[i] == -1){
                if(check(i , n , graph , color) == false){
                    return false ; 
                }
            }
        } 
        return true ; 
    }
}