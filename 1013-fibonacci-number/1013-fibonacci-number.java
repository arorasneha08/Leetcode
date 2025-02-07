class Solution {
    int fibonacci(int n , int[] dp){
        if(n <= 1) return dp[n] = n  ; 
        if(dp[n] != -1) return dp[n] ; 
        return dp[n] = fibonacci(n-1, dp) + fibonacci(n-2 , dp); 
    }
    public int fib(int n) {
        int dp[] = new int[n+1] ;
        Arrays.fill(dp , -1) ;
        fibonacci(n , dp); 
        return dp[n] ; 
    }
}