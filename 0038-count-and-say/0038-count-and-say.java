class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1"; 
        StringBuilder str = new StringBuilder();
        String curr = countAndSay(n-1); 
        int len = curr.length();

        int count = 1 ;  
        for(int i = 1 ; i< len ; i++){
            if(curr.charAt(i) == curr.charAt(i-1)){
                count ++; 
            }
            else{
                str.append(count).append(curr.charAt(i-1)); 
                count = 1 ; 
            }
        }
        str.append(count).append(curr.charAt(len-1)); 
        return str.toString();
    }
}