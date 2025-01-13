class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        while(n != 1){
            int sum = 0 ;
            while(n > 0){
                int r = n % 10; 
                sum += r * r ; 
                n /= 10 ;  
            }
            if(seen.contains(sum)) return false ; // cycle detected 
            seen.add(sum);
            n = sum ; 
        }
        return true ;
    }
}