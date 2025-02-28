class Solution {
    public boolean checkIfPangram(String sentence) {
        int n = sentence.length();
        HashSet<Character> set = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            set.add(sentence.charAt(i)); 
        }
        if(set.size() == 26) return true; 
        return false; 
    }
}