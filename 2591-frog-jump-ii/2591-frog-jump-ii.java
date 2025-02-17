class Solution {
    public int maxJump(int[] stones) {
        int n = stones.length ; 
        int res = stones[1] - stones[0]; 
        for(int i = 1 ; i < n-1 ; i++){
            res = Math.max(stones[i+1] - stones[i-1] , res);
        }
        return res ; 
    }
}