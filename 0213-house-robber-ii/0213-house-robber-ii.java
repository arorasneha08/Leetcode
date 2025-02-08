class Solution {
    public int robAdj(int nums[]){
        int n = nums.length ; 
        int prev = nums[0];
        int prev2 = 0 ;
        for(int i = 1 ; i< n ; i++){
            int pick = nums[i] ;
            if(i > 1){
                pick += prev2; 
            }
            int notpick = prev ; 
            int curr = Math.max(pick , notpick); 
            prev2 = prev ; 
            prev = curr ; 
        }
        return prev ; 
    }
    public int rob(int[] nums) {
        int n = nums.length; 
        if(n == 1) return nums[0]; 
        int[] temp1 = new int[n - 1];
        int[] temp2 = new int[n - 1];

        for (int i = 0; i < n; i++) {
            if (i != 0) temp1[i - 1] = nums[i]; 
            if (i != n - 1) temp2[i] = nums[i];
        }
        return Math.max(robAdj(temp1), robAdj(temp2));
    }
}