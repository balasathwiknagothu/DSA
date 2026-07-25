class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return backtrack(nums, target, 0, 0);
    }

    int backtrack(int[] nums, int target, int index, int sum) {

        if (index == nums.length) {
            return sum == target ? 1 : 0;
        }

        int add = backtrack(nums, target, index + 1, sum + nums[index]);
        int subtract = backtrack(nums, target, index + 1, sum - nums[index]);

        return add + subtract;
    }
}