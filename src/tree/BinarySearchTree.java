package tree;

public class BinarySearchTree {
    static final int COUNT = 10;
    Node root;


    public BinarySearchTree() {
        this.root = null;
    }

//    public void display(BinarySearchTree node, int level) {
//        if (node == null) return;
//    }

    public void add(Integer data) {
        if (root == null) {
            root = new Node(data);
        } else {
            Node node = root;
            while (true) { // node != null
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







    //todo 선생님 재귀 코드
    //  add2 기본 매개변수 사용하기 위해서
    public void add2(Integer input) {
        if(this.root == null) {
            this.root = new Node(input);
        } else {
            addRecur(this.root, input);
        }
    }
    public Node addRecur(Node node, Integer input) {
        if (node == null) {
            return new Node(input);
        }

        if (input > node.data) {
            node.right = addRecur(node.right, input);
        } else if (input < node.data) {
            node.left = addRecur(node.left, input);
        }
        return node;
    }


    public void preOrder () {
        System.out.print("전위 순회 : ");
        preOrder(root);
        System.out.println("");
    }
    public void preOrder (Node node) {
        if (node != null) {
            System.out.print("[" + node.data + "]");
            if(node.left != null){
                preOrder(node.left);
            }
            if(node.right != null){
                preOrder(node.right);
            }
        }
    }


    public void inOrder () {
        System.out.print("중위 순회 : ");
        inOrder(root);
        System.out.println("");
    }
    public void inOrder (Node node) {
        if (node != null) {
            if(node.left != null){
                inOrder(node.left);
            }
            System.out.print("[" + node.data + "]");
            if(node.right != null){
                inOrder(node.right);
            }
        }
    }



    public void PostOrner () {
        System.out.print("후위 순회 : ");
        PostOrner(root);
        System.out.println("");
    }
    public void PostOrner (Node node) {
        if (node != null) {
            if(node.left != null){
                PostOrner(node.left);
            }
            if(node.right != null){
                PostOrner(node.right);
            }
            System.out.print("[" + node.data + "]");
        }
    }



    public void remove(Node node){
        if(node.right == null && node.left ==null)
            node =null;
        else if(node.right==null)
            remove(node.right);
        else if(node.left==null)
            remove(node.left);
        else {}

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
