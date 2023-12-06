package list;

public class Node {
    Integer data;

    Node next;
    // todo 재귀랑은 다름   =>   참조형과 기본형 개념  int Integer
    //  Node 클라스 안에 Node 변수 가능

    public Node(Integer data, Node next) {
        this.data = data;
        this.next = next;
    }



}
