class Solution {
    public long maximumTotalSum(int[] maximumHeight) {
        int n = maximumHeight.length ; 
        Arrays.sort(maximumHeight); 

        long sum = maximumHeight[n-1]  ;
        int lastAssigned = maximumHeight[n-1] ; 

        for(int i = n-2 ; i>=0 ; i--){
            if(maximumHeight[i] >= lastAssigned){
                lastAssigned -- ; 
                if(lastAssigned <= 0) return -1; 
                sum += lastAssigned ; 
            }
            else{
                lastAssigned = maximumHeight[i];
                sum += lastAssigned ; 
            }
        }
        return sum ; 
    }
}