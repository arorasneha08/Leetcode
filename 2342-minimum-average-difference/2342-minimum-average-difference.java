class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long totalSum = 0; 
        long leftSum = 0;
        long rightSum;

        for (int num : nums) {
            totalSum += num;
        }

        int minDiff = Integer.MAX_VALUE;
        int index = 0;

        for (int i = 0; i < n; i++) {
            leftSum += nums[i];
            rightSum = totalSum - leftSum;

            long leftAvg = leftSum / (i + 1);
            long rightAvg = (i == n - 1) ? 0 : rightSum / (n - i - 1);

            int diff = (int) Math.abs(leftAvg - rightAvg);

            if (diff < minDiff) {
                minDiff = diff;
                index = i;
            }
        }

        return index;
    }
}
