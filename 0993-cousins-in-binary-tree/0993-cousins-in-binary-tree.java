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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;
        Queue<TreeNode>q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            boolean xfound=false;
            boolean yfound=false;

            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(node.val==x) xfound=true;
                if(node.val==y) yfound=true;
                if(node.left != null && node.right != null){
                    if((node.left.val==x && node.right.val==y)||(node.left.val==y&&node.right.val==x)){
                        return false;
                    }
                }
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            if(xfound && yfound) return true;
            if(xfound || yfound) return false;
        }
        return false;
    }
}