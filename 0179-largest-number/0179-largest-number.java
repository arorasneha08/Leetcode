class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder str = new StringBuilder() ;
        int n = nums.length ; 
        String arr[] = new String[n]; 
        for(int i = 0 ; i < n ; i++){
            arr[i] = nums[i] + ""; 
        }
        Arrays.sort(arr, (s1 , s2)->(s1 + s2).compareTo(s2+s1)); 
        for(int i = n-1 ; i>= 0; i--){
            str.append(arr[i]); 
        }
        if(str.charAt(0) == '0') return "0" ; 
        return str.toString(); 
    }
}