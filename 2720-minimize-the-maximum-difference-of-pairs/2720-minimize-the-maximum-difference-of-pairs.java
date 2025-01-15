class Solution {
    public boolean isPossible(int mid , int arr[] , int p){
        int count = 0 ; 
        for(int i = 1 ; i< arr.length ; i++){
            if(arr[i] - arr[i-1] <= mid){
                count ++ ; 
                i ++; 
            }
        }
        if(count < p) return false;
        return true ;
    }
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums) ; 
        int n = nums.length ;
        int start = 0 ;
        int end = nums[n-1] - nums[0]; 
        int ans =  0; 
        while(start <= end){
            int mid  = (start + end)/2  ;
            if(isPossible(mid , nums, p)){
                ans = mid ;
                end = mid - 1 ; 
            }
            else{
                start = mid + 1 ; 
            }
        }
        return ans ; 
    }
}