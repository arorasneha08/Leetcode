class Solution {
    private boolean isPossible(long mid, int arr[], int cars) {
        long count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += (long) Math.sqrt(mid / arr[i]); 
            if (count >= cars) return true;
        }
        return false;
    }

    public long repairCars(int[] ranks, int cars) {
        int n = ranks.length;
        long start = 1;
        long end = 0;
        int min = Integer.MAX_VALUE; 

        for (int i = 0; i < n; i++) {
            min = Math.min(min, ranks[i]);
        }

        end = (long) min * cars * cars; 
        long ans = 0;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (isPossible(mid, ranks, cars)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
