class Solution {
    private long func(int index , int questions[][] , long dp[] , int n ){
        if(index >= n) return 0 ; 
        int points = questions[index][0];
        int brainpower = questions[index][1];

        if(dp[index] != -1) return dp[index]; 

        long notpick = func(index + 1 , questions , dp , n); 
        long pick = func(index + brainpower + 1 , questions , dp , n) + points; 
        return dp[index] =  Math.max(pick , notpick); 
    }
    public long mostPoints(int[][] questions) {
        int n = questions.length ; 
        long dp[] = new long[n]; 
        Arrays.fill(dp , -1); 
        return func(0 , questions , dp , n);  
    }
}