class Solution {
    private int findLargest(int num){
        int max = 0 ; 
        while(num!= 0){
            int r = num % 10; 
            max = Math.max(r , max); 
            num = num / 10; 
        }
        return max ; 
    }
    public int maxSum(int[] nums) {
        int n = nums.length ;
        int sum = -1; 
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { 
                if (findLargest(nums[i]) == findLargest(nums[j])) {
                    sum = Math.max(sum, nums[i] + nums[j]);  
                }
            }
        }
        return sum; 
    }
}