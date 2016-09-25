import org.junit.Assert;
import org.junit.Test;

public class NodeTest {
    @Test
    public void shouldCreateNodeWithLeftAndRightAsNullInTree() {
        int data = 1;
        Node node = new Node(data);
        node.left = null;
        node.right = null;

        Assert.assertEquals(data , node.getData());
    }

    @Test
    public void shouldAbleToCreateTreeStructureFromNode() {
        int data = 1;
        Node root = new Node(data);

        data = 2;
        Node left = new Node(data);

        data = 3;
        Node right = new Node(data);

        root.left = left;
        root.right = right;

        Assert.assertEquals(1 , root.getData());
        Assert.assertEquals(2 , root.left.getData());
        Assert.assertEquals(3 , root.right.getData());
    }
}
