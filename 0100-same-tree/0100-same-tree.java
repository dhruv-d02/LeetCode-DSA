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
    List<Integer> tree1, tree2;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return check(p,q);
    }

    private boolean check(TreeNode p, TreeNode q){
        if(p==null && q == null){
            return true;
        }
        if(p==null && q!=null){
            return false;
        }
        if(q==null && p!=null){
            return false;
        }
        if(p.val!=q.val){
           return false; 
        }
        boolean ret = check(p.left, q.left) && check(p.right, q.right);
        return ret;
    }
}