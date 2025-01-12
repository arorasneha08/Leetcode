class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans =  new ArrayList<>(); 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> (a[0] -b[0])) ;
        
        for(int i = 0 ; i< nums2.length ; i++){
            pq.offer(new int[]{nums1[0] + nums2[i], 0, i}); 
        }
        
        while(!pq.isEmpty() && k > 0){
            int curr[] = pq.poll(); 
            int sum = curr[0] ;
            int i = curr[1] ;
            int j = curr[2]; 
            ans.add(Arrays.asList(nums1[i], nums2[j])); 

            if(i + 1 < nums1.length){
                pq.offer(new int[]{nums1[i+1] + nums2[j] , i+1, j}); 
            }
            k--;
        }
        return ans ; 
    }
}