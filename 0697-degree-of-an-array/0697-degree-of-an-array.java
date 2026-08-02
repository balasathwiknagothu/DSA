class Solution {
    public int findShortestSubArray(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> freq=new HashMap<>();
        HashMap<Integer,Integer> first=new HashMap<>();
        HashMap<Integer,Integer> last=new HashMap<>();
        int size=0;
        for(int i=0;i<nums.length;i++){
            first.putIfAbsent(nums[i],i);
            last.put(nums[i],i);

            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
            size=Math.max(size,freq.get(nums[i]));
        }
        int ans=nums.length;
        for(int key:freq.keySet()){
            if(freq.get(key)==size){
                ans=Math.min(ans,last.get(key)-first.get(key)+1);
            }
        }
        return ans;
    }
}