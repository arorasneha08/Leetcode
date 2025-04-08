class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length; 
        int count = 0 ; 
        List<Integer> list = new ArrayList<>();
        for(int num : nums){
            list.add(num); 
        }
        while(true){
            HashSet<Integer> set = new HashSet<>();
            boolean duplicate = false;

            for(int num : list){
                if(set.contains(num)){
                    duplicate = true ;
                    break; 
                }
                set.add(num); 
            } 
            if(!duplicate) break ; 
            int removeCount = Math.min(3 , list.size()); 
            for(int i = 0 ; i < removeCount ; i++){
                list.remove(0); 
            }
            count ++ ; 
        }
        return count; 
    }
}