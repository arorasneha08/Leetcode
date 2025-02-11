class Solution {
    public int func(int index , int target , int arr[] , int[][] dp){
        if(target == 0) return 1 ;
        if (index < 0) return 0;  
        if(index == 0){
            if(target % arr[0] == 0){
                return 1; 
            }
            else return 0; 
        }

        if(dp[index][target] != -1) return dp[index][target]; 
        int notpick = func(index - 1, target , arr, dp);

        int pick = 0; 
        if(arr[index] <= target){
            pick = func(index , target - arr[index] , arr, dp) ; 
        }
        return dp[index][target] = pick + notpick ; 
    }
    public int change(int amount, int[] coins) {
        // int n = coins.length; 
        // int[][] dp = new int[n][amount+1] ; 
        // for(int row[] : dp){
        //     Arrays.fill(row, -1) ;
        // }
        // int res = func(n-1 , amount , coins, dp); 
        // return res ; 

        // using tabulation :- 
        // int n = coins.length; 
        // int[][] dp = new int[n][amount+1] ; 

        // for(int i = 0 ; i < n ; i++){
        //     dp[i][0] = 1 ; 
        // }
        // for (int tar = 0; tar <= amount; tar++) {
        //     if (tar % coins[0] == 0) dp[0][tar] = 1;
        // }
        // for(int idx = 1 ; idx < n ; idx++){
        //     for(int tar = 0 ; tar <= amount; tar ++){
        //         int notpick = dp[idx-1][tar] ;
        //         int pick = 0 ;
        //         if(coins[idx] <= tar){
        //             pick = dp[idx][tar-coins[idx]]; 
        //         } 
        //         dp[idx][tar] = pick + notpick ; 
        //     }
        // }
        // return dp[n-1][amount] ; 

        // using space optimisation :- 1d array 
        int n = coins.length; 
        int[] prev = new int[amount+1] ; 

        for(int i = 0 ; i < n ; i++){
            prev[0] = 1 ; 
        }
        for (int tar = 0; tar <= amount; tar++) {
            if (tar % coins[0] == 0) prev[tar] = 1;
        }
        for(int idx = 1 ; idx < n ; idx++){
            for(int tar = 0 ; tar <= amount; tar ++){
                int notpick = prev[tar] ;
                int pick = 0 ;
                if(coins[idx] <= tar){
                    pick = prev[tar-coins[idx]]; 
                } 
                prev[tar] = pick + notpick ; 
            }
        }
        return prev[amount] ; 
    }
}