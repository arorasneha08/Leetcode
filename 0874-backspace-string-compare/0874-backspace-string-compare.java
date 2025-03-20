class Solution {
    private String func(String s){
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '#'){
                if(!st.isEmpty()) st.pop(); 
            }
            else{
                st.push(s.charAt(i)); 
            }
        }
        String str = "" ;
        while(!st.isEmpty()){
            str += st.pop(); 
        }
        return str ; 
    }
    public boolean backspaceCompare(String s, String t) {
        String s1 = func(s);
        String s2 = func(t);
        if(s1.equals(s2)) return true ;
        return false; 
    }
}