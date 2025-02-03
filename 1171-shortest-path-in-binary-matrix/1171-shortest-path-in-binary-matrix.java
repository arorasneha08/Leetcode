class Solution {
    public class Pair {
        int row, col, dist;
        Pair(int r, int c, int d) {
            row = r;
            col = c;
            dist = d;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) return -1;

        int[][] distance = new int[n][m];
        for (int[] row : distance) Arrays.fill(row, Integer.MAX_VALUE);

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0, 1));  
        distance[0][0] = 1; 

        int[] delRow = {0, 0, 1, -1, -1, 1, -1, 1};
        int[] delCol = {-1, 1, 0, 0, -1, 1, 1, -1};

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int r = curr.row;
            int c = curr.col;
            int d = curr.dist;

            if (r == n - 1 && c == m - 1) return d; 

            for (int i = 0; i < 8; i++) {
                int newRow = delRow[i] + r;
                int newCol = delCol[i] + c;

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m 
                    && grid[newRow][newCol] == 0 && d + 1 < distance[newRow][newCol]) {

                    distance[newRow][newCol] = d + 1;
                    q.offer(new Pair(newRow, newCol, d + 1));
                }
            }
        }
        return -1;
    }
}
