class Solution {
    public int hammingWeight(int num) {
        if(num == 0) return 0 ; 
        int count = 0 ; 
        for(int i = 0; i< 32 ; i++){
            if(((num >> i) & 1 ) == 1){
                count ++ ; 
            }
        }
        return count ;
    }
}