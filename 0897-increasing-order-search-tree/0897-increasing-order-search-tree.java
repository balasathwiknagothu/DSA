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
    private TreeNode cur;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode temp=new TreeNode(-1);
        cur=temp;
        inorder(root);
        return temp.right;
    }
    private void inorder(TreeNode node){
        if(node==null) return;
        inorder(node.left);
        node.left=null;
        cur.right=node;
        cur=node;
        inorder(node.right);
    }
}