class Solution {
    public String removeDuplicates(String s) {
        StringBuilder str = new StringBuilder();
        int n = s.length(); 
        Stack<Integer> st = new Stack<>();

        for(int i = 0 ; i < n ;i++){
            if(!st.isEmpty() && s.charAt(i) == s.charAt(st.peek())){
                st.pop(); 
            }
            else{
                st.push(i) ; 
            }
        }
        while(!st.isEmpty()){
            str.append(s.charAt(st.pop())); 
        }
        str.reverse() ;
        return str.toString() ; 
    }
}