class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[] components = path.split("/"); 

        for(String comp : components){
            if(comp.equals(".") || comp.equals("")){
                continue ; 

            }
            if(comp.equals("..")){
                if(!st.isEmpty()) st.pop(); 
            }
            else{
                st.push(comp); 
            }
        }
        StringBuilder str = new StringBuilder();
        while(!st.isEmpty()){
            str.insert(0, "/" + st.pop());
        }
        return str.length() == 0 ? "/" : str.toString(); 
    } 
}