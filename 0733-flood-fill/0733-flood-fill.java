class Solution {
    public void dfs(int row , int col , int [][] image , int newColor, int initialColor, int n , int m, int[][] ans){
        ans[row][col] =  newColor;
        int delRow[] = {-1, 0 , 0 , 1};
        int delCol[] = {0 , 1 , -1 , 0}; 
        for(int i = 0 ; i<4 ; i++){
            int newRow = row + delRow[i] ;
            int newCol = col + delCol[i] ; 
            if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m 
            && image[newRow][newCol] == initialColor && ans[newRow][newCol] != newColor){
                dfs(newRow, newCol , image , newColor, initialColor, n, m, ans); 
            }
        }

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor = image[sr][sc] ; 
        int n = image.length ;
        int m = image[0].length ; 
        int[][] ans = new int[n][m] ; 
        for(int i = 0; i<n ; i++){
            for(int j = 0 ; j<m ;j++){
                ans[i][j] = image[i][j]; 
            }
        }
        dfs(sr, sc, image , color, initialColor, n, m, ans); 
        return ans ; 
    }
}