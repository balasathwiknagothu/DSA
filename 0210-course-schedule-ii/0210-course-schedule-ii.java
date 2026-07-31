class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n=numCourses;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] p:prerequisites){
            adj.get(p[1]).add(p[0]);
        }
        int[] state=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            if(state[i]==0){
                if(!dfs(i,adj,state,st)){
                    return new int[0];
                }
            }
        }
        int[] ans=new int[n];
        int idx=0;
        while(!st.isEmpty()){
            ans[idx++]=st.pop();
        }
        return ans;
    }
    private boolean dfs(int node, List<List<Integer>> adj, int[] state, Stack<Integer> st){
        state[node]=1;
        for(int nei:adj.get(node)){
            if(state[nei]==1){
                return false;
            }
            if(state[nei]==0){
                if(!dfs(nei,adj,state,st)){
                    return false;
                }
            }
        }
        state[node]=2;
        st.push(node);
        return true;
    }
}