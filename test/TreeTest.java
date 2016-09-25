import org.junit.Assert;
import org.junit.Test;

public class TreeTest {
    private int[] output;
    private int i = 0;
    @Test
    public void shouldCreateTreeStructure() {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(5);

        output = new int[tree.count()];
        i = 0;
        inorder(tree.root);

        int[] expectedArray = {2,4,1,5,3};

        Assert.assertArrayEquals(expectedArray , output);
    }

    private void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.println("Data : " + root.getData());
            output[i++] = root.getData();
            inorder(root.right);
        }
    }
}
