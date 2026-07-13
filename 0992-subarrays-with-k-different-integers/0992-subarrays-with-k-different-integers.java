class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums,k)-atMost(nums,k-1);
    }
    int atMost(int[] arr, int k){
        HashMap<Integer, Integer> map=new HashMap<>();
        int l=0,r=0, count=0;
        while(r<arr.length){
            map.put(arr[r], map.getOrDefault(arr[r],0)+1);
            while(map.size()>k){
                map.put(arr[l],map.get(arr[l])-1);
                if(map.get(arr[l])==0){
                    map.remove(arr[l]);
                }
                l++;
            }
            count+=r-l+1;
            r++;
        }
        return count;
    }
}