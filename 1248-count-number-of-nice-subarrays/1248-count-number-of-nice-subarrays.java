class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            nums[i]=nums[i]%2;
        }
        return helper(nums,k) - helper(nums,k-1);
    }
    int helper(int[] arr, int k){
        int l=0,r=0, sum=0, count=0;
        while(r<arr.length){
            sum+=arr[r];
            while(sum>k){
                sum-=arr[l];
                l++;
            }
            count+=(r-l+1);
            r++;
        }
        return count;
    }
}