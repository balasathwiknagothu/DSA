/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<Integer,Integer> map=new HashMap<>();
    int maxFreq=0;
    public int[] findMode(TreeNode root) {
        inorder(root);
        List<Integer> ans=new ArrayList<>();
        for(int key:map.keySet()){
            if(map.get(key)==maxFreq) ans.add(key);
        }
        int[] res=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            res[i]=ans.get(i);
        }
        return res;
    }
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        map.put(root.val,map.getOrDefault(root.val,0)+1);
        maxFreq=Math.max(maxFreq, map.get(root.val));
        inorder(root.right);
    }
}