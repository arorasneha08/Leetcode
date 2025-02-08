class Solution {
    public int func(int i , int j , int dp[][] , int[][] obstacleGrid){
        if(i == 0  && j == 0) return 1 ; 
        if(i >= 0 && j >= 0 && obstacleGrid[i][j] == 1) return 0 ; 
        if(i < 0 || j < 0) return 0 ;
        if(dp[i][j] != -1) return dp[i][j] ; 

        int up = func(i-1, j, dp , obstacleGrid);
        int down = func(i , j-1 , dp , obstacleGrid);
        return dp[i][j] = up + down ;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // using memoization :- 
        int n = obstacleGrid.length; 
        int m = obstacleGrid[0].length ; 
        
        if (obstacleGrid[0][0] == 1) return 0;

        int dp[][] = new int[n][m] ;
        for(int[] row : dp){
            Arrays.fill(row , -1); 
        }
        return func(n-1, m-1 , dp , obstacleGrid); 
    }
}