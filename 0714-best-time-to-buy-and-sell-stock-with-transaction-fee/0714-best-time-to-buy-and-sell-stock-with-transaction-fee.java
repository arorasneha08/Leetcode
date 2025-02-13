class Solution {
    public int func(int index , int buy , int prices[], int dp[][], int fee){
        if(index == prices.length) return 0 ; 
        int profit = 0 ; 
        if(dp[index][buy] != -1) return dp[index][buy]; 
        if(buy == 1){
            int take = - prices[index] + func(index + 1, 0 , prices , dp, fee);
            int nottake = func(index + 1 , 1 , prices , dp, fee) ;
            profit = Math.max(take , nottake) ; 
        }
        else {
            int sell = prices[index] - fee + func(index + 1 , 1, prices , dp, fee);
            int notsell = 0 + func(index + 1 , 0 , prices , dp, fee);  
            profit = Math.max(sell , notsell) ; 
        }
        return dp[index][buy] = profit ; 
    }
    public int maxProfit(int[] prices, int fee) {
        // int n = prices.length ;
        // int dp[][] = new int[n+1][2];
        // for(int row[] : dp){
        //     Arrays.fill(row , -1); 
        // }
        // return func(0 , 1 , prices, dp,  fee); 

        // using tabulation :- 
        // int n = prices.length ;
        // int dp[][] = new int[n+1][2];
        
        // for(int index = n-1; index >= 0 ; index --){
        //     for(int buy = 0 ; buy <= 1 ; buy ++){
        //         int profit = 0 ; 
        //         if(buy == 1){
        //             int take = -prices[index] + dp[index+1][0] ;
        //             int nottake = dp[index+1][1] ;
        //             profit = Math.max(take , nottake) ; 
        //         }
        //         else{
        //             int sell = prices[index] - fee + dp[index+1][1] ;
        //             int notsell = 0 + dp[index+1][0] ;  
        //             profit = Math.max(sell , notsell) ; 
        //         }

        //         dp[index][buy] = profit;  
        //     }
        // }
        // return dp[0][1]; 

        // using space optimisation :- 
        int n = prices.length ;
        int curr[] = new int[2];
        
        for(int index = n-1; index >= 0 ; index --){
            for(int buy = 0 ; buy <= 1 ; buy ++){
                int profit = 0 ; 
                if(buy == 1){
                    int take = - prices[index] + curr[0] ;
                    int nottake = curr[1] ;
                    profit = Math.max(take , nottake) ; 
                }
                else{
                    int sell = prices[index] - fee + curr[1] ;
                    int notsell = 0 + curr[0] ;  
                    profit = Math.max(sell , notsell) ; 
                }
                curr[buy] = profit;  
            }
        }
        return curr[1]; 
    }
}