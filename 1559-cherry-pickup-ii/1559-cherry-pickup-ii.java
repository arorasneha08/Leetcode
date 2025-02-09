class Solution {
    public int func(int i , int j1 , int j2 , int dp[][][] , int grid[][] , int m , int n){
        if(j1 < 0 || j2 < 0 || j1 >= m || j2 >= m){
            return Integer.MIN_VALUE ; 
        }
        if(i == n-1){
            if(j1 == j2){
                return grid[i][j1]; 
            }
            else{
                return grid[i][j2] + grid[i][j1]; 
            }
        }
        if(dp[i][j1][j2] != -1) {
            return dp[i][j1][j2] ; 
        }
        int maxi = Integer.MIN_VALUE; 
        int delCol[] = {-1 , 0 , 1};

        for(int robot1 = -1 ; robot1 <= 1 ; robot1 ++){
            for(int robot2 = -1 ; robot2 <= 1 ; robot2 ++){
                int value = 0 ; 
                if(j1 == j2){
                    value =  grid[i][j1]; 
                }
                else{
                    value = grid[i][j2] + grid[i][j1]; 
                }
                value += func(i+1 , j1 + robot1 , j2 + robot2 , dp , grid , m ,n ); 
                maxi = Math.max(maxi , value); 
            }
        }
        return dp[i][j1][j2] = maxi;
    }
    public int cherryPickup(int[][] grid) {
        // int n = grid.length; 
        // int m = grid[0].length; 
        // int dp[][][] = new int[n][m][m];
        // for(int[][] layer : dp){
        //     for(int[] row : layer){
        //         Arrays.fill(row , -1) ;
        //     }
        // }
        // return func(0 , 0 , m-1 , dp , grid , m , n); 

        // using tabulation :- 

        // int n = grid.length; 
        // int m = grid[0].length; 
        // int dp[][][] = new int[n][m][m];
        // for(int[][] layer : dp){
        //     for(int[] row : layer){
        //         Arrays.fill(row , -1) ;
        //     }
        // }
        // for(int j1 = 0 ; j1 < m ; j1++){
        //     for(int j2 = 0 ; j2 < m ;j2++){
        //         if(j1 == j2){
        //             dp[n-1][j1][j2] = grid[n-1][j1]; 
        //         }
        //         else{
        //             dp[n-1][j1][j2] = grid[n-1][j1] + grid[n-1][j2]; 
        //         }
        //     }
        // }
        // for(int i = n-2 ; i>= 0 ; i--){
        //     for(int j1 = 0 ; j1 < m ; j1 ++){
        //         for(int j2 = 0 ; j2 < m ; j2 ++){
        //             int maxi = Integer.MIN_VALUE ; 
        //             for(int dj1 = -1 ; dj1 <= 1 ; dj1 ++){
        //                 for(int dj2 = -1 ; dj2 <= 1 ; dj2 ++){
        //                     int value = 0 ;
        //                     if(j1 == j2){
        //                         value = grid[i][j1] ;
        //                     }
        //                     else{
        //                         value = grid[i][j2] + grid[i][j1]; 
        //                     }
        //                     if(j1 + dj1 >= 0 && j1 + dj1 < m && j2 + dj2 >= 0 && j2 + dj2 < m){
        //                         value += dp[i+1][j1 + dj1][j2 + dj2]; 
        //                     }
        //                     else{
        //                         value = Integer.MIN_VALUE;  
        //                     }
        //                     maxi = Math.max(maxi , value) ; 
        //                 }
        //             }
        //             dp[i][j1][j2] = maxi ; 
        //         }
        //     }
        // }
        // return dp[0][0][m-1]; 

        // space optimisation :- 

        int n = grid.length; 
        int m = grid[0].length; 
        
        int[][] next = new int[m][m];
        int[][] curr = new int[m][m];

        for(int j1 = 0; j1 < m; j1++) {
            for(int j2 = 0; j2 < m; j2++) {
                if (j1 == j2) {
                    next[j1][j2] = grid[n-1][j1]; 
                } else {
                    next[j1][j2] = grid[n-1][j1] + grid[n-1][j2]; 
                }
            }
        }

        for(int i = n-2; i >= 0; i--) {
            for(int j1 = 0; j1 < m; j1++) {
                for(int j2 = 0; j2 < m; j2++) {
                    int maxi = Integer.MIN_VALUE;
                    for(int dj1 = -1; dj1 <= 1; dj1++) {
                        for(int dj2 = -1; dj2 <= 1; dj2++) {
                            int value = 0;

                            if(j1 == j2) {
                                value = grid[i][j1];
                            } else {
                                value = grid[i][j1] + grid[i][j2];
                            }

                            if(j1 + dj1 >= 0 && j1 + dj1 < m && j2 + dj2 >= 0 && j2 + dj2 < m) {
                                value += next[j1 + dj1][j2 + dj2]; 
                            }

                            maxi = Math.max(maxi, value); 
                        }
                    }
                    curr[j1][j2] = maxi;
                }
            }
            
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    next[j1][j2] = curr[j1][j2]; 
                }
            }
        }

        return next[0][m-1]; 
    }
}