class Solution {
    public int distinctPrimeFactors(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length; 
        for(int num : nums){
            while(num % 2 == 0){
                set.add(2);
                num = num / 2; 
            }
            for(int i = 3 ; i <= Math.sqrt(num) ; i++){
                while(num % i == 0){
                    set.add(i);
                    num = num / i ; 
                }
            }
            if(num > 2){
                set.add(num); 
            }
        }
        return set.size(); 
    }
}