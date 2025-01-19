class Solution {
    public class Pair implements Comparable<Pair>{
        int row ;
        int col ;
        int height ;

        Pair(int row, int col , int height){
            this.row = row ;
            this.col = col ;
            this.height = height; 
        }

        public int compareTo(Pair that){ // min heap
            return this.height - that.height; 
        }
    }
    public int trapRainWater(int[][] heightMap) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        int n = heightMap.length ;
        int m = heightMap[0].length ;

        int[][] visited = new int[n][m]; 

        for(int i = 0 ; i<n ; i++){
            pq.offer(new Pair(i, 0 , heightMap[i][0])); 
            pq.offer(new Pair(i, m-1 , heightMap[i][m-1])); 
            visited[i][0] = 1 ;
            visited[i][m-1] = 1 ; 
        }

        for(int j = 0 ; j<m ; j++){
            pq.offer(new Pair(0, j , heightMap[0][j] )); 
            pq.offer(new Pair(n-1, j , heightMap[n-1][j] )); 
            visited[0][j] = 1 ;
            visited[n-1][j] = 1 ; 
        }

        int totalWater = 0  ;

        int delRow[] = {0,0,-1,1};
        int delCol[] = {-1,1,0,0} ;

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int r = curr.row ;
            int c = curr.col ; 
            int h = curr.height; 

            for(int i = 0 ; i<4 ; i++){
                int newRow = delRow[i] + r ;
                int newCol = delCol[i] + c ;

                if(newRow >= 0 && newRow < n && newCol >=0 && newCol < m && visited[newRow][newCol] == 0){
                    if(h > heightMap[newRow][newCol]){ // if boundary height is greater than neighbour height , water is stored
                        totalWater += (h - heightMap[newRow][newCol]);
                    }
                    pq.offer(new Pair(newRow  , newCol , Math.max(h , heightMap[newRow][newCol])));
                    visited[newRow][newCol] = 1; 
                }
            }
        }
        return totalWater ; 
    }
}