class Solution {
    public int countGoodSubstrings(String s) {
        int n = s.length(); 
        int k = 3 ; 
        int count = 0 ; 
        int left = 0 ;
        HashMap<Character , Integer> mpp = new HashMap<>();

        for(int right = 0 ; right < n ; right ++){
            mpp.put(s.charAt(right), mpp.getOrDefault(s.charAt(right), 0) + 1);

            if(right - left + 1 > k){
                mpp.put(s.charAt(left) , mpp.get(s.charAt(left)) - 1) ;
                if(mpp.get(s.charAt(left)) == 0){
                    mpp.remove(s.charAt(left)); 
                }
                left ++ ; 
            }
            if (right - left + 1 == k && mpp.size() == 3) {
                count++;
            }
        }
        return count ; 
    }
}