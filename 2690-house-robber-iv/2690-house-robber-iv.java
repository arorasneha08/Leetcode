class Solution {
    private boolean isPossible(int mid , int arr[] , int k){
        int count = 0 ; 
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] <= mid){
                count ++ ; 
                i++ ; 
            }
        }
        if(count >= k) return true ;
        return false; 
    }
    public int minCapability(int[] nums, int k) {
        int n = nums.length ;
        int start = 1 ; 
        int end = 0 ; 
        for(int i = 0 ; i < n ; i++){
            end = Math.max(end , nums[i]); 
        }
        int ans = 0 ; 
        while(start <= end){
            int mid = start + (end - start)/2 ; 
            if(isPossible(mid , nums , k)){
                ans = mid ; 
                end = mid - 1 ; 
            }
            else{
                start = mid + 1 ; 
            }
        }
        return ans;
    }
}