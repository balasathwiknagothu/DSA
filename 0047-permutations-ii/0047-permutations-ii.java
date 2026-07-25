class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtrack(list, new ArrayList<>(), nums, visited);
        return list;
    }

    void backtrack(List<List<Integer>> list,
                   List<Integer> tempList,
                   int[] nums,
                   boolean[] visited) {

        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (visited[i])
                continue;

            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])
                continue;

            visited[i] = true;
            tempList.add(nums[i]);

            backtrack(list, tempList, nums, visited);

            tempList.remove(tempList.size() - 1);
            visited[i] = false;
        }
    }
}