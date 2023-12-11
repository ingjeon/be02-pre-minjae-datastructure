package path.teacher;

public class Node {

    Integer x;
    Integer y;
    Integer f;
    Integer g;
    Integer h;


    Node parents;

    public Node(Integer x, Integer y) {
        this.x = x;
        this.y = y;
        this.f=0;
        this.g=0;
        this.h=0;
    }

    public Node(Integer x, Integer y, Integer f, Integer g, Integer h, Node parents) {
        this.x = x;
        this.y = y;
        this.f = f;
        this.g = g;
        this.h = h;
        this.parents = parents;
    }
}
