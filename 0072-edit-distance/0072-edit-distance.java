class Solution {
    public int func(int index1, int index2 ,String s1 ,String s2 , int dp[][]){
        if(index1 == 0){
            return index2 ; 
        }
        if(index2 == 0){
            return index1 ; 
        }
        if(s1.charAt(index1-1) == s2.charAt(index2-1)){
            return func(index1 - 1 , index2 - 1 , s1, s2 , dp); 
        }
        return 1 + Math.min(func(index1-1 , index2, s1, s2, dp), 
        Math.min(func(index1 , index2-1, s1, s2 , dp) , func(index1-1, index2-1, s1, s2, dp))); 
    }
    public int minDistance(String word1, String word2) {
        // int n = word1.length();
        // int m = word2.length(); 
        // int dp[][] = new int[n+1][m+1];
        // for(int row[] : dp){
        //     Arrays.fill(row , -1); 
        // }
        // return func(n, m , word1, word2 , dp); 

        // tabulation :- 
        int n = word1.length();
        int m = word2.length(); 
        int dp[][] = new int[n+1][m+1];

        for(int i = 0; i <= n; i++) {
            dp[i][0] = i; 
        }
        for(int j = 0; j <= m; j++) {
            dp[0][j] = j;  
        }

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]; 
                }
                else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j] , Math.min(dp[i][j-1] , dp[i-1][j-1])); 
                }
            }
        }
        return dp[n][m] ; 
    }
}