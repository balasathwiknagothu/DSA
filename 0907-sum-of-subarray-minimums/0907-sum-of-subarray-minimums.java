class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int[] nse=findNSE(arr);
        int[] psee=findPSEE(arr);
        int total =0, mod=(int)(Math.pow(10,9)+7);
        for(int i=0;i<n;i++){
            int left=i-psee[i];
            int right=nse[i]-i;
            total = (int)((total + (1L * arr[i] * left * right) % mod) % mod);
        }
        return total;
    }
    int[] findNSE(int[] arr){
        int n=arr.length;
        int[] nse=new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            nse[i]=st.isEmpty()? n:st.peek();
            st.push(i);
        }
        return nse;
    }
    int[] findPSEE(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n=arr.length;
        int[] psee=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            psee[i]=st.isEmpty()? -1:st.peek();
            st.push(i);
        }
        return psee;
    }
}