package linked_list;

import utils.ListNode;

public class MiddleLinkedList {
    static ListNode head;

    public static ListNode middleElement(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void insert(int data) {
        if (head == null) {
            head = new ListNode(data);
        } else {
            ListNode curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new ListNode(data);
        }
    }

    public static void main(String[] args) {
        insert(1);
        insert(2);
        insert(3);
        insert(4);
        System.out.println("The middle of the linked list is " + middleElement(head).data);
    }
}
