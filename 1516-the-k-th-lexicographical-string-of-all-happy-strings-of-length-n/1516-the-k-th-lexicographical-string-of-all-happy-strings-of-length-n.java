class Solution {
    public String getHappyString(int n, int k) {
        List<String> result = new ArrayList<>();
        StringBuilder str = new StringBuilder() ; 
        char ch[] = {'a' , 'b' , 'c'}; 

        backtrack(n , str , result , ch);

        if(k <= result.size()){
            return result.get(k-1); 
        }
        return ""; 
    }
    private void backtrack(int n , StringBuilder str , List<String> result, char ch[]){
        if(str.length() == n){
            result.add(str.toString());
            return ; 
        }
        for(int i = 0  ; i < ch.length; i++){
            if(str.length() == 0 || str.charAt(str.length()-1) != ch[i]){
                str.append(ch[i]); 
                backtrack(n , str , result , ch); 
                str.deleteCharAt(str.length()-1); 
            }
        }
    }
}