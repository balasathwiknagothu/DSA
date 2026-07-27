class Solution {
    public int findCenter(int[][] edges) {
        
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<edges.length;i++){
            for(int j=0;j<edges[0].length;j++){
                map.put(edges[i][j],map.getOrDefault(edges[i][j],0)+1);
            }
        }
        int maxValue=Integer.MIN_VALUE;
        int maxKey=-1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        if(maxValue==edges.length){
            return maxKey;
        }
        return -1;

    }
}