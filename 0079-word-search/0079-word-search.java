class Solution {
    public boolean dfs(char[][] board ,int index , int row , int col , int[][] visited , int len , int n , int m, String word){
        if(index == len) return true ; 

        if(row < 0 || row >= n || col < 0 || col >= m || visited[row][col] == 1 || board[row][col] != word.charAt(index)){
            return false; 
        }

        visited[row][col] = 1; 

        if(dfs(board , index + 1 , row , col-1 , visited , len , n , m , word) ||
        dfs(board , index + 1 , row , col + 1 , visited ,len,  n , m , word) ||
        dfs(board , index + 1 , row - 1, col , visited ,len, n , m , word) ||
        dfs(board , index + 1 , row + 1 , col , visited , len , n , m , word)){
            return true ;
        }

        visited[row][col] = 0; 

        return false ; 
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length ; 
        int m = board[0].length ; 
        int len = word.length(); 
        int visited[][] = new int[n][m] ; 
        for(int i = 0; i < n ; i++){
            for(int j = 0 ; j< m ; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board ,0 , i ,j , visited , len , n , m , word)) return true ; 
                }
            }
        }
        return false; 
    }
}