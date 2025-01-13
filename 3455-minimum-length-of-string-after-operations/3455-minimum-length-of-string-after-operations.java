class Solution {
    public int minimumLength(String s) {
        int n = s.length() ;
        HashMap<Character, Integer> mpp = new HashMap<>() ;
        for(char ch : s.toCharArray()){
            mpp.put(ch , mpp.getOrDefault(ch  , 0) + 1); 
        }
        int maxLen = 0 ; 
        for(Integer num : mpp.values()){
            if(num % 2 == 0){
                maxLen += 2 ; 
            }
            if(num % 2 == 1){
                maxLen += 1 ; 
            }
        }
        return maxLen ; 
    }
}