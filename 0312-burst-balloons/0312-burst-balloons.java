class Solution {
    public int func(int i , int j , int arr[] , int dp[][]){
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int maxi = Integer.MIN_VALUE;

        for (int index = i; index <= j; index++) {  
            int cost = arr[i - 1] * arr[j + 1] * arr[index] + func(i, index - 1, arr, dp) + func(index + 1, j, arr, dp);
            maxi = Math.max(maxi, cost);
        }
        return dp[i][j] = maxi;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        
        int[] arr = new int[n + 2]; 
        arr[0] = arr[n + 1] = 1; 
        
        for (int i = 1; i <= n; i++) {
            arr[i] = nums[i - 1];
        }

        int[][] dp = new int[n + 2][n + 2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return func(1, n, arr, dp); 
    }
}