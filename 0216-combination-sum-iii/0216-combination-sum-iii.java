class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list=new ArrayList<>();
        backtrack(k,1, n,list, new ArrayList<>());
        return list;
    }
    void backtrack(int k, int num, int target, List<List<Integer>> list, List<Integer> templist){
        if(target==0 && k==0){
            list.add(new ArrayList<>(templist));
            return;
        }
        for(int i=num;i<10;i++){
            if(i>target || k<=0) break;
            templist.add(i);
            backtrack(k-1,i+1,target-i,list,templist);
            templist.remove(templist.size()-1);
        }
    }
}