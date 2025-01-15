class Solution {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums); 
        int n = nums.length ;
        int res = nums[n-1] - nums[0] ; 
        for(int i= 1 ; i<n; i++){
            int minHeight = Math.min(nums[0] + k , nums[i] - k);
            int maxHeight = Math.max(nums[n-1] - k , nums[i-1] + k );
            res = Math.min(res , maxHeight - minHeight);
        }
        return res ; 
    }
}