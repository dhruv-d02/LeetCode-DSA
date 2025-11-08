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
    int count;
    public int goodNodes(TreeNode root) {
        count = 0;
        countGood(root, root.val);
        return count;
    }

    private void countGood(TreeNode root, int currMax) {
        if(root == null){
            return;
        }
        if(currMax <= root.val){
            count++;
        }
        currMax = Math.max(currMax, root.val);
        countGood(root.left, currMax);
        countGood(root.right, currMax);
    }
}