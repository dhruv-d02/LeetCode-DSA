import javax.swing.*;
import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;

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
    public TreeNode recoverFromPreorder(String traversal) {

        HashMap<TreeNode, TreeNode> parentNodeMap = new HashMap<>();
        traversal += "-";
        int pos = 0;
        int val = 0;
        int dashCount = 0;
        int prevDashCount = 0;
        TreeNode root = null;
        TreeNode currentNode = null;
        while (pos < traversal.length()){
            char c = traversal.charAt(pos);
            if(c == '-'){
                if(val != 0){
                    if(prevDashCount > dashCount){
                        currentNode = parentNodeMap.get(currentNode);
                        int loop = prevDashCount - dashCount;
                        while (loop > 0){
                            currentNode = parentNodeMap.get(currentNode);
                            loop--;
                        }
                    }
                    else if(currentNode != null && prevDashCount == dashCount){
                        currentNode = parentNodeMap.get(currentNode);
                    }

                    if(currentNode == null){
                        currentNode = new TreeNode(val);
                        if(root == null){
                            root = currentNode;
                        }
                    }else {
                        if (prevDashCount >= dashCount) {
                            currentNode.right = new TreeNode(val);
                            parentNodeMap.put(currentNode.right, currentNode);
                            currentNode = currentNode.right;
                        } else {
                            currentNode.left = new TreeNode(val);
                            parentNodeMap.put(currentNode.left, currentNode);
                            currentNode = currentNode.left;
                        }
                    }
                    val = 0;
                    prevDashCount = dashCount;
                    dashCount = 0;
                }
                dashCount++;
            }else {
                val = val*10 + (c - '0');
            }
            pos++;
        }
        //levelTraversal[dashCount].add(val);
        return root;
    }
}