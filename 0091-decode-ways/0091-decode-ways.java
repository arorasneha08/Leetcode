class Solution {
    private int func(int index , String s , int[] dp){
        if(index == s.length()) return 1 ; 
        if(s.charAt(index) == '0') return 0 ; 
        if(dp[index] != -1) return dp[index]; 
        int res = func(index+1 , s , dp); 
        if(index + 1 < s.length()) {
            if((s.charAt(index) == '1') || (s.charAt(index) == '2' && s.charAt(index + 1) < '7')) {
                res += func(index + 2, s, dp); 
            }
        }
        return dp[index] = res; 
    }
    public int numDecodings(String s) {
        int n = s.length();
        int dp[] = new int[n+1]; 
        Arrays.fill(dp , -1) ;
        return func(0 , s, dp); 
    }
}