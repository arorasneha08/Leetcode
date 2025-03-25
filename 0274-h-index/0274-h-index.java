class Solution {
    public int hIndex(int[] arr) {
        Arrays.sort(arr); 
        int n = arr.length  ; 
        int hIdx = 0 ;
        for(int i = 0 ; i < n ; i++){
            int tempIdx = Math.min(n-i , arr[i]);
            hIdx = Math.max(hIdx , tempIdx); 
        }
        return hIdx ; 
    }
}