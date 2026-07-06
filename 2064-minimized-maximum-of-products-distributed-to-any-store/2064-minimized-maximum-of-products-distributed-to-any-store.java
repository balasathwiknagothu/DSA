class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int left=1, right=Arrays.stream(quantities).max().getAsInt();
        int ans=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(CanDistribute(quantities, mid, n)){
                ans=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
    boolean CanDistribute(int[] quantities, int item, int n){
        if(n==0) return false;
        int sum=0;
        for(int p:quantities){
            sum+=(p-1)/item +1;
            if(sum>n) return false;
        }
        return true;
    }
}