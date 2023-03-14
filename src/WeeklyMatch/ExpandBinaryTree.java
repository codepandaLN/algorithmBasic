package WeeklyMatch;

import java.util.Arrays;

public class ExpandBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode expandBinaryTree(TreeNode root) {
        if (root.left != null) {
            TreeNode decor = new TreeNode(-1);
            decor.left = expandBinaryTree(root.left);
            root.left = decor;
        }
        if (root.right != null) {
            TreeNode decor = new TreeNode(-1);
            decor.right = expandBinaryTree(root.right);
            root.right = decor;
        }
        return root;
    }

    public static void main(String[] args) {
        ExpandBinaryTree s = new ExpandBinaryTree();
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(5);
        root.right = new TreeNode(6);

       s.expandBinaryTree(root);
    }

}
