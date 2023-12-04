package stack;

import java.util.Arrays;

public class Stack {

    //todo 배열 이용 숫자를 여러개 저장 할 수 있게 변수
    // 배열에 직접 접근 X 접근 제어자제어
    // 숫자를 어디까지 저장했는지 가르키는 변수 TOP 생성

    private int top;
    private static int size;
    private Integer[] arr;


    public Stack(int size) {
        this.top = -1;
        this.size = size; // 필요없음
        this.arr = new Integer[size];
    }


    // isEmpty  top==-1 true     false
    public Boolean isEmpty() {
        return top == -1;
    }

    // isFull   top==size-1 true  false
    public boolean isFull() {
        return top == size - 1;
    }

    // peek    제일 마지막 저장된 값 확인 반환
    public Integer peek() {
        return arr[top];
    }

    // push    top!=size-1 top++ 해당 인덱스 번호의 배열에 데이터 저장
    public void push(int data) {
        if (!isFull()) {
            top++;
            arr[top] = data;
        } else {
            System.out.println("스택이 가득참");
        }
    }

    // pop    top!=-1  꺼내고 비워주고  top--
    public Integer pop() {
        if (!isEmpty()) {
            int tmp = arr[top];
            arr[top] = null;
            top--;
            return tmp;
        } else {
            System.out.println("스택이 비어있음");
            return null;
        }
    }

    // display
    public void display() {
        System.out.println("top : " + top + " " + Arrays.toString(arr));
    }

    public void display1() {
        System.out.print("top : " + top + " ");
        for (int i = 0; i < size; i++) {
            System.out.print("["+arr[i]+"] ");
        }
        System.out.println();
    }


}
