package tree;

import list.LinkedList;

public class BinarySearchTreeMain {
    public static void main(String[] args) {

        BinarySearchTree test = new BinarySearchTree();
        test.add(10);
        test.add(20);
        test.add(30);
        test.add(15);
        test.add(40);
        test.add(5);

        test.print2D();

        TreePrinter.print(test.root);

        test.preOrder();
        test.inOrder();
        test.PostOrner();

    }
}
