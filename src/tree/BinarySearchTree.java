package tree;

public class BinarySearchTree {
    static final int COUNT = 10; //display
    Node root;


    public BinarySearchTree() {
        this.root = null;
    }


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
        System.out.println();
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
        System.out.println();
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
        System.out.println();
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



    public void remove(Integer input){
        Node target = root;
        Node parents = null;

        // input 받은 값이 있는곳 탐색
        if (target != null) {
            while (true) {
                if(target.data == input) {
                    break;
                }
                if (input > target.data) {
                    parents = target;
                    target = target.right;
                }
                if (input < target.data) {
                    parents = target;
                    target = target.left;
                }
            }
        }
        // 타겟 밑 자식노드 2개 일때
        if (target.left == null && target.right == null) {
            if (target.data > parents.data) {
                parents.right = null;
            }
            if (target.data < parents.data) {
                parents.left = null;
            }
        }
        // 타겟 밑 자식노드 1개 일때
        else if (target.left != null && target.right == null
                || target.left == null && target.right != null) {
            if (target.data > parents.data) {
                parents.right = target.right;
                target.right = null;
            }
            if (target.data < parents.data) {
                parents.left = target.left;
                target.left = null;
            }
        } else {
            // 	왼쪽을 기준으로 했을 때
            //	삭제하는 노드 대신에 왼쪽 서브트리에서 가장 큰 노드로 대체
            Node maximum = target.left;
            Node maximumParents = target;
            while (maximum.right != null) {
                maximumParents = maximum;
                maximum = maximum.right;
            }
            if (!maximumParents.equals(target)) {
                maximumParents.right = maximum.left;
            }

            if (!target.left.equals(maximum)) {
                maximum.left = target.left;
            }
            maximum.right = target.right;
            if (parents == null) {
                this.root = maximum;
            } else {
                if (target.data > parents.data) {
                    parents.right = maximum;
                }
                if (target.data < parents.data) {
                    parents.left = maximum;
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
