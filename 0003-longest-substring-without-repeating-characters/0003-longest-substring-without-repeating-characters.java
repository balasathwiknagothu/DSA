import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0, r=0, maxlen=0;
        int[] lastSeen=new int[256];
        Arrays.fill(lastSeen,-1);
        int n=s.length();
        while(r<n){
            char ch=s.charAt(r);
            if(lastSeen[ch] !=-1){
                if(lastSeen[ch]>=l){
                    l=lastSeen[ch]+1;
                }
            }
            maxlen=Math.max(maxlen, r-l+1);
            lastSeen[ch]=r;
            r++;
        }
        return maxlen;
    }
}