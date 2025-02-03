import java.util.*;

class Solution {
    public class Pair implements Comparable<Pair> {
        int row, col, effort;

        Pair(int row, int col, int effort) {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }

        public int compareTo(Pair that) {
            return this.effort - that.effort;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] difference = new int[n][m];
        for (int[] row : difference) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(0, 0, 0));
        difference[0][0] = 0;

        int[] delRow = {1, 0, -1, 0};
        int[] delCol = {0, 1, 0, -1};

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int r = curr.row;
            int c = curr.col;
            int eff = curr.effort;

            if (r == n - 1 && c == m - 1) return eff;

            for (int i = 0; i < 4; i++) {
                int newRow = r + delRow[i];
                int newCol = c + delCol[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                    int diff = Math.abs(heights[r][c] - heights[newRow][newCol]);
                    int newEffort = Math.max(diff, eff); // ✅ Fixed this line

                    if (newEffort < difference[newRow][newCol]) {
                        difference[newRow][newCol] = newEffort;
                        pq.offer(new Pair(newRow, newCol, newEffort));
                    }
                }
            }
        }
        return -1;
    }
}
