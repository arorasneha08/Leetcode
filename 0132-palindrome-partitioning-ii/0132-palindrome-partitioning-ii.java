class Solution {
    public boolean isPalindrome(int i , int j , String str){
        int left = i ;
        int right = j ;
        while(left < right){
            if(str.charAt(left) != str.charAt(right)) return false; 
            left ++ ;
            right -- ; 
        }
        return true ; 
    }
    // public int func(int i, String str , int dp[]){
        // if(i == str.length()) return 0 ;
        // if(dp[i] != -1) return dp[i]; 
        // String temp = ""; 
        // int min = Integer.MAX_VALUE ;
        // for(int j = i ; j< str.length() ; j++){
        //     temp += str.charAt(j); 
        //     if(isPalindrome(temp)){
        //         int cost = 1 + func(j+1 , str, dp); 
        //         min = Math.min(min , cost);
        //     }
        // }
        // return min ; 
    // }
    public int minCut(String s) {
        // int n = s.length(); 
        // int dp[] = new int[n];
        // Arrays.fill(dp , -1);
        // return func(0, s, dp) - 1; 

        // tabulation :- 
        int n = s.length(); 
        int dp[] = new int[n+1];
        dp[n] = 0; 
        for(int i = n-1 ; i>= 0 ; i--){
            int min = Integer.MAX_VALUE; 
            for(int j = i ; j< n ; j++){
                if(isPalindrome(i, j, s)){
                    int cost = 1 +  dp[j+1]; 
                    min = Math.min(min , cost); 
                }
            }
            dp[i] = min; 
        }
        return dp[0] - 1; 
    }
}