package tree;

public class BinarySearchTree {
    Node root;

    static final int COUNT = 10;

    public BinarySearchTree() {
        this.root = null;
    }




    public void display(BinarySearchTree node, int level) {
        if (node == null) return;
    }

    public void add(Integer data) {
        if (root == null) {
            root = new Node(data);
        } else {
            Node node = root;
            while (true) {
                if (node.data < data) {
                    if (node.right == null) {
                        node.right = new Node(data);
                        break;
                    }
                    node = node.right;
                } else if (node.data > data) {
                    if (node.left == null) {
                        node.left = new Node(data);
                        break;
                    }
                    node = node.left;
                }
            }
        }
    }






    //todo  출력 예시1
    void print2DUtil(Node root, int space)
    {
        // Base case
        if (root == null)
            return;
        // Increase distance between levels
        space += COUNT;
        // Process right child first
        print2DUtil(root.right, space);
        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.data + "\n");
        // Process left child
        print2DUtil(root.left, space);
    }
    // Wrapper over print2DUtil()
    void print2D()
    {
        // Pass initial space count as 0
        print2DUtil(this.root, 0);
    }


}
