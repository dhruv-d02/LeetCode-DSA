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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> rightView = new ArrayList<>();
        if(root == null){
            return rightView;
        }
        q.add(root);
        while (!q.isEmpty()){
            int levelSize = q.size();
            List<Integer> currLevel = new ArrayList<>();
            for(int i=0; i<levelSize; i++){
                TreeNode curr = q.poll();
                currLevel.add(curr.val);
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            rightView.add(currLevel.get(currLevel.size() - 1));
        }
        return rightView;
    }
}