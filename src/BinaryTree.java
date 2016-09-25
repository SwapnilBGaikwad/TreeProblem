class BinaryTree {
    Node root;

    int count() {
        return count(root);
    }

    private int count(Node root) {
        if (root == null) {
            return 0;
        }
        else {
            int leftCount = count(root.left);
            int rightCount = count(root.right);
            return 1 + leftCount + rightCount;
        }
    }

}
