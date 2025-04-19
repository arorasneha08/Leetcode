class Solution {
    private void func(int digits[] ,Set<String> res , StringBuilder str , boolean[] used){
        if(str.length() == 3){
            if((str.charAt(2) -'0') % 2 == 0 && str.charAt(0) != '0'){
                res.add(str.toString()); 
            }
            return ; 
        }
        for(int i = 0 ; i < digits.length; i++){
            if(used[i]) continue; 
            str.append((char) (digits[i] + '0')); 
            used[i] = true; 
            func(digits , res, str, used);
            str.deleteCharAt(str.length() - 1); 
            used[i] = false; 
        }

    }
    public int totalNumbers(int[] digits) {
        int n = digits.length ; 
        Set<String> set = new HashSet<>();
        boolean used[] = new boolean[n]; 
        func(digits , set ,  new StringBuilder() , used) ; 
        return set.size(); 
    }
}