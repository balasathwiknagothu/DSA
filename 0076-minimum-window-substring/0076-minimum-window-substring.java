class Solution {
    public String minWindow(String s, String t) {
        int[] hash=new int[256];
        Arrays.fill(hash,0);
        int l=0,r=0, minlen=(int)(Math.pow(10,9)), sIndex=-1, count=0;
        int n=s.length(), m=t.length();
        for(int i=0;i<m;i++){
            hash[t.charAt(i)]++;
        }
        while(r<s.length()){
            if(hash[s.charAt(r)]>0){
                count=count+1;
            }
            hash[s.charAt(r)]--;
            while(count==m){
                if(r-l+1 < minlen){
                    minlen=r-l+1;
                    sIndex=l;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)]>0) count=count-1;
                l++;
            }
            r++;
        }
        return sIndex==-1 ? "" : s.substring(sIndex,sIndex+minlen);
    }
}