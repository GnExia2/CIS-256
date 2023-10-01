import java.util.*;

public class BSTChecker {
    public static Node checkBSTValidity(Node rootNode) {
        return checkBSTValidity(rootNode, null, null);
    }

    private static Node checkBSTValidity(Node node, Integer min, Integer max) {
        if (node == null) {
            return null; // Base case: reached a leaf node, no violation
        }

        // Check if the node's key violates the BST property
        if ((min != null && node.key <= min) || (max != null && node.key >= max)) {
            return node; // Violation found, return the violating node
        }

        // Recursively check the left and right subtrees
        Node leftViolation = checkBSTValidity(node.left, min, node.key);
        Node rightViolation = checkBSTValidity(node.right, node.key, max);

        // If any subtree contains a violation, return that violation
        if (leftViolation != null) {
            return leftViolation;
        }
        if (rightViolation != null) {
            return rightViolation;
        }

        // No violation found in this subtree, return null
        return null;
    }
}