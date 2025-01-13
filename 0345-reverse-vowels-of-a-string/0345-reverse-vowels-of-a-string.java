class Solution {
    public boolean isVowel(char ch){
        return "aeiouAEIOU".indexOf(ch) != -1;
    }
    public String reverseVowels(String s) {
        int left = 0 ;
        int right = s.length()-1 ;
        char[] ch = s.toCharArray();
        while(left < right){
            while(left < right && !isVowel(ch[left])){
                left ++ ; 
            }
            while(left < right && !isVowel(ch[right])){
                right --; 
            }
            char temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp ; 
            left ++ ;
            right --; 
        }
        return new String(ch) ; 
    }
}