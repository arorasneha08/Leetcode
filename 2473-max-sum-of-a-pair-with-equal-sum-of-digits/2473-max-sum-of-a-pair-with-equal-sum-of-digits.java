class Solution {
    public int digitSum(int num){
        int sum = 0 ;
        while(num != 0 ){
            int r = num % 10  ;
            sum = sum + r ; 
            num = num / 10 ; 
        }
        return sum ; 
    }
    public int maximumSum(int[] nums) {
        int n = nums.length; 
        HashMap<Integer , List<Integer>> mpp = new HashMap<>(); 
        for(int i = 0 ; i < n ; i++){
            int digSum = digitSum(nums[i]); 
            if(!mpp.containsKey(digSum)){
                mpp.put(digSum , new ArrayList<>());
            }
            mpp.get(digSum).add(nums[i]); 
        }
        int maxSum = -1 ; 
        for(Map.Entry<Integer, List<Integer>> entry : mpp.entrySet()){
            List<Integer> list = entry.getValue(); 
            if(list.size() > 1){
                Collections.sort(list , Collections.reverseOrder()); 
                int sum = list.get(0) + list.get(1) ; 
                maxSum = Math.max(sum , maxSum); 
            }
        }
        return maxSum ; 
    }
}