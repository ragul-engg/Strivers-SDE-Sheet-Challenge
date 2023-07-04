public class LinkedListCycleII {
    public static Node firstNode(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node fast = head;
        Node slow = head;
        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast && fast != null && fast.next != null);
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.next = new Node(2);
        root.next.next = new Node(0);
        root.next.next.next = new Node(4);
        root.next.next.next.next = root.next;
        System.out.println("Cycle starts from: " + firstNode(root).data);
    }
}
