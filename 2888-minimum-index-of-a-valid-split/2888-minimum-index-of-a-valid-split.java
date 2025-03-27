class Solution {
    private int findMajorityElement(List<Integer> nums){
        int n = nums.size() ; 
        int elem = 0 ; 
        int count = 0 ; 
        for(int i = 0 ; i < nums.size() ; i++){
            if(count == 0){
                elem = nums.get(i);
                count = 1 ; 
            }
            else if(elem == nums.get(i)){
                count ++ ; 
            }
            else{
                count -- ; 
            }
        }
        return elem ; 
    }
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size() ; 
        int maj = findMajorityElement(nums);
        int totalcount = 0 ; 
        for(int i = 0 ; i < nums.size() ; i++){
            if(nums.get(i) == maj) {
                totalcount ++ ; 
            }
        }
        int count = 0 ; 
        for(int i = 0 ; i < n ; i++){
            if(nums.get(i) == maj) count ++ ; 
            int leftCount = count; 
            int rightCount = totalcount - count ; 
            if(leftCount > (i+1)/2 && rightCount > (n-i-1)/2){
                return i ; 
            }
        }
        return -1 ; 
    }
}