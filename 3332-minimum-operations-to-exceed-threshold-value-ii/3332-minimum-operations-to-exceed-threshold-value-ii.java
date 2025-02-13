class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add((long)num);
        }
        int ans = 0;
        while (minHeap.size() > 1 && minHeap.peek() < k) {
            long num1 = minHeap.poll();
            long num2 = minHeap.poll();
            long mini = Math.min(num1, num2) * 2 + Math.max(num1, num2);
            minHeap.add(mini);
            ans++;
        }
        return ans;
    }
}