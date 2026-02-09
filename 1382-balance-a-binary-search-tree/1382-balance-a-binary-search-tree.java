import java.util.ArrayList;

class Solution {
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<TreeNode> inorder = new ArrayList<>();
        inorderTraverse(root, inorder);
        return makeBST(inorder, 0, inorder.size()-1);
    }

    private TreeNode makeBST(ArrayList<TreeNode> inorder, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = inorder.get(mid);
        root.left = makeBST(inorder,start, mid - 1);
        root.right = makeBST(inorder,mid + 1, end);
        return root;
    }

    private void inorderTraverse(TreeNode root, ArrayList<TreeNode> inorder) {
        if(root == null){
            return;
        }
        inorderTraverse(root.left, inorder);
        inorder.add(root);
        inorderTraverse(root.right, inorder);
    }
}