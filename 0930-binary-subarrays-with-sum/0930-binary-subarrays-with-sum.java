class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return helper(nums, goal)-helper(nums,goal-1);
    }
    int helper(int[] arr, int k){
        if(k<0) return 0;
        int l=0, r=0, sum=0, count=0;
        while(r<arr.length){
            sum+=arr[r];
            while(sum>k){
                sum=sum-arr[l];
                l++;
            }
            count+=(r-l+1);
            r++;
        }
        return count;
    }
}