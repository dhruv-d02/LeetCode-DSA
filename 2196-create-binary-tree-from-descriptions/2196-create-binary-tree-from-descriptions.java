
import java.util.HashMap;

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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode> nodes = new HashMap<>();
        HashMap<Integer, Integer> childParent = new HashMap<>();
        for(int[] d : descriptions){
            int parent =  d[0];
            int child = d[1];
            boolean isLeft = d[2] == 1;

            childParent.put(child, parent);
            nodes.putIfAbsent(parent, new TreeNode(parent));
            nodes.putIfAbsent(child, new TreeNode(child));
            TreeNode parentNode = nodes.get(parent);
            TreeNode childNode = nodes.get(child);
            if(isLeft){
                parentNode.left = childNode;
            }else{
                parentNode.right = childNode;
            }
        }

        TreeNode root = new TreeNode();
        for (int parent : nodes.keySet()){
            if(childParent.get(parent) == null)
                root = nodes.get(parent);
        }

        return root;
    }
}