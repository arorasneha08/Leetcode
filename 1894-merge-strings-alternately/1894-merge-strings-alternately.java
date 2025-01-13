class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n1 = word1.length() ;
        int n2 = word2.length() ;
        int i = 0; 
        int j = 0; 
        String ans = "" ; 
        boolean flag = true; 
        while(i < n1 && j < n2){
            if(flag){
                ans += word1.charAt(i); 
                i++; 
            }
            else{
                ans += word2.charAt(j); 
                j++; 
            }
            flag = !flag; 
        }
        while(i < n1){
            ans += word1.charAt(i);
            i++; 
        }
        while(j < n2){
            ans += word2.charAt(j);
            j++; 
        }
        return ans ; 
    }
}