class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;

        long[] prefixMax = new long[n];
        prefixMax[0] = Long.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i - 1]);
        }

        long[] suffixMax = new long[n];
        suffixMax[n - 1] = Long.MIN_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], nums[i + 1]);
        }

        long maxValue = 0;
        for (int j = 1; j < n - 1; j++) {
            if (prefixMax[j] > nums[j] && suffixMax[j] > 0) {
                long value = (prefixMax[j] - nums[j]) * suffixMax[j];
                maxValue = Math.max(maxValue, value);
            }
        }

        return maxValue;
    }
}
