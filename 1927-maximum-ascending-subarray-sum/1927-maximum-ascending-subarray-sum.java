class Solution {
    public int maxAscendingSum(int[] arr) {
        int n = arr.length ; 
        int maxSum = 0 ; 
        int sum = arr[0] ; 
        for(int i = 1 ; i < n ; i++){
            if(arr[i] <= arr[i-1]){
                maxSum = Math.max(maxSum , sum); 
                sum = 0 ; 
            }
            sum += arr[i]; 
        }
        maxSum = Math.max(maxSum , sum); 
        return maxSum ; 
    }
}