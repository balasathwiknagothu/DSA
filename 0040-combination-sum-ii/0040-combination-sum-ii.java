class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list,new ArrayList<>(), candidates,target,0);
        return list;
    }
    void backtrack(List<List<Integer>> list, List<Integer> templist,int[] nums, int remain, int start){
        if(remain==0){
            list.add(new ArrayList<>(templist));
            return;
        } 
        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1])   continue;
            if(nums[i]>remain)  break;
            templist.add(nums[i]);
            backtrack(list, templist,nums, remain-nums[i],i+1);
            templist.remove(templist.size()-1);
        }
    }
}