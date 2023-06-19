class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class LinkedListCycle {
    public static boolean hasCycle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.next = new Node(2);
        root.next.next = new Node(0);
        root.next.next.next = new Node(4);
        root.next.next.next.next = root.next;
        System.out.println("Is the list has cycle: " + hasCycle(root));
    }
}
