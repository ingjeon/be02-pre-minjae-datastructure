package list;

public class LinkedListMain {
    public static void main(String[] args) {
        //Todo LinkedList
        LinkedList test = new LinkedList();
        test.insertFirst(10);
        test.insertFirst(20);
        test.insertFirst(30);
        test.insertLast(40);
        test.insertLast(50);
        test.insertIndex(3,60);
        test.display();

        System.out.println(test.removeFirst());
        test.display();

        System.out.println(test.removeLast());
        test.display();

        System.out.println(test.removeIndex(1));
        test.display();

    }
}
