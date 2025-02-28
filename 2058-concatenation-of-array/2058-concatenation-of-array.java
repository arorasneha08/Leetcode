class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length; 
        int len = 2 * n ; 
        int ans[] = new int[len];
        for(int i = 0 ; i < 2*n ; i++){
            ans[i] = nums[i % n] ; 
        }
        return ans ; 
    }
}