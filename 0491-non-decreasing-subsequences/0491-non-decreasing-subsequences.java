class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        backtrack(list,new ArrayList<>(), nums,0);
        return list;
    }
    void backtrack(List<List<Integer>> list, List<Integer> templist, int[] nums, int start){
        if(templist.size()>=2)  list.add(new ArrayList<>(templist));
        HashSet<Integer> set=new HashSet<>();
        for(int i=start;i<nums.length;i++){
            if(set.contains(nums[i])) continue;
            if(templist.isEmpty() || nums[i]>=templist.get(templist.size()-1)){
                set.add(nums[i]);
                templist.add(nums[i]);
                backtrack(list,templist,nums,i+1);
                templist.remove(templist.size()-1);
            }
        }
    }
}