class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length ; 
        int xor = 0 ;
        for(int i = 0; i<n ; i++){
            xor ^= derived[i] ; 
        }
        return xor == 0 ;
    }
}