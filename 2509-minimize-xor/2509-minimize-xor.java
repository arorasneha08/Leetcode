class Solution {
    private int countSetBits(int n){
        int count = 0 ;
        for(int i = 0 ; i<32 ; i++){
            if(((n >> i) & 1) == 1) count ++ ; 
        }
        return count ;
    }
    public int minimizeXor(int num1, int num2) {
        int count1 = countSetBits(num1);
        int count2 = countSetBits(num2);
        int result = 0 ; 
        if(count1 == count2){
            return num1 ; 
        }
        if(count1 < count2){
            result = num1;
            int addBits = count2 - count1 ;
            for(int i = 0  ; i<32 && addBits > 0 ; i++){
                if(((result >> i) & 1) == 0){
                    result |= (1 << i) ; 
                    addBits  -- ; 
                }
            }
            return result ; 
        }
        else{
            result = num1;
            int removeBits = count1 - count2 ;
            for (int i = 0; i < 32 && removeBits > 0; i++) {
                if (((result >> i) & 1) == 1) { 
                    result &= ~(1 << i); 
                    removeBits--;
                }
            }
            return result ; 
        }
    }
}