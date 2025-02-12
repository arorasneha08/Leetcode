class Solution {
    public int func(int index1 , int index2 , String s1 , String s2 , int dp[][]){
        if(index2 == 0) return 1; 
        if(index1 == 0) return 0; 

        if(s1.charAt(index1-1) == s2.charAt(index2-1)){ 
            return dp[index1][index2] = func(index1 - 1, index2 -1, s1, s2, dp) + func(index1-1 , index2 , s1, s2, dp); 
        }
        else {
            return dp[index1][index2] = func(index1 - 1, index2 , s1, s2, dp); 
        }
    }
    public int numDistinct(String s, String t) {
        // int n1 = s.length();
        // int n2 = t.length();
        // int dp[][] = new int[n1+1][n2+1]; 
        // for(int row[] : dp){
        //     Arrays.fill(row , -1) ; 
        // }
        // return func(n1 , n2 , s, t , dp); 

        // memoisation :- 
        // int n1 = s.length();
        // int n2 = t.length();
        // int dp[][] = new int[n1+1][n2+1]; 
        // for(int i = 0 ; i<= n1 ; i++){
        //     dp[i][0] = 1 ; 
        // }
        // for(int i = 1 ; i <= n2 ; i++){
        //     dp[0][i] = 0 ;
        // }
        // for(int i = 1 ; i <= n1 ; i++){
        //     for(int j = 1 ; j<= n2 ; j++){
        //         if(s.charAt(i-1) == t.charAt(j-1)){
        //             dp[i][j] = dp[i-1][j-1] + dp[i-1][j] ; 
        //         }
        //         else {
        //             dp[i][j] = dp[i-1][j] ; 
        //         }
        //     }
        // }
        // return dp[n1][n2] ; 

        // space optimisation :- 
        int n1 = s.length();
        int n2 = t.length();
        int prev[] = new int[n2+1]; 
        int curr[] = new int[n2+1]; 
        prev[0] = 1;
        for(int i = 1 ; i <= n1 ; i++){
            curr[0] = 1; 
            for(int j = 1 ; j<= n2 ; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    curr[j] = prev[j-1] + prev[j] ; 
                }
                else {
                    curr[j] = prev[j] ; 
                }
            }
            prev = curr.clone(); 
        }
        return prev[n2] ; 
    }
}