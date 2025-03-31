class Solution {
    public long putMarbles(int[] weights, int k) {
        if(k == 1) return 0; 
        int n = weights.length ; 
        int left = 0 ; 
        int right = 0 ; 
        List<Integer> list = new ArrayList<>(); 
        long min = 0 , max = 0; 
        for(int i = 0 ; i < n-1 ; i++){
            list.add(weights[i] + weights[i+1]); 
        } 
        Collections.sort(list); 
        for(int i = 0 ; i < k -1; i++){
            min += list.get(i);
            max += list.get(list.size() - i - 1);  
        }   
        return max - min  ;
    }
}