class Node {
    int data;
    Node next;
    Node bottom;

    Node(int data) {
        this.data = data;
        next = bottom = null;
    }
}

public class FlattenAList {
    static Node merge(Node head1, Node head2) {
        Node dummy = new Node(-1);
        Node tail = dummy;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                tail.bottom = head1;
                head1 = head1.bottom;
                tail = tail.bottom;
            } else {
                tail.bottom = head2;
                head2 = head2.bottom;
                tail = tail.bottom;
            }
        }
        if (head1 != null) {
            tail.bottom = head1;
        } else {
            tail.bottom = head2;
        }
        return dummy.bottom;
    }

    static Node flatten(Node root) {
        Node prev = null;
        Node curr = root;
        while (curr != null) {
            Node next = curr.next;
            prev = merge(prev, curr);
            prev.next = null;
            curr.next = null;
            curr = next;
        }
        return prev;
    }

    static void print(Node root) {
        Node curr = root;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.bottom;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.bottom = new Node(7);
        root.bottom.bottom = new Node(8);
        root.bottom.bottom.bottom = new Node(30);
        root.next = new Node(10);
        root.next.next = new Node(19);
        root.next.next.bottom = new Node(22);
        root.next.next.bottom.bottom = new Node(50);
        root.next.next.next = new Node(28);
        root = flatten(root);
        print(root);
    }
}