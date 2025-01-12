class Solution {
    public int beautySum(String s) {
        int n = s.length() ; 
        int sum = 0 ; 
        for(int i = 0 ; i<n ; i++){
            HashMap<Character, Integer> mpp = new HashMap<>();
            int maxFreq = 0 ; 
            for(int j = i ; j<n ; j++){
                char ch = s.charAt(j); 
                mpp.put(ch , mpp.getOrDefault(ch , 0) + 1); 
                maxFreq = Math.max(maxFreq , mpp.get(ch)); 
                int minFreq = Integer.MAX_VALUE ;
                for(int freq : mpp.values()){
                    minFreq = Math.min(minFreq, freq); 
                }
                sum += (maxFreq - minFreq);
            }
        }
        return sum ; 
    }
}