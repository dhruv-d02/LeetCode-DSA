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
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        return traverse(root);
    }

    private List<Integer> traverse(TreeNode root) {
        if(root == null){
            return new ArrayList<Integer>();
        }
        List<Integer> order = new ArrayList<>();
        order.addAll(traverse(root.left));
        order.addAll(traverse(root.right));
        order.add(root.val);
        return order;
    }
}