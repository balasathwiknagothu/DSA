class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int ans=-1;
        int n=position.length;
        int left=1,right=(position[n-1]-position[0])/(m-1);
        while(left<=right){
            int mid=left+(right-left)/2;
            if(canWePlace(position, mid, m)==true){
                ans=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return ans;
    }

    boolean canWePlace(int[] arr, int dist, int m){
        int countballs=1, lastball=arr[0];
        int n=arr.length;
        for(int i=1;i<n;i++){
            if(arr[i]-lastball >=dist){
                countballs++;
                lastball=arr[i];
            }
            if(countballs>=m) return true;
        }
        return false;
    }
}