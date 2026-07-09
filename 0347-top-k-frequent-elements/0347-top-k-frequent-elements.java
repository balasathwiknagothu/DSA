class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int e:nums){
            map.put(e,map.getOrDefault(e,0)+1);
        }
        ArrayList<Map.Entry<Integer,Integer>> arr=new ArrayList<>(map.entrySet());
        arr.sort((a,b)->b.getValue()-a.getValue());
        int[] last=new int[k];
        for(int i=0;i<k;i++){
            last[i]=arr.get(i).getKey();
        }
        return last;
    }
}