class Solution {
    public boolean increasingTriplet(int[] arr) {
        int n = arr.length ; 
        if(n == 1 || n == 2) return false; 
        int first = Integer.MAX_VALUE , second = Integer.MAX_VALUE; 
        for(int num : arr){
            if(num <= first){
                first = num ; 
            }
            else if(num <= second){
                second = num ;
            }
            else{
                return true ; 
            }
        } 
        return false; 
    }
}