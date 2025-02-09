class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long goodPairs = 0 ;
        long totalPairs = 0 ; 
        HashMap<Integer , Integer> mpp = new HashMap<>(); 

        for(int i = 0 ; i < n ; i++){
            int diff = nums[i] - i ; 

            goodPairs += mpp.getOrDefault(diff , 0);
            mpp.put(diff , mpp.getOrDefault(diff , 0) + 1) ;
        }
        totalPairs += (long) n * (n - 1)/2 ; 
        return totalPairs - goodPairs ; 
    }
}