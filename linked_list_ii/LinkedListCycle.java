package linked_list_ii;

import utils.ListNode;

public class LinkedListCycle {
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(3);
        root.next = new ListNode(2);
        root.next.next = new ListNode(0);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = root.next;
        System.out.println("Is the list has cycle: " + hasCycle(root));
    }
}
