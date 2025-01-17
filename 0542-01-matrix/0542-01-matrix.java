class Solution {
    public class Pair{
        int row ;
        int col ; 
        int steps ;
        Pair(int r , int c , int s){
            row = r ;
            col = c ; 
            steps = s ;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length ; 
        int m = mat[0].length ; 
        int visited[][] = new int[n][m] ; 
        int distance[][] = new int[n][m] ; 

        Queue<Pair> q = new LinkedList<>()  ;

        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                if(mat[i][j] == 0){
                    q.offer(new Pair(i,j,0)); 
                    visited[i][j] = 1 ; 
                }
                else{
                    visited[i][j] = 0 ; 
                }
            }
        }

        int delRow[] = {-1,0,1,0}; 
        int delCol[] = {0,-1,0,1} ; 

        while(!q.isEmpty()){
            Pair curr = q.poll() ; 
            int r = curr.row ;
            int c = curr.col ;
            int s = curr.steps; 

            distance[r][c] = s; 

            for(int i = 0 ; i < 4 ; i++){
                int newRow = delRow[i] + r ;
                int newCol = delCol[i] + c ;

                if(newRow >= 0 && newRow < n  && newCol >= 0 && newCol < m && mat[newRow][newCol] == 1 && visited[newRow][newCol] == 0){
                    visited[newRow][newCol] = 1; 
                    q.offer(new Pair(newRow , newCol , s + 1)); 
                }
            }
        }
        return distance ;
    }
}