class Solution {
    public int func(int index , int target , int arr[] , int dp[][]){
        if(index == 0){
            if(arr[0] == 0 && target == 0) return 2 ; 
            if(target == 0 || arr[0] == target) return 1 ; 
            else return 0 ; 
        }
        if(dp[index][target] != -1) return dp[index][target] ;  
        if(arr[0] <= target) dp[0][arr[0]] = 1 ; 

        int notpick = func(index - 1  , target , arr, dp);
        int pick = 0 ; 
        if(arr[index] <= target){
            pick = func(index - 1 , target - arr[index] , arr, dp); 
        }
        dp[index][target] = pick + notpick ; 
        return dp[index][target]; 
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length; 
        int totalSum = 0 ;

        for(int num : nums){
            totalSum += num ; 
        }
        if ((totalSum - target) < 0 || (totalSum - target) % 2 != 0) return 0;
        int subsetSum = (totalSum - target) / 2;
        int dp[][] = new int[n][subsetSum + 1]; 

        for(int row[] : dp){
            Arrays.fill(row , -1) ;
        }
        return func(n-1 , subsetSum , nums, dp); 
    }
}