class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length ;
        Arrays.sort(nums);
        long currSum = 0 ; 
        int maxFreq = 0 ; 
        int left= 0  , right = 0 ; 
        while(right < n ){
            currSum += nums[right];

            if(currSum + k < (long) nums[right] * (right- left + 1)){
                currSum -= nums[left];
                left ++ ; 
            }
            maxFreq = Math.max(maxFreq , right - left + 1) ; 
            right ++ ; 
        }
        return maxFreq; 
    }
}