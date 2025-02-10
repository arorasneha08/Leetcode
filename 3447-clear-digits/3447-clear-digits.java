class Solution {
    public boolean isChar(char ch){
        return ((ch >= 'a' && ch <= 'z') || (ch >='A' && ch <= 'Z')); 
    }
    public boolean isDigit(char ch){
        return ((ch >= '0' && ch <= '9')); 
    }
    public String clearDigits(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < n; i++){
            char ch = s.charAt(i) ; 
            if(!st.isEmpty() && isDigit(ch)){
                st.pop(); 
            }
            else{
                st.push(ch); 
            }
        }
        StringBuilder str = new StringBuilder();
        while(!st.isEmpty()){
            str.append(st.pop());
        }
        str.reverse();
        return str.toString(); 
    }
}