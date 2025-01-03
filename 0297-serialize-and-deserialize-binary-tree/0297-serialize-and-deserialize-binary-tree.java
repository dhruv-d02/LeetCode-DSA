/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String ret = "";
        ret += Preorder(root, ret);
        return ret;
    }

    private String Preorder(TreeNode root, String ret) {
        if(root == null){
            ret += "n/";
            return ret;
        }
        ret += root.val + "/";
        ret = Preorder(root.left, ret);
        ret = Preorder(root.right, ret);
        return ret;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return makeTree(new StringBuilder(data));
    }
    public TreeNode makeTree(StringBuilder data) {
        if(data.charAt(0) == 'n'){
            data.delete(0, data.indexOf("/")+1);
            return null;
        }
        TreeNode root = null;
        String val = data.substring(0, data.indexOf("/"));
        root = new TreeNode(Integer.parseInt(val));
        data.delete(0, data.indexOf("/")+1);
        root.left = makeTree(data);
        root.right = makeTree(data);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));