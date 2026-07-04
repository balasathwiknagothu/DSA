class Solution {
    int n;
    int[] visited;
    public int findCircleNum(int[][] isConnected) {
        n=isConnected.length;
        visited=new int[n];
        for(int i=0;i<n;i++){
            visited[i]=-1;
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(visited[i]==-1){
                dfs(i, isConnected);
                ans++;
            }
        }
        return ans;
    }
    public void dfs(int src, int[][] isConnected){
        visited[src]=1;
        int[] neigh=isConnected[src];
        for(int j=0;j<neigh.length;j++){
            if(visited[j]==-1 && neigh[j]!=0){
                dfs(j, isConnected);
            }
        }
        return;
    }
}