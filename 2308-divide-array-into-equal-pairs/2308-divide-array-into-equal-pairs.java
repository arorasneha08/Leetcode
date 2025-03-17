class Solution {
    public boolean divideArray(int[] nums) {
        int n = nums.length ;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for(int num : nums){
            mpp.put(num , mpp.getOrDefault(num , 0)+1); 
        }
        for(int value : mpp.values()){
            if(value % 2 != 0) return false ; 
        }
        return true; 
    }
}