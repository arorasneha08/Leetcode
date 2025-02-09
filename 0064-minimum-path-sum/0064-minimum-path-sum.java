class Solution {
    public int func(int i , int j , int dp[][] , int grid[][]){
        if(i < 0 || j < 0) return Integer.MAX_VALUE ; 
        if(i == 0 && j == 0) return grid[i][j] ; 
        if(dp[i][j] != -1) return dp[i][j] ; 

        int up = func(i-1, j, dp , grid) ; 
        int left = func(i, j-1 , dp , grid) ;

        dp[i][j] = grid[i][j] + Math.min(up , left);  
        return dp[i][j] ; 
    }
    public int minPathSum(int[][] grid) {
        // using memoisation :- 
        int n = grid.length ; 
        int m = grid[0].length; 
        int dp[][] = new int[n][m] ;

        for(int[] row : dp){
            Arrays.fill(row , -1) ;
        }
        return func(n-1, m-1, dp, grid) ; 
    }
}