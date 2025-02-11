class Solution {
    public int func(int index1 , int index2 , String s1, String s2 , int n1 , int n2 , int[][] dp){
        if(index1 == 0 || index2 == 0) return 0 ;
        if(s1.charAt(index1-1) == s2.charAt(index2-1)){
            return 1 + func(index1 - 1, index2 - 1 , s1, s2 , n1 , n2, dp);
        }
        if(dp[index1][index2] != -1) return dp[index1][index2]; 
        return dp[index1][index2] = Math.max(func(index1 - 1, index2 , s1, s2, n1, n2, dp) ,
        func(index1 , index2-1 , s1, s2 , n1 , n2 , dp)); 
    }
    public int longestCommonSubsequence(String text1, String text2) {
        // memoisation :- 
        // int n1 = text1.length();
        // int n2 = text2.length(); 
        // int dp[][] = new int[n1+1][n2+1] ; 
        // for(int row[] : dp){
        //     Arrays.fill(row , -1) ;
        // }
        // return func(n1, n2 , text1, text2 , n1 , n2, dp); 

        // tabulation :- 
        int n1 = text1.length();
        int n2 = text2.length(); 
        int dp[][] = new int[n1+1][n2+1] ; 
        for(int i = 0 ; i<= n2 ; i++){
            dp[0][i] = 0 ; 
        }
        for(int i = 0 ; i<= n1 ; i++){
            dp[i][0] = 0 ; 
        }
        for(int i = 1 ; i <= n1 ; i++){
            for(int j = 1 ; j <= n2 ; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1]; 
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]); 
                }
            }
        }
        return dp[n1][n2] ;
    }
}