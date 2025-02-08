class Solution {
    public int func(int i , int j , int dp[][]){
        if(i == 0 && j == 0) return 1 ; // reached the valid position 
        if(i < 0 || j < 0) return 0 ; 
        if(dp[i][j] != -1 ) return dp[i][j];

        int up = func(i-1, j, dp);
        int down = func(i , j-1 , dp);
        dp[i][j] = up + down ; 
        return dp[i][j] ; 
    }
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[n][m] ;
        for(int row [] : dp){
            Arrays.fill(row , -1) ; 
        }
        return func(n-1, m-1 , dp); 
    }
}