package bbbb2;

import bbbb2.TreePrinter;

public class Node implements TreePrinter.PrintableNode {
    int [] data;
    Node[] children;
    Node parent;

    // 특정 노드에 입력된 데이터 개수
    int size;
    boolean leaf;

    @Override
    public TreePrinter.PrintableNode getLeft() {
        return children[0];
    }

    @Override
    public TreePrinter.PrintableNode getCenter() { return children[1];}

    @Override
    public TreePrinter.PrintableNode getRight() { return children[2];}

    @Override
    public String getText() {
        String dataStr = "";
        for (int i=0; i < data.length; i++){
            if(data[i] != 0) dataStr = dataStr + data[i] +", ";
        }
        return "["+ dataStr.substring(0,dataStr.length()) +"]";
    }
    // t는 최소 차수
    // 노드의 최대 데이터 개수 = 2*t-1
    // 노드의 최대 차수 = 2*t
    public Node(){
        this.data = new int[3];
        this.children = new Node[4];
        this.parent = null;
        this.leaf = true;
        this.size = 0;
    }
}
