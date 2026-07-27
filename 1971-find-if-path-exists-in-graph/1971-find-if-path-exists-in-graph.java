class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited=new boolean[n];
        return dfs(adj,visited, source, destination);
    }
    boolean dfs(List<List<Integer>> adj, boolean[] visited, int vertex, int dest){
        if(vertex==dest)    return true;
        visited[vertex]=true;
        for(int neigh:adj.get(vertex)){
            if(!visited[neigh]){
                if(dfs(adj,visited,neigh,dest)) return true;
            }
        }
        return false;
    }
}