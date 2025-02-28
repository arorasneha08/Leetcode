class Solution {
    public int[] shuffle(int[] nums, int n) {
        int ans[] = new int[nums.length] ; 
        int i = 0 ;
        int j = n ; 
        int index= 0 ; 
        while(i < n && j < nums.length){
            if(i < n) ans[index++] = nums[i++];
            if(j < nums.length) ans[index++] = nums[j++]; 
        }
        return ans ; 
    }
}