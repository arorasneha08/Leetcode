class Solution {
    private boolean isOperator(String token){
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
    private int compute(int a , int b , String operator){
        int ans = 0 ; 
        switch(operator){
            case "+" : 
                ans =  b+a ;
                break ; 
            case "-" :
                ans =  b-a ;
                break ; 
            case "*" :
                ans =  b * a ; 
                break ; 
            case "/" : 
                ans =  b/a ; 
                break ; 
        }
        return ans; 
    }
    public int evalRPN(String[] tokens) {
        int n = tokens.length; 
        Stack<Integer> st = new Stack<>();

        for(int i = 0 ; i < n ; i++){
            if(isOperator(tokens[i])){
                int a = st.pop() ; 
                int b = st.pop();
                
                int ans = compute(a , b , tokens[i]); 
                st.push(ans); 
            }
            else{
                st.push(Integer.parseInt(tokens[i])); 
            }
        }
        return st.peek(); 
    }
}