class Solution {
    public int func(int index , int arr[], int dp[]){
        if(index == 0) return dp[index] = arr[index] ; 
        if(index < 0 )return 0 ; 
        if(dp[index] != -1) return dp[index];  
        int pick = arr[index] ; 
        if(index >= 2){
            pick +=  func(index -2 , arr, dp) ; 
        }
        int notpick = func(index - 1 , arr, dp) ; 
        return dp[index] = Math.max(pick , notpick);  
    }
    public int rob(int[] nums) {
        int n = nums.length ; 
        int dp[] = new int[n+1]; 
        if (n == 0) return 0;
        Arrays.fill(dp , -1) ;
        func(n-1 , nums , dp) ; 
        return dp[n-1]; 
    }
}