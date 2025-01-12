class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int i  = 0 ; i< nums.length ; i++){
            sum += nums[i];
        }
        int runningSum = 0 ;
        for(int i = 0 ; i<nums.length ; i++){
            if(runningSum == sum - nums[i] - runningSum){
                return i ; 
            }
            runningSum += nums[i];
        }
        return -1; 
    }
}