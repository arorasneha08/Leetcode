class Solution {
    public int findMin(int[] arr) {
        int n = arr.length ; 
        int start =  0 ;
        int end = n-1 ; 
        int ans = arr[n-1] ; 
        while(start <= end){
            int mid = (start + end )/2;
            if(arr[mid] > arr[n-1]){
                start = mid + 1 ; 
            }
            else if(arr[mid] < arr[n-1]){
                ans = arr[mid] ; 
                end = mid - 1; 
            }
            else{
                end -- ; 
            }
        }
        return ans;
    }
}