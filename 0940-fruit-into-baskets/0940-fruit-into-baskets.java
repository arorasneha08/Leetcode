class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length ;
        HashMap<Integer , Integer> mpp = new HashMap<>();
        int k = 2  ;
        int left = 0 ; 
        int maxLen = 0 ; 
        
        for(int right = 0 ; right <n ; right ++){
            mpp.put(fruits[right] , mpp.getOrDefault(fruits[right] , 0) + 1); 
            
            if(mpp.size() > k){
                mpp.put(fruits[left] , mpp.get(fruits[left]) - 1);
                if(mpp.get(fruits[left]) == 0){
                    mpp.remove(fruits[left]); 
                }
                left ++; 
            }
            if(mpp.size() <= k){
                maxLen = Math.max(maxLen , right - left + 1); 
            }
        }
        return maxLen ; 
    }
}