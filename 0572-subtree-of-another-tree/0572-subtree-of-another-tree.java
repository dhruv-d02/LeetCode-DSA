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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String sbroot = postTraversal(subRoot);
        return check(root, sbroot) == 1 ? true : false;
    }

    private int check(TreeNode root, String sbroot) {
        if(root == null){
            return 1;
        }
        String r = postTraversal(root);
        if(r.equals(sbroot)){
            return 1;
        }
        if(root.left != null){
            if(check(root.left, sbroot) == 1)
                return 1;
        }
        if(root.right != null){
            if(check(root.right, sbroot) == 1)
                return 1;
        }
        return -1;
    }

    private String postTraversal(TreeNode subRoot) {
        if(subRoot == null){
            return "X";
        }
        String ans = postTraversal(subRoot.left);
        ans += postTraversal(subRoot.right);
        ans += subRoot.val;
        return ans;
    }


}