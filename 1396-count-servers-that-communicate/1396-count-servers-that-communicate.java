class Solution {
    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] rowCount = new int[n];
        int[] colCount = new int[m];

        // Count the number of servers in each row and column
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        int totalServers = 0;

        // Check for servers that can communicate
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) {
                    totalServers++;
                }
            }
        }

        return totalServers;
    }
}