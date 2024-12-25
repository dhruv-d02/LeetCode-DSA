import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null){
            return ret;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int max = Integer.MIN_VALUE;
            int size = q.size();
            for (int i=0; i<size; i++){
                TreeNode top = q.poll();
                if(top == null){
                    continue;
                }
                max = Math.max(top.val, max);
                if(top.left != null)
                    q.add(top.left);
                if(top.right != null)
                    q.add(top.right);
            }
            ret.add(max);            
        }
        return ret;
    }
}