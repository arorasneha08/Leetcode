class Solution {
    private boolean isPossible(int mid , int arr[] , long k){
        long child = 0 ; 
        for(int i = 0 ;  i< arr.length ; i++){
            child += (arr[i] / mid) ;
        }
        if(child >= k) return true; 
        return false; 
    }
    public int maximumCandies(int[] candies, long k) {
        int n = candies.length ; 
        int start = 1 ;
        int end = 0 ;
        int res = 0  ; 
        for(int i = 0 ; i < n ; i++){
            end = Math.max(candies[i] , end); 
        } 
        while(start <= end){
            int mid = start + (end - start)/2 ; 

            if(isPossible(mid , candies , k)){
                res = mid ;
                start = mid + 1 ; 
            }
            else{
                end = mid - 1 ; 
            }
        }
        return res ; 
    }
}