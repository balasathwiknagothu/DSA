class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] lprod=new int[n];
        Arrays.fill(lprod,1);
        int[] rprod=new int[n];
        Arrays.fill(rprod,1);
        for(int i=1;i<n;i++){
            lprod[i]=nums[i-1]*lprod[i-1];
        }
        for(int i=n-2;i>=0;i--){
            rprod[i]=nums[i+1]*rprod[i+1];
        }
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            res[i]=lprod[i]*rprod[i];
        }
        return res;
    }
}