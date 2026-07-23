class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        if(n<=2) return n;
        int mask=0;
        for(int x:nums){
            mask|=x;
        }
        return mask+1;
    }
}