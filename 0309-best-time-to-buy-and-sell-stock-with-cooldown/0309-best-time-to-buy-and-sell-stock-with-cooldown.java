class Solution {
    public int func(int index , int buy , int prices[], int dp[][]){
        if(index >= prices.length) return 0 ; 
        int profit = 0 ; 
        if(dp[index][buy] != -1) return dp[index][buy]; 
        if(buy == 1){
            int take = - prices[index] + func(index + 1, 0 , prices , dp);
            int nottake = func(index + 1 , 1 , prices , dp) ;
            profit = Math.max(take , nottake) ; 
        }
        else {
            int sell = prices[index] + func(index + 2 , 1, prices , dp);
            int notsell = 0 + func(index + 1 , 0 , prices , dp);  
            profit = Math.max(sell , notsell) ; 
        }
        return dp[index][buy] = profit ; 
    }
    public int maxProfit(int[] prices) {
        int n = prices.length ;
        int dp[][] = new int[n+1][2];
        for(int row[] : dp){
            Arrays.fill(row , -1); 
        }
        return func(0 , 1 , prices, dp); 
    }
}