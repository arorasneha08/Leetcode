class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length; 
        int ans[] = new int[n];
        for(int i = 0 ; i < n - 1; i++){
            if(nums[i] != 0){
                if(nums[i] == nums[i+1]){
                    ans[i] = 2 * nums[i] ;
                    nums[i+1] = 0 ; 
                }
                else{
                    ans[i] = nums[i]; 
                }
            }
        }
        ans[n-1] = nums[n-1]; 

        int index = 0 ; 
        for(int i = 0 ; i < n ; i++){
            if(ans[i] != 0){
                ans[index++] = ans[i] ; 
            }
        }
        for(int i = index ; i <n ; i++){
            ans[i] = 0 ; 
        }
        return ans ; 
    }
}