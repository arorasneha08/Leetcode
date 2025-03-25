class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int n = s.length();
        int m = p.length(); 
        int freqp [] = new int[26];
        int freqs[] = new int[26];

        for(int i = 0 ; i < m ; i++){
            freqp[p.charAt(i) - 'a'] ++ ;  
        }
        for(int i = 0 ; i < n ; i++){
            freqs[s.charAt(i) - 'a'] ++ ; 
            if(i >= m){
                freqs[s.charAt(i-m) - 'a'] --; 
            }
            if(Arrays.equals(freqp, freqs)){
                list.add(i - m + 1); 
            }
        }
        return list; 
    }
}