package bbbb2;

public class BTreeMain {
    public static void main(String[] args) {
        BTree bTree = new BTree();
        bTree.add(10);
        bTree.display(bTree.root,1);
        TreePrinter.print(bTree.root);

        bTree.add(20);
        bTree.display(bTree.root,1);
        TreePrinter.print(bTree.root);

        bTree.add(30);
        bTree.display(bTree.root,1);
        TreePrinter.print(bTree.root);


        bTree.add(40);
        bTree.display(bTree.root,1);
        TreePrinter.print(bTree.root);

        bTree.add(50);
        bTree.display(bTree.root,1);
        TreePrinter.print(bTree.root);
        bTree.add(60);
        bTree.display(bTree.root,1);
        TreePrinter.print(bTree.root);
        bTree.add(70);
        bTree.display(bTree.root,1);
        TreePrinter.print(bTree.root);
        bTree.add(80);
        bTree.display(bTree.root,1);
        TreePrinter.print(bTree.root);
        bTree.add(5);

        bTree.display(bTree.root,1);
        TreePrinter.print(bTree.root);
    }
}
