class Solution {
    public int calculate(String s) {
        int n = s.length();
        Stack<Integer> st = new Stack<>(); 
        int number = 0 ;
        int result = 0 ;
        int sign = 1 ; 

        for(int i = 0 ; i<n ; i++){
            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9'){
                number = number * 10 + (ch - '0'); 
            }
            else if(ch == '+'){
                result += (number * sign) ;
                number = 0 ;
                sign = 1 ; 
            }
            else if(ch == '-'){
                result += (number * sign);
                number = 0 ;
                sign = -1; 
            }
            else if(ch == '('){
                st.push(result);
                st.push(sign);
                result = 0 ;
                number = 0 ;
                sign = 1 ; 
            }
            else if(ch == ')'){
                result += (number * sign);
                number = 0 ; 
                int stack_sign = st.pop();
                int last_result = st.pop(); 
                result *= stack_sign ;
                result += last_result ; 
            }
        }
        result += (number * sign);
        return result ; 
    }
}