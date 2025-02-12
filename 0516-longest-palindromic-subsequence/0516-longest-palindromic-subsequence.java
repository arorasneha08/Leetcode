class Solution {
    public int func(int index1 , int index2 , String s1 , String s2 , int dp[][]){
        if(index1 == 0 || index2 == 0) return 0 ; 
        
        if(dp[index1][index2] != -1) return dp[index1][index2]; 

        if(s1.charAt(index1-1) == s2.charAt(index2-1)){
            return dp[index1][index2] = 1 + func(index1 - 1 , index2 - 1 , s1, s2, dp); 
        }
        return dp[index1][index2] = Math.max(func(index1-1 , index2 , s1 , s2, dp) , func(index1 , index2 - 1 , s1 , s2, dp)); 
    }
    public int longestPalindromeSubseq(String s) {
        // int n = s.length(); 
        // String s2 = "" ;
        // for(int i = n-1 ; i >=0 ; i--){
        //     s2 += s.charAt(i); 
        // }
        // int dp[][] = new int[n+1][n+1]; 
        // for(int row[] :  dp){
        //     Arrays.fill(row , -1); 
        // }
        // return func(n, n, s, s2 , dp); 

        // using tabulation :- 
        // int n = s.length(); 
        // String s2 = "" ;
        // for(int i = n-1 ; i >=0 ; i--){
        //     s2 += s.charAt(i); 
        // }
        // int dp[][] = new int[n+1][n+1]; 
        // for(int i = 0 ; i < n ; i++){
        //     dp[i][0] = 0 ; 
        //     dp[0][i] = 0 ;  
        // }
        // for(int i = 1 ; i <= n ; i++){
        //     for(int j = 1 ; j<= n ; j++){
        //         if(s.charAt(i-1) == s2.charAt(j-1)){
        //             dp[i][j] = 1 + dp[i-1][j-1]; 
        //         }
        //         else{
        //             dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]); 
        //         }
        //     }
        // }
        // return dp[n][n] ; 

        // space optimisation :- 
        int n = s.length(); 
        String s2 = "" ;
        for(int i = n-1 ; i >=0 ; i--){
            s2 += s.charAt(i); 
        }
        int prev[] = new int[n+1]; 
        for(int i = 0 ; i < n ; i++){
            prev[i] = 0 ;  
        }
        for(int i = 1 ; i <= n ; i++){
            int curr[] = new int[n+1]; 
            for(int j = 1 ; j<= n ; j++){
                if(s.charAt(i-1) == s2.charAt(j-1)){
                    curr[j] = 1 + prev[j-1]; 
                }
                else{
                    curr[j] = Math.max(prev[j] , curr[j-1]); 
                }
            }
            prev = curr;  
        }
        return prev[n] ; 
    }
}