class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer , Integer> mpp = new HashMap<>();
        HashMap<Integer , Integer> mpp2 = new HashMap<>();
        for(int i = 0 ; i < arr.length; i++){
            mpp.put(arr[i] , mpp.getOrDefault(arr[i] , 0) + 1); 
        }
        for(Map.Entry<Integer , Integer> entry : mpp.entrySet()){
            int val = entry.getValue();
            mpp2.put(val , mpp2.getOrDefault(val , 0) +1); 
        }
        for(Map.Entry<Integer , Integer> entry : mpp2.entrySet()){
            int cnt = entry.getValue();
            if(cnt > 1) return false; 
        }
        return true; 
        
    } 
}