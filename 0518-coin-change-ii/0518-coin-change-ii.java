class Solution {
    public int func(int index , int target , int arr[] , int[][] dp){
        if(target == 0) return 1 ;
        if (index < 0) return 0;  

        if(dp[index][target] != -1) return dp[index][target]; 
        int notpick = func(index - 1, target , arr, dp);

        int pick = 0; 
        if(arr[index] <= target){
            pick = func(index , target - arr[index] , arr, dp) ; 
        }
        return dp[index][target] = pick + notpick ; 
    }
    public int change(int amount, int[] coins) {
        int n = coins.length; 
        int[][] dp = new int[n][amount+1] ; 
        for(int row[] : dp){
            Arrays.fill(row, -1) ;
        }
        int res = func(n-1 , amount , coins, dp); 
        return res ; 
    }
}