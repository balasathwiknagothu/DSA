class Solution {
    public int findContentChildren(int[] g, int[] s) {//greed and size arrays
        int n=g.length, m=s.length; 
        int l=0,r=0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(l<m && r<n){
            if(g[r]<=s[l]){
                r=r+1;
            }
            l++;
        }
        return r;
    }
}