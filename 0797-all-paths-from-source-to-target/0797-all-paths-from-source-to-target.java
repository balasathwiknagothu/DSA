class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int source=0, dest=graph.length-1;
        List<List<Integer>> result=new ArrayList<>();
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            adj.add(new ArrayList<>());
            
        }
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }
        dfs(adj, new ArrayList<>(), result,source,dest);
        return result; 
    }
    void dfs(List<List<Integer>> adj, List<Integer> temp, List<List<Integer>> result,int start, int dest){
        temp.add(start);
        if(start==dest){
            result.add(new ArrayList<>(temp));
        }else{
            for(int x:adj.get(start)) dfs(adj,temp,result,x,dest);
        }
        temp.remove(temp.size()-1);
        return;
    }
}