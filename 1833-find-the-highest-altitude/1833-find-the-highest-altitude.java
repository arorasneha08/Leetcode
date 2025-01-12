class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int netGain[] = new int[n];
        netGain[0] = gain[0] ; 
        int max = 0 ; 
        for(int i = 1 ; i<n ; i++){
            netGain[i] = netGain[i-1] + gain[i] ; 
        }
        for(int i = 0 ; i< n ; i++){
            max = Math.max(max , netGain[i]);
        }
        return max ; 
    }
}