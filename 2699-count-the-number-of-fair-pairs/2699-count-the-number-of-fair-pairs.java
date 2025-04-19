class Solution {
    private long countPairs(int arr[] , long target){
        long count = 0 ; 
        int left = 0 ;
        int n = arr.length ; 
        int right = n-1; 
        while(left < right){
            if(arr[left] + arr[right] >= target){
                count += (right - left); 
                right --; 
            }
            else{
                left ++ ; 
            }
        }
        return count; 
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return countPairs(nums , lower) - countPairs(nums , upper + 1); 
    }
}