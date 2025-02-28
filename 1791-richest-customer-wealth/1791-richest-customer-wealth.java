class Solution {
    public int maximumWealth(int[][] accounts) {
        int n = accounts.length ;
        int maxSum = 0 ; 
        for(int j = 0 ; j < n ; j++){
            int sum = 0 ;
            for(int i = 0 ; i < accounts[0].length ; i++){
                sum += accounts[j][i] ; 
            }
            maxSum = Math.max(maxSum , sum) ; 
        }
        return maxSum ; 
    }
}