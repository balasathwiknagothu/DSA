class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        backtrack(candidates,result,target,new ArrayList(),0);
        return result;
    }
    static void backtrack(int[] candidates, List<List<Integer>> result,int target,List<Integer> tempList, int start){
        if(target==0){
            result.add(new ArrayList<>(tempList));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            int num=candidates[i];
            if(num<=target){
                tempList.add(num);
                backtrack(candidates,result,target-num,tempList, i);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}