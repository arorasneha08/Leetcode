class Solution {
    public int func(int index , int target , int[] arr , int[][] dp){
        if(index == 0){
            if(target % arr[0] == 0){
                return target / arr[0] ; 
            }
            else return (int) 1e9; 
        }
        if(dp[index][target] != -1) return dp[index][target]; 

        int notpick = func(index - 1 , target , arr , dp); 
        int pick = (int) 1e9 ;  
        if(arr[index] <= target){
            pick = 1 + func(index , target- arr[index], arr, dp); 
        }
        return dp[index][target] = Math.min(pick , notpick); 
    }
    public int coinChange(int[] coins, int amount) {
        // int n = coins.length; 
        // int dp[][] = new int[n][amount+1] ;
        // for(int row[] : dp){
        //     Arrays.fill(row , -1);
        // }
        // int result = func(n-1 , amount , coins, dp); 
        // if(result == (int) 1e9){
        //     return -1 ; 
        // }
        // return result ;  

        // using tabulation :- 
        // int n = coins.length; 
        // int dp[][]= new int[n][amount+1]; 

        // for(int i = 0 ; i <= amount ; i++){
        //     if(i % coins[0] == 0){
        //         dp[0][i] = i / coins[0]; 
        //     }
        //     else dp[0][i] = (int) 1e9 ; 
        // }
        // for(int idx = 1 ; idx < n ; idx ++){
        //     for(int tar = 0 ; tar <= amount ; tar ++){
        //         int notpick = dp[idx-1][tar];
        //         int pick = (int) 1e9; 
        //         if(coins[idx] <= tar){
        //             pick = 1 + dp[idx][tar-coins[idx]]; 
        //         }
        //         dp[idx][tar] = Math.min(pick, notpick); 
        //     }
        // }
        // int res = dp[n-1][amount]; 
        // if(res == (int) 1e9) return -1  ;
        // return res ; 

        // using space optimisation:- 
        int n = coins.length; 
        int prev[]= new int[amount+1]; 

        for(int i = 0 ; i <= amount ; i++){
            if(i % coins[0] == 0){
                prev[i] = i / coins[0]; 
            }
            else prev[i] = (int) 1e9 ; 
        }
        for(int idx = 1 ; idx < n ; idx ++){
            int curr[] = new int[amount+1]; 
            for(int tar = 0 ; tar <= amount ; tar ++){
                int notpick = prev[tar];
                int pick = (int) 1e9; 
                if(coins[idx] <= tar){
                    pick = 1 + curr[tar-coins[idx]]; 
                }
                curr[tar] = Math.min(pick, notpick); 
            }
            prev = curr; 
        }
        int res = prev[amount]; 
        if(res == (int) 1e9) return -1  ;
        return res ; 
    }
}