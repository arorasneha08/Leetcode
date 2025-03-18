class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length ;
        int left = 0 , right = 0 ; 
        int used_bits = 0 ; 
        int maxLen = 1 ; 
        while(right < n){
            while((used_bits & nums[right])!= 0){
                used_bits ^= nums[left];
                left++ ; 
            }
            used_bits |= nums[right]; 
            maxLen = Math.max(maxLen , right - left + 1); 
            right ++; 
        }
        return maxLen ; 
    }
}