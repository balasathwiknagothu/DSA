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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode cur=root;
        TreeNode temp=new TreeNode(val);
        while(true){
            if(val<cur.val){
                if(cur.left==null){
                    cur.left=temp;
                    break;
                }else{
                    cur=cur.left;
                }
            }else if(val>cur.val){
                if(cur.right==null){
                    cur.right=temp;
                    break;
                }else{
                    cur=cur.right;
                }
            }
        }
        return root;
    }
}