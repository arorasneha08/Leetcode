class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums) ;
        int n = nums.length; 
        int dp[] = new int[n]; 
        int hash[] = new int[n] ; 
        Arrays.fill(dp , 1); 
        int max = 1 ; 
        int lastIdx = 0 ; 
        for(int i = 0 ; i < n ; i++){
            hash[i] = i ; 
            for(int prev = 0 ; prev < i ; prev++){
                if(nums[i] % nums[prev]  == 0 && 1 + dp[prev] > dp[i]){
                    dp[i] = 1 + dp[prev]; 
                    hash[i] = prev ; 
                }
            }
            if(dp[i] > max){
                max = dp[i];
                lastIdx = i ; 
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[lastIdx]); 
        while(hash[lastIdx] != lastIdx){
            lastIdx = hash[lastIdx]; 
            list.add(nums[lastIdx]); 
        }
        Collections.reverse(list);
        return list ; 
    }
}