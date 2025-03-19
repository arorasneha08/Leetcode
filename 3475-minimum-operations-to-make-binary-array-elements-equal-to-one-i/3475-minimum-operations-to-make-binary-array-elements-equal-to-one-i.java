class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length ;
        int count = 0 ; 
        for(int i = 2 ; i < n ; i++){
            if(nums[i-2] == 0){
                nums[i] ^= 1  ;
                nums[i-1] ^= 1 ; 
                nums[i-2] ^= 1 ; 
                count ++ ; 
            }
        }
        for(int i = 0 ; i < n ; i++){
            if(nums[i] == 0){
                return -1;  
            }
        }
        return count; 
    }
}