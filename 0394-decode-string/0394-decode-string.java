class Solution {
    public String decodeString(String s) {
        int n = s.length(); 
        Stack<StringBuilder> stringStack = new Stack<>() ;
        Stack<Integer> countStack = new Stack<>(); 
        StringBuilder currStr = new StringBuilder(); 
        int num = 0 ; 
        
        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0') ; 
            }
            else if(ch == '['){
                countStack.push(num); 
                stringStack.push(currStr); 
                num = 0 ; 
                currStr = new StringBuilder() ; 
            }
            else if(ch == ']'){
                StringBuilder decodedString = stringStack.pop();
                int repeat = countStack.pop();

                for(int i = 0 ; i < repeat ; i++){
                    decodedString.append(currStr); 
                }
                currStr = decodedString ; 
            }
            else{
                currStr.append(ch); 
            }
        }
        return currStr.toString(); 
    }
}