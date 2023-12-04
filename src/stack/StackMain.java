package stack;

public class StackMain {
    public static void main(String[] args) {
        Stack test = new Stack(5);

        test.display();
        test.display1();


        test.push(10);
        test.display();

        test.push(20);
        test.display();

        test.push(30);
        test.display();

        test.pop();
        test.display();


    }
}
