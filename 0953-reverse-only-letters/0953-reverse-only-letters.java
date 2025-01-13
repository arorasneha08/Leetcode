class Solution {
    public boolean isCharacter(char ch){
        if(ch >= 'a' && ch <= 'z' || (ch >= 'A' && ch <= 'Z')) return true ; 
        return false ; 
    }
    public String reverseOnlyLetters(String s) {
        int n = s.length() ;
        int left = 0 ;
        int right = n-1 ;
        char ch[] = s.toCharArray(); 
        while(left < right){
            while(left < right && !isCharacter(ch[left])){
                left ++ ;
            }
            while(left < right && !isCharacter(ch[right])){
                right -- ;
            }
            char temp = ch[left] ;
            ch[left] = ch[right];
            ch[right] = temp; 
            left ++ ;
            right -- ; 
        }
        return new String(ch); 
    }
}