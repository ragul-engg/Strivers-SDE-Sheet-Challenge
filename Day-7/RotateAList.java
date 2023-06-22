class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RotateAList {
    static Node head;

    public static void insert(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new Node(data);
        }
    }

    public static Node rotate(Node head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        Node curr = head;
        int len = 1;
        while (curr.next != null) {
            curr = curr.next;
            len++;
        }
        curr.next = head;
        k %= len;
        int end = len - k;
        while (end > 0) {
            curr = curr.next;
            end--;
        }
        Node newHead = curr.next;
        curr.next = null;
        return newHead;
    }

    public static void print() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        insert(1);
        insert(2);
        insert(3);
        insert(4);
        head = rotate(head, 2);
        print();
    }
}
