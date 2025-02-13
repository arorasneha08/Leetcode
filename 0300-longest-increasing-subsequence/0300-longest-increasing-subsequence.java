class Solution {
    public int func(int index , int prev_idx , int nums[] , int dp[][]){
        if(index == nums.length) return 0 ; 

        if(dp[index][prev_idx+1] != -1) return dp[index][prev_idx+1];

        int notpick = func(index + 1 , prev_idx , nums , dp);
        int pick = 0 ;
        if(prev_idx == -1 || nums[index] > nums[prev_idx]){
            pick = 1 + func(index + 1 , index , nums ,dp) ; 
        }
        int len = Math.max(pick , notpick);
        return dp[index][prev_idx+1] = len ; 
    }
    public int lengthOfLIS(int[] nums) {
        // int n = nums.length ;
        // int dp[][] = new int[n][n+1];
        // for(int row[] : dp){
        //     Arrays.fill(row , -1) ;
        // }
        // return func(0 , -1 , nums , dp); 

        // using tabulation :- 
        // int n = nums.length ;
        // int dp[][] = new int[n+1][n+1];
        // for(int index = n-1 ; index >= 0 ; index --){
        //     for(int prevIdx = index-1 ; prevIdx >= -1 ; prevIdx --){
        //         int notpick = dp[index+1][prevIdx+1]; 
        //         int pick = 0 ;
        //         if(prevIdx == -1 || nums[index] > nums[prevIdx]){
        //             pick = 1 + dp[index+1][index+1]; 
        //         }
        //         int len = Math.max(pick , notpick);
        //         dp[index][prevIdx+1]= len ; 
        //     }
        // }
        // return dp[0][0]; 

        // using space optimisation :- 
        int n = nums.length ;
        int next[] = new int[n+1];
        for(int index = n-1 ; index >= 0 ; index --){
            int curr[] = new int[n+1]; 
            for(int prevIdx = index-1 ; prevIdx >= -1 ; prevIdx --){
                int notpick = next[prevIdx+1]; 
                int pick = 0 ;
                if(prevIdx == -1 || nums[index] > nums[prevIdx]){
                    pick = 1 + next[index+1]; 
                }
                int len = Math.max(pick , notpick);
                curr[prevIdx+1]= len ; 
            }
            next = curr; 
        }
        return next[0]; 
    }
}