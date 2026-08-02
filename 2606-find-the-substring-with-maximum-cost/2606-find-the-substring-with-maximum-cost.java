class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int n=vals.length;
        int m=s.length();
        int[] arr=new int[26];
        for(int i=0;i<26;i++){
            arr[i]=i+1;
        }
        for(int i=0;i<n;i++){
            char ch=chars.charAt(i);
            arr[ch-97]=vals[i];
        }
        int max=0;
        int sum=0;
        for(int i=0;i<m;i++){
            char ch=s.charAt(i);
            int val=arr[ch-97];
            sum+=val;
            if(sum<0) sum=0;
            max=Math.max(max,sum);
        }
        return max;
    }
}