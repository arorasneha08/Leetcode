class Solution {
    public int func(int index , int last , int grid[][] , int dp[][] , int n){
        if(index == 0){
            int min = Integer.MAX_VALUE ;
            for(int i = 0 ; i < n ; i++){
                if(i != last){
                    min = Math.min(min , grid[0][i]); 
                }
            }
            return min ; 
        }
        if(dp[index][last] != -1) return dp[index][last]; 

        int min = Integer.MAX_VALUE ;
        for(int i = 0 ; i < n ; i++){
            if(i != last){
                int sum = grid[index][i] + func(index - 1 , i , grid , dp , n);  
                min = Math.min(min , sum); 
            }
        }
        return dp[index][last] = min ; 
    }
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length ; 
        int dp[][] = new int[n][n+1]; 
        for(int[] row : dp){
            Arrays.fill(row , -1); 
        }

        return func(n-1 , n, grid , dp , n); 
    }
}