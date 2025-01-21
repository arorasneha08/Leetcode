class Solution {
    public long gridGame(int[][] grid) {
        int n = grid.length ;
        int m = grid[0].length ; 
        long topSum  = 0; 
        long bottomSum = 0 ; 
        for(int i = 0 ; i< m ; i++){
            topSum += grid[0][i];
        }
        long min = Long.MAX_VALUE; 
        for(int i = 0 ; i< m ;i++){
            topSum -= grid[0][i];
            min = Math.min(min , Math.max(topSum , bottomSum));
            bottomSum += grid[1][i]; 
        }
        return min ;
    }
}