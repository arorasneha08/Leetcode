class Solution {
    public class Pair{
        int row ; 
        int col ; 
        Pair(int row , int col){
            this.row = row ; 
            this.col = col ; 
        }
    }
    public void bfs(int row, int col , char[][] grid, int[][] visited){
        int n = grid.length ; 
        int m = grid[0].length ; 

        visited[row][col] = 1 ;
        Queue<Pair> q = new LinkedList<>() ;
        q.add(new Pair(row, col)); 

        while(!q.isEmpty()){
            Pair curr = q.poll();
            int r = curr.row ;
            int c = curr.col ;

            int[] delRow = {-1, 1, 0, 0};
            int[] delCol = {0, 0, -1, 1};

            for(int i = 0; i < 4 ; i ++){
                int newRow = delRow[i] + r;
                int newCol = delCol[i] + c; 
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m 
                && visited[newRow][newCol] == 0 && grid[newRow][newCol] == '1'){
                    visited[newRow][newCol] = 1 ; 
                    q.add(new Pair(newRow, newCol)); 
                } 
            }
        }

    }
    public int numIslands(char[][] grid) {
        int n = grid.length ; 
        int m = grid[0].length ; 
        int count = 0 ; 
        int visited[][] = new int[n][m]; 
        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j< m ; j++){
                if(visited[i][j] == 0 && grid[i][j] == '1'){
                    count ++ ; 
                    bfs(i, j, grid, visited); 
                }
            }
        }
        return count ; 
    }
}