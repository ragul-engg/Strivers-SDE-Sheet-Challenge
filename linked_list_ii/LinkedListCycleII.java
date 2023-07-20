package linked_list_ii;

import utils.ListNode;

public class LinkedListCycleII {
    public static ListNode firstNode(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
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
        ListNode root = new ListNode(3);
        root.next = new ListNode(2);
        root.next.next = new ListNode(0);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = root.next;
        System.out.println("Cycle starts from: " + firstNode(root).data);
    }
}
