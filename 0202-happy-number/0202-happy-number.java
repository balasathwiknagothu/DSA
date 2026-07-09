class Solution {
    public boolean isHappy(int n) {
        int left=sum(n);
        int right=sum(sum(n));
        while(left!=right){
            left=sum(left);
            right=sum(sum(right));
        }
        return left==1;
    }
    public int sum(int x){
        int total=0;
        while(x>0){
            int rem=x%10;
            total+=rem*rem;
            x=x/10;
        }
        return total;
    }   
    
}