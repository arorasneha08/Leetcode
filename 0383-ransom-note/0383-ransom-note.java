class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int n = magazine.length() ;
        HashMap<Character , Integer> mpp = new HashMap<>() ; 
        for(int i = 0; i< n ;i++){
            char ch = magazine.charAt(i); 
            mpp.put(ch , mpp.getOrDefault(ch , 0) + 1) ; 
        }
        for(int i = 0 ; i< ransomNote.length() ; i++){
            char ch = ransomNote.charAt(i) ; 
            if(mpp.getOrDefault(ch, 0) == 0){
                return false; 
            }
            mpp.put(ch , mpp.get(ch) -1 ); 
        }
        return true; 
    }
}