class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int sum=1, i=1;
        while(i<n){
            if(ratings[i]==ratings[i-1]){    //flat slopw
                sum+=1;
                i++;
                continue;
            }
            int peak=1;
            while(i<n && ratings[i]>ratings[i-1]){    //inc slope
                peak+=1;
                sum+=peak;
                i++;
            }
            int down=1;
            while(i<n && ratings[i]<ratings[i-1]){    //dec slopw
                sum+=down;
                i++;
                down+=1;
            }
            if(down>peak){
                sum+=down-peak;
            }
        }
        return sum;
    }
}