class Solution {
    public int func(int i , int j , int dp[][] , int matrix[][] , int n , int m){
        if(j < 0 || j > m - 1 || i < 0) return Integer.MAX_VALUE ; 
        if(i == 0 ) return matrix[i][j] ;
        if(dp[i][j] != -1) return dp[i][j] ; 

        int up = func(i-1 , j , dp , matrix , n , m); 
        int left = func(i-1, j-1 , dp , matrix , n, m);
        int right = func(i-1 ,j+1 , dp , matrix , n , m) ;

        int min = matrix[i][j] + Math.min(up , Math.min(left, right)); 
        return dp[i][j] = min ;  
    }
    public int minFallingPathSum(int[][] matrix) {
        // using memoisation :- 

        // int n = matrix.length;
        // int m = matrix[0].length ; 
        // int dp[][] = new int[n][m];
        // for(int[] row : dp){
        //     Arrays.fill(row , -1) ;
        // }
        // int minPathSum = Integer.MAX_VALUE;
        // for (int j = 0; j < m; j++) {
        //     minPathSum = Math.min(minPathSum, func(n - 1, j, dp, matrix, n, m));
        // }
        // return minPathSum;

        // using tabulation :- 

        // int n = matrix.length ; 
        // int m = matrix[0].length; 
        // int dp[][] = new int[n][m] ;

        // for(int j = 0 ; j < m ; j++){
        //     dp[0][j] = matrix[0][j]; 
        // }

        // int minPath = Integer.MAX_VALUE;

        // for(int i = 1 ; i< n ; i++){
        //     for(int j = 0;  j< m ; j++){
        //         int up = Integer.MAX_VALUE , left = Integer.MAX_VALUE , right = Integer.MAX_VALUE ; 
        //         if(i > 0 ){
        //             up = matrix[i][j] + dp[i-1][j] ;
        //         }
        //         if(i > 0 && j > 0){
        //             left = matrix[i][j] + dp[i-1][j-1] ;
        //         }
        //         if(i > 0 && j < m-1){
        //             right = matrix[i][j] + dp[i-1][j+1]; 
        //         }
        //         int min = Math.min(up , Math.min(left , right)); 
        //         dp[i][j] = min ; 
        //     }
        // }
        // // Find the minimum path sum in the last row
        // for (int j = 0; j < m; j++) {
        //     minPath = Math.min(minPath, dp[n-1][j]);
        // }
        // return minPath ; 

        // space optimisation :- 

        int n = matrix.length ; 
        int m = matrix[0].length; 
        int prev[] = new int[m]; 

        for(int j = 0 ; j < m ; j++){
            prev[j] = matrix[0][j]; 
        }

        int minPath = Integer.MAX_VALUE;

        for(int i = 1 ; i< n ; i++){
            int curr[] = new int[m]; 
            for(int j = 0;  j< m ; j++){
                int up = Integer.MAX_VALUE , left = Integer.MAX_VALUE , right = Integer.MAX_VALUE ; 
                if(i > 0 ){
                    up = matrix[i][j] + prev[j] ;
                }
                if(i > 0 && j > 0){
                    left = matrix[i][j] + prev[j-1] ;
                }
                if(i > 0 && j < m-1){
                    right = matrix[i][j] + prev[j+1]; 
                }
                curr[j] = Math.min(up , Math.min(left , right)); 
            }
            prev = curr ; 
        }
        // Find the minimum path sum in the last row
        for (int j = 0; j < m; j++) {
            minPath = Math.min(minPath, prev[j]);
        }
        return minPath ; 

    }
}