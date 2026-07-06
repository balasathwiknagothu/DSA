class Solution {
    public int splitArray(int[] nums, int k) {
        int max = 0, sum = 0;

        for (int x : nums) {
            max = Math.max(max, x);
            sum += x;
        }

        int left = max;
        int right = sum;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canWePartition(nums, mid, k)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    boolean canWePartition(int[] arr, int limit, int k) {
        int partitions = 1;
        int curSum = 0;

        for (int a : arr) {
            if (curSum + a <= limit) {
                curSum += a;
            } else {
                partitions++;
                curSum = a;

                if (partitions > k)
                    return false;
            }
        }

        return true;
    }
}