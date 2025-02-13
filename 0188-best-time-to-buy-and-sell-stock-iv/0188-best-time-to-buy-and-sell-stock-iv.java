class Solution {
    public int func(int index , int buy , int trans , int prices[] , int dp[][][]){
        if(index == prices.length) return 0;
        if(trans == 0) return 0 ;
        int profit= 0  ; 

        if(dp[index][buy][trans] != -1) return dp[index][buy][trans]; 
        if(buy == 1){
            int take = -prices[index] + func(index + 1 , 0 , trans,prices , dp ) ;
            int nottake = 0 + func(index + 1 , 1 , trans, prices,dp) ;
            profit = Math.max(take , nottake);
        }
        else{
            int sell = prices[index] + func(index + 1 , 1 , trans - 1,prices , dp);
            int notsell = 0 + func(index + 1 , 0 , trans, prices ,dp); 
            profit = Math.max(sell , notsell); 
        }
        return dp[index][buy][trans] = profit; 
    }
    public int maxProfit(int k, int[] prices) {
        // int n = prices.length ; 
        // int dp[][][] = new int[n][2][k+1];
        // for(int layer[][] : dp){
        //     for(int row[]: layer){
        //         Arrays.fill(row , -1); 
        //     }
        // }
        // return func(0 , 1, k, prices , dp);

        // using tabulation :-
        int n = prices.length ; 
        int dp[][][] = new int[n+1][2][k+1];

        for(int index = n-1 ; index >= 0 ; index--){
            for(int buy = 0 ; buy <= 1 ; buy ++){
                for(int trans = 1 ; trans <= k ; trans ++){
                    int profit = 0 ;
                    if(buy == 1){
                        int take = -prices[index] + dp[index+1][0][trans] ;
                        int nottake = 0 + dp[index+1][1][trans] ;
                        profit = Math.max(take , nottake);
                    }
                    else{
                        int sell = prices[index] + dp[index+1][1][trans-1];
                        int notsell = 0 + dp[index+1][0][trans]; 
                        profit = Math.max(sell , notsell); 
                    }
                    dp[index][buy][trans] = profit ; 
                }
            }
        }
        return dp[0][1][k];
    }
}