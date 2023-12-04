package queue;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Queue {

    //todo 배열 이용 숫자를 여러개 저장 할 수 있게 변수
    // 배열에 직접 접근 X 접근 제어자제어

    //  front reat  0 저장

    private int front;
    private int rear;
    private int num;
    private static int size;
    private Integer[] arr;


    public Queue(int size) {
        this.front = 0;
        this.rear = 0;
        this.num = 0;
        this.size = size;
        this.arr = new Integer[size];
    }

    public Boolean isEmpty() {
        return num == 0;
    }

    public Boolean isFull() {
        return num == size;
    }

    public void enQueue(int data) {
        if (isFull()) System.out.println("큐가 가득참");
        else {
            arr[rear] = data;
            rear++;
            rear = rear % 3;
            num++;
        }
    }

    public Integer deQueue() {
        Integer tmp = null;
        if (isEmpty()) System.out.println("큐가 비어있음");
        else {
            tmp = arr[front];
            arr[front] = null;
            front++;
            front = front % 3;
            num--;

        }
        return tmp;
    }

    public void display() {
        System.out.println(Arrays.toString(arr));
    }

    public void display1() {
        for (int i = 0; i < size; i++) {
            System.out.print("[" + arr[i] + "] ");
        }
        System.out.println();
    }
}
