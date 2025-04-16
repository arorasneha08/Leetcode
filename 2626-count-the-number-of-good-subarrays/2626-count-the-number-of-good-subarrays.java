class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length; 
        Map<Integer, Integer> mpp = new HashMap<>();
        long ans = 0;
        long pairs = 0 ; 
        int left = 0 ; 
        for(int right = 0 ; right < n ; right ++){
            int val = nums[right];
            pairs += mpp.getOrDefault(val , 0); 
            mpp.put(val , mpp.getOrDefault(val, 0) + 1); 
            while(pairs >= k){
                ans += nums.length - right; 
                int out = nums[left++];
                mpp.put(out , mpp.get(out) - 1);
                pairs -= mpp.get(out); 
            }
        }
        return ans;
    }
}