package queue;

import stack.Stack;

public class QueueMain {
    public static void main(String[] args) {
        Queue test = new Queue(3);

        test.display();
        test.display1();


        test.enQueue(10);
        test.display();

        test.enQueue(20);
        test.display();

        test.enQueue(30);
        test.display();

        test.enQueue(40);
        test.display();

        test.deQueue();
        test.display();

        test.enQueue(50);
        test.display();

        test.enQueue(60);
        test.display();

        test.deQueue();
        test.display();

        test.deQueue();
        test.display();

        test.deQueue();
        test.display();

    }
}
