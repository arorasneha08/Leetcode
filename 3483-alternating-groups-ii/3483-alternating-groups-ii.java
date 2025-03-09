class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int count = 0 ;
        int left = 0 , right = 0 ;

        while(right < n+k-1){
            if(right > 0 && colors[right % n] == colors[(right -1) % n ]){
                left = right; 
            }
            if(right - left + 1 >= k){
                count ++; 
            }
            right ++ ; 
        }
        return count; 
    }
}