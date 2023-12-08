package path;

public class Node {

    Integer x;
    Integer y;
    Integer g;
    Integer h;
    // f = g스타팅부터 이동한 거리 + h목표까지 벽무시 직진
    Integer f;
    Node parents;


    public Node(Integer x, Integer y) {
        this.x = x;
        this.y = y;
        this.g = 0;
        this.h = 0;
        this.f = 0;
        this.parents = null;
    }
}
