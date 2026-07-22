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
    public int findSecondMinimumValue(TreeNode root) {
        if(root==null) return -1;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int min2=Integer.MAX_VALUE;
        int min=root.val;
        boolean found=false;
        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            if(cur.left!=null){
                queue.add(cur.left);
                queue.add(cur.right);
                if(cur.left.val>min){
                    min2=Math.min(min2,cur.left.val);
                    found=true;
                }
                if(cur.right.val>min){
                    min2=Math.min(min2,cur.right.val);
                    found=true;
                }
            }
        }
        return found ? min2:-1;
    }
}