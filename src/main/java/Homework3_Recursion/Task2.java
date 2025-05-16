package Homework3_Recursion;

public class Task2 {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "NULL";
        }

        return "(" + root.value + ", " +
                serialize(root.left) + ", " +
                serialize(root.right) + ")";
    }

    protected static class TreeNode {
        int value;
        TreeNode left, right;

        TreeNode(int value) {
            this.value = value;
        }
    }

}
