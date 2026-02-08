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
        if(root == null)
            return true;
        
        height(root);
        
        return status;
    }
    
    int height(TreeNode root){
        if(root == null || !status)
            return 0;
        
        int left = height(root.left) + 1;
        int right = height(root.right) + 1;
        
        if(Math.abs(left -  right) > 1)
            status = false;
        
        return Math.max(left, right);
    }
}