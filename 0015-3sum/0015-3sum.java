class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        HashSet<List<Integer>> set=new HashSet<>();
        int n=nums.length;
        for(int i=0;i<n-2;i++){
            int l=i+1,r=n-1;
            while(l<r){
                if(nums[l]+nums[r]+nums[i]==0){
                    if(!set.contains(Arrays.asList(nums[i],nums[l],nums[r])))
                   {     
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    set.add(Arrays.asList(nums[i],nums[l],nums[r]));
                   }
                    l++;
                    r--;
                }else if(nums[l]+nums[r]+nums[i]>0){
                    r--;
                }else if(nums[l]+nums[r]+nums[i]<0){
                    l++;
                }
            }
        }
        return res;
    }
}