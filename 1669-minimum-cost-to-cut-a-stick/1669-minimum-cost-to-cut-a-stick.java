class Solution {
    static int func(int i, int j, int[] arr, int[][] dp) {
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        
        int mini = Integer.MAX_VALUE;
        for (int index = i; index <= j; index++) {
            int cost = arr[j+1] - arr[i-1] 
                + func(i, index - 1, arr, dp)
                + func(index + 1, j, arr, dp);
            mini = Math.min(mini, cost);
        }
        return dp[i][j] = mini;
    }
    
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] newCuts = new int[m + 2];
        newCuts[0] = 0;
        newCuts[m + 1] = n;
        for (int i = 0; i < m; i++) {
            newCuts[i + 1] = cuts[i];
        }
        Arrays.sort(newCuts);
        int dp[][] = new int[m + 2][m + 2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return func(1, m, newCuts, dp);
    }
}
