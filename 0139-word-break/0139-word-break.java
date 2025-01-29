class Solution {
    public class Node{
        Node links[] ; 
        boolean flag ;

        Node(){
            links = new Node[26];
            flag = false ; 
        }
        void put(char ch , Node node){
            links[ch - 'a'] = node; 
        }
        Node get(char ch){
            return links[ch - 'a']; 
        }
        boolean containsKey(char ch){
            return (links[ch - 'a'] != null) ; 
        }
    }
    public class Trie{
        Node root ; 
        Trie(){
            root = new Node() ; 
        }
        void insert(String word){
            Node temp = root;  
            for(int i = 0 ; i < word.length() ; i++){
                char ch = word.charAt(i);
                if(!temp.containsKey(ch)){
                    temp.put(ch , new Node()); 
                }
                temp = temp.get(ch); 
            }
            temp.flag = true; 
        }
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie obj = new Trie(); 
        int n = s.length() ; 
        for(int i = 0 ; i< wordDict.size() ; i++){
            obj.insert(wordDict.get(i)); 
        }
        Boolean[] memo = new Boolean[n];
        return helper(s, 0 , obj , memo); 
    }
    public boolean helper(String s , int start , Trie obj , Boolean[] memo){
        if(start == s.length()) return true; 
        if(memo[start] != null) return memo[start]; 

        Node temp = obj.root; 
        for(int i = start ; i < s.length() ; i++){
            char ch = s.charAt(i); 
            if(!temp.containsKey(ch)){
                return memo[start] = false ; 
            }
            temp = temp.get(ch); 
            if(temp.flag && helper(s, i+1 , obj , memo)){
                return memo[start] = true  ; 
            }
        }
        return memo[start] = false ; 
    }
}