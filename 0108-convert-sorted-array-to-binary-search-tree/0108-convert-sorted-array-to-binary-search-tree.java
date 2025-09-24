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
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = createTree(nums, 0, nums.length-1);
        return root;
    }

    private TreeNode createTree(int[] nums, int low, int high) {
        if(low > high){
            return null;
        }
        int mid = low + (high - low)/2;
        TreeNode root = new TreeNode(nums[mid]);
        if(low == high){
            return root;
        }
        root.left = createTree(nums, low, mid-1);
        root.right = createTree(nums, mid+1, high);
        return root;
    }
}