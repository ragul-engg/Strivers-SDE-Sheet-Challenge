class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReverseLinkedList {
    Node head;

    ReverseLinkedList() {
        this.head = null;
    }

    public void insert(int data) {
        if (this.head == null) {
            head = new Node(data);
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new Node(data);
        }
    }

    public void reverse() {
        Node prev = null;
        Node curr = head;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void print() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        ReverseLinkedList obj = new ReverseLinkedList();
        obj.insert(1);
        obj.insert(2);
        obj.insert(3);
        obj.insert(4);
        System.out.println("Linked list elements are: ");
        obj.print();
        obj.reverse();
        System.out.println("\nReversedLinked list elements are: ");
        obj.print();
    }
}
