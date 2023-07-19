public class ReverseNodesKGroup {
    static Node head = null;

    private static void insert(int data) {
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

    public static Node reverseKGroup(Node head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        Node dummyNode = new Node(0);
        dummyNode.next = head;
        int length = findLengthLL(head);
        Node prev = dummyNode;
        Node curr;
        Node next;
        while (length >= k) {
            curr = prev.next;
            next = curr.next;
            for (int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            prev = curr;
            length -= k;
        }
        return dummyNode.next;
    }

    private static int findLengthLL(Node head) {
        int len = 0;
        Node curr = head;
        while (curr != null) {
            curr = curr.next;
            len++;
        }
        return len;
    }

    private static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.next != null) {
                System.out.print(" -> ");
            }
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int k = 3;
        insert(1);
        insert(2);
        insert(3);
        insert(4);
        insert(5);
        insert(6);
        insert(7);
        insert(8);
        System.out.println("Before reversing k groups");
        printList(head);
        head = reverseKGroup(head, k);
        System.out.println("After reversing k groups");
        printList(head);
    }
}