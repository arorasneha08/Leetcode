class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length() ;
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i); 
            if(!st.isEmpty() && ch == '*'){
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
        str.reverse() ;
        return str.toString(); 
    }
}