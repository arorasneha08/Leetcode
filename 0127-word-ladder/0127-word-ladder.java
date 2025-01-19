class Solution {
    public class Pair{
        String word ;
        int steps ; 
        Pair(String word , int steps){
            this.word = word; 
            this.steps = steps; 
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));

        HashSet<String> set = new HashSet<>();
        int len = wordList.size() ;

        for(int i = 0 ; i<len ; i++){
            set.add(wordList.get(i)); 
        }
        set.remove(beginWord);

        while(!q.isEmpty()){
            Pair curr = q.poll(); 
            String w = curr.word ;
            int s = curr.steps ;

            if(w.equals(endWord)){
                return s; 
            }
            for(int i = 0 ; i< w.length(); i++){
                for(char ch = 'a' ; ch <= 'z' ; ch ++){
                    char replacedArr[] = w.toCharArray();
                    replacedArr[i] = ch ; 
                    String replacedWord = new String(replacedArr);
                    if(set.contains(replacedWord)){
                        set.remove(replacedWord); 
                        q.add(new Pair(replacedWord, s + 1)) ; 
                    } 
                }
            }
        }
        return 0; 
    }
}