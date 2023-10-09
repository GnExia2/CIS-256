class TreeNode {
    int key;
    TreeNode left;
    TreeNode right;
    int height;

    public TreeNode(int key) {
        this.key = key;
        this.height = 1;
    }
}

public class AVLTree {
    private TreeNode root;

    // Get the height of a node
    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // Get the balance factor of a node
    private int getBalanceFactor(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    // Perform a right rotation
    private TreeNode rightRotate(TreeNode y) {
        TreeNode x = y.left;
        TreeNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // Perform a left rotation
    private TreeNode leftRotate(TreeNode x) {
        TreeNode y = x.right;
        TreeNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Insert a key into the AVL tree
    public TreeNode insert(TreeNode node, int key) {
        if (node == null) {
            return new TreeNode(key);
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            // Duplicate keys are not allowed
            return node;
        }

        // Update the height of the current node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Get the balance factor and perform rotations if needed
        int balance = getBalanceFactor(node);

        // Left-Left case
        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }

        // Right-Right case
        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }

        // Left-Right case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right-Left case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Search for a key in the AVL tree
    public TreeNode search(TreeNode node, int key) {
        if (node == null || node.key == key) {
            return node;
        }

        if (key < node.key) {
            return search(node.left, key);
        }

        return search(node.right, key);
    }

    // Perform AVL tree insertion
    public void insert(int key) {
        root = insert(root, key);
    }

    // Perform AVL tree search
    public TreeNode search(int key) {
        return search(root, key);
    }

    // Utility function to perform in-order traversal
    public void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.key + " ");
            inOrderTraversal(node.right);
        }
    }

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();

        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30);
        avlTree.insert(40);
        avlTree.insert(50);
        avlTree.insert(25);

        System.out.println("In-order traversal of AVL tree:");
        avlTree.inOrderTraversal(avlTree.root); // Should print the sorted order of inserted elements

        int keyToSearch = 30;
        TreeNode result = avlTree.search(keyToSearch);
        if (result != null) {
            System.out.println("\nFound key " + keyToSearch);
        } else {
            System.out.println("\nKey " + keyToSearch + " not found");
        }
    }
}
