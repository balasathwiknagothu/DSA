class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Long> prefixSum = new HashMap<>();

        long maxSum = Long.MIN_VALUE;
        long psum = 0;

        for (int i = 0; i < nums.length; i++) {

            if (prefixSum.getOrDefault(nums[i], Long.MAX_VALUE) > psum) {
                prefixSum.put(nums[i], psum);
            }

            psum += nums[i];

            if (prefixSum.containsKey(nums[i] + k)) {
                maxSum = Math.max(maxSum,
                        psum - prefixSum.get(nums[i] + k));
            }

            if (prefixSum.containsKey(nums[i] - k)) {
                maxSum = Math.max(maxSum,
                        psum - prefixSum.get(nums[i] - k));
            }
        }

        return maxSum == Long.MIN_VALUE ? 0 : maxSum;
    }
}