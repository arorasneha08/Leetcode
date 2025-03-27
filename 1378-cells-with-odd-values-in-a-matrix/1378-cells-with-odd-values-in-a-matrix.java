class Solution {
    private void mark(int row , int col ,int mat[][], int m , int n){
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i == row) mat[i][j] += 1 ; 
                if(j == col) mat[i][j] += 1 ; 
            }
        }
    }
    public int oddCells(int m, int n, int[][] indices) {
        int mat[][] = new int[m][n] ; 

        for(int index[] : indices){
            int row = index[0] ;
            int col = index[1]; 

            mark(row , col , mat, m, n); 
        }
        int count = 0 ; 
        for(int i = 0 ; i < m; i++){
            for(int j = 0 ;  j < n ; j++){
                if(mat[i][j] % 2 != 0){
                    count ++ ; 
                }
            }
        }
        return count; 
    }
}