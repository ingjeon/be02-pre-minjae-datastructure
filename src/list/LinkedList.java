package list;

public class LinkedList {
    // head는 맨처음 노드 current는 현재 노드
    Node head;

    public LinkedList() {
        this.head = null;
    }

    public void display() {
        Node node = head;
        // 노드에 null 아니면 시작
        while (node != null) {
            System.out.print("[" + node.data + "]");
            // 노드를 next로
            node = node.next;
        }
        System.out.println();
//        if(head != null)
//        System.out.println(head.data);
//        System.out.println(head.next.data);
//        System.out.println(head.next.next.data);
//        System.out.println(head.next.next.next.data);
    }

    public void insertFirst(Integer data) {
        Node tmpF = new Node(data, null);
        tmpF.next = head;
        // => Node tmp = new Node(data,head);
        head = tmpF;
    }

    //todo 선생님
    public void  insertFirst2(Integer data) {
        Node newNode = new Node(data, head);
        head = newNode;
    }

    public void insertLast(Integer data) {
        //todo 조건 주의! head == null
        if (head == null) this.insertFirst(data);
        else {
            Node node = head;
            while (true) {
                if (node.next == null) {
                    node.next = new Node(data, null);
                    break;
                }
                node = node.next;
            }
        }
    }
    //Todo 선생님
    public void insertLast2(Integer data) {
        if(head == null) {
            this.insertFirst(data);
        } else {
            Node node;
            node = head;
            while(node.next != null) {
                node = node.next;
            }
            Node newNode;
            newNode = new Node(data, null);
            node.next = newNode;
        }
    }

    public void insertIndex(Integer index, Integer data) {
        //todo 조건 주의! head == null
        if (head == null || index == 0) insertFirst(data);
        else {
            Node node = head;
            for (int i = 1; i < index; i++) node = node.next;
            Node tmpI = new Node(data, null);
            tmpI.next = node.next;
            node.next = tmpI;
        }
    }
    //todo 선생님
    public void  insertIndex2(Integer index, Integer data) {
        if(head == null || index==0) {
            this.insertFirst(data);
        } else {
            Node node;
            node = head;
            Integer count;
            count = 0;
            while(count != index - 1) {
                node = node.next;
                count = count + 1;
            }
            Node newNode;
            newNode = new Node(data, null);
            newNode.next = node.next;
            node.next = newNode;
        }
    }

    public Integer removeFirst() {
        Integer tmp = null;
        if (head != null) {
            Node node = head;
            head = node.next;
            tmp = node.data;
            node.data = null;
            node.next = null;
            node = null;
        }
        return tmp;
    }

    public Integer removeLast() {
        Integer tmp = null;
        if (head != null) {
            Node node = head;
            while (true) {
                if (node.next.next == null) {
                    tmp = node.next.data;
                    node.next.data = null;
                    node.next = null;
                    node = null;
                    break;
                }
                node = node.next;
            }
        }
        return tmp;
    }


    public Integer removeIndex(Integer index) {

        Integer tmp = null;
        if (head != null) {
            if (index == 0) removeFirst();
            else {
                Node node = head;
                for (int i = 0; i < index - 1; i++) node = node.next;
                Node node2 = node;
                node = node.next;
                node2.next = node.next;

//                node2                          node.next
//                node                             null
//                node.next =node            node.next.next
                tmp = node.data;
                node.data = null;
                node.next = null;
                node = null;
            }
        }
        return tmp;
    }
}
