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
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = Integer.MIN_VALUE;
        helper(root);
        return ans;
    }

    private int helper(TreeNode root){
        if(root == null){
            return -1;
        }
        int left = helper(root.left) + 1;
        int right = helper(root.right) + 1;
        int curr = left + right;
        ans = Math.max( ans, Math.max(curr, Math.max(left, right)));
        return  Math.max(left, right);
    }
}