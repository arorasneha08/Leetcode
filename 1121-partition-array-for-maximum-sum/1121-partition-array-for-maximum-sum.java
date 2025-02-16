class Solution {
    public int func(int i , int n , int arr[] , int k , int dp[]){
        if(i == n) return 0; 
        int ans = Integer.MIN_VALUE ; 
        int max = Integer.MIN_VALUE ;
        int len = 0  ;
        if(dp[i] != -1) return dp[i]; 
        for(int j = i ; j < Math.min(n , i+k) ; j++){
            len ++ ;
            max = Math.max(arr[j] , max); 
            int sum = (len * max) + func(j+1 , n , arr, k, dp); 
            ans = Math.max(ans , sum); 
        }
        return dp[i] = ans ; 
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length; 
        int dp[] = new int[n] ; 
        Arrays.fill(dp , -1) ; 
        return func(0, n, arr, k , dp); 
    }
}