class Solution {
    public boolean func(int index , int target , Boolean[][] dp , int arr[]){
        if(target == 0) return true ;
        if(index == 0) return (arr[0] == target) ; 

        if(dp[index][target] != null) return dp[index][target];

        boolean notTake = func(index - 1 , target , dp , arr) ;
        boolean take = false; 
        if(arr[index] <= target) {
            take = func(index - 1 , target - arr[index] , dp, arr); 
        }
        return dp[index][target] = (take || notTake); 
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length; 
        int sum = 0 ; 
        for(int i = 0 ;i < n ; i++){
            sum += nums[i]; 
        }
        int target = sum / 2 ; 
        if(sum % 2 == 1) return false; 

        Boolean dp[][] = new Boolean[n][target+1]; 

        return func(n-1 , target , dp , nums); 
    }
}