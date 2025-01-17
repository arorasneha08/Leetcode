class Solution {
    public void dfs(int row, int col, char[][] board , int[][] visited, int n , int m){
        visited[row][col] = 1 ;

        int delRow [] = {-1,0,1,0} ;
        int delCol [] = {0,-1,0,1} ; 

        for(int i = 0 ; i<4 ; i++){
            int newRow = delRow[i] + row ;
            int newCol = delCol[i] + col ; 

            if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m 
                && visited[newRow][newCol] == 0 && board[newRow][newCol] == 'O'){
                dfs(newRow, newCol, board , visited , n , m); 
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length  ;
        int m = board[0].length ; 
        int visited[][] = new int[n][m] ;

        for(int j = 0 ; j< m ; j++){
            if(visited[0][j] == 0 && board[0][j] == 'O'){
                dfs(0, j, board , visited , n , m) ; 
            }
            if(visited[n-1][j] == 0 && board[n-1][j] == 'O'){
                dfs(n-1, j, board , visited , n , m); 
            }
        }

        for(int i = 0 ; i<n ; i++){
            if(visited[i][0] == 0 && board[i][0] == 'O'){
                dfs(i, 0 , board , visited , n , m); 
            }
            if(visited[i][m-1] == 0 && board[i][m-1] == 'O'){
                dfs(i, m-1 , board , visited , n , m); 
            }
        }
        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(visited[i][j] == 0 && board[i][j] == 'O'){
                    board[i][j] = 'X' ; 
                }
            }
        }
    }
}