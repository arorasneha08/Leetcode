class Solution {
    int[] findLPS(String pat, int n) {
        int lps[] = new int[n]; 
        int len = 0;
        lps[0] = 0;
        int i = 1;

        while (i < n) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps; 
    }

    public String shortestPalindrome(String s) {
        int n = s.length();
        if (s == null || n <= 1) return s;

        String rev = new StringBuilder(s).reverse().toString();  
        String combine = s + "#" + rev; 

        int lps[] = findLPS(combine, combine.length()); 
        int palLength = lps[combine.length() - 1];

        String extra = rev.substring(0, n - palLength); 
        return extra + s;
    }
}
