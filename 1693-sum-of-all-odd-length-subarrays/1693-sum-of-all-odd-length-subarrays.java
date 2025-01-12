class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length ; 
        int ans = 0 ; 
        for(int i = 0 ; i<n ; i++){
            ans += (((i+1) * (n-i) + 1 )/ 2) * arr[i] ; 
        }
        return ans ;
    }
}