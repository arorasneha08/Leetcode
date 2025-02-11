class Solution {
    public String removeOccurrences(String s, String part) {
        int n = part.length();
        while(s.contains(part)){
            int startIdx = s.indexOf(part);
            s = s.substring(0, startIdx) + s.substring(startIdx + n); 
        }
        return s ; 
    }
}