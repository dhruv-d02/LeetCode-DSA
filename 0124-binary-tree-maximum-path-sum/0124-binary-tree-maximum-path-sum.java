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
    int maximum;
    public int maxPathSum(TreeNode root) {
        maximum = Integer.MIN_VALUE;
        helper(root);
        return maximum;
    }

    private int helper(TreeNode root) {
        if(root == null){
            return 0;
        }
        maximum = Math.max(root.val, maximum);
        int leftSum = helper(root.left);
        int leftPath = leftSum + root.val;
        maximum = Math.max(leftPath, maximum);
        int rightSum = helper(root.right);
        int rightPath = rightSum + root.val;
        maximum = Math.max(rightPath, maximum);
        int rootSum = root.val + leftSum + rightSum;
        maximum = Math.max(maximum, rootSum);
        return Math.max(root.val, Math.max(leftSum + root.val, rightSum + root.val));
    }
}