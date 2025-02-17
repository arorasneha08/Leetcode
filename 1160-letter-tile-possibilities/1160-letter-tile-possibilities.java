class Solution {
    public int numTilePossibilities(String tiles) {
        int n = tiles.length();
        HashSet<String> set = new HashSet<>();
        int visited[] = new int[n+1]; 
        char ch[] = tiles.toCharArray(); 
        backtrack(ch , new StringBuilder() , set , visited); 
        return set.size(); 
    }
    public void backtrack(char ch[] , StringBuilder str , HashSet<String> set , int visited[]){
        if(str.length() > 0){
            set.add(str.toString()); 
        }
        for(int i = 0 ; i < ch.length; i++){
            if(visited[i] == 0){
                str.append(ch[i]);
                visited[i] = 1 ;
                backtrack(ch , str, set, visited); 
                str.deleteCharAt(str.length()-1); 
                visited[i] = 0 ;
            }
        }
    }
}