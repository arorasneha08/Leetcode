class Solution {

    public int minCost(int[][] grid) {
        int n = grid.length ; 
        int m = grid[0].length ; 

        boolean[][] visited = new boolean[n][m] ; 
        Deque<int[]> q = new ArrayDeque<>() ; 

        int delRow[] = {0,0,1,-1} ;
        int delCol[] = {1,-1,0,0} ;

        q.offer(new int[]{0,0,0}); 

        while(!q.isEmpty()){
            int[] curr = q.pollFirst() ;
            int row = curr[0];
            int col = curr[1];
            int cost = curr[2] ; 

            if (row == n - 1 && col == m - 1) {
                return cost;
            }
            
            if (visited[row][col]) continue;
            if (!visited[row][col]) visited[row][col] = true;

            for(int i = 0 ; i<4 ; i++){
                int newRow = delRow[i] + row ;
                int newCol = delCol[i] + col ; 

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !visited[newRow][newCol]){
                    if(grid[row][col] == i+1) {
                        q.offerFirst(new int[]{newRow , newCol , cost}); 
                    }
                    else{
                        q.offer(new int[] {newRow , newCol , cost + 1}) ; 
                    }
                }
            } 
        }
        return -1 ; 
    }
}