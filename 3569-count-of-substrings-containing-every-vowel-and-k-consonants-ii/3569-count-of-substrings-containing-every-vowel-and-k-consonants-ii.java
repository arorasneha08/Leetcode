class Solution {
    private boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch =='u' ; 
    }
    private long helper(String word , int k){
        int n = word.length() ; 
        long res = 0 ;
        int cons = 0 ; 
        int left = 0 , right = 0 ; 
        HashMap<Character , Integer> mpp = new HashMap<>();

        while(right < n){
            char ch = word.charAt(right); 
            if(isVowel(ch)){
                mpp.put(ch , mpp.getOrDefault(ch , 0) +1) ;
            }
            else{
                cons ++ ; 
            }
            while(mpp.size() == 5 && cons >= k){
                res += n - right; 
                char leftChar = word.charAt(left); 
                if(isVowel(leftChar)){
                    mpp.put(leftChar , mpp.get(leftChar)-1); 
                    if(mpp.get(leftChar) == 0){
                        mpp.remove(leftChar);
                    }
                }
                else{
                    cons --; 
                }
                left ++ ; 
            }
            right ++ ; 
        }
        return res; 
    }
    public long countOfSubstrings(String word, int k) {
        return helper(word, k ) - helper(word, k+1); 
    }
}