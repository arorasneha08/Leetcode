class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length ; 
        int m = grid[0].length; 
        int nums[] = new int[n*n +1] ; 

        for(int i = 0 ;  i< n ; i++){
            for(int j = 0 ; j < n ; j++){
                nums[grid[i][j]] ++ ; 
            }
        }
        int missing = 0 ;
        int repeating = 0; 
        for(int i = 0 ; i<= n*n ; i++){
            if(nums[i] > 1){
                missing = i ; 
            }
            if(nums[i] == 0){
                repeating = i ; 
            }
        }
        return new int[]{missing , repeating}; 
    }
}