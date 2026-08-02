class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int res=0;
        for(int i=0;i<k;i++){
            if(numOnes>0){
                res++;
                numOnes--;
            }else if(numOnes<=0 && numZeros>0){
                
                numZeros--;
            }else{
                numNegOnes--;
                res--;

            }
        }
        return res;
    }
}