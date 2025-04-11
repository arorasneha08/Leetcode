class Solution {
    private int findSum(String str){
        int n = str.length();
        int sum = 0 ; 
        for(int i = 0 ; i < n ; i++){
            sum += (str.charAt(i) - '0'); 
        }
        return sum ; 
    }
    public int countSymmetricIntegers(int low, int high) {
        int count = 0; 
        for(int i = low ; i <= high ; i++){
            String str = Integer.toString(i);
            int n = str.length(); 
            if(n % 2 == 0 && findSum(str.substring(0 , n/2)) == findSum(str.substring(n/2))){
                count ++ ; 
            }
        }
        return count; 
    }
}