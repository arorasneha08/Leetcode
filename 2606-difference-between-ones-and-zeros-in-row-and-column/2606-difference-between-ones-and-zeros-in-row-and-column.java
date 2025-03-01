class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length ;
        int m = grid[0].length ; 
        int oneRow[] = new int[n]; 
        int oneCol[] = new int[m] ; 

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                oneRow[i] += grid[i][j]; 
                oneCol[j] += grid[i][j] ; 
            }
        }
        int diff[][] = new int[n][m] ; 
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                diff[i][j] = 2 * oneRow[i] + 2 * oneCol[j] - n - m ; 
            }
        }
        return diff ; 
    }
}