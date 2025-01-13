class Solution {
    public boolean containsNearbyDuplicate(int[] arr, int k) {
        HashMap<Integer , Integer> mpp = new HashMap<>() ;
        int n = arr.length ; 
        for(int i = 0; i< n ; i++){
            if(mpp.containsKey(arr[i])){
                int index = mpp.get(arr[i]); 
                if(Math.abs(index - i)  <= k){
                    return true ; 
                }
            }
            mpp.put(arr[i] , i);
        }
        return false; 
    }
}