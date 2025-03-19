class Solution {
    private void findLPS(String pat , int n , int lps[]){
        int len = 0;
        int i = 1 ; 
        lps[0] = 0 ; 
        while(i < n){
            if(pat.charAt(i) == pat.charAt(len)){
                len ++ ; 
                lps[i] = len ; 
                i++; 
            }
            else{
                if(len != 0){
                    len = lps[len-1]; 
                }
                else{
                    lps[i] = 0  ;
                    i++ ; 
                }
            }
        }
    }
    private boolean stringMatch(String pat, String txt , int n , int m){
        int i = 0 ; 
        int j = 0 ;
        int[] lps = new int[n] ;
        findLPS(pat , n, lps) ; 

        while(i < m){
            if(txt.charAt(i) == pat.charAt(j)){
                i++ ;
                j++ ; 
            }
            if(j == n){
                return true; 
            }
            else if(i < m && (txt.charAt(i) != pat.charAt(j))){
                if(j != 0){
                    j = lps[j-1]; 
                }
                else{
                    i++ ; 
                }
            }
        } 
        return false; 
    }
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        String str = s + s ;
        return stringMatch(s , str.substring(1, 2*n-1) , n , 2*n-2);
    }
}