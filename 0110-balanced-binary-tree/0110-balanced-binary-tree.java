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
    boolean status = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int lhs = height(root);
        return status;
    }

    private int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int lhs = 1 +height(root.left);
        int rhs = 1 + height(root.right);
        if(Math.abs(lhs-rhs) > 1){
            status = false;
        }
        return Math.max(lhs, rhs);
    }
}