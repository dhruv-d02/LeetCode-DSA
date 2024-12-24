import com.sun.source.tree.Tree;

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
    public int findTilt(TreeNode root) {
        int[] ret =  traverse(root);
        return ret[0];
    }

    private int[] traverse(TreeNode root){
        if(root == null){
            return new int[]{0, 0}; //0-> diff, 1 -> sum, 2 -> diffSum
        }
        int[] left = traverse(root.left);
        int[] right = traverse(root.right);
        return  new int[]{Math.abs(left[1]-right[1]) + left[0] + right[0], root.val + left[1] + right[1]};
    }
}