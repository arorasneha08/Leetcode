class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length; 
        int max_sum = 0 ; 
        int min_sum = 0 ; 
        int max_end = 0 ;
        int min_end = 0 ; 
        for(int i = 0 ; i < n ; i++){
            max_end += nums[i];
            min_end += nums[i];

            max_sum = Math.max(max_sum , max_end);
            min_sum = Math.min(min_sum , min_end);

            if(max_end < 0) max_end =  0 ;
            if(min_end > 0) min_end = 0 ;
        }
        return Math.max(max_sum , Math.abs(min_sum)); 
    }
}