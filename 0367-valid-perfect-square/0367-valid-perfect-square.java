class Solution {
    public boolean isPerfectSquare(int num) {
        long start = 1 ;
        long end = num; 
        while(start <= end){
            long mid = start + (end - start)/2 ;
            long midElem = mid * mid ;
            if(midElem == num){
                return  true ; 
            }
            else if(midElem < num){
                start = mid + 1 ; 
            }
            else{
                end = mid - 1 ; 
            }
        }
        return false ;
    }
}