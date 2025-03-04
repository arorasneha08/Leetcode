class Solution {
    public boolean checkPowersOfThree(int n) {
        int power = 1 ; 
        while(power * 3 <= n){
            power *= 3 ; 
        }
        while(n > 0 && power > 0){
            if(n >= power){
                n-= power; 
            }
            power = power/3 ; 
        }
        return n == 0 ; 
    }
}