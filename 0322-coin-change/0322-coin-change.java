class Solution {
    public int func(int index , int target , int[] arr , int[][] dp){
        if(index == 0){
            if(target % arr[0] == 0){
                return target / arr[0] ; 
            }
            else return Integer.MAX_VALUE; 
        }
        if(dp[index][target] != -1) return dp[index][target]; 

        int notpick = func(index - 1 , target , arr , dp); 
        int pick = Integer.MAX_VALUE;  
        if(arr[index] <= target){
            int res = func(index , target- arr[index], arr, dp); 
            if(res != Integer.MAX_VALUE){
                pick = 1 + res ; 
            }
        }
        return dp[index][target] = Math.min(pick , notpick); 
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length; 
        int dp[][] = new int[n][amount+1] ;
        for(int row[] : dp){
            Arrays.fill(row , -1);
        }
        int result = func(n-1 , amount , coins, dp); 
        if(result == Integer.MAX_VALUE){
            return -1 ; 
        }
        return result ;  
    }
}