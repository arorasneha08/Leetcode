class Solution {
    public boolean func(int i, int j, String s1, String s2, Boolean dp[][]) {
        if (i < 0 && j < 0) return true; 
        if (i < 0 && j >= 0) return false; 
        
        if (j < 0 && i >= 0) {  
            for (int idx = 0; idx <= i; idx++) {
                if (s1.charAt(idx) != '*') return false;
            }
            return true;
        }

        if (dp[i][j] != null) return dp[i][j]; 

        if (s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?') {
            return dp[i][j] = func(i - 1, j - 1, s1, s2, dp);
        }

        if (s1.charAt(i) == '*') {
            return dp[i][j] = func(i - 1, j, s1, s2, dp) || func(i, j - 1, s1, s2, dp);
        }

        return dp[i][j] = false;
    }

    public boolean isMatch(String s, String p) {
        int n = p.length();
        int m = s.length();
        Boolean dp[][] = new Boolean[n + 1][m + 1];
        return func(n - 1, m - 1, p, s, dp);
        
    }
}
