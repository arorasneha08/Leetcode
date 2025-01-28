class Solution {
    public class Pair{
        int row; 
        int col ; 
        Pair(int r , int c){
            row = r ;
            col = c ; 
        }
    }
    public int countFishes(int row , int col , int[][] grid , int[][] visited){
        int n = grid.length ; 
        int m = grid[0].length ; 
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(row , col)); 
        visited[row][col] = 1 ; 

        int count = 0 ; 
        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, -1, 0, 1};

        while(!q.isEmpty()){
            Pair curr = q.poll();
            int r = curr.row ;
            int c = curr.col ; 
            count += grid[r][c] ; 

            for(int i = 0 ; i<4 ; i++){
                int newRow = delRow[i] + r ;
                int newCol = delCol[i] + c ; 

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol <m && visited[newRow][newCol] == 0 && grid[newRow][newCol] > 0){
                    visited[newRow][newCol] = 1 ; 
                    q.offer(new Pair(newRow , newCol)); 
                }
            }
        }
        return count ; 
    }
    public int findMaxFish(int[][] grid) {
        int n = grid.length ; 
        int m = grid[0].length ; 
        int visited[][] = new int[n][m];
        int result = 0 ; 

        for(int i = 0 ; i <n ; i++){
            for(int j = 0 ; j<m ; j++){
                if(visited[i][j] == 0 && grid[i][j] > 0){
                    result = Math.max(result , countFishes(i, j , grid, visited)) ; 
                }
            }
        }
        return result; 
    }
}