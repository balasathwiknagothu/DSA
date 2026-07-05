class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if((long)m*k>n) return -1;
        int min=Arrays.stream(bloomDay).min().getAsInt();
        int max=Arrays.stream(bloomDay).max().getAsInt();

        int left=min, right=max;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(possible(bloomDay, mid,m,k)){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    boolean possible(int[] arr, int day, int m, int k){
        int count=0, noofBloom=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=day){
                count++;
            }else{
                noofBloom+=(count)/k;
                count=0;
            }
        }
        noofBloom+=(count/k);
        return (noofBloom>=m);
    }
}