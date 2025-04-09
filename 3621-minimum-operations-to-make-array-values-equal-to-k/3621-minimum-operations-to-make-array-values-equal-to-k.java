class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length ; 
        HashMap<Integer , Integer> mpp = new HashMap<>() ;
        for(int num : nums){
            if(num < k) return -1 ;
            else if(num > k){
                mpp.put(num , mpp.getOrDefault(num , 0) + 1) ; 
            }
        }
        return mpp.size(); 
    }
}