class Solution {
    public int partitionString(String s) {
        int n = s.length();
        int start = 0 ; 
        List<String> res = new ArrayList<>(); 
        Set<Character> set = new HashSet<>() ; 

        for(int i = 0; i < n ; i++){
            char ch = s.charAt(i); 
            if(set.contains(ch)){
                res.add(s.substring(start , i)); 
                set.clear(); 
                start = i ; 
            }
            set.add(ch); 
        }
        res.add(s.substring(start , n)); 
        return res.size(); 
    }
}