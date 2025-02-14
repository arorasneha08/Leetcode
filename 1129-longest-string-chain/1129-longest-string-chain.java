class Solution {
    public boolean checkPossible(String s1 , String s2){
        if (s1.length() != s2.length() - 1) return false;
        
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++; 
            }
            j++; 
            if (j - i > 1) return false; 
        }
        return i == s1.length();
    }

    public int longestStrChain(String[] nums) {
        Arrays.sort(nums ,  Comparator.comparingInt(String::length)); 
        int n = nums.length ;
        int dp[] = new int[n]; 
        Arrays.fill(dp , 1); 
        int max = 1 ; 
        for(int i = 0 ; i < n ; i++){
            for(int prev = 0 ; prev < i ; prev++){
                if(checkPossible(nums[prev] , nums[i])){
                    dp[i] = Math.max(dp[i] , 1 + dp[prev]); 
                }
            }
            max = Math.max(max , dp[i]); 
        }
        return max ; 
    }
}