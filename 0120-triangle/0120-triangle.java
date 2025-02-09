class Solution {
    public int func(int i , int j , int[][] dp , List<List<Integer>> triangle){
        if (i == 0) return triangle.get(0).get(0);

        if (j < 0 || j > i) return Integer.MAX_VALUE;

        if (dp[i][j] != -1) return dp[i][j];

        int up = func(i - 1, j, dp, triangle);
        int left = func(i - 1, j - 1, dp, triangle);
        return dp[i][j] = triangle.get(i).get(j) + Math.min(up, left);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][]; 
        for (int i = 0; i < n; i++) {
            dp[i] = new int[i + 1];
            Arrays.fill(dp[i], -1);
        }
        int minPathSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minPathSum = Math.min(minPathSum, func(n - 1, j, dp, triangle));
        }
        return minPathSum;
    }
}
