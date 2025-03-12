class Solution {
    private int lowerBound(int[] nums) {
        int start = 0, end = nums.length - 1;
        int index = nums.length;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] < 0) {
                start = mid + 1;
            } else if (nums[mid] >= 0) {
                end = mid - 1;
                index = mid;
            }
        }

        return index;
    }
    private int upperBound(int[] nums) {
        int start = 0, end = nums.length - 1;
        int index = nums.length;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] <= 0) {
                start = mid + 1;
            } else if (nums[mid] > 0) {
                end = mid - 1;
                index = mid;
            }
        }

        return index;
    }

    public int maximumCount(int[] nums) {
        int pos = nums.length - upperBound(nums);
        int neg = lowerBound(nums);

        return Math.max(pos, neg);
    }
}