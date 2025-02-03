class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length ; 
        int incLength = 1 , decLength = 1 ;
        int maxLen = 1 ;
        for(int i = 0 ; i< n-1 ; i++){
            if(nums[i+1] > nums[i]){
                incLength ++ ; 
                decLength = 1 ; 
            }
            else if(nums[i+1] < nums[i]){
                decLength ++ ; 
                incLength = 1 ; 
            }
            else{
                decLength = 1 ;
                incLength = 1 ; 
            }
            maxLen = Math.max(maxLen , Math.max(decLength , incLength)); 
        }
        return maxLen ; 
    }
}