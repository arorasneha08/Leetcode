class Solution {
    public int func(int i , int j , String s1 , String s2 , int dp[][]){
        if(i == 0 || j == 0) return 0 ; 

        if(dp[i][j] != -1) return dp[i][j] ; 
        if(s1.charAt(i-1) == s2.charAt(j-1)){
            return dp[i][j] = 1 + func(i-1, j-1, s1, s2, dp); 
        }
        return dp[i][j] = Math.max(func(i-1, j, s1, s2,dp) , func(i, j-1 , s1, s2, dp)); 
    }
    public int minInsertions(String s) {
        int n = s.length() ;
        String s2 = "" ; 
        for(int i = n-1 ; i>= 0 ; i--){
            s2 += s.charAt(i) ;
        }
        int dp[][] = new int[n+1][n+1] ;
        for(int row[] : dp){
            Arrays.fill(row , -1) ; 
        } 
        int lcs = func(n, n, s, s2 , dp);
        return n - lcs ;  
    }
}