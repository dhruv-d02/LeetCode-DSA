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
    int currIndex = 0;
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

    public TreeNode makeTree(Queue<String> q){
        String val = q.poll();
        if(val != null && val.equals("n")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = makeTree(q);
        root.right = makeTree(q);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return makeTree(new LinkedList<>(Arrays.asList(data.split("/"))));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));