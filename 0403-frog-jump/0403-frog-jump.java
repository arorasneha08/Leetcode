class Solution {
    public boolean func(int i , int k , int[] stones , HashMap<Integer , Integer> mpp, int dp[][]){
        if(i == stones.length-1) return true; 
        if(dp[i][k] != -1) return dp[i][k] == 1; 

        boolean prevStep = false ;
        boolean nextStep = false; 
        boolean currStep = false ;
        if(mpp.containsKey(stones[i] + k)){
            prevStep = func(mpp.get(stones[i] + k) , k ,stones , mpp , dp); 
        }
        if(k > 1 && mpp.containsKey(stones[i] + k - 1)){
            currStep = func(mpp.get(stones[i] + k - 1) , k-1 , stones , mpp , dp); 
        }
        if(mpp.containsKey(stones[i] + k + 1)){
            nextStep = func(mpp.get(stones[i] + k + 1) , k+1 , stones , mpp , dp); 
        }
        if(prevStep || currStep || nextStep) {
            dp[i][k] = 1 ; 
        }
        else dp[i][k] = 0 ; 

        return dp[i][k] == 1 ; 
    }
    public boolean canCross(int[] stones) {
        int n = stones.length ; 
        HashMap<Integer , Integer> mpp = new HashMap<>();
        // edge case :- 
        if (stones[1] - stones[0] != 1) {
            return false;
        }
        
        for(int  i = 0 ;i < n ; i++){
            mpp.put(stones[i] , i);
        }
        int dp[][] = new int[n][n] ;
        for(int row[] : dp){
            Arrays.fill(row, -1) ;
        }
        return func(1,1, stones , mpp , dp); 
    }
}