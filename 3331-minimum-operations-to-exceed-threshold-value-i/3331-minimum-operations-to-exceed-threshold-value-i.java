class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length ; 
        int oper = 0 ; 
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            pq.offer(num); 
        }
        while(!pq.isEmpty() && pq.peek() < k){
            pq.poll();
            oper++; 
        }
        return oper ;
    }
}