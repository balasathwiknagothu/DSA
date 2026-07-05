class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length;
        int left=1;
        int right=Arrays.stream(nums).max().getAsInt();
        int ans=0;
        while(left<=right){
            int mid=left+(right-left)/2;
            int divsum=calceilsum(nums,threshold, mid);
            if(divsum<=threshold){
                ans=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
    int calceilsum(int[] nums, int threshold, int k){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=(nums[i]+k-1)/k;
        }
        return sum;
    }
}