class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length ;
        int common = 0; 
        int ans[] = new int[n] ; 
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> alreadyCounted = new HashSet<>();
        for(int i = 0; i<n ; i++){
            if(seen.contains(A[i])){
                if(!alreadyCounted.contains(A[i])){
                    common ++ ;
                    alreadyCounted.add(A[i]);
                }
            }
            else{
                seen.add(A[i]); 
            }
            if(seen.contains(B[i])){
                if(!alreadyCounted.contains(B[i])){
                    common ++; 
                    alreadyCounted.add(B[i]); 
                }
            }
            else{
                seen.add(B[i]); 
            }
            ans[i] = common ; 
        }
        return ans ; 
    }
}