class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0, maxLen=0, zeroCount=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zeroCount++;
            }
            while(zeroCount>k){
                if(nums[l]==0){
                    zeroCount--;
                }
                l++;
            }
            maxLen=Math.max(maxLen, i-l+1);
        }
        return maxLen;
    }
}