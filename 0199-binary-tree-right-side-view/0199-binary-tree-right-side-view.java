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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        rightView(root,res,0);
        return res;
    }
    public void rightView(TreeNode cur, List<Integer> res, int curDepth){
        if(cur==null) return;
        if(curDepth==res.size()){
            res.add(cur.val);
        }
        rightView(cur.right,res,curDepth+1);
        rightView(cur.left,res,curDepth+1);
    }
}