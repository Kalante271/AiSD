package Homework3_Recursion;

public class Task1 {
    public int findingHeight(TreeNode root) {
        if (root == null) return -1;

        int leftHeight = findingHeight(root.left);
        int rightHeight = findingHeight(root.right);

        root.height = Math.max(leftHeight, rightHeight) + 1;
        return root.height;
    }

    protected static class TreeNode {
        int value;
        TreeNode left, right;
        int height;

        TreeNode(int value) {
            this.value = value;
        }
    }

}
