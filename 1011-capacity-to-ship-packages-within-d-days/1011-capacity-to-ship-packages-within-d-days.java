class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int max = Arrays.stream(weights).max().getAsInt();
        int sum = Arrays.stream(weights).sum();

        int left=max, right=sum;
        while(left<=right){
            int mid=left+(right-left)/2;
            int noofDays=findDays(weights, mid);
            if(noofDays<=days){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    int findDays(int[] weights, int cap){
        int days=1, load=0;
        for(int i=0;i<weights.length;i++){
            if(weights[i]+load>cap){
                days+=1;
                load=weights[i];
            }else{
                load+=weights[i];
            }
        }
        return days;
    }
}