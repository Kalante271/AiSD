package Homework3_Recursion;

import java.util.*;

public class Task3 {

    public String serialize(NaryTreeNode root) {
        if (root == null) return "NULL";

        if (root.children.isEmpty()) {
            return "(" + root.value + ", NULL)";
        }

        List<String> childrenSerialized = new ArrayList<>();
        for (NaryTreeNode child : root.children) {
            childrenSerialized.add(serialize(child));
        }

        return "(" + root.value + ", " + String.join(", ", childrenSerialized) + ")";
    }

    class NaryTreeNode {
        int value;
        List<NaryTreeNode> children;

        NaryTreeNode(int value) {
            this.value = value;
            this.children = new ArrayList<>();
        }
    }

}
