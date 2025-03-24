class Solution {
    public String addBinary(String a, String b) {
        char str1[] = a.toCharArray();
        char str2[] = b.toCharArray();
        int i = str1.length-1 ; 
        int j = str2.length-1; 
        int carry = 0 ; 
        String str = "" ; 

        while(carry > 0 || i >=0 || j >= 0){
            int num1 = (i >= 0) ? (str1[i] - '0') : 0 ; 
            int num2 = (j >= 0) ? (str2[j] - '0') : 0 ; 
            int sum = num1 + num2 + carry ; 
            int digit = sum % 2 ; 
            carry = sum / 2;  
            i-- ;
            j-- ; 
            str = (char) (digit + '0') + str ;
        }
        return str; 
    }
}