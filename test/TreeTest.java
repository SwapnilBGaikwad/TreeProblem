import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TreeTest {
    private int[] output;
    private int i = 0;
    private BinaryTree tree = new BinaryTree();

    @Before
    public void setUp() {
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(5);

        output = new int[tree.count()];
        i = 0;
    }

    @Test
    public void shouldCreateTreeStructure() {
        getTreeInArray(tree.root);
        int[] expectedArray = {2,4,1,5,3};
        Assert.assertArrayEquals(expectedArray , output);
    }


    @Test
    public void shouldReturnDiameterOfTree() {
        int diameter = tree.diameter();

        Assert.assertEquals(5 , diameter);
    }


    @Test
    public void shouldReturnDiameterIfLongestPathExistInLeftSideIfTree() {
        Node right = tree.root.right;
        tree.root.right = null;

        tree.root.left.left = new Node(6);
        tree.root.left.left.left = new Node(7);

        tree.root.left.right.left = new Node(8);
        tree.root.left.right.left.left = new Node(9);
        tree.root.left.right.left.left.left = new Node(10);

        int diameter = tree.diameter();

        Assert.assertEquals(7 , diameter);

        tree.root.right = right;
        tree.root.left.left = null;
        tree.root.left.right.left = null;
    }

    /**
     * set output array to inorder traversal of tree.
     * @param root of tree.
     */
    private void getTreeInArray(Node root) {
        if (root != null) {
            getTreeInArray(root.left);
            System.out.println("Data : " + root.getData());
            output[i++] = root.getData();
            getTreeInArray(root.right);
        }
    }
}
