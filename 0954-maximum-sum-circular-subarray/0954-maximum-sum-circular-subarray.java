class Solution {
    private int totalSum(int arr[]){
        int n  = arr.length; 
        int sum = 0 ; 
        for(int i = 0 ; i<n ; i++){
            sum += arr[i];
        }
        return sum ; 
    }
    private int maxSubarraySum(int arr[]){
        int n = arr.length ; 
        int sum = 0 , maxSum = Integer.MIN_VALUE; 
        for(int i = 0 ; i<n ; i++){
            sum = Math.max(arr[i], arr[i] + sum); 
            maxSum = Math.max(maxSum, sum) ; 
        }
        return maxSum ; 
    }
    private int minSubarraySum(int arr[]){
        int n = arr.length ; 
        int sum = 0 , minSum = Integer.MAX_VALUE; 
        for(int i = 0 ; i<n ; i++){
            sum = Math.min(arr[i], sum + arr[i]); 
            minSum = Math.min(minSum, sum) ; 
        }
        return minSum ; 
    }
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length ; 
        int totalSum = totalSum(nums); 
        int maxSum = maxSubarraySum(nums);
        int minSum = minSubarraySum(nums);
        int circularSum = totalSum - minSum ; 
        if(maxSum > 0){
            return Math.max(maxSum, circularSum) ; 
        }
        return maxSum ; 
    }
}