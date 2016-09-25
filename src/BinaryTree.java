class BinaryTree {
    Node root;
    private int diameter = 0;

    int count() {
        return count(root);
    }

    private int count(Node root) {
        if (root == null) {
            return 0;
        } else {
            int leftCount = count(root.left);
            int rightCount = count(root.right);
            return 1 + leftCount + rightCount;
        }
    }

    int diameter() {
        diameter = 0;
        return diameter(root);
    }

    private int diameter(Node root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            int leftDiameter = diameter(root.left);
            int rightDiameter = diameter(root.right);
            int maxDiameter = Math.max(leftDiameter , rightDiameter);
            return Math.max(maxDiameter, 1 + leftHeight + rightHeight);
        }
    }

    private int height(Node root) {
        if (root == null) {
            return 0;
        }
        else {
            return 1 + Math.max(height(root.left) , height(root.right));
        }
    }
}
