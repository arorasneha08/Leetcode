class Solution {
    public class Pair{
        int row ;
        int col ;
        Pair(int row, int col){
            this.row = row ;
            this.col = col ; 
        }
    }
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length ;
        int m = isWater[0].length ; 
        Queue<Pair> q = new LinkedList<>() ; 
        int height[][] = new int[n][m] ; 

        for(int i = 0 ;i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                if(isWater[i][j] == 1){
                    q.add(new Pair(i,j)); 
                    height[i][j] = 0; 
                }
                else{
                    height[i][j] = -1; 
                }
            }
        }

        int delRow[] = {-1,0,1,0}; 
        int delCol[] = {0,-1,0,1} ; 

        while(!q.isEmpty()){
            Pair curr = q.poll();
            int r = curr.row ;
            int c = curr.col ;

            for(int i = 0 ; i< 4 ; i++){
                int newRow = delRow[i] + r ; 
                int newCol = delCol[i] + c ; 

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m 
                &&  height[newRow][newCol] == -1){
                    height[newRow][newCol] = height[r][c] + 1 ; 
                    q.offer(new Pair(newRow , newCol)); 
                }
            }
        }
        return height ;
    }
}