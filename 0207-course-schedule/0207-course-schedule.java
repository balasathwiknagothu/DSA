class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {


    //    //DFS
    //    int V=numCourses;
    //    List<List<Integer>> adjList=new ArrayList<>();
    //    for(int i=0;i<V;i++){
    //        adjList.add(new ArrayList<>());
    //    }
    //    for(int[] p: prerequisites){
    //        adjList.get(p[1]).add(p[0]);
    //    }
    //    
    //    int[] vis=new int[V];
    //    for(int i=0;i<V;i++){
    //        if(vis[i]==0){
    //            if(dfs(i,vis,adjList)==true){
    //                return false;
    //            } 
    //        }
    //    }
    //    return true;


        //BFS
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree=new int[numCourses];
        for(int[] p:prerequisites){
            adj.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        int count=0;
        while(!q.isEmpty()){
            int node=q.poll();
            count++;
            for(int adjNode:adj.get(node)){
                indegree[adjNode]--;
                if(indegree[adjNode]==0){
                    q.offer(adjNode);
                }
            }
        }
        return count==numCourses;

    }

    private boolean dfs(int node, int[] vis, List<List<Integer>> adj){
        vis[node]=1;
        for(int nextNode:adj.get(node)){
            if(vis[nextNode]==0){
                if(dfs(nextNode,vis,adj)==true){
                    return true;
                }
            }else if(vis[nextNode]==1)   return true;
        }
        vis[node]=2;        //finished
        return false;
    }
}