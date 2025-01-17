class Solution {
    public class Pair{
        int row ;
        int col ;
        Pair(int r, int c){
            row = r ;
            col = c;  
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length ;
        int m = grid[0].length;
        int minutes = 0 ; 
        int fresh = 0 ; 
        Queue<Pair> q = new LinkedList<>() ;
        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j)); 
                }
                else if(grid[i][j] == 1){
                    fresh ++ ; 
                }
            }
        }
        if(fresh == 0) { // all oranges are rotten 
            return 0 ; 
        }
        int delRow[] = {0,-1,0,1};
        int delCol[] = {-1,0,1,0}; 

        while(!q.isEmpty()){
            int size = q.size();
            boolean rotted = false; 

            for(int i = 0 ; i<size;  i++){
                Pair curr = q.poll() ;
                int r = curr.row ;
                int c = curr.col ; 

                for(int j = 0 ; j< 4 ; j++){
                    int newRow = r + delRow[j]; 
                    int newCol = c + delCol[j] ; 

                    if(newRow >= 0 && newCol < m && newCol >= 0 && newRow < n && grid[newRow][newCol] == 1){
                        grid[newRow][newCol] = 2 ; 
                        fresh -- ; 
                        q.add(new Pair(newRow, newCol)); 
                        rotted = true ;
                    }
                }
            }
            if(rotted) minutes ++ ; 
        }
        if(fresh == 0){
            return minutes ; 
        }
        return -1  ;
    }
}