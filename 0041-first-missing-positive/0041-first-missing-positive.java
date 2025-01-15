class Solution {
    public int firstMissingPositive(int[] arr) {
        // int n = nums.length;
        // int[] filteredNums = new int[n];
        // int k = 0;
        // for (int i = 0; i < n; i++) {
        //     if (nums[i] > 0) {
        //         filteredNums[k++] = nums[i]; 
        //     }
        // }
        // Arrays.sort(filteredNums, 0, k);
        // int target = 1;
        // for (int i = 0; i < k; i++) {
        //     if (filteredNums[i] == target) {
        //         target++; 
        //     } else if (filteredNums[i] > target) {
        //         return target; 
        //     }
        // }
        // return target;

        int n = arr.length ;
        for(int i = 0 ; i<n ; i++){
            while(arr[i] > 0 && arr[i] <=n && arr[i] != arr[arr[i]-1]){
                int temp = arr[arr[i]-1] ; 
                arr[arr[i]-1] = arr[i]; 
                arr[i] = temp; 
            }
        }
        for(int i = 0 ; i<n ; i++){
            if(arr[i] != i+1){
                return i+1 ; 
            }
        }
        return n+1 ; 
    }
}