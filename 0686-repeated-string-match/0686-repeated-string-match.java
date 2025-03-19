class Solution {
    private void findLPS(String s, int lps[]) {
        lps[0] = 0; 
        int i = 1;
        int len = 0; 
        int n = s.length();  

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
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
    }

    private boolean stringMatch(String pat, String txt) {
        int n = pat.length();
        int m = txt.length();
        int lps[] = new int[n];

        findLPS(pat, lps); 

        int i = 0, j = 0; 
        while (i < m) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++; 
            }
            if (j == n) return true;  
            else if (i < m && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1]; 
                } else {
                    i++; 
                }
            }
        }
        return false; 
    }

    public int repeatedStringMatch(String a, String b) {
        StringBuilder str = new StringBuilder();
        int count = 0; 

        while (str.length() < b.length()) {
            str.append(a);
            count++; 
        }
        if (stringMatch(b, str.toString())) {
            return count; 
        }

        str.append(a);
        count++; 

        if (stringMatch(b, str.toString())) {
            return count; 
        }
        return -1; 
    }
}
