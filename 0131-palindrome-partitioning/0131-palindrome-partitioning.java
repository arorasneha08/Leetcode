class Solution {
    public boolean palindrome(int left , int right, String s ){
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)) return false; 
            left ++ ;
            right -- ; 
        }
        return true ; 
    }
    public void backtrack(int index , String s , List<String> list , List<List<String>> res){
        if(index == s.length()){
            res.add(new ArrayList<>(list));
            return ; 
        }
        for(int i = index ; i< s.length() ; i++){
            if(palindrome(index , i , s)){
                list.add(s.substring(index , i + 1)); 
                backtrack(i+1 , s , list , res);
                list.remove(list.size()-1); 
            }
        }
    }
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<String> list = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();

        backtrack(0 , s , list, res);
        return res; 
    }
}