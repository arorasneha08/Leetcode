class Solution {
    public boolean canPlaceFlowers(int[] arr, int n) {
        int m = arr.length; 
        if(n == 0) return true ; 
        if(m == 1 && arr[0] == 0) return true; 
        if(arr[0] == 0 && arr[1] != 1 && n > 0) {
            arr[0] = 1 ;
            n--; 
        }
        if(arr[m-1] == 0 && arr[m-2] != 1 && n > 0){
            arr[m-1] = 1 ; 
            n--; 
        } 
        for(int i = 1 ; i < arr.length -1 ; i++){
            if(arr[i] == 0 && arr[i-1] != 1 && arr[i+1] != 1 && n > 0){
                arr[i] = 1 ; 
                n-- ; 
            }
        }
        return (n == 0) ; 
    }
}