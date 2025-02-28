class Solution {
    public int[] smallerNumbersThanCurrent(int[] arr) {
        int n = arr.length;
        int ans[] = new int[n];
        int maxCount = 0 ;
        for(int i = 0 ; i < n ; i++){
            int count = 0 ; 
            for(int j = 0 ; j < n ; j++){
                if(arr[j] < arr[i]){
                    count ++ ; 
                }
            }
            ans[i] = count; 
        }
        return ans; 
    }
}