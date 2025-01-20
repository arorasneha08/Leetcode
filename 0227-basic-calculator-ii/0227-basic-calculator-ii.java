class Solution {
    public int calculate(String s) {
        int n = s.length() ; 
        Stack<Integer> st = new Stack<>();
        int number = 0 ;
        char sign = '+' ;

        for(int i = 0 ; i<n ; i++){
            char ch = s.charAt(i) ;
            if(ch >= '0' && ch <= '9'){
                number = number * 10 + (ch - '0'); 
            }
            if(!Character.isDigit(ch) && ch != ' ' || i == n-1){
                if(sign  == '+'){
                    st.push(number); 
                }
                if(sign == '-'){
                    st.push(-number); 
                }
                if(sign == '*'){
                    st.push(st.pop() * number); 
                }
                if(sign == '/'){
                    st.push(st.pop() / number); 
                }
                sign = ch ;
                number = 0 ; 
            }
        }
        int result = 0 ;
        while(!st.isEmpty()){
            result += st.pop(); 
        }
        return result ; 
    }
}