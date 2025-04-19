class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int n = nums.size();
        Collections.sort(nums); 
        int start = 0 ; 
        int end = n - 1 ;
        int pairs = 0 ; 
        while(start <= end){
            if(nums.get(start) + nums.get(end) < target){
                pairs += end - start ; 
                start ++ ; 
            }
            else{
                end -- ; 
            }
        }
        return pairs ;
    }
}